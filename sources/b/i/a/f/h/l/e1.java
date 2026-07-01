package b.i.a.f.h.l;

import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class e1 extends u4<e1, e1$a> implements d6 {
    public static final /* synthetic */ int j = 0;
    private static final e1 zzax;
    private static volatile j6<e1> zzay;
    private int zzaa;
    private String zzab;
    private String zzac;
    private boolean zzad;
    private b5<y0> zzae;
    private String zzaf;
    private int zzag;
    private int zzah;
    private int zzai;
    private String zzaj;
    private long zzak;
    private long zzal;
    private String zzam;
    private String zzan;
    private int zzao;
    private String zzap;
    private f1 zzaq;
    private z4 zzar;
    private long zzas;
    private long zzat;
    private String zzau;
    private String zzav;
    private int zzaw;
    private int zzc;
    private int zzd;
    private int zze;
    private b5<a1> zzf;
    private b5<i1> zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;
    private String zzm;
    private String zzn;
    private String zzo;
    private String zzp;
    private int zzq;
    private String zzr;
    private String zzs;
    private String zzt;
    private long zzu;
    private long zzv;
    private String zzw;
    private boolean zzx;
    private String zzy;
    private long zzz;

    static {
        e1 e1Var = new e1();
        zzax = e1Var;
        u4.r(e1.class, e1Var);
    }

    public e1() {
        m6<Object> m6Var = m6.k;
        this.zzf = m6Var;
        this.zzg = m6Var;
        this.zzm = "";
        this.zzn = "";
        this.zzo = "";
        this.zzp = "";
        this.zzr = "";
        this.zzs = "";
        this.zzt = "";
        this.zzw = "";
        this.zzy = "";
        this.zzab = "";
        this.zzac = "";
        this.zzae = m6Var;
        this.zzaf = "";
        this.zzaj = "";
        this.zzam = "";
        this.zzan = "";
        this.zzap = "";
        this.zzar = x4.k;
        this.zzau = "";
        this.zzav = "";
    }

    public static void A(e1 e1Var, i1 i1Var) {
        Objects.requireNonNull(e1Var);
        i1Var.getClass();
        e1Var.x0();
        e1Var.zzg.add(i1Var);
    }

    public static void A0(e1 e1Var, int i) {
        e1Var.x0();
        e1Var.zzg.remove(i);
    }

    public static void B(e1 e1Var, Iterable iterable) {
        e1Var.w0();
        l3.c(iterable, e1Var.zzf);
    }

    public static void B0(e1 e1Var, long j2) {
        e1Var.zzc |= 8;
        e1Var.zzj = j2;
    }

    public static void C(e1 e1Var, String str) {
        Objects.requireNonNull(e1Var);
        str.getClass();
        e1Var.zzc |= 64;
        e1Var.zzm = str;
    }

    public static void C0(e1 e1Var, Iterable iterable) {
        b5<y0> b5Var = e1Var.zzae;
        if (!b5Var.a()) {
            e1Var.zzae = u4.n(b5Var);
        }
        l3.c(iterable, e1Var.zzae);
    }

    public static void D(e1 e1Var, boolean z2) {
        e1Var.zzc |= 131072;
        e1Var.zzx = z2;
    }

    public static void D0(e1 e1Var, String str) {
        Objects.requireNonNull(e1Var);
        str.getClass();
        e1Var.zzc |= 256;
        e1Var.zzo = str;
    }

    public static void F0(e1 e1Var) {
        e1Var.zzc &= -65537;
        e1Var.zzw = zzax.zzw;
    }

    public static void G(e1 e1Var) {
        e1Var.zzc |= 1;
        e1Var.zze = 1;
    }

    public static void G0(e1 e1Var, int i) {
        e1Var.zzc |= 1024;
        e1Var.zzq = i;
    }

    public static void H0(e1 e1Var, long j2) {
        e1Var.zzc |= 16;
        e1Var.zzk = j2;
    }

    public static void I0(e1 e1Var, Iterable iterable) {
        RandomAccess randomAccess = e1Var.zzar;
        if (!((o3) randomAccess).j) {
            x4 x4Var = (x4) randomAccess;
            int i = x4Var.m;
            e1Var.zzar = x4Var.d(i == 0 ? 10 : i << 1);
        }
        l3.c(iterable, e1Var.zzar);
    }

    public static void J0(e1 e1Var, String str) {
        Objects.requireNonNull(e1Var);
        str.getClass();
        e1Var.zzc |= 512;
        e1Var.zzp = str;
    }

    public static void L0(e1 e1Var) {
        e1Var.zzc &= -131073;
        e1Var.zzx = false;
    }

    public static void M0(e1 e1Var, int i) {
        e1Var.zzc |= 1048576;
        e1Var.zzaa = i;
    }

    public static void N0(e1 e1Var, long j2) {
        e1Var.zzc |= 32;
        e1Var.zzl = j2;
    }

    public static void O0(e1 e1Var, String str) {
        Objects.requireNonNull(e1Var);
        str.getClass();
        e1Var.zzc |= 2048;
        e1Var.zzr = str;
    }

    public static void Q0(e1 e1Var) {
        e1Var.zzc &= -262145;
        e1Var.zzy = zzax.zzy;
    }

    public static void R0(e1 e1Var, int i) {
        e1Var.zzc |= 33554432;
        e1Var.zzag = i;
    }

    public static void S0(e1 e1Var, long j2) {
        e1Var.zzc |= 16384;
        e1Var.zzu = j2;
    }

    public static void T0(e1 e1Var, String str) {
        Objects.requireNonNull(e1Var);
        str.getClass();
        e1Var.zzc |= 4096;
        e1Var.zzs = str;
    }

    public static void U0(e1 e1Var) {
        e1Var.zzc &= -2097153;
        e1Var.zzab = zzax.zzab;
    }

    public static void V0(e1 e1Var, int i) {
        e1Var.zzd |= 2;
        e1Var.zzao = i;
    }

    public static void W0(e1 e1Var, long j2) {
        e1Var.zzc |= 32768;
        e1Var.zzv = j2;
    }

    public static void X0(e1 e1Var, String str) {
        Objects.requireNonNull(e1Var);
        str.getClass();
        e1Var.zzc |= 8192;
        e1Var.zzt = str;
    }

    public static void a1(e1 e1Var) {
        Objects.requireNonNull(e1Var);
        e1Var.zzae = m6.k;
    }

    public static void b1(e1 e1Var, long j2) {
        e1Var.zzc |= 524288;
        e1Var.zzz = j2;
    }

    public static void c1(e1 e1Var, String str) {
        Objects.requireNonNull(e1Var);
        str.getClass();
        e1Var.zzc |= 65536;
        e1Var.zzw = str;
    }

    public static void d1(e1 e1Var) {
        e1Var.zzc &= -268435457;
        e1Var.zzaj = zzax.zzaj;
    }

    public static void e1(e1 e1Var, long j2) {
        e1Var.zzc |= 536870912;
        e1Var.zzak = j2;
    }

    public static void f1(e1 e1Var, String str) {
        Objects.requireNonNull(e1Var);
        str.getClass();
        e1Var.zzc |= 262144;
        e1Var.zzy = str;
    }

    public static void i0(e1 e1Var) {
        e1Var.zzc &= -17;
        e1Var.zzk = 0L;
    }

    public static void i1(e1 e1Var) {
        e1Var.zzc &= Integer.MAX_VALUE;
        e1Var.zzam = zzax.zzam;
    }

    public static void j0(e1 e1Var, int i) {
        e1Var.w0();
        e1Var.zzf.remove(i);
    }

    public static void j1(e1 e1Var, long j2) {
        e1Var.zzc |= BasicMeasure.EXACTLY;
        e1Var.zzal = j2;
    }

    public static void k0(e1 e1Var, long j2) {
        e1Var.zzc |= 4;
        e1Var.zzi = j2;
    }

    public static void k1(e1 e1Var, String str) {
        Objects.requireNonNull(e1Var);
        str.getClass();
        e1Var.zzc |= 2097152;
        e1Var.zzab = str;
    }

    public static void l0(e1 e1Var, String str) {
        Objects.requireNonNull(e1Var);
        str.getClass();
        e1Var.zzc |= 128;
        e1Var.zzn = str;
    }

    public static void l1(e1 e1Var, long j2) {
        e1Var.zzd |= 16;
        e1Var.zzas = j2;
    }

    public static void m0(e1 e1Var, boolean z2) {
        e1Var.zzc |= 8388608;
        e1Var.zzad = z2;
    }

    public static void m1(e1 e1Var, String str) {
        Objects.requireNonNull(e1Var);
        str.getClass();
        e1Var.zzc |= 4194304;
        e1Var.zzac = str;
    }

    public static void p1(e1 e1Var, long j2) {
        e1Var.zzd |= 32;
        e1Var.zzat = j2;
    }

    public static void q1(e1 e1Var, String str) {
        Objects.requireNonNull(e1Var);
        str.getClass();
        e1Var.zzc |= 16777216;
        e1Var.zzaf = str;
    }

    public static void r1(e1 e1Var, String str) {
        Objects.requireNonNull(e1Var);
        str.getClass();
        e1Var.zzc |= 268435456;
        e1Var.zzaj = str;
    }

    public static e1$a u0() {
        return zzax.s();
    }

    public static void u1(e1 e1Var, String str) {
        Objects.requireNonNull(e1Var);
        str.getClass();
        e1Var.zzd |= 4;
        e1Var.zzap = str;
    }

    public static void v(e1 e1Var) {
        Objects.requireNonNull(e1Var);
        e1Var.zzf = m6.k;
    }

    public static /* synthetic */ e1 v0() {
        return zzax;
    }

    public static void w(e1 e1Var, int i, a1 a1Var) {
        Objects.requireNonNull(e1Var);
        e1Var.w0();
        e1Var.zzf.set(i, a1Var);
    }

    public static void x(e1 e1Var, int i, i1 i1Var) {
        Objects.requireNonNull(e1Var);
        i1Var.getClass();
        e1Var.x0();
        e1Var.zzg.set(i, i1Var);
    }

    public static void x1(e1 e1Var, String str) {
        Objects.requireNonNull(e1Var);
        str.getClass();
        e1Var.zzd |= 64;
        e1Var.zzau = str;
    }

    public static void y(e1 e1Var, long j2) {
        e1Var.zzc |= 2;
        e1Var.zzh = j2;
    }

    public static void z(e1 e1Var, a1 a1Var) {
        Objects.requireNonNull(e1Var);
        e1Var.w0();
        e1Var.zzf.add(a1Var);
    }

    public static void z0(e1 e1Var) {
        e1Var.zzc &= -33;
        e1Var.zzl = 0L;
    }

    public static void z1(e1 e1Var, String str) {
        Objects.requireNonNull(e1Var);
        str.getClass();
        e1Var.zzd |= 128;
        e1Var.zzav = str;
    }

    public final String A1() {
        return this.zzn;
    }

    public final String B1() {
        return this.zzo;
    }

    public final String C1() {
        return this.zzp;
    }

    public final boolean D1() {
        return (this.zzc & 1024) != 0;
    }

    public final boolean E() {
        return (this.zzc & 1) != 0;
    }

    public final int E0() {
        return this.zzf.size();
    }

    public final int E1() {
        return this.zzq;
    }

    public final long F() {
        return this.zzu;
    }

    public final String F1() {
        return this.zzr;
    }

    public final String G1() {
        return this.zzs;
    }

    public final boolean H() {
        return (this.zzc & 32768) != 0;
    }

    public final String H1() {
        return this.zzt;
    }

    public final long I() {
        return this.zzv;
    }

    public final boolean I1() {
        return (this.zzc & 16384) != 0;
    }

    public final String J() {
        return this.zzw;
    }

    public final boolean K() {
        return (this.zzc & 131072) != 0;
    }

    public final List<i1> K0() {
        return this.zzg;
    }

    public final boolean L() {
        return this.zzx;
    }

    public final String M() {
        return this.zzy;
    }

    public final boolean N() {
        return (this.zzc & 524288) != 0;
    }

    public final long O() {
        return this.zzz;
    }

    public final boolean P() {
        return (this.zzc & 1048576) != 0;
    }

    public final int P0() {
        return this.zzg.size();
    }

    public final int Q() {
        return this.zzaa;
    }

    public final String R() {
        return this.zzab;
    }

    public final String S() {
        return this.zzac;
    }

    public final boolean T() {
        return (this.zzc & 8388608) != 0;
    }

    public final boolean U() {
        return this.zzad;
    }

    public final List<y0> V() {
        return this.zzae;
    }

    public final String W() {
        return this.zzaf;
    }

    public final boolean X() {
        return (this.zzc & 33554432) != 0;
    }

    public final int Y() {
        return this.zzag;
    }

    public final boolean Y0() {
        return (this.zzc & 2) != 0;
    }

    public final String Z() {
        return this.zzaj;
    }

    public final long Z0() {
        return this.zzh;
    }

    public final boolean a0() {
        return (this.zzc & 536870912) != 0;
    }

    public final long b0() {
        return this.zzak;
    }

    public final boolean c0() {
        return (this.zzc & BasicMeasure.EXACTLY) != 0;
    }

    public final long d0() {
        return this.zzal;
    }

    public final String e0() {
        return this.zzam;
    }

    public final boolean f0() {
        return (this.zzd & 2) != 0;
    }

    public final int g0() {
        return this.zze;
    }

    public final boolean g1() {
        return (this.zzc & 4) != 0;
    }

    public final i1 h0(int i) {
        return this.zzg.get(i);
    }

    public final long h1() {
        return this.zzi;
    }

    public final int n0() {
        return this.zzao;
    }

    public final boolean n1() {
        return (this.zzc & 8) != 0;
    }

    public final String o0() {
        return this.zzap;
    }

    public final long o1() {
        return this.zzj;
    }

    @Override // b.i.a.f.h.l.u4
    public final Object p(int i, Object obj, Object obj2) {
        switch (k1.a[i - 1]) {
            case 1:
                return new e1();
            case 2:
                return new e1$a(null);
            case 3:
                return new o6(zzax, "\u0001-\u0000\u0002\u00015-\u0000\u0004\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဂ\u0001\u0005ဂ\u0002\u0006ဂ\u0003\u0007ဂ\u0005\bဈ\u0006\tဈ\u0007\nဈ\b\u000bဈ\t\fင\n\rဈ\u000b\u000eဈ\f\u0010ဈ\r\u0011ဂ\u000e\u0012ဂ\u000f\u0013ဈ\u0010\u0014ဇ\u0011\u0015ဈ\u0012\u0016ဂ\u0013\u0017င\u0014\u0018ဈ\u0015\u0019ဈ\u0016\u001aဂ\u0004\u001cဇ\u0017\u001d\u001b\u001eဈ\u0018\u001fင\u0019 င\u001a!င\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဈ\u001f&ဈ 'င!)ဈ\",ဉ#-\u001d.ဂ$/ဂ%2ဈ&4ဈ'5ဌ(", new Object[]{"zzc", "zzd", "zze", "zzf", a1.class, "zzg", i1.class, "zzh", "zzi", "zzj", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzaa", "zzab", "zzac", "zzk", "zzad", "zzae", y0.class, "zzaf", "zzag", "zzah", "zzai", "zzaj", "zzak", "zzal", "zzam", "zzan", "zzao", "zzap", "zzaq", "zzar", "zzas", "zzat", "zzau", "zzav", "zzaw", l1.a});
            case 4:
                return zzax;
            case 5:
                j6<e1> u4_a = zzay;
                if (u4_a == null) {
                    synchronized (e1.class) {
                        u4_a = zzay;
                        if (u4_a == null) {
                            u4_a = new u4$a<>(zzax);
                            zzay = u4_a;
                        }
                        break;
                    }
                }
                return u4_a;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final boolean p0() {
        return (this.zzd & 16) != 0;
    }

    public final long q0() {
        return this.zzas;
    }

    public final String r0() {
        return this.zzau;
    }

    public final boolean s0() {
        return (this.zzd & 128) != 0;
    }

    public final boolean s1() {
        return (this.zzc & 16) != 0;
    }

    public final String t0() {
        return this.zzav;
    }

    public final long t1() {
        return this.zzk;
    }

    public final a1 u(int i) {
        return this.zzf.get(i);
    }

    public final boolean v1() {
        return (this.zzc & 32) != 0;
    }

    public final void w0() {
        b5<a1> b5Var = this.zzf;
        if (b5Var.a()) {
            return;
        }
        this.zzf = u4.n(b5Var);
    }

    public final long w1() {
        return this.zzl;
    }

    public final void x0() {
        b5<i1> b5Var = this.zzg;
        if (b5Var.a()) {
            return;
        }
        this.zzg = u4.n(b5Var);
    }

    public final List<a1> y0() {
        return this.zzf;
    }

    public final String y1() {
        return this.zzm;
    }
}
