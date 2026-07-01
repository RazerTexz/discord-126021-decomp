package com.discord.app;

import com.discord.utilities.analytics.AnalyticsTracker;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import d0.t.k;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AppLog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppLog$b extends o implements Function1<String, Unit> {
    public final /* synthetic */ Map $metadata;
    public final /* synthetic */ Throwable $throwable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppLog$b(Throwable th, Map map) {
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
        Set<Map$Entry> setEntrySet;
        m.checkNotNullParameter(str, "message");
        try {
            if (this.$throwable != null) {
                AppLog.g.recordBreadcrumb("Message " + str, "Error");
            }
            Map map = this.$metadata;
            if (map != null && (setEntrySet = map.entrySet()) != null) {
                for (Map$Entry map$Entry : setEntrySet) {
                    AppLog.g.recordBreadcrumb("Metadata: " + ((String) map$Entry.getKey()) + ", " + ((String) map$Entry.getValue()), "Error");
                }
            }
            Exception exc = new Exception(str, this.$throwable);
            AppLog appLog = AppLog.g;
            StackTraceElement[] stackTrace = exc.getStackTrace();
            m.checkNotNullExpressionValue(stackTrace, "e.stackTrace");
            exc.setStackTrace(AppLog.a(appLog, stackTrace, str));
            Throwable cause = exc.getCause();
            if (cause != null) {
                StackTraceElement[] stackTrace2 = cause.getStackTrace();
                m.checkNotNullExpressionValue(stackTrace2, "cause.stackTrace");
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
                m.checkNotNullExpressionValue(stackTrace3, "throwable.stackTrace");
                sb.append(k.joinToString$default(stackTrace3, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
                analyticsTracker.appExceptionThrown(sb.toString());
            } catch (Exception e2) {
                AppLog.g.w("Unable to report to analytics.", e2);
            }
        }
    }
}
