package b.c.a.w.c;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: ShapeKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class l extends a<b.c.a.y.l.k, Path> {
    public final b.c.a.y.l.k i;
    public final Path j;

    public l(List<b.c.a.c0.a<b.c.a.y.l.k>> list) {
        super(list);
        this.i = new b.c.a.y.l.k();
        this.j = new Path();
    }

    @Override // b.c.a.w.c.a
    public Path f(b.c.a.c0.a<b.c.a.y.l.k> aVar, float f) {
        b.c.a.y.l.k kVar = aVar.f347b;
        b.c.a.y.l.k kVar2 = aVar.c;
        b.c.a.y.l.k kVar3 = this.i;
        if (kVar3.f424b == null) {
            kVar3.f424b = new PointF();
        }
        kVar3.c = kVar.c || kVar2.c;
        if (kVar.a.size() != kVar2.a.size()) {
            StringBuilder sbU = b.d.b.a.a.U("Curves must have the same number of control points. Shape 1: ");
            sbU.append(kVar.a.size());
            sbU.append("\tShape 2: ");
            sbU.append(kVar2.a.size());
            b.c.a.b0.c.b(sbU.toString());
        }
        int iMin = Math.min(kVar.a.size(), kVar2.a.size());
        if (kVar3.a.size() < iMin) {
            for (int size = kVar3.a.size(); size < iMin; size++) {
                kVar3.a.add(new b.c.a.y.a());
            }
        } else if (kVar3.a.size() > iMin) {
            for (int size2 = kVar3.a.size() - 1; size2 >= iMin; size2--) {
                List<b.c.a.y.a> list = kVar3.a;
                list.remove(list.size() - 1);
            }
        }
        PointF pointF = kVar.f424b;
        PointF pointF2 = kVar2.f424b;
        float fE = b.c.a.b0.f.e(pointF.x, pointF2.x, f);
        float fE2 = b.c.a.b0.f.e(pointF.y, pointF2.y, f);
        if (kVar3.f424b == null) {
            kVar3.f424b = new PointF();
        }
        kVar3.f424b.set(fE, fE2);
        for (int size3 = kVar3.a.size() - 1; size3 >= 0; size3--) {
            b.c.a.y.a aVar2 = kVar.a.get(size3);
            b.c.a.y.a aVar3 = kVar2.a.get(size3);
            PointF pointF3 = aVar2.a;
            PointF pointF4 = aVar2.f399b;
            PointF pointF5 = aVar2.c;
            PointF pointF6 = aVar3.a;
            PointF pointF7 = aVar3.f399b;
            PointF pointF8 = aVar3.c;
            kVar3.a.get(size3).a.set(b.c.a.b0.f.e(pointF3.x, pointF6.x, f), b.c.a.b0.f.e(pointF3.y, pointF6.y, f));
            kVar3.a.get(size3).f399b.set(b.c.a.b0.f.e(pointF4.x, pointF7.x, f), b.c.a.b0.f.e(pointF4.y, pointF7.y, f));
            kVar3.a.get(size3).c.set(b.c.a.b0.f.e(pointF5.x, pointF8.x, f), b.c.a.b0.f.e(pointF5.y, pointF8.y, f));
        }
        b.c.a.y.l.k kVar4 = this.i;
        Path path = this.j;
        path.reset();
        PointF pointF9 = kVar4.f424b;
        path.moveTo(pointF9.x, pointF9.y);
        b.c.a.b0.f.a.set(pointF9.x, pointF9.y);
        for (int i = 0; i < kVar4.a.size(); i++) {
            b.c.a.y.a aVar4 = kVar4.a.get(i);
            PointF pointF10 = aVar4.a;
            PointF pointF11 = aVar4.f399b;
            PointF pointF12 = aVar4.c;
            if (pointF10.equals(b.c.a.b0.f.a) && pointF11.equals(pointF12)) {
                path.lineTo(pointF12.x, pointF12.y);
            } else {
                path.cubicTo(pointF10.x, pointF10.y, pointF11.x, pointF11.y, pointF12.x, pointF12.y);
            }
            b.c.a.b0.f.a.set(pointF12.x, pointF12.y);
        }
        if (kVar4.c) {
            path.close();
        }
        return this.j;
    }
}
