package lombok.core.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/ConfigurationFile$RegularConfigurationFile.SCL.lombok */
class ConfigurationFile$RegularConfigurationFile extends ConfigurationFile {
    private final File file;

    /* synthetic */ ConfigurationFile$RegularConfigurationFile(File file, ConfigurationFile$RegularConfigurationFile configurationFile$RegularConfigurationFile) {
        this(file);
    }

    private ConfigurationFile$RegularConfigurationFile(File file) {
        super(file.getPath(), null);
        this.file = file;
    }

    @Override // lombok.core.configuration.ConfigurationFile
    boolean exists() {
        return ConfigurationFile.access$1(this.file);
    }

    @Override // lombok.core.configuration.ConfigurationFile
    public ConfigurationFile resolve(String path) {
        if (path.endsWith("!")) {
            return null;
        }
        String[] parts = path.split("!");
        if (parts.length > 2) {
            return null;
        }
        String realFileName = parts[0];
        File file = resolveFile(replaceEnvironmentVariables(realFileName));
        if (realFileName.endsWith(".zip") || realFileName.endsWith(".jar")) {
            try {
                return ConfigurationFile$ArchivedConfigurationFile.create(file, URI.create(parts.length == 1 ? "lombok.config" : parts[1]));
            } catch (Exception unused) {
                return null;
            }
        }
        if (parts.length <= 1 && file != null) {
            return forFile(file);
        }
        return null;
    }

    private File resolveFile(String path) {
        char firstCharacter;
        boolean absolute = false;
        int colon = path.indexOf(58);
        if (colon != -1) {
            if (colon != 1 || path.indexOf(58, colon + 1) != -1 || (firstCharacter = Character.toLowerCase(path.charAt(0))) < 'a' || firstCharacter > 'z') {
                return null;
            }
            absolute = true;
        }
        if (path.charAt(0) == '/') {
            absolute = true;
        }
        try {
            return absolute ? new File(path) : new File(this.file.toURI().resolve(path));
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // lombok.core.configuration.ConfigurationFile
    long getLastModifiedOrMissing() {
        return getLastModifiedOrMissing(this.file);
    }

    @Override // lombok.core.configuration.ConfigurationFile
    CharSequence contents() throws IOException {
        FileInputStream is = new FileInputStream(this.file);
        try {
            return ConfigurationFile.access$2(is);
        } finally {
            is.close();
        }
    }

    @Override // lombok.core.configuration.ConfigurationFile
    ConfigurationFile parent() {
        File parent = this.file.getParentFile().getParentFile();
        if (parent == null) {
            return null;
        }
        return forDirectory(parent);
    }

    private static String replaceEnvironmentVariables(String fileName) {
        int start = 0;
        StringBuffer result = new StringBuffer();
        if (fileName.startsWith("~")) {
            start = 1;
            result.append(System.getProperty("user.home", "~"));
        }
        Matcher matcher = ConfigurationFile.access$3().matcher(fileName.substring(start));
        while (matcher.find()) {
            String key = matcher.group(1);
            String value = (String) ConfigurationFile.access$4().get(key);
            if (value == null) {
                value = "<" + key + ">";
            }
            matcher.appendReplacement(result, value);
        }
        matcher.appendTail(result);
        return result.toString();
    }
}
