package b.i.a.c;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: Player.java */
/* JADX INFO: loaded from: classes3.dex */
public final class y1$f implements w0 {

    @Nullable
    public final Object j;
    public final int k;

    @Nullable
    public final o1 l;

    @Nullable
    public final Object m;
    public final int n;
    public final long o;
    public final long p;
    public final int q;
    public final int r;

    public y1$f(@Nullable Object obj, int i, @Nullable o1 o1Var, @Nullable Object obj2, int i2, long j, long j2, int i3, int i4) {
        this.j = obj;
        this.k = i;
        this.l = o1Var;
        this.m = obj2;
        this.n = i2;
        this.o = j;
        this.p = j2;
        this.q = i3;
        this.r = i4;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || y1$f.class != obj.getClass()) {
            return false;
        }
        y1$f y1_f = (y1$f) obj;
        return this.k == y1_f.k && this.n == y1_f.n && this.o == y1_f.o && this.p == y1_f.p && this.q == y1_f.q && this.r == y1_f.r && b.i.a.f.e.o.f.V(this.j, y1_f.j) && b.i.a.f.e.o.f.V(this.m, y1_f.m) && b.i.a.f.e.o.f.V(this.l, y1_f.l);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.j, Integer.valueOf(this.k), this.l, this.m, Integer.valueOf(this.n), Long.valueOf(this.o), Long.valueOf(this.p), Integer.valueOf(this.q), Integer.valueOf(this.r)});
    }
}
