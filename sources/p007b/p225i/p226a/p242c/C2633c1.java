package p007b.p225i.p226a.p242c;

import androidx.annotation.Nullable;

/* JADX INFO: renamed from: b.i.a.c.c1 */
/* JADX INFO: compiled from: DeviceInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2633c1 implements InterfaceC2963w0 {

    /* JADX INFO: renamed from: j */
    public final int f6167j;

    /* JADX INFO: renamed from: k */
    public final int f6168k;

    /* JADX INFO: renamed from: l */
    public final int f6169l;

    public C2633c1(int i, int i2, int i3) {
        this.f6167j = i;
        this.f6168k = i2;
        this.f6169l = i3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2633c1)) {
            return false;
        }
        C2633c1 c2633c1 = (C2633c1) obj;
        return this.f6167j == c2633c1.f6167j && this.f6168k == c2633c1.f6168k && this.f6169l == c2633c1.f6169l;
    }

    public int hashCode() {
        return ((((527 + this.f6167j) * 31) + this.f6168k) * 31) + this.f6169l;
    }
}
