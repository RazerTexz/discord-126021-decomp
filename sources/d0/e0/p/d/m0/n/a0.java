package d0.e0.p.d.m0.n;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: IntersectionTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a0 implements u0, d0.e0.p.d.m0.n.n1.g {
    public c0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet<c0> f3518b;
    public final int c;

    public a0(Collection<? extends c0> collection) {
        d0.z.d.m.checkNotNullParameter(collection, "typesToIntersect");
        collection.isEmpty();
        LinkedHashSet<c0> linkedHashSet = new LinkedHashSet<>(collection);
        this.f3518b = linkedHashSet;
        this.c = linkedHashSet.hashCode();
    }

    public final d0.e0.p.d.m0.k.a0.i createScopeForKotlinType() {
        return d0.e0.p.d.m0.k.a0.o.f3464b.create("member scope for intersection type", this.f3518b);
    }

    public final j0 createType() {
        d0 d0Var = d0.a;
        return d0.simpleTypeWithNonTrivialMemberScope(d0.e0.p.d.m0.c.g1.g.f.getEMPTY(), this, d0.t.n.emptyList(), false, createScopeForKotlinType(), new a0$a(this));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a0) {
            return d0.z.d.m.areEqual(this.f3518b, ((a0) obj).f3518b);
        }
        return false;
    }

    public final c0 getAlternativeType() {
        return this.a;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public d0.e0.p.d.m0.b.h getBuiltIns() {
        d0.e0.p.d.m0.b.h builtIns = this.f3518b.iterator().next().getConstructor().getBuiltIns();
        d0.z.d.m.checkNotNullExpressionValue(builtIns, "intersectedTypes.iterator().next().constructor.builtIns");
        return builtIns;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public d0.e0.p.d.m0.c.h getDeclarationDescriptor() {
        return null;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public List<d0.e0.p.d.m0.c.z0> getParameters() {
        return d0.t.n.emptyList();
    }

    @Override // d0.e0.p.d.m0.n.u0
    public Collection<c0> getSupertypes() {
        return this.f3518b;
    }

    public int hashCode() {
        return this.c;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public boolean isDenotable() {
        return false;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public /* bridge */ /* synthetic */ u0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        return refine(gVar);
    }

    public final a0 setAlternative(c0 c0Var) {
        a0 a0Var = new a0(this.f3518b);
        a0Var.a = c0Var;
        return a0Var;
    }

    public String toString() {
        return d0.t.u.joinToString$default(d0.t.u.sortedWith(this.f3518b, new b0()), " & ", "{", "}", 0, null, null, 56, null);
    }

    @Override // d0.e0.p.d.m0.n.u0
    public a0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        Collection<c0> supertypes = getSupertypes();
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(supertypes, 10));
        Iterator<T> it = supertypes.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            arrayList.add(((c0) it.next()).refine(gVar));
            z2 = true;
        }
        a0 alternative = null;
        if (z2) {
            c0 alternativeType = getAlternativeType();
            alternative = new a0(arrayList).setAlternative(alternativeType != null ? alternativeType.refine(gVar) : null);
        }
        return alternative == null ? this : alternative;
    }
}
