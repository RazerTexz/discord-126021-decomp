package d0.e0.p.d.m0.k.v;

import b.d.b.a.outline;
import d0.LazyJVM;
import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.KotlinTypeFactory;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.e0.p.d.m0.n.TypeProjectionImpl;
import d0.e0.p.d.m0.n.TypeSubstitution;
import d0.e0.p.d.m0.n.Variance;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.n, reason: use source file name */
/* JADX INFO: compiled from: IntegerLiteralTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class IntegerLiteralTypeConstructor implements TypeConstructor {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3475b;
    public final ModuleDescriptor2 c;
    public final Set<KotlinType> d;
    public final KotlinType4 e;
    public final Lazy f;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.n$a */
    /* JADX INFO: compiled from: IntegerLiteralTypeConstructor.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v14, types: [d0.e0.p.d.m0.n.j0] */
        /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v6, types: [d0.e0.p.d.m0.n.c0, d0.e0.p.d.m0.n.j0, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r1v1 */
        public final KotlinType4 findIntersectionType(Collection<? extends KotlinType4> collection) {
            Intrinsics3.checkNotNullParameter(collection, "types");
            if (collection.isEmpty()) {
                return null;
            }
            Iterator it = collection.iterator();
            if (!it.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            ?? next = it.next();
            while (it.hasNext()) {
                KotlinType4 kotlinType4 = (KotlinType4) it.next();
                next = (KotlinType4) next;
                if (next != 0 && kotlinType4 != null) {
                    TypeConstructor constructor = next.getConstructor();
                    TypeConstructor constructor2 = kotlinType4.getConstructor();
                    boolean z2 = constructor instanceof IntegerLiteralTypeConstructor;
                    if (z2 && (constructor2 instanceof IntegerLiteralTypeConstructor)) {
                        IntegerLiteralTypeConstructor integerLiteralTypeConstructor = (IntegerLiteralTypeConstructor) constructor;
                        IntegerLiteralTypeConstructor integerLiteralTypeConstructor2 = new IntegerLiteralTypeConstructor(integerLiteralTypeConstructor.f3475b, integerLiteralTypeConstructor.c, _Collections.union(integerLiteralTypeConstructor.getPossibleTypes(), ((IntegerLiteralTypeConstructor) constructor2).getPossibleTypes()), null);
                        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
                        next = KotlinTypeFactory.integerLiteralType(Annotations4.f.getEMPTY(), integerLiteralTypeConstructor2, false);
                    } else if (z2) {
                        if (((IntegerLiteralTypeConstructor) constructor).getPossibleTypes().contains(kotlinType4)) {
                            next = kotlinType4;
                        }
                    } else if (!(constructor2 instanceof IntegerLiteralTypeConstructor) || !((IntegerLiteralTypeConstructor) constructor2).getPossibleTypes().contains(next)) {
                    }
                }
                next = 0;
            }
            return (KotlinType4) next;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.n$b */
    /* JADX INFO: compiled from: IntegerLiteralTypeConstructor.kt */
    public static final class b extends Lambda implements Function0<List<KotlinType4>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<KotlinType4> invoke() {
            KotlinType4 defaultType = IntegerLiteralTypeConstructor.this.getBuiltIns().getComparable().getDefaultType();
            Intrinsics3.checkNotNullExpressionValue(defaultType, "builtIns.comparable.defaultType");
            List<KotlinType4> listMutableListOf = Collections2.mutableListOf(TypeSubstitution.replace$default(defaultType, CollectionsJVM.listOf(new TypeProjectionImpl(Variance.IN_VARIANCE, IntegerLiteralTypeConstructor.this.e)), null, 2, null));
            if (!IntegerLiteralTypeConstructor.access$isContainsOnlyUnsignedTypes(IntegerLiteralTypeConstructor.this)) {
                listMutableListOf.add(IntegerLiteralTypeConstructor.this.getBuiltIns().getNumberType());
            }
            return listMutableListOf;
        }
    }

    public IntegerLiteralTypeConstructor(long j, ModuleDescriptor2 moduleDescriptor2, Set set, DefaultConstructorMarker defaultConstructorMarker) {
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
        this.e = KotlinTypeFactory.integerLiteralType(Annotations4.f.getEMPTY(), this, false);
        this.f = LazyJVM.lazy(new b());
        this.f3475b = j;
        this.c = moduleDescriptor2;
        this.d = set;
    }

    public static final boolean access$isContainsOnlyUnsignedTypes(IntegerLiteralTypeConstructor integerLiteralTypeConstructor) {
        Collection<KotlinType> allSignedLiteralTypes = PrimitiveTypeUtil.getAllSignedLiteralTypes(integerLiteralTypeConstructor.c);
        if ((allSignedLiteralTypes instanceof Collection) && allSignedLiteralTypes.isEmpty()) {
            return true;
        }
        Iterator<T> it = allSignedLiteralTypes.iterator();
        while (it.hasNext()) {
            if (!(!integerLiteralTypeConstructor.getPossibleTypes().contains((KotlinType) it.next()))) {
                return false;
            }
        }
        return true;
    }

    public final boolean checkConstructor(TypeConstructor typeConstructor) {
        Intrinsics3.checkNotNullParameter(typeConstructor, "constructor");
        Set<KotlinType> set = this.d;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            if (Intrinsics3.areEqual(((KotlinType) it.next()).getConstructor(), typeConstructor)) {
                return true;
            }
        }
        return false;
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        return this.c.getBuiltIns();
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public ClassifierDescriptor getDeclarationDescriptor() {
        return null;
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        return Collections2.emptyList();
    }

    public final Set<KotlinType> getPossibleTypes() {
        return this.d;
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public Collection<KotlinType> getSupertypes() {
        return (List) this.f.getValue();
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
        StringBuilder sbQ = outline.Q('[');
        sbQ.append(_Collections.joinToString$default(this.d, ",", null, null, 0, null, IntegerLiteralTypeConstructor2.j, 30, null));
        sbQ.append(']');
        return Intrinsics3.stringPlus("IntegerLiteralType", sbQ.toString());
    }
}
