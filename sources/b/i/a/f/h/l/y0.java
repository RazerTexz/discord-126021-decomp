package b.i.a.f.h.l;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class y0 extends u4<y0, y0$a> implements d6 {
    private static final y0 zzh;
    private static volatile j6<y0> zzi;
    private int zzc;
    private int zzd;
    private g1 zze;
    private g1 zzf;
    private boolean zzg;

    static {
        y0 y0Var = new y0();
        zzh = y0Var;
        u4.r(y0.class, y0Var);
    }

    public static y0$a F() {
        return zzh.s();
    }

    public static /* synthetic */ y0 G() {
        return zzh;
    }

    public static void u(y0 y0Var, int i) {
        y0Var.zzc |= 1;
        y0Var.zzd = i;
    }

    public static void v(y0 y0Var, g1 g1Var) {
        Objects.requireNonNull(y0Var);
        y0Var.zze = g1Var;
        y0Var.zzc |= 2;
    }

    public static void w(y0 y0Var, boolean z2) {
        y0Var.zzc |= 8;
        y0Var.zzg = z2;
    }

    public static void z(y0 y0Var, g1 g1Var) {
        Objects.requireNonNull(y0Var);
        g1Var.getClass();
        y0Var.zzf = g1Var;
        y0Var.zzc |= 4;
    }

    public final g1 A() {
        g1 g1Var = this.zze;
        return g1Var == null ? g1.N() : g1Var;
    }

    public final boolean B() {
        return (this.zzc & 4) != 0;
    }

    public final g1 C() {
        g1 g1Var = this.zzf;
        return g1Var == null ? g1.N() : g1Var;
    }

    public final boolean D() {
        return (this.zzc & 8) != 0;
    }

    public final boolean E() {
        return this.zzg;
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (k1.a[i - 1]) {
            case 1:
                return new y0();
            case 2:
                return new y0$a(null);
            case 3:
                return new o6(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                j6<y0> u4_a = zzi;
                if (u4_a == null) {
                    synchronized (y0.class) {
                        u4_a = zzi;
                        if (u4_a == null) {
                            u4_a = new u4$a<>(zzh);
                            zzi = u4_a;
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

    public final boolean x() {
        return (this.zzc & 1) != 0;
    }

    public final int y() {
        return this.zzd;
    }
}
