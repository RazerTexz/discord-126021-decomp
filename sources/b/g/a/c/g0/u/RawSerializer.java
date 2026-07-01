package b.g.a.c.g0.u;

import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonToken2;
import b.g.a.b.s.WritableTypeId;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import java.io.IOException;

/* JADX INFO: renamed from: b.g.a.c.g0.u.e0, reason: use source file name */
/* JADX INFO: compiled from: RawSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class RawSerializer<T> extends StdSerializer<T> {
    public RawSerializer(Class<?> cls) {
        super(cls, false);
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.V(t.toString());
    }

    @Override // b.g.a.c.JsonSerializer
    public void g(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        WritableTypeId writableTypeIdE = typeSerializer.e(jsonGenerator, typeSerializer.d(t, JsonToken2.VALUE_EMBEDDED_OBJECT));
        jsonGenerator.V(t.toString());
        typeSerializer.f(jsonGenerator, writableTypeIdE);
    }
}
