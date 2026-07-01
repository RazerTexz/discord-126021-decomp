package b.i.a.f.h.l;

import b.i.a.f.h.l.u4;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class z0 extends u4<z0, a> implements d6 {
    private static final z0 zzf;
    private static volatile j6<z0> zzg;
    private int zzc;
    private int zzd;
    private long zze;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends u4.b<z0, a> implements d6 {
        public a() {
            super(z0.zzf);
        }

        public a(k1 k1Var) {
            super(z0.zzf);
        }
    }

    static {
        z0 z0Var = new z0();
        zzf = z0Var;
        u4.r(z0.class, z0Var);
    }

    public static a A() {
        return zzf.s();
    }

    public static void u(z0 z0Var, int i) {
        z0Var.zzc |= 1;
        z0Var.zzd = i;
    }

    public static void v(z0 z0Var, long j) {
        z0Var.zzc |= 2;
        z0Var.zze = j;
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (k1.a[i - 1]) {
            case 1:
                return new z0();
            case 2:
                return new a(null);
            case 3:
                return new o6(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                j6<z0> aVar = zzg;
                if (aVar == null) {
                    synchronized (z0.class) {
                        aVar = zzg;
                        if (aVar == null) {
                            aVar = new u4.a<>(zzf);
                            zzg = aVar;
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

    public final boolean w() {
        return (this.zzc & 1) != 0;
    }

    public final int x() {
        return this.zzd;
    }

    public final boolean y() {
        return (this.zzc & 2) != 0;
    }

    public final long z() {
        return this.zze;
    }
}
