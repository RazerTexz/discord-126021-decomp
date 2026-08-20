package lombok.core.debug;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;

/* JADX INFO: loaded from: discord-126021.apk:lombok/core/debug/ProblemReporter.SCL.lombok */
public class ProblemReporter {
    private static ErrorLogger logger;

    /* JADX INFO: loaded from: discord-126021.apk:lombok/core/debug/ProblemReporter$ErrorLogger.SCL.lombok */
    private interface ErrorLogger {
        void info(String str, Throwable th);

        void warning(String str, Throwable th);

        void error(String str, Throwable th);
    }

    public static void info(String msg, Throwable ex) {
        init();
        try {
            logger.info(msg, ex);
        } catch (Throwable unused) {
            logger = new TerminalLogger(null);
            logger.info(msg, ex);
        }
    }

    public static void warning(String msg, Throwable ex) {
        init();
        try {
            logger.warning(msg, ex);
        } catch (Throwable unused) {
            logger = new TerminalLogger(null);
            logger.warning(msg, ex);
        }
    }

    public static void error(String msg, Throwable ex) {
        init();
        try {
            logger.error(msg, ex);
        } catch (Throwable unused) {
            logger = new TerminalLogger(null);
            logger.error(msg, ex);
        }
    }

    private static void init() {
        if (logger != null) {
            return;
        }
        try {
            logger = new EclipseWorkspaceLogger(null);
        } catch (Throwable unused) {
            logger = new TerminalLogger(null);
        }
    }

    /* JADX INFO: loaded from: discord-126021.apk:lombok/core/debug/ProblemReporter$TerminalLogger.SCL.lombok */
    private static class TerminalLogger implements ErrorLogger {
        private TerminalLogger() {
        }

        /* synthetic */ TerminalLogger(TerminalLogger terminalLogger) {
            this();
        }

        @Override // lombok.core.debug.ProblemReporter.ErrorLogger
        public void info(String message, Throwable ex) {
            System.err.println(message);
            if (ex != null) {
                ex.printStackTrace();
            }
        }

        @Override // lombok.core.debug.ProblemReporter.ErrorLogger
        public void warning(String message, Throwable ex) {
            System.err.println(message);
            if (ex != null) {
                ex.printStackTrace();
            }
        }

        @Override // lombok.core.debug.ProblemReporter.ErrorLogger
        public void error(String message, Throwable ex) {
            System.err.println(message);
            if (ex != null) {
                ex.printStackTrace();
            }
        }
    }

    /* JADX INFO: loaded from: discord-126021.apk:lombok/core/debug/ProblemReporter$EclipseWorkspaceLogger.SCL.lombok */
    private static class EclipseWorkspaceLogger implements ErrorLogger {
        private static final int MAX_LOG = 200;
        private static final long SQUELCH_TIMEOUT = TimeUnit.HOURS.toMillis(1);
        private static final AtomicInteger counter = new AtomicInteger();
        private static volatile long squelchTimeout = 0;
        private static final String DEFAULT_BUNDLE_NAME = "org.eclipse.jdt.core";
        private static final Bundle bundle = Platform.getBundle(DEFAULT_BUNDLE_NAME);

        private EclipseWorkspaceLogger() {
        }

        /* synthetic */ EclipseWorkspaceLogger(EclipseWorkspaceLogger eclipseWorkspaceLogger) {
            this();
        }

        static {
            if (bundle == null) {
                throw new NoClassDefFoundError();
            }
        }

        @Override // lombok.core.debug.ProblemReporter.ErrorLogger
        public void info(String message, Throwable error) {
            msg(1, message, error);
        }

        @Override // lombok.core.debug.ProblemReporter.ErrorLogger
        public void warning(String message, Throwable error) {
            msg(2, message, error);
        }

        @Override // lombok.core.debug.ProblemReporter.ErrorLogger
        public void error(String message, Throwable error) {
            msg(4, message, error);
        }

        private void msg(int msgType, String message, Throwable error) {
            int ct = squelchTimeout != 0 ? 0 : counter.incrementAndGet();
            boolean printSquelchWarning = false;
            if (squelchTimeout != 0) {
                long now = System.currentTimeMillis();
                if (squelchTimeout > now) {
                    return;
                }
                squelchTimeout = now + SQUELCH_TIMEOUT;
                printSquelchWarning = true;
            } else if (ct >= 200) {
                squelchTimeout = System.currentTimeMillis() + SQUELCH_TIMEOUT;
                printSquelchWarning = true;
            }
            ILog log = Platform.getLog(bundle);
            log.log(new Status(msgType, DEFAULT_BUNDLE_NAME, message, error));
            if (printSquelchWarning) {
                log.log(new Status(2, DEFAULT_BUNDLE_NAME, "Lombok has logged too many messages; to avoid memory issues, further lombok logs will be squelched for a while. Restart eclipse to start over."));
            }
        }
    }
}
