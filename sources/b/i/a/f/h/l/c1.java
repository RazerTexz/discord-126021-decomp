package b.i.a.f.h.l;

import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class c1 extends u4<c1, c1$a> implements d6 {
    private static final c1 zzj;
    private static volatile j6<c1> zzk;
    private int zzc;
    private long zzf;
    private float zzg;
    private double zzh;
    private String zzd = "";
    private String zze = "";
    private b5<c1> zzi = m6.k;

    static {
        c1 c1Var = new c1();
        zzj = c1Var;
        u4.r(c1.class, c1Var);
    }

    public static void C(c1 c1Var) {
        c1Var.zzc &= -5;
        c1Var.zzf = 0L;
    }

    public static void D(c1 c1Var, String str) {
        Objects.requireNonNull(c1Var);
        str.getClass();
        c1Var.zzc |= 2;
        c1Var.zze = str;
    }

    public static void E(c1 c1Var) {
        c1Var.zzc &= -17;
        c1Var.zzh = 0.0d;
    }

    public static void H(c1 c1Var) {
        Objects.requireNonNull(c1Var);
        c1Var.zzi = m6.k;
    }

    public static c1$a Q() {
        return zzj.s();
    }

    public static /* synthetic */ c1 R() {
        return zzj;
    }

    public static void u(c1 c1Var) {
        c1Var.zzc &= -3;
        c1Var.zze = zzj.zze;
    }

    public static void v(c1 c1Var, double d) {
        c1Var.zzc |= 16;
        c1Var.zzh = d;
    }

    public static void w(c1 c1Var, long j) {
        c1Var.zzc |= 4;
        c1Var.zzf = j;
    }

    public static void x(c1 c1Var, c1 c1Var2) {
        Objects.requireNonNull(c1Var);
        b5<c1> b5Var = c1Var.zzi;
        if (!b5Var.a()) {
            c1Var.zzi = u4.n(b5Var);
        }
        c1Var.zzi.add(c1Var2);
    }

    public static void y(c1 c1Var, Iterable iterable) {
        b5<c1> b5Var = c1Var.zzi;
        if (!b5Var.a()) {
            c1Var.zzi = u4.n(b5Var);
        }
        l3.c(iterable, c1Var.zzi);
    }

    public static void z(c1 c1Var, String str) {
        Objects.requireNonNull(c1Var);
        str.getClass();
        c1Var.zzc |= 1;
        c1Var.zzd = str;
    }

    public final boolean A() {
        return (this.zzc & 1) != 0;
    }

    public final String B() {
        return this.zzd;
    }

    public final boolean F() {
        return (this.zzc & 2) != 0;
    }

    public final String G() {
        return this.zze;
    }

    public final boolean I() {
        return (this.zzc & 4) != 0;
    }

    public final long J() {
        return this.zzf;
    }

    public final boolean K() {
        return (this.zzc & 8) != 0;
    }

    public final float L() {
        return this.zzg;
    }

    public final boolean M() {
        return (this.zzc & 16) != 0;
    }

    public final double N() {
        return this.zzh;
    }

    public final List<c1> O() {
        return this.zzi;
    }

    public final int P() {
        return this.zzi.size();
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (k1.a[i - 1]) {
            case 1:
                return new c1();
            case 2:
                return new c1$a(null);
            case 3:
                return new o6(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", c1.class});
            case 4:
                return zzj;
            case 5:
                j6<c1> u4_a = zzk;
                if (u4_a == null) {
                    synchronized (c1.class) {
                        u4_a = zzk;
                        if (u4_a == null) {
                            u4_a = new u4$a<>(zzj);
                            zzk = u4_a;
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
}
