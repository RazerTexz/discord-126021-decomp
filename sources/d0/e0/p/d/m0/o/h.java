package d0.e0.p.d.m0.o;

import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.x;
import d0.z.d.m;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements b {
    public static final h a = new h();

    @Override // d0.e0.p.d.m0.o.b
    public boolean check(x xVar) {
        m.checkNotNullParameter(xVar, "functionDescriptor");
        List<c1> valueParameters = xVar.getValueParameters();
        m.checkNotNullExpressionValue(valueParameters, "functionDescriptor.valueParameters");
        if (!(valueParameters instanceof Collection) || !valueParameters.isEmpty()) {
            for (c1 c1Var : valueParameters) {
                m.checkNotNullExpressionValue(c1Var, "it");
                if (!(!d0.e0.p.d.m0.k.x.a.declaresOrInheritsDefaultValue(c1Var) && c1Var.getVarargElementType() == null)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // d0.e0.p.d.m0.o.b
    public String getDescription() {
        return "should not have varargs or parameters with default values";
    }

    @Override // d0.e0.p.d.m0.o.b
    public String invoke(x xVar) {
        return b$a.invoke(this, xVar);
    }
}
