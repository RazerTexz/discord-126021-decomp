package p007b.p225i.p226a.p288f.p313h.p325l;

import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4;

/* JADX INFO: renamed from: b.i.a.f.h.l.v0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3860v0 extends AbstractC3851u4<C3860v0, a> implements InterfaceC3626d6 {
    private static final C3860v0 zzf;
    private static volatile InterfaceC3710j6<C3860v0> zzg;
    private int zzc;
    private String zzd = "";
    private String zze = "";

    /* JADX INFO: renamed from: b.i.a.f.h.l.v0$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends AbstractC3851u4.b<C3860v0, a> implements InterfaceC3626d6 {
        public a(C3886x0 c3886x0) {
            super(C3860v0.zzf);
        }
    }

    static {
        C3860v0 c3860v0 = new C3860v0();
        zzf = c3860v0;
        AbstractC3851u4.m5313r(C3860v0.class, c3860v0);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4
    /* JADX INFO: renamed from: p */
    public final Object mo4541p(int i, Object obj, Object obj2) {
        switch (C3886x0.f10398a[i - 1]) {
            case 1:
                return new C3860v0();
            case 2:
                return new a(null);
            case 3:
                return new C3775o6(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                InterfaceC3710j6<C3860v0> aVar = zzg;
                if (aVar == null) {
                    synchronized (C3860v0.class) {
                        aVar = zzg;
                        if (aVar == null) {
                            aVar = new AbstractC3851u4.a<>(zzf);
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

    /* JADX INFO: renamed from: u */
    public final String m5330u() {
        return this.zzd;
    }

    /* JADX INFO: renamed from: v */
    public final String m5331v() {
        return this.zze;
    }
}
