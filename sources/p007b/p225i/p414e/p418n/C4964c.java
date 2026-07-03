package p007b.p225i.p414e.p418n;

/* JADX INFO: renamed from: b.i.e.n.c */
/* JADX INFO: compiled from: BitSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4964c {

    /* JADX INFO: renamed from: a */
    public final byte[] f13233a;

    /* JADX INFO: renamed from: b */
    public int f13234b;

    /* JADX INFO: renamed from: c */
    public int f13235c;

    public C4964c(byte[] bArr) {
        this.f13233a = bArr;
    }

    /* JADX INFO: renamed from: a */
    public int m6948a() {
        return ((this.f13233a.length - this.f13234b) * 8) - this.f13235c;
    }

    /* JADX INFO: renamed from: b */
    public int m6949b(int i) {
        if (i <= 0 || i > 32 || i > m6948a()) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        int i2 = this.f13235c;
        int i3 = 0;
        if (i2 > 0) {
            int i4 = 8 - i2;
            int i5 = i < i4 ? i : i4;
            int i6 = i4 - i5;
            byte[] bArr = this.f13233a;
            int i7 = this.f13234b;
            int i8 = (((255 >> (8 - i5)) << i6) & bArr[i7]) >> i6;
            i -= i5;
            int i9 = i2 + i5;
            this.f13235c = i9;
            if (i9 == 8) {
                this.f13235c = 0;
                this.f13234b = i7 + 1;
            }
            i3 = i8;
        }
        if (i <= 0) {
            return i3;
        }
        while (i >= 8) {
            int i10 = i3 << 8;
            byte[] bArr2 = this.f13233a;
            int i11 = this.f13234b;
            i3 = (bArr2[i11] & 255) | i10;
            this.f13234b = i11 + 1;
            i -= 8;
        }
        if (i <= 0) {
            return i3;
        }
        int i12 = 8 - i;
        int i13 = (i3 << i) | ((((255 >> i12) << i12) & this.f13233a[this.f13234b]) >> i12);
        this.f13235c += i;
        return i13;
    }
}
