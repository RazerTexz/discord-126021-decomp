package b.i.a.c;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: StarRating.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l2 extends d2 {

    @IntRange(from = 1)
    public final int k;
    public final float l;

    public l2(@IntRange(from = 1) int i) {
        b.c.a.a0.d.m(i > 0, "maxStars must be a positive integer");
        this.k = i;
        this.l = -1.0f;
    }

    public static String a(int i) {
        return Integer.toString(i, 36);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof l2)) {
            return false;
        }
        l2 l2Var = (l2) obj;
        return this.k == l2Var.k && this.l == l2Var.l;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.k), Float.valueOf(this.l)});
    }

    public l2(@IntRange(from = 1) int i, @FloatRange(from = 0.0d) float f) {
        b.c.a.a0.d.m(i > 0, "maxStars must be a positive integer");
        b.c.a.a0.d.m(f >= 0.0f && f <= ((float) i), "starRating is out of range [0, maxStars]");
        this.k = i;
        this.l = f;
    }
}
