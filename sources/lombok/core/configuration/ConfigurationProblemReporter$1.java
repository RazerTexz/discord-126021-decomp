package lombok.core.configuration;

import lombok.eclipse.handlers.EclipseHandlerUtil;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/ConfigurationProblemReporter$1.SCL.lombok */
class ConfigurationProblemReporter$1 implements ConfigurationProblemReporter {
    ConfigurationProblemReporter$1() {
    }

    @Override // lombok.core.configuration.ConfigurationProblemReporter
    public void report(String sourceDescription, String problem, int lineNumber, CharSequence line) {
        try {
            EclipseHandlerUtil.warning(String.format("%s (%s:%d)", problem, sourceDescription, Integer.valueOf(lineNumber)), null);
        } catch (Throwable unused) {
        }
        System.err.printf("%s (%s:%d)\n", problem, sourceDescription, Integer.valueOf(lineNumber));
    }
}
