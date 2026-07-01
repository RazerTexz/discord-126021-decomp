package b.c.a.a0;

import android.graphics.PointF;
import b.c.a.a0.i0.c$a;
import b.c.a.a0.i0.c$b;
import java.io.IOException;

/* JADX INFO: compiled from: AnimatableTransformParser.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static c$a a = c$a.a("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static c$a f328b = c$a.a("k");

    /* JADX WARN: Code duplicated, block: B:113:0x0219  */
    /* JADX WARN: Code duplicated, block: B:114:0x021c  */
    /* JADX WARN: Code duplicated, block: B:22:0x0068  */
    /* JADX WARN: Code duplicated, block: B:23:0x009b  */
    /* JADX WARN: Code duplicated, block: B:25:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:88:0x01c5  */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public static b.c.a.y.k.l a(b.c.a.a0.i0.c cVar, b.c.a.d dVar) throws IOException {
        boolean z2;
        b.c.a.y.k.b bVar;
        boolean z3;
        b.c.a.y.k.b bVar2;
        b.c.a.y.k.g gVar;
        b.c.a.y.k.b bVar3;
        b.c.a.y.k.m<PointF, PointF> mVar;
        b.c.a.y.k.b bVarR1;
        b.c.a.y.k.b bVar4;
        boolean z4 = false;
        boolean z5 = cVar.u() == c$b.BEGIN_OBJECT;
        if (z5) {
            cVar.b();
        }
        b.c.a.y.k.b bVar5 = null;
        b.c.a.y.k.g gVar2 = null;
        b.c.a.y.k.m<PointF, PointF> mVarB = null;
        b.c.a.y.k.b bVarR2 = null;
        b.c.a.y.k.b bVarR3 = null;
        b.c.a.y.k.e eVarA = null;
        b.c.a.y.k.d dVarS1 = null;
        b.c.a.y.k.b bVarR4 = null;
        b.c.a.y.k.b bVarR5 = null;
        while (cVar.e()) {
            switch (cVar.y(a)) {
                case 0:
                    gVar = gVar2;
                    bVar3 = bVarR2;
                    mVar = mVarB;
                    cVar.b();
                    while (cVar.e()) {
                        if (cVar.y(f328b) != 0) {
                            cVar.A();
                            cVar.C();
                        } else {
                            eVarA = a.a(cVar, dVar);
                        }
                    }
                    cVar.d();
                    gVar2 = gVar;
                    mVarB = mVar;
                    bVarR2 = bVar3;
                    z4 = false;
                    break;
                case 1:
                    bVar3 = bVarR2;
                    mVarB = a.b(cVar, dVar);
                    bVarR2 = bVar3;
                    z4 = false;
                    break;
                case 2:
                    bVar3 = bVarR2;
                    mVar = mVarB;
                    gVar2 = new b.c.a.y.k.g(d.o1(cVar, dVar, a0.a));
                    mVarB = mVar;
                    bVarR2 = bVar3;
                    z4 = false;
                    break;
                case 3:
                    dVar.a("Lottie doesn't support 3D layers.");
                    bVarR1 = d.r1(cVar, dVar, z4);
                    if (bVarR1.a.isEmpty()) {
                        bVar4 = bVarR1;
                        gVar = gVar2;
                        bVar3 = bVarR2;
                        mVar = mVarB;
                        bVarR1.a.add((b.c.a.c0.a<V>) new b.c.a.c0.a(dVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(dVar.l)));
                    } else {
                        bVar4 = bVarR1;
                        gVar = gVar2;
                        bVar3 = bVarR2;
                        mVar = mVarB;
                        if (((b.c.a.c0.a) bVar4.a.get(0)).f347b == 0) {
                            bVar4.a.set(0, (b.c.a.c0.a<V>) new b.c.a.c0.a(dVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(dVar.l)));
                        }
                    }
                    bVar5 = bVar4;
                    gVar2 = gVar;
                    mVarB = mVar;
                    bVarR2 = bVar3;
                    z4 = false;
                    break;
                case 4:
                    bVarR1 = d.r1(cVar, dVar, z4);
                    if (bVarR1.a.isEmpty()) {
                        bVar4 = bVarR1;
                        gVar = gVar2;
                        bVar3 = bVarR2;
                        mVar = mVarB;
                        bVarR1.a.add((b.c.a.c0.a<V>) new b.c.a.c0.a(dVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(dVar.l)));
                    } else {
                        bVar4 = bVarR1;
                        gVar = gVar2;
                        bVar3 = bVarR2;
                        mVar = mVarB;
                        if (((b.c.a.c0.a) bVar4.a.get(0)).f347b == 0) {
                            bVar4.a.set(0, (b.c.a.c0.a<V>) new b.c.a.c0.a(dVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(dVar.l)));
                        }
                    }
                    bVar5 = bVar4;
                    gVar2 = gVar;
                    mVarB = mVar;
                    bVarR2 = bVar3;
                    z4 = false;
                    break;
                case 5:
                    dVarS1 = d.s1(cVar, dVar);
                    break;
                case 6:
                    bVarR4 = d.r1(cVar, dVar, z4);
                    break;
                case 7:
                    bVarR5 = d.r1(cVar, dVar, z4);
                    break;
                case 8:
                    bVarR3 = d.r1(cVar, dVar, z4);
                    break;
                case 9:
                    bVarR2 = d.r1(cVar, dVar, z4);
                    break;
                default:
                    bVar3 = bVarR2;
                    cVar.A();
                    cVar.C();
                    bVarR2 = bVar3;
                    z4 = false;
                    break;
            }
        }
        b.c.a.y.k.g gVar3 = gVar2;
        b.c.a.y.k.b bVar6 = bVarR2;
        b.c.a.y.k.m<PointF, PointF> mVar2 = mVarB;
        if (z5) {
            cVar.d();
        }
        if (eVarA == null || (eVarA.isStatic() && eVarA.a.get(0).f347b.equals(0.0f, 0.0f))) {
            eVarA = null;
        }
        if (mVar2 == null || (!(mVar2 instanceof b.c.a.y.k.i) && mVar2.isStatic() && mVar2.b().get(0).f347b.equals(0.0f, 0.0f))) {
            mVar2 = null;
        }
        b.c.a.y.k.b bVar7 = bVar5 == null || (bVar5.isStatic() && (((Float) ((b.c.a.c0.a) bVar5.a.get(0)).f347b).floatValue() > 0.0f ? 1 : (((Float) ((b.c.a.c0.a) bVar5.a.get(0)).f347b).floatValue() == 0.0f ? 0 : -1)) == 0) ? null : bVar5;
        if (gVar3 != 0) {
            if (gVar3.isStatic()) {
                b.c.a.c0.d dVar2 = (b.c.a.c0.d) ((b.c.a.c0.a) gVar3.a.get(0)).f347b;
                z2 = (dVar2.a > 1.0f ? 1 : (dVar2.a == 1.0f ? 0 : -1)) == 0 && (dVar2.f350b > 1.0f ? 1 : (dVar2.f350b == 1.0f ? 0 : -1)) == 0;
            }
        }
        b.c.a.y.k.g gVar4 = z2 ? null : gVar3;
        if (bVarR3 == null || (bVarR3.isStatic() && ((Float) ((b.c.a.c0.a) bVarR3.a.get(0)).f347b).floatValue() == 0.0f)) {
            bVarR3 = null;
        }
        if (bVar6 != null) {
            bVar = bVar6;
            z3 = bVar6.isStatic() && ((Float) ((b.c.a.c0.a) bVar.a.get(0)).f347b).floatValue() == 0.0f;
            if (z3) {
                bVar2 = null;
            } else {
                bVar2 = bVar;
            }
            return new b.c.a.y.k.l(eVarA, mVar2, gVar4, bVar7, dVarS1, bVarR4, bVarR5, bVarR3, bVar2);
        }
        bVar = bVar6;
        if (z3) {
            bVar2 = null;
        } else {
            bVar2 = bVar;
        }
        return new b.c.a.y.k.l(eVarA, mVar2, gVar4, bVar7, dVarS1, bVarR4, bVarR5, bVarR3, bVar2);
    }
}
