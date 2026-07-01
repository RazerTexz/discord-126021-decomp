package b.g.a.c.g0.u;

import b.g.a.b.Base64Variants;
import b.g.a.b.JsonGenerator;
import b.g.a.c.SerializerProvider;
import b.g.a.c.i0.ByteBufferBackedInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: renamed from: b.g.a.c.g0.u.g, reason: use source file name */
/* JADX INFO: compiled from: ByteBufferSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class ByteBufferSerializer extends StdScalarSerializer<ByteBuffer> {
    public ByteBufferSerializer() {
        super(ByteBuffer.class);
    }

    @Override // b.g.a.c.JsonSerializer
    public void f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        if (byteBuffer.hasArray()) {
            int iPosition = byteBuffer.position();
            byte[] bArrArray = byteBuffer.array();
            int iArrayOffset = byteBuffer.arrayOffset() + iPosition;
            int iLimit = byteBuffer.limit() - iPosition;
            Objects.requireNonNull(jsonGenerator);
            jsonGenerator.n(Base64Variants.f656b, bArrArray, iArrayOffset, iLimit);
            return;
        }
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        if (byteBufferAsReadOnlyBuffer.position() > 0) {
            byteBufferAsReadOnlyBuffer.rewind();
        }
        ByteBufferBackedInputStream byteBufferBackedInputStream = new ByteBufferBackedInputStream(byteBufferAsReadOnlyBuffer);
        int iRemaining = byteBufferAsReadOnlyBuffer.remaining();
        Objects.requireNonNull(jsonGenerator);
        jsonGenerator.f(Base64Variants.f656b, byteBufferBackedInputStream, iRemaining);
        byteBufferBackedInputStream.close();
    }
}
