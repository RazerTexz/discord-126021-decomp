package d0.e0.p.d.m0.o;

import d0.e0.p.d.m0.b.j$b;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.x;
import d0.e0.p.d.m0.n.c0;
import d0.z.d.m;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements b {
    public static final e a = new e();

    @Override // d0.e0.p.d.m0.o.b
    public boolean check(x xVar) {
        m.checkNotNullParameter(xVar, "functionDescriptor");
        c1 c1Var = xVar.getValueParameters().get(1);
        j$b j_b = d0.e0.p.d.m0.b.j.a;
        m.checkNotNullExpressionValue(c1Var, "secondParameter");
        c0 c0VarCreateKPropertyStarType = j_b.createKPropertyStarType(d0.e0.p.d.m0.k.x.a.getModule(c1Var));
        if (c0VarCreateKPropertyStarType == null) {
            return false;
        }
        c0 type = c1Var.getType();
        m.checkNotNullExpressionValue(type, "secondParameter.type");
        return d0.e0.p.d.m0.n.o1.a.isSubtypeOf(c0VarCreateKPropertyStarType, d0.e0.p.d.m0.n.o1.a.makeNotNullable(type));
    }

    @Override // d0.e0.p.d.m0.o.b
    public String getDescription() {
        return "second parameter must be of type KProperty<*> or its supertype";
    }

    @Override // d0.e0.p.d.m0.o.b
    public String invoke(x xVar) {
        return b$a.invoke(this, xVar);
    }
}
