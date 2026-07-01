package b.g.a.c.g0.t;

import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.g.a.a.JsonInclude;
import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonToken2;
import b.g.a.b.s.WritableTypeId;
import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.BeanProperty;
import b.g.a.c.JavaType;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializerProvider;
import b.g.a.c.c0.AnnotatedMember;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.ContainerSerializer;
import b.g.a.c.g0.ContextualSerializer;
import b.g.a.c.g0.t.PropertySerializerMap;
import b.g.a.c.y.JacksonStdImpl;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.g.a.c.g0.t.i, reason: use source file name */
/* JADX INFO: compiled from: MapEntrySerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class MapEntrySerializer extends ContainerSerializer<Map.Entry<?, ?>> implements ContextualSerializer {
    public PropertySerializerMap _dynamicValueSerializers;
    public final JavaType _entryType;
    public JsonSerializer<Object> _keySerializer;
    public final JavaType _keyType;
    public final BeanProperty _property;
    public final boolean _suppressNulls;
    public final Object _suppressableValue;
    public JsonSerializer<Object> _valueSerializer;
    public final JavaType _valueType;
    public final boolean _valueTypeIsStatic;
    public final TypeSerializer _valueTypeSerializer;

    public MapEntrySerializer(JavaType javaType, JavaType javaType2, JavaType javaType3, boolean z2, TypeSerializer typeSerializer, BeanProperty beanProperty) {
        super(javaType);
        this._entryType = javaType;
        this._keyType = javaType2;
        this._valueType = javaType3;
        this._valueTypeIsStatic = z2;
        this._valueTypeSerializer = typeSerializer;
        this._property = beanProperty;
        this._dynamicValueSerializers = PropertySerializerMap.b.f706b;
        this._suppressableValue = null;
        this._suppressNulls = false;
    }

    @Override // b.g.a.c.g0.ContextualSerializer
    public JsonSerializer<?> a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializerH;
        JsonSerializer<?> jsonSerializerH2;
        Object obj;
        boolean zB;
        JsonInclude.b bVarB;
        JsonInclude.a aVar;
        Object objT0 = JsonInclude.a.NON_EMPTY;
        AnnotationIntrospector annotationIntrospectorV = serializerProvider.v();
        AnnotatedMember member = beanProperty == null ? null : beanProperty.getMember();
        if (member == null || annotationIntrospectorV == null) {
            jsonSerializerH = null;
            jsonSerializerH2 = null;
        } else {
            Object objL = annotationIntrospectorV.l(member);
            jsonSerializerH2 = objL != null ? serializerProvider.H(member, objL) : null;
            Object objC = annotationIntrospectorV.c(member);
            jsonSerializerH = objC != null ? serializerProvider.H(member, objC) : null;
        }
        if (jsonSerializerH == null) {
            jsonSerializerH = this._valueSerializer;
        }
        JsonSerializer<?> jsonSerializerK = k(serializerProvider, beanProperty, jsonSerializerH);
        if (jsonSerializerK == null && this._valueTypeIsStatic && !this._valueType.y()) {
            jsonSerializerK = serializerProvider.m(this._valueType, beanProperty);
        }
        JsonSerializer<?> jsonSerializer = jsonSerializerK;
        if (jsonSerializerH2 == null) {
            jsonSerializerH2 = this._keySerializer;
        }
        JsonSerializer<?> jsonSerializerO = jsonSerializerH2 == null ? serializerProvider.o(this._keyType, beanProperty) : serializerProvider.z(jsonSerializerH2, beanProperty);
        Object obj2 = this._suppressableValue;
        boolean z2 = this._suppressNulls;
        if (beanProperty == null || (bVarB = beanProperty.b(serializerProvider._config, null)) == null || (aVar = bVarB._contentInclusion) == JsonInclude.a.USE_DEFAULTS) {
            obj = obj2;
            zB = z2;
        } else {
            int iOrdinal = aVar.ordinal();
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    if (iOrdinal != 3) {
                        if (iOrdinal == 4) {
                            objT0 = AnimatableValueParser.t0(this._valueType);
                            if (objT0 != null && objT0.getClass().isArray()) {
                                objT0 = AnimatableValueParser.q0(objT0);
                            }
                        } else if (iOrdinal != 5) {
                            obj = null;
                            zB = false;
                        } else {
                            objT0 = serializerProvider.A(null, bVarB._contentFilter);
                            if (objT0 != null) {
                                zB = serializerProvider.B(objT0);
                                obj = objT0;
                            }
                        }
                    }
                } else if (!this._valueType.b()) {
                    objT0 = null;
                }
                obj = objT0;
            } else {
                obj = null;
            }
            zB = true;
        }
        return new MapEntrySerializer(this, jsonSerializerO, jsonSerializer, obj, zB);
    }

    @Override // b.g.a.c.JsonSerializer
    public boolean d(SerializerProvider serializerProvider, Object obj) {
        Object value = ((Map.Entry) obj).getValue();
        if (value == null) {
            return this._suppressNulls;
        }
        if (this._suppressableValue != null) {
            JsonSerializer<Object> jsonSerializer = this._valueSerializer;
            if (jsonSerializer == null) {
                Class<?> cls = value.getClass();
                JsonSerializer<Object> jsonSerializerC = this._dynamicValueSerializers.c(cls);
                if (jsonSerializerC == null) {
                    try {
                        PropertySerializerMap propertySerializerMap = this._dynamicValueSerializers;
                        BeanProperty beanProperty = this._property;
                        Objects.requireNonNull(propertySerializerMap);
                        JsonSerializer<Object> jsonSerializerN = serializerProvider.n(cls, beanProperty);
                        PropertySerializerMap propertySerializerMapB = propertySerializerMap.b(cls, jsonSerializerN);
                        if (propertySerializerMap != propertySerializerMapB) {
                            this._dynamicValueSerializers = propertySerializerMapB;
                        }
                        jsonSerializer = jsonSerializerN;
                    } catch (JsonMappingException unused) {
                    }
                } else {
                    jsonSerializer = jsonSerializerC;
                }
            }
            Object obj2 = this._suppressableValue;
            return obj2 == JsonInclude.a.NON_EMPTY ? jsonSerializer.d(serializerProvider, value) : obj2.equals(value);
        }
        return false;
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Map.Entry<?, ?> entry = (Map.Entry) obj;
        jsonGenerator.d0(entry);
        r(entry, jsonGenerator, serializerProvider);
        jsonGenerator.u();
    }

    @Override // b.g.a.c.JsonSerializer
    public void g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        Map.Entry<?, ?> entry = (Map.Entry) obj;
        jsonGenerator.e(entry);
        WritableTypeId writableTypeIdE = typeSerializer.e(jsonGenerator, typeSerializer.d(entry, JsonToken2.START_OBJECT));
        r(entry, jsonGenerator, serializerProvider);
        typeSerializer.f(jsonGenerator, writableTypeIdE);
    }

    @Override // b.g.a.c.g0.ContainerSerializer
    public ContainerSerializer<?> p(TypeSerializer typeSerializer) {
        return new MapEntrySerializer(this, this._keySerializer, this._valueSerializer, this._suppressableValue, this._suppressNulls);
    }

    public void r(Map.Entry<?, ?> entry, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        JsonSerializer<Object> jsonSerializer;
        TypeSerializer typeSerializer = this._valueTypeSerializer;
        Object key = entry.getKey();
        JsonSerializer<Object> jsonSerializer2 = key == null ? serializerProvider._nullKeySerializer : this._keySerializer;
        Object value = entry.getValue();
        if (value != null) {
            jsonSerializer = this._valueSerializer;
            if (jsonSerializer == null) {
                Class<?> cls = value.getClass();
                JsonSerializer<Object> jsonSerializerC = this._dynamicValueSerializers.c(cls);
                if (jsonSerializerC != null) {
                    jsonSerializer = jsonSerializerC;
                } else if (this._valueType.r()) {
                    PropertySerializerMap propertySerializerMap = this._dynamicValueSerializers;
                    PropertySerializerMap.d dVarA = propertySerializerMap.a(serializerProvider.k(this._valueType, cls), serializerProvider, this._property);
                    PropertySerializerMap propertySerializerMap2 = dVarA.f708b;
                    if (propertySerializerMap != propertySerializerMap2) {
                        this._dynamicValueSerializers = propertySerializerMap2;
                    }
                    jsonSerializer = dVarA.a;
                } else {
                    PropertySerializerMap propertySerializerMap3 = this._dynamicValueSerializers;
                    BeanProperty beanProperty = this._property;
                    Objects.requireNonNull(propertySerializerMap3);
                    JsonSerializer<Object> jsonSerializerN = serializerProvider.n(cls, beanProperty);
                    PropertySerializerMap propertySerializerMapB = propertySerializerMap3.b(cls, jsonSerializerN);
                    if (propertySerializerMap3 != propertySerializerMapB) {
                        this._dynamicValueSerializers = propertySerializerMapB;
                    }
                    jsonSerializer = jsonSerializerN;
                }
            }
            Object obj = this._suppressableValue;
            if (obj != null && ((obj == JsonInclude.a.NON_EMPTY && jsonSerializer.d(serializerProvider, value)) || this._suppressableValue.equals(value))) {
                return;
            }
        } else if (this._suppressNulls) {
            return;
        } else {
            jsonSerializer = serializerProvider._nullValueSerializer;
        }
        jsonSerializer2.f(key, jsonGenerator, serializerProvider);
        try {
            if (typeSerializer == null) {
                jsonSerializer.f(value, jsonGenerator, serializerProvider);
            } else {
                jsonSerializer.g(value, jsonGenerator, serializerProvider, typeSerializer);
            }
        } catch (Exception e) {
            o(serializerProvider, e, entry, outline.v("", key));
            throw null;
        }
    }

    public MapEntrySerializer(MapEntrySerializer mapEntrySerializer, JsonSerializer jsonSerializer, JsonSerializer jsonSerializer2, Object obj, boolean z2) {
        super(Map.class, false);
        this._entryType = mapEntrySerializer._entryType;
        this._keyType = mapEntrySerializer._keyType;
        this._valueType = mapEntrySerializer._valueType;
        this._valueTypeIsStatic = mapEntrySerializer._valueTypeIsStatic;
        this._valueTypeSerializer = mapEntrySerializer._valueTypeSerializer;
        this._keySerializer = jsonSerializer;
        this._valueSerializer = jsonSerializer2;
        this._dynamicValueSerializers = PropertySerializerMap.b.f706b;
        this._property = mapEntrySerializer._property;
        this._suppressableValue = obj;
        this._suppressNulls = z2;
    }
}
