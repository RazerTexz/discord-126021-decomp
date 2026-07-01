package b.i.a.c;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: TracksInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p2$a implements w0 {
    public final b.i.a.c.a3.n0 j;
    public final int[] k;
    public final int l;
    public final boolean[] m;

    public p2$a(b.i.a.c.a3.n0 n0Var, int[] iArr, int i, boolean[] zArr) {
        int i2 = n0Var.k;
        b.c.a.a0.d.j(i2 == iArr.length && i2 == zArr.length);
        this.j = n0Var;
        this.k = (int[]) iArr.clone();
        this.l = i;
        this.m = (boolean[]) zArr.clone();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p2$a.class != obj.getClass()) {
            return false;
        }
        p2$a p2_a = (p2$a) obj;
        return this.l == p2_a.l && this.j.equals(p2_a.j) && Arrays.equals(this.k, p2_a.k) && Arrays.equals(this.m, p2_a.m);
    }

    public int hashCode() {
        return Arrays.hashCode(this.m) + ((((Arrays.hashCode(this.k) + (this.j.hashCode() * 31)) * 31) + this.l) * 31);
    }
}
