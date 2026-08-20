package p007b.p225i.p226a.p288f.p313h.p325l;

import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.f.h.l.o0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3769o0 extends AbstractC3851u4<C3769o0, a> implements InterfaceC3626d6 {
    private static final C3769o0 zzj;
    private static volatile InterfaceC3710j6<C3769o0> zzk;
    private int zzc;
    private int zzd;
    private String zze = "";
    private C3743m0 zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;

    /* JADX INFO: renamed from: b.i.a.f.h.l.o0$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends AbstractC3851u4.b<C3769o0, a> implements InterfaceC3626d6 {
        public a() {
            super(C3769o0.zzj);
        }

        public a(C3795q0 c3795q0) {
            super(C3769o0.zzj);
        }
    }

    static {
        C3769o0 c3769o0 = new C3769o0();
        zzj = c3769o0;
        AbstractC3851u4.m5313r(C3769o0.class, c3769o0);
    }

    /* JADX INFO: renamed from: D */
    public static a m5141D() {
        return zzj.m5314s();
    }

    /* JADX INFO: renamed from: u */
    public static void m5143u(C3769o0 c3769o0, String str) {
        Objects.requireNonNull(c3769o0);
        str.getClass();
        c3769o0.zzc |= 2;
        c3769o0.zze = str;
    }

    /* JADX INFO: renamed from: A */
    public final boolean m5144A() {
        return this.zzh;
    }

    /* JADX INFO: renamed from: B */
    public final boolean m5145B() {
        return (this.zzc & 32) != 0;
    }

    /* JADX INFO: renamed from: C */
    public final boolean m5146C() {
        return this.zzi;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4
    /* JADX INFO: renamed from: p */
    public final Object mo4541p(int i, Object obj, Object obj2) {
        switch (C3795q0.f10256a[i - 1]) {
            case 1:
                return new C3769o0();
            case 2:
                return new a(null);
            case 3:
                return new C3775o6(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzj;
            case 5:
                InterfaceC3710j6<C3769o0> aVar = zzk;
                if (aVar == null) {
                    synchronized (C3769o0.class) {
                        aVar = zzk;
                        if (aVar == null) {
                            aVar = new AbstractC3851u4.a<>(zzj);
                            zzk = aVar;
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
    public final boolean m5147v() {
        return (this.zzc & 1) != 0;
    }

    /* JADX INFO: renamed from: w */
    public final int m5148w() {
        return this.zzd;
    }

    /* JADX INFO: renamed from: x */
    public final String m5149x() {
        return this.zze;
    }

    /* JADX INFO: renamed from: y */
    public final C3743m0 m5150y() {
        C3743m0 c3743m0 = this.zzf;
        return c3743m0 == null ? C3743m0.m5059D() : c3743m0;
    }

    /* JADX INFO: renamed from: z */
    public final boolean m5151z() {
        return this.zzg;
    }
}
