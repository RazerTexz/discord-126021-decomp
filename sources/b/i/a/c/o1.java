package b.i.a.c;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: MediaItem.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o1 implements w0 {
    public static final w0$a<o1> j;
    public final String k;

    @Nullable
    public final o1$h l;
    public final o1$g m;
    public final p1 n;
    public final o1$d o;

    static {
        new o1$c().a();
        j = k0.a;
    }

    public o1(String str, o1$e o1_e, @Nullable o1$i o1_i, o1$g o1_g, p1 p1Var) {
        this.k = str;
        this.l = null;
        this.m = o1_g;
        this.n = p1Var;
        this.o = o1_e;
    }

    public static String a(int i) {
        return Integer.toString(i, 36);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o1)) {
            return false;
        }
        o1 o1Var = (o1) obj;
        return b.i.a.c.f3.e0.a(this.k, o1Var.k) && this.o.equals(o1Var.o) && b.i.a.c.f3.e0.a(this.l, o1Var.l) && b.i.a.c.f3.e0.a(this.m, o1Var.m) && b.i.a.c.f3.e0.a(this.n, o1Var.n);
    }

    public int hashCode() {
        int iHashCode = this.k.hashCode() * 31;
        o1$h o1_h = this.l;
        return this.n.hashCode() + ((this.o.hashCode() + ((this.m.hashCode() + ((iHashCode + (o1_h != null ? o1_h.hashCode() : 0)) * 31)) * 31)) * 31);
    }

    public o1(String str, o1$e o1_e, o1$i o1_i, o1$g o1_g, p1 p1Var, o1$a o1_a) {
        this.k = str;
        this.l = o1_i;
        this.m = o1_g;
        this.n = p1Var;
        this.o = o1_e;
    }
}
