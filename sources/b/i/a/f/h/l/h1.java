package b.i.a.f.h.l;

import b.i.a.f.h.l.u4;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class h1 extends u4<h1, a> implements d6 {
    private static final h1 zzf;
    private static volatile j6<h1> zzg;
    private int zzc;
    private int zzd;
    private c5 zze = q5.k;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends u4.b<h1, a> implements d6 {
        public a() {
            super(h1.zzf);
        }

        public a(k1 k1Var) {
            super(h1.zzf);
        }
    }

    static {
        h1 h1Var = new h1();
        zzf = h1Var;
        u4.r(h1.class, h1Var);
    }

    public static a B() {
        return zzf.s();
    }

    public static void v(h1 h1Var, int i) {
        h1Var.zzc |= 1;
        h1Var.zzd = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void w(h1 h1Var, Iterable iterable) {
        c5 c5Var = h1Var.zze;
        if (!((o3) c5Var).j) {
            h1Var.zze = u4.o(c5Var);
        }
        l3.c(iterable, h1Var.zze);
    }

    public final int A() {
        return ((q5) this.zze).size();
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (k1.a[i - 1]) {
            case 1:
                return new h1();
            case 2:
                return new a(null);
            case 3:
                return new o6(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                j6<h1> aVar = zzg;
                if (aVar == null) {
                    synchronized (h1.class) {
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

    public final long u(int i) {
        q5 q5Var = (q5) this.zze;
        q5Var.h(i);
        return q5Var.l[i];
    }

    public final boolean x() {
        return (this.zzc & 1) != 0;
    }

    public final int y() {
        return this.zzd;
    }

    public final List<Long> z() {
        return this.zze;
    }
}
