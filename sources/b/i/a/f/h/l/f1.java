package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class f1 extends u4<f1, f1$a> implements d6 {
    private static final f1 zzf;
    private static volatile j6<f1> zzg;
    private int zzc;
    private int zzd = 1;
    private b5<b1> zze = m6.k;

    static {
        f1 f1Var = new f1();
        zzf = f1Var;
        u4.r(f1.class, f1Var);
    }

    public static /* synthetic */ f1 u() {
        return zzf;
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (k1.a[i - 1]) {
            case 1:
                return new f1();
            case 2:
                return new f1$a(null);
            case 3:
                return new o6(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zzc", "zzd", m1.a, "zze", b1.class});
            case 4:
                return zzf;
            case 5:
                j6<f1> u4_a = zzg;
                if (u4_a == null) {
                    synchronized (f1.class) {
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
