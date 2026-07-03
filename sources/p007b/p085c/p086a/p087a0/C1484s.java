package p007b.p085c.p086a.p087a0;

import android.graphics.Color;
import java.io.IOException;
import java.util.ArrayList;
import p007b.p085c.p086a.C1505d;
import p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c;
import p007b.p085c.p086a.p089b0.C1495c;
import p007b.p085c.p086a.p089b0.C1499g;
import p007b.p085c.p086a.p090c0.C1501a;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p085c.p086a.p095y.p096k.C1572a;
import p007b.p085c.p086a.p095y.p096k.C1573b;
import p007b.p085c.p086a.p095y.p096k.C1575d;
import p007b.p085c.p086a.p095y.p096k.C1579h;
import p007b.p085c.p086a.p095y.p096k.C1581j;
import p007b.p085c.p086a.p095y.p096k.C1582k;
import p007b.p085c.p086a.p095y.p096k.C1583l;
import p007b.p085c.p086a.p095y.p097l.C1591f;
import p007b.p085c.p086a.p095y.p097l.InterfaceC1587b;
import p007b.p085c.p086a.p095y.p098m.C1606e;

/* JADX INFO: renamed from: b.c.a.a0.s */
/* JADX INFO: compiled from: LayerParser.java */
/* JADX INFO: loaded from: classes.dex */
public class C1484s {

    /* JADX INFO: renamed from: a */
    public static final AbstractC1473c.a f2280a = AbstractC1473c.a.m616a("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd");

    /* JADX INFO: renamed from: b */
    public static final AbstractC1473c.a f2281b = AbstractC1473c.a.m616a("d", "a");

    /* JADX INFO: renamed from: c */
    public static final AbstractC1473c.a f2282c = AbstractC1473c.a.m616a("nm");

    /* JADX WARN: Code duplicated, block: B:113:0x0254  */
    /* JADX WARN: Code duplicated, block: B:146:0x02af  */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0055. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX INFO: renamed from: a */
    public static C1606e m634a(AbstractC1473c abstractC1473c, C1505d c1505d) throws IOException {
        long j;
        byte b2;
        byte b3;
        String str;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        abstractC1473c.mo604b();
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        int i = 1;
        boolean z2 = false;
        long jMo610q = -1;
        float fMo609n = 0.0f;
        String strMo612t = null;
        C1606e.a aVar = null;
        String strMo612t2 = null;
        C1583l c1583lM414a = null;
        int iM659c = 0;
        int iM659c2 = 0;
        int color = 0;
        float fMo609n2 = 1.0f;
        float fMo609n3 = 0.0f;
        int iM659c3 = 0;
        int iM659c4 = 0;
        C1581j c1581j = null;
        C1582k c1582k = null;
        int i2 = 1;
        C1573b c1573bM565r1 = null;
        boolean zMo608f = false;
        long jMo610q2 = 0;
        String strMo612t3 = "UNSET";
        float fMo609n4 = 0.0f;
        while (abstractC1473c.mo607e()) {
            switch (abstractC1473c.mo615y(f2280a)) {
                case 0:
                    strMo612t = strMo612t;
                    strMo612t3 = abstractC1473c.mo612t();
                    strMo612t = strMo612t;
                    break;
                case 1:
                    strMo612t = strMo612t;
                    jMo610q2 = abstractC1473c.mo610q();
                    strMo612t = strMo612t;
                    break;
                case 2:
                    strMo612t = strMo612t;
                    strMo612t2 = abstractC1473c.mo612t();
                    strMo612t = strMo612t;
                    break;
                case 3:
                    strMo612t = strMo612t;
                    j = jMo610q2;
                    int iMo610q = abstractC1473c.mo610q();
                    aVar = iMo610q < 6 ? C1606e.a.values()[iMo610q] : C1606e.a.UNKNOWN;
                    jMo610q2 = j;
                    strMo612t = strMo612t;
                    break;
                case 4:
                    strMo612t = strMo612t;
                    j = jMo610q2;
                    jMo610q = abstractC1473c.mo610q();
                    jMo610q2 = j;
                    strMo612t = strMo612t;
                    break;
                case 5:
                    strMo612t = strMo612t;
                    iM659c = (int) (C1499g.m659c() * abstractC1473c.mo610q());
                    strMo612t = strMo612t;
                    break;
                case 6:
                    strMo612t = strMo612t;
                    iM659c2 = (int) (C1499g.m659c() * abstractC1473c.mo610q());
                    strMo612t = strMo612t;
                    break;
                case 7:
                    strMo612t = strMo612t;
                    color = Color.parseColor(abstractC1473c.mo612t());
                    strMo612t = strMo612t;
                    break;
                case 8:
                    strMo612t = strMo612t;
                    c1583lM414a = C1458c.m414a(abstractC1473c, c1505d);
                    strMo612t = strMo612t;
                    break;
                case 9:
                    strMo612t = strMo612t;
                    j = jMo610q2;
                    i2 = C1563b.com$airbnb$lottie$model$layer$Layer$MatteType$s$values()[abstractC1473c.mo610q()];
                    c1505d.f2350o++;
                    jMo610q2 = j;
                    strMo612t = strMo612t;
                    break;
                case 10:
                    strMo612t = strMo612t;
                    C1579h c1579h = null;
                    abstractC1473c.mo603a();
                    while (abstractC1473c.mo607e()) {
                        abstractC1473c.mo604b();
                        C1579h c1579h2 = c1579h;
                        C1575d c1575dM569s1 = c1579h2;
                        int i3 = 0;
                        boolean zMo608f2 = false;
                        while (abstractC1473c.mo607e()) {
                            String strMo611s = abstractC1473c.mo611s();
                            strMo611s.hashCode();
                            long j2 = jMo610q2;
                            int iHashCode = strMo611s.hashCode();
                            if (iHashCode != 111) {
                                if (iHashCode != 3588) {
                                    if (iHashCode != 104433) {
                                        if (iHashCode == 3357091 && strMo611s.equals("mode")) {
                                            b2 = 3;
                                        } else {
                                            b2 = -1;
                                        }
                                    } else if (strMo611s.equals("inv")) {
                                        b2 = 2;
                                    } else {
                                        b2 = -1;
                                    }
                                } else if (strMo611s.equals("pt")) {
                                    b2 = 1;
                                } else {
                                    b2 = -1;
                                }
                            } else if (strMo611s.equals("o")) {
                                b2 = 0;
                            } else {
                                b2 = -1;
                            }
                            if (b2 == 0) {
                                c1575dM569s1 = C1460d.m569s1(abstractC1473c, c1505d);
                            } else if (b2 == 1) {
                                c1579h2 = new C1579h(C1483r.m632a(abstractC1473c, c1505d, C1499g.m659c(), C1457b0.f2211a));
                            } else if (b2 == 2) {
                                zMo608f2 = abstractC1473c.mo608f();
                            } else if (b2 != 3) {
                                abstractC1473c.mo601C();
                            } else {
                                String strMo612t4 = abstractC1473c.mo612t();
                                strMo612t4.hashCode();
                                int iHashCode2 = strMo612t4.hashCode();
                                if (iHashCode2 != 97) {
                                    if (iHashCode2 != 105) {
                                        if (iHashCode2 != 110) {
                                            if (iHashCode2 == 115 && strMo612t4.equals("s")) {
                                                b3 = 3;
                                            } else {
                                                b3 = -1;
                                            }
                                        } else if (strMo612t4.equals("n")) {
                                            b3 = 2;
                                        } else {
                                            b3 = -1;
                                        }
                                    } else if (strMo612t4.equals("i")) {
                                        b3 = 1;
                                    } else {
                                        b3 = -1;
                                    }
                                } else if (strMo612t4.equals("a")) {
                                    b3 = 0;
                                } else {
                                    b3 = -1;
                                }
                                if (b3 != 0) {
                                    if (b3 == 1) {
                                        c1505d.m669a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                                        i3 = 3;
                                    } else if (b3 == 2) {
                                        i3 = 4;
                                    } else if (b3 != 3) {
                                        C1495c.m640b("Unknown mask mode " + strMo611s + ". Defaulting to Add.");
                                    } else {
                                        i3 = 2;
                                    }
                                }
                                i3 = 1;
                            }
                            jMo610q2 = j2;
                            c1575dM569s1 = c1575dM569s1;
                        }
                        abstractC1473c.mo606d();
                        arrayList.add(new C1591f(i3, c1579h2, c1575dM569s1, zMo608f2));
                        jMo610q2 = jMo610q2;
                        c1579h = null;
                    }
                    j = jMo610q2;
                    c1505d.f2350o += arrayList.size();
                    abstractC1473c.mo605c();
                    jMo610q2 = j;
                    strMo612t = strMo612t;
                    break;
                case 11:
                    abstractC1473c.mo603a();
                    while (abstractC1473c.mo607e()) {
                        InterfaceC1587b interfaceC1587bM599a = C1466g.m599a(abstractC1473c, c1505d);
                        if (interfaceC1587bM599a != null) {
                            arrayList2.add(interfaceC1587bM599a);
                        }
                    }
                    abstractC1473c.mo605c();
                    j = jMo610q2;
                    jMo610q2 = j;
                    strMo612t = strMo612t;
                    break;
                case 12:
                    abstractC1473c.mo604b();
                    while (abstractC1473c.mo607e()) {
                        int iMo615y = abstractC1473c.mo615y(f2281b);
                        if (iMo615y == 0) {
                            str = strMo612t;
                            c1581j = new C1581j(C1460d.m553o1(abstractC1473c, c1505d, C1468h.f2233a));
                        } else if (iMo615y != i) {
                            abstractC1473c.mo600A();
                            abstractC1473c.mo601C();
                        } else {
                            abstractC1473c.mo603a();
                            if (abstractC1473c.mo607e()) {
                                AbstractC1473c.a aVar2 = C1456b.f2209a;
                                abstractC1473c.mo604b();
                                C1582k c1582k2 = null;
                                while (abstractC1473c.mo607e()) {
                                    if (abstractC1473c.mo615y(C1456b.f2209a) != 0) {
                                        abstractC1473c.mo600A();
                                        abstractC1473c.mo601C();
                                    } else {
                                        abstractC1473c.mo604b();
                                        C1573b c1573bM561q1 = null;
                                        C1573b c1573bM561q2 = null;
                                        C1572a c1572aM557p1 = null;
                                        C1572a c1572aM557p2 = null;
                                        while (abstractC1473c.mo607e()) {
                                            int iMo615y2 = abstractC1473c.mo615y(C1456b.f2210b);
                                            if (iMo615y2 == 0) {
                                                c1572aM557p1 = C1460d.m557p1(abstractC1473c, c1505d);
                                            } else if (iMo615y2 == i) {
                                                c1572aM557p2 = C1460d.m557p1(abstractC1473c, c1505d);
                                            } else if (iMo615y2 == 2) {
                                                c1573bM561q1 = C1460d.m561q1(abstractC1473c, c1505d);
                                            } else if (iMo615y2 != 3) {
                                                abstractC1473c.mo600A();
                                                abstractC1473c.mo601C();
                                            } else {
                                                c1573bM561q2 = C1460d.m561q1(abstractC1473c, c1505d);
                                            }
                                            i = 1;
                                        }
                                        abstractC1473c.mo606d();
                                        c1582k2 = new C1582k(c1572aM557p1, c1572aM557p2, c1573bM561q1, c1573bM561q2);
                                        strMo612t = strMo612t;
                                        i = 1;
                                    }
                                }
                                str = strMo612t;
                                abstractC1473c.mo606d();
                                c1582k = c1582k2 == null ? new C1582k(null, null, null, null) : c1582k2;
                            } else {
                                str = strMo612t;
                            }
                            while (abstractC1473c.mo607e()) {
                                abstractC1473c.mo601C();
                            }
                            abstractC1473c.mo605c();
                        }
                        strMo612t = str;
                        i = 1;
                    }
                    strMo612t = strMo612t;
                    abstractC1473c.mo606d();
                    strMo612t = strMo612t;
                    break;
                case 13:
                    abstractC1473c.mo603a();
                    ArrayList arrayList3 = new ArrayList();
                    while (abstractC1473c.mo607e()) {
                        abstractC1473c.mo604b();
                        while (abstractC1473c.mo607e()) {
                            if (abstractC1473c.mo615y(f2282c) != 0) {
                                abstractC1473c.mo600A();
                                abstractC1473c.mo601C();
                            } else {
                                arrayList3.add(abstractC1473c.mo612t());
                            }
                        }
                        abstractC1473c.mo606d();
                    }
                    abstractC1473c.mo605c();
                    c1505d.m669a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList3);
                    j = jMo610q2;
                    jMo610q2 = j;
                    strMo612t = strMo612t;
                    break;
                case 14:
                    fMo609n2 = (float) abstractC1473c.mo609n();
                    strMo612t = strMo612t;
                    strMo612t = strMo612t;
                    break;
                case 15:
                    fMo609n3 = (float) abstractC1473c.mo609n();
                    strMo612t = strMo612t;
                    strMo612t = strMo612t;
                    break;
                case 16:
                    iM659c3 = (int) (C1499g.m659c() * abstractC1473c.mo610q());
                    strMo612t = strMo612t;
                    strMo612t = strMo612t;
                    break;
                case 17:
                    iM659c4 = (int) (C1499g.m659c() * abstractC1473c.mo610q());
                    strMo612t = strMo612t;
                    strMo612t = strMo612t;
                    break;
                case 18:
                    fMo609n = (float) abstractC1473c.mo609n();
                    strMo612t = strMo612t;
                    strMo612t = strMo612t;
                    break;
                case 19:
                    fMo609n4 = (float) abstractC1473c.mo609n();
                    break;
                case 20:
                    c1573bM565r1 = C1460d.m565r1(abstractC1473c, c1505d, z2);
                    break;
                case 21:
                    strMo612t = abstractC1473c.mo612t();
                    break;
                case 22:
                    zMo608f = abstractC1473c.mo608f();
                    break;
                default:
                    strMo612t = strMo612t;
                    j = jMo610q2;
                    abstractC1473c.mo600A();
                    abstractC1473c.mo601C();
                    jMo610q2 = j;
                    strMo612t = strMo612t;
                    break;
            }
            i = 1;
            z2 = false;
        }
        String str2 = strMo612t;
        long j3 = jMo610q2;
        abstractC1473c.mo606d();
        float f = fMo609n / fMo609n2;
        float f2 = fMo609n4 / fMo609n2;
        ArrayList arrayList4 = new ArrayList();
        if (f > 0.0f) {
            arrayList4.add(new C1501a(c1505d, fValueOf2, fValueOf2, null, 0.0f, Float.valueOf(f)));
        }
        if (f2 <= 0.0f) {
            f2 = c1505d.f2347l;
        }
        arrayList4.add(new C1501a(c1505d, fValueOf, fValueOf, null, f, Float.valueOf(f2)));
        arrayList4.add(new C1501a(c1505d, fValueOf2, fValueOf2, null, f2, Float.valueOf(Float.MAX_VALUE)));
        if (strMo612t3.endsWith(".ai") || "ai".equals(str2)) {
            c1505d.m669a("Convert your Illustrator layers to shape layers.");
        }
        return new C1606e(arrayList2, c1505d, strMo612t3, j3, aVar, jMo610q, strMo612t2, arrayList, c1583lM414a, iM659c, iM659c2, color, fMo609n2, fMo609n3, iM659c3, iM659c4, c1581j, c1582k, arrayList4, i2, c1573bM565r1, zMo608f);
    }
}
