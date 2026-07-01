package b.g.a.c.g0.u;

import b.g.a.a.i$d;
import b.g.a.c.z.i$a;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonMappingException$a;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: StdSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class q0<T> extends b.g.a.c.n<T> implements Serializable {
    public static final Object j = new Object();
    private static final long serialVersionUID = 1;
    public final Class<T> _handledType;

    public q0(Class<T> cls) {
        this._handledType = cls;
    }

    public static final boolean j(Object obj, Object obj2) {
        return (obj == null || obj2 == null) ? false : true;
    }

    @Override // b.g.a.c.n
    public Class<T> c() {
        return this._handledType;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public b.g.a.c.n<?> k(b.g.a.c.x xVar, b.g.a.c.d dVar, b.g.a.c.n<?> nVar) throws JsonMappingException {
        b.g.a.c.n<?> j0Var;
        b.g.a.c.c0.i member;
        Object objG;
        Object obj = j;
        Map identityHashMap = (Map) xVar.w(obj);
        if (identityHashMap == null) {
            identityHashMap = new IdentityHashMap();
            i$a i_a = (i$a) xVar.l;
            Map<Object, Object> map = i_a.l;
            if (map == null) {
                HashMap map2 = new HashMap();
                map2.put(obj, identityHashMap == null ? i$a.k : identityHashMap);
                i_a = new i$a(i_a._shared, map2);
            } else {
                map.put(obj, identityHashMap);
            }
            xVar.l = i_a;
        } else if (identityHashMap.get(dVar) != null) {
            return nVar;
        }
        identityHashMap.put(dVar, Boolean.TRUE);
        try {
            b.g.a.c.b bVarV = xVar.v();
            if (!j(bVarV, dVar) || (member = dVar.getMember()) == null || (objG = bVarV.G(member)) == null) {
                j0Var = nVar;
            } else {
                b.g.a.c.i0.e<Object, Object> eVarC = xVar.c(dVar.getMember(), objG);
                b.g.a.c.j jVarA = eVarC.a(xVar.d());
                j0Var = new j0(eVarC, jVarA, (nVar != null || jVarA.y()) ? nVar : xVar.s(jVarA));
            }
            return j0Var != null ? xVar.z(j0Var, dVar) : nVar;
        } finally {
            identityHashMap.remove(dVar);
        }
    }

    public i$d l(b.g.a.c.x xVar, b.g.a.c.d dVar, Class<?> cls) {
        return dVar != null ? dVar.a(xVar._config, cls) : xVar._config.i(cls);
    }

    public b.g.a.c.g0.m m(b.g.a.c.x xVar, Object obj, Object obj2) throws JsonMappingException {
        Objects.requireNonNull(xVar._config);
        xVar.g(this._handledType, "Cannot resolve PropertyFilter with id '" + obj + "'; no FilterProvider configured");
        throw null;
    }

    public void n(b.g.a.c.x xVar, Throwable th, Object obj, int i) throws IOException {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        b.g.a.c.i0.d.w(th);
        boolean z2 = xVar == null || xVar.D(b.g.a.c.w.WRAP_EXCEPTIONS);
        if (th instanceof IOException) {
            if (!z2 || !(th instanceof JsonMappingException)) {
                throw ((IOException) th);
            }
        } else if (!z2) {
            b.g.a.c.i0.d.x(th);
        }
        throw JsonMappingException.f(th, new JsonMappingException$a(obj, i));
    }

    public void o(b.g.a.c.x xVar, Throwable th, Object obj, String str) throws IOException {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        b.g.a.c.i0.d.w(th);
        boolean z2 = xVar == null || xVar.D(b.g.a.c.w.WRAP_EXCEPTIONS);
        if (th instanceof IOException) {
            if (!z2 || !(th instanceof JsonMappingException)) {
                throw ((IOException) th);
            }
        } else if (!z2) {
            b.g.a.c.i0.d.x(th);
        }
        int i = JsonMappingException.j;
        throw JsonMappingException.f(th, new JsonMappingException$a(obj, str));
    }

    public q0(b.g.a.c.j jVar) {
        this._handledType = (Class<T>) jVar._class;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q0(Class<?> cls, boolean z2) {
        this._handledType = cls;
    }

    public q0(q0<?> q0Var) {
        this._handledType = (Class<T>) q0Var._handledType;
    }
}
