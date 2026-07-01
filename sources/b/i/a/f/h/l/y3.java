package b.i.a.f.h.l;

import b.d.b.a.outline;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class y3 extends z3 {
    private final int zzc;
    private final int zzd;

    public y3(byte[] bArr, int i, int i2) {
        super(bArr);
        t3.l(i, i + i2, bArr.length);
        this.zzc = i;
        this.zzd = i2;
    }

    @Override // b.i.a.f.h.l.z3, b.i.a.f.h.l.t3
    public final byte c(int i) {
        int i2 = this.zzd;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.zzb[this.zzc + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(outline.g(22, "Index < 0: ", i));
        }
        throw new ArrayIndexOutOfBoundsException(outline.h(40, "Index > length: ", i, ", ", i2));
    }

    @Override // b.i.a.f.h.l.z3, b.i.a.f.h.l.t3
    public final int d() {
        return this.zzd;
    }

    @Override // b.i.a.f.h.l.z3, b.i.a.f.h.l.t3
    public final byte k(int i) {
        return this.zzb[this.zzc + i];
    }

    @Override // b.i.a.f.h.l.z3
    public final int o() {
        return this.zzc;
    }
}
