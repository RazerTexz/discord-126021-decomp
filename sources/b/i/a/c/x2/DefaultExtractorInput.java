package b.i.a.c.x2;

import b.i.a.c.ExoPlayerLibraryInfo;
import b.i.a.c.e3.DataReader;
import b.i.a.c.f3.Util2;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* JADX INFO: renamed from: b.i.a.c.x2.e, reason: use source file name */
/* JADX INFO: compiled from: DefaultExtractorInput.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultExtractorInput implements ExtractorInput {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataReader f1170b;
    public final long c;
    public long d;
    public int f;
    public int g;
    public byte[] e = new byte[65536];
    public final byte[] a = new byte[4096];

    static {
        ExoPlayerLibraryInfo.a("goog.exo.extractor");
    }

    public DefaultExtractorInput(DataReader dataReader, long j, long j2) {
        this.f1170b = dataReader;
        this.d = j;
        this.c = j2;
    }

    @Override // b.i.a.c.x2.ExtractorInput
    public long b() {
        return this.c;
    }

    @Override // b.i.a.c.x2.ExtractorInput
    public boolean c(byte[] bArr, int i, int i2, boolean z2) throws IOException {
        int iMin;
        int i3 = this.g;
        if (i3 == 0) {
            iMin = 0;
        } else {
            iMin = Math.min(i3, i2);
            System.arraycopy(this.e, 0, bArr, i, iMin);
            s(iMin);
        }
        int iR = iMin;
        while (iR < i2 && iR != -1) {
            iR = r(bArr, i, i2, iR, z2);
        }
        p(iR);
        return iR != -1;
    }

    @Override // b.i.a.c.x2.ExtractorInput
    public boolean e(byte[] bArr, int i, int i2, boolean z2) throws IOException {
        if (!m(i2, z2)) {
            return false;
        }
        System.arraycopy(this.e, this.f - i2, bArr, i, i2);
        return true;
    }

    @Override // b.i.a.c.x2.ExtractorInput
    public long f() {
        return this.d + ((long) this.f);
    }

    @Override // b.i.a.c.x2.ExtractorInput
    public void g(int i) throws IOException {
        m(i, false);
    }

    @Override // b.i.a.c.x2.ExtractorInput
    public long getPosition() {
        return this.d;
    }

    @Override // b.i.a.c.x2.ExtractorInput
    public int h(int i) throws IOException {
        int iMin = Math.min(this.g, i);
        s(iMin);
        if (iMin == 0) {
            byte[] bArr = this.a;
            iMin = r(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        p(iMin);
        return iMin;
    }

    @Override // b.i.a.c.x2.ExtractorInput
    public int i(byte[] bArr, int i, int i2) throws IOException {
        int iMin;
        q(i2);
        int i3 = this.g;
        int i4 = this.f;
        int i5 = i3 - i4;
        if (i5 == 0) {
            iMin = r(this.e, i4, i2, 0, true);
            if (iMin == -1) {
                return -1;
            }
            this.g += iMin;
        } else {
            iMin = Math.min(i2, i5);
        }
        System.arraycopy(this.e, this.f, bArr, i, iMin);
        this.f += iMin;
        return iMin;
    }

    @Override // b.i.a.c.x2.ExtractorInput
    public void k() {
        this.f = 0;
    }

    @Override // b.i.a.c.x2.ExtractorInput
    public void l(int i) throws IOException {
        int iMin = Math.min(this.g, i);
        s(iMin);
        int iR = iMin;
        while (iR < i && iR != -1) {
            iR = r(this.a, -iR, Math.min(i, this.a.length + iR), iR, false);
        }
        p(iR);
    }

    @Override // b.i.a.c.x2.ExtractorInput
    public boolean m(int i, boolean z2) throws IOException {
        q(i);
        int iR = this.g - this.f;
        while (iR < i) {
            iR = r(this.e, this.f, i, iR, z2);
            if (iR == -1) {
                return false;
            }
            this.g = this.f + iR;
        }
        this.f += i;
        return true;
    }

    @Override // b.i.a.c.x2.ExtractorInput
    public void o(byte[] bArr, int i, int i2) throws IOException {
        e(bArr, i, i2, false);
    }

    public final void p(int i) {
        if (i != -1) {
            this.d += (long) i;
        }
    }

    public final void q(int i) {
        int i2 = this.f + i;
        byte[] bArr = this.e;
        if (i2 > bArr.length) {
            this.e = Arrays.copyOf(this.e, Util2.h(bArr.length * 2, 65536 + i2, i2 + 524288));
        }
    }

    public final int r(byte[] bArr, int i, int i2, int i3, boolean z2) throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int i4 = this.f1170b.read(bArr, i + i3, i2 - i3);
        if (i4 != -1) {
            return i3 + i4;
        }
        if (i3 == 0 && z2) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // b.i.a.c.x2.ExtractorInput, b.i.a.c.e3.DataReader
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.g;
        int iR = 0;
        if (i3 != 0) {
            int iMin = Math.min(i3, i2);
            System.arraycopy(this.e, 0, bArr, i, iMin);
            s(iMin);
            iR = iMin;
        }
        if (iR == 0) {
            iR = r(bArr, i, i2, 0, true);
        }
        p(iR);
        return iR;
    }

    @Override // b.i.a.c.x2.ExtractorInput
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        c(bArr, i, i2, false);
    }

    public final void s(int i) {
        int i2 = this.g - i;
        this.g = i2;
        this.f = 0;
        byte[] bArr = this.e;
        byte[] bArr2 = i2 < bArr.length - 524288 ? new byte[65536 + i2] : bArr;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        this.e = bArr2;
    }
}
