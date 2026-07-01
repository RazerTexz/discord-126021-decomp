package b.i.a.f.h.l;

import b.i.a.f.h.l.u4;
import com.discord.widgets.chat.input.MentionUtils;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class p0 extends u4<p0, a> implements d6 {
    private static final p0 zzh;
    private static volatile j6<p0> zzi;
    private int zzc;
    private int zzd;
    private boolean zzf;
    private String zze = "";
    private b5<String> zzg = m6.k;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends u4.b<p0, a> implements d6 {
        public a(q0 q0Var) {
            super(p0.zzh);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public enum b implements y4 {
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

        public static b f(int i) {
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

        @Override // b.i.a.f.h.l.y4
        public final int a() {
            return this.zzi;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + b.class.getName() + MentionUtils.MENTIONS_CHAR + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + '>';
        }
    }

    static {
        p0 p0Var = new p0();
        zzh = p0Var;
        u4.r(p0.class, p0Var);
    }

    public static p0 C() {
        return zzh;
    }

    public final List<String> A() {
        return this.zzg;
    }

    public final int B() {
        return this.zzg.size();
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (q0.a[i - 1]) {
            case 1:
                return new p0();
            case 2:
                return new a(null);
            case 3:
                return new o6(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zzc", "zzd", w0.a, "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                j6<p0> aVar = zzi;
                if (aVar == null) {
                    synchronized (p0.class) {
                        aVar = zzi;
                        if (aVar == null) {
                            aVar = new u4.a<>(zzh);
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

    public final boolean u() {
        return (this.zzc & 1) != 0;
    }

    public final b v() {
        b bVarF = b.f(this.zzd);
        return bVarF == null ? b.UNKNOWN_MATCH_TYPE : bVarF;
    }

    public final boolean w() {
        return (this.zzc & 2) != 0;
    }

    public final String x() {
        return this.zze;
    }

    public final boolean y() {
        return (this.zzc & 4) != 0;
    }

    public final boolean z() {
        return this.zzf;
    }
}
