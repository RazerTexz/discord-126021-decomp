package d0.e0.p.d.m0.n;

import java.util.List;

/* JADX INFO: compiled from: ErrorType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h1 extends s {
    public final String p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h1(String str, u0 u0Var, d0.e0.p.d.m0.k.a0.i iVar, List<? extends w0> list, boolean z2) {
        super(u0Var, iVar, list, z2, null, 16, null);
        d0.z.d.m.checkNotNullParameter(str, "presentableName");
        d0.z.d.m.checkNotNullParameter(u0Var, "constructor");
        d0.z.d.m.checkNotNullParameter(iVar, "memberScope");
        d0.z.d.m.checkNotNullParameter(list, "arguments");
        this.p = str;
    }

    @Override // d0.e0.p.d.m0.n.s
    public String getPresentableName() {
        return this.p;
    }

    @Override // d0.e0.p.d.m0.n.s, d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ i1 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // d0.e0.p.d.m0.n.s, d0.e0.p.d.m0.n.c0
    public h1 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        return this;
    }

    @Override // d0.e0.p.d.m0.n.s, d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ s refine(d0.e0.p.d.m0.n.l1.g gVar) {
        return refine(gVar);
    }

    @Override // d0.e0.p.d.m0.n.s, d0.e0.p.d.m0.n.j0, d0.e0.p.d.m0.n.i1
    public j0 makeNullableAsSpecified(boolean z2) {
        return new h1(getPresentableName(), getConstructor(), getMemberScope(), getArguments(), z2);
    }

    @Override // d0.e0.p.d.m0.n.s, d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ c0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        return refine(gVar);
    }

    @Override // d0.e0.p.d.m0.n.s, d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ i1 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        return refine(gVar);
    }
}
