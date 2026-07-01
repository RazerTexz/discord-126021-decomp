package d0.e0.p.d.m0.e.a.l0;

import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.d0;
import d0.e0.p.d.m0.n.e1;
import d0.e0.p.d.m0.n.g1;
import d0.e0.p.d.m0.n.i1;
import d0.e0.p.d.m0.n.j0;

/* JADX INFO: compiled from: typeEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends d0.e0.p.d.m0.n.m implements d0.e0.p.d.m0.n.j {
    public final j0 k;

    public g(j0 j0Var) {
        d0.z.d.m.checkNotNullParameter(j0Var, "delegate");
        this.k = j0Var;
    }

    public final j0 a(j0 j0Var) {
        j0 j0VarMakeNullableAsSpecified = j0Var.makeNullableAsSpecified(false);
        return !d0.e0.p.d.m0.n.o1.a.isTypeParameter(j0Var) ? j0VarMakeNullableAsSpecified : new g(j0VarMakeNullableAsSpecified);
    }

    @Override // d0.e0.p.d.m0.n.m
    public j0 getDelegate() {
        return this.k;
    }

    @Override // d0.e0.p.d.m0.n.m, d0.e0.p.d.m0.n.c0
    public boolean isMarkedNullable() {
        return false;
    }

    @Override // d0.e0.p.d.m0.n.j
    public boolean isTypeVariable() {
        return true;
    }

    @Override // d0.e0.p.d.m0.n.j0, d0.e0.p.d.m0.n.i1
    public j0 makeNullableAsSpecified(boolean z2) {
        return z2 ? this.k.makeNullableAsSpecified(true) : this;
    }

    @Override // d0.e0.p.d.m0.n.j0, d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ j0 replaceAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        return replaceAnnotations(gVar);
    }

    @Override // d0.e0.p.d.m0.n.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.n.m replaceDelegate(j0 j0Var) {
        return replaceDelegate(j0Var);
    }

    @Override // d0.e0.p.d.m0.n.j
    public c0 substitutionResult(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "replacement");
        i1 i1VarUnwrap = c0Var.unwrap();
        if (!d0.e0.p.d.m0.n.o1.a.isTypeParameter(i1VarUnwrap) && !e1.isNullableType(i1VarUnwrap)) {
            return i1VarUnwrap;
        }
        if (i1VarUnwrap instanceof j0) {
            return a((j0) i1VarUnwrap);
        }
        if (!(i1VarUnwrap instanceof d0.e0.p.d.m0.n.v)) {
            throw new IllegalStateException(d0.z.d.m.stringPlus("Incorrect type: ", i1VarUnwrap).toString());
        }
        d0 d0Var = d0.a;
        d0.e0.p.d.m0.n.v vVar = (d0.e0.p.d.m0.n.v) i1VarUnwrap;
        return g1.wrapEnhancement(d0.flexibleType(a(vVar.getLowerBound()), a(vVar.getUpperBound())), g1.getEnhancement(i1VarUnwrap));
    }

    @Override // d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ i1 replaceAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        return replaceAnnotations(gVar);
    }

    @Override // d0.e0.p.d.m0.n.m
    public g replaceDelegate(j0 j0Var) {
        d0.z.d.m.checkNotNullParameter(j0Var, "delegate");
        return new g(j0Var);
    }

    @Override // d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ i1 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // d0.e0.p.d.m0.n.j0, d0.e0.p.d.m0.n.i1
    public g replaceAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "newAnnotations");
        return new g(this.k.replaceAnnotations(gVar));
    }
}
