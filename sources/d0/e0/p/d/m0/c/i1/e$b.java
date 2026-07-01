package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.c.y0;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.u0;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: AbstractTypeAliasDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$b implements u0 {
    public final /* synthetic */ e a;

    public e$b(e eVar) {
        this.a = eVar;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public d0.e0.p.d.m0.b.h getBuiltIns() {
        return d0.e0.p.d.m0.k.x.a.getBuiltIns(getDeclarationDescriptor());
    }

    @Override // d0.e0.p.d.m0.n.u0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.h getDeclarationDescriptor() {
        return getDeclarationDescriptor();
    }

    @Override // d0.e0.p.d.m0.n.u0
    public List<z0> getParameters() {
        List list = ((d0.e0.p.d.m0.l.b.e0.l) this.a).f3498z;
        if (list != null) {
            return list;
        }
        d0.z.d.m.throwUninitializedPropertyAccessException("typeConstructorParameters");
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public Collection<d0.e0.p.d.m0.n.c0> getSupertypes() {
        Collection<d0.e0.p.d.m0.n.c0> supertypes = getDeclarationDescriptor().getUnderlyingType().getConstructor().getSupertypes();
        d0.z.d.m.checkNotNullExpressionValue(supertypes, "declarationDescriptor.underlyingType.constructor.supertypes");
        return supertypes;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public boolean isDenotable() {
        return true;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public u0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        return this;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("[typealias ");
        sbU.append(getDeclarationDescriptor().getName().asString());
        sbU.append(']');
        return sbU.toString();
    }

    @Override // d0.e0.p.d.m0.n.u0
    public y0 getDeclarationDescriptor() {
        return this.a;
    }
}
