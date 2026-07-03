package androidx.core.text;

import android.annotation.SuppressLint;
import android.text.Spannable;
import android.text.SpannableString;
import kotlin.ranges.IntRange;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SpannableString.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SpannableStringKt {
    @SuppressLint({"SyntheticAccessor"})
    public static final void clearSpans(Spannable spannable) {
        C12238m.checkNotNullParameter(spannable, "<this>");
        Object[] spans = spannable.getSpans(0, spannable.length(), Object.class);
        C12238m.checkNotNullExpressionValue(spans, "getSpans(start, end, T::class.java)");
        for (Object obj : spans) {
            spannable.removeSpan(obj);
        }
    }

    public static final void set(Spannable spannable, int i, int i2, Object obj) {
        C12238m.checkNotNullParameter(spannable, "<this>");
        C12238m.checkNotNullParameter(obj, "span");
        spannable.setSpan(obj, i, i2, 17);
    }

    public static final Spannable toSpannable(CharSequence charSequence) {
        C12238m.checkNotNullParameter(charSequence, "<this>");
        SpannableString spannableStringValueOf = SpannableString.valueOf(charSequence);
        C12238m.checkNotNullExpressionValue(spannableStringValueOf, "valueOf(this)");
        return spannableStringValueOf;
    }

    public static final void set(Spannable spannable, IntRange intRange, Object obj) {
        C12238m.checkNotNullParameter(spannable, "<this>");
        C12238m.checkNotNullParameter(intRange, "range");
        C12238m.checkNotNullParameter(obj, "span");
        spannable.setSpan(obj, intRange.getStart().intValue(), intRange.getEndInclusive().intValue(), 17);
    }
}
