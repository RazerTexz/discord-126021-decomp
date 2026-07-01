package b.i.a.c;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import java.util.Arrays;

/* JADX INFO: renamed from: b.i.a.c.l2, reason: use source file name */
/* JADX INFO: compiled from: StarRating.java */
/* JADX INFO: loaded from: classes3.dex */
public final class StarRating extends Rating {

    @IntRange(from = 1)
    public final int k;
    public final float l;

    public StarRating(@IntRange(from = 1) int i) {
        AnimatableValueParser.m(i > 0, "maxStars must be a positive integer");
        this.k = i;
        this.l = -1.0f;
    }

    public static String a(int i) {
        return Integer.toString(i, 36);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof StarRating)) {
            return false;
        }
        StarRating starRating = (StarRating) obj;
        return this.k == starRating.k && this.l == starRating.l;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.k), Float.valueOf(this.l)});
    }

    public StarRating(@IntRange(from = 1) int i, @FloatRange(from = 0.0d) float f) {
        AnimatableValueParser.m(i > 0, "maxStars must be a positive integer");
        AnimatableValueParser.m(f >= 0.0f && f <= ((float) i), "starRating is out of range [0, maxStars]");
        this.k = i;
        this.l = f;
    }
}
