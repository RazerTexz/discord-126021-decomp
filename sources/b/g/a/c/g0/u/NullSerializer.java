package b.g.a.c.g0.u;

import b.g.a.b.JsonGenerator;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.y.JacksonStdImpl;
import java.io.IOException;

/* JADX INFO: renamed from: b.g.a.c.g0.u.u, reason: use source file name */
/* JADX INFO: compiled from: NullSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class NullSerializer extends StdSerializer<Object> {
    public static final NullSerializer k = new NullSerializer();

    public NullSerializer() {
        super(Object.class);
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.A();
    }

    @Override // b.g.a.c.JsonSerializer
    public void g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        jsonGenerator.A();
    }
}
