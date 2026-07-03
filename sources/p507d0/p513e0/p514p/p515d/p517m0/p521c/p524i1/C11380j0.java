package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11476z;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11327d;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11475y0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11786d;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11914c1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11968m0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12015y;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.C12250y;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.j0 */
/* JADX INFO: compiled from: TypeAliasConstructorDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11380j0 extends AbstractC11391q implements InterfaceC11378i0 {

    /* JADX INFO: renamed from: M */
    public static final a f22887M = new a(null);

    /* JADX INFO: renamed from: N */
    public static final /* synthetic */ KProperty<Object>[] f22888N = {C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(C11380j0.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;"))};

    /* JADX INFO: renamed from: O */
    public final InterfaceC11905o f22889O;

    /* JADX INFO: renamed from: P */
    public final InterfaceC11475y0 f22890P;

    /* JADX INFO: renamed from: Q */
    public InterfaceC11327d f22891Q;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.j0$a */
    /* JADX INFO: compiled from: TypeAliasConstructorDescriptor.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final C11914c1 access$getTypeSubstitutorForUnderlyingClass(a aVar, InterfaceC11475y0 interfaceC11475y0) {
            Objects.requireNonNull(aVar);
            if (interfaceC11475y0.getClassDescriptor() == null) {
                return null;
            }
            return C11914c1.create(interfaceC11475y0.getExpandedType());
        }

        public final InterfaceC11378i0 createIfAvailable(InterfaceC11905o interfaceC11905o, InterfaceC11475y0 interfaceC11475y0, InterfaceC11327d interfaceC11327d) {
            InterfaceC11327d interfaceC11327dSubstitute;
            C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
            C12238m.checkNotNullParameter(interfaceC11475y0, "typeAliasDescriptor");
            C12238m.checkNotNullParameter(interfaceC11327d, "constructor");
            C11914c1 c11914c1Create = interfaceC11475y0.getClassDescriptor() == null ? null : C11914c1.create(interfaceC11475y0.getExpandedType());
            if (c11914c1Create == null || (interfaceC11327dSubstitute = interfaceC11327d.substitute(c11914c1Create)) == null) {
                return null;
            }
            InterfaceC11344g annotations = interfaceC11327d.getAnnotations();
            InterfaceC11321b.a kind = interfaceC11327d.getKind();
            C12238m.checkNotNullExpressionValue(kind, "constructor.kind");
            InterfaceC11467u0 source = interfaceC11475y0.getSource();
            C12238m.checkNotNullExpressionValue(source, "typeAliasDescriptor.source");
            C11380j0 c11380j0 = new C11380j0(interfaceC11905o, interfaceC11475y0, interfaceC11327dSubstitute, null, annotations, kind, source, null);
            List<InterfaceC11326c1> substitutedValueParameters = AbstractC11391q.getSubstitutedValueParameters(c11380j0, interfaceC11327d.getValueParameters(), c11914c1Create);
            if (substitutedValueParameters == null) {
                return null;
            }
            AbstractC11934j0 abstractC11934j0LowerIfFlexible = C12015y.lowerIfFlexible(interfaceC11327dSubstitute.getReturnType().unwrap());
            AbstractC11934j0 defaultType = interfaceC11475y0.getDefaultType();
            C12238m.checkNotNullExpressionValue(defaultType, "typeAliasDescriptor.defaultType");
            AbstractC11934j0 abstractC11934j0WithAbbreviation = C11968m0.withAbbreviation(abstractC11934j0LowerIfFlexible, defaultType);
            InterfaceC11459q0 dispatchReceiverParameter = interfaceC11327d.getDispatchReceiverParameter();
            c11380j0.initialize(dispatchReceiverParameter != null ? C11786d.createExtensionReceiverParameterForCallable(c11380j0, c11914c1Create.safeSubstitute(dispatchReceiverParameter.getType(), EnumC11935j1.INVARIANT), InterfaceC11344g.f22735f.getEMPTY()) : null, null, interfaceC11475y0.getDeclaredTypeParameters(), substitutedValueParameters, abstractC11934j0WithAbbreviation, EnumC11476z.FINAL, interfaceC11475y0.getVisibility());
            return c11380j0;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.j0$b */
    /* JADX INFO: compiled from: TypeAliasConstructorDescriptor.kt */
    public static final class b extends AbstractC12240o implements Function0<C11380j0> {
        public final /* synthetic */ InterfaceC11327d $underlyingConstructorDescriptor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC11327d interfaceC11327d) {
            super(0);
            this.$underlyingConstructorDescriptor = interfaceC11327d;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final C11380j0 invoke() {
            InterfaceC11905o storageManager = C11380j0.this.getStorageManager();
            InterfaceC11475y0 typeAliasDescriptor = C11380j0.this.getTypeAliasDescriptor();
            InterfaceC11327d interfaceC11327d = this.$underlyingConstructorDescriptor;
            C11380j0 c11380j0 = C11380j0.this;
            InterfaceC11344g annotations = interfaceC11327d.getAnnotations();
            InterfaceC11321b.a kind = this.$underlyingConstructorDescriptor.getKind();
            C12238m.checkNotNullExpressionValue(kind, "underlyingConstructorDescriptor.kind");
            InterfaceC11467u0 source = C11380j0.this.getTypeAliasDescriptor().getSource();
            C12238m.checkNotNullExpressionValue(source, "typeAliasDescriptor.source");
            C11380j0 c11380j1 = new C11380j0(storageManager, typeAliasDescriptor, interfaceC11327d, c11380j0, annotations, kind, source, null);
            C11380j0 c11380j2 = C11380j0.this;
            InterfaceC11327d interfaceC11327d2 = this.$underlyingConstructorDescriptor;
            C11914c1 c11914c1Access$getTypeSubstitutorForUnderlyingClass = a.access$getTypeSubstitutorForUnderlyingClass(C11380j0.f22887M, c11380j2.getTypeAliasDescriptor());
            if (c11914c1Access$getTypeSubstitutorForUnderlyingClass == null) {
                return null;
            }
            InterfaceC11459q0 dispatchReceiverParameter = interfaceC11327d2.getDispatchReceiverParameter();
            c11380j1.initialize(null, dispatchReceiverParameter == null ? null : dispatchReceiverParameter.substitute(c11914c1Access$getTypeSubstitutorForUnderlyingClass), c11380j2.getTypeAliasDescriptor().getDeclaredTypeParameters(), c11380j2.getValueParameters(), c11380j2.getReturnType(), EnumC11476z.FINAL, c11380j2.getTypeAliasDescriptor().getVisibility());
            return c11380j1;
        }
    }

    public C11380j0(InterfaceC11905o interfaceC11905o, InterfaceC11475y0 interfaceC11475y0, InterfaceC11327d interfaceC11327d, InterfaceC11378i0 interfaceC11378i0, InterfaceC11344g interfaceC11344g, InterfaceC11321b.a aVar, InterfaceC11467u0 interfaceC11467u0) {
        super(interfaceC11475y0, interfaceC11378i0, interfaceC11344g, C11716e.special("<init>"), aVar, interfaceC11467u0);
        this.f22889O = interfaceC11905o;
        this.f22890P = interfaceC11475y0;
        setActual(getTypeAliasDescriptor().isActual());
        interfaceC11905o.createNullableLazyValue(new b(interfaceC11327d));
        this.f22891Q = interfaceC11327d;
    }

    public /* synthetic */ C11380j0(InterfaceC11905o interfaceC11905o, InterfaceC11475y0 interfaceC11475y0, InterfaceC11327d interfaceC11327d, InterfaceC11378i0 interfaceC11378i0, InterfaceC11344g interfaceC11344g, InterfaceC11321b.a aVar, InterfaceC11467u0 interfaceC11467u0, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC11905o, interfaceC11475y0, interfaceC11327d, interfaceC11378i0, interfaceC11344g, aVar, interfaceC11467u0);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q
    /* JADX INFO: renamed from: b */
    public AbstractC11391q mo9373b(InterfaceC11450m interfaceC11450m, InterfaceC11472x interfaceC11472x, InterfaceC11321b.a aVar, C11716e c11716e, InterfaceC11344g interfaceC11344g, InterfaceC11467u0 interfaceC11467u0) {
        C12238m.checkNotNullParameter(interfaceC11450m, "newOwner");
        C12238m.checkNotNullParameter(aVar, "kind");
        C12238m.checkNotNullParameter(interfaceC11344g, "annotations");
        C12238m.checkNotNullParameter(interfaceC11467u0, "source");
        return new C11380j0(this.f22889O, getTypeAliasDescriptor(), getUnderlyingConstructorDescriptor(), this, interfaceC11344g, InterfaceC11321b.a.DECLARATION, interfaceC11467u0);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11448l
    public InterfaceC11330e getConstructedClass() {
        InterfaceC11330e constructedClass = getUnderlyingConstructorDescriptor().getConstructedClass();
        C12238m.checkNotNullExpressionValue(constructedClass, "underlyingConstructorDescriptor.constructedClass");
        return constructedClass;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a
    public AbstractC11913c0 getReturnType() {
        AbstractC11913c0 returnType = super.getReturnType();
        C12238m.checkNotNull(returnType);
        return returnType;
    }

    public final InterfaceC11905o getStorageManager() {
        return this.f22889O;
    }

    public InterfaceC11475y0 getTypeAliasDescriptor() {
        return this.f22890P;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.InterfaceC11378i0
    public InterfaceC11327d getUnderlyingConstructorDescriptor() {
        return this.f22891Q;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11448l
    public boolean isPrimary() {
        return getUnderlyingConstructorDescriptor().isPrimary();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b
    public InterfaceC11378i0 copy(InterfaceC11450m interfaceC11450m, EnumC11476z enumC11476z, AbstractC11466u abstractC11466u, InterfaceC11321b.a aVar, boolean z2) {
        C12238m.checkNotNullParameter(interfaceC11450m, "newOwner");
        C12238m.checkNotNullParameter(enumC11476z, "modality");
        C12238m.checkNotNullParameter(abstractC11466u, "visibility");
        C12238m.checkNotNullParameter(aVar, "kind");
        InterfaceC11472x interfaceC11472xBuild = newCopyBuilder().setOwner(interfaceC11450m).setModality(enumC11476z).setVisibility(abstractC11466u).setKind(aVar).setCopyOverrides(z2).build();
        Objects.requireNonNull(interfaceC11472xBuild, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (InterfaceC11378i0) interfaceC11472xBuild;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11383l, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public InterfaceC11475y0 getContainingDeclaration() {
        return getTypeAliasDescriptor();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11471w0
    public InterfaceC11378i0 substitute(C11914c1 c11914c1) {
        C12238m.checkNotNullParameter(c11914c1, "substitutor");
        InterfaceC11472x interfaceC11472xSubstitute = super.substitute(c11914c1);
        Objects.requireNonNull(interfaceC11472xSubstitute, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        C11380j0 c11380j0 = (C11380j0) interfaceC11472xSubstitute;
        C11914c1 c11914c1Create = C11914c1.create(c11380j0.getReturnType());
        C12238m.checkNotNullExpressionValue(c11914c1Create, "create(substitutedTypeAliasConstructor.returnType)");
        InterfaceC11327d interfaceC11327dSubstitute = getUnderlyingConstructorDescriptor().getOriginal().substitute(c11914c1Create);
        if (interfaceC11327dSubstitute == null) {
            return null;
        }
        c11380j0.f22891Q = interfaceC11327dSubstitute;
        return c11380j0;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11383l, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11381k, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public InterfaceC11378i0 getOriginal() {
        return (InterfaceC11378i0) super.getOriginal();
    }
}
