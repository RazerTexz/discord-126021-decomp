package b.g.a.c.g0.u;

import b.g.a.b.JsonGenerator;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.y.JacksonStdImpl;
import java.io.IOException;

/* JADX INFO: renamed from: b.g.a.c.g0.u.r0, reason: use source file name */
/* JADX INFO: compiled from: StringSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public final class StringSerializer2 extends StdScalarSerializer<Object> {
    private static final long serialVersionUID = 1;

    public StringSerializer2() {
        super(String.class, false);
    }

    @Override // b.g.a.c.JsonSerializer
    public boolean d(SerializerProvider serializerProvider, Object obj) {
        return ((String) obj).isEmpty();
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.j0((String) obj);
    }

    @Override // b.g.a.c.g0.u.StdScalarSerializer, b.g.a.c.JsonSerializer
    public final void g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        jsonGenerator.j0((String) obj);
    }
}
