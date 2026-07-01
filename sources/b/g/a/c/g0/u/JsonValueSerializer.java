package b.g.a.c.g0.u;

import b.d.b.a.outline;
import b.g.a.a.JsonTypeInfo;
import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonToken2;
import b.g.a.b.s.WritableTypeId;
import b.g.a.c.BeanProperty;
import b.g.a.c.JavaType;
import b.g.a.c.JsonSerializer;
import b.g.a.c.MapperFeature;
import b.g.a.c.SerializerProvider;
import b.g.a.c.c0.AnnotatedMember;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.ContextualSerializer;
import b.g.a.c.g0.t.PropertySerializerMap;
import b.g.a.c.i0.ClassUtil;
import b.g.a.c.y.JacksonStdImpl;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: renamed from: b.g.a.c.g0.u.s, reason: use source file name */
/* JADX INFO: compiled from: JsonValueSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class JsonValueSerializer extends StdSerializer<Object> implements ContextualSerializer {
    public final AnnotatedMember _accessor;
    public final boolean _forceTypeInformation;
    public final BeanProperty _property;
    public final JsonSerializer<Object> _valueSerializer;
    public final JavaType _valueType;
    public final TypeSerializer _valueTypeSerializer;
    public transient PropertySerializerMap k;

    /* JADX INFO: renamed from: b.g.a.c.g0.u.s$a */
    /* JADX INFO: compiled from: JsonValueSerializer.java */
    public static class a extends TypeSerializer {
        public final TypeSerializer a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f714b;

        public a(TypeSerializer typeSerializer, Object obj) {
            this.a = typeSerializer;
            this.f714b = obj;
        }

        @Override // b.g.a.c.e0.TypeSerializer
        public TypeSerializer a(BeanProperty beanProperty) {
            throw new UnsupportedOperationException();
        }

        @Override // b.g.a.c.e0.TypeSerializer
        public String b() {
            return this.a.b();
        }

        @Override // b.g.a.c.e0.TypeSerializer
        public JsonTypeInfo.a c() {
            return this.a.c();
        }

        @Override // b.g.a.c.e0.TypeSerializer
        public WritableTypeId e(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) throws IOException {
            writableTypeId.a = this.f714b;
            return this.a.e(jsonGenerator, writableTypeId);
        }

        @Override // b.g.a.c.e0.TypeSerializer
        public WritableTypeId f(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) throws IOException {
            return this.a.f(jsonGenerator, writableTypeId);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public JsonValueSerializer(JsonValueSerializer jsonValueSerializer, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, boolean z2) {
        Class cls = jsonValueSerializer._handledType;
        super(cls == null ? Object.class : cls);
        this._accessor = jsonValueSerializer._accessor;
        this._valueType = jsonValueSerializer._valueType;
        this._valueTypeSerializer = typeSerializer;
        this._valueSerializer = jsonSerializer;
        this._property = beanProperty;
        this._forceTypeInformation = z2;
        this.k = PropertySerializerMap.b.f706b;
    }

    @Override // b.g.a.c.g0.ContextualSerializer
    public JsonSerializer<?> a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        TypeSerializer typeSerializerA = this._valueTypeSerializer;
        if (typeSerializerA != null) {
            typeSerializerA = typeSerializerA.a(beanProperty);
        }
        JsonSerializer<?> jsonSerializer = this._valueSerializer;
        if (jsonSerializer != null) {
            return q(beanProperty, typeSerializerA, serializerProvider.y(jsonSerializer, beanProperty), this._forceTypeInformation);
        }
        if (!serializerProvider.C(MapperFeature.USE_STATIC_TYPING) && !this._valueType.x()) {
            return beanProperty != this._property ? q(beanProperty, typeSerializerA, jsonSerializer, this._forceTypeInformation) : this;
        }
        JsonSerializer<Object> jsonSerializerQ = serializerProvider.q(this._valueType, beanProperty);
        Class<?> cls = this._valueType._class;
        boolean zS = false;
        if (!cls.isPrimitive() ? cls == String.class || cls == Integer.class || cls == Boolean.class || cls == Double.class : cls == Integer.TYPE || cls == Boolean.TYPE || cls == Double.TYPE) {
            zS = ClassUtil.s(jsonSerializerQ);
        }
        return q(beanProperty, typeSerializerA, jsonSerializerQ, zS);
    }

    @Override // b.g.a.c.JsonSerializer
    public boolean d(SerializerProvider serializerProvider, Object obj) {
        Object objJ = this._accessor.j(obj);
        if (objJ == null) {
            return true;
        }
        JsonSerializer<Object> jsonSerializerP = this._valueSerializer;
        if (jsonSerializerP == null) {
            try {
                jsonSerializerP = p(serializerProvider, objJ.getClass());
            } catch (JsonMappingException e) {
                throw new RuntimeJsonMappingException(e);
            }
        }
        return jsonSerializerP.d(serializerProvider, objJ);
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        try {
            Object objJ = this._accessor.j(obj);
            if (objJ == null) {
                serializerProvider.l(jsonGenerator);
                return;
            }
            JsonSerializer<Object> jsonSerializerP = this._valueSerializer;
            if (jsonSerializerP == null) {
                jsonSerializerP = p(serializerProvider, objJ.getClass());
            }
            TypeSerializer typeSerializer = this._valueTypeSerializer;
            if (typeSerializer != null) {
                jsonSerializerP.g(objJ, jsonGenerator, serializerProvider, typeSerializer);
            } else {
                jsonSerializerP.f(objJ, jsonGenerator, serializerProvider);
            }
        } catch (Exception e) {
            o(serializerProvider, e, obj, this._accessor.c() + "()");
            throw null;
        }
    }

    @Override // b.g.a.c.JsonSerializer
    public void g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        try {
            Object objJ = this._accessor.j(obj);
            if (objJ == null) {
                serializerProvider.l(jsonGenerator);
                return;
            }
            JsonSerializer<Object> jsonSerializerP = this._valueSerializer;
            if (jsonSerializerP == null) {
                jsonSerializerP = p(serializerProvider, objJ.getClass());
            } else if (this._forceTypeInformation) {
                WritableTypeId writableTypeIdE = typeSerializer.e(jsonGenerator, typeSerializer.d(obj, JsonToken2.VALUE_STRING));
                jsonSerializerP.f(objJ, jsonGenerator, serializerProvider);
                typeSerializer.f(jsonGenerator, writableTypeIdE);
                return;
            }
            jsonSerializerP.g(objJ, jsonGenerator, serializerProvider, new a(typeSerializer, obj));
        } catch (Exception e) {
            o(serializerProvider, e, obj, this._accessor.c() + "()");
            throw null;
        }
    }

    public JsonSerializer<Object> p(SerializerProvider serializerProvider, Class<?> cls) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializerC = this.k.c(cls);
        if (jsonSerializerC != null) {
            return jsonSerializerC;
        }
        if (!this._valueType.r()) {
            JsonSerializer<Object> jsonSerializerR = serializerProvider.r(cls, this._property);
            this.k = this.k.b(cls, jsonSerializerR);
            return jsonSerializerR;
        }
        JavaType javaTypeK = serializerProvider.k(this._valueType, cls);
        JsonSerializer<Object> jsonSerializerQ = serializerProvider.q(javaTypeK, this._property);
        PropertySerializerMap propertySerializerMap = this.k;
        Objects.requireNonNull(propertySerializerMap);
        this.k = propertySerializerMap.b(javaTypeK._class, jsonSerializerQ);
        return jsonSerializerQ;
    }

    public JsonValueSerializer q(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, boolean z2) {
        return (this._property == beanProperty && this._valueTypeSerializer == typeSerializer && this._valueSerializer == jsonSerializer && z2 == this._forceTypeInformation) ? this : new JsonValueSerializer(this, beanProperty, typeSerializer, jsonSerializer, z2);
    }

    public String toString() {
        StringBuilder sbU = outline.U("(@JsonValue serializer for method ");
        sbU.append(this._accessor.g());
        sbU.append("#");
        sbU.append(this._accessor.c());
        sbU.append(")");
        return sbU.toString();
    }

    public JsonValueSerializer(AnnotatedMember annotatedMember, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer) {
        super(annotatedMember.e());
        this._accessor = annotatedMember;
        this._valueType = annotatedMember.e();
        this._valueTypeSerializer = typeSerializer;
        this._valueSerializer = jsonSerializer;
        this._property = null;
        this._forceTypeInformation = true;
        this.k = PropertySerializerMap.b.f706b;
    }
}
