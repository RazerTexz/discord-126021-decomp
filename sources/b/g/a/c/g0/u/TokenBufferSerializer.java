package b.g.a.c.g0.u;

import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonToken2;
import b.g.a.c.SerializerProvider;
import b.g.a.c.e0.TypeSerializer;
import b.g.a.c.i0.TokenBuffer;
import b.g.a.c.y.JacksonStdImpl;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: renamed from: b.g.a.c.g0.u.v0, reason: use source file name */
/* JADX INFO: compiled from: TokenBufferSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class TokenBufferSerializer extends StdSerializer<TokenBuffer> {
    public TokenBufferSerializer() {
        super(TokenBuffer.class);
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Objects.requireNonNull((TokenBuffer) obj);
        Objects.requireNonNull(null);
        throw null;
    }

    @Override // b.g.a.c.JsonSerializer
    public void g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        TokenBuffer tokenBuffer = (TokenBuffer) obj;
        typeSerializer.e(jsonGenerator, typeSerializer.d(tokenBuffer, JsonToken2.VALUE_EMBEDDED_OBJECT));
        Objects.requireNonNull(tokenBuffer);
        Objects.requireNonNull(null);
        throw null;
    }
}
