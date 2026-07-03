package p007b.p085c.p086a.p087a0;

import android.graphics.PointF;
import java.io.IOException;
import p007b.p085c.p086a.C1505d;
import p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c;
import p007b.p085c.p086a.p090c0.C1501a;
import p007b.p085c.p086a.p090c0.C1504d;
import p007b.p085c.p086a.p095y.p096k.C1573b;
import p007b.p085c.p086a.p095y.p096k.C1575d;
import p007b.p085c.p086a.p095y.p096k.C1576e;
import p007b.p085c.p086a.p095y.p096k.C1578g;
import p007b.p085c.p086a.p095y.p096k.C1580i;
import p007b.p085c.p086a.p095y.p096k.C1583l;
import p007b.p085c.p086a.p095y.p096k.InterfaceC1584m;

/* JADX INFO: renamed from: b.c.a.a0.c */
/* JADX INFO: compiled from: AnimatableTransformParser.java */
/* JADX INFO: loaded from: classes.dex */
public class C1458c {

    /* JADX INFO: renamed from: a */
    public static AbstractC1473c.a f2213a = AbstractC1473c.a.m616a("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa");

    /* JADX INFO: renamed from: b */
    public static AbstractC1473c.a f2214b = AbstractC1473c.a.m616a("k");

    /* JADX WARN: Code duplicated, block: B:113:0x0219  */
    /* JADX WARN: Code duplicated, block: B:114:0x021c  */
    /* JADX WARN: Code duplicated, block: B:22:0x0068  */
    /* JADX WARN: Code duplicated, block: B:23:0x009b  */
    /* JADX WARN: Code duplicated, block: B:25:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:88:0x01c5  */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: a */
    public static C1583l m414a(AbstractC1473c abstractC1473c, C1505d c1505d) throws IOException {
        boolean z2;
        C1573b c1573b;
        boolean z3;
        C1573b c1573b2;
        C1578g c1578g;
        C1573b c1573b3;
        InterfaceC1584m<PointF, PointF> interfaceC1584m;
        C1573b c1573bM565r1;
        C1573b c1573b4;
        boolean z4 = false;
        boolean z5 = abstractC1473c.mo613u() == AbstractC1473c.b.BEGIN_OBJECT;
        if (z5) {
            abstractC1473c.mo604b();
        }
        C1573b c1573b5 = null;
        C1578g c1578g2 = null;
        InterfaceC1584m<PointF, PointF> interfaceC1584mM412b = null;
        C1573b c1573bM565r2 = null;
        C1573b c1573bM565r3 = null;
        C1576e c1576eM411a = null;
        C1575d c1575dM569s1 = null;
        C1573b c1573bM565r4 = null;
        C1573b c1573bM565r5 = null;
        while (abstractC1473c.mo607e()) {
            switch (abstractC1473c.mo615y(f2213a)) {
                case 0:
                    c1578g = c1578g2;
                    c1573b3 = c1573bM565r2;
                    interfaceC1584m = interfaceC1584mM412b;
                    abstractC1473c.mo604b();
                    while (abstractC1473c.mo607e()) {
                        if (abstractC1473c.mo615y(f2214b) != 0) {
                            abstractC1473c.mo600A();
                            abstractC1473c.mo601C();
                        } else {
                            c1576eM411a = C1454a.m411a(abstractC1473c, c1505d);
                        }
                    }
                    abstractC1473c.mo606d();
                    c1578g2 = c1578g;
                    interfaceC1584mM412b = interfaceC1584m;
                    c1573bM565r2 = c1573b3;
                    z4 = false;
                    break;
                case 1:
                    c1573b3 = c1573bM565r2;
                    interfaceC1584mM412b = C1454a.m412b(abstractC1473c, c1505d);
                    c1573bM565r2 = c1573b3;
                    z4 = false;
                    break;
                case 2:
                    c1573b3 = c1573bM565r2;
                    interfaceC1584m = interfaceC1584mM412b;
                    c1578g2 = new C1578g(C1460d.m553o1(abstractC1473c, c1505d, C1455a0.f2208a));
                    interfaceC1584mM412b = interfaceC1584m;
                    c1573bM565r2 = c1573b3;
                    z4 = false;
                    break;
                case 3:
                    c1505d.m669a("Lottie doesn't support 3D layers.");
                    c1573bM565r1 = C1460d.m565r1(abstractC1473c, c1505d, z4);
                    if (c1573bM565r1.f2738a.isEmpty()) {
                        c1573b4 = c1573bM565r1;
                        c1578g = c1578g2;
                        c1573b3 = c1573bM565r2;
                        interfaceC1584m = interfaceC1584mM412b;
                        c1573bM565r1.f2738a.add((C1501a<V>) new C1501a(c1505d, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(c1505d.f2347l)));
                    } else {
                        c1573b4 = c1573bM565r1;
                        c1578g = c1578g2;
                        c1573b3 = c1573bM565r2;
                        interfaceC1584m = interfaceC1584mM412b;
                        if (((C1501a) c1573b4.f2738a.get(0)).f2317b == 0) {
                            c1573b4.f2738a.set(0, (C1501a<V>) new C1501a(c1505d, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(c1505d.f2347l)));
                        }
                    }
                    c1573b5 = c1573b4;
                    c1578g2 = c1578g;
                    interfaceC1584mM412b = interfaceC1584m;
                    c1573bM565r2 = c1573b3;
                    z4 = false;
                    break;
                case 4:
                    c1573bM565r1 = C1460d.m565r1(abstractC1473c, c1505d, z4);
                    if (c1573bM565r1.f2738a.isEmpty()) {
                        c1573b4 = c1573bM565r1;
                        c1578g = c1578g2;
                        c1573b3 = c1573bM565r2;
                        interfaceC1584m = interfaceC1584mM412b;
                        c1573bM565r1.f2738a.add((C1501a<V>) new C1501a(c1505d, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(c1505d.f2347l)));
                    } else {
                        c1573b4 = c1573bM565r1;
                        c1578g = c1578g2;
                        c1573b3 = c1573bM565r2;
                        interfaceC1584m = interfaceC1584mM412b;
                        if (((C1501a) c1573b4.f2738a.get(0)).f2317b == 0) {
                            c1573b4.f2738a.set(0, (C1501a<V>) new C1501a(c1505d, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(c1505d.f2347l)));
                        }
                    }
                    c1573b5 = c1573b4;
                    c1578g2 = c1578g;
                    interfaceC1584mM412b = interfaceC1584m;
                    c1573bM565r2 = c1573b3;
                    z4 = false;
                    break;
                case 5:
                    c1575dM569s1 = C1460d.m569s1(abstractC1473c, c1505d);
                    break;
                case 6:
                    c1573bM565r4 = C1460d.m565r1(abstractC1473c, c1505d, z4);
                    break;
                case 7:
                    c1573bM565r5 = C1460d.m565r1(abstractC1473c, c1505d, z4);
                    break;
                case 8:
                    c1573bM565r3 = C1460d.m565r1(abstractC1473c, c1505d, z4);
                    break;
                case 9:
                    c1573bM565r2 = C1460d.m565r1(abstractC1473c, c1505d, z4);
                    break;
                default:
                    c1573b3 = c1573bM565r2;
                    abstractC1473c.mo600A();
                    abstractC1473c.mo601C();
                    c1573bM565r2 = c1573b3;
                    z4 = false;
                    break;
            }
        }
        C1578g c1578g3 = c1578g2;
        C1573b c1573b6 = c1573bM565r2;
        InterfaceC1584m<PointF, PointF> interfaceC1584m2 = interfaceC1584mM412b;
        if (z5) {
            abstractC1473c.mo606d();
        }
        if (c1576eM411a == null || (c1576eM411a.isStatic() && c1576eM411a.f2722a.get(0).f2317b.equals(0.0f, 0.0f))) {
            c1576eM411a = null;
        }
        if (interfaceC1584m2 == null || (!(interfaceC1584m2 instanceof C1580i) && interfaceC1584m2.isStatic() && interfaceC1584m2.mo774b().get(0).f2317b.equals(0.0f, 0.0f))) {
            interfaceC1584m2 = null;
        }
        C1573b c1573b7 = c1573b5 == null || (c1573b5.isStatic() && (((Float) ((C1501a) c1573b5.f2738a.get(0)).f2317b).floatValue() > 0.0f ? 1 : (((Float) ((C1501a) c1573b5.f2738a.get(0)).f2317b).floatValue() == 0.0f ? 0 : -1)) == 0) ? null : c1573b5;
        if (c1578g3 != 0) {
            if (c1578g3.isStatic()) {
                C1504d c1504d = (C1504d) ((C1501a) c1578g3.f2738a.get(0)).f2317b;
                z2 = (c1504d.f2334a > 1.0f ? 1 : (c1504d.f2334a == 1.0f ? 0 : -1)) == 0 && (c1504d.f2335b > 1.0f ? 1 : (c1504d.f2335b == 1.0f ? 0 : -1)) == 0;
            }
        }
        C1578g c1578g4 = z2 ? null : c1578g3;
        if (c1573bM565r3 == null || (c1573bM565r3.isStatic() && ((Float) ((C1501a) c1573bM565r3.f2738a.get(0)).f2317b).floatValue() == 0.0f)) {
            c1573bM565r3 = null;
        }
        if (c1573b6 != null) {
            c1573b = c1573b6;
            z3 = c1573b6.isStatic() && ((Float) ((C1501a) c1573b.f2738a.get(0)).f2317b).floatValue() == 0.0f;
            if (z3) {
                c1573b2 = null;
            } else {
                c1573b2 = c1573b;
            }
            return new C1583l(c1576eM411a, interfaceC1584m2, c1578g4, c1573b7, c1575dM569s1, c1573bM565r4, c1573bM565r5, c1573bM565r3, c1573b2);
        }
        c1573b = c1573b6;
        if (z3) {
            c1573b2 = null;
        } else {
            c1573b2 = c1573b;
        }
        return new C1583l(c1576eM411a, interfaceC1584m2, c1578g4, c1573b7, c1575dM569s1, c1573bM565r4, c1573bM565r5, c1573bM565r3, c1573b2);
    }
}
