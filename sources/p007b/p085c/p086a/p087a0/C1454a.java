package p007b.p085c.p086a.p087a0;

import android.graphics.PointF;
import java.io.IOException;
import java.util.ArrayList;
import p007b.p085c.p086a.C1505d;
import p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c;
import p007b.p085c.p086a.p089b0.C1499g;
import p007b.p085c.p086a.p090c0.C1501a;
import p007b.p085c.p086a.p091w.p093c.C1551h;
import p007b.p085c.p086a.p095y.p096k.C1573b;
import p007b.p085c.p086a.p095y.p096k.C1576e;
import p007b.p085c.p086a.p095y.p096k.C1580i;
import p007b.p085c.p086a.p095y.p096k.InterfaceC1584m;

/* JADX INFO: renamed from: b.c.a.a0.a */
/* JADX INFO: compiled from: AnimatablePathValueParser.java */
/* JADX INFO: loaded from: classes.dex */
public class C1454a {

    /* JADX INFO: renamed from: a */
    public static AbstractC1473c.a f2207a = AbstractC1473c.a.m616a("k", "x", "y");

    /* JADX INFO: renamed from: a */
    public static C1576e m411a(AbstractC1473c abstractC1473c, C1505d c1505d) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (abstractC1473c.mo613u() == AbstractC1473c.b.BEGIN_ARRAY) {
            abstractC1473c.mo603a();
            while (abstractC1473c.mo607e()) {
                arrayList.add(new C1551h(c1505d, C1482q.m631a(abstractC1473c, c1505d, C1499g.m659c(), C1487v.f2288a, abstractC1473c.mo613u() == AbstractC1473c.b.BEGIN_OBJECT)));
            }
            abstractC1473c.mo605c();
            C1483r.m633b(arrayList);
        } else {
            arrayList.add(new C1501a(C1481p.m628b(abstractC1473c, C1499g.m659c())));
        }
        return new C1576e(arrayList);
    }

    /* JADX INFO: renamed from: b */
    public static InterfaceC1584m<PointF, PointF> m412b(AbstractC1473c abstractC1473c, C1505d c1505d) throws IOException {
        AbstractC1473c.b bVar = AbstractC1473c.b.STRING;
        abstractC1473c.mo604b();
        C1576e c1576eM411a = null;
        C1573b c1573bM561q1 = null;
        C1573b c1573bM561q2 = null;
        boolean z2 = false;
        while (abstractC1473c.mo613u() != AbstractC1473c.b.END_OBJECT) {
            int iMo615y = abstractC1473c.mo615y(f2207a);
            if (iMo615y == 0) {
                c1576eM411a = m411a(abstractC1473c, c1505d);
            } else if (iMo615y != 1) {
                if (iMo615y != 2) {
                    abstractC1473c.mo600A();
                    abstractC1473c.mo601C();
                } else if (abstractC1473c.mo613u() == bVar) {
                    abstractC1473c.mo601C();
                    z2 = true;
                } else {
                    c1573bM561q2 = C1460d.m561q1(abstractC1473c, c1505d);
                }
            } else if (abstractC1473c.mo613u() == bVar) {
                abstractC1473c.mo601C();
                z2 = true;
            } else {
                c1573bM561q1 = C1460d.m561q1(abstractC1473c, c1505d);
            }
        }
        abstractC1473c.mo606d();
        if (z2) {
            c1505d.m669a("Lottie doesn't support expressions.");
        }
        return c1576eM411a != null ? c1576eM411a : new C1580i(c1573bM561q1, c1573bM561q2);
    }
}
