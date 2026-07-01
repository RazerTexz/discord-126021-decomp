package androidx.core.text;

import android.text.Html;
import android.text.Spanned;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: androidx.core.text.HtmlKt, reason: use source file name */
/* JADX INFO: compiled from: Html.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Html {
    public static final Spanned parseAsHtml(String str, int i, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
        Intrinsics3.checkNotNullParameter(str, "<this>");
        Spanned spannedFromHtml = HtmlCompat.fromHtml(str, i, imageGetter, tagHandler);
        Intrinsics3.checkNotNullExpressionValue(spannedFromHtml, "fromHtml(this, flags, imageGetter, tagHandler)");
        return spannedFromHtml;
    }

    public static /* synthetic */ Spanned parseAsHtml$default(String str, int i, Html.ImageGetter imageGetter, Html.TagHandler tagHandler, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            imageGetter = null;
        }
        if ((i2 & 4) != 0) {
            tagHandler = null;
        }
        Intrinsics3.checkNotNullParameter(str, "<this>");
        Spanned spannedFromHtml = HtmlCompat.fromHtml(str, i, imageGetter, tagHandler);
        Intrinsics3.checkNotNullExpressionValue(spannedFromHtml, "fromHtml(this, flags, imageGetter, tagHandler)");
        return spannedFromHtml;
    }

    public static final String toHtml(Spanned spanned, int i) {
        Intrinsics3.checkNotNullParameter(spanned, "<this>");
        String html = HtmlCompat.toHtml(spanned, i);
        Intrinsics3.checkNotNullExpressionValue(html, "toHtml(this, option)");
        return html;
    }

    public static /* synthetic */ String toHtml$default(Spanned spanned, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics3.checkNotNullParameter(spanned, "<this>");
        String html = HtmlCompat.toHtml(spanned, i);
        Intrinsics3.checkNotNullExpressionValue(html, "toHtml(this, option)");
        return html;
    }
}
