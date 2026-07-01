package b.i.a.c.g3;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import b.i.a.c.w0;

/* JADX INFO: compiled from: VideoSize.java */
/* JADX INFO: loaded from: classes3.dex */
public final class y implements w0 {
    public static final y j = new y(0, 0);

    @IntRange(from = 0)
    public final int k;

    @IntRange(from = 0)
    public final int l;

    @IntRange(from = 0, to = 359)
    public final int m;

    @FloatRange(from = 0.0d, fromInclusive = false)
    public final float n;

    public y(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        this.k = i;
        this.l = i2;
        this.m = 0;
        this.n = 1.0f;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return this.k == yVar.k && this.l == yVar.l && this.m == yVar.m && this.n == yVar.n;
    }

    public int hashCode() {
        return Float.floatToRawIntBits(this.n) + ((((((217 + this.k) * 31) + this.l) * 31) + this.m) * 31);
    }

    public y(@IntRange(from = 0) int i, @IntRange(from = 0) int i2, @IntRange(from = 0, to = 359) int i3, @FloatRange(from = 0.0d, fromInclusive = false) float f) {
        this.k = i;
        this.l = i2;
        this.m = i3;
        this.n = f;
    }
}
