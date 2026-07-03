package p007b.p225i.p226a.p242c;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import java.util.Arrays;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.c.v1 */
/* JADX INFO: compiled from: PercentageRating.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2952v1 extends AbstractC2656d2 {

    /* JADX INFO: renamed from: k */
    public final float f7900k;

    public C2952v1() {
        this.f7900k = -1.0f;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof C2952v1) && this.f7900k == ((C2952v1) obj).f7900k;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f7900k)});
    }

    public C2952v1(@FloatRange(from = 0.0d, m75to = 100.0d) float f) {
        C1460d.m543m(f >= 0.0f && f <= 100.0f, "percent must be in the range of [0, 100]");
        this.f7900k = f;
    }
}
