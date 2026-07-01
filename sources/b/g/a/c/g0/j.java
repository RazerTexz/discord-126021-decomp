package b.g.a.c.g0;

import b.g.a.a.i0;
import b.g.a.c.g0.t.m$a;
import b.g.a.c.g0.t.u;
import b.g.a.c.n$a;
import b.g.a.c.t;
import b.g.a.c.v;
import b.g.a.c.w;
import b.g.a.c.x;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: DefaultSerializerProvider.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j extends x implements Serializable {
    private static final long serialVersionUID = 1;
    public transient Map<Object, u> m;
    public transient ArrayList<i0<?>> n;
    public transient b.g.a.b.d o;

    public j() {
    }

    @Override // b.g.a.c.x
    public Object A(b.g.a.c.c0.s sVar, Class<?> cls) {
        if (cls == null) {
            return null;
        }
        Objects.requireNonNull(this._config._base);
        return b.g.a.c.i0.d.g(cls, this._config.b());
    }

    @Override // b.g.a.c.x
    public boolean B(Object obj) throws JsonMappingException {
        try {
            return obj.equals(null);
        } catch (Throwable th) {
            InvalidDefinitionException invalidDefinitionException = new InvalidDefinitionException(this.o, String.format("Problem determining whether filter of type '%s' should filter out `null` values: (%s) %s", obj.getClass().getName(), th.getClass().getName(), b.g.a.c.i0.d.h(th)), b(obj.getClass()));
            invalidDefinitionException.initCause(th);
            throw invalidDefinitionException;
        }
    }

    @Override // b.g.a.c.x
    public b.g.a.c.n<Object> H(b.g.a.c.c0.b bVar, Object obj) throws JsonMappingException {
        b.g.a.c.n<Object> nVar;
        if (obj instanceof b.g.a.c.n) {
            nVar = (b.g.a.c.n) obj;
        } else {
            if (!(obj instanceof Class)) {
                b.g.a.c.j jVarE = bVar.e();
                StringBuilder sbU = b.d.b.a.a.U("AnnotationIntrospector returned serializer definition of type ");
                sbU.append(obj.getClass().getName());
                sbU.append("; expected type JsonSerializer or Class<JsonSerializer> instead");
                f(jVarE, sbU.toString());
                throw null;
            }
            Class cls = (Class) obj;
            if (cls == n$a.class || b.g.a.c.i0.d.p(cls)) {
                return null;
            }
            if (!b.g.a.c.n.class.isAssignableFrom(cls)) {
                b.g.a.c.j jVarE2 = bVar.e();
                StringBuilder sbU2 = b.d.b.a.a.U("AnnotationIntrospector returned Class ");
                sbU2.append(cls.getName());
                sbU2.append("; expected Class<JsonSerializer>");
                f(jVarE2, sbU2.toString());
                throw null;
            }
            Objects.requireNonNull(this._config._base);
            nVar = (b.g.a.c.n) b.g.a.c.i0.d.g(cls, this._config.b());
        }
        if (nVar instanceof o) {
            ((o) nVar).b(this);
        }
        return nVar;
    }

    public final void I(b.g.a.b.d dVar, Object obj, b.g.a.c.n<Object> nVar, t tVar) throws IOException {
        try {
            dVar.c0();
            v vVar = this._config;
            b.g.a.b.k jVar = tVar._encodedSimple;
            if (jVar == null) {
                jVar = vVar == null ? new b.g.a.b.p.j(tVar._simpleName) : new b.g.a.b.p.j(tVar._simpleName);
                tVar._encodedSimple = jVar;
            }
            dVar.x(jVar);
            nVar.f(obj, dVar, this);
            dVar.u();
        } catch (Exception e) {
            throw J(dVar, e);
        }
    }

    public final IOException J(b.g.a.b.d dVar, Exception exc) {
        if (exc instanceof IOException) {
            return (IOException) exc;
        }
        String strH = b.g.a.c.i0.d.h(exc);
        if (strH == null) {
            StringBuilder sbU = b.d.b.a.a.U("[no message for ");
            sbU.append(exc.getClass().getName());
            sbU.append("]");
            strH = sbU.toString();
        }
        return new JsonMappingException(dVar, strH, exc);
    }

    public abstract j K(v vVar, q qVar);

    public void L(b.g.a.b.d dVar, Object obj) throws IOException {
        b.g.a.c.n<Object> nVarU;
        b.g.a.c.n<Object> nVar;
        this.o = dVar;
        if (obj == null) {
            try {
                this._nullValueSerializer.f(null, dVar, this);
                return;
            } catch (Exception e) {
                throw J(dVar, e);
            }
        }
        Class<?> cls = obj.getClass();
        b.g.a.c.g0.t.m mVar = this._knownSerializers;
        m$a m_a = mVar.a[mVar.f711b & (cls.getName().hashCode() + 1)];
        if (m_a == null) {
            nVarU = null;
            break;
        }
        if (!(m_a.c == cls && m_a.e)) {
            while (true) {
                m_a = m_a.f712b;
                if (m_a == null) {
                    nVarU = null;
                    break;
                } else {
                    if (m_a.c == cls && m_a.e) {
                        nVarU = m_a.a;
                        break;
                    }
                }
            }
        } else {
            nVarU = m_a.a;
        }
        if (nVarU == null) {
            p pVar = this._serializerCache;
            synchronized (pVar) {
                nVar = pVar.a.get(new b.g.a.c.i0.u(cls, true));
            }
            if (nVar != null) {
                nVarU = nVar;
            } else {
                nVarU = u(cls, null);
                q qVar = this._serializerFactory;
                v vVar = this._config;
                b.g.a.c.e0.g gVarC = qVar.c(vVar, vVar._base._typeFactory.b(null, cls, b.g.a.c.h0.n.l));
                if (gVarC != null) {
                    nVarU = new b.g.a.c.g0.t.p(gVarC.a(null), nVarU);
                }
                p pVar2 = this._serializerCache;
                synchronized (pVar2) {
                    if (pVar2.a.put(new b.g.a.c.i0.u(cls, true), nVarU) == null) {
                        pVar2.f703b.set(null);
                    }
                }
            }
        }
        v vVar2 = this._config;
        t tVar = vVar2._rootName;
        if (tVar == null) {
            if (vVar2.v(w.WRAP_ROOT_VALUE)) {
                v vVar3 = this._config;
                t tVar2 = vVar3._rootName;
                if (tVar2 == null) {
                    b.g.a.c.i0.p pVar3 = vVar3._rootNames;
                    Objects.requireNonNull(pVar3);
                    b.g.a.c.h0.b bVar = new b.g.a.c.h0.b(cls);
                    t tVar3 = pVar3.j.k.get(bVar);
                    if (tVar3 != null) {
                        tVar2 = tVar3;
                    } else {
                        t tVarF = vVar3.e().F(((b.g.a.c.c0.q) vVar3.o(cls)).f);
                        if (tVarF == null || !tVarF.c()) {
                            tVarF = t.a(cls.getSimpleName());
                        }
                        b.g.a.c.i0.h<b.g.a.c.h0.b, t> hVar = pVar3.j;
                        if (hVar.k.size() >= hVar.j) {
                            synchronized (hVar) {
                                if (hVar.k.size() >= hVar.j) {
                                    hVar.k.clear();
                                }
                            }
                        }
                        hVar.k.put(bVar, tVarF);
                        tVar2 = tVarF;
                    }
                }
                I(dVar, obj, nVarU, tVar2);
                return;
            }
        } else if (!tVar.d()) {
            I(dVar, obj, nVarU, tVar);
            return;
        }
        try {
            nVarU.f(obj, dVar, this);
        } catch (Exception e2) {
            throw J(dVar, e2);
        }
    }

    @Override // b.g.a.c.x
    public u p(Object obj, i0<?> i0Var) {
        Map<Object, u> map = this.m;
        if (map == null) {
            this.m = D(w.USE_EQUALITY_FOR_OBJECT_ID) ? new HashMap<>() : new IdentityHashMap<>();
        } else {
            u uVar = map.get(obj);
            if (uVar != null) {
                return uVar;
            }
        }
        i0<?> i0VarE = null;
        ArrayList<i0<?>> arrayList = this.n;
        if (arrayList == null) {
            this.n = new ArrayList<>(8);
        } else {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                i0<?> i0Var2 = this.n.get(i);
                if (i0Var2.a(i0Var)) {
                    i0VarE = i0Var2;
                    break;
                }
            }
        }
        if (i0VarE == null) {
            i0VarE = i0Var.e(this);
            this.n.add(i0VarE);
        }
        u uVar2 = new u(i0VarE);
        this.m.put(obj, uVar2);
        return uVar2;
    }

    public j(x xVar, v vVar, q qVar) {
        super(xVar, vVar, qVar);
    }
}
