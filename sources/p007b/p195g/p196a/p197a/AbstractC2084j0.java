package p007b.p195g.p196a.p197a;

/* JADX INFO: renamed from: b.g.a.a.j0 */
/* JADX INFO: compiled from: ObjectIdGenerators.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2084j0<T> extends AbstractC2082i0<T> {
    public final Class<?> _scope;

    public AbstractC2084j0(Class<?> cls) {
        this._scope = cls;
    }

    @Override // p007b.p195g.p196a.p197a.AbstractC2082i0
    /* JADX INFO: renamed from: a */
    public boolean mo1608a(AbstractC2082i0<?> abstractC2082i0) {
        return abstractC2082i0.getClass() == getClass() && abstractC2082i0.mo1611d() == this._scope;
    }

    @Override // p007b.p195g.p196a.p197a.AbstractC2082i0
    /* JADX INFO: renamed from: d */
    public final Class<?> mo1611d() {
        return this._scope;
    }
}
