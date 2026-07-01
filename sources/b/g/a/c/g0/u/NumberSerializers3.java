package b.g.a.c.g0.u;

import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonParser;
import b.g.a.c.SerializerProvider;
import b.g.a.c.y.JacksonStdImpl;
import java.io.IOException;

/* JADX INFO: renamed from: b.g.a.c.g0.u.c0, reason: use source file name */
/* JADX INFO: compiled from: NumberSerializers.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class NumberSerializers3 extends NumberSerializers4<Object> {
    public static final NumberSerializers3 k = new NumberSerializers3();

    public NumberSerializers3() {
        super(Short.class, JsonParser.b.INT, "number");
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.O(((Short) obj).shortValue());
    }
}
