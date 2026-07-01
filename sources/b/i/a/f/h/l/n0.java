package b.i.a.f.h.l;

import b.i.a.f.h.l.u4;
import com.discord.widgets.chat.input.MentionUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class n0 extends u4<n0, b> implements d6 {
    private static final n0 zzi;
    private static volatile j6<n0> zzj;
    private int zzc;
    private int zzd;
    private boolean zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public enum a implements y4 {
        UNKNOWN_COMPARISON_TYPE(0),
        LESS_THAN(1),
        GREATER_THAN(2),
        EQUAL(3),
        BETWEEN(4);

        private final int zzg;

        a(int i) {
            this.zzg = i;
        }

        public static a f(int i) {
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
    public static final class b extends u4.b<n0, b> implements d6 {
        public b(q0 q0Var) {
            super(n0.zzi);
        }
    }

    static {
        n0 n0Var = new n0();
        zzi = n0Var;
        u4.r(n0.class, n0Var);
    }

    public static n0 E() {
        return zzi;
    }

    public final boolean A() {
        return (this.zzc & 8) != 0;
    }

    public final String B() {
        return this.zzg;
    }

    public final boolean C() {
        return (this.zzc & 16) != 0;
    }

    public final String D() {
        return this.zzh;
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (q0.a[i - 1]) {
            case 1:
                return new n0();
            case 2:
                return new b(null);
            case 3:
                return new o6(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zzc", "zzd", r0.a, "zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzi;
            case 5:
                j6<n0> aVar = zzj;
                if (aVar == null) {
                    synchronized (n0.class) {
                        aVar = zzj;
                        if (aVar == null) {
                            aVar = new u4.a<>(zzi);
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

    public final boolean u() {
        return (this.zzc & 1) != 0;
    }

    public final a v() {
        a aVarF = a.f(this.zzd);
        return aVarF == null ? a.UNKNOWN_COMPARISON_TYPE : aVarF;
    }

    public final boolean w() {
        return (this.zzc & 2) != 0;
    }

    public final boolean x() {
        return this.zze;
    }

    public final boolean y() {
        return (this.zzc & 4) != 0;
    }

    public final String z() {
        return this.zzf;
    }
}
