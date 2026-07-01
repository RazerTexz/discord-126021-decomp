package com.discord.app;

import android.content.SharedPreferences;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.BuildConfig;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.systemlog.SystemLogReport;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import d0.g0.Strings4;
import d0.g0._Strings;
import d0.t._Arrays;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.q.ReplaySubject;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
    public static final SerializedSubject<LoggedItem, LoggedItem> logsSubject = new SerializedSubject<>(new ReplaySubject(new ReplaySubject.d(new ReplaySubject.c(5000))));

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public static final String[] PACKAGE_MARKERS = {BuildConfig.APPLICATION_ID, "co.discord"};

    /* JADX INFO: compiled from: AppLog.kt */
    public static final /* data */ class LoggedItem implements MGRecyclerDataPayload {

        /* JADX INFO: renamed from: j, reason: from kotlin metadata */
        public final String key;

        /* JADX INFO: renamed from: k, reason: from kotlin metadata */
        public final int priority;

        /* JADX INFO: renamed from: l, reason: from kotlin metadata */
        public final String message;

        /* JADX INFO: renamed from: m, reason: from kotlin metadata */
        public final Throwable throwable;

        public LoggedItem(int i, String str, Throwable th) {
            Intrinsics3.checkNotNullParameter(str, "message");
            this.priority = i;
            this.message = str;
            this.throwable = th;
            String string = UUID.randomUUID().toString();
            Intrinsics3.checkNotNullExpressionValue(string, "UUID.randomUUID().toString()");
            this.key = string;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoggedItem)) {
                return false;
            }
            LoggedItem loggedItem = (LoggedItem) other;
            return this.priority == loggedItem.priority && Intrinsics3.areEqual(this.message, loggedItem.message) && Intrinsics3.areEqual(this.throwable, loggedItem.throwable);
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return 0;
        }

        public int hashCode() {
            int i = this.priority * 31;
            String str = this.message;
            int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            Throwable th = this.throwable;
            return iHashCode + (th != null ? th.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("LoggedItem(priority=");
            sbU.append(this.priority);
            sbU.append(", message=");
            sbU.append(this.message);
            sbU.append(", throwable=");
            sbU.append(this.throwable);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: AppLog.kt */
    public static final class a extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ Map $metadata;
        public final /* synthetic */ int $priority;
        public final /* synthetic */ Throwable $throwable;

        /* JADX INFO: renamed from: com.discord.app.AppLog$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AppLog.kt */
        public static final class C0064a extends Lambda implements Function2<String, Integer, Unit> {
            public C0064a() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num) {
                invoke(str, num.intValue());
                return Unit.a;
            }

            public final void invoke(String str, int i) {
                Intrinsics3.checkNotNullParameter(str, "message");
                Iterator<T> it = _Strings.chunked(str, i).iterator();
                while (it.hasNext()) {
                    Log.println(a.this.$priority, AppLog.g.getDefaultTag(), (String) it.next());
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, Map map, Throwable th) {
            super(1);
            this.$priority = i;
            this.$metadata = map;
            this.$throwable = th;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Set setEntrySet;
            String strJoinToString$default;
            Intrinsics3.checkNotNullParameter(str, "message");
            C0064a c0064a = new C0064a();
            c0064a.invoke(str, 1000);
            Map map = this.$metadata;
            if (map != null && (setEntrySet = map.entrySet()) != null && (strJoinToString$default = _Collections.joinToString$default(setEntrySet, "\n\t", null, null, 0, null, null, 62, null)) != null) {
                c0064a.invoke("Metadata: " + strJoinToString$default, Integer.MAX_VALUE);
            }
            String stackTraceString = Log.getStackTraceString(this.$throwable);
            Intrinsics3.checkNotNullExpressionValue(stackTraceString, "Log.getStackTraceString(throwable)");
            c0064a.invoke(stackTraceString, 1000);
        }
    }

    /* JADX INFO: compiled from: AppLog.kt */
    public static final class b extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ Map $metadata;
        public final /* synthetic */ Throwable $throwable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Throwable th, Map map) {
            super(1);
            this.$throwable = th;
            this.$metadata = map;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Set<Map.Entry> setEntrySet;
            Intrinsics3.checkNotNullParameter(str, "message");
            try {
                if (this.$throwable != null) {
                    AppLog.g.recordBreadcrumb("Message " + str, "Error");
                }
                Map map = this.$metadata;
                if (map != null && (setEntrySet = map.entrySet()) != null) {
                    for (Map.Entry entry : setEntrySet) {
                        AppLog.g.recordBreadcrumb("Metadata: " + ((String) entry.getKey()) + ", " + ((String) entry.getValue()), "Error");
                    }
                }
                Exception exc = new Exception(str, this.$throwable);
                AppLog appLog = AppLog.g;
                StackTraceElement[] stackTrace = exc.getStackTrace();
                Intrinsics3.checkNotNullExpressionValue(stackTrace, "e.stackTrace");
                exc.setStackTrace(AppLog.a(appLog, stackTrace, str));
                Throwable cause = exc.getCause();
                if (cause != null) {
                    StackTraceElement[] stackTrace2 = cause.getStackTrace();
                    Intrinsics3.checkNotNullExpressionValue(stackTrace2, "cause.stackTrace");
                    cause.setStackTrace(AppLog.a(appLog, stackTrace2, str));
                }
                FirebaseCrashlytics.getInstance().recordException(exc);
            } catch (Exception e) {
                AppLog.g.w("Unable to notify error logging.", e);
            }
            if (this.$throwable != null) {
                try {
                    AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.$throwable.getClass().toString());
                    sb.append(":\n");
                    StackTraceElement[] stackTrace3 = this.$throwable.getStackTrace();
                    Intrinsics3.checkNotNullExpressionValue(stackTrace3, "throwable.stackTrace");
                    sb.append(_Arrays.joinToString$default(stackTrace3, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
                    analyticsTracker.appExceptionThrown(sb.toString());
                } catch (Exception e2) {
                    AppLog.g.w("Unable to report to analytics.", e2);
                }
            }
        }
    }

    /* JADX INFO: compiled from: AppLog.kt */
    public static final /* synthetic */ class c extends FunctionReferenceImpl implements Function2<String, Throwable, Unit> {
        public c(AppLog appLog) {
            super(2, appLog, AppLog.class, "v", "v(Ljava/lang/String;Ljava/lang/Throwable;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(String str, Throwable th) {
            String str2 = str;
            Intrinsics3.checkNotNullParameter(str2, "p1");
            ((AppLog) this.receiver).v(str2, th);
            return Unit.a;
        }
    }

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
            Intrinsics3.checkNotNullExpressionValue(className2, "stackTraceElement.className");
            boolean z4 = Strings4.contains$default((CharSequence) className2, (CharSequence) "MediaEngineLegacy", false, 2, (Object) null) && Intrinsics3.areEqual(stackTraceElement.getMethodName(), "e");
            String className3 = stackTraceElement.getClassName();
            Intrinsics3.checkNotNullExpressionValue(className3, "stackTraceElement.className");
            String name = Logger.class.getName();
            Intrinsics3.checkNotNullExpressionValue(name, "Logger::class.java.name");
            if (Strings4.contains$default((CharSequence) className3, (CharSequence) name, false, 2, (Object) null)) {
                z3 = true;
            } else {
                String className4 = stackTraceElement.getClassName();
                Intrinsics3.checkNotNullExpressionValue(className4, "stackTraceElement.className");
                String name2 = Logging.class.getName();
                Intrinsics3.checkNotNullExpressionValue(name2, "Logging::class.java.name");
                if (Strings4.contains$default((CharSequence) className4, (CharSequence) name2, false, 2, (Object) null)) {
                    z3 = true;
                } else {
                    String className5 = stackTraceElement.getClassName();
                    Intrinsics3.checkNotNullExpressionValue(className5, "stackTraceElement.className");
                    String name3 = AppLog.class.getName();
                    Intrinsics3.checkNotNullExpressionValue(name3, "AppLog::class.java.name");
                    if (Strings4.contains$default((CharSequence) className5, (CharSequence) name3, false, 2, (Object) null)) {
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
                if ((stackTraceElement2 == null || (className = stackTraceElement2.getClassName()) == null || !Strings4.contains$default((CharSequence) className, (CharSequence) strArr[i4], false, 2, (Object) null)) ? false : true) {
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
        stackTraceElementArr2[i5] = stackTraceElement3 != null ? new StackTraceElement(stackTraceElement3.getClassName(), stackTraceElement3.getMethodName(), outline.y(stackTraceElement3.getFileName(), ", ", str), stackTraceElement3.getLineNumber()) : null;
        return stackTraceElementArr2;
    }

    public static final void g(Long userId, String userLogin, String username) {
        String strValueOf;
        if (initCalled) {
            SharedPreferences sharedPreferences = cache;
            if (sharedPreferences != null) {
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
                if (userId != null) {
                    userId.longValue();
                    editorEdit.putString("LOG_CACHE_KEY_USER_ID", String.valueOf(userId));
                }
                if (userLogin != null) {
                    editorEdit.putString("LOG_CACHE_KEY_USER_LOGIN", userLogin);
                }
                if (username != null) {
                    editorEdit.putString("LOG_CACHE_KEY_USER_NAME", username);
                }
                editorEdit.apply();
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
        a aVar = new a(i, map, th);
        logsSubject.k.onNext(new LoggedItem(i, str, th));
        b bVar = new b(th, map);
        if (i == 6) {
            bVar.invoke2(str);
        }
        aVar.invoke2(str);
    }

    public final void c(String message, String category, Throwable throwable, Function2<? super String, ? super Throwable, Unit> loggingFn) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(category, "category");
        Intrinsics3.checkNotNullParameter(loggingFn, "loggingFn");
        if (initCalled) {
            String str = '[' + category + "]: " + message;
            loggingFn.invoke("Breadcrumb, " + str, throwable);
            FirebaseCrashlytics.getInstance().log(str);
        }
    }

    @Override // com.discord.utilities.logging.Logger
    public void d(String tag, String message, Throwable throwable) {
        Intrinsics3.checkNotNullParameter(tag, "tag");
        Intrinsics3.checkNotNullParameter(message, "message");
        d(tag + " -> " + message, throwable);
    }

    @Override // com.discord.utilities.logging.Logger
    public void e(String message, Throwable throwable, Map<String, String> metadata) {
        Intrinsics3.checkNotNullParameter(message, "message");
        b(message, 6, throwable, metadata);
    }

    public final void f(String from, String to) {
        Intrinsics3.checkNotNullParameter(from, "from");
        Intrinsics3.checkNotNullParameter(to, "to");
        recordBreadcrumb("Navigation [" + from + "] > [" + to + ']', NotificationCompat.CATEGORY_NAVIGATION);
    }

    @Override // com.discord.utilities.logging.Logger
    public void i(String tag, String message, Throwable throwable) {
        Intrinsics3.checkNotNullParameter(tag, "tag");
        Intrinsics3.checkNotNullParameter(message, "message");
        i(tag + " -> " + message, throwable);
    }

    @Override // com.discord.utilities.logging.Logger
    public void recordBreadcrumb(String message, String category) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(category, "category");
        c(message, category, null, new c(this));
    }

    @Override // com.discord.utilities.logging.Logger
    public void v(String message, Throwable throwable) {
        Intrinsics3.checkNotNullParameter(message, "message");
        b(message, 2, throwable, null);
    }

    @Override // com.discord.utilities.logging.Logger
    public void w(String tag, String message, Throwable throwable) {
        Intrinsics3.checkNotNullParameter(tag, "tag");
        Intrinsics3.checkNotNullParameter(message, "message");
        w(tag + " -> " + message, throwable);
    }

    public static final void i(String message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        g.i(message, null);
    }

    @Override // com.discord.utilities.logging.Logger
    public void d(String message, Throwable throwable) {
        Intrinsics3.checkNotNullParameter(message, "message");
        b(message, 3, throwable, null);
    }

    @Override // com.discord.utilities.logging.Logger
    public void e(String tag, String message, Throwable throwable, Map<String, String> metadata) {
        Intrinsics3.checkNotNullParameter(tag, "tag");
        Intrinsics3.checkNotNullParameter(message, "message");
        e(tag + " -> " + message, throwable, metadata);
    }

    @Override // com.discord.utilities.logging.Logger
    public void w(String message, Throwable throwable) {
        Intrinsics3.checkNotNullParameter(message, "message");
        b(message, 5, throwable, null);
    }

    @Override // com.discord.utilities.logging.Logger
    public void i(String message, Throwable throwable) {
        Intrinsics3.checkNotNullParameter(message, "message");
        b(message, 4, throwable, null);
    }
}
