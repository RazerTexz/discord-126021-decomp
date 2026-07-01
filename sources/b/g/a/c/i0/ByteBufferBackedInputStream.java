package b.g.a.c.i0;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: b.g.a.c.i0.c, reason: use source file name */
/* JADX INFO: compiled from: ByteBufferBackedInputStream.java */
/* JADX INFO: loaded from: classes3.dex */
public class ByteBufferBackedInputStream extends InputStream {
    public final ByteBuffer j;

    public ByteBufferBackedInputStream(ByteBuffer byteBuffer) {
        this.j = byteBuffer;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.j.remaining();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.j.hasRemaining()) {
            return this.j.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (!this.j.hasRemaining()) {
            return -1;
        }
        int iMin = Math.min(i2, this.j.remaining());
        this.j.get(bArr, i, iMin);
        return iMin;
    }
}
