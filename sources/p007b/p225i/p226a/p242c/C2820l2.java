package p007b.p225i.p226a.p242c;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import java.util.Arrays;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.c.l2 */
/* JADX INFO: compiled from: StarRating.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2820l2 extends AbstractC2656d2 {

    /* JADX INFO: renamed from: k */
    @IntRange(from = 1)
    public final int f7240k;

    /* JADX INFO: renamed from: l */
    public final float f7241l;

    public C2820l2(@IntRange(from = 1) int i) {
        C1460d.m543m(i > 0, "maxStars must be a positive integer");
        this.f7240k = i;
        this.f7241l = -1.0f;
    }

    /* JADX INFO: renamed from: a */
    public static String m3304a(int i) {
        return Integer.toString(i, 36);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof C2820l2)) {
            return false;
        }
        C2820l2 c2820l2 = (C2820l2) obj;
        return this.f7240k == c2820l2.f7240k && this.f7241l == c2820l2.f7241l;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f7240k), Float.valueOf(this.f7241l)});
    }

    public C2820l2(@IntRange(from = 1) int i, @FloatRange(from = 0.0d) float f) {
        C1460d.m543m(i > 0, "maxStars must be a positive integer");
        C1460d.m543m(f >= 0.0f && f <= ((float) i), "starRating is out of range [0, maxStars]");
        this.f7240k = i;
        this.f7241l = f;
    }
}
