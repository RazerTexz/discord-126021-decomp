package lombok.core.debug;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;

/* JADX INFO: loaded from: app.apk:lombok/core/debug/ProblemReporter$EclipseWorkspaceLogger.SCL.lombok */
class ProblemReporter$EclipseWorkspaceLogger implements ProblemReporter$ErrorLogger {
    private static final int MAX_LOG = 200;
    private static final long SQUELCH_TIMEOUT = TimeUnit.HOURS.toMillis(1);
    private static final AtomicInteger counter = new AtomicInteger();
    private static volatile long squelchTimeout = 0;
    private static final String DEFAULT_BUNDLE_NAME = "org.eclipse.jdt.core";
    private static final Bundle bundle = Platform.getBundle(DEFAULT_BUNDLE_NAME);

    private ProblemReporter$EclipseWorkspaceLogger() {
    }

    /* synthetic */ ProblemReporter$EclipseWorkspaceLogger(ProblemReporter$EclipseWorkspaceLogger problemReporter$EclipseWorkspaceLogger) {
        this();
    }

    static {
        if (bundle == null) {
            throw new NoClassDefFoundError();
        }
    }

    @Override // lombok.core.debug.ProblemReporter$ErrorLogger
    public void info(String message, Throwable error) {
        msg(1, message, error);
    }

    @Override // lombok.core.debug.ProblemReporter$ErrorLogger
    public void warning(String message, Throwable error) {
        msg(2, message, error);
    }

    @Override // lombok.core.debug.ProblemReporter$ErrorLogger
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
