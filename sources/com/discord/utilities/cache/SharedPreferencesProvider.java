package com.discord.utilities.cache;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.VisibleForTesting;
import androidx.preference.PreferenceManager;
import d0.z.d.m;

/* JADX INFO: compiled from: SharedPreferencesProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SharedPreferencesProvider {
    public static final SharedPreferencesProvider INSTANCE = new SharedPreferencesProvider();
    private static SharedPreferences prefsSessionDurable;
    private static SharedPreferences sharedPreferences;

    private SharedPreferencesProvider() {
    }

    public final SharedPreferences get() {
        SharedPreferences sharedPreferences2 = sharedPreferences;
        if (sharedPreferences2 != null) {
            return sharedPreferences2;
        }
        throw new IllegalStateException("You must call init() before accessing prefs");
    }

    public final SharedPreferences getPrefsSessionDurable() {
        SharedPreferences sharedPreferences2 = prefsSessionDurable;
        if (sharedPreferences2 != null) {
            return sharedPreferences2;
        }
        throw new IllegalStateException("You must call init() before accessing prefsSessionDurable");
    }

    public final void init(Context context) {
        m.checkNotNullParameter(context, "context");
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        prefsSessionDurable = context.getSharedPreferences("prefsSessionDurable", 0);
    }

    @VisibleForTesting
    public final void setInstanceForTesting(SharedPreferences prefs) {
        sharedPreferences = prefs;
    }
}
