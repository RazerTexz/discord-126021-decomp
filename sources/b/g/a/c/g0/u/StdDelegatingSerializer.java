package b.g.a.c.g0.u;

import b.g.a.b.JsonGenerator;
import b.g.a.c.BeanProperty;
import b.g.a.c.JavaType;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.ContextualSerializer;
import b.g.a.c.g0.ResolvableSerializer;
import b.g.a.c.h0.TypeFactory;
import b.g.a.c.i0.ClassUtil;
import b.g.a.c.i0.Converter;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;

/* JADX INFO: renamed from: b.g.a.c.g0.u.j0, reason: use source file name */
/* JADX INFO: compiled from: StdDelegatingSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class StdDelegatingSerializer extends StdSerializer<Object> implements ContextualSerializer, ResolvableSerializer {
    public final Converter<Object, ?> _converter;
    public final JsonSerializer<Object> _delegateSerializer;
    public final JavaType _delegateType;

    public StdDelegatingSerializer(Converter<Object, ?> converter, JavaType javaType, JsonSerializer<?> jsonSerializer) {
        super(javaType);
        this._converter = converter;
        this._delegateType = javaType;
        this._delegateSerializer = jsonSerializer;
    }

    @Override // b.g.a.c.g0.ContextualSerializer
    public JsonSerializer<?> a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<?> jsonSerializerZ = this._delegateSerializer;
        JavaType javaTypeA = this._delegateType;
        if (jsonSerializerZ == null) {
            if (javaTypeA == null) {
                javaTypeA = this._converter.a(serializerProvider.d());
            }
            if (!javaTypeA.y()) {
                jsonSerializerZ = serializerProvider.s(javaTypeA);
            }
        }
        if (jsonSerializerZ instanceof ContextualSerializer) {
            jsonSerializerZ = serializerProvider.z(jsonSerializerZ, beanProperty);
        }
        if (jsonSerializerZ == this._delegateSerializer && javaTypeA == this._delegateType) {
            return this;
        }
        Converter<Object, ?> converter = this._converter;
        ClassUtil.z(StdDelegatingSerializer.class, this, "withDelegate");
        return new StdDelegatingSerializer(converter, javaTypeA, jsonSerializerZ);
    }

    @Override // b.g.a.c.g0.ResolvableSerializer
    public void b(SerializerProvider serializerProvider) throws JsonMappingException {
        Object obj = this._delegateSerializer;
        if (obj == null || !(obj instanceof ResolvableSerializer)) {
            return;
        }
        ((ResolvableSerializer) obj).b(serializerProvider);
    }

    @Override // b.g.a.c.JsonSerializer
    public boolean d(SerializerProvider serializerProvider, Object obj) {
        Object objConvert = this._converter.convert(obj);
        if (objConvert == null) {
            return true;
        }
        JsonSerializer<Object> jsonSerializer = this._delegateSerializer;
        if (jsonSerializer == null) {
            return obj == null;
        }
        return jsonSerializer.d(serializerProvider, objConvert);
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Object objConvert = this._converter.convert(obj);
        if (objConvert == null) {
            serializerProvider.l(jsonGenerator);
            return;
        }
        JsonSerializer<Object> jsonSerializerP = this._delegateSerializer;
        if (jsonSerializerP == null) {
            jsonSerializerP = p(objConvert, serializerProvider);
        }
        jsonSerializerP.f(objConvert, jsonGenerator, serializerProvider);
    }

    @Override // b.g.a.c.JsonSerializer
    public void g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        Object objConvert = this._converter.convert(obj);
        JsonSerializer<Object> jsonSerializerP = this._delegateSerializer;
        if (jsonSerializerP == null) {
            jsonSerializerP = p(obj, serializerProvider);
        }
        jsonSerializerP.g(objConvert, jsonGenerator, serializerProvider, typeSerializer);
    }

    public JsonSerializer<Object> p(Object obj, SerializerProvider serializerProvider) throws JsonMappingException {
        Class<?> cls = obj.getClass();
        JsonSerializer<Object> jsonSerializerB = serializerProvider._knownSerializers.b(cls);
        if (jsonSerializerB != null) {
            return jsonSerializerB;
        }
        JsonSerializer<Object> jsonSerializerB2 = serializerProvider._serializerCache.b(cls);
        if (jsonSerializerB2 != null) {
            return jsonSerializerB2;
        }
        JsonSerializer<Object> jsonSerializerA = serializerProvider._serializerCache.a(serializerProvider._config._base._typeFactory.b(null, cls, TypeFactory.l));
        if (jsonSerializerA != null) {
            return jsonSerializerA;
        }
        JsonSerializer<Object> jsonSerializerI = serializerProvider.i(cls);
        return jsonSerializerI == null ? serializerProvider.x(cls) : jsonSerializerI;
    }
}
