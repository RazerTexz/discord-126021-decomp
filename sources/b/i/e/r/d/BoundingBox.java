package b.i.e.r.d;

import b.i.e.ResultPoint;
import b.i.e.n.BitMatrix;
import com.google.zxing.NotFoundException;

/* JADX INFO: renamed from: b.i.e.r.d.c, reason: use source file name */
/* JADX INFO: compiled from: BoundingBox.java */
/* JADX INFO: loaded from: classes3.dex */
public final class BoundingBox {
    public final BitMatrix a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ResultPoint f1877b;
    public final ResultPoint c;
    public final ResultPoint d;
    public final ResultPoint e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;

    public BoundingBox(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) throws NotFoundException {
        boolean z2 = resultPoint == null || resultPoint2 == null;
        boolean z3 = resultPoint3 == null || resultPoint4 == null;
        if (z2 && z3) {
            throw NotFoundException.l;
        }
        if (z2) {
            resultPoint = new ResultPoint(0.0f, resultPoint3.f1826b);
            resultPoint2 = new ResultPoint(0.0f, resultPoint4.f1826b);
        } else if (z3) {
            int i = bitMatrix.j;
            resultPoint3 = new ResultPoint(i - 1, resultPoint.f1826b);
            resultPoint4 = new ResultPoint(i - 1, resultPoint2.f1826b);
        }
        this.a = bitMatrix;
        this.f1877b = resultPoint;
        this.c = resultPoint2;
        this.d = resultPoint3;
        this.e = resultPoint4;
        this.f = (int) Math.min(resultPoint.a, resultPoint2.a);
        this.g = (int) Math.max(resultPoint3.a, resultPoint4.a);
        this.h = (int) Math.min(resultPoint.f1826b, resultPoint3.f1826b);
        this.i = (int) Math.max(resultPoint2.f1826b, resultPoint4.f1826b);
    }

    public BoundingBox(BoundingBox boundingBox) {
        this.a = boundingBox.a;
        this.f1877b = boundingBox.f1877b;
        this.c = boundingBox.c;
        this.d = boundingBox.d;
        this.e = boundingBox.e;
        this.f = boundingBox.f;
        this.g = boundingBox.g;
        this.h = boundingBox.h;
        this.i = boundingBox.i;
    }
}
