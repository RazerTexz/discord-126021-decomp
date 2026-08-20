package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11475y0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11396v;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11822n;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.d0 */
/* JADX INFO: compiled from: KotlinTypeFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11916d0 {

    /* JADX INFO: renamed from: a */
    public static final C11916d0 f24748a = new C11916d0();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.d0$a */
    /* JADX INFO: compiled from: KotlinTypeFactory.kt */
    public static final class a extends AbstractC12240o implements Function1 {

        /* JADX INFO: renamed from: j */
        public static final a f24749j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Void invoke(AbstractC11947g abstractC11947g) {
            C12238m.checkNotNullParameter(abstractC11947g, "$noName_0");
            return null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.d0$b */
    /* JADX INFO: compiled from: KotlinTypeFactory.kt */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final AbstractC11934j0 f24750a;

        /* JADX INFO: renamed from: b */
        public final InterfaceC12008u0 f24751b;

        public b(AbstractC11934j0 abstractC11934j0, InterfaceC12008u0 interfaceC12008u0) {
            this.f24750a = abstractC11934j0;
            this.f24751b = interfaceC12008u0;
        }

        public final AbstractC11934j0 getExpandedType() {
            return this.f24750a;
        }

        public final InterfaceC12008u0 getRefinedConstructor() {
            return this.f24751b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.d0$c */
    /* JADX INFO: compiled from: KotlinTypeFactory.kt */
    public static final class c extends AbstractC12240o implements Function1<AbstractC11947g, AbstractC11934j0> {
        public final /* synthetic */ InterfaceC11344g $annotations;
        public final /* synthetic */ List<InterfaceC12012w0> $arguments;
        public final /* synthetic */ InterfaceC12008u0 $constructor;
        public final /* synthetic */ boolean $nullable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(InterfaceC12008u0 interfaceC12008u0, List<? extends InterfaceC12012w0> list, InterfaceC11344g interfaceC11344g, boolean z2) {
            super(1);
            this.$constructor = interfaceC12008u0;
            this.$arguments = list;
            this.$annotations = interfaceC11344g;
            this.$nullable = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public final AbstractC11934j0 invoke(AbstractC11947g abstractC11947g) {
            C12238m.checkNotNullParameter(abstractC11947g, "refiner");
            b bVarAccess$refineConstructor = C11916d0.access$refineConstructor(C11916d0.this, this.$constructor, abstractC11947g, this.$arguments);
            if (bVarAccess$refineConstructor == null) {
                return null;
            }
            AbstractC11934j0 expandedType = bVarAccess$refineConstructor.getExpandedType();
            if (expandedType != null) {
                return expandedType;
            }
            InterfaceC11344g interfaceC11344g = this.$annotations;
            InterfaceC12008u0 refinedConstructor = bVarAccess$refineConstructor.getRefinedConstructor();
            C12238m.checkNotNull(refinedConstructor);
            return C11916d0.simpleType(interfaceC11344g, refinedConstructor, this.$arguments, this.$nullable, abstractC11947g);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.d0$d */
    /* JADX INFO: compiled from: KotlinTypeFactory.kt */
    public static final class d extends AbstractC12240o implements Function1<AbstractC11947g, AbstractC11934j0> {
        public final /* synthetic */ InterfaceC11344g $annotations;
        public final /* synthetic */ List<InterfaceC12012w0> $arguments;
        public final /* synthetic */ InterfaceC12008u0 $constructor;
        public final /* synthetic */ InterfaceC11770i $memberScope;
        public final /* synthetic */ boolean $nullable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(InterfaceC12008u0 interfaceC12008u0, List<? extends InterfaceC12012w0> list, InterfaceC11344g interfaceC11344g, boolean z2, InterfaceC11770i interfaceC11770i) {
            super(1);
            this.$constructor = interfaceC12008u0;
            this.$arguments = list;
            this.$annotations = interfaceC11344g;
            this.$nullable = z2;
            this.$memberScope = interfaceC11770i;
        }

        @Override // kotlin.jvm.functions.Function1
        public final AbstractC11934j0 invoke(AbstractC11947g abstractC11947g) {
            C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
            b bVarAccess$refineConstructor = C11916d0.access$refineConstructor(C11916d0.this, this.$constructor, abstractC11947g, this.$arguments);
            if (bVarAccess$refineConstructor == null) {
                return null;
            }
            AbstractC11934j0 expandedType = bVarAccess$refineConstructor.getExpandedType();
            if (expandedType != null) {
                return expandedType;
            }
            InterfaceC11344g interfaceC11344g = this.$annotations;
            InterfaceC12008u0 refinedConstructor = bVarAccess$refineConstructor.getRefinedConstructor();
            C12238m.checkNotNull(refinedConstructor);
            return C11916d0.simpleTypeWithNonTrivialMemberScope(interfaceC11344g, refinedConstructor, this.$arguments, this.$nullable, this.$memberScope);
        }
    }

    static {
        a aVar = a.f24749j;
    }

    public static final b access$refineConstructor(C11916d0 c11916d0, InterfaceC12008u0 interfaceC12008u0, AbstractC11947g abstractC11947g, List list) {
        b bVar;
        Objects.requireNonNull(c11916d0);
        InterfaceC11352h declarationDescriptor = interfaceC12008u0.getDeclarationDescriptor();
        InterfaceC11352h interfaceC11352hRefineDescriptor = declarationDescriptor == null ? null : abstractC11947g.refineDescriptor(declarationDescriptor);
        if (interfaceC11352hRefineDescriptor == null) {
            return null;
        }
        if (interfaceC11352hRefineDescriptor instanceof InterfaceC11475y0) {
            bVar = new b(computeExpandedType((InterfaceC11475y0) interfaceC11352hRefineDescriptor, list), null);
        } else {
            InterfaceC12008u0 interfaceC12008u0Refine = interfaceC11352hRefineDescriptor.getTypeConstructor().refine(abstractC11947g);
            C12238m.checkNotNullExpressionValue(interfaceC12008u0Refine, "descriptor.typeConstructor.refine(kotlinTypeRefiner)");
            bVar = new b(null, interfaceC12008u0Refine);
        }
        return bVar;
    }

    public static final AbstractC11934j0 computeExpandedType(InterfaceC11475y0 interfaceC11475y0, List<? extends InterfaceC12012w0> list) {
        C12238m.checkNotNullParameter(interfaceC11475y0, "<this>");
        C12238m.checkNotNullParameter(list, "arguments");
        return new C12000q0(InterfaceC12004s0.a.f24876a, false).expand(C12002r0.f24866a.create(null, interfaceC11475y0, list), InterfaceC11344g.f22735f.getEMPTY());
    }

    public static final AbstractC11932i1 flexibleType(AbstractC11934j0 abstractC11934j0, AbstractC11934j0 abstractC11934j1) {
        C12238m.checkNotNullParameter(abstractC11934j0, "lowerBound");
        C12238m.checkNotNullParameter(abstractC11934j1, "upperBound");
        return C12238m.areEqual(abstractC11934j0, abstractC11934j1) ? abstractC11934j0 : new C12011w(abstractC11934j0, abstractC11934j1);
    }

    public static final AbstractC11934j0 integerLiteralType(InterfaceC11344g interfaceC11344g, C11822n c11822n, boolean z2) {
        C12238m.checkNotNullParameter(interfaceC11344g, "annotations");
        C12238m.checkNotNullParameter(c11822n, "constructor");
        List listEmptyList = C12147n.emptyList();
        InterfaceC11770i interfaceC11770iCreateErrorScope = C12005t.createErrorScope("Scope for integer literal type", true);
        C12238m.checkNotNullExpressionValue(interfaceC11770iCreateErrorScope, "createErrorScope(\"Scope for integer literal type\", true)");
        return simpleTypeWithNonTrivialMemberScope(interfaceC11344g, c11822n, listEmptyList, z2, interfaceC11770iCreateErrorScope);
    }

    public static final AbstractC11934j0 simpleNotNullType(InterfaceC11344g interfaceC11344g, InterfaceC11330e interfaceC11330e, List<? extends InterfaceC12012w0> list) {
        C12238m.checkNotNullParameter(interfaceC11344g, "annotations");
        C12238m.checkNotNullParameter(interfaceC11330e, "descriptor");
        C12238m.checkNotNullParameter(list, "arguments");
        InterfaceC12008u0 typeConstructor = interfaceC11330e.getTypeConstructor();
        C12238m.checkNotNullExpressionValue(typeConstructor, "descriptor.typeConstructor");
        return simpleType$default(interfaceC11344g, typeConstructor, list, false, null, 16, null);
    }

    public static final AbstractC11934j0 simpleType(InterfaceC11344g interfaceC11344g, InterfaceC12008u0 interfaceC12008u0, List<? extends InterfaceC12012w0> list, boolean z2, AbstractC11947g abstractC11947g) {
        InterfaceC11770i interfaceC11770iCreateScopeForKotlinType;
        C12238m.checkNotNullParameter(interfaceC11344g, "annotations");
        C12238m.checkNotNullParameter(interfaceC12008u0, "constructor");
        C12238m.checkNotNullParameter(list, "arguments");
        if (interfaceC11344g.isEmpty() && list.isEmpty() && !z2 && interfaceC12008u0.getDeclarationDescriptor() != null) {
            InterfaceC11352h declarationDescriptor = interfaceC12008u0.getDeclarationDescriptor();
            C12238m.checkNotNull(declarationDescriptor);
            AbstractC11934j0 defaultType = declarationDescriptor.getDefaultType();
            C12238m.checkNotNullExpressionValue(defaultType, "constructor.declarationDescriptor!!.defaultType");
            return defaultType;
        }
        C11916d0 c11916d0 = f24748a;
        InterfaceC11352h declarationDescriptor2 = interfaceC12008u0.getDeclarationDescriptor();
        if (declarationDescriptor2 instanceof InterfaceC11477z0) {
            interfaceC11770iCreateScopeForKotlinType = declarationDescriptor2.getDefaultType().getMemberScope();
        } else if (declarationDescriptor2 instanceof InterfaceC11330e) {
            if (abstractC11947g == null) {
                abstractC11947g = C11836a.getKotlinTypeRefiner(C11836a.getModule(declarationDescriptor2));
            }
            interfaceC11770iCreateScopeForKotlinType = list.isEmpty() ? C11396v.getRefinedUnsubstitutedMemberScopeIfPossible((InterfaceC11330e) declarationDescriptor2, abstractC11947g) : C11396v.getRefinedMemberScopeIfPossible((InterfaceC11330e) declarationDescriptor2, AbstractC12010v0.f24889b.create(interfaceC12008u0, list), abstractC11947g);
        } else if (declarationDescriptor2 instanceof InterfaceC11475y0) {
            interfaceC11770iCreateScopeForKotlinType = C12005t.createErrorScope(C12238m.stringPlus("Scope for abbreviation: ", ((InterfaceC11475y0) declarationDescriptor2).getName()), true);
            C12238m.checkNotNullExpressionValue(interfaceC11770iCreateScopeForKotlinType, "createErrorScope(\"Scope for abbreviation: ${descriptor.name}\", true)");
        } else {
            if (!(interfaceC12008u0 instanceof C11907a0)) {
                throw new IllegalStateException("Unsupported classifier: " + declarationDescriptor2 + " for constructor: " + interfaceC12008u0);
            }
            interfaceC11770iCreateScopeForKotlinType = ((C11907a0) interfaceC12008u0).createScopeForKotlinType();
        }
        return simpleTypeWithNonTrivialMemberScope(interfaceC11344g, interfaceC12008u0, list, z2, interfaceC11770iCreateScopeForKotlinType, c11916d0.new c(interfaceC12008u0, list, interfaceC11344g, z2));
    }

    public static /* synthetic */ AbstractC11934j0 simpleType$default(InterfaceC11344g interfaceC11344g, InterfaceC12008u0 interfaceC12008u0, List list, boolean z2, AbstractC11947g abstractC11947g, int i, Object obj) {
        if ((i & 16) != 0) {
            abstractC11947g = null;
        }
        return simpleType(interfaceC11344g, interfaceC12008u0, list, z2, abstractC11947g);
    }

    public static final AbstractC11934j0 simpleTypeWithNonTrivialMemberScope(InterfaceC11344g interfaceC11344g, InterfaceC12008u0 interfaceC12008u0, List<? extends InterfaceC12012w0> list, boolean z2, InterfaceC11770i interfaceC11770i) {
        C12238m.checkNotNullParameter(interfaceC11344g, "annotations");
        C12238m.checkNotNullParameter(interfaceC12008u0, "constructor");
        C12238m.checkNotNullParameter(list, "arguments");
        C12238m.checkNotNullParameter(interfaceC11770i, "memberScope");
        C11937k0 c11937k0 = new C11937k0(interfaceC12008u0, list, z2, interfaceC11770i, f24748a.new d(interfaceC12008u0, list, interfaceC11344g, z2, interfaceC11770i));
        return interfaceC11344g.isEmpty() ? c11937k0 : new C11927h(c11937k0, interfaceC11344g);
    }

    public static final AbstractC11934j0 simpleTypeWithNonTrivialMemberScope(InterfaceC11344g interfaceC11344g, InterfaceC12008u0 interfaceC12008u0, List<? extends InterfaceC12012w0> list, boolean z2, InterfaceC11770i interfaceC11770i, Function1<? super AbstractC11947g, ? extends AbstractC11934j0> function1) {
        C12238m.checkNotNullParameter(interfaceC11344g, "annotations");
        C12238m.checkNotNullParameter(interfaceC12008u0, "constructor");
        C12238m.checkNotNullParameter(list, "arguments");
        C12238m.checkNotNullParameter(interfaceC11770i, "memberScope");
        C12238m.checkNotNullParameter(function1, "refinedTypeFactory");
        C11937k0 c11937k0 = new C11937k0(interfaceC12008u0, list, z2, interfaceC11770i, function1);
        return interfaceC11344g.isEmpty() ? c11937k0 : new C11927h(c11937k0, interfaceC11344g);
    }
}
