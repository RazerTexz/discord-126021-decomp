package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.C2106b;
import p007b.p195g.p196a.p205c.AbstractC2374x;
import p007b.p195g.p196a.p205c.p219i0.C2341c;

/* JADX INFO: renamed from: b.g.a.c.g0.u.g */
/* JADX INFO: compiled from: ByteBufferSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2284g extends AbstractC2303p0<ByteBuffer> {
    public C2284g() {
        super(ByteBuffer.class);
    }

    @Override // p007b.p195g.p196a.p205c.AbstractC2364n
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, AbstractC2108d abstractC2108d, AbstractC2374x abstractC2374x) throws IOException {
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        if (byteBuffer.hasArray()) {
            int iPosition = byteBuffer.position();
            byte[] bArrArray = byteBuffer.array();
            int iArrayOffset = byteBuffer.arrayOffset() + iPosition;
            int iLimit = byteBuffer.limit() - iPosition;
            Objects.requireNonNull(abstractC2108d);
            abstractC2108d.mo1660n(C2106b.f4452b, bArrArray, iArrayOffset, iLimit);
            return;
        }
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        if (byteBufferAsReadOnlyBuffer.position() > 0) {
            byteBufferAsReadOnlyBuffer.rewind();
        }
        C2341c c2341c = new C2341c(byteBufferAsReadOnlyBuffer);
        int iRemaining = byteBufferAsReadOnlyBuffer.remaining();
        Objects.requireNonNull(abstractC2108d);
        abstractC2108d.mo1655f(C2106b.f4452b, c2341c, iRemaining);
        c2341c.close();
    }
}
