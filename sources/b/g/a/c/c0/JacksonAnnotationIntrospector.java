package b.g.a.c.c0;

import b.g.a.a.JacksonAnnotationsInside;
import b.g.a.a.JacksonInject;
import b.g.a.a.JsonAnyGetter;
import b.g.a.a.JsonAnySetter;
import b.g.a.a.JsonAutoDetect;
import b.g.a.a.JsonBackReference;
import b.g.a.a.JsonCreator;
import b.g.a.a.JsonFilter;
import b.g.a.a.JsonFormat;
import b.g.a.a.JsonGetter;
import b.g.a.a.JsonIdentityInfo;
import b.g.a.a.JsonIdentityReference;
import b.g.a.a.JsonIgnore;
import b.g.a.a.JsonIgnoreProperties;
import b.g.a.a.JsonIgnoreType;
import b.g.a.a.JsonInclude;
import b.g.a.a.JsonIncludeProperties;
import b.g.a.a.JsonKey;
import b.g.a.a.JsonManagedReference;
import b.g.a.a.JsonMerge;
import b.g.a.a.JsonProperty;
import b.g.a.a.JsonPropertyDescription;
import b.g.a.a.JsonPropertyOrder;
import b.g.a.a.JsonRawValue;
import b.g.a.a.JsonRootName;
import b.g.a.a.JsonSetter;
import b.g.a.a.JsonSubTypes;
import b.g.a.a.JsonTypeId;
import b.g.a.a.JsonTypeInfo;
import b.g.a.a.JsonTypeName;
import b.g.a.a.JsonUnwrapped;
import b.g.a.a.JsonValue;
import b.g.a.a.JsonView;
import b.g.a.a.Nulls;
import b.g.a.a.ObjectIdGenerators2;
import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.JavaType;
import b.g.a.c.JsonSerializer;
import b.g.a.c.MapperFeature;
import b.g.a.c.PropertyMetadata;
import b.g.a.c.PropertyName;
import b.g.a.c.b0.Java7Support;
import b.g.a.c.c0.VisibilityChecker;
import b.g.a.c.e0.NamedType;
import b.g.a.c.e0.TypeIdResolver;
import b.g.a.c.e0.TypeResolverBuilder;
import b.g.a.c.e0.h.StdTypeResolverBuilder;
import b.g.a.c.g0.BeanPropertyWriter;
import b.g.a.c.g0.VirtualBeanPropertyWriter;
import b.g.a.c.g0.t.AttributePropertyWriter;
import b.g.a.c.g0.u.RawSerializer;
import b.g.a.c.h0.ClassStack;
import b.g.a.c.h0.MapLikeType;
import b.g.a.c.h0.TypeFactory;
import b.g.a.c.i0.ClassUtil;
import b.g.a.c.i0.Converter;
import b.g.a.c.i0.LRUMap;
import b.g.a.c.i0.NameTransformer;
import b.g.a.c.i0.NameTransformer2;
import b.g.a.c.i0.NameTransformer3;
import b.g.a.c.i0.NameTransformer4;
import b.g.a.c.i0.SimpleBeanPropertyDefinition;
import b.g.a.c.y.JsonAppend;
import b.g.a.c.y.JsonDeserialize;
import b.g.a.c.y.JsonNaming;
import b.g.a.c.y.JsonSerialize;
import b.g.a.c.y.JsonTypeIdResolver;
import b.g.a.c.y.JsonTypeResolver;
import b.g.a.c.z.MapperConfig;
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

/* JADX INFO: renamed from: b.g.a.c.c0.x, reason: use source file name */
/* JADX INFO: compiled from: JacksonAnnotationIntrospector.java */
/* JADX INFO: loaded from: classes3.dex */
public class JacksonAnnotationIntrospector extends AnnotationIntrospector implements Serializable {
    public static final Class<? extends Annotation>[] j = {JsonSerialize.class, JsonView.class, JsonFormat.class, JsonTypeInfo.class, JsonRawValue.class, JsonUnwrapped.class, JsonBackReference.class, JsonManagedReference.class};
    public static final Class<? extends Annotation>[] k = {JsonDeserialize.class, JsonView.class, JsonFormat.class, JsonTypeInfo.class, JsonUnwrapped.class, JsonBackReference.class, JsonManagedReference.class, JsonMerge.class};
    public static final Java7Support l;
    private static final long serialVersionUID = 1;
    public transient LRUMap<Class<?>, Boolean> m = new LRUMap<>(48, 48);
    public boolean _cfgConstructorPropertiesImpliesCreator = true;

    static {
        Java7Support java7Support;
        try {
            java7Support = Java7Support.a;
        } catch (Throwable unused) {
            java7Support = null;
        }
        l = java7Support;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.HashSet] */
    @Override // b.g.a.c.AnnotationIntrospector
    public JsonIncludeProperties.a A(MapperConfig<?> mapperConfig, Annotated annotated) {
        ?? EmptySet;
        JsonIncludeProperties jsonIncludeProperties = (JsonIncludeProperties) annotated.b(JsonIncludeProperties.class);
        if (jsonIncludeProperties == null) {
            return JsonIncludeProperties.a.j;
        }
        String[] strArrValue = jsonIncludeProperties.value();
        if (strArrValue == null || strArrValue.length == 0) {
            EmptySet = Collections.emptySet();
        } else {
            EmptySet = new HashSet(strArrValue.length);
            for (String str : strArrValue) {
                EmptySet.add(str);
            }
        }
        return new JsonIncludeProperties.a(EmptySet);
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public Integer B(Annotated annotated) {
        int iIndex;
        JsonProperty jsonProperty = (JsonProperty) annotated.b(JsonProperty.class);
        if (jsonProperty == null || (iIndex = jsonProperty.index()) == -1) {
            return null;
        }
        return Integer.valueOf(iIndex);
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public TypeResolverBuilder<?> C(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        if (javaType.v() || javaType.b()) {
            return null;
        }
        return h0(mapperConfig, annotatedMember, javaType);
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public AnnotationIntrospector.a D(AnnotatedMember annotatedMember) {
        JsonManagedReference jsonManagedReference = (JsonManagedReference) annotatedMember.b(JsonManagedReference.class);
        if (jsonManagedReference != null) {
            return new AnnotationIntrospector.a(1, jsonManagedReference.value());
        }
        JsonBackReference jsonBackReference = (JsonBackReference) annotatedMember.b(JsonBackReference.class);
        if (jsonBackReference != null) {
            return new AnnotationIntrospector.a(2, jsonBackReference.value());
        }
        return null;
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public PropertyName E(MapperConfig<?> mapperConfig, AnnotatedField annotatedField, PropertyName propertyName) {
        return null;
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public PropertyName F(AnnotatedClass annotatedClass) {
        JsonRootName jsonRootName = (JsonRootName) annotatedClass.b(JsonRootName.class);
        if (jsonRootName == null) {
            return null;
        }
        String strNamespace = jsonRootName.namespace();
        return PropertyName.b(jsonRootName.value(), (strNamespace == null || !strNamespace.isEmpty()) ? strNamespace : null);
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public Object G(AnnotatedMember annotatedMember) {
        Class<?> clsG0;
        JsonSerialize jsonSerialize = (JsonSerialize) annotatedMember.b(JsonSerialize.class);
        if (jsonSerialize == null || (clsG0 = g0(jsonSerialize.contentConverter())) == null || clsG0 == Converter.a.class) {
            return null;
        }
        return clsG0;
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public Object H(Annotated annotated) {
        Class<?> clsG0;
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.b(JsonSerialize.class);
        if (jsonSerialize == null || (clsG0 = g0(jsonSerialize.converter())) == null || clsG0 == Converter.a.class) {
            return null;
        }
        return clsG0;
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public String[] I(AnnotatedClass annotatedClass) {
        JsonPropertyOrder jsonPropertyOrder = (JsonPropertyOrder) annotatedClass.b(JsonPropertyOrder.class);
        if (jsonPropertyOrder == null) {
            return null;
        }
        return jsonPropertyOrder.value();
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public Boolean J(Annotated annotated) {
        JsonPropertyOrder jsonPropertyOrder = (JsonPropertyOrder) annotated.b(JsonPropertyOrder.class);
        if (jsonPropertyOrder == null || !jsonPropertyOrder.alphabetic()) {
            return null;
        }
        return Boolean.TRUE;
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public JsonSerialize.b K(Annotated annotated) {
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.b(JsonSerialize.class);
        if (jsonSerialize == null) {
            return null;
        }
        return jsonSerialize.typing();
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public Object L(Annotated annotated) {
        Class<? extends JsonSerializer> clsUsing;
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.b(JsonSerialize.class);
        if (jsonSerialize != null && (clsUsing = jsonSerialize.using()) != JsonSerializer.a.class) {
            return clsUsing;
        }
        JsonRawValue jsonRawValue = (JsonRawValue) annotated.b(JsonRawValue.class);
        if (jsonRawValue == null || !jsonRawValue.value()) {
            return null;
        }
        return new RawSerializer(annotated.d());
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public JsonSetter.a M(Annotated annotated) {
        JsonSetter jsonSetter = (JsonSetter) annotated.b(JsonSetter.class);
        if (jsonSetter == null) {
            return JsonSetter.a.j;
        }
        Nulls nulls = jsonSetter.nulls();
        Nulls nullsContentNulls = jsonSetter.contentNulls();
        Nulls nulls2 = Nulls.DEFAULT;
        if (nulls == null) {
            nulls = nulls2;
        }
        if (nullsContentNulls == null) {
            nullsContentNulls = nulls2;
        }
        return nulls == nulls2 && nullsContentNulls == nulls2 ? JsonSetter.a.j : new JsonSetter.a(nulls, nullsContentNulls);
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public List<NamedType> N(Annotated annotated) {
        JsonSubTypes jsonSubTypes = (JsonSubTypes) annotated.b(JsonSubTypes.class);
        if (jsonSubTypes == null) {
            return null;
        }
        JsonSubTypes.a[] aVarArrValue = jsonSubTypes.value();
        ArrayList arrayList = new ArrayList(aVarArrValue.length);
        for (JsonSubTypes.a aVar : aVarArrValue) {
            arrayList.add(new NamedType(aVar.value(), aVar.name()));
            for (String str : aVar.names()) {
                arrayList.add(new NamedType(aVar.value(), str));
            }
        }
        return arrayList;
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public String O(AnnotatedClass annotatedClass) {
        JsonTypeName jsonTypeName = (JsonTypeName) annotatedClass.b(JsonTypeName.class);
        if (jsonTypeName == null) {
            return null;
        }
        return jsonTypeName.value();
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public TypeResolverBuilder<?> P(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, JavaType javaType) {
        return h0(mapperConfig, annotatedClass, javaType);
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public NameTransformer4 Q(AnnotatedMember annotatedMember) {
        JsonUnwrapped jsonUnwrapped = (JsonUnwrapped) annotatedMember.b(JsonUnwrapped.class);
        if (jsonUnwrapped == null || !jsonUnwrapped.enabled()) {
            return null;
        }
        String strPrefix = jsonUnwrapped.prefix();
        String strSuffix = jsonUnwrapped.suffix();
        boolean z2 = false;
        boolean z3 = (strPrefix == null || strPrefix.isEmpty()) ? false : true;
        if (strSuffix != null && !strSuffix.isEmpty()) {
            z2 = true;
        }
        if (z3) {
            return z2 ? new NameTransformer(strPrefix, strSuffix) : new NameTransformer2(strPrefix);
        }
        return z2 ? new NameTransformer3(strSuffix) : NameTransformer4.j;
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public Class<?>[] R(Annotated annotated) {
        JsonView jsonView = (JsonView) annotated.b(JsonView.class);
        if (jsonView == null) {
            return null;
        }
        return jsonView.value();
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public Boolean S(Annotated annotated) {
        JsonAnyGetter jsonAnyGetter = (JsonAnyGetter) annotated.b(JsonAnyGetter.class);
        if (jsonAnyGetter == null) {
            return null;
        }
        return Boolean.valueOf(jsonAnyGetter.enabled());
    }

    @Override // b.g.a.c.AnnotationIntrospector
    @Deprecated
    public boolean T(AnnotatedMethod annotatedMethod) {
        return annotatedMethod.k(JsonAnyGetter.class);
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public Boolean U(Annotated annotated) {
        JsonAnySetter jsonAnySetter = (JsonAnySetter) annotated.b(JsonAnySetter.class);
        if (jsonAnySetter == null) {
            return null;
        }
        return Boolean.valueOf(jsonAnySetter.enabled());
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public Boolean V(MapperConfig<?> mapperConfig, Annotated annotated) {
        JsonKey jsonKey = (JsonKey) annotated.b(JsonKey.class);
        if (jsonKey == null) {
            return null;
        }
        return Boolean.valueOf(jsonKey.value());
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public Boolean W(Annotated annotated) {
        JsonValue jsonValue = (JsonValue) annotated.b(JsonValue.class);
        if (jsonValue == null) {
            return null;
        }
        return Boolean.valueOf(jsonValue.value());
    }

    @Override // b.g.a.c.AnnotationIntrospector
    @Deprecated
    public boolean X(AnnotatedMethod annotatedMethod) {
        JsonValue jsonValue = (JsonValue) annotatedMethod.b(JsonValue.class);
        return jsonValue != null && jsonValue.value();
    }

    @Override // b.g.a.c.AnnotationIntrospector
    @Deprecated
    public boolean Y(Annotated annotated) {
        Java7Support java7Support;
        Boolean boolC;
        JsonCreator jsonCreator = (JsonCreator) annotated.b(JsonCreator.class);
        if (jsonCreator != null) {
            return jsonCreator.mode() != JsonCreator.a.DISABLED;
        }
        if (!this._cfgConstructorPropertiesImpliesCreator || !(annotated instanceof AnnotatedConstructor) || (java7Support = l) == null || (boolC = java7Support.c(annotated)) == null) {
            return false;
        }
        return boolC.booleanValue();
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public boolean Z(AnnotatedMember annotatedMember) {
        Boolean boolB;
        JsonIgnore jsonIgnore = (JsonIgnore) annotatedMember.b(JsonIgnore.class);
        if (jsonIgnore != null) {
            return jsonIgnore.value();
        }
        Java7Support java7Support = l;
        if (java7Support == null || (boolB = java7Support.b(annotatedMember)) == null) {
            return false;
        }
        return boolB.booleanValue();
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public void a(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, List<BeanPropertyWriter> list) {
        JsonAppend jsonAppend = (JsonAppend) annotatedClass.t.a(JsonAppend.class);
        if (jsonAppend == null) {
            return;
        }
        boolean zPrepend = jsonAppend.prepend();
        JsonAppend.a[] aVarArrAttrs = jsonAppend.attrs();
        int length = aVarArrAttrs.length;
        ClassStack classStack = null;
        JavaType javaTypeB = null;
        int i = 0;
        while (i < length) {
            if (javaTypeB == null) {
                javaTypeB = mapperConfig._base._typeFactory.b(classStack, Object.class, TypeFactory.l);
            }
            JsonAppend.a aVar = aVarArrAttrs[i];
            PropertyMetadata propertyMetadata = aVar.required() ? PropertyMetadata.j : PropertyMetadata.k;
            String strValue = aVar.value();
            PropertyName propertyNameJ0 = j0(aVar.propName(), aVar.propNamespace());
            if (!propertyNameJ0.c()) {
                propertyNameJ0 = PropertyName.a(strValue);
            }
            AttributePropertyWriter attributePropertyWriter = new AttributePropertyWriter(strValue, SimpleBeanPropertyDefinition.w(mapperConfig, new VirtualAnnotatedMember(annotatedClass, annotatedClass.l, strValue, javaTypeB), propertyNameJ0, propertyMetadata, aVar.include()), annotatedClass.t, javaTypeB);
            if (zPrepend) {
                list.add(i, attributePropertyWriter);
            } else {
                list.add(attributePropertyWriter);
            }
            i++;
            classStack = null;
        }
        JsonAppend.b[] bVarArrProps = jsonAppend.props();
        int length2 = bVarArrProps.length;
        for (int i2 = 0; i2 < length2; i2++) {
            JsonAppend.b bVar = bVarArrProps[i2];
            PropertyMetadata propertyMetadata2 = bVar.required() ? PropertyMetadata.j : PropertyMetadata.k;
            PropertyName propertyNameJ1 = j0(bVar.name(), bVar.namespace());
            JavaType javaTypeD = mapperConfig.d(bVar.type());
            SimpleBeanPropertyDefinition simpleBeanPropertyDefinitionW = SimpleBeanPropertyDefinition.w(mapperConfig, new VirtualAnnotatedMember(annotatedClass, annotatedClass.l, propertyNameJ1._simpleName, javaTypeD), propertyNameJ1, propertyMetadata2, bVar.include());
            Class<? extends VirtualBeanPropertyWriter> clsValue = bVar.value();
            Objects.requireNonNull(mapperConfig._base);
            VirtualBeanPropertyWriter virtualBeanPropertyWriterK = ((VirtualBeanPropertyWriter) ClassUtil.g(clsValue, mapperConfig.b())).k(mapperConfig, annotatedClass, simpleBeanPropertyDefinitionW, javaTypeD);
            if (zPrepend) {
                list.add(i2, virtualBeanPropertyWriterK);
            } else {
                list.add(virtualBeanPropertyWriterK);
            }
        }
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public Boolean a0(AnnotatedMember annotatedMember) {
        JsonProperty jsonProperty = (JsonProperty) annotatedMember.b(JsonProperty.class);
        if (jsonProperty != null) {
            return Boolean.valueOf(jsonProperty.required());
        }
        return null;
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public VisibilityChecker<?> b(AnnotatedClass annotatedClass, VisibilityChecker<?> visibilityChecker) {
        JsonAutoDetect jsonAutoDetect = (JsonAutoDetect) annotatedClass.b(JsonAutoDetect.class);
        if (jsonAutoDetect == null) {
            return visibilityChecker;
        }
        VisibilityChecker.a aVar = (VisibilityChecker.a) visibilityChecker;
        Objects.requireNonNull(aVar);
        return aVar.b(aVar.a(aVar._getterMinLevel, jsonAutoDetect.getterVisibility()), aVar.a(aVar._isGetterMinLevel, jsonAutoDetect.isGetterVisibility()), aVar.a(aVar._setterMinLevel, jsonAutoDetect.setterVisibility()), aVar.a(aVar._creatorMinLevel, jsonAutoDetect.creatorVisibility()), aVar.a(aVar._fieldMinLevel, jsonAutoDetect.fieldVisibility()));
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public boolean b0(Annotation annotation) {
        Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
        Boolean boolValueOf = this.m.get(clsAnnotationType);
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(clsAnnotationType.getAnnotation(JacksonAnnotationsInside.class) != null);
            this.m.putIfAbsent(clsAnnotationType, boolValueOf);
        }
        return boolValueOf.booleanValue();
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public Object c(Annotated annotated) {
        Class<? extends JsonSerializer> clsContentUsing;
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.b(JsonSerialize.class);
        if (jsonSerialize == null || (clsContentUsing = jsonSerialize.contentUsing()) == JsonSerializer.a.class) {
            return null;
        }
        return clsContentUsing;
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public Boolean c0(AnnotatedClass annotatedClass) {
        JsonIgnoreType jsonIgnoreType = (JsonIgnoreType) annotatedClass.b(JsonIgnoreType.class);
        if (jsonIgnoreType == null) {
            return null;
        }
        return Boolean.valueOf(jsonIgnoreType.value());
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public JsonCreator.a d(MapperConfig<?> mapperConfig, Annotated annotated) {
        Java7Support java7Support;
        Boolean boolC;
        JsonCreator jsonCreator = (JsonCreator) annotated.b(JsonCreator.class);
        if (jsonCreator != null) {
            return jsonCreator.mode();
        }
        if (this._cfgConstructorPropertiesImpliesCreator && mapperConfig.q(MapperFeature.INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES) && (annotated instanceof AnnotatedConstructor) && (java7Support = l) != null && (boolC = java7Support.c(annotated)) != null && boolC.booleanValue()) {
            return JsonCreator.a.PROPERTIES;
        }
        return null;
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public Boolean d0(AnnotatedMember annotatedMember) {
        return Boolean.valueOf(annotatedMember.k(JsonTypeId.class));
    }

    @Override // b.g.a.c.AnnotationIntrospector
    @Deprecated
    public JsonCreator.a e(Annotated annotated) {
        JsonCreator jsonCreator = (JsonCreator) annotated.b(JsonCreator.class);
        if (jsonCreator == null) {
            return null;
        }
        return jsonCreator.mode();
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public JavaType e0(MapperConfig<?> mapperConfig, Annotated annotated, JavaType javaType) throws JsonMappingException {
        JavaType javaTypeM;
        JavaType javaTypeM2;
        TypeFactory typeFactory = mapperConfig._base._typeFactory;
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.b(JsonSerialize.class);
        Class<?> clsG0 = jsonSerialize == null ? null : g0(jsonSerialize.as());
        if (clsG0 != null) {
            Class<?> cls = javaType._class;
            if (cls == clsG0) {
                javaType = javaType.M();
            } else {
                try {
                    if (clsG0.isAssignableFrom(cls)) {
                        javaType = typeFactory.g(javaType, clsG0);
                    } else if (cls.isAssignableFrom(clsG0)) {
                        javaType = typeFactory.h(javaType, clsG0, false);
                    } else {
                        if (!i0(cls, clsG0)) {
                            throw new JsonMappingException(null, String.format("Cannot refine serialization type %s into %s; types not related", javaType, clsG0.getName()));
                        }
                        javaType = javaType.M();
                    }
                } catch (IllegalArgumentException e) {
                    throw new JsonMappingException(null, String.format("Failed to widen type %s with annotation (value %s), from '%s': %s", javaType, clsG0.getName(), annotated.c(), e.getMessage()), e);
                }
            }
        }
        if (javaType.z()) {
            JavaType javaTypeO = javaType.o();
            Class<?> clsG1 = jsonSerialize == null ? null : g0(jsonSerialize.keyAs());
            if (clsG1 != null) {
                Class<?> cls2 = javaTypeO._class;
                if (cls2 == clsG1) {
                    javaTypeM2 = javaTypeO.M();
                } else {
                    try {
                        if (clsG1.isAssignableFrom(cls2)) {
                            javaTypeM2 = typeFactory.g(javaTypeO, clsG1);
                        } else if (cls2.isAssignableFrom(clsG1)) {
                            javaTypeM2 = typeFactory.h(javaTypeO, clsG1, false);
                        } else {
                            if (!i0(cls2, clsG1)) {
                                throw new JsonMappingException(null, String.format("Cannot refine serialization key type %s into %s; types not related", javaTypeO, clsG1.getName()));
                            }
                            javaTypeM2 = javaTypeO.M();
                        }
                    } catch (IllegalArgumentException e2) {
                        throw new JsonMappingException(null, String.format("Failed to widen key type of %s with concrete-type annotation (value %s), from '%s': %s", javaType, clsG1.getName(), annotated.c(), e2.getMessage()), e2);
                    }
                }
                javaType = ((MapLikeType) javaType).M(javaTypeM2);
            }
        }
        JavaType javaTypeK = javaType.k();
        if (javaTypeK == null) {
            return javaType;
        }
        Class<?> clsG2 = jsonSerialize == null ? null : g0(jsonSerialize.contentAs());
        if (clsG2 == null) {
            return javaType;
        }
        Class<?> cls3 = javaTypeK._class;
        if (cls3 == clsG2) {
            javaTypeM = javaTypeK.M();
        } else {
            try {
                if (clsG2.isAssignableFrom(cls3)) {
                    javaTypeM = typeFactory.g(javaTypeK, clsG2);
                } else if (cls3.isAssignableFrom(clsG2)) {
                    javaTypeM = typeFactory.h(javaTypeK, clsG2, false);
                } else {
                    if (!i0(cls3, clsG2)) {
                        throw new JsonMappingException(null, String.format("Cannot refine serialization content type %s into %s; types not related", javaTypeK, clsG2.getName()));
                    }
                    javaTypeM = javaTypeK.M();
                }
            } catch (IllegalArgumentException e3) {
                throw new JsonMappingException(null, String.format("Internal error: failed to refine value type of %s with concrete-type annotation (value %s), from '%s': %s", javaType, clsG2.getName(), annotated.c(), e3.getMessage()), e3);
            }
        }
        return javaType.D(javaTypeM);
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public String[] f(Class<?> cls, Enum<?>[] enumArr, String[] strArr) {
        JsonProperty jsonProperty;
        HashMap map = null;
        for (Field field : cls.getDeclaredFields()) {
            if (field.isEnumConstant() && (jsonProperty = (JsonProperty) field.getAnnotation(JsonProperty.class)) != null) {
                String strValue = jsonProperty.value();
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

    @Override // b.g.a.c.AnnotationIntrospector
    public AnnotatedMethod f0(MapperConfig<?> mapperConfig, AnnotatedMethod annotatedMethod, AnnotatedMethod annotatedMethod2) {
        Class<?> clsP = annotatedMethod.p(0);
        Class<?> clsP2 = annotatedMethod2.p(0);
        if (clsP.isPrimitive()) {
            if (!clsP2.isPrimitive()) {
                return annotatedMethod;
            }
        } else if (clsP2.isPrimitive()) {
            return annotatedMethod2;
        }
        if (clsP == String.class) {
            if (clsP2 != String.class) {
                return annotatedMethod;
            }
            return null;
        }
        if (clsP2 == String.class) {
            return annotatedMethod2;
        }
        return null;
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public Object g(Annotated annotated) {
        JsonFilter jsonFilter = (JsonFilter) annotated.b(JsonFilter.class);
        if (jsonFilter == null) {
            return null;
        }
        String strValue = jsonFilter.value();
        if (strValue.isEmpty()) {
            return null;
        }
        return strValue;
    }

    public Class<?> g0(Class<?> cls) {
        if (cls == null || ClassUtil.p(cls)) {
            return null;
        }
        return cls;
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public JsonFormat.d h(Annotated annotated) {
        JsonFormat jsonFormat = (JsonFormat) annotated.b(JsonFormat.class);
        if (jsonFormat == null) {
            return null;
        }
        String strPattern = jsonFormat.pattern();
        JsonFormat.c cVarShape = jsonFormat.shape();
        String strLocale = jsonFormat.locale();
        String strTimezone = jsonFormat.timezone();
        JsonFormat.a[] aVarArrWith = jsonFormat.with();
        JsonFormat.a[] aVarArrWithout = jsonFormat.without();
        int iOrdinal = 0;
        for (JsonFormat.a aVar : aVarArrWith) {
            iOrdinal |= 1 << aVar.ordinal();
        }
        int iOrdinal2 = 0;
        for (JsonFormat.a aVar2 : aVarArrWithout) {
            iOrdinal2 |= 1 << aVar2.ordinal();
        }
        return new JsonFormat.d(strPattern, cVarShape, strLocale, strTimezone, new JsonFormat.b(iOrdinal, iOrdinal2), jsonFormat.lenient().f());
    }

    public TypeResolverBuilder<?> h0(MapperConfig<?> mapperConfig, Annotated annotated, JavaType javaType) {
        TypeResolverBuilder stdTypeResolverBuilder;
        JsonTypeInfo jsonTypeInfo = (JsonTypeInfo) annotated.b(JsonTypeInfo.class);
        JsonTypeResolver jsonTypeResolver = (JsonTypeResolver) annotated.b(JsonTypeResolver.class);
        TypeIdResolver typeIdResolver = null;
        if (jsonTypeResolver != null) {
            if (jsonTypeInfo == null) {
                return null;
            }
            Class<? extends TypeResolverBuilder<?>> clsValue = jsonTypeResolver.value();
            Objects.requireNonNull(mapperConfig._base);
            stdTypeResolverBuilder = (TypeResolverBuilder) ClassUtil.g(clsValue, mapperConfig.b());
        } else {
            if (jsonTypeInfo == null) {
                return null;
            }
            JsonTypeInfo.b bVarUse = jsonTypeInfo.use();
            JsonTypeInfo.b bVar = JsonTypeInfo.b.NONE;
            if (bVarUse == bVar) {
                StdTypeResolverBuilder stdTypeResolverBuilder2 = new StdTypeResolverBuilder();
                stdTypeResolverBuilder2.g(bVar, null);
                return stdTypeResolverBuilder2;
            }
            stdTypeResolverBuilder = new StdTypeResolverBuilder();
        }
        JsonTypeIdResolver jsonTypeIdResolver = (JsonTypeIdResolver) annotated.b(JsonTypeIdResolver.class);
        if (jsonTypeIdResolver != null) {
            Class<? extends TypeIdResolver> clsValue2 = jsonTypeIdResolver.value();
            Objects.requireNonNull(mapperConfig._base);
            typeIdResolver = (TypeIdResolver) ClassUtil.g(clsValue2, mapperConfig.b());
        }
        if (typeIdResolver != null) {
            typeIdResolver.b(javaType);
        }
        TypeResolverBuilder typeResolverBuilderB = stdTypeResolverBuilder.b(jsonTypeInfo.use(), typeIdResolver);
        JsonTypeInfo.a aVarInclude = jsonTypeInfo.include();
        if (aVarInclude == JsonTypeInfo.a.EXTERNAL_PROPERTY && (annotated instanceof AnnotatedClass)) {
            aVarInclude = JsonTypeInfo.a.PROPERTY;
        }
        TypeResolverBuilder typeResolverBuilderC = typeResolverBuilderB.f(aVarInclude).c(jsonTypeInfo.property());
        Class<?> clsDefaultImpl = jsonTypeInfo.defaultImpl();
        if (clsDefaultImpl != JsonTypeInfo.c.class && !clsDefaultImpl.isAnnotation()) {
            typeResolverBuilderC = typeResolverBuilderC.d(clsDefaultImpl);
        }
        return typeResolverBuilderC.a(jsonTypeInfo.visible());
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0016  */
    @Override // b.g.a.c.AnnotationIntrospector
    public String i(AnnotatedMember annotatedMember) {
        PropertyName propertyNameA;
        Java7Support java7Support;
        if (annotatedMember instanceof AnnotatedParameter) {
            AnnotatedParameter annotatedParameter = (AnnotatedParameter) annotatedMember;
            if (annotatedParameter._owner == null || (java7Support = l) == null || (propertyNameA = java7Support.a(annotatedParameter)) == null) {
                propertyNameA = null;
            }
        } else {
            propertyNameA = null;
        }
        if (propertyNameA == null) {
            return null;
        }
        return propertyNameA._simpleName;
    }

    public final boolean i0(Class<?> cls, Class<?> cls2) {
        if (cls.isPrimitive()) {
            return cls == ClassUtil.v(cls2);
        }
        return cls2.isPrimitive() && cls2 == ClassUtil.v(cls);
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public JacksonInject.a j(AnnotatedMember annotatedMember) {
        String name;
        JacksonInject jacksonInject = (JacksonInject) annotatedMember.b(JacksonInject.class);
        if (jacksonInject == null) {
            return null;
        }
        JacksonInject.a aVarA = JacksonInject.a.a(jacksonInject.value(), jacksonInject.useInput().f());
        if (aVarA._id != null) {
            return aVarA;
        }
        if (annotatedMember instanceof AnnotatedMethod) {
            AnnotatedMethod annotatedMethod = (AnnotatedMethod) annotatedMember;
            name = annotatedMethod.o() == 0 ? annotatedMember.d().getName() : annotatedMethod.p(0).getName();
        } else {
            name = annotatedMember.d().getName();
        }
        return name.equals(aVarA._id) ? aVarA : new JacksonInject.a(name, aVarA._useInput);
    }

    public PropertyName j0(String str, String str2) {
        if (str.isEmpty()) {
            return PropertyName.j;
        }
        return (str2 == null || str2.isEmpty()) ? PropertyName.a(str) : PropertyName.b(str, str2);
    }

    @Override // b.g.a.c.AnnotationIntrospector
    @Deprecated
    public Object k(AnnotatedMember annotatedMember) {
        JacksonInject.a aVarJ = j(annotatedMember);
        if (aVarJ == null) {
            return null;
        }
        return aVarJ._id;
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public Object l(Annotated annotated) {
        Class<? extends JsonSerializer> clsKeyUsing;
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.b(JsonSerialize.class);
        if (jsonSerialize == null || (clsKeyUsing = jsonSerialize.keyUsing()) == JsonSerializer.a.class) {
            return null;
        }
        return clsKeyUsing;
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public Boolean m(Annotated annotated) {
        JsonMerge jsonMerge = (JsonMerge) annotated.b(JsonMerge.class);
        if (jsonMerge == null) {
            return null;
        }
        return jsonMerge.value().f();
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public PropertyName n(Annotated annotated) {
        boolean z2;
        JsonSetter jsonSetter = (JsonSetter) annotated.b(JsonSetter.class);
        if (jsonSetter != null) {
            String strValue = jsonSetter.value();
            if (!strValue.isEmpty()) {
                return PropertyName.a(strValue);
            }
            z2 = true;
        } else {
            z2 = false;
        }
        JsonProperty jsonProperty = (JsonProperty) annotated.b(JsonProperty.class);
        if (jsonProperty != null) {
            String strNamespace = jsonProperty.namespace();
            return PropertyName.b(jsonProperty.value(), (strNamespace == null || !strNamespace.isEmpty()) ? strNamespace : null);
        }
        if (!z2) {
            Class<? extends Annotation>[] clsArr = k;
            AnnotationMap annotationMap = ((AnnotatedMember) annotated).k;
            if (!(annotationMap != null ? annotationMap.b(clsArr) : false)) {
                return null;
            }
        }
        return PropertyName.j;
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public PropertyName o(Annotated annotated) {
        boolean z2;
        JsonGetter jsonGetter = (JsonGetter) annotated.b(JsonGetter.class);
        if (jsonGetter != null) {
            String strValue = jsonGetter.value();
            if (!strValue.isEmpty()) {
                return PropertyName.a(strValue);
            }
            z2 = true;
        } else {
            z2 = false;
        }
        JsonProperty jsonProperty = (JsonProperty) annotated.b(JsonProperty.class);
        if (jsonProperty != null) {
            String strNamespace = jsonProperty.namespace();
            return PropertyName.b(jsonProperty.value(), (strNamespace == null || !strNamespace.isEmpty()) ? strNamespace : null);
        }
        if (!z2) {
            Class<? extends Annotation>[] clsArr = j;
            AnnotationMap annotationMap = ((AnnotatedMember) annotated).k;
            if (!(annotationMap != null ? annotationMap.b(clsArr) : false)) {
                return null;
            }
        }
        return PropertyName.j;
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public Object p(AnnotatedClass annotatedClass) {
        JsonNaming jsonNaming = (JsonNaming) annotatedClass.b(JsonNaming.class);
        if (jsonNaming == null) {
            return null;
        }
        return jsonNaming.value();
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public Object q(Annotated annotated) {
        Class<? extends JsonSerializer> clsNullsUsing;
        JsonSerialize jsonSerialize = (JsonSerialize) annotated.b(JsonSerialize.class);
        if (jsonSerialize == null || (clsNullsUsing = jsonSerialize.nullsUsing()) == JsonSerializer.a.class) {
            return null;
        }
        return clsNullsUsing;
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public ObjectIdInfo r(Annotated annotated) {
        JsonIdentityInfo jsonIdentityInfo = (JsonIdentityInfo) annotated.b(JsonIdentityInfo.class);
        if (jsonIdentityInfo == null || jsonIdentityInfo.generator() == ObjectIdGenerators2.class) {
            return null;
        }
        return new ObjectIdInfo(PropertyName.a(jsonIdentityInfo.property()), jsonIdentityInfo.scope(), jsonIdentityInfo.generator(), false, jsonIdentityInfo.resolver());
    }

    public Object readResolve() {
        if (this.m == null) {
            this.m = new LRUMap<>(48, 48);
        }
        return this;
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public ObjectIdInfo s(Annotated annotated, ObjectIdInfo objectIdInfo) {
        JsonIdentityReference jsonIdentityReference = (JsonIdentityReference) annotated.b(JsonIdentityReference.class);
        if (jsonIdentityReference == null) {
            return objectIdInfo;
        }
        if (objectIdInfo == null) {
            objectIdInfo = ObjectIdInfo.a;
        }
        boolean zAlwaysAsId = jsonIdentityReference.alwaysAsId();
        return objectIdInfo.f == zAlwaysAsId ? objectIdInfo : new ObjectIdInfo(objectIdInfo.f681b, objectIdInfo.e, objectIdInfo.c, zAlwaysAsId, objectIdInfo.d);
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public JsonProperty.a t(Annotated annotated) {
        JsonProperty jsonProperty = (JsonProperty) annotated.b(JsonProperty.class);
        if (jsonProperty != null) {
            return jsonProperty.access();
        }
        return null;
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public TypeResolverBuilder<?> u(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        if (javaType.k() != null) {
            return h0(mapperConfig, annotatedMember, javaType);
        }
        throw new IllegalArgumentException("Must call method with a container or reference type (got " + javaType + ")");
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public String v(Annotated annotated) {
        JsonProperty jsonProperty = (JsonProperty) annotated.b(JsonProperty.class);
        if (jsonProperty == null) {
            return null;
        }
        String strDefaultValue = jsonProperty.defaultValue();
        if (strDefaultValue.isEmpty()) {
            return null;
        }
        return strDefaultValue;
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public String w(Annotated annotated) {
        JsonPropertyDescription jsonPropertyDescription = (JsonPropertyDescription) annotated.b(JsonPropertyDescription.class);
        if (jsonPropertyDescription == null) {
            return null;
        }
        return jsonPropertyDescription.value();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.HashSet] */
    @Override // b.g.a.c.AnnotationIntrospector
    public JsonIgnoreProperties.a x(MapperConfig<?> mapperConfig, Annotated annotated) {
        ?? EmptySet;
        JsonIgnoreProperties jsonIgnoreProperties = (JsonIgnoreProperties) annotated.b(JsonIgnoreProperties.class);
        if (jsonIgnoreProperties == null) {
            return JsonIgnoreProperties.a.j;
        }
        JsonIgnoreProperties.a aVar = JsonIgnoreProperties.a.j;
        String[] strArrValue = jsonIgnoreProperties.value();
        if (strArrValue == null || strArrValue.length == 0) {
            EmptySet = Collections.emptySet();
        } else {
            EmptySet = new HashSet(strArrValue.length);
            for (String str : strArrValue) {
                EmptySet.add(str);
            }
        }
        return JsonIgnoreProperties.a.c(EmptySet, jsonIgnoreProperties.ignoreUnknown(), jsonIgnoreProperties.allowGetters(), jsonIgnoreProperties.allowSetters(), false);
    }

    @Override // b.g.a.c.AnnotationIntrospector
    @Deprecated
    public JsonIgnoreProperties.a y(Annotated annotated) {
        return x(null, annotated);
    }

    @Override // b.g.a.c.AnnotationIntrospector
    public JsonInclude.b z(Annotated annotated) {
        JsonInclude.b bVar;
        JsonSerialize jsonSerialize;
        JsonInclude.b bVarB;
        JsonInclude.a aVar = JsonInclude.a.USE_DEFAULTS;
        JsonInclude jsonInclude = (JsonInclude) annotated.b(JsonInclude.class);
        if (jsonInclude == null) {
            JsonInclude.b bVar2 = JsonInclude.b.j;
            bVar = JsonInclude.b.j;
        } else {
            JsonInclude.b bVar3 = JsonInclude.b.j;
            JsonInclude.a aVarValue = jsonInclude.value();
            JsonInclude.a aVarContent = jsonInclude.content();
            if (aVarValue == aVar && aVarContent == aVar) {
                bVar = JsonInclude.b.j;
            } else {
                Class<?> clsValueFilter = jsonInclude.valueFilter();
                if (clsValueFilter == Void.class) {
                    clsValueFilter = null;
                }
                Class<?> clsContentFilter = jsonInclude.contentFilter();
                bVar = new JsonInclude.b(aVarValue, aVarContent, clsValueFilter, clsContentFilter != Void.class ? clsContentFilter : null);
            }
        }
        if (bVar._valueInclusion != aVar || (jsonSerialize = (JsonSerialize) annotated.b(JsonSerialize.class)) == null) {
            return bVar;
        }
        int iOrdinal = jsonSerialize.include().ordinal();
        if (iOrdinal == 0) {
            bVarB = bVar.b(JsonInclude.a.ALWAYS);
        } else if (iOrdinal == 1) {
            bVarB = bVar.b(JsonInclude.a.NON_NULL);
        } else if (iOrdinal == 2) {
            bVarB = bVar.b(JsonInclude.a.NON_DEFAULT);
        } else {
            if (iOrdinal != 3) {
                return bVar;
            }
            bVarB = bVar.b(JsonInclude.a.NON_EMPTY);
        }
        return bVarB;
    }
}
