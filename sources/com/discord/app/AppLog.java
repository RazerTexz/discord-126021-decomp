package com.discord.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences$Editor;
import androidx.core.app.NotificationCompat;
import com.discord.BuildConfig;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.systemlog.SystemLogReport;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import d0.g0.w;
import d0.z.d.m;
import j0.q.a;
import j0.q.a$c;
import j0.q.a$d;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.webrtc.Logging;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: AppLog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppLog extends Logger {

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static boolean initCalled;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static SharedPreferences cache;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public static boolean hasReportedTombstone;
    public static final AppLog g = new AppLog();

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public static int minLoggingPriority = 99;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public static final SerializedSubject<AppLog$LoggedItem, AppLog$LoggedItem> logsSubject = new SerializedSubject<>(new a(new a$d(new a$c(5000))));

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public static final String[] PACKAGE_MARKERS = {BuildConfig.APPLICATION_ID, "co.discord"};

    public AppLog() {
        super("Discord");
    }

    /* JADX WARN: Code duplicated, block: B:19:0x007a  */
    public static final StackTraceElement[] a(AppLog appLog, StackTraceElement[] stackTraceElementArr, String str) {
        int i;
        boolean z2;
        String className;
        boolean z3;
        Objects.requireNonNull(appLog);
        int length = stackTraceElementArr.length;
        int i2 = 0;
        while (true) {
            i = -1;
            if (i2 >= length) {
                i2 = -1;
                break;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i2];
            String className2 = stackTraceElement.getClassName();
            m.checkNotNullExpressionValue(className2, "stackTraceElement.className");
            boolean z4 = w.contains$default((CharSequence) className2, (CharSequence) "MediaEngineLegacy", false, 2, (Object) null) && m.areEqual(stackTraceElement.getMethodName(), "e");
            String className3 = stackTraceElement.getClassName();
            m.checkNotNullExpressionValue(className3, "stackTraceElement.className");
            String name = Logger.class.getName();
            m.checkNotNullExpressionValue(name, "Logger::class.java.name");
            if (w.contains$default((CharSequence) className3, (CharSequence) name, false, 2, (Object) null)) {
                z3 = true;
            } else {
                String className4 = stackTraceElement.getClassName();
                m.checkNotNullExpressionValue(className4, "stackTraceElement.className");
                String name2 = Logging.class.getName();
                m.checkNotNullExpressionValue(name2, "Logging::class.java.name");
                if (w.contains$default((CharSequence) className4, (CharSequence) name2, false, 2, (Object) null)) {
                    z3 = true;
                } else {
                    String className5 = stackTraceElement.getClassName();
                    m.checkNotNullExpressionValue(className5, "stackTraceElement.className");
                    String name3 = AppLog.class.getName();
                    m.checkNotNullExpressionValue(name3, "AppLog::class.java.name");
                    if (w.contains$default((CharSequence) className5, (CharSequence) name3, false, 2, (Object) null)) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                }
            }
            if ((z3 || z4) ? false : true) {
                break;
            }
            i2++;
        }
        int length2 = stackTraceElementArr.length - i2;
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[length2];
        System.arraycopy(stackTraceElementArr, i2, stackTraceElementArr2, 0, length2);
        for (int i3 = 0; i3 < length2; i3++) {
            StackTraceElement stackTraceElement2 = stackTraceElementArr2[i3];
            String[] strArr = PACKAGE_MARKERS;
            int length3 = strArr.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length3) {
                    z2 = false;
                    break;
                }
                if ((stackTraceElement2 == null || (className = stackTraceElement2.getClassName()) == null || !w.contains$default((CharSequence) className, (CharSequence) strArr[i4], false, 2, (Object) null)) ? false : true) {
                    z2 = true;
                    break;
                }
                i4++;
            }
            if (z2) {
                i = i3;
                break;
            }
        }
        int i5 = i > 0 ? i : 0;
        StackTraceElement stackTraceElement3 = stackTraceElementArr2[i5];
        stackTraceElementArr2[i5] = stackTraceElement3 != null ? new StackTraceElement(stackTraceElement3.getClassName(), stackTraceElement3.getMethodName(), b.d.b.a.a.y(stackTraceElement3.getFileName(), ", ", str), stackTraceElement3.getLineNumber()) : null;
        return stackTraceElementArr2;
    }

    public static final void g(Long userId, String userLogin, String username) {
        String strValueOf;
        if (initCalled) {
            SharedPreferences sharedPreferences = cache;
            if (sharedPreferences != null) {
                SharedPreferences$Editor sharedPreferences$EditorEdit = sharedPreferences.edit();
                m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
                if (userId != null) {
                    userId.longValue();
                    sharedPreferences$EditorEdit.putString("LOG_CACHE_KEY_USER_ID", String.valueOf(userId));
                }
                if (userLogin != null) {
                    sharedPreferences$EditorEdit.putString("LOG_CACHE_KEY_USER_LOGIN", userLogin);
                }
                if (username != null) {
                    sharedPreferences$EditorEdit.putString("LOG_CACHE_KEY_USER_NAME", username);
                }
                sharedPreferences$EditorEdit.apply();
            }
            FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
            if (userId == null || (strValueOf = String.valueOf(userId.longValue())) == null) {
                strValueOf = "";
            }
            firebaseCrashlytics.setUserId(strValueOf);
            if (userLogin != null) {
                FirebaseCrashlytics.getInstance().setCustomKey("userLogin", userLogin);
            }
            if (username != null) {
                FirebaseCrashlytics.getInstance().setCustomKey("userName", username);
            }
            if (userId == null || hasReportedTombstone) {
                return;
            }
            hasReportedTombstone = true;
            SystemLogReport.INSTANCE.reportLastCrash();
        }
    }

    public final void b(String str, int i, Throwable th, Map<String, String> map) {
        if (i < minLoggingPriority) {
            return;
        }
        AppLog$a appLog$a = new AppLog$a(i, map, th);
        logsSubject.k.onNext(new AppLog$LoggedItem(i, str, th));
        AppLog$b appLog$b = new AppLog$b(th, map);
        if (i == 6) {
            appLog$b.invoke2(str);
        }
        appLog$a.invoke2(str);
    }

    public final void c(String message, String category, Throwable throwable, Function2<? super String, ? super Throwable, Unit> loggingFn) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(category, "category");
        m.checkNotNullParameter(loggingFn, "loggingFn");
        if (initCalled) {
            String str = '[' + category + "]: " + message;
            loggingFn.invoke("Breadcrumb, " + str, throwable);
            FirebaseCrashlytics.getInstance().log(str);
        }
    }

    @Override // com.discord.utilities.logging.Logger
    public void d(String tag, String message, Throwable throwable) {
        m.checkNotNullParameter(tag, "tag");
        m.checkNotNullParameter(message, "message");
        d(tag + " -> " + message, throwable);
    }

    @Override // com.discord.utilities.logging.Logger
    public void e(String message, Throwable throwable, Map<String, String> metadata) {
        m.checkNotNullParameter(message, "message");
        b(message, 6, throwable, metadata);
    }

    public final void f(String from, String to) {
        m.checkNotNullParameter(from, "from");
        m.checkNotNullParameter(to, "to");
        recordBreadcrumb("Navigation [" + from + "] > [" + to + ']', NotificationCompat.CATEGORY_NAVIGATION);
    }

    @Override // com.discord.utilities.logging.Logger
    public void i(String tag, String message, Throwable throwable) {
        m.checkNotNullParameter(tag, "tag");
        m.checkNotNullParameter(message, "message");
        i(tag + " -> " + message, throwable);
    }

    @Override // com.discord.utilities.logging.Logger
    public void recordBreadcrumb(String message, String category) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(category, "category");
        c(message, category, null, new AppLog$c(this));
    }

    @Override // com.discord.utilities.logging.Logger
    public void v(String message, Throwable throwable) {
        m.checkNotNullParameter(message, "message");
        b(message, 2, throwable, null);
    }

    @Override // com.discord.utilities.logging.Logger
    public void w(String tag, String message, Throwable throwable) {
        m.checkNotNullParameter(tag, "tag");
        m.checkNotNullParameter(message, "message");
        w(tag + " -> " + message, throwable);
    }

    public static final void i(String message) {
        m.checkNotNullParameter(message, "message");
        g.i(message, null);
    }

    @Override // com.discord.utilities.logging.Logger
    public void d(String message, Throwable throwable) {
        m.checkNotNullParameter(message, "message");
        b(message, 3, throwable, null);
    }

    @Override // com.discord.utilities.logging.Logger
    public void e(String tag, String message, Throwable throwable, Map<String, String> metadata) {
        m.checkNotNullParameter(tag, "tag");
        m.checkNotNullParameter(message, "message");
        e(tag + " -> " + message, throwable, metadata);
    }

    @Override // com.discord.utilities.logging.Logger
    public void w(String message, Throwable throwable) {
        m.checkNotNullParameter(message, "message");
        b(message, 5, throwable, null);
    }

    @Override // com.discord.utilities.logging.Logger
    public void i(String message, Throwable throwable) {
        m.checkNotNullParameter(message, "message");
        b(message, 4, throwable, null);
    }
}
