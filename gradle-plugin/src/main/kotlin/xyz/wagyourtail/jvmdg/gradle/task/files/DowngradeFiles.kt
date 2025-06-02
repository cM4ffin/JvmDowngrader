package xyz.wagyourtail.jvmdg.gradle.task.files

import org.gradle.api.file.FileCollection
import org.gradle.api.internal.ConventionTask
import org.gradle.api.provider.Property
import org.gradle.api.services.ServiceReference
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.api.tasks.TaskAction
import xyz.wagyourtail.jvmdg.ClassDowngrader
import xyz.wagyourtail.jvmdg.compile.PathDowngrader
import xyz.wagyourtail.jvmdg.gradle.flags.DefaultFlags
import xyz.wagyourtail.jvmdg.gradle.flags.DowngradeFlags
import xyz.wagyourtail.jvmdg.gradle.flags.FlagsConvention
import xyz.wagyourtail.jvmdg.gradle.flags.toFlags
import xyz.wagyourtail.jvmdg.util.FinalizeOnRead
import xyz.wagyourtail.jvmdg.util.LazyMutable
import xyz.wagyourtail.jvmdg.util.MustSet
import xyz.wagyourtail.jvmdg.util.Utils
import java.io.File
import java.nio.file.FileSystem
import kotlin.io.path.exists
import kotlin.io.path.isDirectory
import kotlin.io.path.name

abstract class DowngradeFiles: ConventionTask(), DowngradeFlags, FlagsConvention {

    private var _inputCollection: FileCollection by FinalizeOnRead(MustSet())

    @get:InputFiles
    var inputCollection: FileCollection
        get() = _inputCollection
        set(value) {
            _inputCollection = value

            // use _inputCollection to finalize it immediately
            val fd = _inputCollection.map { it to temporaryDir.resolve(it.name) }
            outputs.dirs(*fd.filter { it.first.isDirectory }.map { it.second }.toTypedArray())
            outputs.files(*fd.filter { it.first.isFile }.map { it.second }.toTypedArray())

        }

    @get:InputFiles
    var classpath: FileCollection by FinalizeOnRead(LazyMutable {
        project.extensions.getByType(SourceSetContainer::class.java).getByName("main").runtimeClasspath
    })

    @get:Internal
    val outputMap: Map<File, File>
        get() = inputCollection.associateWith { temporaryDir.resolve(it.name) }

    /**
     * this is the true output, gradle just doesn't have a
     * \@OutputDirectoriesAndFiles
     */
    @get:Internal
    val outputCollection: FileCollection by lazy {
        outputs.files
    }

    @get:ServiceReference("jvmdgDefaultFlags")
    abstract val defaultFlags: Property<DefaultFlags>

    init {
        group = "JVMDowngrader"
        convention(defaultFlags.get().parameters)
    }

    @TaskAction
    fun doDowngrade() {
        var toDowngrade = inputCollection.map { it.toPath() }.filter { it.exists() }
        val classpath = classpath.files

        val fileSystems = mutableSetOf<FileSystem>()

        try {

            outputs.files.forEach { it.deleteRecursively() }

            val downgraded = toDowngrade.map { temporaryDir.resolve(it.name) }.map {
                if (it.extension == "jar" || it.extension == "zip") {
                    val fs = Utils.openZipFileSystem(it.toPath(), true)
                    fileSystems.add(fs)
                    fs.getPath("/")
                } else it.toPath()
            }

            toDowngrade = toDowngrade.map {
                if (it.isDirectory()) it else run {
                    val fs = Utils.openZipFileSystem(it, false)
                    fileSystems.add(fs)
                    fs.getPath("/")
                }
            }
            ClassDowngrader.downgradeTo(this.toFlags()).use {
                PathDowngrader.downgradePaths(it, toDowngrade, downgraded, classpath.map { it.toURI().toURL() }.toSet())
            }
        } finally {
            fileSystems.forEach { it.close() }
        }
    }

    fun forInputs(files: Set<File>): FileCollection {
        return project.files(outputMap.filterKeys { it in files }.values)
    }

}
