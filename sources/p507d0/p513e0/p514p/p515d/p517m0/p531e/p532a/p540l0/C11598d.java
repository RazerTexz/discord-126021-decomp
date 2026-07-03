package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.InterfaceC11525c;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p537m.C11559g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12009v;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11916d0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11919e0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11920e1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11926g1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11968m0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12015y;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC11931i0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.C11992a;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.d */
/* JADX INFO: compiled from: typeEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11598d {

    /* JADX INFO: renamed from: a */
    public final InterfaceC11525c f23445a;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.d$a */
    /* JADX INFO: compiled from: typeEnhancement.kt */
    public static class a {

        /* JADX INFO: renamed from: a */
        public final AbstractC11913c0 f23446a;

        /* JADX INFO: renamed from: b */
        public final int f23447b;

        /* JADX INFO: renamed from: c */
        public final boolean f23448c;

        public a(AbstractC11913c0 abstractC11913c0, int i, boolean z2) {
            C12238m.checkNotNullParameter(abstractC11913c0, "type");
            this.f23446a = abstractC11913c0;
            this.f23447b = i;
            this.f23448c = z2;
        }

        public final int getSubtreeSize() {
            return this.f23447b;
        }

        public AbstractC11913c0 getType() {
            return this.f23446a;
        }

        public final AbstractC11913c0 getTypeIfChanged() {
            AbstractC11913c0 type = getType();
            if (getWereChanges()) {
                return type;
            }
            return null;
        }

        public final boolean getWereChanges() {
            return this.f23448c;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.d$b */
    /* JADX INFO: compiled from: typeEnhancement.kt */
    public static final class b extends a {

        /* JADX INFO: renamed from: d */
        public final AbstractC11934j0 f23449d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AbstractC11934j0 abstractC11934j0, int i, boolean z2) {
            super(abstractC11934j0, i, z2);
            C12238m.checkNotNullParameter(abstractC11934j0, "type");
            this.f23449d = abstractC11934j0;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0.C11598d.a
        public AbstractC11934j0 getType() {
            return this.f23449d;
        }
    }

    public C11598d(InterfaceC11525c interfaceC11525c) {
        C12238m.checkNotNullParameter(interfaceC11525c, "javaResolverSettings");
        this.f23445a = interfaceC11525c;
    }

    /* JADX INFO: renamed from: a */
    public final b m9506a(AbstractC11934j0 abstractC11934j0, Function1<? super Integer, C11599e> function1, int i, EnumC11614t enumC11614t, boolean z2) {
        AbstractC11932i1 abstractC11932i1WrapEnhancement;
        int subtreeSize;
        InterfaceC12012w0 interfaceC12012w0CreateProjection;
        if (!C11615u.shouldEnhance(enumC11614t) && abstractC11934j0.getArguments().isEmpty()) {
            return new b(abstractC11934j0, 1, false);
        }
        InterfaceC11352h declarationDescriptor = abstractC11934j0.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return new b(abstractC11934j0, 1, false);
        }
        C11599e c11599eInvoke = function1.invoke(Integer.valueOf(i));
        C11597c c11597cAccess$enhanceMutability = C11618x.access$enhanceMutability(declarationDescriptor, c11599eInvoke, enumC11614t);
        InterfaceC11352h interfaceC11352h = (InterfaceC11352h) c11597cAccess$enhanceMutability.component1();
        InterfaceC11344g interfaceC11344gComponent2 = c11597cAccess$enhanceMutability.component2();
        InterfaceC12008u0 typeConstructor = interfaceC11352h.getTypeConstructor();
        C12238m.checkNotNullExpressionValue(typeConstructor, "enhancedClassifier.typeConstructor");
        int i2 = i + 1;
        boolean z3 = interfaceC11344gComponent2 != null;
        List<InterfaceC12012w0> arguments = abstractC11934j0.getArguments();
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(arguments, 10));
        int i3 = 0;
        for (Object obj : arguments) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                C12147n.throwIndexOverflow();
            }
            InterfaceC12012w0 interfaceC12012w0 = (InterfaceC12012w0) obj;
            if (interfaceC12012w0.isStarProjection()) {
                subtreeSize = i2 + 1;
                if (function1.invoke(Integer.valueOf(i2)).getNullability() != EnumC11602h.NOT_NULL || z2) {
                    interfaceC12012w0CreateProjection = C11920e1.makeStarProjection(interfaceC11352h.getTypeConstructor().getParameters().get(i3));
                    C12238m.checkNotNullExpressionValue(interfaceC12012w0CreateProjection, "{\n                    TypeUtils.makeStarProjection(enhancedClassifier.typeConstructor.parameters[localArgIndex])\n                }");
                } else {
                    AbstractC11913c0 abstractC11913c0MakeNotNullable = C11992a.makeNotNullable(interfaceC12012w0.getType().unwrap());
                    EnumC11935j1 projectionKind = interfaceC12012w0.getProjectionKind();
                    C12238m.checkNotNullExpressionValue(projectionKind, "arg.projectionKind");
                    interfaceC12012w0CreateProjection = C11992a.createProjection(abstractC11913c0MakeNotNullable, projectionKind, typeConstructor.getParameters().get(i3));
                }
            } else {
                a aVarM9507b = m9507b(interfaceC12012w0.getType().unwrap(), function1, i2);
                z3 = z3 || aVarM9507b.getWereChanges();
                subtreeSize = aVarM9507b.getSubtreeSize() + i2;
                AbstractC11913c0 type = aVarM9507b.getType();
                EnumC11935j1 projectionKind2 = interfaceC12012w0.getProjectionKind();
                C12238m.checkNotNullExpressionValue(projectionKind2, "arg.projectionKind");
                interfaceC12012w0CreateProjection = C11992a.createProjection(type, projectionKind2, typeConstructor.getParameters().get(i3));
            }
            i2 = subtreeSize;
            arrayList.add(interfaceC12012w0CreateProjection);
            i3 = i4;
        }
        C11597c c11597cAccess$getEnhancedNullability = C11618x.access$getEnhancedNullability(abstractC11934j0, c11599eInvoke, enumC11614t);
        boolean zBooleanValue = ((Boolean) c11597cAccess$getEnhancedNullability.component1()).booleanValue();
        InterfaceC11344g interfaceC11344gComponent3 = c11597cAccess$getEnhancedNullability.component2();
        int i5 = i2 - i;
        if (!(z3 || interfaceC11344gComponent3 != null)) {
            return new b(abstractC11934j0, i5, false);
        }
        boolean z4 = false;
        InterfaceC11344g interfaceC11344gAccess$compositeAnnotationsOrSingle = C11618x.access$compositeAnnotationsOrSingle(C12147n.listOfNotNull((Object[]) new InterfaceC11344g[]{abstractC11934j0.getAnnotations(), interfaceC11344gComponent2, interfaceC11344gComponent3}));
        C11916d0 c11916d0 = C11916d0.f24748a;
        AbstractC11934j0 abstractC11934j0SimpleType$default = C11916d0.simpleType$default(interfaceC11344gAccess$compositeAnnotationsOrSingle, typeConstructor, arrayList, zBooleanValue, null, 16, null);
        if (c11599eInvoke.isNotNullTypeParameter()) {
            if (this.f23445a.getCorrectNullabilityForNotNullTypeParameter()) {
                abstractC11932i1WrapEnhancement = abstractC11934j0SimpleType$default;
                abstractC11932i1WrapEnhancement = C11968m0.makeSimpleTypeDefinitelyNotNullOrNotNull(abstractC11934j0SimpleType$default, true);
            } else {
                abstractC11932i1WrapEnhancement = abstractC11934j0SimpleType$default;
                abstractC11932i1WrapEnhancement = new C11601g(abstractC11934j0SimpleType$default);
            }
        }
        if (interfaceC11344gComponent3 != null && c11599eInvoke.isNullabilityQualifierForWarning()) {
            z4 = true;
        }
        if (z4) {
            abstractC11932i1WrapEnhancement = C11926g1.wrapEnhancement(abstractC11934j0, abstractC11932i1WrapEnhancement);
        }
        return new b((AbstractC11934j0) abstractC11932i1WrapEnhancement, i5, true);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x005e  */
    /* JADX INFO: renamed from: b */
    public final a m9507b(AbstractC11932i1 abstractC11932i1, Function1<? super Integer, C11599e> function1, int i) {
        AbstractC11932i1 abstractC11932i1FlexibleType;
        if (C11919e0.isError(abstractC11932i1)) {
            return new a(abstractC11932i1, 1, false);
        }
        if (!(abstractC11932i1 instanceof AbstractC12009v)) {
            if (abstractC11932i1 instanceof AbstractC11934j0) {
                return m9506a((AbstractC11934j0) abstractC11932i1, function1, i, EnumC11614t.INFLEXIBLE, false);
            }
            throw new NoWhenBranchMatchedException();
        }
        boolean z2 = abstractC11932i1 instanceof InterfaceC11931i0;
        AbstractC12009v abstractC12009v = (AbstractC12009v) abstractC11932i1;
        b bVarM9506a = m9506a(abstractC12009v.getLowerBound(), function1, i, EnumC11614t.FLEXIBLE_LOWER, z2);
        b bVarM9506a2 = m9506a(abstractC12009v.getUpperBound(), function1, i, EnumC11614t.FLEXIBLE_UPPER, z2);
        bVarM9506a.getSubtreeSize();
        bVarM9506a2.getSubtreeSize();
        boolean z3 = bVarM9506a.getWereChanges() || bVarM9506a2.getWereChanges();
        AbstractC11934j0 type = bVarM9506a.getType();
        AbstractC11913c0 enhancement = C11926g1.getEnhancement(bVarM9506a2.getType());
        AbstractC11913c0 enhancement2 = C11926g1.getEnhancement(type);
        if (enhancement2 != null) {
            if (enhancement != null) {
                C11916d0 c11916d0 = C11916d0.f24748a;
                enhancement2 = C11916d0.flexibleType(C12015y.lowerIfFlexible(enhancement2), C12015y.upperIfFlexible(enhancement));
            }
        } else if (enhancement == null) {
            enhancement2 = null;
        } else {
            enhancement2 = enhancement;
            if (enhancement != null) {
                C11916d0 c11916d1 = C11916d0.f24748a;
                enhancement2 = C11916d0.flexibleType(C12015y.lowerIfFlexible(enhancement2), C12015y.upperIfFlexible(enhancement));
            }
        }
        if (z3) {
            if (abstractC11932i1 instanceof C11559g) {
                abstractC11932i1FlexibleType = new C11559g(bVarM9506a.getType(), bVarM9506a2.getType());
            } else {
                C11916d0 c11916d2 = C11916d0.f24748a;
                abstractC11932i1FlexibleType = C11916d0.flexibleType(bVarM9506a.getType(), bVarM9506a2.getType());
            }
            abstractC11932i1 = C11926g1.wrapEnhancement(abstractC11932i1FlexibleType, enhancement2);
        }
        return new a(abstractC11932i1, bVarM9506a.getSubtreeSize(), z3);
    }

    public final AbstractC11913c0 enhance(AbstractC11913c0 abstractC11913c0, Function1<? super Integer, C11599e> function1) {
        C12238m.checkNotNullParameter(abstractC11913c0, "<this>");
        C12238m.checkNotNullParameter(function1, "qualifiers");
        return m9507b(abstractC11913c0.unwrap(), function1, 0).getTypeIfChanged();
    }
}
