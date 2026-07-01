package b.i.a.f.h.l;

import b.i.a.f.h.l.u4;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class o1 extends u4<o1, a> implements d6 {
    private static final o1 zzf;
    private static volatile j6<o1> zzg;
    private int zzc;
    private String zzd = "";
    private b5<q1> zze = m6.k;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends u4.b<o1, a> implements d6 {
        public a(r1 r1Var) {
            super(o1.zzf);
        }
    }

    static {
        o1 o1Var = new o1();
        zzf = o1Var;
        u4.r(o1.class, o1Var);
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (r1.a[i - 1]) {
            case 1:
                return new o1();
            case 2:
                return new a(null);
            case 3:
                return new o6(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zzc", "zzd", "zze", q1.class});
            case 4:
                return zzf;
            case 5:
                j6<o1> aVar = zzg;
                if (aVar == null) {
                    synchronized (o1.class) {
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
