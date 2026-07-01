package com.discord.utilities.systemlog;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences$Editor;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.debug.HistoricalProcessExitReason;
import com.discord.utilities.debug.HistoricalProcessExitReason$Reason;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SystemLogReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SystemLogReport {
    private static final String CACHE_KEY_LAST_STORED_TOMBSTONE_HASH = "CACHE_KEY_SYSTEM_LOG_STORE_LAST_STORED_TOMBSTONE_HASH";
    public static final SystemLogReport INSTANCE = new SystemLogReport();

    private SystemLogReport() {
    }

    public static final /* synthetic */ boolean access$checkHashChanged(SystemLogReport systemLogReport, String str) {
        return systemLogReport.checkHashChanged(str);
    }

    public static final /* synthetic */ void access$sendReport(SystemLogReport systemLogReport, SystemLogUtils$Tombstone systemLogUtils$Tombstone) {
        systemLogReport.sendReport(systemLogUtils$Tombstone);
    }

    private final boolean checkHashChanged(String hash) {
        if (m.areEqual(getPrefsSessionDurable().getString(CACHE_KEY_LAST_STORED_TOMBSTONE_HASH, null), hash)) {
            return false;
        }
        SharedPreferences$Editor sharedPreferences$EditorEdit = getPrefsSessionDurable().edit();
        m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
        sharedPreferences$EditorEdit.putString(CACHE_KEY_LAST_STORED_TOMBSTONE_HASH, hash);
        sharedPreferences$EditorEdit.apply();
        return true;
    }

    private final SharedPreferences getPrefsSessionDurable() {
        return SharedPreferencesProvider.INSTANCE.getPrefsSessionDurable();
    }

    private final void sendReport(SystemLogUtils$Tombstone tombstone) {
        boolean zDidCrashOnPreviousExecution = FirebaseCrashlytics.getInstance().didCrashOnPreviousExecution();
        HistoricalProcessExitReason$Reason lastReason = HistoricalProcessExitReason.INSTANCE.getLastReason();
        AnalyticsTracker.INSTANCE.appNativeCrash(zDidCrashOnPreviousExecution, lastReason != null ? lastReason.getReason() : null, lastReason != null ? lastReason.getReason() : null, tombstone != null ? tombstone.getGroupHash() : null, tombstone != null ? tombstone.getCause() : null);
    }

    public final void reportLastCrash() {
        ObservableExtensionsKt.appSubscribe$default(SystemLogUtils.INSTANCE.fetchLastTombstone(), SystemLogReport.class, (Context) null, (Function1) null, SystemLogReport$reportLastCrash$1.INSTANCE, (Function0) null, (Function0) null, SystemLogReport$reportLastCrash$2.INSTANCE, 54, (Object) null);
    }
}
