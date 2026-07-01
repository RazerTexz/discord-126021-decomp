package b.g.a.c.g0.u;

import b.g.a.a.JsonFormat;
import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonToken2;
import b.g.a.b.s.WritableTypeId;
import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.BeanProperty;
import b.g.a.c.JavaType;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializationFeature;
import b.g.a.c.SerializerProvider;
import b.g.a.c.c0.AnnotatedMember;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.ContainerSerializer;
import b.g.a.c.g0.ContextualSerializer;
import b.g.a.c.g0.t.PropertySerializerMap;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: renamed from: b.g.a.c.g0.u.b, reason: use source file name */
/* JADX INFO: compiled from: AsArraySerializerBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AsArraySerializerBase<T> extends ContainerSerializer<T> implements ContextualSerializer {
    public PropertySerializerMap _dynamicSerializers;
    public final JsonSerializer<Object> _elementSerializer;
    public final JavaType _elementType;
    public final BeanProperty _property;
    public final boolean _staticTyping;
    public final Boolean _unwrapSingle;
    public final TypeSerializer _valueTypeSerializer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsArraySerializerBase(Class<?> cls, JavaType javaType, boolean z2, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        super(cls, false);
        boolean z3 = false;
        this._elementType = javaType;
        if (z2 || (javaType != null && javaType.x())) {
            z3 = true;
        }
        this._staticTyping = z3;
        this._valueTypeSerializer = typeSerializer;
        this._property = null;
        this._elementSerializer = jsonSerializer;
        this._dynamicSerializers = PropertySerializerMap.b.f706b;
        this._unwrapSingle = null;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0020  */
    @Override // b.g.a.c.g0.ContextualSerializer
    public JsonSerializer<?> a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<?> jsonSerializerH;
        JavaType javaType;
        Object objC;
        TypeSerializer typeSerializerA = this._valueTypeSerializer;
        if (typeSerializerA != null) {
            typeSerializerA = typeSerializerA.a(beanProperty);
        }
        if (beanProperty != null) {
            AnnotationIntrospector annotationIntrospectorV = serializerProvider.v();
            AnnotatedMember member = beanProperty.getMember();
            if (member == null || (objC = annotationIntrospectorV.c(member)) == null) {
                jsonSerializerH = null;
            } else {
                jsonSerializerH = serializerProvider.H(member, objC);
            }
        } else {
            jsonSerializerH = null;
        }
        JsonFormat.d dVarL = l(serializerProvider, beanProperty, this._handledType);
        Boolean boolB = dVarL != null ? dVarL.b(JsonFormat.a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) : null;
        if (jsonSerializerH == null) {
            jsonSerializerH = this._elementSerializer;
        }
        JsonSerializer<?> jsonSerializerK = k(serializerProvider, beanProperty, jsonSerializerH);
        if (jsonSerializerK == null && (javaType = this._elementType) != null && this._staticTyping && !javaType.y()) {
            jsonSerializerK = serializerProvider.m(this._elementType, beanProperty);
        }
        return (jsonSerializerK == this._elementSerializer && beanProperty == this._property && this._valueTypeSerializer == typeSerializerA && Objects.equals(this._unwrapSingle, boolB)) ? this : t(beanProperty, typeSerializerA, jsonSerializerK, boolB);
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (serializerProvider.D(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) && q(t)) {
            s(t, jsonGenerator, serializerProvider);
            return;
        }
        jsonGenerator.X(t);
        s(t, jsonGenerator, serializerProvider);
        jsonGenerator.t();
    }

    @Override // b.g.a.c.JsonSerializer
    public void g(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        WritableTypeId writableTypeIdE = typeSerializer.e(jsonGenerator, typeSerializer.d(t, JsonToken2.START_ARRAY));
        jsonGenerator.e(t);
        s(t, jsonGenerator, serializerProvider);
        typeSerializer.f(jsonGenerator, writableTypeIdE);
    }

    public final JsonSerializer<Object> r(PropertySerializerMap propertySerializerMap, Class<?> cls, SerializerProvider serializerProvider) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializerN = serializerProvider.n(cls, this._property);
        PropertySerializerMap propertySerializerMapB = propertySerializerMap.b(cls, jsonSerializerN);
        if (propertySerializerMap != propertySerializerMapB) {
            this._dynamicSerializers = propertySerializerMapB;
        }
        return jsonSerializerN;
    }

    public abstract void s(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException;

    public abstract AsArraySerializerBase<T> t(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool);

    public AsArraySerializerBase(AsArraySerializerBase<?> asArraySerializerBase, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool) {
        super(asArraySerializerBase);
        this._elementType = asArraySerializerBase._elementType;
        this._staticTyping = asArraySerializerBase._staticTyping;
        this._valueTypeSerializer = typeSerializer;
        this._property = beanProperty;
        this._elementSerializer = jsonSerializer;
        this._dynamicSerializers = PropertySerializerMap.b.f706b;
        this._unwrapSingle = bool;
    }
}
