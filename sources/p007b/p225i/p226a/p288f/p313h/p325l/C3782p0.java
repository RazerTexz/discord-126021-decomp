package p007b.p225i.p226a.p288f.p313h.p325l;

import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.List;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4;

/* JADX INFO: renamed from: b.i.a.f.h.l.p0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3782p0 extends AbstractC3851u4<C3782p0, a> implements InterfaceC3626d6 {
    private static final C3782p0 zzh;
    private static volatile InterfaceC3710j6<C3782p0> zzi;
    private int zzc;
    private int zzd;
    private boolean zzf;
    private String zze = "";
    private InterfaceC3597b5<String> zzg = C3749m6.f10094k;

    /* JADX INFO: renamed from: b.i.a.f.h.l.p0$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends AbstractC3851u4.b<C3782p0, a> implements InterfaceC3626d6 {
        public a(C3795q0 c3795q0) {
            super(C3782p0.zzh);
        }
    }

    /* JADX INFO: renamed from: b.i.a.f.h.l.p0$b */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public enum b implements InterfaceC3903y4 {
        UNKNOWN_MATCH_TYPE(0),
        REGEXP(1),
        BEGINS_WITH(2),
        ENDS_WITH(3),
        PARTIAL(4),
        EXACT(5),
        IN_LIST(6);

        private final int zzi;

        b(int i) {
            this.zzi = i;
        }

        /* JADX INFO: renamed from: f */
        public static b m5171f(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN_MATCH_TYPE;
                case 1:
                    return REGEXP;
                case 2:
                    return BEGINS_WITH;
                case 3:
                    return ENDS_WITH;
                case 4:
                    return PARTIAL;
                case 5:
                    return EXACT;
                case 6:
                    return IN_LIST;
                default:
                    return null;
            }
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3903y4
        /* JADX INFO: renamed from: a */
        public final int mo4875a() {
            return this.zzi;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + b.class.getName() + MentionUtilsKt.MENTIONS_CHAR + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + '>';
        }
    }

    static {
        C3782p0 c3782p0 = new C3782p0();
        zzh = c3782p0;
        AbstractC3851u4.m5313r(C3782p0.class, c3782p0);
    }

    /* JADX INFO: renamed from: C */
    public static C3782p0 m5161C() {
        return zzh;
    }

    /* JADX INFO: renamed from: A */
    public final List<String> m5163A() {
        return this.zzg;
    }

    /* JADX INFO: renamed from: B */
    public final int m5164B() {
        return this.zzg.size();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4
    /* JADX INFO: renamed from: p */
    public final Object mo4541p(int i, Object obj, Object obj2) {
        switch (C3795q0.f10256a[i - 1]) {
            case 1:
                return new C3782p0();
            case 2:
                return new a(null);
            case 3:
                return new C3775o6(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zzc", "zzd", C3873w0.f10376a, "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                InterfaceC3710j6<C3782p0> aVar = zzi;
                if (aVar == null) {
                    synchronized (C3782p0.class) {
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
    public final boolean m5165u() {
        return (this.zzc & 1) != 0;
    }

    /* JADX INFO: renamed from: v */
    public final b m5166v() {
        b bVarM5171f = b.m5171f(this.zzd);
        return bVarM5171f == null ? b.UNKNOWN_MATCH_TYPE : bVarM5171f;
    }

    /* JADX INFO: renamed from: w */
    public final boolean m5167w() {
        return (this.zzc & 2) != 0;
    }

    /* JADX INFO: renamed from: x */
    public final String m5168x() {
        return this.zze;
    }

    /* JADX INFO: renamed from: y */
    public final boolean m5169y() {
        return (this.zzc & 4) != 0;
    }

    /* JADX INFO: renamed from: z */
    public final boolean m5170z() {
        return this.zzf;
    }
}
