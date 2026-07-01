package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.b$a;

/* JADX INFO: compiled from: ProtoEnumFlagsUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a0 {
    public static final d0.e0.p.d.m0.c.u descriptorVisibility(z zVar, d0.e0.p.d.m0.f.x xVar) {
        d0.z.d.m.checkNotNullParameter(zVar, "<this>");
        switch (xVar == null ? -1 : a0$a.f3482b[xVar.ordinal()]) {
            case 1:
                d0.e0.p.d.m0.c.u uVar = d0.e0.p.d.m0.c.t.d;
                d0.z.d.m.checkNotNullExpressionValue(uVar, "INTERNAL");
                return uVar;
            case 2:
                d0.e0.p.d.m0.c.u uVar2 = d0.e0.p.d.m0.c.t.a;
                d0.z.d.m.checkNotNullExpressionValue(uVar2, "PRIVATE");
                return uVar2;
            case 3:
                d0.e0.p.d.m0.c.u uVar3 = d0.e0.p.d.m0.c.t.f3300b;
                d0.z.d.m.checkNotNullExpressionValue(uVar3, "PRIVATE_TO_THIS");
                return uVar3;
            case 4:
                d0.e0.p.d.m0.c.u uVar4 = d0.e0.p.d.m0.c.t.c;
                d0.z.d.m.checkNotNullExpressionValue(uVar4, "PROTECTED");
                return uVar4;
            case 5:
                d0.e0.p.d.m0.c.u uVar5 = d0.e0.p.d.m0.c.t.e;
                d0.z.d.m.checkNotNullExpressionValue(uVar5, "PUBLIC");
                return uVar5;
            case 6:
                d0.e0.p.d.m0.c.u uVar6 = d0.e0.p.d.m0.c.t.f;
                d0.z.d.m.checkNotNullExpressionValue(uVar6, "LOCAL");
                return uVar6;
            default:
                d0.e0.p.d.m0.c.u uVar7 = d0.e0.p.d.m0.c.t.a;
                d0.z.d.m.checkNotNullExpressionValue(uVar7, "PRIVATE");
                return uVar7;
        }
    }

    public static final b$a memberKind(z zVar, d0.e0.p.d.m0.f.j jVar) {
        b$a b_a = b$a.DECLARATION;
        d0.z.d.m.checkNotNullParameter(zVar, "<this>");
        int i = jVar == null ? -1 : a0$a.a[jVar.ordinal()];
        if (i == 1) {
            return b_a;
        }
        if (i == 2) {
            return b$a.FAKE_OVERRIDE;
        }
        if (i != 3) {
            return i != 4 ? b_a : b$a.SYNTHESIZED;
        }
        return b$a.DELEGATION;
    }
}
