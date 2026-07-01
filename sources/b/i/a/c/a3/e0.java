package b.i.a.c.a3;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import b.i.a.c.j1;
import b.i.a.c.j1$b;
import b.i.a.c.j2;
import b.i.a.c.x2.t$a;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.HttpDataSource$CleartextNotPermittedException;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader$UnexpectedLoaderException;
import com.google.android.exoplayer2.upstream.Loader$b;
import com.google.android.exoplayer2.upstream.Loader$c;
import com.google.android.exoplayer2.upstream.Loader$d;
import com.google.android.exoplayer2.upstream.Loader$e;
import com.google.android.exoplayer2.upstream.Loader$f;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: compiled from: ProgressiveMediaPeriod.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e0 implements x, b.i.a.c.x2.j, Loader$b<e0$a>, Loader$f, h0$d {
    public static final Map<String, String> j;
    public static final j1 k;

    @Nullable
    public x$a B;

    @Nullable
    public IcyHeaders C;
    public boolean F;
    public boolean G;
    public boolean H;
    public e0$e I;
    public b.i.a.c.x2.t J;
    public boolean L;
    public boolean N;
    public boolean O;
    public int P;
    public long R;
    public boolean T;
    public int U;
    public boolean V;
    public boolean W;
    public final Uri l;
    public final b.i.a.c.e3.l m;
    public final b.i.a.c.w2.u n;
    public final b.i.a.c.e3.w o;
    public final b0$a p;
    public final b.i.a.c.w2.s$a q;
    public final e0$b r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b.i.a.c.e3.o f809s;

    @Nullable
    public final String t;
    public final long u;
    public final d0 w;
    public final Loader v = new Loader("ProgressiveMediaPeriod");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final b.i.a.c.f3.j f810x = new b.i.a.c.f3.j();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Runnable f811y = new g(this);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Runnable f812z = new i(this);
    public final Handler A = b.i.a.c.f3.e0.j();
    public e0$d[] E = new e0$d[0];
    public h0[] D = new h0[0];
    public long S = -9223372036854775807L;
    public long Q = -1;
    public long K = -9223372036854775807L;
    public int M = 1;

    static {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", "1");
        j = Collections.unmodifiableMap(map);
        j1$b j1_b = new j1$b();
        j1_b.a = "icy";
        j1_b.k = "application/x-icy";
        k = j1_b.a();
    }

    public e0(Uri uri, b.i.a.c.e3.l lVar, d0 d0Var, b.i.a.c.w2.u uVar, b.i.a.c.w2.s$a s_a, b.i.a.c.e3.w wVar, b0$a b0_a, e0$b e0_b, b.i.a.c.e3.o oVar, @Nullable String str, int i) {
        this.l = uri;
        this.m = lVar;
        this.n = uVar;
        this.q = s_a;
        this.o = wVar;
        this.p = b0_a;
        this.r = e0_b;
        this.f809s = oVar;
        this.t = str;
        this.u = i;
        this.w = d0Var;
    }

    public void A() throws IOException {
        Loader loader = this.v;
        int iA = ((b.i.a.c.e3.s) this.o).a(this.M);
        IOException iOException = loader.e;
        if (iOException != null) {
            throw iOException;
        }
        Loader$d<? extends Loader$e> loader$d = loader.d;
        if (loader$d != null) {
            if (iA == Integer.MIN_VALUE) {
                iA = loader$d.j;
            }
            IOException iOException2 = loader$d.n;
            if (iOException2 != null && loader$d.o > iA) {
                throw iOException2;
            }
        }
    }

    public final b.i.a.c.x2.w B(e0$d e0_d) {
        int length = this.D.length;
        for (int i = 0; i < length; i++) {
            if (e0_d.equals(this.E[i])) {
                return this.D[i];
            }
        }
        b.i.a.c.e3.o oVar = this.f809s;
        Looper looper = this.A.getLooper();
        b.i.a.c.w2.u uVar = this.n;
        b.i.a.c.w2.s$a s_a = this.q;
        Objects.requireNonNull(looper);
        Objects.requireNonNull(uVar);
        Objects.requireNonNull(s_a);
        h0 h0Var = new h0(oVar, looper, uVar, s_a);
        h0Var.g = this;
        int i2 = length + 1;
        e0$d[] e0_dArr = (e0$d[]) Arrays.copyOf(this.E, i2);
        e0_dArr[length] = e0_d;
        int i3 = b.i.a.c.f3.e0.a;
        this.E = e0_dArr;
        h0[] h0VarArr = (h0[]) Arrays.copyOf(this.D, i2);
        h0VarArr[length] = h0Var;
        this.D = h0VarArr;
        return h0Var;
    }

    public final void C() {
        e0$a e0_a = new e0$a(this, this.l, this.m, this.w, this, this.f810x);
        if (this.G) {
            b.c.a.a0.d.D(w());
            long j2 = this.K;
            if (j2 != -9223372036854775807L && this.S > j2) {
                this.V = true;
                this.S = -9223372036854775807L;
                return;
            }
            b.i.a.c.x2.t tVar = this.J;
            Objects.requireNonNull(tVar);
            long j3 = tVar.h(this.S).a.c;
            long j4 = this.S;
            e0_a.g.a = j3;
            e0_a.j = j4;
            e0_a.i = true;
            e0_a.n = false;
            for (h0 h0Var : this.D) {
                h0Var.u = this.S;
            }
            this.S = -9223372036854775807L;
        }
        this.U = u();
        Loader loader = this.v;
        int iA = ((b.i.a.c.e3.s) this.o).a(this.M);
        Objects.requireNonNull(loader);
        Looper looperMyLooper = Looper.myLooper();
        b.c.a.a0.d.H(looperMyLooper);
        loader.e = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new Loader$d(loader, looperMyLooper, e0_a, this, iA, jElapsedRealtime).b(0L);
        b.i.a.c.e3.n nVar = e0_a.k;
        b0$a b0_a = this.p;
        b0_a.f(new t(e0_a.a, nVar, jElapsedRealtime), new w(1, -1, null, 0, null, b0_a.a(e0_a.j), b0_a.a(this.K)));
    }

    public final boolean D() {
        return this.O || w();
    }

    @Override // b.i.a.c.x2.j
    public void a(b.i.a.c.x2.t tVar) {
        this.A.post(new h(this, tVar));
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public void b(Loader$e loader$e, long j2, long j3, boolean z2) {
        e0$a e0_a = (e0$a) loader$e;
        b.i.a.c.e3.y yVar = e0_a.c;
        t tVar = new t(e0_a.a, e0_a.k, yVar.c, yVar.d, j2, j3, yVar.f956b);
        Objects.requireNonNull(this.o);
        b0$a b0_a = this.p;
        b0_a.c(tVar, new w(1, -1, null, 0, null, b0_a.a(e0_a.j), b0_a.a(this.K)));
        if (z2) {
            return;
        }
        if (this.Q == -1) {
            this.Q = e0_a.l;
        }
        for (h0 h0Var : this.D) {
            h0Var.s(false);
        }
        if (this.P > 0) {
            x$a x_a = this.B;
            Objects.requireNonNull(x_a);
            x_a.a(this);
        }
    }

    @Override // b.i.a.c.a3.x
    public long c() {
        if (this.P == 0) {
            return Long.MIN_VALUE;
        }
        return q();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public void d(Loader$e loader$e, long j2, long j3) {
        b.i.a.c.x2.t tVar;
        e0$a e0_a = (e0$a) loader$e;
        if (this.K == -9223372036854775807L && (tVar = this.J) != null) {
            boolean zC = tVar.c();
            long jV = v();
            long j4 = jV == Long.MIN_VALUE ? 0L : jV + 10000;
            this.K = j4;
            ((f0) this.r).u(j4, zC, this.L);
        }
        b.i.a.c.e3.y yVar = e0_a.c;
        t tVar2 = new t(e0_a.a, e0_a.k, yVar.c, yVar.d, j2, j3, yVar.f956b);
        Objects.requireNonNull(this.o);
        b0$a b0_a = this.p;
        b0_a.d(tVar2, new w(1, -1, null, 0, null, b0_a.a(e0_a.j), b0_a.a(this.K)));
        if (this.Q == -1) {
            this.Q = e0_a.l;
        }
        this.V = true;
        x$a x_a = this.B;
        Objects.requireNonNull(x_a);
        x_a.a(this);
    }

    @Override // b.i.a.c.a3.x
    public void e() throws IOException {
        A();
        if (this.V && !this.G) {
            throw ParserException.a("Loading finished before preparation is complete.", null);
        }
    }

    @Override // b.i.a.c.a3.x
    public long f(long j2) {
        boolean z2;
        t();
        boolean[] zArr = this.I.f816b;
        if (!this.J.c()) {
            j2 = 0;
        }
        this.O = false;
        this.R = j2;
        if (w()) {
            this.S = j2;
            return j2;
        }
        if (this.M != 7) {
            int length = this.D.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z2 = true;
                    break;
                }
                if (!this.D[i].t(j2, false) && (zArr[i] || !this.H)) {
                    z2 = false;
                    break;
                }
                i++;
            }
            if (z2) {
                return j2;
            }
        }
        this.T = false;
        this.S = j2;
        this.V = false;
        if (this.v.b()) {
            for (h0 h0Var : this.D) {
                h0Var.h();
            }
            Loader$d<? extends Loader$e> loader$d = this.v.d;
            b.c.a.a0.d.H(loader$d);
            loader$d.a(false);
        } else {
            this.v.e = null;
            for (h0 h0Var2 : this.D) {
                h0Var2.s(false);
            }
        }
        return j2;
    }

    @Override // b.i.a.c.a3.x
    public boolean g(long j2) {
        if (!this.V) {
            if (!(this.v.e != null) && !this.T && (!this.G || this.P != 0)) {
                boolean zB = this.f810x.b();
                if (this.v.b()) {
                    return zB;
                }
                C();
                return true;
            }
        }
        return false;
    }

    @Override // b.i.a.c.a3.x
    public boolean h() {
        boolean z2;
        if (this.v.b()) {
            b.i.a.c.f3.j jVar = this.f810x;
            synchronized (jVar) {
                z2 = jVar.f971b;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    @Override // b.i.a.c.a3.x
    public long i(long j2, j2 j2Var) {
        t();
        if (!this.J.c()) {
            return 0L;
        }
        t$a t_aH = this.J.h(j2);
        long j3 = t_aH.a.f1298b;
        long j4 = t_aH.f1296b.f1298b;
        long j5 = j2Var.c;
        if (j5 == 0 && j2Var.d == 0) {
            return j2;
        }
        int i = b.i.a.c.f3.e0.a;
        long j6 = j2 - j5;
        long j7 = ((j5 ^ j2) & (j2 ^ j6)) >= 0 ? j6 : Long.MIN_VALUE;
        long j8 = j2Var.d;
        long j9 = RecyclerView.FOREVER_NS;
        long j10 = j2 + j8;
        if (((j8 ^ j10) & (j2 ^ j10)) >= 0) {
            j9 = j10;
        }
        boolean z2 = false;
        boolean z3 = j7 <= j3 && j3 <= j9;
        if (j7 <= j4 && j4 <= j9) {
            z2 = true;
        }
        if (z3 && z2) {
            if (Math.abs(j3 - j2) <= Math.abs(j4 - j2)) {
                return j3;
            }
        } else {
            if (z3) {
                return j3;
            }
            if (!z2) {
                return j7;
            }
        }
        return j4;
    }

    @Override // b.i.a.c.x2.j
    public void j() {
        this.F = true;
        this.A.post(this.f811y);
    }

    @Override // b.i.a.c.a3.x
    public long k() {
        if (!this.O) {
            return -9223372036854775807L;
        }
        if (!this.V && u() <= this.U) {
            return -9223372036854775807L;
        }
        this.O = false;
        return this.R;
    }

    @Override // b.i.a.c.a3.x
    public void l(x$a x_a, long j2) {
        this.B = x_a;
        this.f810x.b();
        C();
    }

    @Override // b.i.a.c.a3.x
    public long m(b.i.a.c.c3.j[] jVarArr, boolean[] zArr, i0[] i0VarArr, boolean[] zArr2, long j2) {
        t();
        e0$e e0_e = this.I;
        o0 o0Var = e0_e.a;
        boolean[] zArr3 = e0_e.c;
        int i = this.P;
        for (int i2 = 0; i2 < jVarArr.length; i2++) {
            if (i0VarArr[i2] != null && (jVarArr[i2] == null || !zArr[i2])) {
                int i3 = ((e0$c) i0VarArr[i2]).a;
                b.c.a.a0.d.D(zArr3[i3]);
                this.P--;
                zArr3[i3] = false;
                i0VarArr[i2] = null;
            }
        }
        boolean z2 = !this.N ? j2 == 0 : i != 0;
        for (int i4 = 0; i4 < jVarArr.length; i4++) {
            if (i0VarArr[i4] == null && jVarArr[i4] != null) {
                b.i.a.c.c3.j jVar = jVarArr[i4];
                b.c.a.a0.d.D(jVar.length() == 1);
                b.c.a.a0.d.D(jVar.f(0) == 0);
                int iA = o0Var.a(jVar.a());
                b.c.a.a0.d.D(!zArr3[iA]);
                this.P++;
                zArr3[iA] = true;
                i0VarArr[i4] = new e0$c(this, iA);
                zArr2[i4] = true;
                if (!z2) {
                    h0 h0Var = this.D[iA];
                    z2 = (h0Var.t(j2, true) || h0Var.k() == 0) ? false : true;
                }
            }
        }
        if (this.P == 0) {
            this.T = false;
            this.O = false;
            if (this.v.b()) {
                for (h0 h0Var2 : this.D) {
                    h0Var2.h();
                }
                Loader$d<? extends Loader$e> loader$d = this.v.d;
                b.c.a.a0.d.H(loader$d);
                loader$d.a(false);
            } else {
                for (h0 h0Var3 : this.D) {
                    h0Var3.s(false);
                }
            }
        } else if (z2) {
            j2 = f(j2);
            for (int i5 = 0; i5 < i0VarArr.length; i5++) {
                if (i0VarArr[i5] != null) {
                    zArr2[i5] = true;
                }
            }
        }
        this.N = true;
        return j2;
    }

    @Override // b.i.a.c.a3.x
    public o0 n() {
        t();
        return this.I.a;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x007a  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:53:0x00db  */
    @Override // com.google.android.exoplayer2.upstream.Loader$b
    public Loader$c o(Loader$e loader$e, long j2, long j3, IOException iOException, int i) {
        long jMin;
        boolean z2;
        Loader$c loader$cA;
        b.i.a.c.x2.t tVar;
        boolean z3;
        e0$a e0_a = (e0$a) loader$e;
        if (this.Q == -1) {
            this.Q = e0_a.l;
        }
        b.i.a.c.e3.y yVar = e0_a.c;
        t tVar2 = new t(e0_a.a, e0_a.k, yVar.c, yVar.d, j2, j3, yVar.f956b);
        b.i.a.c.f3.e0.M(e0_a.j);
        b.i.a.c.f3.e0.M(this.K);
        if ((iOException instanceof ParserException) || (iOException instanceof FileNotFoundException) || (iOException instanceof HttpDataSource$CleartextNotPermittedException) || (iOException instanceof Loader$UnexpectedLoaderException)) {
            jMin = -9223372036854775807L;
        } else {
            int i2 = DataSourceException.j;
            Throwable cause = iOException;
            while (true) {
                if (cause == null) {
                    z3 = false;
                    break;
                }
                if ((cause instanceof DataSourceException) && ((DataSourceException) cause).reason == 2008) {
                    z3 = true;
                    break;
                }
                cause = cause.getCause();
            }
            if (z3) {
                jMin = -9223372036854775807L;
            } else {
                jMin = Math.min((i - 1) * 1000, 5000);
            }
        }
        if (jMin == -9223372036854775807L) {
            loader$cA = Loader.f2978b;
        } else {
            int iU = u();
            boolean z4 = iU > this.U;
            if (this.Q == -1 && ((tVar = this.J) == null || tVar.i() == -9223372036854775807L)) {
                if (!this.G || D()) {
                    this.O = this.G;
                    this.R = 0L;
                    this.U = 0;
                    for (h0 h0Var : this.D) {
                        h0Var.s(false);
                    }
                    e0_a.g.a = 0L;
                    e0_a.j = 0L;
                    e0_a.i = true;
                    e0_a.n = false;
                } else {
                    this.T = true;
                    z2 = false;
                }
                if (z2) {
                    loader$cA = Loader.a(z4, jMin);
                } else {
                    loader$cA = Loader.a;
                }
            } else {
                this.U = iU;
            }
            z2 = true;
            if (z2) {
                loader$cA = Loader.a(z4, jMin);
            } else {
                loader$cA = Loader.a;
            }
        }
        int i3 = loader$cA.a;
        boolean z5 = !(i3 == 0 || i3 == 1);
        b0$a b0_a = this.p;
        b0_a.e(tVar2, new w(1, -1, null, 0, null, b0_a.a(e0_a.j), b0_a.a(this.K)), iOException, z5);
        if (z5) {
            Objects.requireNonNull(this.o);
        }
        return loader$cA;
    }

    @Override // b.i.a.c.x2.j
    public b.i.a.c.x2.w p(int i, int i2) {
        return B(new e0$d(i, false));
    }

    @Override // b.i.a.c.a3.x
    public long q() {
        long jV;
        boolean z2;
        long j2;
        t();
        boolean[] zArr = this.I.f816b;
        if (this.V) {
            return Long.MIN_VALUE;
        }
        if (w()) {
            return this.S;
        }
        if (this.H) {
            int length = this.D.length;
            jV = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                if (zArr[i]) {
                    h0 h0Var = this.D[i];
                    synchronized (h0Var) {
                        z2 = h0Var.f821x;
                    }
                    if (z2) {
                        continue;
                    } else {
                        h0 h0Var2 = this.D[i];
                        synchronized (h0Var2) {
                            j2 = h0Var2.w;
                        }
                        jV = Math.min(jV, j2);
                    }
                }
            }
        } else {
            jV = Long.MAX_VALUE;
        }
        if (jV == RecyclerView.FOREVER_NS) {
            jV = v();
        }
        return jV == Long.MIN_VALUE ? this.R : jV;
    }

    @Override // b.i.a.c.a3.x
    public void r(long j2, boolean z2) {
        long jG;
        int i;
        t();
        if (w()) {
            return;
        }
        boolean[] zArr = this.I.c;
        int length = this.D.length;
        for (int i2 = 0; i2 < length; i2++) {
            h0 h0Var = this.D[i2];
            boolean z3 = zArr[i2];
            g0 g0Var = h0Var.a;
            synchronized (h0Var) {
                int i3 = h0Var.q;
                jG = -1;
                if (i3 != 0) {
                    long[] jArr = h0Var.o;
                    int i4 = h0Var.f820s;
                    if (j2 >= jArr[i4]) {
                        int i5 = h0Var.i(i4, (!z3 || (i = h0Var.t) == i3) ? i3 : i + 1, j2, z2);
                        if (i5 != -1) {
                            jG = h0Var.g(i5);
                        }
                    }
                }
            }
            g0Var.a(jG);
        }
    }

    @Override // b.i.a.c.a3.x
    public void s(long j2) {
    }

    @EnsuresNonNull({"trackState", "seekMap"})
    public final void t() {
        b.c.a.a0.d.D(this.G);
        Objects.requireNonNull(this.I);
        Objects.requireNonNull(this.J);
    }

    public final int u() {
        int iN = 0;
        for (h0 h0Var : this.D) {
            iN += h0Var.n();
        }
        return iN;
    }

    public final long v() {
        long j2;
        long jMax = Long.MIN_VALUE;
        for (h0 h0Var : this.D) {
            synchronized (h0Var) {
                j2 = h0Var.w;
            }
            jMax = Math.max(jMax, j2);
        }
        return jMax;
    }

    public final boolean w() {
        return this.S != -9223372036854775807L;
    }

    public final void x() {
        if (this.W || this.G || !this.F || this.J == null) {
            return;
        }
        for (h0 h0Var : this.D) {
            if (h0Var.m() == null) {
                return;
            }
        }
        this.f810x.a();
        int length = this.D.length;
        n0[] n0VarArr = new n0[length];
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            j1 j1VarM = this.D[i].m();
            Objects.requireNonNull(j1VarM);
            String str = j1VarM.w;
            boolean zH = b.i.a.c.f3.t.h(str);
            boolean z2 = zH || b.i.a.c.f3.t.j(str);
            zArr[i] = z2;
            this.H = z2 | this.H;
            IcyHeaders icyHeaders = this.C;
            if (icyHeaders != null) {
                if (zH || this.E[i].f815b) {
                    Metadata metadata = j1VarM.u;
                    Metadata metadata2 = metadata == null ? new Metadata(icyHeaders) : metadata.a(icyHeaders);
                    j1$b j1_bA = j1VarM.a();
                    j1_bA.i = metadata2;
                    j1VarM = j1_bA.a();
                }
                if (zH && j1VarM.q == -1 && j1VarM.r == -1 && icyHeaders.j != -1) {
                    j1$b j1_bA2 = j1VarM.a();
                    j1_bA2.f = icyHeaders.j;
                    j1VarM = j1_bA2.a();
                }
            }
            int iD = this.n.d(j1VarM);
            j1$b j1_bA3 = j1VarM.a();
            j1_bA3.D = iD;
            n0VarArr[i] = new n0(j1_bA3.a());
        }
        this.I = new e0$e(new o0(n0VarArr), zArr);
        this.G = true;
        x$a x_a = this.B;
        Objects.requireNonNull(x_a);
        x_a.b(this);
    }

    public final void y(int i) {
        t();
        e0$e e0_e = this.I;
        boolean[] zArr = e0_e.d;
        if (zArr[i]) {
            return;
        }
        j1 j1Var = e0_e.a.l[i].l[0];
        b0$a b0_a = this.p;
        b0_a.b(new w(1, b.i.a.c.f3.t.g(j1Var.w), j1Var, 0, null, b0_a.a(this.R), -9223372036854775807L));
        zArr[i] = true;
    }

    public final void z(int i) {
        t();
        boolean[] zArr = this.I.f816b;
        if (this.T && zArr[i] && !this.D[i].p(false)) {
            this.S = 0L;
            this.T = false;
            this.O = true;
            this.R = 0L;
            this.U = 0;
            for (h0 h0Var : this.D) {
                h0Var.s(false);
            }
            x$a x_a = this.B;
            Objects.requireNonNull(x_a);
            x_a.a(this);
        }
    }
}
