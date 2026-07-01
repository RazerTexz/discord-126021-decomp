package d0.e0.p.d.m0.n;

import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: flexibleTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class w extends v implements j {
    static {
        new w$a(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(j0 j0Var, j0 j0Var2) {
        super(j0Var, j0Var2);
        d0.z.d.m.checkNotNullParameter(j0Var, "lowerBound");
        d0.z.d.m.checkNotNullParameter(j0Var2, "upperBound");
    }

    @Override // d0.e0.p.d.m0.n.v
    public j0 getDelegate() {
        return getLowerBound();
    }

    @Override // d0.e0.p.d.m0.n.j
    public boolean isTypeVariable() {
        return (getLowerBound().getConstructor().getDeclarationDescriptor() instanceof d0.e0.p.d.m0.c.z0) && d0.z.d.m.areEqual(getLowerBound().getConstructor(), getUpperBound().getConstructor());
    }

    @Override // d0.e0.p.d.m0.n.i1
    public i1 makeNullableAsSpecified(boolean z2) {
        d0 d0Var = d0.a;
        return d0.flexibleType(getLowerBound().makeNullableAsSpecified(z2), getUpperBound().makeNullableAsSpecified(z2));
    }

    @Override // d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ c0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        return refine(gVar);
    }

    @Override // d0.e0.p.d.m0.n.v
    public String render(d0.e0.p.d.m0.j.c cVar, d0.e0.p.d.m0.j.h hVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "renderer");
        d0.z.d.m.checkNotNullParameter(hVar, "options");
        if (!hVar.getDebugMode()) {
            return cVar.renderFlexibleType(cVar.renderType(getLowerBound()), cVar.renderType(getUpperBound()), d0.e0.p.d.m0.n.o1.a.getBuiltIns(this));
        }
        StringBuilder sbQ = b.d.b.a.a.Q('(');
        sbQ.append(cVar.renderType(getLowerBound()));
        sbQ.append("..");
        sbQ.append(cVar.renderType(getUpperBound()));
        sbQ.append(')');
        return sbQ.toString();
    }

    @Override // d0.e0.p.d.m0.n.i1
    public i1 replaceAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "newAnnotations");
        d0 d0Var = d0.a;
        return d0.flexibleType(getLowerBound().replaceAnnotations(gVar), getUpperBound().replaceAnnotations(gVar));
    }

    @Override // d0.e0.p.d.m0.n.j
    public c0 substitutionResult(c0 c0Var) {
        i1 i1VarFlexibleType;
        d0.z.d.m.checkNotNullParameter(c0Var, "replacement");
        i1 i1VarUnwrap = c0Var.unwrap();
        if (i1VarUnwrap instanceof v) {
            i1VarFlexibleType = i1VarUnwrap;
        } else {
            if (!(i1VarUnwrap instanceof j0)) {
                throw new NoWhenBranchMatchedException();
            }
            d0 d0Var = d0.a;
            j0 j0Var = (j0) i1VarUnwrap;
            i1VarFlexibleType = d0.flexibleType(j0Var, j0Var.makeNullableAsSpecified(true));
        }
        return g1.inheritEnhancement(i1VarFlexibleType, i1VarUnwrap);
    }

    @Override // d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ i1 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        return refine(gVar);
    }

    @Override // d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public v refine(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        return new w((j0) gVar.refineType(getLowerBound()), (j0) gVar.refineType(getUpperBound()));
    }
}
