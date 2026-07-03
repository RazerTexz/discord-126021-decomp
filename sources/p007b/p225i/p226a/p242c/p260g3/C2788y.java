package p007b.p225i.p226a.p242c.p260g3;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import p007b.p225i.p226a.p242c.InterfaceC2963w0;

/* JADX INFO: renamed from: b.i.a.c.g3.y */
/* JADX INFO: compiled from: VideoSize.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2788y implements InterfaceC2963w0 {

    /* JADX INFO: renamed from: j */
    public static final C2788y f6954j = new C2788y(0, 0);

    /* JADX INFO: renamed from: k */
    @IntRange(from = 0)
    public final int f6955k;

    /* JADX INFO: renamed from: l */
    @IntRange(from = 0)
    public final int f6956l;

    /* JADX INFO: renamed from: m */
    @IntRange(from = 0, m76to = 359)
    public final int f6957m;

    /* JADX INFO: renamed from: n */
    @FloatRange(from = 0.0d, fromInclusive = false)
    public final float f6958n;

    public C2788y(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        this.f6955k = i;
        this.f6956l = i2;
        this.f6957m = 0;
        this.f6958n = 1.0f;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2788y)) {
            return false;
        }
        C2788y c2788y = (C2788y) obj;
        return this.f6955k == c2788y.f6955k && this.f6956l == c2788y.f6956l && this.f6957m == c2788y.f6957m && this.f6958n == c2788y.f6958n;
    }

    public int hashCode() {
        return Float.floatToRawIntBits(this.f6958n) + ((((((217 + this.f6955k) * 31) + this.f6956l) * 31) + this.f6957m) * 31);
    }

    public C2788y(@IntRange(from = 0) int i, @IntRange(from = 0) int i2, @IntRange(from = 0, m76to = 359) int i3, @FloatRange(from = 0.0d, fromInclusive = false) float f) {
        this.f6955k = i;
        this.f6956l = i2;
        this.f6957m = i3;
        this.f6958n = f;
    }
}
