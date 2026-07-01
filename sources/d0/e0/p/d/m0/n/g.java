package d0.e0.p.d.m0.n;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: AbstractTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g implements u0 {
    public final d0.e0.p.d.m0.m.j<g$b> a;

    public g(d0.e0.p.d.m0.m.o oVar) {
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        this.a = oVar.createLazyValueWithPostCompute(new g$c(this), g$d.j, new g$e(this));
    }

    public static final Collection access$computeNeighbours(g gVar, u0 u0Var, boolean z2) {
        Objects.requireNonNull(gVar);
        g gVar2 = u0Var instanceof g ? (g) u0Var : null;
        List listPlus = gVar2 != null ? d0.t.u.plus((Collection) gVar2.a.invoke().getAllSupertypes(), (Iterable) gVar2.c(z2)) : null;
        if (listPlus != null) {
            return listPlus;
        }
        Collection<c0> supertypes = u0Var.getSupertypes();
        d0.z.d.m.checkNotNullExpressionValue(supertypes, "supertypes");
        return supertypes;
    }

    public abstract Collection<c0> a();

    public c0 b() {
        return null;
    }

    public Collection<c0> c(boolean z2) {
        return d0.t.n.emptyList();
    }

    public abstract d0.e0.p.d.m0.c.x0 d();

    public List<c0> e(List<c0> list) {
        d0.z.d.m.checkNotNullParameter(list, "supertypes");
        return list;
    }

    public void f(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "type");
    }

    @Override // d0.e0.p.d.m0.n.u0
    public abstract d0.e0.p.d.m0.c.h getDeclarationDescriptor();

    @Override // d0.e0.p.d.m0.n.u0
    public /* bridge */ /* synthetic */ Collection getSupertypes() {
        return getSupertypes();
    }

    @Override // d0.e0.p.d.m0.n.u0
    public u0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        return new g$a(this, gVar);
    }

    @Override // d0.e0.p.d.m0.n.u0
    public List<c0> getSupertypes() {
        return this.a.invoke().getSupertypesWithoutCycles();
    }
}
