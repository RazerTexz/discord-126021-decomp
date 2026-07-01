package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.n.z0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModuleAwareClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u$a {
    public u$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final d0.e0.p.d.m0.k.a0.i getRefinedMemberScopeIfPossible$descriptors(d0.e0.p.d.m0.c.e eVar, z0 z0Var, d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "<this>");
        d0.z.d.m.checkNotNullParameter(z0Var, "typeSubstitution");
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        u uVar = eVar instanceof u ? (u) eVar : null;
        if (uVar != null) {
            return uVar.getMemberScope(z0Var, gVar);
        }
        d0.e0.p.d.m0.k.a0.i memberScope = eVar.getMemberScope(z0Var);
        d0.z.d.m.checkNotNullExpressionValue(memberScope, "this.getMemberScope(\n                typeSubstitution\n            )");
        return memberScope;
    }

    public final d0.e0.p.d.m0.k.a0.i getRefinedUnsubstitutedMemberScopeIfPossible$descriptors(d0.e0.p.d.m0.c.e eVar, d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "<this>");
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        u uVar = eVar instanceof u ? (u) eVar : null;
        if (uVar != null) {
            return uVar.getUnsubstitutedMemberScope(gVar);
        }
        d0.e0.p.d.m0.k.a0.i unsubstitutedMemberScope = eVar.getUnsubstitutedMemberScope();
        d0.z.d.m.checkNotNullExpressionValue(unsubstitutedMemberScope, "this.unsubstitutedMemberScope");
        return unsubstitutedMemberScope;
    }
}
