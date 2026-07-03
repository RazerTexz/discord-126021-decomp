package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.C12083g;
import p507d0.EnumC12110i;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11473x0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11900j;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.C11948h;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.g */
/* JADX INFO: compiled from: AbstractTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11924g implements InterfaceC12008u0 {

    /* JADX INFO: renamed from: a */
    public final InterfaceC11900j<b> f24772a;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.g$a */
    /* JADX INFO: compiled from: AbstractTypeConstructor.kt */
    public final class a implements InterfaceC12008u0 {

        /* JADX INFO: renamed from: a */
        public final AbstractC11947g f24773a;

        /* JADX INFO: renamed from: b */
        public final Lazy f24774b;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ AbstractC11924g f24775c;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.n.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AbstractTypeConstructor.kt */
        public static final class C13336a extends AbstractC12240o implements Function0<List<? extends AbstractC11913c0>> {
            public final /* synthetic */ AbstractC11924g this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C13336a(AbstractC11924g abstractC11924g) {
                super(0);
                this.this$1 = abstractC11924g;
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends AbstractC11913c0> invoke() {
                return C11948h.refineTypes(a.this.f24773a, this.this$1.getSupertypes());
            }
        }

        public a(AbstractC11924g abstractC11924g, AbstractC11947g abstractC11947g) {
            C12238m.checkNotNullParameter(abstractC11924g, "this$0");
            C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
            this.f24775c = abstractC11924g;
            this.f24773a = abstractC11947g;
            this.f24774b = C12083g.lazy(EnumC12110i.PUBLICATION, new C13336a(abstractC11924g));
        }

        public boolean equals(Object obj) {
            return this.f24775c.equals(obj);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public AbstractC11288h getBuiltIns() {
            AbstractC11288h builtIns = this.f24775c.getBuiltIns();
            C12238m.checkNotNullExpressionValue(builtIns, "this@AbstractTypeConstructor.builtIns");
            return builtIns;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public InterfaceC11352h getDeclarationDescriptor() {
            return this.f24775c.getDeclarationDescriptor();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public List<InterfaceC11477z0> getParameters() {
            List<InterfaceC11477z0> parameters = this.f24775c.getParameters();
            C12238m.checkNotNullExpressionValue(parameters, "this@AbstractTypeConstructor.parameters");
            return parameters;
        }

        public int hashCode() {
            return this.f24775c.hashCode();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public boolean isDenotable() {
            return this.f24775c.isDenotable();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public InterfaceC12008u0 refine(AbstractC11947g abstractC11947g) {
            C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
            return this.f24775c.refine(abstractC11947g);
        }

        public String toString() {
            return this.f24775c.toString();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public List<AbstractC11913c0> getSupertypes() {
            return (List) this.f24774b.getValue();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.g$b */
    /* JADX INFO: compiled from: AbstractTypeConstructor.kt */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final Collection<AbstractC11913c0> f24776a;

        /* JADX INFO: renamed from: b */
        public List<? extends AbstractC11913c0> f24777b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Collection<? extends AbstractC11913c0> collection) {
            C12238m.checkNotNullParameter(collection, "allSupertypes");
            this.f24776a = collection;
            this.f24777b = C12145m.listOf(C12005t.f24879c);
        }

        public final Collection<AbstractC11913c0> getAllSupertypes() {
            return this.f24776a;
        }

        public final List<AbstractC11913c0> getSupertypesWithoutCycles() {
            return this.f24777b;
        }

        public final void setSupertypesWithoutCycles(List<? extends AbstractC11913c0> list) {
            C12238m.checkNotNullParameter(list, "<set-?>");
            this.f24777b = list;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.g$c */
    /* JADX INFO: compiled from: AbstractTypeConstructor.kt */
    public static final class c extends AbstractC12240o implements Function0<b> {
        public c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return new b(AbstractC11924g.this.mo9370a());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.g$d */
    /* JADX INFO: compiled from: AbstractTypeConstructor.kt */
    public static final class d extends AbstractC12240o implements Function1<Boolean, b> {

        /* JADX INFO: renamed from: j */
        public static final d f24778j = new d();

        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ b invoke(Boolean bool) {
            return invoke(bool.booleanValue());
        }

        public final b invoke(boolean z2) {
            return new b(C12145m.listOf(C12005t.f24879c));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.g$e */
    /* JADX INFO: compiled from: AbstractTypeConstructor.kt */
    public static final class e extends AbstractC12240o implements Function1<b, Unit> {

        /* JADX INFO: renamed from: d0.e0.p.d.m0.n.g$e$a */
        /* JADX INFO: compiled from: AbstractTypeConstructor.kt */
        public static final class a extends AbstractC12240o implements Function1<InterfaceC12008u0, Iterable<? extends AbstractC11913c0>> {
            public final /* synthetic */ AbstractC11924g this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(AbstractC11924g abstractC11924g) {
                super(1);
                this.this$0 = abstractC11924g;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Iterable<AbstractC11913c0> invoke(InterfaceC12008u0 interfaceC12008u0) {
                C12238m.checkNotNullParameter(interfaceC12008u0, "it");
                return AbstractC11924g.access$computeNeighbours(this.this$0, interfaceC12008u0, false);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.n.g$e$b */
        /* JADX INFO: compiled from: AbstractTypeConstructor.kt */
        public static final class b extends AbstractC12240o implements Function1<AbstractC11913c0, Unit> {
            public final /* synthetic */ AbstractC11924g this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(AbstractC11924g abstractC11924g) {
                super(1);
                this.this$0 = abstractC11924g;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AbstractC11913c0 abstractC11913c0) {
                invoke2(abstractC11913c0);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AbstractC11913c0 abstractC11913c0) {
                C12238m.checkNotNullParameter(abstractC11913c0, "it");
                this.this$0.mo9405f(abstractC11913c0);
            }
        }

        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(b bVar) {
            invoke2(bVar);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(b bVar) {
            C12238m.checkNotNullParameter(bVar, "supertypes");
            Collection<AbstractC11913c0> collectionFindLoopsInSupertypesAndDisconnect = AbstractC11924g.this.mo9371d().findLoopsInSupertypesAndDisconnect(AbstractC11924g.this, bVar.getAllSupertypes(), new a(AbstractC11924g.this), new b(AbstractC11924g.this));
            if (collectionFindLoopsInSupertypesAndDisconnect.isEmpty()) {
                AbstractC11913c0 abstractC11913c0Mo9403b = AbstractC11924g.this.mo9403b();
                collectionFindLoopsInSupertypesAndDisconnect = abstractC11913c0Mo9403b == null ? null : C12145m.listOf(abstractC11913c0Mo9403b);
                if (collectionFindLoopsInSupertypesAndDisconnect == null) {
                    collectionFindLoopsInSupertypesAndDisconnect = C12147n.emptyList();
                }
            }
            Objects.requireNonNull(AbstractC11924g.this);
            AbstractC11924g abstractC11924g = AbstractC11924g.this;
            List<AbstractC11913c0> list = collectionFindLoopsInSupertypesAndDisconnect instanceof List ? (List) collectionFindLoopsInSupertypesAndDisconnect : null;
            if (list == null) {
                list = C12163u.toList(collectionFindLoopsInSupertypesAndDisconnect);
            }
            bVar.setSupertypesWithoutCycles(abstractC11924g.mo9404e(list));
        }
    }

    public AbstractC11924g(InterfaceC11905o interfaceC11905o) {
        C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
        this.f24772a = interfaceC11905o.createLazyValueWithPostCompute(new c(), d.f24778j, new e());
    }

    public static final Collection access$computeNeighbours(AbstractC11924g abstractC11924g, InterfaceC12008u0 interfaceC12008u0, boolean z2) {
        Objects.requireNonNull(abstractC11924g);
        AbstractC11924g abstractC11924g2 = interfaceC12008u0 instanceof AbstractC11924g ? (AbstractC11924g) interfaceC12008u0 : null;
        List listPlus = abstractC11924g2 != null ? C12163u.plus((Collection) abstractC11924g2.f24772a.invoke().getAllSupertypes(), (Iterable) abstractC11924g2.mo9996c(z2)) : null;
        if (listPlus != null) {
            return listPlus;
        }
        Collection<AbstractC11913c0> supertypes = interfaceC12008u0.getSupertypes();
        C12238m.checkNotNullExpressionValue(supertypes, "supertypes");
        return supertypes;
    }

    /* JADX INFO: renamed from: a */
    public abstract Collection<AbstractC11913c0> mo9370a();

    /* JADX INFO: renamed from: b */
    public AbstractC11913c0 mo9403b() {
        return null;
    }

    /* JADX INFO: renamed from: c */
    public Collection<AbstractC11913c0> mo9996c(boolean z2) {
        return C12147n.emptyList();
    }

    /* JADX INFO: renamed from: d */
    public abstract InterfaceC11473x0 mo9371d();

    /* JADX INFO: renamed from: e */
    public List<AbstractC11913c0> mo9404e(List<AbstractC11913c0> list) {
        C12238m.checkNotNullParameter(list, "supertypes");
        return list;
    }

    /* JADX INFO: renamed from: f */
    public void mo9405f(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "type");
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public abstract InterfaceC11352h getDeclarationDescriptor();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public InterfaceC12008u0 refine(AbstractC11947g abstractC11947g) {
        C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
        return new a(this, abstractC11947g);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
    public List<AbstractC11913c0> getSupertypes() {
        return this.f24772a.invoke().getSupertypesWithoutCycles();
    }
}
