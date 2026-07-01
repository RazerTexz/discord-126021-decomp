package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class o1 extends u4<o1, o1$a> implements d6 {
    private static final o1 zzf;
    private static volatile j6<o1> zzg;
    private int zzc;
    private String zzd = "";
    private b5<q1> zze = m6.k;

    static {
        o1 o1Var = new o1();
        zzf = o1Var;
        u4.r(o1.class, o1Var);
    }

    public static /* synthetic */ o1 u() {
        return zzf;
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (r1.a[i - 1]) {
            case 1:
                return new o1();
            case 2:
                return new o1$a(null);
            case 3:
                return new o6(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zzc", "zzd", "zze", q1.class});
            case 4:
                return zzf;
            case 5:
                j6<o1> u4_a = zzg;
                if (u4_a == null) {
                    synchronized (o1.class) {
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
