package b.i.a.f.h.l;

import b.i.a.f.h.l.u4;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class b1 extends u4<b1, a> implements d6 {
    private static final b1 zzf;
    private static volatile j6<b1> zzg;
    private int zzc;
    private String zzd = "";
    private long zze;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends u4.b<b1, a> implements d6 {
        public a(k1 k1Var) {
            super(b1.zzf);
        }
    }

    static {
        b1 b1Var = new b1();
        zzf = b1Var;
        u4.r(b1.class, b1Var);
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (k1.a[i - 1]) {
            case 1:
                return new b1();
            case 2:
                return new a(null);
            case 3:
                return new o6(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                j6<b1> aVar = zzg;
                if (aVar == null) {
                    synchronized (b1.class) {
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
