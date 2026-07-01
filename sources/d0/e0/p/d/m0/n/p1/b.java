package d0.e0.p.d.m0.n.p1;

import d0.e0.p.d.m0.b.h;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.a1;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.c1;
import d0.e0.p.d.m0.n.d0;
import d0.e0.p.d.m0.n.e1;
import d0.e0.p.d.m0.n.g1;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.u0;
import d0.e0.p.d.m0.n.w0;
import d0.e0.p.d.m0.n.y;
import d0.e0.p.d.m0.n.y0;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;

/* JADX INFO: compiled from: CapturedTypeApproximation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    /* JADX WARN: Code duplicated, block: B:29:0x00a5  */
    public static final c0 a(c0 c0Var, List<d> list) {
        y0 y0Var;
        c0Var.getArguments().size();
        list.size();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
        for (d dVar : list) {
            j1 j1Var = j1.OUT_VARIANCE;
            j1 j1Var2 = j1.INVARIANT;
            dVar.isConsistent();
            if (m.areEqual(dVar.getInProjection(), dVar.getOutProjection())) {
                y0Var = new y0(dVar.getInProjection());
            } else {
                j1 variance = dVar.getTypeParameter().getVariance();
                j1 j1Var3 = j1.IN_VARIANCE;
                if (variance == j1Var3) {
                    y0Var = new y0(dVar.getInProjection());
                } else if (h.isNothing(dVar.getInProjection()) && dVar.getTypeParameter().getVariance() != j1Var3) {
                    if (j1Var == dVar.getTypeParameter().getVariance()) {
                        j1Var = j1Var2;
                    }
                    y0Var = new y0(j1Var, dVar.getOutProjection());
                } else if (h.isNullableAny(dVar.getOutProjection())) {
                    if (j1Var3 != dVar.getTypeParameter().getVariance()) {
                        j1Var2 = j1Var3;
                    }
                    y0Var = new y0(j1Var2, dVar.getInProjection());
                } else {
                    if (j1Var == dVar.getTypeParameter().getVariance()) {
                        j1Var = j1Var2;
                    }
                    y0Var = new y0(j1Var, dVar.getOutProjection());
                }
            }
            arrayList.add(y0Var);
        }
        return a1.replace$default(c0Var, arrayList, null, null, 6, null);
    }

    public static final a<c0> approximateCapturedTypes(c0 c0Var) {
        Object objA;
        d dVar;
        m.checkNotNullParameter(c0Var, "type");
        if (y.isFlexible(c0Var)) {
            a<c0> aVarApproximateCapturedTypes = approximateCapturedTypes(y.lowerIfFlexible(c0Var));
            a<c0> aVarApproximateCapturedTypes2 = approximateCapturedTypes(y.upperIfFlexible(c0Var));
            d0 d0Var = d0.a;
            return new a<>(g1.inheritEnhancement(d0.flexibleType(y.lowerIfFlexible(aVarApproximateCapturedTypes.getLower()), y.upperIfFlexible(aVarApproximateCapturedTypes2.getLower())), c0Var), g1.inheritEnhancement(d0.flexibleType(y.lowerIfFlexible(aVarApproximateCapturedTypes.getUpper()), y.upperIfFlexible(aVarApproximateCapturedTypes2.getUpper())), c0Var));
        }
        u0 constructor = c0Var.getConstructor();
        boolean z2 = true;
        if (d0.e0.p.d.m0.k.u.a.d.isCaptured(c0Var)) {
            w0 projection = ((d0.e0.p.d.m0.k.u.a.b) constructor).getProjection();
            c0 type = projection.getType();
            m.checkNotNullExpressionValue(type, "typeProjection.type");
            c0 c0VarMakeNullableIfNeeded = e1.makeNullableIfNeeded(type, c0Var.isMarkedNullable());
            m.checkNotNullExpressionValue(c0VarMakeNullableIfNeeded, "makeNullableIfNeeded(this, type.isMarkedNullable)");
            int iOrdinal = projection.getProjectionKind().ordinal();
            if (iOrdinal == 1) {
                j0 nullableAnyType = d0.e0.p.d.m0.n.o1.a.getBuiltIns(c0Var).getNullableAnyType();
                m.checkNotNullExpressionValue(nullableAnyType, "type.builtIns.nullableAnyType");
                return new a<>(c0VarMakeNullableIfNeeded, nullableAnyType);
            }
            if (iOrdinal != 2) {
                throw new AssertionError(m.stringPlus("Only nontrivial projections should have been captured, not: ", projection));
            }
            j0 nothingType = d0.e0.p.d.m0.n.o1.a.getBuiltIns(c0Var).getNothingType();
            m.checkNotNullExpressionValue(nothingType, "type.builtIns.nothingType");
            c0 c0VarMakeNullableIfNeeded2 = e1.makeNullableIfNeeded((c0) nothingType, c0Var.isMarkedNullable());
            m.checkNotNullExpressionValue(c0VarMakeNullableIfNeeded2, "makeNullableIfNeeded(this, type.isMarkedNullable)");
            return new a<>(c0VarMakeNullableIfNeeded2, c0VarMakeNullableIfNeeded);
        }
        if (c0Var.getArguments().isEmpty() || c0Var.getArguments().size() != constructor.getParameters().size()) {
            return new a<>(c0Var, c0Var);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<w0> arguments = c0Var.getArguments();
        List<z0> parameters = constructor.getParameters();
        m.checkNotNullExpressionValue(parameters, "typeConstructor.parameters");
        for (Pair pair : u.zip(arguments, parameters)) {
            w0 w0Var = (w0) pair.component1();
            z0 z0Var = (z0) pair.component2();
            m.checkNotNullExpressionValue(z0Var, "typeParameter");
            int iOrdinal2 = c1.combine(z0Var.getVariance(), w0Var).ordinal();
            if (iOrdinal2 == 0) {
                c0 type2 = w0Var.getType();
                m.checkNotNullExpressionValue(type2, "type");
                c0 type3 = w0Var.getType();
                m.checkNotNullExpressionValue(type3, "type");
                dVar = new d(z0Var, type2, type3);
            } else if (iOrdinal2 == 1) {
                c0 type4 = w0Var.getType();
                m.checkNotNullExpressionValue(type4, "type");
                j0 nullableAnyType2 = d0.e0.p.d.m0.k.x.a.getBuiltIns(z0Var).getNullableAnyType();
                m.checkNotNullExpressionValue(nullableAnyType2, "typeParameter.builtIns.nullableAnyType");
                dVar = new d(z0Var, type4, nullableAnyType2);
            } else {
                if (iOrdinal2 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                j0 nothingType2 = d0.e0.p.d.m0.k.x.a.getBuiltIns(z0Var).getNothingType();
                m.checkNotNullExpressionValue(nothingType2, "typeParameter.builtIns.nothingType");
                c0 type5 = w0Var.getType();
                m.checkNotNullExpressionValue(type5, "type");
                dVar = new d(z0Var, nothingType2, type5);
            }
            if (w0Var.isStarProjection()) {
                arrayList.add(dVar);
                arrayList2.add(dVar);
            } else {
                a<c0> aVarApproximateCapturedTypes3 = approximateCapturedTypes(dVar.getInProjection());
                c0 c0VarComponent1 = aVarApproximateCapturedTypes3.component1();
                c0 c0VarComponent2 = aVarApproximateCapturedTypes3.component2();
                a<c0> aVarApproximateCapturedTypes4 = approximateCapturedTypes(dVar.getOutProjection());
                a aVar = new a(new d(dVar.getTypeParameter(), c0VarComponent2, aVarApproximateCapturedTypes4.component1()), new d(dVar.getTypeParameter(), c0VarComponent1, aVarApproximateCapturedTypes4.component2()));
                d dVar2 = (d) aVar.component1();
                d dVar3 = (d) aVar.component2();
                arrayList.add(dVar2);
                arrayList2.add(dVar3);
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
        } while (!(!((d) it.next()).isConsistent()));
        if (z2) {
            objA = d0.e0.p.d.m0.n.o1.a.getBuiltIns(c0Var).getNothingType();
            m.checkNotNullExpressionValue(objA, "type.builtIns.nothingType");
        } else {
            objA = a(c0Var, arrayList);
        }
        return new a<>(objA, a(c0Var, arrayList2));
    }

    public static final w0 approximateCapturedTypesIfNecessary(w0 w0Var, boolean z2) {
        if (w0Var == null) {
            return null;
        }
        if (w0Var.isStarProjection()) {
            return w0Var;
        }
        c0 type = w0Var.getType();
        m.checkNotNullExpressionValue(type, "typeProjection.type");
        if (!e1.contains(type, b$a.j)) {
            return w0Var;
        }
        j1 projectionKind = w0Var.getProjectionKind();
        m.checkNotNullExpressionValue(projectionKind, "typeProjection.projectionKind");
        if (projectionKind == j1.OUT_VARIANCE) {
            return new y0(projectionKind, approximateCapturedTypes(type).getUpper());
        }
        if (z2) {
            return new y0(projectionKind, approximateCapturedTypes(type).getLower());
        }
        c1 c1VarCreate = c1.create(new c());
        m.checkNotNullExpressionValue(c1VarCreate, "create(object : TypeConstructorSubstitution() {\n        override fun get(key: TypeConstructor): TypeProjection? {\n            val capturedTypeConstructor = key as? CapturedTypeConstructor ?: return null\n            if (capturedTypeConstructor.projection.isStarProjection) {\n                return TypeProjectionImpl(Variance.OUT_VARIANCE, capturedTypeConstructor.projection.type)\n            }\n            return capturedTypeConstructor.projection\n        }\n    })");
        return c1VarCreate.substituteWithoutApproximation(w0Var);
    }
}
