package b.g.a.c.g0.u;

import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonToken2;
import b.g.a.b.s.WritableTypeId;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import java.io.IOException;

/* JADX INFO: renamed from: b.g.a.c.g0.u.p0, reason: use source file name */
/* JADX INFO: compiled from: StdScalarSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class StdScalarSerializer<T> extends StdSerializer<T> {
    public StdScalarSerializer(Class<T> cls) {
        super(cls);
    }

    @Override // b.g.a.c.JsonSerializer
    public void g(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        WritableTypeId writableTypeIdE = typeSerializer.e(jsonGenerator, typeSerializer.d(t, JsonToken2.VALUE_STRING));
        f(t, jsonGenerator, serializerProvider);
        typeSerializer.f(jsonGenerator, writableTypeIdE);
    }

    public StdScalarSerializer(Class<?> cls, boolean z2) {
        super(cls);
    }
}
