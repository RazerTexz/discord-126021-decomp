package androidx.core.text;

import android.text.TextUtils;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: CharSequence.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CharSequenceKt {
    public static final boolean isDigitsOnly(CharSequence charSequence) {
        C12238m.checkNotNullParameter(charSequence, "<this>");
        return TextUtils.isDigitsOnly(charSequence);
    }

    public static final int trimmedLength(CharSequence charSequence) {
        C12238m.checkNotNullParameter(charSequence, "<this>");
        return TextUtils.getTrimmedLength(charSequence);
    }
}
