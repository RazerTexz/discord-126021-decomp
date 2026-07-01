package b.g.a.c.g0.u;

import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonToken2;
import b.g.a.b.s.WritableTypeId;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.y.JacksonStdImpl;
import java.io.IOException;

/* JADX INFO: renamed from: b.g.a.c.g0.u.f, reason: use source file name */
/* JADX INFO: compiled from: ByteArraySerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class ByteArraySerializer2 extends StdSerializer<byte[]> {
    private static final long serialVersionUID = 1;

    public ByteArraySerializer2() {
        super(byte[].class);
    }

    @Override // b.g.a.c.JsonSerializer
    public boolean d(SerializerProvider serializerProvider, Object obj) {
        return ((byte[]) obj).length == 0;
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        byte[] bArr = (byte[]) obj;
        jsonGenerator.n(serializerProvider._config._base._defaultBase64, bArr, 0, bArr.length);
    }

    @Override // b.g.a.c.JsonSerializer
    public void g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        byte[] bArr = (byte[]) obj;
        WritableTypeId writableTypeIdE = typeSerializer.e(jsonGenerator, typeSerializer.d(bArr, JsonToken2.VALUE_EMBEDDED_OBJECT));
        jsonGenerator.n(serializerProvider._config._base._defaultBase64, bArr, 0, bArr.length);
        typeSerializer.f(jsonGenerator, writableTypeIdE);
    }
}
