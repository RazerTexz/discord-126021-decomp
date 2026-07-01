package lombok.core.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/SingleConfigurationSource$1.SCL.lombok */
class SingleConfigurationSource$1 implements ConfigurationParser$Collector {
    private final /* synthetic */ List val$imports;
    private final /* synthetic */ Map val$values;

    SingleConfigurationSource$1(List list, Map map) {
        this.val$imports = list;
        this.val$values = map;
    }

    @Override // lombok.core.configuration.ConfigurationParser$Collector
    public void addImport(ConfigurationFile importFile, ConfigurationFile context, int lineNumber) {
        this.val$imports.add(importFile);
    }

    @Override // lombok.core.configuration.ConfigurationParser$Collector
    public void clear(ConfigurationKey<?> key, ConfigurationFile context, int lineNumber) {
        this.val$values.put(key, new ConfigurationSource$Result(null, true));
    }

    @Override // lombok.core.configuration.ConfigurationParser$Collector
    public void set(ConfigurationKey<?> key, Object value, ConfigurationFile context, int lineNumber) {
        this.val$values.put(key, new ConfigurationSource$Result(value, true));
    }

    @Override // lombok.core.configuration.ConfigurationParser$Collector
    public void add(ConfigurationKey<?> key, Object value, ConfigurationFile context, int lineNumber) {
        modifyList(key, value, true);
    }

    @Override // lombok.core.configuration.ConfigurationParser$Collector
    public void remove(ConfigurationKey<?> key, Object value, ConfigurationFile context, int lineNumber) {
        modifyList(key, value, false);
    }

    private void modifyList(ConfigurationKey<?> key, Object value, boolean add) {
        List<ConfigurationSource$ListModification> list;
        ConfigurationSource$Result result = (ConfigurationSource$Result) this.val$values.get(key);
        if (result == null || result.getValue() == null) {
            list = new ArrayList<>();
            this.val$values.put(key, new ConfigurationSource$Result(list, result != null));
        } else {
            list = (List) result.getValue();
        }
        list.add(new ConfigurationSource$ListModification(value, add));
    }
}
