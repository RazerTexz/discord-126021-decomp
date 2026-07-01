package b.f.d.g;

import b.c.a.a0.AnimatableValueParser;
import b.f.d.e.FLog;
import b.f.d.h.ResourceReleaser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.d.g.f, reason: use source file name */
/* JADX INFO: compiled from: PooledByteArrayBufferedInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class PooledByteArrayBufferedInputStream extends InputStream {
    public final InputStream j;
    public final byte[] k;
    public final ResourceReleaser<byte[]> l;
    public int m;
    public int n;
    public boolean o;

    public PooledByteArrayBufferedInputStream(InputStream inputStream, byte[] bArr, ResourceReleaser<byte[]> resourceReleaser) {
        this.j = inputStream;
        Objects.requireNonNull(bArr);
        this.k = bArr;
        Objects.requireNonNull(resourceReleaser);
        this.l = resourceReleaser;
        this.m = 0;
        this.n = 0;
        this.o = false;
    }

    public final boolean a() throws IOException {
        if (this.n < this.m) {
            return true;
        }
        int i = this.j.read(this.k);
        if (i <= 0) {
            return false;
        }
        this.m = i;
        this.n = 0;
        return true;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        AnimatableValueParser.B(this.n <= this.m);
        b();
        return this.j.available() + (this.m - this.n);
    }

    public final void b() throws IOException {
        if (this.o) {
            throw new IOException("stream already closed");
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.o) {
            return;
        }
        this.o = true;
        this.l.release(this.k);
        super.close();
    }

    public void finalize() throws Throwable {
        if (!this.o) {
            FLog.e("PooledByteInputStream", "Finalized without closing");
            close();
        }
        super.finalize();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        AnimatableValueParser.B(this.n <= this.m);
        b();
        if (!a()) {
            return -1;
        }
        byte[] bArr = this.k;
        int i = this.n;
        this.n = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        AnimatableValueParser.B(this.n <= this.m);
        b();
        int i = this.m;
        int i2 = this.n;
        long j2 = i - i2;
        if (j2 >= j) {
            this.n = (int) (((long) i2) + j);
            return j;
        }
        this.n = i;
        return this.j.skip(j - j2) + j2;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        AnimatableValueParser.B(this.n <= this.m);
        b();
        if (!a()) {
            return -1;
        }
        int iMin = Math.min(this.m - this.n, i2);
        System.arraycopy(this.k, this.n, bArr, i, iMin);
        this.n += iMin;
        return iMin;
    }
}
