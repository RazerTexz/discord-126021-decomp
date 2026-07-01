package b.c.a.a0;

import android.graphics.Color;
import b.c.a.a0.i0.c$a;
import b.c.a.y.m.e$a;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: LayerParser.java */
/* JADX INFO: loaded from: classes.dex */
public class s {
    public static final c$a a = c$a.a("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c$a f342b = c$a.a("d", "a");
    public static final c$a c = c$a.a("nm");

    /* JADX WARN: Code duplicated, block: B:113:0x0254  */
    /* JADX WARN: Code duplicated, block: B:146:0x02af  */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0055. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v11 */
    public static b.c.a.y.m.e a(b.c.a.a0.i0.c cVar, b.c.a.d dVar) throws IOException {
        long j;
        byte b2;
        byte b3;
        String str;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        cVar.b();
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        int i = 1;
        boolean z2 = false;
        long jQ = -1;
        float fN = 0.0f;
        String strT = null;
        e$a e_a = null;
        String strT2 = null;
        b.c.a.y.k.l lVarA = null;
        int iC = 0;
        int iC2 = 0;
        int color = 0;
        float fN2 = 1.0f;
        float fN3 = 0.0f;
        int iC3 = 0;
        int iC4 = 0;
        b.c.a.y.k.j jVar = null;
        b.c.a.y.k.k kVar = null;
        int i2 = 1;
        b.c.a.y.k.b bVarR1 = null;
        boolean zF = false;
        long jQ2 = 0;
        String strT3 = "UNSET";
        float fN4 = 0.0f;
        while (cVar.e()) {
            switch (cVar.y(a)) {
                case 0:
                    strT = strT;
                    strT3 = cVar.t();
                    strT = strT;
                    break;
                case 1:
                    strT = strT;
                    jQ2 = cVar.q();
                    strT = strT;
                    break;
                case 2:
                    strT = strT;
                    strT2 = cVar.t();
                    strT = strT;
                    break;
                case 3:
                    strT = strT;
                    j = jQ2;
                    int iQ = cVar.q();
                    e_a = iQ < 6 ? e$a.values()[iQ] : e$a.UNKNOWN;
                    jQ2 = j;
                    strT = strT;
                    break;
                case 4:
                    strT = strT;
                    j = jQ2;
                    jQ = cVar.q();
                    jQ2 = j;
                    strT = strT;
                    break;
                case 5:
                    strT = strT;
                    iC = (int) (b.c.a.b0.g.c() * cVar.q());
                    strT = strT;
                    break;
                case 6:
                    strT = strT;
                    iC2 = (int) (b.c.a.b0.g.c() * cVar.q());
                    strT = strT;
                    break;
                case 7:
                    strT = strT;
                    color = Color.parseColor(cVar.t());
                    strT = strT;
                    break;
                case 8:
                    strT = strT;
                    lVarA = c.a(cVar, dVar);
                    strT = strT;
                    break;
                case 9:
                    strT = strT;
                    j = jQ2;
                    i2 = b.c.a.y.b.com$airbnb$lottie$model$layer$Layer$MatteType$s$values()[cVar.q()];
                    dVar.o++;
                    jQ2 = j;
                    strT = strT;
                    break;
                case 10:
                    strT = strT;
                    b.c.a.y.k.h hVar = null;
                    cVar.a();
                    while (cVar.e()) {
                        cVar.b();
                        b.c.a.y.k.h hVar2 = hVar;
                        b.c.a.y.k.d dVarS1 = hVar2;
                        int i3 = 0;
                        boolean zF2 = false;
                        while (cVar.e()) {
                            String strS = cVar.s();
                            strS.hashCode();
                            long j2 = jQ2;
                            int iHashCode = strS.hashCode();
                            if (iHashCode != 111) {
                                if (iHashCode != 3588) {
                                    if (iHashCode != 104433) {
                                        if (iHashCode == 3357091 && strS.equals("mode")) {
                                            b2 = 3;
                                        } else {
                                            b2 = -1;
                                        }
                                    } else if (strS.equals("inv")) {
                                        b2 = 2;
                                    } else {
                                        b2 = -1;
                                    }
                                } else if (strS.equals("pt")) {
                                    b2 = 1;
                                } else {
                                    b2 = -1;
                                }
                            } else if (strS.equals("o")) {
                                b2 = 0;
                            } else {
                                b2 = -1;
                            }
                            if (b2 == 0) {
                                dVarS1 = d.s1(cVar, dVar);
                            } else if (b2 == 1) {
                                hVar2 = new b.c.a.y.k.h(r.a(cVar, dVar, b.c.a.b0.g.c(), b0.a));
                            } else if (b2 == 2) {
                                zF2 = cVar.f();
                            } else if (b2 != 3) {
                                cVar.C();
                            } else {
                                String strT4 = cVar.t();
                                strT4.hashCode();
                                int iHashCode2 = strT4.hashCode();
                                if (iHashCode2 != 97) {
                                    if (iHashCode2 != 105) {
                                        if (iHashCode2 != 110) {
                                            if (iHashCode2 == 115 && strT4.equals("s")) {
                                                b3 = 3;
                                            } else {
                                                b3 = -1;
                                            }
                                        } else if (strT4.equals("n")) {
                                            b3 = 2;
                                        } else {
                                            b3 = -1;
                                        }
                                    } else if (strT4.equals("i")) {
                                        b3 = 1;
                                    } else {
                                        b3 = -1;
                                    }
                                } else if (strT4.equals("a")) {
                                    b3 = 0;
                                } else {
                                    b3 = -1;
                                }
                                if (b3 != 0) {
                                    if (b3 == 1) {
                                        dVar.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                                        i3 = 3;
                                    } else if (b3 == 2) {
                                        i3 = 4;
                                    } else if (b3 != 3) {
                                        b.c.a.b0.c.b("Unknown mask mode " + strS + ". Defaulting to Add.");
                                    } else {
                                        i3 = 2;
                                    }
                                }
                                i3 = 1;
                            }
                            jQ2 = j2;
                            dVarS1 = dVarS1;
                        }
                        cVar.d();
                        arrayList.add(new b.c.a.y.l.f(i3, hVar2, dVarS1, zF2));
                        jQ2 = jQ2;
                        hVar = null;
                    }
                    j = jQ2;
                    dVar.o += arrayList.size();
                    cVar.c();
                    jQ2 = j;
                    strT = strT;
                    break;
                case 11:
                    cVar.a();
                    while (cVar.e()) {
                        b.c.a.y.l.b bVarA = g.a(cVar, dVar);
                        if (bVarA != null) {
                            arrayList2.add(bVarA);
                        }
                    }
                    cVar.c();
                    j = jQ2;
                    jQ2 = j;
                    strT = strT;
                    break;
                case 12:
                    cVar.b();
                    while (cVar.e()) {
                        int iY = cVar.y(f342b);
                        if (iY == 0) {
                            str = strT;
                            jVar = new b.c.a.y.k.j(d.o1(cVar, dVar, h.a));
                        } else if (iY != i) {
                            cVar.A();
                            cVar.C();
                        } else {
                            cVar.a();
                            if (cVar.e()) {
                                c$a c_a = b.a;
                                cVar.b();
                                b.c.a.y.k.k kVar2 = null;
                                while (cVar.e()) {
                                    if (cVar.y(b.a) != 0) {
                                        cVar.A();
                                        cVar.C();
                                    } else {
                                        cVar.b();
                                        b.c.a.y.k.b bVarQ1 = null;
                                        b.c.a.y.k.b bVarQ2 = null;
                                        b.c.a.y.k.a aVarP1 = null;
                                        b.c.a.y.k.a aVarP2 = null;
                                        while (cVar.e()) {
                                            int iY2 = cVar.y(b.f326b);
                                            if (iY2 == 0) {
                                                aVarP1 = d.p1(cVar, dVar);
                                            } else if (iY2 == i) {
                                                aVarP2 = d.p1(cVar, dVar);
                                            } else if (iY2 == 2) {
                                                bVarQ1 = d.q1(cVar, dVar);
                                            } else if (iY2 != 3) {
                                                cVar.A();
                                                cVar.C();
                                            } else {
                                                bVarQ2 = d.q1(cVar, dVar);
                                            }
                                            i = 1;
                                        }
                                        cVar.d();
                                        kVar2 = new b.c.a.y.k.k(aVarP1, aVarP2, bVarQ1, bVarQ2);
                                        strT = strT;
                                        i = 1;
                                    }
                                }
                                str = strT;
                                cVar.d();
                                kVar = kVar2 == null ? new b.c.a.y.k.k(null, null, null, null) : kVar2;
                            } else {
                                str = strT;
                            }
                            while (cVar.e()) {
                                cVar.C();
                            }
                            cVar.c();
                        }
                        strT = str;
                        i = 1;
                    }
                    strT = strT;
                    cVar.d();
                    strT = strT;
                    break;
                case 13:
                    cVar.a();
                    ArrayList arrayList3 = new ArrayList();
                    while (cVar.e()) {
                        cVar.b();
                        while (cVar.e()) {
                            if (cVar.y(c) != 0) {
                                cVar.A();
                                cVar.C();
                            } else {
                                arrayList3.add(cVar.t());
                            }
                        }
                        cVar.d();
                    }
                    cVar.c();
                    dVar.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList3);
                    j = jQ2;
                    jQ2 = j;
                    strT = strT;
                    break;
                case 14:
                    fN2 = (float) cVar.n();
                    strT = strT;
                    strT = strT;
                    break;
                case 15:
                    fN3 = (float) cVar.n();
                    strT = strT;
                    strT = strT;
                    break;
                case 16:
                    iC3 = (int) (b.c.a.b0.g.c() * cVar.q());
                    strT = strT;
                    strT = strT;
                    break;
                case 17:
                    iC4 = (int) (b.c.a.b0.g.c() * cVar.q());
                    strT = strT;
                    strT = strT;
                    break;
                case 18:
                    fN = (float) cVar.n();
                    strT = strT;
                    strT = strT;
                    break;
                case 19:
                    fN4 = (float) cVar.n();
                    break;
                case 20:
                    bVarR1 = d.r1(cVar, dVar, z2);
                    break;
                case 21:
                    strT = cVar.t();
                    break;
                case 22:
                    zF = cVar.f();
                    break;
                default:
                    strT = strT;
                    j = jQ2;
                    cVar.A();
                    cVar.C();
                    jQ2 = j;
                    strT = strT;
                    break;
            }
            i = 1;
            z2 = false;
        }
        String str2 = strT;
        long j3 = jQ2;
        cVar.d();
        float f = fN / fN2;
        float f2 = fN4 / fN2;
        ArrayList arrayList4 = new ArrayList();
        if (f > 0.0f) {
            arrayList4.add(new b.c.a.c0.a(dVar, fValueOf2, fValueOf2, null, 0.0f, Float.valueOf(f)));
        }
        if (f2 <= 0.0f) {
            f2 = dVar.l;
        }
        arrayList4.add(new b.c.a.c0.a(dVar, fValueOf, fValueOf, null, f, Float.valueOf(f2)));
        arrayList4.add(new b.c.a.c0.a(dVar, fValueOf2, fValueOf2, null, f2, Float.valueOf(Float.MAX_VALUE)));
        if (strT3.endsWith(".ai") || "ai".equals(str2)) {
            dVar.a("Convert your Illustrator layers to shape layers.");
        }
        return new b.c.a.y.m.e(arrayList2, dVar, strT3, j3, e_a, jQ, strT2, arrayList, lVarA, iC, iC2, color, fN2, fN3, iC3, iC4, jVar, kVar, arrayList4, i2, bVarR1, zF);
    }
}
