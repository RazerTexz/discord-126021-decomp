package b.g.a.c.g0;

import b.d.b.a.outline;
import b.g.a.a.JsonInclude;
import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.BeanDescription;
import b.g.a.c.JavaType;
import b.g.a.c.JsonSerializable;
import b.g.a.c.JsonSerializer;
import b.g.a.c.MapperFeature;
import b.g.a.c.SerializationConfig;
import b.g.a.c.SerializerProvider;
import b.g.a.c.c0.Annotated;
import b.g.a.c.c0.AnnotatedClass;
import b.g.a.c.c0.AnnotatedClassResolver;
import b.g.a.c.c0.AnnotatedMember;
import b.g.a.c.c0.BasicBeanDescription;
import b.g.a.c.c0.POJOPropertiesCollector;
import b.g.a.c.e0.NamedType;
import b.g.a.c.e0.TypeResolverBuilder;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.e0.h.StdSubtypeResolver;
import b.g.a.c.g0.u.BooleanSerializer2;
import b.g.a.c.g0.u.CalendarSerializer2;
import b.g.a.c.g0.u.ClassSerializer2;
import b.g.a.c.g0.u.DateSerializer2;
import b.g.a.c.g0.u.FileSerializer;
import b.g.a.c.g0.u.JsonValueSerializer;
import b.g.a.c.g0.u.NullSerializer;
import b.g.a.c.g0.u.NumberSerializer;
import b.g.a.c.g0.u.NumberSerializers;
import b.g.a.c.g0.u.NumberSerializers2;
import b.g.a.c.g0.u.NumberSerializers3;
import b.g.a.c.g0.u.NumberSerializers5;
import b.g.a.c.g0.u.NumberSerializers6;
import b.g.a.c.g0.u.NumberSerializers7;
import b.g.a.c.g0.u.SerializableSerializer;
import b.g.a.c.g0.u.StdDelegatingSerializer;
import b.g.a.c.g0.u.StdJdkSerializers;
import b.g.a.c.g0.u.StdJdkSerializers2;
import b.g.a.c.g0.u.StdJdkSerializers3;
import b.g.a.c.g0.u.StdKeySerializers;
import b.g.a.c.g0.u.StringSerializer2;
import b.g.a.c.g0.u.ToStringSerializer;
import b.g.a.c.g0.u.TokenBufferSerializer;
import b.g.a.c.g0.u.UUIDSerializer;
import b.g.a.c.i0.ArrayIterator2;
import b.g.a.c.i0.ClassUtil;
import b.g.a.c.i0.Converter;
import b.g.a.c.i0.EnumValues;
import b.g.a.c.i0.TokenBuffer;
import b.g.a.c.y.JsonSerialize;
import b.g.a.c.z.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.File;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: b.g.a.c.g0.b, reason: use source file name */
/* JADX INFO: compiled from: BasicSerializerFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BasicSerializerFactory extends SerializerFactory2 implements Serializable {
    public static final HashMap<String, JsonSerializer<?>> j;
    public static final HashMap<String, Class<? extends JsonSerializer<?>>> k;
    public final SerializerFactoryConfig _factoryConfig;

    static {
        HashMap<String, Class<? extends JsonSerializer<?>>> map = new HashMap<>();
        HashMap<String, JsonSerializer<?>> map2 = new HashMap<>();
        map2.put(String.class.getName(), new StringSerializer2());
        ToStringSerializer toStringSerializer = ToStringSerializer.k;
        map2.put(StringBuffer.class.getName(), toStringSerializer);
        map2.put(StringBuilder.class.getName(), toStringSerializer);
        map2.put(Character.class.getName(), toStringSerializer);
        map2.put(Character.TYPE.getName(), toStringSerializer);
        map2.put(Integer.class.getName(), new NumberSerializers(Integer.class));
        Class cls = Integer.TYPE;
        map2.put(cls.getName(), new NumberSerializers(cls));
        map2.put(Long.class.getName(), new NumberSerializers2(Long.class));
        Class cls2 = Long.TYPE;
        map2.put(cls2.getName(), new NumberSerializers2(cls2));
        String name = Byte.class.getName();
        NumberSerializers7 numberSerializers7 = NumberSerializers7.k;
        map2.put(name, numberSerializers7);
        map2.put(Byte.TYPE.getName(), numberSerializers7);
        String name2 = Short.class.getName();
        NumberSerializers3 numberSerializers3 = NumberSerializers3.k;
        map2.put(name2, numberSerializers3);
        map2.put(Short.TYPE.getName(), numberSerializers3);
        map2.put(Double.class.getName(), new NumberSerializers5(Double.class));
        map2.put(Double.TYPE.getName(), new NumberSerializers5(Double.TYPE));
        String name3 = Float.class.getName();
        NumberSerializers6 numberSerializers6 = NumberSerializers6.k;
        map2.put(name3, numberSerializers6);
        map2.put(Float.TYPE.getName(), numberSerializers6);
        map2.put(Boolean.TYPE.getName(), new BooleanSerializer2(true));
        map2.put(Boolean.class.getName(), new BooleanSerializer2(false));
        map2.put(BigInteger.class.getName(), new NumberSerializer(BigInteger.class));
        map2.put(BigDecimal.class.getName(), new NumberSerializer(BigDecimal.class));
        map2.put(Calendar.class.getName(), CalendarSerializer2.k);
        map2.put(Date.class.getName(), DateSerializer2.k);
        HashMap map3 = new HashMap();
        map3.put(URL.class, new ToStringSerializer(URL.class));
        map3.put(URI.class, new ToStringSerializer(URI.class));
        map3.put(Currency.class, new ToStringSerializer(Currency.class));
        map3.put(UUID.class, new UUIDSerializer());
        map3.put(Pattern.class, new ToStringSerializer(Pattern.class));
        map3.put(Locale.class, new ToStringSerializer(Locale.class));
        map3.put(AtomicBoolean.class, StdJdkSerializers.class);
        map3.put(AtomicInteger.class, StdJdkSerializers2.class);
        map3.put(AtomicLong.class, StdJdkSerializers3.class);
        map3.put(File.class, FileSerializer.class);
        map3.put(Class.class, ClassSerializer2.class);
        NullSerializer nullSerializer = NullSerializer.k;
        map3.put(Void.class, nullSerializer);
        map3.put(Void.TYPE, nullSerializer);
        for (Map.Entry entry : map3.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof JsonSerializer) {
                map2.put(((Class) entry.getKey()).getName(), (JsonSerializer) value);
            } else {
                map.put(((Class) entry.getKey()).getName(), (Class) value);
            }
        }
        map.put(TokenBuffer.class.getName(), TokenBufferSerializer.class);
        j = map2;
        k = map;
    }

    public BasicSerializerFactory(SerializerFactoryConfig serializerFactoryConfig) {
        this._factoryConfig = serializerFactoryConfig == null ? new SerializerFactoryConfig() : serializerFactoryConfig;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x015a  */
    /* JADX WARN: Code duplicated, block: B:116:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:117:0x01a8 A[PHI: r3
      0x01a8: PHI (r3v6 b.g.a.c.n<java.lang.Object>) = (r3v5 b.g.a.c.n<java.lang.Object>), (r3v9 b.g.a.c.n<java.lang.Object>) binds: [B:20:0x0046, B:86:0x0121] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // b.g.a.c.g0.SerializerFactory2
    public JsonSerializer<Object> a(SerializerProvider serializerProvider, JavaType javaType, JsonSerializer<Object> jsonSerializer) throws JsonMappingException {
        JsonSerializer<?> jsonSerializerB;
        AnnotatedMember annotatedMemberB;
        StdKeySerializers.a aVar;
        SerializationConfig serializationConfig = serializerProvider._config;
        BeanDescription beanDescriptionU = serializationConfig.u(javaType);
        Serializers[] serializersArr = this._factoryConfig._additionalKeySerializers;
        if (serializersArr.length > 0) {
            ArrayIterator2 arrayIterator2 = new ArrayIterator2(serializersArr);
            jsonSerializerB = null;
            while (arrayIterator2.hasNext() && (jsonSerializerB = ((Serializers) arrayIterator2.next()).b(serializationConfig, javaType, beanDescriptionU)) == null) {
            }
        } else {
            jsonSerializerB = null;
        }
        if (jsonSerializerB == null) {
            BasicBeanDescription basicBeanDescription = (BasicBeanDescription) beanDescriptionU;
            AnnotatedClass annotatedClass = basicBeanDescription.f;
            Object objL = serializerProvider.v().l(annotatedClass);
            JsonSerializer<Object> jsonSerializerH = objL != null ? serializerProvider.H(annotatedClass, objL) : null;
            if (jsonSerializerH != null) {
                jsonSerializer = jsonSerializerH;
            } else if (jsonSerializer == null) {
                Class cls = javaType._class;
                JsonSerializer<Object> jsonSerializer2 = StdKeySerializers.a;
                if (cls == null || cls == Object.class) {
                    jsonSerializerH = new StdKeySerializers.b();
                } else if (cls == String.class) {
                    jsonSerializerH = StdKeySerializers.a;
                } else {
                    if (cls.isPrimitive()) {
                        Annotation[] annotationArr = ClassUtil.a;
                        if (cls == Integer.TYPE) {
                            cls = Integer.class;
                        } else if (cls == Long.TYPE) {
                            cls = Long.class;
                        } else if (cls == Boolean.TYPE) {
                            cls = Boolean.class;
                        } else if (cls == Double.TYPE) {
                            cls = Double.class;
                        } else if (cls == Float.TYPE) {
                            cls = Float.class;
                        } else if (cls == Byte.TYPE) {
                            cls = Byte.class;
                        } else if (cls == Short.TYPE) {
                            cls = Short.class;
                        } else {
                            if (cls != Character.TYPE) {
                                throw new IllegalArgumentException(outline.o(cls, outline.U("Class "), " is not a primitive type"));
                            }
                            cls = Character.class;
                        }
                    }
                    if (cls == Integer.class) {
                        aVar = new StdKeySerializers.a(5, cls);
                    } else if (cls == Long.class) {
                        aVar = new StdKeySerializers.a(6, cls);
                    } else if (cls.isPrimitive() || Number.class.isAssignableFrom(cls)) {
                        aVar = new StdKeySerializers.a(8, cls);
                    } else if (cls == Class.class) {
                        aVar = new StdKeySerializers.a(3, cls);
                    } else if (Date.class.isAssignableFrom(cls)) {
                        aVar = new StdKeySerializers.a(1, cls);
                    } else if (Calendar.class.isAssignableFrom(cls)) {
                        aVar = new StdKeySerializers.a(2, cls);
                    } else if (cls == UUID.class) {
                        aVar = new StdKeySerializers.a(8, cls);
                    } else if (cls == byte[].class) {
                        aVar = new StdKeySerializers.a(7, cls);
                    } else {
                        jsonSerializerH = null;
                    }
                    jsonSerializerH = aVar;
                }
                if (jsonSerializerH == null) {
                    POJOPropertiesCollector pOJOPropertiesCollector = basicBeanDescription.c;
                    if (pOJOPropertiesCollector != null) {
                        if (!pOJOPropertiesCollector.i) {
                            pOJOPropertiesCollector.h();
                        }
                        LinkedList<AnnotatedMember> linkedList = pOJOPropertiesCollector.q;
                        if (linkedList == null) {
                            annotatedMemberB = null;
                        } else {
                            if (linkedList.size() > 1) {
                                pOJOPropertiesCollector.i("Multiple 'as-key' properties defined (%s vs %s)", pOJOPropertiesCollector.q.get(0), pOJOPropertiesCollector.q.get(1));
                                throw null;
                            }
                            annotatedMemberB = pOJOPropertiesCollector.q.get(0);
                        }
                    } else {
                        annotatedMemberB = null;
                    }
                    if (annotatedMemberB == null) {
                        annotatedMemberB = beanDescriptionU.b();
                    }
                    if (annotatedMemberB != null) {
                        JsonSerializer<Object> jsonSerializerA = a(serializerProvider, annotatedMemberB.e(), jsonSerializer);
                        if (serializationConfig.b()) {
                            ClassUtil.d(annotatedMemberB.i(), serializationConfig.q(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                        }
                        jsonSerializer = new JsonValueSerializer(annotatedMemberB, null, jsonSerializerA);
                    } else {
                        Class<?> cls2 = javaType._class;
                        if (cls2 == null) {
                            jsonSerializer = new StdKeySerializers.a(8, cls2);
                        } else if (cls2 == Enum.class) {
                            jsonSerializer = new StdKeySerializers.b();
                        } else if (ClassUtil.q(cls2)) {
                            jsonSerializer = new StdKeySerializers.c(cls2, EnumValues.a(serializationConfig, cls2));
                        } else {
                            jsonSerializer = new StdKeySerializers.a(8, cls2);
                        }
                    }
                } else {
                    jsonSerializer = jsonSerializerH;
                }
            }
        } else {
            jsonSerializer = jsonSerializerB;
        }
        if (this._factoryConfig.a()) {
            ArrayIterator2 arrayIterator3 = (ArrayIterator2) this._factoryConfig.b();
            while (arrayIterator3.hasNext()) {
                Objects.requireNonNull((BeanSerializerModifier) arrayIterator3.next());
            }
        }
        return jsonSerializer;
    }

    @Override // b.g.a.c.g0.SerializerFactory2
    public TypeSerializer c(SerializationConfig serializationConfig, JavaType javaType) {
        ArrayList arrayList;
        AnnotatedClass annotatedClass = ((BasicBeanDescription) serializationConfig.o(javaType._class)).f;
        TypeResolverBuilder<?> typeResolverBuilderP = serializationConfig.e().P(serializationConfig, annotatedClass, javaType);
        if (typeResolverBuilderP == null) {
            typeResolverBuilderP = serializationConfig._base._typeResolverBuilder;
            arrayList = null;
        } else {
            StdSubtypeResolver stdSubtypeResolver = (StdSubtypeResolver) serializationConfig._subtypeResolver;
            Objects.requireNonNull(stdSubtypeResolver);
            AnnotationIntrospector annotationIntrospectorE = serializationConfig.e();
            HashMap<NamedType, NamedType> map = new HashMap<>();
            LinkedHashSet<NamedType> linkedHashSet = stdSubtypeResolver._registeredSubtypes;
            if (linkedHashSet != null) {
                Class<?> cls = annotatedClass.l;
                for (NamedType namedType : linkedHashSet) {
                    if (cls.isAssignableFrom(namedType._class)) {
                        stdSubtypeResolver.b(AnnotatedClassResolver.h(serializationConfig, namedType._class), namedType, serializationConfig, annotationIntrospectorE, map);
                    }
                }
            }
            stdSubtypeResolver.b(annotatedClass, new NamedType(annotatedClass.l, null), serializationConfig, annotationIntrospectorE, map);
            arrayList = new ArrayList(map.values());
        }
        if (typeResolverBuilderP == null) {
            return null;
        }
        return typeResolverBuilderP.e(serializationConfig, javaType, arrayList);
    }

    public JsonInclude.b d(SerializerProvider serializerProvider, BeanDescription beanDescription, JavaType javaType, Class<?> cls) throws JsonMappingException {
        SerializationConfig serializationConfig = serializerProvider._config;
        JsonInclude.b bVarC = beanDescription.c(serializationConfig._configOverrides._defaultInclusion);
        serializationConfig._configOverrides.a(cls);
        serializationConfig.k(javaType._class, null);
        return bVarC;
    }

    public final JsonSerializer<?> e(SerializerProvider serializerProvider, JavaType javaType, BeanDescription beanDescription) throws JsonMappingException {
        if (JsonSerializable.class.isAssignableFrom(javaType._class)) {
            return SerializableSerializer.k;
        }
        AnnotatedMember annotatedMemberB = beanDescription.b();
        if (annotatedMemberB == null) {
            return null;
        }
        if (serializerProvider._config.b()) {
            ClassUtil.d(annotatedMemberB.i(), serializerProvider.C(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        JavaType javaTypeE = annotatedMemberB.e();
        JsonSerializer<Object> jsonSerializerF = f(serializerProvider, annotatedMemberB);
        if (jsonSerializerF == null) {
            jsonSerializerF = (JsonSerializer) javaTypeE._valueHandler;
        }
        TypeSerializer typeSerializerC = (TypeSerializer) javaTypeE._typeHandler;
        if (typeSerializerC == null) {
            typeSerializerC = c(serializerProvider._config, javaTypeE);
        }
        return new JsonValueSerializer(annotatedMemberB, typeSerializerC, jsonSerializerF);
    }

    public JsonSerializer<Object> f(SerializerProvider serializerProvider, Annotated annotated) throws JsonMappingException {
        Object objL = serializerProvider.v().L(annotated);
        if (objL == null) {
            return null;
        }
        JsonSerializer<Object> jsonSerializerH = serializerProvider.H(annotated, objL);
        Object objH = serializerProvider.v().H(annotated);
        Converter<Object, Object> converterC = objH != null ? serializerProvider.c(annotated, objH) : null;
        return converterC == null ? jsonSerializerH : new StdDelegatingSerializer(converterC, converterC.a(serializerProvider.d()), jsonSerializerH);
    }

    public boolean g(SerializationConfig serializationConfig, BeanDescription beanDescription, TypeSerializer typeSerializer) {
        JsonSerialize.b bVarK = serializationConfig.e().K(((BasicBeanDescription) beanDescription).f);
        if (bVarK == null || bVarK == JsonSerialize.b.DEFAULT_TYPING) {
            return serializationConfig.q(MapperFeature.USE_STATIC_TYPING);
        }
        return bVarK == JsonSerialize.b.STATIC;
    }
}
