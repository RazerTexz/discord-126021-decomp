package b.i.a.f.h.l;

import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class g1 extends u4<g1, g1$a> implements d6 {
    private static final g1 zzg;
    private static volatile j6<g1> zzh;
    private c5 zzc;
    private c5 zzd;
    private b5<z0> zze;
    private b5<h1> zzf;

    static {
        g1 g1Var = new g1();
        zzg = g1Var;
        u4.r(g1.class, g1Var);
    }

    public g1() {
        q5 q5Var = q5.k;
        this.zzc = q5Var;
        this.zzd = q5Var;
        m6<Object> m6Var = m6.k;
        this.zze = m6Var;
        this.zzf = m6Var;
    }

    public static void B(g1 g1Var) {
        Objects.requireNonNull(g1Var);
        g1Var.zzd = q5.k;
    }

    public static void C(g1 g1Var, int i) {
        b5<h1> b5Var = g1Var.zzf;
        if (!b5Var.a()) {
            g1Var.zzf = u4.n(b5Var);
        }
        g1Var.zzf.remove(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void D(g1 g1Var, Iterable iterable) {
        c5 c5Var = g1Var.zzd;
        if (!((o3) c5Var).j) {
            g1Var.zzd = u4.o(c5Var);
        }
        l3.c(iterable, g1Var.zzd);
    }

    public static void F(g1 g1Var, Iterable iterable) {
        b5<z0> b5Var = g1Var.zze;
        if (!b5Var.a()) {
            g1Var.zze = u4.n(b5Var);
        }
        l3.c(iterable, g1Var.zze);
    }

    public static void H(g1 g1Var, Iterable iterable) {
        b5<h1> b5Var = g1Var.zzf;
        if (!b5Var.a()) {
            g1Var.zzf = u4.n(b5Var);
        }
        l3.c(iterable, g1Var.zzf);
    }

    public static g1$a M() {
        return zzg.s();
    }

    public static g1 N() {
        return zzg;
    }

    public static /* synthetic */ g1 O() {
        return zzg;
    }

    public static void w(g1 g1Var) {
        Objects.requireNonNull(g1Var);
        g1Var.zzc = q5.k;
    }

    public static void x(g1 g1Var, int i) {
        b5<z0> b5Var = g1Var.zze;
        if (!b5Var.a()) {
            g1Var.zze = u4.n(b5Var);
        }
        g1Var.zze.remove(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void y(g1 g1Var, Iterable iterable) {
        c5 c5Var = g1Var.zzc;
        if (!((o3) c5Var).j) {
            g1Var.zzc = u4.o(c5Var);
        }
        l3.c(iterable, g1Var.zzc);
    }

    public final h1 A(int i) {
        return this.zzf.get(i);
    }

    public final List<Long> E() {
        return this.zzd;
    }

    public final int G() {
        return ((q5) this.zzd).size();
    }

    public final List<z0> I() {
        return this.zze;
    }

    public final int J() {
        return this.zze.size();
    }

    public final List<h1> K() {
        return this.zzf;
    }

    public final int L() {
        return this.zzf.size();
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (k1.a[i - 1]) {
            case 1:
                return new g1();
            case 2:
                return new g1$a(null);
            case 3:
                return new o6(zzg, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzc", "zzd", "zze", z0.class, "zzf", h1.class});
            case 4:
                return zzg;
            case 5:
                j6<g1> u4_a = zzh;
                if (u4_a == null) {
                    synchronized (g1.class) {
                        u4_a = zzh;
                        if (u4_a == null) {
                            u4_a = new u4$a<>(zzg);
                            zzh = u4_a;
                        }
                        break;
                    }
                }
                return u4_a;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final z0 u(int i) {
        return this.zze.get(i);
    }

    public final List<Long> v() {
        return this.zzc;
    }

    public final int z() {
        return ((q5) this.zzc).size();
    }
}
