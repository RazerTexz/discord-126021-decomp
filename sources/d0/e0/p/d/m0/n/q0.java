package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.k.a0.i$b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: TypeAliasExpander.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q0 {
    public static final q0$a a = new q0$a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s0 f3536b;
    public final boolean c;

    static {
        new q0(s0$a.a, false);
    }

    public q0(s0 s0Var, boolean z2) {
        d0.z.d.m.checkNotNullParameter(s0Var, "reportStrategy");
        this.f3536b = s0Var;
        this.c = z2;
    }

    public final void a(d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.c.g1.g gVar2) {
        HashSet hashSet = new HashSet();
        Iterator<d0.e0.p.d.m0.c.g1.c> it = gVar.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getFqName());
        }
        for (d0.e0.p.d.m0.c.g1.c cVar : gVar2) {
            if (hashSet.contains(cVar.getFqName())) {
                this.f3536b.repeatedAnnotation(cVar);
            }
        }
    }

    public final j0 b(j0 j0Var, d0.e0.p.d.m0.c.g1.g gVar) {
        return e0.isError(j0Var) ? j0Var : a1.replace$default(j0Var, null, c(j0Var, gVar), 1, null);
    }

    public final d0.e0.p.d.m0.c.g1.g c(c0 c0Var, d0.e0.p.d.m0.c.g1.g gVar) {
        return e0.isError(c0Var) ? c0Var.getAnnotations() : d0.e0.p.d.m0.c.g1.i.composeAnnotations(gVar, c0Var.getAnnotations());
    }

    public final j0 d(r0 r0Var, d0.e0.p.d.m0.c.g1.g gVar, boolean z2, int i, boolean z3) {
        w0 w0VarE = e(new y0(j1.INVARIANT, r0Var.getDescriptor().getUnderlyingType()), r0Var, null, i);
        c0 type = w0VarE.getType();
        d0.z.d.m.checkNotNullExpressionValue(type, "expandedProjection.type");
        j0 j0VarAsSimpleType = a1.asSimpleType(type);
        if (e0.isError(j0VarAsSimpleType)) {
            return j0VarAsSimpleType;
        }
        w0VarE.getProjectionKind();
        a(j0VarAsSimpleType.getAnnotations(), gVar);
        j0 j0VarMakeNullableIfNeeded = e1.makeNullableIfNeeded(b(j0VarAsSimpleType, gVar), z2);
        d0.z.d.m.checkNotNullExpressionValue(j0VarMakeNullableIfNeeded, "expandedType.combineAnnotations(annotations).let { TypeUtils.makeNullableIfNeeded(it, isNullable) }");
        if (!z3) {
            return j0VarMakeNullableIfNeeded;
        }
        d0 d0Var = d0.a;
        u0 typeConstructor = r0Var.getDescriptor().getTypeConstructor();
        d0.z.d.m.checkNotNullExpressionValue(typeConstructor, "descriptor.typeConstructor");
        return m0.withAbbreviation(j0VarMakeNullableIfNeeded, d0.simpleTypeWithNonTrivialMemberScope(gVar, typeConstructor, r0Var.getArguments(), z2, i$b.f3461b));
    }

    public final w0 e(w0 w0Var, r0 r0Var, d0.e0.p.d.m0.c.z0 z0Var, int i) {
        c0 c0VarB;
        j1 j1Var = j1.INVARIANT;
        q0$a.access$assertRecursionDepth(a, i, r0Var.getDescriptor());
        if (w0Var.isStarProjection()) {
            d0.z.d.m.checkNotNull(z0Var);
            w0 w0VarMakeStarProjection = e1.makeStarProjection(z0Var);
            d0.z.d.m.checkNotNullExpressionValue(w0VarMakeStarProjection, "makeStarProjection(typeParameterDescriptor!!)");
            return w0VarMakeStarProjection;
        }
        c0 type = w0Var.getType();
        d0.z.d.m.checkNotNullExpressionValue(type, "underlyingProjection.type");
        w0 replacement = r0Var.getReplacement(type.getConstructor());
        if (replacement != null) {
            if (replacement.isStarProjection()) {
                d0.z.d.m.checkNotNull(z0Var);
                w0 w0VarMakeStarProjection2 = e1.makeStarProjection(z0Var);
                d0.z.d.m.checkNotNullExpressionValue(w0VarMakeStarProjection2, "makeStarProjection(typeParameterDescriptor!!)");
                return w0VarMakeStarProjection2;
            }
            i1 i1VarUnwrap = replacement.getType().unwrap();
            j1 projectionKind = replacement.getProjectionKind();
            d0.z.d.m.checkNotNullExpressionValue(projectionKind, "argument.projectionKind");
            j1 projectionKind2 = w0Var.getProjectionKind();
            d0.z.d.m.checkNotNullExpressionValue(projectionKind2, "underlyingProjection.projectionKind");
            if (projectionKind2 != projectionKind && projectionKind2 != j1Var) {
                if (projectionKind == j1Var) {
                    projectionKind = projectionKind2;
                } else {
                    this.f3536b.conflictingProjection(r0Var.getDescriptor(), z0Var, i1VarUnwrap);
                }
            }
            j1 variance = z0Var == null ? null : z0Var.getVariance();
            if (variance == null) {
                variance = j1Var;
            }
            d0.z.d.m.checkNotNullExpressionValue(variance, "typeParameterDescriptor?.variance ?: Variance.INVARIANT");
            if (variance == projectionKind || variance == j1Var) {
                j1Var = projectionKind;
            } else if (projectionKind != j1Var) {
                this.f3536b.conflictingProjection(r0Var.getDescriptor(), z0Var, i1VarUnwrap);
                j1Var = projectionKind;
            }
            a(type.getAnnotations(), i1VarUnwrap.getAnnotations());
            if (i1VarUnwrap instanceof q) {
                q qVar = (q) i1VarUnwrap;
                c0VarB = qVar.replaceAnnotations(c(qVar, type.getAnnotations()));
            } else {
                j0 j0VarMakeNullableIfNeeded = e1.makeNullableIfNeeded(a1.asSimpleType(i1VarUnwrap), type.isMarkedNullable());
                d0.z.d.m.checkNotNullExpressionValue(j0VarMakeNullableIfNeeded, "makeNullableIfNeeded(this, fromType.isMarkedNullable)");
                c0VarB = b(j0VarMakeNullableIfNeeded, type.getAnnotations());
            }
            return new y0(j1Var, c0VarB);
        }
        i1 i1VarUnwrap2 = w0Var.getType().unwrap();
        if (r.isDynamic(i1VarUnwrap2)) {
            return w0Var;
        }
        j0 j0VarAsSimpleType = a1.asSimpleType(i1VarUnwrap2);
        if (e0.isError(j0VarAsSimpleType) || !d0.e0.p.d.m0.n.o1.a.requiresTypeAliasExpansion(j0VarAsSimpleType)) {
            return w0Var;
        }
        u0 constructor = j0VarAsSimpleType.getConstructor();
        d0.e0.p.d.m0.c.h declarationDescriptor = constructor.getDeclarationDescriptor();
        constructor.getParameters().size();
        j0VarAsSimpleType.getArguments().size();
        if (declarationDescriptor instanceof d0.e0.p.d.m0.c.z0) {
            return w0Var;
        }
        int i2 = 0;
        if (declarationDescriptor instanceof d0.e0.p.d.m0.c.y0) {
            d0.e0.p.d.m0.c.y0 y0Var = (d0.e0.p.d.m0.c.y0) declarationDescriptor;
            if (r0Var.isRecursion(y0Var)) {
                this.f3536b.recursiveTypeAlias(y0Var);
                return new y0(j1Var, t.createErrorType(d0.z.d.m.stringPlus("Recursive type alias: ", y0Var.getName())));
            }
            List<w0> arguments = j0VarAsSimpleType.getArguments();
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(arguments, 10));
            for (Object obj : arguments) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    d0.t.n.throwIndexOverflow();
                }
                arrayList.add(e((w0) obj, r0Var, constructor.getParameters().get(i2), i + 1));
                i2 = i3;
            }
            j0 j0VarD = d(r0.a.create(r0Var, y0Var, arrayList), j0VarAsSimpleType.getAnnotations(), j0VarAsSimpleType.isMarkedNullable(), i + 1, false);
            j0 j0VarF = f(j0VarAsSimpleType, r0Var, i);
            if (!r.isDynamic(j0VarD)) {
                j0VarD = m0.withAbbreviation(j0VarD, j0VarF);
            }
            return new y0(w0Var.getProjectionKind(), j0VarD);
        }
        j0 j0VarF2 = f(j0VarAsSimpleType, r0Var, i);
        c1 c1VarCreate = c1.create(j0VarF2);
        d0.z.d.m.checkNotNullExpressionValue(c1VarCreate, "create(substitutedType)");
        for (Object obj2 : j0VarF2.getArguments()) {
            int i4 = i2 + 1;
            if (i2 < 0) {
                d0.t.n.throwIndexOverflow();
            }
            w0 w0Var2 = (w0) obj2;
            if (!w0Var2.isStarProjection()) {
                c0 type2 = w0Var2.getType();
                d0.z.d.m.checkNotNullExpressionValue(type2, "substitutedArgument.type");
                if (!d0.e0.p.d.m0.n.o1.a.containsTypeAliasParameters(type2)) {
                    w0 w0Var3 = j0VarAsSimpleType.getArguments().get(i2);
                    d0.e0.p.d.m0.c.z0 z0Var2 = j0VarAsSimpleType.getConstructor().getParameters().get(i2);
                    if (this.c) {
                        q0$a q0_a = a;
                        s0 s0Var = this.f3536b;
                        c0 type3 = w0Var3.getType();
                        d0.z.d.m.checkNotNullExpressionValue(type3, "unsubstitutedArgument.type");
                        c0 type4 = w0Var2.getType();
                        d0.z.d.m.checkNotNullExpressionValue(type4, "substitutedArgument.type");
                        d0.z.d.m.checkNotNullExpressionValue(z0Var2, "typeParameter");
                        q0_a.checkBoundsInTypeAlias(s0Var, type3, type4, z0Var2, c1VarCreate);
                    }
                }
            }
            i2 = i4;
        }
        return new y0(w0Var.getProjectionKind(), j0VarF2);
    }

    public final j0 expand(r0 r0Var, d0.e0.p.d.m0.c.g1.g gVar) {
        d0.z.d.m.checkNotNullParameter(r0Var, "typeAliasExpansion");
        d0.z.d.m.checkNotNullParameter(gVar, "annotations");
        return d(r0Var, gVar, false, 0, true);
    }

    public final j0 f(j0 j0Var, r0 r0Var, int i) {
        u0 constructor = j0Var.getConstructor();
        List<w0> arguments = j0Var.getArguments();
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(arguments, 10));
        int i2 = 0;
        for (Object obj : arguments) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                d0.t.n.throwIndexOverflow();
            }
            w0 w0Var = (w0) obj;
            w0 w0VarE = e(w0Var, r0Var, constructor.getParameters().get(i2), i + 1);
            if (!w0VarE.isStarProjection()) {
                w0VarE = new y0(w0VarE.getProjectionKind(), e1.makeNullableIfNeeded(w0VarE.getType(), w0Var.getType().isMarkedNullable()));
            }
            arrayList.add(w0VarE);
            i2 = i3;
        }
        return a1.replace$default(j0Var, arrayList, null, 2, null);
    }
}
