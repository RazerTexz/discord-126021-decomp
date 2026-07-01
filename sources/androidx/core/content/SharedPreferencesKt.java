package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences$Editor;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SharedPreferences.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SharedPreferencesKt {
    @SuppressLint({"ApplySharedPref"})
    public static final void edit(SharedPreferences sharedPreferences, boolean z2, Function1<? super SharedPreferences$Editor, Unit> function1) {
        m.checkNotNullParameter(sharedPreferences, "<this>");
        m.checkNotNullParameter(function1, "action");
        SharedPreferences$Editor sharedPreferences$EditorEdit = sharedPreferences.edit();
        m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
        function1.invoke(sharedPreferences$EditorEdit);
        if (z2) {
            sharedPreferences$EditorEdit.commit();
        } else {
            sharedPreferences$EditorEdit.apply();
        }
    }

    public static /* synthetic */ void edit$default(SharedPreferences sharedPreferences, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        m.checkNotNullParameter(sharedPreferences, "<this>");
        m.checkNotNullParameter(function1, "action");
        SharedPreferences$Editor sharedPreferences$EditorEdit = sharedPreferences.edit();
        m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
        function1.invoke(sharedPreferences$EditorEdit);
        if (z2) {
            sharedPreferences$EditorEdit.commit();
        } else {
            sharedPreferences$EditorEdit.apply();
        }
    }
}
