package b.i.e;

/* JADX INFO: renamed from: b.i.e.k, reason: use source file name */
/* JADX INFO: compiled from: ResultPoint.java */
/* JADX INFO: loaded from: classes3.dex */
public class ResultPoint {
    public final float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f1826b;

    public ResultPoint(float f, float f2) {
        this.a = f;
        this.f1826b = f2;
    }

    public static float a(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return b.i.a.f.e.o.f.Q(resultPoint.a, resultPoint.f1826b, resultPoint2.a, resultPoint2.f1826b);
    }

    public static void b(ResultPoint[] resultPointArr) {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        float fA = a(resultPointArr[0], resultPointArr[1]);
        float fA2 = a(resultPointArr[1], resultPointArr[2]);
        float fA3 = a(resultPointArr[0], resultPointArr[2]);
        if (fA2 >= fA && fA2 >= fA3) {
            resultPoint = resultPointArr[0];
            resultPoint2 = resultPointArr[1];
            resultPoint3 = resultPointArr[2];
        } else if (fA3 < fA2 || fA3 < fA) {
            resultPoint = resultPointArr[2];
            resultPoint2 = resultPointArr[0];
            resultPoint3 = resultPointArr[1];
        } else {
            resultPoint = resultPointArr[1];
            resultPoint2 = resultPointArr[0];
            resultPoint3 = resultPointArr[2];
        }
        float f = resultPoint.a;
        float f2 = resultPoint.f1826b;
        if (((resultPoint2.f1826b - f2) * (resultPoint3.a - f)) - ((resultPoint2.a - f) * (resultPoint3.f1826b - f2)) < 0.0f) {
            ResultPoint resultPoint4 = resultPoint3;
            resultPoint3 = resultPoint2;
            resultPoint2 = resultPoint4;
        }
        resultPointArr[0] = resultPoint2;
        resultPointArr[1] = resultPoint;
        resultPointArr[2] = resultPoint3;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ResultPoint) {
            ResultPoint resultPoint = (ResultPoint) obj;
            if (this.a == resultPoint.a && this.f1826b == resultPoint.f1826b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f1826b) + (Float.floatToIntBits(this.a) * 31);
    }

    public final String toString() {
        return "(" + this.a + ',' + this.f1826b + ')';
    }
}
