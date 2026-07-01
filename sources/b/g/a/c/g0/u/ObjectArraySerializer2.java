package b.g.a.c.g0.u;

import b.g.a.a.JsonFormat;
import b.g.a.b.JsonGenerator;
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
import b.g.a.c.y.JacksonStdImpl;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: renamed from: b.g.a.c.g0.u.d0, reason: use source file name */
/* JADX INFO: compiled from: ObjectArraySerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class ObjectArraySerializer2 extends ArraySerializerBase<Object[]> implements ContextualSerializer {
    public PropertySerializerMap _dynamicSerializers;
    public JsonSerializer<Object> _elementSerializer;
    public final JavaType _elementType;
    public final boolean _staticTyping;
    public final TypeSerializer _valueTypeSerializer;

    public ObjectArraySerializer2(JavaType javaType, boolean z2, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        super(Object[].class);
        this._elementType = javaType;
        this._staticTyping = z2;
        this._valueTypeSerializer = typeSerializer;
        this._dynamicSerializers = PropertySerializerMap.b.f706b;
        this._elementSerializer = jsonSerializer;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0021  */
    @Override // b.g.a.c.g0.u.ArraySerializerBase, b.g.a.c.g0.ContextualSerializer
    public JsonSerializer<?> a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<?> jsonSerializerH;
        JavaType javaType;
        Object objC;
        TypeSerializer typeSerializerA = this._valueTypeSerializer;
        if (typeSerializerA != null) {
            typeSerializerA = typeSerializerA.a(beanProperty);
        }
        TypeSerializer typeSerializer = typeSerializerA;
        if (beanProperty != null) {
            AnnotatedMember member = beanProperty.getMember();
            AnnotationIntrospector annotationIntrospectorV = serializerProvider.v();
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
        JsonSerializer<?> jsonSerializerM = (jsonSerializerK != null || (javaType = this._elementType) == null || !this._staticTyping || javaType.y()) ? jsonSerializerK : serializerProvider.m(this._elementType, beanProperty);
        return (this._property == beanProperty && jsonSerializerM == this._elementSerializer && this._valueTypeSerializer == typeSerializer && Objects.equals(this._unwrapSingle, boolB)) ? this : new ObjectArraySerializer2(this, beanProperty, typeSerializer, jsonSerializerM, boolB);
    }

    @Override // b.g.a.c.JsonSerializer
    public boolean d(SerializerProvider serializerProvider, Object obj) {
        return ((Object[]) obj).length == 0;
    }

    @Override // b.g.a.c.g0.u.ArraySerializerBase, b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Object[] objArr = (Object[]) obj;
        int length = objArr.length;
        if (length == 1 && ((this._unwrapSingle == null && serializerProvider.D(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            t(objArr, jsonGenerator, serializerProvider);
            return;
        }
        jsonGenerator.b0(objArr, length);
        t(objArr, jsonGenerator, serializerProvider);
        jsonGenerator.t();
    }

    @Override // b.g.a.c.g0.ContainerSerializer
    public ContainerSerializer<?> p(TypeSerializer typeSerializer) {
        return new ObjectArraySerializer2(this._elementType, this._staticTyping, typeSerializer, this._elementSerializer);
    }

    @Override // b.g.a.c.g0.ContainerSerializer
    public boolean q(Object obj) {
        return ((Object[]) obj).length == 1;
    }

    @Override // b.g.a.c.g0.u.ArraySerializerBase
    public JsonSerializer<?> s(BeanProperty beanProperty, Boolean bool) {
        return new ObjectArraySerializer2(this, beanProperty, this._valueTypeSerializer, this._elementSerializer, bool);
    }

    @Override // b.g.a.c.g0.u.ArraySerializerBase
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void t(Object[] objArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Object obj;
        Object obj2;
        PropertySerializerMap propertySerializerMapB;
        int length = objArr.length;
        if (length == 0) {
            return;
        }
        JsonSerializer<Object> jsonSerializer = this._elementSerializer;
        int i = 0;
        if (jsonSerializer != null) {
            int length2 = objArr.length;
            TypeSerializer typeSerializer = this._valueTypeSerializer;
            Object obj3 = null;
            while (i < length2) {
                try {
                    obj3 = objArr[i];
                    if (obj3 == null) {
                        serializerProvider.l(jsonGenerator);
                    } else if (typeSerializer == null) {
                        jsonSerializer.f(obj3, jsonGenerator, serializerProvider);
                    } else {
                        jsonSerializer.g(obj3, jsonGenerator, serializerProvider, typeSerializer);
                    }
                    i++;
                } catch (Exception e) {
                    n(serializerProvider, e, obj3, i);
                    throw null;
                }
            }
            return;
        }
        TypeSerializer typeSerializer2 = this._valueTypeSerializer;
        if (typeSerializer2 != null) {
            int length3 = objArr.length;
            try {
                PropertySerializerMap propertySerializerMap = this._dynamicSerializers;
                obj2 = null;
                while (i < length3) {
                    try {
                        obj2 = objArr[i];
                        if (obj2 == null) {
                            serializerProvider.l(jsonGenerator);
                        } else {
                            Class<?> cls = obj2.getClass();
                            JsonSerializer<Object> jsonSerializerC = propertySerializerMap.c(cls);
                            if (jsonSerializerC == null && propertySerializerMap != (propertySerializerMapB = propertySerializerMap.b(cls, (jsonSerializerC = serializerProvider.n(cls, this._property))))) {
                                this._dynamicSerializers = propertySerializerMapB;
                            }
                            jsonSerializerC.g(obj2, jsonGenerator, serializerProvider, typeSerializer2);
                        }
                        i++;
                    } catch (Exception e2) {
                        e = e2;
                        n(serializerProvider, e, obj2, i);
                        throw null;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                obj2 = null;
            }
        } else {
            try {
                PropertySerializerMap propertySerializerMap2 = this._dynamicSerializers;
                obj = null;
                while (i < length) {
                    try {
                        obj = objArr[i];
                        if (obj == null) {
                            serializerProvider.l(jsonGenerator);
                        } else {
                            Class<?> cls2 = obj.getClass();
                            JsonSerializer<Object> jsonSerializerC2 = propertySerializerMap2.c(cls2);
                            if (jsonSerializerC2 == null) {
                                if (this._elementType.r()) {
                                    PropertySerializerMap.d dVarA = propertySerializerMap2.a(serializerProvider.k(this._elementType, cls2), serializerProvider, this._property);
                                    PropertySerializerMap propertySerializerMap3 = dVarA.f708b;
                                    if (propertySerializerMap2 != propertySerializerMap3) {
                                        this._dynamicSerializers = propertySerializerMap3;
                                    }
                                    jsonSerializerC2 = dVarA.a;
                                } else {
                                    jsonSerializerC2 = serializerProvider.n(cls2, this._property);
                                    PropertySerializerMap propertySerializerMapB2 = propertySerializerMap2.b(cls2, jsonSerializerC2);
                                    if (propertySerializerMap2 != propertySerializerMapB2) {
                                        this._dynamicSerializers = propertySerializerMapB2;
                                    }
                                }
                            }
                            jsonSerializerC2.f(obj, jsonGenerator, serializerProvider);
                        }
                        i++;
                    } catch (Exception e4) {
                        e = e4;
                        n(serializerProvider, e, obj, i);
                        throw null;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                obj = null;
            }
        }
    }

    public ObjectArraySerializer2(ObjectArraySerializer2 objectArraySerializer2, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, Boolean bool) {
        super(objectArraySerializer2, beanProperty, bool);
        this._elementType = objectArraySerializer2._elementType;
        this._valueTypeSerializer = typeSerializer;
        this._staticTyping = objectArraySerializer2._staticTyping;
        this._dynamicSerializers = PropertySerializerMap.b.f706b;
        this._elementSerializer = jsonSerializer;
    }
}
