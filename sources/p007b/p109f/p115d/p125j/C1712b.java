package p007b.p109f.p115d.p125j;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: b.f.d.j.b */
/* JADX INFO: compiled from: TailAppendingInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class C1712b extends FilterInputStream {

    /* JADX INFO: renamed from: j */
    public final byte[] f3130j;

    /* JADX INFO: renamed from: k */
    public int f3131k;

    /* JADX INFO: renamed from: l */
    public int f3132l;

    public C1712b(InputStream inputStream, byte[] bArr) {
        super(inputStream);
        this.f3130j = bArr;
    }

    /* JADX INFO: renamed from: a */
    public final int m1003a() {
        int i = this.f3131k;
        byte[] bArr = this.f3130j;
        if (i >= bArr.length) {
            return -1;
        }
        this.f3131k = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        if (((FilterInputStream) this).in.markSupported()) {
            super.mark(i);
            this.f3132l = this.f3131k;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i = ((FilterInputStream) this).in.read();
        return i != -1 ? i : m1003a();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        if (!((FilterInputStream) this).in.markSupported()) {
            throw new IOException("mark is not supported");
        }
        ((FilterInputStream) this).in.reset();
        this.f3131k = this.f3132l;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = ((FilterInputStream) this).in.read(bArr, i, i2);
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        if (i2 == 0) {
            return 0;
        }
        while (i4 < i2) {
            int iM1003a = m1003a();
            if (iM1003a == -1) {
                break;
            }
            bArr[i + i4] = (byte) iM1003a;
            i4++;
        }
        if (i4 > 0) {
            return i4;
        }
        return -1;
    }
}
