package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class v0 extends u4<v0, v0$a> implements d6 {
    private static final v0 zzf;
    private static volatile j6<v0> zzg;
    private int zzc;
    private String zzd = "";
    private String zze = "";

    static {
        v0 v0Var = new v0();
        zzf = v0Var;
        u4.r(v0.class, v0Var);
    }

    public static /* synthetic */ v0 w() {
        return zzf;
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (x0.a[i - 1]) {
            case 1:
                return new v0();
            case 2:
                return new v0$a(null);
            case 3:
                return new o6(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                j6<v0> u4_a = zzg;
                if (u4_a == null) {
                    synchronized (v0.class) {
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

    public final String u() {
        return this.zzd;
    }

    public final String v() {
        return this.zze;
    }
}
