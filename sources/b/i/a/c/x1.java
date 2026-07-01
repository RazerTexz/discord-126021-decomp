package b.i.a.c;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: PlaybackParameters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class x1 implements w0 {
    public static final x1 j = new x1(1.0f, 1.0f);
    public final float k;
    public final float l;
    public final int m;

    public x1(@FloatRange(from = 0.0d, fromInclusive = false) float f, @FloatRange(from = 0.0d, fromInclusive = false) float f2) {
        b.c.a.a0.d.j(f > 0.0f);
        b.c.a.a0.d.j(f2 > 0.0f);
        this.k = f;
        this.l = f2;
        this.m = Math.round(f * 1000.0f);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || x1.class != obj.getClass()) {
            return false;
        }
        x1 x1Var = (x1) obj;
        return this.k == x1Var.k && this.l == x1Var.l;
    }

    public int hashCode() {
        return Float.floatToRawIntBits(this.l) + ((Float.floatToRawIntBits(this.k) + 527) * 31);
    }

    public String toString() {
        return b.i.a.c.f3.e0.k("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.k), Float.valueOf(this.l));
    }
}
