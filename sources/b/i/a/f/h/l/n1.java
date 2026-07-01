package b.i.a.f.h.l;

import b.i.a.f.h.l.u4;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class n1 extends u4<n1, a> implements d6 {
    private static final n1 zzd;
    private static volatile j6<n1> zze;
    private b5<o1> zzc = m6.k;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends u4.b<n1, a> implements d6 {
        public a(r1 r1Var) {
            super(n1.zzd);
        }
    }

    static {
        n1 n1Var = new n1();
        zzd = n1Var;
        u4.r(n1.class, n1Var);
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (r1.a[i - 1]) {
            case 1:
                return new n1();
            case 2:
                return new a(null);
            case 3:
                return new o6(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", o1.class});
            case 4:
                return zzd;
            case 5:
                j6<n1> aVar = zze;
                if (aVar == null) {
                    synchronized (n1.class) {
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
}
