package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p195g.p196a.p197a.AbstractC2082i0;
import p007b.p195g.p196a.p197a.AbstractC2088l0;
import p007b.p195g.p196a.p197a.InterfaceC2081i;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.EnumC2112h;
import p007b.p195g.p196a.p198b.InterfaceC2115k;
import p007b.p195g.p196a.p198b.p203s.C2138b;
import p007b.p195g.p196a.p205c.AbstractC2165b;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.C2370t;
import p007b.p195g.p196a.p205c.C2372v;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2175b;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2188i;
import p007b.p195g.p196a.p205c.p210c0.C2174a0;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p215g0.AbstractC2239h;
import p007b.p195g.p196a.p205c.p215g0.C2232a;
import p007b.p195g.p196a.p205c.p215g0.C2234c;
import p007b.p195g.p196a.p205c.p215g0.C2236e;
import p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i;
import p007b.p195g.p196a.p205c.p215g0.InterfaceC2246o;
import p007b.p195g.p196a.p205c.p215g0.p216t.C2259i;
import p007b.p195g.p196a.p205c.p215g0.p216t.C2260j;
import p007b.p195g.p196a.p205c.p215g0.p216t.C2261k;
import p007b.p195g.p196a.p205c.p215g0.p216t.C2271u;
import p007b.p195g.p196a.p205c.p219i0.AbstractC2352n;
import p007b.p195g.p196a.p205c.p219i0.C2342d;
import p007b.p195g.p196a.p205c.p219i0.C2344f;
import p007b.p195g.p196a.p205c.p219i0.InterfaceC2343e;

/* JADX INFO: renamed from: b.g.a.c.g0.u.d */
/* JADX INFO: compiled from: BeanSerializerBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2278d extends AbstractC2305q0<Object> implements InterfaceC2240i, InterfaceC2246o {

    /* JADX INFO: renamed from: k */
    public static final C2234c[] f4851k;
    public final C2232a _anyGetterWriter;
    public final AbstractC2360j _beanType;
    public final C2234c[] _filteredProps;
    public final C2260j _objectIdWriter;
    public final Object _propertyFilterId;
    public final C2234c[] _props;
    public final InterfaceC2081i.c _serializationShape;
    public final AbstractC2188i _typeId;

    static {
        new C2370t("#object-ref");
        f4851k = new C2234c[0];
    }

    public AbstractC2278d(AbstractC2360j abstractC2360j, C2236e c2236e, C2234c[] c2234cArr, C2234c[] c2234cArr2) {
        super(abstractC2360j);
        this._beanType = abstractC2360j;
        this._props = c2234cArr;
        this._filteredProps = c2234cArr2;
        if (c2236e == null) {
            this._typeId = null;
            this._anyGetterWriter = null;
            this._propertyFilterId = null;
            this._objectIdWriter = null;
            this._serializationShape = null;
            return;
        }
        this._typeId = c2236e.f4803h;
        this._anyGetterWriter = c2236e.f4801f;
        this._propertyFilterId = c2236e.f4802g;
        this._objectIdWriter = c2236e.f4804i;
        this._serializationShape = c2236e.f4797b.mo1812a(null).m1601e();
    }

    /* JADX INFO: renamed from: t */
    public static final C2234c[] m2051t(C2234c[] c2234cArr, AbstractC2352n abstractC2352n) {
        if (c2234cArr == null || c2234cArr.length == 0 || abstractC2352n == null || abstractC2352n == AbstractC2352n.f4961j) {
            return c2234cArr;
        }
        int length = c2234cArr.length;
        C2234c[] c2234cArr2 = new C2234c[length];
        for (int i = 0; i < length; i++) {
            C2234c c2234c = c2234cArr[i];
            if (c2234c != null) {
                c2234cArr2[i] = c2234c.mo1981g(abstractC2352n);
            }
        }
        return c2234cArr2;
    }

    /* JADX WARN: Code duplicated, block: B:73:0x0171  */
    @Override // p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i
    /* JADX INFO: renamed from: a */
    public AbstractC2364n<?> mo1997a(AbstractC2374x abstractC2374x, InterfaceC2206d interfaceC2206d) throws JsonMappingException {
        InterfaceC2081i.c cVarM1601e;
        Object objMo1783g;
        Set<String> set;
        Set<String> setM1617d;
        int i;
        AbstractC2278d abstractC2278dMo1987w;
        Object obj;
        C2174a0 c2174a0Mo1795s;
        AbstractC2165b abstractC2165bM2257v = abstractC2374x.m2257v();
        C2234c[] c2234cArr = null;
        AbstractC2188i member = (interfaceC2206d == null || abstractC2165bM2257v == null) ? null : interfaceC2206d.getMember();
        C2372v c2372v = abstractC2374x._config;
        InterfaceC2081i.d dVarM2074l = m2074l(abstractC2374x, interfaceC2206d, this._handledType);
        char c = 0;
        if (dVarM2074l == null || !dVarM2074l.m1605i()) {
            cVarM1601e = null;
        } else {
            cVarM1601e = dVarM2074l.m1601e();
            if (cVarM1601e != InterfaceC2081i.c.ANY && cVarM1601e != this._serializationShape) {
                if (this._beanType.m2219w()) {
                    int iOrdinal = cVarM1601e.ordinal();
                    if (iOrdinal == 5 || iOrdinal == 7 || iOrdinal == 8) {
                        c2372v.m2276n(this._beanType);
                        Class<?> cls = this._beanType._class;
                        return abstractC2374x.m2260y(new C2296m(C2344f.m2198a(abstractC2374x._config, cls), C2296m.m2068p(cls, dVarM2074l, true, null)), interfaceC2206d);
                    }
                } else if (cVarM1601e == InterfaceC2081i.c.NATURAL && ((!this._beanType.mo2122z() || !Map.class.isAssignableFrom(this._handledType)) && Map.Entry.class.isAssignableFrom(this._handledType))) {
                    AbstractC2360j abstractC2360jMo2144i = this._beanType.mo2144i(Map.Entry.class);
                    return abstractC2374x.m2260y(new C2259i(this._beanType, abstractC2360jMo2144i.m2217h(0), abstractC2360jMo2144i.m2217h(1), false, null, interfaceC2206d), interfaceC2206d);
                }
            }
        }
        C2260j c2260jM2031a = this._objectIdWriter;
        if (member != null) {
            setM1617d = abstractC2165bM2257v.mo1800x(c2372v, member).m1617d();
            set = abstractC2165bM2257v.mo1745A(c2372v, member)._included;
            C2174a0 c2174a0Mo1794r = abstractC2165bM2257v.mo1794r(member);
            if (c2174a0Mo1794r != null) {
                C2174a0 c2174a0Mo1795s2 = abstractC2165bM2257v.mo1795s(member, c2174a0Mo1794r);
                Class<? extends AbstractC2082i0<?>> cls2 = c2174a0Mo1795s2.f4629c;
                AbstractC2360j abstractC2360j = abstractC2374x.mo1940d().m2167i(abstractC2374x.m1938b(cls2), AbstractC2082i0.class)[0];
                if (cls2 == AbstractC2088l0.class) {
                    String str = c2174a0Mo1795s2.f4628b._simpleName;
                    int length = this._props.length;
                    i = 0;
                    while (true) {
                        if (i == length) {
                            AbstractC2360j abstractC2360j2 = this._beanType;
                            Object[] objArr = new Object[2];
                            objArr[c] = C2342d.m2189u(this._handledType);
                            objArr[1] = str == null ? "[null]" : C2342d.m2171c(str);
                            abstractC2374x.mo1942f(abstractC2360j2, String.format("Invalid Object Id definition for %s: cannot find property with name %s", objArr));
                            throw null;
                        }
                        C2234c c2234c = this._props[i];
                        if (str.equals(c2234c._name._value)) {
                            c2260jM2031a = C2260j.m2031a(c2234c._declaredType, null, new C2261k(c2174a0Mo1795s2, c2234c), c2174a0Mo1795s2.f4632f);
                            break;
                        }
                        i++;
                        c = 0;
                    }
                } else {
                    c2260jM2031a = C2260j.m2031a(abstractC2360j, c2174a0Mo1795s2.f4628b, abstractC2374x.m1941e(member, c2174a0Mo1795s2), c2174a0Mo1795s2.f4632f);
                }
                objMo1783g = abstractC2165bM2257v.mo1783g(member);
                if (objMo1783g != null || ((obj = this._propertyFilterId) != null && objMo1783g.equals(obj))) {
                    objMo1783g = null;
                }
            } else if (c2260jM2031a != null && (c2174a0Mo1795s = abstractC2165bM2257v.mo1795s(member, null)) != null) {
                c2260jM2031a = this._objectIdWriter;
                boolean z2 = c2174a0Mo1795s.f4632f;
                if (z2 != c2260jM2031a.f4822e) {
                    c2260jM2031a = new C2260j(c2260jM2031a.f4818a, c2260jM2031a.f4819b, c2260jM2031a.f4820c, c2260jM2031a.f4821d, z2);
                }
            }
            i = 0;
            objMo1783g = abstractC2165bM2257v.mo1783g(member);
            if (objMo1783g != null) {
                objMo1783g = null;
            } else {
                objMo1783g = null;
            }
        } else {
            objMo1783g = null;
            set = null;
            setM1617d = null;
            i = 0;
        }
        if (i > 0) {
            C2234c[] c2234cArr2 = this._props;
            C2234c[] c2234cArr3 = (C2234c[]) Arrays.copyOf(c2234cArr2, c2234cArr2.length);
            C2234c c2234c2 = c2234cArr3[i];
            System.arraycopy(c2234cArr3, 0, c2234cArr3, 1, i);
            c2234cArr3[0] = c2234c2;
            C2234c[] c2234cArr4 = this._filteredProps;
            if (c2234cArr4 != null) {
                c2234cArr = (C2234c[]) Arrays.copyOf(c2234cArr4, c2234cArr4.length);
                C2234c c2234c3 = c2234cArr[i];
                System.arraycopy(c2234cArr, 0, c2234cArr, 1, i);
                c2234cArr[0] = c2234c3;
            }
            abstractC2278dMo1987w = mo1989y(c2234cArr3, c2234cArr);
        } else {
            abstractC2278dMo1987w = this;
        }
        if (c2260jM2031a != null) {
            C2260j c2260j = new C2260j(c2260jM2031a.f4818a, c2260jM2031a.f4819b, c2260jM2031a.f4820c, abstractC2374x.m2255t(c2260jM2031a.f4818a, interfaceC2206d), c2260jM2031a.f4822e);
            if (c2260j != this._objectIdWriter) {
                abstractC2278dMo1987w = abstractC2278dMo1987w.mo1988x(c2260j);
            }
        }
        if ((setM1617d != null && !setM1617d.isEmpty()) || set != null) {
            abstractC2278dMo1987w = abstractC2278dMo1987w.mo1986v(setM1617d, set);
        }
        if (objMo1783g != null) {
            abstractC2278dMo1987w = abstractC2278dMo1987w.mo1987w(objMo1783g);
        }
        if (cVarM1601e == null) {
            cVarM1601e = this._serializationShape;
        }
        return cVarM1601e == InterfaceC2081i.c.ARRAY ? abstractC2278dMo1987w.mo1985s() : abstractC2278dMo1987w;
    }

    /* JADX WARN: Code duplicated, block: B:60:0x00b6  */
    @Override // p007b.p195g.p196a.p205c.p215g0.InterfaceC2246o
    /* JADX INFO: renamed from: b */
    public void mo2007b(AbstractC2374x abstractC2374x) throws JsonMappingException {
        C2234c c2234c;
        AbstractC2215g abstractC2215g;
        AbstractC2175b abstractC2175b;
        Object objMo1752H;
        AbstractC2364n<Object> abstractC2364n;
        C2234c c2234c2;
        C2234c[] c2234cArr = this._filteredProps;
        int length = c2234cArr == null ? 0 : c2234cArr.length;
        int length2 = this._props.length;
        for (int i = 0; i < length2; i++) {
            C2234c c2234c3 = this._props[i];
            if (!c2234c3._suppressNulls) {
                if (!(c2234c3._nullSerializer != null) && (abstractC2364n = abstractC2374x._nullValueSerializer) != null) {
                    c2234c3.mo1979e(abstractC2364n);
                    if (i < length && (c2234c2 = this._filteredProps[i]) != null) {
                        c2234c2.mo1979e(abstractC2364n);
                    }
                }
            }
            if (!(c2234c3._serializer != null)) {
                AbstractC2165b abstractC2165bM2257v = abstractC2374x.m2257v();
                AbstractC2364n<Object> abstractC2364nM2255t = null;
                if (abstractC2165bM2257v != null && (abstractC2175b = c2234c3._member) != null && (objMo1752H = abstractC2165bM2257v.mo1752H(abstractC2175b)) != null) {
                    InterfaceC2343e<Object, Object> interfaceC2343eM1939c = abstractC2374x.m1939c(c2234c3._member, objMo1752H);
                    AbstractC2360j abstractC2360jM2197a = interfaceC2343eM1939c.m2197a(abstractC2374x.mo1940d());
                    abstractC2364nM2255t = new C2291j0(interfaceC2343eM1939c, abstractC2360jM2197a, abstractC2360jM2197a.m2221y() ? null : abstractC2374x.m2255t(abstractC2360jM2197a, c2234c3));
                }
                if (abstractC2364nM2255t == null) {
                    AbstractC2360j abstractC2360j = c2234c3._cfgSerializationType;
                    if (abstractC2360j == null) {
                        abstractC2360j = c2234c3._declaredType;
                        if (!abstractC2360j.m2220x()) {
                            if (abstractC2360j.mo2104v() || abstractC2360j.mo2143g() > 0) {
                                c2234c3._nonTrivialBaseType = abstractC2360j;
                            }
                        }
                    }
                    abstractC2364nM2255t = abstractC2374x.m2255t(abstractC2360j, c2234c3);
                    if (abstractC2360j.mo2104v() && (abstractC2215g = (AbstractC2215g) abstractC2360j.mo2099k()._typeHandler) != null && (abstractC2364nM2255t instanceof AbstractC2239h)) {
                        AbstractC2239h abstractC2239h = (AbstractC2239h) abstractC2364nM2255t;
                        Objects.requireNonNull(abstractC2239h);
                        abstractC2364nM2255t = abstractC2239h.mo1995p(abstractC2215g);
                    }
                    if (i < length) {
                        c2234c3.mo1980f(abstractC2364nM2255t);
                    } else {
                        c2234c3.mo1980f(abstractC2364nM2255t);
                    }
                } else if (i < length || (c2234c = this._filteredProps[i]) == null) {
                    c2234c3.mo1980f(abstractC2364nM2255t);
                } else {
                    c2234c.mo1980f(abstractC2364nM2255t);
                }
            }
        }
        C2232a c2232a = this._anyGetterWriter;
        if (c2232a != null) {
            AbstractC2364n<?> abstractC2364n2 = c2232a.f4786c;
            if (abstractC2364n2 instanceof InterfaceC2240i) {
                AbstractC2364n<?> abstractC2364nM2260y = abstractC2374x.m2260y(abstractC2364n2, c2232a.f4784a);
                c2232a.f4786c = abstractC2364nM2260y;
                if (abstractC2364nM2260y instanceof C2310t) {
                    c2232a.f4787d = (C2310t) abstractC2364nM2260y;
                }
            }
        }
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: g */
    public void mo1808g(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2215g abstractC2215g) throws IOException {
        if (this._objectIdWriter != null) {
            abstractC2108d.mo1654e(obj);
            m2053p(obj, abstractC2108d, abstractC2374x, abstractC2215g);
            return;
        }
        abstractC2108d.mo1654e(obj);
        C2138b c2138bM2055r = m2055r(abstractC2215g, obj, EnumC2112h.START_OBJECT);
        abstractC2215g.mo1959e(abstractC2108d, c2138bM2055r);
        Object obj2 = this._propertyFilterId;
        if (obj2 == null) {
            m2056u(obj, abstractC2108d, abstractC2374x);
            abstractC2215g.mo1960f(abstractC2108d, c2138bM2055r);
        } else {
            if (this._filteredProps != null) {
                Class<?> cls = abstractC2374x._serializationView;
            }
            m2075m(abstractC2374x, obj2, obj);
            throw null;
        }
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: i */
    public boolean mo2052i() {
        return this._objectIdWriter != null;
    }

    /* JADX INFO: renamed from: p */
    public final void m2053p(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2215g abstractC2215g) throws IOException {
        C2260j c2260j = this._objectIdWriter;
        C2271u c2271uMo2005p = abstractC2374x.mo2005p(obj, c2260j.f4820c);
        if (c2271uMo2005p.m2043a(abstractC2108d, abstractC2374x, c2260j)) {
            return;
        }
        if (c2271uMo2005p.f4848b == null) {
            c2271uMo2005p.f4848b = c2271uMo2005p.f4847a.mo1610c(obj);
        }
        Object obj2 = c2271uMo2005p.f4848b;
        if (c2260j.f4822e) {
            c2260j.f4821d.mo1807f(obj2, abstractC2108d, abstractC2374x);
            return;
        }
        C2260j c2260j2 = this._objectIdWriter;
        C2138b c2138bM2055r = m2055r(abstractC2215g, obj, EnumC2112h.START_OBJECT);
        abstractC2215g.mo1959e(abstractC2108d, c2138bM2055r);
        c2271uMo2005p.f4849c = true;
        Objects.requireNonNull(abstractC2108d);
        InterfaceC2115k interfaceC2115k = c2260j2.f4819b;
        if (interfaceC2115k != null) {
            abstractC2108d.mo1665x(interfaceC2115k);
            c2260j2.f4821d.mo1807f(c2271uMo2005p.f4848b, abstractC2108d, abstractC2374x);
        }
        Object obj3 = this._propertyFilterId;
        if (obj3 != null) {
            m2075m(abstractC2374x, obj3, obj);
            throw null;
        }
        m2056u(obj, abstractC2108d, abstractC2374x);
        abstractC2215g.mo1960f(abstractC2108d, c2138bM2055r);
    }

    /* JADX INFO: renamed from: q */
    public final void m2054q(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, boolean z2) throws IOException {
        C2260j c2260j = this._objectIdWriter;
        C2271u c2271uMo2005p = abstractC2374x.mo2005p(obj, c2260j.f4820c);
        if (c2271uMo2005p.m2043a(abstractC2108d, abstractC2374x, c2260j)) {
            return;
        }
        if (c2271uMo2005p.f4848b == null) {
            c2271uMo2005p.f4848b = c2271uMo2005p.f4847a.mo1610c(obj);
        }
        Object obj2 = c2271uMo2005p.f4848b;
        if (c2260j.f4822e) {
            c2260j.f4821d.mo1807f(obj2, abstractC2108d, abstractC2374x);
            return;
        }
        if (z2) {
            abstractC2108d.mo1653d0(obj);
        }
        c2271uMo2005p.f4849c = true;
        InterfaceC2115k interfaceC2115k = c2260j.f4819b;
        if (interfaceC2115k != null) {
            abstractC2108d.mo1665x(interfaceC2115k);
            c2260j.f4821d.mo1807f(c2271uMo2005p.f4848b, abstractC2108d, abstractC2374x);
        }
        Object obj3 = this._propertyFilterId;
        if (obj3 != null) {
            m2075m(abstractC2374x, obj3, obj);
            throw null;
        }
        m2056u(obj, abstractC2108d, abstractC2374x);
        if (z2) {
            abstractC2108d.mo1664u();
        }
    }

    /* JADX INFO: renamed from: r */
    public final C2138b m2055r(AbstractC2215g abstractC2215g, Object obj, EnumC2112h enumC2112h) {
        AbstractC2188i abstractC2188i = this._typeId;
        if (abstractC2188i == null) {
            return abstractC2215g.m1958d(obj, enumC2112h);
        }
        Object objMo1889j = abstractC2188i.mo1889j(obj);
        if (objMo1889j == null) {
            objMo1889j = "";
        }
        C2138b c2138bM1958d = abstractC2215g.m1958d(obj, enumC2112h);
        c2138bM1958d.f4586c = objMo1889j;
        return c2138bM1958d;
    }

    /* JADX INFO: renamed from: s */
    public abstract AbstractC2278d mo1985s();

    /* JADX INFO: renamed from: u */
    public void m2056u(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        C2234c[] c2234cArr = this._filteredProps;
        if (c2234cArr == null || abstractC2374x._serializationView == null) {
            c2234cArr = this._props;
        }
        int i = 0;
        try {
            int length = c2234cArr.length;
            while (i < length) {
                C2234c c2234c = c2234cArr[i];
                if (c2234c != null) {
                    c2234c.mo1983i(obj, abstractC2108d, abstractC2374x);
                }
                i++;
            }
            C2232a c2232a = this._anyGetterWriter;
            if (c2232a != null) {
                c2232a.m1970a(obj, abstractC2108d, abstractC2374x);
            }
        } catch (Exception e) {
            m2077o(abstractC2374x, e, obj, i != c2234cArr.length ? c2234cArr[i]._name._value : "[anySetter]");
            throw null;
        } catch (StackOverflowError e2) {
            JsonMappingException jsonMappingException = new JsonMappingException(abstractC2108d, "Infinite recursion (StackOverflowError)", e2);
            jsonMappingException.m8743e(new JsonMappingException.C10677a(obj, i != c2234cArr.length ? c2234cArr[i]._name._value : "[anySetter]"));
            throw jsonMappingException;
        }
    }

    /* JADX INFO: renamed from: v */
    public abstract AbstractC2278d mo1986v(Set<String> set, Set<String> set2);

    /* JADX INFO: renamed from: w */
    public abstract AbstractC2278d mo1987w(Object obj);

    /* JADX INFO: renamed from: x */
    public abstract AbstractC2278d mo1988x(C2260j c2260j);

    /* JADX INFO: renamed from: y */
    public abstract AbstractC2278d mo1989y(C2234c[] c2234cArr, C2234c[] c2234cArr2);

    public AbstractC2278d(AbstractC2278d abstractC2278d, C2234c[] c2234cArr, C2234c[] c2234cArr2) {
        super(abstractC2278d._handledType);
        this._beanType = abstractC2278d._beanType;
        this._props = c2234cArr;
        this._filteredProps = c2234cArr2;
        this._typeId = abstractC2278d._typeId;
        this._anyGetterWriter = abstractC2278d._anyGetterWriter;
        this._objectIdWriter = abstractC2278d._objectIdWriter;
        this._propertyFilterId = abstractC2278d._propertyFilterId;
        this._serializationShape = abstractC2278d._serializationShape;
    }

    public AbstractC2278d(AbstractC2278d abstractC2278d, C2260j c2260j, Object obj) {
        super(abstractC2278d._handledType);
        this._beanType = abstractC2278d._beanType;
        this._props = abstractC2278d._props;
        this._filteredProps = abstractC2278d._filteredProps;
        this._typeId = abstractC2278d._typeId;
        this._anyGetterWriter = abstractC2278d._anyGetterWriter;
        this._objectIdWriter = c2260j;
        this._propertyFilterId = obj;
        this._serializationShape = abstractC2278d._serializationShape;
    }

    public AbstractC2278d(AbstractC2278d abstractC2278d, Set<String> set, Set<String> set2) {
        super(abstractC2278d._handledType);
        this._beanType = abstractC2278d._beanType;
        C2234c[] c2234cArr = abstractC2278d._props;
        C2234c[] c2234cArr2 = abstractC2278d._filteredProps;
        int length = c2234cArr.length;
        ArrayList arrayList = new ArrayList(length);
        ArrayList arrayList2 = c2234cArr2 == null ? null : new ArrayList(length);
        for (int i = 0; i < length; i++) {
            C2234c c2234c = c2234cArr[i];
            if (!C1460d.m502b2(c2234c._name._value, set, set2)) {
                arrayList.add(c2234c);
                if (c2234cArr2 != null) {
                    arrayList2.add(c2234cArr2[i]);
                }
            }
        }
        this._props = (C2234c[]) arrayList.toArray(new C2234c[arrayList.size()]);
        this._filteredProps = arrayList2 != null ? (C2234c[]) arrayList2.toArray(new C2234c[arrayList2.size()]) : null;
        this._typeId = abstractC2278d._typeId;
        this._anyGetterWriter = abstractC2278d._anyGetterWriter;
        this._objectIdWriter = abstractC2278d._objectIdWriter;
        this._propertyFilterId = abstractC2278d._propertyFilterId;
        this._serializationShape = abstractC2278d._serializationShape;
    }
}
