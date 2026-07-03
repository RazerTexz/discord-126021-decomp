package p007b.p225i.p226a.p288f.p313h.p325l;

import com.google.android.gms.internal.measurement.zzhi;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.f.h.l.z3 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3915z3 extends AbstractC3596b4 {
    public final byte[] zzb;

    public C3915z3(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.zzb = bArr;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3837t3
    /* JADX INFO: renamed from: c */
    public byte mo5281c(int i) {
        return this.zzb[i];
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3837t3
    /* JADX INFO: renamed from: d */
    public int mo5282d() {
        return this.zzb.length;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3837t3
    /* JADX INFO: renamed from: e */
    public final int mo5283e(int i, int i2, int i3) {
        byte[] bArr = this.zzb;
        int iMo5379o = mo5379o();
        Charset charset = C3877w4.f10379a;
        for (int i4 = iMo5379o; i4 < iMo5379o + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3837t3
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC3837t3) || mo5282d() != ((AbstractC3837t3) obj).mo5282d()) {
            return false;
        }
        if (mo5282d() == 0) {
            return true;
        }
        if (!(obj instanceof C3915z3)) {
            return obj.equals(this);
        }
        C3915z3 c3915z3 = (C3915z3) obj;
        int iM5289n = m5289n();
        int iM5289n2 = c3915z3.m5289n();
        if (iM5289n != 0 && iM5289n2 != 0 && iM5289n != iM5289n2) {
            return false;
        }
        int iMo5282d = mo5282d();
        if (iMo5282d > c3915z3.mo5282d()) {
            int iMo5282d2 = mo5282d();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(iMo5282d);
            sb.append(iMo5282d2);
            throw new IllegalArgumentException(sb.toString());
        }
        if (iMo5282d > c3915z3.mo5282d()) {
            throw new IllegalArgumentException(C1643a.m853h(59, "Ran off end of other: 0, ", iMo5282d, ", ", c3915z3.mo5282d()));
        }
        byte[] bArr = this.zzb;
        byte[] bArr2 = c3915z3.zzb;
        int iMo5379o = mo5379o() + iMo5282d;
        int iMo5379o2 = mo5379o();
        int iMo5379o3 = c3915z3.mo5379o();
        while (iMo5379o2 < iMo5379o) {
            if (bArr[iMo5379o2] != bArr2[iMo5379o3]) {
                return false;
            }
            iMo5379o2++;
            iMo5379o3++;
        }
        return true;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3837t3
    /* JADX INFO: renamed from: g */
    public final AbstractC3837t3 mo5284g(int i, int i2) {
        int iM5280l = AbstractC3837t3.m5280l(0, i2, mo5282d());
        return iM5280l == 0 ? AbstractC3837t3.f10322j : new C3902y3(this.zzb, mo5379o(), iM5280l);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3837t3
    /* JADX INFO: renamed from: i */
    public final String mo5285i(Charset charset) {
        return new String(this.zzb, mo5379o(), mo5282d(), charset);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3837t3
    /* JADX INFO: renamed from: j */
    public final void mo5286j(AbstractC3850u3 abstractC3850u3) throws IOException {
        ((zzhi.C10804a) abstractC3850u3).m9102Z(this.zzb, mo5379o(), mo5282d());
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3837t3
    /* JADX INFO: renamed from: k */
    public byte mo5287k(int i) {
        return this.zzb[i];
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3837t3
    /* JADX INFO: renamed from: m */
    public final boolean mo5288m() {
        int iMo5379o = mo5379o();
        return C3724k7.m5022b(this.zzb, iMo5379o, mo5282d() + iMo5379o);
    }

    /* JADX INFO: renamed from: o */
    public int mo5379o() {
        return 0;
    }
}
