package b.i.a.c.e3;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: DataSourceInputStream.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends InputStream {
    public final l j;
    public final n k;
    public long o;
    public boolean m = false;
    public boolean n = false;
    public final byte[] l = new byte[1];

    public m(l lVar, n nVar) {
        this.j = lVar;
        this.k = nVar;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.n) {
            return;
        }
        this.j.close();
        this.n = true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.l) == -1) {
            return -1;
        }
        return this.l[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        b.c.a.a0.d.D(!this.n);
        if (!this.m) {
            this.j.a(this.k);
            this.m = true;
        }
        int i3 = this.j.read(bArr, i, i2);
        if (i3 == -1) {
            return -1;
        }
        this.o += (long) i3;
        return i3;
    }
}
