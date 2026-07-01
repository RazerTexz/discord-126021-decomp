package lombok.core.debug;

/* JADX INFO: loaded from: app.apk:lombok/core/debug/ProblemReporter$TerminalLogger.SCL.lombok */
class ProblemReporter$TerminalLogger implements ProblemReporter$ErrorLogger {
    private ProblemReporter$TerminalLogger() {
    }

    /* synthetic */ ProblemReporter$TerminalLogger(ProblemReporter$TerminalLogger problemReporter$TerminalLogger) {
        this();
    }

    @Override // lombok.core.debug.ProblemReporter$ErrorLogger
    public void info(String message, Throwable ex) {
        System.err.println(message);
        if (ex != null) {
            ex.printStackTrace();
        }
    }

    @Override // lombok.core.debug.ProblemReporter$ErrorLogger
    public void warning(String message, Throwable ex) {
        System.err.println(message);
        if (ex != null) {
            ex.printStackTrace();
        }
    }

    @Override // lombok.core.debug.ProblemReporter$ErrorLogger
    public void error(String message, Throwable ex) {
        System.err.println(message);
        if (ex != null) {
            ex.printStackTrace();
        }
    }
}
