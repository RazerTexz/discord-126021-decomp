package d0.e0.p.d.m0.i;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: AbstractMessageLite.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$a$a extends FilterInputStream {
    public int j;

    public a$a$a(InputStream inputStream, int i) {
        super(inputStream);
        this.j = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return Math.min(super.available(), this.j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.j <= 0) {
            return -1;
        }
        int i = super.read();
        if (i >= 0) {
            this.j--;
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long jSkip = super.skip(Math.min(j, this.j));
        if (jSkip >= 0) {
            this.j = (int) (((long) this.j) - jSkip);
        }
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.j;
        if (i3 <= 0) {
            return -1;
        }
        int i4 = super.read(bArr, i, Math.min(i2, i3));
        if (i4 >= 0) {
            this.j -= i4;
        }
        return i4;
    }
}
