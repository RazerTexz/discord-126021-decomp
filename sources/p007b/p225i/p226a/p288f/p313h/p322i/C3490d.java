package p007b.p225i.p226a.p288f.p313h.p322i;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.f.h.i.d */
/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3490d extends FilterInputStream {

    /* JADX INFO: renamed from: j */
    public long f9654j;

    /* JADX INFO: renamed from: k */
    public long f9655k;

    public C3490d(InputStream inputStream) {
        super(inputStream);
        this.f9655k = -1L;
        Objects.requireNonNull(inputStream);
        this.f9654j = 1048577L;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() throws IOException {
        return (int) Math.min(((FilterInputStream) this).in.available(), this.f9654j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i) {
        ((FilterInputStream) this).in.mark(i);
        this.f9655k = this.f9654j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        if (this.f9654j == 0) {
            return -1;
        }
        int i = ((FilterInputStream) this).in.read();
        if (i != -1) {
            this.f9654j--;
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() throws IOException {
        if (!((FilterInputStream) this).in.markSupported()) {
            throw new IOException("Mark not supported");
        }
        if (this.f9655k == -1) {
            throw new IOException("Mark not set");
        }
        ((FilterInputStream) this).in.reset();
        this.f9654j = this.f9655k;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j) throws IOException {
        long jSkip = ((FilterInputStream) this).in.skip(Math.min(j, this.f9654j));
        this.f9654j -= jSkip;
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.f9654j;
        if (j == 0) {
            return -1;
        }
        int i3 = ((FilterInputStream) this).in.read(bArr, i, (int) Math.min(i2, j));
        if (i3 != -1) {
            this.f9654j -= (long) i3;
        }
        return i3;
    }
}
