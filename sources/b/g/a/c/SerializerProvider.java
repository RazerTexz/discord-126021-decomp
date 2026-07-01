package b.g.a.c;

import b.g.a.a.ObjectIdGenerator;
import b.g.a.b.JsonGenerator;
import b.g.a.c.c0.Annotated;
import b.g.a.c.c0.BeanPropertyDefinition;
import b.g.a.c.g0.ContextualSerializer;
import b.g.a.c.g0.DefaultSerializerProvider;
import b.g.a.c.g0.ResolvableSerializer;
import b.g.a.c.g0.SerializerCache;
import b.g.a.c.g0.SerializerFactory2;
import b.g.a.c.g0.t.FailingSerializer;
import b.g.a.c.g0.t.ReadOnlyClassToSerializerMap;
import b.g.a.c.g0.t.UnknownSerializer;
import b.g.a.c.g0.t.WritableObjectId;
import b.g.a.c.g0.u.NullSerializer;
import b.g.a.c.h0.TypeFactory;
import b.g.a.c.i0.ClassUtil;
import b.g.a.c.i0.TypeKey;
import b.g.a.c.z.ContextAttributes;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Map;

/* JADX INFO: renamed from: b.g.a.c.x, reason: use source file name */
/* JADX INFO: compiled from: SerializerProvider.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SerializerProvider extends DatabindContext {
    public static final JsonSerializer<Object> j = new FailingSerializer("Null key for a Map not allowed in JSON (use a converting NullKeySerializer?)");
    public static final JsonSerializer<Object> k = new UnknownSerializer();
    public final SerializationConfig _config;
    public DateFormat _dateFormat;
    public JsonSerializer<Object> _keySerializer;
    public final ReadOnlyClassToSerializerMap _knownSerializers;
    public JsonSerializer<Object> _nullKeySerializer;
    public JsonSerializer<Object> _nullValueSerializer;
    public final Class<?> _serializationView;
    public final SerializerCache _serializerCache;
    public final SerializerFactory2 _serializerFactory;
    public final boolean _stdNullValueSerializer;
    public JsonSerializer<Object> _unknownTypeSerializer;
    public transient ContextAttributes l;

    public SerializerProvider() {
        this._unknownTypeSerializer = k;
        this._nullValueSerializer = NullSerializer.k;
        this._nullKeySerializer = j;
        this._config = null;
        this._serializerFactory = null;
        this._serializerCache = new SerializerCache();
        this._knownSerializers = null;
        this._serializationView = null;
        this.l = null;
        this._stdNullValueSerializer = true;
    }

    public abstract Object A(BeanPropertyDefinition beanPropertyDefinition, Class<?> cls) throws JsonMappingException;

    public abstract boolean B(Object obj) throws JsonMappingException;

    public final boolean C(MapperFeature mapperFeature) {
        return mapperFeature.h(this._config._mapperFeatures);
    }

    public final boolean D(SerializationFeature serializationFeature) {
        return this._config.v(serializationFeature);
    }

    public <T> T E(BeanDescription beanDescription, BeanPropertyDefinition beanPropertyDefinition, String str, Object... objArr) throws JsonMappingException {
        String str2;
        String strA = a(str, objArr);
        if (beanPropertyDefinition != null) {
            String strP = beanPropertyDefinition.p();
            if (strP == null) {
                str2 = "[N/A]";
            } else {
                Object[] objArr2 = new Object[1];
                if (strP.length() > 500) {
                    strP = strP.substring(0, 500) + "]...[" + strP.substring(strP.length() - 500);
                }
                objArr2[0] = strP;
                str2 = String.format("\"%s\"", objArr2);
            }
        } else {
            str2 = "N/A";
        }
        throw new InvalidDefinitionException(((DefaultSerializerProvider) this).o, String.format("Invalid definition for property %s (of type %s): %s", str2, beanDescription != null ? ClassUtil.u(beanDescription.a._class) : "N/A", strA), beanDescription, beanPropertyDefinition);
    }

    public <T> T F(BeanDescription beanDescription, String str, Object... objArr) throws JsonMappingException {
        throw new InvalidDefinitionException(((DefaultSerializerProvider) this).o, String.format("Invalid type definition for type %s: %s", ClassUtil.u(beanDescription.a._class), a(str, objArr)), beanDescription, null);
    }

    public void G(String str, Object... objArr) throws JsonMappingException {
        throw new JsonMappingException(((DefaultSerializerProvider) this).o, a(str, objArr), null);
    }

    public abstract JsonSerializer<Object> H(Annotated annotated, Object obj) throws JsonMappingException;

    @Override // b.g.a.c.DatabindContext
    public final TypeFactory d() {
        return this._config._base._typeFactory;
    }

    @Override // b.g.a.c.DatabindContext
    public <T> T f(JavaType javaType, String str) throws JsonMappingException {
        throw new InvalidDefinitionException(((DefaultSerializerProvider) this).o, str, javaType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JsonSerializer<Object> h(JavaType javaType) throws JsonMappingException {
        try {
            JsonSerializer<Object> jsonSerializerB = this._serializerFactory.b(this, javaType);
            if (jsonSerializerB != 0) {
                SerializerCache serializerCache = this._serializerCache;
                synchronized (serializerCache) {
                    if (serializerCache.a.put(new TypeKey(javaType, false), jsonSerializerB) == null) {
                        serializerCache.f703b.set(null);
                    }
                    if (jsonSerializerB instanceof ResolvableSerializer) {
                        ((ResolvableSerializer) jsonSerializerB).b(this);
                    }
                }
            }
            return jsonSerializerB;
        } catch (IllegalArgumentException e) {
            throw new JsonMappingException(((DefaultSerializerProvider) this).o, a(ClassUtil.h(e), new Object[0]), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JsonSerializer<Object> i(Class<?> cls) throws JsonMappingException {
        JavaType javaTypeB = this._config._base._typeFactory.b(null, cls, TypeFactory.l);
        try {
            JsonSerializer<Object> jsonSerializerB = this._serializerFactory.b(this, javaTypeB);
            if (jsonSerializerB != 0) {
                SerializerCache serializerCache = this._serializerCache;
                synchronized (serializerCache) {
                    JsonSerializer<Object> jsonSerializerPut = serializerCache.a.put(new TypeKey(cls, false), jsonSerializerB);
                    JsonSerializer<Object> jsonSerializerPut2 = serializerCache.a.put(new TypeKey(javaTypeB, false), jsonSerializerB);
                    if (jsonSerializerPut == null || jsonSerializerPut2 == null) {
                        serializerCache.f703b.set(null);
                    }
                    if (jsonSerializerB instanceof ResolvableSerializer) {
                        ((ResolvableSerializer) jsonSerializerB).b(this);
                    }
                }
            }
            return jsonSerializerB;
        } catch (IllegalArgumentException e) {
            throw new JsonMappingException(((DefaultSerializerProvider) this).o, a(ClassUtil.h(e), new Object[0]), e);
        }
    }

    public final DateFormat j() {
        DateFormat dateFormat = this._dateFormat;
        if (dateFormat != null) {
            return dateFormat;
        }
        DateFormat dateFormat2 = (DateFormat) this._config._base._dateFormat.clone();
        this._dateFormat = dateFormat2;
        return dateFormat2;
    }

    public JavaType k(JavaType javaType, Class<?> cls) throws IllegalArgumentException {
        return javaType._class == cls ? javaType : this._config._base._typeFactory.h(javaType, cls, true);
    }

    public final void l(JsonGenerator jsonGenerator) throws IOException {
        if (this._stdNullValueSerializer) {
            jsonGenerator.A();
        } else {
            this._nullValueSerializer.f(null, jsonGenerator, this);
        }
    }

    public JsonSerializer<Object> m(JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializerA = this._knownSerializers.a(javaType);
        return (jsonSerializerA == null && (jsonSerializerA = this._serializerCache.a(javaType)) == null && (jsonSerializerA = h(javaType)) == null) ? x(javaType._class) : z(jsonSerializerA, beanProperty);
    }

    public JsonSerializer<Object> n(Class<?> cls, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializerB = this._knownSerializers.b(cls);
        return (jsonSerializerB == null && (jsonSerializerB = this._serializerCache.b(cls)) == null && (jsonSerializerB = this._serializerCache.a(this._config._base._typeFactory.b(null, cls, TypeFactory.l))) == null && (jsonSerializerB = i(cls)) == null) ? x(cls) : z(jsonSerializerB, beanProperty);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JsonSerializer<Object> o(JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializerA = this._serializerFactory.a(this, javaType, this._keySerializer);
        if (jsonSerializerA instanceof ResolvableSerializer) {
            ((ResolvableSerializer) jsonSerializerA).b(this);
        }
        return z(jsonSerializerA, beanProperty);
    }

    public abstract WritableObjectId p(Object obj, ObjectIdGenerator<?> objectIdGenerator);

    public JsonSerializer<Object> q(JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializerA = this._knownSerializers.a(javaType);
        return (jsonSerializerA == null && (jsonSerializerA = this._serializerCache.a(javaType)) == null && (jsonSerializerA = h(javaType)) == null) ? x(javaType._class) : y(jsonSerializerA, beanProperty);
    }

    public JsonSerializer<Object> r(Class<?> cls, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializerB = this._knownSerializers.b(cls);
        return (jsonSerializerB == null && (jsonSerializerB = this._serializerCache.b(cls)) == null && (jsonSerializerB = this._serializerCache.a(this._config._base._typeFactory.b(null, cls, TypeFactory.l))) == null && (jsonSerializerB = i(cls)) == null) ? x(cls) : y(jsonSerializerB, beanProperty);
    }

    public JsonSerializer<Object> s(JavaType javaType) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializerA = this._knownSerializers.a(javaType);
        if (jsonSerializerA != null) {
            return jsonSerializerA;
        }
        JsonSerializer<Object> jsonSerializerA2 = this._serializerCache.a(javaType);
        if (jsonSerializerA2 != null) {
            return jsonSerializerA2;
        }
        JsonSerializer<Object> jsonSerializerH = h(javaType);
        return jsonSerializerH == null ? x(javaType._class) : jsonSerializerH;
    }

    public JsonSerializer<Object> t(JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        if (javaType != null) {
            JsonSerializer<Object> jsonSerializerA = this._knownSerializers.a(javaType);
            return (jsonSerializerA == null && (jsonSerializerA = this._serializerCache.a(javaType)) == null && (jsonSerializerA = h(javaType)) == null) ? x(javaType._class) : z(jsonSerializerA, beanProperty);
        }
        G("Null passed for `valueType` of `findValueSerializer()`", new Object[0]);
        throw null;
    }

    public JsonSerializer<Object> u(Class<?> cls, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializerB = this._knownSerializers.b(cls);
        return (jsonSerializerB == null && (jsonSerializerB = this._serializerCache.b(cls)) == null && (jsonSerializerB = this._serializerCache.a(this._config._base._typeFactory.b(null, cls, TypeFactory.l))) == null && (jsonSerializerB = i(cls)) == null) ? x(cls) : z(jsonSerializerB, beanProperty);
    }

    public final AnnotationIntrospector v() {
        return this._config.e();
    }

    public Object w(Object obj) {
        Object obj2;
        ContextAttributes.a aVar = (ContextAttributes.a) this.l;
        Map<Object, Object> map = aVar.l;
        if (map == null || (obj2 = map.get(obj)) == null) {
            return aVar._shared.get(obj);
        }
        if (obj2 == ContextAttributes.a.k) {
            return null;
        }
        return obj2;
    }

    public JsonSerializer<Object> x(Class<?> cls) {
        return cls == Object.class ? this._unknownTypeSerializer : new UnknownSerializer(cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JsonSerializer<?> y(JsonSerializer<?> jsonSerializer, BeanProperty beanProperty) throws JsonMappingException {
        return (jsonSerializer == 0 || !(jsonSerializer instanceof ContextualSerializer)) ? jsonSerializer : ((ContextualSerializer) jsonSerializer).a(this, beanProperty);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JsonSerializer<?> z(JsonSerializer<?> jsonSerializer, BeanProperty beanProperty) throws JsonMappingException {
        return (jsonSerializer == 0 || !(jsonSerializer instanceof ContextualSerializer)) ? jsonSerializer : ((ContextualSerializer) jsonSerializer).a(this, beanProperty);
    }

    public SerializerProvider(SerializerProvider serializerProvider, SerializationConfig serializationConfig, SerializerFactory2 serializerFactory2) {
        this._unknownTypeSerializer = k;
        this._nullValueSerializer = NullSerializer.k;
        JsonSerializer<Object> jsonSerializer = j;
        this._nullKeySerializer = jsonSerializer;
        this._serializerFactory = serializerFactory2;
        this._config = serializationConfig;
        SerializerCache serializerCache = serializerProvider._serializerCache;
        this._serializerCache = serializerCache;
        this._unknownTypeSerializer = serializerProvider._unknownTypeSerializer;
        this._keySerializer = serializerProvider._keySerializer;
        JsonSerializer<Object> jsonSerializer2 = serializerProvider._nullValueSerializer;
        this._nullValueSerializer = jsonSerializer2;
        this._nullKeySerializer = serializerProvider._nullKeySerializer;
        this._stdNullValueSerializer = jsonSerializer2 == jsonSerializer;
        this._serializationView = serializationConfig._view;
        this.l = serializationConfig._attributes;
        ReadOnlyClassToSerializerMap readOnlyClassToSerializerMap = serializerCache.f703b.get();
        if (readOnlyClassToSerializerMap == null) {
            synchronized (serializerCache) {
                readOnlyClassToSerializerMap = serializerCache.f703b.get();
                if (readOnlyClassToSerializerMap == null) {
                    ReadOnlyClassToSerializerMap readOnlyClassToSerializerMap2 = new ReadOnlyClassToSerializerMap(serializerCache.a);
                    serializerCache.f703b.set(readOnlyClassToSerializerMap2);
                    readOnlyClassToSerializerMap = readOnlyClassToSerializerMap2;
                }
            }
        }
        this._knownSerializers = readOnlyClassToSerializerMap;
    }
}
