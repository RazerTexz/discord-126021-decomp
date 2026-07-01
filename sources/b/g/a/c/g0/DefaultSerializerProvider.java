package b.g.a.c.g0;

import b.d.b.a.outline;
import b.g.a.a.ObjectIdGenerator;
import b.g.a.b.JsonGenerator;
import b.g.a.b.SerializableString;
import b.g.a.b.p.SerializedString;
import b.g.a.c.JavaType;
import b.g.a.c.JsonSerializer;
import b.g.a.c.PropertyName;
import b.g.a.c.SerializationConfig;
import b.g.a.c.SerializationFeature;
import b.g.a.c.SerializerProvider;
import b.g.a.c.c0.Annotated;
import b.g.a.c.c0.BasicBeanDescription;
import b.g.a.c.c0.BeanPropertyDefinition;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.t.ReadOnlyClassToSerializerMap;
import b.g.a.c.g0.t.TypeWrappedSerializer;
import b.g.a.c.g0.t.WritableObjectId;
import b.g.a.c.h0.ClassKey;
import b.g.a.c.h0.TypeFactory;
import b.g.a.c.i0.ClassUtil;
import b.g.a.c.i0.LRUMap;
import b.g.a.c.i0.RootNameLookup;
import b.g.a.c.i0.TypeKey;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.g.a.c.g0.j, reason: use source file name */
/* JADX INFO: compiled from: DefaultSerializerProvider.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DefaultSerializerProvider extends SerializerProvider implements Serializable {
    private static final long serialVersionUID = 1;
    public transient Map<Object, WritableObjectId> m;
    public transient ArrayList<ObjectIdGenerator<?>> n;
    public transient JsonGenerator o;

    /* JADX INFO: renamed from: b.g.a.c.g0.j$a */
    /* JADX INFO: compiled from: DefaultSerializerProvider.java */
    public static final class a extends DefaultSerializerProvider {
        private static final long serialVersionUID = 1;

        public a() {
        }

        @Override // b.g.a.c.g0.DefaultSerializerProvider
        public DefaultSerializerProvider K(SerializationConfig serializationConfig, SerializerFactory2 serializerFactory2) {
            return new a(this, serializationConfig, serializerFactory2);
        }

        public a(SerializerProvider serializerProvider, SerializationConfig serializationConfig, SerializerFactory2 serializerFactory2) {
            super(serializerProvider, serializationConfig, serializerFactory2);
        }
    }

    public DefaultSerializerProvider() {
    }

    @Override // b.g.a.c.SerializerProvider
    public Object A(BeanPropertyDefinition beanPropertyDefinition, Class<?> cls) {
        if (cls == null) {
            return null;
        }
        Objects.requireNonNull(this._config._base);
        return ClassUtil.g(cls, this._config.b());
    }

    @Override // b.g.a.c.SerializerProvider
    public boolean B(Object obj) throws JsonMappingException {
        try {
            return obj.equals(null);
        } catch (Throwable th) {
            InvalidDefinitionException invalidDefinitionException = new InvalidDefinitionException(this.o, String.format("Problem determining whether filter of type '%s' should filter out `null` values: (%s) %s", obj.getClass().getName(), th.getClass().getName(), ClassUtil.h(th)), b(obj.getClass()));
            invalidDefinitionException.initCause(th);
            throw invalidDefinitionException;
        }
    }

    @Override // b.g.a.c.SerializerProvider
    public JsonSerializer<Object> H(Annotated annotated, Object obj) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializer;
        if (obj instanceof JsonSerializer) {
            jsonSerializer = (JsonSerializer) obj;
        } else {
            if (!(obj instanceof Class)) {
                JavaType javaTypeE = annotated.e();
                StringBuilder sbU = outline.U("AnnotationIntrospector returned serializer definition of type ");
                sbU.append(obj.getClass().getName());
                sbU.append("; expected type JsonSerializer or Class<JsonSerializer> instead");
                f(javaTypeE, sbU.toString());
                throw null;
            }
            Class cls = (Class) obj;
            if (cls == JsonSerializer.a.class || ClassUtil.p(cls)) {
                return null;
            }
            if (!JsonSerializer.class.isAssignableFrom(cls)) {
                JavaType javaTypeE2 = annotated.e();
                StringBuilder sbU2 = outline.U("AnnotationIntrospector returned Class ");
                sbU2.append(cls.getName());
                sbU2.append("; expected Class<JsonSerializer>");
                f(javaTypeE2, sbU2.toString());
                throw null;
            }
            Objects.requireNonNull(this._config._base);
            jsonSerializer = (JsonSerializer) ClassUtil.g(cls, this._config.b());
        }
        if (jsonSerializer instanceof ResolvableSerializer) {
            ((ResolvableSerializer) jsonSerializer).b(this);
        }
        return jsonSerializer;
    }

    public final void I(JsonGenerator jsonGenerator, Object obj, JsonSerializer<Object> jsonSerializer, PropertyName propertyName) throws IOException {
        try {
            jsonGenerator.c0();
            SerializationConfig serializationConfig = this._config;
            SerializableString serializedString = propertyName._encodedSimple;
            if (serializedString == null) {
                serializedString = serializationConfig == null ? new SerializedString(propertyName._simpleName) : new SerializedString(propertyName._simpleName);
                propertyName._encodedSimple = serializedString;
            }
            jsonGenerator.x(serializedString);
            jsonSerializer.f(obj, jsonGenerator, this);
            jsonGenerator.u();
        } catch (Exception e) {
            throw J(jsonGenerator, e);
        }
    }

    public final IOException J(JsonGenerator jsonGenerator, Exception exc) {
        if (exc instanceof IOException) {
            return (IOException) exc;
        }
        String strH = ClassUtil.h(exc);
        if (strH == null) {
            StringBuilder sbU = outline.U("[no message for ");
            sbU.append(exc.getClass().getName());
            sbU.append("]");
            strH = sbU.toString();
        }
        return new JsonMappingException(jsonGenerator, strH, exc);
    }

    public abstract DefaultSerializerProvider K(SerializationConfig serializationConfig, SerializerFactory2 serializerFactory2);

    public void L(JsonGenerator jsonGenerator, Object obj) throws IOException {
        JsonSerializer<Object> jsonSerializerU;
        JsonSerializer<Object> jsonSerializer;
        this.o = jsonGenerator;
        if (obj == null) {
            try {
                this._nullValueSerializer.f(null, jsonGenerator, this);
                return;
            } catch (Exception e) {
                throw J(jsonGenerator, e);
            }
        }
        Class<?> cls = obj.getClass();
        ReadOnlyClassToSerializerMap readOnlyClassToSerializerMap = this._knownSerializers;
        ReadOnlyClassToSerializerMap.a aVar = readOnlyClassToSerializerMap.a[readOnlyClassToSerializerMap.f711b & (cls.getName().hashCode() + 1)];
        if (aVar == null) {
            jsonSerializerU = null;
            break;
        }
        if (!(aVar.c == cls && aVar.e)) {
            while (true) {
                aVar = aVar.f712b;
                if (aVar == null) {
                    jsonSerializerU = null;
                    break;
                } else {
                    if (aVar.c == cls && aVar.e) {
                        jsonSerializerU = aVar.a;
                        break;
                    }
                }
            }
        } else {
            jsonSerializerU = aVar.a;
        }
        if (jsonSerializerU == null) {
            SerializerCache serializerCache = this._serializerCache;
            synchronized (serializerCache) {
                jsonSerializer = serializerCache.a.get(new TypeKey(cls, true));
            }
            if (jsonSerializer != null) {
                jsonSerializerU = jsonSerializer;
            } else {
                jsonSerializerU = u(cls, null);
                SerializerFactory2 serializerFactory2 = this._serializerFactory;
                SerializationConfig serializationConfig = this._config;
                TypeSerializer typeSerializerC = serializerFactory2.c(serializationConfig, serializationConfig._base._typeFactory.b(null, cls, TypeFactory.l));
                if (typeSerializerC != null) {
                    jsonSerializerU = new TypeWrappedSerializer(typeSerializerC.a(null), jsonSerializerU);
                }
                SerializerCache serializerCache2 = this._serializerCache;
                synchronized (serializerCache2) {
                    if (serializerCache2.a.put(new TypeKey(cls, true), jsonSerializerU) == null) {
                        serializerCache2.f703b.set(null);
                    }
                }
            }
        }
        SerializationConfig serializationConfig2 = this._config;
        PropertyName propertyName = serializationConfig2._rootName;
        if (propertyName == null) {
            if (serializationConfig2.v(SerializationFeature.WRAP_ROOT_VALUE)) {
                SerializationConfig serializationConfig3 = this._config;
                PropertyName propertyName2 = serializationConfig3._rootName;
                if (propertyName2 == null) {
                    RootNameLookup rootNameLookup = serializationConfig3._rootNames;
                    Objects.requireNonNull(rootNameLookup);
                    ClassKey classKey = new ClassKey(cls);
                    PropertyName propertyName3 = rootNameLookup.j.k.get(classKey);
                    if (propertyName3 != null) {
                        propertyName2 = propertyName3;
                    } else {
                        PropertyName propertyNameF = serializationConfig3.e().F(((BasicBeanDescription) serializationConfig3.o(cls)).f);
                        if (propertyNameF == null || !propertyNameF.c()) {
                            propertyNameF = PropertyName.a(cls.getSimpleName());
                        }
                        LRUMap<ClassKey, PropertyName> lRUMap = rootNameLookup.j;
                        if (lRUMap.k.size() >= lRUMap.j) {
                            synchronized (lRUMap) {
                                if (lRUMap.k.size() >= lRUMap.j) {
                                    lRUMap.k.clear();
                                }
                            }
                        }
                        lRUMap.k.put(classKey, propertyNameF);
                        propertyName2 = propertyNameF;
                    }
                }
                I(jsonGenerator, obj, jsonSerializerU, propertyName2);
                return;
            }
        } else if (!propertyName.d()) {
            I(jsonGenerator, obj, jsonSerializerU, propertyName);
            return;
        }
        try {
            jsonSerializerU.f(obj, jsonGenerator, this);
        } catch (Exception e2) {
            throw J(jsonGenerator, e2);
        }
    }

    @Override // b.g.a.c.SerializerProvider
    public WritableObjectId p(Object obj, ObjectIdGenerator<?> objectIdGenerator) {
        Map<Object, WritableObjectId> map = this.m;
        if (map == null) {
            this.m = D(SerializationFeature.USE_EQUALITY_FOR_OBJECT_ID) ? new HashMap<>() : new IdentityHashMap<>();
        } else {
            WritableObjectId writableObjectId = map.get(obj);
            if (writableObjectId != null) {
                return writableObjectId;
            }
        }
        ObjectIdGenerator<?> objectIdGeneratorE = null;
        ArrayList<ObjectIdGenerator<?>> arrayList = this.n;
        if (arrayList == null) {
            this.n = new ArrayList<>(8);
        } else {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ObjectIdGenerator<?> objectIdGenerator2 = this.n.get(i);
                if (objectIdGenerator2.a(objectIdGenerator)) {
                    objectIdGeneratorE = objectIdGenerator2;
                    break;
                }
            }
        }
        if (objectIdGeneratorE == null) {
            objectIdGeneratorE = objectIdGenerator.e(this);
            this.n.add(objectIdGeneratorE);
        }
        WritableObjectId writableObjectId2 = new WritableObjectId(objectIdGeneratorE);
        this.m.put(obj, writableObjectId2);
        return writableObjectId2;
    }

    public DefaultSerializerProvider(SerializerProvider serializerProvider, SerializationConfig serializationConfig, SerializerFactory2 serializerFactory2) {
        super(serializerProvider, serializationConfig, serializerFactory2);
    }
}
