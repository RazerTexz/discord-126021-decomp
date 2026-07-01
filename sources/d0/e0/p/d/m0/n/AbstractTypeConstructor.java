package d0.e0.p.d.m0.n;

import d0.Lazy5;
import d0.LazyJVM;
import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.SupertypeLoopChecker;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.m.storage5;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner2;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.g, reason: use source file name */
/* JADX INFO: compiled from: AbstractTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractTypeConstructor implements TypeConstructor {
    public final storage5<b> a;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.g$a */
    /* JADX INFO: compiled from: AbstractTypeConstructor.kt */
    public final class a implements TypeConstructor {
        public final KotlinTypeRefiner a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Lazy f3524b;
        public final /* synthetic */ AbstractTypeConstructor c;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.n.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AbstractTypeConstructor.kt */
        public static final class C0412a extends Lambda implements Function0<List<? extends KotlinType>> {
            public final /* synthetic */ AbstractTypeConstructor this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0412a(AbstractTypeConstructor abstractTypeConstructor) {
                super(0);
                this.this$1 = abstractTypeConstructor;
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends KotlinType> invoke() {
                return KotlinTypeRefiner2.refineTypes(a.this.a, this.this$1.getSupertypes());
            }
        }

        public a(AbstractTypeConstructor abstractTypeConstructor, KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics3.checkNotNullParameter(abstractTypeConstructor, "this$0");
            Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            this.c = abstractTypeConstructor;
            this.a = kotlinTypeRefiner;
            this.f3524b = LazyJVM.lazy(Lazy5.PUBLICATION, new C0412a(abstractTypeConstructor));
        }

        public boolean equals(Object obj) {
            return this.c.equals(obj);
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public KotlinBuiltIns getBuiltIns() {
            KotlinBuiltIns builtIns = this.c.getBuiltIns();
            Intrinsics3.checkNotNullExpressionValue(builtIns, "this@AbstractTypeConstructor.builtIns");
            return builtIns;
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public ClassifierDescriptor getDeclarationDescriptor() {
            return this.c.getDeclarationDescriptor();
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> parameters = this.c.getParameters();
            Intrinsics3.checkNotNullExpressionValue(parameters, "this@AbstractTypeConstructor.parameters");
            return parameters;
        }

        public int hashCode() {
            return this.c.hashCode();
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public boolean isDenotable() {
            return this.c.isDenotable();
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            return this.c.refine(kotlinTypeRefiner);
        }

        public String toString() {
            return this.c.toString();
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public List<KotlinType> getSupertypes() {
            return (List) this.f3524b.getValue();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.g$b */
    /* JADX INFO: compiled from: AbstractTypeConstructor.kt */
    public static final class b {
        public final Collection<KotlinType> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<? extends KotlinType> f3525b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Collection<? extends KotlinType> collection) {
            Intrinsics3.checkNotNullParameter(collection, "allSupertypes");
            this.a = collection;
            this.f3525b = CollectionsJVM.listOf(ErrorUtils.c);
        }

        public final Collection<KotlinType> getAllSupertypes() {
            return this.a;
        }

        public final List<KotlinType> getSupertypesWithoutCycles() {
            return this.f3525b;
        }

        public final void setSupertypesWithoutCycles(List<? extends KotlinType> list) {
            Intrinsics3.checkNotNullParameter(list, "<set-?>");
            this.f3525b = list;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.g$c */
    /* JADX INFO: compiled from: AbstractTypeConstructor.kt */
    public static final class c extends Lambda implements Function0<b> {
        public c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return new b(AbstractTypeConstructor.this.a());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.g$d */
    /* JADX INFO: compiled from: AbstractTypeConstructor.kt */
    public static final class d extends Lambda implements Function1<Boolean, b> {
        public static final d j = new d();

        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ b invoke(Boolean bool) {
            return invoke(bool.booleanValue());
        }

        public final b invoke(boolean z2) {
            return new b(CollectionsJVM.listOf(ErrorUtils.c));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.g$e */
    /* JADX INFO: compiled from: AbstractTypeConstructor.kt */
    public static final class e extends Lambda implements Function1<b, Unit> {

        /* JADX INFO: renamed from: d0.e0.p.d.m0.n.g$e$a */
        /* JADX INFO: compiled from: AbstractTypeConstructor.kt */
        public static final class a extends Lambda implements Function1<TypeConstructor, Iterable<? extends KotlinType>> {
            public final /* synthetic */ AbstractTypeConstructor this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(AbstractTypeConstructor abstractTypeConstructor) {
                super(1);
                this.this$0 = abstractTypeConstructor;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Iterable<KotlinType> invoke(TypeConstructor typeConstructor) {
                Intrinsics3.checkNotNullParameter(typeConstructor, "it");
                return AbstractTypeConstructor.access$computeNeighbours(this.this$0, typeConstructor, false);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.n.g$e$b */
        /* JADX INFO: compiled from: AbstractTypeConstructor.kt */
        public static final class b extends Lambda implements Function1<KotlinType, Unit> {
            public final /* synthetic */ AbstractTypeConstructor this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(AbstractTypeConstructor abstractTypeConstructor) {
                super(1);
                this.this$0 = abstractTypeConstructor;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KotlinType kotlinType) {
                invoke2(kotlinType);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KotlinType kotlinType) {
                Intrinsics3.checkNotNullParameter(kotlinType, "it");
                this.this$0.f(kotlinType);
            }
        }

        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(b bVar) {
            invoke2(bVar);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(b bVar) {
            Intrinsics3.checkNotNullParameter(bVar, "supertypes");
            Collection<KotlinType> collectionFindLoopsInSupertypesAndDisconnect = AbstractTypeConstructor.this.d().findLoopsInSupertypesAndDisconnect(AbstractTypeConstructor.this, bVar.getAllSupertypes(), new a(AbstractTypeConstructor.this), new b(AbstractTypeConstructor.this));
            if (collectionFindLoopsInSupertypesAndDisconnect.isEmpty()) {
                KotlinType kotlinTypeB = AbstractTypeConstructor.this.b();
                collectionFindLoopsInSupertypesAndDisconnect = kotlinTypeB == null ? null : CollectionsJVM.listOf(kotlinTypeB);
                if (collectionFindLoopsInSupertypesAndDisconnect == null) {
                    collectionFindLoopsInSupertypesAndDisconnect = Collections2.emptyList();
                }
            }
            Objects.requireNonNull(AbstractTypeConstructor.this);
            AbstractTypeConstructor abstractTypeConstructor = AbstractTypeConstructor.this;
            List<KotlinType> list = collectionFindLoopsInSupertypesAndDisconnect instanceof List ? (List) collectionFindLoopsInSupertypesAndDisconnect : null;
            if (list == null) {
                list = _Collections.toList(collectionFindLoopsInSupertypesAndDisconnect);
            }
            bVar.setSupertypesWithoutCycles(abstractTypeConstructor.e(list));
        }
    }

    public AbstractTypeConstructor(StorageManager storageManager) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        this.a = storageManager.createLazyValueWithPostCompute(new c(), d.j, new e());
    }

    public static final Collection access$computeNeighbours(AbstractTypeConstructor abstractTypeConstructor, TypeConstructor typeConstructor, boolean z2) {
        Objects.requireNonNull(abstractTypeConstructor);
        AbstractTypeConstructor abstractTypeConstructor2 = typeConstructor instanceof AbstractTypeConstructor ? (AbstractTypeConstructor) typeConstructor : null;
        List listPlus = abstractTypeConstructor2 != null ? _Collections.plus((Collection) abstractTypeConstructor2.a.invoke().getAllSupertypes(), (Iterable) abstractTypeConstructor2.c(z2)) : null;
        if (listPlus != null) {
            return listPlus;
        }
        Collection<KotlinType> supertypes = typeConstructor.getSupertypes();
        Intrinsics3.checkNotNullExpressionValue(supertypes, "supertypes");
        return supertypes;
    }

    public abstract Collection<KotlinType> a();

    public KotlinType b() {
        return null;
    }

    public Collection<KotlinType> c(boolean z2) {
        return Collections2.emptyList();
    }

    public abstract SupertypeLoopChecker d();

    public List<KotlinType> e(List<KotlinType> list) {
        Intrinsics3.checkNotNullParameter(list, "supertypes");
        return list;
    }

    public void f(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "type");
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public abstract ClassifierDescriptor getDeclarationDescriptor();

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new a(this, kotlinTypeRefiner);
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public List<KotlinType> getSupertypes() {
        return this.a.invoke().getSupertypesWithoutCycles();
    }
}
