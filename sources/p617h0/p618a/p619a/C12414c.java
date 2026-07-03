package p617h0.p618a.p619a;

import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: h0.a.a.c */
/* JADX INFO: compiled from: ByteVector.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12414c {

    /* JADX INFO: renamed from: a */
    public byte[] f26153a;

    /* JADX INFO: renamed from: b */
    public int f26154b;

    public C12414c() {
        this.f26153a = new byte[64];
    }

    /* JADX INFO: renamed from: a */
    public final C12414c m10529a(String str, int i, int i2) {
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
        int i6 = this.f26154b;
        int i7 = (i6 - i) - 2;
        if (i7 >= 0) {
            byte[] bArr = this.f26153a;
            bArr[i7] = (byte) (i5 >>> 8);
            bArr[i7 + 1] = (byte) i5;
        }
        if ((i6 + i5) - i > this.f26153a.length) {
            m10530b(i5 - i);
        }
        int i8 = this.f26154b;
        while (i < length) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 < 1 || cCharAt2 > 127) {
                if (cCharAt2 <= 2047) {
                    byte[] bArr2 = this.f26153a;
                    int i9 = i8 + 1;
                    bArr2[i8] = (byte) (((cCharAt2 >> 6) & 31) | Opcodes.CHECKCAST);
                    i8 = i9 + 1;
                    bArr2[i9] = (byte) ((cCharAt2 & '?') | 128);
                } else {
                    byte[] bArr3 = this.f26153a;
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
                this.f26153a[i8] = (byte) cCharAt2;
            }
            i8 = i3;
            i++;
        }
        this.f26154b = i8;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public final void m10530b(int i) {
        byte[] bArr = this.f26153a;
        int length = bArr.length * 2;
        int i2 = this.f26154b;
        int i3 = i + i2;
        if (length <= i3) {
            length = i3;
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        this.f26153a = bArr2;
    }

    /* JADX INFO: renamed from: c */
    public final C12414c m10531c(int i, int i2) {
        int i3 = this.f26154b;
        if (i3 + 2 > this.f26153a.length) {
            m10530b(2);
        }
        byte[] bArr = this.f26153a;
        int i4 = i3 + 1;
        bArr[i3] = (byte) i;
        bArr[i4] = (byte) i2;
        this.f26154b = i4 + 1;
        return this;
    }

    /* JADX INFO: renamed from: d */
    public final C12414c m10532d(int i, int i2, int i3) {
        int i4 = this.f26154b;
        if (i4 + 4 > this.f26153a.length) {
            m10530b(4);
        }
        byte[] bArr = this.f26153a;
        int i5 = i4 + 1;
        bArr[i4] = (byte) i;
        int i6 = i5 + 1;
        bArr[i5] = (byte) i2;
        int i7 = i6 + 1;
        bArr[i6] = (byte) (i3 >>> 8);
        bArr[i7] = (byte) i3;
        this.f26154b = i7 + 1;
        return this;
    }

    /* JADX INFO: renamed from: e */
    public final C12414c m10533e(int i, int i2) {
        int i3 = this.f26154b;
        if (i3 + 3 > this.f26153a.length) {
            m10530b(3);
        }
        byte[] bArr = this.f26153a;
        int i4 = i3 + 1;
        bArr[i3] = (byte) i;
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i2 >>> 8);
        bArr[i5] = (byte) i2;
        this.f26154b = i5 + 1;
        return this;
    }

    /* JADX INFO: renamed from: f */
    public final C12414c m10534f(int i, int i2, int i3) {
        int i4 = this.f26154b;
        if (i4 + 5 > this.f26153a.length) {
            m10530b(5);
        }
        byte[] bArr = this.f26153a;
        int i5 = i4 + 1;
        bArr[i4] = (byte) i;
        int i6 = i5 + 1;
        bArr[i5] = (byte) (i2 >>> 8);
        int i7 = i6 + 1;
        bArr[i6] = (byte) i2;
        int i8 = i7 + 1;
        bArr[i7] = (byte) (i3 >>> 8);
        bArr[i8] = (byte) i3;
        this.f26154b = i8 + 1;
        return this;
    }

    /* JADX INFO: renamed from: g */
    public C12414c m10535g(int i) {
        int i2 = this.f26154b;
        int i3 = i2 + 1;
        if (i3 > this.f26153a.length) {
            m10530b(1);
        }
        this.f26153a[i2] = (byte) i;
        this.f26154b = i3;
        return this;
    }

    /* JADX INFO: renamed from: h */
    public C12414c m10536h(byte[] bArr, int i, int i2) {
        if (this.f26154b + i2 > this.f26153a.length) {
            m10530b(i2);
        }
        if (bArr != null) {
            System.arraycopy(bArr, i, this.f26153a, this.f26154b, i2);
        }
        this.f26154b += i2;
        return this;
    }

    /* JADX INFO: renamed from: i */
    public C12414c m10537i(int i) {
        int i2 = this.f26154b;
        if (i2 + 4 > this.f26153a.length) {
            m10530b(4);
        }
        byte[] bArr = this.f26153a;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 24);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i >>> 16);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i >>> 8);
        bArr[i5] = (byte) i;
        this.f26154b = i5 + 1;
        return this;
    }

    /* JADX INFO: renamed from: j */
    public C12414c m10538j(int i) {
        int i2 = this.f26154b;
        if (i2 + 2 > this.f26153a.length) {
            m10530b(2);
        }
        byte[] bArr = this.f26153a;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >>> 8);
        bArr[i3] = (byte) i;
        this.f26154b = i3 + 1;
        return this;
    }

    public C12414c(int i) {
        this.f26153a = new byte[i];
    }
}
