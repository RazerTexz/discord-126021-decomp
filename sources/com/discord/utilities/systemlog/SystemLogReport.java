package com.discord.utilities.systemlog;

import android.content.SharedPreferences;
import com.discord.app.AppLog;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.debug.HistoricalProcessExitReason;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.systemlog.SystemLogUtils;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: SystemLogReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SystemLogReport {
    private static final String CACHE_KEY_LAST_STORED_TOMBSTONE_HASH = "CACHE_KEY_SYSTEM_LOG_STORE_LAST_STORED_TOMBSTONE_HASH";
    public static final SystemLogReport INSTANCE = new SystemLogReport();

    /* JADX INFO: renamed from: com.discord.utilities.systemlog.SystemLogReport$reportLastCrash$1, reason: invalid class name */
    /* JADX INFO: compiled from: SystemLogReport.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            error.setShouldLog(false);
            error.setShowErrorToasts(false);
            SystemLogReport.INSTANCE.sendReport(null);
            AppLog.g.i("Checking tombstone error", error.getThrowable());
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.systemlog.SystemLogReport$reportLastCrash$2, reason: invalid class name */
    /* JADX INFO: compiled from: SystemLogReport.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<SystemLogUtils.Tombstone, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SystemLogUtils.Tombstone tombstone) {
            invoke2(tombstone);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SystemLogUtils.Tombstone tombstone) {
            Intrinsics3.checkNotNullParameter(tombstone, "crash");
            Iterator it = Strings4.split$default((CharSequence) tombstone.getText(), new String[]{"\n"}, false, 0, 6, (Object) null).iterator();
            while (it.hasNext()) {
                AppLog.g.recordBreadcrumb((String) it.next(), "Tombstone");
            }
            AppLog appLog = AppLog.g;
            appLog.recordBreadcrumb(tombstone.getGroupHash(), "Tombstone-Hash");
            SystemLogReport systemLogReport = SystemLogReport.INSTANCE;
            boolean zCheckHashChanged = systemLogReport.checkHashChanged(tombstone.getTextHash());
            if (zCheckHashChanged) {
                Logger.e$default(appLog, "Tombstone", null, null, 6, null);
            }
            if (!zCheckHashChanged) {
                tombstone = null;
            }
            systemLogReport.sendReport(tombstone);
        }
    }

    private SystemLogReport() {
    }

    private final boolean checkHashChanged(String hash) {
        if (Intrinsics3.areEqual(getPrefsSessionDurable().getString(CACHE_KEY_LAST_STORED_TOMBSTONE_HASH, null), hash)) {
            return false;
        }
        SharedPreferences.Editor editorEdit = getPrefsSessionDurable().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putString(CACHE_KEY_LAST_STORED_TOMBSTONE_HASH, hash);
        editorEdit.apply();
        return true;
    }

    private final SharedPreferences getPrefsSessionDurable() {
        return SharedPreferencesProvider.INSTANCE.getPrefsSessionDurable();
    }

    private final void sendReport(SystemLogUtils.Tombstone tombstone) {
        boolean zDidCrashOnPreviousExecution = FirebaseCrashlytics.getInstance().didCrashOnPreviousExecution();
        HistoricalProcessExitReason.Reason lastReason = HistoricalProcessExitReason.INSTANCE.getLastReason();
        AnalyticsTracker.INSTANCE.appNativeCrash(zDidCrashOnPreviousExecution, lastReason != null ? lastReason.getReason() : null, lastReason != null ? lastReason.getReason() : null, tombstone != null ? tombstone.getGroupHash() : null, tombstone != null ? tombstone.getCause() : null);
    }

    public final void reportLastCrash() {
        ObservableExtensionsKt.appSubscribe(SystemLogUtils.INSTANCE.fetchLastTombstone(), (Class<?>) SystemLogReport.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : AnonymousClass1.INSTANCE), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), AnonymousClass2.INSTANCE);
    }
}
