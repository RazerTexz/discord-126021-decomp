package p507d0.p513e0.p514p.p515d.p517m0.p567n.p572p1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p555u.p556a.C11806d;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p555u.p556a.InterfaceC11804b;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11908a1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11914c1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11916d0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11920e1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11926g1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12015y;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12016y0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.C11992a;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.p1.b */
/* JADX INFO: compiled from: CapturedTypeApproximation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11996b {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.p1.b$a */
    /* JADX INFO: compiled from: CapturedTypeApproximation.kt */
    public static final class a extends AbstractC12240o implements Function1<AbstractC11932i1, Boolean> {

        /* JADX INFO: renamed from: j */
        public static final a f24858j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(AbstractC11932i1 abstractC11932i1) {
            C12238m.checkNotNullExpressionValue(abstractC11932i1, "it");
            return Boolean.valueOf(C11806d.isCaptured(abstractC11932i1));
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00a5  */
    /* JADX INFO: renamed from: a */
    public static final AbstractC11913c0 m10023a(AbstractC11913c0 abstractC11913c0, List<C11998d> list) {
        C12016y0 c12016y0;
        abstractC11913c0.getArguments().size();
        list.size();
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
        for (C11998d c11998d : list) {
            EnumC11935j1 enumC11935j1 = EnumC11935j1.OUT_VARIANCE;
            EnumC11935j1 enumC11935j2 = EnumC11935j1.INVARIANT;
            c11998d.isConsistent();
            if (C12238m.areEqual(c11998d.getInProjection(), c11998d.getOutProjection())) {
                c12016y0 = new C12016y0(c11998d.getInProjection());
            } else {
                EnumC11935j1 variance = c11998d.getTypeParameter().getVariance();
                EnumC11935j1 enumC11935j3 = EnumC11935j1.IN_VARIANCE;
                if (variance == enumC11935j3) {
                    c12016y0 = new C12016y0(c11998d.getInProjection());
                } else if (AbstractC11288h.isNothing(c11998d.getInProjection()) && c11998d.getTypeParameter().getVariance() != enumC11935j3) {
                    if (enumC11935j1 == c11998d.getTypeParameter().getVariance()) {
                        enumC11935j1 = enumC11935j2;
                    }
                    c12016y0 = new C12016y0(enumC11935j1, c11998d.getOutProjection());
                } else if (AbstractC11288h.isNullableAny(c11998d.getOutProjection())) {
                    if (enumC11935j3 != c11998d.getTypeParameter().getVariance()) {
                        enumC11935j2 = enumC11935j3;
                    }
                    c12016y0 = new C12016y0(enumC11935j2, c11998d.getInProjection());
                } else {
                    if (enumC11935j1 == c11998d.getTypeParameter().getVariance()) {
                        enumC11935j1 = enumC11935j2;
                    }
                    c12016y0 = new C12016y0(enumC11935j1, c11998d.getOutProjection());
                }
            }
            arrayList.add(c12016y0);
        }
        return C11908a1.replace$default(abstractC11913c0, arrayList, null, null, 6, null);
    }

    public static final C11995a<AbstractC11913c0> approximateCapturedTypes(AbstractC11913c0 abstractC11913c0) {
        Object objM10023a;
        C11998d c11998d;
        C12238m.checkNotNullParameter(abstractC11913c0, "type");
        if (C12015y.isFlexible(abstractC11913c0)) {
            C11995a<AbstractC11913c0> c11995aApproximateCapturedTypes = approximateCapturedTypes(C12015y.lowerIfFlexible(abstractC11913c0));
            C11995a<AbstractC11913c0> c11995aApproximateCapturedTypes2 = approximateCapturedTypes(C12015y.upperIfFlexible(abstractC11913c0));
            C11916d0 c11916d0 = C11916d0.f24748a;
            return new C11995a<>(C11926g1.inheritEnhancement(C11916d0.flexibleType(C12015y.lowerIfFlexible(c11995aApproximateCapturedTypes.getLower()), C12015y.upperIfFlexible(c11995aApproximateCapturedTypes2.getLower())), abstractC11913c0), C11926g1.inheritEnhancement(C11916d0.flexibleType(C12015y.lowerIfFlexible(c11995aApproximateCapturedTypes.getUpper()), C12015y.upperIfFlexible(c11995aApproximateCapturedTypes2.getUpper())), abstractC11913c0));
        }
        InterfaceC12008u0 constructor = abstractC11913c0.getConstructor();
        boolean z2 = true;
        if (C11806d.isCaptured(abstractC11913c0)) {
            InterfaceC12012w0 projection = ((InterfaceC11804b) constructor).getProjection();
            AbstractC11913c0 type = projection.getType();
            C12238m.checkNotNullExpressionValue(type, "typeProjection.type");
            AbstractC11913c0 abstractC11913c0MakeNullableIfNeeded = C11920e1.makeNullableIfNeeded(type, abstractC11913c0.isMarkedNullable());
            C12238m.checkNotNullExpressionValue(abstractC11913c0MakeNullableIfNeeded, "makeNullableIfNeeded(this, type.isMarkedNullable)");
            int iOrdinal = projection.getProjectionKind().ordinal();
            if (iOrdinal == 1) {
                AbstractC11934j0 nullableAnyType = C11992a.getBuiltIns(abstractC11913c0).getNullableAnyType();
                C12238m.checkNotNullExpressionValue(nullableAnyType, "type.builtIns.nullableAnyType");
                return new C11995a<>(abstractC11913c0MakeNullableIfNeeded, nullableAnyType);
            }
            if (iOrdinal != 2) {
                throw new AssertionError(C12238m.stringPlus("Only nontrivial projections should have been captured, not: ", projection));
            }
            AbstractC11934j0 nothingType = C11992a.getBuiltIns(abstractC11913c0).getNothingType();
            C12238m.checkNotNullExpressionValue(nothingType, "type.builtIns.nothingType");
            AbstractC11913c0 abstractC11913c0MakeNullableIfNeeded2 = C11920e1.makeNullableIfNeeded((AbstractC11913c0) nothingType, abstractC11913c0.isMarkedNullable());
            C12238m.checkNotNullExpressionValue(abstractC11913c0MakeNullableIfNeeded2, "makeNullableIfNeeded(this, type.isMarkedNullable)");
            return new C11995a<>(abstractC11913c0MakeNullableIfNeeded2, abstractC11913c0MakeNullableIfNeeded);
        }
        if (abstractC11913c0.getArguments().isEmpty() || abstractC11913c0.getArguments().size() != constructor.getParameters().size()) {
            return new C11995a<>(abstractC11913c0, abstractC11913c0);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<InterfaceC12012w0> arguments = abstractC11913c0.getArguments();
        List<InterfaceC11477z0> parameters = constructor.getParameters();
        C12238m.checkNotNullExpressionValue(parameters, "typeConstructor.parameters");
        for (Pair pair : C12163u.zip(arguments, parameters)) {
            InterfaceC12012w0 interfaceC12012w0 = (InterfaceC12012w0) pair.component1();
            InterfaceC11477z0 interfaceC11477z0 = (InterfaceC11477z0) pair.component2();
            C12238m.checkNotNullExpressionValue(interfaceC11477z0, "typeParameter");
            int iOrdinal2 = C11914c1.combine(interfaceC11477z0.getVariance(), interfaceC12012w0).ordinal();
            if (iOrdinal2 == 0) {
                AbstractC11913c0 type2 = interfaceC12012w0.getType();
                C12238m.checkNotNullExpressionValue(type2, "type");
                AbstractC11913c0 type3 = interfaceC12012w0.getType();
                C12238m.checkNotNullExpressionValue(type3, "type");
                c11998d = new C11998d(interfaceC11477z0, type2, type3);
            } else if (iOrdinal2 == 1) {
                AbstractC11913c0 type4 = interfaceC12012w0.getType();
                C12238m.checkNotNullExpressionValue(type4, "type");
                AbstractC11934j0 nullableAnyType2 = C11836a.getBuiltIns(interfaceC11477z0).getNullableAnyType();
                C12238m.checkNotNullExpressionValue(nullableAnyType2, "typeParameter.builtIns.nullableAnyType");
                c11998d = new C11998d(interfaceC11477z0, type4, nullableAnyType2);
            } else {
                if (iOrdinal2 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                AbstractC11934j0 nothingType2 = C11836a.getBuiltIns(interfaceC11477z0).getNothingType();
                C12238m.checkNotNullExpressionValue(nothingType2, "typeParameter.builtIns.nothingType");
                AbstractC11913c0 type5 = interfaceC12012w0.getType();
                C12238m.checkNotNullExpressionValue(type5, "type");
                c11998d = new C11998d(interfaceC11477z0, nothingType2, type5);
            }
            if (interfaceC12012w0.isStarProjection()) {
                arrayList.add(c11998d);
                arrayList2.add(c11998d);
            } else {
                C11995a<AbstractC11913c0> c11995aApproximateCapturedTypes3 = approximateCapturedTypes(c11998d.getInProjection());
                AbstractC11913c0 abstractC11913c0Component1 = c11995aApproximateCapturedTypes3.component1();
                AbstractC11913c0 abstractC11913c0Component2 = c11995aApproximateCapturedTypes3.component2();
                C11995a<AbstractC11913c0> c11995aApproximateCapturedTypes4 = approximateCapturedTypes(c11998d.getOutProjection());
                C11995a c11995a = new C11995a(new C11998d(c11998d.getTypeParameter(), abstractC11913c0Component2, c11995aApproximateCapturedTypes4.component1()), new C11998d(c11998d.getTypeParameter(), abstractC11913c0Component1, c11995aApproximateCapturedTypes4.component2()));
                C11998d c11998d2 = (C11998d) c11995a.component1();
                C11998d c11998d3 = (C11998d) c11995a.component2();
                arrayList.add(c11998d2);
                arrayList2.add(c11998d3);
            }
        }
        if (arrayList.isEmpty()) {
            z2 = false;
            break;
        }
        Iterator it = arrayList.iterator();
        do {
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
        } while (!(!((C11998d) it.next()).isConsistent()));
        if (z2) {
            objM10023a = C11992a.getBuiltIns(abstractC11913c0).getNothingType();
            C12238m.checkNotNullExpressionValue(objM10023a, "type.builtIns.nothingType");
        } else {
            objM10023a = m10023a(abstractC11913c0, arrayList);
        }
        return new C11995a<>(objM10023a, m10023a(abstractC11913c0, arrayList2));
    }

    public static final InterfaceC12012w0 approximateCapturedTypesIfNecessary(InterfaceC12012w0 interfaceC12012w0, boolean z2) {
        if (interfaceC12012w0 == null) {
            return null;
        }
        if (interfaceC12012w0.isStarProjection()) {
            return interfaceC12012w0;
        }
        AbstractC11913c0 type = interfaceC12012w0.getType();
        C12238m.checkNotNullExpressionValue(type, "typeProjection.type");
        if (!C11920e1.contains(type, a.f24858j)) {
            return interfaceC12012w0;
        }
        EnumC11935j1 projectionKind = interfaceC12012w0.getProjectionKind();
        C12238m.checkNotNullExpressionValue(projectionKind, "typeProjection.projectionKind");
        if (projectionKind == EnumC11935j1.OUT_VARIANCE) {
            return new C12016y0(projectionKind, approximateCapturedTypes(type).getUpper());
        }
        if (z2) {
            return new C12016y0(projectionKind, approximateCapturedTypes(type).getLower());
        }
        C11914c1 c11914c1Create = C11914c1.create(new C11997c());
        C12238m.checkNotNullExpressionValue(c11914c1Create, "create(object : TypeConstructorSubstitution() {\n        override fun get(key: TypeConstructor): TypeProjection? {\n            val capturedTypeConstructor = key as? CapturedTypeConstructor ?: return null\n            if (capturedTypeConstructor.projection.isStarProjection) {\n                return TypeProjectionImpl(Variance.OUT_VARIANCE, capturedTypeConstructor.projection.type)\n            }\n            return capturedTypeConstructor.projection\n        }\n    })");
        return c11914c1Create.substituteWithoutApproximation(interfaceC12012w0);
    }
}
