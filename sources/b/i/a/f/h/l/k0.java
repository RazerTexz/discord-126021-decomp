package b.i.a.f.h.l;

import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class k0 extends u4<k0, k0$a> implements d6 {
    private static final k0 zzi;
    private static volatile j6<k0> zzj;
    private int zzc;
    private int zzd;
    private b5<o0> zze;
    private b5<l0> zzf;
    private boolean zzg;
    private boolean zzh;

    static {
        k0 k0Var = new k0();
        zzi = k0Var;
        u4.r(k0.class, k0Var);
    }

    public k0() {
        m6<Object> m6Var = m6.k;
        this.zze = m6Var;
        this.zzf = m6Var;
    }

    public static /* synthetic */ k0 E() {
        return zzi;
    }

    public static void v(k0 k0Var, int i, l0 l0Var) {
        Objects.requireNonNull(k0Var);
        b5<l0> b5Var = k0Var.zzf;
        if (!b5Var.a()) {
            k0Var.zzf = u4.n(b5Var);
        }
        k0Var.zzf.set(i, l0Var);
    }

    public static void w(k0 k0Var, int i, o0 o0Var) {
        Objects.requireNonNull(k0Var);
        b5<o0> b5Var = k0Var.zze;
        if (!b5Var.a()) {
            k0Var.zze = u4.n(b5Var);
        }
        k0Var.zze.set(i, o0Var);
    }

    public final List<o0> A() {
        return this.zze;
    }

    public final int B() {
        return this.zze.size();
    }

    public final List<l0> C() {
        return this.zzf;
    }

    public final int D() {
        return this.zzf.size();
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (q0.a[i - 1]) {
            case 1:
                return new k0();
            case 2:
                return new k0$a(null);
            case 3:
                return new o6(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zzc", "zzd", "zze", o0.class, "zzf", l0.class, "zzg", "zzh"});
            case 4:
                return zzi;
            case 5:
                j6<k0> u4_a = zzj;
                if (u4_a == null) {
                    synchronized (k0.class) {
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

    public final o0 u(int i) {
        return this.zze.get(i);
    }

    public final boolean x() {
        return (this.zzc & 1) != 0;
    }

    public final int y() {
        return this.zzd;
    }

    public final l0 z(int i) {
        return this.zzf.get(i);
    }
}
