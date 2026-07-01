package lombok.core.configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import lombok.ConfigurationKeys;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/ConfigurationApp$3.SCL.lombok */
class ConfigurationApp$3 implements ConfigurationParser$Collector {
    final /* synthetic */ ConfigurationApp this$0;
    private final /* synthetic */ Deque val$round;
    private final /* synthetic */ Collection val$keys;
    private final /* synthetic */ Map val$result;

    ConfigurationApp$3(ConfigurationApp configurationApp, Deque deque, Collection collection, Map map) {
        this.this$0 = configurationApp;
        this.val$round = deque;
        this.val$keys = collection;
        this.val$result = map;
    }

    @Override // lombok.core.configuration.ConfigurationParser$Collector
    public void addImport(ConfigurationFile importFile, ConfigurationFile context, int lineNumber) {
        this.val$round.push(new ConfigurationApp$Source(importFile, String.valueOf(importFile.description()) + " (imported from " + context.description() + ":" + lineNumber + ")"));
    }

    @Override // lombok.core.configuration.ConfigurationParser$Collector
    public void clear(ConfigurationKey<?> key, ConfigurationFile context, int lineNumber) {
        trace(key, "clear " + key.getKeyName(), lineNumber);
    }

    @Override // lombok.core.configuration.ConfigurationParser$Collector
    public void set(ConfigurationKey<?> key, Object value, ConfigurationFile context, int lineNumber) {
        trace(key, String.valueOf(key.getKeyName()) + " = " + value, lineNumber);
    }

    @Override // lombok.core.configuration.ConfigurationParser$Collector
    public void add(ConfigurationKey<?> key, Object value, ConfigurationFile context, int lineNumber) {
        trace(key, String.valueOf(key.getKeyName()) + " += " + value, lineNumber);
    }

    @Override // lombok.core.configuration.ConfigurationParser$Collector
    public void remove(ConfigurationKey<?> key, Object value, ConfigurationFile context, int lineNumber) {
        trace(key, String.valueOf(key.getKeyName()) + " -= " + value, lineNumber);
    }

    private void trace(ConfigurationKey<?> key, String message, int lineNumber) {
        if (this.val$keys.contains(key) || key == ConfigurationKeys.STOP_BUBBLING) {
            List<String> traces = (List) this.val$result.get(key);
            if (traces == null) {
                traces = new ArrayList<>();
                this.val$result.put(key, traces);
            }
            traces.add(String.format("%4d: %s", Integer.valueOf(lineNumber), message));
        }
    }
}
