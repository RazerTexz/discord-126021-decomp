package b.i.a.c;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.errorprone.annotations.InlineMe;
import java.util.Objects;

/* JADX INFO: compiled from: Timeline.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class o2 implements w0 {
    public static final o2 j = new o2$a();

    public int a(boolean z2) {
        return q() ? -1 : 0;
    }

    public abstract int b(Object obj);

    public int c(boolean z2) {
        if (q()) {
            return -1;
        }
        return p() - 1;
    }

    public final int d(int i, o2$b o2_b, o2$c o2_c, int i2, boolean z2) {
        int i3 = g(i, o2_b, false).l;
        if (n(i3, o2_c).C != i) {
            return i + 1;
        }
        int iE = e(i3, i2, z2);
        if (iE == -1) {
            return -1;
        }
        return n(iE, o2_c).B;
    }

    public int e(int i, int i2, boolean z2) {
        if (i2 == 0) {
            if (i == c(z2)) {
                return -1;
            }
            return i + 1;
        }
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            return i == c(z2) ? a(z2) : i + 1;
        }
        throw new IllegalStateException();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o2)) {
            return false;
        }
        o2 o2Var = (o2) obj;
        if (o2Var.p() != p() || o2Var.i() != i()) {
            return false;
        }
        o2$c o2_c = new o2$c();
        o2$b o2_b = new o2$b();
        o2$c o2_c2 = new o2$c();
        o2$b o2_b2 = new o2$b();
        for (int i = 0; i < p(); i++) {
            if (!n(i, o2_c).equals(o2Var.n(i, o2_c2))) {
                return false;
            }
        }
        for (int i2 = 0; i2 < i(); i2++) {
            if (!g(i2, o2_b, true).equals(o2Var.g(i2, o2_b2, true))) {
                return false;
            }
        }
        return true;
    }

    public final o2$b f(int i, o2$b o2_b) {
        return g(i, o2_b, false);
    }

    public abstract o2$b g(int i, o2$b o2_b, boolean z2);

    public o2$b h(Object obj, o2$b o2_b) {
        return g(b(obj), o2_b, true);
    }

    public int hashCode() {
        o2$c o2_c = new o2$c();
        o2$b o2_b = new o2$b();
        int iP = p() + 217;
        for (int i = 0; i < p(); i++) {
            iP = (iP * 31) + n(i, o2_c).hashCode();
        }
        int i2 = i() + (iP * 31);
        for (int i3 = 0; i3 < i(); i3++) {
            i2 = (i2 * 31) + g(i3, o2_b, true).hashCode();
        }
        return i2;
    }

    public abstract int i();

    @InlineMe(replacement = "this.getPeriodPositionUs(window, period, windowIndex, windowPositionUs)")
    @Deprecated
    public final Pair<Object, Long> j(o2$c o2_c, o2$b o2_b, int i, long j2) {
        Pair<Object, Long> pairK = k(o2_c, o2_b, i, j2, 0L);
        Objects.requireNonNull(pairK);
        return pairK;
    }

    @Nullable
    @InlineMe(replacement = "this.getPeriodPositionUs(window, period, windowIndex, windowPositionUs, defaultPositionProjectionUs)")
    @Deprecated
    public final Pair<Object, Long> k(o2$c o2_c, o2$b o2_b, int i, long j2, long j3) {
        b.c.a.a0.d.t(i, 0, p());
        o(i, o2_c, j3);
        if (j2 == -9223372036854775807L) {
            j2 = o2_c.f1045z;
            if (j2 == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = o2_c.B;
        f(i2, o2_b);
        while (i2 < o2_c.C && o2_b.n != j2) {
            int i3 = i2 + 1;
            if (f(i3, o2_b).n > j2) {
                break;
            }
            i2 = i3;
        }
        g(i2, o2_b, true);
        long jMin = j2 - o2_b.n;
        long j4 = o2_b.m;
        if (j4 != -9223372036854775807L) {
            jMin = Math.min(jMin, j4 - 1);
        }
        long jMax = Math.max(0L, jMin);
        Object obj = o2_b.k;
        Objects.requireNonNull(obj);
        return Pair.create(obj, Long.valueOf(jMax));
    }

    public int l(int i, int i2, boolean z2) {
        if (i2 == 0) {
            if (i == a(z2)) {
                return -1;
            }
            return i - 1;
        }
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            return i == a(z2) ? c(z2) : i - 1;
        }
        throw new IllegalStateException();
    }

    public abstract Object m(int i);

    public final o2$c n(int i, o2$c o2_c) {
        return o(i, o2_c, 0L);
    }

    public abstract o2$c o(int i, o2$c o2_c, long j2);

    public abstract int p();

    public final boolean q() {
        return p() == 0;
    }
}
