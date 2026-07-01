package lombok.core.debug;

/* JADX INFO: loaded from: app.apk:lombok/core/debug/ProblemReporter$ErrorLogger.SCL.lombok */
interface ProblemReporter$ErrorLogger {
    void info(String str, Throwable th);

    void warning(String str, Throwable th);

    void error(String str, Throwable th);
}
