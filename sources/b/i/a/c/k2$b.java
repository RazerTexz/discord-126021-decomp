package b.i.a.c;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder$Callback;
import android.view.TextureView$SurfaceTextureListener;
import androidx.annotation.Nullable;
import b.i.a.c.g3.z.k$b;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: SimpleExoPlayer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k2$b implements b.i.a.c.g3.x, b.i.a.c.t2.r, b.i.a.c.b3.l, b.i.a.c.z2.e, SurfaceHolder$Callback, TextureView$SurfaceTextureListener, k$b, t0$b, s0$b, m2$b, y1$c, e1$a {
    public final /* synthetic */ k2 j;

    public k2$b(k2 k2Var, k2$a k2_a) {
        this.j = k2Var;
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void A(p1 p1Var) {
        z1.f(this, p1Var);
    }

    @Override // b.i.a.c.t2.r
    public void B(String str) {
        this.j.i.B(str);
    }

    @Override // b.i.a.c.t2.r
    public void C(String str, long j, long j2) {
        this.j.i.C(str, j, j2);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void D(boolean z2) {
        z1.p(this, z2);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void E(y1 y1Var, y1$d y1_d) {
        z1.b(this, y1Var, y1_d);
    }

    @Override // b.i.a.c.g3.x
    public void F(int i, long j) {
        this.j.i.F(i, j);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void H(boolean z2, int i) {
        z1.k(this, z2, i);
    }

    @Override // b.i.a.c.t2.r
    public void I(j1 j1Var, @Nullable b.i.a.c.v2.g gVar) {
        Objects.requireNonNull(this.j);
        this.j.i.I(j1Var, gVar);
    }

    @Override // b.i.a.c.g3.x
    public void K(Object obj, long j) {
        this.j.i.K(obj, j);
        k2 k2Var = this.j;
        if (k2Var.q == obj) {
            Iterator<y1$e> it = k2Var.h.iterator();
            while (it.hasNext()) {
                it.next().c();
            }
        }
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void L(int i) {
        z1.n(this, i);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void M(o1 o1Var, int i) {
        z1.e(this, o1Var, i);
    }

    @Override // b.i.a.c.t2.r
    public void N(Exception exc) {
        this.j.i.N(exc);
    }

    @Override // b.i.a.c.g3.x
    public /* synthetic */ void O(j1 j1Var) {
        b.i.a.c.g3.w.a(this, j1Var);
    }

    @Override // b.i.a.c.g3.x
    public void P(b.i.a.c.v2.e eVar) {
        Objects.requireNonNull(this.j);
        this.j.i.P(eVar);
    }

    @Override // b.i.a.c.g3.x
    public void Q(j1 j1Var, @Nullable b.i.a.c.v2.g gVar) {
        Objects.requireNonNull(this.j);
        this.j.i.Q(j1Var, gVar);
    }

    @Override // b.i.a.c.t2.r
    public void R(long j) {
        this.j.i.R(j);
    }

    @Override // b.i.a.c.t2.r
    public void T(Exception exc) {
        this.j.i.T(exc);
    }

    @Override // b.i.a.c.t2.r
    public /* synthetic */ void U(j1 j1Var) {
        b.i.a.c.t2.q.a(this, j1Var);
    }

    @Override // b.i.a.c.g3.x
    public void V(Exception exc) {
        this.j.i.V(exc);
    }

    @Override // b.i.a.c.y1$c
    public void W(boolean z2, int i) {
        k2.d0(this.j);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void Y(b.i.a.c.a3.o0 o0Var, b.i.a.c.c3.n nVar) {
        z1.r(this, o0Var, nVar);
    }

    @Override // b.i.a.c.g3.x
    public void Z(b.i.a.c.v2.e eVar) {
        this.j.i.Z(eVar);
        Objects.requireNonNull(this.j);
        Objects.requireNonNull(this.j);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void a() {
        z1.o(this);
    }

    @Override // b.i.a.c.z2.e
    public void b(Metadata metadata) {
        this.j.i.b(metadata);
        f1 f1Var = this.j.e;
        p1$b p1_bA = f1Var.E.a();
        int i = 0;
        while (true) {
            Metadata$Entry[] metadata$EntryArr = metadata.j;
            if (i >= metadata$EntryArr.length) {
                break;
            }
            metadata$EntryArr[i].n(p1_bA);
            i++;
        }
        f1Var.E = p1_bA.a();
        p1 p1VarE0 = f1Var.e0();
        if (!p1VarE0.equals(f1Var.D)) {
            f1Var.D = p1VarE0;
            b.i.a.c.f3.p<y1$c> pVar = f1Var.j;
            pVar.b(14, new j(f1Var));
            pVar.a();
        }
        Iterator<y1$e> it = this.j.h.iterator();
        while (it.hasNext()) {
            it.next().b(metadata);
        }
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void b0(x1 x1Var) {
        z1.g(this, x1Var);
    }

    @Override // b.i.a.c.t2.r
    public void d(boolean z2) {
        k2 k2Var = this.j;
        if (k2Var.C == z2) {
            return;
        }
        k2Var.C = z2;
        k2Var.i.d(z2);
        Iterator<y1$e> it = k2Var.h.iterator();
        while (it.hasNext()) {
            it.next().d(k2Var.C);
        }
    }

    @Override // b.i.a.c.b3.l
    public void e(List<b.i.a.c.b3.b> list) {
        k2 k2Var = this.j;
        k2Var.D = list;
        Iterator<y1$e> it = k2Var.h.iterator();
        while (it.hasNext()) {
            it.next().e(list);
        }
    }

    @Override // b.i.a.c.t2.r
    public void e0(int i, long j, long j2) {
        this.j.i.e0(i, j, j2);
    }

    @Override // b.i.a.c.g3.x
    public void f(b.i.a.c.g3.y yVar) {
        k2 k2Var = this.j;
        k2Var.I = yVar;
        k2Var.i.f(yVar);
        Iterator<y1$e> it = this.j.h.iterator();
        while (it.hasNext()) {
            it.next().f(yVar);
        }
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void f0(PlaybackException playbackException) {
        z1.j(this, playbackException);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void g(y1$f y1_f, y1$f y1_f2, int i) {
        z1.m(this, y1_f, y1_f2, i);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void h(int i) {
        z1.h(this, i);
    }

    @Override // b.i.a.c.g3.x
    public void h0(long j, int i) {
        this.j.i.h0(j, i);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void i(boolean z2) {
        z1.d(this, z2);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void j(int i) {
        z1.l(this, i);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void j0(boolean z2) {
        z1.c(this, z2);
    }

    @Override // b.i.a.c.t2.r
    public void k(b.i.a.c.v2.e eVar) {
        this.j.i.k(eVar);
        Objects.requireNonNull(this.j);
        Objects.requireNonNull(this.j);
    }

    @Override // b.i.a.c.g3.x
    public void l(String str) {
        this.j.i.l(str);
    }

    @Override // b.i.a.c.t2.r
    public void m(b.i.a.c.v2.e eVar) {
        Objects.requireNonNull(this.j);
        this.j.i.m(eVar);
    }

    @Override // b.i.a.c.g3.x
    public void n(String str, long j, long j2) {
        this.j.i.n(str, j, j2);
    }

    @Override // b.i.a.c.e1$a
    public void o(boolean z2) {
        k2.d0(this.j);
    }

    @Override // android.view.TextureView$SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        k2 k2Var = this.j;
        Objects.requireNonNull(k2Var);
        Surface surface = new Surface(surfaceTexture);
        k2Var.l0(surface);
        k2Var.r = surface;
        this.j.h0(i, i2);
    }

    @Override // android.view.TextureView$SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.j.l0(null);
        this.j.h0(0, 0);
        return true;
    }

    @Override // android.view.TextureView$SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.j.h0(i, i2);
    }

    @Override // android.view.TextureView$SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void p(p2 p2Var) {
        z1.s(this, p2Var);
    }

    @Override // b.i.a.c.g3.z.k$b
    public void q(Surface surface) {
        this.j.l0(null);
    }

    @Override // b.i.a.c.y1$c
    public void r(boolean z2) {
        Objects.requireNonNull(this.j);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void s(PlaybackException playbackException) {
        z1.i(this, playbackException);
    }

    @Override // android.view.SurfaceHolder$Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.j.h0(i2, i3);
    }

    @Override // android.view.SurfaceHolder$Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        k2 k2Var = this.j;
        if (k2Var.u) {
            k2Var.l0(surfaceHolder.getSurface());
        }
    }

    @Override // android.view.SurfaceHolder$Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        k2 k2Var = this.j;
        if (k2Var.u) {
            k2Var.l0(null);
        }
        this.j.h0(0, 0);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void t(y1$b y1_b) {
        z1.a(this, y1_b);
    }

    @Override // b.i.a.c.g3.z.k$b
    public void u(Surface surface) {
        this.j.l0(surface);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void v(o2 o2Var, int i) {
        z1.q(this, o2Var, i);
    }

    @Override // b.i.a.c.e1$a
    public /* synthetic */ void x(boolean z2) {
        d1.a(this, z2);
    }

    @Override // b.i.a.c.y1$c
    public void y(int i) {
        k2.d0(this.j);
    }
}
