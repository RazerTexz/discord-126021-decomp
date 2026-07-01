package b.i.a.f.h.l;

import b.i.a.f.h.l.u4;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class m0 extends u4<m0, a> implements d6 {
    private static final m0 zzh;
    private static volatile j6<m0> zzi;
    private int zzc;
    private p0 zzd;
    private n0 zze;
    private boolean zzf;
    private String zzg = "";

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public static final class a extends u4.b<m0, a> implements d6 {
        public a() {
            super(m0.zzh);
        }

        public a(q0 q0Var) {
            super(m0.zzh);
        }
    }

    static {
        m0 m0Var = new m0();
        zzh = m0Var;
        u4.r(m0.class, m0Var);
    }

    public static m0 D() {
        return zzh;
    }

    public static void u(m0 m0Var, String str) {
        Objects.requireNonNull(m0Var);
        str.getClass();
        m0Var.zzc |= 8;
        m0Var.zzg = str;
    }

    public final boolean A() {
        return this.zzf;
    }

    public final boolean B() {
        return (this.zzc & 8) != 0;
    }

    public final String C() {
        return this.zzg;
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (q0.a[i - 1]) {
            case 1:
                return new m0();
            case 2:
                return new a(null);
            case 3:
                return new o6(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                j6<m0> aVar = zzi;
                if (aVar == null) {
                    synchronized (m0.class) {
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

    public final boolean v() {
        return (this.zzc & 1) != 0;
    }

    public final p0 w() {
        p0 p0Var = this.zzd;
        return p0Var == null ? p0.C() : p0Var;
    }

    public final boolean x() {
        return (this.zzc & 2) != 0;
    }

    public final n0 y() {
        n0 n0Var = this.zze;
        return n0Var == null ? n0.E() : n0Var;
    }

    public final boolean z() {
        return (this.zzc & 4) != 0;
    }
}
