package androidx.core.text;

import android.text.Spanned;
import androidx.exifinterface.media.ExifInterface;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: androidx.core.text.SpannedStringKt, reason: use source file name */
/* JADX INFO: compiled from: SpannedString.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SpannedString {
    public static final /* synthetic */ <T> T[] getSpans(Spanned spanned, int i, int i2) {
        Intrinsics3.checkNotNullParameter(spanned, "<this>");
        Intrinsics3.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        T[] tArr = (T[]) spanned.getSpans(i, i2, Object.class);
        Intrinsics3.checkNotNullExpressionValue(tArr, "getSpans(start, end, T::class.java)");
        return tArr;
    }

    public static /* synthetic */ Object[] getSpans$default(Spanned spanned, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = spanned.length();
        }
        Intrinsics3.checkNotNullParameter(spanned, "<this>");
        Intrinsics3.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Object[] spans = spanned.getSpans(i, i2, Object.class);
        Intrinsics3.checkNotNullExpressionValue(spans, "getSpans(start, end, T::class.java)");
        return spans;
    }

    public static final Spanned toSpanned(CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(charSequence, "<this>");
        android.text.SpannedString spannedStringValueOf = android.text.SpannedString.valueOf(charSequence);
        Intrinsics3.checkNotNullExpressionValue(spannedStringValueOf, "valueOf(this)");
        return spannedStringValueOf;
    }
}
