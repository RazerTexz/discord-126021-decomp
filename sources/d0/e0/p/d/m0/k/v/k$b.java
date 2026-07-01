package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.j0;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k$b extends k {
    public final String c;

    public k$b(String str) {
        d0.z.d.m.checkNotNullParameter(str, "message");
        this.c = str;
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public /* bridge */ /* synthetic */ c0 getType(d0.e0.p.d.m0.c.c0 c0Var) {
        return getType(c0Var);
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public String toString() {
        return this.c;
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public j0 getType(d0.e0.p.d.m0.c.c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        j0 j0VarCreateErrorType = d0.e0.p.d.m0.n.t.createErrorType(this.c);
        d0.z.d.m.checkNotNullExpressionValue(j0VarCreateErrorType, "createErrorType(message)");
        return j0VarCreateErrorType;
    }
}
