package lombok.core.debug;

/* JADX INFO: loaded from: app.apk:lombok/core/debug/ProblemReporter.SCL.lombok */
public class ProblemReporter {
    private static ProblemReporter$ErrorLogger logger;

    public static void info(String msg, Throwable ex) {
        init();
        try {
            logger.info(msg, ex);
        } catch (Throwable unused) {
            logger = new ProblemReporter$TerminalLogger(null);
            logger.info(msg, ex);
        }
    }

    public static void warning(String msg, Throwable ex) {
        init();
        try {
            logger.warning(msg, ex);
        } catch (Throwable unused) {
            logger = new ProblemReporter$TerminalLogger(null);
            logger.warning(msg, ex);
        }
    }

    public static void error(String msg, Throwable ex) {
        init();
        try {
            logger.error(msg, ex);
        } catch (Throwable unused) {
            logger = new ProblemReporter$TerminalLogger(null);
            logger.error(msg, ex);
        }
    }

    private static void init() {
        if (logger != null) {
            return;
        }
        try {
            logger = new ProblemReporter$EclipseWorkspaceLogger(null);
        } catch (Throwable unused) {
            logger = new ProblemReporter$TerminalLogger(null);
        }
    }
}
