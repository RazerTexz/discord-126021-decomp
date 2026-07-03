package androidx.core.graphics;

import android.graphics.Color;
import android.graphics.ColorSpace;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.motion.widget.Key;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Color.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ColorKt {
    @RequiresApi(26)
    public static final float component1(Color color) {
        C12238m.checkNotNullParameter(color, "<this>");
        return color.getComponent(0);
    }

    public static final int component1(@ColorInt int i) {
        return (i >> 24) & 255;
    }

    @RequiresApi(26)
    public static final float component2(Color color) {
        C12238m.checkNotNullParameter(color, "<this>");
        return color.getComponent(1);
    }

    public static final int component2(@ColorInt int i) {
        return (i >> 16) & 255;
    }

    @RequiresApi(26)
    public static final float component3(Color color) {
        C12238m.checkNotNullParameter(color, "<this>");
        return color.getComponent(2);
    }

    public static final int component3(@ColorInt int i) {
        return (i >> 8) & 255;
    }

    @RequiresApi(26)
    public static final float component4(Color color) {
        C12238m.checkNotNullParameter(color, "<this>");
        return color.getComponent(3);
    }

    public static final int component4(@ColorInt int i) {
        return i & 255;
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i, ColorSpace.Named named) {
        C12238m.checkNotNullParameter(named, "colorSpace");
        return Color.convert(i, ColorSpace.get(named));
    }

    @RequiresApi(26)
    public static final float getAlpha(long j) {
        return Color.alpha(j);
    }

    public static final int getAlpha(@ColorInt int i) {
        return (i >> 24) & 255;
    }

    @RequiresApi(26)
    public static final float getBlue(long j) {
        return Color.blue(j);
    }

    public static final int getBlue(@ColorInt int i) {
        return i & 255;
    }

    @RequiresApi(26)
    public static final ColorSpace getColorSpace(long j) {
        ColorSpace colorSpace = Color.colorSpace(j);
        C12238m.checkNotNullExpressionValue(colorSpace, "colorSpace(this)");
        return colorSpace;
    }

    @RequiresApi(26)
    public static final float getGreen(long j) {
        return Color.green(j);
    }

    public static final int getGreen(@ColorInt int i) {
        return (i >> 8) & 255;
    }

    @RequiresApi(26)
    public static final float getLuminance(@ColorInt int i) {
        return Color.luminance(i);
    }

    @RequiresApi(26)
    public static final float getRed(long j) {
        return Color.red(j);
    }

    public static final int getRed(@ColorInt int i) {
        return (i >> 16) & 255;
    }

    @RequiresApi(26)
    public static final boolean isSrgb(long j) {
        return Color.isSrgb(j);
    }

    @RequiresApi(26)
    public static final boolean isWideGamut(long j) {
        return Color.isWideGamut(j);
    }

    @RequiresApi(26)
    public static final Color plus(Color color, Color color2) {
        C12238m.checkNotNullParameter(color, "<this>");
        C12238m.checkNotNullParameter(color2, "c");
        Color colorCompositeColors = ColorUtils.compositeColors(color2, color);
        C12238m.checkNotNullExpressionValue(colorCompositeColors, "compositeColors(c, this)");
        return colorCompositeColors;
    }

    @RequiresApi(26)
    public static final Color toColor(@ColorInt int i) {
        Color colorValueOf = Color.valueOf(i);
        C12238m.checkNotNullExpressionValue(colorValueOf, "valueOf(this)");
        return colorValueOf;
    }

    @ColorInt
    @RequiresApi(26)
    public static final int toColorInt(long j) {
        return Color.toArgb(j);
    }

    @RequiresApi(26)
    public static final long toColorLong(@ColorInt int i) {
        return Color.pack(i);
    }

    @RequiresApi(26)
    public static final float component1(long j) {
        return Color.red(j);
    }

    @RequiresApi(26)
    public static final float component2(long j) {
        return Color.green(j);
    }

    @RequiresApi(26)
    public static final float component3(long j) {
        return Color.blue(j);
    }

    @RequiresApi(26)
    public static final float component4(long j) {
        return Color.alpha(j);
    }

    @RequiresApi(26)
    public static final long convertTo(@ColorInt int i, ColorSpace colorSpace) {
        C12238m.checkNotNullParameter(colorSpace, "colorSpace");
        return Color.convert(i, colorSpace);
    }

    @RequiresApi(26)
    public static final float getLuminance(long j) {
        return Color.luminance(j);
    }

    @RequiresApi(26)
    public static final Color toColor(long j) {
        Color colorValueOf = Color.valueOf(j);
        C12238m.checkNotNullExpressionValue(colorValueOf, "valueOf(this)");
        return colorValueOf;
    }

    @ColorInt
    public static final int toColorInt(String str) {
        C12238m.checkNotNullParameter(str, "<this>");
        return Color.parseColor(str);
    }

    @RequiresApi(26)
    public static final long convertTo(long j, ColorSpace.Named named) {
        C12238m.checkNotNullParameter(named, "colorSpace");
        return Color.convert(j, ColorSpace.get(named));
    }

    @RequiresApi(26)
    public static final long convertTo(long j, ColorSpace colorSpace) {
        C12238m.checkNotNullParameter(colorSpace, "colorSpace");
        return Color.convert(j, colorSpace);
    }

    @RequiresApi(26)
    public static final Color convertTo(Color color, ColorSpace.Named named) {
        C12238m.checkNotNullParameter(color, "<this>");
        C12238m.checkNotNullParameter(named, "colorSpace");
        Color colorConvert = color.convert(ColorSpace.get(named));
        C12238m.checkNotNullExpressionValue(colorConvert, "convert(ColorSpace.get(colorSpace))");
        return colorConvert;
    }

    @RequiresApi(26)
    public static final Color convertTo(Color color, ColorSpace colorSpace) {
        C12238m.checkNotNullParameter(color, "<this>");
        C12238m.checkNotNullParameter(colorSpace, "colorSpace");
        Color colorConvert = color.convert(colorSpace);
        C12238m.checkNotNullExpressionValue(colorConvert, "convert(colorSpace)");
        return colorConvert;
    }
}
