package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: androidx.core.content.res.TypedArrayKt, reason: use source file name */
/* JADX INFO: compiled from: TypedArray.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TypedArray {
    private static final void checkAttribute(android.content.res.TypedArray typedArray, @StyleableRes int i) {
        if (!typedArray.hasValue(i)) {
            throw new IllegalArgumentException("Attribute not defined in set.");
        }
    }

    public static final boolean getBooleanOrThrow(android.content.res.TypedArray typedArray, @StyleableRes int i) {
        Intrinsics3.checkNotNullParameter(typedArray, "<this>");
        checkAttribute(typedArray, i);
        return typedArray.getBoolean(i, false);
    }

    @ColorInt
    public static final int getColorOrThrow(android.content.res.TypedArray typedArray, @StyleableRes int i) {
        Intrinsics3.checkNotNullParameter(typedArray, "<this>");
        checkAttribute(typedArray, i);
        return typedArray.getColor(i, 0);
    }

    public static final ColorStateList getColorStateListOrThrow(android.content.res.TypedArray typedArray, @StyleableRes int i) {
        Intrinsics3.checkNotNullParameter(typedArray, "<this>");
        checkAttribute(typedArray, i);
        ColorStateList colorStateList = typedArray.getColorStateList(i);
        if (colorStateList != null) {
            return colorStateList;
        }
        throw new IllegalStateException("Attribute value was not a color or color state list.".toString());
    }

    public static final float getDimensionOrThrow(android.content.res.TypedArray typedArray, @StyleableRes int i) {
        Intrinsics3.checkNotNullParameter(typedArray, "<this>");
        checkAttribute(typedArray, i);
        return typedArray.getDimension(i, 0.0f);
    }

    @Dimension
    public static final int getDimensionPixelOffsetOrThrow(android.content.res.TypedArray typedArray, @StyleableRes int i) {
        Intrinsics3.checkNotNullParameter(typedArray, "<this>");
        checkAttribute(typedArray, i);
        return typedArray.getDimensionPixelOffset(i, 0);
    }

    @Dimension
    public static final int getDimensionPixelSizeOrThrow(android.content.res.TypedArray typedArray, @StyleableRes int i) {
        Intrinsics3.checkNotNullParameter(typedArray, "<this>");
        checkAttribute(typedArray, i);
        return typedArray.getDimensionPixelSize(i, 0);
    }

    public static final Drawable getDrawableOrThrow(android.content.res.TypedArray typedArray, @StyleableRes int i) {
        Intrinsics3.checkNotNullParameter(typedArray, "<this>");
        checkAttribute(typedArray, i);
        Drawable drawable = typedArray.getDrawable(i);
        Intrinsics3.checkNotNull(drawable);
        return drawable;
    }

    public static final float getFloatOrThrow(android.content.res.TypedArray typedArray, @StyleableRes int i) {
        Intrinsics3.checkNotNullParameter(typedArray, "<this>");
        checkAttribute(typedArray, i);
        return typedArray.getFloat(i, 0.0f);
    }

    @RequiresApi(26)
    public static final Typeface getFontOrThrow(android.content.res.TypedArray typedArray, @StyleableRes int i) {
        Intrinsics3.checkNotNullParameter(typedArray, "<this>");
        checkAttribute(typedArray, i);
        Typeface font = typedArray.getFont(i);
        Intrinsics3.checkNotNull(font);
        return font;
    }

    public static final int getIntOrThrow(android.content.res.TypedArray typedArray, @StyleableRes int i) {
        Intrinsics3.checkNotNullParameter(typedArray, "<this>");
        checkAttribute(typedArray, i);
        return typedArray.getInt(i, 0);
    }

    public static final int getIntegerOrThrow(android.content.res.TypedArray typedArray, @StyleableRes int i) {
        Intrinsics3.checkNotNullParameter(typedArray, "<this>");
        checkAttribute(typedArray, i);
        return typedArray.getInteger(i, 0);
    }

    @AnyRes
    public static final int getResourceIdOrThrow(android.content.res.TypedArray typedArray, @StyleableRes int i) {
        Intrinsics3.checkNotNullParameter(typedArray, "<this>");
        checkAttribute(typedArray, i);
        return typedArray.getResourceId(i, 0);
    }

    public static final String getStringOrThrow(android.content.res.TypedArray typedArray, @StyleableRes int i) {
        Intrinsics3.checkNotNullParameter(typedArray, "<this>");
        checkAttribute(typedArray, i);
        String string = typedArray.getString(i);
        if (string != null) {
            return string;
        }
        throw new IllegalStateException("Attribute value could not be coerced to String.".toString());
    }

    public static final CharSequence[] getTextArrayOrThrow(android.content.res.TypedArray typedArray, @StyleableRes int i) {
        Intrinsics3.checkNotNullParameter(typedArray, "<this>");
        checkAttribute(typedArray, i);
        CharSequence[] textArray = typedArray.getTextArray(i);
        Intrinsics3.checkNotNullExpressionValue(textArray, "getTextArray(index)");
        return textArray;
    }

    public static final CharSequence getTextOrThrow(android.content.res.TypedArray typedArray, @StyleableRes int i) {
        Intrinsics3.checkNotNullParameter(typedArray, "<this>");
        checkAttribute(typedArray, i);
        CharSequence text = typedArray.getText(i);
        if (text != null) {
            return text;
        }
        throw new IllegalStateException("Attribute value could not be coerced to CharSequence.".toString());
    }

    public static final <R> R use(android.content.res.TypedArray typedArray, Function1<? super android.content.res.TypedArray, ? extends R> function1) {
        Intrinsics3.checkNotNullParameter(typedArray, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "block");
        R rInvoke = function1.invoke(typedArray);
        typedArray.recycle();
        return rInvoke;
    }
}
