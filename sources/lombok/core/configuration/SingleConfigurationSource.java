package lombok.core.configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/SingleConfigurationSource.SCL.lombok */
public final class SingleConfigurationSource implements ConfigurationSource {
    private final Map<ConfigurationKey<?>, ConfigurationSource$Result> values = new HashMap();
    private final List<ConfigurationFile> imports;

    public static ConfigurationSource parse(ConfigurationFile context, ConfigurationParser parser) {
        Map<ConfigurationKey<?>, ConfigurationSource$Result> values = new HashMap<>();
        List<ConfigurationFile> imports = new ArrayList<>();
        ConfigurationParser$Collector collector = new SingleConfigurationSource$1(imports, values);
        parser.parse(context, collector);
        return new SingleConfigurationSource(values, imports);
    }

    private SingleConfigurationSource(Map<ConfigurationKey<?>, ConfigurationSource$Result> values, List<ConfigurationFile> imports) {
        for (Map$Entry<ConfigurationKey<?>, ConfigurationSource$Result> entry : values.entrySet()) {
            ConfigurationSource$Result result = entry.getValue();
            if (result.getValue() instanceof List) {
                this.values.put(entry.getKey(), new ConfigurationSource$Result(Collections.unmodifiableList((List) result.getValue()), result.isAuthoritative()));
            } else {
                this.values.put(entry.getKey(), result);
            }
        }
        this.imports = Collections.unmodifiableList(imports);
    }

    @Override // lombok.core.configuration.ConfigurationSource
    public ConfigurationSource$Result resolve(ConfigurationKey<?> key) {
        return this.values.get(key);
    }

    @Override // lombok.core.configuration.ConfigurationSource
    public List<ConfigurationFile> imports() {
        return this.imports;
    }
}
