package androidx.core.text;

import android.text.Html$ImageGetter;
import android.text.Html$TagHandler;
import android.text.Spanned;
import d0.z.d.m;

/* JADX INFO: compiled from: Html.kt */
/* JADX INFO: loaded from: classes.dex */
public final class HtmlKt {
    public static final Spanned parseAsHtml(String str, int i, Html$ImageGetter html$ImageGetter, Html$TagHandler html$TagHandler) {
        m.checkNotNullParameter(str, "<this>");
        Spanned spannedFromHtml = HtmlCompat.fromHtml(str, i, html$ImageGetter, html$TagHandler);
        m.checkNotNullExpressionValue(spannedFromHtml, "fromHtml(this, flags, imageGetter, tagHandler)");
        return spannedFromHtml;
    }

    public static /* synthetic */ Spanned parseAsHtml$default(String str, int i, Html$ImageGetter html$ImageGetter, Html$TagHandler html$TagHandler, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            html$ImageGetter = null;
        }
        if ((i2 & 4) != 0) {
            html$TagHandler = null;
        }
        m.checkNotNullParameter(str, "<this>");
        Spanned spannedFromHtml = HtmlCompat.fromHtml(str, i, html$ImageGetter, html$TagHandler);
        m.checkNotNullExpressionValue(spannedFromHtml, "fromHtml(this, flags, imageGetter, tagHandler)");
        return spannedFromHtml;
    }

    public static final String toHtml(Spanned spanned, int i) {
        m.checkNotNullParameter(spanned, "<this>");
        String html = HtmlCompat.toHtml(spanned, i);
        m.checkNotNullExpressionValue(html, "toHtml(this, option)");
        return html;
    }

    public static /* synthetic */ String toHtml$default(Spanned spanned, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        m.checkNotNullParameter(spanned, "<this>");
        String html = HtmlCompat.toHtml(spanned, i);
        m.checkNotNullExpressionValue(html, "toHtml(this, option)");
        return html;
    }
}
