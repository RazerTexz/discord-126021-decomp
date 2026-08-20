package p007b.p225i.p226a.p288f.p313h.p325l;

import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.f.h.l.y0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3899y0 extends AbstractC3851u4<C3899y0, a> implements InterfaceC3626d6 {
    private static final C3899y0 zzh;
    private static volatile InterfaceC3710j6<C3899y0> zzi;
    private int zzc;
    private int zzd;
    private C3663g1 zze;
    private C3663g1 zzf;
    private boolean zzg;

    /* JADX INFO: renamed from: b.i.a.f.h.l.y0$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends AbstractC3851u4.b<C3899y0, a> implements InterfaceC3626d6 {
        public a() {
            super(C3899y0.zzh);
        }

        public a(C3718k1 c3718k1) {
            super(C3899y0.zzh);
        }
    }

    static {
        C3899y0 c3899y0 = new C3899y0();
        zzh = c3899y0;
        AbstractC3851u4.m5313r(C3899y0.class, c3899y0);
    }

    /* JADX INFO: renamed from: F */
    public static a m5363F() {
        return zzh.m5314s();
    }

    /* JADX INFO: renamed from: u */
    public static void m5365u(C3899y0 c3899y0, int i) {
        c3899y0.zzc |= 1;
        c3899y0.zzd = i;
    }

    /* JADX INFO: renamed from: v */
    public static void m5366v(C3899y0 c3899y0, C3663g1 c3663g1) {
        Objects.requireNonNull(c3899y0);
        c3899y0.zze = c3663g1;
        c3899y0.zzc |= 2;
    }

    /* JADX INFO: renamed from: w */
    public static void m5367w(C3899y0 c3899y0, boolean z2) {
        c3899y0.zzc |= 8;
        c3899y0.zzg = z2;
    }

    /* JADX INFO: renamed from: z */
    public static void m5368z(C3899y0 c3899y0, C3663g1 c3663g1) {
        Objects.requireNonNull(c3899y0);
        c3663g1.getClass();
        c3899y0.zzf = c3663g1;
        c3899y0.zzc |= 4;
    }

    /* JADX INFO: renamed from: A */
    public final C3663g1 m5369A() {
        C3663g1 c3663g1 = this.zze;
        return c3663g1 == null ? C3663g1.m4894N() : c3663g1;
    }

    /* JADX INFO: renamed from: B */
    public final boolean m5370B() {
        return (this.zzc & 4) != 0;
    }

    /* JADX INFO: renamed from: C */
    public final C3663g1 m5371C() {
        C3663g1 c3663g1 = this.zzf;
        return c3663g1 == null ? C3663g1.m4894N() : c3663g1;
    }

    /* JADX INFO: renamed from: D */
    public final boolean m5372D() {
        return (this.zzc & 8) != 0;
    }

    /* JADX INFO: renamed from: E */
    public final boolean m5373E() {
        return this.zzg;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4
    /* JADX INFO: renamed from: p */
    public final Object mo4541p(int i, Object obj, Object obj2) {
        switch (C3718k1.f10050a[i - 1]) {
            case 1:
                return new C3899y0();
            case 2:
                return new a(null);
            case 3:
                return new C3775o6(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                InterfaceC3710j6<C3899y0> aVar = zzi;
                if (aVar == null) {
                    synchronized (C3899y0.class) {
                        aVar = zzi;
                        if (aVar == null) {
                            aVar = new AbstractC3851u4.a<>(zzh);
                            zzi = aVar;
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

    /* JADX INFO: renamed from: x */
    public final boolean m5374x() {
        return (this.zzc & 1) != 0;
    }

    /* JADX INFO: renamed from: y */
    public final int m5375y() {
        return this.zzd;
    }
}
