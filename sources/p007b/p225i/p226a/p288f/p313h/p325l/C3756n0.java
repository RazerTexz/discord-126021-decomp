package p007b.p225i.p226a.p288f.p313h.p325l;

import com.discord.widgets.chat.input.MentionUtilsKt;

/* JADX INFO: renamed from: b.i.a.f.h.l.n0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3756n0 extends AbstractC3851u4<C3756n0, b> implements InterfaceC3626d6 {
    private static final C3756n0 zzi;
    private static volatile InterfaceC3710j6<C3756n0> zzj;
    private int zzc;
    private int zzd;
    private boolean zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";

    /* JADX INFO: renamed from: b.i.a.f.h.l.n0$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public enum a implements InterfaceC3903y4 {
        UNKNOWN_COMPARISON_TYPE(0),
        LESS_THAN(1),
        GREATER_THAN(2),
        EQUAL(3),
        BETWEEN(4);

        private final int zzg;

        a(int i) {
            this.zzg = i;
        }

        /* JADX INFO: renamed from: f */
        public static a m5122f(int i) {
            if (i == 0) {
                return UNKNOWN_COMPARISON_TYPE;
            }
            if (i == 1) {
                return LESS_THAN;
            }
            if (i == 2) {
                return GREATER_THAN;
            }
            if (i == 3) {
                return EQUAL;
            }
            if (i != 4) {
                return null;
            }
            return BETWEEN;
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3903y4
        /* JADX INFO: renamed from: a */
        public final int mo4875a() {
            return this.zzg;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + a.class.getName() + MentionUtilsKt.MENTIONS_CHAR + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
        }
    }

    /* JADX INFO: renamed from: b.i.a.f.h.l.n0$b */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class b extends AbstractC3851u4.b<C3756n0, b> implements InterfaceC3626d6 {
        public b(C3795q0 c3795q0) {
            super(C3756n0.zzi);
        }
    }

    static {
        C3756n0 c3756n0 = new C3756n0();
        zzi = c3756n0;
        AbstractC3851u4.m5313r(C3756n0.class, c3756n0);
    }

    /* JADX INFO: renamed from: E */
    public static C3756n0 m5110E() {
        return zzi;
    }

    /* JADX INFO: renamed from: A */
    public final boolean m5112A() {
        return (this.zzc & 8) != 0;
    }

    /* JADX INFO: renamed from: B */
    public final String m5113B() {
        return this.zzg;
    }

    /* JADX INFO: renamed from: C */
    public final boolean m5114C() {
        return (this.zzc & 16) != 0;
    }

    /* JADX INFO: renamed from: D */
    public final String m5115D() {
        return this.zzh;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4
    /* JADX INFO: renamed from: p */
    public final Object mo4541p(int i, Object obj, Object obj2) {
        switch (C3795q0.f10256a[i - 1]) {
            case 1:
                return new C3756n0();
            case 2:
                return new b(null);
            case 3:
                return new C3775o6(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zzc", "zzd", C3808r0.f10281a, "zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzi;
            case 5:
                InterfaceC3710j6<C3756n0> aVar = zzj;
                if (aVar == null) {
                    synchronized (C3756n0.class) {
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
    public final boolean m5116u() {
        return (this.zzc & 1) != 0;
    }

    /* JADX INFO: renamed from: v */
    public final a m5117v() {
        a aVarM5122f = a.m5122f(this.zzd);
        return aVarM5122f == null ? a.UNKNOWN_COMPARISON_TYPE : aVarM5122f;
    }

    /* JADX INFO: renamed from: w */
    public final boolean m5118w() {
        return (this.zzc & 2) != 0;
    }

    /* JADX INFO: renamed from: x */
    public final boolean m5119x() {
        return this.zze;
    }

    /* JADX INFO: renamed from: y */
    public final boolean m5120y() {
        return (this.zzc & 4) != 0;
    }

    /* JADX INFO: renamed from: z */
    public final String m5121z() {
        return this.zzf;
    }
}
