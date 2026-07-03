package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p195g.p196a.p197a.InterfaceC2081i;
import p007b.p195g.p196a.p197a.InterfaceC2094p;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.EnumC2112h;
import p007b.p195g.p196a.p198b.p203s.C2138b;
import p007b.p195g.p196a.p205c.AbstractC2165b;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.C2372v;
import p007b.p195g.p196a.p205c.EnumC2373w;
import p007b.p195g.p196a.p205c.InterfaceC2206d;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2188i;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2215g;
import p007b.p195g.p196a.p205c.p215g0.AbstractC2239h;
import p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i;
import p007b.p195g.p196a.p205c.p215g0.p216t.AbstractC2262l;
import p007b.p195g.p196a.p205c.p218h0.C2335n;
import p007b.p195g.p196a.p205c.p219i0.C2342d;
import p007b.p195g.p196a.p205c.p219i0.C2345g;
import p007b.p195g.p196a.p205c.p220y.InterfaceC2375a;

/* JADX INFO: renamed from: b.g.a.c.g0.u.t */
/* JADX INFO: compiled from: MapSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@InterfaceC2375a
public class C2310t extends AbstractC2239h<Map<?, ?>> implements InterfaceC2240i {

    /* JADX INFO: renamed from: k */
    public static final AbstractC2360j f4864k = C2335n.m2158k();

    /* JADX INFO: renamed from: l */
    public static final Object f4865l = InterfaceC2094p.a.NON_EMPTY;
    private static final long serialVersionUID = 1;
    public AbstractC2262l _dynamicValueSerializers;
    public final Object _filterId;
    public final Set<String> _ignoredEntries;
    public final Set<String> _includedEntries;
    public final C2345g _inclusionChecker;
    public AbstractC2364n<Object> _keySerializer;
    public final AbstractC2360j _keyType;
    public final InterfaceC2206d _property;
    public final boolean _sortKeys;
    public final boolean _suppressNulls;
    public final Object _suppressableValue;
    public AbstractC2364n<Object> _valueSerializer;
    public final AbstractC2360j _valueType;
    public final boolean _valueTypeIsStatic;
    public final AbstractC2215g _valueTypeSerializer;

    public C2310t(Set<String> set, Set<String> set2, AbstractC2360j abstractC2360j, AbstractC2360j abstractC2360j2, boolean z2, AbstractC2215g abstractC2215g, AbstractC2364n<?> abstractC2364n, AbstractC2364n<?> abstractC2364n2) {
        super(Map.class, false);
        C2345g c2345g = null;
        set = (set == null || set.isEmpty()) ? null : set;
        this._ignoredEntries = set;
        this._includedEntries = set2;
        this._keyType = abstractC2360j;
        this._valueType = abstractC2360j2;
        this._valueTypeIsStatic = z2;
        this._valueTypeSerializer = abstractC2215g;
        this._keySerializer = abstractC2364n;
        this._valueSerializer = abstractC2364n2;
        this._dynamicValueSerializers = AbstractC2262l.b.f4828b;
        this._property = null;
        this._filterId = null;
        this._sortKeys = false;
        this._suppressableValue = null;
        this._suppressNulls = false;
        if (set2 != null || (set != null && !set.isEmpty())) {
            c2345g = new C2345g(set, set2);
        }
        this._inclusionChecker = c2345g;
    }

    /* JADX INFO: renamed from: s */
    public static C2310t m2082s(Set<String> set, Set<String> set2, AbstractC2360j abstractC2360j, boolean z2, AbstractC2215g abstractC2215g, AbstractC2364n<Object> abstractC2364n, AbstractC2364n<Object> abstractC2364n2, Object obj) {
        AbstractC2360j abstractC2360jM2158k;
        AbstractC2360j abstractC2360j2;
        boolean z3;
        if (abstractC2360j == null) {
            abstractC2360j2 = f4864k;
            abstractC2360jM2158k = abstractC2360j2;
        } else {
            AbstractC2360j abstractC2360jMo2121o = abstractC2360j.mo2121o();
            abstractC2360jM2158k = abstractC2360j._class == Properties.class ? C2335n.m2158k() : abstractC2360j.mo2099k();
            abstractC2360j2 = abstractC2360jMo2121o;
        }
        if (z2) {
            z3 = abstractC2360jM2158k._class == Object.class ? false : z2;
        } else {
            z3 = abstractC2360jM2158k != null && abstractC2360jM2158k.m2220x();
        }
        C2310t c2310t = new C2310t(set, set2, abstractC2360j2, abstractC2360jM2158k, z3, abstractC2215g, abstractC2364n, abstractC2364n2);
        if (obj == null || c2310t._filterId == obj) {
            return c2310t;
        }
        C2342d.m2194z(C2310t.class, c2310t, "withFilterId");
        return new C2310t(c2310t, obj, c2310t._sortKeys);
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0194 A[PHI: r11
      0x0194: PHI (r11v1 java.lang.Object) = (r11v0 java.lang.Object), (r11v0 java.lang.Object), (r11v3 java.lang.Object), (r11v4 java.lang.Object) binds: [B:83:0x0151, B:104:0x018f, B:106:0x0193, B:94:0x0167] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // p007b.p195g.p196a.p205c.p215g0.InterfaceC2240i
    /* JADX INFO: renamed from: a */
    public AbstractC2364n<?> mo1997a(AbstractC2374x abstractC2374x, InterfaceC2206d interfaceC2206d) throws JsonMappingException {
        AbstractC2364n<?> abstractC2364nMo2000H;
        AbstractC2364n<Object> abstractC2364nMo2000H2;
        Set<String> set;
        Set<String> set2;
        boolean zBooleanValue;
        C2310t c2310t;
        InterfaceC2094p.a aVar;
        boolean zMo1999B;
        Object objM572t0;
        Boolean boolM1598b;
        AbstractC2165b abstractC2165bM2257v = abstractC2374x.m2257v();
        Object objMo1998A = null;
        AbstractC2188i member = interfaceC2206d == null ? null : interfaceC2206d.getMember();
        if (AbstractC2305q0.m2072j(member, abstractC2165bM2257v)) {
            Object objMo1788l = abstractC2165bM2257v.mo1788l(member);
            abstractC2364nMo2000H = objMo1788l != null ? abstractC2374x.mo2000H(member, objMo1788l) : null;
            Object objMo1775c = abstractC2165bM2257v.mo1775c(member);
            abstractC2364nMo2000H2 = objMo1775c != null ? abstractC2374x.mo2000H(member, objMo1775c) : null;
        } else {
            abstractC2364nMo2000H = null;
            abstractC2364nMo2000H2 = null;
        }
        if (abstractC2364nMo2000H2 == null) {
            abstractC2364nMo2000H2 = this._valueSerializer;
        }
        AbstractC2364n<?> abstractC2364nM2073k = m2073k(abstractC2374x, interfaceC2206d, abstractC2364nMo2000H2);
        if (abstractC2364nM2073k == null && this._valueTypeIsStatic && !this._valueType.m2221y()) {
            abstractC2364nM2073k = abstractC2374x.m2249m(this._valueType, interfaceC2206d);
        }
        AbstractC2364n<?> abstractC2364n = abstractC2364nM2073k;
        if (abstractC2364nMo2000H == null) {
            abstractC2364nMo2000H = this._keySerializer;
        }
        AbstractC2364n<?> abstractC2364nM2251o = abstractC2364nMo2000H == null ? abstractC2374x.m2251o(this._keyType, interfaceC2206d) : abstractC2374x.m2261z(abstractC2364nMo2000H, interfaceC2206d);
        Set<String> hashSet = this._ignoredEntries;
        Set<String> hashSet2 = this._includedEntries;
        if (AbstractC2305q0.m2072j(member, abstractC2165bM2257v)) {
            C2372v c2372v = abstractC2374x._config;
            Set<String> setM1617d = abstractC2165bM2257v.mo1800x(c2372v, member).m1617d();
            if ((setM1617d == null || setM1617d.isEmpty()) ? false : true) {
                hashSet = hashSet == null ? new HashSet<>() : new HashSet(hashSet);
                Iterator<String> it = setM1617d.iterator();
                while (it.hasNext()) {
                    hashSet.add(it.next());
                }
            }
            Set<String> set3 = abstractC2165bM2257v.mo1745A(c2372v, member)._included;
            if (set3 != null) {
                hashSet2 = hashSet2 == null ? new HashSet<>() : new HashSet(hashSet2);
                Iterator<String> it2 = set3.iterator();
                while (it2.hasNext()) {
                    hashSet2.add(it2.next());
                }
            }
            zBooleanValue = Boolean.TRUE.equals(abstractC2165bM2257v.mo1754J(member));
            set = hashSet;
            set2 = hashSet2;
        } else {
            set = hashSet;
            set2 = hashSet2;
            zBooleanValue = false;
        }
        InterfaceC2081i.d dVarM2074l = m2074l(abstractC2374x, interfaceC2206d, Map.class);
        if (dVarM2074l != null && (boolM1598b = dVarM2074l.m1598b(InterfaceC2081i.a.WRITE_SORTED_MAP_ENTRIES)) != null) {
            zBooleanValue = boolM1598b.booleanValue();
        }
        boolean z2 = zBooleanValue;
        C2342d.m2194z(C2310t.class, this, "withResolved");
        C2310t c2310t2 = new C2310t(this, interfaceC2206d, abstractC2364nM2251o, abstractC2364n, set, set2);
        if (z2 != c2310t2._sortKeys) {
            c2310t = new C2310t(c2310t2, this._filterId, z2);
        }
        if (member != null) {
            c2310t = c2310t2;
            Object objMo1783g = abstractC2165bM2257v.mo1783g(member);
            if (objMo1783g != null && c2310t._filterId != objMo1783g) {
                C2342d.m2194z(C2310t.class, c2310t, "withFilterId");
                c2310t = new C2310t(c2310t, objMo1783g, c2310t._sortKeys);
            }
        }
        c2310t = c2310t2;
        InterfaceC2094p.b bVarMo1929b = interfaceC2206d != null ? interfaceC2206d.mo1929b(abstractC2374x._config, Map.class) : abstractC2374x._config.mo2272j(Map.class);
        if (bVarMo1929b == null || (aVar = bVarMo1929b._contentInclusion) == InterfaceC2094p.a.USE_DEFAULTS) {
            return c2310t;
        }
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 1) {
            zMo1999B = true;
        } else if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                objM572t0 = f4865l;
            } else if (iOrdinal == 4) {
                objM572t0 = C1460d.m572t0(this._valueType);
                if (objM572t0 != null && objM572t0.getClass().isArray()) {
                    objM572t0 = C1460d.m560q0(objM572t0);
                }
            } else if (iOrdinal != 5) {
                zMo1999B = false;
            } else {
                objMo1998A = abstractC2374x.mo1998A(null, bVarMo1929b._contentFilter);
                if (objMo1998A == null) {
                    zMo1999B = true;
                } else {
                    zMo1999B = abstractC2374x.mo1999B(objMo1998A);
                }
            }
            objMo1998A = objM572t0;
            zMo1999B = true;
        } else {
            if (this._valueType.mo1728b()) {
                objM572t0 = f4865l;
                objMo1998A = objM572t0;
            }
            zMo1999B = true;
        }
        return c2310t.m2086v(objMo1998A, zMo1999B);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: d */
    public boolean mo2021d(AbstractC2374x abstractC2374x, Object obj) {
        Map map = (Map) obj;
        if (!map.isEmpty()) {
            Object obj2 = this._suppressableValue;
            if (obj2 == null && !this._suppressNulls) {
                return false;
            }
            AbstractC2364n<Object> abstractC2364n = this._valueSerializer;
            boolean z2 = f4865l == obj2;
            if (abstractC2364n != null) {
                for (Object obj3 : map.values()) {
                    if (obj3 == null) {
                        if (!this._suppressNulls) {
                            return false;
                        }
                    } else if (z2) {
                        if (!abstractC2364n.mo2021d(abstractC2374x, obj3)) {
                            return false;
                        }
                    } else if (obj2 == null || !obj2.equals(map)) {
                        return false;
                    }
                }
            } else {
                for (Object obj4 : map.values()) {
                    if (obj4 != null) {
                        try {
                            AbstractC2364n<Object> abstractC2364nM2083r = m2083r(abstractC2374x, obj4);
                            if (z2) {
                                if (!abstractC2364nM2083r.mo2021d(abstractC2374x, obj4)) {
                                    return false;
                                }
                            } else if (obj2 == null || !obj2.equals(map)) {
                                return false;
                            }
                        } catch (JsonMappingException unused) {
                            return false;
                        }
                    } else if (!this._suppressNulls) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        Map<?, ?> map = (Map) obj;
        abstractC2108d.mo1653d0(map);
        m2085u(map, abstractC2108d, abstractC2374x);
        abstractC2108d.mo1664u();
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: g */
    public void mo1808g(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, AbstractC2215g abstractC2215g) throws IOException {
        Map<?, ?> map = (Map) obj;
        abstractC2108d.mo1654e(map);
        C2138b c2138bMo1959e = abstractC2215g.mo1959e(abstractC2108d, abstractC2215g.m1958d(map, EnumC2112h.START_OBJECT));
        m2085u(map, abstractC2108d, abstractC2374x);
        abstractC2215g.mo1960f(abstractC2108d, c2138bMo1959e);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.AbstractC2239h
    /* JADX INFO: renamed from: p */
    public AbstractC2239h mo1995p(AbstractC2215g abstractC2215g) {
        if (this._valueTypeSerializer == abstractC2215g) {
            return this;
        }
        C2342d.m2194z(C2310t.class, this, "_withValueTypeSerializer");
        return new C2310t(this, abstractC2215g, this._suppressableValue, this._suppressNulls);
    }

    /* JADX INFO: renamed from: r */
    public final AbstractC2364n<Object> m2083r(AbstractC2374x abstractC2374x, Object obj) throws JsonMappingException {
        Class<?> cls = obj.getClass();
        AbstractC2364n<Object> abstractC2364nMo2034c = this._dynamicValueSerializers.mo2034c(cls);
        if (abstractC2364nMo2034c != null) {
            return abstractC2364nMo2034c;
        }
        if (this._valueType.mo2102r()) {
            AbstractC2262l abstractC2262l = this._dynamicValueSerializers;
            AbstractC2262l.d dVarM2032a = abstractC2262l.m2032a(abstractC2374x.m2247k(this._valueType, cls), abstractC2374x, this._property);
            AbstractC2262l abstractC2262l2 = dVarM2032a.f4831b;
            if (abstractC2262l != abstractC2262l2) {
                this._dynamicValueSerializers = abstractC2262l2;
            }
            return dVarM2032a.f4830a;
        }
        AbstractC2262l abstractC2262l3 = this._dynamicValueSerializers;
        InterfaceC2206d interfaceC2206d = this._property;
        Objects.requireNonNull(abstractC2262l3);
        AbstractC2364n<Object> abstractC2364nM2250n = abstractC2374x.m2250n(cls, interfaceC2206d);
        AbstractC2262l abstractC2262lMo2033b = abstractC2262l3.mo2033b(cls, abstractC2364nM2250n);
        if (abstractC2262l3 != abstractC2262lMo2033b) {
            this._dynamicValueSerializers = abstractC2262lMo2033b;
        }
        return abstractC2364nM2250n;
    }

    /* JADX INFO: renamed from: t */
    public void m2084t(Map<?, ?> map, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x, Object obj) throws IOException {
        AbstractC2364n<Object> abstractC2364n;
        AbstractC2364n<Object> abstractC2364nM2083r;
        boolean z2 = f4865l == obj;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            if (key == null) {
                abstractC2364n = abstractC2374x._nullKeySerializer;
            } else {
                C2345g c2345g = this._inclusionChecker;
                if (c2345g == null || !c2345g.m2201a(key)) {
                    abstractC2364n = this._keySerializer;
                }
            }
            Object value = entry.getValue();
            if (value != null) {
                abstractC2364nM2083r = this._valueSerializer;
                if (abstractC2364nM2083r == null) {
                    abstractC2364nM2083r = m2083r(abstractC2374x, value);
                }
                if (z2) {
                    if (abstractC2364nM2083r.mo2021d(abstractC2374x, value)) {
                        continue;
                    } else {
                        abstractC2364n.mo1807f(key, abstractC2108d, abstractC2374x);
                        abstractC2364nM2083r.mo1808g(value, abstractC2108d, abstractC2374x, this._valueTypeSerializer);
                    }
                } else if (obj == null || !obj.equals(value)) {
                    abstractC2364n.mo1807f(key, abstractC2108d, abstractC2374x);
                    abstractC2364nM2083r.mo1808g(value, abstractC2108d, abstractC2374x, this._valueTypeSerializer);
                }
            } else if (this._suppressNulls) {
                continue;
            } else {
                abstractC2364nM2083r = abstractC2374x._nullValueSerializer;
                abstractC2364n.mo1807f(key, abstractC2108d, abstractC2374x);
                try {
                    abstractC2364nM2083r.mo1808g(value, abstractC2108d, abstractC2374x, this._valueTypeSerializer);
                } catch (Exception e) {
                    m2077o(abstractC2374x, e, map, String.valueOf(key));
                    throw null;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:153:0x0077 A[EXC_TOP_SPLITTER, PHI: r6
      0x0077: PHI (r6v2 b.g.a.c.n<java.lang.Object>) = 
      (r6v1 b.g.a.c.n<java.lang.Object>)
      (r6v4 b.g.a.c.n<java.lang.Object>)
      (r6v4 b.g.a.c.n<java.lang.Object>)
      (r6v4 b.g.a.c.n<java.lang.Object>)
     binds: [B:28:0x0056, B:35:0x006b, B:37:0x006e, B:39:0x0074] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:157:0x01b1 A[EXC_TOP_SPLITTER, PHI: r7
      0x01b1: PHI (r7v5 b.g.a.c.n<java.lang.Object>) = 
      (r7v4 b.g.a.c.n<java.lang.Object>)
      (r7v7 b.g.a.c.n<java.lang.Object>)
      (r7v7 b.g.a.c.n<java.lang.Object>)
      (r7v7 b.g.a.c.n<java.lang.Object>)
     binds: [B:133:0x0194, B:139:0x01a5, B:141:0x01a8, B:143:0x01ae] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX INFO: renamed from: u */
    public void m2085u(Map<?, ?> map, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        TreeMap treeMap;
        AbstractC2364n<Object> abstractC2364nM2083r;
        AbstractC2364n<Object> abstractC2364n;
        AbstractC2364n<Object> abstractC2364nM2083r2;
        Object key;
        if (map.isEmpty()) {
            return;
        }
        if ((this._sortKeys || abstractC2374x.m2240D(EnumC2373w.ORDER_MAP_ENTRIES_BY_KEYS)) && !(map instanceof SortedMap)) {
            if ((map instanceof HashMap) && map.containsKey(null)) {
                treeMap = new TreeMap();
                for (Map.Entry<?, ?> entry : map.entrySet()) {
                    Object key2 = entry.getKey();
                    if (key2 == null) {
                        Object value = entry.getValue();
                        AbstractC2364n<Object> abstractC2364n2 = abstractC2374x._nullKeySerializer;
                        if (value != null) {
                            abstractC2364nM2083r = this._valueSerializer;
                            if (abstractC2364nM2083r == null) {
                                abstractC2364nM2083r = m2083r(abstractC2374x, value);
                            }
                            Object obj = this._suppressableValue;
                            if (obj == f4865l) {
                                if (abstractC2364nM2083r.mo2021d(abstractC2374x, value)) {
                                    continue;
                                } else {
                                    abstractC2364n2.mo1807f(null, abstractC2108d, abstractC2374x);
                                    abstractC2364nM2083r.mo1807f(value, abstractC2108d, abstractC2374x);
                                }
                            } else if (obj == null || !obj.equals(value)) {
                                abstractC2364n2.mo1807f(null, abstractC2108d, abstractC2374x);
                                abstractC2364nM2083r.mo1807f(value, abstractC2108d, abstractC2374x);
                            }
                        } else if (this._suppressNulls) {
                            continue;
                        } else {
                            abstractC2364nM2083r = abstractC2374x._nullValueSerializer;
                            try {
                                abstractC2364n2.mo1807f(null, abstractC2108d, abstractC2374x);
                                abstractC2364nM2083r.mo1807f(value, abstractC2108d, abstractC2374x);
                            } catch (Exception e) {
                                m2077o(abstractC2374x, e, value, "");
                                throw null;
                            }
                        }
                    } else {
                        treeMap.put(key2, entry.getValue());
                    }
                }
            } else {
                treeMap = new TreeMap(map);
            }
            map = treeMap;
        }
        Object obj2 = this._filterId;
        if (obj2 != null) {
            m2075m(abstractC2374x, obj2, map);
            throw null;
        }
        Object obj3 = this._suppressableValue;
        if (obj3 != null || this._suppressNulls) {
            if (this._valueTypeSerializer != null) {
                m2084t(map, abstractC2108d, abstractC2374x, obj3);
                return;
            }
            boolean z2 = f4865l == obj3;
            for (Map.Entry<?, ?> entry2 : map.entrySet()) {
                Object key3 = entry2.getKey();
                if (key3 == null) {
                    abstractC2364n = abstractC2374x._nullKeySerializer;
                } else {
                    C2345g c2345g = this._inclusionChecker;
                    if (c2345g == null || !c2345g.m2201a(key3)) {
                        abstractC2364n = this._keySerializer;
                    }
                }
                Object value2 = entry2.getValue();
                if (value2 != null) {
                    abstractC2364nM2083r2 = this._valueSerializer;
                    if (abstractC2364nM2083r2 == null) {
                        abstractC2364nM2083r2 = m2083r(abstractC2374x, value2);
                    }
                    if (z2) {
                        if (abstractC2364nM2083r2.mo2021d(abstractC2374x, value2)) {
                            continue;
                        } else {
                            abstractC2364n.mo1807f(key3, abstractC2108d, abstractC2374x);
                            abstractC2364nM2083r2.mo1807f(value2, abstractC2108d, abstractC2374x);
                        }
                    } else if (obj3 == null || !obj3.equals(value2)) {
                        abstractC2364n.mo1807f(key3, abstractC2108d, abstractC2374x);
                        abstractC2364nM2083r2.mo1807f(value2, abstractC2108d, abstractC2374x);
                    }
                } else if (this._suppressNulls) {
                    continue;
                } else {
                    abstractC2364nM2083r2 = abstractC2374x._nullValueSerializer;
                    try {
                        abstractC2364n.mo1807f(key3, abstractC2108d, abstractC2374x);
                        abstractC2364nM2083r2.mo1807f(value2, abstractC2108d, abstractC2374x);
                    } catch (Exception e2) {
                        m2077o(abstractC2374x, e2, map, String.valueOf(key3));
                        throw null;
                    }
                }
            }
            return;
        }
        AbstractC2364n<Object> abstractC2364n3 = this._valueSerializer;
        if (abstractC2364n3 != null) {
            AbstractC2364n<Object> abstractC2364n4 = this._keySerializer;
            AbstractC2215g abstractC2215g = this._valueTypeSerializer;
            for (Map.Entry<?, ?> entry3 : map.entrySet()) {
                Object key4 = entry3.getKey();
                C2345g c2345g2 = this._inclusionChecker;
                if (c2345g2 == null || !c2345g2.m2201a(key4)) {
                    if (key4 == null) {
                        abstractC2374x._nullKeySerializer.mo1807f(null, abstractC2108d, abstractC2374x);
                    } else {
                        abstractC2364n4.mo1807f(key4, abstractC2108d, abstractC2374x);
                    }
                    Object value3 = entry3.getValue();
                    if (value3 == null) {
                        abstractC2374x.m2248l(abstractC2108d);
                    } else if (abstractC2215g == null) {
                        try {
                            abstractC2364n3.mo1807f(value3, abstractC2108d, abstractC2374x);
                        } catch (Exception e3) {
                            m2077o(abstractC2374x, e3, map, String.valueOf(key4));
                            throw null;
                        }
                    } else {
                        abstractC2364n3.mo1808g(value3, abstractC2108d, abstractC2374x, abstractC2215g);
                    }
                }
            }
            return;
        }
        if (this._valueTypeSerializer != null) {
            m2084t(map, abstractC2108d, abstractC2374x, null);
            return;
        }
        AbstractC2364n<Object> abstractC2364n5 = this._keySerializer;
        try {
            key = null;
            for (Map.Entry<?, ?> entry4 : map.entrySet()) {
                try {
                    Object value4 = entry4.getValue();
                    key = entry4.getKey();
                    if (key == null) {
                        abstractC2374x._nullKeySerializer.mo1807f(null, abstractC2108d, abstractC2374x);
                    } else {
                        C2345g c2345g3 = this._inclusionChecker;
                        if (c2345g3 == null || !c2345g3.m2201a(key)) {
                            abstractC2364n5.mo1807f(key, abstractC2108d, abstractC2374x);
                        }
                    }
                    if (value4 == null) {
                        abstractC2374x.m2248l(abstractC2108d);
                    } else {
                        AbstractC2364n<Object> abstractC2364nM2083r3 = this._valueSerializer;
                        if (abstractC2364nM2083r3 == null) {
                            abstractC2364nM2083r3 = m2083r(abstractC2374x, value4);
                        }
                        abstractC2364nM2083r3.mo1807f(value4, abstractC2108d, abstractC2374x);
                    }
                } catch (Exception e4) {
                    e = e4;
                    m2077o(abstractC2374x, e, map, String.valueOf(key));
                    throw null;
                }
            }
        } catch (Exception e5) {
            e = e5;
            key = null;
        }
    }

    /* JADX INFO: renamed from: v */
    public C2310t m2086v(Object obj, boolean z2) {
        if (obj == this._suppressableValue && z2 == this._suppressNulls) {
            return this;
        }
        C2342d.m2194z(C2310t.class, this, "withContentInclusion");
        return new C2310t(this, this._valueTypeSerializer, obj, z2);
    }

    public C2310t(C2310t c2310t, InterfaceC2206d interfaceC2206d, AbstractC2364n<?> abstractC2364n, AbstractC2364n<?> abstractC2364n2, Set<String> set, Set<String> set2) {
        super(Map.class, false);
        C2345g c2345g = null;
        set = (set == null || set.isEmpty()) ? null : set;
        this._ignoredEntries = set;
        this._includedEntries = set2;
        this._keyType = c2310t._keyType;
        this._valueType = c2310t._valueType;
        this._valueTypeIsStatic = c2310t._valueTypeIsStatic;
        this._valueTypeSerializer = c2310t._valueTypeSerializer;
        this._keySerializer = abstractC2364n;
        this._valueSerializer = abstractC2364n2;
        this._dynamicValueSerializers = AbstractC2262l.b.f4828b;
        this._property = interfaceC2206d;
        this._filterId = c2310t._filterId;
        this._sortKeys = c2310t._sortKeys;
        this._suppressableValue = c2310t._suppressableValue;
        this._suppressNulls = c2310t._suppressNulls;
        if (set2 != null || (set != null && !set.isEmpty())) {
            c2345g = new C2345g(set, set2);
        }
        this._inclusionChecker = c2345g;
    }

    public C2310t(C2310t c2310t, AbstractC2215g abstractC2215g, Object obj, boolean z2) {
        super(Map.class, false);
        this._ignoredEntries = c2310t._ignoredEntries;
        this._includedEntries = c2310t._includedEntries;
        this._keyType = c2310t._keyType;
        this._valueType = c2310t._valueType;
        this._valueTypeIsStatic = c2310t._valueTypeIsStatic;
        this._valueTypeSerializer = abstractC2215g;
        this._keySerializer = c2310t._keySerializer;
        this._valueSerializer = c2310t._valueSerializer;
        this._dynamicValueSerializers = c2310t._dynamicValueSerializers;
        this._property = c2310t._property;
        this._filterId = c2310t._filterId;
        this._sortKeys = c2310t._sortKeys;
        this._suppressableValue = obj;
        this._suppressNulls = z2;
        this._inclusionChecker = c2310t._inclusionChecker;
    }

    public C2310t(C2310t c2310t, Object obj, boolean z2) {
        super(Map.class, false);
        this._ignoredEntries = c2310t._ignoredEntries;
        this._includedEntries = c2310t._includedEntries;
        this._keyType = c2310t._keyType;
        this._valueType = c2310t._valueType;
        this._valueTypeIsStatic = c2310t._valueTypeIsStatic;
        this._valueTypeSerializer = c2310t._valueTypeSerializer;
        this._keySerializer = c2310t._keySerializer;
        this._valueSerializer = c2310t._valueSerializer;
        this._dynamicValueSerializers = AbstractC2262l.b.f4828b;
        this._property = c2310t._property;
        this._filterId = obj;
        this._sortKeys = z2;
        this._suppressableValue = c2310t._suppressableValue;
        this._suppressNulls = c2310t._suppressNulls;
        this._inclusionChecker = c2310t._inclusionChecker;
    }
}
