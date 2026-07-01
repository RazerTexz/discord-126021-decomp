package b.i.a.f.h.l;

import b.i.a.f.h.l.u4;
import com.discord.widgets.chat.input.MentionUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class f1 extends u4<f1, a> implements d6 {
    private static final f1 zzf;
    private static volatile j6<f1> zzg;
    private int zzc;
    private int zzd = 1;
    private b5<b1> zze = m6.k;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends u4.b<f1, a> implements d6 {
        public a(k1 k1Var) {
            super(f1.zzf);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public enum b implements y4 {
        RADS(1),
        PROVISIONING(2);

        private final int zzd;

        b(int i) {
            this.zzd = i;
        }

        @Override // b.i.a.f.h.l.y4
        public final int a() {
            return this.zzd;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + b.class.getName() + MentionUtils.MENTIONS_CHAR + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + '>';
        }
    }

    static {
        f1 f1Var = new f1();
        zzf = f1Var;
        u4.r(f1.class, f1Var);
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (k1.a[i - 1]) {
            case 1:
                return new f1();
            case 2:
                return new a(null);
            case 3:
                return new o6(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zzc", "zzd", m1.a, "zze", b1.class});
            case 4:
                return zzf;
            case 5:
                j6<f1> aVar = zzg;
                if (aVar == null) {
                    synchronized (f1.class) {
                        aVar = zzg;
                        if (aVar == null) {
                            aVar = new u4.a<>(zzf);
                            zzg = aVar;
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
