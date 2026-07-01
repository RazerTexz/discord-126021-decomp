package androidx.core.text;

import android.text.TextUtils;
import d0.z.d.m;

/* JADX INFO: compiled from: String.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StringKt {
    public static final String htmlEncode(String str) {
        m.checkNotNullParameter(str, "<this>");
        String strHtmlEncode = TextUtils.htmlEncode(str);
        m.checkNotNullExpressionValue(strHtmlEncode, "htmlEncode(this)");
        return strHtmlEncode;
    }
}
