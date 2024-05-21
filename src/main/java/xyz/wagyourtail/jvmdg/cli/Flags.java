package xyz.wagyourtail.jvmdg.cli;

import org.objectweb.asm.Opcodes;
import xyz.wagyourtail.jvmdg.ClassDowngrader;
import xyz.wagyourtail.jvmdg.Constants;

import java.beans.XMLDecoder;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.*;

public class Flags {
    public static int classVersion = Opcodes.V1_8;
    public static File api = null;
    public static boolean quiet = Boolean.getBoolean(Constants.QUIET);
    public static boolean allowMaven = System.getProperty(Constants.ALLOW_MAVEN_LOOKUP, "true").equalsIgnoreCase("true");

    // debug
    public static boolean printDebug = Boolean.getBoolean(Constants.DEBUG);
    public static boolean removeReflectionInfo = Boolean.getBoolean(Constants.DEBUG_REMOVE_REFLECTION_INFO);
    public static Set<Integer> debugSkipStubs = new HashSet<>(getDebugSkip());

    private static Set<Integer> getDebugSkip() {
        Set<Integer> skip = new HashSet<>();
        String skipStubs = System.getProperty(Constants.DEBUG_SKIP_STUBS);
        if (skipStubs == null) return skip;
        for (String s : skipStubs.split(",")) {
            skip.add(Integer.parseInt(s));
        }
        return skip;
    }

    private static URL getJavaApiFromShade() throws IOException {
        return ClassDowngrader.class.getResource("/META-INF/lib/java-api.jar");
    }

    private static File getJavaApiFromSystemProperty() throws IOException {
        String api = System.getProperty(Constants.JAVA_API);
        if (api == null) {
            return null;
        }
        return new File(api);
    }

    private static URL getJavaApiFromMaven() throws IOException {
        Package pkg = ClassDowngrader.class.getPackage();
        String version = pkg.getImplementationVersion();
        if (version.contains("SNAPSHOT")) {
            // retrieve maven metadata
            URL url = URI.create("https://maven.wagyourtail.xyz/snapshots/xyz/wagyourtail/jvmdowngrader/jvmdowngrader-java-api/" + version + "/maven-metadata.xml").toURL();
            // get actual latest
            try (InputStream in = url.openStream()) {
                XMLDecoder decoder = new XMLDecoder(in);
                Map<String, Object> metadata = (Map<String, Object>) decoder.readObject();
                String snapshotVersion = ((Map<String, Object>) ((Map<String, Object>) metadata.get("versioning")).get("snapshot")).get("timestamp") + "-" + ((Map<String, Object>) ((Map<String, Object>) metadata.get("versioning")).get("snapshot")).get("buildNumber");
                return URI.create("https://maven.wagyourtail.xyz/snapshots/xyz/wagyourtail/jvmdowngrader/jvmdowngrader-java-api/" + version + "/jvmdowngrader-java-api-" + version + "-" + snapshotVersion + ".jar").toURL();
            }
        } else {
            File file = Constants.DIR;
            file.mkdirs();
            file = new File(file, "java-api-" + version + ".jar");
            // if already exists, return that
            if (file.exists()) {
                return file.toURI().toURL();
            }

            URL url = URI.create("https://maven.wagyourtail.xyz/releases/xyz/wagyourtail/jvmdowngrader/jvmdowngrader-java-api/" + version + "/jvmdowngrader-java-api-" + version + ".jar").toURL();
            // download
            try (InputStream in = url.openStream()) {
                Files.copy(in, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
            return file.toURI().toURL();
        }
    }

    public static Path findJavaApi() {
        try {
            if (api != null) {
                return api.toPath();
            }
            Constants.DIR.mkdirs();
            Path tmp = Constants.DIR.toPath().resolve("jvmdg-api.jar");
            File prop = getJavaApiFromSystemProperty();
            if (prop != null) {
                return prop.toPath();
            }
            URL url = getJavaApiFromShade();
            if (url == null && allowMaven) {
                url = getJavaApiFromMaven();
            }
            assert url != null;
            try (InputStream in = url.openStream()) {
                Files.copy(in, tmp, StandardCopyOption.REPLACE_EXISTING);
            }
            return tmp;
        } catch (IOException e) {
            throw new RuntimeException("Failed to find java api", e);
        }
    }
}
