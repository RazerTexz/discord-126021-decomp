package p007b.p225i.p226a.p288f.p313h.p325l;

import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.f.h.l.y3 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3902y3 extends C3915z3 {
    private final int zzc;
    private final int zzd;

    public C3902y3(byte[] bArr, int i, int i2) {
        super(bArr);
        AbstractC3837t3.m5280l(i, i + i2, bArr.length);
        this.zzc = i;
        this.zzd = i2;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3915z3, p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3837t3
    /* JADX INFO: renamed from: c */
    public final byte mo5281c(int i) {
        int i2 = this.zzd;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.zzb[this.zzc + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(C1643a.m851g(22, "Index < 0: ", i));
        }
        throw new ArrayIndexOutOfBoundsException(C1643a.m853h(40, "Index > length: ", i, ", ", i2));
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3915z3, p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3837t3
    /* JADX INFO: renamed from: d */
    public final int mo5282d() {
        return this.zzd;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3915z3, p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3837t3
    /* JADX INFO: renamed from: k */
    public final byte mo5287k(int i) {
        return this.zzb[this.zzc + i];
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3915z3
    /* JADX INFO: renamed from: o */
    public final int mo5379o() {
        return this.zzc;
    }
}
