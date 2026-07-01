package com.google.android.exoplayer2.ui;

import android.view.View;
import android.view.View$OnClickListener;
import android.widget.TextView;
import b.i.a.c.a2;
import b.i.a.c.a3.o0;
import b.i.a.c.c1;
import b.i.a.c.c3.n;
import b.i.a.c.d3.o;
import b.i.a.c.d3.o$a;
import b.i.a.c.f3.e0;
import b.i.a.c.g3.y;
import b.i.a.c.o1;
import b.i.a.c.o2;
import b.i.a.c.p1;
import b.i.a.c.p2;
import b.i.a.c.x1;
import b.i.a.c.y1;
import b.i.a.c.y1$b;
import b.i.a.c.y1$d;
import b.i.a.c.y1$e;
import b.i.a.c.y1$f;
import b.i.a.c.z1;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class PlayerControlView$c implements y1$e, o$a, View$OnClickListener {
    public final /* synthetic */ PlayerControlView j;

    public PlayerControlView$c(PlayerControlView playerControlView, PlayerControlView$a playerControlView$a) {
        this.j = playerControlView;
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void A(p1 p1Var) {
        a2.i(this, p1Var);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void D(boolean z2) {
        a2.t(this, z2);
    }

    @Override // b.i.a.c.y1$c
    public void E(y1 y1Var, y1$d y1_d) {
        if (y1_d.a(4, 5)) {
            PlayerControlView playerControlView = this.j;
            int i = PlayerControlView.j;
            playerControlView.m();
        }
        if (y1_d.a(4, 5, 7)) {
            PlayerControlView playerControlView2 = this.j;
            int i2 = PlayerControlView.j;
            playerControlView2.n();
        }
        if (y1_d.a.a.get(8)) {
            PlayerControlView playerControlView3 = this.j;
            int i3 = PlayerControlView.j;
            playerControlView3.o();
        }
        if (y1_d.a.a.get(9)) {
            PlayerControlView playerControlView4 = this.j;
            int i4 = PlayerControlView.j;
            playerControlView4.p();
        }
        if (y1_d.a(8, 9, 11, 0, 13)) {
            PlayerControlView playerControlView5 = this.j;
            int i5 = PlayerControlView.j;
            playerControlView5.l();
        }
        if (y1_d.a(11, 0)) {
            PlayerControlView playerControlView6 = this.j;
            int i6 = PlayerControlView.j;
            playerControlView6.q();
        }
    }

    @Override // b.i.a.c.y1$e
    public /* synthetic */ void G(int i, boolean z2) {
        a2.d(this, i, z2);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void H(boolean z2, int i) {
        z1.k(this, z2, i);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void L(int i) {
        a2.s(this, i);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void M(o1 o1Var, int i) {
        a2.h(this, o1Var, i);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void W(boolean z2, int i) {
        a2.k(this, z2, i);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void Y(o0 o0Var, n nVar) {
        z1.r(this, o0Var, nVar);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void a() {
        z1.o(this);
    }

    @Override // b.i.a.c.y1$e
    public /* synthetic */ void a0(int i, int i2) {
        a2.v(this, i, i2);
    }

    @Override // b.i.a.c.y1$e
    public /* synthetic */ void b(Metadata metadata) {
        a2.j(this, metadata);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void b0(x1 x1Var) {
        a2.l(this, x1Var);
    }

    @Override // b.i.a.c.y1$e
    public /* synthetic */ void c() {
        a2.r(this);
    }

    @Override // b.i.a.c.y1$e
    public /* synthetic */ void d(boolean z2) {
        a2.u(this, z2);
    }

    @Override // b.i.a.c.y1$e
    public /* synthetic */ void e(List list) {
        a2.b(this, list);
    }

    @Override // b.i.a.c.y1$e
    public /* synthetic */ void f(y yVar) {
        a2.y(this, yVar);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void f0(PlaybackException playbackException) {
        a2.p(this, playbackException);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void g(y1$f y1_f, y1$f y1_f2, int i) {
        a2.q(this, y1_f, y1_f2, i);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void h(int i) {
        a2.n(this, i);
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
        a2.g(this, z2);
    }

    @Override // b.i.a.c.d3.o$a
    public void k(o oVar, long j) {
        PlayerControlView playerControlView = this.j;
        TextView textView = playerControlView.w;
        if (textView != null) {
            textView.setText(e0.u(playerControlView.f2970y, playerControlView.f2971z, j));
        }
    }

    @Override // b.i.a.c.d3.o$a
    public void l(o oVar, long j, boolean z2) {
        y1 y1Var;
        PlayerControlView playerControlView = this.j;
        int iC = 0;
        playerControlView.V = false;
        if (z2 || (y1Var = playerControlView.Q) == null) {
            return;
        }
        o2 o2VarK = y1Var.K();
        if (playerControlView.U && !o2VarK.q()) {
            int iP = o2VarK.p();
            while (true) {
                long jB = o2VarK.n(iC, playerControlView.B).b();
                if (j < jB) {
                    break;
                }
                if (iC == iP - 1) {
                    j = jB;
                    break;
                } else {
                    j -= jB;
                    iC++;
                }
            }
        } else {
            iC = y1Var.C();
        }
        y1Var.h(iC, j);
        playerControlView.n();
    }

    @Override // b.i.a.c.d3.o$a
    public void m(o oVar, long j) {
        PlayerControlView playerControlView = this.j;
        playerControlView.V = true;
        TextView textView = playerControlView.w;
        if (textView != null) {
            textView.setText(e0.u(playerControlView.f2970y, playerControlView.f2971z, j));
        }
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        PlayerControlView playerControlView = this.j;
        y1 y1Var = playerControlView.Q;
        if (y1Var == null) {
            return;
        }
        if (playerControlView.n == view) {
            y1Var.O();
            return;
        }
        if (playerControlView.m == view) {
            y1Var.s();
            return;
        }
        if (playerControlView.q == view) {
            if (y1Var.y() != 4) {
                y1Var.P();
                return;
            }
            return;
        }
        if (playerControlView.r == view) {
            y1Var.R();
            return;
        }
        if (playerControlView.o == view) {
            playerControlView.b(y1Var);
            return;
        }
        if (playerControlView.p == view) {
            Objects.requireNonNull(playerControlView);
            y1Var.d();
            return;
        }
        if (playerControlView.f2968s != view) {
            if (playerControlView.t == view) {
                y1Var.k(!y1Var.M());
                return;
            }
            return;
        }
        int I = y1Var.I();
        int i = this.j.f2959b0;
        for (int i2 = 1; i2 <= 2; i2++) {
            int i3 = (I + i2) % 3;
            boolean z2 = false;
            if (i3 == 0 || (i3 == 1 ? (i & 1) != 0 : !(i3 != 2 || (i & 2) == 0))) {
                z2 = true;
            }
            if (z2) {
                I = i3;
                break;
            }
        }
        y1Var.E(I);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void p(p2 p2Var) {
        a2.x(this, p2Var);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void r(boolean z2) {
        a2.f(this, z2);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void s(PlaybackException playbackException) {
        a2.o(this, playbackException);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void t(y1$b y1_b) {
        a2.a(this, y1_b);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void v(o2 o2Var, int i) {
        a2.w(this, o2Var, i);
    }

    @Override // b.i.a.c.y1$e
    public /* synthetic */ void w(float f) {
        a2.z(this, f);
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void y(int i) {
        a2.m(this, i);
    }

    @Override // b.i.a.c.y1$e
    public /* synthetic */ void z(c1 c1Var) {
        a2.c(this, c1Var);
    }
}
