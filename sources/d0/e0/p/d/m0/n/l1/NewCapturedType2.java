package d0.e0.p.d.m0.n.l1;

import b.d.b.a.outline;
import d0.Lazy5;
import d0.LazyJVM;
import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.k.u.a.CapturedTypeConstructor2;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType3;
import d0.e0.p.d.m0.n.TypeProjection;
import d0.e0.p.d.m0.n.o1.TypeUtils2;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.j, reason: use source file name */
/* JADX INFO: compiled from: NewCapturedType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NewCapturedType2 implements CapturedTypeConstructor2 {
    public final TypeProjection a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<? extends List<? extends KotlinType3>> f3528b;
    public final NewCapturedType2 c;
    public final TypeParameterDescriptor d;
    public final Lazy e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.j$a */
    /* JADX INFO: compiled from: NewCapturedType.kt */
    public static final class a extends Lambda implements Function0<List<? extends KotlinType3>> {
        public final /* synthetic */ List<KotlinType3> $supertypes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends KotlinType3> list) {
            super(0);
            this.$supertypes = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends KotlinType3> invoke() {
            return this.$supertypes;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.j$b */
    /* JADX INFO: compiled from: NewCapturedType.kt */
    public static final class b extends Lambda implements Function0<List<? extends KotlinType3>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends KotlinType3> invoke() {
            Function0 function0 = NewCapturedType2.this.f3528b;
            if (function0 == null) {
                return null;
            }
            return (List) function0.invoke();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.j$c */
    /* JADX INFO: compiled from: NewCapturedType.kt */
    public static final class c extends Lambda implements Function0<List<? extends KotlinType3>> {
        public final /* synthetic */ List<KotlinType3> $supertypes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(List<? extends KotlinType3> list) {
            super(0);
            this.$supertypes = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends KotlinType3> invoke() {
            return this.$supertypes;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.j$d */
    /* JADX INFO: compiled from: NewCapturedType.kt */
    public static final class d extends Lambda implements Function0<List<? extends KotlinType3>> {
        public final /* synthetic */ KotlinTypeRefiner $kotlinTypeRefiner;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(KotlinTypeRefiner kotlinTypeRefiner) {
            super(0);
            this.$kotlinTypeRefiner = kotlinTypeRefiner;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends KotlinType3> invoke() {
            List<KotlinType3> supertypes = NewCapturedType2.this.getSupertypes();
            KotlinTypeRefiner kotlinTypeRefiner = this.$kotlinTypeRefiner;
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(supertypes, 10));
            Iterator<T> it = supertypes.iterator();
            while (it.hasNext()) {
                arrayList.add(((KotlinType3) it.next()).refine(kotlinTypeRefiner));
            }
            return arrayList;
        }
    }

    public NewCapturedType2(TypeProjection typeProjection, Function0<? extends List<? extends KotlinType3>> function0, NewCapturedType2 newCapturedType2, TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics3.checkNotNullParameter(typeProjection, "projection");
        this.a = typeProjection;
        this.f3528b = function0;
        this.c = newCapturedType2;
        this.d = typeParameterDescriptor;
        this.e = LazyJVM.lazy(Lazy5.PUBLICATION, new b());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics3.areEqual(NewCapturedType2.class, obj == null ? null : obj.getClass())) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
        NewCapturedType2 newCapturedType2 = (NewCapturedType2) obj;
        NewCapturedType2 newCapturedType3 = this.c;
        if (newCapturedType3 == null) {
            newCapturedType3 = this;
        }
        NewCapturedType2 newCapturedType4 = newCapturedType2.c;
        if (newCapturedType4 != null) {
            newCapturedType2 = newCapturedType4;
        }
        return newCapturedType3 == newCapturedType2;
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        KotlinType type = getProjection().getType();
        Intrinsics3.checkNotNullExpressionValue(type, "projection.type");
        return TypeUtils2.getBuiltIns(type);
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public ClassifierDescriptor getDeclarationDescriptor() {
        return null;
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        return Collections2.emptyList();
    }

    @Override // d0.e0.p.d.m0.k.u.a.CapturedTypeConstructor2
    public TypeProjection getProjection() {
        return this.a;
    }

    public int hashCode() {
        NewCapturedType2 newCapturedType2 = this.c;
        return newCapturedType2 == null ? super.hashCode() : newCapturedType2.hashCode();
    }

    public final void initializeSupertypes(List<? extends KotlinType3> list) {
        Intrinsics3.checkNotNullParameter(list, "supertypes");
        Function0<? extends List<? extends KotlinType3>> function0 = this.f3528b;
        this.f3528b = new c(list);
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    public String toString() {
        StringBuilder sbU = outline.U("CapturedType(");
        sbU.append(getProjection());
        sbU.append(')');
        return sbU.toString();
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public List<KotlinType3> getSupertypes() {
        List<KotlinType3> list = (List) this.e.getValue();
        return list == null ? Collections2.emptyList() : list;
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public NewCapturedType2 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        TypeProjection typeProjectionRefine = getProjection().refine(kotlinTypeRefiner);
        Intrinsics3.checkNotNullExpressionValue(typeProjectionRefine, "projection.refine(kotlinTypeRefiner)");
        d dVar = this.f3528b == null ? null : new d(kotlinTypeRefiner);
        NewCapturedType2 newCapturedType2 = this.c;
        if (newCapturedType2 == null) {
            newCapturedType2 = this;
        }
        return new NewCapturedType2(typeProjectionRefine, dVar, newCapturedType2, this.d);
    }

    public /* synthetic */ NewCapturedType2(TypeProjection typeProjection, Function0 function0, NewCapturedType2 newCapturedType2, TypeParameterDescriptor typeParameterDescriptor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeProjection, (i & 2) != 0 ? null : function0, (i & 4) != 0 ? null : newCapturedType2, (i & 8) != 0 ? null : typeParameterDescriptor);
    }

    public /* synthetic */ NewCapturedType2(TypeProjection typeProjection, List list, NewCapturedType2 newCapturedType2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeProjection, list, (i & 4) != 0 ? null : newCapturedType2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewCapturedType2(TypeProjection typeProjection, List<? extends KotlinType3> list, NewCapturedType2 newCapturedType2) {
        this(typeProjection, new a(list), newCapturedType2, null, 8, null);
        Intrinsics3.checkNotNullParameter(typeProjection, "projection");
        Intrinsics3.checkNotNullParameter(list, "supertypes");
    }
}
