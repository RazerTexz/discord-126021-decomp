package p007b.p225i.p226a.p288f.p313h.p325l;

import java.util.List;

/* JADX INFO: renamed from: b.i.a.f.h.l.h1 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3677h1 extends AbstractC3851u4<C3677h1, a> implements InterfaceC3626d6 {
    private static final C3677h1 zzf;
    private static volatile InterfaceC3710j6<C3677h1> zzg;
    private int zzc;
    private int zzd;
    private InterfaceC3611c5 zze = C3800q5.f10271k;

    /* JADX INFO: renamed from: b.i.a.f.h.l.h1$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends AbstractC3851u4.b<C3677h1, a> implements InterfaceC3626d6 {
        public a() {
            super(C3677h1.zzf);
        }

        public a(C3718k1 c3718k1) {
            super(C3677h1.zzf);
        }
    }

    static {
        C3677h1 c3677h1 = new C3677h1();
        zzf = c3677h1;
        AbstractC3851u4.m5313r(C3677h1.class, c3677h1);
    }

    /* JADX INFO: renamed from: B */
    public static a m4924B() {
        return zzf.m5314s();
    }

    /* JADX INFO: renamed from: v */
    public static void m4926v(C3677h1 c3677h1, int i) {
        c3677h1.zzc |= 1;
        c3677h1.zzd = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: w */
    public static void m4927w(C3677h1 c3677h1, Iterable iterable) {
        InterfaceC3611c5 interfaceC3611c5 = c3677h1.zze;
        if (!((AbstractC3772o3) interfaceC3611c5).f10123j) {
            c3677h1.zze = AbstractC3851u4.m5311o(interfaceC3611c5);
        }
        AbstractC3733l3.m5051c(iterable, c3677h1.zze);
    }

    /* JADX INFO: renamed from: A */
    public final int m4928A() {
        return ((C3800q5) this.zze).size();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4
    /* JADX INFO: renamed from: p */
    public final Object mo4541p(int i, Object obj, Object obj2) {
        switch (C3718k1.f10050a[i - 1]) {
            case 1:
                return new C3677h1();
            case 2:
                return new a(null);
            case 3:
                return new C3775o6(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                InterfaceC3710j6<C3677h1> aVar = zzg;
                if (aVar == null) {
                    synchronized (C3677h1.class) {
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
    public final long m4929u(int i) {
        C3800q5 c3800q5 = (C3800q5) this.zze;
        c3800q5.m5189h(i);
        return c3800q5.f10272l[i];
    }

    /* JADX INFO: renamed from: x */
    public final boolean m4930x() {
        return (this.zzc & 1) != 0;
    }

    /* JADX INFO: renamed from: y */
    public final int m4931y() {
        return this.zzd;
    }

    /* JADX INFO: renamed from: z */
    public final List<Long> m4932z() {
        return this.zze;
    }
}
