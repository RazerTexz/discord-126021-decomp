package b.i.a.c;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import android.util.SparseBooleanArray;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import b.i.a.c.a3.a0$a;
import b.i.a.c.a3.k0$a;
import b.i.a.c.f3.b0$b;
import b.i.a.c.f3.p$b;
import b.i.a.c.f3.p$c;
import com.google.android.exoplayer2.IllegalSeekPositionException;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: ExoPlayerImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f1 extends u0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f958b = 0;
    public int A;
    public b.i.a.c.a3.k0 B;
    public y1$b C;
    public p1 D;
    public p1 E;
    public w1 F;
    public int G;
    public long H;
    public final b.i.a.c.c3.r c;
    public final y1$b d;
    public final f2[] e;
    public final b.i.a.c.c3.q f;
    public final b.i.a.c.f3.o g;
    public final h1$e h;
    public final h1 i;
    public final b.i.a.c.f3.p<y1$c> j;
    public final CopyOnWriteArraySet<e1$a> k;
    public final o2$b l;
    public final List<f1$a> m;
    public final boolean n;
    public final b.i.a.c.a3.c0 o;

    @Nullable
    public final b.i.a.c.s2.g1 p;
    public final Looper q;
    public final b.i.a.c.e3.f r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f959s;
    public final long t;
    public final b.i.a.c.f3.g u;
    public int v;
    public boolean w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f960x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f961y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f962z;

    static {
        i1.a("goog.exo.exoplayer");
    }

    @SuppressLint({"HandlerLeak"})
    public f1(f2[] f2VarArr, b.i.a.c.c3.q qVar, b.i.a.c.a3.c0 c0Var, n1 n1Var, b.i.a.c.e3.f fVar, @Nullable b.i.a.c.s2.g1 g1Var, boolean z2, j2 j2Var, long j, long j2, m1 m1Var, long j3, boolean z3, b.i.a.c.f3.g gVar, Looper looper, @Nullable y1 y1Var, y1$b y1_b) {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = b.i.a.c.f3.e0.e;
        StringBuilder sbS = b.d.b.a.a.S(b.d.b.a.a.b(str, b.d.b.a.a.b(hexString, 30)), "Init ", hexString, " [", "ExoPlayerLib/2.16.0");
        sbS.append("] [");
        sbS.append(str);
        sbS.append("]");
        Log.i("ExoPlayerImpl", sbS.toString());
        b.c.a.a0.d.D(f2VarArr.length > 0);
        this.e = f2VarArr;
        Objects.requireNonNull(qVar);
        this.f = qVar;
        this.o = c0Var;
        this.r = fVar;
        this.p = g1Var;
        this.n = z2;
        this.f959s = j;
        this.t = j2;
        this.q = looper;
        this.u = gVar;
        this.v = 0;
        this.j = new b.i.a.c.f3.p<>(new CopyOnWriteArraySet(), looper, gVar, new u(y1Var));
        this.k = new CopyOnWriteArraySet<>();
        this.m = new ArrayList();
        this.B = new k0$a(0, new Random());
        this.c = new b.i.a.c.c3.r(new h2[f2VarArr.length], new b.i.a.c.c3.j[f2VarArr.length], p2.j, null);
        this.l = new o2$b();
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = {1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 20, 30};
        for (int i = 0; i < 12; i++) {
            int i2 = iArr[i];
            b.c.a.a0.d.D(!false);
            sparseBooleanArray.append(i2, true);
        }
        if (qVar instanceof b.i.a.c.c3.h) {
            b.c.a.a0.d.D(!false);
            sparseBooleanArray.append(29, true);
        }
        b.i.a.c.f3.n nVar = y1_b.k;
        for (int i3 = 0; i3 < nVar.c(); i3++) {
            int iB = nVar.b(i3);
            b.c.a.a0.d.D(true);
            sparseBooleanArray.append(iB, true);
        }
        b.c.a.a0.d.D(true);
        b.i.a.c.f3.n nVar2 = new b.i.a.c.f3.n(sparseBooleanArray, null);
        this.d = new y1$b(nVar2, null);
        SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray();
        for (int i4 = 0; i4 < nVar2.c(); i4++) {
            int iB2 = nVar2.b(i4);
            b.c.a.a0.d.D(true);
            sparseBooleanArray2.append(iB2, true);
        }
        b.c.a.a0.d.D(true);
        sparseBooleanArray2.append(4, true);
        b.c.a.a0.d.D(true);
        sparseBooleanArray2.append(10, true);
        b.c.a.a0.d.D(true);
        this.C = new y1$b(new b.i.a.c.f3.n(sparseBooleanArray2, null), null);
        p1 p1Var = p1.j;
        this.D = p1Var;
        this.E = p1Var;
        this.G = -1;
        this.g = gVar.b(looper, null);
        w wVar = new w(this);
        this.h = wVar;
        this.F = w1.h(this.c);
        if (g1Var != null) {
            b.c.a.a0.d.D(g1Var.p == null || g1Var.m.f1081b.isEmpty());
            g1Var.p = y1Var;
            g1Var.q = g1Var.j.b(looper, null);
            b.i.a.c.f3.p<b.i.a.c.s2.h1> pVar = g1Var.o;
            g1Var.o = new b.i.a.c.f3.p<>(pVar.d, looper, pVar.a, new b.i.a.c.s2.h(g1Var, y1Var));
            d0(g1Var);
            fVar.f(new Handler(looper), g1Var);
        }
        this.i = new h1(f2VarArr, qVar, this.c, n1Var, fVar, this.v, this.w, g1Var, j2Var, m1Var, j3, z3, looper, gVar, wVar);
    }

    public static long j0(w1 w1Var) {
        o2$c o2_c = new o2$c();
        o2$b o2_b = new o2$b();
        w1Var.f1146b.h(w1Var.c.a, o2_b);
        long j = w1Var.d;
        return j == -9223372036854775807L ? w1Var.f1146b.n(o2_b.l, o2_c).f1045z : o2_b.n + j;
    }

    public static boolean k0(w1 w1Var) {
        return w1Var.f == 3 && w1Var.m && w1Var.n == 0;
    }

    @Override // b.i.a.c.y1
    public List A() {
        b.i.b.b.a<Object> aVar = b.i.b.b.p.k;
        return b.i.b.b.h0.l;
    }

    @Override // b.i.a.c.y1
    public int B() {
        if (f()) {
            return this.F.c.f835b;
        }
        return -1;
    }

    @Override // b.i.a.c.y1
    public int C() {
        int iH0 = h0();
        if (iH0 == -1) {
            return 0;
        }
        return iH0;
    }

    @Override // b.i.a.c.y1
    public void E(int i) {
        if (this.v != i) {
            this.v = i;
            ((b0$b) this.i.q.a(11, i, 0)).b();
            this.j.b(8, new k(i));
            r0();
            this.j.a();
        }
    }

    @Override // b.i.a.c.y1
    public void F(@Nullable SurfaceView surfaceView) {
    }

    @Override // b.i.a.c.y1
    public int G() {
        return this.F.n;
    }

    @Override // b.i.a.c.y1
    public p2 H() {
        return this.F.j.d;
    }

    @Override // b.i.a.c.y1
    public int I() {
        return this.v;
    }

    @Override // b.i.a.c.y1
    public long J() {
        if (f()) {
            w1 w1Var = this.F;
            a0$a a0_a = w1Var.c;
            w1Var.f1146b.h(a0_a.a, this.l);
            return b.i.a.c.f3.e0.M(this.l.a(a0_a.f835b, a0_a.c));
        }
        o2 o2VarK = K();
        if (o2VarK.q()) {
            return -9223372036854775807L;
        }
        return o2VarK.n(C(), this.a).b();
    }

    @Override // b.i.a.c.y1
    public o2 K() {
        return this.F.f1146b;
    }

    @Override // b.i.a.c.y1
    public Looper L() {
        return this.q;
    }

    @Override // b.i.a.c.y1
    public boolean M() {
        return this.w;
    }

    @Override // b.i.a.c.y1
    public long N() {
        if (this.F.f1146b.q()) {
            return this.H;
        }
        w1 w1Var = this.F;
        if (w1Var.l.d != w1Var.c.d) {
            return w1Var.f1146b.n(C(), this.a).b();
        }
        long j = w1Var.r;
        if (this.F.l.a()) {
            w1 w1Var2 = this.F;
            o2$b o2_bH = w1Var2.f1146b.h(w1Var2.l.a, this.l);
            long jC = o2_bH.c(this.F.l.f835b);
            j = jC == Long.MIN_VALUE ? o2_bH.m : jC;
        }
        w1 w1Var3 = this.F;
        return b.i.a.c.f3.e0.M(m0(w1Var3.f1146b, w1Var3.l, j));
    }

    @Override // b.i.a.c.y1
    public void Q(@Nullable TextureView textureView) {
    }

    @Override // b.i.a.c.y1
    public p1 S() {
        return this.D;
    }

    @Override // b.i.a.c.y1
    public long T() {
        return b.i.a.c.f3.e0.M(g0(this.F));
    }

    @Override // b.i.a.c.y1
    public long U() {
        return this.f959s;
    }

    @Override // b.i.a.c.y1
    public void a() {
        w1 w1Var = this.F;
        if (w1Var.f != 1) {
            return;
        }
        w1 w1VarE = w1Var.e(null);
        w1 w1VarF = w1VarE.f(w1VarE.f1146b.q() ? 4 : 2);
        this.f960x++;
        ((b0$b) this.i.q.c(0)).b();
        s0(w1VarF, 1, 1, false, false, 5, -9223372036854775807L, -1);
    }

    @Override // b.i.a.c.y1
    public x1 c() {
        return this.F.o;
    }

    public void d0(y1$c y1_c) {
        b.i.a.c.f3.p<y1$c> pVar = this.j;
        if (pVar.g) {
            return;
        }
        Objects.requireNonNull(y1_c);
        pVar.d.add(new p$c<>(y1_c));
    }

    public final p1 e0() {
        o2 o2VarK = K();
        o1 o1Var = o2VarK.q() ? null : o2VarK.n(C(), this.a).p;
        if (o1Var == null) {
            return this.E;
        }
        p1$b p1_bA = this.E.a();
        p1 p1Var = o1Var.n;
        if (p1Var != null) {
            CharSequence charSequence = p1Var.l;
            if (charSequence != null) {
                p1_bA.a = charSequence;
            }
            CharSequence charSequence2 = p1Var.m;
            if (charSequence2 != null) {
                p1_bA.f1050b = charSequence2;
            }
            CharSequence charSequence3 = p1Var.n;
            if (charSequence3 != null) {
                p1_bA.c = charSequence3;
            }
            CharSequence charSequence4 = p1Var.o;
            if (charSequence4 != null) {
                p1_bA.d = charSequence4;
            }
            CharSequence charSequence5 = p1Var.p;
            if (charSequence5 != null) {
                p1_bA.e = charSequence5;
            }
            CharSequence charSequence6 = p1Var.q;
            if (charSequence6 != null) {
                p1_bA.f = charSequence6;
            }
            CharSequence charSequence7 = p1Var.r;
            if (charSequence7 != null) {
                p1_bA.g = charSequence7;
            }
            Uri uri = p1Var.f1046s;
            if (uri != null) {
                p1_bA.h = uri;
            }
            d2 d2Var = p1Var.t;
            if (d2Var != null) {
                p1_bA.i = d2Var;
            }
            d2 d2Var2 = p1Var.u;
            if (d2Var2 != null) {
                p1_bA.j = d2Var2;
            }
            byte[] bArr = p1Var.v;
            if (bArr != null) {
                Integer num = p1Var.w;
                p1_bA.k = (byte[]) bArr.clone();
                p1_bA.l = num;
            }
            Uri uri2 = p1Var.f1047x;
            if (uri2 != null) {
                p1_bA.m = uri2;
            }
            Integer num2 = p1Var.f1048y;
            if (num2 != null) {
                p1_bA.n = num2;
            }
            Integer num3 = p1Var.f1049z;
            if (num3 != null) {
                p1_bA.o = num3;
            }
            Integer num4 = p1Var.A;
            if (num4 != null) {
                p1_bA.p = num4;
            }
            Boolean bool = p1Var.B;
            if (bool != null) {
                p1_bA.q = bool;
            }
            Integer num5 = p1Var.C;
            if (num5 != null) {
                p1_bA.r = num5;
            }
            Integer num6 = p1Var.D;
            if (num6 != null) {
                p1_bA.r = num6;
            }
            Integer num7 = p1Var.E;
            if (num7 != null) {
                p1_bA.f1051s = num7;
            }
            Integer num8 = p1Var.F;
            if (num8 != null) {
                p1_bA.t = num8;
            }
            Integer num9 = p1Var.G;
            if (num9 != null) {
                p1_bA.u = num9;
            }
            Integer num10 = p1Var.H;
            if (num10 != null) {
                p1_bA.v = num10;
            }
            Integer num11 = p1Var.I;
            if (num11 != null) {
                p1_bA.w = num11;
            }
            CharSequence charSequence8 = p1Var.J;
            if (charSequence8 != null) {
                p1_bA.f1052x = charSequence8;
            }
            CharSequence charSequence9 = p1Var.K;
            if (charSequence9 != null) {
                p1_bA.f1053y = charSequence9;
            }
            CharSequence charSequence10 = p1Var.L;
            if (charSequence10 != null) {
                p1_bA.f1054z = charSequence10;
            }
            Integer num12 = p1Var.M;
            if (num12 != null) {
                p1_bA.A = num12;
            }
            Integer num13 = p1Var.N;
            if (num13 != null) {
                p1_bA.B = num13;
            }
            CharSequence charSequence11 = p1Var.O;
            if (charSequence11 != null) {
                p1_bA.C = charSequence11;
            }
            CharSequence charSequence12 = p1Var.P;
            if (charSequence12 != null) {
                p1_bA.D = charSequence12;
            }
            Bundle bundle = p1Var.Q;
            if (bundle != null) {
                p1_bA.E = bundle;
            }
        }
        return p1_bA.a();
    }

    @Override // b.i.a.c.y1
    public boolean f() {
        return this.F.c.a();
    }

    public b2 f0(b2$b b2_b) {
        return new b2(this.i, b2_b, this.F.f1146b, C(), this.u, this.i.f1007s);
    }

    @Override // b.i.a.c.y1
    public long g() {
        return b.i.a.c.f3.e0.M(this.F.f1147s);
    }

    public final long g0(w1 w1Var) {
        if (w1Var.f1146b.q()) {
            return b.i.a.c.f3.e0.B(this.H);
        }
        return w1Var.c.a() ? w1Var.t : m0(w1Var.f1146b, w1Var.c, w1Var.t);
    }

    @Override // b.i.a.c.y1
    public void h(int i, long j) {
        o2 o2Var = this.F.f1146b;
        if (i < 0 || (!o2Var.q() && i >= o2Var.p())) {
            throw new IllegalSeekPositionException(o2Var, i, j);
        }
        this.f960x++;
        if (f()) {
            Log.w("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            h1$d h1_d = new h1$d(this.F);
            h1_d.a(1);
            f1 f1Var = ((w) this.h).a;
            f1Var.g.b(new c0(f1Var, h1_d));
            return;
        }
        int i2 = this.F.f != 1 ? 2 : 1;
        int iC = C();
        w1 w1VarL0 = l0(this.F.f(i2), o2Var, i0(o2Var, i, j));
        ((b0$b) this.i.q.i(3, new h1$g(o2Var, i, b.i.a.c.f3.e0.B(j)))).b();
        s0(w1VarL0, 0, 1, true, true, 1, g0(w1VarL0), iC);
    }

    public final int h0() {
        if (this.F.f1146b.q()) {
            return this.G;
        }
        w1 w1Var = this.F;
        return w1Var.f1146b.h(w1Var.c.a, this.l).l;
    }

    @Override // b.i.a.c.y1
    public y1$b i() {
        return this.C;
    }

    @Nullable
    public final Pair<Object, Long> i0(o2 o2Var, int i, long j) {
        if (o2Var.q()) {
            this.G = i;
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.H = j;
            return null;
        }
        if (i == -1 || i >= o2Var.p()) {
            i = o2Var.a(this.w);
            j = o2Var.n(i, this.a).a();
        }
        return o2Var.j(this.a, this.l, i, b.i.a.c.f3.e0.B(j));
    }

    @Override // b.i.a.c.y1
    public boolean j() {
        return this.F.m;
    }

    @Override // b.i.a.c.y1
    public void k(boolean z2) {
        if (this.w != z2) {
            this.w = z2;
            ((b0$b) this.i.q.a(12, z2 ? 1 : 0, 0)).b();
            this.j.b(9, new n(z2));
            r0();
            this.j.a();
        }
    }

    @Override // b.i.a.c.y1
    public long l() {
        return 3000L;
    }

    public final w1 l0(w1 w1Var, o2 o2Var, @Nullable Pair<Object, Long> pair) {
        List<Metadata> list;
        b.c.a.a0.d.j(o2Var.q() || pair != null);
        o2 o2Var2 = w1Var.f1146b;
        w1 w1VarG = w1Var.g(o2Var);
        if (o2Var.q()) {
            a0$a a0_a = w1.a;
            a0$a a0_a2 = w1.a;
            long jB = b.i.a.c.f3.e0.B(this.H);
            b.i.a.c.a3.o0 o0Var = b.i.a.c.a3.o0.j;
            b.i.a.c.c3.r rVar = this.c;
            b.i.b.b.a<Object> aVar = b.i.b.b.p.k;
            w1 w1VarA = w1VarG.b(a0_a2, jB, jB, jB, 0L, o0Var, rVar, b.i.b.b.h0.l).a(a0_a2);
            w1VarA.r = w1VarA.t;
            return w1VarA;
        }
        Object obj = w1VarG.c.a;
        int i = b.i.a.c.f3.e0.a;
        boolean z2 = !obj.equals(pair.first);
        a0$a a0_a3 = z2 ? new a0$a(pair.first) : w1VarG.c;
        long jLongValue = ((Long) pair.second).longValue();
        long jB2 = b.i.a.c.f3.e0.B(w());
        if (!o2Var2.q()) {
            jB2 -= o2Var2.h(obj, this.l).n;
        }
        if (z2 || jLongValue < jB2) {
            b.c.a.a0.d.D(!a0_a3.a());
            b.i.a.c.a3.o0 o0Var2 = z2 ? b.i.a.c.a3.o0.j : w1VarG.i;
            b.i.a.c.c3.r rVar2 = z2 ? this.c : w1VarG.j;
            if (z2) {
                b.i.b.b.a<Object> aVar2 = b.i.b.b.p.k;
                list = b.i.b.b.h0.l;
            } else {
                list = w1VarG.k;
            }
            w1 w1VarA2 = w1VarG.b(r0, jLongValue, jLongValue, jLongValue, 0L, o0Var2, rVar2, list).a(a0_a3);
            w1VarA2.r = jLongValue;
            return w1VarA2;
        }
        if (jLongValue == jB2) {
            int iB = o2Var.b(w1VarG.l.a);
            if (iB == -1 || o2Var.f(iB, this.l).l != o2Var.h(a0_a3.a, this.l).l) {
                o2Var.h(a0_a3.a, this.l);
                long jA = a0_a3.a() ? this.l.a(a0_a3.f835b, a0_a3.c) : this.l.m;
                w1VarG = w1VarG.b(a0_a3, w1VarG.t, w1VarG.t, w1VarG.e, jA - w1VarG.t, w1VarG.i, w1VarG.j, w1VarG.k).a(a0_a3);
                w1VarG.r = jA;
            }
        } else {
            b.c.a.a0.d.D(!a0_a3.a());
            long jMax = Math.max(0L, w1VarG.f1147s - (jLongValue - jB2));
            long j = w1VarG.r;
            if (w1VarG.l.equals(w1VarG.c)) {
                j = jLongValue + jMax;
            }
            w1VarG = w1VarG.b(a0_a3, jLongValue, jLongValue, jLongValue, jMax, w1VarG.i, w1VarG.j, w1VarG.k);
            w1VarG.r = j;
        }
        return w1VarG;
    }

    @Override // b.i.a.c.y1
    public int m() {
        if (this.F.f1146b.q()) {
            return 0;
        }
        w1 w1Var = this.F;
        return w1Var.f1146b.b(w1Var.c.a);
    }

    public final long m0(o2 o2Var, a0$a a0_a, long j) {
        o2Var.h(a0_a.a, this.l);
        return j + this.l.n;
    }

    @Override // b.i.a.c.y1
    public void n(@Nullable TextureView textureView) {
    }

    public void n0() {
        String str;
        boolean z2;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str2 = b.i.a.c.f3.e0.e;
        HashSet<String> hashSet = i1.a;
        synchronized (i1.class) {
            str = i1.f1016b;
        }
        StringBuilder sbS = b.d.b.a.a.S(b.d.b.a.a.b(str, b.d.b.a.a.b(str2, b.d.b.a.a.b(hexString, 36))), "Release ", hexString, " [", "ExoPlayerLib/2.16.0");
        b.d.b.a.a.s0(sbS, "] [", str2, "] [", str);
        sbS.append("]");
        Log.i("ExoPlayerImpl", sbS.toString());
        h1 h1Var = this.i;
        synchronized (h1Var) {
            if (h1Var.I || !h1Var.r.isAlive()) {
                z2 = true;
            } else {
                h1Var.q.f(7);
                long jD = h1Var.E;
                synchronized (h1Var) {
                    long jD2 = h1Var.f1010z.d() + jD;
                    boolean z3 = false;
                    while (!Boolean.valueOf(h1Var.I).booleanValue() && jD > 0) {
                        try {
                            h1Var.f1010z.c();
                            h1Var.wait(jD);
                        } catch (InterruptedException unused) {
                            z3 = true;
                        }
                        jD = jD2 - h1Var.f1010z.d();
                    }
                    if (z3) {
                        Thread.currentThread().interrupt();
                    }
                    z2 = h1Var.I;
                }
            }
        }
        if (!z2) {
            b.i.a.c.f3.p<y1$c> pVar = this.j;
            pVar.b(10, b0.a);
            pVar.a();
        }
        this.j.c();
        this.g.j(null);
        b.i.a.c.s2.g1 g1Var = this.p;
        if (g1Var != null) {
            this.r.d(g1Var);
        }
        w1 w1VarF = this.F.f(1);
        this.F = w1VarF;
        w1 w1VarA = w1VarF.a(w1VarF.c);
        this.F = w1VarA;
        w1VarA.r = w1VarA.t;
        this.F.f1147s = 0L;
    }

    @Override // b.i.a.c.y1
    public b.i.a.c.g3.y o() {
        return b.i.a.c.g3.y.j;
    }

    public void o0(y1$c y1_c) {
        b.i.a.c.f3.p<y1$c> pVar = this.j;
        for (p$c<y1$c> p_c : pVar.d) {
            if (p_c.a.equals(y1_c)) {
                p$b<y1$c> p_b = pVar.c;
                p_c.d = true;
                if (p_c.c) {
                    p_b.a(p_c.a, p_c.f974b.b());
                }
                pVar.d.remove(p_c);
            }
        }
    }

    @Override // b.i.a.c.y1
    public void p(y1$e y1_e) {
        o0(y1_e);
    }

    public final void p0(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            this.m.remove(i3);
        }
        this.B = this.B.a(i, i2);
    }

    @Override // b.i.a.c.y1
    public int q() {
        if (f()) {
            return this.F.c.c;
        }
        return -1;
    }

    public void q0(boolean z2, int i, int i2) {
        w1 w1Var = this.F;
        if (w1Var.m == z2 && w1Var.n == i) {
            return;
        }
        this.f960x++;
        w1 w1VarD = w1Var.d(z2, i);
        ((b0$b) this.i.q.a(1, z2 ? 1 : 0, i)).b();
        s0(w1VarD, 0, i2, false, false, 5, -9223372036854775807L, -1);
    }

    @Override // b.i.a.c.y1
    public void r(@Nullable SurfaceView surfaceView) {
    }

    public final void r0() {
        y1$b y1_b = this.C;
        y1$b y1_b2 = this.d;
        y1$b$a y1_b_a = new y1$b$a();
        y1_b_a.a(y1_b2);
        y1_b_a.b(4, !f());
        y1_b_a.b(5, a0() && !f());
        y1_b_a.b(6, X() && !f());
        y1_b_a.b(7, !K().q() && (X() || !Z() || a0()) && !f());
        y1_b_a.b(8, W() && !f());
        y1_b_a.b(9, !K().q() && (W() || (Z() && Y())) && !f());
        y1_b_a.b(10, !f());
        y1_b_a.b(11, a0() && !f());
        y1_b_a.b(12, a0() && !f());
        y1$b y1_bC = y1_b_a.c();
        this.C = y1_bC;
        if (y1_bC.equals(y1_b)) {
            return;
        }
        this.j.b(13, new x(this));
    }

    public final void s0(w1 w1Var, int i, int i2, boolean z2, boolean z3, int i3, long j, int i4) {
        Pair pair;
        int i5;
        o1 o1Var;
        int i6;
        Object obj;
        o1 o1Var2;
        Object obj2;
        int iB;
        long jJ0;
        long jJ1;
        Object obj3;
        o1 o1Var3;
        Object obj4;
        int iB2;
        w1 w1Var2 = this.F;
        this.F = w1Var;
        boolean z4 = !w1Var2.f1146b.equals(w1Var.f1146b);
        o2 o2Var = w1Var2.f1146b;
        o2 o2Var2 = w1Var.f1146b;
        if (o2Var2.q() && o2Var.q()) {
            pair = new Pair(Boolean.FALSE, -1);
        } else if (o2Var2.q() != o2Var.q()) {
            pair = new Pair(Boolean.TRUE, 3);
        } else if (o2Var.n(o2Var.h(w1Var2.c.a, this.l).l, this.a).n.equals(o2Var2.n(o2Var2.h(w1Var.c.a, this.l).l, this.a).n)) {
            pair = (z3 && i3 == 0 && w1Var2.c.d < w1Var.c.d) ? new Pair(Boolean.TRUE, 0) : new Pair(Boolean.FALSE, -1);
        } else {
            if (z3 && i3 == 0) {
                i5 = 1;
            } else if (z3 && i3 == 1) {
                i5 = 2;
            } else {
                if (!z4) {
                    throw new IllegalStateException();
                }
                i5 = 3;
            }
            pair = new Pair(Boolean.TRUE, Integer.valueOf(i5));
        }
        boolean zBooleanValue = ((Boolean) pair.first).booleanValue();
        int iIntValue = ((Integer) pair.second).intValue();
        p1 p1VarE0 = this.D;
        if (zBooleanValue) {
            o1Var = w1Var.f1146b.q() ? null : w1Var.f1146b.n(w1Var.f1146b.h(w1Var.c.a, this.l).l, this.a).p;
            this.E = p1.j;
        } else {
            o1Var = null;
        }
        if (zBooleanValue || !w1Var2.k.equals(w1Var.k)) {
            p1$b p1_bA = this.E.a();
            List<Metadata> list = w1Var.k;
            for (int i7 = 0; i7 < list.size(); i7++) {
                Metadata metadata = list.get(i7);
                int i8 = 0;
                while (true) {
                    Metadata$Entry[] metadata$EntryArr = metadata.j;
                    if (i8 < metadata$EntryArr.length) {
                        metadata$EntryArr[i8].n(p1_bA);
                        i8++;
                    }
                }
            }
            this.E = p1_bA.a();
            p1VarE0 = e0();
        }
        boolean z5 = !p1VarE0.equals(this.D);
        this.D = p1VarE0;
        if (!w1Var2.f1146b.equals(w1Var.f1146b)) {
            this.j.b(0, new d0(w1Var, i));
        }
        if (z3) {
            o2$b o2_b = new o2$b();
            if (w1Var2.f1146b.q()) {
                i6 = i4;
                obj = null;
                o1Var2 = null;
                obj2 = null;
                iB = -1;
            } else {
                Object obj5 = w1Var2.c.a;
                w1Var2.f1146b.h(obj5, o2_b);
                int i9 = o2_b.l;
                obj2 = obj5;
                i6 = i9;
                iB = w1Var2.f1146b.b(obj5);
                obj = w1Var2.f1146b.n(i9, this.a).n;
                o1Var2 = this.a.p;
            }
            if (i3 == 0) {
                jJ0 = o2_b.n + o2_b.m;
                if (w1Var2.c.a()) {
                    a0$a a0_a = w1Var2.c;
                    jJ0 = o2_b.a(a0_a.f835b, a0_a.c);
                    jJ1 = j0(w1Var2);
                } else {
                    if (w1Var2.c.e != -1 && this.F.c.a()) {
                        jJ0 = j0(this.F);
                    }
                    jJ1 = jJ0;
                }
            } else if (w1Var2.c.a()) {
                jJ0 = w1Var2.t;
                jJ1 = j0(w1Var2);
            } else {
                jJ0 = o2_b.n + w1Var2.t;
                jJ1 = jJ0;
            }
            long jM = b.i.a.c.f3.e0.M(jJ0);
            long jM2 = b.i.a.c.f3.e0.M(jJ1);
            a0$a a0_a2 = w1Var2.c;
            y1$f y1_f = new y1$f(obj, i6, o1Var2, obj2, iB, jM, jM2, a0_a2.f835b, a0_a2.c);
            int iC = C();
            if (this.F.f1146b.q()) {
                obj3 = null;
                o1Var3 = null;
                obj4 = null;
                iB2 = -1;
            } else {
                w1 w1Var3 = this.F;
                Object obj6 = w1Var3.c.a;
                w1Var3.f1146b.h(obj6, this.l);
                iB2 = this.F.f1146b.b(obj6);
                obj4 = obj6;
                obj3 = this.F.f1146b.n(iC, this.a).n;
                o1Var3 = this.a.p;
            }
            long jM3 = b.i.a.c.f3.e0.M(j);
            long jM4 = this.F.c.a() ? b.i.a.c.f3.e0.M(j0(this.F)) : jM3;
            a0$a a0_a3 = this.F.c;
            this.j.b(11, new a0(i3, y1_f, new y1$f(obj3, iC, o1Var3, obj4, iB2, jM3, jM4, a0_a3.f835b, a0_a3.c)));
        }
        if (zBooleanValue) {
            this.j.b(1, new z(o1Var, iIntValue));
        }
        if (w1Var2.g != w1Var.g) {
            this.j.b(10, new l(w1Var));
            if (w1Var.g != null) {
                this.j.b(10, new y(w1Var));
            }
        }
        b.i.a.c.c3.r rVar = w1Var2.j;
        b.i.a.c.c3.r rVar2 = w1Var.j;
        if (rVar != rVar2) {
            this.f.a(rVar2.e);
            this.j.b(2, new q(w1Var, new b.i.a.c.c3.n(w1Var.j.c)));
            this.j.b(2, new t(w1Var));
        }
        if (z5) {
            this.j.b(14, new p(this.D));
        }
        if (w1Var2.h != w1Var.h) {
            this.j.b(3, new o(w1Var));
        }
        if (w1Var2.f != w1Var.f || w1Var2.m != w1Var.m) {
            this.j.b(-1, new e0(w1Var));
        }
        if (w1Var2.f != w1Var.f) {
            this.j.b(4, new m(w1Var));
        }
        if (w1Var2.m != w1Var.m) {
            this.j.b(5, new s(w1Var, i2));
        }
        if (w1Var2.n != w1Var.n) {
            this.j.b(6, new r(w1Var));
        }
        if (k0(w1Var2) != k0(w1Var)) {
            this.j.b(7, new v(w1Var));
        }
        if (!w1Var2.o.equals(w1Var.o)) {
            this.j.b(12, new f0(w1Var));
        }
        if (z2) {
            this.j.b(-1, b.a);
        }
        r0();
        this.j.a();
        if (w1Var2.p != w1Var.p) {
            Iterator<e1$a> it = this.k.iterator();
            while (it.hasNext()) {
                it.next().x(w1Var.p);
            }
        }
        if (w1Var2.q != w1Var.q) {
            Iterator<e1$a> it2 = this.k.iterator();
            while (it2.hasNext()) {
                it2.next().o(w1Var.q);
            }
        }
    }

    @Override // b.i.a.c.y1
    @Nullable
    public PlaybackException t() {
        return this.F.g;
    }

    @Override // b.i.a.c.y1
    public void u(boolean z2) {
        q0(z2, 0, 1);
    }

    @Override // b.i.a.c.y1
    public long v() {
        return this.t;
    }

    @Override // b.i.a.c.y1
    public long w() {
        if (!f()) {
            return T();
        }
        w1 w1Var = this.F;
        w1Var.f1146b.h(w1Var.c.a, this.l);
        w1 w1Var2 = this.F;
        return w1Var2.d == -9223372036854775807L ? w1Var2.f1146b.n(C(), this.a).a() : b.i.a.c.f3.e0.M(this.l.n) + b.i.a.c.f3.e0.M(this.F.d);
    }

    @Override // b.i.a.c.y1
    public void x(y1$e y1_e) {
        d0(y1_e);
    }

    @Override // b.i.a.c.y1
    public int y() {
        return this.F.f;
    }
}
