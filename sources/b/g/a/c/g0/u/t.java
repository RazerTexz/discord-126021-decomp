package b.g.a.c.g0.u;

import b.g.a.a.i$a;
import b.g.a.a.i$d;
import b.g.a.a.p$a;
import b.g.a.a.p$b;
import b.g.a.c.g0.t.l$b;
import b.g.a.c.g0.t.l$d;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: MapSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@b.g.a.c.y.a
public class t extends b.g.a.c.g0.h<Map<?, ?>> implements b.g.a.c.g0.i {
    public static final b.g.a.c.j k = b.g.a.c.h0.n.k();
    public static final Object l = p$a.NON_EMPTY;
    private static final long serialVersionUID = 1;
    public b.g.a.c.g0.t.l _dynamicValueSerializers;
    public final Object _filterId;
    public final Set<String> _ignoredEntries;
    public final Set<String> _includedEntries;
    public final b.g.a.c.i0.g _inclusionChecker;
    public b.g.a.c.n<Object> _keySerializer;
    public final b.g.a.c.j _keyType;
    public final b.g.a.c.d _property;
    public final boolean _sortKeys;
    public final boolean _suppressNulls;
    public final Object _suppressableValue;
    public b.g.a.c.n<Object> _valueSerializer;
    public final b.g.a.c.j _valueType;
    public final boolean _valueTypeIsStatic;
    public final b.g.a.c.e0.g _valueTypeSerializer;

    public t(Set<String> set, Set<String> set2, b.g.a.c.j jVar, b.g.a.c.j jVar2, boolean z2, b.g.a.c.e0.g gVar, b.g.a.c.n<?> nVar, b.g.a.c.n<?> nVar2) {
        super(Map.class, false);
        b.g.a.c.i0.g gVar2 = null;
        set = (set == null || set.isEmpty()) ? null : set;
        this._ignoredEntries = set;
        this._includedEntries = set2;
        this._keyType = jVar;
        this._valueType = jVar2;
        this._valueTypeIsStatic = z2;
        this._valueTypeSerializer = gVar;
        this._keySerializer = nVar;
        this._valueSerializer = nVar2;
        this._dynamicValueSerializers = l$b.f706b;
        this._property = null;
        this._filterId = null;
        this._sortKeys = false;
        this._suppressableValue = null;
        this._suppressNulls = false;
        if (set2 != null || (set != null && !set.isEmpty())) {
            gVar2 = new b.g.a.c.i0.g(set, set2);
        }
        this._inclusionChecker = gVar2;
    }

    public static t s(Set<String> set, Set<String> set2, b.g.a.c.j jVar, boolean z2, b.g.a.c.e0.g gVar, b.g.a.c.n<Object> nVar, b.g.a.c.n<Object> nVar2, Object obj) {
        b.g.a.c.j jVarK;
        b.g.a.c.j jVar2;
        boolean z3;
        if (jVar == null) {
            jVar2 = k;
            jVarK = jVar2;
        } else {
            b.g.a.c.j jVarO = jVar.o();
            jVarK = jVar._class == Properties.class ? b.g.a.c.h0.n.k() : jVar.k();
            jVar2 = jVarO;
        }
        if (z2) {
            z3 = jVarK._class == Object.class ? false : z2;
        } else {
            z3 = jVarK != null && jVarK.x();
        }
        t tVar = new t(set, set2, jVar2, jVarK, z3, gVar, nVar, nVar2);
        if (obj == null || tVar._filterId == obj) {
            return tVar;
        }
        b.g.a.c.i0.d.z(t.class, tVar, "withFilterId");
        return new t(tVar, obj, tVar._sortKeys);
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0194 A[PHI: r11
      0x0194: PHI (r11v1 java.lang.Object) = (r11v0 java.lang.Object), (r11v0 java.lang.Object), (r11v3 java.lang.Object), (r11v4 java.lang.Object) binds: [B:83:0x0151, B:104:0x018f, B:106:0x0193, B:94:0x0167] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // b.g.a.c.g0.i
    public b.g.a.c.n<?> a(b.g.a.c.x xVar, b.g.a.c.d dVar) throws JsonMappingException {
        b.g.a.c.n<?> nVarH;
        b.g.a.c.n<Object> nVarH2;
        Set<String> set;
        Set<String> set2;
        boolean zBooleanValue;
        t tVar;
        p$a p_a;
        boolean zB;
        Object objT0;
        Boolean boolB;
        b.g.a.c.b bVarV = xVar.v();
        Object objA = null;
        b.g.a.c.c0.i member = dVar == null ? null : dVar.getMember();
        if (q0.j(member, bVarV)) {
            Object objL = bVarV.l(member);
            nVarH = objL != null ? xVar.H(member, objL) : null;
            Object objC = bVarV.c(member);
            nVarH2 = objC != null ? xVar.H(member, objC) : null;
        } else {
            nVarH = null;
            nVarH2 = null;
        }
        if (nVarH2 == null) {
            nVarH2 = this._valueSerializer;
        }
        b.g.a.c.n<?> nVarK = k(xVar, dVar, nVarH2);
        if (nVarK == null && this._valueTypeIsStatic && !this._valueType.y()) {
            nVarK = xVar.m(this._valueType, dVar);
        }
        b.g.a.c.n<?> nVar = nVarK;
        if (nVarH == null) {
            nVarH = this._keySerializer;
        }
        b.g.a.c.n<?> nVarO = nVarH == null ? xVar.o(this._keyType, dVar) : xVar.z(nVarH, dVar);
        Set<String> hashSet = this._ignoredEntries;
        Set<String> hashSet2 = this._includedEntries;
        if (q0.j(member, bVarV)) {
            b.g.a.c.v vVar = xVar._config;
            Set<String> setD = bVarV.x(vVar, member).d();
            if ((setD == null || setD.isEmpty()) ? false : true) {
                hashSet = hashSet == null ? new HashSet<>() : new HashSet(hashSet);
                Iterator<String> it = setD.iterator();
                while (it.hasNext()) {
                    hashSet.add(it.next());
                }
            }
            Set<String> set3 = bVarV.A(vVar, member)._included;
            if (set3 != null) {
                hashSet2 = hashSet2 == null ? new HashSet<>() : new HashSet(hashSet2);
                Iterator<String> it2 = set3.iterator();
                while (it2.hasNext()) {
                    hashSet2.add(it2.next());
                }
            }
            zBooleanValue = Boolean.TRUE.equals(bVarV.J(member));
            set = hashSet;
            set2 = hashSet2;
        } else {
            set = hashSet;
            set2 = hashSet2;
            zBooleanValue = false;
        }
        i$d i_dL = l(xVar, dVar, Map.class);
        if (i_dL != null && (boolB = i_dL.b(i$a.WRITE_SORTED_MAP_ENTRIES)) != null) {
            zBooleanValue = boolB.booleanValue();
        }
        boolean z2 = zBooleanValue;
        b.g.a.c.i0.d.z(t.class, this, "withResolved");
        t tVar2 = new t(this, dVar, nVarO, nVar, set, set2);
        if (z2 != tVar2._sortKeys) {
            tVar = new t(tVar2, this._filterId, z2);
        }
        if (member != null) {
            tVar = tVar2;
            Object objG = bVarV.g(member);
            if (objG != null && tVar._filterId != objG) {
                b.g.a.c.i0.d.z(t.class, tVar, "withFilterId");
                tVar = new t(tVar, objG, tVar._sortKeys);
            }
        }
        tVar = tVar2;
        p$b p_bB = dVar != null ? dVar.b(xVar._config, Map.class) : xVar._config.j(Map.class);
        if (p_bB == null || (p_a = p_bB._contentInclusion) == p$a.USE_DEFAULTS) {
            return tVar;
        }
        int iOrdinal = p_a.ordinal();
        if (iOrdinal == 1) {
            zB = true;
        } else if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                objT0 = l;
            } else if (iOrdinal == 4) {
                objT0 = b.c.a.a0.d.t0(this._valueType);
                if (objT0 != null && objT0.getClass().isArray()) {
                    objT0 = b.c.a.a0.d.q0(objT0);
                }
            } else if (iOrdinal != 5) {
                zB = false;
            } else {
                objA = xVar.A(null, p_bB._contentFilter);
                if (objA == null) {
                    zB = true;
                } else {
                    zB = xVar.B(objA);
                }
            }
            objA = objT0;
            zB = true;
        } else {
            if (this._valueType.b()) {
                objT0 = l;
                objA = objT0;
            }
            zB = true;
        }
        return tVar.v(objA, zB);
    }

    @Override // b.g.a.c.n
    public boolean d(b.g.a.c.x xVar, Object obj) {
        Map map = (Map) obj;
        if (!map.isEmpty()) {
            Object obj2 = this._suppressableValue;
            if (obj2 == null && !this._suppressNulls) {
                return false;
            }
            b.g.a.c.n<Object> nVar = this._valueSerializer;
            boolean z2 = l == obj2;
            if (nVar != null) {
                for (Object obj3 : map.values()) {
                    if (obj3 == null) {
                        if (!this._suppressNulls) {
                            return false;
                        }
                    } else if (z2) {
                        if (!nVar.d(xVar, obj3)) {
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
                            b.g.a.c.n<Object> nVarR = r(xVar, obj4);
                            if (z2) {
                                if (!nVarR.d(xVar, obj4)) {
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

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        Map<?, ?> map = (Map) obj;
        dVar.d0(map);
        u(map, dVar, xVar);
        dVar.u();
    }

    @Override // b.g.a.c.n
    public void g(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar, b.g.a.c.e0.g gVar) throws IOException {
        Map<?, ?> map = (Map) obj;
        dVar.e(map);
        b.g.a.b.s.b bVarE = gVar.e(dVar, gVar.d(map, b.g.a.b.h.START_OBJECT));
        u(map, dVar, xVar);
        gVar.f(dVar, bVarE);
    }

    @Override // b.g.a.c.g0.h
    public b.g.a.c.g0.h p(b.g.a.c.e0.g gVar) {
        if (this._valueTypeSerializer == gVar) {
            return this;
        }
        b.g.a.c.i0.d.z(t.class, this, "_withValueTypeSerializer");
        return new t(this, gVar, this._suppressableValue, this._suppressNulls);
    }

    public final b.g.a.c.n<Object> r(b.g.a.c.x xVar, Object obj) throws JsonMappingException {
        Class<?> cls = obj.getClass();
        b.g.a.c.n<Object> nVarC = this._dynamicValueSerializers.c(cls);
        if (nVarC != null) {
            return nVarC;
        }
        if (this._valueType.r()) {
            b.g.a.c.g0.t.l lVar = this._dynamicValueSerializers;
            l$d l_dA = lVar.a(xVar.k(this._valueType, cls), xVar, this._property);
            b.g.a.c.g0.t.l lVar2 = l_dA.f708b;
            if (lVar != lVar2) {
                this._dynamicValueSerializers = lVar2;
            }
            return l_dA.a;
        }
        b.g.a.c.g0.t.l lVar3 = this._dynamicValueSerializers;
        b.g.a.c.d dVar = this._property;
        Objects.requireNonNull(lVar3);
        b.g.a.c.n<Object> nVarN = xVar.n(cls, dVar);
        b.g.a.c.g0.t.l lVarB = lVar3.b(cls, nVarN);
        if (lVar3 != lVarB) {
            this._dynamicValueSerializers = lVarB;
        }
        return nVarN;
    }

    public void t(Map<?, ?> map, b.g.a.b.d dVar, b.g.a.c.x xVar, Object obj) throws IOException {
        b.g.a.c.n<Object> nVar;
        b.g.a.c.n<Object> nVarR;
        boolean z2 = l == obj;
        for (Map$Entry<?, ?> map$Entry : map.entrySet()) {
            Object key = map$Entry.getKey();
            if (key == null) {
                nVar = xVar._nullKeySerializer;
            } else {
                b.g.a.c.i0.g gVar = this._inclusionChecker;
                if (gVar == null || !gVar.a(key)) {
                    nVar = this._keySerializer;
                }
            }
            Object value = map$Entry.getValue();
            if (value != null) {
                nVarR = this._valueSerializer;
                if (nVarR == null) {
                    nVarR = r(xVar, value);
                }
                if (z2) {
                    if (nVarR.d(xVar, value)) {
                        continue;
                    } else {
                        nVar.f(key, dVar, xVar);
                        nVarR.g(value, dVar, xVar, this._valueTypeSerializer);
                    }
                } else if (obj == null || !obj.equals(value)) {
                    nVar.f(key, dVar, xVar);
                    nVarR.g(value, dVar, xVar, this._valueTypeSerializer);
                }
            } else if (this._suppressNulls) {
                continue;
            } else {
                nVarR = xVar._nullValueSerializer;
                nVar.f(key, dVar, xVar);
                try {
                    nVarR.g(value, dVar, xVar, this._valueTypeSerializer);
                } catch (Exception e) {
                    o(xVar, e, map, String.valueOf(key));
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
    public void u(Map<?, ?> map, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        TreeMap treeMap;
        b.g.a.c.n<Object> nVarR;
        b.g.a.c.n<Object> nVar;
        b.g.a.c.n<Object> nVarR2;
        Object key;
        if (map.isEmpty()) {
            return;
        }
        if ((this._sortKeys || xVar.D(b.g.a.c.w.ORDER_MAP_ENTRIES_BY_KEYS)) && !(map instanceof SortedMap)) {
            if ((map instanceof HashMap) && map.containsKey(null)) {
                treeMap = new TreeMap();
                for (Map$Entry<?, ?> map$Entry : map.entrySet()) {
                    Object key2 = map$Entry.getKey();
                    if (key2 == null) {
                        Object value = map$Entry.getValue();
                        b.g.a.c.n<Object> nVar2 = xVar._nullKeySerializer;
                        if (value != null) {
                            nVarR = this._valueSerializer;
                            if (nVarR == null) {
                                nVarR = r(xVar, value);
                            }
                            Object obj = this._suppressableValue;
                            if (obj == l) {
                                if (nVarR.d(xVar, value)) {
                                    continue;
                                } else {
                                    nVar2.f(null, dVar, xVar);
                                    nVarR.f(value, dVar, xVar);
                                }
                            } else if (obj == null || !obj.equals(value)) {
                                nVar2.f(null, dVar, xVar);
                                nVarR.f(value, dVar, xVar);
                            }
                        } else if (this._suppressNulls) {
                            continue;
                        } else {
                            nVarR = xVar._nullValueSerializer;
                            try {
                                nVar2.f(null, dVar, xVar);
                                nVarR.f(value, dVar, xVar);
                            } catch (Exception e) {
                                o(xVar, e, value, "");
                                throw null;
                            }
                        }
                    } else {
                        treeMap.put(key2, map$Entry.getValue());
                    }
                }
            } else {
                treeMap = new TreeMap(map);
            }
            map = treeMap;
        }
        Object obj2 = this._filterId;
        if (obj2 != null) {
            m(xVar, obj2, map);
            throw null;
        }
        Object obj3 = this._suppressableValue;
        if (obj3 != null || this._suppressNulls) {
            if (this._valueTypeSerializer != null) {
                t(map, dVar, xVar, obj3);
                return;
            }
            boolean z2 = l == obj3;
            for (Map$Entry<?, ?> map$Entry2 : map.entrySet()) {
                Object key3 = map$Entry2.getKey();
                if (key3 == null) {
                    nVar = xVar._nullKeySerializer;
                } else {
                    b.g.a.c.i0.g gVar = this._inclusionChecker;
                    if (gVar == null || !gVar.a(key3)) {
                        nVar = this._keySerializer;
                    }
                }
                Object value2 = map$Entry2.getValue();
                if (value2 != null) {
                    nVarR2 = this._valueSerializer;
                    if (nVarR2 == null) {
                        nVarR2 = r(xVar, value2);
                    }
                    if (z2) {
                        if (nVarR2.d(xVar, value2)) {
                            continue;
                        } else {
                            nVar.f(key3, dVar, xVar);
                            nVarR2.f(value2, dVar, xVar);
                        }
                    } else if (obj3 == null || !obj3.equals(value2)) {
                        nVar.f(key3, dVar, xVar);
                        nVarR2.f(value2, dVar, xVar);
                    }
                } else if (this._suppressNulls) {
                    continue;
                } else {
                    nVarR2 = xVar._nullValueSerializer;
                    try {
                        nVar.f(key3, dVar, xVar);
                        nVarR2.f(value2, dVar, xVar);
                    } catch (Exception e2) {
                        o(xVar, e2, map, String.valueOf(key3));
                        throw null;
                    }
                }
            }
            return;
        }
        b.g.a.c.n<Object> nVar3 = this._valueSerializer;
        if (nVar3 != null) {
            b.g.a.c.n<Object> nVar4 = this._keySerializer;
            b.g.a.c.e0.g gVar2 = this._valueTypeSerializer;
            for (Map$Entry<?, ?> map$Entry3 : map.entrySet()) {
                Object key4 = map$Entry3.getKey();
                b.g.a.c.i0.g gVar3 = this._inclusionChecker;
                if (gVar3 == null || !gVar3.a(key4)) {
                    if (key4 == null) {
                        xVar._nullKeySerializer.f(null, dVar, xVar);
                    } else {
                        nVar4.f(key4, dVar, xVar);
                    }
                    Object value3 = map$Entry3.getValue();
                    if (value3 == null) {
                        xVar.l(dVar);
                    } else if (gVar2 == null) {
                        try {
                            nVar3.f(value3, dVar, xVar);
                        } catch (Exception e3) {
                            o(xVar, e3, map, String.valueOf(key4));
                            throw null;
                        }
                    } else {
                        nVar3.g(value3, dVar, xVar, gVar2);
                    }
                }
            }
            return;
        }
        if (this._valueTypeSerializer != null) {
            t(map, dVar, xVar, null);
            return;
        }
        b.g.a.c.n<Object> nVar5 = this._keySerializer;
        try {
            key = null;
            for (Map$Entry<?, ?> map$Entry4 : map.entrySet()) {
                try {
                    Object value4 = map$Entry4.getValue();
                    key = map$Entry4.getKey();
                    if (key == null) {
                        xVar._nullKeySerializer.f(null, dVar, xVar);
                    } else {
                        b.g.a.c.i0.g gVar4 = this._inclusionChecker;
                        if (gVar4 == null || !gVar4.a(key)) {
                            nVar5.f(key, dVar, xVar);
                        }
                    }
                    if (value4 == null) {
                        xVar.l(dVar);
                    } else {
                        b.g.a.c.n<Object> nVarR3 = this._valueSerializer;
                        if (nVarR3 == null) {
                            nVarR3 = r(xVar, value4);
                        }
                        nVarR3.f(value4, dVar, xVar);
                    }
                } catch (Exception e4) {
                    e = e4;
                    o(xVar, e, map, String.valueOf(key));
                    throw null;
                }
            }
        } catch (Exception e5) {
            e = e5;
            key = null;
        }
    }

    public t v(Object obj, boolean z2) {
        if (obj == this._suppressableValue && z2 == this._suppressNulls) {
            return this;
        }
        b.g.a.c.i0.d.z(t.class, this, "withContentInclusion");
        return new t(this, this._valueTypeSerializer, obj, z2);
    }

    public t(t tVar, b.g.a.c.d dVar, b.g.a.c.n<?> nVar, b.g.a.c.n<?> nVar2, Set<String> set, Set<String> set2) {
        super(Map.class, false);
        b.g.a.c.i0.g gVar = null;
        set = (set == null || set.isEmpty()) ? null : set;
        this._ignoredEntries = set;
        this._includedEntries = set2;
        this._keyType = tVar._keyType;
        this._valueType = tVar._valueType;
        this._valueTypeIsStatic = tVar._valueTypeIsStatic;
        this._valueTypeSerializer = tVar._valueTypeSerializer;
        this._keySerializer = nVar;
        this._valueSerializer = nVar2;
        this._dynamicValueSerializers = l$b.f706b;
        this._property = dVar;
        this._filterId = tVar._filterId;
        this._sortKeys = tVar._sortKeys;
        this._suppressableValue = tVar._suppressableValue;
        this._suppressNulls = tVar._suppressNulls;
        if (set2 != null || (set != null && !set.isEmpty())) {
            gVar = new b.g.a.c.i0.g(set, set2);
        }
        this._inclusionChecker = gVar;
    }

    public t(t tVar, b.g.a.c.e0.g gVar, Object obj, boolean z2) {
        super(Map.class, false);
        this._ignoredEntries = tVar._ignoredEntries;
        this._includedEntries = tVar._includedEntries;
        this._keyType = tVar._keyType;
        this._valueType = tVar._valueType;
        this._valueTypeIsStatic = tVar._valueTypeIsStatic;
        this._valueTypeSerializer = gVar;
        this._keySerializer = tVar._keySerializer;
        this._valueSerializer = tVar._valueSerializer;
        this._dynamicValueSerializers = tVar._dynamicValueSerializers;
        this._property = tVar._property;
        this._filterId = tVar._filterId;
        this._sortKeys = tVar._sortKeys;
        this._suppressableValue = obj;
        this._suppressNulls = z2;
        this._inclusionChecker = tVar._inclusionChecker;
    }

    public t(t tVar, Object obj, boolean z2) {
        super(Map.class, false);
        this._ignoredEntries = tVar._ignoredEntries;
        this._includedEntries = tVar._includedEntries;
        this._keyType = tVar._keyType;
        this._valueType = tVar._valueType;
        this._valueTypeIsStatic = tVar._valueTypeIsStatic;
        this._valueTypeSerializer = tVar._valueTypeSerializer;
        this._keySerializer = tVar._keySerializer;
        this._valueSerializer = tVar._valueSerializer;
        this._dynamicValueSerializers = l$b.f706b;
        this._property = tVar._property;
        this._filterId = obj;
        this._sortKeys = z2;
        this._suppressableValue = tVar._suppressableValue;
        this._suppressNulls = tVar._suppressNulls;
        this._inclusionChecker = tVar._inclusionChecker;
    }
}
