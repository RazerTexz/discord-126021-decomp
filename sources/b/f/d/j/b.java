package b.f.d.j;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: TailAppendingInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends FilterInputStream {
    public final byte[] j;
    public int k;
    public int l;

    public b(InputStream inputStream, byte[] bArr) {
        super(inputStream);
        this.j = bArr;
    }

    public final int a() {
        int i = this.k;
        byte[] bArr = this.j;
        if (i >= bArr.length) {
            return -1;
        }
        this.k = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        if (((FilterInputStream) this).in.markSupported()) {
            super.mark(i);
            this.l = this.k;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i = ((FilterInputStream) this).in.read();
        return i != -1 ? i : a();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        if (!((FilterInputStream) this).in.markSupported()) {
            throw new IOException("mark is not supported");
        }
        ((FilterInputStream) this).in.reset();
        this.k = this.l;
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
            int iA = a();
            if (iA == -1) {
                break;
            }
            bArr[i + i4] = (byte) iA;
            i4++;
        }
        if (i4 > 0) {
            return i4;
        }
        return -1;
    }
}
