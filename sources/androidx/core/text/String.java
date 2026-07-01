package androidx.core.text;

import android.text.TextUtils;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: androidx.core.text.StringKt, reason: use source file name */
/* JADX INFO: compiled from: String.kt */
/* JADX INFO: loaded from: classes.dex */
public final class String {
    public static final java.lang.String htmlEncode(java.lang.String str) {
        Intrinsics3.checkNotNullParameter(str, "<this>");
        java.lang.String strHtmlEncode = TextUtils.htmlEncode(str);
        Intrinsics3.checkNotNullExpressionValue(strHtmlEncode, "htmlEncode(this)");
        return strHtmlEncode;
    }
}
