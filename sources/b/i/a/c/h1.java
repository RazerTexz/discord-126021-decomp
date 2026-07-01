package b.i.a.c;

import android.os.Handler;
import android.os.Handler$Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.core.view.PointerIconCompat;
import b.i.a.c.a3.a0$a;
import b.i.a.c.a3.x$a;
import b.i.a.c.f3.b0$b;
import b.i.b.b.n$b;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmSession$DrmSessionException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.upstream.DataSourceException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: ExoPlayerImplInternal.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h1 implements Handler$Callback, x$a, u1$d, a1$a, b2$a {
    public final h1$e A;
    public final s1 B;
    public final u1 C;
    public final m1 D;
    public final long E;
    public j2 F;
    public w1 G;
    public h1$d H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public int N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public int S;

    @Nullable
    public h1$g T;
    public long U;
    public int V;
    public boolean W;

    @Nullable
    public ExoPlaybackException X;
    public final f2[] j;
    public final Set<f2> k;
    public final g2[] l;
    public final b.i.a.c.c3.q m;
    public final b.i.a.c.c3.r n;
    public final n1 o;
    public final b.i.a.c.e3.f p;
    public final b.i.a.c.f3.o q;
    public final HandlerThread r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Looper f1007s;
    public final o2$c t;
    public final o2$b u;
    public final long v;
    public final boolean w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final a1 f1008x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ArrayList<h1$c> f1009y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final b.i.a.c.f3.g f1010z;

    public h1(f2[] f2VarArr, b.i.a.c.c3.q qVar, b.i.a.c.c3.r rVar, n1 n1Var, b.i.a.c.e3.f fVar, int i, boolean z2, @Nullable b.i.a.c.s2.g1 g1Var, j2 j2Var, m1 m1Var, long j, boolean z3, Looper looper, b.i.a.c.f3.g gVar, h1$e h1_e) {
        this.A = h1_e;
        this.j = f2VarArr;
        this.m = qVar;
        this.n = rVar;
        this.o = n1Var;
        this.p = fVar;
        this.N = i;
        this.O = z2;
        this.F = j2Var;
        this.D = m1Var;
        this.E = j;
        this.J = z3;
        this.f1010z = gVar;
        this.v = n1Var.b();
        this.w = n1Var.a();
        w1 w1VarH = w1.h(rVar);
        this.G = w1VarH;
        this.H = new h1$d(w1VarH);
        this.l = new g2[f2VarArr.length];
        for (int i2 = 0; i2 < f2VarArr.length; i2++) {
            f2VarArr[i2].f(i2);
            this.l[i2] = f2VarArr[i2].m();
        }
        this.f1008x = new a1(this, gVar);
        this.f1009y = new ArrayList<>();
        this.k = b.i.b.b.h.c();
        this.t = new o2$c();
        this.u = new o2$b();
        qVar.a = fVar;
        this.W = true;
        Handler handler = new Handler(looper);
        this.B = new s1(g1Var, handler);
        this.C = new u1(this, g1Var, handler);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.r = handlerThread;
        handlerThread.start();
        Looper looper2 = handlerThread.getLooper();
        this.f1007s = looper2;
        this.q = gVar.b(looper2, this);
    }

    public static boolean K(h1$c h1_c, o2 o2Var, o2 o2Var2, int i, boolean z2, o2$c o2_c, o2$b o2_b) {
        Object obj = h1_c.m;
        if (obj == null) {
            Objects.requireNonNull(h1_c.j);
            Objects.requireNonNull(h1_c.j);
            long jB = b.i.a.c.f3.e0.B(-9223372036854775807L);
            b2 b2Var = h1_c.j;
            Pair<Object, Long> pairM = M(o2Var, new h1$g(b2Var.d, b2Var.h, jB), false, i, z2, o2_c, o2_b);
            if (pairM == null) {
                return false;
            }
            h1_c.f(o2Var.b(pairM.first), ((Long) pairM.second).longValue(), pairM.first);
            Objects.requireNonNull(h1_c.j);
            return true;
        }
        int iB = o2Var.b(obj);
        if (iB == -1) {
            return false;
        }
        Objects.requireNonNull(h1_c.j);
        h1_c.k = iB;
        o2Var2.h(h1_c.m, o2_b);
        if (o2_b.o && o2Var2.n(o2_b.l, o2_c).B == o2Var2.b(h1_c.m)) {
            Pair<Object, Long> pairJ = o2Var.j(o2_c, o2_b, o2Var.h(h1_c.m, o2_b).l, h1_c.l + o2_b.n);
            h1_c.f(o2Var.b(pairJ.first), ((Long) pairJ.second).longValue(), pairJ.first);
        }
        return true;
    }

    @Nullable
    public static Pair<Object, Long> M(o2 o2Var, h1$g h1_g, boolean z2, int i, boolean z3, o2$c o2_c, o2$b o2_b) {
        Object objN;
        o2 o2Var2 = h1_g.a;
        if (o2Var.q()) {
            return null;
        }
        o2 o2Var3 = o2Var2.q() ? o2Var : o2Var2;
        try {
            Pair<Object, Long> pairJ = o2Var3.j(o2_c, o2_b, h1_g.f1014b, h1_g.c);
            if (o2Var.equals(o2Var3)) {
                return pairJ;
            }
            if (o2Var.b(pairJ.first) != -1) {
                return (o2Var3.h(pairJ.first, o2_b).o && o2Var3.n(o2_b.l, o2_c).B == o2Var3.b(pairJ.first)) ? o2Var.j(o2_c, o2_b, o2Var.h(pairJ.first, o2_b).l, h1_g.c) : pairJ;
            }
            if (z2 && (objN = N(o2_c, o2_b, i, z3, pairJ.first, o2Var3, o2Var)) != null) {
                return o2Var.j(o2_c, o2_b, o2Var.h(objN, o2_b).l, -9223372036854775807L);
            }
            return null;
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    @Nullable
    public static Object N(o2$c o2_c, o2$b o2_b, int i, boolean z2, Object obj, o2 o2Var, o2 o2Var2) {
        int iB = o2Var.b(obj);
        int i2 = o2Var.i();
        int iD = iB;
        int iB2 = -1;
        for (int i3 = 0; i3 < i2 && iB2 == -1; i3++) {
            iD = o2Var.d(iD, o2_b, o2_c, i, z2);
            if (iD == -1) {
                break;
            }
            iB2 = o2Var2.b(o2Var.m(iD));
        }
        if (iB2 == -1) {
            return null;
        }
        return o2Var2.m(iB2);
    }

    public static j1[] i(b.i.a.c.c3.j jVar) {
        int length = jVar != null ? jVar.length() : 0;
        j1[] j1VarArr = new j1[length];
        for (int i = 0; i < length; i++) {
            j1VarArr[i] = jVar.d(i);
        }
        return j1VarArr;
    }

    public static boolean w(f2 f2Var) {
        return f2Var.getState() != 0;
    }

    public static boolean y(w1 w1Var, o2$b o2_b) {
        a0$a a0_a = w1Var.c;
        o2 o2Var = w1Var.f1146b;
        return o2Var.q() || o2Var.h(a0_a.a, o2_b).o;
    }

    public final void A() {
        h1$d h1_d = this.H;
        w1 w1Var = this.G;
        boolean z2 = h1_d.a | (h1_d.f1012b != w1Var);
        h1_d.a = z2;
        h1_d.f1012b = w1Var;
        if (z2) {
            f1 f1Var = ((w) this.A).a;
            f1Var.g.b(new c0(f1Var, h1_d));
            this.H = new h1$d(this.G);
        }
    }

    public final void B() throws Throwable {
        r(this.C.c(), true);
    }

    public final void C(h1$b h1_b) throws Throwable {
        this.H.a(1);
        u1 u1Var = this.C;
        Objects.requireNonNull(h1_b);
        Objects.requireNonNull(u1Var);
        b.c.a.a0.d.j(u1Var.e() >= 0);
        u1Var.i = null;
        r(u1Var.c(), false);
    }

    public final void D() {
        this.H.a(1);
        H(false, false, false, true);
        this.o.c();
        f0(this.G.f1146b.q() ? 4 : 2);
        u1 u1Var = this.C;
        b.i.a.c.e3.a0 a0VarC = this.p.c();
        b.c.a.a0.d.D(!u1Var.j);
        u1Var.k = a0VarC;
        for (int i = 0; i < u1Var.a.size(); i++) {
            u1$c u1_c = u1Var.a.get(i);
            u1Var.g(u1_c);
            u1Var.h.add(u1_c);
        }
        u1Var.j = true;
        this.q.f(2);
    }

    public final void E() {
        H(true, false, true, false);
        this.o.e();
        f0(1);
        this.r.quit();
        synchronized (this) {
            this.I = true;
            notifyAll();
        }
    }

    public final void F(int i, int i2, b.i.a.c.a3.k0 k0Var) throws Throwable {
        this.H.a(1);
        u1 u1Var = this.C;
        Objects.requireNonNull(u1Var);
        b.c.a.a0.d.j(i >= 0 && i <= i2 && i2 <= u1Var.e());
        u1Var.i = k0Var;
        u1Var.i(i, i2);
        r(u1Var.c(), false);
    }

    public final void G() throws ExoPlaybackException {
        boolean z2;
        float f = this.f1008x.c().k;
        s1 s1Var = this.B;
        q1 q1Var = s1Var.h;
        q1 q1Var2 = s1Var.i;
        boolean z3 = true;
        for (q1 q1Var3 = q1Var; q1Var3 != null && q1Var3.d; q1Var3 = q1Var3.l) {
            b.i.a.c.c3.r rVarI = q1Var3.i(f, this.G.f1146b);
            b.i.a.c.c3.r rVar = q1Var3.n;
            if (rVar == null || rVar.c.length != rVarI.c.length) {
                z2 = false;
                break;
            }
            int i = 0;
            while (true) {
                if (i >= rVarI.c.length) {
                    z2 = true;
                    break;
                } else {
                    if (!rVarI.a(rVar, i)) {
                        z2 = false;
                        break;
                    }
                    i++;
                }
            }
            if (!z2) {
                if (z3) {
                    s1 s1Var2 = this.B;
                    q1 q1Var4 = s1Var2.h;
                    boolean zN = s1Var2.n(q1Var4);
                    boolean[] zArr = new boolean[this.j.length];
                    long jA = q1Var4.a(rVarI, this.G.t, zN, zArr);
                    w1 w1Var = this.G;
                    boolean z4 = (w1Var.f == 4 || jA == w1Var.t) ? false : true;
                    w1 w1Var2 = this.G;
                    this.G = u(w1Var2.c, jA, w1Var2.d, w1Var2.e, z4, 5);
                    if (z4) {
                        J(jA);
                    }
                    boolean[] zArr2 = new boolean[this.j.length];
                    int i2 = 0;
                    while (true) {
                        f2[] f2VarArr = this.j;
                        if (i2 >= f2VarArr.length) {
                            break;
                        }
                        f2 f2Var = f2VarArr[i2];
                        zArr2[i2] = w(f2Var);
                        b.i.a.c.a3.i0 i0Var = q1Var4.c[i2];
                        if (zArr2[i2]) {
                            if (i0Var != f2Var.h()) {
                                e(f2Var);
                            } else if (zArr[i2]) {
                                f2Var.u(this.U);
                            }
                        }
                        i2++;
                    }
                    h(zArr2);
                } else {
                    this.B.n(q1Var3);
                    if (q1Var3.d) {
                        q1Var3.a(rVarI, Math.max(q1Var3.f.f1058b, this.U - q1Var3.o), false, new boolean[q1Var3.i.length]);
                    }
                }
                q(true);
                if (this.G.f != 4) {
                    z();
                    n0();
                    this.q.f(2);
                    return;
                }
                return;
            }
            if (q1Var3 == q1Var2) {
                z3 = false;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00b4 A[PHI: r4 r5 r7
      0x00b4: PHI (r4v4 b.i.a.c.a3.a0$a) = (r4v3 b.i.a.c.a3.a0$a), (r4v10 b.i.a.c.a3.a0$a) binds: [B:33:0x0087, B:35:0x00ac] A[DONT_GENERATE, DONT_INLINE]
      0x00b4: PHI (r5v2 long) = (r5v1 long), (r5v7 long) binds: [B:33:0x0087, B:35:0x00ac] A[DONT_GENERATE, DONT_INLINE]
      0x00b4: PHI (r7v3 long) = (r7v2 long), (r7v6 long) binds: [B:33:0x0087, B:35:0x00ac] A[DONT_GENERATE, DONT_INLINE]] */
    public final void H(boolean z2, boolean z3, boolean z4, boolean z5) {
        a0$a a0_a;
        long j;
        boolean z6;
        List list;
        this.q.h(2);
        this.X = null;
        this.L = false;
        a1 a1Var = this.f1008x;
        a1Var.o = false;
        b.i.a.c.f3.z zVar = a1Var.j;
        if (zVar.k) {
            zVar.a(zVar.e());
            zVar.k = false;
        }
        this.U = 1000000000000L;
        for (f2 f2Var : this.j) {
            try {
                e(f2Var);
            } catch (ExoPlaybackException | RuntimeException e) {
                b.i.a.c.f3.q.b("ExoPlayerImplInternal", "Disable failed.", e);
            }
        }
        if (z2) {
            for (f2 f2Var2 : this.j) {
                if (this.k.remove(f2Var2)) {
                    try {
                        f2Var2.reset();
                    } catch (RuntimeException e2) {
                        b.i.a.c.f3.q.b("ExoPlayerImplInternal", "Reset failed.", e2);
                    }
                }
            }
        }
        this.S = 0;
        w1 w1Var = this.G;
        a0$a a0_a2 = w1Var.c;
        long jLongValue = w1Var.t;
        long j2 = (this.G.c.a() || y(this.G, this.u)) ? this.G.d : this.G.t;
        if (z3) {
            this.T = null;
            Pair<a0$a, Long> pairL = l(this.G.f1146b);
            a0_a2 = (a0$a) pairL.first;
            jLongValue = ((Long) pairL.second).longValue();
            j2 = -9223372036854775807L;
            if (a0_a2.equals(this.G.c)) {
                a0_a = a0_a2;
                j = jLongValue;
                z6 = false;
            } else {
                z6 = true;
                a0_a = a0_a2;
                j = jLongValue;
            }
        } else {
            a0_a = a0_a2;
            j = jLongValue;
            z6 = false;
        }
        this.B.b();
        this.M = false;
        w1 w1Var2 = this.G;
        o2 o2Var = w1Var2.f1146b;
        int i = w1Var2.f;
        ExoPlaybackException exoPlaybackException = z5 ? null : w1Var2.g;
        b.i.a.c.a3.o0 o0Var = z6 ? b.i.a.c.a3.o0.j : w1Var2.i;
        b.i.a.c.c3.r rVar = z6 ? this.n : w1Var2.j;
        if (z6) {
            b.i.b.b.a<Object> aVar = b.i.b.b.p.k;
            list = b.i.b.b.h0.l;
        } else {
            list = w1Var2.k;
        }
        this.G = new w1(o2Var, a0_a, j2, j, i, exoPlaybackException, false, o0Var, rVar, list, a0_a, w1Var2.m, w1Var2.n, w1Var2.o, j, 0L, j, this.R, false);
        if (z4) {
            u1 u1Var = this.C;
            for (u1$b u1_b : u1Var.g.values()) {
                try {
                    u1_b.a.a(u1_b.f1138b);
                } catch (RuntimeException e3) {
                    b.i.a.c.f3.q.b("MediaSourceList", "Failed to release child source.", e3);
                }
                u1_b.a.c(u1_b.c);
                u1_b.a.g(u1_b.c);
            }
            u1Var.g.clear();
            u1Var.h.clear();
            u1Var.j = false;
        }
    }

    public final void I() {
        q1 q1Var = this.B.h;
        this.K = q1Var != null && q1Var.f.h && this.J;
    }

    public final void J(long j) throws ExoPlaybackException {
        q1 q1Var = this.B.h;
        long j2 = j + (q1Var == null ? 1000000000000L : q1Var.o);
        this.U = j2;
        this.f1008x.j.a(j2);
        for (f2 f2Var : this.j) {
            if (w(f2Var)) {
                f2Var.u(this.U);
            }
        }
        for (q1 q1Var2 = this.B.h; q1Var2 != null; q1Var2 = q1Var2.l) {
            for (b.i.a.c.c3.j jVar : q1Var2.n.c) {
                if (jVar != null) {
                    jVar.j();
                }
            }
        }
    }

    public final void L(o2 o2Var, o2 o2Var2) {
        if (o2Var.q() && o2Var2.q()) {
            return;
        }
        int size = this.f1009y.size();
        while (true) {
            size--;
            if (size < 0) {
                Collections.sort(this.f1009y);
                return;
            } else if (!K(this.f1009y.get(size), o2Var, o2Var2, this.N, this.O, this.t, this.u)) {
                this.f1009y.get(size).j.c(false);
                this.f1009y.remove(size);
            }
        }
    }

    public final void O(long j, long j2) {
        this.q.h(2);
        this.q.g(2, j + j2);
    }

    public final void P(boolean z2) throws ExoPlaybackException {
        a0$a a0_a = this.B.h.f.a;
        long jS = S(a0_a, this.G.t, true, false);
        if (jS != this.G.t) {
            w1 w1Var = this.G;
            this.G = u(a0_a, jS, w1Var.d, w1Var.e, z2, 5);
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00ab A[Catch: all -> 0x0145, TryCatch #1 {all -> 0x0145, blocks: (B:22:0x00a1, B:24:0x00ab, B:27:0x00b1, B:29:0x00b7, B:30:0x00ba, B:32:0x00c0, B:34:0x00ca, B:36:0x00d0, B:40:0x00d8, B:42:0x00e2, B:44:0x00f2, B:48:0x00fc, B:52:0x010e, B:56:0x0117), top: B:74:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:27:0x00b1 A[Catch: all -> 0x0145, TryCatch #1 {all -> 0x0145, blocks: (B:22:0x00a1, B:24:0x00ab, B:27:0x00b1, B:29:0x00b7, B:30:0x00ba, B:32:0x00c0, B:34:0x00ca, B:36:0x00d0, B:40:0x00d8, B:42:0x00e2, B:44:0x00f2, B:48:0x00fc, B:52:0x010e, B:56:0x0117), top: B:74:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x00b7 A[Catch: all -> 0x0145, TryCatch #1 {all -> 0x0145, blocks: (B:22:0x00a1, B:24:0x00ab, B:27:0x00b1, B:29:0x00b7, B:30:0x00ba, B:32:0x00c0, B:34:0x00ca, B:36:0x00d0, B:40:0x00d8, B:42:0x00e2, B:44:0x00f2, B:48:0x00fc, B:52:0x010e, B:56:0x0117), top: B:74:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00c0 A[Catch: all -> 0x0145, TryCatch #1 {all -> 0x0145, blocks: (B:22:0x00a1, B:24:0x00ab, B:27:0x00b1, B:29:0x00b7, B:30:0x00ba, B:32:0x00c0, B:34:0x00ca, B:36:0x00d0, B:40:0x00d8, B:42:0x00e2, B:44:0x00f2, B:48:0x00fc, B:52:0x010e, B:56:0x0117), top: B:74:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00ca A[Catch: all -> 0x0145, TryCatch #1 {all -> 0x0145, blocks: (B:22:0x00a1, B:24:0x00ab, B:27:0x00b1, B:29:0x00b7, B:30:0x00ba, B:32:0x00c0, B:34:0x00ca, B:36:0x00d0, B:40:0x00d8, B:42:0x00e2, B:44:0x00f2, B:48:0x00fc, B:52:0x010e, B:56:0x0117), top: B:74:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:51:0x010d  */
    /* JADX WARN: Code duplicated, block: B:54:0x0114  */
    /* JADX WARN: Code duplicated, block: B:55:0x0116  */
    /* JADX WARN: Code duplicated, block: B:60:0x0120  */
    public final void Q(h1$g h1_g) throws Throwable {
        long jLongValue;
        long j;
        boolean z2;
        a0$a a0_a;
        long j2;
        long j3;
        long j4;
        long jI;
        boolean z3;
        long jR;
        boolean z4;
        long j5;
        q1 q1Var;
        w1 w1Var;
        int i;
        this.H.a(1);
        Pair<Object, Long> pairM = M(this.G.f1146b, h1_g, true, this.N, this.O, this.t, this.u);
        try {
            if (pairM != null) {
                Object obj = pairM.first;
                jLongValue = ((Long) pairM.second).longValue();
                long j6 = h1_g.c == -9223372036854775807L ? -9223372036854775807L : jLongValue;
                a0$a a0_aO = this.B.o(this.G.f1146b, obj, jLongValue);
                if (a0_aO.a()) {
                    this.G.f1146b.h(a0_aO.a, this.u);
                    j2 = this.u.d(a0_aO.f835b) == a0_aO.c ? this.u.p.o : 0L;
                    j3 = j6;
                    z2 = true;
                    a0_a = a0_aO;
                } else {
                    j = j6;
                    z2 = h1_g.c == -9223372036854775807L;
                    a0_a = a0_aO;
                }
                if (this.G.f1146b.q()) {
                    if (pairM == null) {
                        if (this.G.f != 1) {
                            f0(4);
                        }
                        H(false, true, false, true);
                    } else {
                        if (a0_a.equals(this.G.c)) {
                            q1Var = this.B.h;
                            if (q1Var == null && q1Var.d && j2 != 0) {
                                jI = q1Var.a.i(j2, this.F);
                            } else {
                                jI = j2;
                            }
                            if (b.i.a.c.f3.e0.M(jI) == b.i.a.c.f3.e0.M(this.G.t) && ((i = (w1Var = this.G).f) == 2 || i == 3)) {
                                long j7 = w1Var.t;
                                this.G = u(a0_a, j7, j3, j7, z2, 2);
                                return;
                            }
                        } else {
                            jI = j2;
                        }
                        if (this.G.f == 4) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        jR = R(a0_a, jI, z3);
                        z4 = (j2 != jR) | z2;
                        try {
                            w1 w1Var2 = this.G;
                            o2 o2Var = w1Var2.f1146b;
                            m0(o2Var, a0_a, o2Var, w1Var2.c, j3);
                            z2 = z4;
                            j5 = jR;
                        } catch (Throwable th) {
                            th = th;
                            z2 = z4;
                            j4 = jR;
                            this.G = u(a0_a, j4, j3, j4, z2, 2);
                            throw th;
                        }
                    }
                    this.G = u(a0_a, j5, j3, j5, z2, 2);
                    return;
                }
                this.T = h1_g;
                j5 = j2;
                this.G = u(a0_a, j5, j3, j5, z2, 2);
                return;
            }
            Pair<a0$a, Long> pairL = l(this.G.f1146b);
            a0_a = (a0$a) pairL.first;
            jLongValue = ((Long) pairL.second).longValue();
            z2 = !this.G.f1146b.q();
            j = -9223372036854775807L;
            if (this.G.f1146b.q()) {
                if (pairM == null) {
                    if (this.G.f != 1) {
                        f0(4);
                    }
                    H(false, true, false, true);
                } else {
                    if (a0_a.equals(this.G.c)) {
                        q1Var = this.B.h;
                        if (q1Var == null) {
                            jI = j2;
                        } else {
                            jI = j2;
                        }
                        if (b.i.a.c.f3.e0.M(jI) == b.i.a.c.f3.e0.M(this.G.t)) {
                            long j8 = w1Var.t;
                            this.G = u(a0_a, j8, j3, j8, z2, 2);
                            return;
                        }
                    } else {
                        jI = j2;
                    }
                    if (this.G.f == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    jR = R(a0_a, jI, z3);
                    z4 = (j2 != jR) | z2;
                    w1 w1Var3 = this.G;
                    o2 o2Var2 = w1Var3.f1146b;
                    m0(o2Var2, a0_a, o2Var2, w1Var3.c, j3);
                    z2 = z4;
                    j5 = jR;
                }
                this.G = u(a0_a, j5, j3, j5, z2, 2);
                return;
            }
            this.T = h1_g;
            j5 = j2;
            this.G = u(a0_a, j5, j3, j5, z2, 2);
            return;
        } catch (Throwable th2) {
            th = th2;
            j4 = j2;
        }
        j2 = jLongValue;
        j3 = j;
    }

    public final long R(a0$a a0_a, long j, boolean z2) throws ExoPlaybackException {
        s1 s1Var = this.B;
        return S(a0_a, j, s1Var.h != s1Var.i, z2);
    }

    public final long S(a0$a a0_a, long j, boolean z2, boolean z3) throws ExoPlaybackException {
        s1 s1Var;
        k0();
        this.L = false;
        if (z3 || this.G.f == 3) {
            f0(2);
        }
        q1 q1Var = this.B.h;
        q1 q1Var2 = q1Var;
        while (q1Var2 != null && !a0_a.equals(q1Var2.f.a)) {
            q1Var2 = q1Var2.l;
        }
        if (z2 || q1Var != q1Var2 || (q1Var2 != null && q1Var2.o + j < 0)) {
            for (f2 f2Var : this.j) {
                e(f2Var);
            }
            if (q1Var2 != null) {
                while (true) {
                    s1Var = this.B;
                    if (s1Var.h == q1Var2) {
                        break;
                    }
                    s1Var.a();
                }
                s1Var.n(q1Var2);
                q1Var2.o = 1000000000000L;
                g();
            }
        }
        if (q1Var2 != null) {
            this.B.n(q1Var2);
            if (!q1Var2.d) {
                q1Var2.f = q1Var2.f.b(j);
            } else if (q1Var2.e) {
                long jF = q1Var2.a.f(j);
                q1Var2.a.r(jF - this.v, this.w);
                j = jF;
            }
            J(j);
            z();
        } else {
            this.B.b();
            J(j);
        }
        q(false);
        this.q.f(2);
        return j;
    }

    public final void T(b2 b2Var) throws ExoPlaybackException {
        if (b2Var.g != this.f1007s) {
            ((b0$b) this.q.i(15, b2Var)).b();
            return;
        }
        d(b2Var);
        int i = this.G.f;
        if (i == 3 || i == 2) {
            this.q.f(2);
        }
    }

    public final void U(b2 b2Var) {
        Looper looper = b2Var.g;
        if (looper.getThread().isAlive()) {
            this.f1010z.b(looper, null).b(new g0(this, b2Var));
        } else {
            Log.w("TAG", "Trying to send message on a dead thread.");
            b2Var.c(false);
        }
    }

    public final void V(f2 f2Var, long j) {
        f2Var.l();
        if (f2Var instanceof b.i.a.c.b3.m) {
            b.i.a.c.b3.m mVar = (b.i.a.c.b3.m) f2Var;
            b.c.a.a0.d.D(mVar.f1140s);
            mVar.I = j;
        }
    }

    public final void W(boolean z2, @Nullable AtomicBoolean atomicBoolean) {
        if (this.P != z2) {
            this.P = z2;
            if (!z2) {
                for (f2 f2Var : this.j) {
                    if (!w(f2Var) && this.k.remove(f2Var)) {
                        f2Var.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    public final void X(h1$a h1_a) throws Throwable {
        this.H.a(1);
        if (h1_a.c != -1) {
            this.T = new h1$g(new c2(h1_a.a, h1_a.f1011b), h1_a.c, h1_a.d);
        }
        u1 u1Var = this.C;
        List<u1$c> list = h1_a.a;
        b.i.a.c.a3.k0 k0Var = h1_a.f1011b;
        u1Var.i(0, u1Var.a.size());
        r(u1Var.a(u1Var.a.size(), list, k0Var), false);
    }

    public final void Y(boolean z2) {
        if (z2 == this.R) {
            return;
        }
        this.R = z2;
        w1 w1Var = this.G;
        int i = w1Var.f;
        if (z2 || i == 4 || i == 1) {
            this.G = w1Var.c(z2);
        } else {
            this.q.f(2);
        }
    }

    public final void Z(boolean z2) throws ExoPlaybackException {
        this.J = z2;
        I();
        if (this.K) {
            s1 s1Var = this.B;
            if (s1Var.i != s1Var.h) {
                P(true);
                q(false);
            }
        }
    }

    @Override // b.i.a.c.a3.j0$a
    public void a(b.i.a.c.a3.j0 j0Var) {
        ((b0$b) this.q.i(9, (b.i.a.c.a3.x) j0Var)).b();
    }

    public final void a0(boolean z2, int i, boolean z3, int i2) throws ExoPlaybackException {
        this.H.a(z3 ? 1 : 0);
        h1$d h1_d = this.H;
        h1_d.a = true;
        h1_d.f = true;
        h1_d.g = i2;
        this.G = this.G.d(z2, i);
        this.L = false;
        for (q1 q1Var = this.B.h; q1Var != null; q1Var = q1Var.l) {
            for (b.i.a.c.c3.j jVar : q1Var.n.c) {
                if (jVar != null) {
                    jVar.c(z2);
                }
            }
        }
        if (!g0()) {
            k0();
            n0();
            return;
        }
        int i3 = this.G.f;
        if (i3 == 3) {
            i0();
            this.q.f(2);
        } else if (i3 == 2) {
            this.q.f(2);
        }
    }

    @Override // b.i.a.c.a3.x$a
    public void b(b.i.a.c.a3.x xVar) {
        ((b0$b) this.q.i(8, xVar)).b();
    }

    public final void b0(x1 x1Var) throws ExoPlaybackException {
        this.f1008x.i(x1Var);
        x1 x1VarC = this.f1008x.c();
        t(x1VarC, x1VarC.k, true, true);
    }

    public final void c(h1$a h1_a, int i) throws Throwable {
        this.H.a(1);
        u1 u1Var = this.C;
        if (i == -1) {
            i = u1Var.e();
        }
        r(u1Var.a(i, h1_a.a, h1_a.f1011b), false);
    }

    public final void c0(int i) throws ExoPlaybackException {
        this.N = i;
        s1 s1Var = this.B;
        o2 o2Var = this.G.f1146b;
        s1Var.f = i;
        if (!s1Var.q(o2Var)) {
            P(true);
        }
        q(false);
    }

    public final void d(b2 b2Var) throws ExoPlaybackException {
        b2Var.b();
        try {
            b2Var.a.r(b2Var.e, b2Var.f);
        } finally {
            b2Var.c(true);
        }
    }

    public final void d0(boolean z2) throws ExoPlaybackException {
        this.O = z2;
        s1 s1Var = this.B;
        o2 o2Var = this.G.f1146b;
        s1Var.g = z2;
        if (!s1Var.q(o2Var)) {
            P(true);
        }
        q(false);
    }

    public final void e(f2 f2Var) throws ExoPlaybackException {
        if (f2Var.getState() != 0) {
            a1 a1Var = this.f1008x;
            if (f2Var == a1Var.l) {
                a1Var.m = null;
                a1Var.l = null;
                a1Var.n = true;
            }
            if (f2Var.getState() == 2) {
                f2Var.stop();
            }
            f2Var.g();
            this.S--;
        }
    }

    public final void e0(b.i.a.c.a3.k0 k0Var) throws Throwable {
        this.H.a(1);
        u1 u1Var = this.C;
        int iE = u1Var.e();
        if (k0Var.b() != iE) {
            k0Var = k0Var.h().f(0, iE);
        }
        u1Var.i = k0Var;
        r(u1Var.c(), false);
    }

    /* JADX WARN: Code duplicated, block: B:297:0x0476  */
    /* JADX WARN: Code duplicated, block: B:303:0x048b  */
    /* JADX WARN: Code duplicated, block: B:313:0x04ab  */
    /* JADX WARN: Code duplicated, block: B:315:0x04b1  */
    /* JADX WARN: Code duplicated, block: B:317:0x04b9  */
    /* JADX WARN: Code duplicated, block: B:319:0x04bd  */
    /* JADX WARN: Code duplicated, block: B:325:0x04d6  */
    /* JADX WARN: Code duplicated, block: B:419:0x04c0 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:315:0x04b1, please report this as an issue */
    public final void f() throws ExoPlaybackException, IOException {
        boolean z2;
        boolean z3;
        boolean z4;
        q1 q1Var;
        y0 y0Var;
        long j;
        long j2;
        int i;
        boolean zX;
        int i2;
        boolean z5;
        boolean z6;
        q1 q1Var2;
        q1 q1Var3;
        boolean z7;
        long jA = this.f1010z.a();
        if (!this.G.f1146b.q() && this.C.j) {
            this.B.m(this.U);
            s1 s1Var = this.B;
            q1 q1Var4 = s1Var.j;
            if (q1Var4 == null || (!q1Var4.f.i && q1Var4.f() && s1Var.j.f.e != -9223372036854775807L && s1Var.k < 100)) {
                s1 s1Var2 = this.B;
                long j3 = this.U;
                w1 w1Var = this.G;
                q1 q1Var5 = s1Var2.j;
                r1 r1VarD = q1Var5 == null ? s1Var2.d(w1Var.f1146b, w1Var.c, w1Var.d, w1Var.t) : s1Var2.c(w1Var.f1146b, q1Var5, j3);
                if (r1VarD != null) {
                    s1 s1Var3 = this.B;
                    g2[] g2VarArr = this.l;
                    b.i.a.c.c3.q qVar = this.m;
                    b.i.a.c.e3.o oVarH = this.o.h();
                    u1 u1Var = this.C;
                    b.i.a.c.c3.r rVar = this.n;
                    q1 q1Var6 = s1Var3.j;
                    q1 q1Var7 = new q1(g2VarArr, q1Var6 == null ? 1000000000000L : (q1Var6.o + q1Var6.f.e) - r1VarD.f1058b, qVar, oVarH, u1Var, r1VarD, rVar);
                    q1 q1Var8 = s1Var3.j;
                    if (q1Var8 == null) {
                        s1Var3.h = q1Var7;
                        s1Var3.i = q1Var7;
                    } else if (q1Var7 != q1Var8.l) {
                        q1Var8.b();
                        q1Var8.l = q1Var7;
                        q1Var8.c();
                    }
                    s1Var3.l = null;
                    s1Var3.j = q1Var7;
                    s1Var3.k++;
                    s1Var3.l();
                    q1Var7.a.l(this, r1VarD.f1058b);
                    if (this.B.h == q1Var7) {
                        J(r1VarD.f1058b);
                    }
                    q(false);
                }
            }
            if (this.M) {
                this.M = v();
                l0();
            } else {
                z();
            }
            q1 q1Var9 = this.B.i;
            if (q1Var9 != null) {
                if (q1Var9.l != null && !this.K) {
                    if (!q1Var9.d) {
                        z7 = false;
                        break;
                    }
                    int i3 = 0;
                    while (true) {
                        f2[] f2VarArr = this.j;
                        if (i3 >= f2VarArr.length) {
                            z7 = true;
                            break;
                        }
                        f2 f2Var = f2VarArr[i3];
                        b.i.a.c.a3.i0 i0Var = q1Var9.c[i3];
                        if (f2Var.h() == i0Var) {
                            if (i0Var != null && !f2Var.j()) {
                                q1 q1Var10 = q1Var9.l;
                                if (!(q1Var9.f.f && q1Var10.d && ((f2Var instanceof b.i.a.c.b3.m) || f2Var.t() >= q1Var10.e()))) {
                                }
                            }
                            i3++;
                        }
                        z7 = false;
                        break;
                    }
                    if (z7) {
                        q1 q1Var11 = q1Var9.l;
                        if (q1Var11.d || this.U >= q1Var11.e()) {
                            b.i.a.c.c3.r rVar2 = q1Var9.n;
                            s1 s1Var4 = this.B;
                            q1 q1Var12 = s1Var4.i;
                            b.c.a.a0.d.D((q1Var12 == null || q1Var12.l == null) ? false : true);
                            s1Var4.i = s1Var4.i.l;
                            s1Var4.l();
                            q1 q1Var13 = s1Var4.i;
                            b.i.a.c.c3.r rVar3 = q1Var13.n;
                            if (!q1Var13.d || q1Var13.a.k() == -9223372036854775807L) {
                                for (int i4 = 0; i4 < this.j.length; i4++) {
                                    boolean zB = rVar2.b(i4);
                                    boolean zB2 = rVar3.b(i4);
                                    if (zB && !this.j[i4].v()) {
                                        boolean z8 = ((v0) this.l[i4]).j == -2;
                                        h2 h2Var = rVar2.f912b[i4];
                                        h2 h2Var2 = rVar3.f912b[i4];
                                        if (!zB2 || !h2Var2.equals(h2Var) || z8) {
                                            V(this.j[i4], q1Var13.e());
                                        }
                                    }
                                }
                            } else {
                                long jE = q1Var13.e();
                                for (f2 f2Var2 : this.j) {
                                    if (f2Var2.h() != null) {
                                        V(f2Var2, jE);
                                    }
                                }
                            }
                        }
                    }
                } else if (q1Var9.f.i || this.K) {
                    int i5 = 0;
                    while (true) {
                        f2[] f2VarArr2 = this.j;
                        if (i5 >= f2VarArr2.length) {
                            break;
                        }
                        f2 f2Var3 = f2VarArr2[i5];
                        b.i.a.c.a3.i0 i0Var2 = q1Var9.c[i5];
                        if (i0Var2 != null && f2Var3.h() == i0Var2 && f2Var3.j()) {
                            long j4 = q1Var9.f.e;
                            V(f2Var3, (j4 == -9223372036854775807L || j4 == Long.MIN_VALUE) ? -9223372036854775807L : j4 + q1Var9.o);
                        }
                        i5++;
                    }
                }
            }
            s1 s1Var5 = this.B;
            q1 q1Var14 = s1Var5.i;
            if (q1Var14 != null && s1Var5.h != q1Var14 && !q1Var14.g) {
                b.i.a.c.c3.r rVar4 = q1Var14.n;
                int i6 = 0;
                boolean z9 = false;
                while (true) {
                    f2[] f2VarArr3 = this.j;
                    if (i6 >= f2VarArr3.length) {
                        break;
                    }
                    f2 f2Var4 = f2VarArr3[i6];
                    if (w(f2Var4)) {
                        boolean z10 = f2Var4.h() != q1Var14.c[i6];
                        if (!rVar4.b(i6) || z10) {
                            if (!f2Var4.v()) {
                                f2Var4.k(i(rVar4.c[i6]), q1Var14.c[i6], q1Var14.e(), q1Var14.o);
                            } else if (f2Var4.b()) {
                                e(f2Var4);
                            } else {
                                z9 = true;
                            }
                        }
                    }
                    i6++;
                }
                if (!z9) {
                    g();
                }
            }
            boolean z11 = false;
            while (true) {
                if (!(g0() && !this.K && (q1Var2 = this.B.h) != null && (q1Var3 = q1Var2.l) != null && this.U >= q1Var3.e() && q1Var3.g)) {
                    break;
                }
                if (z11) {
                    A();
                }
                s1 s1Var6 = this.B;
                q1 q1Var15 = s1Var6.h;
                q1 q1VarA = s1Var6.a();
                r1 r1Var = q1VarA.f;
                a0$a a0_a = r1Var.a;
                long j5 = r1Var.f1058b;
                w1 w1VarU = u(a0_a, j5, r1Var.c, j5, true, 0);
                this.G = w1VarU;
                o2 o2Var = w1VarU.f1146b;
                m0(o2Var, q1VarA.f.a, o2Var, q1Var15.f.a, -9223372036854775807L);
                I();
                n0();
                z11 = true;
            }
        }
        int i7 = this.G.f;
        if (i7 == 1 || i7 == 4) {
            this.q.h(2);
            return;
        }
        q1 q1Var16 = this.B.h;
        if (q1Var16 == null) {
            O(jA, 10L);
            return;
        }
        b.c.a.a0.d.f("doSomeWork");
        n0();
        if (q1Var16.d) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            q1Var16.a.r(this.G.t - this.v, this.w);
            boolean z12 = true;
            z2 = true;
            int i8 = 0;
            while (true) {
                f2[] f2VarArr4 = this.j;
                if (i8 >= f2VarArr4.length) {
                    break;
                }
                f2 f2Var5 = f2VarArr4[i8];
                if (w(f2Var5)) {
                    f2Var5.q(this.U, jElapsedRealtime);
                    boolean z13 = z12 && f2Var5.b();
                    boolean z14 = q1Var16.c[i8] != f2Var5.h();
                    boolean z15 = z14 || (!z14 && f2Var5.j()) || f2Var5.d() || f2Var5.b();
                    boolean z16 = z2 && z15;
                    if (!z15) {
                        f2Var5.s();
                    }
                    z2 = z16;
                    z12 = z13;
                }
                i8++;
            }
            z3 = z12;
        } else {
            q1Var16.a.e();
            z2 = true;
            z3 = true;
        }
        long j6 = q1Var16.f.e;
        boolean z17 = z3 && q1Var16.d && (j6 == -9223372036854775807L || j6 <= this.G.t);
        if (z17 && this.K) {
            z4 = false;
            this.K = false;
            a0(false, this.G.n, false, 5);
        } else {
            z4 = false;
        }
        if (z17 && q1Var16.f.i) {
            f0(4);
            k0();
        } else {
            w1 w1Var2 = this.G;
            if (w1Var2.f == 2) {
                if (this.S == 0) {
                    zX = x();
                } else if (z2) {
                    if (w1Var2.h) {
                        long j7 = h0(w1Var2.f1146b, this.B.h.f.a) ? ((y0) this.D).i : -9223372036854775807L;
                        q1 q1Var17 = this.B.j;
                        boolean z18 = q1Var17.f() && q1Var17.f.i;
                        boolean z19 = q1Var17.f.a.a() && !q1Var17.d;
                        if (!z18 && !z19 && !this.o.f(m(), this.f1008x.c().k, this.L, j7)) {
                            zX = false;
                        }
                    }
                    zX = true;
                } else {
                    zX = false;
                }
                if (zX) {
                    f0(3);
                    this.X = null;
                    if (g0()) {
                        i0();
                    }
                } else if (this.G.f == 3) {
                    this.L = g0();
                    f0(2);
                    if (this.L) {
                        for (q1Var = this.B.h; q1Var != null; q1Var = q1Var.l) {
                            for (b.i.a.c.c3.j jVar : q1Var.n.c) {
                                if (jVar != null) {
                                    jVar.k();
                                }
                            }
                        }
                        y0Var = (y0) this.D;
                        j = y0Var.i;
                        if (j != -9223372036854775807L) {
                            long j8 = j + y0Var.f1302b;
                            y0Var.i = j8;
                            j2 = y0Var.h;
                            if (j2 != -9223372036854775807L) {
                                y0Var.i = j2;
                            }
                            y0Var.m = -9223372036854775807L;
                        }
                    }
                    k0();
                }
            } else if (this.G.f == 3 && (this.S != 0 ? !z2 : !x())) {
                this.L = g0();
                f0(2);
                if (this.L) {
                    while (q1Var != null) {
                        while (i < r7) {
                            if (jVar != null) {
                                jVar.k();
                            }
                        }
                    }
                    y0Var = (y0) this.D;
                    j = y0Var.i;
                    if (j != -9223372036854775807L) {
                        long j9 = j + y0Var.f1302b;
                        y0Var.i = j9;
                        j2 = y0Var.h;
                        if (j2 != -9223372036854775807L && j9 > j2) {
                            y0Var.i = j2;
                        }
                        y0Var.m = -9223372036854775807L;
                    }
                }
                k0();
            }
        }
        if (this.G.f == 2) {
            int i9 = 0;
            while (true) {
                f2[] f2VarArr5 = this.j;
                if (i9 >= f2VarArr5.length) {
                    break;
                }
                if (w(f2VarArr5[i9]) && this.j[i9].h() == q1Var16.c[i9]) {
                    this.j[i9].s();
                }
                i9++;
            }
            w1 w1Var3 = this.G;
            if (!w1Var3.h && w1Var3.f1147s < 500000 && v()) {
                throw new IllegalStateException("Playback stuck buffering and not loading");
            }
        }
        boolean z20 = this.R;
        w1 w1Var4 = this.G;
        if (z20 != w1Var4.p) {
            this.G = w1Var4.c(z20);
        }
        if ((g0() && this.G.f == 3) || (i2 = this.G.f) == 2) {
            if (this.R && this.Q) {
                z6 = false;
            } else {
                this.q.h(2);
                this.q.g(2, jA + 10);
                z6 = true;
            }
            z5 = !z6;
        } else {
            if (this.S == 0 || i2 == 4) {
                this.q.h(2);
            } else {
                O(jA, 1000L);
            }
            z5 = false;
        }
        w1 w1Var5 = this.G;
        if (w1Var5.q != z5) {
            this.G = new w1(w1Var5.f1146b, w1Var5.c, w1Var5.d, w1Var5.e, w1Var5.f, w1Var5.g, w1Var5.h, w1Var5.i, w1Var5.j, w1Var5.k, w1Var5.l, w1Var5.m, w1Var5.n, w1Var5.o, w1Var5.r, w1Var5.f1147s, w1Var5.t, w1Var5.p, z5);
        }
        this.Q = z4;
        b.c.a.a0.d.d0();
    }

    public final void f0(int i) {
        w1 w1Var = this.G;
        if (w1Var.f != i) {
            this.G = w1Var.f(i);
        }
    }

    public final void g() throws ExoPlaybackException {
        h(new boolean[this.j.length]);
    }

    public final boolean g0() {
        w1 w1Var = this.G;
        return w1Var.m && w1Var.n == 0;
    }

    public final void h(boolean[] zArr) throws ExoPlaybackException {
        b.i.a.c.f3.s sVar;
        q1 q1Var = this.B.i;
        b.i.a.c.c3.r rVar = q1Var.n;
        for (int i = 0; i < this.j.length; i++) {
            if (!rVar.b(i) && this.k.remove(this.j[i])) {
                this.j[i].reset();
            }
        }
        for (int i2 = 0; i2 < this.j.length; i2++) {
            if (rVar.b(i2)) {
                boolean z2 = zArr[i2];
                f2 f2Var = this.j[i2];
                if (w(f2Var)) {
                    continue;
                } else {
                    s1 s1Var = this.B;
                    q1 q1Var2 = s1Var.i;
                    boolean z3 = q1Var2 == s1Var.h;
                    b.i.a.c.c3.r rVar2 = q1Var2.n;
                    h2 h2Var = rVar2.f912b[i2];
                    j1[] j1VarArrI = i(rVar2.c[i2]);
                    boolean z4 = g0() && this.G.f == 3;
                    boolean z5 = !z2 && z4;
                    this.S++;
                    this.k.add(f2Var);
                    f2Var.o(h2Var, j1VarArrI, q1Var2.c[i2], this.U, z5, z3, q1Var2.e(), q1Var2.o);
                    f2Var.r(11, new g1(this));
                    a1 a1Var = this.f1008x;
                    Objects.requireNonNull(a1Var);
                    b.i.a.c.f3.s sVarW = f2Var.w();
                    if (sVarW != null && sVarW != (sVar = a1Var.m)) {
                        if (sVar != null) {
                            throw ExoPlaybackException.b(new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
                        }
                        a1Var.m = sVarW;
                        a1Var.l = f2Var;
                        sVarW.i(a1Var.j.n);
                    }
                    if (z4) {
                        f2Var.start();
                    }
                }
            }
        }
        q1Var.g = true;
    }

    public final boolean h0(o2 o2Var, a0$a a0_a) {
        if (a0_a.a() || o2Var.q()) {
            return false;
        }
        o2Var.n(o2Var.h(a0_a.a, this.u).l, this.t);
        if (!this.t.c()) {
            return false;
        }
        o2$c o2_c = this.t;
        return o2_c.v && o2_c.f1042s != -9223372036854775807L;
    }

    @Override // android.os.Handler$Callback
    public boolean handleMessage(Message message) throws Throwable {
        q1 q1Var;
        int i = 1000;
        try {
            switch (message.what) {
                case 0:
                    D();
                    break;
                case 1:
                    a0(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    f();
                    break;
                case 3:
                    Q((h1$g) message.obj);
                    break;
                case 4:
                    b0((x1) message.obj);
                    break;
                case 5:
                    this.F = (j2) message.obj;
                    break;
                case 6:
                    j0(false, true);
                    break;
                case 7:
                    E();
                    return true;
                case 8:
                    s((b.i.a.c.a3.x) message.obj);
                    break;
                case 9:
                    o((b.i.a.c.a3.x) message.obj);
                    break;
                case 10:
                    G();
                    break;
                case 11:
                    c0(message.arg1);
                    break;
                case 12:
                    d0(message.arg1 != 0);
                    break;
                case 13:
                    W(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    b2 b2Var = (b2) message.obj;
                    Objects.requireNonNull(b2Var);
                    T(b2Var);
                    break;
                case 15:
                    U((b2) message.obj);
                    break;
                case 16:
                    x1 x1Var = (x1) message.obj;
                    t(x1Var, x1Var.k, true, false);
                    break;
                case 17:
                    X((h1$a) message.obj);
                    break;
                case 18:
                    c((h1$a) message.obj, message.arg1);
                    break;
                case 19:
                    C((h1$b) message.obj);
                    break;
                case 20:
                    F(message.arg1, message.arg2, (b.i.a.c.a3.k0) message.obj);
                    break;
                case 21:
                    e0((b.i.a.c.a3.k0) message.obj);
                    break;
                case 22:
                    B();
                    break;
                case 23:
                    Z(message.arg1 != 0);
                    break;
                case 24:
                    Y(message.arg1 == 1);
                    break;
                case 25:
                    P(true);
                    break;
                default:
                    return false;
            }
        } catch (ExoPlaybackException e) {
            e = e;
            if (e.type == 1 && (q1Var = this.B.i) != null) {
                e = e.a(q1Var.f.a);
            }
            if (e.isRecoverable && this.X == null) {
                b.i.a.c.f3.q.c("ExoPlayerImplInternal", "Recoverable renderer error", e);
                this.X = e;
                b.i.a.c.f3.o oVar = this.q;
                oVar.d(oVar.i(25, e));
            } else {
                ExoPlaybackException exoPlaybackException = this.X;
                if (exoPlaybackException != null) {
                    exoPlaybackException.addSuppressed(e);
                    e = this.X;
                }
                b.i.a.c.f3.q.b("ExoPlayerImplInternal", "Playback error", e);
                j0(true, false);
                this.G = this.G.e(e);
            }
        } catch (ParserException e2) {
            int i2 = e2.dataType;
            if (i2 == 1) {
                i = e2.contentIsMalformed ? 3001 : 3003;
            } else if (i2 == 4) {
                i = e2.contentIsMalformed ? 3002 : 3004;
            }
            p(e2, i);
        } catch (DrmSession$DrmSessionException e3) {
            p(e3, e3.errorCode);
        } catch (BehindLiveWindowException e4) {
            p(e4, PointerIconCompat.TYPE_HAND);
        } catch (DataSourceException e5) {
            p(e5, e5.reason);
        } catch (IOException e6) {
            p(e6, 2000);
        } catch (RuntimeException e7) {
            ExoPlaybackException exoPlaybackExceptionB = ExoPlaybackException.b(e7, ((e7 instanceof IllegalStateException) || (e7 instanceof IllegalArgumentException)) ? PointerIconCompat.TYPE_WAIT : 1000);
            b.i.a.c.f3.q.b("ExoPlayerImplInternal", "Playback error", exoPlaybackExceptionB);
            j0(true, false);
            this.G = this.G.e(exoPlaybackExceptionB);
        }
        A();
        return true;
    }

    public final void i0() throws ExoPlaybackException {
        this.L = false;
        a1 a1Var = this.f1008x;
        a1Var.o = true;
        a1Var.j.b();
        for (f2 f2Var : this.j) {
            if (w(f2Var)) {
                f2Var.start();
            }
        }
    }

    public final long j(o2 o2Var, Object obj, long j) {
        o2Var.n(o2Var.h(obj, this.u).l, this.t);
        o2$c o2_c = this.t;
        if (o2_c.f1042s != -9223372036854775807L && o2_c.c()) {
            o2$c o2_c2 = this.t;
            if (o2_c2.v) {
                long j2 = o2_c2.t;
                int i = b.i.a.c.f3.e0.a;
                return b.i.a.c.f3.e0.B((j2 == -9223372036854775807L ? System.currentTimeMillis() : j2 + SystemClock.elapsedRealtime()) - this.t.f1042s) - (j + this.u.n);
            }
        }
        return -9223372036854775807L;
    }

    public final void j0(boolean z2, boolean z3) {
        H(z2 || !this.P, false, true, false);
        this.H.a(z3 ? 1 : 0);
        this.o.i();
        f0(1);
    }

    public final long k() {
        q1 q1Var = this.B.i;
        if (q1Var == null) {
            return 0L;
        }
        long jMax = q1Var.o;
        if (!q1Var.d) {
            return jMax;
        }
        int i = 0;
        while (true) {
            f2[] f2VarArr = this.j;
            if (i >= f2VarArr.length) {
                return jMax;
            }
            if (w(f2VarArr[i]) && this.j[i].h() == q1Var.c[i]) {
                long jT = this.j[i].t();
                if (jT == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                jMax = Math.max(jT, jMax);
            }
            i++;
        }
    }

    public final void k0() throws ExoPlaybackException {
        a1 a1Var = this.f1008x;
        a1Var.o = false;
        b.i.a.c.f3.z zVar = a1Var.j;
        if (zVar.k) {
            zVar.a(zVar.e());
            zVar.k = false;
        }
        for (f2 f2Var : this.j) {
            if (w(f2Var) && f2Var.getState() == 2) {
                f2Var.stop();
            }
        }
    }

    public final Pair<a0$a, Long> l(o2 o2Var) {
        if (o2Var.q()) {
            a0$a a0_a = w1.a;
            return Pair.create(w1.a, 0L);
        }
        Pair<Object, Long> pairJ = o2Var.j(this.t, this.u, o2Var.a(this.O), -9223372036854775807L);
        a0$a a0_aO = this.B.o(o2Var, pairJ.first, 0L);
        long jLongValue = ((Long) pairJ.second).longValue();
        if (a0_aO.a()) {
            o2Var.h(a0_aO.a, this.u);
            jLongValue = a0_aO.c == this.u.d(a0_aO.f835b) ? this.u.p.o : 0L;
        }
        return Pair.create(a0_aO, Long.valueOf(jLongValue));
    }

    public final void l0() {
        q1 q1Var = this.B.j;
        boolean z2 = this.M || (q1Var != null && q1Var.a.h());
        w1 w1Var = this.G;
        if (z2 != w1Var.h) {
            this.G = new w1(w1Var.f1146b, w1Var.c, w1Var.d, w1Var.e, w1Var.f, w1Var.g, z2, w1Var.i, w1Var.j, w1Var.k, w1Var.l, w1Var.m, w1Var.n, w1Var.o, w1Var.r, w1Var.f1147s, w1Var.t, w1Var.p, w1Var.q);
        }
    }

    public final long m() {
        return n(this.G.r);
    }

    public final void m0(o2 o2Var, a0$a a0_a, o2 o2Var2, a0$a a0_a2, long j) {
        if (o2Var.q() || !h0(o2Var, a0_a)) {
            float f = this.f1008x.c().k;
            x1 x1Var = this.G.o;
            if (f != x1Var.k) {
                this.f1008x.i(x1Var);
                return;
            }
            return;
        }
        o2Var.n(o2Var.h(a0_a.a, this.u).l, this.t);
        m1 m1Var = this.D;
        o1$g o1_g = this.t.f1043x;
        int i = b.i.a.c.f3.e0.a;
        y0 y0Var = (y0) m1Var;
        Objects.requireNonNull(y0Var);
        y0Var.d = b.i.a.c.f3.e0.B(o1_g.l);
        y0Var.g = b.i.a.c.f3.e0.B(o1_g.m);
        y0Var.h = b.i.a.c.f3.e0.B(o1_g.n);
        float f2 = o1_g.o;
        if (f2 == -3.4028235E38f) {
            f2 = 0.97f;
        }
        y0Var.k = f2;
        float f3 = o1_g.p;
        if (f3 == -3.4028235E38f) {
            f3 = 1.03f;
        }
        y0Var.j = f3;
        y0Var.a();
        if (j != -9223372036854775807L) {
            y0 y0Var2 = (y0) this.D;
            y0Var2.e = j(o2Var, a0_a.a, j);
            y0Var2.a();
        } else {
            if (b.i.a.c.f3.e0.a(o2Var2.q() ? null : o2Var2.n(o2Var2.h(a0_a2.a, this.u).l, this.t).n, this.t.n)) {
                return;
            }
            y0 y0Var3 = (y0) this.D;
            y0Var3.e = -9223372036854775807L;
            y0Var3.a();
        }
    }

    public final long n(long j) {
        q1 q1Var = this.B.j;
        if (q1Var == null) {
            return 0L;
        }
        return Math.max(0L, j - (this.U - q1Var.o));
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:48:0x00c3  */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0166, code lost:
    
        r6 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n0() throws ExoPlaybackException {
        x1 x1VarC;
        b.i.a.c.f3.z zVar;
        long j;
        h1 h1Var;
        h1$c h1_c;
        q1 q1Var = this.B.h;
        if (q1Var == null) {
            return;
        }
        long jK = q1Var.d ? q1Var.a.k() : -9223372036854775807L;
        if (jK != -9223372036854775807L) {
            J(jK);
            if (jK != this.G.t) {
                w1 w1Var = this.G;
                this.G = u(w1Var.c, jK, w1Var.d, jK, true, 5);
            }
        } else {
            a1 a1Var = this.f1008x;
            boolean z2 = q1Var != this.B.i;
            f2 f2Var = a1Var.l;
            if (f2Var == null || f2Var.b() || (!a1Var.l.d() && (z2 || a1Var.l.j()))) {
                a1Var.n = true;
                if (a1Var.o) {
                    a1Var.j.b();
                }
            } else {
                b.i.a.c.f3.s sVar = a1Var.m;
                Objects.requireNonNull(sVar);
                long jE = sVar.e();
                if (!a1Var.n) {
                    a1Var.j.a(jE);
                    x1VarC = sVar.c();
                    if (!x1VarC.equals(a1Var.j.n)) {
                        zVar = a1Var.j;
                        if (zVar.k) {
                            zVar.a(zVar.e());
                        }
                        zVar.n = x1VarC;
                        ((b0$b) ((h1) a1Var.k).q.i(16, x1VarC)).b();
                    }
                } else if (jE < a1Var.j.e()) {
                    b.i.a.c.f3.z zVar2 = a1Var.j;
                    if (zVar2.k) {
                        zVar2.a(zVar2.e());
                        zVar2.k = false;
                    }
                } else {
                    a1Var.n = false;
                    if (a1Var.o) {
                        a1Var.j.b();
                    }
                    a1Var.j.a(jE);
                    x1VarC = sVar.c();
                    if (!x1VarC.equals(a1Var.j.n)) {
                        zVar = a1Var.j;
                        if (zVar.k) {
                            zVar.a(zVar.e());
                        }
                        zVar.n = x1VarC;
                        ((b0$b) ((h1) a1Var.k).q.i(16, x1VarC)).b();
                    }
                }
            }
            long jE2 = a1Var.e();
            this.U = jE2;
            long j2 = jE2 - q1Var.o;
            long j3 = this.G.t;
            if (!this.f1009y.isEmpty() && !this.G.c.a()) {
                if (this.W) {
                    j3--;
                    this.W = false;
                }
                w1 w1Var2 = this.G;
                int iB = w1Var2.f1146b.b(w1Var2.c.a);
                int iMin = Math.min(this.V, this.f1009y.size());
                if (iMin > 0) {
                    h1_c = this.f1009y.get(iMin - 1);
                    j = j2;
                    h1Var = this;
                } else {
                    j = j2;
                    h1Var = this;
                    h1_c = null;
                }
                while (h1_c != null) {
                    int i = h1_c.k;
                    if (i <= iB && (i != iB || h1_c.l <= j3)) {
                        break;
                    }
                    iMin--;
                    if (iMin > 0) {
                        h1_c = h1Var.f1009y.get(iMin - 1);
                    } else {
                        j = j;
                        h1Var = h1Var;
                        h1_c = null;
                    }
                }
                if (iMin < h1Var.f1009y.size()) {
                    h1$c h1_c2 = h1Var.f1009y.get(iMin);
                    while (h1_c2 != null && h1_c2.m != null) {
                        int i2 = h1_c2.k;
                        if (i2 >= iB && (i2 != iB || h1_c2.l > j3)) {
                            break;
                        }
                        iMin++;
                        h1_c2 = iMin < h1Var.f1009y.size() ? h1Var.f1009y.get(iMin) : null;
                    }
                    while (h1_c2 != null && h1_c2.m != null && h1_c2.k == iB) {
                        long j4 = h1_c2.l;
                        if (j4 <= j3 || j4 > j) {
                            break;
                        }
                        try {
                            h1Var.T(h1_c2.j);
                            Objects.requireNonNull(h1_c2.j);
                            h1Var.f1009y.remove(iMin);
                            h1_c2 = iMin < h1Var.f1009y.size() ? h1Var.f1009y.get(iMin) : null;
                        } catch (Throwable th) {
                            Objects.requireNonNull(h1_c2.j);
                            h1Var.f1009y.remove(iMin);
                            throw th;
                        }
                    }
                    h1Var.V = iMin;
                }
            }
            this.G.t = j2;
        }
        this.G.r = this.B.j.d();
        this.G.f1147s = m();
        w1 w1Var3 = this.G;
        if (w1Var3.m && w1Var3.f == 3 && h0(w1Var3.f1146b, w1Var3.c)) {
            w1 w1Var4 = this.G;
            float f = 1.0f;
            if (w1Var4.o.k == 1.0f) {
                m1 m1Var = this.D;
                long j5 = j(w1Var4.f1146b, w1Var4.c.a, w1Var4.t);
                long jM = m();
                y0 y0Var = (y0) m1Var;
                if (y0Var.d != -9223372036854775807L) {
                    long j6 = j5 - jM;
                    long j7 = y0Var.n;
                    if (j7 == -9223372036854775807L) {
                        y0Var.n = j6;
                        y0Var.o = 0L;
                    } else {
                        float f2 = y0Var.c;
                        long jMax = Math.max(j6, (long) (((1.0f - f2) * j6) + (j7 * f2)));
                        y0Var.n = jMax;
                        long jAbs = Math.abs(j6 - jMax);
                        long j8 = y0Var.o;
                        float f3 = y0Var.c;
                        y0Var.o = (long) (((1.0f - f3) * jAbs) + (j8 * f3));
                    }
                    if (y0Var.m == -9223372036854775807L || SystemClock.elapsedRealtime() - y0Var.m >= 1000) {
                        y0Var.m = SystemClock.elapsedRealtime();
                        long j9 = (y0Var.o * 3) + y0Var.n;
                        if (y0Var.i > j9) {
                            float fB = b.i.a.c.f3.e0.B(1000L);
                            long[] jArr = {j9, y0Var.f, y0Var.i - (((long) ((y0Var.l - 1.0f) * fB)) + ((long) ((y0Var.j - 1.0f) * fB)))};
                            b.i.a.f.e.o.f.v(true);
                            long j10 = jArr[0];
                            for (int i3 = 1; i3 < 3; i3++) {
                                if (jArr[i3] > j10) {
                                    j10 = jArr[i3];
                                }
                            }
                            y0Var.i = j10;
                        } else {
                            long jI = b.i.a.c.f3.e0.i(j5 - ((long) (Math.max(0.0f, y0Var.l - 1.0f) / 1.0E-7f)), y0Var.i, j9);
                            y0Var.i = jI;
                            long j11 = y0Var.h;
                            if (j11 != -9223372036854775807L && jI > j11) {
                                y0Var.i = j11;
                            }
                        }
                        long j12 = j5 - y0Var.i;
                        if (Math.abs(j12) < y0Var.a) {
                            y0Var.l = 1.0f;
                        } else {
                            y0Var.l = b.i.a.c.f3.e0.g((1.0E-7f * j12) + 1.0f, y0Var.k, y0Var.j);
                        }
                        f = y0Var.l;
                    } else {
                        f = y0Var.l;
                    }
                }
                if (this.f1008x.c().k != f) {
                    this.f1008x.i(new x1(f, this.G.o.l));
                    t(this.G.o, this.f1008x.c().k, false, false);
                }
            }
        }
    }

    public final void o(b.i.a.c.a3.x xVar) {
        s1 s1Var = this.B;
        q1 q1Var = s1Var.j;
        if (q1Var != null && q1Var.a == xVar) {
            s1Var.m(this.U);
            z();
        }
    }

    public final void p(IOException iOException, int i) {
        ExoPlaybackException exoPlaybackException = new ExoPlaybackException(0, iOException, i);
        q1 q1Var = this.B.h;
        if (q1Var != null) {
            exoPlaybackException = exoPlaybackException.a(q1Var.f.a);
        }
        b.i.a.c.f3.q.b("ExoPlayerImplInternal", "Playback error", exoPlaybackException);
        j0(false, false);
        this.G = this.G.e(exoPlaybackException);
    }

    public final void q(boolean z2) {
        q1 q1Var = this.B.j;
        a0$a a0_a = q1Var == null ? this.G.c : q1Var.f.a;
        boolean z3 = !this.G.l.equals(a0_a);
        if (z3) {
            this.G = this.G.a(a0_a);
        }
        w1 w1Var = this.G;
        w1Var.r = q1Var == null ? w1Var.t : q1Var.d();
        this.G.f1147s = m();
        if ((z3 || z2) && q1Var != null && q1Var.d) {
            this.o.d(this.j, q1Var.m, q1Var.n.c);
        }
    }

    public final void r(o2 o2Var, boolean z2) throws Throwable {
        a0$a a0_a;
        Object obj;
        int iA;
        Object obj2;
        long j;
        long j2;
        int i;
        int i2;
        boolean z3;
        boolean z4;
        boolean z5;
        int iA2;
        boolean z6;
        boolean z7;
        long j3;
        long j4;
        h1$f h1_f;
        long j5;
        int i3;
        long jLongValue;
        Object obj3;
        boolean z8;
        int i4;
        int iA3;
        boolean z9;
        boolean z10;
        boolean z11;
        long j6;
        h1$g h1_g;
        boolean z12;
        boolean z13;
        boolean z14;
        w1 w1Var = this.G;
        h1$g h1_g2 = this.T;
        s1 s1Var = this.B;
        int i5 = this.N;
        boolean z15 = this.O;
        o2$c o2_c = this.t;
        o2$b o2_b = this.u;
        if (o2Var.q()) {
            a0$a a0_a2 = w1.a;
            h1_f = new h1$f(w1.a, 0L, -9223372036854775807L, false, true, false);
        } else {
            a0$a a0_a3 = w1Var.c;
            Object obj4 = a0_a3.a;
            boolean zY = y(w1Var, o2_b);
            long j7 = (w1Var.c.a() || zY) ? w1Var.d : w1Var.t;
            if (h1_g2 != null) {
                Object obj5 = obj4;
                Pair<Object, Long> pairM = M(o2Var, h1_g2, true, i5, z15, o2_c, o2_b);
                if (pairM == null) {
                    iA3 = o2Var.a(z15);
                    j6 = j7;
                    z11 = false;
                    z10 = false;
                    z9 = true;
                } else {
                    if (h1_g2.c == -9223372036854775807L) {
                        i4 = o2Var.h(pairM.first, o2_b).l;
                        jLongValue = j7;
                        obj3 = obj5;
                        z8 = false;
                    } else {
                        Object obj6 = pairM.first;
                        jLongValue = ((Long) pairM.second).longValue();
                        obj3 = obj6;
                        z8 = true;
                        i4 = -1;
                    }
                    obj5 = obj3;
                    iA3 = i4;
                    z9 = false;
                    long j8 = jLongValue;
                    z10 = w1Var.f == 4;
                    z11 = z8;
                    j6 = j8;
                }
                z5 = z11;
                z3 = z10;
                j2 = j6;
                z4 = z9;
                a0_a = a0_a3;
                i2 = -1;
                i = iA3;
                obj2 = obj5;
            } else {
                a0_a = a0_a3;
                if (w1Var.f1146b.q()) {
                    iA = o2Var.a(z15);
                    obj = obj4;
                } else if (o2Var.b(obj4) == -1) {
                    obj = obj4;
                    Object objN = N(o2_c, o2_b, i5, z15, obj4, w1Var.f1146b, o2Var);
                    if (objN == null) {
                        iA2 = o2Var.a(z15);
                        z6 = true;
                    } else {
                        iA2 = o2Var.h(objN, o2_b).l;
                        z6 = false;
                    }
                    z7 = z6;
                    a0_a = a0_a;
                    i = iA2;
                    z4 = z7;
                    obj2 = obj;
                    j2 = j7;
                    i2 = -1;
                    z3 = false;
                    z5 = false;
                } else {
                    obj = obj4;
                    if (j7 == -9223372036854775807L) {
                        iA = o2Var.h(obj, o2_b).l;
                    } else if (zY) {
                        a0_a = a0_a;
                        w1Var.f1146b.h(a0_a.a, o2_b);
                        if (w1Var.f1146b.n(o2_b.l, o2_c).B == w1Var.f1146b.b(a0_a.a)) {
                            Pair<Object, Long> pairJ = o2Var.j(o2_c, o2_b, o2Var.h(obj, o2_b).l, j7 + o2_b.n);
                            Object obj7 = pairJ.first;
                            long jLongValue2 = ((Long) pairJ.second).longValue();
                            obj2 = obj7;
                            j = jLongValue2;
                        } else {
                            obj2 = obj;
                            j = j7;
                        }
                        j2 = j;
                        i = -1;
                        i2 = -1;
                        z3 = false;
                        z4 = false;
                        z5 = true;
                    } else {
                        iA = -1;
                        iA2 = iA;
                        z7 = false;
                        i = iA2;
                        z4 = z7;
                        obj2 = obj;
                        j2 = j7;
                        i2 = -1;
                        z3 = false;
                        z5 = false;
                    }
                }
                iA2 = iA;
                z7 = false;
                i = iA2;
                z4 = z7;
                obj2 = obj;
                j2 = j7;
                i2 = -1;
                z3 = false;
                z5 = false;
            }
            if (i != i2) {
                Pair<Object, Long> pairJ2 = o2Var.j(o2_c, o2_b, i, -9223372036854775807L);
                Object obj8 = pairJ2.first;
                long jLongValue3 = ((Long) pairJ2.second).longValue();
                obj2 = obj8;
                j2 = jLongValue3;
                j3 = -9223372036854775807L;
            } else {
                j3 = j2;
            }
            a0$a a0_aO = s1Var.o(o2Var, obj2, j2);
            boolean z16 = a0_aO.e == -1 || ((i3 = a0_a.e) != -1 && a0_aO.f835b >= i3);
            boolean zEquals = a0_a.a.equals(obj2);
            boolean z17 = zEquals && !a0_a.a() && !a0_aO.a() && z16;
            o2Var.h(obj2, o2_b);
            boolean z18 = zEquals && !zY && j7 == j3 && ((a0_aO.a() && o2_b.e(a0_aO.f835b)) || (a0_a.a() && o2_b.e(a0_a.f835b)));
            if (z17 || z18) {
                a0_aO = a0_a;
            }
            if (a0_aO.a()) {
                if (a0_aO.equals(a0_a)) {
                    j5 = w1Var.t;
                } else {
                    o2Var.h(a0_aO.a, o2_b);
                    j5 = a0_aO.c == o2_b.d(a0_aO.f835b) ? o2_b.p.o : 0L;
                }
                j4 = j5;
            } else {
                j4 = j2;
            }
            h1_f = new h1$f(a0_aO, j4, j3, z3, z4, z5);
        }
        h1$f h1_f2 = h1_f;
        a0$a a0_a4 = h1_f2.a;
        long j9 = h1_f2.c;
        boolean z19 = h1_f2.d;
        long jR = h1_f2.f1013b;
        boolean z20 = (this.G.c.equals(a0_a4) && jR == this.G.t) ? false : true;
        try {
            if (h1_f2.e) {
                if (this.G.f != 1) {
                    f0(4);
                }
                H(false, false, false, true);
            }
            try {
                if (z20) {
                    z13 = false;
                    z14 = true;
                    if (!o2Var.q()) {
                        for (q1 q1Var = this.B.h; q1Var != null; q1Var = q1Var.l) {
                            if (q1Var.f.a.equals(a0_a4)) {
                                q1Var.f = this.B.h(o2Var, q1Var.f);
                                q1Var.j();
                            }
                        }
                        jR = R(a0_a4, jR, z19);
                    }
                } else {
                    try {
                        z13 = false;
                        z14 = true;
                        if (!this.B.r(o2Var, this.U, k())) {
                            P(false);
                        }
                    } catch (Throwable th) {
                        th = th;
                        z12 = true;
                        h1_g = null;
                        w1 w1Var2 = this.G;
                        h1$g h1_g3 = h1_g;
                        m0(o2Var, a0_a4, w1Var2.f1146b, w1Var2.c, h1_f2.f ? jR : -9223372036854775807L);
                        if (z20 || j9 != this.G.d) {
                            w1 w1Var3 = this.G;
                            Object obj9 = w1Var3.c.a;
                            o2 o2Var2 = w1Var3.f1146b;
                            if (!z20 || !z2 || o2Var2.q() || o2Var2.h(obj9, this.u).o) {
                                z12 = false;
                            }
                            this.G = u(a0_a4, jR, j9, this.G.e, z12, o2Var.b(obj9) == -1 ? 4 : 3);
                        }
                        I();
                        L(o2Var, this.G.f1146b);
                        this.G = this.G.g(o2Var);
                        if (!o2Var.q()) {
                            this.T = h1_g3;
                        }
                        q(false);
                        throw th;
                    }
                }
                w1 w1Var4 = this.G;
                m0(o2Var, a0_a4, w1Var4.f1146b, w1Var4.c, h1_f2.f ? jR : -9223372036854775807L);
                if (z20 || j9 != this.G.d) {
                    w1 w1Var5 = this.G;
                    Object obj10 = w1Var5.c.a;
                    o2 o2Var3 = w1Var5.f1146b;
                    if (!z20 || !z2 || o2Var3.q() || o2Var3.h(obj10, this.u).o) {
                        z14 = false;
                    }
                    this.G = u(a0_a4, jR, j9, this.G.e, z14, o2Var.b(obj10) == -1 ? 4 : 3);
                }
                I();
                L(o2Var, this.G.f1146b);
                this.G = this.G.g(o2Var);
                if (!o2Var.q()) {
                    this.T = null;
                }
                q(z13);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            h1_g = null;
            z12 = true;
        }
    }

    public final void s(b.i.a.c.a3.x xVar) throws ExoPlaybackException {
        q1 q1Var = this.B.j;
        if (q1Var != null && q1Var.a == xVar) {
            float f = this.f1008x.c().k;
            o2 o2Var = this.G.f1146b;
            q1Var.d = true;
            q1Var.m = q1Var.a.n();
            b.i.a.c.c3.r rVarI = q1Var.i(f, o2Var);
            r1 r1Var = q1Var.f;
            long jMax = r1Var.f1058b;
            long j = r1Var.e;
            if (j != -9223372036854775807L && jMax >= j) {
                jMax = Math.max(0L, j - 1);
            }
            long jA = q1Var.a(rVarI, jMax, false, new boolean[q1Var.i.length]);
            long j2 = q1Var.o;
            r1 r1Var2 = q1Var.f;
            q1Var.o = (r1Var2.f1058b - jA) + j2;
            q1Var.f = r1Var2.b(jA);
            this.o.d(this.j, q1Var.m, q1Var.n.c);
            if (q1Var == this.B.h) {
                J(q1Var.f.f1058b);
                g();
                w1 w1Var = this.G;
                a0$a a0_a = w1Var.c;
                long j3 = q1Var.f.f1058b;
                this.G = u(a0_a, j3, w1Var.d, j3, false, 5);
            }
            z();
        }
    }

    public final void t(x1 x1Var, float f, boolean z2, boolean z3) throws ExoPlaybackException {
        int i;
        h1 h1Var = this;
        if (z2) {
            if (z3) {
                h1Var.H.a(1);
            }
            w1 w1Var = h1Var.G;
            h1Var = this;
            h1Var.G = new w1(w1Var.f1146b, w1Var.c, w1Var.d, w1Var.e, w1Var.f, w1Var.g, w1Var.h, w1Var.i, w1Var.j, w1Var.k, w1Var.l, w1Var.m, w1Var.n, x1Var, w1Var.r, w1Var.f1147s, w1Var.t, w1Var.p, w1Var.q);
        }
        float f2 = x1Var.k;
        q1 q1Var = h1Var.B.h;
        while (true) {
            i = 0;
            if (q1Var == null) {
                break;
            }
            b.i.a.c.c3.j[] jVarArr = q1Var.n.c;
            int length = jVarArr.length;
            while (i < length) {
                b.i.a.c.c3.j jVar = jVarArr[i];
                if (jVar != null) {
                    jVar.i(f2);
                }
                i++;
            }
            q1Var = q1Var.l;
        }
        f2[] f2VarArr = h1Var.j;
        int length2 = f2VarArr.length;
        while (i < length2) {
            f2 f2Var = f2VarArr[i];
            if (f2Var != null) {
                f2Var.n(f, x1Var.k);
            }
            i++;
        }
    }

    @CheckResult
    public final w1 u(a0$a a0_a, long j, long j2, long j3, boolean z2, int i) {
        b.i.a.c.a3.o0 o0Var;
        b.i.a.c.c3.r rVar;
        List<Metadata> list;
        b.i.b.b.p<Object> pVarL;
        int i2 = 0;
        this.W = (!this.W && j == this.G.t && a0_a.equals(this.G.c)) ? false : true;
        I();
        w1 w1Var = this.G;
        b.i.a.c.a3.o0 o0Var2 = w1Var.i;
        b.i.a.c.c3.r rVar2 = w1Var.j;
        List<Metadata> list2 = w1Var.k;
        if (this.C.j) {
            q1 q1Var = this.B.h;
            b.i.a.c.a3.o0 o0Var3 = q1Var == null ? b.i.a.c.a3.o0.j : q1Var.m;
            b.i.a.c.c3.r rVar3 = q1Var == null ? this.n : q1Var.n;
            b.i.a.c.c3.j[] jVarArr = rVar3.c;
            b.i.a.f.e.o.f.A(4, "initialCapacity");
            Object[] objArrCopyOf = new Object[4];
            int length = jVarArr.length;
            int i3 = 0;
            boolean z3 = false;
            int i4 = 0;
            while (i3 < length) {
                b.i.a.c.c3.j jVar = jVarArr[i3];
                if (jVar != null) {
                    Metadata metadata = jVar.d(i2).u;
                    if (metadata == null) {
                        Metadata metadata2 = new Metadata(new Metadata$Entry[i2]);
                        int i5 = i4 + 1;
                        if (objArrCopyOf.length < i5) {
                            objArrCopyOf = Arrays.copyOf(objArrCopyOf, n$b.a(objArrCopyOf.length, i5));
                        }
                        objArrCopyOf[i4] = metadata2;
                        i4 = i5;
                    } else {
                        int i6 = i4 + 1;
                        if (objArrCopyOf.length < i6) {
                            objArrCopyOf = Arrays.copyOf(objArrCopyOf, n$b.a(objArrCopyOf.length, i6));
                        }
                        objArrCopyOf[i4] = metadata;
                        i4 = i6;
                        z3 = true;
                    }
                }
                i3++;
                o0Var3 = o0Var3;
                i2 = 0;
            }
            b.i.a.c.a3.o0 o0Var4 = o0Var3;
            if (z3) {
                pVarL = b.i.b.b.p.l(objArrCopyOf, i4);
            } else {
                b.i.b.b.a<Object> aVar = b.i.b.b.p.k;
                pVarL = b.i.b.b.h0.l;
            }
            if (q1Var != null) {
                r1 r1Var = q1Var.f;
                if (r1Var.c != j2) {
                    q1Var.f = r1Var.a(j2);
                }
            }
            list = pVarL;
            rVar = rVar3;
            o0Var = o0Var4;
        } else if (a0_a.equals(w1Var.c)) {
            o0Var = o0Var2;
            rVar = rVar2;
            list = list2;
        } else {
            b.i.a.c.a3.o0 o0Var5 = b.i.a.c.a3.o0.j;
            b.i.a.c.c3.r rVar4 = this.n;
            b.i.b.b.a<Object> aVar2 = b.i.b.b.p.k;
            o0Var = o0Var5;
            rVar = rVar4;
            list = b.i.b.b.h0.l;
        }
        if (z2) {
            h1$d h1_d = this.H;
            if (!h1_d.d || h1_d.e == 5) {
                h1_d.a = true;
                h1_d.d = true;
                h1_d.e = i;
            } else {
                b.c.a.a0.d.j(i == 5);
            }
        }
        return this.G.b(a0_a, j, j2, j3, m(), o0Var, rVar, list);
    }

    public final boolean v() {
        q1 q1Var = this.B.j;
        if (q1Var == null) {
            return false;
        }
        return (!q1Var.d ? 0L : q1Var.a.c()) != Long.MIN_VALUE;
    }

    public final boolean x() {
        q1 q1Var = this.B.h;
        long j = q1Var.f.e;
        return q1Var.d && (j == -9223372036854775807L || this.G.t < j || !g0());
    }

    public final void z() {
        long j;
        long j2;
        boolean zG;
        if (v()) {
            q1 q1Var = this.B.j;
            long jN = n(!q1Var.d ? 0L : q1Var.a.c());
            if (q1Var == this.B.h) {
                j = this.U;
                j2 = q1Var.o;
            } else {
                j = this.U - q1Var.o;
                j2 = q1Var.f.f1058b;
            }
            zG = this.o.g(j - j2, jN, this.f1008x.c().k);
        } else {
            zG = false;
        }
        this.M = zG;
        if (zG) {
            q1 q1Var2 = this.B.j;
            long j3 = this.U;
            b.c.a.a0.d.D(q1Var2.g());
            q1Var2.a.g(j3 - q1Var2.o);
        }
        l0();
    }
}
