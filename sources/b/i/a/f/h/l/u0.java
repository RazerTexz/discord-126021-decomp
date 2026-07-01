package b.i.a.f.h.l;

import b.i.a.f.h.l.u4;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class u0 extends u4<u0, a> implements d6 {
    private static final u0 zzm;
    private static volatile j6<u0> zzn;
    private int zzc;
    private long zzd;
    private String zze = "";
    private int zzf;
    private b5<v0> zzg;
    private b5<t0> zzh;
    private b5<k0> zzi;
    private String zzj;
    private boolean zzk;
    private b5<p1> zzl;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends u4.b<u0, a> implements d6 {
        public a() {
            super(u0.zzm);
        }

        public a(x0 x0Var) {
            super(u0.zzm);
        }
    }

    static {
        u0 u0Var = new u0();
        zzm = u0Var;
        u4.r(u0.class, u0Var);
    }

    public u0() {
        m6<Object> m6Var = m6.k;
        this.zzg = m6Var;
        this.zzh = m6Var;
        this.zzi = m6Var;
        this.zzj = "";
        this.zzl = m6Var;
    }

    public static a F() {
        return zzm.s();
    }

    public static u0 G() {
        return zzm;
    }

    public static void v(u0 u0Var) {
        Objects.requireNonNull(u0Var);
        u0Var.zzi = m6.k;
    }

    public static void w(u0 u0Var, int i, t0 t0Var) {
        Objects.requireNonNull(u0Var);
        b5<t0> b5Var = u0Var.zzh;
        if (!b5Var.a()) {
            u0Var.zzh = u4.n(b5Var);
        }
        u0Var.zzh.set(i, t0Var);
    }

    public final String A() {
        return this.zze;
    }

    public final List<v0> B() {
        return this.zzg;
    }

    public final int C() {
        return this.zzh.size();
    }

    public final List<k0> D() {
        return this.zzi;
    }

    public final boolean E() {
        return this.zzk;
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (x0.a[i - 1]) {
            case 1:
                return new u0();
            case 2:
                return new a(null);
            case 3:
                return new o6(zzm, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0004\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", v0.class, "zzh", t0.class, "zzi", k0.class, "zzj", "zzk", "zzl", p1.class});
            case 4:
                return zzm;
            case 5:
                j6<u0> aVar = zzn;
                if (aVar == null) {
                    synchronized (u0.class) {
                        aVar = zzn;
                        if (aVar == null) {
                            aVar = new u4.a<>(zzm);
                            zzn = aVar;
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

    public final t0 u(int i) {
        return this.zzh.get(i);
    }

    public final boolean x() {
        return (this.zzc & 1) != 0;
    }

    public final long y() {
        return this.zzd;
    }

    public final boolean z() {
        return (this.zzc & 2) != 0;
    }
}
