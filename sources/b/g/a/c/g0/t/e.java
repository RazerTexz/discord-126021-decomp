package b.g.a.c.g0.t;

import b.g.a.c.x;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: FilteredBeanPropertyWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends b.g.a.c.g0.c implements Serializable {
    private static final long serialVersionUID = 1;
    public final b.g.a.c.g0.c _delegate;
    public final Class<?> _view;

    public e(b.g.a.c.g0.c cVar, Class<?> cls) {
        super(cVar, cVar._name);
        this._delegate = cVar;
        this._view = cls;
    }

    @Override // b.g.a.c.g0.c
    public void e(b.g.a.c.n<Object> nVar) {
        this._delegate.e(nVar);
    }

    @Override // b.g.a.c.g0.c
    public void f(b.g.a.c.n<Object> nVar) {
        this._delegate.f(nVar);
    }

    @Override // b.g.a.c.g0.c
    public b.g.a.c.g0.c g(b.g.a.c.i0.n nVar) {
        return new e(this._delegate.g(nVar), this._view);
    }

    @Override // b.g.a.c.g0.c
    public void h(Object obj, b.g.a.b.d dVar, x xVar) throws Exception {
        Class<?> cls = xVar._serializationView;
        if (cls == null || this._view.isAssignableFrom(cls)) {
            this._delegate.h(obj, dVar, xVar);
            return;
        }
        b.g.a.c.n<Object> nVar = this._delegate._nullSerializer;
        if (nVar != null) {
            nVar.f(null, dVar, xVar);
        } else {
            dVar.A();
        }
    }

    @Override // b.g.a.c.g0.c
    public void i(Object obj, b.g.a.b.d dVar, x xVar) throws Exception {
        Class<?> cls = xVar._serializationView;
        if (cls == null || this._view.isAssignableFrom(cls)) {
            this._delegate.i(obj, dVar, xVar);
        } else {
            Objects.requireNonNull(this._delegate);
            Objects.requireNonNull(dVar);
        }
    }
}
