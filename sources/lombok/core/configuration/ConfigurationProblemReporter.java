package lombok.core.configuration;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/ConfigurationProblemReporter.SCL.lombok */
public interface ConfigurationProblemReporter {
    public static final ConfigurationProblemReporter CONSOLE = new ConfigurationProblemReporter$1();

    void report(String str, String str2, int i, CharSequence charSequence);
}
