package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p537m;

import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import p507d0.C12116o;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.EnumC11508k;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11916d0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11919e0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12005t;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12015y;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12016y0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.m.f */
/* JADX INFO: compiled from: RawType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11558f extends AbstractC12018z0 {

    /* JADX INFO: renamed from: b */
    public static final C11558f f23432b = new C11558f();

    /* JADX INFO: renamed from: c */
    public static final C11553a f23433c;

    /* JADX INFO: renamed from: d */
    public static final C11553a f23434d;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.m.f$a */
    /* JADX INFO: compiled from: RawType.kt */
    public static final class a extends AbstractC12240o implements Function1<AbstractC11947g, AbstractC11934j0> {
        public final /* synthetic */ C11553a $attr;
        public final /* synthetic */ InterfaceC11330e $declaration;
        public final /* synthetic */ AbstractC11934j0 $type;
        public final /* synthetic */ C11558f this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC11330e interfaceC11330e, C11558f c11558f, AbstractC11934j0 abstractC11934j0, C11553a c11553a) {
            super(1);
            this.$declaration = interfaceC11330e;
            this.this$0 = c11558f;
            this.$type = abstractC11934j0;
            this.$attr = c11553a;
        }

        @Override // kotlin.jvm.functions.Function1
        public final AbstractC11934j0 invoke(AbstractC11947g abstractC11947g) {
            InterfaceC11330e interfaceC11330eFindClassAcrossModuleDependencies;
            C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
            InterfaceC11330e interfaceC11330e = this.$declaration;
            if (!(interfaceC11330e instanceof InterfaceC11330e)) {
                interfaceC11330e = null;
            }
            C11712a classId = interfaceC11330e == null ? null : C11836a.getClassId(interfaceC11330e);
            if (classId == null || (interfaceC11330eFindClassAcrossModuleDependencies = abstractC11947g.findClassAcrossModuleDependencies(classId)) == null || C12238m.areEqual(interfaceC11330eFindClassAcrossModuleDependencies, this.$declaration)) {
                return null;
            }
            return (AbstractC11934j0) this.this$0.m9501a(this.$type, interfaceC11330eFindClassAcrossModuleDependencies, this.$attr).getFirst();
        }
    }

    static {
        EnumC11508k enumC11508k = EnumC11508k.COMMON;
        f23433c = C11557e.toAttributes$default(enumC11508k, false, null, 3, null).withFlexibility(EnumC11554b.FLEXIBLE_LOWER_BOUND);
        f23434d = C11557e.toAttributes$default(enumC11508k, false, null, 3, null).withFlexibility(EnumC11554b.FLEXIBLE_UPPER_BOUND);
    }

    public static /* synthetic */ InterfaceC12012w0 computeProjection$default(C11558f c11558f, InterfaceC11477z0 interfaceC11477z0, C11553a c11553a, AbstractC11913c0 abstractC11913c0, int i, Object obj) {
        if ((i & 4) != 0) {
            abstractC11913c0 = C11557e.getErasedUpperBound$default(interfaceC11477z0, null, null, 3, null);
        }
        return c11558f.computeProjection(interfaceC11477z0, c11553a, abstractC11913c0);
    }

    /* JADX INFO: renamed from: a */
    public final Pair<AbstractC11934j0, Boolean> m9501a(AbstractC11934j0 abstractC11934j0, InterfaceC11330e interfaceC11330e, C11553a c11553a) {
        if (abstractC11934j0.getConstructor().getParameters().isEmpty()) {
            return C12116o.m10073to(abstractC11934j0, Boolean.FALSE);
        }
        if (AbstractC11288h.isArray(abstractC11934j0)) {
            InterfaceC12012w0 interfaceC12012w0 = abstractC11934j0.getArguments().get(0);
            EnumC11935j1 projectionKind = interfaceC12012w0.getProjectionKind();
            AbstractC11913c0 type = interfaceC12012w0.getType();
            C12238m.checkNotNullExpressionValue(type, "componentTypeProjection.type");
            List listListOf = C12145m.listOf(new C12016y0(projectionKind, m9502b(type)));
            C11916d0 c11916d0 = C11916d0.f24748a;
            return C12116o.m10073to(C11916d0.simpleType$default(abstractC11934j0.getAnnotations(), abstractC11934j0.getConstructor(), listListOf, abstractC11934j0.isMarkedNullable(), null, 16, null), Boolean.FALSE);
        }
        if (C11919e0.isError(abstractC11934j0)) {
            AbstractC11934j0 abstractC11934j0CreateErrorType = C12005t.createErrorType(C12238m.stringPlus("Raw error type: ", abstractC11934j0.getConstructor()));
            C12238m.checkNotNullExpressionValue(abstractC11934j0CreateErrorType, "createErrorType(\"Raw error type: ${type.constructor}\")");
            return C12116o.m10073to(abstractC11934j0CreateErrorType, Boolean.FALSE);
        }
        InterfaceC11770i memberScope = interfaceC11330e.getMemberScope(this);
        C12238m.checkNotNullExpressionValue(memberScope, "declaration.getMemberScope(RawSubstitution)");
        C11916d0 c11916d1 = C11916d0.f24748a;
        InterfaceC11344g annotations = abstractC11934j0.getAnnotations();
        InterfaceC12008u0 typeConstructor = interfaceC11330e.getTypeConstructor();
        C12238m.checkNotNullExpressionValue(typeConstructor, "declaration.typeConstructor");
        List<InterfaceC11477z0> parameters = interfaceC11330e.getTypeConstructor().getParameters();
        C12238m.checkNotNullExpressionValue(parameters, "declaration.typeConstructor.parameters");
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(parameters, 10));
        for (InterfaceC11477z0 interfaceC11477z0 : parameters) {
            C12238m.checkNotNullExpressionValue(interfaceC11477z0, "parameter");
            arrayList.add(computeProjection$default(this, interfaceC11477z0, c11553a, null, 4, null));
        }
        return C12116o.m10073to(C11916d0.simpleTypeWithNonTrivialMemberScope(annotations, typeConstructor, arrayList, abstractC11934j0.isMarkedNullable(), memberScope, new a(interfaceC11330e, this, abstractC11934j0, c11553a)), Boolean.TRUE);
    }

    /* JADX INFO: renamed from: b */
    public final AbstractC11913c0 m9502b(AbstractC11913c0 abstractC11913c0) {
        InterfaceC11352h declarationDescriptor = abstractC11913c0.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof InterfaceC11477z0) {
            return m9502b(C11557e.getErasedUpperBound$default((InterfaceC11477z0) declarationDescriptor, null, null, 3, null));
        }
        if (!(declarationDescriptor instanceof InterfaceC11330e)) {
            throw new IllegalStateException(C12238m.stringPlus("Unexpected declaration kind: ", declarationDescriptor).toString());
        }
        InterfaceC11352h declarationDescriptor2 = C12015y.upperIfFlexible(abstractC11913c0).getConstructor().getDeclarationDescriptor();
        if (!(declarationDescriptor2 instanceof InterfaceC11330e)) {
            throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + declarationDescriptor2 + "\" while for lower it's \"" + declarationDescriptor + '\"').toString());
        }
        Pair<AbstractC11934j0, Boolean> pairM9501a = m9501a(C12015y.lowerIfFlexible(abstractC11913c0), (InterfaceC11330e) declarationDescriptor, f23433c);
        AbstractC11934j0 abstractC11934j0Component1 = pairM9501a.component1();
        boolean zBooleanValue = pairM9501a.component2().booleanValue();
        Pair<AbstractC11934j0, Boolean> pairM9501a2 = m9501a(C12015y.upperIfFlexible(abstractC11913c0), (InterfaceC11330e) declarationDescriptor2, f23434d);
        AbstractC11934j0 abstractC11934j0Component2 = pairM9501a2.component1();
        boolean zBooleanValue2 = pairM9501a2.component2().booleanValue();
        if (zBooleanValue || zBooleanValue2) {
            return new C11559g(abstractC11934j0Component1, abstractC11934j0Component2);
        }
        C11916d0 c11916d0 = C11916d0.f24748a;
        return C11916d0.flexibleType(abstractC11934j0Component1, abstractC11934j0Component2);
    }

    public final InterfaceC12012w0 computeProjection(InterfaceC11477z0 interfaceC11477z0, C11553a c11553a, AbstractC11913c0 abstractC11913c0) {
        EnumC11935j1 enumC11935j1 = EnumC11935j1.INVARIANT;
        C12238m.checkNotNullParameter(interfaceC11477z0, "parameter");
        C12238m.checkNotNullParameter(c11553a, "attr");
        C12238m.checkNotNullParameter(abstractC11913c0, "erasedUpperBound");
        int iOrdinal = c11553a.getFlexibility().ordinal();
        if (iOrdinal != 0 && iOrdinal != 1) {
            if (iOrdinal == 2) {
                return new C12016y0(enumC11935j1, abstractC11913c0);
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!interfaceC11477z0.getVariance().getAllowsOutPosition()) {
            return new C12016y0(enumC11935j1, C11836a.getBuiltIns(interfaceC11477z0).getNothingType());
        }
        List<InterfaceC11477z0> parameters = abstractC11913c0.getConstructor().getParameters();
        C12238m.checkNotNullExpressionValue(parameters, "erasedUpperBound.constructor.parameters");
        return parameters.isEmpty() ^ true ? new C12016y0(EnumC11935j1.OUT_VARIANCE, abstractC11913c0) : C11557e.makeStarProjection(interfaceC11477z0, c11553a);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0
    public boolean isEmpty() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0
    public C12016y0 get(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "key");
        return new C12016y0(m9502b(abstractC11913c0));
    }
}
