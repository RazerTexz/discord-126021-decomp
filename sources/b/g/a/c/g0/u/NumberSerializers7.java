package b.g.a.c.g0.u;

import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonParser;
import b.g.a.c.SerializerProvider;
import b.g.a.c.y.JacksonStdImpl;
import java.io.IOException;

/* JADX INFO: renamed from: b.g.a.c.g0.u.z, reason: use source file name */
/* JADX INFO: compiled from: NumberSerializers.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class NumberSerializers7 extends NumberSerializers4<Object> {
    public static final NumberSerializers7 k = new NumberSerializers7();

    public NumberSerializers7() {
        super(Number.class, JsonParser.b.INT, "integer");
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.H(((Number) obj).intValue());
    }
}
