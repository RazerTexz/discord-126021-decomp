package b.g.a.c;

import b.g.a.a.i0;
import b.g.a.c.z.i$a;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Map;

/* JADX INFO: compiled from: SerializerProvider.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class x extends e {
    public static final n<Object> j = new b.g.a.c.g0.t.c("Null key for a Map not allowed in JSON (use a converting NullKeySerializer?)");
    public static final n<Object> k = new b.g.a.c.g0.t.q();
    public final v _config;
    public DateFormat _dateFormat;
    public n<Object> _keySerializer;
    public final b.g.a.c.g0.t.m _knownSerializers;
    public n<Object> _nullKeySerializer;
    public n<Object> _nullValueSerializer;
    public final Class<?> _serializationView;
    public final b.g.a.c.g0.p _serializerCache;
    public final b.g.a.c.g0.q _serializerFactory;
    public final boolean _stdNullValueSerializer;
    public n<Object> _unknownTypeSerializer;
    public transient b.g.a.c.z.i l;

    public x() {
        this._unknownTypeSerializer = k;
        this._nullValueSerializer = b.g.a.c.g0.u.u.k;
        this._nullKeySerializer = j;
        this._config = null;
        this._serializerFactory = null;
        this._serializerCache = new b.g.a.c.g0.p();
        this._knownSerializers = null;
        this._serializationView = null;
        this.l = null;
        this._stdNullValueSerializer = true;
    }

    public abstract Object A(b.g.a.c.c0.s sVar, Class<?> cls) throws JsonMappingException;

    public abstract boolean B(Object obj) throws JsonMappingException;

    public final boolean C(p pVar) {
        return pVar.h(this._config._mapperFeatures);
    }

    public final boolean D(w wVar) {
        return this._config.v(wVar);
    }

    public <T> T E(c cVar, b.g.a.c.c0.s sVar, String str, Object... objArr) throws JsonMappingException {
        String str2;
        String strA = a(str, objArr);
        if (sVar != null) {
            String strP = sVar.p();
            if (strP == null) {
                str2 = "[N/A]";
            } else {
                Object[] objArr2 = new Object[1];
                if (strP.length() > 500) {
                    strP = strP.substring(0, 500) + "]...[" + strP.substring(strP.length() - 500);
                }
                objArr2[0] = strP;
                str2 = String.format("\"%s\"", objArr2);
            }
        } else {
            str2 = "N/A";
        }
        throw new InvalidDefinitionException(((b.g.a.c.g0.j) this).o, String.format("Invalid definition for property %s (of type %s): %s", str2, cVar != null ? b.g.a.c.i0.d.u(cVar.a._class) : "N/A", strA), cVar, sVar);
    }

    public <T> T F(c cVar, String str, Object... objArr) throws JsonMappingException {
        throw new InvalidDefinitionException(((b.g.a.c.g0.j) this).o, String.format("Invalid type definition for type %s: %s", b.g.a.c.i0.d.u(cVar.a._class), a(str, objArr)), cVar, null);
    }

    public void G(String str, Object... objArr) throws JsonMappingException {
        throw new JsonMappingException(((b.g.a.c.g0.j) this).o, a(str, objArr), null);
    }

    public abstract n<Object> H(b.g.a.c.c0.b bVar, Object obj) throws JsonMappingException;

    @Override // b.g.a.c.e
    public final b.g.a.c.h0.n d() {
        return this._config._base._typeFactory;
    }

    @Override // b.g.a.c.e
    public <T> T f(j jVar, String str) throws JsonMappingException {
        throw new InvalidDefinitionException(((b.g.a.c.g0.j) this).o, str, jVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n<Object> h(j jVar) throws JsonMappingException {
        try {
            n<Object> nVarB = this._serializerFactory.b(this, jVar);
            if (nVarB != 0) {
                b.g.a.c.g0.p pVar = this._serializerCache;
                synchronized (pVar) {
                    if (pVar.a.put(new b.g.a.c.i0.u(jVar, false), nVarB) == null) {
                        pVar.f703b.set(null);
                    }
                    if (nVarB instanceof b.g.a.c.g0.o) {
                        ((b.g.a.c.g0.o) nVarB).b(this);
                    }
                }
            }
            return nVarB;
        } catch (IllegalArgumentException e) {
            throw new JsonMappingException(((b.g.a.c.g0.j) this).o, a(b.g.a.c.i0.d.h(e), new Object[0]), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n<Object> i(Class<?> cls) throws JsonMappingException {
        j jVarB = this._config._base._typeFactory.b(null, cls, b.g.a.c.h0.n.l);
        try {
            n<Object> nVarB = this._serializerFactory.b(this, jVarB);
            if (nVarB != 0) {
                b.g.a.c.g0.p pVar = this._serializerCache;
                synchronized (pVar) {
                    n<Object> nVarPut = pVar.a.put(new b.g.a.c.i0.u(cls, false), nVarB);
                    n<Object> nVarPut2 = pVar.a.put(new b.g.a.c.i0.u(jVarB, false), nVarB);
                    if (nVarPut == null || nVarPut2 == null) {
                        pVar.f703b.set(null);
                    }
                    if (nVarB instanceof b.g.a.c.g0.o) {
                        ((b.g.a.c.g0.o) nVarB).b(this);
                    }
                }
            }
            return nVarB;
        } catch (IllegalArgumentException e) {
            throw new JsonMappingException(((b.g.a.c.g0.j) this).o, a(b.g.a.c.i0.d.h(e), new Object[0]), e);
        }
    }

    public final DateFormat j() {
        DateFormat dateFormat = this._dateFormat;
        if (dateFormat != null) {
            return dateFormat;
        }
        DateFormat dateFormat2 = (DateFormat) this._config._base._dateFormat.clone();
        this._dateFormat = dateFormat2;
        return dateFormat2;
    }

    public j k(j jVar, Class<?> cls) throws IllegalArgumentException {
        return jVar._class == cls ? jVar : this._config._base._typeFactory.h(jVar, cls, true);
    }

    public final void l(b.g.a.b.d dVar) throws IOException {
        if (this._stdNullValueSerializer) {
            dVar.A();
        } else {
            this._nullValueSerializer.f(null, dVar, this);
        }
    }

    public n<Object> m(j jVar, d dVar) throws JsonMappingException {
        n<Object> nVarA = this._knownSerializers.a(jVar);
        return (nVarA == null && (nVarA = this._serializerCache.a(jVar)) == null && (nVarA = h(jVar)) == null) ? x(jVar._class) : z(nVarA, dVar);
    }

    public n<Object> n(Class<?> cls, d dVar) throws JsonMappingException {
        n<Object> nVarB = this._knownSerializers.b(cls);
        return (nVarB == null && (nVarB = this._serializerCache.b(cls)) == null && (nVarB = this._serializerCache.a(this._config._base._typeFactory.b(null, cls, b.g.a.c.h0.n.l))) == null && (nVarB = i(cls)) == null) ? x(cls) : z(nVarB, dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n<Object> o(j jVar, d dVar) throws JsonMappingException {
        n<Object> nVarA = this._serializerFactory.a(this, jVar, this._keySerializer);
        if (nVarA instanceof b.g.a.c.g0.o) {
            ((b.g.a.c.g0.o) nVarA).b(this);
        }
        return z(nVarA, dVar);
    }

    public abstract b.g.a.c.g0.t.u p(Object obj, i0<?> i0Var);

    public n<Object> q(j jVar, d dVar) throws JsonMappingException {
        n<Object> nVarA = this._knownSerializers.a(jVar);
        return (nVarA == null && (nVarA = this._serializerCache.a(jVar)) == null && (nVarA = h(jVar)) == null) ? x(jVar._class) : y(nVarA, dVar);
    }

    public n<Object> r(Class<?> cls, d dVar) throws JsonMappingException {
        n<Object> nVarB = this._knownSerializers.b(cls);
        return (nVarB == null && (nVarB = this._serializerCache.b(cls)) == null && (nVarB = this._serializerCache.a(this._config._base._typeFactory.b(null, cls, b.g.a.c.h0.n.l))) == null && (nVarB = i(cls)) == null) ? x(cls) : y(nVarB, dVar);
    }

    public n<Object> s(j jVar) throws JsonMappingException {
        n<Object> nVarA = this._knownSerializers.a(jVar);
        if (nVarA != null) {
            return nVarA;
        }
        n<Object> nVarA2 = this._serializerCache.a(jVar);
        if (nVarA2 != null) {
            return nVarA2;
        }
        n<Object> nVarH = h(jVar);
        return nVarH == null ? x(jVar._class) : nVarH;
    }

    public n<Object> t(j jVar, d dVar) throws JsonMappingException {
        if (jVar != null) {
            n<Object> nVarA = this._knownSerializers.a(jVar);
            return (nVarA == null && (nVarA = this._serializerCache.a(jVar)) == null && (nVarA = h(jVar)) == null) ? x(jVar._class) : z(nVarA, dVar);
        }
        G("Null passed for `valueType` of `findValueSerializer()`", new Object[0]);
        throw null;
    }

    public n<Object> u(Class<?> cls, d dVar) throws JsonMappingException {
        n<Object> nVarB = this._knownSerializers.b(cls);
        return (nVarB == null && (nVarB = this._serializerCache.b(cls)) == null && (nVarB = this._serializerCache.a(this._config._base._typeFactory.b(null, cls, b.g.a.c.h0.n.l))) == null && (nVarB = i(cls)) == null) ? x(cls) : z(nVarB, dVar);
    }

    public final b v() {
        return this._config.e();
    }

    public Object w(Object obj) {
        Object obj2;
        i$a i_a = (i$a) this.l;
        Map<Object, Object> map = i_a.l;
        if (map == null || (obj2 = map.get(obj)) == null) {
            return i_a._shared.get(obj);
        }
        if (obj2 == i$a.k) {
            return null;
        }
        return obj2;
    }

    public n<Object> x(Class<?> cls) {
        return cls == Object.class ? this._unknownTypeSerializer : new b.g.a.c.g0.t.q(cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n<?> y(n<?> nVar, d dVar) throws JsonMappingException {
        return (nVar == 0 || !(nVar instanceof b.g.a.c.g0.i)) ? nVar : ((b.g.a.c.g0.i) nVar).a(this, dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n<?> z(n<?> nVar, d dVar) throws JsonMappingException {
        return (nVar == 0 || !(nVar instanceof b.g.a.c.g0.i)) ? nVar : ((b.g.a.c.g0.i) nVar).a(this, dVar);
    }

    public x(x xVar, v vVar, b.g.a.c.g0.q qVar) {
        this._unknownTypeSerializer = k;
        this._nullValueSerializer = b.g.a.c.g0.u.u.k;
        n<Object> nVar = j;
        this._nullKeySerializer = nVar;
        this._serializerFactory = qVar;
        this._config = vVar;
        b.g.a.c.g0.p pVar = xVar._serializerCache;
        this._serializerCache = pVar;
        this._unknownTypeSerializer = xVar._unknownTypeSerializer;
        this._keySerializer = xVar._keySerializer;
        n<Object> nVar2 = xVar._nullValueSerializer;
        this._nullValueSerializer = nVar2;
        this._nullKeySerializer = xVar._nullKeySerializer;
        this._stdNullValueSerializer = nVar2 == nVar;
        this._serializationView = vVar._view;
        this.l = vVar._attributes;
        b.g.a.c.g0.t.m mVar = pVar.f703b.get();
        if (mVar == null) {
            synchronized (pVar) {
                mVar = pVar.f703b.get();
                if (mVar == null) {
                    b.g.a.c.g0.t.m mVar2 = new b.g.a.c.g0.t.m(pVar.a);
                    pVar.f703b.set(mVar2);
                    mVar = mVar2;
                }
            }
        }
        this._knownSerializers = mVar;
    }
}
