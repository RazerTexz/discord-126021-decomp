package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: androidx.core.graphics.RectKt, reason: use source file name */
/* JADX INFO: compiled from: Rect.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Rect {
    @SuppressLint({"CheckResult"})
    public static final android.graphics.Rect and(android.graphics.Rect rect, android.graphics.Rect rect2) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        Intrinsics3.checkNotNullParameter(rect2, "r");
        android.graphics.Rect rect3 = new android.graphics.Rect(rect);
        rect3.intersect(rect2);
        return rect3;
    }

    public static final int component1(android.graphics.Rect rect) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        return rect.left;
    }

    public static final int component2(android.graphics.Rect rect) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        return rect.top;
    }

    public static final int component3(android.graphics.Rect rect) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        return rect.right;
    }

    public static final int component4(android.graphics.Rect rect) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        return rect.bottom;
    }

    public static final boolean contains(android.graphics.Rect rect, Point point) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        Intrinsics3.checkNotNullParameter(point, "p");
        return rect.contains(point.x, point.y);
    }

    public static final Region minus(android.graphics.Rect rect, android.graphics.Rect rect2) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        Intrinsics3.checkNotNullParameter(rect2, "r");
        Region region = new Region(rect);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    public static final android.graphics.Rect or(android.graphics.Rect rect, android.graphics.Rect rect2) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        Intrinsics3.checkNotNullParameter(rect2, "r");
        android.graphics.Rect rect3 = new android.graphics.Rect(rect);
        rect3.union(rect2);
        return rect3;
    }

    public static final android.graphics.Rect plus(android.graphics.Rect rect, android.graphics.Rect rect2) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        Intrinsics3.checkNotNullParameter(rect2, "r");
        android.graphics.Rect rect3 = new android.graphics.Rect(rect);
        rect3.union(rect2);
        return rect3;
    }

    public static final android.graphics.Rect times(android.graphics.Rect rect, int i) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        android.graphics.Rect rect2 = new android.graphics.Rect(rect);
        rect2.top *= i;
        rect2.left *= i;
        rect2.right *= i;
        rect2.bottom *= i;
        return rect2;
    }

    public static final android.graphics.Rect toRect(RectF rectF) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        android.graphics.Rect rect = new android.graphics.Rect();
        rectF.roundOut(rect);
        return rect;
    }

    public static final RectF toRectF(android.graphics.Rect rect) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        return new RectF(rect);
    }

    public static final Region toRegion(android.graphics.Rect rect) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        return new Region(rect);
    }

    public static final RectF transform(RectF rectF, Matrix matrix) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        Intrinsics3.checkNotNullParameter(matrix, "m");
        matrix.mapRect(rectF);
        return rectF;
    }

    public static final Region xor(android.graphics.Rect rect, android.graphics.Rect rect2) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        Intrinsics3.checkNotNullParameter(rect2, "r");
        Region region = new Region(rect);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    public static final float component1(RectF rectF) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        return rectF.left;
    }

    public static final float component2(RectF rectF) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        return rectF.top;
    }

    public static final float component3(RectF rectF) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        return rectF.right;
    }

    public static final float component4(RectF rectF) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        return rectF.bottom;
    }

    public static final boolean contains(RectF rectF, PointF pointF) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        Intrinsics3.checkNotNullParameter(pointF, "p");
        return rectF.contains(pointF.x, pointF.y);
    }

    public static final Region toRegion(RectF rectF) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        android.graphics.Rect rect = new android.graphics.Rect();
        rectF.roundOut(rect);
        return new Region(rect);
    }

    @SuppressLint({"CheckResult"})
    public static final RectF and(RectF rectF, RectF rectF2) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        Intrinsics3.checkNotNullParameter(rectF2, "r");
        RectF rectF3 = new RectF(rectF);
        rectF3.intersect(rectF2);
        return rectF3;
    }

    public static final Region minus(RectF rectF, RectF rectF2) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        Intrinsics3.checkNotNullParameter(rectF2, "r");
        android.graphics.Rect rect = new android.graphics.Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        android.graphics.Rect rect2 = new android.graphics.Rect();
        rectF2.roundOut(rect2);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    public static final RectF or(RectF rectF, RectF rectF2) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        Intrinsics3.checkNotNullParameter(rectF2, "r");
        RectF rectF3 = new RectF(rectF);
        rectF3.union(rectF2);
        return rectF3;
    }

    public static final RectF plus(RectF rectF, RectF rectF2) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        Intrinsics3.checkNotNullParameter(rectF2, "r");
        RectF rectF3 = new RectF(rectF);
        rectF3.union(rectF2);
        return rectF3;
    }

    public static final Region xor(RectF rectF, RectF rectF2) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        Intrinsics3.checkNotNullParameter(rectF2, "r");
        android.graphics.Rect rect = new android.graphics.Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        android.graphics.Rect rect2 = new android.graphics.Rect();
        rectF2.roundOut(rect2);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    public static final android.graphics.Rect plus(android.graphics.Rect rect, int i) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        android.graphics.Rect rect2 = new android.graphics.Rect(rect);
        rect2.offset(i, i);
        return rect2;
    }

    public static final RectF times(RectF rectF, float f) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f;
        rectF2.left *= f;
        rectF2.right *= f;
        rectF2.bottom *= f;
        return rectF2;
    }

    public static final RectF plus(RectF rectF, float f) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(f, f);
        return rectF2;
    }

    public static final android.graphics.Rect plus(android.graphics.Rect rect, Point point) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        Intrinsics3.checkNotNullParameter(point, "xy");
        android.graphics.Rect rect2 = new android.graphics.Rect(rect);
        rect2.offset(point.x, point.y);
        return rect2;
    }

    public static final android.graphics.Rect minus(android.graphics.Rect rect, int i) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        android.graphics.Rect rect2 = new android.graphics.Rect(rect);
        int i2 = -i;
        rect2.offset(i2, i2);
        return rect2;
    }

    public static final RectF plus(RectF rectF, PointF pointF) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        Intrinsics3.checkNotNullParameter(pointF, "xy");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(pointF.x, pointF.y);
        return rectF2;
    }

    public static final RectF times(RectF rectF, int i) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        float f = i;
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f;
        rectF2.left *= f;
        rectF2.right *= f;
        rectF2.bottom *= f;
        return rectF2;
    }

    public static final RectF minus(RectF rectF, float f) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        RectF rectF2 = new RectF(rectF);
        float f2 = -f;
        rectF2.offset(f2, f2);
        return rectF2;
    }

    public static final android.graphics.Rect minus(android.graphics.Rect rect, Point point) {
        Intrinsics3.checkNotNullParameter(rect, "<this>");
        Intrinsics3.checkNotNullParameter(point, "xy");
        android.graphics.Rect rect2 = new android.graphics.Rect(rect);
        rect2.offset(-point.x, -point.y);
        return rect2;
    }

    public static final RectF minus(RectF rectF, PointF pointF) {
        Intrinsics3.checkNotNullParameter(rectF, "<this>");
        Intrinsics3.checkNotNullParameter(pointF, "xy");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(-pointF.x, -pointF.y);
        return rectF2;
    }
}
