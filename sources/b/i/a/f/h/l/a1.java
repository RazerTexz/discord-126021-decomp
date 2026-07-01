package b.i.a.f.h.l;

import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class a1 extends u4<a1, a1$a> implements d6 {
    private static final a1 zzi;
    private static volatile j6<a1> zzj;
    private int zzc;
    private b5<c1> zzd = m6.k;
    private String zze = "";
    private long zzf;
    private long zzg;
    private int zzh;

    static {
        a1 a1Var = new a1();
        zzi = a1Var;
        u4.r(a1.class, a1Var);
    }

    public static void A(a1 a1Var, c1 c1Var) {
        Objects.requireNonNull(a1Var);
        c1Var.getClass();
        a1Var.O();
        a1Var.zzd.add(c1Var);
    }

    public static void B(a1 a1Var, Iterable iterable) {
        a1Var.O();
        l3.c(iterable, a1Var.zzd);
    }

    public static void C(a1 a1Var, String str) {
        Objects.requireNonNull(a1Var);
        str.getClass();
        a1Var.zzc |= 1;
        a1Var.zze = str;
    }

    public static void E(a1 a1Var, long j) {
        a1Var.zzc |= 4;
        a1Var.zzg = j;
    }

    public static a1$a M() {
        return zzi.s();
    }

    public static /* synthetic */ a1 N() {
        return zzi;
    }

    public static void w(a1 a1Var) {
        Objects.requireNonNull(a1Var);
        a1Var.zzd = m6.k;
    }

    public static void x(a1 a1Var, int i) {
        a1Var.O();
        a1Var.zzd.remove(i);
    }

    public static void y(a1 a1Var, int i, c1 c1Var) {
        Objects.requireNonNull(a1Var);
        c1Var.getClass();
        a1Var.O();
        a1Var.zzd.set(i, c1Var);
    }

    public static void z(a1 a1Var, long j) {
        a1Var.zzc |= 2;
        a1Var.zzf = j;
    }

    public final int D() {
        return this.zzd.size();
    }

    public final String F() {
        return this.zze;
    }

    public final boolean G() {
        return (this.zzc & 2) != 0;
    }

    public final long H() {
        return this.zzf;
    }

    public final boolean I() {
        return (this.zzc & 4) != 0;
    }

    public final long J() {
        return this.zzg;
    }

    public final boolean K() {
        return (this.zzc & 8) != 0;
    }

    public final int L() {
        return this.zzh;
    }

    public final void O() {
        b5<c1> b5Var = this.zzd;
        if (b5Var.a()) {
            return;
        }
        this.zzd = u4.n(b5Var);
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (k1.a[i - 1]) {
            case 1:
                return new a1();
            case 2:
                return new a1$a(null);
            case 3:
                return new o6(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zzc", "zzd", c1.class, "zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzi;
            case 5:
                j6<a1> u4_a = zzj;
                if (u4_a == null) {
                    synchronized (a1.class) {
                        u4_a = zzj;
                        if (u4_a == null) {
                            u4_a = new u4$a<>(zzi);
                            zzj = u4_a;
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

    public final c1 u(int i) {
        return this.zzd.get(i);
    }

    public final List<c1> v() {
        return this.zzd;
    }
}
