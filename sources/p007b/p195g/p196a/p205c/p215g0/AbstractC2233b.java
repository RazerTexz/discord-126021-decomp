package p007b.p195g.p196a.p205c.p215g0;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.File;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p197a.InterfaceC2094p;
import p007b.p195g.p196a.p205c.AbstractC2165b;
import p007b.p195g.p196a.p205c.AbstractC2172c;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.C2372v;
import p007b.p195g.p196a.p205c.EnumC2366p;
import p007b.p195g.p196a.p205c.InterfaceC2363m;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2175b;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2188i;
import p007b.p195g.p196a.p205c.p210c0.C2176b0;
import p007b.p195g.p196a.p205c.p210c0.C2177c;
import p007b.p195g.p196a.p205c.p210c0.C2179d;
import p007b.p195g.p196a.p205c.p210c0.C2196q;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p212e0.C2210b;
import p007b.p195g.p196a.p205c.p212e0.InterfaceC2214f;
import p007b.p195g.p196a.p205c.p212e0.p213h.C2224i;
import p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2301o0;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2273a0;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2275b0;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2277c0;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2280e;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2285g0;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2286h;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2288i;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2291j0;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2292k;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2293k0;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2295l0;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2297m0;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2300o;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2307r0;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2308s;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2311t0;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2312u;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2314v;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2315v0;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2317w0;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2318x;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2319y;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2320z;
import p007b.p195g.p196a.p205c.p219i0.C2340b;
import p007b.p195g.p196a.p205c.p219i0.C2342d;
import p007b.p195g.p196a.p205c.p219i0.C2344f;
import p007b.p195g.p196a.p205c.p219i0.C2357s;
import p007b.p195g.p196a.p205c.p219i0.InterfaceC2343e;
import p007b.p195g.p196a.p205c.p220y.InterfaceC2379e;
import p007b.p195g.p196a.p205c.p221z.C2397o;

/* JADX INFO: renamed from: b.g.a.c.g0.b */
/* JADX INFO: compiled from: BasicSerializerFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2233b extends AbstractC2248q implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final HashMap<String, AbstractC2364n<?>> f4788j;

    /* JADX INFO: renamed from: k */
    public static final HashMap<String, Class<? extends AbstractC2364n<?>>> f4789k;
    public final C2397o _factoryConfig;

    static {
        HashMap<String, Class<? extends AbstractC2364n<?>>> map = new HashMap<>();
        HashMap<String, AbstractC2364n<?>> map2 = new HashMap<>();
        map2.put(String.class.getName(), new C2307r0());
        C2311t0 c2311t0 = C2311t0.f4866k;
        map2.put(StringBuffer.class.getName(), c2311t0);
        map2.put(StringBuilder.class.getName(), c2311t0);
        map2.put(Character.class.getName(), c2311t0);
        map2.put(Character.TYPE.getName(), c2311t0);
        map2.put(Integer.class.getName(), new C2273a0(Integer.class));
        Class cls = Integer.TYPE;
        map2.put(cls.getName(), new C2273a0(cls));
        map2.put(Long.class.getName(), new C2275b0(Long.class));
        Class cls2 = Long.TYPE;
        map2.put(cls2.getName(), new C2275b0(cls2));
        String name = Byte.class.getName();
        C2320z c2320z = C2320z.f4872k;
        map2.put(name, c2320z);
        map2.put(Byte.TYPE.getName(), c2320z);
        String name2 = Short.class.getName();
        C2277c0 c2277c0 = C2277c0.f4850k;
        map2.put(name2, c2277c0);
        map2.put(Short.TYPE.getName(), c2277c0);
        map2.put(Double.class.getName(), new C2318x(Double.class));
        map2.put(Double.TYPE.getName(), new C2318x(Double.TYPE));
        String name3 = Float.class.getName();
        C2319y c2319y = C2319y.f4871k;
        map2.put(name3, c2319y);
        map2.put(Float.TYPE.getName(), c2319y);
        map2.put(Boolean.TYPE.getName(), new C2280e(true));
        map2.put(Boolean.class.getName(), new C2280e(false));
        map2.put(BigInteger.class.getName(), new C2314v(BigInteger.class));
        map2.put(BigDecimal.class.getName(), new C2314v(BigDecimal.class));
        map2.put(Calendar.class.getName(), C2286h.f4854k);
        map2.put(Date.class.getName(), C2292k.f4856k);
        HashMap map3 = new HashMap();
        map3.put(URL.class, new C2311t0(URL.class));
        map3.put(URI.class, new C2311t0(URI.class));
        map3.put(Currency.class, new C2311t0(Currency.class));
        map3.put(UUID.class, new C2317w0());
        map3.put(Pattern.class, new C2311t0(Pattern.class));
        map3.put(Locale.class, new C2311t0(Locale.class));
        map3.put(AtomicBoolean.class, C2293k0.class);
        map3.put(AtomicInteger.class, C2295l0.class);
        map3.put(AtomicLong.class, C2297m0.class);
        map3.put(File.class, C2300o.class);
        map3.put(Class.class, C2288i.class);
        C2312u c2312u = C2312u.f4867k;
        map3.put(Void.class, c2312u);
        map3.put(Void.TYPE, c2312u);
        for (Map.Entry entry : map3.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof AbstractC2364n) {
                map2.put(((Class) entry.getKey()).getName(), (AbstractC2364n) value);
            } else {
                map.put(((Class) entry.getKey()).getName(), (Class) value);
            }
        }
        map.put(C2357s.class.getName(), C2315v0.class);
        f4788j = map2;
        f4789k = map;
    }

    public AbstractC2233b(C2397o c2397o) {
        this._factoryConfig = c2397o == null ? new C2397o() : c2397o;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x015a  */
    /* JADX WARN: Code duplicated, block: B:116:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:117:0x01a8 A[PHI: r3
      0x01a8: PHI (r3v6 b.g.a.c.n<java.lang.Object>) = (r3v5 b.g.a.c.n<java.lang.Object>), (r3v9 b.g.a.c.n<java.lang.Object>) binds: [B:20:0x0046, B:86:0x0121] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2248q
    /* JADX INFO: renamed from: a */
    public AbstractC2364n<Object> mo1971a(AbstractC2374x abstractC2374x, AbstractC2360j abstractC2360j, AbstractC2364n<Object> abstractC2364n) throws JsonMappingException {
        AbstractC2364n<?> abstractC2364nM2011b;
        AbstractC2188i abstractC2188iMo1813b;
        AbstractC2301o0.a aVar;
        C2372v c2372v = abstractC2374x._config;
        AbstractC2172c abstractC2172cM2236u = c2372v.m2236u(abstractC2360j);
        InterfaceC2249r[] interfaceC2249rArr = this._factoryConfig._additionalKeySerializers;
        if (interfaceC2249rArr.length > 0) {
            C2340b c2340b = new C2340b(interfaceC2249rArr);
            abstractC2364nM2011b = null;
            while (c2340b.hasNext() && (abstractC2364nM2011b = ((InterfaceC2249r) c2340b.next()).m2011b(c2372v, abstractC2360j, abstractC2172cM2236u)) == null) {
            }
        } else {
            abstractC2364nM2011b = null;
        }
        if (abstractC2364nM2011b == null) {
            C2196q c2196q = (C2196q) abstractC2172cM2236u;
            C2177c c2177c = c2196q.f4736f;
            Object objMo1788l = abstractC2374x.m2257v().mo1788l(c2177c);
            AbstractC2364n<Object> abstractC2364nMo2000H = objMo1788l != null ? abstractC2374x.mo2000H(c2177c, objMo1788l) : null;
            if (abstractC2364nMo2000H != null) {
                abstractC2364n = abstractC2364nMo2000H;
            } else if (abstractC2364n == null) {
                Class cls = abstractC2360j._class;
                AbstractC2364n<Object> abstractC2364n2 = AbstractC2301o0.f4858a;
                if (cls == null || cls == Object.class) {
                    abstractC2364nMo2000H = new AbstractC2301o0.b();
                } else if (cls == String.class) {
                    abstractC2364nMo2000H = AbstractC2301o0.f4858a;
                } else {
                    if (cls.isPrimitive()) {
                        Annotation[] annotationArr = C2342d.f4944a;
                        if (cls == Integer.TYPE) {
                            cls = Integer.class;
                        } else if (cls == Long.TYPE) {
                            cls = Long.class;
                        } else if (cls == Boolean.TYPE) {
                            cls = Boolean.class;
                        } else if (cls == Double.TYPE) {
                            cls = Double.class;
                        } else if (cls == Float.TYPE) {
                            cls = Float.class;
                        } else if (cls == Byte.TYPE) {
                            cls = Byte.class;
                        } else if (cls == Short.TYPE) {
                            cls = Short.class;
                        } else {
                            if (cls != Character.TYPE) {
                                throw new IllegalArgumentException(C1643a.m867o(cls, C1643a.m833U("Class "), " is not a primitive type"));
                            }
                            cls = Character.class;
                        }
                    }
                    if (cls == Integer.class) {
                        aVar = new AbstractC2301o0.a(5, cls);
                    } else if (cls == Long.class) {
                        aVar = new AbstractC2301o0.a(6, cls);
                    } else if (cls.isPrimitive() || Number.class.isAssignableFrom(cls)) {
                        aVar = new AbstractC2301o0.a(8, cls);
                    } else if (cls == Class.class) {
                        aVar = new AbstractC2301o0.a(3, cls);
                    } else if (Date.class.isAssignableFrom(cls)) {
                        aVar = new AbstractC2301o0.a(1, cls);
                    } else if (Calendar.class.isAssignableFrom(cls)) {
                        aVar = new AbstractC2301o0.a(2, cls);
                    } else if (cls == UUID.class) {
                        aVar = new AbstractC2301o0.a(8, cls);
                    } else if (cls == byte[].class) {
                        aVar = new AbstractC2301o0.a(7, cls);
                    } else {
                        abstractC2364nMo2000H = null;
                    }
                    abstractC2364nMo2000H = aVar;
                }
                if (abstractC2364nMo2000H == null) {
                    C2176b0 c2176b0 = c2196q.f4733c;
                    if (c2176b0 != null) {
                        if (!c2176b0.f4641i) {
                            c2176b0.m1829h();
                        }
                        LinkedList<AbstractC2188i> linkedList = c2176b0.f4649q;
                        if (linkedList == null) {
                            abstractC2188iMo1813b = null;
                        } else {
                            if (linkedList.size() > 1) {
                                c2176b0.m1830i("Multiple 'as-key' properties defined (%s vs %s)", c2176b0.f4649q.get(0), c2176b0.f4649q.get(1));
                                throw null;
                            }
                            abstractC2188iMo1813b = c2176b0.f4649q.get(0);
                        }
                    } else {
                        abstractC2188iMo1813b = null;
                    }
                    if (abstractC2188iMo1813b == null) {
                        abstractC2188iMo1813b = abstractC2172cM2236u.mo1813b();
                    }
                    if (abstractC2188iMo1813b != null) {
                        AbstractC2364n<Object> abstractC2364nMo1971a = mo1971a(abstractC2374x, abstractC2188iMo1813b.mo1821e(), abstractC2364n);
                        if (c2372v.m2265b()) {
                            C2342d.m2172d(abstractC2188iMo1813b.mo1888i(), c2372v.m2279q(EnumC2366p.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                        }
                        abstractC2364n = new C2308s(abstractC2188iMo1813b, null, abstractC2364nMo1971a);
                    } else {
                        Class<?> cls2 = abstractC2360j._class;
                        if (cls2 == null) {
                            abstractC2364n = new AbstractC2301o0.a(8, cls2);
                        } else if (cls2 == Enum.class) {
                            abstractC2364n = new AbstractC2301o0.b();
                        } else if (C2342d.m2185q(cls2)) {
                            abstractC2364n = new AbstractC2301o0.c(cls2, C2344f.m2198a(c2372v, cls2));
                        } else {
                            abstractC2364n = new AbstractC2301o0.a(8, cls2);
                        }
                    }
                } else {
                    abstractC2364n = abstractC2364nMo2000H;
                }
            }
        } else {
            abstractC2364n = abstractC2364nM2011b;
        }
        if (this._factoryConfig.m2282a()) {
            C2340b c2340b2 = (C2340b) this._factoryConfig.m2283b();
            while (c2340b2.hasNext()) {
                Objects.requireNonNull((AbstractC2238g) c2340b2.next());
            }
        }
        return abstractC2364n;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2248q
    /* JADX INFO: renamed from: c */
    public AbstractC2215g mo1972c(C2372v c2372v, AbstractC2360j abstractC2360j) {
        ArrayList arrayList;
        C2177c c2177c = ((C2196q) c2372v.m2277o(abstractC2360j._class)).f4736f;
        InterfaceC2214f<?> interfaceC2214fMo1760P = c2372v.m2267e().mo1760P(c2372v, c2177c, abstractC2360j);
        if (interfaceC2214fMo1760P == null) {
            interfaceC2214fMo1760P = c2372v._base._typeResolverBuilder;
            arrayList = null;
        } else {
            C2224i c2224i = (C2224i) c2372v._subtypeResolver;
            Objects.requireNonNull(c2224i);
            AbstractC2165b abstractC2165bM2267e = c2372v.m2267e();
            HashMap<C2210b, C2210b> map = new HashMap<>();
            LinkedHashSet<C2210b> linkedHashSet = c2224i._registeredSubtypes;
            if (linkedHashSet != null) {
                Class<?> cls = c2177c.f4655l;
                for (C2210b c2210b : linkedHashSet) {
                    if (cls.isAssignableFrom(c2210b._class)) {
                        c2224i.m1965b(C2179d.m1879h(c2372v, c2210b._class), c2210b, c2372v, abstractC2165bM2267e, map);
                    }
                }
            }
            c2224i.m1965b(c2177c, new C2210b(c2177c.f4655l, null), c2372v, abstractC2165bM2267e, map);
            arrayList = new ArrayList(map.values());
        }
        if (interfaceC2214fMo1760P == null) {
            return null;
        }
        return interfaceC2214fMo1760P.mo1953e(c2372v, abstractC2360j, arrayList);
    }

    /* JADX INFO: renamed from: d */
    public InterfaceC2094p.b m1973d(AbstractC2374x abstractC2374x, AbstractC2172c abstractC2172c, AbstractC2360j abstractC2360j, Class<?> cls) throws JsonMappingException {
        C2372v c2372v = abstractC2374x._config;
        InterfaceC2094p.b bVarMo1814c = abstractC2172c.mo1814c(c2372v._configOverrides._defaultInclusion);
        c2372v._configOverrides.m2263a(cls);
        c2372v.m2273k(abstractC2360j._class, null);
        return bVarMo1814c;
    }

    /* JADX INFO: renamed from: e */
    public final AbstractC2364n<?> m1974e(AbstractC2374x abstractC2374x, AbstractC2360j abstractC2360j, AbstractC2172c abstractC2172c) throws JsonMappingException {
        if (InterfaceC2363m.class.isAssignableFrom(abstractC2360j._class)) {
            return C2285g0.f4853k;
        }
        AbstractC2188i abstractC2188iMo1813b = abstractC2172c.mo1813b();
        if (abstractC2188iMo1813b == null) {
            return null;
        }
        if (abstractC2374x._config.m2265b()) {
            C2342d.m2172d(abstractC2188iMo1813b.mo1888i(), abstractC2374x.m2239C(EnumC2366p.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        AbstractC2360j abstractC2360jMo1821e = abstractC2188iMo1813b.mo1821e();
        AbstractC2364n<Object> abstractC2364nM1975f = m1975f(abstractC2374x, abstractC2188iMo1813b);
        if (abstractC2364nM1975f == null) {
            abstractC2364nM1975f = (AbstractC2364n) abstractC2360jMo1821e._valueHandler;
        }
        AbstractC2215g abstractC2215gMo1972c = (AbstractC2215g) abstractC2360jMo1821e._typeHandler;
        if (abstractC2215gMo1972c == null) {
            abstractC2215gMo1972c = mo1972c(abstractC2374x._config, abstractC2360jMo1821e);
        }
        return new C2308s(abstractC2188iMo1813b, abstractC2215gMo1972c, abstractC2364nM1975f);
    }

    /* JADX INFO: renamed from: f */
    public AbstractC2364n<Object> m1975f(AbstractC2374x abstractC2374x, AbstractC2175b abstractC2175b) throws JsonMappingException {
        Object objMo1756L = abstractC2374x.m2257v().mo1756L(abstractC2175b);
        if (objMo1756L == null) {
            return null;
        }
        AbstractC2364n<Object> abstractC2364nMo2000H = abstractC2374x.mo2000H(abstractC2175b, objMo1756L);
        Object objMo1752H = abstractC2374x.m2257v().mo1752H(abstractC2175b);
        InterfaceC2343e<Object, Object> interfaceC2343eM1939c = objMo1752H != null ? abstractC2374x.m1939c(abstractC2175b, objMo1752H) : null;
        return interfaceC2343eM1939c == null ? abstractC2364nMo2000H : new C2291j0(interfaceC2343eM1939c, interfaceC2343eM1939c.m2197a(abstractC2374x.mo1940d()), abstractC2364nMo2000H);
    }

    /* JADX INFO: renamed from: g */
    public boolean m1976g(C2372v c2372v, AbstractC2172c abstractC2172c, AbstractC2215g abstractC2215g) {
        InterfaceC2379e.b bVarMo1755K = c2372v.m2267e().mo1755K(((C2196q) abstractC2172c).f4736f);
        if (bVarMo1755K == null || bVarMo1755K == InterfaceC2379e.b.DEFAULT_TYPING) {
            return c2372v.m2279q(EnumC2366p.USE_STATIC_TYPING);
        }
        return bVarMo1755K == InterfaceC2379e.b.STATIC;
    }
}
