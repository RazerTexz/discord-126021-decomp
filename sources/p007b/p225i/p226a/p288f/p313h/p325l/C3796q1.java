package p007b.p225i.p226a.p288f.p313h.p325l;

import com.discord.widgets.chat.input.MentionUtilsKt;

/* JADX INFO: renamed from: b.i.a.f.h.l.q1 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3796q1 extends AbstractC3851u4<C3796q1, b> implements InterfaceC3626d6 {
    private static final C3796q1 zzk;
    private static volatile InterfaceC3710j6<C3796q1> zzl;
    private int zzc;
    private int zzd;
    private boolean zzf;
    private long zzg;
    private double zzh;
    private String zze = "";
    private InterfaceC3597b5<C3796q1> zzi = C3749m6.f10094k;
    private String zzj = "";

    /* JADX INFO: renamed from: b.i.a.f.h.l.q1$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public enum a implements InterfaceC3903y4 {
        UNKNOWN(0),
        STRING(1),
        NUMBER(2),
        BOOLEAN(3),
        STATEMENT(4);

        private final int zzg;

        a(int i) {
            this.zzg = i;
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

    /* JADX INFO: renamed from: b.i.a.f.h.l.q1$b */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class b extends AbstractC3851u4.b<C3796q1, b> implements InterfaceC3626d6 {
        public b(C3809r1 c3809r1) {
            super(C3796q1.zzk);
        }
    }

    static {
        C3796q1 c3796q1 = new C3796q1();
        zzk = c3796q1;
        AbstractC3851u4.m5313r(C3796q1.class, c3796q1);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4
    /* JADX INFO: renamed from: p */
    public final Object mo4541p(int i, Object obj, Object obj2) {
        switch (C3809r1.f10282a[i - 1]) {
            case 1:
                return new C3796q1();
            case 2:
                return new b(null);
            case 3:
                return new C3775o6(zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004ဂ\u0003\u0005က\u0004\u0006\u001b\u0007ဈ\u0005", new Object[]{"zzc", "zzd", C3822s1.f10301a, "zze", "zzf", "zzg", "zzh", "zzi", C3796q1.class, "zzj"});
            case 4:
                return zzk;
            case 5:
                InterfaceC3710j6<C3796q1> aVar = zzl;
                if (aVar == null) {
                    synchronized (C3796q1.class) {
                        aVar = zzl;
                        if (aVar == null) {
                            aVar = new AbstractC3851u4.a<>(zzk);
                            zzl = aVar;
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
