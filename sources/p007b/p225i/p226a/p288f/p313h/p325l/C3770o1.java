package p007b.p225i.p226a.p288f.p313h.p325l;

/* JADX INFO: renamed from: b.i.a.f.h.l.o1 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3770o1 extends AbstractC3851u4<C3770o1, a> implements InterfaceC3626d6 {
    private static final C3770o1 zzf;
    private static volatile InterfaceC3710j6<C3770o1> zzg;
    private int zzc;
    private String zzd = "";
    private InterfaceC3597b5<C3796q1> zze = C3749m6.f10094k;

    /* JADX INFO: renamed from: b.i.a.f.h.l.o1$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends AbstractC3851u4.b<C3770o1, a> implements InterfaceC3626d6 {
        public a(C3809r1 c3809r1) {
            super(C3770o1.zzf);
        }
    }

    static {
        C3770o1 c3770o1 = new C3770o1();
        zzf = c3770o1;
        AbstractC3851u4.m5313r(C3770o1.class, c3770o1);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4
    /* JADX INFO: renamed from: p */
    public final Object mo4541p(int i, Object obj, Object obj2) {
        switch (C3809r1.f10282a[i - 1]) {
            case 1:
                return new C3770o1();
            case 2:
                return new a(null);
            case 3:
                return new C3775o6(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zzc", "zzd", "zze", C3796q1.class});
            case 4:
                return zzf;
            case 5:
                InterfaceC3710j6<C3770o1> aVar = zzg;
                if (aVar == null) {
                    synchronized (C3770o1.class) {
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
}
