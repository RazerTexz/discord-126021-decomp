package b.i.a.c.f3;

import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.b.a.Charsets;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: renamed from: b.i.a.c.f3.x, reason: use source file name */
/* JADX INFO: compiled from: ParsableByteArray.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ParsableByteArray {
    public byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f984b;
    public int c;

    public ParsableByteArray() {
        this.a = Util2.f;
    }

    public void A(int i) {
        byte[] bArr = this.a;
        if (bArr.length < i) {
            bArr = new byte[i];
        }
        C(bArr, i);
    }

    public void B(byte[] bArr) {
        int length = bArr.length;
        this.a = bArr;
        this.c = length;
        this.f984b = 0;
    }

    public void C(byte[] bArr, int i) {
        this.a = bArr;
        this.c = i;
        this.f984b = 0;
    }

    public void D(int i) {
        AnimatableValueParser.j(i >= 0 && i <= this.a.length);
        this.c = i;
    }

    public void E(int i) {
        AnimatableValueParser.j(i >= 0 && i <= this.c);
        this.f984b = i;
    }

    public void F(int i) {
        E(this.f984b + i);
    }

    public int a() {
        return this.c - this.f984b;
    }

    public void b(int i) {
        byte[] bArr = this.a;
        if (i > bArr.length) {
            this.a = Arrays.copyOf(bArr, i);
        }
    }

    public int c() {
        return this.a[this.f984b] & 255;
    }

    public void d(ParsableBitArray parsableBitArray, int i) {
        e(parsableBitArray.a, 0, i);
        parsableBitArray.k(0);
    }

    public void e(byte[] bArr, int i, int i2) {
        System.arraycopy(this.a, this.f984b, bArr, i, i2);
        this.f984b += i2;
    }

    public int f() {
        byte[] bArr = this.a;
        int i = this.f984b;
        int i2 = i + 1;
        this.f984b = i2;
        int i3 = (bArr[i] & 255) << 24;
        int i4 = i2 + 1;
        this.f984b = i4;
        int i5 = i3 | ((bArr[i2] & 255) << 16);
        int i6 = i4 + 1;
        this.f984b = i6;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        this.f984b = i6 + 1;
        return (bArr[i6] & 255) | i7;
    }

    @Nullable
    public String g() {
        if (a() == 0) {
            return null;
        }
        int i = this.f984b;
        while (i < this.c) {
            byte b2 = this.a[i];
            int i2 = Util2.a;
            if (b2 == 10 || b2 == 13) {
                break;
            }
            i++;
        }
        int i3 = this.f984b;
        if (i - i3 >= 3) {
            byte[] bArr = this.a;
            if (bArr[i3] == -17 && bArr[i3 + 1] == -69 && bArr[i3 + 2] == -65) {
                this.f984b = i3 + 3;
            }
        }
        byte[] bArr2 = this.a;
        int i4 = this.f984b;
        String strM = Util2.m(bArr2, i4, i - i4);
        this.f984b = i;
        int i5 = this.c;
        if (i == i5) {
            return strM;
        }
        byte[] bArr3 = this.a;
        if (bArr3[i] == 13) {
            int i6 = i + 1;
            this.f984b = i6;
            if (i6 == i5) {
                return strM;
            }
        }
        int i7 = this.f984b;
        if (bArr3[i7] == 10) {
            this.f984b = i7 + 1;
        }
        return strM;
    }

    public int h() {
        byte[] bArr = this.a;
        int i = this.f984b;
        int i2 = i + 1;
        this.f984b = i2;
        int i3 = bArr[i] & 255;
        int i4 = i2 + 1;
        this.f984b = i4;
        int i5 = i3 | ((bArr[i2] & 255) << 8);
        int i6 = i4 + 1;
        this.f984b = i6;
        int i7 = i5 | ((bArr[i4] & 255) << 16);
        this.f984b = i6 + 1;
        return ((bArr[i6] & 255) << 24) | i7;
    }

    public short i() {
        byte[] bArr = this.a;
        int i = this.f984b;
        int i2 = i + 1;
        this.f984b = i2;
        int i3 = bArr[i] & 255;
        this.f984b = i2 + 1;
        return (short) (((bArr[i2] & 255) << 8) | i3);
    }

    public long j() {
        byte[] bArr = this.a;
        int i = this.f984b;
        int i2 = i + 1;
        this.f984b = i2;
        long j = ((long) bArr[i]) & 255;
        int i3 = i2 + 1;
        this.f984b = i3;
        long j2 = j | ((((long) bArr[i2]) & 255) << 8);
        int i4 = i3 + 1;
        this.f984b = i4;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 16);
        this.f984b = i4 + 1;
        return j3 | ((((long) bArr[i4]) & 255) << 24);
    }

    public int k() {
        int iH = h();
        if (iH >= 0) {
            return iH;
        }
        throw new IllegalStateException(outline.g(29, "Top bit not zero: ", iH));
    }

    public int l() {
        byte[] bArr = this.a;
        int i = this.f984b;
        int i2 = i + 1;
        this.f984b = i2;
        int i3 = bArr[i] & 255;
        this.f984b = i2 + 1;
        return ((bArr[i2] & 255) << 8) | i3;
    }

    public long m() {
        byte[] bArr = this.a;
        int i = this.f984b;
        int i2 = i + 1;
        this.f984b = i2;
        long j = (((long) bArr[i]) & 255) << 56;
        int i3 = i2 + 1;
        this.f984b = i3;
        long j2 = j | ((((long) bArr[i2]) & 255) << 48);
        int i4 = i3 + 1;
        this.f984b = i4;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 40);
        int i5 = i4 + 1;
        this.f984b = i5;
        long j4 = j3 | ((((long) bArr[i4]) & 255) << 32);
        int i6 = i5 + 1;
        this.f984b = i6;
        long j5 = j4 | ((((long) bArr[i5]) & 255) << 24);
        int i7 = i6 + 1;
        this.f984b = i7;
        long j6 = j5 | ((((long) bArr[i6]) & 255) << 16);
        int i8 = i7 + 1;
        this.f984b = i8;
        long j7 = j6 | ((((long) bArr[i7]) & 255) << 8);
        this.f984b = i8 + 1;
        return j7 | (((long) bArr[i8]) & 255);
    }

    @Nullable
    public String n() {
        if (a() == 0) {
            return null;
        }
        int i = this.f984b;
        while (i < this.c && this.a[i] != 0) {
            i++;
        }
        byte[] bArr = this.a;
        int i2 = this.f984b;
        String strM = Util2.m(bArr, i2, i - i2);
        this.f984b = i;
        if (i < this.c) {
            this.f984b = i + 1;
        }
        return strM;
    }

    public String o(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = this.f984b;
        int i3 = (i2 + i) - 1;
        String strM = Util2.m(this.a, i2, (i3 >= this.c || this.a[i3] != 0) ? i : i - 1);
        this.f984b += i;
        return strM;
    }

    public short p() {
        byte[] bArr = this.a;
        int i = this.f984b;
        int i2 = i + 1;
        this.f984b = i2;
        int i3 = (bArr[i] & 255) << 8;
        this.f984b = i2 + 1;
        return (short) ((bArr[i2] & 255) | i3);
    }

    public String q(int i) {
        return r(i, Charsets.c);
    }

    public String r(int i, Charset charset) {
        String str = new String(this.a, this.f984b, i, charset);
        this.f984b += i;
        return str;
    }

    public int s() {
        return (t() << 21) | (t() << 14) | (t() << 7) | t();
    }

    public int t() {
        byte[] bArr = this.a;
        int i = this.f984b;
        this.f984b = i + 1;
        return bArr[i] & 255;
    }

    public long u() {
        byte[] bArr = this.a;
        int i = this.f984b;
        int i2 = i + 1;
        this.f984b = i2;
        long j = (((long) bArr[i]) & 255) << 24;
        int i3 = i2 + 1;
        this.f984b = i3;
        long j2 = j | ((((long) bArr[i2]) & 255) << 16);
        int i4 = i3 + 1;
        this.f984b = i4;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 8);
        this.f984b = i4 + 1;
        return j3 | (((long) bArr[i4]) & 255);
    }

    public int v() {
        byte[] bArr = this.a;
        int i = this.f984b;
        int i2 = i + 1;
        this.f984b = i2;
        int i3 = (bArr[i] & 255) << 16;
        int i4 = i2 + 1;
        this.f984b = i4;
        int i5 = i3 | ((bArr[i2] & 255) << 8);
        this.f984b = i4 + 1;
        return (bArr[i4] & 255) | i5;
    }

    public int w() {
        int iF = f();
        if (iF >= 0) {
            return iF;
        }
        throw new IllegalStateException(outline.g(29, "Top bit not zero: ", iF));
    }

    public long x() {
        long jM = m();
        if (jM >= 0) {
            return jM;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("Top bit not zero: ");
        sb.append(jM);
        throw new IllegalStateException(sb.toString());
    }

    public int y() {
        byte[] bArr = this.a;
        int i = this.f984b;
        int i2 = i + 1;
        this.f984b = i2;
        int i3 = (bArr[i] & 255) << 8;
        this.f984b = i2 + 1;
        return (bArr[i2] & 255) | i3;
    }

    public long z() {
        int i;
        int i2;
        long j = this.a[this.f984b];
        int i3 = 7;
        while (true) {
            if (i3 >= 0) {
                int i4 = 1 << i3;
                if ((((long) i4) & j) == 0) {
                    if (i3 < 6) {
                        j &= (long) (i4 - 1);
                        i2 = 7 - i3;
                        break;
                    }
                    if (i3 == 7) {
                        i2 = 1;
                        break;
                    }
                } else {
                    i3--;
                }
            }
            i2 = 0;
            break;
        }
        if (i2 == 0) {
            StringBuilder sb = new StringBuilder(55);
            sb.append("Invalid UTF-8 sequence first byte: ");
            sb.append(j);
            throw new NumberFormatException(sb.toString());
        }
        for (i = 1; i < i2; i++) {
            byte b2 = this.a[this.f984b + i];
            if ((b2 & 192) != 128) {
                StringBuilder sb2 = new StringBuilder(62);
                sb2.append("Invalid UTF-8 sequence continuation byte: ");
                sb2.append(j);
                throw new NumberFormatException(sb2.toString());
            }
            j = (j << 6) | ((long) (b2 & 63));
        }
        this.f984b += i2;
        return j;
    }

    public ParsableByteArray(int i) {
        this.a = new byte[i];
        this.c = i;
    }

    public ParsableByteArray(byte[] bArr) {
        this.a = bArr;
        this.c = bArr.length;
    }

    public ParsableByteArray(byte[] bArr, int i) {
        this.a = bArr;
        this.c = i;
    }
}
