package b.i.a.f.h.l;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class o0 extends u4<o0, o0$a> implements d6 {
    private static final o0 zzj;
    private static volatile j6<o0> zzk;
    private int zzc;
    private int zzd;
    private String zze = "";
    private m0 zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;

    static {
        o0 o0Var = new o0();
        zzj = o0Var;
        u4.r(o0.class, o0Var);
    }

    public static o0$a D() {
        return zzj.s();
    }

    public static /* synthetic */ o0 E() {
        return zzj;
    }

    public static void u(o0 o0Var, String str) {
        Objects.requireNonNull(o0Var);
        str.getClass();
        o0Var.zzc |= 2;
        o0Var.zze = str;
    }

    public final boolean A() {
        return this.zzh;
    }

    public final boolean B() {
        return (this.zzc & 32) != 0;
    }

    public final boolean C() {
        return this.zzi;
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (q0.a[i - 1]) {
            case 1:
                return new o0();
            case 2:
                return new o0$a(null);
            case 3:
                return new o6(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzj;
            case 5:
                j6<o0> u4_a = zzk;
                if (u4_a == null) {
                    synchronized (o0.class) {
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

    public final boolean v() {
        return (this.zzc & 1) != 0;
    }

    public final int w() {
        return this.zzd;
    }

    public final String x() {
        return this.zze;
    }

    public final m0 y() {
        m0 m0Var = this.zzf;
        return m0Var == null ? m0.D() : m0Var;
    }

    public final boolean z() {
        return this.zzg;
    }
}
