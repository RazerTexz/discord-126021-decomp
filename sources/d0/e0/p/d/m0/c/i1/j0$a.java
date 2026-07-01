package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.c.b$a;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.y0;
import d0.e0.p.d.m0.n.c1;
import d0.e0.p.d.m0.n.j1;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TypeAliasConstructorDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j0$a {
    public j0$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public static final c1 access$getTypeSubstitutorForUnderlyingClass(j0$a j0_a, y0 y0Var) {
        Objects.requireNonNull(j0_a);
        if (y0Var.getClassDescriptor() == null) {
            return null;
        }
        return c1.create(y0Var.getExpandedType());
    }

    public final i0 createIfAvailable(d0.e0.p.d.m0.m.o oVar, y0 y0Var, d0.e0.p.d.m0.c.d dVar) {
        d0.e0.p.d.m0.c.d dVarSubstitute;
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(y0Var, "typeAliasDescriptor");
        d0.z.d.m.checkNotNullParameter(dVar, "constructor");
        c1 c1VarCreate = y0Var.getClassDescriptor() == null ? null : c1.create(y0Var.getExpandedType());
        if (c1VarCreate == null || (dVarSubstitute = dVar.substitute(c1VarCreate)) == null) {
            return null;
        }
        d0.e0.p.d.m0.c.g1.g annotations = dVar.getAnnotations();
        b$a kind = dVar.getKind();
        d0.z.d.m.checkNotNullExpressionValue(kind, "constructor.kind");
        u0 source = y0Var.getSource();
        d0.z.d.m.checkNotNullExpressionValue(source, "typeAliasDescriptor.source");
        j0 j0Var = new j0(oVar, y0Var, dVarSubstitute, null, annotations, kind, source, null);
        List<d0.e0.p.d.m0.c.c1> substitutedValueParameters = q.getSubstitutedValueParameters(j0Var, dVar.getValueParameters(), c1VarCreate);
        if (substitutedValueParameters == null) {
            return null;
        }
        d0.e0.p.d.m0.n.j0 j0VarLowerIfFlexible = d0.e0.p.d.m0.n.y.lowerIfFlexible(dVarSubstitute.getReturnType().unwrap());
        d0.e0.p.d.m0.n.j0 defaultType = y0Var.getDefaultType();
        d0.z.d.m.checkNotNullExpressionValue(defaultType, "typeAliasDescriptor.defaultType");
        d0.e0.p.d.m0.n.j0 j0VarWithAbbreviation = d0.e0.p.d.m0.n.m0.withAbbreviation(j0VarLowerIfFlexible, defaultType);
        q0 dispatchReceiverParameter = dVar.getDispatchReceiverParameter();
        j0Var.initialize(dispatchReceiverParameter != null ? d0.e0.p.d.m0.k.d.createExtensionReceiverParameterForCallable(j0Var, c1VarCreate.safeSubstitute(dispatchReceiverParameter.getType(), j1.INVARIANT), d0.e0.p.d.m0.c.g1.g.f.getEMPTY()) : null, null, y0Var.getDeclaredTypeParameters(), substitutedValueParameters, j0VarWithAbbreviation, d0.e0.p.d.m0.c.z.FINAL, y0Var.getVisibility());
        return j0Var;
    }
}
