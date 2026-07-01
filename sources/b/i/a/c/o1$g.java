package b.i.a.c;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: MediaItem.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o1$g implements w0 {
    public static final o1$g j = new o1$g$a().a();
    public static final w0$a<o1$g> k = j0.a;
    public final long l;
    public final long m;
    public final long n;
    public final float o;
    public final float p;

    public o1$g(o1$g$a o1_g_a, o1$a o1_a) {
        long j2 = o1_g_a.a;
        long j3 = o1_g_a.f1038b;
        long j4 = o1_g_a.c;
        float f = o1_g_a.d;
        float f2 = o1_g_a.e;
        this.l = j2;
        this.m = j3;
        this.n = j4;
        this.o = f;
        this.p = f2;
    }

    public static String a(int i) {
        return Integer.toString(i, 36);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o1$g)) {
            return false;
        }
        o1$g o1_g = (o1$g) obj;
        return this.l == o1_g.l && this.m == o1_g.m && this.n == o1_g.n && this.o == o1_g.o && this.p == o1_g.p;
    }

    public int hashCode() {
        long j2 = this.l;
        long j3 = this.m;
        int i = ((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.n;
        int i2 = (i + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        float f = this.o;
        int iFloatToIntBits = (i2 + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31;
        float f2 = this.p;
        return iFloatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0);
    }

    @Deprecated
    public o1$g(long j2, long j3, long j4, float f, float f2) {
        this.l = j2;
        this.m = j3;
        this.n = j4;
        this.o = f;
        this.p = f2;
    }
}
