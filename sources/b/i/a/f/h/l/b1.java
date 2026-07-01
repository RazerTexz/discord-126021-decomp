package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class b1 extends u4<b1, b1$a> implements d6 {
    private static final b1 zzf;
    private static volatile j6<b1> zzg;
    private int zzc;
    private String zzd = "";
    private long zze;

    static {
        b1 b1Var = new b1();
        zzf = b1Var;
        u4.r(b1.class, b1Var);
    }

    public static /* synthetic */ b1 u() {
        return zzf;
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (k1.a[i - 1]) {
            case 1:
                return new b1();
            case 2:
                return new b1$a(null);
            case 3:
                return new o6(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                j6<b1> u4_a = zzg;
                if (u4_a == null) {
                    synchronized (b1.class) {
                        u4_a = zzg;
                        if (u4_a == null) {
                            u4_a = new u4$a<>(zzf);
                            zzg = u4_a;
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
}
