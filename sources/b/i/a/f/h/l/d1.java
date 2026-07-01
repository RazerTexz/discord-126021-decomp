package b.i.a.f.h.l;

import b.i.a.f.h.l.e1;
import b.i.a.f.h.l.u4;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class d1 extends u4<d1, a> implements d6 {
    private static final d1 zzd;
    private static volatile j6<d1> zze;
    private b5<e1> zzc = m6.k;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends u4.b<d1, a> implements d6 {
        public a() {
            super(d1.zzd);
        }

        public final a q(e1.a aVar) {
            if (this.l) {
                n();
                this.l = false;
            }
            d1.w((d1) this.k, (e1) ((u4) aVar.p()));
            return this;
        }

        public a(k1 k1Var) {
            super(d1.zzd);
        }
    }

    static {
        d1 d1Var = new d1();
        zzd = d1Var;
        u4.r(d1.class, d1Var);
    }

    public static void w(d1 d1Var, e1 e1Var) {
        Objects.requireNonNull(d1Var);
        b5<e1> b5Var = d1Var.zzc;
        if (!b5Var.a()) {
            d1Var.zzc = u4.n(b5Var);
        }
        d1Var.zzc.add(e1Var);
    }

    public static a x() {
        return zzd.s();
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (k1.a[i - 1]) {
            case 1:
                return new d1();
            case 2:
                return new a(null);
            case 3:
                return new o6(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", e1.class});
            case 4:
                return zzd;
            case 5:
                j6<d1> aVar = zze;
                if (aVar == null) {
                    synchronized (d1.class) {
                        aVar = zze;
                        if (aVar == null) {
                            aVar = new u4.a<>(zzd);
                            zze = aVar;
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

    public final e1 u() {
        return this.zzc.get(0);
    }

    public final List<e1> v() {
        return this.zzc;
    }
}
