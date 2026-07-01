package b.i.a.c.f3;

/* JADX INFO: compiled from: ParsableNalUnitBitArray.java */
/* JADX INFO: loaded from: classes3.dex */
public final class y {
    public byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f985b;
    public int c;
    public int d = 0;

    public y(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.c = i;
        this.f985b = i2;
        a();
    }

    public final void a() {
        int i;
        int i2 = this.c;
        b.c.a.a0.d.D(i2 >= 0 && (i2 < (i = this.f985b) || (i2 == i && this.d == 0)));
    }

    public boolean b(int i) {
        int i2 = this.c;
        int i3 = i / 8;
        int i4 = i2 + i3;
        int i5 = (this.d + i) - (i3 * 8);
        if (i5 > 7) {
            i4++;
            i5 -= 8;
        }
        while (true) {
            i2++;
            if (i2 > i4 || i4 >= this.f985b) {
                break;
            }
            if (h(i2)) {
                i4++;
                i2 += 2;
            }
        }
        int i6 = this.f985b;
        if (i4 >= i6) {
            return i4 == i6 && i5 == 0;
        }
        return true;
    }

    public boolean c() {
        int i = this.c;
        int i2 = this.d;
        int i3 = 0;
        while (this.c < this.f985b && !d()) {
            i3++;
        }
        boolean z2 = this.c == this.f985b;
        this.c = i;
        this.d = i2;
        return !z2 && b((i3 * 2) + 1);
    }

    public boolean d() {
        boolean z2 = (this.a[this.c] & (128 >> this.d)) != 0;
        i();
        return z2;
    }

    public int e(int i) {
        int i2;
        this.d += i;
        int i3 = 0;
        while (true) {
            i2 = this.d;
            int i4 = 2;
            if (i2 <= 8) {
                break;
            }
            int i5 = i2 - 8;
            this.d = i5;
            byte[] bArr = this.a;
            int i6 = this.c;
            i3 |= (bArr[i6] & 255) << i5;
            if (!h(i6 + 1)) {
                i4 = 1;
            }
            this.c = i6 + i4;
        }
        byte[] bArr2 = this.a;
        int i7 = this.c;
        int i8 = ((-1) >>> (32 - i)) & (i3 | ((bArr2[i7] & 255) >> (8 - i2)));
        if (i2 == 8) {
            this.d = 0;
            this.c = i7 + (h(i7 + 1) ? 2 : 1);
        }
        a();
        return i8;
    }

    public final int f() {
        int i = 0;
        while (!d()) {
            i++;
        }
        return ((1 << i) - 1) + (i > 0 ? e(i) : 0);
    }

    public int g() {
        int iF = f();
        return ((iF + 1) / 2) * (iF % 2 == 0 ? -1 : 1);
    }

    public final boolean h(int i) {
        if (2 <= i && i < this.f985b) {
            byte[] bArr = this.a;
            if (bArr[i] == 3 && bArr[i - 2] == 0 && bArr[i - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    public void i() {
        int i = this.d + 1;
        this.d = i;
        if (i == 8) {
            this.d = 0;
            int i2 = this.c;
            this.c = i2 + (h(i2 + 1) ? 2 : 1);
        }
        a();
    }

    public void j(int i) {
        int i2 = this.c;
        int i3 = i / 8;
        int i4 = i2 + i3;
        this.c = i4;
        int i5 = (i - (i3 * 8)) + this.d;
        this.d = i5;
        if (i5 > 7) {
            this.c = i4 + 1;
            this.d = i5 - 8;
        }
        while (true) {
            i2++;
            if (i2 > this.c) {
                a();
                return;
            } else if (h(i2)) {
                this.c++;
                i2 += 2;
            }
        }
    }
}
