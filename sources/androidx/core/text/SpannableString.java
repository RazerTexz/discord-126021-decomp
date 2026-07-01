package androidx.core.text;

import android.annotation.SuppressLint;
import android.text.Spannable;
import d0.z.d.Intrinsics3;
import kotlin.ranges.Ranges2;

/* JADX INFO: renamed from: androidx.core.text.SpannableStringKt, reason: use source file name */
/* JADX INFO: compiled from: SpannableString.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SpannableString {
    @SuppressLint({"SyntheticAccessor"})
    public static final void clearSpans(Spannable spannable) {
        Intrinsics3.checkNotNullParameter(spannable, "<this>");
        Object[] spans = spannable.getSpans(0, spannable.length(), Object.class);
        Intrinsics3.checkNotNullExpressionValue(spans, "getSpans(start, end, T::class.java)");
        for (Object obj : spans) {
            spannable.removeSpan(obj);
        }
    }

    public static final void set(Spannable spannable, int i, int i2, Object obj) {
        Intrinsics3.checkNotNullParameter(spannable, "<this>");
        Intrinsics3.checkNotNullParameter(obj, "span");
        spannable.setSpan(obj, i, i2, 17);
    }

    public static final Spannable toSpannable(CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(charSequence, "<this>");
        android.text.SpannableString spannableStringValueOf = android.text.SpannableString.valueOf(charSequence);
        Intrinsics3.checkNotNullExpressionValue(spannableStringValueOf, "valueOf(this)");
        return spannableStringValueOf;
    }

    public static final void set(Spannable spannable, Ranges2 ranges2, Object obj) {
        Intrinsics3.checkNotNullParameter(spannable, "<this>");
        Intrinsics3.checkNotNullParameter(ranges2, "range");
        Intrinsics3.checkNotNullParameter(obj, "span");
        spannable.setSpan(obj, ranges2.getStart().intValue(), ranges2.getEndInclusive().intValue(), 17);
    }
}
