package d0.e0.p.d.m0.n;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: TypeSubstitution.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a1 {
    public static final j0 asSimpleType(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        i1 i1VarUnwrap = c0Var.unwrap();
        j0 j0Var = i1VarUnwrap instanceof j0 ? (j0) i1VarUnwrap : null;
        if (j0Var != null) {
            return j0Var;
        }
        throw new IllegalStateException(d0.z.d.m.stringPlus("This is should be simple type: ", c0Var).toString());
    }

    public static final c0 replace(c0 c0Var, List<? extends w0> list, d0.e0.p.d.m0.c.g1.g gVar) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        d0.z.d.m.checkNotNullParameter(list, "newArguments");
        d0.z.d.m.checkNotNullParameter(gVar, "newAnnotations");
        return replace$default(c0Var, list, gVar, null, 4, null);
    }

    public static final c0 replace(c0 c0Var, List<? extends w0> list, d0.e0.p.d.m0.c.g1.g gVar, List<? extends w0> list2) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        d0.z.d.m.checkNotNullParameter(list, "newArguments");
        d0.z.d.m.checkNotNullParameter(gVar, "newAnnotations");
        d0.z.d.m.checkNotNullParameter(list2, "newArgumentsForUpperBound");
        if ((list.isEmpty() || list == c0Var.getArguments()) && gVar == c0Var.getAnnotations()) {
            return c0Var;
        }
        i1 i1VarUnwrap = c0Var.unwrap();
        if (i1VarUnwrap instanceof v) {
            d0 d0Var = d0.a;
            v vVar = (v) i1VarUnwrap;
            return d0.flexibleType(replace(vVar.getLowerBound(), list, gVar), replace(vVar.getUpperBound(), list2, gVar));
        }
        if (i1VarUnwrap instanceof j0) {
            return replace((j0) i1VarUnwrap, list, gVar);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ c0 replace$default(c0 c0Var, List list, d0.e0.p.d.m0.c.g1.g gVar, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = c0Var.getArguments();
        }
        if ((i & 2) != 0) {
            gVar = c0Var.getAnnotations();
        }
        if ((i & 4) != 0) {
            list2 = list;
        }
        return replace(c0Var, list, gVar, list2);
    }

    public static /* synthetic */ j0 replace$default(j0 j0Var, List list, d0.e0.p.d.m0.c.g1.g gVar, int i, Object obj) {
        if ((i & 1) != 0) {
            list = j0Var.getArguments();
        }
        if ((i & 2) != 0) {
            gVar = j0Var.getAnnotations();
        }
        return replace(j0Var, (List<? extends w0>) list, gVar);
    }

    public static final j0 replace(j0 j0Var, List<? extends w0> list, d0.e0.p.d.m0.c.g1.g gVar) {
        d0.z.d.m.checkNotNullParameter(j0Var, "<this>");
        d0.z.d.m.checkNotNullParameter(list, "newArguments");
        d0.z.d.m.checkNotNullParameter(gVar, "newAnnotations");
        if (list.isEmpty() && gVar == j0Var.getAnnotations()) {
            return j0Var;
        }
        if (list.isEmpty()) {
            return j0Var.replaceAnnotations(gVar);
        }
        d0 d0Var = d0.a;
        return d0.simpleType$default(gVar, j0Var.getConstructor(), list, j0Var.isMarkedNullable(), null, 16, null);
    }
}
