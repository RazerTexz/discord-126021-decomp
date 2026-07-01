package b.g.a.c.g0.t;

import b.g.a.c.w;
import b.g.a.c.x;
import java.io.IOException;
import java.io.Serializable;
import java.util.Set;

/* JADX INFO: compiled from: UnwrappingBeanSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class t extends b.g.a.c.g0.u.d implements Serializable {
    private static final long serialVersionUID = 1;
    public final b.g.a.c.i0.n _nameTransformer;

    public t(t tVar, j jVar, Object obj) {
        super(tVar, jVar, obj);
        this._nameTransformer = tVar._nameTransformer;
    }

    @Override // b.g.a.c.n
    public final void f(Object obj, b.g.a.b.d dVar, x xVar) throws IOException {
        dVar.e(obj);
        if (this._objectIdWriter != null) {
            q(obj, dVar, xVar, false);
            return;
        }
        Object obj2 = this._propertyFilterId;
        if (obj2 == null) {
            u(obj, dVar, xVar);
            return;
        }
        if (this._filteredProps != null) {
            Class<?> cls = xVar._serializationView;
        }
        m(xVar, obj2, obj);
        throw null;
    }

    @Override // b.g.a.c.g0.u.d, b.g.a.c.n
    public void g(Object obj, b.g.a.b.d dVar, x xVar, b.g.a.c.e0.g gVar) throws IOException {
        if (xVar.D(w.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS)) {
            xVar.g(this._handledType, "Unwrapped property requires use of type information: cannot serialize without disabling `SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS`");
        }
        dVar.e(obj);
        if (this._objectIdWriter != null) {
            p(obj, dVar, xVar, gVar);
            return;
        }
        Object obj2 = this._propertyFilterId;
        if (obj2 == null) {
            u(obj, dVar, xVar);
        } else {
            b.g.a.c.g0.c[] cVarArr = this._filteredProps;
            m(xVar, obj2, obj);
            throw null;
        }
    }

    @Override // b.g.a.c.n
    public b.g.a.c.n<Object> h(b.g.a.c.i0.n nVar) {
        return new t(this, nVar);
    }

    @Override // b.g.a.c.g0.u.d
    public b.g.a.c.g0.u.d s() {
        return this;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("UnwrappingBeanSerializer for ");
        sbU.append(this._handledType.getName());
        return sbU.toString();
    }

    @Override // b.g.a.c.g0.u.d
    public b.g.a.c.g0.u.d v(Set<String> set, Set<String> set2) {
        return new t(this, set, set2);
    }

    @Override // b.g.a.c.g0.u.d
    public b.g.a.c.g0.u.d w(Object obj) {
        return new t(this, this._objectIdWriter, obj);
    }

    @Override // b.g.a.c.g0.u.d
    public b.g.a.c.g0.u.d x(j jVar) {
        return new t(this, jVar);
    }

    @Override // b.g.a.c.g0.u.d
    public b.g.a.c.g0.u.d y(b.g.a.c.g0.c[] cVarArr, b.g.a.c.g0.c[] cVarArr2) {
        return new t(this, cVarArr, cVarArr2);
    }

    public t(t tVar, Set<String> set, Set<String> set2) {
        super(tVar, set, set2);
        this._nameTransformer = tVar._nameTransformer;
    }

    public t(t tVar, b.g.a.c.g0.c[] cVarArr, b.g.a.c.g0.c[] cVarArr2) {
        super(tVar, cVarArr, cVarArr2);
        this._nameTransformer = tVar._nameTransformer;
    }

    public t(t tVar, j jVar) {
        super(tVar, jVar, tVar._propertyFilterId);
        this._nameTransformer = tVar._nameTransformer;
    }

    public t(b.g.a.c.g0.u.d dVar, b.g.a.c.i0.n nVar) {
        super(dVar, b.g.a.c.g0.u.d.t(dVar._props, nVar), b.g.a.c.g0.u.d.t(dVar._filteredProps, nVar));
        this._nameTransformer = nVar;
    }
}
