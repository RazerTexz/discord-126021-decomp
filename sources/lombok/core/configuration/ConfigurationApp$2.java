package lombok.core.configuration;

import java.util.List;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/ConfigurationApp$2.SCL.lombok */
class ConfigurationApp$2 implements ConfigurationProblemReporter {
    final /* synthetic */ ConfigurationApp this$0;
    private final /* synthetic */ List val$problems;

    ConfigurationApp$2(ConfigurationApp configurationApp, List list) {
        this.this$0 = configurationApp;
        this.val$problems = list;
    }

    @Override // lombok.core.configuration.ConfigurationProblemReporter
    public void report(String sourceDescription, String problem, int lineNumber, CharSequence line) {
        this.val$problems.add(String.format("%s: %s (%s:%d)", problem, line, sourceDescription, Integer.valueOf(lineNumber)));
    }
}
