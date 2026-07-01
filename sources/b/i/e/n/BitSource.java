package b.i.e.n;

/* JADX INFO: renamed from: b.i.e.n.c, reason: use source file name */
/* JADX INFO: compiled from: BitSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class BitSource {
    public final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1830b;
    public int c;

    public BitSource(byte[] bArr) {
        this.a = bArr;
    }

    public int a() {
        return ((this.a.length - this.f1830b) * 8) - this.c;
    }

    public int b(int i) {
        if (i <= 0 || i > 32 || i > a()) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        int i2 = this.c;
        int i3 = 0;
        if (i2 > 0) {
            int i4 = 8 - i2;
            int i5 = i < i4 ? i : i4;
            int i6 = i4 - i5;
            byte[] bArr = this.a;
            int i7 = this.f1830b;
            int i8 = (((255 >> (8 - i5)) << i6) & bArr[i7]) >> i6;
            i -= i5;
            int i9 = i2 + i5;
            this.c = i9;
            if (i9 == 8) {
                this.c = 0;
                this.f1830b = i7 + 1;
            }
            i3 = i8;
        }
        if (i <= 0) {
            return i3;
        }
        while (i >= 8) {
            int i10 = i3 << 8;
            byte[] bArr2 = this.a;
            int i11 = this.f1830b;
            i3 = (bArr2[i11] & 255) | i10;
            this.f1830b = i11 + 1;
            i -= 8;
        }
        if (i <= 0) {
            return i3;
        }
        int i12 = 8 - i;
        int i13 = (i3 << i) | ((((255 >> i12) << i12) & this.a[this.f1830b]) >> i12);
        this.c += i;
        return i13;
    }
}
