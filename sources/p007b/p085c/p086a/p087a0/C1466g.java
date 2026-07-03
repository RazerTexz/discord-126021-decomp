package p007b.p085c.p086a.p087a0;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.ArrayList;
import p007b.p085c.p086a.C1505d;
import p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c;
import p007b.p085c.p086a.p089b0.C1495c;
import p007b.p085c.p086a.p089b0.C1499g;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p085c.p086a.p095y.p096k.C1572a;
import p007b.p085c.p086a.p095y.p096k.C1573b;
import p007b.p085c.p086a.p095y.p096k.C1574c;
import p007b.p085c.p086a.p095y.p096k.C1575d;
import p007b.p085c.p086a.p095y.p096k.C1577f;
import p007b.p085c.p086a.p095y.p096k.C1579h;
import p007b.p085c.p086a.p095y.p096k.C1583l;
import p007b.p085c.p086a.p095y.p096k.InterfaceC1584m;
import p007b.p085c.p086a.p095y.p097l.C1586a;
import p007b.p085c.p086a.p095y.p097l.C1589d;
import p007b.p085c.p086a.p095y.p097l.C1590e;
import p007b.p085c.p086a.p095y.p097l.C1592g;
import p007b.p085c.p086a.p095y.p097l.C1593h;
import p007b.p085c.p086a.p095y.p097l.C1594i;
import p007b.p085c.p086a.p095y.p097l.C1595j;
import p007b.p085c.p086a.p095y.p097l.C1597l;
import p007b.p085c.p086a.p095y.p097l.C1598m;
import p007b.p085c.p086a.p095y.p097l.C1599n;
import p007b.p085c.p086a.p095y.p097l.C1600o;
import p007b.p085c.p086a.p095y.p097l.C1601p;
import p007b.p085c.p086a.p095y.p097l.InterfaceC1587b;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.c.a.a0.g */
/* JADX INFO: compiled from: ContentModelParser.java */
/* JADX INFO: loaded from: classes.dex */
public class C1466g {

    /* JADX INFO: renamed from: a */
    public static AbstractC1473c.a f2231a = AbstractC1473c.a.m616a("ty", "d");

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:133:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:388:0x069f A[LOOP:1: B:386:0x0699->B:388:0x069f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:69:0x00e3  */
    @Nullable
    /* JADX INFO: renamed from: a */
    public static InterfaceC1587b m599a(AbstractC1473c abstractC1473c, C1505d c1505d) throws IOException {
        String strMo612t;
        String strMo612t2;
        InterfaceC1587b c1586a;
        InterfaceC1587b c1598m;
        String strMo612t3;
        String strMo612t4;
        byte b2;
        abstractC1473c.mo604b();
        int iMo610q = 2;
        while (true) {
            strMo612t = null;
            c1586a = null;
            strMo612t4 = null;
            strMo612t3 = null;
            if (!abstractC1473c.mo607e()) {
                strMo612t2 = null;
                break;
            }
            int iMo615y = abstractC1473c.mo615y(f2231a);
            if (iMo615y == 0) {
                strMo612t2 = abstractC1473c.mo612t();
                break;
            }
            if (iMo615y != 1) {
                abstractC1473c.mo600A();
                abstractC1473c.mo601C();
            } else {
                iMo610q = abstractC1473c.mo610q();
            }
        }
        if (strMo612t2 == null) {
            return null;
        }
        boolean zMo608f = false;
        int iMo610q2 = 0;
        boolean zMo608f2 = false;
        switch (strMo612t2) {
            case "el":
                AbstractC1473c.a aVar = C1462e.f2226a;
                boolean z2 = iMo610q == 3;
                String strMo612t5 = null;
                InterfaceC1584m<PointF, PointF> interfaceC1584mM412b = null;
                C1577f c1577fM577u1 = null;
                boolean zMo608f3 = false;
                while (abstractC1473c.mo607e()) {
                    int iMo615y2 = abstractC1473c.mo615y(C1462e.f2226a);
                    if (iMo615y2 == 0) {
                        strMo612t5 = abstractC1473c.mo612t();
                    } else if (iMo615y2 == 1) {
                        interfaceC1584mM412b = C1454a.m412b(abstractC1473c, c1505d);
                    } else if (iMo615y2 == 2) {
                        c1577fM577u1 = C1460d.m577u1(abstractC1473c, c1505d);
                    } else if (iMo615y2 == 3) {
                        zMo608f3 = abstractC1473c.mo608f();
                    } else if (iMo615y2 != 4) {
                        abstractC1473c.mo600A();
                        abstractC1473c.mo601C();
                    } else {
                        z2 = abstractC1473c.mo610q() == 3;
                    }
                }
                c1586a = new C1586a(strMo612t5, interfaceC1584mM412b, c1577fM577u1, z2, zMo608f3);
                while (abstractC1473c.mo607e()) {
                    abstractC1473c.mo601C();
                }
                abstractC1473c.mo606d();
                return c1586a;
            case "fl":
                AbstractC1473c.a aVar2 = C1459c0.f2215a;
                int iMo610q3 = 1;
                String strMo612t6 = null;
                C1572a c1572aM557p1 = null;
                C1575d c1575dM569s1 = null;
                boolean zMo608f4 = false;
                boolean zMo608f5 = false;
                while (abstractC1473c.mo607e()) {
                    int iMo615y3 = abstractC1473c.mo615y(C1459c0.f2215a);
                    if (iMo615y3 == 0) {
                        strMo612t6 = abstractC1473c.mo612t();
                    } else if (iMo615y3 == 1) {
                        c1572aM557p1 = C1460d.m557p1(abstractC1473c, c1505d);
                    } else if (iMo615y3 == 2) {
                        c1575dM569s1 = C1460d.m569s1(abstractC1473c, c1505d);
                    } else if (iMo615y3 == 3) {
                        zMo608f4 = abstractC1473c.mo608f();
                    } else if (iMo615y3 == 4) {
                        iMo610q3 = abstractC1473c.mo610q();
                    } else if (iMo615y3 != 5) {
                        abstractC1473c.mo600A();
                        abstractC1473c.mo601C();
                    } else {
                        zMo608f5 = abstractC1473c.mo608f();
                    }
                }
                c1586a = new C1597l(strMo612t6, zMo608f4, iMo610q3 == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, c1572aM557p1, c1575dM569s1, zMo608f5);
                while (abstractC1473c.mo607e()) {
                    abstractC1473c.mo601C();
                }
                abstractC1473c.mo606d();
                return c1586a;
            case "gf":
                AbstractC1473c.a aVar3 = C1478m.f2269a;
                Path.FillType fillType = Path.FillType.WINDING;
                String strMo612t7 = null;
                C1574c c1574c = null;
                C1575d c1575dM569s2 = null;
                C1577f c1577fM577u2 = null;
                C1577f c1577fM577u3 = null;
                int i = 0;
                boolean zMo608f6 = false;
                while (abstractC1473c.mo607e()) {
                    switch (abstractC1473c.mo615y(C1478m.f2269a)) {
                        case 0:
                            strMo612t7 = abstractC1473c.mo612t();
                            break;
                        case 1:
                            abstractC1473c.mo604b();
                            int iMo610q4 = -1;
                            while (abstractC1473c.mo607e()) {
                                int iMo615y4 = abstractC1473c.mo615y(C1478m.f2270b);
                                if (iMo615y4 == 0) {
                                    iMo610q4 = abstractC1473c.mo610q();
                                } else if (iMo615y4 != 1) {
                                    abstractC1473c.mo600A();
                                    abstractC1473c.mo601C();
                                } else {
                                    c1574c = new C1574c(C1460d.m553o1(abstractC1473c, c1505d, new C1477l(iMo610q4)));
                                }
                            }
                            abstractC1473c.mo606d();
                            break;
                        case 2:
                            c1575dM569s2 = C1460d.m569s1(abstractC1473c, c1505d);
                            break;
                        case 3:
                            i = abstractC1473c.mo610q() != 1 ? 2 : 1;
                            break;
                        case 4:
                            c1577fM577u2 = C1460d.m577u1(abstractC1473c, c1505d);
                            break;
                        case 5:
                            c1577fM577u3 = C1460d.m577u1(abstractC1473c, c1505d);
                            break;
                        case 6:
                            fillType = abstractC1473c.mo610q() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                            break;
                        case 7:
                            zMo608f6 = abstractC1473c.mo608f();
                            break;
                        default:
                            abstractC1473c.mo600A();
                            abstractC1473c.mo601C();
                            break;
                    }
                }
                c1586a = new C1589d(strMo612t7, i, fillType, c1574c, c1575dM569s2, c1577fM577u2, c1577fM577u3, null, null, zMo608f6);
                while (abstractC1473c.mo607e()) {
                    abstractC1473c.mo601C();
                }
                abstractC1473c.mo606d();
                return c1586a;
            case "gr":
                AbstractC1473c.a aVar4 = C1461d0.f2225a;
                ArrayList arrayList = new ArrayList();
                while (abstractC1473c.mo607e()) {
                    int iMo615y5 = abstractC1473c.mo615y(C1461d0.f2225a);
                    if (iMo615y5 == 0) {
                        strMo612t = abstractC1473c.mo612t();
                    } else if (iMo615y5 == 1) {
                        zMo608f = abstractC1473c.mo608f();
                    } else if (iMo615y5 != 2) {
                        abstractC1473c.mo601C();
                    } else {
                        abstractC1473c.mo603a();
                        while (abstractC1473c.mo607e()) {
                            InterfaceC1587b interfaceC1587bM599a = m599a(abstractC1473c, c1505d);
                            if (interfaceC1587bM599a != null) {
                                arrayList.add(interfaceC1587bM599a);
                            }
                        }
                        abstractC1473c.mo605c();
                    }
                }
                c1598m = new C1598m(strMo612t, arrayList, zMo608f);
                c1586a = c1598m;
                while (abstractC1473c.mo607e()) {
                    abstractC1473c.mo601C();
                }
                abstractC1473c.mo606d();
                return c1586a;
            case "gs":
                AbstractC1473c.a aVar5 = C1479n.f2271a;
                ArrayList arrayList2 = new ArrayList();
                String strMo612t8 = null;
                C1574c c1574c2 = null;
                C1575d c1575dM569s3 = null;
                C1577f c1577fM577u4 = null;
                C1577f c1577fM577u5 = null;
                C1573b c1573bM561q1 = null;
                C1573b c1573b = null;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                float fMo609n = 0.0f;
                boolean zMo608f7 = false;
                while (abstractC1473c.mo607e()) {
                    switch (abstractC1473c.mo615y(C1479n.f2271a)) {
                        case 0:
                            strMo612t8 = abstractC1473c.mo612t();
                            break;
                        case 1:
                            abstractC1473c.mo604b();
                            int iMo610q5 = -1;
                            while (abstractC1473c.mo607e()) {
                                int iMo615y6 = abstractC1473c.mo615y(C1479n.f2272b);
                                if (iMo615y6 == 0) {
                                    iMo610q5 = abstractC1473c.mo610q();
                                } else if (iMo615y6 != 1) {
                                    abstractC1473c.mo600A();
                                    abstractC1473c.mo601C();
                                } else {
                                    c1574c2 = new C1574c(C1460d.m553o1(abstractC1473c, c1505d, new C1477l(iMo610q5)));
                                }
                            }
                            abstractC1473c.mo606d();
                            break;
                        case 2:
                            c1575dM569s3 = C1460d.m569s1(abstractC1473c, c1505d);
                            break;
                        case 3:
                            i2 = abstractC1473c.mo610q() != 1 ? 2 : 1;
                            break;
                        case 4:
                            c1577fM577u4 = C1460d.m577u1(abstractC1473c, c1505d);
                            break;
                        case 5:
                            c1577fM577u5 = C1460d.m577u1(abstractC1473c, c1505d);
                            break;
                        case 6:
                            c1573bM561q1 = C1460d.m561q1(abstractC1473c, c1505d);
                            break;
                        case 7:
                            i3 = C1563b.com$airbnb$lottie$model$content$ShapeStroke$LineCapType$s$values()[abstractC1473c.mo610q() - 1];
                            break;
                        case 8:
                            i4 = C1563b.m753x4b958c1e()[abstractC1473c.mo610q() - 1];
                            break;
                        case 9:
                            fMo609n = (float) abstractC1473c.mo609n();
                            break;
                        case 10:
                            zMo608f7 = abstractC1473c.mo608f();
                            break;
                        case 11:
                            abstractC1473c.mo603a();
                            while (abstractC1473c.mo607e()) {
                                abstractC1473c.mo604b();
                                C1573b c1573bM561q2 = null;
                                String strMo612t9 = null;
                                while (abstractC1473c.mo607e()) {
                                    int iMo615y7 = abstractC1473c.mo615y(C1479n.f2273c);
                                    if (iMo615y7 == 0) {
                                        strMo612t9 = abstractC1473c.mo612t();
                                    } else if (iMo615y7 != 1) {
                                        abstractC1473c.mo600A();
                                        abstractC1473c.mo601C();
                                    } else {
                                        c1573bM561q2 = C1460d.m561q1(abstractC1473c, c1505d);
                                    }
                                }
                                abstractC1473c.mo606d();
                                if (strMo612t9.equals("o")) {
                                    c1573b = c1573bM561q2;
                                } else if (strMo612t9.equals("d") || strMo612t9.equals("g")) {
                                    c1505d.f2349n = true;
                                    arrayList2.add(c1573bM561q2);
                                }
                            }
                            abstractC1473c.mo605c();
                            if (arrayList2.size() == 1) {
                                arrayList2.add(arrayList2.get(0));
                            }
                            break;
                        default:
                            abstractC1473c.mo600A();
                            abstractC1473c.mo601C();
                            break;
                    }
                }
                c1586a = new C1590e(strMo612t8, i2, c1574c2, c1575dM569s3, c1577fM577u4, c1577fM577u5, c1573bM561q1, i3, i4, fMo609n, arrayList2, c1573b, zMo608f7);
                while (abstractC1473c.mo607e()) {
                    abstractC1473c.mo601C();
                }
                abstractC1473c.mo606d();
                return c1586a;
            case "mm":
                AbstractC1473c.a aVar6 = C1486u.f2287a;
                C1592g.a aVar7 = null;
                while (abstractC1473c.mo607e()) {
                    int iMo615y8 = abstractC1473c.mo615y(C1486u.f2287a);
                    if (iMo615y8 == 0) {
                        strMo612t3 = abstractC1473c.mo612t();
                    } else if (iMo615y8 == 1) {
                        int iMo610q6 = abstractC1473c.mo610q();
                        C1592g.a aVar8 = C1592g.a.MERGE;
                        if (iMo610q6 != 1) {
                            if (iMo610q6 == 2) {
                                aVar7 = C1592g.a.ADD;
                            } else if (iMo610q6 == 3) {
                                aVar7 = C1592g.a.SUBTRACT;
                            } else if (iMo610q6 == 4) {
                                aVar7 = C1592g.a.INTERSECT;
                            } else if (iMo610q6 == 5) {
                                aVar7 = C1592g.a.EXCLUDE_INTERSECTIONS;
                            }
                        }
                        aVar7 = aVar8;
                    } else if (iMo615y8 != 2) {
                        abstractC1473c.mo600A();
                        abstractC1473c.mo601C();
                    } else {
                        zMo608f2 = abstractC1473c.mo608f();
                    }
                }
                C1592g c1592g = new C1592g(strMo612t3, aVar7, zMo608f2);
                c1505d.m669a("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                c1586a = c1592g;
                while (abstractC1473c.mo607e()) {
                    abstractC1473c.mo601C();
                }
                abstractC1473c.mo606d();
                return c1586a;
            case "rc":
                AbstractC1473c.a aVar9 = C1490y.f2291a;
                String strMo612t10 = null;
                InterfaceC1584m<PointF, PointF> interfaceC1584mM412b2 = null;
                C1577f c1577fM577u6 = null;
                C1573b c1573bM561q3 = null;
                boolean zMo608f8 = false;
                while (abstractC1473c.mo607e()) {
                    int iMo615y9 = abstractC1473c.mo615y(C1490y.f2291a);
                    if (iMo615y9 == 0) {
                        strMo612t10 = abstractC1473c.mo612t();
                    } else if (iMo615y9 == 1) {
                        interfaceC1584mM412b2 = C1454a.m412b(abstractC1473c, c1505d);
                    } else if (iMo615y9 == 2) {
                        c1577fM577u6 = C1460d.m577u1(abstractC1473c, c1505d);
                    } else if (iMo615y9 == 3) {
                        c1573bM561q3 = C1460d.m561q1(abstractC1473c, c1505d);
                    } else if (iMo615y9 != 4) {
                        abstractC1473c.mo601C();
                    } else {
                        zMo608f8 = abstractC1473c.mo608f();
                    }
                }
                c1586a = new C1594i(strMo612t10, interfaceC1584mM412b2, c1577fM577u6, c1573bM561q3, zMo608f8);
                while (abstractC1473c.mo607e()) {
                    abstractC1473c.mo601C();
                }
                abstractC1473c.mo606d();
                return c1586a;
            case "rp":
                AbstractC1473c.a aVar10 = C1491z.f2292a;
                String strMo612t11 = null;
                C1573b c1573bM565r1 = null;
                C1573b c1573bM565r2 = null;
                C1583l c1583lM414a = null;
                boolean zMo608f9 = false;
                while (abstractC1473c.mo607e()) {
                    int iMo615y10 = abstractC1473c.mo615y(C1491z.f2292a);
                    if (iMo615y10 == 0) {
                        strMo612t11 = abstractC1473c.mo612t();
                    } else if (iMo615y10 == 1) {
                        c1573bM565r1 = C1460d.m565r1(abstractC1473c, c1505d, false);
                    } else if (iMo615y10 == 2) {
                        c1573bM565r2 = C1460d.m565r1(abstractC1473c, c1505d, false);
                    } else if (iMo615y10 == 3) {
                        c1583lM414a = C1458c.m414a(abstractC1473c, c1505d);
                    } else if (iMo615y10 != 4) {
                        abstractC1473c.mo601C();
                    } else {
                        zMo608f9 = abstractC1473c.mo608f();
                    }
                }
                c1586a = new C1595j(strMo612t11, c1573bM565r1, c1573bM565r2, c1583lM414a, zMo608f9);
                while (abstractC1473c.mo607e()) {
                    abstractC1473c.mo601C();
                }
                abstractC1473c.mo606d();
                return c1586a;
            case "sh":
                AbstractC1473c.a aVar11 = C1463e0.f2227a;
                boolean zMo608f10 = false;
                C1579h c1579h = null;
                while (abstractC1473c.mo607e()) {
                    int iMo615y11 = abstractC1473c.mo615y(C1463e0.f2227a);
                    if (iMo615y11 == 0) {
                        strMo612t4 = abstractC1473c.mo612t();
                    } else if (iMo615y11 == 1) {
                        iMo610q2 = abstractC1473c.mo610q();
                    } else if (iMo615y11 == 2) {
                        c1579h = new C1579h(C1483r.m632a(abstractC1473c, c1505d, C1499g.m659c(), C1457b0.f2211a));
                    } else if (iMo615y11 != 3) {
                        abstractC1473c.mo601C();
                    } else {
                        zMo608f10 = abstractC1473c.mo608f();
                    }
                }
                c1598m = new C1599n(strMo612t4, iMo610q2, c1579h, zMo608f10);
                c1586a = c1598m;
                while (abstractC1473c.mo607e()) {
                    abstractC1473c.mo601C();
                }
                abstractC1473c.mo606d();
                return c1586a;
            case "sr":
                AbstractC1473c.a aVar12 = C1489x.f2290a;
                String strMo612t12 = null;
                C1593h.a aVarM776f = null;
                C1573b c1573bM565r3 = null;
                InterfaceC1584m<PointF, PointF> interfaceC1584mM412b3 = null;
                C1573b c1573bM565r4 = null;
                C1573b c1573bM561q4 = null;
                C1573b c1573bM561q5 = null;
                C1573b c1573bM565r5 = null;
                C1573b c1573bM565r6 = null;
                boolean zMo608f11 = false;
                while (abstractC1473c.mo607e()) {
                    switch (abstractC1473c.mo615y(C1489x.f2290a)) {
                        case 0:
                            strMo612t12 = abstractC1473c.mo612t();
                            break;
                        case 1:
                            aVarM776f = C1593h.a.m776f(abstractC1473c.mo610q());
                            break;
                        case 2:
                            c1573bM565r3 = C1460d.m565r1(abstractC1473c, c1505d, false);
                            break;
                        case 3:
                            interfaceC1584mM412b3 = C1454a.m412b(abstractC1473c, c1505d);
                            break;
                        case 4:
                            c1573bM565r4 = C1460d.m565r1(abstractC1473c, c1505d, false);
                            break;
                        case 5:
                            c1573bM561q5 = C1460d.m561q1(abstractC1473c, c1505d);
                            break;
                        case 6:
                            c1573bM565r6 = C1460d.m565r1(abstractC1473c, c1505d, false);
                            break;
                        case 7:
                            c1573bM561q4 = C1460d.m561q1(abstractC1473c, c1505d);
                            break;
                        case 8:
                            c1573bM565r5 = C1460d.m565r1(abstractC1473c, c1505d, false);
                            break;
                        case 9:
                            zMo608f11 = abstractC1473c.mo608f();
                            break;
                        default:
                            abstractC1473c.mo600A();
                            abstractC1473c.mo601C();
                            break;
                    }
                }
                c1598m = new C1593h(strMo612t12, aVarM776f, c1573bM565r3, interfaceC1584mM412b3, c1573bM565r4, c1573bM561q4, c1573bM561q5, c1573bM565r5, c1573bM565r6, zMo608f11);
                c1586a = c1598m;
                while (abstractC1473c.mo607e()) {
                    abstractC1473c.mo601C();
                }
                abstractC1473c.mo606d();
                return c1586a;
            case "st":
                AbstractC1473c.a aVar13 = C1465f0.f2229a;
                ArrayList arrayList3 = new ArrayList();
                String strMo612t13 = null;
                C1573b c1573b2 = null;
                C1572a c1572aM557p2 = null;
                C1575d c1575dM569s4 = null;
                C1573b c1573bM561q6 = null;
                int i5 = 0;
                int i6 = 0;
                float fMo609n2 = 0.0f;
                boolean zMo608f12 = false;
                while (abstractC1473c.mo607e()) {
                    switch (abstractC1473c.mo615y(C1465f0.f2229a)) {
                        case 0:
                            strMo612t13 = abstractC1473c.mo612t();
                            break;
                        case 1:
                            c1572aM557p2 = C1460d.m557p1(abstractC1473c, c1505d);
                            break;
                        case 2:
                            c1573bM561q6 = C1460d.m561q1(abstractC1473c, c1505d);
                            break;
                        case 3:
                            c1575dM569s4 = C1460d.m569s1(abstractC1473c, c1505d);
                            break;
                        case 4:
                            i5 = C1563b.com$airbnb$lottie$model$content$ShapeStroke$LineCapType$s$values()[abstractC1473c.mo610q() - 1];
                            break;
                        case 5:
                            i6 = C1563b.m753x4b958c1e()[abstractC1473c.mo610q() - 1];
                            break;
                        case 6:
                            fMo609n2 = (float) abstractC1473c.mo609n();
                            break;
                        case 7:
                            zMo608f12 = abstractC1473c.mo608f();
                            break;
                        case 8:
                            abstractC1473c.mo603a();
                            while (abstractC1473c.mo607e()) {
                                abstractC1473c.mo604b();
                                C1573b c1573bM561q7 = null;
                                String strMo612t14 = null;
                                while (abstractC1473c.mo607e()) {
                                    int iMo615y12 = abstractC1473c.mo615y(C1465f0.f2230b);
                                    if (iMo615y12 == 0) {
                                        strMo612t14 = abstractC1473c.mo612t();
                                    } else if (iMo615y12 != 1) {
                                        abstractC1473c.mo600A();
                                        abstractC1473c.mo601C();
                                    } else {
                                        c1573bM561q7 = C1460d.m561q1(abstractC1473c, c1505d);
                                    }
                                }
                                abstractC1473c.mo606d();
                                strMo612t14.hashCode();
                                int iHashCode = strMo612t14.hashCode();
                                if (iHashCode != 100) {
                                    if (iHashCode != 103) {
                                        if (iHashCode == 111 && strMo612t14.equals("o")) {
                                            b2 = 2;
                                        } else {
                                            b2 = -1;
                                        }
                                    } else if (strMo612t14.equals("g")) {
                                        b2 = 1;
                                    } else {
                                        b2 = -1;
                                    }
                                } else if (strMo612t14.equals("d")) {
                                    b2 = 0;
                                } else {
                                    b2 = -1;
                                }
                                if (b2 == 0 || b2 == 1) {
                                    c1505d.f2349n = true;
                                    arrayList3.add(c1573bM561q7);
                                } else if (b2 == 2) {
                                    c1573b2 = c1573bM561q7;
                                }
                            }
                            abstractC1473c.mo605c();
                            if (arrayList3.size() == 1) {
                                arrayList3.add(arrayList3.get(0));
                            }
                            break;
                        default:
                            abstractC1473c.mo601C();
                            break;
                    }
                }
                c1586a = new C1600o(strMo612t13, c1573b2, arrayList3, c1572aM557p2, c1575dM569s4, c1573bM561q6, i5, i6, fMo609n2, zMo608f12);
                while (abstractC1473c.mo607e()) {
                    abstractC1473c.mo601C();
                }
                abstractC1473c.mo606d();
                return c1586a;
            case "tm":
                AbstractC1473c.a aVar14 = C1467g0.f2232a;
                String strMo612t15 = null;
                C1573b c1573bM565r7 = null;
                C1573b c1573bM565r8 = null;
                C1573b c1573bM565r9 = null;
                int i7 = 0;
                boolean zMo608f13 = false;
                while (abstractC1473c.mo607e()) {
                    int iMo615y13 = abstractC1473c.mo615y(C1467g0.f2232a);
                    if (iMo615y13 == 0) {
                        c1573bM565r7 = C1460d.m565r1(abstractC1473c, c1505d, false);
                    } else if (iMo615y13 == 1) {
                        c1573bM565r8 = C1460d.m565r1(abstractC1473c, c1505d, false);
                    } else if (iMo615y13 == 2) {
                        c1573bM565r9 = C1460d.m565r1(abstractC1473c, c1505d, false);
                    } else if (iMo615y13 == 3) {
                        strMo612t15 = abstractC1473c.mo612t();
                    } else if (iMo615y13 == 4) {
                        int iMo610q7 = abstractC1473c.mo610q();
                        if (iMo610q7 == 1) {
                            i7 = 1;
                        } else {
                            if (iMo610q7 != 2) {
                                throw new IllegalArgumentException(C1643a.m871q("Unknown trim path type ", iMo610q7));
                            }
                            i7 = 2;
                        }
                    } else if (iMo615y13 != 5) {
                        abstractC1473c.mo601C();
                    } else {
                        zMo608f13 = abstractC1473c.mo608f();
                    }
                }
                c1586a = new C1601p(strMo612t15, i7, c1573bM565r7, c1573bM565r8, c1573bM565r9, zMo608f13);
                while (abstractC1473c.mo607e()) {
                    abstractC1473c.mo601C();
                }
                abstractC1473c.mo606d();
                return c1586a;
            case "tr":
                c1586a = C1458c.m414a(abstractC1473c, c1505d);
                while (abstractC1473c.mo607e()) {
                    abstractC1473c.mo601C();
                }
                abstractC1473c.mo606d();
                return c1586a;
            default:
                C1495c.m640b("Unknown shape type " + strMo612t2);
                while (abstractC1473c.mo607e()) {
                    abstractC1473c.mo601C();
                }
                abstractC1473c.mo606d();
                return c1586a;
        }
    }
}
