package b.i.a.f.h.l;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class p0 extends u4<p0, p0$a> implements d6 {
    private static final p0 zzh;
    private static volatile j6<p0> zzi;
    private int zzc;
    private int zzd;
    private boolean zzf;
    private String zze = "";
    private b5<String> zzg = m6.k;

    static {
        p0 p0Var = new p0();
        zzh = p0Var;
        u4.r(p0.class, p0Var);
    }

    public static p0 C() {
        return zzh;
    }

    public static /* synthetic */ p0 D() {
        return zzh;
    }

    public final List<String> A() {
        return this.zzg;
    }

    public final int B() {
        return this.zzg.size();
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (q0.a[i - 1]) {
            case 1:
                return new p0();
            case 2:
                return new p0$a(null);
            case 3:
                return new o6(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zzc", "zzd", w0.a, "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                j6<p0> u4_a = zzi;
                if (u4_a == null) {
                    synchronized (p0.class) {
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

    public final boolean u() {
        return (this.zzc & 1) != 0;
    }

    public final p0$b v() {
        p0$b p0_bF = p0$b.f(this.zzd);
        return p0_bF == null ? p0$b.UNKNOWN_MATCH_TYPE : p0_bF;
    }

    public final boolean w() {
        return (this.zzc & 2) != 0;
    }

    public final String x() {
        return this.zze;
    }

    public final boolean y() {
        return (this.zzc & 4) != 0;
    }

    public final boolean z() {
        return this.zzf;
    }
}
