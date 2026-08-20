package p007b.p225i.p226a.p288f.p313h.p325l;

/* JADX INFO: renamed from: b.i.a.f.h.l.n1 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3757n1 extends AbstractC3851u4<C3757n1, a> implements InterfaceC3626d6 {
    private static final C3757n1 zzd;
    private static volatile InterfaceC3710j6<C3757n1> zze;
    private InterfaceC3597b5<C3770o1> zzc = C3749m6.f10094k;

    /* JADX INFO: renamed from: b.i.a.f.h.l.n1$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends AbstractC3851u4.b<C3757n1, a> implements InterfaceC3626d6 {
        public a(C3809r1 c3809r1) {
            super(C3757n1.zzd);
        }
    }

    static {
        C3757n1 c3757n1 = new C3757n1();
        zzd = c3757n1;
        AbstractC3851u4.m5313r(C3757n1.class, c3757n1);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4
    /* JADX INFO: renamed from: p */
    public final Object mo4541p(int i, Object obj, Object obj2) {
        switch (C3809r1.f10282a[i - 1]) {
            case 1:
                return new C3757n1();
            case 2:
                return new a(null);
            case 3:
                return new C3775o6(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", C3770o1.class});
            case 4:
                return zzd;
            case 5:
                InterfaceC3710j6<C3757n1> aVar = zze;
                if (aVar == null) {
                    synchronized (C3757n1.class) {
                        aVar = zze;
                        if (aVar == null) {
                            aVar = new AbstractC3851u4.a<>(zzd);
                            zze = aVar;
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
