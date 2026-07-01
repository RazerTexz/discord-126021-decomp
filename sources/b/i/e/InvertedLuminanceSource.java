package b.i.e;

/* JADX INFO: renamed from: b.i.e.e, reason: use source file name */
/* JADX INFO: compiled from: InvertedLuminanceSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class InvertedLuminanceSource extends LuminanceSource {
    public final LuminanceSource c;

    public InvertedLuminanceSource(LuminanceSource luminanceSource) {
        super(luminanceSource.a, luminanceSource.f1823b);
        this.c = luminanceSource;
    }

    @Override // b.i.e.LuminanceSource
    public byte[] a() {
        byte[] bArrA = this.c.a();
        int i = this.a * this.f1823b;
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) (255 - (bArrA[i2] & 255));
        }
        return bArr;
    }

    @Override // b.i.e.LuminanceSource
    public byte[] b(int i, byte[] bArr) {
        byte[] bArrB = this.c.b(i, bArr);
        int i2 = this.a;
        for (int i3 = 0; i3 < i2; i3++) {
            bArrB[i3] = (byte) (255 - (bArrB[i3] & 255));
        }
        return bArrB;
    }

    @Override // b.i.e.LuminanceSource
    public boolean c() {
        return this.c.c();
    }

    @Override // b.i.e.LuminanceSource
    public LuminanceSource d() {
        return new InvertedLuminanceSource(this.c.d());
    }
}
