package b.i.a.c;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: PercentageRating.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v1 extends d2 {
    public final float k;

    public v1() {
        this.k = -1.0f;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof v1) && this.k == ((v1) obj).k;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.k)});
    }

    public v1(@FloatRange(from = 0.0d, to = 100.0d) float f) {
        b.c.a.a0.d.m(f >= 0.0f && f <= 100.0f, "percent must be in the range of [0, 100]");
        this.k = f;
    }
}
