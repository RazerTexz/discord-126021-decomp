package androidx.core.content;

import android.content.SharedPreferences$Editor;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class SharedPreferencesCompat$EditorCompat {
    private static SharedPreferencesCompat$EditorCompat sInstance;
    private final SharedPreferencesCompat$EditorCompat$Helper mHelper = new SharedPreferencesCompat$EditorCompat$Helper();

    private SharedPreferencesCompat$EditorCompat() {
    }

    @Deprecated
    public static SharedPreferencesCompat$EditorCompat getInstance() {
        if (sInstance == null) {
            sInstance = new SharedPreferencesCompat$EditorCompat();
        }
        return sInstance;
    }

    @Deprecated
    public void apply(@NonNull SharedPreferences$Editor sharedPreferences$Editor) {
        this.mHelper.apply(sharedPreferences$Editor);
    }
}
