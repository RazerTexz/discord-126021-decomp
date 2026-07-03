package p007b.p195g.p196a.p205c.p219i0;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: b.g.a.c.i0.c */
/* JADX INFO: compiled from: ByteBufferBackedInputStream.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2341c extends InputStream {

    /* JADX INFO: renamed from: j */
    public final ByteBuffer f4943j;

    public C2341c(ByteBuffer byteBuffer) {
        this.f4943j = byteBuffer;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f4943j.remaining();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f4943j.hasRemaining()) {
            return this.f4943j.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f4943j.hasRemaining()) {
            return -1;
        }
        int iMin = Math.min(i2, this.f4943j.remaining());
        this.f4943j.get(bArr, i, iMin);
        return iMin;
    }
}
