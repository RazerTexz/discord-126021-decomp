package b.i.a.f.h.l;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class t0 extends u4<t0, t0$a> implements d6 {
    private static final t0 zzh;
    private static volatile j6<t0> zzi;
    private int zzc;
    private String zzd = "";
    private boolean zze;
    private boolean zzf;
    private int zzg;

    static {
        t0 t0Var = new t0();
        zzh = t0Var;
        u4.r(t0.class, t0Var);
    }

    public static /* synthetic */ t0 A() {
        return zzh;
    }

    public static void v(t0 t0Var, String str) {
        Objects.requireNonNull(t0Var);
        str.getClass();
        t0Var.zzc |= 1;
        t0Var.zzd = str;
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (x0.a[i - 1]) {
            case 1:
                return new t0();
            case 2:
                return new t0$a(null);
            case 3:
                return new o6(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                j6<t0> u4_a = zzi;
                if (u4_a == null) {
                    synchronized (t0.class) {
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

    public final String u() {
        return this.zzd;
    }

    public final boolean w() {
        return this.zze;
    }

    public final boolean x() {
        return this.zzf;
    }

    public final boolean y() {
        return (this.zzc & 8) != 0;
    }

    public final int z() {
        return this.zzg;
    }
}
