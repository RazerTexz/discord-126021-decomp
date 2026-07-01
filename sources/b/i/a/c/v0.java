package b.i.a.c;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: BaseRenderer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class v0 implements f2, g2 {
    public final int j;

    @Nullable
    public h2 l;
    public int m;
    public int n;

    @Nullable
    public b.i.a.c.a3.i0 o;

    @Nullable
    public j1[] p;
    public long q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1140s;
    public boolean t;
    public final k1 k = new k1();
    public long r = Long.MIN_VALUE;

    public v0(int i) {
        this.j = i;
    }

    public final k1 A() {
        this.k.a();
        return this.k;
    }

    public abstract void B();

    public void C(boolean z2, boolean z3) throws ExoPlaybackException {
    }

    public abstract void D(long j, boolean z2) throws ExoPlaybackException;

    public void E() {
    }

    public void F() throws ExoPlaybackException {
    }

    public void G() {
    }

    public abstract void H(j1[] j1VarArr, long j, long j2) throws ExoPlaybackException;

    public final int I(k1 k1Var, DecoderInputBuffer decoderInputBuffer, int i) {
        b.i.a.c.a3.i0 i0Var = this.o;
        Objects.requireNonNull(i0Var);
        int iA = i0Var.a(k1Var, decoderInputBuffer, i);
        if (iA == -4) {
            if (decoderInputBuffer.n()) {
                this.r = Long.MIN_VALUE;
                return this.f1140s ? -4 : -3;
            }
            long j = decoderInputBuffer.n + this.q;
            decoderInputBuffer.n = j;
            this.r = Math.max(this.r, j);
        } else if (iA == -5) {
            j1 j1Var = k1Var.f1027b;
            Objects.requireNonNull(j1Var);
            if (j1Var.A != RecyclerView.FOREVER_NS) {
                j1$b j1_bA = j1Var.a();
                j1_bA.o = j1Var.A + this.q;
                k1Var.f1027b = j1_bA.a();
            }
        }
        return iA;
    }

    @Override // b.i.a.c.f2
    public final void f(int i) {
        this.m = i;
    }

    @Override // b.i.a.c.f2
    public final void g() {
        b.c.a.a0.d.D(this.n == 1);
        this.k.a();
        this.n = 0;
        this.o = null;
        this.p = null;
        this.f1140s = false;
        B();
    }

    @Override // b.i.a.c.f2
    public final int getState() {
        return this.n;
    }

    @Override // b.i.a.c.f2
    @Nullable
    public final b.i.a.c.a3.i0 h() {
        return this.o;
    }

    @Override // b.i.a.c.f2
    public final boolean j() {
        return this.r == Long.MIN_VALUE;
    }

    @Override // b.i.a.c.f2
    public final void k(j1[] j1VarArr, b.i.a.c.a3.i0 i0Var, long j, long j2) throws ExoPlaybackException {
        b.c.a.a0.d.D(!this.f1140s);
        this.o = i0Var;
        if (this.r == Long.MIN_VALUE) {
            this.r = j;
        }
        this.p = j1VarArr;
        this.q = j2;
        H(j1VarArr, j, j2);
    }

    @Override // b.i.a.c.f2
    public final void l() {
        this.f1140s = true;
    }

    @Override // b.i.a.c.f2
    public final g2 m() {
        return this;
    }

    @Override // b.i.a.c.f2
    public /* synthetic */ void n(float f, float f2) throws ExoPlaybackException {
        e2.a(this, f, f2);
    }

    @Override // b.i.a.c.f2
    public final void o(h2 h2Var, j1[] j1VarArr, b.i.a.c.a3.i0 i0Var, long j, boolean z2, boolean z3, long j2, long j3) throws ExoPlaybackException {
        b.c.a.a0.d.D(this.n == 0);
        this.l = h2Var;
        this.n = 1;
        C(z2, z3);
        k(j1VarArr, i0Var, j2, j3);
        D(j, z2);
    }

    @Override // b.i.a.c.g2
    public int p() throws ExoPlaybackException {
        return 0;
    }

    @Override // b.i.a.c.b2$b
    public void r(int i, @Nullable Object obj) throws ExoPlaybackException {
    }

    @Override // b.i.a.c.f2
    public final void reset() {
        b.c.a.a0.d.D(this.n == 0);
        this.k.a();
        E();
    }

    @Override // b.i.a.c.f2
    public final void s() throws IOException {
        b.i.a.c.a3.i0 i0Var = this.o;
        Objects.requireNonNull(i0Var);
        i0Var.b();
    }

    @Override // b.i.a.c.f2
    public final void start() throws ExoPlaybackException {
        b.c.a.a0.d.D(this.n == 1);
        this.n = 2;
        F();
    }

    @Override // b.i.a.c.f2
    public final void stop() {
        b.c.a.a0.d.D(this.n == 2);
        this.n = 1;
        G();
    }

    @Override // b.i.a.c.f2
    public final long t() {
        return this.r;
    }

    @Override // b.i.a.c.f2
    public final void u(long j) throws ExoPlaybackException {
        this.f1140s = false;
        this.r = j;
        D(j, false);
    }

    @Override // b.i.a.c.f2
    public final boolean v() {
        return this.f1140s;
    }

    @Override // b.i.a.c.f2
    @Nullable
    public b.i.a.c.f3.s w() {
        return null;
    }

    @Override // b.i.a.c.f2
    public final int x() {
        return this.j;
    }

    public final ExoPlaybackException y(Throwable th, @Nullable j1 j1Var, int i) {
        return z(th, j1Var, false, i);
    }

    public final ExoPlaybackException z(Throwable th, @Nullable j1 j1Var, boolean z2, int i) {
        int iA;
        if (j1Var == null || this.t) {
            iA = 4;
        } else {
            this.t = true;
            try {
                iA = a(j1Var) & 7;
                this.t = false;
            } catch (ExoPlaybackException unused) {
                this.t = false;
                iA = 4;
            } catch (Throwable th2) {
                this.t = false;
                throw th2;
            }
        }
        return new ExoPlaybackException(1, th, null, i, getName(), this.m, j1Var, j1Var == null ? 4 : iA, z2);
    }
}
