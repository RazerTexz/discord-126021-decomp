package p007b.p225i.p226a.p288f.p313h.p325l;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4;
import p007b.p225i.p226a.p288f.p313h.p325l.C3607c1;

/* JADX INFO: renamed from: b.i.a.f.h.l.a1 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3579a1 extends AbstractC3851u4<C3579a1, a> implements InterfaceC3626d6 {
    private static final C3579a1 zzi;
    private static volatile InterfaceC3710j6<C3579a1> zzj;
    private int zzc;
    private InterfaceC3597b5<C3607c1> zzd = C3749m6.f10094k;
    private String zze = "";
    private long zzf;
    private long zzg;
    private int zzh;

    /* JADX INFO: renamed from: b.i.a.f.h.l.a1$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends AbstractC3851u4.b<C3579a1, a> implements InterfaceC3626d6 {
        public a() {
            super(C3579a1.zzi);
        }

        /* JADX INFO: renamed from: A */
        public final long m4544A() {
            return ((C3579a1) this.f10347k).m4537J();
        }

        /* JADX INFO: renamed from: q */
        public final a m4545q(int i, C3607c1 c3607c1) {
            if (this.f10348l) {
                m5318n();
                this.f10348l = false;
            }
            C3579a1.m4530y((C3579a1) this.f10347k, i, c3607c1);
            return this;
        }

        /* JADX INFO: renamed from: r */
        public final a m4546r(long j) {
            if (this.f10348l) {
                m5318n();
                this.f10348l = false;
            }
            C3579a1.m4531z((C3579a1) this.f10347k, j);
            return this;
        }

        /* JADX INFO: renamed from: s */
        public final a m4547s(C3607c1.a aVar) {
            if (this.f10348l) {
                m5318n();
                this.f10348l = false;
            }
            C3579a1.m4522A((C3579a1) this.f10347k, (C3607c1) ((AbstractC3851u4) aVar.m5320p()));
            return this;
        }

        /* JADX INFO: renamed from: t */
        public final a m4548t(String str) {
            if (this.f10348l) {
                m5318n();
                this.f10348l = false;
            }
            C3579a1.m4524C((C3579a1) this.f10347k, str);
            return this;
        }

        /* JADX INFO: renamed from: u */
        public final C3607c1 m4549u(int i) {
            return ((C3579a1) this.f10347k).m4542u(i);
        }

        /* JADX INFO: renamed from: v */
        public final List<C3607c1> m4550v() {
            return Collections.unmodifiableList(((C3579a1) this.f10347k).m4543v());
        }

        /* JADX INFO: renamed from: w */
        public final int m4551w() {
            return ((C3579a1) this.f10347k).m4532D();
        }

        /* JADX INFO: renamed from: x */
        public final a m4552x(int i) {
            if (this.f10348l) {
                m5318n();
                this.f10348l = false;
            }
            C3579a1.m4529x((C3579a1) this.f10347k, i);
            return this;
        }

        /* JADX INFO: renamed from: y */
        public final String m4553y() {
            return ((C3579a1) this.f10347k).m4533F();
        }

        /* JADX INFO: renamed from: z */
        public final long m4554z() {
            return ((C3579a1) this.f10347k).m4535H();
        }

        public a(C3718k1 c3718k1) {
            super(C3579a1.zzi);
        }
    }

    static {
        C3579a1 c3579a1 = new C3579a1();
        zzi = c3579a1;
        AbstractC3851u4.m5313r(C3579a1.class, c3579a1);
    }

    /* JADX INFO: renamed from: A */
    public static void m4522A(C3579a1 c3579a1, C3607c1 c3607c1) {
        Objects.requireNonNull(c3579a1);
        c3607c1.getClass();
        c3579a1.m4540O();
        c3579a1.zzd.add(c3607c1);
    }

    /* JADX INFO: renamed from: B */
    public static void m4523B(C3579a1 c3579a1, Iterable iterable) {
        c3579a1.m4540O();
        AbstractC3733l3.m5051c(iterable, c3579a1.zzd);
    }

    /* JADX INFO: renamed from: C */
    public static void m4524C(C3579a1 c3579a1, String str) {
        Objects.requireNonNull(c3579a1);
        str.getClass();
        c3579a1.zzc |= 1;
        c3579a1.zze = str;
    }

    /* JADX INFO: renamed from: E */
    public static void m4525E(C3579a1 c3579a1, long j) {
        c3579a1.zzc |= 4;
        c3579a1.zzg = j;
    }

    /* JADX INFO: renamed from: M */
    public static a m4526M() {
        return zzi.m5314s();
    }

    /* JADX INFO: renamed from: w */
    public static void m4528w(C3579a1 c3579a1) {
        Objects.requireNonNull(c3579a1);
        c3579a1.zzd = C3749m6.f10094k;
    }

    /* JADX INFO: renamed from: x */
    public static void m4529x(C3579a1 c3579a1, int i) {
        c3579a1.m4540O();
        c3579a1.zzd.remove(i);
    }

    /* JADX INFO: renamed from: y */
    public static void m4530y(C3579a1 c3579a1, int i, C3607c1 c3607c1) {
        Objects.requireNonNull(c3579a1);
        c3607c1.getClass();
        c3579a1.m4540O();
        c3579a1.zzd.set(i, c3607c1);
    }

    /* JADX INFO: renamed from: z */
    public static void m4531z(C3579a1 c3579a1, long j) {
        c3579a1.zzc |= 2;
        c3579a1.zzf = j;
    }

    /* JADX INFO: renamed from: D */
    public final int m4532D() {
        return this.zzd.size();
    }

    /* JADX INFO: renamed from: F */
    public final String m4533F() {
        return this.zze;
    }

    /* JADX INFO: renamed from: G */
    public final boolean m4534G() {
        return (this.zzc & 2) != 0;
    }

    /* JADX INFO: renamed from: H */
    public final long m4535H() {
        return this.zzf;
    }

    /* JADX INFO: renamed from: I */
    public final boolean m4536I() {
        return (this.zzc & 4) != 0;
    }

    /* JADX INFO: renamed from: J */
    public final long m4537J() {
        return this.zzg;
    }

    /* JADX INFO: renamed from: K */
    public final boolean m4538K() {
        return (this.zzc & 8) != 0;
    }

    /* JADX INFO: renamed from: L */
    public final int m4539L() {
        return this.zzh;
    }

    /* JADX INFO: renamed from: O */
    public final void m4540O() {
        InterfaceC3597b5<C3607c1> interfaceC3597b5 = this.zzd;
        if (interfaceC3597b5.mo4568a()) {
            return;
        }
        this.zzd = AbstractC3851u4.m5310n(interfaceC3597b5);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4
    /* JADX INFO: renamed from: p */
    public final Object mo4541p(int i, Object obj, Object obj2) {
        switch (C3718k1.f10050a[i - 1]) {
            case 1:
                return new C3579a1();
            case 2:
                return new a(null);
            case 3:
                return new C3775o6(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zzc", "zzd", C3607c1.class, "zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzi;
            case 5:
                InterfaceC3710j6<C3579a1> aVar = zzj;
                if (aVar == null) {
                    synchronized (C3579a1.class) {
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
    public final C3607c1 m4542u(int i) {
        return this.zzd.get(i);
    }

    /* JADX INFO: renamed from: v */
    public final List<C3607c1> m4543v() {
        return this.zzd;
    }
}
