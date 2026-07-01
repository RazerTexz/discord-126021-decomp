package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class p1 extends u4<p1, p1$a> implements d6 {
    private static final p1 zzf;
    private static volatile j6<p1> zzg;
    private int zzc;
    private b5<q1> zzd = m6.k;
    private n1 zze;

    static {
        p1 p1Var = new p1();
        zzf = p1Var;
        u4.r(p1.class, p1Var);
    }

    public static /* synthetic */ p1 u() {
        return zzf;
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (r1.a[i - 1]) {
            case 1:
                return new p1();
            case 2:
                return new p1$a(null);
            case 3:
                return new o6(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zzc", "zzd", q1.class, "zze"});
            case 4:
                return zzf;
            case 5:
                j6<p1> u4_a = zzg;
                if (u4_a == null) {
                    synchronized (p1.class) {
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
