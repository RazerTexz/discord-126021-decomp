package p007b.p195g.p196a.p205c.p215g0;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p197a.AbstractC2082i0;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.InterfaceC2115k;
import p007b.p195g.p196a.p198b.p200p.C2130j;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.C2370t;
import p007b.p195g.p196a.p205c.C2372v;
import p007b.p195g.p196a.p205c.EnumC2373w;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2175b;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2198s;
import p007b.p195g.p196a.p205c.p210c0.C2196q;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p215g0.p216t.C2263m;
import p007b.p195g.p196a.p205c.p215g0.p216t.C2266p;
import p007b.p195g.p196a.p205c.p215g0.p216t.C2271u;
import p007b.p195g.p196a.p205c.p218h0.C2323b;
import p007b.p195g.p196a.p205c.p218h0.C2335n;
import p007b.p195g.p196a.p205c.p219i0.C2342d;
import p007b.p195g.p196a.p205c.p219i0.C2346h;
import p007b.p195g.p196a.p205c.p219i0.C2354p;
import p007b.p195g.p196a.p205c.p219i0.C2359u;

/* JADX INFO: renamed from: b.g.a.c.g0.j */
/* JADX INFO: compiled from: DefaultSerializerProvider.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2241j extends AbstractC2374x implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: m */
    public transient Map<Object, C2271u> f4806m;

    /* JADX INFO: renamed from: n */
    public transient ArrayList<AbstractC2082i0<?>> f4807n;

    /* JADX INFO: renamed from: o */
    public transient AbstractC2108d f4808o;

    /* JADX INFO: renamed from: b.g.a.c.g0.j$a */
    /* JADX INFO: compiled from: DefaultSerializerProvider.java */
    public static final class a extends AbstractC2241j {
        private static final long serialVersionUID = 1;

        public a() {
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2241j
        /* JADX INFO: renamed from: K */
        public AbstractC2241j mo2003K(C2372v c2372v, AbstractC2248q abstractC2248q) {
            return new a(this, c2372v, abstractC2248q);
        }

        public a(AbstractC2374x abstractC2374x, C2372v c2372v, AbstractC2248q abstractC2248q) {
            super(abstractC2374x, c2372v, abstractC2248q);
        }
    }

    public AbstractC2241j() {
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2374x
    /* JADX INFO: renamed from: A */
    public Object mo1998A(AbstractC2198s abstractC2198s, Class<?> cls) {
        if (cls == null) {
            return null;
        }
        Objects.requireNonNull(this._config._base);
        return C2342d.m2175g(cls, this._config.m2265b());
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2374x
    /* JADX INFO: renamed from: B */
    public boolean mo1999B(Object obj) throws JsonMappingException {
        try {
            return obj.equals(null);
        } catch (Throwable th) {
            InvalidDefinitionException invalidDefinitionException = new InvalidDefinitionException(this.f4808o, String.format("Problem determining whether filter of type '%s' should filter out `null` values: (%s) %s", obj.getClass().getName(), th.getClass().getName(), C2342d.m2176h(th)), m1938b(obj.getClass()));
            invalidDefinitionException.initCause(th);
            throw invalidDefinitionException;
        }
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2374x
    /* JADX INFO: renamed from: H */
    public AbstractC2364n<Object> mo2000H(AbstractC2175b abstractC2175b, Object obj) throws JsonMappingException {
        AbstractC2364n<Object> abstractC2364n;
        if (obj instanceof AbstractC2364n) {
            abstractC2364n = (AbstractC2364n) obj;
        } else {
            if (!(obj instanceof Class)) {
                AbstractC2360j abstractC2360jMo1821e = abstractC2175b.mo1821e();
                StringBuilder sbM833U = C1643a.m833U("AnnotationIntrospector returned serializer definition of type ");
                sbM833U.append(obj.getClass().getName());
                sbM833U.append("; expected type JsonSerializer or Class<JsonSerializer> instead");
                mo1942f(abstractC2360jMo1821e, sbM833U.toString());
                throw null;
            }
            Class cls = (Class) obj;
            if (cls == AbstractC2364n.a.class || C2342d.m2184p(cls)) {
                return null;
            }
            if (!AbstractC2364n.class.isAssignableFrom(cls)) {
                AbstractC2360j abstractC2360jMo1821e2 = abstractC2175b.mo1821e();
                StringBuilder sbM833U2 = C1643a.m833U("AnnotationIntrospector returned Class ");
                sbM833U2.append(cls.getName());
                sbM833U2.append("; expected Class<JsonSerializer>");
                mo1942f(abstractC2360jMo1821e2, sbM833U2.toString());
                throw null;
            }
            Objects.requireNonNull(this._config._base);
            abstractC2364n = (AbstractC2364n) C2342d.m2175g(cls, this._config.m2265b());
        }
        if (abstractC2364n instanceof InterfaceC2246o) {
            ((InterfaceC2246o) abstractC2364n).mo2007b(this);
        }
        return abstractC2364n;
    }

    /* JADX INFO: renamed from: I */
    public final void m2001I(AbstractC2108d abstractC2108d, Object obj, AbstractC2364n<Object> abstractC2364n, C2370t c2370t) throws IOException {
        try {
            abstractC2108d.mo1651c0();
            C2372v c2372v = this._config;
            InterfaceC2115k c2130j = c2370t._encodedSimple;
            if (c2130j == null) {
                c2130j = c2372v == null ? new C2130j(c2370t._simpleName) : new C2130j(c2370t._simpleName);
                c2370t._encodedSimple = c2130j;
            }
            abstractC2108d.mo1665x(c2130j);
            abstractC2364n.mo1807f(obj, abstractC2108d, this);
            abstractC2108d.mo1664u();
        } catch (Exception e) {
            throw m2002J(abstractC2108d, e);
        }
    }

    /* JADX INFO: renamed from: J */
    public final IOException m2002J(AbstractC2108d abstractC2108d, Exception exc) {
        if (exc instanceof IOException) {
            return (IOException) exc;
        }
        String strM2176h = C2342d.m2176h(exc);
        if (strM2176h == null) {
            StringBuilder sbM833U = C1643a.m833U("[no message for ");
            sbM833U.append(exc.getClass().getName());
            sbM833U.append("]");
            strM2176h = sbM833U.toString();
        }
        return new JsonMappingException(abstractC2108d, strM2176h, exc);
    }

    /* JADX INFO: renamed from: K */
    public abstract AbstractC2241j mo2003K(C2372v c2372v, AbstractC2248q abstractC2248q);

    /* JADX INFO: renamed from: L */
    public void m2004L(AbstractC2108d abstractC2108d, Object obj) throws IOException {
        AbstractC2364n<Object> abstractC2364nM2256u;
        AbstractC2364n<Object> abstractC2364n;
        this.f4808o = abstractC2108d;
        if (obj == null) {
            try {
                this._nullValueSerializer.mo1807f(null, abstractC2108d, this);
                return;
            } catch (Exception e) {
                throw m2002J(abstractC2108d, e);
            }
        }
        Class<?> cls = obj.getClass();
        C2263m c2263m = this._knownSerializers;
        C2263m.a aVar = c2263m.f4836a[c2263m.f4837b & (cls.getName().hashCode() + 1)];
        if (aVar == null) {
            abstractC2364nM2256u = null;
            break;
        }
        if (!(aVar.f4840c == cls && aVar.f4842e)) {
            while (true) {
                aVar = aVar.f4839b;
                if (aVar == null) {
                    abstractC2364nM2256u = null;
                    break;
                } else {
                    if (aVar.f4840c == cls && aVar.f4842e) {
                        abstractC2364nM2256u = aVar.f4838a;
                        break;
                    }
                }
            }
        } else {
            abstractC2364nM2256u = aVar.f4838a;
        }
        if (abstractC2364nM2256u == null) {
            C2247p c2247p = this._serializerCache;
            synchronized (c2247p) {
                abstractC2364n = c2247p.f4815a.get(new C2359u(cls, true));
            }
            if (abstractC2364n != null) {
                abstractC2364nM2256u = abstractC2364n;
            } else {
                abstractC2364nM2256u = m2256u(cls, null);
                AbstractC2248q abstractC2248q = this._serializerFactory;
                C2372v c2372v = this._config;
                AbstractC2215g abstractC2215gMo1972c = abstractC2248q.mo1972c(c2372v, c2372v._base._typeFactory.m2160b(null, cls, C2335n.f4926l));
                if (abstractC2215gMo1972c != null) {
                    abstractC2364nM2256u = new C2266p(abstractC2215gMo1972c.mo1955a(null), abstractC2364nM2256u);
                }
                C2247p c2247p2 = this._serializerCache;
                synchronized (c2247p2) {
                    if (c2247p2.f4815a.put(new C2359u(cls, true), abstractC2364nM2256u) == null) {
                        c2247p2.f4816b.set(null);
                    }
                }
            }
        }
        C2372v c2372v2 = this._config;
        C2370t c2370t = c2372v2._rootName;
        if (c2370t == null) {
            if (c2372v2.m2237v(EnumC2373w.WRAP_ROOT_VALUE)) {
                C2372v c2372v3 = this._config;
                C2370t c2370t2 = c2372v3._rootName;
                if (c2370t2 == null) {
                    C2354p c2354p = c2372v3._rootNames;
                    Objects.requireNonNull(c2354p);
                    C2323b c2323b = new C2323b(cls);
                    C2370t c2370t3 = c2354p.f4962j.f4955k.get(c2323b);
                    if (c2370t3 != null) {
                        c2370t2 = c2370t3;
                    } else {
                        C2370t c2370tMo1750F = c2372v3.m2267e().mo1750F(((C2196q) c2372v3.m2277o(cls)).f4736f);
                        if (c2370tMo1750F == null || !c2370tMo1750F.m2229c()) {
                            c2370tMo1750F = C2370t.m2227a(cls.getSimpleName());
                        }
                        C2346h<C2323b, C2370t> c2346h = c2354p.f4962j;
                        if (c2346h.f4955k.size() >= c2346h.f4954j) {
                            synchronized (c2346h) {
                                if (c2346h.f4955k.size() >= c2346h.f4954j) {
                                    c2346h.f4955k.clear();
                                }
                            }
                        }
                        c2346h.f4955k.put(c2323b, c2370tMo1750F);
                        c2370t2 = c2370tMo1750F;
                    }
                }
                m2001I(abstractC2108d, obj, abstractC2364nM2256u, c2370t2);
                return;
            }
        } else if (!c2370t.m2230d()) {
            m2001I(abstractC2108d, obj, abstractC2364nM2256u, c2370t);
            return;
        }
        try {
            abstractC2364nM2256u.mo1807f(obj, abstractC2108d, this);
        } catch (Exception e2) {
            throw m2002J(abstractC2108d, e2);
        }
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2374x
    /* JADX INFO: renamed from: p */
    public C2271u mo2005p(Object obj, AbstractC2082i0<?> abstractC2082i0) {
        Map<Object, C2271u> map = this.f4806m;
        if (map == null) {
            this.f4806m = m2240D(EnumC2373w.USE_EQUALITY_FOR_OBJECT_ID) ? new HashMap<>() : new IdentityHashMap<>();
        } else {
            C2271u c2271u = map.get(obj);
            if (c2271u != null) {
                return c2271u;
            }
        }
        AbstractC2082i0<?> abstractC2082i0Mo1612e = null;
        ArrayList<AbstractC2082i0<?>> arrayList = this.f4807n;
        if (arrayList == null) {
            this.f4807n = new ArrayList<>(8);
        } else {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                AbstractC2082i0<?> abstractC2082i1 = this.f4807n.get(i);
                if (abstractC2082i1.mo1608a(abstractC2082i0)) {
                    abstractC2082i0Mo1612e = abstractC2082i1;
                    break;
                }
            }
        }
        if (abstractC2082i0Mo1612e == null) {
            abstractC2082i0Mo1612e = abstractC2082i0.mo1612e(this);
            this.f4807n.add(abstractC2082i0Mo1612e);
        }
        C2271u c2271u2 = new C2271u(abstractC2082i0Mo1612e);
        this.f4806m.put(obj, c2271u2);
        return c2271u2;
    }

    public AbstractC2241j(AbstractC2374x abstractC2374x, C2372v c2372v, AbstractC2248q abstractC2248q) {
        super(abstractC2374x, c2372v, abstractC2248q);
    }
}
