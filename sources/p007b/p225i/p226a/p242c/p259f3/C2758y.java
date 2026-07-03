package p007b.p225i.p226a.p242c.p259f3;

import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.c.f3.y */
/* JADX INFO: compiled from: ParsableNalUnitBitArray.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2758y {

    /* JADX INFO: renamed from: a */
    public byte[] f6796a;

    /* JADX INFO: renamed from: b */
    public int f6797b;

    /* JADX INFO: renamed from: c */
    public int f6798c;

    /* JADX INFO: renamed from: d */
    public int f6799d = 0;

    public C2758y(byte[] bArr, int i, int i2) {
        this.f6796a = bArr;
        this.f6798c = i;
        this.f6797b = i2;
        m3107a();
    }

    /* JADX INFO: renamed from: a */
    public final void m3107a() {
        int i;
        int i2 = this.f6798c;
        C1460d.m426D(i2 >= 0 && (i2 < (i = this.f6797b) || (i2 == i && this.f6799d == 0)));
    }

    /* JADX INFO: renamed from: b */
    public boolean m3108b(int i) {
        int i2 = this.f6798c;
        int i3 = i / 8;
        int i4 = i2 + i3;
        int i5 = (this.f6799d + i) - (i3 * 8);
        if (i5 > 7) {
            i4++;
            i5 -= 8;
        }
        while (true) {
            i2++;
            if (i2 > i4 || i4 >= this.f6797b) {
                break;
            }
            if (m3114h(i2)) {
                i4++;
                i2 += 2;
            }
        }
        int i6 = this.f6797b;
        if (i4 >= i6) {
            return i4 == i6 && i5 == 0;
        }
        return true;
    }

    /* JADX INFO: renamed from: c */
    public boolean m3109c() {
        int i = this.f6798c;
        int i2 = this.f6799d;
        int i3 = 0;
        while (this.f6798c < this.f6797b && !m3110d()) {
            i3++;
        }
        boolean z2 = this.f6798c == this.f6797b;
        this.f6798c = i;
        this.f6799d = i2;
        return !z2 && m3108b((i3 * 2) + 1);
    }

    /* JADX INFO: renamed from: d */
    public boolean m3110d() {
        boolean z2 = (this.f6796a[this.f6798c] & (128 >> this.f6799d)) != 0;
        m3115i();
        return z2;
    }

    /* JADX INFO: renamed from: e */
    public int m3111e(int i) {
        int i2;
        this.f6799d += i;
        int i3 = 0;
        while (true) {
            i2 = this.f6799d;
            int i4 = 2;
            if (i2 <= 8) {
                break;
            }
            int i5 = i2 - 8;
            this.f6799d = i5;
            byte[] bArr = this.f6796a;
            int i6 = this.f6798c;
            i3 |= (bArr[i6] & 255) << i5;
            if (!m3114h(i6 + 1)) {
                i4 = 1;
            }
            this.f6798c = i6 + i4;
        }
        byte[] bArr2 = this.f6796a;
        int i7 = this.f6798c;
        int i8 = ((-1) >>> (32 - i)) & (i3 | ((bArr2[i7] & 255) >> (8 - i2)));
        if (i2 == 8) {
            this.f6799d = 0;
            this.f6798c = i7 + (m3114h(i7 + 1) ? 2 : 1);
        }
        m3107a();
        return i8;
    }

    /* JADX INFO: renamed from: f */
    public final int m3112f() {
        int i = 0;
        while (!m3110d()) {
            i++;
        }
        return ((1 << i) - 1) + (i > 0 ? m3111e(i) : 0);
    }

    /* JADX INFO: renamed from: g */
    public int m3113g() {
        int iM3112f = m3112f();
        return ((iM3112f + 1) / 2) * (iM3112f % 2 == 0 ? -1 : 1);
    }

    /* JADX INFO: renamed from: h */
    public final boolean m3114h(int i) {
        if (2 <= i && i < this.f6797b) {
            byte[] bArr = this.f6796a;
            if (bArr[i] == 3 && bArr[i - 2] == 0 && bArr[i - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: i */
    public void m3115i() {
        int i = this.f6799d + 1;
        this.f6799d = i;
        if (i == 8) {
            this.f6799d = 0;
            int i2 = this.f6798c;
            this.f6798c = i2 + (m3114h(i2 + 1) ? 2 : 1);
        }
        m3107a();
    }

    /* JADX INFO: renamed from: j */
    public void m3116j(int i) {
        int i2 = this.f6798c;
        int i3 = i / 8;
        int i4 = i2 + i3;
        this.f6798c = i4;
        int i5 = (i - (i3 * 8)) + this.f6799d;
        this.f6799d = i5;
        if (i5 > 7) {
            this.f6798c = i4 + 1;
            this.f6799d = i5 - 8;
        }
        while (true) {
            i2++;
            if (i2 > this.f6798c) {
                m3107a();
                return;
            } else if (m3114h(i2)) {
                this.f6798c++;
                i2 += 2;
            }
        }
    }
}
