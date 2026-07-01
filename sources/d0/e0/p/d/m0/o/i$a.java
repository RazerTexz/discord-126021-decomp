package d0.e0.p.d.m0.o;

import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.x;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i$a extends o implements Function1<x, String> {
    public static final i$a j = new i$a();

    public i$a() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(x xVar) {
        return invoke2(xVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(x xVar) {
        Boolean boolValueOf;
        m.checkNotNullParameter(xVar, "<this>");
        List<c1> valueParameters = xVar.getValueParameters();
        m.checkNotNullExpressionValue(valueParameters, "valueParameters");
        c1 c1Var = (c1) u.lastOrNull((List) valueParameters);
        if (c1Var == null) {
            boolValueOf = null;
        } else {
            boolValueOf = Boolean.valueOf(!d0.e0.p.d.m0.k.x.a.declaresOrInheritsDefaultValue(c1Var) && c1Var.getVarargElementType() == null);
        }
        boolean zAreEqual = m.areEqual(boolValueOf, Boolean.TRUE);
        i iVar = i.a;
        if (zAreEqual) {
            return null;
        }
        return "last parameter should not have a default value or be a vararg";
    }
}
