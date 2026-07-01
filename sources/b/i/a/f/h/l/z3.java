package b.i.a.f.h.l;

import com.google.android.gms.internal.measurement.zzhi$a;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class z3 extends b4 {
    public final byte[] zzb;

    public z3(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.zzb = bArr;
    }

    @Override // b.i.a.f.h.l.t3
    public byte c(int i) {
        return this.zzb[i];
    }

    @Override // b.i.a.f.h.l.t3
    public int d() {
        return this.zzb.length;
    }

    @Override // b.i.a.f.h.l.t3
    public final int e(int i, int i2, int i3) {
        byte[] bArr = this.zzb;
        int iO = o();
        Charset charset = w4.a;
        for (int i4 = iO; i4 < iO + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    @Override // b.i.a.f.h.l.t3
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t3) || d() != ((t3) obj).d()) {
            return false;
        }
        if (d() == 0) {
            return true;
        }
        if (!(obj instanceof z3)) {
            return obj.equals(this);
        }
        z3 z3Var = (z3) obj;
        int iN = n();
        int iN2 = z3Var.n();
        if (iN != 0 && iN2 != 0 && iN != iN2) {
            return false;
        }
        int iD = d();
        if (iD > z3Var.d()) {
            int iD2 = d();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(iD);
            sb.append(iD2);
            throw new IllegalArgumentException(sb.toString());
        }
        if (iD > z3Var.d()) {
            throw new IllegalArgumentException(b.d.b.a.a.h(59, "Ran off end of other: 0, ", iD, ", ", z3Var.d()));
        }
        byte[] bArr = this.zzb;
        byte[] bArr2 = z3Var.zzb;
        int iO = o() + iD;
        int iO2 = o();
        int iO3 = z3Var.o();
        while (iO2 < iO) {
            if (bArr[iO2] != bArr2[iO3]) {
                return false;
            }
            iO2++;
            iO3++;
        }
        return true;
    }

    @Override // b.i.a.f.h.l.t3
    public final t3 g(int i, int i2) {
        int iL = t3.l(0, i2, d());
        return iL == 0 ? t3.j : new y3(this.zzb, o(), iL);
    }

    @Override // b.i.a.f.h.l.t3
    public final String i(Charset charset) {
        return new String(this.zzb, o(), d(), charset);
    }

    @Override // b.i.a.f.h.l.t3
    public final void j(u3 u3Var) throws IOException {
        ((zzhi$a) u3Var).Z(this.zzb, o(), d());
    }

    @Override // b.i.a.f.h.l.t3
    public byte k(int i) {
        return this.zzb[i];
    }

    @Override // b.i.a.f.h.l.t3
    public final boolean m() {
        int iO = o();
        return k7.b(this.zzb, iO, d() + iO);
    }

    public int o() {
        return 0;
    }
}
