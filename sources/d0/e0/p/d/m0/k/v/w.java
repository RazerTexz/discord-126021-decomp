package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.j0;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class w extends g<String> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(String str) {
        super(str);
        d0.z.d.m.checkNotNullParameter(str, "value");
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public /* bridge */ /* synthetic */ c0 getType(d0.e0.p.d.m0.c.c0 c0Var) {
        return getType(c0Var);
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public String toString() {
        return b.d.b.a.a.H(b.d.b.a.a.Q('\"'), getValue(), '\"');
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public j0 getType(d0.e0.p.d.m0.c.c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        j0 stringType = c0Var.getBuiltIns().getStringType();
        d0.z.d.m.checkNotNullExpressionValue(stringType, "module.builtIns.stringType");
        return stringType;
    }
}
