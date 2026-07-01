package b.i.a.c.x2;

/* JADX INFO: compiled from: VorbisBitArray.java */
/* JADX INFO: loaded from: classes3.dex */
public final class y {
    public final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1301b;
    public int c;
    public int d;

    public y(byte[] bArr) {
        this.a = bArr;
        this.f1301b = bArr.length;
    }

    public boolean a() {
        boolean z2 = (((this.a[this.c] & 255) >> this.d) & 1) == 1;
        c(1);
        return z2;
    }

    public int b(int i) {
        int i2 = this.c;
        int iMin = Math.min(i, 8 - this.d);
        int i3 = i2 + 1;
        int i4 = ((this.a[i2] & 255) >> this.d) & (255 >> (8 - iMin));
        while (iMin < i) {
            i4 |= (this.a[i3] & 255) << iMin;
            iMin += 8;
            i3++;
        }
        int i5 = i4 & ((-1) >>> (32 - i));
        c(i);
        return i5;
    }

    public void c(int i) {
        int i2;
        int i3 = i / 8;
        int i4 = this.c + i3;
        this.c = i4;
        int i5 = (i - (i3 * 8)) + this.d;
        this.d = i5;
        boolean z2 = true;
        if (i5 > 7) {
            this.c = i4 + 1;
            this.d = i5 - 8;
        }
        int i6 = this.c;
        if (i6 < 0 || (i6 >= (i2 = this.f1301b) && (i6 != i2 || this.d != 0))) {
            z2 = false;
        }
        b.c.a.a0.d.D(z2);
    }
}
