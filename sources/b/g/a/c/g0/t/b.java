package b.g.a.c.g0.t;

import b.g.a.c.w;
import b.g.a.c.x;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonMappingException$a;
import java.io.IOException;
import java.util.Set;

/* JADX INFO: compiled from: BeanAsArraySerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends b.g.a.c.g0.u.d {
    private static final long serialVersionUID = 1;
    public final b.g.a.c.g0.u.d _defaultSerializer;

    public b(b.g.a.c.g0.u.d dVar, Set<String> set, Set<String> set2) {
        super(dVar, set, set2);
        this._defaultSerializer = dVar;
    }

    @Override // b.g.a.c.n
    public final void f(Object obj, b.g.a.b.d dVar, x xVar) throws IOException {
        if (xVar.D(w.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) {
            b.g.a.c.g0.c[] cVarArr = this._filteredProps;
            if (cVarArr == null || xVar._serializationView == null) {
                cVarArr = this._props;
            }
            if (cVarArr.length == 1) {
                z(obj, dVar, xVar);
                return;
            }
        }
        dVar.X(obj);
        z(obj, dVar, xVar);
        dVar.t();
    }

    @Override // b.g.a.c.g0.u.d, b.g.a.c.n
    public void g(Object obj, b.g.a.b.d dVar, x xVar, b.g.a.c.e0.g gVar) throws IOException {
        if (this._objectIdWriter != null) {
            p(obj, dVar, xVar, gVar);
            return;
        }
        b.g.a.b.s.b bVarR = r(gVar, obj, b.g.a.b.h.START_ARRAY);
        gVar.e(dVar, bVarR);
        dVar.e(obj);
        z(obj, dVar, xVar);
        gVar.f(dVar, bVarR);
    }

    @Override // b.g.a.c.n
    public b.g.a.c.n<Object> h(b.g.a.c.i0.n nVar) {
        return this._defaultSerializer.h(nVar);
    }

    @Override // b.g.a.c.g0.u.d
    public b.g.a.c.g0.u.d s() {
        return this;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("BeanAsArraySerializer for ");
        sbU.append(this._handledType.getName());
        return sbU.toString();
    }

    @Override // b.g.a.c.g0.u.d
    public b.g.a.c.g0.u.d v(Set set, Set set2) {
        return new b(this, (Set<String>) set, (Set<String>) set2);
    }

    @Override // b.g.a.c.g0.u.d
    public b.g.a.c.g0.u.d w(Object obj) {
        return new b(this, this._objectIdWriter, obj);
    }

    @Override // b.g.a.c.g0.u.d
    public b.g.a.c.g0.u.d x(j jVar) {
        return this._defaultSerializer.x(jVar);
    }

    @Override // b.g.a.c.g0.u.d
    public b.g.a.c.g0.u.d y(b.g.a.c.g0.c[] cVarArr, b.g.a.c.g0.c[] cVarArr2) {
        return this;
    }

    public final void z(Object obj, b.g.a.b.d dVar, x xVar) throws IOException {
        b.g.a.c.g0.c[] cVarArr = this._filteredProps;
        if (cVarArr == null || xVar._serializationView == null) {
            cVarArr = this._props;
        }
        int i = 0;
        try {
            int length = cVarArr.length;
            while (i < length) {
                b.g.a.c.g0.c cVar = cVarArr[i];
                if (cVar == null) {
                    dVar.A();
                } else {
                    cVar.h(obj, dVar, xVar);
                }
                i++;
            }
        } catch (Exception e) {
            o(xVar, e, obj, i != cVarArr.length ? cVarArr[i]._name._value : "[anySetter]");
            throw null;
        } catch (StackOverflowError e2) {
            JsonMappingException jsonMappingException = new JsonMappingException(dVar, "Infinite recursion (StackOverflowError)", e2);
            jsonMappingException.e(new JsonMappingException$a(obj, i != cVarArr.length ? cVarArr[i]._name._value : "[anySetter]"));
            throw jsonMappingException;
        }
    }

    public b(b.g.a.c.g0.u.d dVar, j jVar, Object obj) {
        super(dVar, jVar, obj);
        this._defaultSerializer = dVar;
    }

    public b(b.g.a.c.g0.u.d dVar) {
        super(dVar, (j) null, dVar._propertyFilterId);
        this._defaultSerializer = dVar;
    }
}
