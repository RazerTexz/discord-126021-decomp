package b.g.a.c.g0;

import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.g.a.a.JsonFormat;
import b.g.a.a.JsonIgnoreProperties;
import b.g.a.a.JsonInclude;
import b.g.a.a.JsonIncludeProperties;
import b.g.a.a.JsonTypeInfo;
import b.g.a.a.ObjectIdGenerator;
import b.g.a.a.ObjectIdGenerators3;
import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.BeanDescription;
import b.g.a.c.BeanProperty;
import b.g.a.c.JavaType;
import b.g.a.c.JsonSerializer;
import b.g.a.c.MapperFeature;
import b.g.a.c.PropertyMetadata;
import b.g.a.c.PropertyName;
import b.g.a.c.SerializationConfig;
import b.g.a.c.SerializationFeature;
import b.g.a.c.SerializerProvider;
import b.g.a.c.b0.OptionalHandlerFactory;
import b.g.a.c.c0.AnnotatedClass;
import b.g.a.c.c0.AnnotatedConstructor;
import b.g.a.c.c0.AnnotatedField;
import b.g.a.c.c0.AnnotatedMember;
import b.g.a.c.c0.AnnotatedMethod;
import b.g.a.c.c0.BasicBeanDescription;
import b.g.a.c.c0.BeanPropertyDefinition;
import b.g.a.c.c0.ObjectIdInfo;
import b.g.a.c.c0.POJOPropertiesCollector;
import b.g.a.c.e0.TypeResolverBuilder;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.t.FilteredBeanPropertyWriter;
import b.g.a.c.g0.t.FilteredBeanPropertyWriter2;
import b.g.a.c.g0.t.IndexedListSerializer;
import b.g.a.c.g0.t.IndexedStringListSerializer;
import b.g.a.c.g0.t.IteratorSerializer;
import b.g.a.c.g0.t.MapEntrySerializer;
import b.g.a.c.g0.t.ObjectIdWriter;
import b.g.a.c.g0.t.PropertyBasedObjectIdGenerator;
import b.g.a.c.g0.t.StringArraySerializer2;
import b.g.a.c.g0.t.StringCollectionSerializer;
import b.g.a.c.g0.t.UnsupportedTypeSerializer;
import b.g.a.c.g0.t.UnwrappingBeanPropertyWriter;
import b.g.a.c.g0.u.AtomicReferenceSerializer;
import b.g.a.c.g0.u.BeanSerializerBase;
import b.g.a.c.g0.u.ByteBufferSerializer;
import b.g.a.c.g0.u.CalendarSerializer2;
import b.g.a.c.g0.u.CollectionSerializer2;
import b.g.a.c.g0.u.DateSerializer2;
import b.g.a.c.g0.u.EnumSerializer2;
import b.g.a.c.g0.u.EnumSetSerializer2;
import b.g.a.c.g0.u.InetAddressSerializer;
import b.g.a.c.g0.u.InetSocketAddressSerializer;
import b.g.a.c.g0.u.IterableSerializer;
import b.g.a.c.g0.u.MapSerializer2;
import b.g.a.c.g0.u.NumberSerializer;
import b.g.a.c.g0.u.ObjectArraySerializer2;
import b.g.a.c.g0.u.ReferenceTypeSerializer;
import b.g.a.c.g0.u.StdArraySerializers;
import b.g.a.c.g0.u.StdDelegatingSerializer;
import b.g.a.c.g0.u.TimeZoneSerializer2;
import b.g.a.c.g0.u.ToStringSerializer;
import b.g.a.c.h0.ArrayType;
import b.g.a.c.h0.CollectionLikeType;
import b.g.a.c.h0.CollectionType;
import b.g.a.c.h0.MapLikeType;
import b.g.a.c.h0.MapType;
import b.g.a.c.h0.ReferenceType;
import b.g.a.c.h0.TypeFactory;
import b.g.a.c.i0.ArrayIterator2;
import b.g.a.c.i0.ClassUtil;
import b.g.a.c.i0.Converter;
import b.g.a.c.i0.EnumValues;
import b.g.a.c.i0.NameTransformer4;
import b.g.a.c.z.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: b.g.a.c.g0.f, reason: use source file name */
/* JADX INFO: compiled from: BeanSerializerFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class BeanSerializerFactory extends BasicSerializerFactory implements Serializable {
    public static final BeanSerializerFactory l = new BeanSerializerFactory(null);
    private static final long serialVersionUID = 1;

    public BeanSerializerFactory(SerializerFactoryConfig serializerFactoryConfig) {
        super(null);
    }

    @Override // b.g.a.c.g0.SerializerFactory2
    public JsonSerializer<Object> b(SerializerProvider serializerProvider, JavaType javaType) throws JsonMappingException {
        JavaType javaTypeE0;
        Object objH;
        SerializationConfig serializationConfig = serializerProvider._config;
        BeanDescription beanDescriptionU = serializationConfig.u(javaType);
        JsonSerializer<?> jsonSerializerF = f(serializerProvider, ((BasicBeanDescription) beanDescriptionU).f);
        if (jsonSerializerF != null) {
            return jsonSerializerF;
        }
        AnnotationIntrospector annotationIntrospectorE = serializationConfig.e();
        boolean z2 = false;
        Converter converter = null;
        if (annotationIntrospectorE == null) {
            javaTypeE0 = javaType;
        } else {
            try {
                javaTypeE0 = annotationIntrospectorE.e0(serializationConfig, ((BasicBeanDescription) beanDescriptionU).f, javaType);
            } catch (JsonMappingException e) {
                serializerProvider.F(beanDescriptionU, e.getMessage(), new Object[0]);
                throw null;
            }
        }
        if (javaTypeE0 != javaType) {
            if (!javaTypeE0.t(javaType._class)) {
                beanDescriptionU = serializationConfig.u(javaTypeE0);
            }
            z2 = true;
        }
        BasicBeanDescription basicBeanDescription = (BasicBeanDescription) beanDescriptionU;
        AnnotationIntrospector annotationIntrospector = basicBeanDescription.e;
        if (annotationIntrospector != null && (objH = annotationIntrospector.H(basicBeanDescription.f)) != null) {
            if (objH instanceof Converter) {
                converter = (Converter) objH;
            } else {
                if (!(objH instanceof Class)) {
                    StringBuilder sbU = outline.U("AnnotationIntrospector returned Converter definition of type ");
                    sbU.append(objH.getClass().getName());
                    sbU.append("; expected type Converter or Class<Converter> instead");
                    throw new IllegalStateException(sbU.toString());
                }
                Class cls = (Class) objH;
                if (cls != Converter.a.class && !ClassUtil.p(cls)) {
                    if (!Converter.class.isAssignableFrom(cls)) {
                        throw new IllegalStateException(outline.o(cls, outline.U("AnnotationIntrospector returned Class "), "; expected Class<Converter>"));
                    }
                    Objects.requireNonNull(basicBeanDescription.d._base);
                    converter = (Converter) ClassUtil.g(cls, basicBeanDescription.d.b());
                }
            }
        }
        if (converter == null) {
            return i(serializerProvider, javaTypeE0, beanDescriptionU, z2);
        }
        JavaType javaTypeA = converter.a(serializerProvider.d());
        if (!javaTypeA.t(javaTypeE0._class)) {
            beanDescriptionU = serializationConfig.u(javaTypeA);
            jsonSerializerF = f(serializerProvider, ((BasicBeanDescription) beanDescriptionU).f);
        }
        if (jsonSerializerF == null && !javaTypeA.y()) {
            jsonSerializerF = i(serializerProvider, javaTypeA, beanDescriptionU, true);
        }
        return new StdDelegatingSerializer(converter, javaTypeA, jsonSerializerF);
    }

    /* JADX WARN: Code duplicated, block: B:121:0x0259  */
    /* JADX WARN: Code duplicated, block: B:123:0x0261  */
    /* JADX WARN: Code duplicated, block: B:125:0x0267  */
    /* JADX WARN: Code duplicated, block: B:126:0x0269  */
    /* JADX WARN: Code duplicated, block: B:128:0x0271  */
    /* JADX WARN: Code duplicated, block: B:135:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:138:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:139:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:97:0x020f  */
    /* JADX WARN: Multi-variable type inference failed */
    public BeanPropertyWriter h(SerializerProvider serializerProvider, BeanPropertyDefinition beanPropertyDefinition, PropertyBuilder propertyBuilder, boolean z2, AnnotatedMember annotatedMember) throws JsonMappingException {
        TypeSerializer typeSerializerC;
        boolean z3;
        boolean z4;
        boolean zB;
        Object obj;
        Class<?>[] clsArrI;
        BeanPropertyWriter beanPropertyWriter;
        Object objQ;
        BasicBeanDescription basicBeanDescription;
        AnnotationIntrospector annotationIntrospector;
        Class<?>[] clsArrR;
        Object objT0;
        PropertyName propertyNameM = beanPropertyDefinition.m();
        JavaType javaTypeE = annotatedMember.e();
        BeanProperty.a aVar = new BeanProperty.a(propertyNameM, javaTypeE, beanPropertyDefinition.t(), annotatedMember, beanPropertyDefinition.o());
        JsonSerializer<Object> jsonSerializerF = f(serializerProvider, annotatedMember);
        if (jsonSerializerF instanceof ResolvableSerializer) {
            ((ResolvableSerializer) jsonSerializerF).b(serializerProvider);
        }
        JsonSerializer<?> jsonSerializerY = serializerProvider.y(jsonSerializerF, aVar);
        if (javaTypeE.v() || javaTypeE.b()) {
            SerializationConfig serializationConfig = serializerProvider._config;
            JavaType javaTypeK = javaTypeE.k();
            TypeResolverBuilder<?> typeResolverBuilderU = serializationConfig.e().u(serializationConfig, annotatedMember, javaTypeE);
            typeSerializerC = typeResolverBuilderU == null ? c(serializationConfig, javaTypeK) : typeResolverBuilderU.e(serializationConfig, javaTypeK, serializationConfig._subtypeResolver.a(serializationConfig, annotatedMember, javaTypeK));
        } else {
            typeSerializerC = null;
        }
        SerializationConfig serializationConfig2 = serializerProvider._config;
        TypeResolverBuilder<?> typeResolverBuilderC = serializationConfig2.e().C(serializationConfig2, annotatedMember, javaTypeE);
        TypeSerializer typeSerializerC2 = typeResolverBuilderC == null ? c(serializationConfig2, javaTypeE) : typeResolverBuilderC.e(serializationConfig2, javaTypeE, serializationConfig2._subtypeResolver.a(serializationConfig2, annotatedMember, javaTypeE));
        Object obj2 = JsonInclude.a.NON_EMPTY;
        try {
            JavaType javaTypeA = propertyBuilder.a(annotatedMember, z2, javaTypeE);
            if (typeSerializerC != null) {
                if (javaTypeA == null) {
                    javaTypeA = javaTypeE;
                }
                if (javaTypeA.k() == null) {
                    serializerProvider.E(propertyBuilder.f702b, beanPropertyDefinition, "serialization type " + javaTypeA + " has no content", new Object[0]);
                    throw null;
                }
                JavaType javaTypeE2 = javaTypeA.E(typeSerializerC);
                javaTypeE2.k();
                javaTypeA = javaTypeE2;
            }
            JavaType javaType = javaTypeA == null ? javaTypeE : javaTypeA;
            AnnotatedMember annotatedMemberJ = beanPropertyDefinition.j();
            if (annotatedMemberJ == null) {
                serializerProvider.E(propertyBuilder.f702b, beanPropertyDefinition, "could not determine property type", new Object[0]);
                throw null;
            }
            Class<?> clsD = annotatedMemberJ.d();
            SerializationConfig serializationConfig3 = propertyBuilder.a;
            Class<?> cls = javaType._class;
            JsonInclude.b bVar = propertyBuilder.e;
            serializationConfig3.f(cls);
            serializationConfig3.f(clsD);
            JsonInclude.b[] bVarArr = {bVar, null, null};
            JsonInclude.b bVar2 = JsonInclude.b.j;
            int i = 0;
            JsonInclude.b bVar3 = null;
            for (int i2 = 3; i < i2; i2 = 3) {
                JsonInclude.b bVarA = bVarArr[i];
                if (bVarA != null) {
                    if (bVar3 != null) {
                        bVarA = bVar3.a(bVarA);
                    }
                    bVar3 = bVarA;
                }
                i++;
            }
            JsonInclude.b bVarA2 = bVar3.a(beanPropertyDefinition.g());
            JsonInclude.a aVar2 = bVarA2._valueInclusion;
            if (aVar2 == JsonInclude.a.USE_DEFAULTS) {
                aVar2 = JsonInclude.a.ALWAYS;
            }
            int iOrdinal = aVar2.ordinal();
            if (iOrdinal != 1) {
                if (iOrdinal == 2) {
                    if (!javaType.b()) {
                        z4 = true;
                        zB = z4;
                        obj = null;
                        clsArrI = beanPropertyDefinition.i();
                        if (clsArrI == null) {
                            basicBeanDescription = (BasicBeanDescription) propertyBuilder.f702b;
                            if (!basicBeanDescription.h) {
                                basicBeanDescription.h = true;
                                annotationIntrospector = basicBeanDescription.e;
                                if (annotationIntrospector == null) {
                                    clsArrR = null;
                                } else {
                                    clsArrR = annotationIntrospector.R(basicBeanDescription.f);
                                }
                                if (clsArrR == null) {
                                    clsArrR = BasicBeanDescription.f693b;
                                }
                                basicBeanDescription.g = clsArrR;
                            }
                            clsArrI = basicBeanDescription.g;
                        }
                        beanPropertyWriter = new BeanPropertyWriter(beanPropertyDefinition, annotatedMember, ((BasicBeanDescription) propertyBuilder.f702b).f.t, javaTypeE, jsonSerializerY, typeSerializerC2, javaTypeA, zB, obj, clsArrI);
                        objQ = propertyBuilder.c.q(annotatedMember);
                        if (objQ != null) {
                            beanPropertyWriter.e(serializerProvider.H(annotatedMember, objQ));
                        }
                        NameTransformer4 nameTransformer4Q = propertyBuilder.c.Q(annotatedMember);
                        if (nameTransformer4Q != null) {
                        }
                    }
                    int i3 = BeanPropertyWriter.j;
                } else if (iOrdinal != 3) {
                    if (iOrdinal != 4) {
                        if (iOrdinal != 5) {
                            z3 = false;
                        } else {
                            objT0 = serializerProvider.A(beanPropertyDefinition, bVarA2._valueFilter);
                            if (objT0 != null) {
                                obj = objT0;
                                zB = serializerProvider.B(objT0);
                            }
                        }
                        clsArrI = beanPropertyDefinition.i();
                        if (clsArrI == null) {
                            basicBeanDescription = (BasicBeanDescription) propertyBuilder.f702b;
                            if (!basicBeanDescription.h) {
                                basicBeanDescription.h = true;
                                annotationIntrospector = basicBeanDescription.e;
                                if (annotationIntrospector == null) {
                                    clsArrR = null;
                                } else {
                                    clsArrR = annotationIntrospector.R(basicBeanDescription.f);
                                }
                                if (clsArrR == null && !basicBeanDescription.d.q(MapperFeature.DEFAULT_VIEW_INCLUSION)) {
                                    clsArrR = BasicBeanDescription.f693b;
                                }
                                basicBeanDescription.g = clsArrR;
                            }
                            clsArrI = basicBeanDescription.g;
                        }
                        beanPropertyWriter = new BeanPropertyWriter(beanPropertyDefinition, annotatedMember, ((BasicBeanDescription) propertyBuilder.f702b).f.t, javaTypeE, jsonSerializerY, typeSerializerC2, javaTypeA, zB, obj, clsArrI);
                        objQ = propertyBuilder.c.q(annotatedMember);
                        if (objQ != null) {
                            beanPropertyWriter.e(serializerProvider.H(annotatedMember, objQ));
                        }
                        NameTransformer4 nameTransformer4Q2 = propertyBuilder.c.Q(annotatedMember);
                        return nameTransformer4Q2 != null ? new UnwrappingBeanPropertyWriter(beanPropertyWriter, nameTransformer4Q2) : beanPropertyWriter;
                    }
                    if (propertyBuilder.f) {
                        Object objNewInstance = propertyBuilder.d;
                        if (objNewInstance == null) {
                            BeanDescription beanDescription = propertyBuilder.f702b;
                            boolean zB2 = propertyBuilder.a.b();
                            BasicBeanDescription basicBeanDescription2 = (BasicBeanDescription) beanDescription;
                            AnnotatedConstructor annotatedConstructor = basicBeanDescription2.f.f().a;
                            if (annotatedConstructor == null) {
                                objNewInstance = null;
                            } else {
                                if (zB2) {
                                    annotatedConstructor.f(basicBeanDescription2.d.q(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                                }
                                try {
                                    objNewInstance = annotatedConstructor._constructor.newInstance(new Object[0]);
                                } catch (Exception e) {
                                    e = e;
                                    while (e.getCause() != null) {
                                        e = e.getCause();
                                    }
                                    ClassUtil.w(e);
                                    ClassUtil.x(e);
                                    StringBuilder sbU = outline.U("Failed to instantiate bean of type ");
                                    sbU.append(basicBeanDescription2.f.l.getName());
                                    sbU.append(": (");
                                    sbU.append(e.getClass().getName());
                                    sbU.append(") ");
                                    sbU.append(ClassUtil.h(e));
                                    throw new IllegalArgumentException(sbU.toString(), e);
                                }
                            }
                            if (objNewInstance == null) {
                                objNewInstance = Boolean.FALSE;
                            }
                            propertyBuilder.d = objNewInstance;
                        }
                        Object obj3 = objNewInstance == Boolean.FALSE ? null : propertyBuilder.d;
                        if (obj3 != null) {
                            if (serializerProvider.C(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                                annotatedMember.f(propertyBuilder.a.q(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                            }
                            try {
                                objT0 = annotatedMember.j(obj3);
                                z3 = false;
                            } catch (Exception e2) {
                                e = e2;
                                String strP = beanPropertyDefinition.p();
                                while (e.getCause() != null) {
                                    e = e.getCause();
                                }
                                ClassUtil.w(e);
                                ClassUtil.x(e);
                                StringBuilder sbY = outline.Y("Failed to get property '", strP, "' of default ");
                                sbY.append(obj3.getClass().getName());
                                sbY.append(" instance");
                                throw new IllegalArgumentException(sbY.toString());
                            }
                        } else {
                            objT0 = AnimatableValueParser.t0(javaType);
                            z3 = true;
                        }
                    } else {
                        objT0 = AnimatableValueParser.t0(javaType);
                        z3 = true;
                    }
                    if (objT0 != null) {
                        if (objT0.getClass().isArray()) {
                            objT0 = AnimatableValueParser.q0(objT0);
                        }
                        obj2 = objT0;
                        zB = z3;
                        obj = obj2;
                        clsArrI = beanPropertyDefinition.i();
                        if (clsArrI == null) {
                            basicBeanDescription = (BasicBeanDescription) propertyBuilder.f702b;
                            if (!basicBeanDescription.h) {
                                basicBeanDescription.h = true;
                                annotationIntrospector = basicBeanDescription.e;
                                if (annotationIntrospector == null) {
                                    clsArrR = null;
                                } else {
                                    clsArrR = annotationIntrospector.R(basicBeanDescription.f);
                                }
                                if (clsArrR == null) {
                                    clsArrR = BasicBeanDescription.f693b;
                                }
                                basicBeanDescription.g = clsArrR;
                            }
                            clsArrI = basicBeanDescription.g;
                        }
                        beanPropertyWriter = new BeanPropertyWriter(beanPropertyDefinition, annotatedMember, ((BasicBeanDescription) propertyBuilder.f702b).f.t, javaTypeE, jsonSerializerY, typeSerializerC2, javaTypeA, zB, obj, clsArrI);
                        objQ = propertyBuilder.c.q(annotatedMember);
                        if (objQ != null) {
                            beanPropertyWriter.e(serializerProvider.H(annotatedMember, objQ));
                        }
                        NameTransformer4 nameTransformer4Q3 = propertyBuilder.c.Q(annotatedMember);
                        if (nameTransformer4Q3 != null) {
                        }
                    }
                    obj2 = objT0;
                } else {
                    int i4 = BeanPropertyWriter.j;
                }
                obj = obj2;
                zB = true;
                clsArrI = beanPropertyDefinition.i();
                if (clsArrI == null) {
                    basicBeanDescription = (BasicBeanDescription) propertyBuilder.f702b;
                    if (!basicBeanDescription.h) {
                        basicBeanDescription.h = true;
                        annotationIntrospector = basicBeanDescription.e;
                        if (annotationIntrospector == null) {
                            clsArrR = null;
                        } else {
                            clsArrR = annotationIntrospector.R(basicBeanDescription.f);
                        }
                        if (clsArrR == null) {
                            clsArrR = BasicBeanDescription.f693b;
                        }
                        basicBeanDescription.g = clsArrR;
                    }
                    clsArrI = basicBeanDescription.g;
                }
                beanPropertyWriter = new BeanPropertyWriter(beanPropertyDefinition, annotatedMember, ((BasicBeanDescription) propertyBuilder.f702b).f.t, javaTypeE, jsonSerializerY, typeSerializerC2, javaTypeA, zB, obj, clsArrI);
                objQ = propertyBuilder.c.q(annotatedMember);
                if (objQ != null) {
                    beanPropertyWriter.e(serializerProvider.H(annotatedMember, objQ));
                }
                NameTransformer4 nameTransformer4Q4 = propertyBuilder.c.Q(annotatedMember);
                if (nameTransformer4Q4 != null) {
                }
            }
            z3 = true;
            SerializationFeature serializationFeature = SerializationFeature.WRITE_EMPTY_JSON_ARRAYS;
            if (!javaType.v() || propertyBuilder.a.v(serializationFeature)) {
                z4 = z3;
                zB = z4;
                obj = null;
                clsArrI = beanPropertyDefinition.i();
                if (clsArrI == null) {
                    basicBeanDescription = (BasicBeanDescription) propertyBuilder.f702b;
                    if (!basicBeanDescription.h) {
                        basicBeanDescription.h = true;
                        annotationIntrospector = basicBeanDescription.e;
                        if (annotationIntrospector == null) {
                            clsArrR = null;
                        } else {
                            clsArrR = annotationIntrospector.R(basicBeanDescription.f);
                        }
                        if (clsArrR == null) {
                            clsArrR = BasicBeanDescription.f693b;
                        }
                        basicBeanDescription.g = clsArrR;
                    }
                    clsArrI = basicBeanDescription.g;
                }
                beanPropertyWriter = new BeanPropertyWriter(beanPropertyDefinition, annotatedMember, ((BasicBeanDescription) propertyBuilder.f702b).f.t, javaTypeE, jsonSerializerY, typeSerializerC2, javaTypeA, zB, obj, clsArrI);
                objQ = propertyBuilder.c.q(annotatedMember);
                if (objQ != null) {
                    beanPropertyWriter.e(serializerProvider.H(annotatedMember, objQ));
                }
                NameTransformer4 nameTransformer4Q5 = propertyBuilder.c.Q(annotatedMember);
                if (nameTransformer4Q5 != null) {
                }
            }
            int i5 = BeanPropertyWriter.j;
            zB = z3;
            obj = obj2;
            clsArrI = beanPropertyDefinition.i();
            if (clsArrI == null) {
                basicBeanDescription = (BasicBeanDescription) propertyBuilder.f702b;
                if (!basicBeanDescription.h) {
                    basicBeanDescription.h = true;
                    annotationIntrospector = basicBeanDescription.e;
                    if (annotationIntrospector == null) {
                        clsArrR = null;
                    } else {
                        clsArrR = annotationIntrospector.R(basicBeanDescription.f);
                    }
                    if (clsArrR == null) {
                        clsArrR = BasicBeanDescription.f693b;
                    }
                    basicBeanDescription.g = clsArrR;
                }
                clsArrI = basicBeanDescription.g;
            }
            beanPropertyWriter = new BeanPropertyWriter(beanPropertyDefinition, annotatedMember, ((BasicBeanDescription) propertyBuilder.f702b).f.t, javaTypeE, jsonSerializerY, typeSerializerC2, javaTypeA, zB, obj, clsArrI);
            objQ = propertyBuilder.c.q(annotatedMember);
            if (objQ != null) {
                beanPropertyWriter.e(serializerProvider.H(annotatedMember, objQ));
            }
            NameTransformer4 nameTransformer4Q6 = propertyBuilder.c.Q(annotatedMember);
            if (nameTransformer4Q6 != null) {
            }
        } catch (JsonMappingException e3) {
            serializerProvider.E(propertyBuilder.f702b, beanPropertyDefinition, ClassUtil.h(e3), new Object[0]);
            throw null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:164:0x02f3 A[PHI: r4
      0x02f3: PHI (r4v88 b.g.a.c.n<?>) = (r4v87 b.g.a.c.n<?>), (r4v89 b.g.a.c.n<?>), (r4v91 b.g.a.c.n<?>) binds: [B:131:0x0273, B:133:0x0279, B:161:0x02e8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:215:0x0404 A[PHI: r11 r12 r13 r14 r15
      0x0404: PHI (r11v5 java.lang.Class<java.lang.Enum>) = (r11v4 java.lang.Class<java.lang.Enum>), (r11v10 java.lang.Class<java.lang.Enum>) binds: [B:189:0x0384, B:135:0x0284] A[DONT_GENERATE, DONT_INLINE]
      0x0404: PHI (r12v4 b.g.a.c.c) = (r12v3 b.g.a.c.c), (r12v10 b.g.a.c.c) binds: [B:189:0x0384, B:135:0x0284] A[DONT_GENERATE, DONT_INLINE]
      0x0404: PHI (r13v10 b.g.a.a.p$a) = (r13v9 b.g.a.a.p$a), (r13v13 b.g.a.a.p$a) binds: [B:189:0x0384, B:135:0x0284] A[DONT_GENERATE, DONT_INLINE]
      0x0404: PHI (r14v40 b.g.a.a.p$a) = (r14v39 b.g.a.a.p$a), (r14v43 b.g.a.a.p$a) binds: [B:189:0x0384, B:135:0x0284] A[DONT_GENERATE, DONT_INLINE]
      0x0404: PHI (r15v13 b.g.a.a.i$c) = (r15v12 b.g.a.a.i$c), (r15v16 b.g.a.a.i$c) binds: [B:189:0x0384, B:135:0x0284] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:262:0x04bf A[PHI: r4
      0x04bf: PHI (r4v14 int) = (r4v13 int), (r4v16 int) binds: [B:260:0x04ba, B:247:0x048b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:349:0x0658  */
    /* JADX WARN: Code duplicated, block: B:408:0x0729  */
    /* JADX WARN: Code duplicated, block: B:429:0x078f  */
    /* JADX WARN: Code duplicated, block: B:431:0x0792  */
    /* JADX WARN: Code duplicated, block: B:432:0x0795  */
    /* JADX WARN: Code duplicated, block: B:435:0x07ba  */
    /* JADX WARN: Code duplicated, block: B:440:0x07d6  */
    /* JADX WARN: Code duplicated, block: B:442:0x07e7  */
    /* JADX WARN: Code duplicated, block: B:449:0x07fe  */
    /* JADX WARN: Code duplicated, block: B:452:0x0808  */
    /* JADX WARN: Code duplicated, block: B:459:0x0824  */
    /* JADX WARN: Code duplicated, block: B:460:0x0829  */
    /* JADX WARN: Code duplicated, block: B:463:0x0846  */
    /* JADX WARN: Code duplicated, block: B:468:0x085d  */
    /* JADX WARN: Code duplicated, block: B:473:0x0883  */
    /* JADX WARN: Code duplicated, block: B:475:0x0888  */
    /* JADX WARN: Code duplicated, block: B:476:0x088a  */
    /* JADX WARN: Code duplicated, block: B:478:0x088d  */
    /* JADX WARN: Code duplicated, block: B:479:0x0891  */
    /* JADX WARN: Code duplicated, block: B:481:0x0895  */
    /* JADX WARN: Code duplicated, block: B:482:0x08ac  */
    /* JADX WARN: Code duplicated, block: B:487:0x08cb  */
    /* JADX WARN: Code duplicated, block: B:488:0x08d1  */
    /* JADX WARN: Code duplicated, block: B:490:0x08d8  */
    /* JADX WARN: Code duplicated, block: B:511:0x0925  */
    /* JADX WARN: Code duplicated, block: B:517:0x093f  */
    /* JADX WARN: Code duplicated, block: B:520:0x094d A[LOOP:3: B:518:0x0947->B:520:0x094d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:523:0x0963  */
    /* JADX WARN: Code duplicated, block: B:524:0x0968  */
    /* JADX WARN: Code duplicated, block: B:527:0x0975  */
    /* JADX WARN: Code duplicated, block: B:528:0x0977  */
    /* JADX WARN: Code duplicated, block: B:530:0x097d  */
    /* JADX WARN: Code duplicated, block: B:531:0x0980  */
    /* JADX WARN: Code duplicated, block: B:536:0x098b  */
    /* JADX WARN: Code duplicated, block: B:539:0x0995  */
    /* JADX WARN: Code duplicated, block: B:544:0x09b1  */
    /* JADX WARN: Code duplicated, block: B:547:0x09bf A[LOOP:4: B:545:0x09b9->B:547:0x09bf, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:550:0x09cd  */
    /* JADX WARN: Code duplicated, block: B:551:0x09d0  */
    /* JADX WARN: Code duplicated, block: B:553:0x09d6  */
    /* JADX WARN: Code duplicated, block: B:557:0x09f1  */
    /* JADX WARN: Code duplicated, block: B:558:0x09f4  */
    /* JADX WARN: Code duplicated, block: B:561:0x0a04  */
    /* JADX WARN: Code duplicated, block: B:564:0x0a16  */
    /* JADX WARN: Code duplicated, block: B:566:0x0a2c A[LOOP:7: B:554:0x09df->B:566:0x0a2c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:567:0x0a2f  */
    /* JADX WARN: Code duplicated, block: B:570:0x0a62  */
    /* JADX WARN: Code duplicated, block: B:572:0x0a66  */
    /* JADX WARN: Code duplicated, block: B:575:0x0a6d  */
    /* JADX WARN: Code duplicated, block: B:577:0x0a73  */
    /* JADX WARN: Code duplicated, block: B:578:0x0a7c  */
    /* JADX WARN: Code duplicated, block: B:580:0x0a97  */
    /* JADX WARN: Code duplicated, block: B:582:0x0a9a  */
    /* JADX WARN: Code duplicated, block: B:585:0x0aa7  */
    /* JADX WARN: Code duplicated, block: B:587:0x0abc  */
    /* JADX WARN: Code duplicated, block: B:589:0x0ac2  */
    /* JADX WARN: Code duplicated, block: B:592:0x0ac9  */
    /* JADX WARN: Code duplicated, block: B:594:0x0acf  */
    /* JADX WARN: Code duplicated, block: B:595:0x0ad8  */
    /* JADX WARN: Code duplicated, block: B:597:0x0af3  */
    /* JADX WARN: Code duplicated, block: B:599:0x0af6  */
    /* JADX WARN: Code duplicated, block: B:602:0x0b03  */
    /* JADX WARN: Code duplicated, block: B:604:0x0b18  */
    /* JADX WARN: Code duplicated, block: B:606:0x0b1b  */
    /* JADX WARN: Code duplicated, block: B:608:0x0b2d  */
    /* JADX WARN: Code duplicated, block: B:612:0x0b6e  */
    /* JADX WARN: Code duplicated, block: B:622:0x0b95  */
    /* JADX WARN: Code duplicated, block: B:624:0x0b99  */
    /* JADX WARN: Code duplicated, block: B:629:0x0ba5  */
    /* JADX WARN: Code duplicated, block: B:631:0x0bad  */
    /* JADX WARN: Code duplicated, block: B:634:0x0bb7  */
    /* JADX WARN: Code duplicated, block: B:637:0x0bc5 A[LOOP:6: B:635:0x0bbf->B:637:0x0bc5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:640:0x0bd5  */
    /* JADX WARN: Code duplicated, block: B:642:0x0bdb  */
    /* JADX WARN: Code duplicated, block: B:643:0x0be9  */
    /* JADX WARN: Code duplicated, block: B:645:0x0bf3  */
    /* JADX WARN: Code duplicated, block: B:651:0x0c08  */
    /* JADX WARN: Code duplicated, block: B:653:0x0c18  */
    /* JADX WARN: Code duplicated, block: B:655:0x0c22  */
    /* JADX WARN: Code duplicated, block: B:661:0x0c37  */
    /* JADX WARN: Code duplicated, block: B:663:0x0c45  */
    /* JADX WARN: Code duplicated, block: B:665:0x0c4d  */
    /* JADX WARN: Code duplicated, block: B:666:0x0c50  */
    /* JADX WARN: Code duplicated, block: B:669:0x0c54  */
    /* JADX WARN: Code duplicated, block: B:671:0x0c5e  */
    /* JADX WARN: Code duplicated, block: B:672:0x0c60  */
    /* JADX WARN: Code duplicated, block: B:674:0x0c63  */
    /* JADX WARN: Code duplicated, block: B:676:0x0c71  */
    /* JADX WARN: Code duplicated, block: B:680:0x0c9d  */
    /* JADX WARN: Code duplicated, block: B:696:0x07ca A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:697:0x07c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:698:0x07f2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:700:0x07b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:715:0x0b9b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:716:0x0a14 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:717:0x09e1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:719:0x09a5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:721:0x098f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:733:0x087d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:734:0x0859 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:736:0x0860 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:737:0x0857 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:740:0x0840 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x0180  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v111, types: [b.g.a.c.n] */
    /* JADX WARN: Type inference failed for: r1v114 */
    /* JADX WARN: Type inference failed for: r1v120 */
    /* JADX WARN: Type inference failed for: r1v121, types: [b.g.a.c.g0.d] */
    /* JADX WARN: Type inference failed for: r1v127, types: [b.g.a.c.g0.d] */
    /* JADX WARN: Type inference failed for: r1v155 */
    /* JADX WARN: Type inference failed for: r1v162 */
    /* JADX WARN: Type inference failed for: r1v163, types: [b.g.a.c.n] */
    /* JADX WARN: Type inference failed for: r1v164 */
    /* JADX WARN: Type inference failed for: r1v194 */
    /* JADX WARN: Type inference failed for: r1v195 */
    /* JADX WARN: Type inference failed for: r1v196 */
    /* JADX WARN: Type inference failed for: r1v197 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v203 */
    /* JADX WARN: Type inference failed for: r1v204, types: [b.g.a.c.g0.u.d0] */
    /* JADX WARN: Type inference failed for: r1v207, types: [b.g.a.c.n] */
    /* JADX WARN: Type inference failed for: r1v208 */
    /* JADX WARN: Type inference failed for: r1v210 */
    /* JADX WARN: Type inference failed for: r1v211 */
    /* JADX WARN: Type inference failed for: r1v217 */
    /* JADX WARN: Type inference failed for: r1v218 */
    /* JADX WARN: Type inference failed for: r1v229 */
    /* JADX WARN: Type inference failed for: r1v235, types: [b.g.a.c.n<?>] */
    /* JADX WARN: Type inference failed for: r1v236 */
    /* JADX WARN: Type inference failed for: r1v237 */
    /* JADX WARN: Type inference failed for: r1v239 */
    /* JADX WARN: Type inference failed for: r1v242 */
    /* JADX WARN: Type inference failed for: r1v243 */
    /* JADX WARN: Type inference failed for: r1v247 */
    /* JADX WARN: Type inference failed for: r1v249 */
    /* JADX WARN: Type inference failed for: r1v250 */
    /* JADX WARN: Type inference failed for: r1v251 */
    /* JADX WARN: Type inference failed for: r1v252 */
    /* JADX WARN: Type inference failed for: r1v253 */
    /* JADX WARN: Type inference failed for: r1v254 */
    /* JADX WARN: Type inference failed for: r1v255 */
    /* JADX WARN: Type inference failed for: r1v256 */
    /* JADX WARN: Type inference failed for: r1v257 */
    /* JADX WARN: Type inference failed for: r1v258 */
    /* JADX WARN: Type inference failed for: r1v259 */
    /* JADX WARN: Type inference failed for: r1v260 */
    /* JADX WARN: Type inference failed for: r1v261 */
    /* JADX WARN: Type inference failed for: r1v262 */
    /* JADX WARN: Type inference failed for: r1v263 */
    /* JADX WARN: Type inference failed for: r1v264 */
    /* JADX WARN: Type inference failed for: r1v265 */
    /* JADX WARN: Type inference failed for: r1v266 */
    /* JADX WARN: Type inference failed for: r1v267 */
    /* JADX WARN: Type inference failed for: r1v268 */
    /* JADX WARN: Type inference failed for: r1v269 */
    /* JADX WARN: Type inference failed for: r1v270 */
    /* JADX WARN: Type inference failed for: r1v271 */
    /* JADX WARN: Type inference failed for: r1v272 */
    /* JADX WARN: Type inference failed for: r1v3, types: [b.g.a.c.n] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31, types: [b.g.a.c.n<?>] */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v70 */
    /* JADX WARN: Type inference failed for: r26v0, types: [b.g.a.c.g0.b, b.g.a.c.g0.f] */
    /* JADX WARN: Type inference failed for: r5v33, types: [b.g.a.c.g0.t.i] */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v8, types: [b.g.a.c.n] */
    /* JADX WARN: Type inference failed for: r5v9 */
    public JsonSerializer<?> i(SerializerProvider serializerProvider, JavaType javaType, BeanDescription beanDescription, boolean z2) throws JsonMappingException {
        JsonInclude.a aVar;
        JsonInclude.a aVar2;
        JsonFormat.c cVar;
        Class<Enum> cls;
        BeanDescription beanDescription2;
        int i;
        ?? E;
        JsonSerializer<?> jsonSerializerA;
        int i2;
        Object objT0;
        boolean zB;
        int i3;
        char c;
        int iOrdinal;
        ToStringSerializer toStringSerializer;
        NumberSerializer numberSerializer;
        ToStringSerializer toStringSerializer2;
        TimeZoneSerializer2 timeZoneSerializer2;
        InetSocketAddressSerializer inetSocketAddressSerializer;
        InetAddressSerializer inetAddressSerializer;
        ByteBufferSerializer byteBufferSerializer;
        Object objT1;
        boolean zB2;
        DateSerializer2 dateSerializer2;
        CalendarSerializer2 calendarSerializer2;
        String str;
        boolean z3;
        String str2;
        String str3;
        String str4;
        UnsupportedTypeSerializer unsupportedTypeSerializer;
        SerializationConfig serializationConfig;
        BeanSerializerBuilder beanSerializerBuilder;
        BasicBeanDescription basicBeanDescription;
        List<BeanPropertyDefinition> listD;
        SerializationConfig serializationConfig2;
        AnnotationIntrospector annotationIntrospectorE;
        HashMap map;
        Iterator<BeanPropertyDefinition> it;
        boolean zG;
        PropertyBuilder propertyBuilder;
        ArrayList arrayList;
        boolean z4;
        ArrayList<BeanPropertyWriter> arrayList2;
        AnnotatedMember annotatedMemberJ;
        AnnotationIntrospector.a aVarH;
        ArrayList arrayList3;
        boolean z5;
        int size;
        int i4;
        TypeSerializer typeSerializer;
        boolean zEquals;
        JsonIgnoreProperties.a aVarS;
        Set<String> setD;
        AnnotatedClass annotatedClass;
        AnnotationIntrospector annotationIntrospectorE2;
        JsonIncludeProperties.a aVarA;
        Set<String> set;
        Iterator it2;
        ObjectIdInfo objectIdInfo;
        Class<? extends ObjectIdGenerator<?>> cls2;
        ObjectIdWriter objectIdWriterA;
        String str5;
        int size2;
        int i5;
        String strC;
        BeanPropertyWriter beanPropertyWriter;
        POJOPropertiesCollector pOJOPropertiesCollector;
        AnnotatedMember first;
        List<BeanPropertyWriter> list;
        boolean zQ;
        int size3;
        BeanPropertyWriter[] beanPropertyWriterArr;
        int i6;
        Class<?> cls3;
        boolean z6;
        ToStringSerializer toStringSerializer3;
        JavaType[] javaTypeArrI;
        JavaType javaTypeK;
        boolean z7;
        JavaType[] javaTypeArrI2;
        JavaType javaTypeK2;
        ArrayIterator2 arrayIterator2;
        BeanPropertyWriter beanPropertyWriter2;
        Class<?>[] clsArr;
        List<BeanPropertyWriter> list2;
        JavaType javaTypeE;
        TypeSerializer typeSerializerC;
        JsonSerializer jsonSerializerF;
        LinkedList<AnnotatedMember> linkedList;
        POJOPropertiesCollector pOJOPropertiesCollector2;
        LinkedList<AnnotatedMember> linkedList2;
        ArrayIterator2 arrayIterator3;
        ArrayIterator2 arrayIterator4;
        Iterator<BeanPropertyDefinition> it3;
        BeanPropertyDefinition next;
        BeanPropertyDefinition next2;
        Class<?> clsR;
        Boolean boolC0;
        JsonSerializer<Object> jsonSerializerX;
        EnumSerializer2 enumSerializer2;
        Class<? extends JsonSerializer<?>> cls4;
        JsonSerializer jsonSerializer;
        boolean z8;
        JsonSerializer<?> jsonSerializerE;
        boolean z9;
        TypeSerializer typeSerializer2;
        JsonSerializer<Object> jsonSerializer2;
        ContainerSerializer collectionSerializer2;
        JsonFormat.c cVar2;
        JsonSerializer<?> jsonSerializerE2;
        SerializationConfig serializationConfig3;
        JsonSerializer<Object> jsonSerializer3;
        BasicBeanDescription basicBeanDescription2;
        boolean z10;
        TypeSerializer typeSerializer3;
        Object objT2;
        boolean zB3;
        BeanDescription beanDescription3 = beanDescription;
        boolean z11 = z2;
        Class<Enum> cls5 = Enum.class;
        JsonFormat.c cVar3 = JsonFormat.c.OBJECT;
        JsonInclude.a aVar3 = JsonInclude.a.ALWAYS;
        JsonInclude.a aVar4 = JsonInclude.a.USE_DEFAULTS;
        SerializationConfig serializationConfig4 = serializerProvider._config;
        if (javaType.v()) {
            boolean zG2 = !z11 ? g(serializationConfig4, beanDescription3, null) : z11;
            SerializationConfig serializationConfig5 = serializerProvider._config;
            boolean z12 = (zG2 || !javaType._asStatic || (javaType.v() && javaType.k().y())) ? zG2 : true;
            TypeSerializer typeSerializerC2 = c(serializationConfig5, javaType.k());
            boolean z13 = typeSerializerC2 != null ? false : z12;
            BasicBeanDescription basicBeanDescription3 = (BasicBeanDescription) beanDescription3;
            AnnotatedClass annotatedClass2 = basicBeanDescription3.f;
            Object objC = serializerProvider.v().c(annotatedClass2);
            JsonSerializer<Object> jsonSerializerH = objC != null ? serializerProvider.H(annotatedClass2, objC) : null;
            if (javaType.z()) {
                MapLikeType mapLikeType = (MapLikeType) javaType;
                AnnotatedClass annotatedClass3 = basicBeanDescription3.f;
                Object objL = serializerProvider.v().l(annotatedClass3);
                JsonSerializer<Object> jsonSerializerH2 = objL != null ? serializerProvider.H(annotatedClass3, objL) : null;
                if (mapLikeType instanceof MapType) {
                    MapType mapType = (MapType) mapLikeType;
                    if (beanDescription3.a(null).e() == cVar3) {
                        E = 0;
                        cVar2 = cVar3;
                    } else {
                        SerializationConfig serializationConfig6 = serializerProvider._config;
                        ArrayIterator2 arrayIterator5 = (ArrayIterator2) j();
                        JsonSerializer<?> jsonSerializerE3 = null;
                        while (true) {
                            if (!arrayIterator5.hasNext()) {
                                cVar2 = cVar3;
                                serializationConfig3 = serializationConfig6;
                                jsonSerializer3 = jsonSerializerH;
                                basicBeanDescription2 = basicBeanDescription3;
                                z10 = z13;
                                typeSerializer3 = typeSerializerC2;
                                break;
                            }
                            serializationConfig3 = serializationConfig6;
                            jsonSerializer3 = jsonSerializerH;
                            cVar2 = cVar3;
                            basicBeanDescription2 = basicBeanDescription3;
                            z10 = z13;
                            typeSerializer3 = typeSerializerC2;
                            jsonSerializerE3 = ((Serializers) arrayIterator5.next()).c(serializationConfig6, mapType, beanDescription, jsonSerializerH2, typeSerializerC2, jsonSerializer3);
                            if (jsonSerializerE3 != null) {
                                break;
                            }
                            serializationConfig6 = serializationConfig3;
                            basicBeanDescription3 = basicBeanDescription2;
                            z13 = z10;
                            typeSerializerC2 = typeSerializer3;
                            jsonSerializerH = jsonSerializer3;
                            cVar3 = cVar2;
                        }
                        if (jsonSerializerE3 == null && (jsonSerializerE3 = e(serializerProvider, mapType, beanDescription3)) == null) {
                            Object objG = serializationConfig3.e().g(basicBeanDescription2.f);
                            SerializationConfig serializationConfig7 = serializationConfig3;
                            JsonIgnoreProperties.a aVarS2 = serializationConfig7.s(Map.class, basicBeanDescription2.f);
                            Set<String> setD2 = aVarS2 == null ? null : aVarS2.d();
                            AnnotatedClass annotatedClass4 = basicBeanDescription2.f;
                            AnnotationIntrospector annotationIntrospectorE3 = serializationConfig7.e();
                            JsonIncludeProperties.a aVarA2 = annotationIntrospectorE3 == null ? null : annotationIntrospectorE3.A(serializationConfig7, annotatedClass4);
                            MapSerializer2 mapSerializer2S = MapSerializer2.s(setD2, aVarA2 == null ? null : aVarA2._included, mapType, z10, typeSerializer3, jsonSerializerH2, jsonSerializer3, objG);
                            JavaType javaType2 = mapSerializer2S._valueType;
                            JsonInclude.b bVarD = d(serializerProvider, beanDescription3, javaType2, Map.class);
                            JsonInclude.a aVar5 = bVarD == null ? aVar4 : bVarD._contentInclusion;
                            if (aVar5 == aVar4 || aVar5 == aVar3) {
                                E = mapSerializer2S;
                                if (!serializerProvider.D(SerializationFeature.WRITE_NULL_MAP_VALUES)) {
                                    E = mapSerializer2S.v(null, true);
                                }
                            } else {
                                int iOrdinal2 = aVar5.ordinal();
                                if (iOrdinal2 != 2) {
                                    if (iOrdinal2 == 3) {
                                        objT2 = MapSerializer2.l;
                                    } else if (iOrdinal2 == 4) {
                                        objT2 = AnimatableValueParser.t0(javaType2);
                                        if (objT2 != null && objT2.getClass().isArray()) {
                                            objT2 = AnimatableValueParser.q0(objT2);
                                        }
                                    } else if (iOrdinal2 != 5) {
                                        zB3 = true;
                                        objT2 = null;
                                    } else {
                                        objT2 = serializerProvider.A(null, bVarD._contentFilter);
                                        if (objT2 != null) {
                                            zB3 = serializerProvider.B(objT2);
                                        }
                                    }
                                    zB3 = true;
                                } else if (javaType2.b()) {
                                    objT2 = MapSerializer2.l;
                                    zB3 = true;
                                } else {
                                    zB3 = true;
                                    objT2 = null;
                                }
                                E = mapSerializer2S.v(objT2, zB3);
                            }
                        } else {
                            E = jsonSerializerE3;
                        }
                        if (this._factoryConfig.a()) {
                            ArrayIterator2 arrayIterator6 = (ArrayIterator2) this._factoryConfig.b();
                            while (arrayIterator6.hasNext()) {
                                Objects.requireNonNull((BeanSerializerModifier) arrayIterator6.next());
                            }
                        }
                    }
                } else {
                    cVar2 = cVar3;
                    JsonSerializer<?> jsonSerializerF2 = null;
                    ArrayIterator2 arrayIterator7 = (ArrayIterator2) j();
                    while (arrayIterator7.hasNext()) {
                        MapLikeType mapLikeType2 = mapLikeType;
                        jsonSerializerF2 = ((Serializers) arrayIterator7.next()).f(serializationConfig5, mapLikeType, beanDescription, jsonSerializerH2, typeSerializerC2, jsonSerializerH);
                        if (jsonSerializerF2 != null) {
                            break;
                        }
                        mapLikeType = mapLikeType2;
                    }
                    if (jsonSerializerF2 == null) {
                        jsonSerializerE2 = e(serializerProvider, javaType, beanDescription);
                    } else {
                        E = jsonSerializerF2;
                    }
                    if (E != 0 && this._factoryConfig.a()) {
                        E = jsonSerializerE2;
                        ArrayIterator2 arrayIterator8 = (ArrayIterator2) this._factoryConfig.b();
                        while (arrayIterator8.hasNext()) {
                            Objects.requireNonNull((BeanSerializerModifier) arrayIterator8.next());
                        }
                    }
                }
                E = jsonSerializerE2;
                E = jsonSerializerE2;
                aVar = aVar4;
                aVar2 = aVar3;
                cls = cls5;
                beanDescription2 = beanDescription3;
                cVar = cVar2;
            } else {
                JsonFormat.c cVar4 = cVar3;
                boolean z14 = z13;
                JsonSerializer<?> jsonSerializerE4 = null;
                if (javaType.u()) {
                    CollectionLikeType collectionLikeType = (CollectionLikeType) javaType;
                    if (collectionLikeType instanceof CollectionType) {
                        CollectionType collectionType = (CollectionType) collectionLikeType;
                        SerializationConfig serializationConfig8 = serializerProvider._config;
                        ArrayIterator2 arrayIterator9 = (ArrayIterator2) j();
                        while (true) {
                            if (!arrayIterator9.hasNext()) {
                                aVar = aVar4;
                                aVar2 = aVar3;
                                cls = cls5;
                                beanDescription2 = beanDescription3;
                                cVar = cVar4;
                                break;
                            }
                            Serializers serializers = (Serializers) arrayIterator9.next();
                            aVar = aVar4;
                            SerializationConfig serializationConfig9 = serializationConfig8;
                            aVar2 = aVar3;
                            cVar = cVar4;
                            SerializationConfig serializationConfig10 = serializationConfig8;
                            cls = cls5;
                            ArrayIterator2 arrayIterator10 = arrayIterator9;
                            beanDescription2 = beanDescription3;
                            jsonSerializerE4 = serializers.g(serializationConfig9, collectionType, beanDescription, typeSerializerC2, jsonSerializerH);
                            if (jsonSerializerE4 != null) {
                                break;
                            }
                            cls5 = cls;
                            beanDescription3 = beanDescription2;
                            aVar4 = aVar;
                            aVar3 = aVar2;
                            cVar4 = cVar;
                            serializationConfig8 = serializationConfig10;
                            arrayIterator9 = arrayIterator10;
                        }
                        if (jsonSerializerE4 != null || (jsonSerializerE4 = e(serializerProvider, collectionType, beanDescription2)) != null) {
                            E = jsonSerializerE4;
                        } else if (beanDescription2.a(null).e() == cVar) {
                            E = 0;
                        } else {
                            Class<?> cls6 = collectionType._class;
                            if (EnumSet.class.isAssignableFrom(cls6)) {
                                JavaType javaType3 = collectionType._elementType;
                                if (!(ClassUtil.q(javaType3._class) && javaType3._class != cls)) {
                                    javaType3 = null;
                                }
                                collectionSerializer2 = new EnumSetSerializer2(javaType3);
                            } else {
                                Class<?> cls7 = collectionType._elementType._class;
                                if (!RandomAccess.class.isAssignableFrom(cls6)) {
                                    z9 = z14;
                                    typeSerializer2 = typeSerializerC2;
                                    jsonSerializer2 = jsonSerializerH;
                                    if (cls7 == String.class && ClassUtil.s(jsonSerializer2)) {
                                        jsonSerializerE4 = StringCollectionSerializer.k;
                                    }
                                } else if (cls7 == String.class) {
                                    if (ClassUtil.s(jsonSerializerH)) {
                                        jsonSerializerE4 = IndexedStringListSerializer.k;
                                    }
                                    z9 = z14;
                                    typeSerializer2 = typeSerializerC2;
                                    jsonSerializer2 = jsonSerializerH;
                                } else {
                                    z9 = z14;
                                    typeSerializer2 = typeSerializerC2;
                                    jsonSerializer2 = jsonSerializerH;
                                    jsonSerializerE4 = new IndexedListSerializer(collectionType._elementType, z9, typeSerializer2, jsonSerializer2);
                                }
                                if (jsonSerializerE4 == null) {
                                    collectionSerializer2 = new CollectionSerializer2(collectionType._elementType, z9, typeSerializer2, jsonSerializer2);
                                } else {
                                    E = jsonSerializerE4;
                                }
                            }
                            E = collectionSerializer2;
                        }
                        if (this._factoryConfig.a()) {
                            ArrayIterator2 arrayIterator11 = (ArrayIterator2) this._factoryConfig.b();
                            while (arrayIterator11.hasNext()) {
                                Objects.requireNonNull((BeanSerializerModifier) arrayIterator11.next());
                            }
                        }
                    } else {
                        aVar = aVar4;
                        aVar2 = aVar3;
                        cls = cls5;
                        beanDescription2 = beanDescription3;
                        TypeSerializer typeSerializer4 = typeSerializerC2;
                        JsonSerializer<Object> jsonSerializer4 = jsonSerializerH;
                        cVar = cVar4;
                        ArrayIterator2 arrayIterator12 = (ArrayIterator2) j();
                        JsonSerializer<?> jsonSerializerD = null;
                        while (arrayIterator12.hasNext()) {
                            SerializationConfig serializationConfig11 = serializationConfig5;
                            JsonSerializer<Object> jsonSerializer5 = jsonSerializer4;
                            TypeSerializer typeSerializer5 = typeSerializer4;
                            jsonSerializerD = ((Serializers) arrayIterator12.next()).d(serializationConfig11, collectionLikeType, beanDescription, typeSerializer4, jsonSerializer5);
                            if (jsonSerializerD != null) {
                                break;
                            }
                            serializationConfig5 = serializationConfig11;
                            typeSerializer4 = typeSerializer5;
                            jsonSerializer4 = jsonSerializer5;
                        }
                        if (jsonSerializerD == null) {
                            jsonSerializerE = e(serializerProvider, javaType, beanDescription);
                        } else {
                            E = jsonSerializerD;
                        }
                        if (E != 0 && this._factoryConfig.a()) {
                            E = jsonSerializerE;
                            ArrayIterator2 arrayIterator13 = (ArrayIterator2) this._factoryConfig.b();
                            while (arrayIterator13.hasNext()) {
                                Objects.requireNonNull((BeanSerializerModifier) arrayIterator13.next());
                            }
                        }
                    }
                } else {
                    aVar = aVar4;
                    aVar2 = aVar3;
                    cls = cls5;
                    beanDescription2 = beanDescription3;
                    boolean z15 = z14;
                    cVar = cVar4;
                    if (javaType instanceof ArrayType) {
                        ArrayType arrayType = (ArrayType) javaType;
                        SerializationConfig serializationConfig12 = serializerProvider._config;
                        ArrayIterator2 arrayIterator14 = (ArrayIterator2) j();
                        E = 0;
                        while (true) {
                            if (!arrayIterator14.hasNext()) {
                                z8 = z15;
                                break;
                            }
                            SerializationConfig serializationConfig13 = serializationConfig12;
                            SerializationConfig serializationConfig14 = serializationConfig12;
                            z8 = z15;
                            E = ((Serializers) arrayIterator14.next()).e(serializationConfig13, arrayType, beanDescription, typeSerializerC2, jsonSerializerH);
                            if (E != 0) {
                                break;
                            }
                            z15 = z8;
                            serializationConfig12 = serializationConfig14;
                            E = E;
                        }
                        if (E == 0) {
                            Class<?> cls8 = arrayType._class;
                            if (jsonSerializerH == null || ClassUtil.s(jsonSerializerH)) {
                                E = E;
                                E = String[].class == cls8 ? StringArraySerializer2.k : StdArraySerializers.a.get(cls8.getName());
                            }
                            if (E == 0) {
                                E = new ObjectArraySerializer2(arrayType._componentType, z8, typeSerializerC2, jsonSerializerH);
                            }
                        }
                        if (this._factoryConfig.a()) {
                            ArrayIterator2 arrayIterator15 = (ArrayIterator2) this._factoryConfig.b();
                            while (arrayIterator15.hasNext()) {
                                Objects.requireNonNull((BeanSerializerModifier) arrayIterator15.next());
                            }
                        }
                    } else {
                        E = 0;
                    }
                }
            }
            if (E != 0) {
                return E;
            }
            i = 3;
            z11 = zG2;
        } else {
            aVar = aVar4;
            aVar2 = aVar3;
            cVar = cVar3;
            cls = cls5;
            beanDescription2 = beanDescription3;
            if (javaType.b()) {
                ReferenceType referenceType = (ReferenceType) javaType;
                JavaType javaType4 = referenceType._referencedType;
                TypeSerializer typeSerializerC3 = (TypeSerializer) javaType4._typeHandler;
                SerializationConfig serializationConfig15 = serializerProvider._config;
                if (typeSerializerC3 == null) {
                    typeSerializerC3 = c(serializationConfig15, javaType4);
                }
                TypeSerializer typeSerializer6 = typeSerializerC3;
                JsonSerializer<Object> jsonSerializer6 = (JsonSerializer) javaType4._valueHandler;
                ArrayIterator2 arrayIterator16 = (ArrayIterator2) j();
                while (true) {
                    if (arrayIterator16.hasNext()) {
                        JsonSerializer<Object> jsonSerializer7 = jsonSerializer6;
                        TypeSerializer typeSerializer7 = typeSerializer6;
                        SerializationConfig serializationConfig16 = serializationConfig15;
                        jsonSerializerA = ((Serializers) arrayIterator16.next()).a(serializationConfig15, referenceType, beanDescription, typeSerializer6, jsonSerializer7);
                        if (jsonSerializerA == null) {
                            jsonSerializer6 = jsonSerializer7;
                            typeSerializer6 = typeSerializer7;
                            serializationConfig15 = serializationConfig16;
                        }
                    } else {
                        JsonSerializer<Object> jsonSerializer8 = jsonSerializer6;
                        TypeSerializer typeSerializer8 = typeSerializer6;
                        if (referenceType.B(AtomicReference.class)) {
                            JavaType javaType5 = referenceType._referencedType;
                            JsonInclude.b bVarD2 = d(serializerProvider, beanDescription2, javaType5, AtomicReference.class);
                            JsonInclude.a aVar6 = bVarD2 == null ? aVar : bVarD2._contentInclusion;
                            if (aVar6 == aVar || aVar6 == aVar2) {
                                i2 = 3;
                                objT0 = null;
                                zB = false;
                            } else {
                                int iOrdinal3 = aVar6.ordinal();
                                if (iOrdinal3 != 2) {
                                    i2 = 3;
                                    if (iOrdinal3 == 3) {
                                        objT0 = MapSerializer2.l;
                                    } else if (iOrdinal3 == 4) {
                                        objT0 = AnimatableValueParser.t0(javaType5);
                                        if (objT0 != null && objT0.getClass().isArray()) {
                                            objT0 = AnimatableValueParser.q0(objT0);
                                        }
                                    } else if (iOrdinal3 != 5) {
                                        objT0 = null;
                                    } else {
                                        objT0 = serializerProvider.A(null, bVarD2._contentFilter);
                                        if (objT0 != null) {
                                            zB = serializerProvider.B(objT0);
                                        }
                                    }
                                    zB = true;
                                } else {
                                    i2 = 3;
                                    if (javaType5.b()) {
                                        objT0 = MapSerializer2.l;
                                    } else {
                                        objT0 = null;
                                    }
                                    zB = true;
                                }
                            }
                            ReferenceTypeSerializer<AtomicReference<?>> referenceTypeSerializerT = new AtomicReferenceSerializer(referenceType, z11, typeSerializer8, jsonSerializer8).t(objT0, zB);
                            i = i2;
                            E = referenceTypeSerializerT;
                            break;
                        }
                        jsonSerializerA = null;
                    }
                    i = 3;
                    E = jsonSerializerA;
                    break;
                }
            }
            i = 3;
            ArrayIterator2 arrayIterator17 = (ArrayIterator2) j();
            JsonSerializer<?> jsonSerializerB = null;
            while (arrayIterator17.hasNext() && (jsonSerializerB = ((Serializers) arrayIterator17.next()).b(serializationConfig4, javaType, beanDescription2)) == null) {
            }
            E = jsonSerializerB;
            if (E == 0) {
                E = e(serializerProvider, javaType, beanDescription);
            }
        }
        if (E == 0) {
            String name = javaType._class.getName();
            JsonSerializer<?> jsonSerializer9 = BasicSerializerFactory.j.get(name);
            if (jsonSerializer9 != null || (cls4 = BasicSerializerFactory.k.get(name)) == null) {
                E = jsonSerializer9;
                i3 = 0;
            } else {
                i3 = 0;
                jsonSerializer = (JsonSerializer) ClassUtil.g(cls4, false);
            }
            if (E == 0) {
                if (javaType.w()) {
                    SerializationConfig serializationConfig17 = serializerProvider._config;
                    JsonFormat.d dVarA = beanDescription2.a(null);
                    if (dVarA.e() == cVar) {
                        E = jsonSerializer;
                        Iterator<BeanPropertyDefinition> it4 = ((BasicBeanDescription) beanDescription2).d().iterator();
                        while (it4.hasNext()) {
                            if (it4.next().p().equals("declaringClass")) {
                                it4.remove();
                                break;
                            }
                        }
                        enumSerializer2 = null;
                    } else {
                        Class<?> cls9 = javaType._class;
                        int i7 = EnumSerializer2.k;
                        EnumSerializer2 enumSerializer3 = new EnumSerializer2(EnumValues.a(serializationConfig17, cls9), EnumSerializer2.p(cls9, dVarA, true, null));
                        if (this._factoryConfig.a()) {
                            E = jsonSerializer;
                            ArrayIterator2 arrayIterator18 = (ArrayIterator2) this._factoryConfig.b();
                            while (arrayIterator18.hasNext()) {
                                Objects.requireNonNull((BeanSerializerModifier) arrayIterator18.next());
                            }
                        }
                        E = jsonSerializer;
                        enumSerializer2 = enumSerializer3;
                    }
                    c = 1;
                    E = enumSerializer2;
                } else {
                    c = 1;
                    Class<?> cls10 = javaType._class;
                    ?? A = OptionalHandlerFactory.l.a(serializerProvider._config, javaType, beanDescription2);
                    if (A != 0) {
                        E = jsonSerializer;
                        E = A;
                    } else if (Calendar.class.isAssignableFrom(cls10)) {
                        calendarSerializer2 = CalendarSerializer2.k;
                    } else if (Date.class.isAssignableFrom(cls10)) {
                        dateSerializer2 = DateSerializer2.k;
                    } else if (Map.Entry.class.isAssignableFrom(cls10)) {
                        JavaType javaTypeI = javaType.i(Map.Entry.class);
                        JavaType javaTypeH = javaTypeI.h(i3);
                        JavaType javaTypeH2 = javaTypeI.h(1);
                        JsonFormat.d dVarI = serializerProvider._config.i(Map.Entry.class);
                        JsonFormat.d dVarA2 = beanDescription2.a(null);
                        if (dVarA2 != null) {
                            E = jsonSerializer;
                            dVarI = dVarA2.k(dVarI);
                        }
                        E = jsonSerializer;
                        if (dVarI.e() == cVar) {
                            A = 0;
                        } else {
                            A = new MapEntrySerializer(javaTypeH2, javaTypeH, javaTypeH2, z11, c(serializerProvider._config, javaTypeH2), null);
                            JavaType javaType6 = A._valueType;
                            JsonInclude.b bVarD3 = d(serializerProvider, beanDescription2, javaType6, Map.Entry.class);
                            JsonInclude.a aVar7 = bVarD3 == null ? aVar : bVarD3._contentInclusion;
                            if (aVar7 != aVar && aVar7 != aVar2) {
                                int iOrdinal4 = aVar7.ordinal();
                                if (iOrdinal4 != 2) {
                                    if (iOrdinal4 == i) {
                                        objT1 = MapSerializer2.l;
                                    } else if (iOrdinal4 == 4) {
                                        objT1 = AnimatableValueParser.t0(javaType6);
                                        if (objT1 != null && objT1.getClass().isArray()) {
                                            objT1 = AnimatableValueParser.q0(objT1);
                                        }
                                    } else if (iOrdinal4 != 5) {
                                        objT1 = null;
                                    } else {
                                        objT1 = serializerProvider.A(null, bVarD3._contentFilter);
                                        if (objT1 != null) {
                                            zB2 = serializerProvider.B(objT1);
                                        }
                                    }
                                    zB2 = true;
                                } else {
                                    if (javaType6.b()) {
                                        objT1 = MapSerializer2.l;
                                    } else {
                                        objT1 = null;
                                    }
                                    zB2 = true;
                                }
                                if (A._suppressableValue != objT1 || A._suppressNulls != zB2) {
                                    A = new MapEntrySerializer(A, A._keySerializer, A._valueSerializer, objT1, zB2);
                                }
                            }
                        }
                        E = jsonSerializer;
                        E = A;
                    } else if (ByteBuffer.class.isAssignableFrom(cls10)) {
                        byteBufferSerializer = new ByteBufferSerializer();
                    } else if (InetAddress.class.isAssignableFrom(cls10)) {
                        inetAddressSerializer = new InetAddressSerializer();
                    } else if (InetSocketAddress.class.isAssignableFrom(cls10)) {
                        inetSocketAddressSerializer = new InetSocketAddressSerializer();
                    } else if (TimeZone.class.isAssignableFrom(cls10)) {
                        timeZoneSerializer2 = new TimeZoneSerializer2();
                    } else if (Charset.class.isAssignableFrom(cls10)) {
                        toStringSerializer2 = ToStringSerializer.k;
                    } else if (!Number.class.isAssignableFrom(cls10) || (iOrdinal = beanDescription2.a(null).e().ordinal()) == i || iOrdinal == 4) {
                        E = jsonSerializer;
                        E = jsonSerializer;
                        E = jsonSerializer;
                        E = 0;
                    } else if (iOrdinal != 8) {
                        numberSerializer = NumberSerializer.k;
                    } else {
                        toStringSerializer = ToStringSerializer.k;
                    }
                }
                if (E == 0) {
                    E = jsonSerializer;
                    E = toStringSerializer;
                    E = jsonSerializer;
                    E = numberSerializer;
                    E = jsonSerializer;
                    E = toStringSerializer2;
                    E = jsonSerializer;
                    E = timeZoneSerializer2;
                    E = jsonSerializer;
                    E = inetSocketAddressSerializer;
                    E = jsonSerializer;
                    E = inetAddressSerializer;
                    E = jsonSerializer;
                    E = byteBufferSerializer;
                    E = jsonSerializer;
                    E = dateSerializer2;
                    E = jsonSerializer;
                    E = calendarSerializer2;
                    Class<?> cls11 = javaType._class;
                    Annotation[] annotationArr = ClassUtil.a;
                    if (cls11.isAnnotation()) {
                        str = "annotation";
                    } else if (cls11.isArray()) {
                        str = "array";
                    } else if (cls.isAssignableFrom(cls11)) {
                        str = "enum";
                    } else {
                        str = cls11.isPrimitive() ? "primitive" : null;
                    }
                    if (str == null) {
                        String name2 = cls11.getName();
                        if (name2.startsWith("net.sf.cglib.proxy.") || name2.startsWith("org.hibernate.proxy.")) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                    } else {
                        z3 = false;
                    }
                    if (z3 || ClassUtil.q(javaType._class)) {
                        if (beanDescription2.a._class == Object.class) {
                            jsonSerializerX = serializerProvider.x(Object.class);
                        } else {
                            Class<?> cls12 = javaType._class;
                            if (cls12.getName().startsWith("java.time.")) {
                                str3 = "Java 8 date/time";
                                str4 = "com.fasterxml.jackson.datatype:jackson-datatype-jsr310";
                            } else {
                                if (cls12.getName().startsWith("org.joda.time.")) {
                                    str3 = "Joda date/time";
                                    str4 = "com.fasterxml.jackson.datatype:jackson-datatype-joda";
                                } else {
                                    str2 = null;
                                }
                                if (str2 == null && serializerProvider._config.a(javaType._class) == null) {
                                    unsupportedTypeSerializer = new UnsupportedTypeSerializer(javaType, str2);
                                } else {
                                    unsupportedTypeSerializer = null;
                                }
                                if (unsupportedTypeSerializer != null) {
                                    E = unsupportedTypeSerializer;
                                } else {
                                    serializationConfig = serializerProvider._config;
                                    beanSerializerBuilder = new BeanSerializerBuilder(beanDescription2);
                                    beanSerializerBuilder.c = serializationConfig;
                                    basicBeanDescription = (BasicBeanDescription) beanDescription2;
                                    listD = basicBeanDescription.d();
                                    serializationConfig2 = serializerProvider._config;
                                    annotationIntrospectorE = serializationConfig2.e();
                                    map = new HashMap();
                                    it = listD.iterator();
                                    while (it.hasNext()) {
                                        next2 = it.next();
                                        if (next2.j() == null) {
                                            it.remove();
                                        } else {
                                            clsR = next2.r();
                                            boolC0 = (Boolean) map.get(clsR);
                                            if (boolC0 == null) {
                                                serializationConfig2.f(clsR);
                                                boolC0 = annotationIntrospectorE.c0(((BasicBeanDescription) serializationConfig2.o(clsR)).f);
                                                if (boolC0 == null) {
                                                    boolC0 = Boolean.FALSE;
                                                }
                                                map.put(clsR, boolC0);
                                            }
                                            if (boolC0.booleanValue()) {
                                                it.remove();
                                            }
                                        }
                                    }
                                    if (serializationConfig2.q(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS)) {
                                        it3 = listD.iterator();
                                        while (it3.hasNext()) {
                                            next = it3.next();
                                            if (next.f() && !next.u()) {
                                                it3.remove();
                                            }
                                        }
                                    }
                                    if (listD.isEmpty()) {
                                        arrayList2 = null;
                                        z4 = z11;
                                    } else {
                                        zG = g(serializationConfig2, beanDescription2, null);
                                        propertyBuilder = new PropertyBuilder(serializationConfig2, beanDescription2);
                                        arrayList = new ArrayList(listD.size());
                                        for (BeanPropertyDefinition beanPropertyDefinition : listD) {
                                            annotatedMemberJ = beanPropertyDefinition.j();
                                            if (beanPropertyDefinition.v()) {
                                                aVarH = beanPropertyDefinition.h();
                                                if (aVarH == null) {
                                                    if (aVarH.a == 2) {
                                                        z5 = true;
                                                    } else {
                                                        z5 = false;
                                                    }
                                                    if (z5) {
                                                        arrayList3 = arrayList;
                                                    } else if (annotatedMemberJ instanceof AnnotatedMethod) {
                                                        arrayList3 = arrayList;
                                                        arrayList3.add(h(serializerProvider, beanPropertyDefinition, propertyBuilder, zG, (AnnotatedMethod) annotatedMemberJ));
                                                    } else {
                                                        arrayList3 = arrayList;
                                                        arrayList3.add(h(serializerProvider, beanPropertyDefinition, propertyBuilder, zG, (AnnotatedField) annotatedMemberJ));
                                                    }
                                                } else if (annotatedMemberJ instanceof AnnotatedMethod) {
                                                    arrayList3 = arrayList;
                                                    arrayList3.add(h(serializerProvider, beanPropertyDefinition, propertyBuilder, zG, (AnnotatedMethod) annotatedMemberJ));
                                                } else {
                                                    arrayList3 = arrayList;
                                                    arrayList3.add(h(serializerProvider, beanPropertyDefinition, propertyBuilder, zG, (AnnotatedField) annotatedMemberJ));
                                                }
                                                arrayList = arrayList3;
                                                z11 = z11;
                                            } else if (annotatedMemberJ == null) {
                                                continue;
                                            } else {
                                                if (beanSerializerBuilder.h == null) {
                                                    StringBuilder sbU = outline.U("Multiple type ids specified with ");
                                                    sbU.append(beanSerializerBuilder.h);
                                                    sbU.append(" and ");
                                                    sbU.append(annotatedMemberJ);
                                                    throw new IllegalArgumentException(sbU.toString());
                                                }
                                                beanSerializerBuilder.h = annotatedMemberJ;
                                            }
                                        }
                                        z4 = z11;
                                        arrayList2 = arrayList;
                                    }
                                    if (arrayList2 == null) {
                                        arrayList2 = new ArrayList();
                                    } else {
                                        size = arrayList2.size();
                                        for (i4 = 0; i4 < size; i4++) {
                                            BeanPropertyWriter beanPropertyWriter3 = (BeanPropertyWriter) arrayList2.get(i4);
                                            typeSerializer = beanPropertyWriter3._typeSerializer;
                                            if (typeSerializer == null && typeSerializer.c() == JsonTypeInfo.a.EXTERNAL_PROPERTY) {
                                                PropertyName propertyNameA = PropertyName.a(typeSerializer.b());
                                                for (BeanPropertyWriter beanPropertyWriter4 : arrayList2) {
                                                    if (beanPropertyWriter4 != beanPropertyWriter3) {
                                                        PropertyName propertyName = beanPropertyWriter4._wrapperName;
                                                        if (propertyName != null) {
                                                            zEquals = propertyName.equals(propertyNameA);
                                                        } else if (!propertyNameA._simpleName.equals(beanPropertyWriter4._name._value)) {
                                                            zEquals = false;
                                                        } else if (propertyNameA._namespace != null) {
                                                            zEquals = false;
                                                        } else {
                                                            zEquals = true;
                                                        }
                                                        if (zEquals) {
                                                            beanPropertyWriter3._typeSerializer = null;
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    serializerProvider.v().a(serializationConfig, basicBeanDescription.f, arrayList2);
                                    if (this._factoryConfig.a()) {
                                        arrayIterator4 = (ArrayIterator2) this._factoryConfig.b();
                                        while (arrayIterator4.hasNext()) {
                                            Objects.requireNonNull((BeanSerializerModifier) arrayIterator4.next());
                                        }
                                    }
                                    aVarS = serializationConfig.s(beanDescription2.a._class, basicBeanDescription.f);
                                    if (aVarS != null) {
                                        setD = aVarS.d();
                                    } else {
                                        setD = null;
                                    }
                                    Class<?> cls13 = beanDescription2.a._class;
                                    annotatedClass = basicBeanDescription.f;
                                    annotationIntrospectorE2 = serializationConfig.e();
                                    if (annotationIntrospectorE2 == null) {
                                        aVarA = null;
                                    } else {
                                        aVarA = annotationIntrospectorE2.A(serializationConfig, annotatedClass);
                                    }
                                    if (aVarA != null) {
                                        set = aVarA._included;
                                    } else {
                                        set = null;
                                    }
                                    if (set == null || (setD != null && !setD.isEmpty())) {
                                        it2 = arrayList2.iterator();
                                        while (it2.hasNext()) {
                                            if (AnimatableValueParser.b2(((BeanPropertyWriter) it2.next())._name._value, setD, set)) {
                                                it2.remove();
                                            }
                                        }
                                    }
                                    if (this._factoryConfig.a()) {
                                        arrayIterator3 = (ArrayIterator2) this._factoryConfig.b();
                                        while (arrayIterator3.hasNext()) {
                                            Objects.requireNonNull((BeanSerializerModifier) arrayIterator3.next());
                                        }
                                    }
                                    objectIdInfo = basicBeanDescription.j;
                                    if (objectIdInfo == null) {
                                        objectIdWriterA = null;
                                    } else {
                                        cls2 = objectIdInfo.c;
                                        if (cls2 == ObjectIdGenerators3.class) {
                                            str5 = objectIdInfo.f681b._simpleName;
                                            size2 = arrayList2.size();
                                            i5 = 0;
                                            while (true) {
                                                if (i5 == size2) {
                                                    Object[] objArr = new Object[2];
                                                    objArr[0] = ClassUtil.n(beanDescription2.a);
                                                    if (str5 == null) {
                                                        strC = "[null]";
                                                    } else {
                                                        strC = ClassUtil.c(str5);
                                                    }
                                                    objArr[1] = strC;
                                                    throw new IllegalArgumentException(String.format("Invalid Object Id definition for %s: cannot find property with name %s", objArr));
                                                }
                                                beanPropertyWriter = (BeanPropertyWriter) arrayList2.get(i5);
                                                if (str5.equals(beanPropertyWriter._name._value)) {
                                                    if (i5 > 0) {
                                                        arrayList2.remove(i5);
                                                        arrayList2.add(0, beanPropertyWriter);
                                                    }
                                                    objectIdWriterA = ObjectIdWriter.a(beanPropertyWriter._declaredType, null, new PropertyBasedObjectIdGenerator(objectIdInfo, beanPropertyWriter), objectIdInfo.f);
                                                    break;
                                                }
                                                i5++;
                                            }
                                        } else {
                                            objectIdWriterA = ObjectIdWriter.a(serializerProvider.d().i(serializerProvider.b(cls2), ObjectIdGenerator.class)[0], objectIdInfo.f681b, serializerProvider.e(basicBeanDescription.f, objectIdInfo), objectIdInfo.f);
                                        }
                                    }
                                    beanSerializerBuilder.i = objectIdWriterA;
                                    beanSerializerBuilder.d = arrayList2;
                                    beanSerializerBuilder.g = serializationConfig.e().g(basicBeanDescription.f);
                                    pOJOPropertiesCollector = basicBeanDescription.c;
                                    if (pOJOPropertiesCollector == null) {
                                        first = null;
                                    } else {
                                        if (!pOJOPropertiesCollector.i) {
                                            pOJOPropertiesCollector.h();
                                        }
                                        linkedList = pOJOPropertiesCollector.m;
                                        if (linkedList != null) {
                                            first = null;
                                        } else {
                                            if (linkedList.size() <= 1) {
                                                pOJOPropertiesCollector.i("Multiple 'any-getter' methods defined (%s vs %s)", pOJOPropertiesCollector.m.get(0), pOJOPropertiesCollector.m.get(1));
                                                throw null;
                                            }
                                            first = pOJOPropertiesCollector.m.getFirst();
                                        }
                                        if (first != null) {
                                            pOJOPropertiesCollector2 = basicBeanDescription.c;
                                            if (!pOJOPropertiesCollector2.i) {
                                                pOJOPropertiesCollector2.h();
                                            }
                                            linkedList2 = pOJOPropertiesCollector2.n;
                                            if (linkedList2 != null) {
                                                first = null;
                                            } else {
                                                if (linkedList2.size() <= 1) {
                                                    pOJOPropertiesCollector2.i("Multiple 'any-getter' fields defined (%s vs %s)", pOJOPropertiesCollector2.n.get(0), pOJOPropertiesCollector2.n.get(1));
                                                    throw null;
                                                }
                                                first = pOJOPropertiesCollector2.n.getFirst();
                                            }
                                            if (first != null) {
                                                first = null;
                                            } else if (!Map.class.isAssignableFrom(first.d())) {
                                                throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on field '%s': type is not instance of java.util.Map", first.c()));
                                            }
                                        } else if (!Map.class.isAssignableFrom(first.d())) {
                                            throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on method %s(): return type is not instance of java.util.Map", first.c()));
                                        }
                                    }
                                    if (first != null) {
                                        javaTypeE = first.e();
                                        JavaType javaTypeK3 = javaTypeE.k();
                                        typeSerializerC = c(serializationConfig, javaTypeK3);
                                        jsonSerializerF = f(serializerProvider, first);
                                        if (jsonSerializerF == null) {
                                            jsonSerializerF = MapSerializer2.s(null, null, javaTypeE, serializationConfig.q(MapperFeature.USE_STATIC_TYPING), typeSerializerC, null, null, null);
                                        }
                                        beanSerializerBuilder.f = new AnyGetterWriter(new BeanProperty.a(PropertyName.a(first.c()), javaTypeK3, null, first, PropertyMetadata.k), first, jsonSerializerF);
                                    }
                                    list = beanSerializerBuilder.d;
                                    zQ = serializationConfig.q(MapperFeature.DEFAULT_VIEW_INCLUSION);
                                    size3 = list.size();
                                    beanPropertyWriterArr = new BeanPropertyWriter[size3];
                                    i6 = 0;
                                    int i8 = 0;
                                    while (i6 < size3) {
                                        beanPropertyWriter2 = list.get(i6);
                                        clsArr = beanPropertyWriter2._includeInViews;
                                        if (clsArr != null || clsArr.length == 0) {
                                            list2 = list;
                                            if (zQ) {
                                                beanPropertyWriterArr[i6] = beanPropertyWriter2;
                                            }
                                        } else {
                                            i8++;
                                            list2 = list;
                                            beanPropertyWriterArr[i6] = clsArr.length == 1 ? new FilteredBeanPropertyWriter2(beanPropertyWriter2, clsArr[0]) : new FilteredBeanPropertyWriter(beanPropertyWriter2, clsArr);
                                        }
                                        i6++;
                                        list = list2;
                                    }
                                    if (zQ || i8 != 0) {
                                        if (size3 != beanSerializerBuilder.d.size()) {
                                            throw new IllegalArgumentException(String.format("Trying to set %d filtered properties; must match length of non-filtered `properties` (%d)", Integer.valueOf(size3), Integer.valueOf(beanSerializerBuilder.d.size())));
                                        }
                                        beanSerializerBuilder.e = beanPropertyWriterArr;
                                    }
                                    if (this._factoryConfig.a()) {
                                        arrayIterator2 = (ArrayIterator2) this._factoryConfig.b();
                                        while (arrayIterator2.hasNext()) {
                                            Objects.requireNonNull((BeanSerializerModifier) arrayIterator2.next());
                                        }
                                    }
                                    try {
                                        E = beanSerializerBuilder.a();
                                        if (E == 0) {
                                            if (javaType.A()) {
                                                E = new BeanSerializer2(beanSerializerBuilder.f701b.a, beanSerializerBuilder, BeanSerializerBase.k, null);
                                            } else {
                                                cls3 = javaType._class;
                                                if (Iterator.class.isAssignableFrom(cls3)) {
                                                    javaTypeArrI2 = serializationConfig._base._typeFactory.i(javaType, Iterator.class);
                                                    if (javaTypeArrI2 == null && javaTypeArrI2.length == 1) {
                                                        javaTypeK2 = javaTypeArrI2[0];
                                                    } else {
                                                        javaTypeK2 = TypeFactory.k();
                                                    }
                                                    E = new IteratorSerializer(javaTypeK2, z4, c(serializationConfig, javaTypeK2));
                                                } else {
                                                    z6 = z4;
                                                    if (Iterable.class.isAssignableFrom(cls3)) {
                                                        javaTypeArrI = serializationConfig._base._typeFactory.i(javaType, Iterable.class);
                                                        if (javaTypeArrI == null && javaTypeArrI.length == 1) {
                                                            javaTypeK = javaTypeArrI[0];
                                                        } else {
                                                            javaTypeK = TypeFactory.k();
                                                        }
                                                        E = new IterableSerializer(javaTypeK, z6, c(serializationConfig, javaTypeK));
                                                    } else {
                                                        if (CharSequence.class.isAssignableFrom(cls3)) {
                                                            toStringSerializer3 = ToStringSerializer.k;
                                                        } else {
                                                            toStringSerializer3 = null;
                                                        }
                                                        E = toStringSerializer3;
                                                    }
                                                }
                                                if (E == 0) {
                                                    if (basicBeanDescription.f.t.size() > 0) {
                                                        z7 = true;
                                                    } else {
                                                        z7 = false;
                                                    }
                                                    if (z7) {
                                                        E = new BeanSerializer2(beanSerializerBuilder.f701b.a, beanSerializerBuilder, BeanSerializerBase.k, null);
                                                    }
                                                }
                                            }
                                        }
                                    } catch (RuntimeException e) {
                                        serializerProvider.F(beanDescription2, "Failed to construct BeanSerializer for %s: (%s) %s", beanDescription2.a, e.getClass().getName(), e.getMessage());
                                        throw null;
                                    }
                                }
                            }
                            Object[] objArr2 = new Object[i];
                            objArr2[i3] = str3;
                            objArr2[c] = ClassUtil.n(javaType);
                            objArr2[2] = str4;
                            str2 = String.format("%s type %s not supported by default: add Module \"%s\" to enable handling", objArr2);
                            if (str2 == null) {
                                unsupportedTypeSerializer = null;
                            } else {
                                unsupportedTypeSerializer = null;
                            }
                            if (unsupportedTypeSerializer != null) {
                                E = unsupportedTypeSerializer;
                            } else {
                                serializationConfig = serializerProvider._config;
                                beanSerializerBuilder = new BeanSerializerBuilder(beanDescription2);
                                beanSerializerBuilder.c = serializationConfig;
                                basicBeanDescription = (BasicBeanDescription) beanDescription2;
                                listD = basicBeanDescription.d();
                                serializationConfig2 = serializerProvider._config;
                                annotationIntrospectorE = serializationConfig2.e();
                                map = new HashMap();
                                it = listD.iterator();
                                while (it.hasNext()) {
                                    next2 = it.next();
                                    if (next2.j() == null) {
                                        it.remove();
                                    } else {
                                        clsR = next2.r();
                                        boolC0 = (Boolean) map.get(clsR);
                                        if (boolC0 == null) {
                                            serializationConfig2.f(clsR);
                                            boolC0 = annotationIntrospectorE.c0(((BasicBeanDescription) serializationConfig2.o(clsR)).f);
                                            if (boolC0 == null) {
                                                boolC0 = Boolean.FALSE;
                                            }
                                            map.put(clsR, boolC0);
                                        }
                                        if (boolC0.booleanValue()) {
                                            it.remove();
                                        }
                                    }
                                }
                                if (serializationConfig2.q(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS)) {
                                    it3 = listD.iterator();
                                    while (it3.hasNext()) {
                                        next = it3.next();
                                        if (next.f()) {
                                        }
                                    }
                                }
                                if (listD.isEmpty()) {
                                    arrayList2 = null;
                                    z4 = z11;
                                } else {
                                    zG = g(serializationConfig2, beanDescription2, null);
                                    propertyBuilder = new PropertyBuilder(serializationConfig2, beanDescription2);
                                    arrayList = new ArrayList(listD.size());
                                    while (r16.hasNext()) {
                                        annotatedMemberJ = beanPropertyDefinition.j();
                                        if (beanPropertyDefinition.v()) {
                                            aVarH = beanPropertyDefinition.h();
                                            if (aVarH == null) {
                                                if (aVarH.a == 2) {
                                                    z5 = true;
                                                } else {
                                                    z5 = false;
                                                }
                                                if (z5) {
                                                    arrayList3 = arrayList;
                                                } else if (annotatedMemberJ instanceof AnnotatedMethod) {
                                                    arrayList3 = arrayList;
                                                    arrayList3.add(h(serializerProvider, beanPropertyDefinition, propertyBuilder, zG, (AnnotatedMethod) annotatedMemberJ));
                                                } else {
                                                    arrayList3 = arrayList;
                                                    arrayList3.add(h(serializerProvider, beanPropertyDefinition, propertyBuilder, zG, (AnnotatedField) annotatedMemberJ));
                                                }
                                            } else if (annotatedMemberJ instanceof AnnotatedMethod) {
                                                arrayList3 = arrayList;
                                                arrayList3.add(h(serializerProvider, beanPropertyDefinition, propertyBuilder, zG, (AnnotatedMethod) annotatedMemberJ));
                                            } else {
                                                arrayList3 = arrayList;
                                                arrayList3.add(h(serializerProvider, beanPropertyDefinition, propertyBuilder, zG, (AnnotatedField) annotatedMemberJ));
                                            }
                                            arrayList = arrayList3;
                                            z11 = z11;
                                        } else if (annotatedMemberJ == null) {
                                            continue;
                                        } else {
                                            if (beanSerializerBuilder.h == null) {
                                                StringBuilder sbU2 = outline.U("Multiple type ids specified with ");
                                                sbU2.append(beanSerializerBuilder.h);
                                                sbU2.append(" and ");
                                                sbU2.append(annotatedMemberJ);
                                                throw new IllegalArgumentException(sbU2.toString());
                                            }
                                            beanSerializerBuilder.h = annotatedMemberJ;
                                        }
                                    }
                                    z4 = z11;
                                    arrayList2 = arrayList;
                                }
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList();
                                } else {
                                    size = arrayList2.size();
                                    while (i4 < size) {
                                        BeanPropertyWriter beanPropertyWriter5 = (BeanPropertyWriter) arrayList2.get(i4);
                                        typeSerializer = beanPropertyWriter5._typeSerializer;
                                        if (typeSerializer == null) {
                                        }
                                    }
                                }
                                serializerProvider.v().a(serializationConfig, basicBeanDescription.f, arrayList2);
                                if (this._factoryConfig.a()) {
                                    arrayIterator4 = (ArrayIterator2) this._factoryConfig.b();
                                    while (arrayIterator4.hasNext()) {
                                        Objects.requireNonNull((BeanSerializerModifier) arrayIterator4.next());
                                    }
                                }
                                aVarS = serializationConfig.s(beanDescription2.a._class, basicBeanDescription.f);
                                if (aVarS != null) {
                                    setD = aVarS.d();
                                } else {
                                    setD = null;
                                }
                                Class<?> cls14 = beanDescription2.a._class;
                                annotatedClass = basicBeanDescription.f;
                                annotationIntrospectorE2 = serializationConfig.e();
                                if (annotationIntrospectorE2 == null) {
                                    aVarA = null;
                                } else {
                                    aVarA = annotationIntrospectorE2.A(serializationConfig, annotatedClass);
                                }
                                if (aVarA != null) {
                                    set = aVarA._included;
                                } else {
                                    set = null;
                                }
                                if (set == null) {
                                    it2 = arrayList2.iterator();
                                    while (it2.hasNext()) {
                                        if (AnimatableValueParser.b2(((BeanPropertyWriter) it2.next())._name._value, setD, set)) {
                                            it2.remove();
                                        }
                                    }
                                } else {
                                    it2 = arrayList2.iterator();
                                    while (it2.hasNext()) {
                                        if (AnimatableValueParser.b2(((BeanPropertyWriter) it2.next())._name._value, setD, set)) {
                                            it2.remove();
                                        }
                                    }
                                }
                                if (this._factoryConfig.a()) {
                                    arrayIterator3 = (ArrayIterator2) this._factoryConfig.b();
                                    while (arrayIterator3.hasNext()) {
                                        Objects.requireNonNull((BeanSerializerModifier) arrayIterator3.next());
                                    }
                                }
                                objectIdInfo = basicBeanDescription.j;
                                if (objectIdInfo == null) {
                                    objectIdWriterA = null;
                                } else {
                                    cls2 = objectIdInfo.c;
                                    if (cls2 == ObjectIdGenerators3.class) {
                                        str5 = objectIdInfo.f681b._simpleName;
                                        size2 = arrayList2.size();
                                        i5 = 0;
                                        while (true) {
                                            if (i5 == size2) {
                                                Object[] objArr3 = new Object[2];
                                                objArr3[0] = ClassUtil.n(beanDescription2.a);
                                                if (str5 == null) {
                                                    strC = "[null]";
                                                } else {
                                                    strC = ClassUtil.c(str5);
                                                }
                                                objArr3[1] = strC;
                                                throw new IllegalArgumentException(String.format("Invalid Object Id definition for %s: cannot find property with name %s", objArr3));
                                            }
                                            beanPropertyWriter = (BeanPropertyWriter) arrayList2.get(i5);
                                            if (str5.equals(beanPropertyWriter._name._value)) {
                                                if (i5 > 0) {
                                                    arrayList2.remove(i5);
                                                    arrayList2.add(0, beanPropertyWriter);
                                                }
                                                objectIdWriterA = ObjectIdWriter.a(beanPropertyWriter._declaredType, null, new PropertyBasedObjectIdGenerator(objectIdInfo, beanPropertyWriter), objectIdInfo.f);
                                                break;
                                            }
                                            i5++;
                                        }
                                    } else {
                                        objectIdWriterA = ObjectIdWriter.a(serializerProvider.d().i(serializerProvider.b(cls2), ObjectIdGenerator.class)[0], objectIdInfo.f681b, serializerProvider.e(basicBeanDescription.f, objectIdInfo), objectIdInfo.f);
                                    }
                                }
                                beanSerializerBuilder.i = objectIdWriterA;
                                beanSerializerBuilder.d = arrayList2;
                                beanSerializerBuilder.g = serializationConfig.e().g(basicBeanDescription.f);
                                pOJOPropertiesCollector = basicBeanDescription.c;
                                if (pOJOPropertiesCollector == null) {
                                    first = null;
                                } else {
                                    if (!pOJOPropertiesCollector.i) {
                                        pOJOPropertiesCollector.h();
                                    }
                                    linkedList = pOJOPropertiesCollector.m;
                                    if (linkedList != null) {
                                        first = null;
                                    } else {
                                        if (linkedList.size() <= 1) {
                                            pOJOPropertiesCollector.i("Multiple 'any-getter' methods defined (%s vs %s)", pOJOPropertiesCollector.m.get(0), pOJOPropertiesCollector.m.get(1));
                                            throw null;
                                        }
                                        first = pOJOPropertiesCollector.m.getFirst();
                                    }
                                    if (first != null) {
                                        pOJOPropertiesCollector2 = basicBeanDescription.c;
                                        if (!pOJOPropertiesCollector2.i) {
                                            pOJOPropertiesCollector2.h();
                                        }
                                        linkedList2 = pOJOPropertiesCollector2.n;
                                        if (linkedList2 != null) {
                                            first = null;
                                        } else {
                                            if (linkedList2.size() <= 1) {
                                                pOJOPropertiesCollector2.i("Multiple 'any-getter' fields defined (%s vs %s)", pOJOPropertiesCollector2.n.get(0), pOJOPropertiesCollector2.n.get(1));
                                                throw null;
                                            }
                                            first = pOJOPropertiesCollector2.n.getFirst();
                                        }
                                        if (first != null) {
                                            first = null;
                                        } else if (!Map.class.isAssignableFrom(first.d())) {
                                            throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on field '%s': type is not instance of java.util.Map", first.c()));
                                        }
                                    } else if (!Map.class.isAssignableFrom(first.d())) {
                                        throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on method %s(): return type is not instance of java.util.Map", first.c()));
                                    }
                                }
                                if (first != null) {
                                    javaTypeE = first.e();
                                    JavaType javaTypeK4 = javaTypeE.k();
                                    typeSerializerC = c(serializationConfig, javaTypeK4);
                                    jsonSerializerF = f(serializerProvider, first);
                                    if (jsonSerializerF == null) {
                                        jsonSerializerF = MapSerializer2.s(null, null, javaTypeE, serializationConfig.q(MapperFeature.USE_STATIC_TYPING), typeSerializerC, null, null, null);
                                    }
                                    beanSerializerBuilder.f = new AnyGetterWriter(new BeanProperty.a(PropertyName.a(first.c()), javaTypeK4, null, first, PropertyMetadata.k), first, jsonSerializerF);
                                }
                                list = beanSerializerBuilder.d;
                                zQ = serializationConfig.q(MapperFeature.DEFAULT_VIEW_INCLUSION);
                                size3 = list.size();
                                beanPropertyWriterArr = new BeanPropertyWriter[size3];
                                i6 = 0;
                                int i9 = 0;
                                while (i6 < size3) {
                                    beanPropertyWriter2 = list.get(i6);
                                    clsArr = beanPropertyWriter2._includeInViews;
                                    if (clsArr != null) {
                                        list2 = list;
                                        if (zQ) {
                                            beanPropertyWriterArr[i6] = beanPropertyWriter2;
                                        }
                                    } else {
                                        list2 = list;
                                        if (zQ) {
                                            beanPropertyWriterArr[i6] = beanPropertyWriter2;
                                        }
                                    }
                                    i6++;
                                    list = list2;
                                }
                                if (zQ) {
                                    if (size3 != beanSerializerBuilder.d.size()) {
                                        throw new IllegalArgumentException(String.format("Trying to set %d filtered properties; must match length of non-filtered `properties` (%d)", Integer.valueOf(size3), Integer.valueOf(beanSerializerBuilder.d.size())));
                                    }
                                    beanSerializerBuilder.e = beanPropertyWriterArr;
                                } else {
                                    if (size3 != beanSerializerBuilder.d.size()) {
                                        throw new IllegalArgumentException(String.format("Trying to set %d filtered properties; must match length of non-filtered `properties` (%d)", Integer.valueOf(size3), Integer.valueOf(beanSerializerBuilder.d.size())));
                                    }
                                    beanSerializerBuilder.e = beanPropertyWriterArr;
                                }
                                if (this._factoryConfig.a()) {
                                    arrayIterator2 = (ArrayIterator2) this._factoryConfig.b();
                                    while (arrayIterator2.hasNext()) {
                                        Objects.requireNonNull((BeanSerializerModifier) arrayIterator2.next());
                                    }
                                }
                                E = beanSerializerBuilder.a();
                                if (E == 0) {
                                    if (javaType.A()) {
                                        E = new BeanSerializer2(beanSerializerBuilder.f701b.a, beanSerializerBuilder, BeanSerializerBase.k, null);
                                    } else {
                                        cls3 = javaType._class;
                                        if (Iterator.class.isAssignableFrom(cls3)) {
                                            javaTypeArrI2 = serializationConfig._base._typeFactory.i(javaType, Iterator.class);
                                            if (javaTypeArrI2 == null) {
                                                javaTypeK2 = TypeFactory.k();
                                            } else {
                                                javaTypeK2 = TypeFactory.k();
                                            }
                                            E = new IteratorSerializer(javaTypeK2, z4, c(serializationConfig, javaTypeK2));
                                        } else {
                                            z6 = z4;
                                            if (Iterable.class.isAssignableFrom(cls3)) {
                                                javaTypeArrI = serializationConfig._base._typeFactory.i(javaType, Iterable.class);
                                                if (javaTypeArrI == null) {
                                                    javaTypeK = TypeFactory.k();
                                                } else {
                                                    javaTypeK = TypeFactory.k();
                                                }
                                                E = new IterableSerializer(javaTypeK, z6, c(serializationConfig, javaTypeK));
                                            } else {
                                                if (CharSequence.class.isAssignableFrom(cls3)) {
                                                    toStringSerializer3 = ToStringSerializer.k;
                                                } else {
                                                    toStringSerializer3 = null;
                                                }
                                                E = toStringSerializer3;
                                            }
                                        }
                                        if (E == 0) {
                                            if (basicBeanDescription.f.t.size() > 0) {
                                                z7 = true;
                                            } else {
                                                z7 = false;
                                            }
                                            if (z7) {
                                                E = new BeanSerializer2(beanSerializerBuilder.f701b.a, beanSerializerBuilder, BeanSerializerBase.k, null);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (E == 0) {
                            E = serializerProvider.x(beanDescription2.a._class);
                        }
                    } else {
                        jsonSerializerX = null;
                    }
                    E = jsonSerializerX;
                    if (E == 0) {
                        E = serializerProvider.x(beanDescription2.a._class);
                    }
                }
            }
        }
        if (E != 0 && this._factoryConfig.a()) {
            ArrayIterator2 arrayIterator19 = (ArrayIterator2) this._factoryConfig.b();
            while (arrayIterator19.hasNext()) {
                Objects.requireNonNull((BeanSerializerModifier) arrayIterator19.next());
            }
        }
        return E;
    }

    public Iterable<Serializers> j() {
        return new ArrayIterator2(this._factoryConfig._additionalSerializers);
    }
}
