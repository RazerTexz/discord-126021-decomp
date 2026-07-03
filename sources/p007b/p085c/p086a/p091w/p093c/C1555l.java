package p007b.p085c.p086a.p091w.p093c;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.List;
import p007b.p085c.p086a.p089b0.C1495c;
import p007b.p085c.p086a.p089b0.C1498f;
import p007b.p085c.p086a.p090c0.C1501a;
import p007b.p085c.p086a.p095y.C1562a;
import p007b.p085c.p086a.p095y.p097l.C1596k;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.c.a.w.c.l */
/* JADX INFO: compiled from: ShapeKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class C1555l extends AbstractC1544a<C1596k, Path> {

    /* JADX INFO: renamed from: i */
    public final C1596k f2622i;

    /* JADX INFO: renamed from: j */
    public final Path f2623j;

    public C1555l(List<C1501a<C1596k>> list) {
        super(list);
        this.f2622i = new C1596k();
        this.f2623j = new Path();
    }

    @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a
    /* JADX INFO: renamed from: f */
    public Path mo728f(C1501a<C1596k> c1501a, float f) {
        C1596k c1596k = c1501a.f2317b;
        C1596k c1596k2 = c1501a.f2318c;
        C1596k c1596k3 = this.f2622i;
        if (c1596k3.f2804b == null) {
            c1596k3.f2804b = new PointF();
        }
        c1596k3.f2805c = c1596k.f2805c || c1596k2.f2805c;
        if (c1596k.f2803a.size() != c1596k2.f2803a.size()) {
            StringBuilder sbM833U = C1643a.m833U("Curves must have the same number of control points. Shape 1: ");
            sbM833U.append(c1596k.f2803a.size());
            sbM833U.append("\tShape 2: ");
            sbM833U.append(c1596k2.f2803a.size());
            C1495c.m640b(sbM833U.toString());
        }
        int iMin = Math.min(c1596k.f2803a.size(), c1596k2.f2803a.size());
        if (c1596k3.f2803a.size() < iMin) {
            for (int size = c1596k3.f2803a.size(); size < iMin; size++) {
                c1596k3.f2803a.add(new C1562a());
            }
        } else if (c1596k3.f2803a.size() > iMin) {
            for (int size2 = c1596k3.f2803a.size() - 1; size2 >= iMin; size2--) {
                List<C1562a> list = c1596k3.f2803a;
                list.remove(list.size() - 1);
            }
        }
        PointF pointF = c1596k.f2804b;
        PointF pointF2 = c1596k2.f2804b;
        float fM655e = C1498f.m655e(pointF.x, pointF2.x, f);
        float fM655e2 = C1498f.m655e(pointF.y, pointF2.y, f);
        if (c1596k3.f2804b == null) {
            c1596k3.f2804b = new PointF();
        }
        c1596k3.f2804b.set(fM655e, fM655e2);
        for (int size3 = c1596k3.f2803a.size() - 1; size3 >= 0; size3--) {
            C1562a c1562a = c1596k.f2803a.get(size3);
            C1562a c1562a2 = c1596k2.f2803a.get(size3);
            PointF pointF3 = c1562a.f2652a;
            PointF pointF4 = c1562a.f2653b;
            PointF pointF5 = c1562a.f2654c;
            PointF pointF6 = c1562a2.f2652a;
            PointF pointF7 = c1562a2.f2653b;
            PointF pointF8 = c1562a2.f2654c;
            c1596k3.f2803a.get(size3).f2652a.set(C1498f.m655e(pointF3.x, pointF6.x, f), C1498f.m655e(pointF3.y, pointF6.y, f));
            c1596k3.f2803a.get(size3).f2653b.set(C1498f.m655e(pointF4.x, pointF7.x, f), C1498f.m655e(pointF4.y, pointF7.y, f));
            c1596k3.f2803a.get(size3).f2654c.set(C1498f.m655e(pointF5.x, pointF8.x, f), C1498f.m655e(pointF5.y, pointF8.y, f));
        }
        C1596k c1596k4 = this.f2622i;
        Path path = this.f2623j;
        path.reset();
        PointF pointF9 = c1596k4.f2804b;
        path.moveTo(pointF9.x, pointF9.y);
        C1498f.f2308a.set(pointF9.x, pointF9.y);
        for (int i = 0; i < c1596k4.f2803a.size(); i++) {
            C1562a c1562a3 = c1596k4.f2803a.get(i);
            PointF pointF10 = c1562a3.f2652a;
            PointF pointF11 = c1562a3.f2653b;
            PointF pointF12 = c1562a3.f2654c;
            if (pointF10.equals(C1498f.f2308a) && pointF11.equals(pointF12)) {
                path.lineTo(pointF12.x, pointF12.y);
            } else {
                path.cubicTo(pointF10.x, pointF10.y, pointF11.x, pointF11.y, pointF12.x, pointF12.y);
            }
            C1498f.f2308a.set(pointF12.x, pointF12.y);
        }
        if (c1596k4.f2805c) {
            path.close();
        }
        return this.f2623j;
    }
}
