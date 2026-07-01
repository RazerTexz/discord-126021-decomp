package b.i.a.c;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import java.util.Arrays;

/* JADX INFO: renamed from: b.i.a.c.v1, reason: use source file name */
/* JADX INFO: compiled from: PercentageRating.java */
/* JADX INFO: loaded from: classes3.dex */
public final class PercentageRating extends Rating {
    public final float k;

    public PercentageRating() {
        this.k = -1.0f;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof PercentageRating) && this.k == ((PercentageRating) obj).k;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.k)});
    }

    public PercentageRating(@FloatRange(from = 0.0d, to = 100.0d) float f) {
        AnimatableValueParser.m(f >= 0.0f && f <= 100.0f, "percent must be in the range of [0, 100]");
        this.k = f;
    }
}
