package b.i.a.f.h.l;

import b.i.a.f.h.l.u4;
import com.discord.widgets.chat.input.MentionUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class q1 extends u4<q1, b> implements d6 {
    private static final q1 zzk;
    private static volatile j6<q1> zzl;
    private int zzc;
    private int zzd;
    private boolean zzf;
    private long zzg;
    private double zzh;
    private String zze = "";
    private b5<q1> zzi = m6.k;
    private String zzj = "";

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public enum a implements y4 {
        UNKNOWN(0),
        STRING(1),
        NUMBER(2),
        BOOLEAN(3),
        STATEMENT(4);

        private final int zzg;

        a(int i) {
            this.zzg = i;
        }

        @Override // b.i.a.f.h.l.y4
        public final int a() {
            return this.zzg;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + a.class.getName() + MentionUtils.MENTIONS_CHAR + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class b extends u4.b<q1, b> implements d6 {
        public b(r1 r1Var) {
            super(q1.zzk);
        }
    }

    static {
        q1 q1Var = new q1();
        zzk = q1Var;
        u4.r(q1.class, q1Var);
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (r1.a[i - 1]) {
            case 1:
                return new q1();
            case 2:
                return new b(null);
            case 3:
                return new o6(zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004ဂ\u0003\u0005က\u0004\u0006\u001b\u0007ဈ\u0005", new Object[]{"zzc", "zzd", s1.a, "zze", "zzf", "zzg", "zzh", "zzi", q1.class, "zzj"});
            case 4:
                return zzk;
            case 5:
                j6<q1> aVar = zzl;
                if (aVar == null) {
                    synchronized (q1.class) {
                        aVar = zzl;
                        if (aVar == null) {
                            aVar = new u4.a<>(zzk);
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
