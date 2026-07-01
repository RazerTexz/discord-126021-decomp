package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.n.z0;

/* JADX INFO: compiled from: ModuleAwareClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v {
    public static final d0.e0.p.d.m0.k.a0.i getRefinedMemberScopeIfPossible(d0.e0.p.d.m0.c.e eVar, z0 z0Var, d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "<this>");
        d0.z.d.m.checkNotNullParameter(z0Var, "typeSubstitution");
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        return u.j.getRefinedMemberScopeIfPossible$descriptors(eVar, z0Var, gVar);
    }

    public static final d0.e0.p.d.m0.k.a0.i getRefinedUnsubstitutedMemberScopeIfPossible(d0.e0.p.d.m0.c.e eVar, d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "<this>");
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        return u.j.getRefinedUnsubstitutedMemberScopeIfPossible$descriptors(eVar, gVar);
    }
}
