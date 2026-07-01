package lombok.core.configuration;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/ConfigurationParser$Collector.SCL.lombok */
public interface ConfigurationParser$Collector {
    void addImport(ConfigurationFile configurationFile, ConfigurationFile configurationFile2, int i);

    void clear(ConfigurationKey<?> configurationKey, ConfigurationFile configurationFile, int i);

    void set(ConfigurationKey<?> configurationKey, Object obj, ConfigurationFile configurationFile, int i);

    void add(ConfigurationKey<?> configurationKey, Object obj, ConfigurationFile configurationFile, int i);

    void remove(ConfigurationKey<?> configurationKey, Object obj, ConfigurationFile configurationFile, int i);
}
