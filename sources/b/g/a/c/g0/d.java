package b.g.a.c.g0;

import b.g.a.c.g0.t.t;
import b.g.a.c.x;
import java.io.IOException;
import java.util.Set;

/* JADX INFO: compiled from: BeanSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends b.g.a.c.g0.u.d {
    private static final long serialVersionUID = 29;

    public d(b.g.a.c.j jVar, e eVar, c[] cVarArr, c[] cVarArr2) {
        super(jVar, eVar, cVarArr, cVarArr2);
    }

    @Override // b.g.a.c.n
    public final void f(Object obj, b.g.a.b.d dVar, x xVar) throws IOException {
        if (this._objectIdWriter != null) {
            dVar.e(obj);
            q(obj, dVar, xVar, true);
            return;
        }
        dVar.d0(obj);
        Object obj2 = this._propertyFilterId;
        if (obj2 == null) {
            u(obj, dVar, xVar);
            dVar.u();
        } else {
            if (this._filteredProps != null) {
                Class<?> cls = xVar._serializationView;
            }
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
        return (this._objectIdWriter == null && this._anyGetterWriter == null && this._propertyFilterId == null) ? new b.g.a.c.g0.t.b(this) : this;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("BeanSerializer for ");
        sbU.append(this._handledType.getName());
        return sbU.toString();
    }

    @Override // b.g.a.c.g0.u.d
    public b.g.a.c.g0.u.d v(Set<String> set, Set<String> set2) {
        return new d(this, set, set2);
    }

    @Override // b.g.a.c.g0.u.d
    public b.g.a.c.g0.u.d w(Object obj) {
        return new d(this, this._objectIdWriter, obj);
    }

    @Override // b.g.a.c.g0.u.d
    public b.g.a.c.g0.u.d x(b.g.a.c.g0.t.j jVar) {
        return new d(this, jVar, this._propertyFilterId);
    }

    @Override // b.g.a.c.g0.u.d
    public b.g.a.c.g0.u.d y(c[] cVarArr, c[] cVarArr2) {
        return new d(this, cVarArr, cVarArr2);
    }

    public d(b.g.a.c.g0.u.d dVar, b.g.a.c.g0.t.j jVar, Object obj) {
        super(dVar, jVar, obj);
    }

    public d(b.g.a.c.g0.u.d dVar, Set<String> set, Set<String> set2) {
        super(dVar, set, set2);
    }

    public d(b.g.a.c.g0.u.d dVar, c[] cVarArr, c[] cVarArr2) {
        super(dVar, cVarArr, cVarArr2);
    }
}
