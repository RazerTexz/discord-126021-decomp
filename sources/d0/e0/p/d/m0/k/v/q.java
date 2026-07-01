package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.u0;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: IntegerValueTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q implements u0 {
    @Override // d0.e0.p.d.m0.n.u0
    public d0.e0.p.d.m0.b.h getBuiltIns() {
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.h getDeclarationDescriptor() {
        return (d0.e0.p.d.m0.c.h) m94getDeclarationDescriptor();
    }

    /* JADX INFO: renamed from: getDeclarationDescriptor, reason: collision with other method in class */
    public Void m94getDeclarationDescriptor() {
        return null;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public List<z0> getParameters() {
        return d0.t.n.emptyList();
    }

    @Override // d0.e0.p.d.m0.n.u0
    public Collection<c0> getSupertypes() {
        return null;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public boolean isDenotable() {
        return false;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public u0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        return this;
    }

    public String toString() {
        return "IntegerValueType(0)";
    }
}
