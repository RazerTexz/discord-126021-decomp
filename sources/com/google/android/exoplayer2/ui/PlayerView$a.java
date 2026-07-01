package com.google.android.exoplayer2.ui;

import android.view.TextureView;
import android.view.View;
import android.view.View$OnClickListener;
import android.view.View$OnLayoutChangeListener;
import androidx.annotation.Nullable;
import b.i.a.c.a2;
import b.i.a.c.a3.o0;
import b.i.a.c.b3.b;
import b.i.a.c.c1;
import b.i.a.c.c3.n;
import b.i.a.c.g3.y;
import b.i.a.c.o1;
import b.i.a.c.o2;
import b.i.a.c.o2$b;
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
public final class PlayerView$a implements y1$e, View$OnLayoutChangeListener, View$OnClickListener, PlayerControlView$e {
    public final o2$b j = new o2$b();

    @Nullable
    public Object k;
    public final /* synthetic */ PlayerView l;

    public PlayerView$a(PlayerView playerView) {
        this.l = playerView;
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
    public /* synthetic */ void E(y1 y1Var, y1$d y1_d) {
        a2.e(this, y1Var, y1_d);
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
    public void W(boolean z2, int i) {
        PlayerView playerView = this.l;
        int i2 = PlayerView.j;
        playerView.l();
        PlayerView playerView2 = this.l;
        if (playerView2.e() && playerView2.H) {
            playerView2.d();
        } else {
            playerView2.f(false);
        }
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
    public void c() {
        View view = this.l.m;
        if (view != null) {
            view.setVisibility(4);
        }
    }

    @Override // b.i.a.c.y1$e
    public /* synthetic */ void d(boolean z2) {
        a2.u(this, z2);
    }

    @Override // b.i.a.c.y1$e
    public void e(List<b> list) {
        SubtitleView subtitleView = this.l.q;
        if (subtitleView != null) {
            subtitleView.setCues(list);
        }
    }

    @Override // b.i.a.c.y1$e
    public void f(y yVar) {
        PlayerView playerView = this.l;
        int i = PlayerView.j;
        playerView.k();
    }

    @Override // b.i.a.c.y1$c
    public /* synthetic */ void f0(PlaybackException playbackException) {
        a2.p(this, playbackException);
    }

    @Override // b.i.a.c.y1$c
    public void g(y1$f y1_f, y1$f y1_f2, int i) {
        PlayerView playerView = this.l;
        int i2 = PlayerView.j;
        if (playerView.e()) {
            PlayerView playerView2 = this.l;
            if (playerView2.H) {
                playerView2.d();
            }
        }
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

    @Override // com.google.android.exoplayer2.ui.PlayerControlView$e
    public void k(int i) {
        PlayerView playerView = this.l;
        int i2 = PlayerView.j;
        playerView.m();
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        PlayerView playerView = this.l;
        int i = PlayerView.j;
        playerView.j();
    }

    @Override // android.view.View$OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        PlayerView.a((TextureView) view, this.l.J);
    }

    @Override // b.i.a.c.y1$c
    public void p(p2 p2Var) {
        y1 y1Var = this.l.w;
        Objects.requireNonNull(y1Var);
        o2 o2VarK = y1Var.K();
        if (o2VarK.q()) {
            this.k = null;
        } else if (y1Var.H().k.isEmpty()) {
            Object obj = this.k;
            if (obj != null) {
                int iB = o2VarK.b(obj);
                if (iB != -1) {
                    if (y1Var.C() == o2VarK.f(iB, this.j).l) {
                        return;
                    }
                }
                this.k = null;
            }
        } else {
            this.k = o2VarK.g(y1Var.m(), this.j, true).k;
        }
        this.l.o(false);
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
    public void y(int i) {
        PlayerView playerView = this.l;
        int i2 = PlayerView.j;
        playerView.l();
        this.l.n();
        PlayerView playerView2 = this.l;
        if (playerView2.e() && playerView2.H) {
            playerView2.d();
        } else {
            playerView2.f(false);
        }
    }

    @Override // b.i.a.c.y1$e
    public /* synthetic */ void z(c1 c1Var) {
        a2.c(this, c1Var);
    }
}
