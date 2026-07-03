package p007b.p195g.p196a.p205c.p210c0;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p197a.InterfaceC2067b;
import p007b.p195g.p196a.p197a.InterfaceC2077g;
import p007b.p195g.p196a.p197a.InterfaceC2099u;
import p007b.p195g.p196a.p205c.AbstractC2165b;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.C2370t;
import p007b.p195g.p196a.p205c.C2371u;
import p007b.p195g.p196a.p205c.EnumC2366p;
import p007b.p195g.p196a.p205c.p210c0.C2178c0;
import p007b.p195g.p196a.p205c.p210c0.InterfaceC2186g0;
import p007b.p195g.p196a.p205c.p219i0.C2342d;
import p007b.p195g.p196a.p205c.p221z.AbstractC2394l;

/* JADX INFO: renamed from: b.g.a.c.c0.b0 */
/* JADX INFO: compiled from: POJOPropertiesCollector.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2176b0 {

    /* JADX INFO: renamed from: a */
    public final AbstractC2394l<?> f4633a;

    /* JADX INFO: renamed from: b */
    public final AbstractC2173a f4634b;

    /* JADX INFO: renamed from: c */
    public final boolean f4635c;

    /* JADX INFO: renamed from: d */
    public final AbstractC2360j f4636d;

    /* JADX INFO: renamed from: e */
    public final C2177c f4637e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC2186g0<?> f4638f;

    /* JADX INFO: renamed from: g */
    public final AbstractC2165b f4639g;

    /* JADX INFO: renamed from: h */
    public final boolean f4640h;

    /* JADX INFO: renamed from: i */
    public boolean f4641i;

    /* JADX INFO: renamed from: j */
    public LinkedHashMap<String, C2178c0> f4642j;

    /* JADX INFO: renamed from: k */
    public LinkedList<C2178c0> f4643k;

    /* JADX INFO: renamed from: l */
    public Map<C2370t, C2370t> f4644l;

    /* JADX INFO: renamed from: m */
    public LinkedList<AbstractC2188i> f4645m;

    /* JADX INFO: renamed from: n */
    public LinkedList<AbstractC2188i> f4646n;

    /* JADX INFO: renamed from: o */
    public LinkedList<C2189j> f4647o;

    /* JADX INFO: renamed from: p */
    public LinkedList<AbstractC2188i> f4648p;

    /* JADX INFO: renamed from: q */
    public LinkedList<AbstractC2188i> f4649q;

    /* JADX INFO: renamed from: r */
    public LinkedList<AbstractC2188i> f4650r;

    /* JADX INFO: renamed from: s */
    public HashSet<String> f4651s;

    /* JADX INFO: renamed from: t */
    public LinkedHashMap<Object, AbstractC2188i> f4652t;

    public C2176b0(AbstractC2394l<?> abstractC2394l, boolean z2, AbstractC2360j abstractC2360j, C2177c c2177c, AbstractC2173a abstractC2173a) {
        this.f4633a = abstractC2394l;
        this.f4635c = z2;
        this.f4636d = abstractC2360j;
        this.f4637e = c2177c;
        if (abstractC2394l.m2278p()) {
            this.f4640h = true;
            this.f4639g = abstractC2394l.m2267e();
        } else {
            this.f4640h = false;
            this.f4639g = AbstractC2205z.f4764j;
        }
        this.f4638f = abstractC2394l.mo2275m(abstractC2360j._class, c2177c);
        this.f4634b = abstractC2173a;
        abstractC2394l.m2279q(EnumC2366p.USE_STD_BEAN_NAMING);
    }

    /* JADX INFO: renamed from: a */
    public void m1822a(Map<String, C2178c0> map, C2192m c2192m) {
        C2178c0 c2178c0M1827f;
        InterfaceC2077g.a aVarMo1777d;
        String strMo1785i = this.f4639g.mo1785i(c2192m);
        if (strMo1785i == null) {
            strMo1785i = "";
        }
        C2370t c2370tMo1790n = this.f4639g.mo1790n(c2192m);
        boolean z2 = (c2370tMo1790n == null || c2370tMo1790n.m2230d()) ? false : true;
        if (!z2) {
            if (strMo1785i.isEmpty() || (aVarMo1777d = this.f4639g.mo1777d(this.f4633a, c2192m._owner)) == null || aVarMo1777d == InterfaceC2077g.a.DISABLED) {
                return;
            } else {
                c2370tMo1790n = C2370t.m2227a(strMo1785i);
            }
        }
        C2370t c2370t = c2370tMo1790n;
        String strM1823b = m1823b(strMo1785i);
        if (z2 && strM1823b.isEmpty()) {
            String str = c2370t._simpleName;
            c2178c0M1827f = map.get(str);
            if (c2178c0M1827f == null) {
                c2178c0M1827f = new C2178c0(this.f4633a, this.f4639g, this.f4635c, c2370t);
                map.put(str, c2178c0M1827f);
            }
        } else {
            c2178c0M1827f = m1827f(map, strM1823b);
        }
        c2178c0M1827f.f4678r = new C2178c0.d<>(c2192m, c2178c0M1827f.f4678r, c2370t, z2, true, false);
        this.f4643k.add(c2178c0M1827f);
    }

    /* JADX INFO: renamed from: b */
    public final String m1823b(String str) {
        C2370t c2370t;
        Map<C2370t, C2370t> map = this.f4644l;
        return (map == null || (c2370t = map.get(m1826e(str))) == null) ? str : c2370t._simpleName;
    }

    /* JADX INFO: renamed from: c */
    public void m1824c(String str) {
        if (this.f4635c || str == null) {
            return;
        }
        if (this.f4651s == null) {
            this.f4651s = new HashSet<>();
        }
        this.f4651s.add(str);
    }

    /* JADX INFO: renamed from: d */
    public void m1825d(InterfaceC2067b.a aVar, AbstractC2188i abstractC2188i) {
        if (aVar == null) {
            return;
        }
        Object obj = aVar._id;
        if (this.f4652t == null) {
            this.f4652t = new LinkedHashMap<>();
        }
        AbstractC2188i abstractC2188iPut = this.f4652t.put(obj, abstractC2188i);
        if (abstractC2188iPut == null || abstractC2188iPut.getClass() != abstractC2188i.getClass()) {
            return;
        }
        throw new IllegalArgumentException("Duplicate injectable value with id '" + obj + "' (of type " + obj.getClass().getName() + ")");
    }

    /* JADX INFO: renamed from: e */
    public final C2370t m1826e(String str) {
        return C2370t.m2228b(str, null);
    }

    /* JADX INFO: renamed from: f */
    public C2178c0 m1827f(Map<String, C2178c0> map, String str) {
        C2178c0 c2178c0 = map.get(str);
        if (c2178c0 != null) {
            return c2178c0;
        }
        C2178c0 c2178c1 = new C2178c0(this.f4633a, this.f4639g, this.f4635c, C2370t.m2227a(str));
        map.put(str, c2178c1);
        return c2178c1;
    }

    /* JADX INFO: renamed from: g */
    public boolean m1828g(C2178c0 c2178c0, List<C2178c0> list) {
        if (list != null) {
            String str = c2178c0.f4676p._simpleName;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).f4676p._simpleName.equals(str)) {
                    list.set(i, c2178c0);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:179:0x0341  */
    /* JADX WARN: Code duplicated, block: B:452:0x087e  */
    /* JADX INFO: renamed from: h */
    public void m1829h() {
        C2371u c2371u;
        boolean zBooleanValue;
        boolean z2;
        Collection<C2178c0> collectionValues;
        String strMo2233c;
        HashSet<String> hashSet;
        InterfaceC2099u.a aVarMo1796t;
        C2178c0.d<C2192m> dVar;
        C2178c0.d<C2189j> dVar2;
        C2178c0.d<C2185g> dVar3;
        C2178c0.d<C2189j> dVar4;
        C2178c0.d<C2189j> dVar5;
        C2178c0.d<C2185g> dVar6;
        C2178c0.d<C2192m> dVar7;
        C2178c0.d<C2189j> dVar8;
        boolean z3;
        String strMo1785i;
        C2370t c2370t;
        boolean z4;
        boolean z5;
        boolean zM1595f;
        String strMo1785i2;
        C2370t c2370t2;
        boolean z6;
        boolean zM1595f2;
        C2370t c2370tM1826e;
        boolean z7;
        boolean z8;
        boolean z9;
        LinkedHashMap<String, C2178c0> linkedHashMap = new LinkedHashMap<>();
        AbstractC2165b abstractC2165b = this.f4639g;
        boolean z10 = (this.f4635c || this.f4633a.m2279q(EnumC2366p.ALLOW_FINAL_FIELDS_AS_MUTATORS)) ? false : true;
        boolean zM2279q = this.f4633a.m2279q(EnumC2366p.PROPAGATE_TRANSIENT_MARKER);
        for (C2185g c2185g : this.f4637e.m1833g()) {
            Boolean bool = Boolean.TRUE;
            if (bool.equals(abstractC2165b.mo1766V(this.f4633a, c2185g))) {
                if (this.f4649q == null) {
                    this.f4649q = new LinkedList<>();
                }
                this.f4649q.add(c2185g);
            }
            if (bool.equals(abstractC2165b.mo1767W(c2185g))) {
                if (this.f4650r == null) {
                    this.f4650r = new LinkedList<>();
                }
                this.f4650r.add(c2185g);
            } else {
                boolean zEquals = bool.equals(abstractC2165b.mo1763S(c2185g));
                boolean zEquals2 = bool.equals(abstractC2165b.mo1765U(c2185g));
                if (zEquals || zEquals2) {
                    if (zEquals) {
                        if (this.f4646n == null) {
                            this.f4646n = new LinkedList<>();
                        }
                        this.f4646n.add(c2185g);
                    }
                    if (zEquals2) {
                        if (this.f4648p == null) {
                            this.f4648p = new LinkedList<>();
                        }
                        this.f4648p.add(c2185g);
                    }
                } else {
                    String strMo1785i3 = abstractC2165b.mo1785i(c2185g);
                    if (strMo1785i3 == null) {
                        strMo1785i3 = c2185g.mo1819c();
                    }
                    Objects.requireNonNull((C2202w) this.f4634b);
                    if (strMo1785i3 != null) {
                        C2370t c2370tM1826e2 = m1826e(strMo1785i3);
                        C2370t c2370tMo1749E = abstractC2165b.mo1749E(this.f4633a, c2185g, c2370tM1826e2);
                        if (c2370tMo1749E != null && !c2370tMo1749E.equals(c2370tM1826e2)) {
                            if (this.f4644l == null) {
                                this.f4644l = new HashMap();
                            }
                            this.f4644l.put(c2370tMo1749E, c2370tM1826e2);
                        }
                        C2370t c2370tMo1791o = this.f4635c ? abstractC2165b.mo1791o(c2185g) : abstractC2165b.mo1790n(c2185g);
                        boolean z11 = c2370tMo1791o != null;
                        if (z11 && c2370tMo1791o.m2230d()) {
                            c2370tM1826e = m1826e(strMo1785i3);
                            z7 = false;
                        } else {
                            c2370tM1826e = c2370tMo1791o;
                            z7 = z11;
                        }
                        boolean zM1595f3 = c2370tM1826e != null;
                        if (!zM1595f3) {
                            InterfaceC2186g0.a aVar = (InterfaceC2186g0.a) this.f4638f;
                            Objects.requireNonNull(aVar);
                            zM1595f3 = aVar._fieldMinLevel.m1595f(c2185g.f4708l);
                        }
                        boolean zMo1770Z = abstractC2165b.mo1770Z(c2185g);
                        if (!Modifier.isTransient(c2185g.f4708l.getModifiers()) || z11) {
                            z8 = zMo1770Z;
                            z9 = zM1595f3;
                        } else if (zM2279q) {
                            z9 = false;
                            z8 = true;
                        } else {
                            z8 = zMo1770Z;
                            z9 = false;
                        }
                        if (!z10 || c2370tM1826e != null || z8 || !Modifier.isFinal(c2185g.f4708l.getModifiers())) {
                            C2178c0 c2178c0M1827f = m1827f(linkedHashMap, strMo1785i3);
                            c2178c0M1827f.f4677q = new C2178c0.d<>(c2185g, c2178c0M1827f.f4677q, c2370tM1826e, z7, z9, z8);
                        }
                    }
                }
            }
        }
        for (C2189j c2189j : (C2191l) this.f4637e.m1834h()) {
            int iM1905o = c2189j.m1905o();
            if (iM1905o == 0) {
                AbstractC2165b abstractC2165b2 = this.f4639g;
                Class<?> returnType = c2189j.f4718l.getReturnType();
                if (returnType != Void.TYPE && (returnType != Void.class || this.f4633a.m2279q(EnumC2366p.ALLOW_VOID_VALUED_PROPERTIES))) {
                    Boolean bool2 = Boolean.TRUE;
                    if (bool2.equals(abstractC2165b2.mo1763S(c2189j))) {
                        if (this.f4645m == null) {
                            this.f4645m = new LinkedList<>();
                        }
                        this.f4645m.add(c2189j);
                    } else if (bool2.equals(abstractC2165b2.mo1766V(this.f4633a, c2189j))) {
                        if (this.f4649q == null) {
                            this.f4649q = new LinkedList<>();
                        }
                        this.f4649q.add(c2189j);
                    } else if (bool2.equals(abstractC2165b2.mo1767W(c2189j))) {
                        if (this.f4650r == null) {
                            this.f4650r = new LinkedList<>();
                        }
                        this.f4650r.add(c2189j);
                    } else {
                        C2370t c2370tMo1791o2 = abstractC2165b2.mo1791o(c2189j);
                        boolean z12 = c2370tMo1791o2 != null;
                        if (z12) {
                            strMo1785i = abstractC2165b2.mo1785i(c2189j);
                            if (strMo1785i == null && (strMo1785i = this.f4634b.mo1817c(c2189j, c2189j.mo1819c())) == null) {
                                strMo1785i = this.f4634b.mo1815a(c2189j, c2189j.mo1819c());
                            }
                            if (strMo1785i == null) {
                                strMo1785i = c2189j.mo1819c();
                            }
                            if (c2370tMo1791o2.m2230d()) {
                                c2370tMo1791o2 = m1826e(strMo1785i);
                                z12 = false;
                            }
                            c2370t = c2370tMo1791o2;
                            z4 = z12;
                            z5 = true;
                        } else {
                            strMo1785i = abstractC2165b2.mo1785i(c2189j);
                            if (strMo1785i == null) {
                                strMo1785i = this.f4634b.mo1817c(c2189j, c2189j.mo1819c());
                            }
                            if (strMo1785i == null) {
                                strMo1785i = this.f4634b.mo1815a(c2189j, c2189j.mo1819c());
                                if (strMo1785i != null) {
                                    InterfaceC2186g0.a aVar2 = (InterfaceC2186g0.a) this.f4638f;
                                    Objects.requireNonNull(aVar2);
                                    zM1595f = aVar2._isGetterMinLevel.m1595f(c2189j.f4718l);
                                }
                            } else {
                                InterfaceC2186g0.a aVar3 = (InterfaceC2186g0.a) this.f4638f;
                                Objects.requireNonNull(aVar3);
                                zM1595f = aVar3._getterMinLevel.m1595f(c2189j.f4718l);
                            }
                            z4 = z12;
                            z5 = zM1595f;
                            c2370t = c2370tMo1791o2;
                        }
                        String strM1823b = m1823b(strMo1785i);
                        boolean zMo1770Z2 = abstractC2165b2.mo1770Z(c2189j);
                        C2178c0 c2178c0M1827f2 = m1827f(linkedHashMap, strM1823b);
                        c2178c0M1827f2.f4679s = new C2178c0.d<>(c2189j, c2178c0M1827f2.f4679s, c2370t, z4, z5, zMo1770Z2);
                    }
                }
            } else if (iM1905o == 1) {
                AbstractC2165b abstractC2165b3 = this.f4639g;
                C2370t c2370tMo1790n = abstractC2165b3.mo1790n(c2189j);
                boolean z13 = c2370tMo1790n != null;
                if (z13) {
                    strMo1785i2 = abstractC2165b3.mo1785i(c2189j);
                    if (strMo1785i2 == null) {
                        strMo1785i2 = this.f4634b.mo1816b(c2189j, c2189j.mo1819c());
                    }
                    if (strMo1785i2 == null) {
                        strMo1785i2 = c2189j.mo1819c();
                    }
                    if (c2370tMo1790n.m2230d()) {
                        c2370tMo1790n = m1826e(strMo1785i2);
                        z13 = false;
                    }
                    c2370t2 = c2370tMo1790n;
                    z6 = z13;
                    zM1595f2 = true;
                } else {
                    strMo1785i2 = abstractC2165b3.mo1785i(c2189j);
                    if (strMo1785i2 == null) {
                        strMo1785i2 = this.f4634b.mo1816b(c2189j, c2189j.mo1819c());
                    }
                    if (strMo1785i2 != null) {
                        InterfaceC2186g0.a aVar4 = (InterfaceC2186g0.a) this.f4638f;
                        Objects.requireNonNull(aVar4);
                        z6 = z13;
                        zM1595f2 = aVar4._setterMinLevel.m1595f(c2189j.f4718l);
                        c2370t2 = c2370tMo1790n;
                    }
                }
                String strM1823b2 = m1823b(strMo1785i2);
                boolean zMo1770Z3 = abstractC2165b3.mo1770Z(c2189j);
                C2178c0 c2178c0M1827f3 = m1827f(linkedHashMap, strM1823b2);
                c2178c0M1827f3.f4680t = new C2178c0.d<>(c2189j, c2178c0M1827f3.f4680t, c2370t2, z6, zM1595f2, zMo1770Z3);
            } else if (iM1905o == 2 && Boolean.TRUE.equals(this.f4639g.mo1765U(c2189j))) {
                if (this.f4647o == null) {
                    this.f4647o = new LinkedList<>();
                }
                this.f4647o.add(c2189j);
            }
        }
        C2177c c2177c = this.f4637e;
        Boolean boolValueOf = c2177c.f4667x;
        if (boolValueOf == null) {
            Class<?> cls = c2177c.f4655l;
            Annotation[] annotationArr = C2342d.f4944a;
            if (Modifier.isStatic(cls.getModifiers())) {
                z3 = false;
            } else if ((C2342d.m2188t(cls) ? null : cls.getEnclosingClass()) != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolValueOf = Boolean.valueOf(z3);
            c2177c.f4667x = boolValueOf;
        }
        if (!boolValueOf.booleanValue() && this.f4640h) {
            for (C2181e c2181e : this.f4637e.m1832f().f4669b) {
                if (this.f4643k == null) {
                    this.f4643k = new LinkedList<>();
                }
                int length = c2181e._constructor.getParameterTypes().length;
                for (int i = 0; i < length; i++) {
                    m1822a(linkedHashMap, c2181e.m1910m(i));
                }
            }
            for (C2189j c2189j2 : this.f4637e.m1832f().f4670c) {
                if (this.f4643k == null) {
                    this.f4643k = new LinkedList<>();
                }
                int iM1905o2 = c2189j2.m1905o();
                for (int i2 = 0; i2 < iM1905o2; i2++) {
                    m1822a(linkedHashMap, c2189j2.m1910m(i2));
                }
            }
        }
        Iterator<C2178c0> it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            C2178c0 next = it.next();
            if (!(next.m1868z(next.f4677q) || next.m1868z(next.f4679s) || next.m1868z(next.f4680t) || next.m1868z(next.f4678r))) {
                it.remove();
            } else if (next.m1867y(next.f4677q) || next.m1867y(next.f4679s) || next.m1867y(next.f4680t) || next.m1867y(next.f4678r)) {
                if (next.mo1863u()) {
                    next.f4677q = next.m1842G(next.f4677q);
                    next.f4679s = next.m1842G(next.f4679s);
                    next.f4680t = next.m1842G(next.f4680t);
                    next.f4678r = next.m1842G(next.f4678r);
                    if (!next.mo1849f()) {
                        m1824c(next.mo1858p());
                    }
                } else {
                    it.remove();
                    m1824c(next.mo1858p());
                }
            }
        }
        boolean zM2279q2 = this.f4633a.m2279q(EnumC2366p.INFER_PROPERTY_MUTATORS);
        for (C2178c0 c2178c0 : linkedHashMap.values()) {
            C2176b0 c2176b0 = this.f4635c ? null : this;
            InterfaceC2099u.a aVar5 = InterfaceC2099u.a.AUTO;
            AbstractC2165b abstractC2165b4 = c2178c0.f4674n;
            if (abstractC2165b4 == null || (!c2178c0.f4672l ? ((dVar = c2178c0.f4678r) == null || (aVarMo1796t = abstractC2165b4.mo1796t(dVar.f4686a)) == null || aVarMo1796t == aVar5) && (((dVar2 = c2178c0.f4680t) == null || (aVarMo1796t = c2178c0.f4674n.mo1796t(dVar2.f4686a)) == null || aVarMo1796t == aVar5) && (((dVar3 = c2178c0.f4677q) == null || (aVarMo1796t = c2178c0.f4674n.mo1796t(dVar3.f4686a)) == null || aVarMo1796t == aVar5) && ((dVar4 = c2178c0.f4679s) == null || (aVarMo1796t = c2178c0.f4674n.mo1796t(dVar4.f4686a)) == null || aVarMo1796t == aVar5))) : ((dVar5 = c2178c0.f4679s) == null || (aVarMo1796t = abstractC2165b4.mo1796t(dVar5.f4686a)) == null || aVarMo1796t == aVar5) && (((dVar6 = c2178c0.f4677q) == null || (aVarMo1796t = c2178c0.f4674n.mo1796t(dVar6.f4686a)) == null || aVarMo1796t == aVar5) && (((dVar7 = c2178c0.f4678r) == null || (aVarMo1796t = c2178c0.f4674n.mo1796t(dVar7.f4686a)) == null || aVarMo1796t == aVar5) && ((dVar8 = c2178c0.f4680t) == null || (aVarMo1796t = c2178c0.f4674n.mo1796t(dVar8.f4686a)) == null || aVarMo1796t == aVar5))))) {
                aVarMo1796t = null;
            }
            if (aVarMo1796t != null) {
                aVar5 = aVarMo1796t;
            }
            int iOrdinal = aVar5.ordinal();
            if (iOrdinal == 1) {
                if (c2176b0 != null) {
                    c2176b0.m1824c(c2178c0.mo1858p());
                    Iterator<C2370t> it2 = c2178c0.m1847L().iterator();
                    while (it2.hasNext()) {
                        c2176b0.m1824c(it2.next()._simpleName);
                    }
                }
                c2178c0.f4680t = null;
                c2178c0.f4678r = null;
                if (!c2178c0.f4672l) {
                    c2178c0.f4677q = null;
                }
            } else if (iOrdinal == 2) {
                c2178c0.f4679s = null;
                if (c2178c0.f4672l) {
                    c2178c0.f4677q = null;
                }
            } else if (iOrdinal != 3) {
                c2178c0.f4679s = c2178c0.m1843H(c2178c0.f4679s);
                c2178c0.f4678r = c2178c0.m1843H(c2178c0.f4678r);
                if (!zM2279q2 || c2178c0.f4679s == null) {
                    c2178c0.f4677q = c2178c0.m1843H(c2178c0.f4677q);
                    c2178c0.f4680t = c2178c0.m1843H(c2178c0.f4680t);
                }
            }
        }
        Iterator<Map.Entry<String, C2178c0>> it3 = linkedHashMap.entrySet().iterator();
        LinkedList<C2178c0> linkedList = null;
        while (it3.hasNext()) {
            C2178c0 value = it3.next().getValue();
            Set<C2370t> setM1847L = value.m1847L();
            if (!setM1847L.isEmpty()) {
                it3.remove();
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                if (setM1847L.size() == 1) {
                    linkedList.add(new C2178c0(value, setM1847L.iterator().next()));
                } else {
                    HashMap map = new HashMap();
                    value.m1837B(setM1847L, map, value.f4677q);
                    value.m1837B(setM1847L, map, value.f4679s);
                    value.m1837B(setM1847L, map, value.f4680t);
                    value.m1837B(setM1847L, map, value.f4678r);
                    linkedList.addAll(map.values());
                }
            }
        }
        if (linkedList != null) {
            for (C2178c0 c2178c1 : linkedList) {
                String strMo1858p = c2178c1.mo1858p();
                C2178c0 c2178c2 = linkedHashMap.get(strMo1858p);
                if (c2178c2 == null) {
                    linkedHashMap.put(strMo1858p, c2178c1);
                } else {
                    c2178c2.m1846K(c2178c1);
                }
                if (m1828g(c2178c1, this.f4643k) && (hashSet = this.f4651s) != null) {
                    hashSet.remove(strMo1858p);
                }
            }
        }
        for (C2185g c2185g2 : this.f4637e.m1833g()) {
            m1825d(this.f4639g.mo1786j(c2185g2), c2185g2);
        }
        for (C2189j c2189j3 : (C2191l) this.f4637e.m1834h()) {
            if (c2189j3.m1905o() == 1) {
                m1825d(this.f4639g.mo1786j(c2189j3), c2189j3);
            }
        }
        for (C2178c0 c2178c3 : linkedHashMap.values()) {
            if (this.f4635c) {
                C2178c0.d<C2189j> dVar9 = c2178c3.f4679s;
                if (dVar9 != null) {
                    c2178c3.f4679s = c2178c3.m1836A(c2178c3.f4679s, c2178c3.m1841F(0, dVar9, c2178c3.f4677q, c2178c3.f4678r, c2178c3.f4680t));
                } else {
                    C2178c0.d<C2185g> dVar10 = c2178c3.f4677q;
                    if (dVar10 != null) {
                        c2178c3.f4677q = c2178c3.m1836A(c2178c3.f4677q, c2178c3.m1841F(0, dVar10, c2178c3.f4678r, c2178c3.f4680t));
                    }
                }
            } else {
                C2178c0.d<C2192m> dVar11 = c2178c3.f4678r;
                if (dVar11 != null) {
                    c2178c3.f4678r = c2178c3.m1836A(c2178c3.f4678r, c2178c3.m1841F(0, dVar11, c2178c3.f4680t, c2178c3.f4677q, c2178c3.f4679s));
                } else {
                    C2178c0.d<C2189j> dVar12 = c2178c3.f4680t;
                    if (dVar12 != null) {
                        c2178c3.f4680t = c2178c3.m1836A(c2178c3.f4680t, c2178c3.m1841F(0, dVar12, c2178c3.f4677q, c2178c3.f4679s));
                    } else {
                        C2178c0.d<C2185g> dVar13 = c2178c3.f4677q;
                        if (dVar13 != null) {
                            c2178c3.f4677q = c2178c3.m1836A(c2178c3.f4677q, c2178c3.m1841F(0, dVar13, c2178c3.f4679s));
                        }
                    }
                }
            }
        }
        for (C2178c0 c2178c4 : linkedHashMap.values()) {
            c2178c4.f4677q = c2178c4.m1845J(c2178c4.f4677q);
            c2178c4.f4679s = c2178c4.m1845J(c2178c4.f4679s);
            c2178c4.f4680t = c2178c4.m1845J(c2178c4.f4680t);
            c2178c4.f4678r = c2178c4.m1845J(c2178c4.f4678r);
        }
        Object objMo1792p = this.f4639g.mo1792p(this.f4637e);
        if (objMo1792p == null) {
            c2371u = this.f4633a._base._propertyNamingStrategy;
        } else if (objMo1792p instanceof C2371u) {
            c2371u = (C2371u) objMo1792p;
        } else {
            if (!(objMo1792p instanceof Class)) {
                StringBuilder sbM833U = C1643a.m833U("AnnotationIntrospector returned PropertyNamingStrategy definition of type ");
                sbM833U.append(objMo1792p.getClass().getName());
                sbM833U.append("; expected type PropertyNamingStrategy or Class<PropertyNamingStrategy> instead");
                throw new IllegalStateException(sbM833U.toString());
            }
            Class cls2 = (Class) objMo1792p;
            if (cls2 == C2371u.class) {
                c2371u = null;
            } else {
                if (!C2371u.class.isAssignableFrom(cls2)) {
                    throw new IllegalStateException(C1643a.m867o(cls2, C1643a.m833U("AnnotationIntrospector returned Class "), "; expected Class<PropertyNamingStrategy>"));
                }
                Objects.requireNonNull(this.f4633a._base);
                c2371u = (C2371u) C2342d.m2175g(cls2, this.f4633a.m2265b());
            }
        }
        if (c2371u != null) {
            C2178c0[] c2178c0Arr = (C2178c0[]) linkedHashMap.values().toArray(new C2178c0[linkedHashMap.size()]);
            linkedHashMap.clear();
            for (C2178c0 c2178c5 : c2178c0Arr) {
                C2370t c2370t3 = c2178c5.f4675o;
                if ((c2178c5.m1865w(c2178c5.f4677q) || c2178c5.m1865w(c2178c5.f4679s) || c2178c5.m1865w(c2178c5.f4680t) || c2178c5.m1865w(c2178c5.f4678r)) && !this.f4633a.m2279q(EnumC2366p.ALLOW_EXPLICIT_PROPERTY_RENAMING)) {
                    strMo2233c = null;
                } else if (this.f4635c) {
                    if (c2178c5.f4679s != null) {
                        strMo2233c = c2371u.mo2233c(this.f4633a, c2178c5.mo1856n(), c2370t3._simpleName);
                    } else if (c2178c5.f4677q != null) {
                        strMo2233c = c2371u.mo2232b(this.f4633a, c2178c5.mo1854l(), c2370t3._simpleName);
                    } else {
                        strMo2233c = null;
                    }
                } else if (c2178c5.f4680t != null) {
                    strMo2233c = c2371u.mo2234d(this.f4633a, c2178c5.mo1861s(), c2370t3._simpleName);
                } else if (c2178c5.f4678r != null) {
                    strMo2233c = c2371u.mo2231a(this.f4633a, c2178c5.mo1853k(), c2370t3._simpleName);
                } else if (c2178c5.f4677q != null) {
                    strMo2233c = c2371u.mo2232b(this.f4633a, c2178c5.mo1854l(), c2370t3._simpleName);
                } else if (c2178c5.f4679s != null) {
                    strMo2233c = c2371u.mo2233c(this.f4633a, c2178c5.mo1856n(), c2370t3._simpleName);
                } else {
                    strMo2233c = null;
                }
                if (strMo2233c == null || c2370t3._simpleName.equals(strMo2233c)) {
                    strMo2233c = c2370t3._simpleName;
                } else {
                    C2370t c2370t4 = c2178c5.f4675o;
                    if (!strMo2233c.equals(c2370t4._simpleName)) {
                        c2370t4 = new C2370t(strMo2233c, c2370t4._namespace);
                    }
                    if (c2370t4 != c2178c5.f4675o) {
                        c2178c5 = new C2178c0(c2178c5, c2370t4);
                    }
                }
                C2178c0 c2178c6 = linkedHashMap.get(strMo2233c);
                if (c2178c6 == null) {
                    linkedHashMap.put(strMo2233c, c2178c5);
                } else {
                    c2178c6.m1846K(c2178c5);
                }
                m1828g(c2178c5, this.f4643k);
            }
        }
        if (this.f4633a.m2279q(EnumC2366p.USE_WRAPPER_NAME_AS_PROPERTY_NAME)) {
            Iterator<Map.Entry<String, C2178c0>> it4 = linkedHashMap.entrySet().iterator();
            while (it4.hasNext()) {
                if (it4.next().getValue().mo1859q() != null) {
                    Objects.requireNonNull(this.f4639g);
                }
            }
        }
        AbstractC2165b abstractC2165b5 = this.f4639g;
        Boolean boolMo1754J = abstractC2165b5.mo1754J(this.f4637e);
        if (boolMo1754J == null) {
            AbstractC2394l<?> abstractC2394l = this.f4633a;
            Objects.requireNonNull(abstractC2394l);
            zBooleanValue = abstractC2394l.m2279q(EnumC2366p.SORT_PROPERTIES_ALPHABETICALLY);
        } else {
            zBooleanValue = boolMo1754J.booleanValue();
        }
        Iterator<C2178c0> it5 = linkedHashMap.values().iterator();
        while (true) {
            if (it5.hasNext()) {
                if (it5.next().mo1857o()._index != null) {
                    z2 = true;
                    break;
                }
            } else {
                z2 = false;
                break;
            }
        }
        String[] strArrMo1753I = abstractC2165b5.mo1753I(this.f4637e);
        if (zBooleanValue || z2 || this.f4643k != null || strArrMo1753I != null) {
            int size = linkedHashMap.size();
            Map<? extends Object, ? extends Object> treeMap = zBooleanValue ? new TreeMap<>() : new LinkedHashMap<>(size + size);
            for (C2178c0 c2178c7 : linkedHashMap.values()) {
                treeMap.put(c2178c7.mo1858p(), c2178c7);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(size + size);
            if (strArrMo1753I != null) {
                for (String strMo1858p2 : strArrMo1753I) {
                    C2178c0 c2178c8 = (C2178c0) treeMap.remove(strMo1858p2);
                    if (c2178c8 == null) {
                        for (C2178c0 c2178c9 : linkedHashMap.values()) {
                            if (strMo1858p2.equals(c2178c9.f4676p._simpleName)) {
                                strMo1858p2 = c2178c9.mo1858p();
                                c2178c8 = c2178c9;
                                break;
                            }
                        }
                    }
                    if (c2178c8 != null) {
                        linkedHashMap2.put(strMo1858p2, c2178c8);
                    }
                }
            }
            if (z2) {
                TreeMap treeMap2 = new TreeMap();
                Iterator<Map.Entry<? extends Object, ? extends Object>> it6 = treeMap.entrySet().iterator();
                while (it6.hasNext()) {
                    C2178c0 c2178c10 = (C2178c0) it6.next().getValue();
                    Integer num = c2178c10.mo1857o()._index;
                    if (num != null) {
                        treeMap2.put(num, c2178c10);
                        it6.remove();
                    }
                }
                for (C2178c0 c2178c11 : treeMap2.values()) {
                    linkedHashMap2.put(c2178c11.mo1858p(), c2178c11);
                }
            }
            if (this.f4643k != null && (!zBooleanValue || this.f4633a.m2279q(EnumC2366p.SORT_CREATOR_PROPERTIES_FIRST))) {
                if (zBooleanValue) {
                    TreeMap treeMap3 = new TreeMap();
                    for (C2178c0 c2178c12 : this.f4643k) {
                        treeMap3.put(c2178c12.mo1858p(), c2178c12);
                    }
                    collectionValues = treeMap3.values();
                } else {
                    collectionValues = this.f4643k;
                }
                for (C2178c0 c2178c13 : collectionValues) {
                    String strMo1858p3 = c2178c13.mo1858p();
                    if (treeMap.containsKey(strMo1858p3)) {
                        linkedHashMap2.put(strMo1858p3, c2178c13);
                    }
                }
            }
            linkedHashMap2.putAll(treeMap);
            linkedHashMap.clear();
            linkedHashMap.putAll(linkedHashMap2);
        }
        this.f4642j = linkedHashMap;
        this.f4641i = true;
    }

    /* JADX INFO: renamed from: i */
    public void m1830i(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        StringBuilder sbM833U = C1643a.m833U("Problem with definition of ");
        sbM833U.append(this.f4637e);
        sbM833U.append(": ");
        sbM833U.append(str);
        throw new IllegalArgumentException(sbM833U.toString());
    }
}
