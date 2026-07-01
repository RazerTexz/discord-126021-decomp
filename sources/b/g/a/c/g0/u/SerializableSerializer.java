package b.g.a.c.g0.u;

import b.g.a.b.JsonGenerator;
import b.g.a.c.JsonSerializable;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.y.JacksonStdImpl;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: renamed from: b.g.a.c.g0.u.g0, reason: use source file name */
/* JADX INFO: compiled from: SerializableSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class SerializableSerializer extends StdSerializer<JsonSerializable> {
    public static final SerializableSerializer k = new SerializableSerializer();

    public SerializableSerializer() {
        super(JsonSerializable.class);
    }

    @Override // b.g.a.c.JsonSerializer
    public boolean d(SerializerProvider serializerProvider, Object obj) {
        JsonSerializable jsonSerializable = (JsonSerializable) obj;
        if (!(jsonSerializable instanceof JsonSerializable.a)) {
            return false;
        }
        Objects.requireNonNull((JsonSerializable.a) jsonSerializable);
        return false;
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        ((JsonSerializable) obj).c(jsonGenerator, serializerProvider);
    }

    @Override // b.g.a.c.JsonSerializer
    public void g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        ((JsonSerializable) obj).d(jsonGenerator, serializerProvider, typeSerializer);
    }
}
