package b.i.a.c;

import androidx.annotation.IntRange;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: MediaItem.java */
/* JADX INFO: loaded from: classes3.dex */
public class o1$d implements w0 {
    public static final w0$a<o1$e> j;

    @IntRange(from = 0)
    public final long k;
    public final long l;
    public final boolean m;
    public final boolean n;
    public final boolean o;

    static {
        new o1$d$a().a();
        j = i0.a;
    }

    public o1$d(o1$d$a o1_d_a, o1$a o1_a) {
        this.k = o1_d_a.a;
        this.l = o1_d_a.f1035b;
        this.m = o1_d_a.c;
        this.n = o1_d_a.d;
        this.o = o1_d_a.e;
    }

    public static String a(int i) {
        return Integer.toString(i, 36);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o1$d)) {
            return false;
        }
        o1$d o1_d = (o1$d) obj;
        return this.k == o1_d.k && this.l == o1_d.l && this.m == o1_d.m && this.n == o1_d.n && this.o == o1_d.o;
    }

    public int hashCode() {
        long j2 = this.k;
        int i = ((int) (j2 ^ (j2 >>> 32))) * 31;
        long j3 = this.l;
        return ((((((i + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.m ? 1 : 0)) * 31) + (this.n ? 1 : 0)) * 31) + (this.o ? 1 : 0);
    }
}
