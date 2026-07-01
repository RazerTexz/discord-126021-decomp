package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class n0 extends u4<n0, n0$b> implements d6 {
    private static final n0 zzi;
    private static volatile j6<n0> zzj;
    private int zzc;
    private int zzd;
    private boolean zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";

    static {
        n0 n0Var = new n0();
        zzi = n0Var;
        u4.r(n0.class, n0Var);
    }

    public static n0 E() {
        return zzi;
    }

    public static /* synthetic */ n0 F() {
        return zzi;
    }

    public final boolean A() {
        return (this.zzc & 8) != 0;
    }

    public final String B() {
        return this.zzg;
    }

    public final boolean C() {
        return (this.zzc & 16) != 0;
    }

    public final String D() {
        return this.zzh;
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (q0.a[i - 1]) {
            case 1:
                return new n0();
            case 2:
                return new n0$b(null);
            case 3:
                return new o6(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zzc", "zzd", r0.a, "zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzi;
            case 5:
                j6<n0> u4_a = zzj;
                if (u4_a == null) {
                    synchronized (n0.class) {
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

    public final boolean u() {
        return (this.zzc & 1) != 0;
    }

    public final n0$a v() {
        n0$a n0_aF = n0$a.f(this.zzd);
        return n0_aF == null ? n0$a.UNKNOWN_COMPARISON_TYPE : n0_aF;
    }

    public final boolean w() {
        return (this.zzc & 2) != 0;
    }

    public final boolean x() {
        return this.zze;
    }

    public final boolean y() {
        return (this.zzc & 4) != 0;
    }

    public final String z() {
        return this.zzf;
    }
}
