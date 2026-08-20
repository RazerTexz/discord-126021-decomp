package p007b.p225i.p226a.p288f.p313h.p325l;

import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.f.h.l.m0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3743m0 extends AbstractC3851u4<C3743m0, a> implements InterfaceC3626d6 {
    private static final C3743m0 zzh;
    private static volatile InterfaceC3710j6<C3743m0> zzi;
    private int zzc;
    private C3782p0 zzd;
    private C3756n0 zze;
    private boolean zzf;
    private String zzg = "";

    /* JADX INFO: renamed from: b.i.a.f.h.l.m0$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends AbstractC3851u4.b<C3743m0, a> implements InterfaceC3626d6 {
        public a() {
            super(C3743m0.zzh);
        }

        public a(C3795q0 c3795q0) {
            super(C3743m0.zzh);
        }
    }

    static {
        C3743m0 c3743m0 = new C3743m0();
        zzh = c3743m0;
        AbstractC3851u4.m5313r(C3743m0.class, c3743m0);
    }

    /* JADX INFO: renamed from: D */
    public static C3743m0 m5059D() {
        return zzh;
    }

    /* JADX INFO: renamed from: u */
    public static void m5061u(C3743m0 c3743m0, String str) {
        Objects.requireNonNull(c3743m0);
        str.getClass();
        c3743m0.zzc |= 8;
        c3743m0.zzg = str;
    }

    /* JADX INFO: renamed from: A */
    public final boolean m5062A() {
        return this.zzf;
    }

    /* JADX INFO: renamed from: B */
    public final boolean m5063B() {
        return (this.zzc & 8) != 0;
    }

    /* JADX INFO: renamed from: C */
    public final String m5064C() {
        return this.zzg;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4
    /* JADX INFO: renamed from: p */
    public final Object mo4541p(int i, Object obj, Object obj2) {
        switch (C3795q0.f10256a[i - 1]) {
            case 1:
                return new C3743m0();
            case 2:
                return new a(null);
            case 3:
                return new C3775o6(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                InterfaceC3710j6<C3743m0> aVar = zzi;
                if (aVar == null) {
                    synchronized (C3743m0.class) {
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

    /* JADX INFO: renamed from: v */
    public final boolean m5065v() {
        return (this.zzc & 1) != 0;
    }

    /* JADX INFO: renamed from: w */
    public final C3782p0 m5066w() {
        C3782p0 c3782p0 = this.zzd;
        return c3782p0 == null ? C3782p0.m5161C() : c3782p0;
    }

    /* JADX INFO: renamed from: x */
    public final boolean m5067x() {
        return (this.zzc & 2) != 0;
    }

    /* JADX INFO: renamed from: y */
    public final C3756n0 m5068y() {
        C3756n0 c3756n0 = this.zze;
        return c3756n0 == null ? C3756n0.m5110E() : c3756n0;
    }

    /* JADX INFO: renamed from: z */
    public final boolean m5069z() {
        return (this.zzc & 4) != 0;
    }
}
