package p007b.p225i.p226a.p288f.p313h.p325l;

import java.util.List;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4;

/* JADX INFO: renamed from: b.i.a.f.h.l.c1 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3607c1 extends AbstractC3851u4<C3607c1, a> implements InterfaceC3626d6 {
    private static final C3607c1 zzj;
    private static volatile InterfaceC3710j6<C3607c1> zzk;
    private int zzc;
    private long zzf;
    private float zzg;
    private double zzh;
    private String zzd = "";
    private String zze = "";
    private InterfaceC3597b5<C3607c1> zzi = C3749m6.f10094k;

    /* JADX INFO: renamed from: b.i.a.f.h.l.c1$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends AbstractC3851u4.b<C3607c1, a> implements InterfaceC3626d6 {
        public a() {
            super(C3607c1.zzj);
        }

        /* JADX INFO: renamed from: q */
        public final a m4598q(double d) {
            if (this.f10348l) {
                m5318n();
                this.f10348l = false;
            }
            C3607c1.m4581v((C3607c1) this.f10347k, d);
            return this;
        }

        /* JADX INFO: renamed from: r */
        public final a m4599r(long j) {
            if (this.f10348l) {
                m5318n();
                this.f10348l = false;
            }
            C3607c1.m4582w((C3607c1) this.f10347k, j);
            return this;
        }

        /* JADX INFO: renamed from: s */
        public final a m4600s(String str) {
            if (this.f10348l) {
                m5318n();
                this.f10348l = false;
            }
            C3607c1.m4585z((C3607c1) this.f10347k, str);
            return this;
        }

        /* JADX INFO: renamed from: t */
        public final a m4601t(String str) {
            if (this.f10348l) {
                m5318n();
                this.f10348l = false;
            }
            C3607c1.m4575D((C3607c1) this.f10347k, str);
            return this;
        }

        public a(C3718k1 c3718k1) {
            super(C3607c1.zzj);
        }
    }

    static {
        C3607c1 c3607c1 = new C3607c1();
        zzj = c3607c1;
        AbstractC3851u4.m5313r(C3607c1.class, c3607c1);
    }

    /* JADX INFO: renamed from: C */
    public static void m4574C(C3607c1 c3607c1) {
        c3607c1.zzc &= -5;
        c3607c1.zzf = 0L;
    }

    /* JADX INFO: renamed from: D */
    public static void m4575D(C3607c1 c3607c1, String str) {
        Objects.requireNonNull(c3607c1);
        str.getClass();
        c3607c1.zzc |= 2;
        c3607c1.zze = str;
    }

    /* JADX INFO: renamed from: E */
    public static void m4576E(C3607c1 c3607c1) {
        c3607c1.zzc &= -17;
        c3607c1.zzh = 0.0d;
    }

    /* JADX INFO: renamed from: H */
    public static void m4577H(C3607c1 c3607c1) {
        Objects.requireNonNull(c3607c1);
        c3607c1.zzi = C3749m6.f10094k;
    }

    /* JADX INFO: renamed from: Q */
    public static a m4578Q() {
        return zzj.m5314s();
    }

    /* JADX INFO: renamed from: u */
    public static void m4580u(C3607c1 c3607c1) {
        c3607c1.zzc &= -3;
        c3607c1.zze = zzj.zze;
    }

    /* JADX INFO: renamed from: v */
    public static void m4581v(C3607c1 c3607c1, double d) {
        c3607c1.zzc |= 16;
        c3607c1.zzh = d;
    }

    /* JADX INFO: renamed from: w */
    public static void m4582w(C3607c1 c3607c1, long j) {
        c3607c1.zzc |= 4;
        c3607c1.zzf = j;
    }

    /* JADX INFO: renamed from: x */
    public static void m4583x(C3607c1 c3607c1, C3607c1 c3607c2) {
        Objects.requireNonNull(c3607c1);
        InterfaceC3597b5<C3607c1> interfaceC3597b5 = c3607c1.zzi;
        if (!interfaceC3597b5.mo4568a()) {
            c3607c1.zzi = AbstractC3851u4.m5310n(interfaceC3597b5);
        }
        c3607c1.zzi.add(c3607c2);
    }

    /* JADX INFO: renamed from: y */
    public static void m4584y(C3607c1 c3607c1, Iterable iterable) {
        InterfaceC3597b5<C3607c1> interfaceC3597b5 = c3607c1.zzi;
        if (!interfaceC3597b5.mo4568a()) {
            c3607c1.zzi = AbstractC3851u4.m5310n(interfaceC3597b5);
        }
        AbstractC3733l3.m5051c(iterable, c3607c1.zzi);
    }

    /* JADX INFO: renamed from: z */
    public static void m4585z(C3607c1 c3607c1, String str) {
        Objects.requireNonNull(c3607c1);
        str.getClass();
        c3607c1.zzc |= 1;
        c3607c1.zzd = str;
    }

    /* JADX INFO: renamed from: A */
    public final boolean m4586A() {
        return (this.zzc & 1) != 0;
    }

    /* JADX INFO: renamed from: B */
    public final String m4587B() {
        return this.zzd;
    }

    /* JADX INFO: renamed from: F */
    public final boolean m4588F() {
        return (this.zzc & 2) != 0;
    }

    /* JADX INFO: renamed from: G */
    public final String m4589G() {
        return this.zze;
    }

    /* JADX INFO: renamed from: I */
    public final boolean m4590I() {
        return (this.zzc & 4) != 0;
    }

    /* JADX INFO: renamed from: J */
    public final long m4591J() {
        return this.zzf;
    }

    /* JADX INFO: renamed from: K */
    public final boolean m4592K() {
        return (this.zzc & 8) != 0;
    }

    /* JADX INFO: renamed from: L */
    public final float m4593L() {
        return this.zzg;
    }

    /* JADX INFO: renamed from: M */
    public final boolean m4594M() {
        return (this.zzc & 16) != 0;
    }

    /* JADX INFO: renamed from: N */
    public final double m4595N() {
        return this.zzh;
    }

    /* JADX INFO: renamed from: O */
    public final List<C3607c1> m4596O() {
        return this.zzi;
    }

    /* JADX INFO: renamed from: P */
    public final int m4597P() {
        return this.zzi.size();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4
    /* JADX INFO: renamed from: p */
    public final Object mo4541p(int i, Object obj, Object obj2) {
        switch (C3718k1.f10050a[i - 1]) {
            case 1:
                return new C3607c1();
            case 2:
                return new a(null);
            case 3:
                return new C3775o6(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", C3607c1.class});
            case 4:
                return zzj;
            case 5:
                InterfaceC3710j6<C3607c1> aVar = zzk;
                if (aVar == null) {
                    synchronized (C3607c1.class) {
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
}
