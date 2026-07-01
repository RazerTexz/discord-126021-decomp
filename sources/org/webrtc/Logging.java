package org.webrtc;

import androidx.annotation.Nullable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.EnumSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class Logging {

    @Nullable
    public static Logging$ExternalReporter externalReporter;
    private static final Logger fallbackLogger = createFallbackLogger();

    @Nullable
    private static Loggable loggable;
    private static Logging$Severity loggableSeverity;
    private static volatile boolean loggingEnabled;

    private static Logger createFallbackLogger() {
        Logger logger = Logger.getLogger("org.webrtc.Logging");
        logger.setLevel(Level.ALL);
        return logger;
    }

    public static void d(String str, String str2) {
        log(Logging$Severity.LS_INFO, str, str2);
    }

    public static void deleteInjectedLoggable() {
        loggable = null;
    }

    public static void e(String str, String str2) {
        log(Logging$Severity.LS_ERROR, str, str2);
        Logging$ExternalReporter logging$ExternalReporter = externalReporter;
        if (logging$ExternalReporter != null) {
            logging$ExternalReporter.e(str, str2, null);
        }
    }

    public static void enableLogThreads() {
        nativeEnableLogThreads();
    }

    public static void enableLogTimeStamps() {
        nativeEnableLogTimeStamps();
    }

    public static synchronized void enableLogToDebugOutput(Logging$Severity logging$Severity) {
        if (loggable != null) {
            throw new IllegalStateException("Logging to native debug output not supported while Loggable is injected. Delete the Loggable before calling this method.");
        }
        nativeEnableLogToDebugOutput(logging$Severity.ordinal());
        loggingEnabled = true;
    }

    @Deprecated
    public static void enableTracing(String str, EnumSet<Logging$TraceLevel> enumSet) {
    }

    private static String getStackTraceString(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void injectLoggable(Loggable loggable2, Logging$Severity logging$Severity) {
        if (loggable2 != null) {
            loggable = loggable2;
            loggableSeverity = logging$Severity;
        }
    }

    public static void log(Logging$Severity logging$Severity, String str, String str2) {
        Level level;
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("Logging tag or message may not be null.");
        }
        if (loggable != null) {
            if (logging$Severity.ordinal() < loggableSeverity.ordinal()) {
                return;
            }
            loggable.onLogMessage(str2, logging$Severity, str);
            return;
        }
        if (loggingEnabled) {
            nativeLog(logging$Severity.ordinal(), str, str2);
            return;
        }
        int iOrdinal = logging$Severity.ordinal();
        if (iOrdinal == 1) {
            level = Level.INFO;
        } else if (iOrdinal != 2) {
            level = iOrdinal != 3 ? Level.FINE : Level.SEVERE;
        } else {
            level = Level.WARNING;
        }
        fallbackLogger.log(level, str + ": " + str2);
    }

    private static native void nativeEnableLogThreads();

    private static native void nativeEnableLogTimeStamps();

    private static native void nativeEnableLogToDebugOutput(int i);

    private static native void nativeLog(int i, String str, String str2);

    public static void v(String str, String str2) {
        log(Logging$Severity.LS_VERBOSE, str, str2);
    }

    public static void w(String str, String str2) {
        log(Logging$Severity.LS_WARNING, str, str2);
    }

    public static void w(String str, String str2, Throwable th) {
        Logging$Severity logging$Severity = Logging$Severity.LS_WARNING;
        log(logging$Severity, str, str2);
        log(logging$Severity, str, th.toString());
        log(logging$Severity, str, getStackTraceString(th));
    }

    public static void e(String str, String str2, Throwable th) {
        Logging$Severity logging$Severity = Logging$Severity.LS_ERROR;
        log(logging$Severity, str, str2);
        log(logging$Severity, str, th.toString());
        log(logging$Severity, str, getStackTraceString(th));
        Logging$ExternalReporter logging$ExternalReporter = externalReporter;
        if (logging$ExternalReporter != null) {
            logging$ExternalReporter.e(str, str2, th);
        }
    }
}
