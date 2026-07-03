package p007b.p225i.p226a.p288f.p313h.p325l;

import java.util.List;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4;

/* JADX INFO: renamed from: b.i.a.f.h.l.l0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3730l0 extends AbstractC3851u4<C3730l0, a> implements InterfaceC3626d6 {
    private static final C3730l0 zzl;
    private static volatile InterfaceC3710j6<C3730l0> zzm;
    private int zzc;
    private int zzd;
    private String zze = "";
    private InterfaceC3597b5<C3743m0> zzf = C3749m6.f10094k;
    private boolean zzg;
    private C3756n0 zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;

    /* JADX INFO: renamed from: b.i.a.f.h.l.l0$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends AbstractC3851u4.b<C3730l0, a> implements InterfaceC3626d6 {
        public a() {
            super(C3730l0.zzl);
        }

        public a(C3795q0 c3795q0) {
            super(C3730l0.zzl);
        }
    }

    static {
        C3730l0 c3730l0 = new C3730l0();
        zzl = c3730l0;
        AbstractC3851u4.m5313r(C3730l0.class, c3730l0);
    }

    /* JADX INFO: renamed from: I */
    public static a m5031I() {
        return zzl.m5314s();
    }

    /* JADX INFO: renamed from: v */
    public static void m5033v(C3730l0 c3730l0, int i, C3743m0 c3743m0) {
        Objects.requireNonNull(c3730l0);
        c3743m0.getClass();
        InterfaceC3597b5<C3743m0> interfaceC3597b5 = c3730l0.zzf;
        if (!interfaceC3597b5.mo4568a()) {
            c3730l0.zzf = AbstractC3851u4.m5310n(interfaceC3597b5);
        }
        c3730l0.zzf.set(i, c3743m0);
    }

    /* JADX INFO: renamed from: w */
    public static void m5034w(C3730l0 c3730l0, String str) {
        Objects.requireNonNull(c3730l0);
        str.getClass();
        c3730l0.zzc |= 2;
        c3730l0.zze = str;
    }

    /* JADX INFO: renamed from: A */
    public final List<C3743m0> m5035A() {
        return this.zzf;
    }

    /* JADX INFO: renamed from: B */
    public final int m5036B() {
        return this.zzf.size();
    }

    /* JADX INFO: renamed from: C */
    public final boolean m5037C() {
        return (this.zzc & 8) != 0;
    }

    /* JADX INFO: renamed from: D */
    public final C3756n0 m5038D() {
        C3756n0 c3756n0 = this.zzh;
        return c3756n0 == null ? C3756n0.m5110E() : c3756n0;
    }

    /* JADX INFO: renamed from: E */
    public final boolean m5039E() {
        return this.zzi;
    }

    /* JADX INFO: renamed from: F */
    public final boolean m5040F() {
        return this.zzj;
    }

    /* JADX INFO: renamed from: G */
    public final boolean m5041G() {
        return (this.zzc & 64) != 0;
    }

    /* JADX INFO: renamed from: H */
    public final boolean m5042H() {
        return this.zzk;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4
    /* JADX INFO: renamed from: p */
    public final Object mo4541p(int i, Object obj, Object obj2) {
        switch (C3795q0.f10256a[i - 1]) {
            case 1:
                return new C3730l0();
            case 2:
                return new a(null);
            case 3:
                return new C3775o6(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", C3743m0.class, "zzg", "zzh", "zzi", "zzj", "zzk"});
            case 4:
                return zzl;
            case 5:
                InterfaceC3710j6<C3730l0> aVar = zzm;
                if (aVar == null) {
                    synchronized (C3730l0.class) {
                        aVar = zzm;
                        if (aVar == null) {
                            aVar = new AbstractC3851u4.a<>(zzl);
                            zzm = aVar;
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
    public final C3743m0 m5043u(int i) {
        return this.zzf.get(i);
    }

    /* JADX INFO: renamed from: x */
    public final boolean m5044x() {
        return (this.zzc & 1) != 0;
    }

    /* JADX INFO: renamed from: y */
    public final int m5045y() {
        return this.zzd;
    }

    /* JADX INFO: renamed from: z */
    public final String m5046z() {
        return this.zze;
    }
}
