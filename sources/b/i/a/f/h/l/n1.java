package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class n1 extends u4<n1, n1$a> implements d6 {
    private static final n1 zzd;
    private static volatile j6<n1> zze;
    private b5<o1> zzc = m6.k;

    static {
        n1 n1Var = new n1();
        zzd = n1Var;
        u4.r(n1.class, n1Var);
    }

    public static /* synthetic */ n1 u() {
        return zzd;
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (r1.a[i - 1]) {
            case 1:
                return new n1();
            case 2:
                return new n1$a(null);
            case 3:
                return new o6(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", o1.class});
            case 4:
                return zzd;
            case 5:
                j6<n1> u4_a = zze;
                if (u4_a == null) {
                    synchronized (n1.class) {
                        u4_a = zze;
                        if (u4_a == null) {
                            u4_a = new u4$a<>(zzd);
                            zze = u4_a;
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
