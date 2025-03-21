package xyz.wagyourtail.jvmdg.j12.stub.java_base;

import xyz.wagyourtail.jvmdg.version.CoverageIgnore;
import xyz.wagyourtail.jvmdg.version.Stub;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.spi.FileSystemProvider;
import java.util.HashMap;
import java.util.Map;

public class J_N_F_S_FileSystemProvider {

    @Stub
    @CoverageIgnore
    public static FileSystem newFileSystem(FileSystemProvider provider, URI uri, Map<String, Object> env) throws IOException {
        env = new HashMap<>(env);
        env.replaceAll((k, v) -> {
            if (v instanceof Boolean && !k.equals("useTempFile")) {
                return v.toString();
            }
            return v;
        });
        return provider.newFileSystem(uri, env);
    }

    @Stub
    @CoverageIgnore
    public static FileSystem newFileSystem(FileSystemProvider provider, Path path, Map<String, Object> env) throws IOException {
        env = new HashMap<>(env);
        env.replaceAll((k, v) -> {
            if (v instanceof Boolean && !k.equals("useTempFile")) {
                return v.toString();
            }
            return v;
        });
        return provider.newFileSystem(path, env);
    }

}
