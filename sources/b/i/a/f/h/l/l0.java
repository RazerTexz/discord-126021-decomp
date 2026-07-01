package b.i.a.f.h.l;

import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class l0 extends u4<l0, l0$a> implements d6 {
    private static final l0 zzl;
    private static volatile j6<l0> zzm;
    private int zzc;
    private int zzd;
    private String zze = "";
    private b5<m0> zzf = m6.k;
    private boolean zzg;
    private n0 zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;

    static {
        l0 l0Var = new l0();
        zzl = l0Var;
        u4.r(l0.class, l0Var);
    }

    public static l0$a I() {
        return zzl.s();
    }

    public static /* synthetic */ l0 J() {
        return zzl;
    }

    public static void v(l0 l0Var, int i, m0 m0Var) {
        Objects.requireNonNull(l0Var);
        m0Var.getClass();
        b5<m0> b5Var = l0Var.zzf;
        if (!b5Var.a()) {
            l0Var.zzf = u4.n(b5Var);
        }
        l0Var.zzf.set(i, m0Var);
    }

    public static void w(l0 l0Var, String str) {
        Objects.requireNonNull(l0Var);
        str.getClass();
        l0Var.zzc |= 2;
        l0Var.zze = str;
    }

    public final List<m0> A() {
        return this.zzf;
    }

    public final int B() {
        return this.zzf.size();
    }

    public final boolean C() {
        return (this.zzc & 8) != 0;
    }

    public final n0 D() {
        n0 n0Var = this.zzh;
        return n0Var == null ? n0.E() : n0Var;
    }

    public final boolean E() {
        return this.zzi;
    }

    public final boolean F() {
        return this.zzj;
    }

    public final boolean G() {
        return (this.zzc & 64) != 0;
    }

    public final boolean H() {
        return this.zzk;
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (q0.a[i - 1]) {
            case 1:
                return new l0();
            case 2:
                return new l0$a(null);
            case 3:
                return new o6(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", m0.class, "zzg", "zzh", "zzi", "zzj", "zzk"});
            case 4:
                return zzl;
            case 5:
                j6<l0> u4_a = zzm;
                if (u4_a == null) {
                    synchronized (l0.class) {
                        u4_a = zzm;
                        if (u4_a == null) {
                            u4_a = new u4$a<>(zzl);
                            zzm = u4_a;
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

    public final m0 u(int i) {
        return this.zzf.get(i);
    }

    public final boolean x() {
        return (this.zzc & 1) != 0;
    }

    public final int y() {
        return this.zzd;
    }

    public final String z() {
        return this.zze;
    }
}
