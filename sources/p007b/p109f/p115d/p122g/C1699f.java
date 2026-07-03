package p007b.p109f.p115d.p122g;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p115d.p123h.InterfaceC1709f;

/* JADX INFO: renamed from: b.f.d.g.f */
/* JADX INFO: compiled from: PooledByteArrayBufferedInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class C1699f extends InputStream {

    /* JADX INFO: renamed from: j */
    public final InputStream f3108j;

    /* JADX INFO: renamed from: k */
    public final byte[] f3109k;

    /* JADX INFO: renamed from: l */
    public final InterfaceC1709f<byte[]> f3110l;

    /* JADX INFO: renamed from: m */
    public int f3111m;

    /* JADX INFO: renamed from: n */
    public int f3112n;

    /* JADX INFO: renamed from: o */
    public boolean f3113o;

    public C1699f(InputStream inputStream, byte[] bArr, InterfaceC1709f<byte[]> interfaceC1709f) {
        this.f3108j = inputStream;
        Objects.requireNonNull(bArr);
        this.f3109k = bArr;
        Objects.requireNonNull(interfaceC1709f);
        this.f3110l = interfaceC1709f;
        this.f3111m = 0;
        this.f3112n = 0;
        this.f3113o = false;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m991a() throws IOException {
        if (this.f3112n < this.f3111m) {
            return true;
        }
        int i = this.f3108j.read(this.f3109k);
        if (i <= 0) {
            return false;
        }
        this.f3111m = i;
        this.f3112n = 0;
        return true;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        C1460d.m419B(this.f3112n <= this.f3111m);
        m992b();
        return this.f3108j.available() + (this.f3111m - this.f3112n);
    }

    /* JADX INFO: renamed from: b */
    public final void m992b() throws IOException {
        if (this.f3113o) {
            throw new IOException("stream already closed");
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f3113o) {
            return;
        }
        this.f3113o = true;
        this.f3110l.release(this.f3109k);
        super.close();
    }

    public void finalize() throws Throwable {
        if (!this.f3113o) {
            C1691a.m977e("PooledByteInputStream", "Finalized without closing");
            close();
        }
        super.finalize();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        C1460d.m419B(this.f3112n <= this.f3111m);
        m992b();
        if (!m991a()) {
            return -1;
        }
        byte[] bArr = this.f3109k;
        int i = this.f3112n;
        this.f3112n = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        C1460d.m419B(this.f3112n <= this.f3111m);
        m992b();
        int i = this.f3111m;
        int i2 = this.f3112n;
        long j2 = i - i2;
        if (j2 >= j) {
            this.f3112n = (int) (((long) i2) + j);
            return j;
        }
        this.f3112n = i;
        return this.f3108j.skip(j - j2) + j2;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        C1460d.m419B(this.f3112n <= this.f3111m);
        m992b();
        if (!m991a()) {
            return -1;
        }
        int iMin = Math.min(this.f3111m - this.f3112n, i2);
        System.arraycopy(this.f3109k, this.f3112n, bArr, i, iMin);
        this.f3112n += iMin;
        return iMin;
    }
}
