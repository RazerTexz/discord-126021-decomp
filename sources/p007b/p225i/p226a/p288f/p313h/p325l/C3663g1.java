package p007b.p225i.p226a.p288f.p313h.p325l;

import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.f.h.l.g1 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3663g1 extends AbstractC3851u4<C3663g1, a> implements InterfaceC3626d6 {
    private static final C3663g1 zzg;
    private static volatile InterfaceC3710j6<C3663g1> zzh;
    private InterfaceC3611c5 zzc;
    private InterfaceC3611c5 zzd;
    private InterfaceC3597b5<C3912z0> zze;
    private InterfaceC3597b5<C3677h1> zzf;

    /* JADX INFO: renamed from: b.i.a.f.h.l.g1$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends AbstractC3851u4.b<C3663g1, a> implements InterfaceC3626d6 {
        public a() {
            super(C3663g1.zzg);
        }

        public a(C3718k1 c3718k1) {
            super(C3663g1.zzg);
        }
    }

    static {
        C3663g1 c3663g1 = new C3663g1();
        zzg = c3663g1;
        AbstractC3851u4.m5313r(C3663g1.class, c3663g1);
    }

    public C3663g1() {
        C3800q5 c3800q5 = C3800q5.f10271k;
        this.zzc = c3800q5;
        this.zzd = c3800q5;
        C3749m6<Object> c3749m6 = C3749m6.f10094k;
        this.zze = c3749m6;
        this.zzf = c3749m6;
    }

    /* JADX INFO: renamed from: B */
    public static void m4888B(C3663g1 c3663g1) {
        Objects.requireNonNull(c3663g1);
        c3663g1.zzd = C3800q5.f10271k;
    }

    /* JADX INFO: renamed from: C */
    public static void m4889C(C3663g1 c3663g1, int i) {
        InterfaceC3597b5<C3677h1> interfaceC3597b5 = c3663g1.zzf;
        if (!interfaceC3597b5.mo4568a()) {
            c3663g1.zzf = AbstractC3851u4.m5310n(interfaceC3597b5);
        }
        c3663g1.zzf.remove(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: D */
    public static void m4890D(C3663g1 c3663g1, Iterable iterable) {
        InterfaceC3611c5 interfaceC3611c5 = c3663g1.zzd;
        if (!((AbstractC3772o3) interfaceC3611c5).f10123j) {
            c3663g1.zzd = AbstractC3851u4.m5311o(interfaceC3611c5);
        }
        AbstractC3733l3.m5051c(iterable, c3663g1.zzd);
    }

    /* JADX INFO: renamed from: F */
    public static void m4891F(C3663g1 c3663g1, Iterable iterable) {
        InterfaceC3597b5<C3912z0> interfaceC3597b5 = c3663g1.zze;
        if (!interfaceC3597b5.mo4568a()) {
            c3663g1.zze = AbstractC3851u4.m5310n(interfaceC3597b5);
        }
        AbstractC3733l3.m5051c(iterable, c3663g1.zze);
    }

    /* JADX INFO: renamed from: H */
    public static void m4892H(C3663g1 c3663g1, Iterable iterable) {
        InterfaceC3597b5<C3677h1> interfaceC3597b5 = c3663g1.zzf;
        if (!interfaceC3597b5.mo4568a()) {
            c3663g1.zzf = AbstractC3851u4.m5310n(interfaceC3597b5);
        }
        AbstractC3733l3.m5051c(iterable, c3663g1.zzf);
    }

    /* JADX INFO: renamed from: M */
    public static a m4893M() {
        return zzg.m5314s();
    }

    /* JADX INFO: renamed from: N */
    public static C3663g1 m4894N() {
        return zzg;
    }

    /* JADX INFO: renamed from: w */
    public static void m4896w(C3663g1 c3663g1) {
        Objects.requireNonNull(c3663g1);
        c3663g1.zzc = C3800q5.f10271k;
    }

    /* JADX INFO: renamed from: x */
    public static void m4897x(C3663g1 c3663g1, int i) {
        InterfaceC3597b5<C3912z0> interfaceC3597b5 = c3663g1.zze;
        if (!interfaceC3597b5.mo4568a()) {
            c3663g1.zze = AbstractC3851u4.m5310n(interfaceC3597b5);
        }
        c3663g1.zze.remove(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: y */
    public static void m4898y(C3663g1 c3663g1, Iterable iterable) {
        InterfaceC3611c5 interfaceC3611c5 = c3663g1.zzc;
        if (!((AbstractC3772o3) interfaceC3611c5).f10123j) {
            c3663g1.zzc = AbstractC3851u4.m5311o(interfaceC3611c5);
        }
        AbstractC3733l3.m5051c(iterable, c3663g1.zzc);
    }

    /* JADX INFO: renamed from: A */
    public final C3677h1 m4899A(int i) {
        return this.zzf.get(i);
    }

    /* JADX INFO: renamed from: E */
    public final List<Long> m4900E() {
        return this.zzd;
    }

    /* JADX INFO: renamed from: G */
    public final int m4901G() {
        return ((C3800q5) this.zzd).size();
    }

    /* JADX INFO: renamed from: I */
    public final List<C3912z0> m4902I() {
        return this.zze;
    }

    /* JADX INFO: renamed from: J */
    public final int m4903J() {
        return this.zze.size();
    }

    /* JADX INFO: renamed from: K */
    public final List<C3677h1> m4904K() {
        return this.zzf;
    }

    /* JADX INFO: renamed from: L */
    public final int m4905L() {
        return this.zzf.size();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4
    /* JADX INFO: renamed from: p */
    public final Object mo4541p(int i, Object obj, Object obj2) {
        switch (C3718k1.f10050a[i - 1]) {
            case 1:
                return new C3663g1();
            case 2:
                return new a(null);
            case 3:
                return new C3775o6(zzg, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzc", "zzd", "zze", C3912z0.class, "zzf", C3677h1.class});
            case 4:
                return zzg;
            case 5:
                InterfaceC3710j6<C3663g1> aVar = zzh;
                if (aVar == null) {
                    synchronized (C3663g1.class) {
                        aVar = zzh;
                        if (aVar == null) {
                            aVar = new AbstractC3851u4.a<>(zzg);
                            zzh = aVar;
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
    public final C3912z0 m4906u(int i) {
        return this.zze.get(i);
    }

    /* JADX INFO: renamed from: v */
    public final List<Long> m4907v() {
        return this.zzc;
    }

    /* JADX INFO: renamed from: z */
    public final int m4908z() {
        return ((C3800q5) this.zzc).size();
    }
}
