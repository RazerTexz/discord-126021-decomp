package p007b.p225i.p414e;

/* JADX INFO: renamed from: b.i.e.h */
/* JADX INFO: compiled from: PlanarYUVLuminanceSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4953h extends AbstractC4951f {

    /* JADX INFO: renamed from: c */
    public final byte[] f13190c;

    /* JADX INFO: renamed from: d */
    public final int f13191d;

    /* JADX INFO: renamed from: e */
    public final int f13192e;

    /* JADX INFO: renamed from: f */
    public final int f13193f;

    /* JADX INFO: renamed from: g */
    public final int f13194g;

    public C4953h(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z2) {
        super(i5, i6);
        if (i3 + i5 > i || i4 + i6 > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f13190c = bArr;
        this.f13191d = i;
        this.f13192e = i2;
        this.f13193f = i3;
        this.f13194g = i4;
        if (z2) {
            int i7 = (i4 * i) + i3;
            int i8 = 0;
            while (i8 < i6) {
                int i9 = (i5 / 2) + i7;
                int i10 = (i7 + i5) - 1;
                int i11 = i7;
                while (i11 < i9) {
                    byte b2 = bArr[i11];
                    bArr[i11] = bArr[i10];
                    bArr[i10] = b2;
                    i11++;
                    i10--;
                }
                i8++;
                i7 += this.f13191d;
            }
        }
    }

    @Override // p007b.p225i.p414e.AbstractC4951f
    /* JADX INFO: renamed from: a */
    public byte[] mo6915a() {
        int i = this.f13186a;
        int i2 = this.f13187b;
        int i3 = this.f13191d;
        if (i == i3 && i2 == this.f13192e) {
            return this.f13190c;
        }
        int i4 = i * i2;
        byte[] bArr = new byte[i4];
        int i5 = (this.f13194g * i3) + this.f13193f;
        if (i == i3) {
            System.arraycopy(this.f13190c, i5, bArr, 0, i4);
            return bArr;
        }
        for (int i6 = 0; i6 < i2; i6++) {
            System.arraycopy(this.f13190c, i5, bArr, i6 * i, i);
            i5 += this.f13191d;
        }
        return bArr;
    }

    @Override // p007b.p225i.p414e.AbstractC4951f
    /* JADX INFO: renamed from: b */
    public byte[] mo6916b(int i, byte[] bArr) {
        if (i < 0 || i >= this.f13187b) {
            throw new IllegalArgumentException("Requested row is outside the image: ".concat(String.valueOf(i)));
        }
        int i2 = this.f13186a;
        if (bArr == null || bArr.length < i2) {
            bArr = new byte[i2];
        }
        System.arraycopy(this.f13190c, ((i + this.f13194g) * this.f13191d) + this.f13193f, bArr, 0, i2);
        return bArr;
    }
}
