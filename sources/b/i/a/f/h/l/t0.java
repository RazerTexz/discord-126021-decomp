package b.i.a.f.h.l;

import b.i.a.f.h.l.u4;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class t0 extends u4<t0, a> implements d6 {
    private static final t0 zzh;
    private static volatile j6<t0> zzi;
    private int zzc;
    private String zzd = "";
    private boolean zze;
    private boolean zzf;
    private int zzg;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends u4.b<t0, a> implements d6 {
        public a() {
            super(t0.zzh);
        }

        public final String q() {
            return ((t0) this.k).u();
        }

        public final int r() {
            return ((t0) this.k).z();
        }

        public a(x0 x0Var) {
            super(t0.zzh);
        }
    }

    static {
        t0 t0Var = new t0();
        zzh = t0Var;
        u4.r(t0.class, t0Var);
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
                return new a(null);
            case 3:
                return new o6(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                j6<t0> aVar = zzi;
                if (aVar == null) {
                    synchronized (t0.class) {
                        aVar = zzi;
                        if (aVar == null) {
                            aVar = new u4.a<>(zzh);
                            zzi = aVar;
                        }
                        break;
                    }
                }
                return aVar;
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
