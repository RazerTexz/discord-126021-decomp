package p007b.p225i.p226a.p288f.p313h.p325l;

import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.f.h.l.t0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3834t0 extends AbstractC3851u4<C3834t0, a> implements InterfaceC3626d6 {
    private static final C3834t0 zzh;
    private static volatile InterfaceC3710j6<C3834t0> zzi;
    private int zzc;
    private String zzd = "";
    private boolean zze;
    private boolean zzf;
    private int zzg;

    /* JADX INFO: renamed from: b.i.a.f.h.l.t0$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends AbstractC3851u4.b<C3834t0, a> implements InterfaceC3626d6 {
        public a() {
            super(C3834t0.zzh);
        }

        /* JADX INFO: renamed from: q */
        public final String m5275q() {
            return ((C3834t0) this.f10347k).m5270u();
        }

        /* JADX INFO: renamed from: r */
        public final int m5276r() {
            return ((C3834t0) this.f10347k).m5274z();
        }

        public a(C3886x0 c3886x0) {
            super(C3834t0.zzh);
        }
    }

    static {
        C3834t0 c3834t0 = new C3834t0();
        zzh = c3834t0;
        AbstractC3851u4.m5313r(C3834t0.class, c3834t0);
    }

    /* JADX INFO: renamed from: v */
    public static void m5269v(C3834t0 c3834t0, String str) {
        Objects.requireNonNull(c3834t0);
        str.getClass();
        c3834t0.zzc |= 1;
        c3834t0.zzd = str;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4
    /* JADX INFO: renamed from: p */
    public final Object mo4541p(int i, Object obj, Object obj2) {
        switch (C3886x0.f10398a[i - 1]) {
            case 1:
                return new C3834t0();
            case 2:
                return new a(null);
            case 3:
                return new C3775o6(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                InterfaceC3710j6<C3834t0> aVar = zzi;
                if (aVar == null) {
                    synchronized (C3834t0.class) {
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

    /* JADX INFO: renamed from: u */
    public final String m5270u() {
        return this.zzd;
    }

    /* JADX INFO: renamed from: w */
    public final boolean m5271w() {
        return this.zze;
    }

    /* JADX INFO: renamed from: x */
    public final boolean m5272x() {
        return this.zzf;
    }

    /* JADX INFO: renamed from: y */
    public final boolean m5273y() {
        return (this.zzc & 8) != 0;
    }

    /* JADX INFO: renamed from: z */
    public final int m5274z() {
        return this.zzg;
    }
}
