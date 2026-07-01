package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.k.a0.TypeIntersectionScope;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.a0, reason: use source file name */
/* JADX INFO: compiled from: IntersectionTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class IntersectionTypeConstructor implements TypeConstructor, d0.e0.p.d.m0.n.n1.g {
    public KotlinType a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet<KotlinType> f3518b;
    public final int c;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.a0$a */
    /* JADX INFO: compiled from: IntersectionTypeConstructor.kt */
    public static final class a extends Lambda implements Function1<KotlinTypeRefiner, KotlinType4> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final KotlinType4 invoke(KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            return IntersectionTypeConstructor.this.refine(kotlinTypeRefiner).createType();
        }
    }

    public IntersectionTypeConstructor(Collection<? extends KotlinType> collection) {
        Intrinsics3.checkNotNullParameter(collection, "typesToIntersect");
        collection.isEmpty();
        LinkedHashSet<KotlinType> linkedHashSet = new LinkedHashSet<>(collection);
        this.f3518b = linkedHashSet;
        this.c = linkedHashSet.hashCode();
    }

    public final MemberScope3 createScopeForKotlinType() {
        return TypeIntersectionScope.f3464b.create("member scope for intersection type", this.f3518b);
    }

    public final KotlinType4 createType() {
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(Annotations4.f.getEMPTY(), this, Collections2.emptyList(), false, createScopeForKotlinType(), new a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IntersectionTypeConstructor) {
            return Intrinsics3.areEqual(this.f3518b, ((IntersectionTypeConstructor) obj).f3518b);
        }
        return false;
    }

    public final KotlinType getAlternativeType() {
        return this.a;
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns builtIns = this.f3518b.iterator().next().getConstructor().getBuiltIns();
        Intrinsics3.checkNotNullExpressionValue(builtIns, "intersectedTypes.iterator().next().constructor.builtIns");
        return builtIns;
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public ClassifierDescriptor getDeclarationDescriptor() {
        return null;
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        return Collections2.emptyList();
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public Collection<KotlinType> getSupertypes() {
        return this.f3518b;
    }

    public int hashCode() {
        return this.c;
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    public final IntersectionTypeConstructor setAlternative(KotlinType kotlinType) {
        IntersectionTypeConstructor intersectionTypeConstructor = new IntersectionTypeConstructor(this.f3518b);
        intersectionTypeConstructor.a = kotlinType;
        return intersectionTypeConstructor;
    }

    public String toString() {
        return _Collections.joinToString$default(_Collections.sortedWith(this.f3518b, new b0()), " & ", "{", "}", 0, null, null, 56, null);
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public IntersectionTypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        Collection<KotlinType> supertypes = getSupertypes();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(supertypes, 10));
        Iterator<T> it = supertypes.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            arrayList.add(((KotlinType) it.next()).refine(kotlinTypeRefiner));
            z2 = true;
        }
        IntersectionTypeConstructor alternative = null;
        if (z2) {
            KotlinType alternativeType = getAlternativeType();
            alternative = new IntersectionTypeConstructor(arrayList).setAlternative(alternativeType != null ? alternativeType.refine(kotlinTypeRefiner) : null);
        }
        return alternative == null ? this : alternative;
    }
}
