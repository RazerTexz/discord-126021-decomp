package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class q1 extends u4<q1, q1$b> implements d6 {
    private static final q1 zzk;
    private static volatile j6<q1> zzl;
    private int zzc;
    private int zzd;
    private boolean zzf;
    private long zzg;
    private double zzh;
    private String zze = "";
    private b5<q1> zzi = m6.k;
    private String zzj = "";

    static {
        q1 q1Var = new q1();
        zzk = q1Var;
        u4.r(q1.class, q1Var);
    }

    public static /* synthetic */ q1 u() {
        return zzk;
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (r1.a[i - 1]) {
            case 1:
                return new q1();
            case 2:
                return new q1$b(null);
            case 3:
                return new o6(zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004ဂ\u0003\u0005က\u0004\u0006\u001b\u0007ဈ\u0005", new Object[]{"zzc", "zzd", s1.a, "zze", "zzf", "zzg", "zzh", "zzi", q1.class, "zzj"});
            case 4:
                return zzk;
            case 5:
                j6<q1> u4_a = zzl;
                if (u4_a == null) {
                    synchronized (q1.class) {
                        u4_a = zzl;
                        if (u4_a == null) {
                            u4_a = new u4$a<>(zzk);
                            zzl = u4_a;
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
