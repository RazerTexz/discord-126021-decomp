package androidx.core.text;

import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: androidx.core.text.LocaleKt, reason: use source file name */
/* JADX INFO: compiled from: Locale.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Locale {
    @RequiresApi(17)
    public static final int getLayoutDirection(java.util.Locale locale) {
        Intrinsics3.checkNotNullParameter(locale, "<this>");
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
