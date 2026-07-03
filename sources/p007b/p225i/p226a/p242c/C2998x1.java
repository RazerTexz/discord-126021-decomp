package p007b.p225i.p226a.p242c;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.x1 */
/* JADX INFO: compiled from: PlaybackParameters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2998x1 implements InterfaceC2963w0 {

    /* JADX INFO: renamed from: j */
    public static final C2998x1 f8026j = new C2998x1(1.0f, 1.0f);

    /* JADX INFO: renamed from: k */
    public final float f8027k;

    /* JADX INFO: renamed from: l */
    public final float f8028l;

    /* JADX INFO: renamed from: m */
    public final int f8029m;

    public C2998x1(@FloatRange(from = 0.0d, fromInclusive = false) float f, @FloatRange(from = 0.0d, fromInclusive = false) float f2) {
        C1460d.m531j(f > 0.0f);
        C1460d.m531j(f2 > 0.0f);
        this.f8027k = f;
        this.f8028l = f2;
        this.f8029m = Math.round(f * 1000.0f);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2998x1.class != obj.getClass()) {
            return false;
        }
        C2998x1 c2998x1 = (C2998x1) obj;
        return this.f8027k == c2998x1.f8027k && this.f8028l == c2998x1.f8028l;
    }

    public int hashCode() {
        return Float.floatToRawIntBits(this.f8028l) + ((Float.floatToRawIntBits(this.f8027k) + 527) * 31);
    }

    public String toString() {
        return C2738e0.m3003k("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.f8027k), Float.valueOf(this.f8028l));
    }
}
