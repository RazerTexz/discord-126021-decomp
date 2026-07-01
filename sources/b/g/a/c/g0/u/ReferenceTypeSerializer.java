package b.g.a.c.g0.u;

import b.c.a.a0.AnimatableValueParser;
import b.g.a.a.JsonInclude;
import b.g.a.b.JsonGenerator;
import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.BeanProperty;
import b.g.a.c.JavaType;
import b.g.a.c.JsonSerializer;
import b.g.a.c.MapperFeature;
import b.g.a.c.SerializerProvider;
import b.g.a.c.c0.AnnotatedMember;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.ContextualSerializer;
import b.g.a.c.g0.t.PropertySerializerMap;
import b.g.a.c.h0.ReferenceType;
import b.g.a.c.i0.NameTransformer4;
import b.g.a.c.y.JsonSerialize;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import java.io.IOException;

/* JADX INFO: renamed from: b.g.a.c.g0.u.f0, reason: use source file name */
/* JADX INFO: compiled from: ReferenceTypeSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ReferenceTypeSerializer<T> extends StdSerializer<T> implements ContextualSerializer {
    private static final long serialVersionUID = 1;
    public final BeanProperty _property;
    public final JavaType _referredType;
    public final boolean _suppressNulls;
    public final Object _suppressableValue;
    public final NameTransformer4 _unwrapper;
    public final JsonSerializer<Object> _valueSerializer;
    public final TypeSerializer _valueTypeSerializer;
    public transient PropertySerializerMap k;

    public ReferenceTypeSerializer(ReferenceType referenceType, TypeSerializer typeSerializer, JsonSerializer jsonSerializer) {
        super(referenceType);
        this._referredType = referenceType._referencedType;
        this._property = null;
        this._valueTypeSerializer = typeSerializer;
        this._valueSerializer = jsonSerializer;
        this._unwrapper = null;
        this._suppressableValue = null;
        this._suppressNulls = false;
        this.k = PropertySerializerMap.b.f706b;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0022  */
    /* JADX WARN: Code duplicated, block: B:19:0x0033  */
    /* JADX WARN: Code duplicated, block: B:22:0x003b  */
    /* JADX WARN: Code duplicated, block: B:78:0x00de  */
    @Override // b.g.a.c.g0.ContextualSerializer
    public JsonSerializer<?> a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<?> jsonSerializerY;
        JsonInclude.b bVarB;
        JsonInclude.a aVar;
        boolean zC;
        Object objC;
        Object objT0 = JsonInclude.a.NON_EMPTY;
        TypeSerializer typeSerializerA = this._valueTypeSerializer;
        if (typeSerializerA != null) {
            typeSerializerA = typeSerializerA.a(beanProperty);
        }
        if (beanProperty != null) {
            AnnotatedMember member = beanProperty.getMember();
            AnnotationIntrospector annotationIntrospectorV = serializerProvider.v();
            if (member == null || (objC = annotationIntrospectorV.c(member)) == null) {
                jsonSerializerY = null;
            } else {
                jsonSerializerY = serializerProvider.H(member, objC);
            }
        } else {
            jsonSerializerY = null;
        }
        boolean zB = false;
        if (jsonSerializerY == null) {
            jsonSerializerY = this._valueSerializer;
            if (jsonSerializerY == null) {
                JavaType javaType = this._referredType;
                if (javaType.y()) {
                    zC = false;
                } else if (javaType.x() || javaType._asStatic) {
                    zC = true;
                } else {
                    AnnotationIntrospector annotationIntrospectorV2 = serializerProvider.v();
                    if (annotationIntrospectorV2 != null && beanProperty != null && beanProperty.getMember() != null) {
                        JsonSerialize.b bVarK = annotationIntrospectorV2.K(beanProperty.getMember());
                        if (bVarK == JsonSerialize.b.STATIC) {
                            zC = true;
                        } else if (bVarK == JsonSerialize.b.DYNAMIC) {
                            zC = false;
                        }
                    }
                    zC = serializerProvider.C(MapperFeature.USE_STATIC_TYPING);
                }
                if (zC) {
                    jsonSerializerY = serializerProvider.q(this._referredType, beanProperty);
                }
            } else {
                jsonSerializerY = serializerProvider.y(jsonSerializerY, beanProperty);
            }
        }
        ReferenceTypeSerializer<T> referenceTypeSerializerU = (this._property == beanProperty && this._valueTypeSerializer == typeSerializerA && this._valueSerializer == jsonSerializerY) ? this : u(beanProperty, typeSerializerA, jsonSerializerY, this._unwrapper);
        if (beanProperty == null || (bVarB = beanProperty.b(serializerProvider._config, this._handledType)) == null || (aVar = bVarB._contentInclusion) == JsonInclude.a.USE_DEFAULTS) {
            return referenceTypeSerializerU;
        }
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 1) {
            objT0 = null;
            zB = true;
        } else {
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    if (iOrdinal == 4) {
                        objT0 = AnimatableValueParser.t0(this._referredType);
                        if (objT0 != null && objT0.getClass().isArray()) {
                            objT0 = AnimatableValueParser.q0(objT0);
                        }
                    } else if (iOrdinal != 5) {
                        objT0 = null;
                    } else {
                        objT0 = serializerProvider.A(null, bVarB._contentFilter);
                        if (objT0 != null) {
                            zB = serializerProvider.B(objT0);
                        }
                    }
                }
            } else if (!this._referredType.b()) {
                objT0 = null;
            }
            zB = true;
        }
        return (this._suppressableValue == objT0 && this._suppressNulls == zB) ? referenceTypeSerializerU : referenceTypeSerializerU.t(objT0, zB);
    }

    @Override // b.g.a.c.JsonSerializer
    public boolean d(SerializerProvider serializerProvider, T t) {
        if (!s(t)) {
            return true;
        }
        Object objQ = q(t);
        if (objQ == null) {
            return this._suppressNulls;
        }
        if (this._suppressableValue == null) {
            return false;
        }
        JsonSerializer<Object> jsonSerializerP = this._valueSerializer;
        if (jsonSerializerP == null) {
            try {
                jsonSerializerP = p(serializerProvider, objQ.getClass());
            } catch (JsonMappingException e) {
                throw new RuntimeJsonMappingException(e);
            }
        }
        Object obj = this._suppressableValue;
        return obj == JsonInclude.a.NON_EMPTY ? jsonSerializerP.d(serializerProvider, objQ) : obj.equals(objQ);
    }

    @Override // b.g.a.c.JsonSerializer
    public boolean e() {
        return this._unwrapper != null;
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Object objR = r(t);
        if (objR == null) {
            if (this._unwrapper == null) {
                serializerProvider.l(jsonGenerator);
                return;
            }
            return;
        }
        JsonSerializer<Object> jsonSerializerP = this._valueSerializer;
        if (jsonSerializerP == null) {
            jsonSerializerP = p(serializerProvider, objR.getClass());
        }
        TypeSerializer typeSerializer = this._valueTypeSerializer;
        if (typeSerializer != null) {
            jsonSerializerP.g(objR, jsonGenerator, serializerProvider, typeSerializer);
        } else {
            jsonSerializerP.f(objR, jsonGenerator, serializerProvider);
        }
    }

    @Override // b.g.a.c.JsonSerializer
    public void g(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        Object objR = r(t);
        if (objR == null) {
            if (this._unwrapper == null) {
                serializerProvider.l(jsonGenerator);
            }
        } else {
            JsonSerializer<Object> jsonSerializerP = this._valueSerializer;
            if (jsonSerializerP == null) {
                jsonSerializerP = p(serializerProvider, objR.getClass());
            }
            jsonSerializerP.g(objR, jsonGenerator, serializerProvider, typeSerializer);
        }
    }

    @Override // b.g.a.c.JsonSerializer
    public JsonSerializer<T> h(NameTransformer4 nameTransformer4) {
        JsonSerializer<?> jsonSerializerH = this._valueSerializer;
        if (jsonSerializerH != null && (jsonSerializerH = jsonSerializerH.h(nameTransformer4)) == this._valueSerializer) {
            return this;
        }
        NameTransformer4 nameTransformer5 = this._unwrapper;
        if (nameTransformer5 != null) {
            nameTransformer4 = new NameTransformer4.a(nameTransformer4, nameTransformer5);
        }
        return (this._valueSerializer == jsonSerializerH && nameTransformer5 == nameTransformer4) ? this : u(this._property, this._valueTypeSerializer, jsonSerializerH, nameTransformer4);
    }

    public final JsonSerializer<Object> p(SerializerProvider serializerProvider, Class<?> cls) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializerC = this.k.c(cls);
        if (jsonSerializerC != null) {
            return jsonSerializerC;
        }
        JsonSerializer<Object> jsonSerializerQ = this._referredType.r() ? serializerProvider.q(serializerProvider.k(this._referredType, cls), this._property) : serializerProvider.r(cls, this._property);
        NameTransformer4 nameTransformer4 = this._unwrapper;
        if (nameTransformer4 != null) {
            jsonSerializerQ = jsonSerializerQ.h(nameTransformer4);
        }
        JsonSerializer<Object> jsonSerializer = jsonSerializerQ;
        this.k = this.k.b(cls, jsonSerializer);
        return jsonSerializer;
    }

    public abstract Object q(T t);

    public abstract Object r(T t);

    public abstract boolean s(T t);

    public abstract ReferenceTypeSerializer<T> t(Object obj, boolean z2);

    public abstract ReferenceTypeSerializer<T> u(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, NameTransformer4 nameTransformer4);

    public ReferenceTypeSerializer(ReferenceTypeSerializer<?> referenceTypeSerializer, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, NameTransformer4 nameTransformer4, Object obj, boolean z2) {
        super(referenceTypeSerializer);
        this._referredType = referenceTypeSerializer._referredType;
        this.k = PropertySerializerMap.b.f706b;
        this._property = beanProperty;
        this._valueTypeSerializer = typeSerializer;
        this._valueSerializer = jsonSerializer;
        this._unwrapper = nameTransformer4;
        this._suppressableValue = obj;
        this._suppressNulls = z2;
    }
}
