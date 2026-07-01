package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.d0;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.y0;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r extends g<r$b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r$a f3476b = new r$a(null);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(r$b r_b) {
        super(r_b);
        d0.z.d.m.checkNotNullParameter(r_b, "value");
    }

    public final c0 getArgumentType(d0.e0.p.d.m0.c.c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        r$b value = getValue();
        if (value instanceof r$b$a) {
            return ((r$b$a) getValue()).getType();
        }
        if (!(value instanceof r$b$b)) {
            throw new NoWhenBranchMatchedException();
        }
        f value2 = ((r$b$b) getValue()).getValue();
        d0.e0.p.d.m0.g.a aVarComponent1 = value2.component1();
        int iComponent2 = value2.component2();
        d0.e0.p.d.m0.c.e eVarFindClassAcrossModuleDependencies = d0.e0.p.d.m0.c.w.findClassAcrossModuleDependencies(c0Var, aVarComponent1);
        if (eVarFindClassAcrossModuleDependencies == null) {
            j0 j0VarCreateErrorType = d0.e0.p.d.m0.n.t.createErrorType("Unresolved type: " + aVarComponent1 + " (arrayDimensions=" + iComponent2 + ')');
            d0.z.d.m.checkNotNullExpressionValue(j0VarCreateErrorType, "createErrorType(\"Unresolved type: $classId (arrayDimensions=$arrayDimensions)\")");
            return j0VarCreateErrorType;
        }
        j0 defaultType = eVarFindClassAcrossModuleDependencies.getDefaultType();
        d0.z.d.m.checkNotNullExpressionValue(defaultType, "descriptor.defaultType");
        c0 c0VarReplaceArgumentsWithStarProjections = d0.e0.p.d.m0.n.o1.a.replaceArgumentsWithStarProjections(defaultType);
        for (int i = 0; i < iComponent2; i++) {
            c0VarReplaceArgumentsWithStarProjections = c0Var.getBuiltIns().getArrayType(j1.INVARIANT, c0VarReplaceArgumentsWithStarProjections);
            d0.z.d.m.checkNotNullExpressionValue(c0VarReplaceArgumentsWithStarProjections, "module.builtIns.getArrayType(Variance.INVARIANT, type)");
        }
        return c0VarReplaceArgumentsWithStarProjections;
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public c0 getType(d0.e0.p.d.m0.c.c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        d0 d0Var = d0.a;
        d0.e0.p.d.m0.c.g1.g empty = d0.e0.p.d.m0.c.g1.g.f.getEMPTY();
        d0.e0.p.d.m0.c.e kClass = c0Var.getBuiltIns().getKClass();
        d0.z.d.m.checkNotNullExpressionValue(kClass, "module.builtIns.kClass");
        return d0.simpleNotNullType(empty, kClass, d0.t.m.listOf(new y0(getArgumentType(c0Var))));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public r(f fVar) {
        this(new r$b$b(fVar));
        d0.z.d.m.checkNotNullParameter(fVar, "value");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public r(d0.e0.p.d.m0.g.a aVar, int i) {
        this(new f(aVar, i));
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
    }
}
