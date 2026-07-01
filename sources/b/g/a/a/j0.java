package b.g.a.a;

/* JADX INFO: compiled from: ObjectIdGenerators.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j0<T> extends i0<T> {
    public final Class<?> _scope;

    public j0(Class<?> cls) {
        this._scope = cls;
    }

    @Override // b.g.a.a.i0
    public boolean a(i0<?> i0Var) {
        return i0Var.getClass() == getClass() && i0Var.d() == this._scope;
    }

    @Override // b.g.a.a.i0
    public final Class<?> d() {
        return this._scope;
    }
}
