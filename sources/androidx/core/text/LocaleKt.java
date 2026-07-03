package androidx.core.text;

import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import java.util.Locale;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Locale.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LocaleKt {
    @RequiresApi(17)
    public static final int getLayoutDirection(Locale locale) {
        C12238m.checkNotNullParameter(locale, "<this>");
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
