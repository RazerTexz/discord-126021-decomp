package b.g.a.c.g0.t;

import b.g.a.b.JsonGenerator;
import b.g.a.c.BeanProperty;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.g0.ContextualSerializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;

/* JADX INFO: renamed from: b.g.a.c.g0.t.p, reason: use source file name */
/* JADX INFO: compiled from: TypeWrappedSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TypeWrappedSerializer extends JsonSerializer<Object> implements ContextualSerializer {
    public final TypeSerializer j;
    public final JsonSerializer<Object> k;

    public TypeWrappedSerializer(TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer) {
        this.j = typeSerializer;
        this.k = jsonSerializer;
    }

    @Override // b.g.a.c.g0.ContextualSerializer
    public JsonSerializer<?> a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<?> jsonSerializerZ = this.k;
        if (jsonSerializerZ instanceof ContextualSerializer) {
            jsonSerializerZ = serializerProvider.z(jsonSerializerZ, beanProperty);
        }
        return jsonSerializerZ == this.k ? this : new TypeWrappedSerializer(this.j, jsonSerializerZ);
    }

    @Override // b.g.a.c.JsonSerializer
    public Class<Object> c() {
        return Object.class;
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        this.k.g(obj, jsonGenerator, serializerProvider, this.j);
    }

    @Override // b.g.a.c.JsonSerializer
    public void g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        this.k.g(obj, jsonGenerator, serializerProvider, typeSerializer);
    }
}
