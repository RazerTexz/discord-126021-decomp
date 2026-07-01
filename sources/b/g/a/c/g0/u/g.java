package b.g.a.c.g0.u;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: ByteBufferSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class g extends p0<ByteBuffer> {
    public g() {
        super(ByteBuffer.class);
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        if (byteBuffer.hasArray()) {
            int iPosition = byteBuffer.position();
            byte[] bArrArray = byteBuffer.array();
            int iArrayOffset = byteBuffer.arrayOffset() + iPosition;
            int iLimit = byteBuffer.limit() - iPosition;
            Objects.requireNonNull(dVar);
            dVar.n(b.g.a.b.b.f656b, bArrArray, iArrayOffset, iLimit);
            return;
        }
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        if (byteBufferAsReadOnlyBuffer.position() > 0) {
            byteBufferAsReadOnlyBuffer.rewind();
        }
        b.g.a.c.i0.c cVar = new b.g.a.c.i0.c(byteBufferAsReadOnlyBuffer);
        int iRemaining = byteBufferAsReadOnlyBuffer.remaining();
        Objects.requireNonNull(dVar);
        dVar.f(b.g.a.b.b.f656b, cVar, iRemaining);
        cVar.close();
    }
}
