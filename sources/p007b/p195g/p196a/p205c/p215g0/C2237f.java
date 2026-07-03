package p007b.p195g.p196a.p205c.p215g0;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p197a.AbstractC2082i0;
import p007b.p195g.p196a.p197a.AbstractC2088l0;
import p007b.p195g.p196a.p197a.InterfaceC2070c0;
import p007b.p195g.p196a.p197a.InterfaceC2081i;
import p007b.p195g.p196a.p197a.InterfaceC2091n;
import p007b.p195g.p196a.p197a.InterfaceC2094p;
import p007b.p195g.p196a.p197a.InterfaceC2095q;
import p007b.p195g.p196a.p205c.AbstractC2165b;
import p007b.p195g.p196a.p205c.AbstractC2172c;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.C2369s;
import p007b.p195g.p196a.p205c.C2370t;
import p007b.p195g.p196a.p205c.C2372v;
import p007b.p195g.p196a.p205c.EnumC2366p;
import p007b.p195g.p196a.p205c.EnumC2373w;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p209b0.C2171f;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2188i;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2198s;
import p007b.p195g.p196a.p205c.p210c0.C2174a0;
import p007b.p195g.p196a.p205c.p210c0.C2176b0;
import p007b.p195g.p196a.p205c.p210c0.C2177c;
import p007b.p195g.p196a.p205c.p210c0.C2181e;
import p007b.p195g.p196a.p205c.p210c0.C2185g;
import p007b.p195g.p196a.p205c.p210c0.C2189j;
import p007b.p195g.p196a.p205c.p210c0.C2196q;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p212e0.InterfaceC2214f;
import p007b.p195g.p196a.p205c.p215g0.p216t.C2254d;
import p007b.p195g.p196a.p205c.p215g0.p216t.C2255e;
import p007b.p195g.p196a.p205c.p215g0.p216t.C2256f;
import p007b.p195g.p196a.p205c.p215g0.p216t.C2257g;
import p007b.p195g.p196a.p205c.p215g0.p216t.C2258h;
import p007b.p195g.p196a.p205c.p215g0.p216t.C2259i;
import p007b.p195g.p196a.p205c.p215g0.p216t.C2260j;
import p007b.p195g.p196a.p205c.p215g0.p216t.C2261k;
import p007b.p195g.p196a.p205c.p215g0.p216t.C2264n;
import p007b.p195g.p196a.p205c.p215g0.p216t.C2265o;
import p007b.p195g.p196a.p205c.p215g0.p216t.C2268r;
import p007b.p195g.p196a.p205c.p215g0.p216t.C2269s;
import p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2278d;
import p007b.p195g.p196a.p205c.p215g0.p217u.AbstractC2283f0;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2276c;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2279d0;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2284g;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2286h;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2289i0;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2290j;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2291j0;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2292k;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2296m;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2298n;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2302p;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2304q;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2306r;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2309s0;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2310t;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2311t0;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2314v;
import p007b.p195g.p196a.p205c.p218h0.C2322a;
import p007b.p195g.p196a.p205c.p218h0.C2325d;
import p007b.p195g.p196a.p205c.p218h0.C2326e;
import p007b.p195g.p196a.p205c.p218h0.C2327f;
import p007b.p195g.p196a.p205c.p218h0.C2328g;
import p007b.p195g.p196a.p205c.p218h0.C2330i;
import p007b.p195g.p196a.p205c.p218h0.C2335n;
import p007b.p195g.p196a.p205c.p219i0.AbstractC2352n;
import p007b.p195g.p196a.p205c.p219i0.C2340b;
import p007b.p195g.p196a.p205c.p219i0.C2342d;
import p007b.p195g.p196a.p205c.p219i0.C2344f;
import p007b.p195g.p196a.p205c.p219i0.InterfaceC2343e;
import p007b.p195g.p196a.p205c.p221z.C2397o;

/* JADX INFO: renamed from: b.g.a.c.g0.f */
/* JADX INFO: compiled from: BeanSerializerFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2237f extends AbstractC2233b implements Serializable {

    /* JADX INFO: renamed from: l */
    public static final C2237f f4805l = new C2237f(null);
    private static final long serialVersionUID = 1;

    public C2237f(C2397o c2397o) {
        super(null);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2248q
    /* JADX INFO: renamed from: b */
    public AbstractC2364n<Object> mo1991b(AbstractC2374x abstractC2374x, AbstractC2360j abstractC2360j) throws JsonMappingException {
        AbstractC2360j abstractC2360jMo1780e0;
        Object objMo1752H;
        C2372v c2372v = abstractC2374x._config;
        AbstractC2172c abstractC2172cM2236u = c2372v.m2236u(abstractC2360j);
        AbstractC2364n<?> abstractC2364nM1975f = m1975f(abstractC2374x, ((C2196q) abstractC2172cM2236u).f4736f);
        if (abstractC2364nM1975f != null) {
            return abstractC2364nM1975f;
        }
        AbstractC2165b abstractC2165bM2267e = c2372v.m2267e();
        boolean z2 = false;
        InterfaceC2343e interfaceC2343e = null;
        if (abstractC2165bM2267e == null) {
            abstractC2360jMo1780e0 = abstractC2360j;
        } else {
            try {
                abstractC2360jMo1780e0 = abstractC2165bM2267e.mo1780e0(c2372v, ((C2196q) abstractC2172cM2236u).f4736f, abstractC2360j);
            } catch (JsonMappingException e) {
                abstractC2374x.m2242F(abstractC2172cM2236u, e.getMessage(), new Object[0]);
                throw null;
            }
        }
        if (abstractC2360jMo1780e0 != abstractC2360j) {
            if (!abstractC2360jMo1780e0.m2218t(abstractC2360j._class)) {
                abstractC2172cM2236u = c2372v.m2236u(abstractC2360jMo1780e0);
            }
            z2 = true;
        }
        C2196q c2196q = (C2196q) abstractC2172cM2236u;
        AbstractC2165b abstractC2165b = c2196q.f4735e;
        if (abstractC2165b != null && (objMo1752H = abstractC2165b.mo1752H(c2196q.f4736f)) != null) {
            if (objMo1752H instanceof InterfaceC2343e) {
                interfaceC2343e = (InterfaceC2343e) objMo1752H;
            } else {
                if (!(objMo1752H instanceof Class)) {
                    StringBuilder sbM833U = C1643a.m833U("AnnotationIntrospector returned Converter definition of type ");
                    sbM833U.append(objMo1752H.getClass().getName());
                    sbM833U.append("; expected type Converter or Class<Converter> instead");
                    throw new IllegalStateException(sbM833U.toString());
                }
                Class cls = (Class) objMo1752H;
                if (cls != InterfaceC2343e.a.class && !C2342d.m2184p(cls)) {
                    if (!InterfaceC2343e.class.isAssignableFrom(cls)) {
                        throw new IllegalStateException(C1643a.m867o(cls, C1643a.m833U("AnnotationIntrospector returned Class "), "; expected Class<Converter>"));
                    }
                    Objects.requireNonNull(c2196q.f4734d._base);
                    interfaceC2343e = (InterfaceC2343e) C2342d.m2175g(cls, c2196q.f4734d.m2265b());
                }
            }
        }
        if (interfaceC2343e == null) {
            return m1993i(abstractC2374x, abstractC2360jMo1780e0, abstractC2172cM2236u, z2);
        }
        AbstractC2360j abstractC2360jM2197a = interfaceC2343e.m2197a(abstractC2374x.mo1940d());
        if (!abstractC2360jM2197a.m2218t(abstractC2360jMo1780e0._class)) {
            abstractC2172cM2236u = c2372v.m2236u(abstractC2360jM2197a);
            abstractC2364nM1975f = m1975f(abstractC2374x, ((C2196q) abstractC2172cM2236u).f4736f);
        }
        if (abstractC2364nM1975f == null && !abstractC2360jM2197a.m2221y()) {
            abstractC2364nM1975f = m1993i(abstractC2374x, abstractC2360jM2197a, abstractC2172cM2236u, true);
        }
        return new C2291j0(interfaceC2343e, abstractC2360jM2197a, abstractC2364nM1975f);
    }

    /* JADX WARN: Code duplicated, block: B:121:0x0259  */
    /* JADX WARN: Code duplicated, block: B:123:0x0261  */
    /* JADX WARN: Code duplicated, block: B:125:0x0267  */
    /* JADX WARN: Code duplicated, block: B:126:0x0269  */
    /* JADX WARN: Code duplicated, block: B:128:0x0271  */
    /* JADX WARN: Code duplicated, block: B:135:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:138:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:139:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:97:0x020f  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: h */
    public C2234c m1992h(AbstractC2374x abstractC2374x, AbstractC2198s abstractC2198s, C2243l c2243l, boolean z2, AbstractC2188i abstractC2188i) throws JsonMappingException {
        AbstractC2215g abstractC2215gMo1972c;
        boolean z3;
        boolean z4;
        boolean zMo1999B;
        Object obj;
        Class<?>[] clsArrMo1852i;
        C2234c c2234c;
        Object objMo1793q;
        C2196q c2196q;
        AbstractC2165b abstractC2165b;
        Class<?>[] clsArrMo1762R;
        Object objM572t0;
        C2370t c2370tMo1855m = abstractC2198s.mo1855m();
        AbstractC2360j abstractC2360jMo1821e = abstractC2188i.mo1821e();
        InterfaceC2206d.a aVar = new InterfaceC2206d.a(c2370tMo1855m, abstractC2360jMo1821e, abstractC2198s.mo1862t(), abstractC2188i, abstractC2198s.mo1857o());
        AbstractC2364n<Object> abstractC2364nM1975f = m1975f(abstractC2374x, abstractC2188i);
        if (abstractC2364nM1975f instanceof InterfaceC2246o) {
            ((InterfaceC2246o) abstractC2364nM1975f).mo2007b(abstractC2374x);
        }
        AbstractC2364n<?> abstractC2364nM2260y = abstractC2374x.m2260y(abstractC2364nM1975f, aVar);
        if (abstractC2360jMo1821e.mo2104v() || abstractC2360jMo1821e.mo1728b()) {
            C2372v c2372v = abstractC2374x._config;
            AbstractC2360j abstractC2360jMo2099k = abstractC2360jMo1821e.mo2099k();
            InterfaceC2214f<?> interfaceC2214fMo1797u = c2372v.m2267e().mo1797u(c2372v, abstractC2188i, abstractC2360jMo1821e);
            abstractC2215gMo1972c = interfaceC2214fMo1797u == null ? mo1972c(c2372v, abstractC2360jMo2099k) : interfaceC2214fMo1797u.mo1953e(c2372v, abstractC2360jMo2099k, c2372v._subtypeResolver.mo1945a(c2372v, abstractC2188i, abstractC2360jMo2099k));
        } else {
            abstractC2215gMo1972c = null;
        }
        C2372v c2372v2 = abstractC2374x._config;
        InterfaceC2214f<?> interfaceC2214fMo1747C = c2372v2.m2267e().mo1747C(c2372v2, abstractC2188i, abstractC2360jMo1821e);
        AbstractC2215g abstractC2215gMo1972c2 = interfaceC2214fMo1747C == null ? mo1972c(c2372v2, abstractC2360jMo1821e) : interfaceC2214fMo1747C.mo1953e(c2372v2, abstractC2360jMo1821e, c2372v2._subtypeResolver.mo1945a(c2372v2, abstractC2188i, abstractC2360jMo1821e));
        Object obj2 = InterfaceC2094p.a.NON_EMPTY;
        try {
            AbstractC2360j abstractC2360jM2006a = c2243l.m2006a(abstractC2188i, z2, abstractC2360jMo1821e);
            if (abstractC2215gMo1972c != null) {
                if (abstractC2360jM2006a == null) {
                    abstractC2360jM2006a = abstractC2360jMo1821e;
                }
                if (abstractC2360jM2006a.mo2099k() == null) {
                    abstractC2374x.m2241E(c2243l.f4810b, abstractC2198s, "serialization type " + abstractC2360jM2006a + " has no content", new Object[0]);
                    throw null;
                }
                AbstractC2360j abstractC2360jMo2095E = abstractC2360jM2006a.mo2095E(abstractC2215gMo1972c);
                abstractC2360jMo2095E.mo2099k();
                abstractC2360jM2006a = abstractC2360jMo2095E;
            }
            AbstractC2360j abstractC2360j = abstractC2360jM2006a == null ? abstractC2360jMo1821e : abstractC2360jM2006a;
            AbstractC2188i abstractC2188iM1922j = abstractC2198s.m1922j();
            if (abstractC2188iM1922j == null) {
                abstractC2374x.m2241E(c2243l.f4810b, abstractC2198s, "could not determine property type", new Object[0]);
                throw null;
            }
            Class<?> clsMo1820d = abstractC2188iM1922j.mo1820d();
            C2372v c2372v3 = c2243l.f4809a;
            Class<?> cls = abstractC2360j._class;
            InterfaceC2094p.b bVar = c2243l.f4813e;
            c2372v3.mo2268f(cls);
            c2372v3.mo2268f(clsMo1820d);
            InterfaceC2094p.b[] bVarArr = {bVar, null, null};
            InterfaceC2094p.b bVar2 = InterfaceC2094p.b.f4436j;
            int i = 0;
            InterfaceC2094p.b bVar3 = null;
            for (int i2 = 3; i < i2; i2 = 3) {
                InterfaceC2094p.b bVarM1618a = bVarArr[i];
                if (bVarM1618a != null) {
                    if (bVar3 != null) {
                        bVarM1618a = bVar3.m1618a(bVarM1618a);
                    }
                    bVar3 = bVarM1618a;
                }
                i++;
            }
            InterfaceC2094p.b bVarM1618a2 = bVar3.m1618a(abstractC2198s.mo1850g());
            InterfaceC2094p.a aVar2 = bVarM1618a2._valueInclusion;
            if (aVar2 == InterfaceC2094p.a.USE_DEFAULTS) {
                aVar2 = InterfaceC2094p.a.ALWAYS;
            }
            int iOrdinal = aVar2.ordinal();
            if (iOrdinal != 1) {
                if (iOrdinal == 2) {
                    if (!abstractC2360j.mo1728b()) {
                        z4 = true;
                        zMo1999B = z4;
                        obj = null;
                        clsArrMo1852i = abstractC2198s.mo1852i();
                        if (clsArrMo1852i == null) {
                            c2196q = (C2196q) c2243l.f4810b;
                            if (!c2196q.f4738h) {
                                c2196q.f4738h = true;
                                abstractC2165b = c2196q.f4735e;
                                if (abstractC2165b == null) {
                                    clsArrMo1762R = null;
                                } else {
                                    clsArrMo1762R = abstractC2165b.mo1762R(c2196q.f4736f);
                                }
                                if (clsArrMo1762R == null) {
                                    clsArrMo1762R = C2196q.f4732b;
                                }
                                c2196q.f4737g = clsArrMo1762R;
                            }
                            clsArrMo1852i = c2196q.f4737g;
                        }
                        c2234c = new C2234c(abstractC2198s, abstractC2188i, ((C2196q) c2243l.f4810b).f4736f.f4663t, abstractC2360jMo1821e, abstractC2364nM2260y, abstractC2215gMo1972c2, abstractC2360jM2006a, zMo1999B, obj, clsArrMo1852i);
                        objMo1793q = c2243l.f4811c.mo1793q(abstractC2188i);
                        if (objMo1793q != null) {
                            c2234c.mo1979e(abstractC2374x.mo2000H(abstractC2188i, objMo1793q));
                        }
                        AbstractC2352n abstractC2352nMo1761Q = c2243l.f4811c.mo1761Q(abstractC2188i);
                        if (abstractC2352nMo1761Q != null) {
                        }
                    }
                    int i3 = C2234c.f4790j;
                } else if (iOrdinal != 3) {
                    if (iOrdinal != 4) {
                        if (iOrdinal != 5) {
                            z3 = false;
                        } else {
                            objM572t0 = abstractC2374x.mo1998A(abstractC2198s, bVarM1618a2._valueFilter);
                            if (objM572t0 != null) {
                                obj = objM572t0;
                                zMo1999B = abstractC2374x.mo1999B(objM572t0);
                            }
                        }
                        clsArrMo1852i = abstractC2198s.mo1852i();
                        if (clsArrMo1852i == null) {
                            c2196q = (C2196q) c2243l.f4810b;
                            if (!c2196q.f4738h) {
                                c2196q.f4738h = true;
                                abstractC2165b = c2196q.f4735e;
                                if (abstractC2165b == null) {
                                    clsArrMo1762R = null;
                                } else {
                                    clsArrMo1762R = abstractC2165b.mo1762R(c2196q.f4736f);
                                }
                                if (clsArrMo1762R == null && !c2196q.f4734d.m2279q(EnumC2366p.DEFAULT_VIEW_INCLUSION)) {
                                    clsArrMo1762R = C2196q.f4732b;
                                }
                                c2196q.f4737g = clsArrMo1762R;
                            }
                            clsArrMo1852i = c2196q.f4737g;
                        }
                        c2234c = new C2234c(abstractC2198s, abstractC2188i, ((C2196q) c2243l.f4810b).f4736f.f4663t, abstractC2360jMo1821e, abstractC2364nM2260y, abstractC2215gMo1972c2, abstractC2360jM2006a, zMo1999B, obj, clsArrMo1852i);
                        objMo1793q = c2243l.f4811c.mo1793q(abstractC2188i);
                        if (objMo1793q != null) {
                            c2234c.mo1979e(abstractC2374x.mo2000H(abstractC2188i, objMo1793q));
                        }
                        AbstractC2352n abstractC2352nMo1761Q2 = c2243l.f4811c.mo1761Q(abstractC2188i);
                        return abstractC2352nMo1761Q2 != null ? new C2269s(c2234c, abstractC2352nMo1761Q2) : c2234c;
                    }
                    if (c2243l.f4814f) {
                        Object objNewInstance = c2243l.f4812d;
                        if (objNewInstance == null) {
                            AbstractC2172c abstractC2172c = c2243l.f4810b;
                            boolean zM2265b = c2243l.f4809a.m2265b();
                            C2196q c2196q2 = (C2196q) abstractC2172c;
                            C2181e c2181e = c2196q2.f4736f.m1832f().f4668a;
                            if (c2181e == null) {
                                objNewInstance = null;
                            } else {
                                if (zM2265b) {
                                    c2181e.m1902f(c2196q2.f4734d.m2279q(EnumC2366p.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                                }
                                try {
                                    objNewInstance = c2181e._constructor.newInstance(new Object[0]);
                                } catch (Exception e) {
                                    e = e;
                                    while (e.getCause() != null) {
                                        e = e.getCause();
                                    }
                                    C2342d.m2191w(e);
                                    C2342d.m2192x(e);
                                    StringBuilder sbM833U = C1643a.m833U("Failed to instantiate bean of type ");
                                    sbM833U.append(c2196q2.f4736f.f4655l.getName());
                                    sbM833U.append(": (");
                                    sbM833U.append(e.getClass().getName());
                                    sbM833U.append(") ");
                                    sbM833U.append(C2342d.m2176h(e));
                                    throw new IllegalArgumentException(sbM833U.toString(), e);
                                }
                            }
                            if (objNewInstance == null) {
                                objNewInstance = Boolean.FALSE;
                            }
                            c2243l.f4812d = objNewInstance;
                        }
                        Object obj3 = objNewInstance == Boolean.FALSE ? null : c2243l.f4812d;
                        if (obj3 != null) {
                            if (abstractC2374x.m2239C(EnumC2366p.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                                abstractC2188i.m1902f(c2243l.f4809a.m2279q(EnumC2366p.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                            }
                            try {
                                objM572t0 = abstractC2188i.mo1889j(obj3);
                                z3 = false;
                            } catch (Exception e2) {
                                e = e2;
                                String strMo1858p = abstractC2198s.mo1858p();
                                while (e.getCause() != null) {
                                    e = e.getCause();
                                }
                                C2342d.m2191w(e);
                                C2342d.m2192x(e);
                                StringBuilder sbM837Y = C1643a.m837Y("Failed to get property '", strMo1858p, "' of default ");
                                sbM837Y.append(obj3.getClass().getName());
                                sbM837Y.append(" instance");
                                throw new IllegalArgumentException(sbM837Y.toString());
                            }
                        } else {
                            objM572t0 = C1460d.m572t0(abstractC2360j);
                            z3 = true;
                        }
                    } else {
                        objM572t0 = C1460d.m572t0(abstractC2360j);
                        z3 = true;
                    }
                    if (objM572t0 != null) {
                        if (objM572t0.getClass().isArray()) {
                            objM572t0 = C1460d.m560q0(objM572t0);
                        }
                        obj2 = objM572t0;
                        zMo1999B = z3;
                        obj = obj2;
                        clsArrMo1852i = abstractC2198s.mo1852i();
                        if (clsArrMo1852i == null) {
                            c2196q = (C2196q) c2243l.f4810b;
                            if (!c2196q.f4738h) {
                                c2196q.f4738h = true;
                                abstractC2165b = c2196q.f4735e;
                                if (abstractC2165b == null) {
                                    clsArrMo1762R = null;
                                } else {
                                    clsArrMo1762R = abstractC2165b.mo1762R(c2196q.f4736f);
                                }
                                if (clsArrMo1762R == null) {
                                    clsArrMo1762R = C2196q.f4732b;
                                }
                                c2196q.f4737g = clsArrMo1762R;
                            }
                            clsArrMo1852i = c2196q.f4737g;
                        }
                        c2234c = new C2234c(abstractC2198s, abstractC2188i, ((C2196q) c2243l.f4810b).f4736f.f4663t, abstractC2360jMo1821e, abstractC2364nM2260y, abstractC2215gMo1972c2, abstractC2360jM2006a, zMo1999B, obj, clsArrMo1852i);
                        objMo1793q = c2243l.f4811c.mo1793q(abstractC2188i);
                        if (objMo1793q != null) {
                            c2234c.mo1979e(abstractC2374x.mo2000H(abstractC2188i, objMo1793q));
                        }
                        AbstractC2352n abstractC2352nMo1761Q3 = c2243l.f4811c.mo1761Q(abstractC2188i);
                        if (abstractC2352nMo1761Q3 != null) {
                        }
                    }
                    obj2 = objM572t0;
                } else {
                    int i4 = C2234c.f4790j;
                }
                obj = obj2;
                zMo1999B = true;
                clsArrMo1852i = abstractC2198s.mo1852i();
                if (clsArrMo1852i == null) {
                    c2196q = (C2196q) c2243l.f4810b;
                    if (!c2196q.f4738h) {
                        c2196q.f4738h = true;
                        abstractC2165b = c2196q.f4735e;
                        if (abstractC2165b == null) {
                            clsArrMo1762R = null;
                        } else {
                            clsArrMo1762R = abstractC2165b.mo1762R(c2196q.f4736f);
                        }
                        if (clsArrMo1762R == null) {
                            clsArrMo1762R = C2196q.f4732b;
                        }
                        c2196q.f4737g = clsArrMo1762R;
                    }
                    clsArrMo1852i = c2196q.f4737g;
                }
                c2234c = new C2234c(abstractC2198s, abstractC2188i, ((C2196q) c2243l.f4810b).f4736f.f4663t, abstractC2360jMo1821e, abstractC2364nM2260y, abstractC2215gMo1972c2, abstractC2360jM2006a, zMo1999B, obj, clsArrMo1852i);
                objMo1793q = c2243l.f4811c.mo1793q(abstractC2188i);
                if (objMo1793q != null) {
                    c2234c.mo1979e(abstractC2374x.mo2000H(abstractC2188i, objMo1793q));
                }
                AbstractC2352n abstractC2352nMo1761Q4 = c2243l.f4811c.mo1761Q(abstractC2188i);
                if (abstractC2352nMo1761Q4 != null) {
                }
            }
            z3 = true;
            EnumC2373w enumC2373w = EnumC2373w.WRITE_EMPTY_JSON_ARRAYS;
            if (!abstractC2360j.mo2104v() || c2243l.f4809a.m2237v(enumC2373w)) {
                z4 = z3;
                zMo1999B = z4;
                obj = null;
                clsArrMo1852i = abstractC2198s.mo1852i();
                if (clsArrMo1852i == null) {
                    c2196q = (C2196q) c2243l.f4810b;
                    if (!c2196q.f4738h) {
                        c2196q.f4738h = true;
                        abstractC2165b = c2196q.f4735e;
                        if (abstractC2165b == null) {
                            clsArrMo1762R = null;
                        } else {
                            clsArrMo1762R = abstractC2165b.mo1762R(c2196q.f4736f);
                        }
                        if (clsArrMo1762R == null) {
                            clsArrMo1762R = C2196q.f4732b;
                        }
                        c2196q.f4737g = clsArrMo1762R;
                    }
                    clsArrMo1852i = c2196q.f4737g;
                }
                c2234c = new C2234c(abstractC2198s, abstractC2188i, ((C2196q) c2243l.f4810b).f4736f.f4663t, abstractC2360jMo1821e, abstractC2364nM2260y, abstractC2215gMo1972c2, abstractC2360jM2006a, zMo1999B, obj, clsArrMo1852i);
                objMo1793q = c2243l.f4811c.mo1793q(abstractC2188i);
                if (objMo1793q != null) {
                    c2234c.mo1979e(abstractC2374x.mo2000H(abstractC2188i, objMo1793q));
                }
                AbstractC2352n abstractC2352nMo1761Q5 = c2243l.f4811c.mo1761Q(abstractC2188i);
                if (abstractC2352nMo1761Q5 != null) {
                }
            }
            int i5 = C2234c.f4790j;
            zMo1999B = z3;
            obj = obj2;
            clsArrMo1852i = abstractC2198s.mo1852i();
            if (clsArrMo1852i == null) {
                c2196q = (C2196q) c2243l.f4810b;
                if (!c2196q.f4738h) {
                    c2196q.f4738h = true;
                    abstractC2165b = c2196q.f4735e;
                    if (abstractC2165b == null) {
                        clsArrMo1762R = null;
                    } else {
                        clsArrMo1762R = abstractC2165b.mo1762R(c2196q.f4736f);
                    }
                    if (clsArrMo1762R == null) {
                        clsArrMo1762R = C2196q.f4732b;
                    }
                    c2196q.f4737g = clsArrMo1762R;
                }
                clsArrMo1852i = c2196q.f4737g;
            }
            c2234c = new C2234c(abstractC2198s, abstractC2188i, ((C2196q) c2243l.f4810b).f4736f.f4663t, abstractC2360jMo1821e, abstractC2364nM2260y, abstractC2215gMo1972c2, abstractC2360jM2006a, zMo1999B, obj, clsArrMo1852i);
            objMo1793q = c2243l.f4811c.mo1793q(abstractC2188i);
            if (objMo1793q != null) {
                c2234c.mo1979e(abstractC2374x.mo2000H(abstractC2188i, objMo1793q));
            }
            AbstractC2352n abstractC2352nMo1761Q6 = c2243l.f4811c.mo1761Q(abstractC2188i);
            if (abstractC2352nMo1761Q6 != null) {
            }
        } catch (JsonMappingException e3) {
            abstractC2374x.m2241E(c2243l.f4810b, abstractC2198s, C2342d.m2176h(e3), new Object[0]);
            throw null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:164:0x02f3 A[PHI: r4
      0x02f3: PHI (r4v88 b.g.a.c.n<?>) = (r4v87 b.g.a.c.n<?>), (r4v89 b.g.a.c.n<?>), (r4v91 b.g.a.c.n<?>) binds: [B:131:0x0273, B:133:0x0279, B:161:0x02e8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:215:0x0404 A[PHI: r11 r12 r13 r14 r15
      0x0404: PHI (r11v5 java.lang.Class<java.lang.Enum>) = (r11v4 java.lang.Class<java.lang.Enum>), (r11v10 java.lang.Class<java.lang.Enum>) binds: [B:189:0x0384, B:135:0x0284] A[DONT_GENERATE, DONT_INLINE]
      0x0404: PHI (r12v4 b.g.a.c.c) = (r12v3 b.g.a.c.c), (r12v10 b.g.a.c.c) binds: [B:189:0x0384, B:135:0x0284] A[DONT_GENERATE, DONT_INLINE]
      0x0404: PHI (r13v10 b.g.a.a.p$a) = (r13v9 b.g.a.a.p$a), (r13v13 b.g.a.a.p$a) binds: [B:189:0x0384, B:135:0x0284] A[DONT_GENERATE, DONT_INLINE]
      0x0404: PHI (r14v40 b.g.a.a.p$a) = (r14v39 b.g.a.a.p$a), (r14v43 b.g.a.a.p$a) binds: [B:189:0x0384, B:135:0x0284] A[DONT_GENERATE, DONT_INLINE]
      0x0404: PHI (r15v13 b.g.a.a.i$c) = (r15v12 b.g.a.a.i$c), (r15v16 b.g.a.a.i$c) binds: [B:189:0x0384, B:135:0x0284] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:262:0x04bf A[PHI: r4
      0x04bf: PHI (r4v14 int) = (r4v13 int), (r4v16 int) binds: [B:260:0x04ba, B:247:0x048b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:349:0x0658  */
    /* JADX WARN: Code duplicated, block: B:408:0x0729  */
    /* JADX WARN: Code duplicated, block: B:429:0x078f  */
    /* JADX WARN: Code duplicated, block: B:431:0x0792  */
    /* JADX WARN: Code duplicated, block: B:432:0x0795  */
    /* JADX WARN: Code duplicated, block: B:435:0x07ba  */
    /* JADX WARN: Code duplicated, block: B:440:0x07d6  */
    /* JADX WARN: Code duplicated, block: B:442:0x07e7  */
    /* JADX WARN: Code duplicated, block: B:449:0x07fe  */
    /* JADX WARN: Code duplicated, block: B:452:0x0808  */
    /* JADX WARN: Code duplicated, block: B:459:0x0824  */
    /* JADX WARN: Code duplicated, block: B:460:0x0829  */
    /* JADX WARN: Code duplicated, block: B:463:0x0846  */
    /* JADX WARN: Code duplicated, block: B:468:0x085d  */
    /* JADX WARN: Code duplicated, block: B:473:0x0883  */
    /* JADX WARN: Code duplicated, block: B:475:0x0888  */
    /* JADX WARN: Code duplicated, block: B:476:0x088a  */
    /* JADX WARN: Code duplicated, block: B:478:0x088d  */
    /* JADX WARN: Code duplicated, block: B:479:0x0891  */
    /* JADX WARN: Code duplicated, block: B:481:0x0895  */
    /* JADX WARN: Code duplicated, block: B:482:0x08ac  */
    /* JADX WARN: Code duplicated, block: B:487:0x08cb  */
    /* JADX WARN: Code duplicated, block: B:488:0x08d1  */
    /* JADX WARN: Code duplicated, block: B:490:0x08d8  */
    /* JADX WARN: Code duplicated, block: B:511:0x0925  */
    /* JADX WARN: Code duplicated, block: B:517:0x093f  */
    /* JADX WARN: Code duplicated, block: B:520:0x094d A[LOOP:3: B:518:0x0947->B:520:0x094d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:523:0x0963  */
    /* JADX WARN: Code duplicated, block: B:524:0x0968  */
    /* JADX WARN: Code duplicated, block: B:527:0x0975  */
    /* JADX WARN: Code duplicated, block: B:528:0x0977  */
    /* JADX WARN: Code duplicated, block: B:530:0x097d  */
    /* JADX WARN: Code duplicated, block: B:531:0x0980  */
    /* JADX WARN: Code duplicated, block: B:536:0x098b  */
    /* JADX WARN: Code duplicated, block: B:539:0x0995  */
    /* JADX WARN: Code duplicated, block: B:544:0x09b1  */
    /* JADX WARN: Code duplicated, block: B:547:0x09bf A[LOOP:4: B:545:0x09b9->B:547:0x09bf, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:550:0x09cd  */
    /* JADX WARN: Code duplicated, block: B:551:0x09d0  */
    /* JADX WARN: Code duplicated, block: B:553:0x09d6  */
    /* JADX WARN: Code duplicated, block: B:557:0x09f1  */
    /* JADX WARN: Code duplicated, block: B:558:0x09f4  */
    /* JADX WARN: Code duplicated, block: B:561:0x0a04  */
    /* JADX WARN: Code duplicated, block: B:564:0x0a16  */
    /* JADX WARN: Code duplicated, block: B:566:0x0a2c A[LOOP:7: B:554:0x09df->B:566:0x0a2c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:567:0x0a2f  */
    /* JADX WARN: Code duplicated, block: B:570:0x0a62  */
    /* JADX WARN: Code duplicated, block: B:572:0x0a66  */
    /* JADX WARN: Code duplicated, block: B:575:0x0a6d  */
    /* JADX WARN: Code duplicated, block: B:577:0x0a73  */
    /* JADX WARN: Code duplicated, block: B:578:0x0a7c  */
    /* JADX WARN: Code duplicated, block: B:580:0x0a97  */
    /* JADX WARN: Code duplicated, block: B:582:0x0a9a  */
    /* JADX WARN: Code duplicated, block: B:585:0x0aa7  */
    /* JADX WARN: Code duplicated, block: B:587:0x0abc  */
    /* JADX WARN: Code duplicated, block: B:589:0x0ac2  */
    /* JADX WARN: Code duplicated, block: B:592:0x0ac9  */
    /* JADX WARN: Code duplicated, block: B:594:0x0acf  */
    /* JADX WARN: Code duplicated, block: B:595:0x0ad8  */
    /* JADX WARN: Code duplicated, block: B:597:0x0af3  */
    /* JADX WARN: Code duplicated, block: B:599:0x0af6  */
    /* JADX WARN: Code duplicated, block: B:602:0x0b03  */
    /* JADX WARN: Code duplicated, block: B:604:0x0b18  */
    /* JADX WARN: Code duplicated, block: B:606:0x0b1b  */
    /* JADX WARN: Code duplicated, block: B:608:0x0b2d  */
    /* JADX WARN: Code duplicated, block: B:612:0x0b6e  */
    /* JADX WARN: Code duplicated, block: B:622:0x0b95  */
    /* JADX WARN: Code duplicated, block: B:624:0x0b99  */
    /* JADX WARN: Code duplicated, block: B:629:0x0ba5  */
    /* JADX WARN: Code duplicated, block: B:631:0x0bad  */
    /* JADX WARN: Code duplicated, block: B:634:0x0bb7  */
    /* JADX WARN: Code duplicated, block: B:637:0x0bc5 A[LOOP:6: B:635:0x0bbf->B:637:0x0bc5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:640:0x0bd5  */
    /* JADX WARN: Code duplicated, block: B:642:0x0bdb  */
    /* JADX WARN: Code duplicated, block: B:643:0x0be9  */
    /* JADX WARN: Code duplicated, block: B:645:0x0bf3  */
    /* JADX WARN: Code duplicated, block: B:651:0x0c08  */
    /* JADX WARN: Code duplicated, block: B:653:0x0c18  */
    /* JADX WARN: Code duplicated, block: B:655:0x0c22  */
    /* JADX WARN: Code duplicated, block: B:661:0x0c37  */
    /* JADX WARN: Code duplicated, block: B:663:0x0c45  */
    /* JADX WARN: Code duplicated, block: B:665:0x0c4d  */
    /* JADX WARN: Code duplicated, block: B:666:0x0c50  */
    /* JADX WARN: Code duplicated, block: B:669:0x0c54  */
    /* JADX WARN: Code duplicated, block: B:671:0x0c5e  */
    /* JADX WARN: Code duplicated, block: B:672:0x0c60  */
    /* JADX WARN: Code duplicated, block: B:674:0x0c63  */
    /* JADX WARN: Code duplicated, block: B:676:0x0c71  */
    /* JADX WARN: Code duplicated, block: B:680:0x0c9d  */
    /* JADX WARN: Code duplicated, block: B:696:0x07ca A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:697:0x07c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:698:0x07f2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:700:0x07b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:715:0x0b9b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:716:0x0a14 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:717:0x09e1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:719:0x09a5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:721:0x098f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:733:0x087d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:734:0x0859 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:736:0x0860 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:737:0x0857 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:740:0x0840 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x0180  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v111, types: [b.g.a.c.n] */
    /* JADX WARN: Type inference failed for: r1v114 */
    /* JADX WARN: Type inference failed for: r1v120 */
    /* JADX WARN: Type inference failed for: r1v121, types: [b.g.a.c.g0.d] */
    /* JADX WARN: Type inference failed for: r1v127, types: [b.g.a.c.g0.d] */
    /* JADX WARN: Type inference failed for: r1v155 */
    /* JADX WARN: Type inference failed for: r1v162 */
    /* JADX WARN: Type inference failed for: r1v163, types: [b.g.a.c.n] */
    /* JADX WARN: Type inference failed for: r1v164 */
    /* JADX WARN: Type inference failed for: r1v194 */
    /* JADX WARN: Type inference failed for: r1v195 */
    /* JADX WARN: Type inference failed for: r1v196 */
    /* JADX WARN: Type inference failed for: r1v197 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v203 */
    /* JADX WARN: Type inference failed for: r1v204, types: [b.g.a.c.g0.u.d0] */
    /* JADX WARN: Type inference failed for: r1v207, types: [b.g.a.c.n] */
    /* JADX WARN: Type inference failed for: r1v208 */
    /* JADX WARN: Type inference failed for: r1v210 */
    /* JADX WARN: Type inference failed for: r1v211 */
    /* JADX WARN: Type inference failed for: r1v217 */
    /* JADX WARN: Type inference failed for: r1v218 */
    /* JADX WARN: Type inference failed for: r1v229 */
    /* JADX WARN: Type inference failed for: r1v235, types: [b.g.a.c.n<?>] */
    /* JADX WARN: Type inference failed for: r1v236 */
    /* JADX WARN: Type inference failed for: r1v237 */
    /* JADX WARN: Type inference failed for: r1v239 */
    /* JADX WARN: Type inference failed for: r1v242 */
    /* JADX WARN: Type inference failed for: r1v243 */
    /* JADX WARN: Type inference failed for: r1v247 */
    /* JADX WARN: Type inference failed for: r1v249 */
    /* JADX WARN: Type inference failed for: r1v250 */
    /* JADX WARN: Type inference failed for: r1v251 */
    /* JADX WARN: Type inference failed for: r1v252 */
    /* JADX WARN: Type inference failed for: r1v253 */
    /* JADX WARN: Type inference failed for: r1v254 */
    /* JADX WARN: Type inference failed for: r1v255 */
    /* JADX WARN: Type inference failed for: r1v256 */
    /* JADX WARN: Type inference failed for: r1v257 */
    /* JADX WARN: Type inference failed for: r1v258 */
    /* JADX WARN: Type inference failed for: r1v259 */
    /* JADX WARN: Type inference failed for: r1v260 */
    /* JADX WARN: Type inference failed for: r1v261 */
    /* JADX WARN: Type inference failed for: r1v262 */
    /* JADX WARN: Type inference failed for: r1v263 */
    /* JADX WARN: Type inference failed for: r1v264 */
    /* JADX WARN: Type inference failed for: r1v265 */
    /* JADX WARN: Type inference failed for: r1v266 */
    /* JADX WARN: Type inference failed for: r1v267 */
    /* JADX WARN: Type inference failed for: r1v268 */
    /* JADX WARN: Type inference failed for: r1v269 */
    /* JADX WARN: Type inference failed for: r1v270 */
    /* JADX WARN: Type inference failed for: r1v271 */
    /* JADX WARN: Type inference failed for: r1v272 */
    /* JADX WARN: Type inference failed for: r1v3, types: [b.g.a.c.n] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31, types: [b.g.a.c.n<?>] */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v70 */
    /* JADX WARN: Type inference failed for: r26v0, types: [b.g.a.c.g0.b, b.g.a.c.g0.f] */
    /* JADX WARN: Type inference failed for: r5v33, types: [b.g.a.c.g0.t.i] */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v8, types: [b.g.a.c.n] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX INFO: renamed from: i */
    public AbstractC2364n<?> m1993i(AbstractC2374x abstractC2374x, AbstractC2360j abstractC2360j, AbstractC2172c abstractC2172c, boolean z2) throws JsonMappingException {
        InterfaceC2094p.a aVar;
        InterfaceC2094p.a aVar2;
        InterfaceC2081i.c cVar;
        Class<Enum> cls;
        AbstractC2172c abstractC2172c2;
        int i;
        ?? M1974e;
        AbstractC2364n<?> abstractC2364nM2010a;
        int i2;
        Object objM572t0;
        boolean zMo1999B;
        int i3;
        char c;
        int iOrdinal;
        C2311t0 c2311t0;
        C2314v c2314v;
        C2311t0 c2311t1;
        C2309s0 c2309s0;
        C2304q c2304q;
        C2302p c2302p;
        C2284g c2284g;
        Object objM572t1;
        boolean zMo1999B2;
        C2292k c2292k;
        C2286h c2286h;
        String str;
        boolean z3;
        String str2;
        String str3;
        String str4;
        C2268r c2268r;
        C2372v c2372v;
        C2236e c2236e;
        C2196q c2196q;
        List<AbstractC2198s> listM1919d;
        C2372v c2372v2;
        AbstractC2165b abstractC2165bM2267e;
        HashMap map;
        Iterator<AbstractC2198s> it;
        boolean zM1976g;
        C2243l c2243l;
        ArrayList arrayList;
        boolean z4;
        ArrayList<C2234c> arrayList2;
        AbstractC2188i abstractC2188iM1922j;
        AbstractC2165b.a aVarMo1851h;
        ArrayList arrayList3;
        boolean z5;
        int size;
        int i4;
        AbstractC2215g abstractC2215g;
        boolean zEquals;
        InterfaceC2091n.a aVarM2280s;
        Set<String> setM1617d;
        C2177c c2177c;
        AbstractC2165b abstractC2165bM2267e2;
        InterfaceC2095q.a aVarMo1745A;
        Set<String> set;
        Iterator it2;
        C2174a0 c2174a0;
        Class<? extends AbstractC2082i0<?>> cls2;
        C2260j c2260jM2031a;
        String str5;
        int size2;
        int i5;
        String strM2171c;
        C2234c c2234c;
        C2176b0 c2176b0;
        AbstractC2188i first;
        List<C2234c> list;
        boolean zM2279q;
        int size3;
        C2234c[] c2234cArr;
        int i6;
        Class<?> cls3;
        boolean z6;
        C2311t0 c2311t2;
        AbstractC2360j[] abstractC2360jArrM2167i;
        AbstractC2360j abstractC2360jM2158k;
        boolean z7;
        AbstractC2360j[] abstractC2360jArrM2167i2;
        AbstractC2360j abstractC2360jM2158k2;
        C2340b c2340b;
        C2234c c2234c2;
        Class<?>[] clsArr;
        List<C2234c> list2;
        AbstractC2360j abstractC2360jMo1821e;
        AbstractC2215g abstractC2215gMo1972c;
        AbstractC2364n abstractC2364nM1975f;
        LinkedList<AbstractC2188i> linkedList;
        C2176b0 c2176b1;
        LinkedList<AbstractC2188i> linkedList2;
        C2340b c2340b2;
        C2340b c2340b3;
        Iterator<AbstractC2198s> it3;
        AbstractC2198s next;
        AbstractC2198s next2;
        Class<?> clsMo1860r;
        Boolean boolMo1776c0;
        AbstractC2364n<Object> abstractC2364nM2259x;
        C2296m c2296m;
        Class<? extends AbstractC2364n<?>> cls4;
        AbstractC2364n abstractC2364n;
        boolean z8;
        AbstractC2364n<?> abstractC2364nM1974e;
        boolean z9;
        AbstractC2215g abstractC2215g2;
        AbstractC2364n<Object> abstractC2364n2;
        AbstractC2239h c2290j;
        InterfaceC2081i.c cVar2;
        AbstractC2364n<?> abstractC2364nM1974e2;
        C2372v c2372v3;
        AbstractC2364n<Object> abstractC2364n3;
        C2196q c2196q2;
        boolean z10;
        AbstractC2215g abstractC2215g3;
        Object objM572t2;
        boolean zMo1999B3;
        AbstractC2172c abstractC2172c3 = abstractC2172c;
        boolean z11 = z2;
        Class<Enum> cls5 = Enum.class;
        InterfaceC2081i.c cVar3 = InterfaceC2081i.c.OBJECT;
        InterfaceC2094p.a aVar3 = InterfaceC2094p.a.ALWAYS;
        InterfaceC2094p.a aVar4 = InterfaceC2094p.a.USE_DEFAULTS;
        C2372v c2372v4 = abstractC2374x._config;
        if (abstractC2360j.mo2104v()) {
            boolean zM1976g2 = !z11 ? m1976g(c2372v4, abstractC2172c3, null) : z11;
            C2372v c2372v5 = abstractC2374x._config;
            boolean z12 = (zM1976g2 || !abstractC2360j._asStatic || (abstractC2360j.mo2104v() && abstractC2360j.mo2099k().m2221y())) ? zM1976g2 : true;
            AbstractC2215g abstractC2215gMo1972c2 = mo1972c(c2372v5, abstractC2360j.mo2099k());
            boolean z13 = abstractC2215gMo1972c2 != null ? false : z12;
            C2196q c2196q3 = (C2196q) abstractC2172c3;
            C2177c c2177c2 = c2196q3.f4736f;
            Object objMo1775c = abstractC2374x.m2257v().mo1775c(c2177c2);
            AbstractC2364n<Object> abstractC2364nMo2000H = objMo1775c != null ? abstractC2374x.mo2000H(c2177c2, objMo1775c) : null;
            if (abstractC2360j.mo2122z()) {
                C2327f c2327f = (C2327f) abstractC2360j;
                C2177c c2177c3 = c2196q3.f4736f;
                Object objMo1788l = abstractC2374x.m2257v().mo1788l(c2177c3);
                AbstractC2364n<Object> abstractC2364nMo2000H2 = objMo1788l != null ? abstractC2374x.mo2000H(c2177c3, objMo1788l) : null;
                if (c2327f instanceof C2328g) {
                    C2328g c2328g = (C2328g) c2327f;
                    if (abstractC2172c3.mo1812a(null).m1601e() == cVar3) {
                        M1974e = 0;
                        cVar2 = cVar3;
                    } else {
                        C2372v c2372v6 = abstractC2374x._config;
                        C2340b c2340b4 = (C2340b) m1994j();
                        AbstractC2364n<?> abstractC2364nM1974e3 = null;
                        while (true) {
                            if (!c2340b4.hasNext()) {
                                cVar2 = cVar3;
                                c2372v3 = c2372v6;
                                abstractC2364n3 = abstractC2364nMo2000H;
                                c2196q2 = c2196q3;
                                z10 = z13;
                                abstractC2215g3 = abstractC2215gMo1972c2;
                                break;
                            }
                            c2372v3 = c2372v6;
                            abstractC2364n3 = abstractC2364nMo2000H;
                            cVar2 = cVar3;
                            c2196q2 = c2196q3;
                            z10 = z13;
                            abstractC2215g3 = abstractC2215gMo1972c2;
                            abstractC2364nM1974e3 = ((InterfaceC2249r) c2340b4.next()).m2012c(c2372v6, c2328g, abstractC2172c, abstractC2364nMo2000H2, abstractC2215gMo1972c2, abstractC2364n3);
                            if (abstractC2364nM1974e3 != null) {
                                break;
                            }
                            c2372v6 = c2372v3;
                            c2196q3 = c2196q2;
                            z13 = z10;
                            abstractC2215gMo1972c2 = abstractC2215g3;
                            abstractC2364nMo2000H = abstractC2364n3;
                            cVar3 = cVar2;
                        }
                        if (abstractC2364nM1974e3 == null && (abstractC2364nM1974e3 = m1974e(abstractC2374x, c2328g, abstractC2172c3)) == null) {
                            Object objMo1783g = c2372v3.m2267e().mo1783g(c2196q2.f4736f);
                            C2372v c2372v7 = c2372v3;
                            InterfaceC2091n.a aVarM2280s2 = c2372v7.m2280s(Map.class, c2196q2.f4736f);
                            Set<String> setM1617d2 = aVarM2280s2 == null ? null : aVarM2280s2.m1617d();
                            C2177c c2177c4 = c2196q2.f4736f;
                            AbstractC2165b abstractC2165bM2267e3 = c2372v7.m2267e();
                            InterfaceC2095q.a aVarMo1745A2 = abstractC2165bM2267e3 == null ? null : abstractC2165bM2267e3.mo1745A(c2372v7, c2177c4);
                            C2310t c2310tM2082s = C2310t.m2082s(setM1617d2, aVarMo1745A2 == null ? null : aVarMo1745A2._included, c2328g, z10, abstractC2215g3, abstractC2364nMo2000H2, abstractC2364n3, objMo1783g);
                            AbstractC2360j abstractC2360j2 = c2310tM2082s._valueType;
                            InterfaceC2094p.b bVarM1973d = m1973d(abstractC2374x, abstractC2172c3, abstractC2360j2, Map.class);
                            InterfaceC2094p.a aVar5 = bVarM1973d == null ? aVar4 : bVarM1973d._contentInclusion;
                            if (aVar5 == aVar4 || aVar5 == aVar3) {
                                M1974e = c2310tM2082s;
                                if (!abstractC2374x.m2240D(EnumC2373w.WRITE_NULL_MAP_VALUES)) {
                                    M1974e = c2310tM2082s.m2086v(null, true);
                                }
                            } else {
                                int iOrdinal2 = aVar5.ordinal();
                                if (iOrdinal2 != 2) {
                                    if (iOrdinal2 == 3) {
                                        objM572t2 = C2310t.f4865l;
                                    } else if (iOrdinal2 == 4) {
                                        objM572t2 = C1460d.m572t0(abstractC2360j2);
                                        if (objM572t2 != null && objM572t2.getClass().isArray()) {
                                            objM572t2 = C1460d.m560q0(objM572t2);
                                        }
                                    } else if (iOrdinal2 != 5) {
                                        zMo1999B3 = true;
                                        objM572t2 = null;
                                    } else {
                                        objM572t2 = abstractC2374x.mo1998A(null, bVarM1973d._contentFilter);
                                        if (objM572t2 != null) {
                                            zMo1999B3 = abstractC2374x.mo1999B(objM572t2);
                                        }
                                    }
                                    zMo1999B3 = true;
                                } else if (abstractC2360j2.mo1728b()) {
                                    objM572t2 = C2310t.f4865l;
                                    zMo1999B3 = true;
                                } else {
                                    zMo1999B3 = true;
                                    objM572t2 = null;
                                }
                                M1974e = c2310tM2082s.m2086v(objM572t2, zMo1999B3);
                            }
                        } else {
                            M1974e = abstractC2364nM1974e3;
                        }
                        if (this._factoryConfig.m2282a()) {
                            C2340b c2340b5 = (C2340b) this._factoryConfig.m2283b();
                            while (c2340b5.hasNext()) {
                                Objects.requireNonNull((AbstractC2238g) c2340b5.next());
                            }
                        }
                    }
                } else {
                    cVar2 = cVar3;
                    AbstractC2364n<?> abstractC2364nM2015f = null;
                    C2340b c2340b6 = (C2340b) m1994j();
                    while (c2340b6.hasNext()) {
                        C2327f c2327f2 = c2327f;
                        abstractC2364nM2015f = ((InterfaceC2249r) c2340b6.next()).m2015f(c2372v5, c2327f, abstractC2172c, abstractC2364nMo2000H2, abstractC2215gMo1972c2, abstractC2364nMo2000H);
                        if (abstractC2364nM2015f != null) {
                            break;
                        }
                        c2327f = c2327f2;
                    }
                    if (abstractC2364nM2015f == null) {
                        abstractC2364nM1974e2 = m1974e(abstractC2374x, abstractC2360j, abstractC2172c);
                    } else {
                        M1974e = abstractC2364nM2015f;
                    }
                    if (M1974e != 0 && this._factoryConfig.m2282a()) {
                        M1974e = abstractC2364nM1974e2;
                        C2340b c2340b7 = (C2340b) this._factoryConfig.m2283b();
                        while (c2340b7.hasNext()) {
                            Objects.requireNonNull((AbstractC2238g) c2340b7.next());
                        }
                    }
                }
                M1974e = abstractC2364nM1974e2;
                M1974e = abstractC2364nM1974e2;
                aVar = aVar4;
                aVar2 = aVar3;
                cls = cls5;
                abstractC2172c2 = abstractC2172c3;
                cVar = cVar2;
            } else {
                InterfaceC2081i.c cVar4 = cVar3;
                boolean z14 = z13;
                AbstractC2364n<?> abstractC2364nM1974e4 = null;
                if (abstractC2360j.mo2111u()) {
                    C2325d c2325d = (C2325d) abstractC2360j;
                    if (c2325d instanceof C2326e) {
                        C2326e c2326e = (C2326e) c2325d;
                        C2372v c2372v8 = abstractC2374x._config;
                        C2340b c2340b8 = (C2340b) m1994j();
                        while (true) {
                            if (!c2340b8.hasNext()) {
                                aVar = aVar4;
                                aVar2 = aVar3;
                                cls = cls5;
                                abstractC2172c2 = abstractC2172c3;
                                cVar = cVar4;
                                break;
                            }
                            InterfaceC2249r interfaceC2249r = (InterfaceC2249r) c2340b8.next();
                            aVar = aVar4;
                            C2372v c2372v9 = c2372v8;
                            aVar2 = aVar3;
                            cVar = cVar4;
                            C2372v c2372v10 = c2372v8;
                            cls = cls5;
                            C2340b c2340b9 = c2340b8;
                            abstractC2172c2 = abstractC2172c3;
                            abstractC2364nM1974e4 = interfaceC2249r.m2016g(c2372v9, c2326e, abstractC2172c, abstractC2215gMo1972c2, abstractC2364nMo2000H);
                            if (abstractC2364nM1974e4 != null) {
                                break;
                            }
                            cls5 = cls;
                            abstractC2172c3 = abstractC2172c2;
                            aVar4 = aVar;
                            aVar3 = aVar2;
                            cVar4 = cVar;
                            c2372v8 = c2372v10;
                            c2340b8 = c2340b9;
                        }
                        if (abstractC2364nM1974e4 != null || (abstractC2364nM1974e4 = m1974e(abstractC2374x, c2326e, abstractC2172c2)) != null) {
                            M1974e = abstractC2364nM1974e4;
                        } else if (abstractC2172c2.mo1812a(null).m1601e() == cVar) {
                            M1974e = 0;
                        } else {
                            Class<?> cls6 = c2326e._class;
                            if (EnumSet.class.isAssignableFrom(cls6)) {
                                AbstractC2360j abstractC2360j3 = c2326e._elementType;
                                if (!(C2342d.m2185q(abstractC2360j3._class) && abstractC2360j3._class != cls)) {
                                    abstractC2360j3 = null;
                                }
                                c2290j = new C2298n(abstractC2360j3);
                            } else {
                                Class<?> cls7 = c2326e._elementType._class;
                                if (!RandomAccess.class.isAssignableFrom(cls6)) {
                                    z9 = z14;
                                    abstractC2215g2 = abstractC2215gMo1972c2;
                                    abstractC2364n2 = abstractC2364nMo2000H;
                                    if (cls7 == String.class && C2342d.m2187s(abstractC2364n2)) {
                                        abstractC2364nM1974e4 = C2265o.f4844k;
                                    }
                                } else if (cls7 == String.class) {
                                    if (C2342d.m2187s(abstractC2364nMo2000H)) {
                                        abstractC2364nM1974e4 = C2257g.f4817k;
                                    }
                                    z9 = z14;
                                    abstractC2215g2 = abstractC2215gMo1972c2;
                                    abstractC2364n2 = abstractC2364nMo2000H;
                                } else {
                                    z9 = z14;
                                    abstractC2215g2 = abstractC2215gMo1972c2;
                                    abstractC2364n2 = abstractC2364nMo2000H;
                                    abstractC2364nM1974e4 = new C2256f(c2326e._elementType, z9, abstractC2215g2, abstractC2364n2);
                                }
                                if (abstractC2364nM1974e4 == null) {
                                    c2290j = new C2290j(c2326e._elementType, z9, abstractC2215g2, abstractC2364n2);
                                } else {
                                    M1974e = abstractC2364nM1974e4;
                                }
                            }
                            M1974e = c2290j;
                        }
                        if (this._factoryConfig.m2282a()) {
                            C2340b c2340b10 = (C2340b) this._factoryConfig.m2283b();
                            while (c2340b10.hasNext()) {
                                Objects.requireNonNull((AbstractC2238g) c2340b10.next());
                            }
                        }
                    } else {
                        aVar = aVar4;
                        aVar2 = aVar3;
                        cls = cls5;
                        abstractC2172c2 = abstractC2172c3;
                        AbstractC2215g abstractC2215g4 = abstractC2215gMo1972c2;
                        AbstractC2364n<Object> abstractC2364n4 = abstractC2364nMo2000H;
                        cVar = cVar4;
                        C2340b c2340b11 = (C2340b) m1994j();
                        AbstractC2364n<?> abstractC2364nM2013d = null;
                        while (c2340b11.hasNext()) {
                            C2372v c2372v11 = c2372v5;
                            AbstractC2364n<Object> abstractC2364n5 = abstractC2364n4;
                            AbstractC2215g abstractC2215g5 = abstractC2215g4;
                            abstractC2364nM2013d = ((InterfaceC2249r) c2340b11.next()).m2013d(c2372v11, c2325d, abstractC2172c, abstractC2215g4, abstractC2364n5);
                            if (abstractC2364nM2013d != null) {
                                break;
                            }
                            c2372v5 = c2372v11;
                            abstractC2215g4 = abstractC2215g5;
                            abstractC2364n4 = abstractC2364n5;
                        }
                        if (abstractC2364nM2013d == null) {
                            abstractC2364nM1974e = m1974e(abstractC2374x, abstractC2360j, abstractC2172c);
                        } else {
                            M1974e = abstractC2364nM2013d;
                        }
                        if (M1974e != 0 && this._factoryConfig.m2282a()) {
                            M1974e = abstractC2364nM1974e;
                            C2340b c2340b12 = (C2340b) this._factoryConfig.m2283b();
                            while (c2340b12.hasNext()) {
                                Objects.requireNonNull((AbstractC2238g) c2340b12.next());
                            }
                        }
                    }
                } else {
                    aVar = aVar4;
                    aVar2 = aVar3;
                    cls = cls5;
                    abstractC2172c2 = abstractC2172c3;
                    boolean z15 = z14;
                    cVar = cVar4;
                    if (abstractC2360j instanceof C2322a) {
                        C2322a c2322a = (C2322a) abstractC2360j;
                        C2372v c2372v12 = abstractC2374x._config;
                        C2340b c2340b13 = (C2340b) m1994j();
                        M1974e = 0;
                        while (true) {
                            if (!c2340b13.hasNext()) {
                                z8 = z15;
                                break;
                            }
                            C2372v c2372v13 = c2372v12;
                            C2372v c2372v14 = c2372v12;
                            z8 = z15;
                            M1974e = ((InterfaceC2249r) c2340b13.next()).m2014e(c2372v13, c2322a, abstractC2172c, abstractC2215gMo1972c2, abstractC2364nMo2000H);
                            if (M1974e != 0) {
                                break;
                            }
                            z15 = z8;
                            c2372v12 = c2372v14;
                            M1974e = M1974e;
                        }
                        if (M1974e == 0) {
                            Class<?> cls8 = c2322a._class;
                            if (abstractC2364nMo2000H == null || C2342d.m2187s(abstractC2364nMo2000H)) {
                                M1974e = M1974e;
                                M1974e = String[].class == cls8 ? C2264n.f4843k : C2289i0.f4855a.get(cls8.getName());
                            }
                            if (M1974e == 0) {
                                M1974e = new C2279d0(c2322a._componentType, z8, abstractC2215gMo1972c2, abstractC2364nMo2000H);
                            }
                        }
                        if (this._factoryConfig.m2282a()) {
                            C2340b c2340b14 = (C2340b) this._factoryConfig.m2283b();
                            while (c2340b14.hasNext()) {
                                Objects.requireNonNull((AbstractC2238g) c2340b14.next());
                            }
                        }
                    } else {
                        M1974e = 0;
                    }
                }
            }
            if (M1974e != 0) {
                return M1974e;
            }
            i = 3;
            z11 = zM1976g2;
        } else {
            aVar = aVar4;
            aVar2 = aVar3;
            cVar = cVar3;
            cls = cls5;
            abstractC2172c2 = abstractC2172c3;
            if (abstractC2360j.mo1728b()) {
                C2330i c2330i = (C2330i) abstractC2360j;
                AbstractC2360j abstractC2360j4 = c2330i._referencedType;
                AbstractC2215g abstractC2215gMo1972c3 = (AbstractC2215g) abstractC2360j4._typeHandler;
                C2372v c2372v15 = abstractC2374x._config;
                if (abstractC2215gMo1972c3 == null) {
                    abstractC2215gMo1972c3 = mo1972c(c2372v15, abstractC2360j4);
                }
                AbstractC2215g abstractC2215g6 = abstractC2215gMo1972c3;
                AbstractC2364n<Object> abstractC2364n6 = (AbstractC2364n) abstractC2360j4._valueHandler;
                C2340b c2340b15 = (C2340b) m1994j();
                while (true) {
                    if (c2340b15.hasNext()) {
                        AbstractC2364n<Object> abstractC2364n7 = abstractC2364n6;
                        AbstractC2215g abstractC2215g7 = abstractC2215g6;
                        C2372v c2372v16 = c2372v15;
                        abstractC2364nM2010a = ((InterfaceC2249r) c2340b15.next()).m2010a(c2372v15, c2330i, abstractC2172c, abstractC2215g6, abstractC2364n7);
                        if (abstractC2364nM2010a == null) {
                            abstractC2364n6 = abstractC2364n7;
                            abstractC2215g6 = abstractC2215g7;
                            c2372v15 = c2372v16;
                        }
                    } else {
                        AbstractC2364n<Object> abstractC2364n8 = abstractC2364n6;
                        AbstractC2215g abstractC2215g8 = abstractC2215g6;
                        if (c2330i.m2216B(AtomicReference.class)) {
                            AbstractC2360j abstractC2360j5 = c2330i._referencedType;
                            InterfaceC2094p.b bVarM1973d2 = m1973d(abstractC2374x, abstractC2172c2, abstractC2360j5, AtomicReference.class);
                            InterfaceC2094p.a aVar6 = bVarM1973d2 == null ? aVar : bVarM1973d2._contentInclusion;
                            if (aVar6 == aVar || aVar6 == aVar2) {
                                i2 = 3;
                                objM572t0 = null;
                                zMo1999B = false;
                            } else {
                                int iOrdinal3 = aVar6.ordinal();
                                if (iOrdinal3 != 2) {
                                    i2 = 3;
                                    if (iOrdinal3 == 3) {
                                        objM572t0 = C2310t.f4865l;
                                    } else if (iOrdinal3 == 4) {
                                        objM572t0 = C1460d.m572t0(abstractC2360j5);
                                        if (objM572t0 != null && objM572t0.getClass().isArray()) {
                                            objM572t0 = C1460d.m560q0(objM572t0);
                                        }
                                    } else if (iOrdinal3 != 5) {
                                        objM572t0 = null;
                                    } else {
                                        objM572t0 = abstractC2374x.mo1998A(null, bVarM1973d2._contentFilter);
                                        if (objM572t0 != null) {
                                            zMo1999B = abstractC2374x.mo1999B(objM572t0);
                                        }
                                    }
                                    zMo1999B = true;
                                } else {
                                    i2 = 3;
                                    if (abstractC2360j5.mo1728b()) {
                                        objM572t0 = C2310t.f4865l;
                                    } else {
                                        objM572t0 = null;
                                    }
                                    zMo1999B = true;
                                }
                            }
                            AbstractC2283f0<AtomicReference<?>> abstractC2283f0Mo2049t = new C2276c(c2330i, z11, abstractC2215g8, abstractC2364n8).mo2049t(objM572t0, zMo1999B);
                            i = i2;
                            M1974e = abstractC2283f0Mo2049t;
                            break;
                        }
                        abstractC2364nM2010a = null;
                    }
                    i = 3;
                    M1974e = abstractC2364nM2010a;
                    break;
                }
            }
            i = 3;
            C2340b c2340b16 = (C2340b) m1994j();
            AbstractC2364n<?> abstractC2364nM2011b = null;
            while (c2340b16.hasNext() && (abstractC2364nM2011b = ((InterfaceC2249r) c2340b16.next()).m2011b(c2372v4, abstractC2360j, abstractC2172c2)) == null) {
            }
            M1974e = abstractC2364nM2011b;
            if (M1974e == 0) {
                M1974e = m1974e(abstractC2374x, abstractC2360j, abstractC2172c);
            }
        }
        if (M1974e == 0) {
            String name = abstractC2360j._class.getName();
            AbstractC2364n<?> abstractC2364n9 = AbstractC2233b.f4788j.get(name);
            if (abstractC2364n9 != null || (cls4 = AbstractC2233b.f4789k.get(name)) == null) {
                M1974e = abstractC2364n9;
                i3 = 0;
            } else {
                i3 = 0;
                abstractC2364n = (AbstractC2364n) C2342d.m2175g(cls4, false);
            }
            if (M1974e == 0) {
                if (abstractC2360j.m2219w()) {
                    C2372v c2372v17 = abstractC2374x._config;
                    InterfaceC2081i.d dVarMo1812a = abstractC2172c2.mo1812a(null);
                    if (dVarMo1812a.m1601e() == cVar) {
                        M1974e = abstractC2364n;
                        Iterator<AbstractC2198s> it4 = ((C2196q) abstractC2172c2).m1919d().iterator();
                        while (it4.hasNext()) {
                            if (it4.next().mo1858p().equals("declaringClass")) {
                                it4.remove();
                                break;
                            }
                        }
                        c2296m = null;
                    } else {
                        Class<?> cls9 = abstractC2360j._class;
                        int i7 = C2296m.f4857k;
                        C2296m c2296m2 = new C2296m(C2344f.m2198a(c2372v17, cls9), C2296m.m2068p(cls9, dVarMo1812a, true, null));
                        if (this._factoryConfig.m2282a()) {
                            M1974e = abstractC2364n;
                            C2340b c2340b17 = (C2340b) this._factoryConfig.m2283b();
                            while (c2340b17.hasNext()) {
                                Objects.requireNonNull((AbstractC2238g) c2340b17.next());
                            }
                        }
                        M1974e = abstractC2364n;
                        c2296m = c2296m2;
                    }
                    c = 1;
                    M1974e = c2296m;
                } else {
                    c = 1;
                    Class<?> cls10 = abstractC2360j._class;
                    ?? M1809a = C2171f.f4625l.m1809a(abstractC2374x._config, abstractC2360j, abstractC2172c2);
                    if (M1809a != 0) {
                        M1974e = abstractC2364n;
                        M1974e = M1809a;
                    } else if (Calendar.class.isAssignableFrom(cls10)) {
                        c2286h = C2286h.f4854k;
                    } else if (Date.class.isAssignableFrom(cls10)) {
                        c2292k = C2292k.f4856k;
                    } else if (Map.Entry.class.isAssignableFrom(cls10)) {
                        AbstractC2360j abstractC2360jMo2144i = abstractC2360j.mo2144i(Map.Entry.class);
                        AbstractC2360j abstractC2360jM2217h = abstractC2360jMo2144i.m2217h(i3);
                        AbstractC2360j abstractC2360jM2217h2 = abstractC2360jMo2144i.m2217h(1);
                        InterfaceC2081i.d dVarMo2271i = abstractC2374x._config.mo2271i(Map.Entry.class);
                        InterfaceC2081i.d dVarMo1812a2 = abstractC2172c2.mo1812a(null);
                        if (dVarMo1812a2 != null) {
                            M1974e = abstractC2364n;
                            dVarMo2271i = dVarMo1812a2.m1607k(dVarMo2271i);
                        }
                        M1974e = abstractC2364n;
                        if (dVarMo2271i.m1601e() == cVar) {
                            M1809a = 0;
                        } else {
                            M1809a = new C2259i(abstractC2360jM2217h2, abstractC2360jM2217h, abstractC2360jM2217h2, z11, mo1972c(abstractC2374x._config, abstractC2360jM2217h2), null);
                            AbstractC2360j abstractC2360j6 = M1809a._valueType;
                            InterfaceC2094p.b bVarM1973d3 = m1973d(abstractC2374x, abstractC2172c2, abstractC2360j6, Map.Entry.class);
                            InterfaceC2094p.a aVar7 = bVarM1973d3 == null ? aVar : bVarM1973d3._contentInclusion;
                            if (aVar7 != aVar && aVar7 != aVar2) {
                                int iOrdinal4 = aVar7.ordinal();
                                if (iOrdinal4 != 2) {
                                    if (iOrdinal4 == i) {
                                        objM572t1 = C2310t.f4865l;
                                    } else if (iOrdinal4 == 4) {
                                        objM572t1 = C1460d.m572t0(abstractC2360j6);
                                        if (objM572t1 != null && objM572t1.getClass().isArray()) {
                                            objM572t1 = C1460d.m560q0(objM572t1);
                                        }
                                    } else if (iOrdinal4 != 5) {
                                        objM572t1 = null;
                                    } else {
                                        objM572t1 = abstractC2374x.mo1998A(null, bVarM1973d3._contentFilter);
                                        if (objM572t1 != null) {
                                            zMo1999B2 = abstractC2374x.mo1999B(objM572t1);
                                        }
                                    }
                                    zMo1999B2 = true;
                                } else {
                                    if (abstractC2360j6.mo1728b()) {
                                        objM572t1 = C2310t.f4865l;
                                    } else {
                                        objM572t1 = null;
                                    }
                                    zMo1999B2 = true;
                                }
                                if (M1809a._suppressableValue != objM572t1 || M1809a._suppressNulls != zMo1999B2) {
                                    M1809a = new C2259i(M1809a, M1809a._keySerializer, M1809a._valueSerializer, objM572t1, zMo1999B2);
                                }
                            }
                        }
                        M1974e = abstractC2364n;
                        M1974e = M1809a;
                    } else if (ByteBuffer.class.isAssignableFrom(cls10)) {
                        c2284g = new C2284g();
                    } else if (InetAddress.class.isAssignableFrom(cls10)) {
                        c2302p = new C2302p();
                    } else if (InetSocketAddress.class.isAssignableFrom(cls10)) {
                        c2304q = new C2304q();
                    } else if (TimeZone.class.isAssignableFrom(cls10)) {
                        c2309s0 = new C2309s0();
                    } else if (Charset.class.isAssignableFrom(cls10)) {
                        c2311t1 = C2311t0.f4866k;
                    } else if (!Number.class.isAssignableFrom(cls10) || (iOrdinal = abstractC2172c2.mo1812a(null).m1601e().ordinal()) == i || iOrdinal == 4) {
                        M1974e = abstractC2364n;
                        M1974e = abstractC2364n;
                        M1974e = abstractC2364n;
                        M1974e = 0;
                    } else if (iOrdinal != 8) {
                        c2314v = C2314v.f4868k;
                    } else {
                        c2311t0 = C2311t0.f4866k;
                    }
                }
                if (M1974e == 0) {
                    M1974e = abstractC2364n;
                    M1974e = c2311t0;
                    M1974e = abstractC2364n;
                    M1974e = c2314v;
                    M1974e = abstractC2364n;
                    M1974e = c2311t1;
                    M1974e = abstractC2364n;
                    M1974e = c2309s0;
                    M1974e = abstractC2364n;
                    M1974e = c2304q;
                    M1974e = abstractC2364n;
                    M1974e = c2302p;
                    M1974e = abstractC2364n;
                    M1974e = c2284g;
                    M1974e = abstractC2364n;
                    M1974e = c2292k;
                    M1974e = abstractC2364n;
                    M1974e = c2286h;
                    Class<?> cls11 = abstractC2360j._class;
                    Annotation[] annotationArr = C2342d.f4944a;
                    if (cls11.isAnnotation()) {
                        str = "annotation";
                    } else if (cls11.isArray()) {
                        str = "array";
                    } else if (cls.isAssignableFrom(cls11)) {
                        str = "enum";
                    } else {
                        str = cls11.isPrimitive() ? "primitive" : null;
                    }
                    if (str == null) {
                        String name2 = cls11.getName();
                        if (name2.startsWith("net.sf.cglib.proxy.") || name2.startsWith("org.hibernate.proxy.")) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                    } else {
                        z3 = false;
                    }
                    if (z3 || C2342d.m2185q(abstractC2360j._class)) {
                        if (abstractC2172c2.f4626a._class == Object.class) {
                            abstractC2364nM2259x = abstractC2374x.m2259x(Object.class);
                        } else {
                            Class<?> cls12 = abstractC2360j._class;
                            if (cls12.getName().startsWith("java.time.")) {
                                str3 = "Java 8 date/time";
                                str4 = "com.fasterxml.jackson.datatype:jackson-datatype-jsr310";
                            } else {
                                if (cls12.getName().startsWith("org.joda.time.")) {
                                    str3 = "Joda date/time";
                                    str4 = "com.fasterxml.jackson.datatype:jackson-datatype-joda";
                                } else {
                                    str2 = null;
                                }
                                if (str2 == null && abstractC2374x._config.mo1885a(abstractC2360j._class) == null) {
                                    c2268r = new C2268r(abstractC2360j, str2);
                                } else {
                                    c2268r = null;
                                }
                                if (c2268r != null) {
                                    M1974e = c2268r;
                                } else {
                                    c2372v = abstractC2374x._config;
                                    c2236e = new C2236e(abstractC2172c2);
                                    c2236e.f4798c = c2372v;
                                    c2196q = (C2196q) abstractC2172c2;
                                    listM1919d = c2196q.m1919d();
                                    c2372v2 = abstractC2374x._config;
                                    abstractC2165bM2267e = c2372v2.m2267e();
                                    map = new HashMap();
                                    it = listM1919d.iterator();
                                    while (it.hasNext()) {
                                        next2 = it.next();
                                        if (next2.m1922j() == null) {
                                            it.remove();
                                        } else {
                                            clsMo1860r = next2.mo1860r();
                                            boolMo1776c0 = (Boolean) map.get(clsMo1860r);
                                            if (boolMo1776c0 == null) {
                                                c2372v2.mo2268f(clsMo1860r);
                                                boolMo1776c0 = abstractC2165bM2267e.mo1776c0(((C2196q) c2372v2.m2277o(clsMo1860r)).f4736f);
                                                if (boolMo1776c0 == null) {
                                                    boolMo1776c0 = Boolean.FALSE;
                                                }
                                                map.put(clsMo1860r, boolMo1776c0);
                                            }
                                            if (boolMo1776c0.booleanValue()) {
                                                it.remove();
                                            }
                                        }
                                    }
                                    if (c2372v2.m2279q(EnumC2366p.REQUIRE_SETTERS_FOR_GETTERS)) {
                                        it3 = listM1919d.iterator();
                                        while (it3.hasNext()) {
                                            next = it3.next();
                                            if (next.mo1849f() && !next.mo1863u()) {
                                                it3.remove();
                                            }
                                        }
                                    }
                                    if (listM1919d.isEmpty()) {
                                        arrayList2 = null;
                                        z4 = z11;
                                    } else {
                                        zM1976g = m1976g(c2372v2, abstractC2172c2, null);
                                        c2243l = new C2243l(c2372v2, abstractC2172c2);
                                        arrayList = new ArrayList(listM1919d.size());
                                        for (AbstractC2198s abstractC2198s : listM1919d) {
                                            abstractC2188iM1922j = abstractC2198s.m1922j();
                                            if (abstractC2198s.mo1864v()) {
                                                aVarMo1851h = abstractC2198s.mo1851h();
                                                if (aVarMo1851h == null) {
                                                    if (aVarMo1851h.f4619a == 2) {
                                                        z5 = true;
                                                    } else {
                                                        z5 = false;
                                                    }
                                                    if (z5) {
                                                        arrayList3 = arrayList;
                                                    } else if (abstractC2188iM1922j instanceof C2189j) {
                                                        arrayList3 = arrayList;
                                                        arrayList3.add(m1992h(abstractC2374x, abstractC2198s, c2243l, zM1976g, (C2189j) abstractC2188iM1922j));
                                                    } else {
                                                        arrayList3 = arrayList;
                                                        arrayList3.add(m1992h(abstractC2374x, abstractC2198s, c2243l, zM1976g, (C2185g) abstractC2188iM1922j));
                                                    }
                                                } else if (abstractC2188iM1922j instanceof C2189j) {
                                                    arrayList3 = arrayList;
                                                    arrayList3.add(m1992h(abstractC2374x, abstractC2198s, c2243l, zM1976g, (C2189j) abstractC2188iM1922j));
                                                } else {
                                                    arrayList3 = arrayList;
                                                    arrayList3.add(m1992h(abstractC2374x, abstractC2198s, c2243l, zM1976g, (C2185g) abstractC2188iM1922j));
                                                }
                                                arrayList = arrayList3;
                                                z11 = z11;
                                            } else if (abstractC2188iM1922j == null) {
                                                continue;
                                            } else {
                                                if (c2236e.f4803h == null) {
                                                    StringBuilder sbM833U = C1643a.m833U("Multiple type ids specified with ");
                                                    sbM833U.append(c2236e.f4803h);
                                                    sbM833U.append(" and ");
                                                    sbM833U.append(abstractC2188iM1922j);
                                                    throw new IllegalArgumentException(sbM833U.toString());
                                                }
                                                c2236e.f4803h = abstractC2188iM1922j;
                                            }
                                        }
                                        z4 = z11;
                                        arrayList2 = arrayList;
                                    }
                                    if (arrayList2 == null) {
                                        arrayList2 = new ArrayList();
                                    } else {
                                        size = arrayList2.size();
                                        for (i4 = 0; i4 < size; i4++) {
                                            C2234c c2234c3 = (C2234c) arrayList2.get(i4);
                                            abstractC2215g = c2234c3._typeSerializer;
                                            if (abstractC2215g == null && abstractC2215g.mo1957c() == InterfaceC2070c0.a.EXTERNAL_PROPERTY) {
                                                C2370t c2370tM2227a = C2370t.m2227a(abstractC2215g.mo1956b());
                                                for (C2234c c2234c4 : arrayList2) {
                                                    if (c2234c4 != c2234c3) {
                                                        C2370t c2370t = c2234c4._wrapperName;
                                                        if (c2370t != null) {
                                                            zEquals = c2370t.equals(c2370tM2227a);
                                                        } else if (!c2370tM2227a._simpleName.equals(c2234c4._name._value)) {
                                                            zEquals = false;
                                                        } else if (c2370tM2227a._namespace != null) {
                                                            zEquals = false;
                                                        } else {
                                                            zEquals = true;
                                                        }
                                                        if (zEquals) {
                                                            c2234c3._typeSerializer = null;
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    abstractC2374x.m2257v().mo1771a(c2372v, c2196q.f4736f, arrayList2);
                                    if (this._factoryConfig.m2282a()) {
                                        c2340b3 = (C2340b) this._factoryConfig.m2283b();
                                        while (c2340b3.hasNext()) {
                                            Objects.requireNonNull((AbstractC2238g) c2340b3.next());
                                        }
                                    }
                                    aVarM2280s = c2372v.m2280s(abstractC2172c2.f4626a._class, c2196q.f4736f);
                                    if (aVarM2280s != null) {
                                        setM1617d = aVarM2280s.m1617d();
                                    } else {
                                        setM1617d = null;
                                    }
                                    Class<?> cls13 = abstractC2172c2.f4626a._class;
                                    c2177c = c2196q.f4736f;
                                    abstractC2165bM2267e2 = c2372v.m2267e();
                                    if (abstractC2165bM2267e2 == null) {
                                        aVarMo1745A = null;
                                    } else {
                                        aVarMo1745A = abstractC2165bM2267e2.mo1745A(c2372v, c2177c);
                                    }
                                    if (aVarMo1745A != null) {
                                        set = aVarMo1745A._included;
                                    } else {
                                        set = null;
                                    }
                                    if (set == null || (setM1617d != null && !setM1617d.isEmpty())) {
                                        it2 = arrayList2.iterator();
                                        while (it2.hasNext()) {
                                            if (C1460d.m502b2(((C2234c) it2.next())._name._value, setM1617d, set)) {
                                                it2.remove();
                                            }
                                        }
                                    }
                                    if (this._factoryConfig.m2282a()) {
                                        c2340b2 = (C2340b) this._factoryConfig.m2283b();
                                        while (c2340b2.hasNext()) {
                                            Objects.requireNonNull((AbstractC2238g) c2340b2.next());
                                        }
                                    }
                                    c2174a0 = c2196q.f4740j;
                                    if (c2174a0 == null) {
                                        c2260jM2031a = null;
                                    } else {
                                        cls2 = c2174a0.f4629c;
                                        if (cls2 == AbstractC2088l0.class) {
                                            str5 = c2174a0.f4628b._simpleName;
                                            size2 = arrayList2.size();
                                            i5 = 0;
                                            while (true) {
                                                if (i5 == size2) {
                                                    Object[] objArr = new Object[2];
                                                    objArr[0] = C2342d.m2182n(abstractC2172c2.f4626a);
                                                    if (str5 == null) {
                                                        strM2171c = "[null]";
                                                    } else {
                                                        strM2171c = C2342d.m2171c(str5);
                                                    }
                                                    objArr[1] = strM2171c;
                                                    throw new IllegalArgumentException(String.format("Invalid Object Id definition for %s: cannot find property with name %s", objArr));
                                                }
                                                c2234c = (C2234c) arrayList2.get(i5);
                                                if (str5.equals(c2234c._name._value)) {
                                                    if (i5 > 0) {
                                                        arrayList2.remove(i5);
                                                        arrayList2.add(0, c2234c);
                                                    }
                                                    c2260jM2031a = C2260j.m2031a(c2234c._declaredType, null, new C2261k(c2174a0, c2234c), c2174a0.f4632f);
                                                    break;
                                                }
                                                i5++;
                                            }
                                        } else {
                                            c2260jM2031a = C2260j.m2031a(abstractC2374x.mo1940d().m2167i(abstractC2374x.m1938b(cls2), AbstractC2082i0.class)[0], c2174a0.f4628b, abstractC2374x.m1941e(c2196q.f4736f, c2174a0), c2174a0.f4632f);
                                        }
                                    }
                                    c2236e.f4804i = c2260jM2031a;
                                    c2236e.f4799d = arrayList2;
                                    c2236e.f4802g = c2372v.m2267e().mo1783g(c2196q.f4736f);
                                    c2176b0 = c2196q.f4733c;
                                    if (c2176b0 == null) {
                                        first = null;
                                    } else {
                                        if (!c2176b0.f4641i) {
                                            c2176b0.m1829h();
                                        }
                                        linkedList = c2176b0.f4645m;
                                        if (linkedList != null) {
                                            first = null;
                                        } else {
                                            if (linkedList.size() <= 1) {
                                                c2176b0.m1830i("Multiple 'any-getter' methods defined (%s vs %s)", c2176b0.f4645m.get(0), c2176b0.f4645m.get(1));
                                                throw null;
                                            }
                                            first = c2176b0.f4645m.getFirst();
                                        }
                                        if (first != null) {
                                            c2176b1 = c2196q.f4733c;
                                            if (!c2176b1.f4641i) {
                                                c2176b1.m1829h();
                                            }
                                            linkedList2 = c2176b1.f4646n;
                                            if (linkedList2 != null) {
                                                first = null;
                                            } else {
                                                if (linkedList2.size() <= 1) {
                                                    c2176b1.m1830i("Multiple 'any-getter' fields defined (%s vs %s)", c2176b1.f4646n.get(0), c2176b1.f4646n.get(1));
                                                    throw null;
                                                }
                                                first = c2176b1.f4646n.getFirst();
                                            }
                                            if (first != null) {
                                                first = null;
                                            } else if (!Map.class.isAssignableFrom(first.mo1820d())) {
                                                throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on field '%s': type is not instance of java.util.Map", first.mo1819c()));
                                            }
                                        } else if (!Map.class.isAssignableFrom(first.mo1820d())) {
                                            throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on method %s(): return type is not instance of java.util.Map", first.mo1819c()));
                                        }
                                    }
                                    if (first != null) {
                                        abstractC2360jMo1821e = first.mo1821e();
                                        AbstractC2360j abstractC2360jMo2099k = abstractC2360jMo1821e.mo2099k();
                                        abstractC2215gMo1972c = mo1972c(c2372v, abstractC2360jMo2099k);
                                        abstractC2364nM1975f = m1975f(abstractC2374x, first);
                                        if (abstractC2364nM1975f == null) {
                                            abstractC2364nM1975f = C2310t.m2082s(null, null, abstractC2360jMo1821e, c2372v.m2279q(EnumC2366p.USE_STATIC_TYPING), abstractC2215gMo1972c, null, null, null);
                                        }
                                        c2236e.f4801f = new C2232a(new InterfaceC2206d.a(C2370t.m2227a(first.mo1819c()), abstractC2360jMo2099k, null, first, C2369s.f5026k), first, abstractC2364nM1975f);
                                    }
                                    list = c2236e.f4799d;
                                    zM2279q = c2372v.m2279q(EnumC2366p.DEFAULT_VIEW_INCLUSION);
                                    size3 = list.size();
                                    c2234cArr = new C2234c[size3];
                                    i6 = 0;
                                    int i8 = 0;
                                    while (i6 < size3) {
                                        c2234c2 = list.get(i6);
                                        clsArr = c2234c2._includeInViews;
                                        if (clsArr != null || clsArr.length == 0) {
                                            list2 = list;
                                            if (zM2279q) {
                                                c2234cArr[i6] = c2234c2;
                                            }
                                        } else {
                                            i8++;
                                            list2 = list;
                                            c2234cArr[i6] = clsArr.length == 1 ? new C2255e(c2234c2, clsArr[0]) : new C2254d(c2234c2, clsArr);
                                        }
                                        i6++;
                                        list = list2;
                                    }
                                    if (zM2279q || i8 != 0) {
                                        if (size3 != c2236e.f4799d.size()) {
                                            throw new IllegalArgumentException(String.format("Trying to set %d filtered properties; must match length of non-filtered `properties` (%d)", Integer.valueOf(size3), Integer.valueOf(c2236e.f4799d.size())));
                                        }
                                        c2236e.f4800e = c2234cArr;
                                    }
                                    if (this._factoryConfig.m2282a()) {
                                        c2340b = (C2340b) this._factoryConfig.m2283b();
                                        while (c2340b.hasNext()) {
                                            Objects.requireNonNull((AbstractC2238g) c2340b.next());
                                        }
                                    }
                                    try {
                                        M1974e = c2236e.m1990a();
                                        if (M1974e == 0) {
                                            if (abstractC2360j.m2215A()) {
                                                M1974e = new C2235d(c2236e.f4797b.f4626a, c2236e, AbstractC2278d.f4851k, null);
                                            } else {
                                                cls3 = abstractC2360j._class;
                                                if (Iterator.class.isAssignableFrom(cls3)) {
                                                    abstractC2360jArrM2167i2 = c2372v._base._typeFactory.m2167i(abstractC2360j, Iterator.class);
                                                    if (abstractC2360jArrM2167i2 == null && abstractC2360jArrM2167i2.length == 1) {
                                                        abstractC2360jM2158k2 = abstractC2360jArrM2167i2[0];
                                                    } else {
                                                        abstractC2360jM2158k2 = C2335n.m2158k();
                                                    }
                                                    M1974e = new C2258h(abstractC2360jM2158k2, z4, mo1972c(c2372v, abstractC2360jM2158k2));
                                                } else {
                                                    z6 = z4;
                                                    if (Iterable.class.isAssignableFrom(cls3)) {
                                                        abstractC2360jArrM2167i = c2372v._base._typeFactory.m2167i(abstractC2360j, Iterable.class);
                                                        if (abstractC2360jArrM2167i == null && abstractC2360jArrM2167i.length == 1) {
                                                            abstractC2360jM2158k = abstractC2360jArrM2167i[0];
                                                        } else {
                                                            abstractC2360jM2158k = C2335n.m2158k();
                                                        }
                                                        M1974e = new C2306r(abstractC2360jM2158k, z6, mo1972c(c2372v, abstractC2360jM2158k));
                                                    } else {
                                                        if (CharSequence.class.isAssignableFrom(cls3)) {
                                                            c2311t2 = C2311t0.f4866k;
                                                        } else {
                                                            c2311t2 = null;
                                                        }
                                                        M1974e = c2311t2;
                                                    }
                                                }
                                                if (M1974e == 0) {
                                                    if (c2196q.f4736f.f4663t.size() > 0) {
                                                        z7 = true;
                                                    } else {
                                                        z7 = false;
                                                    }
                                                    if (z7) {
                                                        M1974e = new C2235d(c2236e.f4797b.f4626a, c2236e, AbstractC2278d.f4851k, null);
                                                    }
                                                }
                                            }
                                        }
                                    } catch (RuntimeException e) {
                                        abstractC2374x.m2242F(abstractC2172c2, "Failed to construct BeanSerializer for %s: (%s) %s", abstractC2172c2.f4626a, e.getClass().getName(), e.getMessage());
                                        throw null;
                                    }
                                }
                            }
                            Object[] objArr2 = new Object[i];
                            objArr2[i3] = str3;
                            objArr2[c] = C2342d.m2182n(abstractC2360j);
                            objArr2[2] = str4;
                            str2 = String.format("%s type %s not supported by default: add Module \"%s\" to enable handling", objArr2);
                            if (str2 == null) {
                                c2268r = null;
                            } else {
                                c2268r = null;
                            }
                            if (c2268r != null) {
                                M1974e = c2268r;
                            } else {
                                c2372v = abstractC2374x._config;
                                c2236e = new C2236e(abstractC2172c2);
                                c2236e.f4798c = c2372v;
                                c2196q = (C2196q) abstractC2172c2;
                                listM1919d = c2196q.m1919d();
                                c2372v2 = abstractC2374x._config;
                                abstractC2165bM2267e = c2372v2.m2267e();
                                map = new HashMap();
                                it = listM1919d.iterator();
                                while (it.hasNext()) {
                                    next2 = it.next();
                                    if (next2.m1922j() == null) {
                                        it.remove();
                                    } else {
                                        clsMo1860r = next2.mo1860r();
                                        boolMo1776c0 = (Boolean) map.get(clsMo1860r);
                                        if (boolMo1776c0 == null) {
                                            c2372v2.mo2268f(clsMo1860r);
                                            boolMo1776c0 = abstractC2165bM2267e.mo1776c0(((C2196q) c2372v2.m2277o(clsMo1860r)).f4736f);
                                            if (boolMo1776c0 == null) {
                                                boolMo1776c0 = Boolean.FALSE;
                                            }
                                            map.put(clsMo1860r, boolMo1776c0);
                                        }
                                        if (boolMo1776c0.booleanValue()) {
                                            it.remove();
                                        }
                                    }
                                }
                                if (c2372v2.m2279q(EnumC2366p.REQUIRE_SETTERS_FOR_GETTERS)) {
                                    it3 = listM1919d.iterator();
                                    while (it3.hasNext()) {
                                        next = it3.next();
                                        if (next.mo1849f()) {
                                        }
                                    }
                                }
                                if (listM1919d.isEmpty()) {
                                    arrayList2 = null;
                                    z4 = z11;
                                } else {
                                    zM1976g = m1976g(c2372v2, abstractC2172c2, null);
                                    c2243l = new C2243l(c2372v2, abstractC2172c2);
                                    arrayList = new ArrayList(listM1919d.size());
                                    while (r16.hasNext()) {
                                        abstractC2188iM1922j = abstractC2198s.m1922j();
                                        if (abstractC2198s.mo1864v()) {
                                            aVarMo1851h = abstractC2198s.mo1851h();
                                            if (aVarMo1851h == null) {
                                                if (aVarMo1851h.f4619a == 2) {
                                                    z5 = true;
                                                } else {
                                                    z5 = false;
                                                }
                                                if (z5) {
                                                    arrayList3 = arrayList;
                                                } else if (abstractC2188iM1922j instanceof C2189j) {
                                                    arrayList3 = arrayList;
                                                    arrayList3.add(m1992h(abstractC2374x, abstractC2198s, c2243l, zM1976g, (C2189j) abstractC2188iM1922j));
                                                } else {
                                                    arrayList3 = arrayList;
                                                    arrayList3.add(m1992h(abstractC2374x, abstractC2198s, c2243l, zM1976g, (C2185g) abstractC2188iM1922j));
                                                }
                                            } else if (abstractC2188iM1922j instanceof C2189j) {
                                                arrayList3 = arrayList;
                                                arrayList3.add(m1992h(abstractC2374x, abstractC2198s, c2243l, zM1976g, (C2189j) abstractC2188iM1922j));
                                            } else {
                                                arrayList3 = arrayList;
                                                arrayList3.add(m1992h(abstractC2374x, abstractC2198s, c2243l, zM1976g, (C2185g) abstractC2188iM1922j));
                                            }
                                            arrayList = arrayList3;
                                            z11 = z11;
                                        } else if (abstractC2188iM1922j == null) {
                                            continue;
                                        } else {
                                            if (c2236e.f4803h == null) {
                                                StringBuilder sbM833U2 = C1643a.m833U("Multiple type ids specified with ");
                                                sbM833U2.append(c2236e.f4803h);
                                                sbM833U2.append(" and ");
                                                sbM833U2.append(abstractC2188iM1922j);
                                                throw new IllegalArgumentException(sbM833U2.toString());
                                            }
                                            c2236e.f4803h = abstractC2188iM1922j;
                                        }
                                    }
                                    z4 = z11;
                                    arrayList2 = arrayList;
                                }
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList();
                                } else {
                                    size = arrayList2.size();
                                    while (i4 < size) {
                                        C2234c c2234c5 = (C2234c) arrayList2.get(i4);
                                        abstractC2215g = c2234c5._typeSerializer;
                                        if (abstractC2215g == null) {
                                        }
                                    }
                                }
                                abstractC2374x.m2257v().mo1771a(c2372v, c2196q.f4736f, arrayList2);
                                if (this._factoryConfig.m2282a()) {
                                    c2340b3 = (C2340b) this._factoryConfig.m2283b();
                                    while (c2340b3.hasNext()) {
                                        Objects.requireNonNull((AbstractC2238g) c2340b3.next());
                                    }
                                }
                                aVarM2280s = c2372v.m2280s(abstractC2172c2.f4626a._class, c2196q.f4736f);
                                if (aVarM2280s != null) {
                                    setM1617d = aVarM2280s.m1617d();
                                } else {
                                    setM1617d = null;
                                }
                                Class<?> cls14 = abstractC2172c2.f4626a._class;
                                c2177c = c2196q.f4736f;
                                abstractC2165bM2267e2 = c2372v.m2267e();
                                if (abstractC2165bM2267e2 == null) {
                                    aVarMo1745A = null;
                                } else {
                                    aVarMo1745A = abstractC2165bM2267e2.mo1745A(c2372v, c2177c);
                                }
                                if (aVarMo1745A != null) {
                                    set = aVarMo1745A._included;
                                } else {
                                    set = null;
                                }
                                if (set == null) {
                                    it2 = arrayList2.iterator();
                                    while (it2.hasNext()) {
                                        if (C1460d.m502b2(((C2234c) it2.next())._name._value, setM1617d, set)) {
                                            it2.remove();
                                        }
                                    }
                                } else {
                                    it2 = arrayList2.iterator();
                                    while (it2.hasNext()) {
                                        if (C1460d.m502b2(((C2234c) it2.next())._name._value, setM1617d, set)) {
                                            it2.remove();
                                        }
                                    }
                                }
                                if (this._factoryConfig.m2282a()) {
                                    c2340b2 = (C2340b) this._factoryConfig.m2283b();
                                    while (c2340b2.hasNext()) {
                                        Objects.requireNonNull((AbstractC2238g) c2340b2.next());
                                    }
                                }
                                c2174a0 = c2196q.f4740j;
                                if (c2174a0 == null) {
                                    c2260jM2031a = null;
                                } else {
                                    cls2 = c2174a0.f4629c;
                                    if (cls2 == AbstractC2088l0.class) {
                                        str5 = c2174a0.f4628b._simpleName;
                                        size2 = arrayList2.size();
                                        i5 = 0;
                                        while (true) {
                                            if (i5 == size2) {
                                                Object[] objArr3 = new Object[2];
                                                objArr3[0] = C2342d.m2182n(abstractC2172c2.f4626a);
                                                if (str5 == null) {
                                                    strM2171c = "[null]";
                                                } else {
                                                    strM2171c = C2342d.m2171c(str5);
                                                }
                                                objArr3[1] = strM2171c;
                                                throw new IllegalArgumentException(String.format("Invalid Object Id definition for %s: cannot find property with name %s", objArr3));
                                            }
                                            c2234c = (C2234c) arrayList2.get(i5);
                                            if (str5.equals(c2234c._name._value)) {
                                                if (i5 > 0) {
                                                    arrayList2.remove(i5);
                                                    arrayList2.add(0, c2234c);
                                                }
                                                c2260jM2031a = C2260j.m2031a(c2234c._declaredType, null, new C2261k(c2174a0, c2234c), c2174a0.f4632f);
                                                break;
                                            }
                                            i5++;
                                        }
                                    } else {
                                        c2260jM2031a = C2260j.m2031a(abstractC2374x.mo1940d().m2167i(abstractC2374x.m1938b(cls2), AbstractC2082i0.class)[0], c2174a0.f4628b, abstractC2374x.m1941e(c2196q.f4736f, c2174a0), c2174a0.f4632f);
                                    }
                                }
                                c2236e.f4804i = c2260jM2031a;
                                c2236e.f4799d = arrayList2;
                                c2236e.f4802g = c2372v.m2267e().mo1783g(c2196q.f4736f);
                                c2176b0 = c2196q.f4733c;
                                if (c2176b0 == null) {
                                    first = null;
                                } else {
                                    if (!c2176b0.f4641i) {
                                        c2176b0.m1829h();
                                    }
                                    linkedList = c2176b0.f4645m;
                                    if (linkedList != null) {
                                        first = null;
                                    } else {
                                        if (linkedList.size() <= 1) {
                                            c2176b0.m1830i("Multiple 'any-getter' methods defined (%s vs %s)", c2176b0.f4645m.get(0), c2176b0.f4645m.get(1));
                                            throw null;
                                        }
                                        first = c2176b0.f4645m.getFirst();
                                    }
                                    if (first != null) {
                                        c2176b1 = c2196q.f4733c;
                                        if (!c2176b1.f4641i) {
                                            c2176b1.m1829h();
                                        }
                                        linkedList2 = c2176b1.f4646n;
                                        if (linkedList2 != null) {
                                            first = null;
                                        } else {
                                            if (linkedList2.size() <= 1) {
                                                c2176b1.m1830i("Multiple 'any-getter' fields defined (%s vs %s)", c2176b1.f4646n.get(0), c2176b1.f4646n.get(1));
                                                throw null;
                                            }
                                            first = c2176b1.f4646n.getFirst();
                                        }
                                        if (first != null) {
                                            first = null;
                                        } else if (!Map.class.isAssignableFrom(first.mo1820d())) {
                                            throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on field '%s': type is not instance of java.util.Map", first.mo1819c()));
                                        }
                                    } else if (!Map.class.isAssignableFrom(first.mo1820d())) {
                                        throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on method %s(): return type is not instance of java.util.Map", first.mo1819c()));
                                    }
                                }
                                if (first != null) {
                                    abstractC2360jMo1821e = first.mo1821e();
                                    AbstractC2360j abstractC2360jMo2099k2 = abstractC2360jMo1821e.mo2099k();
                                    abstractC2215gMo1972c = mo1972c(c2372v, abstractC2360jMo2099k2);
                                    abstractC2364nM1975f = m1975f(abstractC2374x, first);
                                    if (abstractC2364nM1975f == null) {
                                        abstractC2364nM1975f = C2310t.m2082s(null, null, abstractC2360jMo1821e, c2372v.m2279q(EnumC2366p.USE_STATIC_TYPING), abstractC2215gMo1972c, null, null, null);
                                    }
                                    c2236e.f4801f = new C2232a(new InterfaceC2206d.a(C2370t.m2227a(first.mo1819c()), abstractC2360jMo2099k2, null, first, C2369s.f5026k), first, abstractC2364nM1975f);
                                }
                                list = c2236e.f4799d;
                                zM2279q = c2372v.m2279q(EnumC2366p.DEFAULT_VIEW_INCLUSION);
                                size3 = list.size();
                                c2234cArr = new C2234c[size3];
                                i6 = 0;
                                int i9 = 0;
                                while (i6 < size3) {
                                    c2234c2 = list.get(i6);
                                    clsArr = c2234c2._includeInViews;
                                    if (clsArr != null) {
                                        list2 = list;
                                        if (zM2279q) {
                                            c2234cArr[i6] = c2234c2;
                                        }
                                    } else {
                                        list2 = list;
                                        if (zM2279q) {
                                            c2234cArr[i6] = c2234c2;
                                        }
                                    }
                                    i6++;
                                    list = list2;
                                }
                                if (zM2279q) {
                                    if (size3 != c2236e.f4799d.size()) {
                                        throw new IllegalArgumentException(String.format("Trying to set %d filtered properties; must match length of non-filtered `properties` (%d)", Integer.valueOf(size3), Integer.valueOf(c2236e.f4799d.size())));
                                    }
                                    c2236e.f4800e = c2234cArr;
                                } else {
                                    if (size3 != c2236e.f4799d.size()) {
                                        throw new IllegalArgumentException(String.format("Trying to set %d filtered properties; must match length of non-filtered `properties` (%d)", Integer.valueOf(size3), Integer.valueOf(c2236e.f4799d.size())));
                                    }
                                    c2236e.f4800e = c2234cArr;
                                }
                                if (this._factoryConfig.m2282a()) {
                                    c2340b = (C2340b) this._factoryConfig.m2283b();
                                    while (c2340b.hasNext()) {
                                        Objects.requireNonNull((AbstractC2238g) c2340b.next());
                                    }
                                }
                                M1974e = c2236e.m1990a();
                                if (M1974e == 0) {
                                    if (abstractC2360j.m2215A()) {
                                        M1974e = new C2235d(c2236e.f4797b.f4626a, c2236e, AbstractC2278d.f4851k, null);
                                    } else {
                                        cls3 = abstractC2360j._class;
                                        if (Iterator.class.isAssignableFrom(cls3)) {
                                            abstractC2360jArrM2167i2 = c2372v._base._typeFactory.m2167i(abstractC2360j, Iterator.class);
                                            if (abstractC2360jArrM2167i2 == null) {
                                                abstractC2360jM2158k2 = C2335n.m2158k();
                                            } else {
                                                abstractC2360jM2158k2 = C2335n.m2158k();
                                            }
                                            M1974e = new C2258h(abstractC2360jM2158k2, z4, mo1972c(c2372v, abstractC2360jM2158k2));
                                        } else {
                                            z6 = z4;
                                            if (Iterable.class.isAssignableFrom(cls3)) {
                                                abstractC2360jArrM2167i = c2372v._base._typeFactory.m2167i(abstractC2360j, Iterable.class);
                                                if (abstractC2360jArrM2167i == null) {
                                                    abstractC2360jM2158k = C2335n.m2158k();
                                                } else {
                                                    abstractC2360jM2158k = C2335n.m2158k();
                                                }
                                                M1974e = new C2306r(abstractC2360jM2158k, z6, mo1972c(c2372v, abstractC2360jM2158k));
                                            } else {
                                                if (CharSequence.class.isAssignableFrom(cls3)) {
                                                    c2311t2 = C2311t0.f4866k;
                                                } else {
                                                    c2311t2 = null;
                                                }
                                                M1974e = c2311t2;
                                            }
                                        }
                                        if (M1974e == 0) {
                                            if (c2196q.f4736f.f4663t.size() > 0) {
                                                z7 = true;
                                            } else {
                                                z7 = false;
                                            }
                                            if (z7) {
                                                M1974e = new C2235d(c2236e.f4797b.f4626a, c2236e, AbstractC2278d.f4851k, null);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (M1974e == 0) {
                            M1974e = abstractC2374x.m2259x(abstractC2172c2.f4626a._class);
                        }
                    } else {
                        abstractC2364nM2259x = null;
                    }
                    M1974e = abstractC2364nM2259x;
                    if (M1974e == 0) {
                        M1974e = abstractC2374x.m2259x(abstractC2172c2.f4626a._class);
                    }
                }
            }
        }
        if (M1974e != 0 && this._factoryConfig.m2282a()) {
            C2340b c2340b18 = (C2340b) this._factoryConfig.m2283b();
            while (c2340b18.hasNext()) {
                Objects.requireNonNull((AbstractC2238g) c2340b18.next());
            }
        }
        return M1974e;
    }

    /* JADX INFO: renamed from: j */
    public Iterable<InterfaceC2249r> m1994j() {
        return new C2340b(this._factoryConfig._additionalSerializers);
    }
}
