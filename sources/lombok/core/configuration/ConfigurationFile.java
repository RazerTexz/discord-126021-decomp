package lombok.core.configuration;

import com.adjust.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/ConfigurationFile.SCL.lombok */
public abstract class ConfigurationFile {
    private static final String LOMBOK_CONFIG_FILENAME = "lombok.config";
    private final String identifier;
    private static final Pattern VARIABLE = Pattern.compile("\\<(.+?)\\>");
    private static final Map<String, String> ENV = new HashMap(System.getenv());
    private static final ThreadLocal<byte[]> buffers = new ConfigurationFile$1();

    abstract long getLastModifiedOrMissing();

    abstract boolean exists();

    abstract CharSequence contents() throws IOException;

    public abstract ConfigurationFile resolve(String str);

    abstract ConfigurationFile parent();

    static /* synthetic */ Pattern access$3() {
        return VARIABLE;
    }

    static /* synthetic */ Map access$4() {
        return ENV;
    }

    static void setEnvironment(String key, String value) {
        ENV.put(key, value);
    }

    public static ConfigurationFile forFile(File file) {
        return new ConfigurationFile$RegularConfigurationFile(file, null);
    }

    public static ConfigurationFile forDirectory(File directory) {
        return forFile(new File(directory, LOMBOK_CONFIG_FILENAME));
    }

    public static ConfigurationFile fromCharSequence(String identifier, CharSequence contents, long lastModified) {
        return new ConfigurationFile$CharSequenceConfigurationFile(identifier, contents, lastModified, null);
    }

    private ConfigurationFile(String identifier) {
        this.identifier = identifier;
    }

    /* synthetic */ ConfigurationFile(String str, ConfigurationFile configurationFile) {
        this(str);
    }

    final String description() {
        return this.identifier;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ConfigurationFile) {
            return this.identifier.equals(((ConfigurationFile) obj).identifier);
        }
        return false;
    }

    public final int hashCode() {
        return this.identifier.hashCode();
    }

    public static long getLastModifiedOrMissing(File file) {
        if (fileExists(file)) {
            return file.lastModified();
        }
        return -88L;
    }

    static /* synthetic */ boolean access$1(File file) {
        return fileExists(file);
    }

    private static boolean fileExists(File file) {
        return file.exists() && file.isFile();
    }

    static /* synthetic */ String access$2(InputStream inputStream) throws IOException {
        return read(inputStream);
    }

    private static String read(InputStream is) throws IOException {
        byte[] b2 = buffers.get();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        while (true) {
            int r = is.read(b2);
            if (r != -1) {
                out.write(b2, 0, r);
            } else {
                return new String(out.toByteArray(), Constants.ENCODING);
            }
        }
    }
}
