package androidx.core.text;

import android.text.TextUtils;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: String.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StringKt {
    public static final String htmlEncode(String str) {
        C12238m.checkNotNullParameter(str, "<this>");
        String strHtmlEncode = TextUtils.htmlEncode(str);
        C12238m.checkNotNullExpressionValue(strHtmlEncode, "htmlEncode(this)");
        return strHtmlEncode;
    }
}
