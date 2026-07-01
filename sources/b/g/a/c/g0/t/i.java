package b.g.a.c.g0.t;

import b.g.a.a.p$a;
import b.g.a.a.p$b;
import b.g.a.c.x;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;

/* JADX INFO: compiled from: MapEntrySerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@b.g.a.c.y.a
public class i extends b.g.a.c.g0.h<Map$Entry<?, ?>> implements b.g.a.c.g0.i {
    public l _dynamicValueSerializers;
    public final b.g.a.c.j _entryType;
    public b.g.a.c.n<Object> _keySerializer;
    public final b.g.a.c.j _keyType;
    public final b.g.a.c.d _property;
    public final boolean _suppressNulls;
    public final Object _suppressableValue;
    public b.g.a.c.n<Object> _valueSerializer;
    public final b.g.a.c.j _valueType;
    public final boolean _valueTypeIsStatic;
    public final b.g.a.c.e0.g _valueTypeSerializer;

    public i(b.g.a.c.j jVar, b.g.a.c.j jVar2, b.g.a.c.j jVar3, boolean z2, b.g.a.c.e0.g gVar, b.g.a.c.d dVar) {
        super(jVar);
        this._entryType = jVar;
        this._keyType = jVar2;
        this._valueType = jVar3;
        this._valueTypeIsStatic = z2;
        this._valueTypeSerializer = gVar;
        this._property = dVar;
        this._dynamicValueSerializers = l$b.f706b;
        this._suppressableValue = null;
        this._suppressNulls = false;
    }

    @Override // b.g.a.c.g0.i
    public b.g.a.c.n<?> a(x xVar, b.g.a.c.d dVar) throws JsonMappingException {
        b.g.a.c.n<Object> nVarH;
        b.g.a.c.n<?> nVarH2;
        Object obj;
        boolean zB;
        p$b p_bB;
        p$a p_a;
        Object objT0 = p$a.NON_EMPTY;
        b.g.a.c.b bVarV = xVar.v();
        b.g.a.c.c0.i member = dVar == null ? null : dVar.getMember();
        if (member == null || bVarV == null) {
            nVarH = null;
            nVarH2 = null;
        } else {
            Object objL = bVarV.l(member);
            nVarH2 = objL != null ? xVar.H(member, objL) : null;
            Object objC = bVarV.c(member);
            nVarH = objC != null ? xVar.H(member, objC) : null;
        }
        if (nVarH == null) {
            nVarH = this._valueSerializer;
        }
        b.g.a.c.n<?> nVarK = k(xVar, dVar, nVarH);
        if (nVarK == null && this._valueTypeIsStatic && !this._valueType.y()) {
            nVarK = xVar.m(this._valueType, dVar);
        }
        b.g.a.c.n<?> nVar = nVarK;
        if (nVarH2 == null) {
            nVarH2 = this._keySerializer;
        }
        b.g.a.c.n<?> nVarO = nVarH2 == null ? xVar.o(this._keyType, dVar) : xVar.z(nVarH2, dVar);
        Object obj2 = this._suppressableValue;
        boolean z2 = this._suppressNulls;
        if (dVar == null || (p_bB = dVar.b(xVar._config, null)) == null || (p_a = p_bB._contentInclusion) == p$a.USE_DEFAULTS) {
            obj = obj2;
            zB = z2;
        } else {
            int iOrdinal = p_a.ordinal();
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    if (iOrdinal != 3) {
                        if (iOrdinal == 4) {
                            objT0 = b.c.a.a0.d.t0(this._valueType);
                            if (objT0 != null && objT0.getClass().isArray()) {
                                objT0 = b.c.a.a0.d.q0(objT0);
                            }
                        } else if (iOrdinal != 5) {
                            obj = null;
                            zB = false;
                        } else {
                            objT0 = xVar.A(null, p_bB._contentFilter);
                            if (objT0 != null) {
                                zB = xVar.B(objT0);
                                obj = objT0;
                            }
                        }
                    }
                } else if (!this._valueType.b()) {
                    objT0 = null;
                }
                obj = objT0;
            } else {
                obj = null;
            }
            zB = true;
        }
        return new i(this, nVarO, nVar, obj, zB);
    }

    @Override // b.g.a.c.n
    public boolean d(x xVar, Object obj) {
        Object value = ((Map$Entry) obj).getValue();
        if (value == null) {
            return this._suppressNulls;
        }
        if (this._suppressableValue != null) {
            b.g.a.c.n<Object> nVar = this._valueSerializer;
            if (nVar == null) {
                Class<?> cls = value.getClass();
                b.g.a.c.n<Object> nVarC = this._dynamicValueSerializers.c(cls);
                if (nVarC == null) {
                    try {
                        l lVar = this._dynamicValueSerializers;
                        b.g.a.c.d dVar = this._property;
                        Objects.requireNonNull(lVar);
                        b.g.a.c.n<Object> nVarN = xVar.n(cls, dVar);
                        l lVarB = lVar.b(cls, nVarN);
                        if (lVar != lVarB) {
                            this._dynamicValueSerializers = lVarB;
                        }
                        nVar = nVarN;
                    } catch (JsonMappingException unused) {
                    }
                } else {
                    nVar = nVarC;
                }
            }
            Object obj2 = this._suppressableValue;
            return obj2 == p$a.NON_EMPTY ? nVar.d(xVar, value) : obj2.equals(value);
        }
        return false;
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, x xVar) throws IOException {
        Map$Entry<?, ?> map$Entry = (Map$Entry) obj;
        dVar.d0(map$Entry);
        r(map$Entry, dVar, xVar);
        dVar.u();
    }

    @Override // b.g.a.c.n
    public void g(Object obj, b.g.a.b.d dVar, x xVar, b.g.a.c.e0.g gVar) throws IOException {
        Map$Entry<?, ?> map$Entry = (Map$Entry) obj;
        dVar.e(map$Entry);
        b.g.a.b.s.b bVarE = gVar.e(dVar, gVar.d(map$Entry, b.g.a.b.h.START_OBJECT));
        r(map$Entry, dVar, xVar);
        gVar.f(dVar, bVarE);
    }

    @Override // b.g.a.c.g0.h
    public b.g.a.c.g0.h<?> p(b.g.a.c.e0.g gVar) {
        return new i(this, this._keySerializer, this._valueSerializer, this._suppressableValue, this._suppressNulls);
    }

    public void r(Map$Entry<?, ?> map$Entry, b.g.a.b.d dVar, x xVar) throws IOException {
        b.g.a.c.n<Object> nVar;
        b.g.a.c.e0.g gVar = this._valueTypeSerializer;
        Object key = map$Entry.getKey();
        b.g.a.c.n<Object> nVar2 = key == null ? xVar._nullKeySerializer : this._keySerializer;
        Object value = map$Entry.getValue();
        if (value != null) {
            nVar = this._valueSerializer;
            if (nVar == null) {
                Class<?> cls = value.getClass();
                b.g.a.c.n<Object> nVarC = this._dynamicValueSerializers.c(cls);
                if (nVarC != null) {
                    nVar = nVarC;
                } else if (this._valueType.r()) {
                    l lVar = this._dynamicValueSerializers;
                    l$d l_dA = lVar.a(xVar.k(this._valueType, cls), xVar, this._property);
                    l lVar2 = l_dA.f708b;
                    if (lVar != lVar2) {
                        this._dynamicValueSerializers = lVar2;
                    }
                    nVar = l_dA.a;
                } else {
                    l lVar3 = this._dynamicValueSerializers;
                    b.g.a.c.d dVar2 = this._property;
                    Objects.requireNonNull(lVar3);
                    b.g.a.c.n<Object> nVarN = xVar.n(cls, dVar2);
                    l lVarB = lVar3.b(cls, nVarN);
                    if (lVar3 != lVarB) {
                        this._dynamicValueSerializers = lVarB;
                    }
                    nVar = nVarN;
                }
            }
            Object obj = this._suppressableValue;
            if (obj != null && ((obj == p$a.NON_EMPTY && nVar.d(xVar, value)) || this._suppressableValue.equals(value))) {
                return;
            }
        } else if (this._suppressNulls) {
            return;
        } else {
            nVar = xVar._nullValueSerializer;
        }
        nVar2.f(key, dVar, xVar);
        try {
            if (gVar == null) {
                nVar.f(value, dVar, xVar);
            } else {
                nVar.g(value, dVar, xVar, gVar);
            }
        } catch (Exception e) {
            o(xVar, e, map$Entry, b.d.b.a.a.v("", key));
            throw null;
        }
    }

    public i(i iVar, b.g.a.c.n nVar, b.g.a.c.n nVar2, Object obj, boolean z2) {
        super(Map.class, false);
        this._entryType = iVar._entryType;
        this._keyType = iVar._keyType;
        this._valueType = iVar._valueType;
        this._valueTypeIsStatic = iVar._valueTypeIsStatic;
        this._valueTypeSerializer = iVar._valueTypeSerializer;
        this._keySerializer = nVar;
        this._valueSerializer = nVar2;
        this._dynamicValueSerializers = l$b.f706b;
        this._property = iVar._property;
        this._suppressableValue = obj;
        this._suppressNulls = z2;
    }
}
