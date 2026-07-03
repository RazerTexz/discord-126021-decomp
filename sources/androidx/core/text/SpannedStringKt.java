package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;
import androidx.exifinterface.media.ExifInterface;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SpannedString.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SpannedStringKt {
    public static final /* synthetic */ <T> T[] getSpans(Spanned spanned, int i, int i2) {
        C12238m.checkNotNullParameter(spanned, "<this>");
        C12238m.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        T[] tArr = (T[]) spanned.getSpans(i, i2, Object.class);
        C12238m.checkNotNullExpressionValue(tArr, "getSpans(start, end, T::class.java)");
        return tArr;
    }

    public static /* synthetic */ Object[] getSpans$default(Spanned spanned, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = spanned.length();
        }
        C12238m.checkNotNullParameter(spanned, "<this>");
        C12238m.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Object[] spans = spanned.getSpans(i, i2, Object.class);
        C12238m.checkNotNullExpressionValue(spans, "getSpans(start, end, T::class.java)");
        return spans;
    }

    public static final Spanned toSpanned(CharSequence charSequence) {
        C12238m.checkNotNullParameter(charSequence, "<this>");
        SpannedString spannedStringValueOf = SpannedString.valueOf(charSequence);
        C12238m.checkNotNullExpressionValue(spannedStringValueOf, "valueOf(this)");
        return spannedStringValueOf;
    }
}
