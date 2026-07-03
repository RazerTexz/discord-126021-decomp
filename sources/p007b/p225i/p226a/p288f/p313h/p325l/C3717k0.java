package p007b.p225i.p226a.p288f.p313h.p325l;

import java.util.List;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4;

/* JADX INFO: renamed from: b.i.a.f.h.l.k0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3717k0 extends AbstractC3851u4<C3717k0, a> implements InterfaceC3626d6 {
    private static final C3717k0 zzi;
    private static volatile InterfaceC3710j6<C3717k0> zzj;
    private int zzc;
    private int zzd;
    private InterfaceC3597b5<C3769o0> zze;
    private InterfaceC3597b5<C3730l0> zzf;
    private boolean zzg;
    private boolean zzh;

    /* JADX INFO: renamed from: b.i.a.f.h.l.k0$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends AbstractC3851u4.b<C3717k0, a> implements InterfaceC3626d6 {
        public a() {
            super(C3717k0.zzi);
        }

        public a(C3795q0 c3795q0) {
            super(C3717k0.zzi);
        }
    }

    static {
        C3717k0 c3717k0 = new C3717k0();
        zzi = c3717k0;
        AbstractC3851u4.m5313r(C3717k0.class, c3717k0);
    }

    public C3717k0() {
        C3749m6<Object> c3749m6 = C3749m6.f10094k;
        this.zze = c3749m6;
        this.zzf = c3749m6;
    }

    /* JADX INFO: renamed from: v */
    public static void m5010v(C3717k0 c3717k0, int i, C3730l0 c3730l0) {
        Objects.requireNonNull(c3717k0);
        InterfaceC3597b5<C3730l0> interfaceC3597b5 = c3717k0.zzf;
        if (!interfaceC3597b5.mo4568a()) {
            c3717k0.zzf = AbstractC3851u4.m5310n(interfaceC3597b5);
        }
        c3717k0.zzf.set(i, c3730l0);
    }

    /* JADX INFO: renamed from: w */
    public static void m5011w(C3717k0 c3717k0, int i, C3769o0 c3769o0) {
        Objects.requireNonNull(c3717k0);
        InterfaceC3597b5<C3769o0> interfaceC3597b5 = c3717k0.zze;
        if (!interfaceC3597b5.mo4568a()) {
            c3717k0.zze = AbstractC3851u4.m5310n(interfaceC3597b5);
        }
        c3717k0.zze.set(i, c3769o0);
    }

    /* JADX INFO: renamed from: A */
    public final List<C3769o0> m5012A() {
        return this.zze;
    }

    /* JADX INFO: renamed from: B */
    public final int m5013B() {
        return this.zze.size();
    }

    /* JADX INFO: renamed from: C */
    public final List<C3730l0> m5014C() {
        return this.zzf;
    }

    /* JADX INFO: renamed from: D */
    public final int m5015D() {
        return this.zzf.size();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4
    /* JADX INFO: renamed from: p */
    public final Object mo4541p(int i, Object obj, Object obj2) {
        switch (C3795q0.f10256a[i - 1]) {
            case 1:
                return new C3717k0();
            case 2:
                return new a(null);
            case 3:
                return new C3775o6(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zzc", "zzd", "zze", C3769o0.class, "zzf", C3730l0.class, "zzg", "zzh"});
            case 4:
                return zzi;
            case 5:
                InterfaceC3710j6<C3717k0> aVar = zzj;
                if (aVar == null) {
                    synchronized (C3717k0.class) {
                        aVar = zzj;
                        if (aVar == null) {
                            aVar = new AbstractC3851u4.a<>(zzi);
                            zzj = aVar;
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
    public final C3769o0 m5016u(int i) {
        return this.zze.get(i);
    }

    /* JADX INFO: renamed from: x */
    public final boolean m5017x() {
        return (this.zzc & 1) != 0;
    }

    /* JADX INFO: renamed from: y */
    public final int m5018y() {
        return this.zzd;
    }

    /* JADX INFO: renamed from: z */
    public final C3730l0 m5019z(int i) {
        return this.zzf.get(i);
    }
}
