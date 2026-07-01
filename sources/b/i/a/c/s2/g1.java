package b.i.a.c.s2;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import androidx.media.AudioAttributesCompat;
import b.i.a.c.a2;
import b.i.a.c.a3.a0$a;
import b.i.a.c.e3.f$a;
import b.i.a.c.j1;
import b.i.a.c.o1;
import b.i.a.c.o2;
import b.i.a.c.o2$b;
import b.i.a.c.o2$c;
import b.i.a.c.p1;
import b.i.a.c.p2;
import b.i.a.c.x1;
import b.i.a.c.y1;
import b.i.a.c.y1$b;
import b.i.a.c.y1$d;
import b.i.a.c.y1$e;
import b.i.a.c.y1$f;
import b.i.a.c.z1;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: AnalyticsCollector.java */
/* JADX INFO: loaded from: classes3.dex */
public class g1 implements y1$e, b.i.a.c.t2.r, b.i.a.c.g3.x, b.i.a.c.a3.b0, f$a, b.i.a.c.w2.s {
    public final b.i.a.c.f3.g j;
    public final o2$b k;
    public final o2$c l;
    public final g1$a m;
    public final SparseArray<h1$a> n;
    public b.i.a.c.f3.p<h1> o;
    public y1 p;
    public b.i.a.c.f3.o q;
    public boolean r;

    public g1(b.i.a.c.f3.g gVar) {
        this.j = gVar;
        this.o = new b.i.a.c.f3.p<>(new CopyOnWriteArraySet(), b.i.a.c.f3.e0.o(), gVar, o0.a);
        o2$b o2_b = new o2$b();
        this.k = o2_b;
        this.l = new o2$c();
        this.m = new g1$a(o2_b);
        this.n = new SparseArray<>();
    }

    @Override // b.i.a.c.y1$c
    public void A(p1 p1Var) {
        h1$a h1_aK0 = k0();
        r0 r0Var = new r0(h1_aK0, p1Var);
        this.n.put(14, h1_aK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(14, r0Var);
        pVar.a();
    }

    @Override // b.i.a.c.t2.r
    public final void B(String str) {
        h1$a h1_aP0 = p0();
        t tVar = new t(h1_aP0, str);
        this.n.put(PointerIconCompat.TYPE_ALL_SCROLL, h1_aP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_ALL_SCROLL, tVar);
        pVar.a();
    }

    @Override // b.i.a.c.t2.r
    public final void C(String str, long j, long j2) {
        h1$a h1_aP0 = p0();
        l0 l0Var = new l0(h1_aP0, str, j2, j);
        this.n.put(PointerIconCompat.TYPE_VERTICAL_TEXT, h1_aP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_VERTICAL_TEXT, l0Var);
        pVar.a();
    }

    @Override // b.i.a.c.y1$c
    public final void D(boolean z2) {
        h1$a h1_aK0 = k0();
        g0 g0Var = new g0(h1_aK0, z2);
        this.n.put(9, h1_aK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(9, g0Var);
        pVar.a();
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void E(y1 y1Var, y1$d y1_d) {
        a2.e(this, y1Var, y1_d);
    }

    @Override // b.i.a.c.g3.x
    public final void F(int i, long j) {
        h1$a h1_aO0 = o0();
        z zVar = new z(h1_aO0, i, j);
        this.n.put(AudioAttributesCompat.FLAG_ALL, h1_aO0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(AudioAttributesCompat.FLAG_ALL, zVar);
        pVar.a();
    }

    @Override // b.i.a.c.y1$e
    public /* synthetic */ void G(int i, boolean z2) {
        a2.d(this, i, z2);
    }

    @Override // b.i.a.c.y1$c
    public final void H(boolean z2, int i) {
        h1$a h1_aK0 = k0();
        j0 j0Var = new j0(h1_aK0, z2, i);
        this.n.put(-1, h1_aK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(-1, j0Var);
        pVar.a();
    }

    @Override // b.i.a.c.t2.r
    public final void I(j1 j1Var, @Nullable b.i.a.c.v2.g gVar) {
        h1$a h1_aP0 = p0();
        i0 i0Var = new i0(h1_aP0, j1Var, gVar);
        this.n.put(PointerIconCompat.TYPE_ALIAS, h1_aP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_ALIAS, i0Var);
        pVar.a();
    }

    @Override // b.i.a.c.w2.s
    public final void J(int i, @Nullable a0$a a0_a) {
        h1$a h1_aN0 = n0(i, a0_a);
        t0 t0Var = new t0(h1_aN0);
        this.n.put(1034, h1_aN0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1034, t0Var);
        pVar.a();
    }

    @Override // b.i.a.c.g3.x
    public final void K(Object obj, long j) {
        h1$a h1_aP0 = p0();
        f1 f1Var = new f1(h1_aP0, obj, j);
        this.n.put(1027, h1_aP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1027, f1Var);
        pVar.a();
    }

    @Override // b.i.a.c.y1$c
    public final void L(int i) {
        h1$a h1_aK0 = k0();
        b0 b0Var = new b0(h1_aK0, i);
        this.n.put(8, h1_aK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(8, b0Var);
        pVar.a();
    }

    @Override // b.i.a.c.y1$c
    public final void M(@Nullable o1 o1Var, int i) {
        h1$a h1_aK0 = k0();
        q qVar = new q(h1_aK0, o1Var, i);
        this.n.put(1, h1_aK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1, qVar);
        pVar.a();
    }

    @Override // b.i.a.c.t2.r
    public final void N(Exception exc) {
        h1$a h1_aP0 = p0();
        e0 e0Var = new e0(h1_aP0, exc);
        this.n.put(PointerIconCompat.TYPE_ZOOM_IN, h1_aP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_ZOOM_IN, e0Var);
        pVar.a();
    }

    @Override // b.i.a.c.g3.x
    public /* synthetic */ void O(j1 j1Var) {
        b.i.a.c.g3.w.a(this, j1Var);
    }

    @Override // b.i.a.c.g3.x
    public final void P(b.i.a.c.v2.e eVar) {
        h1$a h1_aP0 = p0();
        d0 d0Var = new d0(h1_aP0, eVar);
        this.n.put(PointerIconCompat.TYPE_GRAB, h1_aP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_GRAB, d0Var);
        pVar.a();
    }

    @Override // b.i.a.c.g3.x
    public final void Q(j1 j1Var, @Nullable b.i.a.c.v2.g gVar) {
        h1$a h1_aP0 = p0();
        y0 y0Var = new y0(h1_aP0, j1Var, gVar);
        this.n.put(1022, h1_aP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1022, y0Var);
        pVar.a();
    }

    @Override // b.i.a.c.t2.r
    public final void R(long j) {
        h1$a h1_aP0 = p0();
        n0 n0Var = new n0(h1_aP0, j);
        this.n.put(PointerIconCompat.TYPE_COPY, h1_aP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_COPY, n0Var);
        pVar.a();
    }

    @Override // b.i.a.c.w2.s
    public final void S(int i, @Nullable a0$a a0_a) {
        h1$a h1_aN0 = n0(i, a0_a);
        e1 e1Var = new e1(h1_aN0);
        this.n.put(1031, h1_aN0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1031, e1Var);
        pVar.a();
    }

    @Override // b.i.a.c.t2.r
    public final void T(Exception exc) {
        h1$a h1_aP0 = p0();
        k kVar = new k(h1_aP0, exc);
        this.n.put(1037, h1_aP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1037, kVar);
        pVar.a();
    }

    @Override // b.i.a.c.t2.r
    public /* synthetic */ void U(j1 j1Var) {
        b.i.a.c.t2.q.a(this, j1Var);
    }

    @Override // b.i.a.c.g3.x
    public final void V(Exception exc) {
        h1$a h1_aP0 = p0();
        q0 q0Var = new q0(h1_aP0, exc);
        this.n.put(1038, h1_aP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1038, q0Var);
        pVar.a();
    }

    @Override // b.i.a.c.y1$c
    public final void W(boolean z2, int i) {
        h1$a h1_aK0 = k0();
        d1 d1Var = new d1(h1_aK0, z2, i);
        this.n.put(5, h1_aK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(5, d1Var);
        pVar.a();
    }

    @Override // b.i.a.c.a3.b0
    public final void X(int i, @Nullable a0$a a0_a, b.i.a.c.a3.t tVar, b.i.a.c.a3.w wVar) {
        h1$a h1_aN0 = n0(i, a0_a);
        y yVar = new y(h1_aN0, tVar, wVar);
        this.n.put(PointerIconCompat.TYPE_CONTEXT_MENU, h1_aN0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_CONTEXT_MENU, yVar);
        pVar.a();
    }

    @Override // b.i.a.c.y1$c
    public final void Y(b.i.a.c.a3.o0 o0Var, b.i.a.c.c3.n nVar) {
        h1$a h1_aK0 = k0();
        i iVar = new i(h1_aK0, o0Var, nVar);
        this.n.put(2, h1_aK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(2, iVar);
        pVar.a();
    }

    @Override // b.i.a.c.g3.x
    public final void Z(b.i.a.c.v2.e eVar) {
        h1$a h1_aO0 = o0();
        j jVar = new j(h1_aO0, eVar);
        this.n.put(InputDeviceCompat.SOURCE_GAMEPAD, h1_aO0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(InputDeviceCompat.SOURCE_GAMEPAD, jVar);
        pVar.a();
    }

    @Override // b.i.a.c.y1$c
    public final void a() {
        h1$a h1_aK0 = k0();
        u uVar = new u(h1_aK0);
        this.n.put(-1, h1_aK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(-1, uVar);
        pVar.a();
    }

    @Override // b.i.a.c.y1$e
    public void a0(int i, int i2) {
        h1$a h1_aP0 = p0();
        n nVar = new n(h1_aP0, i, i2);
        this.n.put(1029, h1_aP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1029, nVar);
        pVar.a();
    }

    @Override // b.i.a.c.y1$e
    public final void b(Metadata metadata) {
        h1$a h1_aK0 = k0();
        v vVar = new v(h1_aK0, metadata);
        this.n.put(PointerIconCompat.TYPE_CROSSHAIR, h1_aK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_CROSSHAIR, vVar);
        pVar.a();
    }

    @Override // b.i.a.c.y1$c
    public final void b0(x1 x1Var) {
        h1$a h1_aK0 = k0();
        m mVar = new m(h1_aK0, x1Var);
        this.n.put(12, h1_aK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(12, mVar);
        pVar.a();
    }

    @Override // b.i.a.c.y1$e
    public /* synthetic */ void c() {
        a2.r(this);
    }

    @Override // b.i.a.c.w2.s
    public final void c0(int i, @Nullable a0$a a0_a, int i2) {
        h1$a h1_aN0 = n0(i, a0_a);
        p0 p0Var = new p0(h1_aN0, i2);
        this.n.put(1030, h1_aN0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1030, p0Var);
        pVar.a();
    }

    @Override // b.i.a.c.y1$e
    public final void d(boolean z2) {
        h1$a h1_aP0 = p0();
        u0 u0Var = new u0(h1_aP0, z2);
        this.n.put(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, h1_aP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, u0Var);
        pVar.a();
    }

    @Override // b.i.a.c.w2.s
    public final void d0(int i, @Nullable a0$a a0_a) {
        h1$a h1_aN0 = n0(i, a0_a);
        b bVar = new b(h1_aN0);
        this.n.put(1035, h1_aN0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1035, bVar);
        pVar.a();
    }

    @Override // b.i.a.c.y1$e
    public /* synthetic */ void e(List list) {
        a2.b(this, list);
    }

    @Override // b.i.a.c.t2.r
    public final void e0(int i, long j, long j2) {
        h1$a h1_aP0 = p0();
        c0 c0Var = new c0(h1_aP0, i, j, j2);
        this.n.put(PointerIconCompat.TYPE_NO_DROP, h1_aP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_NO_DROP, c0Var);
        pVar.a();
    }

    @Override // b.i.a.c.y1$e
    public final void f(b.i.a.c.g3.y yVar) {
        h1$a h1_aP0 = p0();
        m0 m0Var = new m0(h1_aP0, yVar);
        this.n.put(1028, h1_aP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1028, m0Var);
        pVar.a();
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void f0(PlaybackException playbackException) {
        a2.p(this, playbackException);
    }

    @Override // b.i.a.c.y1$c
    public final void g(y1$f y1_f, y1$f y1_f2, int i) {
        if (i == 1) {
            this.r = false;
        }
        g1$a g1_a = this.m;
        y1 y1Var = this.p;
        Objects.requireNonNull(y1Var);
        g1_a.d = g1$a.b(y1Var, g1_a.f1081b, g1_a.e, g1_a.a);
        h1$a h1_aK0 = k0();
        r rVar = new r(h1_aK0, i, y1_f, y1_f2);
        this.n.put(11, h1_aK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(11, rVar);
        pVar.a();
    }

    @Override // b.i.a.c.a3.b0
    public final void g0(int i, @Nullable a0$a a0_a, b.i.a.c.a3.t tVar, b.i.a.c.a3.w wVar, IOException iOException, boolean z2) {
        h1$a h1_aN0 = n0(i, a0_a);
        f0 f0Var = new f0(h1_aN0, tVar, wVar, iOException, z2);
        this.n.put(PointerIconCompat.TYPE_HELP, h1_aN0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_HELP, f0Var);
        pVar.a();
    }

    @Override // b.i.a.c.y1$c
    public final void h(int i) {
        h1$a h1_aK0 = k0();
        b1 b1Var = new b1(h1_aK0, i);
        this.n.put(6, h1_aK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(6, b1Var);
        pVar.a();
    }

    @Override // b.i.a.c.g3.x
    public final void h0(long j, int i) {
        h1$a h1_aO0 = o0();
        c1 c1Var = new c1(h1_aO0, j, i);
        this.n.put(1026, h1_aO0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1026, c1Var);
        pVar.a();
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void i(boolean z2) {
        z1.d(this, z2);
    }

    @Override // b.i.a.c.w2.s
    public final void i0(int i, @Nullable a0$a a0_a) {
        h1$a h1_aN0 = n0(i, a0_a);
        v0 v0Var = new v0(h1_aN0);
        this.n.put(1033, h1_aN0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1033, v0Var);
        pVar.a();
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void j(int i) {
        z1.l(this, i);
    }

    @Override // b.i.a.c.y1$c
    public void j0(boolean z2) {
        h1$a h1_aK0 = k0();
        z0 z0Var = new z0(h1_aK0, z2);
        this.n.put(7, h1_aK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(7, z0Var);
        pVar.a();
    }

    @Override // b.i.a.c.t2.r
    public final void k(b.i.a.c.v2.e eVar) {
        h1$a h1_aO0 = o0();
        w0 w0Var = new w0(h1_aO0, eVar);
        this.n.put(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, h1_aO0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, w0Var);
        pVar.a();
    }

    public final h1$a k0() {
        return m0(this.m.d);
    }

    @Override // b.i.a.c.g3.x
    public final void l(String str) {
        h1$a h1_aP0 = p0();
        f fVar = new f(h1_aP0, str);
        this.n.put(1024, h1_aP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1024, fVar);
        pVar.a();
    }

    @RequiresNonNull({"player"})
    public final h1$a l0(o2 o2Var, int i, @Nullable a0$a a0_a) {
        long jW;
        a0$a a0_a2 = o2Var.q() ? null : a0_a;
        long jD = this.j.d();
        boolean z2 = false;
        boolean z3 = o2Var.equals(this.p.K()) && i == this.p.C();
        long jA = 0;
        if (a0_a2 == null || !a0_a2.a()) {
            if (z3) {
                jW = this.p.w();
            } else if (!o2Var.q()) {
                jA = o2Var.o(i, this.l, 0L).a();
            }
            return new h1$a(jD, o2Var, i, a0_a2, jW, this.p.K(), this.p.C(), this.m.d, this.p.T(), this.p.g());
        }
        if (z3 && this.p.B() == a0_a2.f835b && this.p.q() == a0_a2.c) {
            z2 = true;
        }
        if (z2) {
            jA = this.p.T();
        }
        jW = jA;
        return new h1$a(jD, o2Var, i, a0_a2, jW, this.p.K(), this.p.C(), this.m.d, this.p.T(), this.p.g());
    }

    @Override // b.i.a.c.t2.r
    public final void m(b.i.a.c.v2.e eVar) {
        h1$a h1_aP0 = p0();
        l lVar = new l(h1_aP0, eVar);
        this.n.put(PointerIconCompat.TYPE_TEXT, h1_aP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_TEXT, lVar);
        pVar.a();
    }

    public final h1$a m0(@Nullable a0$a a0_a) {
        Objects.requireNonNull(this.p);
        o2 o2Var = a0_a == null ? null : this.m.c.get(a0_a);
        if (a0_a != null && o2Var != null) {
            return l0(o2Var, o2Var.h(a0_a.a, this.k).l, a0_a);
        }
        int iC = this.p.C();
        o2 o2VarK = this.p.K();
        if (!(iC < o2VarK.p())) {
            o2VarK = o2.j;
        }
        return l0(o2VarK, iC, null);
    }

    @Override // b.i.a.c.g3.x
    public final void n(String str, long j, long j2) {
        h1$a h1_aP0 = p0();
        d dVar = new d(h1_aP0, str, j2, j);
        this.n.put(PointerIconCompat.TYPE_GRABBING, h1_aP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_GRABBING, dVar);
        pVar.a();
    }

    public final h1$a n0(int i, @Nullable a0$a a0_a) {
        Objects.requireNonNull(this.p);
        if (a0_a != null) {
            return this.m.c.get(a0_a) != null ? m0(a0_a) : l0(o2.j, i, a0_a);
        }
        o2 o2VarK = this.p.K();
        if (!(i < o2VarK.p())) {
            o2VarK = o2.j;
        }
        return l0(o2VarK, i, null);
    }

    @Override // b.i.a.c.a3.b0
    public final void o(int i, @Nullable a0$a a0_a, b.i.a.c.a3.w wVar) {
        h1$a h1_aN0 = n0(i, a0_a);
        g gVar = new g(h1_aN0, wVar);
        this.n.put(PointerIconCompat.TYPE_WAIT, h1_aN0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_WAIT, gVar);
        pVar.a();
    }

    public final h1$a o0() {
        return m0(this.m.e);
    }

    @Override // b.i.a.c.y1$c
    public void p(p2 p2Var) {
        h1$a h1_aK0 = k0();
        w wVar = new w(h1_aK0, p2Var);
        this.n.put(2, h1_aK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(2, wVar);
        pVar.a();
    }

    public final h1$a p0() {
        return m0(this.m.f);
    }

    @Override // b.i.a.c.a3.b0
    public final void q(int i, @Nullable a0$a a0_a, b.i.a.c.a3.t tVar, b.i.a.c.a3.w wVar) {
        h1$a h1_aN0 = n0(i, a0_a);
        h0 h0Var = new h0(h1_aN0, tVar, wVar);
        this.n.put(PointerIconCompat.TYPE_HAND, h1_aN0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_HAND, h0Var);
        pVar.a();
    }

    @Override // b.i.a.c.y1$c
    public final void r(boolean z2) {
        h1$a h1_aK0 = k0();
        e eVar = new e(h1_aK0, z2);
        this.n.put(3, h1_aK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(3, eVar);
        pVar.a();
    }

    @Override // b.i.a.c.y1$c
    public final void s(PlaybackException playbackException) {
        b.i.a.c.a3.y yVar;
        h1$a h1_aM0 = (!(playbackException instanceof ExoPlaybackException) || (yVar = ((ExoPlaybackException) playbackException).mediaPeriodId) == null) ? null : m0(new a0$a(yVar));
        if (h1_aM0 == null) {
            h1_aM0 = k0();
        }
        a aVar = new a(h1_aM0, playbackException);
        this.n.put(10, h1_aM0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(10, aVar);
        pVar.a();
    }

    @Override // b.i.a.c.y1$c
    public void t(y1$b y1_b) {
        h1$a h1_aK0 = k0();
        a0 a0Var = new a0(h1_aK0, y1_b);
        this.n.put(13, h1_aK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(13, a0Var);
        pVar.a();
    }

    @Override // b.i.a.c.w2.s
    public final void u(int i, @Nullable a0$a a0_a, Exception exc) {
        h1$a h1_aN0 = n0(i, a0_a);
        c cVar = new c(h1_aN0, exc);
        this.n.put(1032, h1_aN0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1032, cVar);
        pVar.a();
    }

    @Override // b.i.a.c.y1$c
    public final void v(o2 o2Var, int i) {
        g1$a g1_a = this.m;
        y1 y1Var = this.p;
        Objects.requireNonNull(y1Var);
        g1_a.d = g1$a.b(y1Var, g1_a.f1081b, g1_a.e, g1_a.a);
        g1_a.d(y1Var.K());
        h1$a h1_aK0 = k0();
        x xVar = new x(h1_aK0, i);
        this.n.put(0, h1_aK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(0, xVar);
        pVar.a();
    }

    @Override // b.i.a.c.y1$e
    public final void w(float f) {
        h1$a h1_aP0 = p0();
        s sVar = new s(h1_aP0, f);
        this.n.put(PointerIconCompat.TYPE_ZOOM_OUT, h1_aP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_ZOOM_OUT, sVar);
        pVar.a();
    }

    @Override // b.i.a.c.a3.b0
    public final void x(int i, @Nullable a0$a a0_a, b.i.a.c.a3.t tVar, b.i.a.c.a3.w wVar) {
        h1$a h1_aN0 = n0(i, a0_a);
        k0 k0Var = new k0(h1_aN0, tVar, wVar);
        this.n.put(1000, h1_aN0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1000, k0Var);
        pVar.a();
    }

    @Override // b.i.a.c.y1$c
    public final void y(int i) {
        h1$a h1_aK0 = k0();
        a1 a1Var = new a1(h1_aK0, i);
        this.n.put(4, h1_aK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(4, a1Var);
        pVar.a();
    }

    @Override // b.i.a.c.y1$e
    public /* synthetic */ void z(b.i.a.c.c1 c1Var) {
        a2.c(this, c1Var);
    }
}
