package b.i.a.f.h.l;

import b.i.a.f.h.l.u4;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class p1 extends u4<p1, a> implements d6 {
    private static final p1 zzf;
    private static volatile j6<p1> zzg;
    private int zzc;
    private b5<q1> zzd = m6.k;
    private n1 zze;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends u4.b<p1, a> implements d6 {
        public a(r1 r1Var) {
            super(p1.zzf);
        }
    }

    static {
        p1 p1Var = new p1();
        zzf = p1Var;
        u4.r(p1.class, p1Var);
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (r1.a[i - 1]) {
            case 1:
                return new p1();
            case 2:
                return new a(null);
            case 3:
                return new o6(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zzc", "zzd", q1.class, "zze"});
            case 4:
                return zzf;
            case 5:
                j6<p1> aVar = zzg;
                if (aVar == null) {
                    synchronized (p1.class) {
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
}
