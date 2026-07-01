package b.g.a.c.i0;

import java.io.Serializable;

/* JADX INFO: compiled from: NameTransformer.java */
/* JADX INFO: loaded from: classes3.dex */
public class n$a extends n implements Serializable {
    private static final long serialVersionUID = 1;
    public final n _t1;
    public final n _t2;

    public n$a(n nVar, n nVar2) {
        this._t1 = nVar;
        this._t2 = nVar2;
    }

    @Override // b.g.a.c.i0.n
    public String a(String str) {
        return this._t1.a(this._t2.a(str));
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("[ChainedTransformer(");
        sbU.append(this._t1);
        sbU.append(", ");
        sbU.append(this._t2);
        sbU.append(")]");
        return sbU.toString();
    }
}
