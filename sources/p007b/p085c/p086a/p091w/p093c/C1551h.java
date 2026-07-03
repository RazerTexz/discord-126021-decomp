package p007b.p085c.p086a.p091w.p093c;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import p007b.p085c.p086a.C1505d;
import p007b.p085c.p086a.p089b0.C1499g;
import p007b.p085c.p086a.p090c0.C1501a;

/* JADX INFO: renamed from: b.c.a.w.c.h */
/* JADX INFO: compiled from: PathKeyframe.java */
/* JADX INFO: loaded from: classes.dex */
public class C1551h extends C1501a<PointF> {

    /* JADX INFO: renamed from: o */
    @Nullable
    public Path f2614o;

    /* JADX INFO: renamed from: p */
    public final C1501a<PointF> f2615p;

    public C1551h(C1505d c1505d, C1501a<PointF> c1501a) {
        super(c1505d, c1501a.f2317b, c1501a.f2318c, c1501a.f2319d, c1501a.f2320e, c1501a.f2321f);
        this.f2615p = c1501a;
        m742e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: e */
    public void m742e() {
        T t;
        T t2 = this.f2318c;
        boolean z2 = (t2 == 0 || (t = this.f2317b) == 0 || !((PointF) t).equals(((PointF) t2).x, ((PointF) t2).y)) ? false : true;
        T t3 = this.f2318c;
        if (t3 == 0 || z2) {
            return;
        }
        PointF pointF = (PointF) this.f2317b;
        PointF pointF2 = (PointF) t3;
        C1501a<PointF> c1501a = this.f2615p;
        PointF pointF3 = c1501a.f2328m;
        PointF pointF4 = c1501a.f2329n;
        PathMeasure pathMeasure = C1499g.f2309a;
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            float f = pointF3.x + pointF.x;
            float f2 = pointF.y + pointF3.y;
            float f3 = pointF2.x;
            float f4 = f3 + pointF4.x;
            float f5 = pointF2.y;
            path.cubicTo(f, f2, f4, f5 + pointF4.y, f3, f5);
        }
        this.f2614o = path;
    }
}
