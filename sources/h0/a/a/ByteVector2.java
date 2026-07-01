package h0.a.a;

import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: h0.a.a.c, reason: use source file name */
/* JADX INFO: compiled from: ByteVector.java */
/* JADX INFO: loaded from: classes3.dex */
public class ByteVector2 {
    public byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3699b;

    public ByteVector2() {
        this.a = new byte[64];
    }

    public final ByteVector2 a(String str, int i, int i2) {
        int i3;
        int length = str.length();
        int i4 = i;
        int i5 = i4;
        while (i4 < length) {
            char cCharAt = str.charAt(i4);
            if (cCharAt < 1 || cCharAt > 127) {
                i5 = cCharAt <= 2047 ? i5 + 2 : i5 + 3;
            } else {
                i5++;
            }
            i4++;
        }
        if (i5 > i2) {
            throw new IllegalArgumentException("UTF8 string too large");
        }
        int i6 = this.f3699b;
        int i7 = (i6 - i) - 2;
        if (i7 >= 0) {
            byte[] bArr = this.a;
            bArr[i7] = (byte) (i5 >>> 8);
            bArr[i7 + 1] = (byte) i5;
        }
        if ((i6 + i5) - i > this.a.length) {
            b(i5 - i);
        }
        int i8 = this.f3699b;
        while (i < length) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 < 1 || cCharAt2 > 127) {
                if (cCharAt2 <= 2047) {
                    byte[] bArr2 = this.a;
                    int i9 = i8 + 1;
                    bArr2[i8] = (byte) (((cCharAt2 >> 6) & 31) | Opcodes.CHECKCAST);
                    i8 = i9 + 1;
                    bArr2[i9] = (byte) ((cCharAt2 & '?') | 128);
                } else {
                    byte[] bArr3 = this.a;
                    int i10 = i8 + 1;
                    bArr3[i8] = (byte) (((cCharAt2 >> '\f') & 15) | 224);
                    int i11 = i10 + 1;
                    bArr3[i10] = (byte) (((cCharAt2 >> 6) & 63) | 128);
                    i3 = i11 + 1;
                    bArr3[i11] = (byte) ((cCharAt2 & '?') | 128);
                }
                i++;
            } else {
                i3 = i8 + 1;
                this.a[i8] = (byte) cCharAt2;
            }
            i8 = i3;
            i++;
        }
        this.f3699b = i8;
        return this;
    }

    public final void b(int i) {
        byte[] bArr = this.a;
        int length = bArr.length * 2;
        int i2 = this.f3699b;
        int i3 = i + i2;
        if (length <= i3) {
            length = i3;
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        this.a = bArr2;
    }

    public final ByteVector2 c(int i, int i2) {
        int i3 = this.f3699b;
        if (i3 + 2 > this.a.length) {
            b(2);
        }
        byte[] bArr = this.a;
        int i4 = i3 + 1;
        bArr[i3] = (byte) i;
        bArr[i4] = (byte) i2;
        this.f3699b = i4 + 1;
        return this;
    }

    public final ByteVector2 d(int i, int i2, int i3) {
        int i4 = this.f3699b;
        if (i4 + 4 > this.a.length) {
            b(4);
        }
        byte[] bArr = this.a;
        int i5 = i4 + 1;
        bArr[i4] = (byte) i;
        int i6 = i5 + 1;
        bArr[i5] = (byte) i2;
        int i7 = i6 + 1;
        bArr[i6] = (byte) (i3 >>> 8);
        bArr[i7] = (byte) i3;
        this.f3699b = i7 + 1;
        return this;
    }

    public final ByteVector2 e(int i, int i2) {
        int i3 = this.f3699b;
        if (i3 + 3 > this.a.length) {
            b(3);
        }
        byte[] bArr = this.a;
        int i4 = i3 + 1;
        bArr[i3] = (byte) i;
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i2 >>> 8);
        bArr[i5] = (byte) i2;
        this.f3699b = i5 + 1;
        return this;
    }

    public final ByteVector2 f(int i, int i2, int i3) {
        int i4 = this.f3699b;
        if (i4 + 5 > this.a.length) {
            b(5);
        }
        byte[] bArr = this.a;
        int i5 = i4 + 1;
        bArr[i4] = (byte) i;
        int i6 = i5 + 1;
        bArr[i5] = (byte) (i2 >>> 8);
        int i7 = i6 + 1;
        bArr[i6] = (byte) i2;
        int i8 = i7 + 1;
        bArr[i7] = (byte) (i3 >>> 8);
        bArr[i8] = (byte) i3;
        this.f3699b = i8 + 1;
        return this;
    }

    public ByteVector2 g(int i) {
        int i2 = this.f3699b;
        int i3 = i2 + 1;
        if (i3 > this.a.length) {
            b(1);
        }
        this.a[i2] = (byte) i;
        this.f3699b = i3;
        return this;
    }

    public ByteVector2 h(byte[] bArr, int i, int i2) {
        if (this.f3699b + i2 > this.a.length) {
            b(i2);
        }
        if (bArr != null) {
            System.arraycopy(bArr, i, this.a, this.f3699b, i2);
        }
        this.f3699b += i2;
        return this;
    }

    public ByteVector2 i(int i) {
        int i2 = this.f3699b;
        if (i2 + 4 > this.a.length) {
            b(4);
        }
        byte[] bArr = this.a;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 24);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i >>> 16);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i >>> 8);
        bArr[i5] = (byte) i;
        this.f3699b = i5 + 1;
        return this;
    }

    public ByteVector2 j(int i) {
        int i2 = this.f3699b;
        if (i2 + 2 > this.a.length) {
            b(2);
        }
        byte[] bArr = this.a;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 8);
        bArr[i3] = (byte) i;
        this.f3699b = i3 + 1;
        return this;
    }

    public ByteVector2(int i) {
        this.a = new byte[i];
    }
}
