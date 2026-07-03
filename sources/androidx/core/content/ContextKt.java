package androidx.core.content;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Context.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ContextKt {
    public static final /* synthetic */ <T> T getSystemService(Context context) {
        C12238m.checkNotNullParameter(context, "<this>");
        C12238m.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) ContextCompat.getSystemService(context, Object.class);
    }

    public static final void withStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, @AttrRes int i, @StyleRes int i2, Function1<? super TypedArray, Unit> function1) {
        C12238m.checkNotNullParameter(context, "<this>");
        C12238m.checkNotNullParameter(iArr, "attrs");
        C12238m.checkNotNullParameter(function1, "block");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, i2);
        C12238m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(set, attrs, defStyleAttr, defStyleRes)");
        function1.invoke(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void withStyledAttributes$default(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            attributeSet = null;
        }
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        C12238m.checkNotNullParameter(context, "<this>");
        C12238m.checkNotNullParameter(iArr, "attrs");
        C12238m.checkNotNullParameter(function1, "block");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, i2);
        C12238m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(set, attrs, defStyleAttr, defStyleRes)");
        function1.invoke(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static final void withStyledAttributes(Context context, @StyleRes int i, int[] iArr, Function1<? super TypedArray, Unit> function1) {
        C12238m.checkNotNullParameter(context, "<this>");
        C12238m.checkNotNullParameter(iArr, "attrs");
        C12238m.checkNotNullParameter(function1, "block");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, iArr);
        C12238m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(resourceId, attrs)");
        function1.invoke(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }
}
