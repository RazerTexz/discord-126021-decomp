package b.c.a.y;

import android.graphics.PointF;
import androidx.annotation.RestrictTo;

/* JADX INFO: renamed from: b.c.a.y.a, reason: use source file name */
/* JADX INFO: compiled from: CubicCurveData.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class CubicCurveData {
    public final PointF a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PointF f399b;
    public final PointF c;

    public CubicCurveData() {
        this.a = new PointF();
        this.f399b = new PointF();
        this.c = new PointF();
    }

    public CubicCurveData(PointF pointF, PointF pointF2, PointF pointF3) {
        this.a = pointF;
        this.f399b = pointF2;
        this.c = pointF3;
    }
}
