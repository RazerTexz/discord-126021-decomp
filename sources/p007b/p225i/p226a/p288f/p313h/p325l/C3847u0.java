package p007b.p225i.p226a.p288f.p313h.p325l;

import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.f.h.l.u0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3847u0 extends AbstractC3851u4<C3847u0, a> implements InterfaceC3626d6 {
    private static final C3847u0 zzm;
    private static volatile InterfaceC3710j6<C3847u0> zzn;
    private int zzc;
    private long zzd;
    private String zze = "";
    private int zzf;
    private InterfaceC3597b5<C3860v0> zzg;
    private InterfaceC3597b5<C3834t0> zzh;
    private InterfaceC3597b5<C3717k0> zzi;
    private String zzj;
    private boolean zzk;
    private InterfaceC3597b5<C3783p1> zzl;

    /* JADX INFO: renamed from: b.i.a.f.h.l.u0$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends AbstractC3851u4.b<C3847u0, a> implements InterfaceC3626d6 {
        public a() {
            super(C3847u0.zzm);
        }

        public a(C3886x0 c3886x0) {
            super(C3847u0.zzm);
        }
    }

    static {
        C3847u0 c3847u0 = new C3847u0();
        zzm = c3847u0;
        AbstractC3851u4.m5313r(C3847u0.class, c3847u0);
    }

    public C3847u0() {
        C3749m6<Object> c3749m6 = C3749m6.f10094k;
        this.zzg = c3749m6;
        this.zzh = c3749m6;
        this.zzi = c3749m6;
        this.zzj = "";
        this.zzl = c3749m6;
    }

    /* JADX INFO: renamed from: F */
    public static a m5294F() {
        return zzm.m5314s();
    }

    /* JADX INFO: renamed from: G */
    public static C3847u0 m5295G() {
        return zzm;
    }

    /* JADX INFO: renamed from: v */
    public static void m5297v(C3847u0 c3847u0) {
        Objects.requireNonNull(c3847u0);
        c3847u0.zzi = C3749m6.f10094k;
    }

    /* JADX INFO: renamed from: w */
    public static void m5298w(C3847u0 c3847u0, int i, C3834t0 c3834t0) {
        Objects.requireNonNull(c3847u0);
        InterfaceC3597b5<C3834t0> interfaceC3597b5 = c3847u0.zzh;
        if (!interfaceC3597b5.mo4568a()) {
            c3847u0.zzh = AbstractC3851u4.m5310n(interfaceC3597b5);
        }
        c3847u0.zzh.set(i, c3834t0);
    }

    /* JADX INFO: renamed from: A */
    public final String m5299A() {
        return this.zze;
    }

    /* JADX INFO: renamed from: B */
    public final List<C3860v0> m5300B() {
        return this.zzg;
    }

    /* JADX INFO: renamed from: C */
    public final int m5301C() {
        return this.zzh.size();
    }

    /* JADX INFO: renamed from: D */
    public final List<C3717k0> m5302D() {
        return this.zzi;
    }

    /* JADX INFO: renamed from: E */
    public final boolean m5303E() {
        return this.zzk;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4
    /* JADX INFO: renamed from: p */
    public final Object mo4541p(int i, Object obj, Object obj2) {
        switch (C3886x0.f10398a[i - 1]) {
            case 1:
                return new C3847u0();
            case 2:
                return new a(null);
            case 3:
                return new C3775o6(zzm, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0004\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", C3860v0.class, "zzh", C3834t0.class, "zzi", C3717k0.class, "zzj", "zzk", "zzl", C3783p1.class});
            case 4:
                return zzm;
            case 5:
                InterfaceC3710j6<C3847u0> aVar = zzn;
                if (aVar == null) {
                    synchronized (C3847u0.class) {
                        aVar = zzn;
                        if (aVar == null) {
                            aVar = new AbstractC3851u4.a<>(zzm);
                            zzn = aVar;
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
    public final C3834t0 m5304u(int i) {
        return this.zzh.get(i);
    }

    /* JADX INFO: renamed from: x */
    public final boolean m5305x() {
        return (this.zzc & 1) != 0;
    }

    /* JADX INFO: renamed from: y */
    public final long m5306y() {
        return this.zzd;
    }

    /* JADX INFO: renamed from: z */
    public final boolean m5307z() {
        return (this.zzc & 2) != 0;
    }
}
