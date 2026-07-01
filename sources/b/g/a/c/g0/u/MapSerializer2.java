package b.g.a.c.g0.u;

import b.c.a.a0.AnimatableValueParser;
import b.g.a.a.JsonFormat;
import b.g.a.a.JsonInclude;
import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonToken2;
import b.g.a.b.s.WritableTypeId;
import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.BeanProperty;
import b.g.a.c.JavaType;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializationConfig;
import b.g.a.c.SerializationFeature;
import b.g.a.c.SerializerProvider;
import b.g.a.c.c0.AnnotatedMember;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.ContainerSerializer;
import b.g.a.c.g0.ContextualSerializer;
import b.g.a.c.g0.t.PropertySerializerMap;
import b.g.a.c.h0.TypeFactory;
import b.g.a.c.i0.ClassUtil;
import b.g.a.c.i0.IgnorePropertiesUtil;
import b.g.a.c.y.JacksonStdImpl;
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

/* JADX INFO: renamed from: b.g.a.c.g0.u.t, reason: use source file name */
/* JADX INFO: compiled from: MapSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class MapSerializer2 extends ContainerSerializer<Map<?, ?>> implements ContextualSerializer {
    public static final JavaType k = TypeFactory.k();
    public static final Object l = JsonInclude.a.NON_EMPTY;
    private static final long serialVersionUID = 1;
    public PropertySerializerMap _dynamicValueSerializers;
    public final Object _filterId;
    public final Set<String> _ignoredEntries;
    public final Set<String> _includedEntries;
    public final IgnorePropertiesUtil _inclusionChecker;
    public JsonSerializer<Object> _keySerializer;
    public final JavaType _keyType;
    public final BeanProperty _property;
    public final boolean _sortKeys;
    public final boolean _suppressNulls;
    public final Object _suppressableValue;
    public JsonSerializer<Object> _valueSerializer;
    public final JavaType _valueType;
    public final boolean _valueTypeIsStatic;
    public final TypeSerializer _valueTypeSerializer;

    public MapSerializer2(Set<String> set, Set<String> set2, JavaType javaType, JavaType javaType2, boolean z2, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, JsonSerializer<?> jsonSerializer2) {
        super(Map.class, false);
        IgnorePropertiesUtil ignorePropertiesUtil = null;
        set = (set == null || set.isEmpty()) ? null : set;
        this._ignoredEntries = set;
        this._includedEntries = set2;
        this._keyType = javaType;
        this._valueType = javaType2;
        this._valueTypeIsStatic = z2;
        this._valueTypeSerializer = typeSerializer;
        this._keySerializer = jsonSerializer;
        this._valueSerializer = jsonSerializer2;
        this._dynamicValueSerializers = PropertySerializerMap.b.f706b;
        this._property = null;
        this._filterId = null;
        this._sortKeys = false;
        this._suppressableValue = null;
        this._suppressNulls = false;
        if (set2 != null || (set != null && !set.isEmpty())) {
            ignorePropertiesUtil = new IgnorePropertiesUtil(set, set2);
        }
        this._inclusionChecker = ignorePropertiesUtil;
    }

    public static MapSerializer2 s(Set<String> set, Set<String> set2, JavaType javaType, boolean z2, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer, JsonSerializer<Object> jsonSerializer2, Object obj) {
        JavaType javaTypeK;
        JavaType javaType2;
        boolean z3;
        if (javaType == null) {
            javaType2 = k;
            javaTypeK = javaType2;
        } else {
            JavaType javaTypeO = javaType.o();
            javaTypeK = javaType._class == Properties.class ? TypeFactory.k() : javaType.k();
            javaType2 = javaTypeO;
        }
        if (z2) {
            z3 = javaTypeK._class == Object.class ? false : z2;
        } else {
            z3 = javaTypeK != null && javaTypeK.x();
        }
        MapSerializer2 mapSerializer2 = new MapSerializer2(set, set2, javaType2, javaTypeK, z3, typeSerializer, jsonSerializer, jsonSerializer2);
        if (obj == null || mapSerializer2._filterId == obj) {
            return mapSerializer2;
        }
        ClassUtil.z(MapSerializer2.class, mapSerializer2, "withFilterId");
        return new MapSerializer2(mapSerializer2, obj, mapSerializer2._sortKeys);
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0194 A[PHI: r11
      0x0194: PHI (r11v1 java.lang.Object) = (r11v0 java.lang.Object), (r11v0 java.lang.Object), (r11v3 java.lang.Object), (r11v4 java.lang.Object) binds: [B:83:0x0151, B:104:0x018f, B:106:0x0193, B:94:0x0167] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // b.g.a.c.g0.ContextualSerializer
    public JsonSerializer<?> a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<?> jsonSerializerH;
        JsonSerializer<Object> jsonSerializerH2;
        Set<String> set;
        Set<String> set2;
        boolean zBooleanValue;
        MapSerializer2 mapSerializer2;
        JsonInclude.a aVar;
        boolean zB;
        Object objT0;
        Boolean boolB;
        AnnotationIntrospector annotationIntrospectorV = serializerProvider.v();
        Object objA = null;
        AnnotatedMember member = beanProperty == null ? null : beanProperty.getMember();
        if (StdSerializer.j(member, annotationIntrospectorV)) {
            Object objL = annotationIntrospectorV.l(member);
            jsonSerializerH = objL != null ? serializerProvider.H(member, objL) : null;
            Object objC = annotationIntrospectorV.c(member);
            jsonSerializerH2 = objC != null ? serializerProvider.H(member, objC) : null;
        } else {
            jsonSerializerH = null;
            jsonSerializerH2 = null;
        }
        if (jsonSerializerH2 == null) {
            jsonSerializerH2 = this._valueSerializer;
        }
        JsonSerializer<?> jsonSerializerK = k(serializerProvider, beanProperty, jsonSerializerH2);
        if (jsonSerializerK == null && this._valueTypeIsStatic && !this._valueType.y()) {
            jsonSerializerK = serializerProvider.m(this._valueType, beanProperty);
        }
        JsonSerializer<?> jsonSerializer = jsonSerializerK;
        if (jsonSerializerH == null) {
            jsonSerializerH = this._keySerializer;
        }
        JsonSerializer<?> jsonSerializerO = jsonSerializerH == null ? serializerProvider.o(this._keyType, beanProperty) : serializerProvider.z(jsonSerializerH, beanProperty);
        Set<String> hashSet = this._ignoredEntries;
        Set<String> hashSet2 = this._includedEntries;
        if (StdSerializer.j(member, annotationIntrospectorV)) {
            SerializationConfig serializationConfig = serializerProvider._config;
            Set<String> setD = annotationIntrospectorV.x(serializationConfig, member).d();
            if ((setD == null || setD.isEmpty()) ? false : true) {
                hashSet = hashSet == null ? new HashSet<>() : new HashSet(hashSet);
                Iterator<String> it = setD.iterator();
                while (it.hasNext()) {
                    hashSet.add(it.next());
                }
            }
            Set<String> set3 = annotationIntrospectorV.A(serializationConfig, member)._included;
            if (set3 != null) {
                hashSet2 = hashSet2 == null ? new HashSet<>() : new HashSet(hashSet2);
                Iterator<String> it2 = set3.iterator();
                while (it2.hasNext()) {
                    hashSet2.add(it2.next());
                }
            }
            zBooleanValue = Boolean.TRUE.equals(annotationIntrospectorV.J(member));
            set = hashSet;
            set2 = hashSet2;
        } else {
            set = hashSet;
            set2 = hashSet2;
            zBooleanValue = false;
        }
        JsonFormat.d dVarL = l(serializerProvider, beanProperty, Map.class);
        if (dVarL != null && (boolB = dVarL.b(JsonFormat.a.WRITE_SORTED_MAP_ENTRIES)) != null) {
            zBooleanValue = boolB.booleanValue();
        }
        boolean z2 = zBooleanValue;
        ClassUtil.z(MapSerializer2.class, this, "withResolved");
        MapSerializer2 mapSerializer3 = new MapSerializer2(this, beanProperty, jsonSerializerO, jsonSerializer, set, set2);
        if (z2 != mapSerializer3._sortKeys) {
            mapSerializer2 = new MapSerializer2(mapSerializer3, this._filterId, z2);
        }
        if (member != null) {
            mapSerializer2 = mapSerializer3;
            Object objG = annotationIntrospectorV.g(member);
            if (objG != null && mapSerializer2._filterId != objG) {
                ClassUtil.z(MapSerializer2.class, mapSerializer2, "withFilterId");
                mapSerializer2 = new MapSerializer2(mapSerializer2, objG, mapSerializer2._sortKeys);
            }
        }
        mapSerializer2 = mapSerializer3;
        JsonInclude.b bVarB = beanProperty != null ? beanProperty.b(serializerProvider._config, Map.class) : serializerProvider._config.j(Map.class);
        if (bVarB == null || (aVar = bVarB._contentInclusion) == JsonInclude.a.USE_DEFAULTS) {
            return mapSerializer2;
        }
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 1) {
            zB = true;
        } else if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                objT0 = l;
            } else if (iOrdinal == 4) {
                objT0 = AnimatableValueParser.t0(this._valueType);
                if (objT0 != null && objT0.getClass().isArray()) {
                    objT0 = AnimatableValueParser.q0(objT0);
                }
            } else if (iOrdinal != 5) {
                zB = false;
            } else {
                objA = serializerProvider.A(null, bVarB._contentFilter);
                if (objA == null) {
                    zB = true;
                } else {
                    zB = serializerProvider.B(objA);
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
        return mapSerializer2.v(objA, zB);
    }

    @Override // b.g.a.c.JsonSerializer
    public boolean d(SerializerProvider serializerProvider, Object obj) {
        Map map = (Map) obj;
        if (!map.isEmpty()) {
            Object obj2 = this._suppressableValue;
            if (obj2 == null && !this._suppressNulls) {
                return false;
            }
            JsonSerializer<Object> jsonSerializer = this._valueSerializer;
            boolean z2 = l == obj2;
            if (jsonSerializer != null) {
                for (Object obj3 : map.values()) {
                    if (obj3 == null) {
                        if (!this._suppressNulls) {
                            return false;
                        }
                    } else if (z2) {
                        if (!jsonSerializer.d(serializerProvider, obj3)) {
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
                            JsonSerializer<Object> jsonSerializerR = r(serializerProvider, obj4);
                            if (z2) {
                                if (!jsonSerializerR.d(serializerProvider, obj4)) {
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

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Map<?, ?> map = (Map) obj;
        jsonGenerator.d0(map);
        u(map, jsonGenerator, serializerProvider);
        jsonGenerator.u();
    }

    @Override // b.g.a.c.JsonSerializer
    public void g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        Map<?, ?> map = (Map) obj;
        jsonGenerator.e(map);
        WritableTypeId writableTypeIdE = typeSerializer.e(jsonGenerator, typeSerializer.d(map, JsonToken2.START_OBJECT));
        u(map, jsonGenerator, serializerProvider);
        typeSerializer.f(jsonGenerator, writableTypeIdE);
    }

    @Override // b.g.a.c.g0.ContainerSerializer
    public ContainerSerializer p(TypeSerializer typeSerializer) {
        if (this._valueTypeSerializer == typeSerializer) {
            return this;
        }
        ClassUtil.z(MapSerializer2.class, this, "_withValueTypeSerializer");
        return new MapSerializer2(this, typeSerializer, this._suppressableValue, this._suppressNulls);
    }

    public final JsonSerializer<Object> r(SerializerProvider serializerProvider, Object obj) throws JsonMappingException {
        Class<?> cls = obj.getClass();
        JsonSerializer<Object> jsonSerializerC = this._dynamicValueSerializers.c(cls);
        if (jsonSerializerC != null) {
            return jsonSerializerC;
        }
        if (this._valueType.r()) {
            PropertySerializerMap propertySerializerMap = this._dynamicValueSerializers;
            PropertySerializerMap.d dVarA = propertySerializerMap.a(serializerProvider.k(this._valueType, cls), serializerProvider, this._property);
            PropertySerializerMap propertySerializerMap2 = dVarA.f708b;
            if (propertySerializerMap != propertySerializerMap2) {
                this._dynamicValueSerializers = propertySerializerMap2;
            }
            return dVarA.a;
        }
        PropertySerializerMap propertySerializerMap3 = this._dynamicValueSerializers;
        BeanProperty beanProperty = this._property;
        Objects.requireNonNull(propertySerializerMap3);
        JsonSerializer<Object> jsonSerializerN = serializerProvider.n(cls, beanProperty);
        PropertySerializerMap propertySerializerMapB = propertySerializerMap3.b(cls, jsonSerializerN);
        if (propertySerializerMap3 != propertySerializerMapB) {
            this._dynamicValueSerializers = propertySerializerMapB;
        }
        return jsonSerializerN;
    }

    public void t(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, Object obj) throws IOException {
        JsonSerializer<Object> jsonSerializer;
        JsonSerializer<Object> jsonSerializerR;
        boolean z2 = l == obj;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            if (key == null) {
                jsonSerializer = serializerProvider._nullKeySerializer;
            } else {
                IgnorePropertiesUtil ignorePropertiesUtil = this._inclusionChecker;
                if (ignorePropertiesUtil == null || !ignorePropertiesUtil.a(key)) {
                    jsonSerializer = this._keySerializer;
                }
            }
            Object value = entry.getValue();
            if (value != null) {
                jsonSerializerR = this._valueSerializer;
                if (jsonSerializerR == null) {
                    jsonSerializerR = r(serializerProvider, value);
                }
                if (z2) {
                    if (jsonSerializerR.d(serializerProvider, value)) {
                        continue;
                    } else {
                        jsonSerializer.f(key, jsonGenerator, serializerProvider);
                        jsonSerializerR.g(value, jsonGenerator, serializerProvider, this._valueTypeSerializer);
                    }
                } else if (obj == null || !obj.equals(value)) {
                    jsonSerializer.f(key, jsonGenerator, serializerProvider);
                    jsonSerializerR.g(value, jsonGenerator, serializerProvider, this._valueTypeSerializer);
                }
            } else if (this._suppressNulls) {
                continue;
            } else {
                jsonSerializerR = serializerProvider._nullValueSerializer;
                jsonSerializer.f(key, jsonGenerator, serializerProvider);
                try {
                    jsonSerializerR.g(value, jsonGenerator, serializerProvider, this._valueTypeSerializer);
                } catch (Exception e) {
                    o(serializerProvider, e, map, String.valueOf(key));
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
    public void u(Map<?, ?> map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        TreeMap treeMap;
        JsonSerializer<Object> jsonSerializerR;
        JsonSerializer<Object> jsonSerializer;
        JsonSerializer<Object> jsonSerializerR2;
        Object key;
        if (map.isEmpty()) {
            return;
        }
        if ((this._sortKeys || serializerProvider.D(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS)) && !(map instanceof SortedMap)) {
            if ((map instanceof HashMap) && map.containsKey(null)) {
                treeMap = new TreeMap();
                for (Map.Entry<?, ?> entry : map.entrySet()) {
                    Object key2 = entry.getKey();
                    if (key2 == null) {
                        Object value = entry.getValue();
                        JsonSerializer<Object> jsonSerializer2 = serializerProvider._nullKeySerializer;
                        if (value != null) {
                            jsonSerializerR = this._valueSerializer;
                            if (jsonSerializerR == null) {
                                jsonSerializerR = r(serializerProvider, value);
                            }
                            Object obj = this._suppressableValue;
                            if (obj == l) {
                                if (jsonSerializerR.d(serializerProvider, value)) {
                                    continue;
                                } else {
                                    jsonSerializer2.f(null, jsonGenerator, serializerProvider);
                                    jsonSerializerR.f(value, jsonGenerator, serializerProvider);
                                }
                            } else if (obj == null || !obj.equals(value)) {
                                jsonSerializer2.f(null, jsonGenerator, serializerProvider);
                                jsonSerializerR.f(value, jsonGenerator, serializerProvider);
                            }
                        } else if (this._suppressNulls) {
                            continue;
                        } else {
                            jsonSerializerR = serializerProvider._nullValueSerializer;
                            try {
                                jsonSerializer2.f(null, jsonGenerator, serializerProvider);
                                jsonSerializerR.f(value, jsonGenerator, serializerProvider);
                            } catch (Exception e) {
                                o(serializerProvider, e, value, "");
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
            m(serializerProvider, obj2, map);
            throw null;
        }
        Object obj3 = this._suppressableValue;
        if (obj3 != null || this._suppressNulls) {
            if (this._valueTypeSerializer != null) {
                t(map, jsonGenerator, serializerProvider, obj3);
                return;
            }
            boolean z2 = l == obj3;
            for (Map.Entry<?, ?> entry2 : map.entrySet()) {
                Object key3 = entry2.getKey();
                if (key3 == null) {
                    jsonSerializer = serializerProvider._nullKeySerializer;
                } else {
                    IgnorePropertiesUtil ignorePropertiesUtil = this._inclusionChecker;
                    if (ignorePropertiesUtil == null || !ignorePropertiesUtil.a(key3)) {
                        jsonSerializer = this._keySerializer;
                    }
                }
                Object value2 = entry2.getValue();
                if (value2 != null) {
                    jsonSerializerR2 = this._valueSerializer;
                    if (jsonSerializerR2 == null) {
                        jsonSerializerR2 = r(serializerProvider, value2);
                    }
                    if (z2) {
                        if (jsonSerializerR2.d(serializerProvider, value2)) {
                            continue;
                        } else {
                            jsonSerializer.f(key3, jsonGenerator, serializerProvider);
                            jsonSerializerR2.f(value2, jsonGenerator, serializerProvider);
                        }
                    } else if (obj3 == null || !obj3.equals(value2)) {
                        jsonSerializer.f(key3, jsonGenerator, serializerProvider);
                        jsonSerializerR2.f(value2, jsonGenerator, serializerProvider);
                    }
                } else if (this._suppressNulls) {
                    continue;
                } else {
                    jsonSerializerR2 = serializerProvider._nullValueSerializer;
                    try {
                        jsonSerializer.f(key3, jsonGenerator, serializerProvider);
                        jsonSerializerR2.f(value2, jsonGenerator, serializerProvider);
                    } catch (Exception e2) {
                        o(serializerProvider, e2, map, String.valueOf(key3));
                        throw null;
                    }
                }
            }
            return;
        }
        JsonSerializer<Object> jsonSerializer3 = this._valueSerializer;
        if (jsonSerializer3 != null) {
            JsonSerializer<Object> jsonSerializer4 = this._keySerializer;
            TypeSerializer typeSerializer = this._valueTypeSerializer;
            for (Map.Entry<?, ?> entry3 : map.entrySet()) {
                Object key4 = entry3.getKey();
                IgnorePropertiesUtil ignorePropertiesUtil2 = this._inclusionChecker;
                if (ignorePropertiesUtil2 == null || !ignorePropertiesUtil2.a(key4)) {
                    if (key4 == null) {
                        serializerProvider._nullKeySerializer.f(null, jsonGenerator, serializerProvider);
                    } else {
                        jsonSerializer4.f(key4, jsonGenerator, serializerProvider);
                    }
                    Object value3 = entry3.getValue();
                    if (value3 == null) {
                        serializerProvider.l(jsonGenerator);
                    } else if (typeSerializer == null) {
                        try {
                            jsonSerializer3.f(value3, jsonGenerator, serializerProvider);
                        } catch (Exception e3) {
                            o(serializerProvider, e3, map, String.valueOf(key4));
                            throw null;
                        }
                    } else {
                        jsonSerializer3.g(value3, jsonGenerator, serializerProvider, typeSerializer);
                    }
                }
            }
            return;
        }
        if (this._valueTypeSerializer != null) {
            t(map, jsonGenerator, serializerProvider, null);
            return;
        }
        JsonSerializer<Object> jsonSerializer5 = this._keySerializer;
        try {
            key = null;
            for (Map.Entry<?, ?> entry4 : map.entrySet()) {
                try {
                    Object value4 = entry4.getValue();
                    key = entry4.getKey();
                    if (key == null) {
                        serializerProvider._nullKeySerializer.f(null, jsonGenerator, serializerProvider);
                    } else {
                        IgnorePropertiesUtil ignorePropertiesUtil3 = this._inclusionChecker;
                        if (ignorePropertiesUtil3 == null || !ignorePropertiesUtil3.a(key)) {
                            jsonSerializer5.f(key, jsonGenerator, serializerProvider);
                        }
                    }
                    if (value4 == null) {
                        serializerProvider.l(jsonGenerator);
                    } else {
                        JsonSerializer<Object> jsonSerializerR3 = this._valueSerializer;
                        if (jsonSerializerR3 == null) {
                            jsonSerializerR3 = r(serializerProvider, value4);
                        }
                        jsonSerializerR3.f(value4, jsonGenerator, serializerProvider);
                    }
                } catch (Exception e4) {
                    e = e4;
                    o(serializerProvider, e, map, String.valueOf(key));
                    throw null;
                }
            }
        } catch (Exception e5) {
            e = e5;
            key = null;
        }
    }

    public MapSerializer2 v(Object obj, boolean z2) {
        if (obj == this._suppressableValue && z2 == this._suppressNulls) {
            return this;
        }
        ClassUtil.z(MapSerializer2.class, this, "withContentInclusion");
        return new MapSerializer2(this, this._valueTypeSerializer, obj, z2);
    }

    public MapSerializer2(MapSerializer2 mapSerializer2, BeanProperty beanProperty, JsonSerializer<?> jsonSerializer, JsonSerializer<?> jsonSerializer2, Set<String> set, Set<String> set2) {
        super(Map.class, false);
        IgnorePropertiesUtil ignorePropertiesUtil = null;
        set = (set == null || set.isEmpty()) ? null : set;
        this._ignoredEntries = set;
        this._includedEntries = set2;
        this._keyType = mapSerializer2._keyType;
        this._valueType = mapSerializer2._valueType;
        this._valueTypeIsStatic = mapSerializer2._valueTypeIsStatic;
        this._valueTypeSerializer = mapSerializer2._valueTypeSerializer;
        this._keySerializer = jsonSerializer;
        this._valueSerializer = jsonSerializer2;
        this._dynamicValueSerializers = PropertySerializerMap.b.f706b;
        this._property = beanProperty;
        this._filterId = mapSerializer2._filterId;
        this._sortKeys = mapSerializer2._sortKeys;
        this._suppressableValue = mapSerializer2._suppressableValue;
        this._suppressNulls = mapSerializer2._suppressNulls;
        if (set2 != null || (set != null && !set.isEmpty())) {
            ignorePropertiesUtil = new IgnorePropertiesUtil(set, set2);
        }
        this._inclusionChecker = ignorePropertiesUtil;
    }

    public MapSerializer2(MapSerializer2 mapSerializer2, TypeSerializer typeSerializer, Object obj, boolean z2) {
        super(Map.class, false);
        this._ignoredEntries = mapSerializer2._ignoredEntries;
        this._includedEntries = mapSerializer2._includedEntries;
        this._keyType = mapSerializer2._keyType;
        this._valueType = mapSerializer2._valueType;
        this._valueTypeIsStatic = mapSerializer2._valueTypeIsStatic;
        this._valueTypeSerializer = typeSerializer;
        this._keySerializer = mapSerializer2._keySerializer;
        this._valueSerializer = mapSerializer2._valueSerializer;
        this._dynamicValueSerializers = mapSerializer2._dynamicValueSerializers;
        this._property = mapSerializer2._property;
        this._filterId = mapSerializer2._filterId;
        this._sortKeys = mapSerializer2._sortKeys;
        this._suppressableValue = obj;
        this._suppressNulls = z2;
        this._inclusionChecker = mapSerializer2._inclusionChecker;
    }

    public MapSerializer2(MapSerializer2 mapSerializer2, Object obj, boolean z2) {
        super(Map.class, false);
        this._ignoredEntries = mapSerializer2._ignoredEntries;
        this._includedEntries = mapSerializer2._includedEntries;
        this._keyType = mapSerializer2._keyType;
        this._valueType = mapSerializer2._valueType;
        this._valueTypeIsStatic = mapSerializer2._valueTypeIsStatic;
        this._valueTypeSerializer = mapSerializer2._valueTypeSerializer;
        this._keySerializer = mapSerializer2._keySerializer;
        this._valueSerializer = mapSerializer2._valueSerializer;
        this._dynamicValueSerializers = PropertySerializerMap.b.f706b;
        this._property = mapSerializer2._property;
        this._filterId = obj;
        this._sortKeys = z2;
        this._suppressableValue = mapSerializer2._suppressableValue;
        this._suppressNulls = mapSerializer2._suppressNulls;
        this._inclusionChecker = mapSerializer2._inclusionChecker;
    }
}
