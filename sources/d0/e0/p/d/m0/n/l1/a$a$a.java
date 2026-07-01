package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.c1;
import d0.e0.p.d.m0.n.f$b$a;
import d0.e0.p.d.m0.n.j1;

/* JADX INFO: compiled from: ClassicTypeCheckerContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$a$a extends f$b$a {
    public final /* synthetic */ c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c1 f3527b;

    public a$a$a(c cVar, c1 c1Var) {
        this.a = cVar;
        this.f3527b = c1Var;
    }

    @Override // d0.e0.p.d.m0.n.f$b
    public d0.e0.p.d.m0.n.n1.i transformType(d0.e0.p.d.m0.n.f fVar, d0.e0.p.d.m0.n.n1.h hVar) {
        d0.z.d.m.checkNotNullParameter(fVar, "context");
        d0.z.d.m.checkNotNullParameter(hVar, "type");
        c cVar = this.a;
        c0 c0VarSafeSubstitute = this.f3527b.safeSubstitute((c0) cVar.lowerBoundIfFlexible(hVar), j1.INVARIANT);
        d0.z.d.m.checkNotNullExpressionValue(c0VarSafeSubstitute, "substitutor.safeSubstitute(\n                        type.lowerBoundIfFlexible() as KotlinType,\n                        Variance.INVARIANT\n                    )");
        d0.e0.p.d.m0.n.n1.i iVarAsSimpleType = cVar.asSimpleType(c0VarSafeSubstitute);
        d0.z.d.m.checkNotNull(iVarAsSimpleType);
        return iVarAsSimpleType;
    }
}
