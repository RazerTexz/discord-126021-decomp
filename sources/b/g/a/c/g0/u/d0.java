package b.g.a.c.g0.u;

import b.g.a.a.i$a;
import b.g.a.a.i$d;
import b.g.a.c.g0.t.l$b;
import b.g.a.c.g0.t.l$d;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: ObjectArraySerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@b.g.a.c.y.a
public class d0 extends a<Object[]> implements b.g.a.c.g0.i {
    public b.g.a.c.g0.t.l _dynamicSerializers;
    public b.g.a.c.n<Object> _elementSerializer;
    public final b.g.a.c.j _elementType;
    public final boolean _staticTyping;
    public final b.g.a.c.e0.g _valueTypeSerializer;

    public d0(b.g.a.c.j jVar, boolean z2, b.g.a.c.e0.g gVar, b.g.a.c.n<Object> nVar) {
        super(Object[].class);
        this._elementType = jVar;
        this._staticTyping = z2;
        this._valueTypeSerializer = gVar;
        this._dynamicSerializers = l$b.f706b;
        this._elementSerializer = nVar;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0021  */
    @Override // b.g.a.c.g0.u.a, b.g.a.c.g0.i
    public b.g.a.c.n<?> a(b.g.a.c.x xVar, b.g.a.c.d dVar) throws JsonMappingException {
        b.g.a.c.n<?> nVarH;
        b.g.a.c.j jVar;
        Object objC;
        b.g.a.c.e0.g gVarA = this._valueTypeSerializer;
        if (gVarA != null) {
            gVarA = gVarA.a(dVar);
        }
        b.g.a.c.e0.g gVar = gVarA;
        if (dVar != null) {
            b.g.a.c.c0.i member = dVar.getMember();
            b.g.a.c.b bVarV = xVar.v();
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
        b.g.a.c.n<?> nVarM = (nVarK != null || (jVar = this._elementType) == null || !this._staticTyping || jVar.y()) ? nVarK : xVar.m(this._elementType, dVar);
        return (this._property == dVar && nVarM == this._elementSerializer && this._valueTypeSerializer == gVar && Objects.equals(this._unwrapSingle, boolB)) ? this : new d0(this, dVar, gVar, nVarM, boolB);
    }

    @Override // b.g.a.c.n
    public boolean d(b.g.a.c.x xVar, Object obj) {
        return ((Object[]) obj).length == 0;
    }

    @Override // b.g.a.c.g0.u.a, b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        Object[] objArr = (Object[]) obj;
        int length = objArr.length;
        if (length == 1 && ((this._unwrapSingle == null && xVar.D(b.g.a.c.w.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            u(objArr, dVar, xVar);
            return;
        }
        dVar.b0(objArr, length);
        u(objArr, dVar, xVar);
        dVar.t();
    }

    @Override // b.g.a.c.g0.h
    public b.g.a.c.g0.h<?> p(b.g.a.c.e0.g gVar) {
        return new d0(this._elementType, this._staticTyping, gVar, this._elementSerializer);
    }

    @Override // b.g.a.c.g0.h
    public boolean q(Object obj) {
        return ((Object[]) obj).length == 1;
    }

    @Override // b.g.a.c.g0.u.a
    public b.g.a.c.n<?> s(b.g.a.c.d dVar, Boolean bool) {
        return new d0(this, dVar, this._valueTypeSerializer, this._elementSerializer, bool);
    }

    @Override // b.g.a.c.g0.u.a
    public /* bridge */ /* synthetic */ void t(Object[] objArr, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        u(objArr, dVar, xVar);
    }

    public void u(Object[] objArr, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        Object obj;
        Object obj2;
        b.g.a.c.g0.t.l lVarB;
        int length = objArr.length;
        if (length == 0) {
            return;
        }
        b.g.a.c.n<Object> nVar = this._elementSerializer;
        int i = 0;
        if (nVar != null) {
            int length2 = objArr.length;
            b.g.a.c.e0.g gVar = this._valueTypeSerializer;
            Object obj3 = null;
            while (i < length2) {
                try {
                    obj3 = objArr[i];
                    if (obj3 == null) {
                        xVar.l(dVar);
                    } else if (gVar == null) {
                        nVar.f(obj3, dVar, xVar);
                    } else {
                        nVar.g(obj3, dVar, xVar, gVar);
                    }
                    i++;
                } catch (Exception e) {
                    n(xVar, e, obj3, i);
                    throw null;
                }
            }
            return;
        }
        b.g.a.c.e0.g gVar2 = this._valueTypeSerializer;
        if (gVar2 != null) {
            int length3 = objArr.length;
            try {
                b.g.a.c.g0.t.l lVar = this._dynamicSerializers;
                obj2 = null;
                while (i < length3) {
                    try {
                        obj2 = objArr[i];
                        if (obj2 == null) {
                            xVar.l(dVar);
                        } else {
                            Class<?> cls = obj2.getClass();
                            b.g.a.c.n<Object> nVarC = lVar.c(cls);
                            if (nVarC == null && lVar != (lVarB = lVar.b(cls, (nVarC = xVar.n(cls, this._property))))) {
                                this._dynamicSerializers = lVarB;
                            }
                            nVarC.g(obj2, dVar, xVar, gVar2);
                        }
                        i++;
                    } catch (Exception e2) {
                        e = e2;
                        n(xVar, e, obj2, i);
                        throw null;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                obj2 = null;
            }
        } else {
            try {
                b.g.a.c.g0.t.l lVar2 = this._dynamicSerializers;
                obj = null;
                while (i < length) {
                    try {
                        obj = objArr[i];
                        if (obj == null) {
                            xVar.l(dVar);
                        } else {
                            Class<?> cls2 = obj.getClass();
                            b.g.a.c.n<Object> nVarC2 = lVar2.c(cls2);
                            if (nVarC2 == null) {
                                if (this._elementType.r()) {
                                    l$d l_dA = lVar2.a(xVar.k(this._elementType, cls2), xVar, this._property);
                                    b.g.a.c.g0.t.l lVar3 = l_dA.f708b;
                                    if (lVar2 != lVar3) {
                                        this._dynamicSerializers = lVar3;
                                    }
                                    nVarC2 = l_dA.a;
                                } else {
                                    nVarC2 = xVar.n(cls2, this._property);
                                    b.g.a.c.g0.t.l lVarB2 = lVar2.b(cls2, nVarC2);
                                    if (lVar2 != lVarB2) {
                                        this._dynamicSerializers = lVarB2;
                                    }
                                }
                            }
                            nVarC2.f(obj, dVar, xVar);
                        }
                        i++;
                    } catch (Exception e4) {
                        e = e4;
                        n(xVar, e, obj, i);
                        throw null;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                obj = null;
            }
        }
    }

    public d0(d0 d0Var, b.g.a.c.d dVar, b.g.a.c.e0.g gVar, b.g.a.c.n<?> nVar, Boolean bool) {
        super(d0Var, dVar, bool);
        this._elementType = d0Var._elementType;
        this._valueTypeSerializer = gVar;
        this._staticTyping = d0Var._staticTyping;
        this._dynamicSerializers = l$b.f706b;
        this._elementSerializer = nVar;
    }
}
