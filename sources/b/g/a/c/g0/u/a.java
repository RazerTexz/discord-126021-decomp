package b.g.a.c.g0.u;

import b.g.a.a.i$a;
import b.g.a.a.i$d;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: ArraySerializerBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a<T> extends b.g.a.c.g0.h<T> implements b.g.a.c.g0.i {
    public final b.g.a.c.d _property;
    public final Boolean _unwrapSingle;

    public a(Class<T> cls) {
        super(cls);
        this._property = null;
        this._unwrapSingle = null;
    }

    public b.g.a.c.n<?> a(b.g.a.c.x xVar, b.g.a.c.d dVar) throws JsonMappingException {
        i$d i_dL;
        if (dVar != null && (i_dL = l(xVar, dVar, this._handledType)) != null) {
            Boolean boolB = i_dL.b(i$a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
            if (!Objects.equals(boolB, this._unwrapSingle)) {
                return s(dVar, boolB);
            }
        }
        return this;
    }

    @Override // b.g.a.c.n
    public void f(T t, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        if (r(xVar) && q(t)) {
            t(t, dVar, xVar);
            return;
        }
        dVar.X(t);
        t(t, dVar, xVar);
        dVar.t();
    }

    @Override // b.g.a.c.n
    public final void g(T t, b.g.a.b.d dVar, b.g.a.c.x xVar, b.g.a.c.e0.g gVar) throws IOException {
        b.g.a.b.s.b bVarE = gVar.e(dVar, gVar.d(t, b.g.a.b.h.START_ARRAY));
        dVar.e(t);
        t(t, dVar, xVar);
        gVar.f(dVar, bVarE);
    }

    public final boolean r(b.g.a.c.x xVar) {
        Boolean bool = this._unwrapSingle;
        return bool == null ? xVar.D(b.g.a.c.w.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) : bool.booleanValue();
    }

    public abstract b.g.a.c.n<?> s(b.g.a.c.d dVar, Boolean bool);

    public abstract void t(T t, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException;

    public a(a<?> aVar, b.g.a.c.d dVar, Boolean bool) {
        super(aVar._handledType, false);
        this._property = dVar;
        this._unwrapSingle = bool;
    }
}
