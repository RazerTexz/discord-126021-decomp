package b.g.a.c.g0.u;

import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonParser;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.y.JacksonStdImpl;
import java.io.IOException;

/* JADX INFO: renamed from: b.g.a.c.g0.u.a0, reason: use source file name */
/* JADX INFO: compiled from: NumberSerializers.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class NumberSerializers extends NumberSerializers4<Object> {
    public NumberSerializers(Class<?> cls) {
        super(cls, JsonParser.b.INT, "integer");
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.H(((Integer) obj).intValue());
    }

    @Override // b.g.a.c.g0.u.StdScalarSerializer, b.g.a.c.JsonSerializer
    public void g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        f(obj, jsonGenerator, serializerProvider);
    }
}
