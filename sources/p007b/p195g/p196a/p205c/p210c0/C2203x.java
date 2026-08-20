package p007b.p195g.p196a.p205c.p210c0;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import p007b.p195g.p196a.p197a.AbstractC2086k0;
import p007b.p195g.p196a.p197a.EnumC2080h0;
import p007b.p195g.p196a.p197a.InterfaceC2065a;
import p007b.p195g.p196a.p197a.InterfaceC2066a0;
import p007b.p195g.p196a.p197a.InterfaceC2067b;
import p007b.p195g.p196a.p197a.InterfaceC2068b0;
import p007b.p195g.p196a.p197a.InterfaceC2069c;
import p007b.p195g.p196a.p197a.InterfaceC2070c0;
import p007b.p195g.p196a.p197a.InterfaceC2071d;
import p007b.p195g.p196a.p197a.InterfaceC2072d0;
import p007b.p195g.p196a.p197a.InterfaceC2073e;
import p007b.p195g.p196a.p197a.InterfaceC2074e0;
import p007b.p195g.p196a.p197a.InterfaceC2075f;
import p007b.p195g.p196a.p197a.InterfaceC2076f0;
import p007b.p195g.p196a.p197a.InterfaceC2077g;
import p007b.p195g.p196a.p197a.InterfaceC2078g0;
import p007b.p195g.p196a.p197a.InterfaceC2079h;
import p007b.p195g.p196a.p197a.InterfaceC2081i;
import p007b.p195g.p196a.p197a.InterfaceC2083j;
import p007b.p195g.p196a.p197a.InterfaceC2085k;
import p007b.p195g.p196a.p197a.InterfaceC2087l;
import p007b.p195g.p196a.p197a.InterfaceC2089m;
import p007b.p195g.p196a.p197a.InterfaceC2091n;
import p007b.p195g.p196a.p197a.InterfaceC2093o;
import p007b.p195g.p196a.p197a.InterfaceC2094p;
import p007b.p195g.p196a.p197a.InterfaceC2095q;
import p007b.p195g.p196a.p197a.InterfaceC2096r;
import p007b.p195g.p196a.p197a.InterfaceC2097s;
import p007b.p195g.p196a.p197a.InterfaceC2098t;
import p007b.p195g.p196a.p197a.InterfaceC2099u;
import p007b.p195g.p196a.p197a.InterfaceC2100v;
import p007b.p195g.p196a.p197a.InterfaceC2101w;
import p007b.p195g.p196a.p197a.InterfaceC2102x;
import p007b.p195g.p196a.p197a.InterfaceC2103y;
import p007b.p195g.p196a.p197a.InterfaceC2104z;
import p007b.p195g.p196a.p205c.AbstractC2165b;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.C2369s;
import p007b.p195g.p196a.p205c.C2370t;
import p007b.p195g.p196a.p205c.EnumC2366p;
import p007b.p195g.p196a.p205c.p209b0.AbstractC2168c;
import p007b.p195g.p196a.p205c.p212e0.C2210b;
import p007b.p195g.p196a.p205c.p212e0.InterfaceC2213e;
import p007b.p195g.p196a.p205c.p212e0.InterfaceC2214f;
import p007b.p195g.p196a.p205c.p212e0.p213h.C2225j;
import p007b.p195g.p196a.p205c.p215g0.AbstractC2250s;
import p007b.p195g.p196a.p205c.p215g0.C2234c;
import p007b.p195g.p196a.p205c.p215g0.p216t.C2251a;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2281e0;
import p007b.p195g.p196a.p205c.p218h0.C2324c;
import p007b.p195g.p196a.p205c.p218h0.C2327f;
import p007b.p195g.p196a.p205c.p218h0.C2335n;
import p007b.p195g.p196a.p205c.p219i0.AbstractC2352n;
import p007b.p195g.p196a.p205c.p219i0.C2342d;
import p007b.p195g.p196a.p205c.p219i0.C2346h;
import p007b.p195g.p196a.p205c.p219i0.C2349k;
import p007b.p195g.p196a.p205c.p219i0.C2350l;
import p007b.p195g.p196a.p205c.p219i0.C2351m;
import p007b.p195g.p196a.p205c.p219i0.C2355q;
import p007b.p195g.p196a.p205c.p219i0.InterfaceC2343e;
import p007b.p195g.p196a.p205c.p220y.InterfaceC2376b;
import p007b.p195g.p196a.p205c.p220y.InterfaceC2377c;
import p007b.p195g.p196a.p205c.p220y.InterfaceC2378d;
import p007b.p195g.p196a.p205c.p220y.InterfaceC2379e;
import p007b.p195g.p196a.p205c.p220y.InterfaceC2380f;
import p007b.p195g.p196a.p205c.p220y.InterfaceC2381g;
import p007b.p195g.p196a.p205c.p221z.AbstractC2394l;

/* JADX INFO: renamed from: b.g.a.c.c0.x */
/* JADX INFO: compiled from: JacksonAnnotationIntrospector.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2203x extends AbstractC2165b implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final Class<? extends Annotation>[] f4757j = {InterfaceC2379e.class, InterfaceC2078g0.class, InterfaceC2081i.class, InterfaceC2070c0.class, InterfaceC2102x.class, InterfaceC2074e0.class, InterfaceC2075f.class, InterfaceC2097s.class};

    /* JADX INFO: renamed from: k */
    public static final Class<? extends Annotation>[] f4758k = {InterfaceC2377c.class, InterfaceC2078g0.class, InterfaceC2081i.class, InterfaceC2070c0.class, InterfaceC2074e0.class, InterfaceC2075f.class, InterfaceC2097s.class, InterfaceC2098t.class};

    /* JADX INFO: renamed from: l */
    public static final AbstractC2168c f4759l;
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: m */
    public transient C2346h<Class<?>, Boolean> f4760m = new C2346h<>(48, 48);
    public boolean _cfgConstructorPropertiesImpliesCreator = true;

    static {
        AbstractC2168c abstractC2168c;
        try {
            abstractC2168c = AbstractC2168c.f4622a;
        } catch (Throwable unused) {
            abstractC2168c = null;
        }
        f4759l = abstractC2168c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.HashSet] */
    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: A */
    public InterfaceC2095q.a mo1745A(AbstractC2394l<?> abstractC2394l, AbstractC2175b abstractC2175b) {
        ?? EmptySet;
        InterfaceC2095q interfaceC2095q = (InterfaceC2095q) abstractC2175b.mo1818b(InterfaceC2095q.class);
        if (interfaceC2095q == null) {
            return InterfaceC2095q.a.f4437j;
        }
        String[] strArrValue = interfaceC2095q.value();
        if (strArrValue == null || strArrValue.length == 0) {
            EmptySet = Collections.emptySet();
        } else {
            EmptySet = new HashSet(strArrValue.length);
            for (String str : strArrValue) {
                EmptySet.add(str);
            }
        }
        return new InterfaceC2095q.a(EmptySet);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: B */
    public Integer mo1746B(AbstractC2175b abstractC2175b) {
        int iIndex;
        InterfaceC2099u interfaceC2099u = (InterfaceC2099u) abstractC2175b.mo1818b(InterfaceC2099u.class);
        if (interfaceC2099u == null || (iIndex = interfaceC2099u.index()) == -1) {
            return null;
        }
        return Integer.valueOf(iIndex);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: C */
    public InterfaceC2214f<?> mo1747C(AbstractC2394l<?> abstractC2394l, AbstractC2188i abstractC2188i, AbstractC2360j abstractC2360j) {
        if (abstractC2360j.mo2104v() || abstractC2360j.mo1728b()) {
            return null;
        }
        return m1934h0(abstractC2394l, abstractC2188i, abstractC2360j);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: D */
    public AbstractC2165b.a mo1748D(AbstractC2188i abstractC2188i) {
        InterfaceC2097s interfaceC2097s = (InterfaceC2097s) abstractC2188i.mo1818b(InterfaceC2097s.class);
        if (interfaceC2097s != null) {
            return new AbstractC2165b.a(1, interfaceC2097s.value());
        }
        InterfaceC2075f interfaceC2075f = (InterfaceC2075f) abstractC2188i.mo1818b(InterfaceC2075f.class);
        if (interfaceC2075f != null) {
            return new AbstractC2165b.a(2, interfaceC2075f.value());
        }
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: E */
    public C2370t mo1749E(AbstractC2394l<?> abstractC2394l, C2185g c2185g, C2370t c2370t) {
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: F */
    public C2370t mo1750F(C2177c c2177c) {
        InterfaceC2103y interfaceC2103y = (InterfaceC2103y) c2177c.mo1818b(InterfaceC2103y.class);
        if (interfaceC2103y == null) {
            return null;
        }
        String strNamespace = interfaceC2103y.namespace();
        return C2370t.m2228b(interfaceC2103y.value(), (strNamespace == null || !strNamespace.isEmpty()) ? strNamespace : null);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: G */
    public Object mo1751G(AbstractC2188i abstractC2188i) {
        Class<?> clsM1933g0;
        InterfaceC2379e interfaceC2379e = (InterfaceC2379e) abstractC2188i.mo1818b(InterfaceC2379e.class);
        if (interfaceC2379e == null || (clsM1933g0 = m1933g0(interfaceC2379e.contentConverter())) == null || clsM1933g0 == InterfaceC2343e.a.class) {
            return null;
        }
        return clsM1933g0;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: H */
    public Object mo1752H(AbstractC2175b abstractC2175b) {
        Class<?> clsM1933g0;
        InterfaceC2379e interfaceC2379e = (InterfaceC2379e) abstractC2175b.mo1818b(InterfaceC2379e.class);
        if (interfaceC2379e == null || (clsM1933g0 = m1933g0(interfaceC2379e.converter())) == null || clsM1933g0 == InterfaceC2343e.a.class) {
            return null;
        }
        return clsM1933g0;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: I */
    public String[] mo1753I(C2177c c2177c) {
        InterfaceC2101w interfaceC2101w = (InterfaceC2101w) c2177c.mo1818b(InterfaceC2101w.class);
        if (interfaceC2101w == null) {
            return null;
        }
        return interfaceC2101w.value();
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: J */
    public Boolean mo1754J(AbstractC2175b abstractC2175b) {
        InterfaceC2101w interfaceC2101w = (InterfaceC2101w) abstractC2175b.mo1818b(InterfaceC2101w.class);
        if (interfaceC2101w == null || !interfaceC2101w.alphabetic()) {
            return null;
        }
        return Boolean.TRUE;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: K */
    public InterfaceC2379e.b mo1755K(AbstractC2175b abstractC2175b) {
        InterfaceC2379e interfaceC2379e = (InterfaceC2379e) abstractC2175b.mo1818b(InterfaceC2379e.class);
        if (interfaceC2379e == null) {
            return null;
        }
        return interfaceC2379e.typing();
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: L */
    public Object mo1756L(AbstractC2175b abstractC2175b) {
        Class<? extends AbstractC2364n> clsUsing;
        InterfaceC2379e interfaceC2379e = (InterfaceC2379e) abstractC2175b.mo1818b(InterfaceC2379e.class);
        if (interfaceC2379e != null && (clsUsing = interfaceC2379e.using()) != AbstractC2364n.a.class) {
            return clsUsing;
        }
        InterfaceC2102x interfaceC2102x = (InterfaceC2102x) abstractC2175b.mo1818b(InterfaceC2102x.class);
        if (interfaceC2102x == null || !interfaceC2102x.value()) {
            return null;
        }
        return new C2281e0(abstractC2175b.mo1820d());
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: M */
    public InterfaceC2104z.a mo1757M(AbstractC2175b abstractC2175b) {
        InterfaceC2104z interfaceC2104z = (InterfaceC2104z) abstractC2175b.mo1818b(InterfaceC2104z.class);
        if (interfaceC2104z == null) {
            return InterfaceC2104z.a.f4443j;
        }
        EnumC2080h0 enumC2080h0Nulls = interfaceC2104z.nulls();
        EnumC2080h0 enumC2080h0ContentNulls = interfaceC2104z.contentNulls();
        EnumC2080h0 enumC2080h0 = EnumC2080h0.DEFAULT;
        if (enumC2080h0Nulls == null) {
            enumC2080h0Nulls = enumC2080h0;
        }
        if (enumC2080h0ContentNulls == null) {
            enumC2080h0ContentNulls = enumC2080h0;
        }
        return enumC2080h0Nulls == enumC2080h0 && enumC2080h0ContentNulls == enumC2080h0 ? InterfaceC2104z.a.f4443j : new InterfaceC2104z.a(enumC2080h0Nulls, enumC2080h0ContentNulls);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: N */
    public List<C2210b> mo1758N(AbstractC2175b abstractC2175b) {
        InterfaceC2066a0 interfaceC2066a0 = (InterfaceC2066a0) abstractC2175b.mo1818b(InterfaceC2066a0.class);
        if (interfaceC2066a0 == null) {
            return null;
        }
        InterfaceC2066a0.a[] aVarArrValue = interfaceC2066a0.value();
        ArrayList arrayList = new ArrayList(aVarArrValue.length);
        for (InterfaceC2066a0.a aVar : aVarArrValue) {
            arrayList.add(new C2210b(aVar.value(), aVar.name()));
            for (String str : aVar.names()) {
                arrayList.add(new C2210b(aVar.value(), str));
            }
        }
        return arrayList;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: O */
    public String mo1759O(C2177c c2177c) {
        InterfaceC2072d0 interfaceC2072d0 = (InterfaceC2072d0) c2177c.mo1818b(InterfaceC2072d0.class);
        if (interfaceC2072d0 == null) {
            return null;
        }
        return interfaceC2072d0.value();
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: P */
    public InterfaceC2214f<?> mo1760P(AbstractC2394l<?> abstractC2394l, C2177c c2177c, AbstractC2360j abstractC2360j) {
        return m1934h0(abstractC2394l, c2177c, abstractC2360j);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: Q */
    public AbstractC2352n mo1761Q(AbstractC2188i abstractC2188i) {
        InterfaceC2074e0 interfaceC2074e0 = (InterfaceC2074e0) abstractC2188i.mo1818b(InterfaceC2074e0.class);
        if (interfaceC2074e0 == null || !interfaceC2074e0.enabled()) {
            return null;
        }
        String strPrefix = interfaceC2074e0.prefix();
        String strSuffix = interfaceC2074e0.suffix();
        boolean z2 = false;
        boolean z3 = (strPrefix == null || strPrefix.isEmpty()) ? false : true;
        if (strSuffix != null && !strSuffix.isEmpty()) {
            z2 = true;
        }
        if (z3) {
            return z2 ? new C2349k(strPrefix, strSuffix) : new C2350l(strPrefix);
        }
        return z2 ? new C2351m(strSuffix) : AbstractC2352n.f4961j;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: R */
    public Class<?>[] mo1762R(AbstractC2175b abstractC2175b) {
        InterfaceC2078g0 interfaceC2078g0 = (InterfaceC2078g0) abstractC2175b.mo1818b(InterfaceC2078g0.class);
        if (interfaceC2078g0 == null) {
            return null;
        }
        return interfaceC2078g0.value();
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: S */
    public Boolean mo1763S(AbstractC2175b abstractC2175b) {
        InterfaceC2069c interfaceC2069c = (InterfaceC2069c) abstractC2175b.mo1818b(InterfaceC2069c.class);
        if (interfaceC2069c == null) {
            return null;
        }
        return Boolean.valueOf(interfaceC2069c.enabled());
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    @Deprecated
    /* JADX INFO: renamed from: T */
    public boolean mo1764T(C2189j c2189j) {
        return c2189j.m1904k(InterfaceC2069c.class);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: U */
    public Boolean mo1765U(AbstractC2175b abstractC2175b) {
        InterfaceC2071d interfaceC2071d = (InterfaceC2071d) abstractC2175b.mo1818b(InterfaceC2071d.class);
        if (interfaceC2071d == null) {
            return null;
        }
        return Boolean.valueOf(interfaceC2071d.enabled());
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: V */
    public Boolean mo1766V(AbstractC2394l<?> abstractC2394l, AbstractC2175b abstractC2175b) {
        InterfaceC2096r interfaceC2096r = (InterfaceC2096r) abstractC2175b.mo1818b(InterfaceC2096r.class);
        if (interfaceC2096r == null) {
            return null;
        }
        return Boolean.valueOf(interfaceC2096r.value());
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: W */
    public Boolean mo1767W(AbstractC2175b abstractC2175b) {
        InterfaceC2076f0 interfaceC2076f0 = (InterfaceC2076f0) abstractC2175b.mo1818b(InterfaceC2076f0.class);
        if (interfaceC2076f0 == null) {
            return null;
        }
        return Boolean.valueOf(interfaceC2076f0.value());
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    @Deprecated
    /* JADX INFO: renamed from: X */
    public boolean mo1768X(C2189j c2189j) {
        InterfaceC2076f0 interfaceC2076f0 = (InterfaceC2076f0) c2189j.mo1818b(InterfaceC2076f0.class);
        return interfaceC2076f0 != null && interfaceC2076f0.value();
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    @Deprecated
    /* JADX INFO: renamed from: Y */
    public boolean mo1769Y(AbstractC2175b abstractC2175b) {
        AbstractC2168c abstractC2168c;
        Boolean boolMo1806c;
        InterfaceC2077g interfaceC2077g = (InterfaceC2077g) abstractC2175b.mo1818b(InterfaceC2077g.class);
        if (interfaceC2077g != null) {
            return interfaceC2077g.mode() != InterfaceC2077g.a.DISABLED;
        }
        if (!this._cfgConstructorPropertiesImpliesCreator || !(abstractC2175b instanceof C2181e) || (abstractC2168c = f4759l) == null || (boolMo1806c = abstractC2168c.mo1806c(abstractC2175b)) == null) {
            return false;
        }
        return boolMo1806c.booleanValue();
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: Z */
    public boolean mo1770Z(AbstractC2188i abstractC2188i) {
        Boolean boolMo1805b;
        InterfaceC2089m interfaceC2089m = (InterfaceC2089m) abstractC2188i.mo1818b(InterfaceC2089m.class);
        if (interfaceC2089m != null) {
            return interfaceC2089m.value();
        }
        AbstractC2168c abstractC2168c = f4759l;
        if (abstractC2168c == null || (boolMo1805b = abstractC2168c.mo1805b(abstractC2188i)) == null) {
            return false;
        }
        return boolMo1805b.booleanValue();
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: a */
    public void mo1771a(AbstractC2394l<?> abstractC2394l, C2177c c2177c, List<C2234c> list) {
        InterfaceC2376b interfaceC2376b = (InterfaceC2376b) c2177c.f4663t.mo1915a(InterfaceC2376b.class);
        if (interfaceC2376b == null) {
            return;
        }
        boolean zPrepend = interfaceC2376b.prepend();
        InterfaceC2376b.a[] aVarArrAttrs = interfaceC2376b.attrs();
        int length = aVarArrAttrs.length;
        C2324c c2324c = null;
        AbstractC2360j abstractC2360jM2160b = null;
        int i = 0;
        while (i < length) {
            if (abstractC2360jM2160b == null) {
                abstractC2360jM2160b = abstractC2394l._base._typeFactory.m2160b(c2324c, Object.class, C2335n.f4926l);
            }
            InterfaceC2376b.a aVar = aVarArrAttrs[i];
            C2369s c2369s = aVar.required() ? C2369s.f5025j : C2369s.f5026k;
            String strValue = aVar.value();
            C2370t c2370tM1936j0 = m1936j0(aVar.propName(), aVar.propNamespace());
            if (!c2370tM1936j0.m2229c()) {
                c2370tM1936j0 = C2370t.m2227a(strValue);
            }
            C2251a c2251a = new C2251a(strValue, C2355q.m2203w(abstractC2394l, new C2184f0(c2177c, c2177c.f4655l, strValue, abstractC2360jM2160b), c2370tM1936j0, c2369s, aVar.include()), c2177c.f4663t, abstractC2360jM2160b);
            if (zPrepend) {
                list.add(i, c2251a);
            } else {
                list.add(c2251a);
            }
            i++;
            c2324c = null;
        }
        InterfaceC2376b.b[] bVarArrProps = interfaceC2376b.props();
        int length2 = bVarArrProps.length;
        for (int i2 = 0; i2 < length2; i2++) {
            InterfaceC2376b.b bVar = bVarArrProps[i2];
            C2369s c2369s2 = bVar.required() ? C2369s.f5025j : C2369s.f5026k;
            C2370t c2370tM1936j1 = m1936j0(bVar.name(), bVar.namespace());
            AbstractC2360j abstractC2360jM2266d = abstractC2394l.m2266d(bVar.type());
            C2355q c2355qM2203w = C2355q.m2203w(abstractC2394l, new C2184f0(c2177c, c2177c.f4655l, c2370tM1936j1._simpleName, abstractC2360jM2266d), c2370tM1936j1, c2369s2, bVar.include());
            Class<? extends AbstractC2250s> clsValue = bVar.value();
            Objects.requireNonNull(abstractC2394l._base);
            AbstractC2250s abstractC2250sMo2018k = ((AbstractC2250s) C2342d.m2175g(clsValue, abstractC2394l.m2265b())).mo2018k(abstractC2394l, c2177c, c2355qM2203w, abstractC2360jM2266d);
            if (zPrepend) {
                list.add(i2, abstractC2250sMo2018k);
            } else {
                list.add(abstractC2250sMo2018k);
            }
        }
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: a0 */
    public Boolean mo1772a0(AbstractC2188i abstractC2188i) {
        InterfaceC2099u interfaceC2099u = (InterfaceC2099u) abstractC2188i.mo1818b(InterfaceC2099u.class);
        if (interfaceC2099u != null) {
            return Boolean.valueOf(interfaceC2099u.required());
        }
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: b */
    public InterfaceC2186g0<?> mo1773b(C2177c c2177c, InterfaceC2186g0<?> interfaceC2186g0) {
        InterfaceC2073e interfaceC2073e = (InterfaceC2073e) c2177c.mo1818b(InterfaceC2073e.class);
        if (interfaceC2073e == null) {
            return interfaceC2186g0;
        }
        InterfaceC2186g0.a aVar = (InterfaceC2186g0.a) interfaceC2186g0;
        Objects.requireNonNull(aVar);
        return aVar.m1899b(aVar.m1898a(aVar._getterMinLevel, interfaceC2073e.getterVisibility()), aVar.m1898a(aVar._isGetterMinLevel, interfaceC2073e.isGetterVisibility()), aVar.m1898a(aVar._setterMinLevel, interfaceC2073e.setterVisibility()), aVar.m1898a(aVar._creatorMinLevel, interfaceC2073e.creatorVisibility()), aVar.m1898a(aVar._fieldMinLevel, interfaceC2073e.fieldVisibility()));
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: b0 */
    public boolean mo1774b0(Annotation annotation) {
        Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
        Boolean boolValueOf = this.f4760m.get(clsAnnotationType);
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(clsAnnotationType.getAnnotation(InterfaceC2065a.class) != null);
            this.f4760m.putIfAbsent(clsAnnotationType, boolValueOf);
        }
        return boolValueOf.booleanValue();
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: c */
    public Object mo1775c(AbstractC2175b abstractC2175b) {
        Class<? extends AbstractC2364n> clsContentUsing;
        InterfaceC2379e interfaceC2379e = (InterfaceC2379e) abstractC2175b.mo1818b(InterfaceC2379e.class);
        if (interfaceC2379e == null || (clsContentUsing = interfaceC2379e.contentUsing()) == AbstractC2364n.a.class) {
            return null;
        }
        return clsContentUsing;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: c0 */
    public Boolean mo1776c0(C2177c c2177c) {
        InterfaceC2093o interfaceC2093o = (InterfaceC2093o) c2177c.mo1818b(InterfaceC2093o.class);
        if (interfaceC2093o == null) {
            return null;
        }
        return Boolean.valueOf(interfaceC2093o.value());
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: d */
    public InterfaceC2077g.a mo1777d(AbstractC2394l<?> abstractC2394l, AbstractC2175b abstractC2175b) {
        AbstractC2168c abstractC2168c;
        Boolean boolMo1806c;
        InterfaceC2077g interfaceC2077g = (InterfaceC2077g) abstractC2175b.mo1818b(InterfaceC2077g.class);
        if (interfaceC2077g != null) {
            return interfaceC2077g.mode();
        }
        if (this._cfgConstructorPropertiesImpliesCreator && abstractC2394l.m2279q(EnumC2366p.INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES) && (abstractC2175b instanceof C2181e) && (abstractC2168c = f4759l) != null && (boolMo1806c = abstractC2168c.mo1806c(abstractC2175b)) != null && boolMo1806c.booleanValue()) {
            return InterfaceC2077g.a.PROPERTIES;
        }
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: d0 */
    public Boolean mo1778d0(AbstractC2188i abstractC2188i) {
        return Boolean.valueOf(abstractC2188i.m1904k(InterfaceC2068b0.class));
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    @Deprecated
    /* JADX INFO: renamed from: e */
    public InterfaceC2077g.a mo1779e(AbstractC2175b abstractC2175b) {
        InterfaceC2077g interfaceC2077g = (InterfaceC2077g) abstractC2175b.mo1818b(InterfaceC2077g.class);
        if (interfaceC2077g == null) {
            return null;
        }
        return interfaceC2077g.mode();
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: e0 */
    public AbstractC2360j mo1780e0(AbstractC2394l<?> abstractC2394l, AbstractC2175b abstractC2175b, AbstractC2360j abstractC2360j) throws JsonMappingException {
        AbstractC2360j abstractC2360jMo2129M;
        AbstractC2360j abstractC2360jMo2129M2;
        C2335n c2335n = abstractC2394l._base._typeFactory;
        InterfaceC2379e interfaceC2379e = (InterfaceC2379e) abstractC2175b.mo1818b(InterfaceC2379e.class);
        Class<?> clsM1933g0 = interfaceC2379e == null ? null : m1933g0(interfaceC2379e.m2262as());
        if (clsM1933g0 != null) {
            Class<?> cls = abstractC2360j._class;
            if (cls == clsM1933g0) {
                abstractC2360j = abstractC2360j.mo2129M();
            } else {
                try {
                    if (clsM1933g0.isAssignableFrom(cls)) {
                        abstractC2360j = c2335n.m2165g(abstractC2360j, clsM1933g0);
                    } else if (cls.isAssignableFrom(clsM1933g0)) {
                        abstractC2360j = c2335n.m2166h(abstractC2360j, clsM1933g0, false);
                    } else {
                        if (!m1935i0(cls, clsM1933g0)) {
                            throw new JsonMappingException(null, String.format("Cannot refine serialization type %s into %s; types not related", abstractC2360j, clsM1933g0.getName()));
                        }
                        abstractC2360j = abstractC2360j.mo2129M();
                    }
                } catch (IllegalArgumentException e) {
                    throw new JsonMappingException(null, String.format("Failed to widen type %s with annotation (value %s), from '%s': %s", abstractC2360j, clsM1933g0.getName(), abstractC2175b.mo1819c(), e.getMessage()), e);
                }
            }
        }
        if (abstractC2360j.mo2122z()) {
            AbstractC2360j abstractC2360jMo2121o = abstractC2360j.mo2121o();
            Class<?> clsM1933g1 = interfaceC2379e == null ? null : m1933g0(interfaceC2379e.keyAs());
            if (clsM1933g1 != null) {
                Class<?> cls2 = abstractC2360jMo2121o._class;
                if (cls2 == clsM1933g1) {
                    abstractC2360jMo2129M2 = abstractC2360jMo2121o.mo2129M();
                } else {
                    try {
                        if (clsM1933g1.isAssignableFrom(cls2)) {
                            abstractC2360jMo2129M2 = c2335n.m2165g(abstractC2360jMo2121o, clsM1933g1);
                        } else if (cls2.isAssignableFrom(clsM1933g1)) {
                            abstractC2360jMo2129M2 = c2335n.m2166h(abstractC2360jMo2121o, clsM1933g1, false);
                        } else {
                            if (!m1935i0(cls2, clsM1933g1)) {
                                throw new JsonMappingException(null, String.format("Cannot refine serialization key type %s into %s; types not related", abstractC2360jMo2121o, clsM1933g1.getName()));
                            }
                            abstractC2360jMo2129M2 = abstractC2360jMo2121o.mo2129M();
                        }
                    } catch (IllegalArgumentException e2) {
                        throw new JsonMappingException(null, String.format("Failed to widen key type of %s with concrete-type annotation (value %s), from '%s': %s", abstractC2360j, clsM1933g1.getName(), abstractC2175b.mo1819c(), e2.getMessage()), e2);
                    }
                }
                abstractC2360j = ((C2327f) abstractC2360j).mo2117M(abstractC2360jMo2129M2);
            }
        }
        AbstractC2360j abstractC2360jMo2099k = abstractC2360j.mo2099k();
        if (abstractC2360jMo2099k == null) {
            return abstractC2360j;
        }
        Class<?> clsM1933g2 = interfaceC2379e == null ? null : m1933g0(interfaceC2379e.contentAs());
        if (clsM1933g2 == null) {
            return abstractC2360j;
        }
        Class<?> cls3 = abstractC2360jMo2099k._class;
        if (cls3 == clsM1933g2) {
            abstractC2360jMo2129M = abstractC2360jMo2099k.mo2129M();
        } else {
            try {
                if (clsM1933g2.isAssignableFrom(cls3)) {
                    abstractC2360jMo2129M = c2335n.m2165g(abstractC2360jMo2099k, clsM1933g2);
                } else if (cls3.isAssignableFrom(clsM1933g2)) {
                    abstractC2360jMo2129M = c2335n.m2166h(abstractC2360jMo2099k, clsM1933g2, false);
                } else {
                    if (!m1935i0(cls3, clsM1933g2)) {
                        throw new JsonMappingException(null, String.format("Cannot refine serialization content type %s into %s; types not related", abstractC2360jMo2099k, clsM1933g2.getName()));
                    }
                    abstractC2360jMo2129M = abstractC2360jMo2099k.mo2129M();
                }
            } catch (IllegalArgumentException e3) {
                throw new JsonMappingException(null, String.format("Internal error: failed to refine value type of %s with concrete-type annotation (value %s), from '%s': %s", abstractC2360j, clsM1933g2.getName(), abstractC2175b.mo1819c(), e3.getMessage()), e3);
            }
        }
        return abstractC2360j.mo2094D(abstractC2360jMo2129M);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: f */
    public String[] mo1781f(Class<?> cls, Enum<?>[] enumArr, String[] strArr) {
        InterfaceC2099u interfaceC2099u;
        HashMap map = null;
        for (Field field : cls.getDeclaredFields()) {
            if (field.isEnumConstant() && (interfaceC2099u = (InterfaceC2099u) field.getAnnotation(InterfaceC2099u.class)) != null) {
                String strValue = interfaceC2099u.value();
                if (!strValue.isEmpty()) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    map.put(field.getName(), strValue);
                }
            }
        }
        if (map != null) {
            int length = enumArr.length;
            for (int i = 0; i < length; i++) {
                String str = (String) map.get(enumArr[i].name());
                if (str != null) {
                    strArr[i] = str;
                }
            }
        }
        return strArr;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: f0 */
    public C2189j mo1782f0(AbstractC2394l<?> abstractC2394l, C2189j c2189j, C2189j c2189j2) {
        Class<?> clsM1906p = c2189j.m1906p(0);
        Class<?> clsM1906p2 = c2189j2.m1906p(0);
        if (clsM1906p.isPrimitive()) {
            if (!clsM1906p2.isPrimitive()) {
                return c2189j;
            }
        } else if (clsM1906p2.isPrimitive()) {
            return c2189j2;
        }
        if (clsM1906p == String.class) {
            if (clsM1906p2 != String.class) {
                return c2189j;
            }
            return null;
        }
        if (clsM1906p2 == String.class) {
            return c2189j2;
        }
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: g */
    public Object mo1783g(AbstractC2175b abstractC2175b) {
        InterfaceC2079h interfaceC2079h = (InterfaceC2079h) abstractC2175b.mo1818b(InterfaceC2079h.class);
        if (interfaceC2079h == null) {
            return null;
        }
        String strValue = interfaceC2079h.value();
        if (strValue.isEmpty()) {
            return null;
        }
        return strValue;
    }

    /* JADX INFO: renamed from: g0 */
    public Class<?> m1933g0(Class<?> cls) {
        if (cls == null || C2342d.m2184p(cls)) {
            return null;
        }
        return cls;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: h */
    public InterfaceC2081i.d mo1784h(AbstractC2175b abstractC2175b) {
        InterfaceC2081i interfaceC2081i = (InterfaceC2081i) abstractC2175b.mo1818b(InterfaceC2081i.class);
        if (interfaceC2081i == null) {
            return null;
        }
        String strPattern = interfaceC2081i.pattern();
        InterfaceC2081i.c cVarShape = interfaceC2081i.shape();
        String strLocale = interfaceC2081i.locale();
        String strTimezone = interfaceC2081i.timezone();
        InterfaceC2081i.a[] aVarArrWith = interfaceC2081i.with();
        InterfaceC2081i.a[] aVarArrWithout = interfaceC2081i.without();
        int iOrdinal = 0;
        for (InterfaceC2081i.a aVar : aVarArrWith) {
            iOrdinal |= 1 << aVar.ordinal();
        }
        int iOrdinal2 = 0;
        for (InterfaceC2081i.a aVar2 : aVarArrWithout) {
            iOrdinal2 |= 1 << aVar2.ordinal();
        }
        return new InterfaceC2081i.d(strPattern, cVarShape, strLocale, strTimezone, new InterfaceC2081i.b(iOrdinal, iOrdinal2), interfaceC2081i.lenient().m1613f());
    }

    /* JADX INFO: renamed from: h0 */
    public InterfaceC2214f<?> m1934h0(AbstractC2394l<?> abstractC2394l, AbstractC2175b abstractC2175b, AbstractC2360j abstractC2360j) {
        InterfaceC2214f c2225j;
        InterfaceC2070c0 interfaceC2070c0 = (InterfaceC2070c0) abstractC2175b.mo1818b(InterfaceC2070c0.class);
        InterfaceC2381g interfaceC2381g = (InterfaceC2381g) abstractC2175b.mo1818b(InterfaceC2381g.class);
        InterfaceC2213e interfaceC2213e = null;
        if (interfaceC2381g != null) {
            if (interfaceC2070c0 == null) {
                return null;
            }
            Class<? extends InterfaceC2214f<?>> clsValue = interfaceC2381g.value();
            Objects.requireNonNull(abstractC2394l._base);
            c2225j = (InterfaceC2214f) C2342d.m2175g(clsValue, abstractC2394l.m2265b());
        } else {
            if (interfaceC2070c0 == null) {
                return null;
            }
            InterfaceC2070c0.b bVarUse = interfaceC2070c0.use();
            InterfaceC2070c0.b bVar = InterfaceC2070c0.b.NONE;
            if (bVarUse == bVar) {
                C2225j c2225j2 = new C2225j();
                c2225j2.m1966g(bVar, null);
                return c2225j2;
            }
            c2225j = new C2225j();
        }
        InterfaceC2380f interfaceC2380f = (InterfaceC2380f) abstractC2175b.mo1818b(InterfaceC2380f.class);
        if (interfaceC2380f != null) {
            Class<? extends InterfaceC2213e> clsValue2 = interfaceC2380f.value();
            Objects.requireNonNull(abstractC2394l._base);
            interfaceC2213e = (InterfaceC2213e) C2342d.m2175g(clsValue2, abstractC2394l.m2265b());
        }
        if (interfaceC2213e != null) {
            interfaceC2213e.mo1947b(abstractC2360j);
        }
        InterfaceC2214f interfaceC2214fMo1950b = c2225j.mo1950b(interfaceC2070c0.use(), interfaceC2213e);
        InterfaceC2070c0.a aVarInclude = interfaceC2070c0.include();
        if (aVarInclude == InterfaceC2070c0.a.EXTERNAL_PROPERTY && (abstractC2175b instanceof C2177c)) {
            aVarInclude = InterfaceC2070c0.a.PROPERTY;
        }
        InterfaceC2214f interfaceC2214fMo1951c = interfaceC2214fMo1950b.mo1954f(aVarInclude).mo1951c(interfaceC2070c0.property());
        Class<?> clsDefaultImpl = interfaceC2070c0.defaultImpl();
        if (clsDefaultImpl != InterfaceC2070c0.c.class && !clsDefaultImpl.isAnnotation()) {
            interfaceC2214fMo1951c = interfaceC2214fMo1951c.mo1952d(clsDefaultImpl);
        }
        return interfaceC2214fMo1951c.mo1949a(interfaceC2070c0.visible());
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0016  */
    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: i */
    public String mo1785i(AbstractC2188i abstractC2188i) {
        C2370t c2370tMo1804a;
        AbstractC2168c abstractC2168c;
        if (abstractC2188i instanceof C2192m) {
            C2192m c2192m = (C2192m) abstractC2188i;
            if (c2192m._owner == null || (abstractC2168c = f4759l) == null || (c2370tMo1804a = abstractC2168c.mo1804a(c2192m)) == null) {
                c2370tMo1804a = null;
            }
        } else {
            c2370tMo1804a = null;
        }
        if (c2370tMo1804a == null) {
            return null;
        }
        return c2370tMo1804a._simpleName;
    }

    /* JADX INFO: renamed from: i0 */
    public final boolean m1935i0(Class<?> cls, Class<?> cls2) {
        if (cls.isPrimitive()) {
            return cls == C2342d.m2190v(cls2);
        }
        return cls2.isPrimitive() && cls2 == C2342d.m2190v(cls);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: j */
    public InterfaceC2067b.a mo1786j(AbstractC2188i abstractC2188i) {
        String name;
        InterfaceC2067b interfaceC2067b = (InterfaceC2067b) abstractC2188i.mo1818b(InterfaceC2067b.class);
        if (interfaceC2067b == null) {
            return null;
        }
        InterfaceC2067b.a aVarM1593a = InterfaceC2067b.a.m1593a(interfaceC2067b.value(), interfaceC2067b.useInput().m1613f());
        if (aVarM1593a._id != null) {
            return aVarM1593a;
        }
        if (abstractC2188i instanceof C2189j) {
            C2189j c2189j = (C2189j) abstractC2188i;
            name = c2189j.m1905o() == 0 ? abstractC2188i.mo1820d().getName() : c2189j.m1906p(0).getName();
        } else {
            name = abstractC2188i.mo1820d().getName();
        }
        return name.equals(aVarM1593a._id) ? aVarM1593a : new InterfaceC2067b.a(name, aVarM1593a._useInput);
    }

    /* JADX INFO: renamed from: j0 */
    public C2370t m1936j0(String str, String str2) {
        if (str.isEmpty()) {
            return C2370t.f5029j;
        }
        return (str2 == null || str2.isEmpty()) ? C2370t.m2227a(str) : C2370t.m2228b(str, str2);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    @Deprecated
    /* JADX INFO: renamed from: k */
    public Object mo1787k(AbstractC2188i abstractC2188i) {
        InterfaceC2067b.a aVarMo1786j = mo1786j(abstractC2188i);
        if (aVarMo1786j == null) {
            return null;
        }
        return aVarMo1786j._id;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: l */
    public Object mo1788l(AbstractC2175b abstractC2175b) {
        Class<? extends AbstractC2364n> clsKeyUsing;
        InterfaceC2379e interfaceC2379e = (InterfaceC2379e) abstractC2175b.mo1818b(InterfaceC2379e.class);
        if (interfaceC2379e == null || (clsKeyUsing = interfaceC2379e.keyUsing()) == AbstractC2364n.a.class) {
            return null;
        }
        return clsKeyUsing;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: m */
    public Boolean mo1789m(AbstractC2175b abstractC2175b) {
        InterfaceC2098t interfaceC2098t = (InterfaceC2098t) abstractC2175b.mo1818b(InterfaceC2098t.class);
        if (interfaceC2098t == null) {
            return null;
        }
        return interfaceC2098t.value().m1613f();
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: n */
    public C2370t mo1790n(AbstractC2175b abstractC2175b) {
        boolean z2;
        InterfaceC2104z interfaceC2104z = (InterfaceC2104z) abstractC2175b.mo1818b(InterfaceC2104z.class);
        if (interfaceC2104z != null) {
            String strValue = interfaceC2104z.value();
            if (!strValue.isEmpty()) {
                return C2370t.m2227a(strValue);
            }
            z2 = true;
        } else {
            z2 = false;
        }
        InterfaceC2099u interfaceC2099u = (InterfaceC2099u) abstractC2175b.mo1818b(InterfaceC2099u.class);
        if (interfaceC2099u != null) {
            String strNamespace = interfaceC2099u.namespace();
            return C2370t.m2228b(interfaceC2099u.value(), (strNamespace == null || !strNamespace.isEmpty()) ? strNamespace : null);
        }
        if (!z2) {
            Class<? extends Annotation>[] clsArr = f4758k;
            C2195p c2195p = ((AbstractC2188i) abstractC2175b).f4717k;
            if (!(c2195p != null ? c2195p.m1917b(clsArr) : false)) {
                return null;
            }
        }
        return C2370t.f5029j;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: o */
    public C2370t mo1791o(AbstractC2175b abstractC2175b) {
        boolean z2;
        InterfaceC2083j interfaceC2083j = (InterfaceC2083j) abstractC2175b.mo1818b(InterfaceC2083j.class);
        if (interfaceC2083j != null) {
            String strValue = interfaceC2083j.value();
            if (!strValue.isEmpty()) {
                return C2370t.m2227a(strValue);
            }
            z2 = true;
        } else {
            z2 = false;
        }
        InterfaceC2099u interfaceC2099u = (InterfaceC2099u) abstractC2175b.mo1818b(InterfaceC2099u.class);
        if (interfaceC2099u != null) {
            String strNamespace = interfaceC2099u.namespace();
            return C2370t.m2228b(interfaceC2099u.value(), (strNamespace == null || !strNamespace.isEmpty()) ? strNamespace : null);
        }
        if (!z2) {
            Class<? extends Annotation>[] clsArr = f4757j;
            C2195p c2195p = ((AbstractC2188i) abstractC2175b).f4717k;
            if (!(c2195p != null ? c2195p.m1917b(clsArr) : false)) {
                return null;
            }
        }
        return C2370t.f5029j;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: p */
    public Object mo1792p(C2177c c2177c) {
        InterfaceC2378d interfaceC2378d = (InterfaceC2378d) c2177c.mo1818b(InterfaceC2378d.class);
        if (interfaceC2378d == null) {
            return null;
        }
        return interfaceC2378d.value();
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: q */
    public Object mo1793q(AbstractC2175b abstractC2175b) {
        Class<? extends AbstractC2364n> clsNullsUsing;
        InterfaceC2379e interfaceC2379e = (InterfaceC2379e) abstractC2175b.mo1818b(InterfaceC2379e.class);
        if (interfaceC2379e == null || (clsNullsUsing = interfaceC2379e.nullsUsing()) == AbstractC2364n.a.class) {
            return null;
        }
        return clsNullsUsing;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: r */
    public C2174a0 mo1794r(AbstractC2175b abstractC2175b) {
        InterfaceC2085k interfaceC2085k = (InterfaceC2085k) abstractC2175b.mo1818b(InterfaceC2085k.class);
        if (interfaceC2085k == null || interfaceC2085k.generator() == AbstractC2086k0.class) {
            return null;
        }
        return new C2174a0(C2370t.m2227a(interfaceC2085k.property()), interfaceC2085k.scope(), interfaceC2085k.generator(), false, interfaceC2085k.resolver());
    }

    public Object readResolve() {
        if (this.f4760m == null) {
            this.f4760m = new C2346h<>(48, 48);
        }
        return this;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: s */
    public C2174a0 mo1795s(AbstractC2175b abstractC2175b, C2174a0 c2174a0) {
        InterfaceC2087l interfaceC2087l = (InterfaceC2087l) abstractC2175b.mo1818b(InterfaceC2087l.class);
        if (interfaceC2087l == null) {
            return c2174a0;
        }
        if (c2174a0 == null) {
            c2174a0 = C2174a0.f4627a;
        }
        boolean zAlwaysAsId = interfaceC2087l.alwaysAsId();
        return c2174a0.f4632f == zAlwaysAsId ? c2174a0 : new C2174a0(c2174a0.f4628b, c2174a0.f4631e, c2174a0.f4629c, zAlwaysAsId, c2174a0.f4630d);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: t */
    public InterfaceC2099u.a mo1796t(AbstractC2175b abstractC2175b) {
        InterfaceC2099u interfaceC2099u = (InterfaceC2099u) abstractC2175b.mo1818b(InterfaceC2099u.class);
        if (interfaceC2099u != null) {
            return interfaceC2099u.access();
        }
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: u */
    public InterfaceC2214f<?> mo1797u(AbstractC2394l<?> abstractC2394l, AbstractC2188i abstractC2188i, AbstractC2360j abstractC2360j) {
        if (abstractC2360j.mo2099k() != null) {
            return m1934h0(abstractC2394l, abstractC2188i, abstractC2360j);
        }
        throw new IllegalArgumentException("Must call method with a container or reference type (got " + abstractC2360j + ")");
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: v */
    public String mo1798v(AbstractC2175b abstractC2175b) {
        InterfaceC2099u interfaceC2099u = (InterfaceC2099u) abstractC2175b.mo1818b(InterfaceC2099u.class);
        if (interfaceC2099u == null) {
            return null;
        }
        String strDefaultValue = interfaceC2099u.defaultValue();
        if (strDefaultValue.isEmpty()) {
            return null;
        }
        return strDefaultValue;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: w */
    public String mo1799w(AbstractC2175b abstractC2175b) {
        InterfaceC2100v interfaceC2100v = (InterfaceC2100v) abstractC2175b.mo1818b(InterfaceC2100v.class);
        if (interfaceC2100v == null) {
            return null;
        }
        return interfaceC2100v.value();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.HashSet] */
    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: x */
    public InterfaceC2091n.a mo1800x(AbstractC2394l<?> abstractC2394l, AbstractC2175b abstractC2175b) {
        ?? EmptySet;
        InterfaceC2091n interfaceC2091n = (InterfaceC2091n) abstractC2175b.mo1818b(InterfaceC2091n.class);
        if (interfaceC2091n == null) {
            return InterfaceC2091n.a.f4427j;
        }
        InterfaceC2091n.a aVar = InterfaceC2091n.a.f4427j;
        String[] strArrValue = interfaceC2091n.value();
        if (strArrValue == null || strArrValue.length == 0) {
            EmptySet = Collections.emptySet();
        } else {
            EmptySet = new HashSet(strArrValue.length);
            for (String str : strArrValue) {
                EmptySet.add(str);
            }
        }
        return InterfaceC2091n.a.m1616c(EmptySet, interfaceC2091n.ignoreUnknown(), interfaceC2091n.allowGetters(), interfaceC2091n.allowSetters(), false);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    @Deprecated
    /* JADX INFO: renamed from: y */
    public InterfaceC2091n.a mo1801y(AbstractC2175b abstractC2175b) {
        return mo1800x(null, abstractC2175b);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2165b
    /* JADX INFO: renamed from: z */
    public InterfaceC2094p.b mo1802z(AbstractC2175b abstractC2175b) {
        InterfaceC2094p.b bVar;
        InterfaceC2379e interfaceC2379e;
        InterfaceC2094p.b bVarM1619b;
        InterfaceC2094p.a aVar = InterfaceC2094p.a.USE_DEFAULTS;
        InterfaceC2094p interfaceC2094p = (InterfaceC2094p) abstractC2175b.mo1818b(InterfaceC2094p.class);
        if (interfaceC2094p == null) {
            InterfaceC2094p.b bVar2 = InterfaceC2094p.b.f4436j;
            bVar = InterfaceC2094p.b.f4436j;
        } else {
            InterfaceC2094p.b bVar3 = InterfaceC2094p.b.f4436j;
            InterfaceC2094p.a aVarValue = interfaceC2094p.value();
            InterfaceC2094p.a aVarContent = interfaceC2094p.content();
            if (aVarValue == aVar && aVarContent == aVar) {
                bVar = InterfaceC2094p.b.f4436j;
            } else {
                Class<?> clsValueFilter = interfaceC2094p.valueFilter();
                if (clsValueFilter == Void.class) {
                    clsValueFilter = null;
                }
                Class<?> clsContentFilter = interfaceC2094p.contentFilter();
                bVar = new InterfaceC2094p.b(aVarValue, aVarContent, clsValueFilter, clsContentFilter != Void.class ? clsContentFilter : null);
            }
        }
        if (bVar._valueInclusion != aVar || (interfaceC2379e = (InterfaceC2379e) abstractC2175b.mo1818b(InterfaceC2379e.class)) == null) {
            return bVar;
        }
        int iOrdinal = interfaceC2379e.include().ordinal();
        if (iOrdinal == 0) {
            bVarM1619b = bVar.m1619b(InterfaceC2094p.a.ALWAYS);
        } else if (iOrdinal == 1) {
            bVarM1619b = bVar.m1619b(InterfaceC2094p.a.NON_NULL);
        } else if (iOrdinal == 2) {
            bVarM1619b = bVar.m1619b(InterfaceC2094p.a.NON_DEFAULT);
        } else {
            if (iOrdinal != 3) {
                return bVar;
            }
            bVarM1619b = bVar.m1619b(InterfaceC2094p.a.NON_EMPTY);
        }
        return bVarM1619b;
    }
}
