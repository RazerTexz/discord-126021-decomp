package b.g.a.c.g0.t;

import b.g.a.c.x;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: FilteredBeanPropertyWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends b.g.a.c.g0.c implements Serializable {
    private static final long serialVersionUID = 1;
    public final b.g.a.c.g0.c _delegate;
    public final Class<?>[] _views;

    public d(b.g.a.c.g0.c cVar, Class<?>[] clsArr) {
        super(cVar, cVar._name);
        this._delegate = cVar;
        this._views = clsArr;
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
        return new d(this._delegate.g(nVar), this._views);
    }

    @Override // b.g.a.c.g0.c
    public void h(Object obj, b.g.a.b.d dVar, x xVar) throws Exception {
        if (j(xVar._serializationView)) {
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
        if (j(xVar._serializationView)) {
            this._delegate.i(obj, dVar, xVar);
        } else {
            Objects.requireNonNull(this._delegate);
            Objects.requireNonNull(dVar);
        }
    }

    public final boolean j(Class<?> cls) {
        if (cls == null) {
            return true;
        }
        int length = this._views.length;
        for (int i = 0; i < length; i++) {
            if (this._views[i].isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }
}
