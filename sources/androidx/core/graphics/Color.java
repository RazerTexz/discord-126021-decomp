package androidx.core.graphics;

import android.graphics.ColorSpace;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.motion.widget.Key;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: androidx.core.graphics.ColorKt, reason: use source file name */
/* JADX INFO: compiled from: Color.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Color {
    @RequiresApi(26)
    public static final float component1(android.graphics.Color color) {
        Intrinsics3.checkNotNullParameter(color, "<this>");
        return color.getComponent(0);
    }

    public static final int component1(@ColorInt int i) {
        return (i >> 24) & 255;
    }

    @RequiresApi(26)
    public static final float component2(android.graphics.Color color) {
        Intrinsics3.checkNotNullParameter(color, "<this>");
        return color.getComponent(1);
    }

    public static final int component2(@ColorInt int i) {
        return (i >> 16) & 255;
    }

    @RequiresApi(26)
    public static final float component3(android.graphics.Color color) {
        Intrinsics3.checkNotNullParameter(color, "<this>");
        return color.getComponent(2);
    }

    public static final int component3(@ColorInt int i) {
        return (i >> 8) & 255;
    }

    @RequiresApi(26)
    public static final float component4(android.graphics.Color color) {
        Intrinsics3.checkNotNullParameter(color, "<this>");
        return color.getComponent(3);
    }

    public static final int component4(@ColorInt int i) {
        return i & 255;
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i, ColorSpace.Named named) {
        Intrinsics3.checkNotNullParameter(named, "colorSpace");
        return android.graphics.Color.convert(i, ColorSpace.get(named));
    }

    @RequiresApi(26)
    public static final float getAlpha(long j) {
        return android.graphics.Color.alpha(j);
    }

    public static final int getAlpha(@ColorInt int i) {
        return (i >> 24) & 255;
    }

    @RequiresApi(26)
    public static final float getBlue(long j) {
        return android.graphics.Color.blue(j);
    }

    public static final int getBlue(@ColorInt int i) {
        return i & 255;
    }

    @RequiresApi(26)
    public static final ColorSpace getColorSpace(long j) {
        ColorSpace colorSpace = android.graphics.Color.colorSpace(j);
        Intrinsics3.checkNotNullExpressionValue(colorSpace, "colorSpace(this)");
        return colorSpace;
    }

    @RequiresApi(26)
    public static final float getGreen(long j) {
        return android.graphics.Color.green(j);
    }

    public static final int getGreen(@ColorInt int i) {
        return (i >> 8) & 255;
    }

    @RequiresApi(26)
    public static final float getLuminance(@ColorInt int i) {
        return android.graphics.Color.luminance(i);
    }

    @RequiresApi(26)
    public static final float getRed(long j) {
        return android.graphics.Color.red(j);
    }

    public static final int getRed(@ColorInt int i) {
        return (i >> 16) & 255;
    }

    @RequiresApi(26)
    public static final boolean isSrgb(long j) {
        return android.graphics.Color.isSrgb(j);
    }

    @RequiresApi(26)
    public static final boolean isWideGamut(long j) {
        return android.graphics.Color.isWideGamut(j);
    }

    @RequiresApi(26)
    public static final android.graphics.Color plus(android.graphics.Color color, android.graphics.Color color2) {
        Intrinsics3.checkNotNullParameter(color, "<this>");
        Intrinsics3.checkNotNullParameter(color2, "c");
        android.graphics.Color colorCompositeColors = ColorUtils.compositeColors(color2, color);
        Intrinsics3.checkNotNullExpressionValue(colorCompositeColors, "compositeColors(c, this)");
        return colorCompositeColors;
    }

    @RequiresApi(26)
    public static final android.graphics.Color toColor(@ColorInt int i) {
        android.graphics.Color colorValueOf = android.graphics.Color.valueOf(i);
        Intrinsics3.checkNotNullExpressionValue(colorValueOf, "valueOf(this)");
        return colorValueOf;
    }

    @ColorInt
    @RequiresApi(26)
    public static final int toColorInt(long j) {
        return android.graphics.Color.toArgb(j);
    }

    @RequiresApi(26)
    public static final long toColorLong(@ColorInt int i) {
        return android.graphics.Color.pack(i);
    }

    @RequiresApi(26)
    public static final float component1(long j) {
        return android.graphics.Color.red(j);
    }

    @RequiresApi(26)
    public static final float component2(long j) {
        return android.graphics.Color.green(j);
    }

    @RequiresApi(26)
    public static final float component3(long j) {
        return android.graphics.Color.blue(j);
    }

    @RequiresApi(26)
    public static final float component4(long j) {
        return android.graphics.Color.alpha(j);
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i, ColorSpace colorSpace) {
        Intrinsics3.checkNotNullParameter(colorSpace, "colorSpace");
        return android.graphics.Color.convert(i, colorSpace);
    }

    @RequiresApi(26)
    public static final float getLuminance(long j) {
        return android.graphics.Color.luminance(j);
    }

    @RequiresApi(26)
    public static final android.graphics.Color toColor(long j) {
        android.graphics.Color colorValueOf = android.graphics.Color.valueOf(j);
        Intrinsics3.checkNotNullExpressionValue(colorValueOf, "valueOf(this)");
        return colorValueOf;
    }

    @ColorInt
    public static final int toColorInt(String str) {
        Intrinsics3.checkNotNullParameter(str, "<this>");
        return android.graphics.Color.parseColor(str);
    }

    @RequiresApi(26)
    public static final long convertTo(long j, ColorSpace.Named named) {
        Intrinsics3.checkNotNullParameter(named, "colorSpace");
        return android.graphics.Color.convert(j, ColorSpace.get(named));
    }

    @RequiresApi(26)
    public static final long convertTo(long j, ColorSpace colorSpace) {
        Intrinsics3.checkNotNullParameter(colorSpace, "colorSpace");
        return android.graphics.Color.convert(j, colorSpace);
    }

    @RequiresApi(26)
    public static final android.graphics.Color convertTo(android.graphics.Color color, ColorSpace.Named named) {
        Intrinsics3.checkNotNullParameter(color, "<this>");
        Intrinsics3.checkNotNullParameter(named, "colorSpace");
        android.graphics.Color colorConvert = color.convert(ColorSpace.get(named));
        Intrinsics3.checkNotNullExpressionValue(colorConvert, "convert(ColorSpace.get(colorSpace))");
        return colorConvert;
    }

    @RequiresApi(26)
    public static final android.graphics.Color convertTo(android.graphics.Color color, ColorSpace colorSpace) {
        Intrinsics3.checkNotNullParameter(color, "<this>");
        Intrinsics3.checkNotNullParameter(colorSpace, "colorSpace");
        android.graphics.Color colorConvert = color.convert(colorSpace);
        Intrinsics3.checkNotNullExpressionValue(colorConvert, "convert(colorSpace)");
        return colorConvert;
    }
}
