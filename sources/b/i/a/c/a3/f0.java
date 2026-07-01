package b.i.a.c.a3;

import androidx.annotation.Nullable;
import b.i.a.c.e3.l$a;
import b.i.a.c.o1;
import b.i.a.c.o1$h;
import b.i.a.c.o2;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader$d;
import com.google.android.exoplayer2.upstream.Loader$e;
import com.google.android.exoplayer2.upstream.Loader$g;
import java.util.Objects;

/* JADX INFO: compiled from: ProgressiveMediaSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f0 extends l implements e0$b {
    public final o1 g;
    public final o1$h h;
    public final l$a i;
    public final d0$a j;
    public final b.i.a.c.w2.u k;
    public final b.i.a.c.e3.w l;
    public final int m;
    public boolean n;
    public long o;
    public boolean p;
    public boolean q;

    @Nullable
    public b.i.a.c.e3.a0 r;

    public f0(o1 o1Var, l$a l_a, d0$a d0_a, b.i.a.c.w2.u uVar, b.i.a.c.e3.w wVar, int i, f0$a f0_a) {
        o1$h o1_h = o1Var.l;
        Objects.requireNonNull(o1_h);
        this.h = o1_h;
        this.g = o1Var;
        this.i = l_a;
        this.j = d0_a;
        this.k = uVar;
        this.l = wVar;
        this.m = i;
        this.n = true;
        this.o = -9223372036854775807L;
    }

    @Override // b.i.a.c.a3.a0
    public o1 e() {
        return this.g;
    }

    @Override // b.i.a.c.a3.a0
    public void h() {
    }

    @Override // b.i.a.c.a3.a0
    public void j(x xVar) {
        e0 e0Var = (e0) xVar;
        if (e0Var.G) {
            for (h0 h0Var : e0Var.D) {
                h0Var.h();
                DrmSession drmSession = h0Var.i;
                if (drmSession != null) {
                    drmSession.b(h0Var.e);
                    h0Var.i = null;
                    h0Var.h = null;
                }
            }
        }
        Loader loader = e0Var.v;
        Loader$d<? extends Loader$e> loader$d = loader.d;
        if (loader$d != null) {
            loader$d.a(true);
        }
        loader.c.execute(new Loader$g(e0Var));
        loader.c.shutdown();
        e0Var.A.removeCallbacksAndMessages(null);
        e0Var.B = null;
        e0Var.W = true;
    }

    @Override // b.i.a.c.a3.a0
    public x n(a0$a a0_a, b.i.a.c.e3.o oVar, long j) {
        b.i.a.c.e3.l lVarA = this.i.a();
        b.i.a.c.e3.a0 a0Var = this.r;
        if (a0Var != null) {
            lVarA.d(a0Var);
        }
        return new e0(this.h.a, lVarA, new m(((j) this.j).a), this.k, this.d.g(0, a0_a), this.l, this.c.g(0, a0_a, 0L), this, oVar, this.h.e, this.m);
    }

    @Override // b.i.a.c.a3.l
    public void q(@Nullable b.i.a.c.e3.a0 a0Var) {
        this.r = a0Var;
        this.k.a();
        t();
    }

    @Override // b.i.a.c.a3.l
    public void s() {
        this.k.release();
    }

    public final void t() {
        o2 l0Var = new l0(this.o, this.p, false, this.q, null, this.g);
        if (this.n) {
            l0Var = new f0$a(l0Var);
        }
        r(l0Var);
    }

    public void u(long j, boolean z2, boolean z3) {
        if (j == -9223372036854775807L) {
            j = this.o;
        }
        if (!this.n && this.o == j && this.p == z2 && this.q == z3) {
            return;
        }
        this.o = j;
        this.p = z2;
        this.q = z3;
        this.n = false;
        t();
    }
}
