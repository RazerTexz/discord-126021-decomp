package androidx.core.graphics;

import android.graphics.PointF;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: androidx.core.graphics.PointKt, reason: use source file name */
/* JADX INFO: compiled from: Point.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Point {
    public static final int component1(android.graphics.Point point) {
        Intrinsics3.checkNotNullParameter(point, "<this>");
        return point.x;
    }

    public static final int component2(android.graphics.Point point) {
        Intrinsics3.checkNotNullParameter(point, "<this>");
        return point.y;
    }

    public static final android.graphics.Point minus(android.graphics.Point point, android.graphics.Point point2) {
        Intrinsics3.checkNotNullParameter(point, "<this>");
        Intrinsics3.checkNotNullParameter(point2, "p");
        android.graphics.Point point3 = new android.graphics.Point(point.x, point.y);
        point3.offset(-point2.x, -point2.y);
        return point3;
    }

    public static final android.graphics.Point plus(android.graphics.Point point, android.graphics.Point point2) {
        Intrinsics3.checkNotNullParameter(point, "<this>");
        Intrinsics3.checkNotNullParameter(point2, "p");
        android.graphics.Point point3 = new android.graphics.Point(point.x, point.y);
        point3.offset(point2.x, point2.y);
        return point3;
    }

    public static final android.graphics.Point toPoint(PointF pointF) {
        Intrinsics3.checkNotNullParameter(pointF, "<this>");
        return new android.graphics.Point((int) pointF.x, (int) pointF.y);
    }

    public static final PointF toPointF(android.graphics.Point point) {
        Intrinsics3.checkNotNullParameter(point, "<this>");
        return new PointF(point);
    }

    public static final android.graphics.Point unaryMinus(android.graphics.Point point) {
        Intrinsics3.checkNotNullParameter(point, "<this>");
        return new android.graphics.Point(-point.x, -point.y);
    }

    public static final float component1(PointF pointF) {
        Intrinsics3.checkNotNullParameter(pointF, "<this>");
        return pointF.x;
    }

    public static final float component2(PointF pointF) {
        Intrinsics3.checkNotNullParameter(pointF, "<this>");
        return pointF.y;
    }

    public static final PointF unaryMinus(PointF pointF) {
        Intrinsics3.checkNotNullParameter(pointF, "<this>");
        return new PointF(-pointF.x, -pointF.y);
    }

    public static final PointF minus(PointF pointF, PointF pointF2) {
        Intrinsics3.checkNotNullParameter(pointF, "<this>");
        Intrinsics3.checkNotNullParameter(pointF2, "p");
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(-pointF2.x, -pointF2.y);
        return pointF3;
    }

    public static final PointF plus(PointF pointF, PointF pointF2) {
        Intrinsics3.checkNotNullParameter(pointF, "<this>");
        Intrinsics3.checkNotNullParameter(pointF2, "p");
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(pointF2.x, pointF2.y);
        return pointF3;
    }

    public static final android.graphics.Point minus(android.graphics.Point point, int i) {
        Intrinsics3.checkNotNullParameter(point, "<this>");
        android.graphics.Point point2 = new android.graphics.Point(point.x, point.y);
        int i2 = -i;
        point2.offset(i2, i2);
        return point2;
    }

    public static final android.graphics.Point plus(android.graphics.Point point, int i) {
        Intrinsics3.checkNotNullParameter(point, "<this>");
        android.graphics.Point point2 = new android.graphics.Point(point.x, point.y);
        point2.offset(i, i);
        return point2;
    }

    public static final PointF minus(PointF pointF, float f) {
        Intrinsics3.checkNotNullParameter(pointF, "<this>");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        float f2 = -f;
        pointF2.offset(f2, f2);
        return pointF2;
    }

    public static final PointF plus(PointF pointF, float f) {
        Intrinsics3.checkNotNullParameter(pointF, "<this>");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(f, f);
        return pointF2;
    }
}
