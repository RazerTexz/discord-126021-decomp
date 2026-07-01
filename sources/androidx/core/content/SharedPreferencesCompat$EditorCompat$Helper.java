package androidx.core.content;

import android.content.SharedPreferences$Editor;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class SharedPreferencesCompat$EditorCompat$Helper {
    public void apply(@NonNull SharedPreferences$Editor sharedPreferences$Editor) {
        try {
            sharedPreferences$Editor.apply();
        } catch (AbstractMethodError unused) {
            sharedPreferences$Editor.commit();
        }
    }
}
