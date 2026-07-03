package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;
import p007b.p195g.p196a.p197a.InterfaceC2081i;
import p007b.p195g.p196a.p205c.AbstractC2165b;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.EnumC2373w;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2188i;
import p007b.p195g.p196a.p205c.p215g0.InterfaceC2244m;
import p007b.p195g.p196a.p205c.p219i0.C2342d;
import p007b.p195g.p196a.p205c.p219i0.InterfaceC2343e;
import p007b.p195g.p196a.p205c.p221z.AbstractC2391i;

/* JADX INFO: renamed from: b.g.a.c.g0.u.q0 */
/* JADX INFO: compiled from: StdSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2305q0<T> extends AbstractC2364n<T> implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final Object f4860j = new Object();
    private static final long serialVersionUID = 1;
    public final Class<T> _handledType;

    public AbstractC2305q0(Class<T> cls) {
        this._handledType = cls;
    }

    /* JADX INFO: renamed from: j */
    public static final boolean m2072j(Object obj, Object obj2) {
        return (obj == null || obj2 == null) ? false : true;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: c */
    public Class<T> mo2041c() {
        return this._handledType;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: k */
    public AbstractC2364n<?> m2073k(AbstractC2374x abstractC2374x, InterfaceC2206d interfaceC2206d, AbstractC2364n<?> abstractC2364n) throws JsonMappingException {
        AbstractC2364n<?> c2291j0;
        AbstractC2188i member;
        Object objMo1751G;
        Object obj = f4860j;
        Map identityHashMap = (Map) abstractC2374x.m2258w(obj);
        if (identityHashMap == null) {
            identityHashMap = new IdentityHashMap();
            AbstractC2391i.a aVar = (AbstractC2391i.a) abstractC2374x.f5063l;
            Map<Object, Object> map = aVar.f5089l;
            if (map == null) {
                HashMap map2 = new HashMap();
                map2.put(obj, identityHashMap == null ? AbstractC2391i.a.f5088k : identityHashMap);
                aVar = new AbstractC2391i.a(aVar._shared, map2);
            } else {
                map.put(obj, identityHashMap);
            }
            abstractC2374x.f5063l = aVar;
        } else if (identityHashMap.get(interfaceC2206d) != null) {
            return abstractC2364n;
        }
        identityHashMap.put(interfaceC2206d, Boolean.TRUE);
        try {
            AbstractC2165b abstractC2165bM2257v = abstractC2374x.m2257v();
            if (!m2072j(abstractC2165bM2257v, interfaceC2206d) || (member = interfaceC2206d.getMember()) == null || (objMo1751G = abstractC2165bM2257v.mo1751G(member)) == null) {
                c2291j0 = abstractC2364n;
            } else {
                InterfaceC2343e<Object, Object> interfaceC2343eM1939c = abstractC2374x.m1939c(interfaceC2206d.getMember(), objMo1751G);
                AbstractC2360j abstractC2360jM2197a = interfaceC2343eM1939c.m2197a(abstractC2374x.mo1940d());
                c2291j0 = new C2291j0(interfaceC2343eM1939c, abstractC2360jM2197a, (abstractC2364n != null || abstractC2360jM2197a.m2221y()) ? abstractC2364n : abstractC2374x.m2254s(abstractC2360jM2197a));
            }
            return c2291j0 != null ? abstractC2374x.m2261z(c2291j0, interfaceC2206d) : abstractC2364n;
        } finally {
            identityHashMap.remove(interfaceC2206d);
        }
    }

    /* JADX INFO: renamed from: l */
    public InterfaceC2081i.d m2074l(AbstractC2374x abstractC2374x, InterfaceC2206d interfaceC2206d, Class<?> cls) {
        return interfaceC2206d != null ? interfaceC2206d.mo1928a(abstractC2374x._config, cls) : abstractC2374x._config.mo2271i(cls);
    }

    /* JADX INFO: renamed from: m */
    public InterfaceC2244m m2075m(AbstractC2374x abstractC2374x, Object obj, Object obj2) throws JsonMappingException {
        Objects.requireNonNull(abstractC2374x._config);
        abstractC2374x.m1943g(this._handledType, "Cannot resolve PropertyFilter with id '" + obj + "'; no FilterProvider configured");
        throw null;
    }

    /* JADX INFO: renamed from: n */
    public void m2076n(AbstractC2374x abstractC2374x, Throwable th, Object obj, int i) throws IOException {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        C2342d.m2191w(th);
        boolean z2 = abstractC2374x == null || abstractC2374x.m2240D(EnumC2373w.WRAP_EXCEPTIONS);
        if (th instanceof IOException) {
            if (!z2 || !(th instanceof JsonMappingException)) {
                throw ((IOException) th);
            }
        } else if (!z2) {
            C2342d.m2192x(th);
        }
        throw JsonMappingException.m8741f(th, new JsonMappingException.C10677a(obj, i));
    }

    /* JADX INFO: renamed from: o */
    public void m2077o(AbstractC2374x abstractC2374x, Throwable th, Object obj, String str) throws IOException {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        C2342d.m2191w(th);
        boolean z2 = abstractC2374x == null || abstractC2374x.m2240D(EnumC2373w.WRAP_EXCEPTIONS);
        if (th instanceof IOException) {
            if (!z2 || !(th instanceof JsonMappingException)) {
                throw ((IOException) th);
            }
        } else if (!z2) {
            C2342d.m2192x(th);
        }
        int i = JsonMappingException.f19661j;
        throw JsonMappingException.m8741f(th, new JsonMappingException.C10677a(obj, str));
    }

    public AbstractC2305q0(AbstractC2360j abstractC2360j) {
        this._handledType = (Class<T>) abstractC2360j._class;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractC2305q0(Class<?> cls, boolean z2) {
        this._handledType = cls;
    }

    public AbstractC2305q0(AbstractC2305q0<?> abstractC2305q0) {
        this._handledType = (Class<T>) abstractC2305q0._handledType;
    }
}
