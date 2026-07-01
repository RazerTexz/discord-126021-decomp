package b.i.a.c.f3;

/* JADX INFO: compiled from: ParsableBitArray.java */
/* JADX INFO: loaded from: classes3.dex */
public final class w {
    public byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f983b;
    public int c;
    public int d;

    public w() {
        this.a = e0.f;
    }

    public final void a() {
        int i;
        int i2 = this.f983b;
        b.c.a.a0.d.D(i2 >= 0 && (i2 < (i = this.d) || (i2 == i && this.c == 0)));
    }

    public int b() {
        return ((this.d - this.f983b) * 8) - this.c;
    }

    public void c() {
        if (this.c == 0) {
            return;
        }
        this.c = 0;
        this.f983b++;
        a();
    }

    public int d() {
        b.c.a.a0.d.D(this.c == 0);
        return this.f983b;
    }

    public int e() {
        return (this.f983b * 8) + this.c;
    }

    public boolean f() {
        boolean z2 = (this.a[this.f983b] & (128 >> this.c)) != 0;
        l();
        return z2;
    }

    public int g(int i) {
        int i2;
        if (i == 0) {
            return 0;
        }
        this.c += i;
        int i3 = 0;
        while (true) {
            i2 = this.c;
            if (i2 <= 8) {
                break;
            }
            int i4 = i2 - 8;
            this.c = i4;
            byte[] bArr = this.a;
            int i5 = this.f983b;
            this.f983b = i5 + 1;
            i3 |= (bArr[i5] & 255) << i4;
        }
        byte[] bArr2 = this.a;
        int i6 = this.f983b;
        int i7 = ((-1) >>> (32 - i)) & (i3 | ((bArr2[i6] & 255) >> (8 - i2)));
        if (i2 == 8) {
            this.c = 0;
            this.f983b = i6 + 1;
        }
        a();
        return i7;
    }

    public void h(byte[] bArr, int i, int i2) {
        int i3 = (i2 >> 3) + i;
        while (i < i3) {
            byte[] bArr2 = this.a;
            int i4 = this.f983b;
            int i5 = i4 + 1;
            this.f983b = i5;
            byte b2 = bArr2[i4];
            int i6 = this.c;
            bArr[i] = (byte) (b2 << i6);
            bArr[i] = (byte) (((255 & bArr2[i5]) >> (8 - i6)) | bArr[i]);
            i++;
        }
        int i7 = i2 & 7;
        if (i7 == 0) {
            return;
        }
        bArr[i3] = (byte) (bArr[i3] & (255 >> i7));
        int i8 = this.c;
        if (i8 + i7 > 8) {
            int i9 = bArr[i3];
            byte[] bArr3 = this.a;
            int i10 = this.f983b;
            this.f983b = i10 + 1;
            bArr[i3] = (byte) (i9 | ((bArr3[i10] & 255) << i8));
            this.c = i8 - 8;
        }
        int i11 = this.c + i7;
        this.c = i11;
        byte[] bArr4 = this.a;
        int i12 = this.f983b;
        bArr[i3] = (byte) (((byte) (((255 & bArr4[i12]) >> (8 - i11)) << (8 - i7))) | bArr[i3]);
        if (i11 == 8) {
            this.c = 0;
            this.f983b = i12 + 1;
        }
        a();
    }

    public void i(byte[] bArr, int i, int i2) {
        b.c.a.a0.d.D(this.c == 0);
        System.arraycopy(this.a, this.f983b, bArr, i, i2);
        this.f983b += i2;
        a();
    }

    public void j(byte[] bArr, int i) {
        this.a = bArr;
        this.f983b = 0;
        this.c = 0;
        this.d = i;
    }

    public void k(int i) {
        int i2 = i / 8;
        this.f983b = i2;
        this.c = i - (i2 * 8);
        a();
    }

    public void l() {
        int i = this.c + 1;
        this.c = i;
        if (i == 8) {
            this.c = 0;
            this.f983b++;
        }
        a();
    }

    public void m(int i) {
        int i2 = i / 8;
        int i3 = this.f983b + i2;
        this.f983b = i3;
        int i4 = (i - (i2 * 8)) + this.c;
        this.c = i4;
        if (i4 > 7) {
            this.f983b = i3 + 1;
            this.c = i4 - 8;
        }
        a();
    }

    public void n(int i) {
        b.c.a.a0.d.D(this.c == 0);
        this.f983b += i;
        a();
    }

    public w(byte[] bArr) {
        int length = bArr.length;
        this.a = bArr;
        this.d = length;
    }

    public w(byte[] bArr, int i) {
        this.a = bArr;
        this.d = i;
    }
}
