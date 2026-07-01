package d0.e0.p.d.m0.e.a.i0.m;

import d0.e0.p.d.m0.b.h;
import d0.e0.p.d.m0.e.a.g0.k;
import d0.e0.p.d.m0.k.a0.i;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.d0;
import d0.e0.p.d.m0.n.e0;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.t;
import d0.e0.p.d.m0.n.u0;
import d0.e0.p.d.m0.n.w0;
import d0.e0.p.d.m0.n.y;
import d0.e0.p.d.m0.n.y0;
import d0.e0.p.d.m0.n.z0;
import d0.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;

/* JADX INFO: compiled from: RawType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends z0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f3341b = new f();
    public static final a c;
    public static final a d;

    static {
        k kVar = k.COMMON;
        c = e.toAttributes$default(kVar, false, null, 3, null).withFlexibility(b.FLEXIBLE_LOWER_BOUND);
        d = e.toAttributes$default(kVar, false, null, 3, null).withFlexibility(b.FLEXIBLE_UPPER_BOUND);
    }

    public static final /* synthetic */ Pair access$eraseInflexibleBasedOnClassDescriptor(f fVar, j0 j0Var, d0.e0.p.d.m0.c.e eVar, a aVar) {
        return fVar.a(j0Var, eVar, aVar);
    }

    public static /* synthetic */ w0 computeProjection$default(f fVar, d0.e0.p.d.m0.c.z0 z0Var, a aVar, c0 c0Var, int i, Object obj) {
        if ((i & 4) != 0) {
            c0Var = e.getErasedUpperBound$default(z0Var, null, null, 3, null);
        }
        return fVar.computeProjection(z0Var, aVar, c0Var);
    }

    public final Pair<j0, Boolean> a(j0 j0Var, d0.e0.p.d.m0.c.e eVar, a aVar) {
        if (j0Var.getConstructor().getParameters().isEmpty()) {
            return o.to(j0Var, Boolean.FALSE);
        }
        if (h.isArray(j0Var)) {
            w0 w0Var = j0Var.getArguments().get(0);
            j1 projectionKind = w0Var.getProjectionKind();
            c0 type = w0Var.getType();
            m.checkNotNullExpressionValue(type, "componentTypeProjection.type");
            List listListOf = d0.t.m.listOf(new y0(projectionKind, b(type)));
            d0 d0Var = d0.a;
            return o.to(d0.simpleType$default(j0Var.getAnnotations(), j0Var.getConstructor(), listListOf, j0Var.isMarkedNullable(), null, 16, null), Boolean.FALSE);
        }
        if (e0.isError(j0Var)) {
            j0 j0VarCreateErrorType = t.createErrorType(m.stringPlus("Raw error type: ", j0Var.getConstructor()));
            m.checkNotNullExpressionValue(j0VarCreateErrorType, "createErrorType(\"Raw error type: ${type.constructor}\")");
            return o.to(j0VarCreateErrorType, Boolean.FALSE);
        }
        i memberScope = eVar.getMemberScope(this);
        m.checkNotNullExpressionValue(memberScope, "declaration.getMemberScope(RawSubstitution)");
        d0 d0Var2 = d0.a;
        d0.e0.p.d.m0.c.g1.g annotations = j0Var.getAnnotations();
        u0 typeConstructor = eVar.getTypeConstructor();
        m.checkNotNullExpressionValue(typeConstructor, "declaration.typeConstructor");
        List<d0.e0.p.d.m0.c.z0> parameters = eVar.getTypeConstructor().getParameters();
        m.checkNotNullExpressionValue(parameters, "declaration.typeConstructor.parameters");
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(parameters, 10));
        for (d0.e0.p.d.m0.c.z0 z0Var : parameters) {
            m.checkNotNullExpressionValue(z0Var, "parameter");
            arrayList.add(computeProjection$default(this, z0Var, aVar, null, 4, null));
        }
        return o.to(d0.simpleTypeWithNonTrivialMemberScope(annotations, typeConstructor, arrayList, j0Var.isMarkedNullable(), memberScope, new f$a(eVar, this, j0Var, aVar)), Boolean.TRUE);
    }

    public final c0 b(c0 c0Var) {
        d0.e0.p.d.m0.c.h declarationDescriptor = c0Var.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof d0.e0.p.d.m0.c.z0) {
            return b(e.getErasedUpperBound$default((d0.e0.p.d.m0.c.z0) declarationDescriptor, null, null, 3, null));
        }
        if (!(declarationDescriptor instanceof d0.e0.p.d.m0.c.e)) {
            throw new IllegalStateException(m.stringPlus("Unexpected declaration kind: ", declarationDescriptor).toString());
        }
        d0.e0.p.d.m0.c.h declarationDescriptor2 = y.upperIfFlexible(c0Var).getConstructor().getDeclarationDescriptor();
        if (!(declarationDescriptor2 instanceof d0.e0.p.d.m0.c.e)) {
            throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + declarationDescriptor2 + "\" while for lower it's \"" + declarationDescriptor + '\"').toString());
        }
        Pair<j0, Boolean> pairA = a(y.lowerIfFlexible(c0Var), (d0.e0.p.d.m0.c.e) declarationDescriptor, c);
        j0 j0VarComponent1 = pairA.component1();
        boolean zBooleanValue = pairA.component2().booleanValue();
        Pair<j0, Boolean> pairA2 = a(y.upperIfFlexible(c0Var), (d0.e0.p.d.m0.c.e) declarationDescriptor2, d);
        j0 j0VarComponent2 = pairA2.component1();
        boolean zBooleanValue2 = pairA2.component2().booleanValue();
        if (zBooleanValue || zBooleanValue2) {
            return new g(j0VarComponent1, j0VarComponent2);
        }
        d0 d0Var = d0.a;
        return d0.flexibleType(j0VarComponent1, j0VarComponent2);
    }

    public final w0 computeProjection(d0.e0.p.d.m0.c.z0 z0Var, a aVar, c0 c0Var) {
        j1 j1Var = j1.INVARIANT;
        m.checkNotNullParameter(z0Var, "parameter");
        m.checkNotNullParameter(aVar, "attr");
        m.checkNotNullParameter(c0Var, "erasedUpperBound");
        int iOrdinal = aVar.getFlexibility().ordinal();
        if (iOrdinal != 0 && iOrdinal != 1) {
            if (iOrdinal == 2) {
                return new y0(j1Var, c0Var);
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!z0Var.getVariance().getAllowsOutPosition()) {
            return new y0(j1Var, d0.e0.p.d.m0.k.x.a.getBuiltIns(z0Var).getNothingType());
        }
        List<d0.e0.p.d.m0.c.z0> parameters = c0Var.getConstructor().getParameters();
        m.checkNotNullExpressionValue(parameters, "erasedUpperBound.constructor.parameters");
        return parameters.isEmpty() ^ true ? new y0(j1.OUT_VARIANCE, c0Var) : e.makeStarProjection(z0Var, aVar);
    }

    @Override // d0.e0.p.d.m0.n.z0
    public /* bridge */ /* synthetic */ w0 get(c0 c0Var) {
        return get(c0Var);
    }

    @Override // d0.e0.p.d.m0.n.z0
    public boolean isEmpty() {
        return false;
    }

    @Override // d0.e0.p.d.m0.n.z0
    public y0 get(c0 c0Var) {
        m.checkNotNullParameter(c0Var, "key");
        return new y0(b(c0Var));
    }
}
