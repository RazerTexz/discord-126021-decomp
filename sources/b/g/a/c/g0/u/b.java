package b.g.a.c.g0.u;

import b.g.a.a.i$a;
import b.g.a.a.i$d;
import b.g.a.c.g0.t.l$b;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: AsArraySerializerBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b<T> extends b.g.a.c.g0.h<T> implements b.g.a.c.g0.i {
    public b.g.a.c.g0.t.l _dynamicSerializers;
    public final b.g.a.c.n<Object> _elementSerializer;
    public final b.g.a.c.j _elementType;
    public final b.g.a.c.d _property;
    public final boolean _staticTyping;
    public final Boolean _unwrapSingle;
    public final b.g.a.c.e0.g _valueTypeSerializer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Class<?> cls, b.g.a.c.j jVar, boolean z2, b.g.a.c.e0.g gVar, b.g.a.c.n<Object> nVar) {
        super(cls, false);
        boolean z3 = false;
        this._elementType = jVar;
        if (z2 || (jVar != null && jVar.x())) {
            z3 = true;
        }
        this._staticTyping = z3;
        this._valueTypeSerializer = gVar;
        this._property = null;
        this._elementSerializer = nVar;
        this._dynamicSerializers = l$b.f706b;
        this._unwrapSingle = null;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0020  */
    @Override // b.g.a.c.g0.i
    public b.g.a.c.n<?> a(b.g.a.c.x xVar, b.g.a.c.d dVar) throws JsonMappingException {
        b.g.a.c.n<?> nVarH;
        b.g.a.c.j jVar;
        Object objC;
        b.g.a.c.e0.g gVarA = this._valueTypeSerializer;
        if (gVarA != null) {
            gVarA = gVarA.a(dVar);
        }
        if (dVar != null) {
            b.g.a.c.b bVarV = xVar.v();
            b.g.a.c.c0.i member = dVar.getMember();
            if (member == null || (objC = bVarV.c(member)) == null) {
                nVarH = null;
            } else {
                nVarH = xVar.H(member, objC);
            }
        } else {
            nVarH = null;
        }
        i$d i_dL = l(xVar, dVar, this._handledType);
        Boolean boolB = i_dL != null ? i_dL.b(i$a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) : null;
        if (nVarH == null) {
            nVarH = this._elementSerializer;
        }
        b.g.a.c.n<?> nVarK = k(xVar, dVar, nVarH);
        if (nVarK == null && (jVar = this._elementType) != null && this._staticTyping && !jVar.y()) {
            nVarK = xVar.m(this._elementType, dVar);
        }
        return (nVarK == this._elementSerializer && dVar == this._property && this._valueTypeSerializer == gVarA && Objects.equals(this._unwrapSingle, boolB)) ? this : t(dVar, gVarA, nVarK, boolB);
    }

    @Override // b.g.a.c.n
    public void f(T t, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        if (xVar.D(b.g.a.c.w.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) && q(t)) {
            s(t, dVar, xVar);
            return;
        }
        dVar.X(t);
        s(t, dVar, xVar);
        dVar.t();
    }

    @Override // b.g.a.c.n
    public void g(T t, b.g.a.b.d dVar, b.g.a.c.x xVar, b.g.a.c.e0.g gVar) throws IOException {
        b.g.a.b.s.b bVarE = gVar.e(dVar, gVar.d(t, b.g.a.b.h.START_ARRAY));
        dVar.e(t);
        s(t, dVar, xVar);
        gVar.f(dVar, bVarE);
    }

    public final b.g.a.c.n<Object> r(b.g.a.c.g0.t.l lVar, Class<?> cls, b.g.a.c.x xVar) throws JsonMappingException {
        b.g.a.c.n<Object> nVarN = xVar.n(cls, this._property);
        b.g.a.c.g0.t.l lVarB = lVar.b(cls, nVarN);
        if (lVar != lVarB) {
            this._dynamicSerializers = lVarB;
        }
        return nVarN;
    }

    public abstract void s(T t, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException;

    public abstract b<T> t(b.g.a.c.d dVar, b.g.a.c.e0.g gVar, b.g.a.c.n<?> nVar, Boolean bool);

    public b(b<?> bVar, b.g.a.c.d dVar, b.g.a.c.e0.g gVar, b.g.a.c.n<?> nVar, Boolean bool) {
        super(bVar);
        this._elementType = bVar._elementType;
        this._staticTyping = bVar._staticTyping;
        this._valueTypeSerializer = gVar;
        this._property = dVar;
        this._elementSerializer = nVar;
        this._dynamicSerializers = l$b.f706b;
        this._unwrapSingle = bool;
    }
}
