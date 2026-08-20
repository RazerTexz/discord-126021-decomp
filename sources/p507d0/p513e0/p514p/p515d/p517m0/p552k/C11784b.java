package p507d0.p513e0.p514p.p515d.p517m0.p552k;

import java.util.Collection;
import kotlin.jvm.functions.Function2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11331e0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.InterfaceC11946f;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.b */
/* JADX INFO: compiled from: DescriptorEquivalenceForOverrides.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11784b {

    /* JADX INFO: renamed from: a */
    public static final C11784b f24391a = new C11784b();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.b$a */
    /* JADX INFO: compiled from: DescriptorEquivalenceForOverrides.kt */
    public static final class a extends AbstractC12240o implements Function2<InterfaceC11450m, InterfaceC11450m, Boolean> {

        /* JADX INFO: renamed from: j */
        public static final a f24392j = new a();

        public a() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Boolean invoke(InterfaceC11450m interfaceC11450m, InterfaceC11450m interfaceC11450m2) {
            return Boolean.valueOf(invoke2(interfaceC11450m, interfaceC11450m2));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(InterfaceC11450m interfaceC11450m, InterfaceC11450m interfaceC11450m2) {
            return false;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.b$b */
    /* JADX INFO: compiled from: DescriptorEquivalenceForOverrides.kt */
    public static final class b implements InterfaceC11946f.a {

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ boolean f24394b;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ InterfaceC11318a f24395c;

        /* JADX INFO: renamed from: d */
        public final /* synthetic */ InterfaceC11318a f24396d;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.k.b$b$a */
        /* JADX INFO: compiled from: DescriptorEquivalenceForOverrides.kt */
        public static final class a extends AbstractC12240o implements Function2<InterfaceC11450m, InterfaceC11450m, Boolean> {

            /* JADX INFO: renamed from: $a */
            public final /* synthetic */ InterfaceC11318a f24397$a;

            /* JADX INFO: renamed from: $b */
            public final /* synthetic */ InterfaceC11318a f24398$b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(InterfaceC11318a interfaceC11318a, InterfaceC11318a interfaceC11318a2) {
                super(2);
                this.f24397$a = interfaceC11318a;
                this.f24398$b = interfaceC11318a2;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Boolean invoke(InterfaceC11450m interfaceC11450m, InterfaceC11450m interfaceC11450m2) {
                return Boolean.valueOf(invoke2(interfaceC11450m, interfaceC11450m2));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(InterfaceC11450m interfaceC11450m, InterfaceC11450m interfaceC11450m2) {
                return C12238m.areEqual(interfaceC11450m, this.f24397$a) && C12238m.areEqual(interfaceC11450m2, this.f24398$b);
            }
        }

        public b(boolean z2, InterfaceC11318a interfaceC11318a, InterfaceC11318a interfaceC11318a2) {
            this.f24394b = z2;
            this.f24395c = interfaceC11318a;
            this.f24396d = interfaceC11318a2;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.InterfaceC11946f.a
        public final boolean equals(InterfaceC12008u0 interfaceC12008u0, InterfaceC12008u0 interfaceC12008u1) {
            C12238m.checkNotNullParameter(interfaceC12008u0, "c1");
            C12238m.checkNotNullParameter(interfaceC12008u1, "c2");
            if (C12238m.areEqual(interfaceC12008u0, interfaceC12008u1)) {
                return true;
            }
            InterfaceC11352h declarationDescriptor = interfaceC12008u0.getDeclarationDescriptor();
            InterfaceC11352h declarationDescriptor2 = interfaceC12008u1.getDeclarationDescriptor();
            if ((declarationDescriptor instanceof InterfaceC11477z0) && (declarationDescriptor2 instanceof InterfaceC11477z0)) {
                return C11784b.this.m9917a((InterfaceC11477z0) declarationDescriptor, (InterfaceC11477z0) declarationDescriptor2, this.f24394b, new a(this.f24395c, this.f24396d));
            }
            return false;
        }
    }

    public static /* synthetic */ boolean areCallableDescriptorsEquivalent$default(C11784b c11784b, InterfaceC11318a interfaceC11318a, InterfaceC11318a interfaceC11318a2, boolean z2, boolean z3, boolean z4, AbstractC11947g abstractC11947g, int i, Object obj) {
        return c11784b.areCallableDescriptorsEquivalent(interfaceC11318a, interfaceC11318a2, z2, (i & 8) != 0 ? true : z3, (i & 16) != 0 ? false : z4, abstractC11947g);
    }

    public static /* synthetic */ boolean areEquivalent$default(C11784b c11784b, InterfaceC11450m interfaceC11450m, InterfaceC11450m interfaceC11450m2, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 8) != 0) {
            z3 = true;
        }
        return c11784b.areEquivalent(interfaceC11450m, interfaceC11450m2, z2, z3);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m9917a(InterfaceC11477z0 interfaceC11477z0, InterfaceC11477z0 interfaceC11477z1, boolean z2, Function2<? super InterfaceC11450m, ? super InterfaceC11450m, Boolean> function2) {
        if (C12238m.areEqual(interfaceC11477z0, interfaceC11477z1)) {
            return true;
        }
        return !C12238m.areEqual(interfaceC11477z0.getContainingDeclaration(), interfaceC11477z1.getContainingDeclaration()) && m9918b(interfaceC11477z0, interfaceC11477z1, function2, z2) && interfaceC11477z0.getIndex() == interfaceC11477z1.getIndex();
    }

    public final boolean areCallableDescriptorsEquivalent(InterfaceC11318a interfaceC11318a, InterfaceC11318a interfaceC11318a2, boolean z2, boolean z3, boolean z4, AbstractC11947g abstractC11947g) {
        C12238m.checkNotNullParameter(interfaceC11318a, "a");
        C12238m.checkNotNullParameter(interfaceC11318a2, "b");
        C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
        if (C12238m.areEqual(interfaceC11318a, interfaceC11318a2)) {
            return true;
        }
        if (!C12238m.areEqual(interfaceC11318a.getName(), interfaceC11318a2.getName())) {
            return false;
        }
        if (z3 && (interfaceC11318a instanceof InterfaceC11474y) && (interfaceC11318a2 instanceof InterfaceC11474y) && ((InterfaceC11474y) interfaceC11318a).isExpect() != ((InterfaceC11474y) interfaceC11318a2).isExpect()) {
            return false;
        }
        if ((C12238m.areEqual(interfaceC11318a.getContainingDeclaration(), interfaceC11318a2.getContainingDeclaration()) && (!z2 || !C12238m.areEqual(m9919c(interfaceC11318a), m9919c(interfaceC11318a2)))) || C11787e.isLocal(interfaceC11318a) || C11787e.isLocal(interfaceC11318a2) || !m9918b(interfaceC11318a, interfaceC11318a2, a.f24392j, z2)) {
            return false;
        }
        C11793k c11793kCreate = C11793k.create(abstractC11947g, new b(z2, interfaceC11318a, interfaceC11318a2));
        C12238m.checkNotNullExpressionValue(c11793kCreate, "fun areCallableDescriptorsEquivalent(\n        a: CallableDescriptor,\n        b: CallableDescriptor,\n        allowCopiesFromTheSameDeclaration: Boolean,\n        distinguishExpectsAndNonExpects: Boolean = true,\n        ignoreReturnType: Boolean = false,\n        kotlinTypeRefiner: KotlinTypeRefiner\n    ): Boolean {\n        if (a == b) return true\n        if (a.name != b.name) return false\n        if (distinguishExpectsAndNonExpects && a is MemberDescriptor && b is MemberDescriptor && a.isExpect != b.isExpect) return false\n        if (a.containingDeclaration == b.containingDeclaration) {\n            if (!allowCopiesFromTheSameDeclaration) return false\n            if (a.singleSource() != b.singleSource()) return false\n        }\n\n        // Distinct locals are not equivalent\n        if (DescriptorUtils.isLocal(a) || DescriptorUtils.isLocal(b)) return false\n\n        if (!ownersEquivalent(a, b, { _, _ -> false }, allowCopiesFromTheSameDeclaration)) return false\n\n        val overridingUtil = OverridingUtil.create(kotlinTypeRefiner) eq@{ c1, c2 ->\n            if (c1 == c2) return@eq true\n\n            val d1 = c1.declarationDescriptor\n            val d2 = c2.declarationDescriptor\n\n            if (d1 !is TypeParameterDescriptor || d2 !is TypeParameterDescriptor) return@eq false\n\n            areTypeParametersEquivalent(d1, d2, allowCopiesFromTheSameDeclaration) { x, y -> x == a && y == b }\n        }\n\n        return overridingUtil.isOverridableBy(a, b, null, !ignoreReturnType).result == OverrideCompatibilityInfo.Result.OVERRIDABLE\n                && overridingUtil.isOverridableBy(b, a, null, !ignoreReturnType).result == OverrideCompatibilityInfo.Result.OVERRIDABLE\n\n    }");
        C11793k.d.a result = c11793kCreate.isOverridableBy(interfaceC11318a, interfaceC11318a2, null, !z4).getResult();
        C11793k.d.a aVar = C11793k.d.a.OVERRIDABLE;
        return result == aVar && c11793kCreate.isOverridableBy(interfaceC11318a2, interfaceC11318a, null, z4 ^ true).getResult() == aVar;
    }

    public final boolean areEquivalent(InterfaceC11450m interfaceC11450m, InterfaceC11450m interfaceC11450m2, boolean z2, boolean z3) {
        if ((interfaceC11450m instanceof InterfaceC11330e) && (interfaceC11450m2 instanceof InterfaceC11330e)) {
            return C12238m.areEqual(((InterfaceC11330e) interfaceC11450m).getTypeConstructor(), ((InterfaceC11330e) interfaceC11450m2).getTypeConstructor());
        }
        if ((interfaceC11450m instanceof InterfaceC11477z0) && (interfaceC11450m2 instanceof InterfaceC11477z0)) {
            return m9917a((InterfaceC11477z0) interfaceC11450m, (InterfaceC11477z0) interfaceC11450m2, z2, C11785c.f24399j);
        }
        if ((interfaceC11450m instanceof InterfaceC11318a) && (interfaceC11450m2 instanceof InterfaceC11318a)) {
            return areCallableDescriptorsEquivalent$default(this, (InterfaceC11318a) interfaceC11450m, (InterfaceC11318a) interfaceC11450m2, z2, z3, false, AbstractC11947g.a.f24807a, 16, null);
        }
        return ((interfaceC11450m instanceof InterfaceC11331e0) && (interfaceC11450m2 instanceof InterfaceC11331e0)) ? C12238m.areEqual(((InterfaceC11331e0) interfaceC11450m).getFqName(), ((InterfaceC11331e0) interfaceC11450m2).getFqName()) : C12238m.areEqual(interfaceC11450m, interfaceC11450m2);
    }

    /* JADX INFO: renamed from: b */
    public final boolean m9918b(InterfaceC11450m interfaceC11450m, InterfaceC11450m interfaceC11450m2, Function2<? super InterfaceC11450m, ? super InterfaceC11450m, Boolean> function2, boolean z2) {
        InterfaceC11450m containingDeclaration = interfaceC11450m.getContainingDeclaration();
        InterfaceC11450m containingDeclaration2 = interfaceC11450m2.getContainingDeclaration();
        return ((containingDeclaration instanceof InterfaceC11321b) || (containingDeclaration2 instanceof InterfaceC11321b)) ? function2.invoke(containingDeclaration, containingDeclaration2).booleanValue() : areEquivalent$default(this, containingDeclaration, containingDeclaration2, z2, false, 8, null);
    }

    /* JADX INFO: renamed from: c */
    public final InterfaceC11467u0 m9919c(InterfaceC11318a interfaceC11318a) {
        while (interfaceC11318a instanceof InterfaceC11321b) {
            InterfaceC11321b interfaceC11321b = (InterfaceC11321b) interfaceC11318a;
            if (interfaceC11321b.getKind() != InterfaceC11321b.a.FAKE_OVERRIDE) {
                break;
            }
            Collection<? extends InterfaceC11321b> overriddenDescriptors = interfaceC11321b.getOverriddenDescriptors();
            C12238m.checkNotNullExpressionValue(overriddenDescriptors, "overriddenDescriptors");
            interfaceC11318a = (InterfaceC11321b) C12163u.singleOrNull(overriddenDescriptors);
            if (interfaceC11318a == null) {
                return null;
            }
        }
        return interfaceC11318a.getSource();
    }
}
