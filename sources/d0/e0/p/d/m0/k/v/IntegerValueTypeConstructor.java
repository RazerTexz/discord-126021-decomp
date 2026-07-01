package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.q, reason: use source file name */
/* JADX INFO: compiled from: IntegerValueTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class IntegerValueTypeConstructor implements TypeConstructor {
    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        throw null;
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public /* bridge */ /* synthetic */ ClassifierDescriptor getDeclarationDescriptor() {
        return (ClassifierDescriptor) m94getDeclarationDescriptor();
    }

    /* JADX INFO: renamed from: getDeclarationDescriptor, reason: collision with other method in class */
    public Void m94getDeclarationDescriptor() {
        return null;
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        return Collections2.emptyList();
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public Collection<KotlinType> getSupertypes() {
        return null;
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    public String toString() {
        return "IntegerValueType(0)";
    }
}
