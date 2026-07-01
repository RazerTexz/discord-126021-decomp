package b.g.a.c.c0;

/* JADX INFO: compiled from: AnnotatedWithParams.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n extends i {
    private static final long serialVersionUID = 1;
    public final p[] _paramAnnotations;

    public n(e0 e0Var, p pVar, p[] pVarArr) {
        super(e0Var, pVar);
        this._paramAnnotations = pVarArr;
    }

    public final m m(int i) {
        b.g.a.c.j jVarN = n(i);
        e0 e0Var = this.j;
        p[] pVarArr = this._paramAnnotations;
        return new m(this, jVarN, e0Var, (pVarArr == null || i < 0 || i >= pVarArr.length) ? null : pVarArr[i], i);
    }

    public abstract b.g.a.c.j n(int i);
}
