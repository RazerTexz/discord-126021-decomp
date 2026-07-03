package p007b.p225i.p414e;

/* JADX INFO: renamed from: b.i.e.e */
/* JADX INFO: compiled from: InvertedLuminanceSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4950e extends AbstractC4951f {

    /* JADX INFO: renamed from: c */
    public final AbstractC4951f f13185c;

    public C4950e(AbstractC4951f abstractC4951f) {
        super(abstractC4951f.f13186a, abstractC4951f.f13187b);
        this.f13185c = abstractC4951f;
    }

    @Override // p007b.p225i.p414e.AbstractC4951f
    /* JADX INFO: renamed from: a */
    public byte[] mo6915a() {
        byte[] bArrMo6915a = this.f13185c.mo6915a();
        int i = this.f13186a * this.f13187b;
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) (255 - (bArrMo6915a[i2] & 255));
        }
        return bArr;
    }

    @Override // p007b.p225i.p414e.AbstractC4951f
    /* JADX INFO: renamed from: b */
    public byte[] mo6916b(int i, byte[] bArr) {
        byte[] bArrMo6916b = this.f13185c.mo6916b(i, bArr);
        int i2 = this.f13186a;
        for (int i3 = 0; i3 < i2; i3++) {
            bArrMo6916b[i3] = (byte) (255 - (bArrMo6916b[i3] & 255));
        }
        return bArrMo6916b;
    }

    @Override // p007b.p225i.p414e.AbstractC4951f
    /* JADX INFO: renamed from: c */
    public boolean mo6917c() {
        return this.f13185c.mo6917c();
    }

    @Override // p007b.p225i.p414e.AbstractC4951f
    /* JADX INFO: renamed from: d */
    public AbstractC4951f mo6918d() {
        return new C4950e(this.f13185c.mo6918d());
    }
}
