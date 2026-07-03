package p007b.p109f.p115d.p125j;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: b.f.d.j.a */
/* JADX INFO: compiled from: LimitedInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class C1711a extends FilterInputStream {

    /* JADX INFO: renamed from: j */
    public int f3128j;

    /* JADX INFO: renamed from: k */
    public int f3129k;

    public C1711a(InputStream inputStream, int i) {
        super(inputStream);
        if (i < 0) {
            throw new IllegalArgumentException("limit must be >= 0");
        }
        this.f3128j = i;
        this.f3129k = -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return Math.min(((FilterInputStream) this).in.available(), this.f3128j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        if (((FilterInputStream) this).in.markSupported()) {
            ((FilterInputStream) this).in.mark(i);
            this.f3129k = this.f3128j;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.f3128j == 0) {
            return -1;
        }
        int i = ((FilterInputStream) this).in.read();
        if (i != -1) {
            this.f3128j--;
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        if (!((FilterInputStream) this).in.markSupported()) {
            throw new IOException("mark is not supported");
        }
        if (this.f3129k == -1) {
            throw new IOException("mark not set");
        }
        ((FilterInputStream) this).in.reset();
        this.f3128j = this.f3129k;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long jSkip = ((FilterInputStream) this).in.skip(Math.min(j, this.f3128j));
        this.f3128j = (int) (((long) this.f3128j) - jSkip);
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f3128j;
        if (i3 == 0) {
            return -1;
        }
        int i4 = ((FilterInputStream) this).in.read(bArr, i, Math.min(i2, i3));
        if (i4 > 0) {
            this.f3128j -= i4;
        }
        return i4;
    }
}
