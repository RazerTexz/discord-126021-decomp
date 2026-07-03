package p007b.p225i.p226a.p242c.p267x2;

import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.c.x2.y */
/* JADX INFO: compiled from: VorbisBitArray.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3124y {

    /* JADX INFO: renamed from: a */
    public final byte[] f9011a;

    /* JADX INFO: renamed from: b */
    public final int f9012b;

    /* JADX INFO: renamed from: c */
    public int f9013c;

    /* JADX INFO: renamed from: d */
    public int f9014d;

    public C3124y(byte[] bArr) {
        this.f9011a = bArr;
        this.f9012b = bArr.length;
    }

    /* JADX INFO: renamed from: a */
    public boolean m3822a() {
        boolean z2 = (((this.f9011a[this.f9013c] & 255) >> this.f9014d) & 1) == 1;
        m3824c(1);
        return z2;
    }

    /* JADX INFO: renamed from: b */
    public int m3823b(int i) {
        int i2 = this.f9013c;
        int iMin = Math.min(i, 8 - this.f9014d);
        int i3 = i2 + 1;
        int i4 = ((this.f9011a[i2] & 255) >> this.f9014d) & (255 >> (8 - iMin));
        while (iMin < i) {
            i4 |= (this.f9011a[i3] & 255) << iMin;
            iMin += 8;
            i3++;
        }
        int i5 = i4 & ((-1) >>> (32 - i));
        m3824c(i);
        return i5;
    }

    /* JADX INFO: renamed from: c */
    public void m3824c(int i) {
        int i2;
        int i3 = i / 8;
        int i4 = this.f9013c + i3;
        this.f9013c = i4;
        int i5 = (i - (i3 * 8)) + this.f9014d;
        this.f9014d = i5;
        boolean z2 = true;
        if (i5 > 7) {
            this.f9013c = i4 + 1;
            this.f9014d = i5 - 8;
        }
        int i6 = this.f9013c;
        if (i6 < 0 || (i6 >= (i2 = this.f9012b) && (i6 != i2 || this.f9014d != 0))) {
            z2 = false;
        }
        C1460d.m426D(z2);
    }
}
