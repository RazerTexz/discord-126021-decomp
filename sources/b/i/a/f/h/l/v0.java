package b.i.a.f.h.l;

import b.i.a.f.h.l.u4;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class v0 extends u4<v0, a> implements d6 {
    private static final v0 zzf;
    private static volatile j6<v0> zzg;
    private int zzc;
    private String zzd = "";
    private String zze = "";

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends u4.b<v0, a> implements d6 {
        public a(x0 x0Var) {
            super(v0.zzf);
        }
    }

    static {
        v0 v0Var = new v0();
        zzf = v0Var;
        u4.r(v0.class, v0Var);
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (x0.a[i - 1]) {
            case 1:
                return new v0();
            case 2:
                return new a(null);
            case 3:
                return new o6(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                j6<v0> aVar = zzg;
                if (aVar == null) {
                    synchronized (v0.class) {
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

    public final String u() {
        return this.zzd;
    }

    public final String v() {
        return this.zze;
    }
}
