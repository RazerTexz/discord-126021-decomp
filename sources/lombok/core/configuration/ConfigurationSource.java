package lombok.core.configuration;

import java.util.List;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/ConfigurationSource.SCL.lombok */
public interface ConfigurationSource {
    ConfigurationSource$Result resolve(ConfigurationKey<?> configurationKey);

    List<ConfigurationFile> imports();
}
