package p007b.p085c.p086a.p087a0;

import android.graphics.PointF;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c;
import p007b.p085c.p086a.p089b0.C1498f;
import p007b.p085c.p086a.p095y.C1562a;
import p007b.p085c.p086a.p095y.p097l.C1596k;

/* JADX INFO: renamed from: b.c.a.a0.b0 */
/* JADX INFO: compiled from: ShapeDataParser.java */
/* JADX INFO: loaded from: classes.dex */
public class C1457b0 implements InterfaceC1469h0<C1596k> {

    /* JADX INFO: renamed from: a */
    public static final C1457b0 f2211a = new C1457b0();

    /* JADX INFO: renamed from: b */
    public static final AbstractC1473c.a f2212b = AbstractC1473c.a.m616a("c", "v", "i", "o");

    @Override // p007b.p085c.p086a.p087a0.InterfaceC1469h0
    /* JADX INFO: renamed from: a */
    public C1596k mo413a(AbstractC1473c abstractC1473c, float f) throws IOException {
        if (abstractC1473c.mo613u() == AbstractC1473c.b.BEGIN_ARRAY) {
            abstractC1473c.mo603a();
        }
        abstractC1473c.mo604b();
        List<PointF> listM629c = null;
        List<PointF> listM629c2 = null;
        List<PointF> listM629c3 = null;
        boolean zMo608f = false;
        while (abstractC1473c.mo607e()) {
            int iMo615y = abstractC1473c.mo615y(f2212b);
            if (iMo615y == 0) {
                zMo608f = abstractC1473c.mo608f();
            } else if (iMo615y == 1) {
                listM629c = C1481p.m629c(abstractC1473c, f);
            } else if (iMo615y == 2) {
                listM629c2 = C1481p.m629c(abstractC1473c, f);
            } else if (iMo615y != 3) {
                abstractC1473c.mo600A();
                abstractC1473c.mo601C();
            } else {
                listM629c3 = C1481p.m629c(abstractC1473c, f);
            }
        }
        abstractC1473c.mo606d();
        if (abstractC1473c.mo613u() == AbstractC1473c.b.END_ARRAY) {
            abstractC1473c.mo605c();
        }
        if (listM629c == null || listM629c2 == null || listM629c3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (listM629c.isEmpty()) {
            return new C1596k(new PointF(), false, Collections.emptyList());
        }
        int size = listM629c.size();
        PointF pointF = listM629c.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i = 1; i < size; i++) {
            PointF pointF2 = listM629c.get(i);
            int i2 = i - 1;
            arrayList.add(new C1562a(C1498f.m651a(listM629c.get(i2), listM629c3.get(i2)), C1498f.m651a(pointF2, listM629c2.get(i)), pointF2));
        }
        if (zMo608f) {
            PointF pointF3 = listM629c.get(0);
            int i3 = size - 1;
            arrayList.add(new C1562a(C1498f.m651a(listM629c.get(i3), listM629c3.get(i3)), C1498f.m651a(pointF3, listM629c2.get(0)), pointF3));
        }
        return new C1596k(pointF, zMo608f, arrayList);
    }
}
