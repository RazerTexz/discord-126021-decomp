package lombok.core.configuration;

import java.io.IOException;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/ConfigurationFile$CharSequenceConfigurationFile.SCL.lombok */
class ConfigurationFile$CharSequenceConfigurationFile extends ConfigurationFile {
    private final CharSequence contents;
    private final long lastModified;

    /* synthetic */ ConfigurationFile$CharSequenceConfigurationFile(String str, CharSequence charSequence, long j, ConfigurationFile$CharSequenceConfigurationFile configurationFile$CharSequenceConfigurationFile) {
        this(str, charSequence, j);
    }

    private ConfigurationFile$CharSequenceConfigurationFile(String identifier, CharSequence contents, long lastModified) {
        super(identifier, null);
        this.contents = contents;
        this.lastModified = lastModified;
    }

    @Override // lombok.core.configuration.ConfigurationFile
    long getLastModifiedOrMissing() {
        return this.lastModified;
    }

    @Override // lombok.core.configuration.ConfigurationFile
    CharSequence contents() throws IOException {
        return this.contents;
    }

    @Override // lombok.core.configuration.ConfigurationFile
    boolean exists() {
        return true;
    }

    @Override // lombok.core.configuration.ConfigurationFile
    public ConfigurationFile resolve(String path) {
        return null;
    }

    @Override // lombok.core.configuration.ConfigurationFile
    ConfigurationFile parent() {
        return null;
    }
}
