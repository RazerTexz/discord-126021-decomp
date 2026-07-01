package d0.e0.p.d.m0.e.a.l0;

import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.d0;
import d0.e0.p.d.m0.n.e0;
import d0.e0.p.d.m0.n.e1;
import d0.e0.p.d.m0.n.g1;
import d0.e0.p.d.m0.n.i0;
import d0.e0.p.d.m0.n.i1;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.m0;
import d0.e0.p.d.m0.n.u0;
import d0.e0.p.d.m0.n.w0;
import d0.e0.p.d.m0.n.y;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: typeEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public final d0.e0.p.d.m0.e.a.i0.c a;

    public d(d0.e0.p.d.m0.e.a.i0.c cVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "javaResolverSettings");
        this.a = cVar;
    }

    public final d$b a(j0 j0Var, Function1<? super Integer, e> function1, int i, t tVar, boolean z2) {
        i1 i1VarWrapEnhancement;
        int subtreeSize;
        w0 w0VarCreateProjection;
        if (!u.shouldEnhance(tVar) && j0Var.getArguments().isEmpty()) {
            return new d$b(j0Var, 1, false);
        }
        d0.e0.p.d.m0.c.h declarationDescriptor = j0Var.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return new d$b(j0Var, 1, false);
        }
        e eVarInvoke = function1.invoke(Integer.valueOf(i));
        c cVarAccess$enhanceMutability = x.access$enhanceMutability(declarationDescriptor, eVarInvoke, tVar);
        d0.e0.p.d.m0.c.h hVar = (d0.e0.p.d.m0.c.h) cVarAccess$enhanceMutability.component1();
        d0.e0.p.d.m0.c.g1.g gVarComponent2 = cVarAccess$enhanceMutability.component2();
        u0 typeConstructor = hVar.getTypeConstructor();
        d0.z.d.m.checkNotNullExpressionValue(typeConstructor, "enhancedClassifier.typeConstructor");
        int i2 = i + 1;
        boolean z3 = gVarComponent2 != null;
        List<w0> arguments = j0Var.getArguments();
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(arguments, 10));
        int i3 = 0;
        for (Object obj : arguments) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                d0.t.n.throwIndexOverflow();
            }
            w0 w0Var = (w0) obj;
            if (w0Var.isStarProjection()) {
                subtreeSize = i2 + 1;
                if (function1.invoke(Integer.valueOf(i2)).getNullability() != h.NOT_NULL || z2) {
                    w0VarCreateProjection = e1.makeStarProjection(hVar.getTypeConstructor().getParameters().get(i3));
                    d0.z.d.m.checkNotNullExpressionValue(w0VarCreateProjection, "{\n                    TypeUtils.makeStarProjection(enhancedClassifier.typeConstructor.parameters[localArgIndex])\n                }");
                } else {
                    c0 c0VarMakeNotNullable = d0.e0.p.d.m0.n.o1.a.makeNotNullable(w0Var.getType().unwrap());
                    j1 projectionKind = w0Var.getProjectionKind();
                    d0.z.d.m.checkNotNullExpressionValue(projectionKind, "arg.projectionKind");
                    w0VarCreateProjection = d0.e0.p.d.m0.n.o1.a.createProjection(c0VarMakeNotNullable, projectionKind, typeConstructor.getParameters().get(i3));
                }
            } else {
                d$a d_aB = b(w0Var.getType().unwrap(), function1, i2);
                z3 = z3 || d_aB.getWereChanges();
                subtreeSize = d_aB.getSubtreeSize() + i2;
                c0 type = d_aB.getType();
                j1 projectionKind2 = w0Var.getProjectionKind();
                d0.z.d.m.checkNotNullExpressionValue(projectionKind2, "arg.projectionKind");
                w0VarCreateProjection = d0.e0.p.d.m0.n.o1.a.createProjection(type, projectionKind2, typeConstructor.getParameters().get(i3));
            }
            i2 = subtreeSize;
            arrayList.add(w0VarCreateProjection);
            i3 = i4;
        }
        c cVarAccess$getEnhancedNullability = x.access$getEnhancedNullability(j0Var, eVarInvoke, tVar);
        boolean zBooleanValue = ((Boolean) cVarAccess$getEnhancedNullability.component1()).booleanValue();
        d0.e0.p.d.m0.c.g1.g gVarComponent3 = cVarAccess$getEnhancedNullability.component2();
        int i5 = i2 - i;
        if (!(z3 || gVarComponent3 != null)) {
            return new d$b(j0Var, i5, false);
        }
        boolean z4 = false;
        d0.e0.p.d.m0.c.g1.g gVarAccess$compositeAnnotationsOrSingle = x.access$compositeAnnotationsOrSingle(d0.t.n.listOfNotNull((Object[]) new d0.e0.p.d.m0.c.g1.g[]{j0Var.getAnnotations(), gVarComponent2, gVarComponent3}));
        d0 d0Var = d0.a;
        j0 j0VarSimpleType$default = d0.simpleType$default(gVarAccess$compositeAnnotationsOrSingle, typeConstructor, arrayList, zBooleanValue, null, 16, null);
        if (eVarInvoke.isNotNullTypeParameter()) {
            if (this.a.getCorrectNullabilityForNotNullTypeParameter()) {
                i1VarWrapEnhancement = j0VarSimpleType$default;
                i1VarWrapEnhancement = m0.makeSimpleTypeDefinitelyNotNullOrNotNull(j0VarSimpleType$default, true);
            } else {
                i1VarWrapEnhancement = j0VarSimpleType$default;
                i1VarWrapEnhancement = new g(j0VarSimpleType$default);
            }
        }
        if (gVarComponent3 != null && eVarInvoke.isNullabilityQualifierForWarning()) {
            z4 = true;
        }
        if (z4) {
            i1VarWrapEnhancement = g1.wrapEnhancement(j0Var, i1VarWrapEnhancement);
        }
        return new d$b((j0) i1VarWrapEnhancement, i5, true);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x005e  */
    public final d$a b(i1 i1Var, Function1<? super Integer, e> function1, int i) {
        i1 i1VarFlexibleType;
        if (e0.isError(i1Var)) {
            return new d$a(i1Var, 1, false);
        }
        if (!(i1Var instanceof d0.e0.p.d.m0.n.v)) {
            if (i1Var instanceof j0) {
                return a((j0) i1Var, function1, i, t.INFLEXIBLE, false);
            }
            throw new NoWhenBranchMatchedException();
        }
        boolean z2 = i1Var instanceof i0;
        d0.e0.p.d.m0.n.v vVar = (d0.e0.p.d.m0.n.v) i1Var;
        d$b d_bA = a(vVar.getLowerBound(), function1, i, t.FLEXIBLE_LOWER, z2);
        d$b d_bA2 = a(vVar.getUpperBound(), function1, i, t.FLEXIBLE_UPPER, z2);
        d_bA.getSubtreeSize();
        d_bA2.getSubtreeSize();
        boolean z3 = d_bA.getWereChanges() || d_bA2.getWereChanges();
        j0 type = d_bA.getType();
        c0 enhancement = g1.getEnhancement(d_bA2.getType());
        c0 enhancement2 = g1.getEnhancement(type);
        if (enhancement2 != null) {
            if (enhancement != null) {
                d0 d0Var = d0.a;
                enhancement2 = d0.flexibleType(y.lowerIfFlexible(enhancement2), y.upperIfFlexible(enhancement));
            }
        } else if (enhancement == null) {
            enhancement2 = null;
        } else {
            enhancement2 = enhancement;
            if (enhancement != null) {
                d0 d0Var2 = d0.a;
                enhancement2 = d0.flexibleType(y.lowerIfFlexible(enhancement2), y.upperIfFlexible(enhancement));
            }
        }
        if (z3) {
            if (i1Var instanceof d0.e0.p.d.m0.e.a.i0.m.g) {
                i1VarFlexibleType = new d0.e0.p.d.m0.e.a.i0.m.g(d_bA.getType(), d_bA2.getType());
            } else {
                d0 d0Var3 = d0.a;
                i1VarFlexibleType = d0.flexibleType(d_bA.getType(), d_bA2.getType());
            }
            i1Var = g1.wrapEnhancement(i1VarFlexibleType, enhancement2);
        }
        return new d$a(i1Var, d_bA.getSubtreeSize(), z3);
    }

    public final c0 enhance(c0 c0Var, Function1<? super Integer, e> function1) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        d0.z.d.m.checkNotNullParameter(function1, "qualifiers");
        return b(c0Var.unwrap(), function1, 0).getTypeIfChanged();
    }
}
