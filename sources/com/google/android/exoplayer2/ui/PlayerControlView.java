package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.DeviceInfo2;
import b.i.a.c.ExoPlayerLibraryInfo;
import b.i.a.c.MediaItem2;
import b.i.a.c.MediaMetadata;
import b.i.a.c.PlaybackParameters;
import b.i.a.c.Player;
import b.i.a.c.Player2;
import b.i.a.c.Player3;
import b.i.a.c.Timeline;
import b.i.a.c.TracksInfo;
import b.i.a.c.a3.TrackGroupArray;
import b.i.a.c.a3.p0.AdPlaybackState;
import b.i.a.c.c3.TrackSelectionArray;
import b.i.a.c.d3.TimeBar;
import b.i.a.c.f3.Util2;
import b.i.a.c.g3.VideoSize;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.ui.PlayerControlView;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class PlayerControlView extends FrameLayout {
    public static final /* synthetic */ int j = 0;
    public final Timeline.b A;
    public final Timeline.c B;
    public final Runnable C;
    public final Runnable D;
    public final Drawable E;
    public final Drawable F;
    public final Drawable G;
    public final String H;
    public final String I;
    public final String J;
    public final Drawable K;
    public final Drawable L;
    public final float M;
    public final float N;
    public final String O;
    public final String P;

    @Nullable
    public Player2 Q;

    @Nullable
    public d R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public int W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f2958a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f2959b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f2960c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f2961d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f2962e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f2963f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public boolean f2964g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public long f2965h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public long[] f2966i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean[] f2967j0;
    public final c k;
    public long[] k0;
    public final CopyOnWriteArrayList<e> l;
    public boolean[] l0;

    @Nullable
    public final View m;
    public long m0;

    @Nullable
    public final View n;
    public long n0;

    @Nullable
    public final View o;
    public long o0;

    @Nullable
    public final View p;

    @Nullable
    public final View q;

    @Nullable
    public final View r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public final ImageView f2968s;

    @Nullable
    public final ImageView t;

    @Nullable
    public final View u;

    @Nullable
    public final TextView v;

    @Nullable
    public final TextView w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public final TimeBar f2969x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final StringBuilder f2970y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Formatter f2971z;

    @RequiresApi(21)
    public static final class b {
        @DoNotInline
        public static boolean a(View view) {
            return view.isAccessibilityFocused();
        }
    }

    public final class c implements Player2.e, TimeBar.a, View.OnClickListener {
        public c(a aVar) {
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void A(MediaMetadata mediaMetadata) {
            Player.i(this, mediaMetadata);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void D(boolean z2) {
            Player.t(this, z2);
        }

        @Override // b.i.a.c.Player2.c
        public void E(Player2 player2, Player2.d dVar) {
            if (dVar.a(4, 5)) {
                PlayerControlView playerControlView = PlayerControlView.this;
                int i = PlayerControlView.j;
                playerControlView.m();
            }
            if (dVar.a(4, 5, 7)) {
                PlayerControlView playerControlView2 = PlayerControlView.this;
                int i2 = PlayerControlView.j;
                playerControlView2.n();
            }
            if (dVar.a.a.get(8)) {
                PlayerControlView playerControlView3 = PlayerControlView.this;
                int i3 = PlayerControlView.j;
                playerControlView3.o();
            }
            if (dVar.a.a.get(9)) {
                PlayerControlView playerControlView4 = PlayerControlView.this;
                int i4 = PlayerControlView.j;
                playerControlView4.p();
            }
            if (dVar.a(8, 9, 11, 0, 13)) {
                PlayerControlView playerControlView5 = PlayerControlView.this;
                int i5 = PlayerControlView.j;
                playerControlView5.l();
            }
            if (dVar.a(11, 0)) {
                PlayerControlView playerControlView6 = PlayerControlView.this;
                int i6 = PlayerControlView.j;
                playerControlView6.q();
            }
        }

        @Override // b.i.a.c.Player2.e
        public /* synthetic */ void G(int i, boolean z2) {
            Player.d(this, i, z2);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void H(boolean z2, int i) {
            Player3.k(this, z2, i);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void L(int i) {
            Player.s(this, i);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void M(MediaItem2 mediaItem2, int i) {
            Player.h(this, mediaItem2, i);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void W(boolean z2, int i) {
            Player.k(this, z2, i);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void Y(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            Player3.r(this, trackGroupArray, trackSelectionArray);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void a() {
            Player3.o(this);
        }

        @Override // b.i.a.c.Player2.e
        public /* synthetic */ void a0(int i, int i2) {
            Player.v(this, i, i2);
        }

        @Override // b.i.a.c.Player2.e
        public /* synthetic */ void b(Metadata metadata) {
            Player.j(this, metadata);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void b0(PlaybackParameters playbackParameters) {
            Player.l(this, playbackParameters);
        }

        @Override // b.i.a.c.Player2.e
        public /* synthetic */ void c() {
            Player.r(this);
        }

        @Override // b.i.a.c.Player2.e
        public /* synthetic */ void d(boolean z2) {
            Player.u(this, z2);
        }

        @Override // b.i.a.c.Player2.e
        public /* synthetic */ void e(List list) {
            Player.b(this, list);
        }

        @Override // b.i.a.c.Player2.e
        public /* synthetic */ void f(VideoSize videoSize) {
            Player.y(this, videoSize);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void f0(PlaybackException playbackException) {
            Player.p(this, playbackException);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void g(Player2.f fVar, Player2.f fVar2, int i) {
            Player.q(this, fVar, fVar2, i);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void h(int i) {
            Player.n(this, i);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void i(boolean z2) {
            Player3.d(this, z2);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void j(int i) {
            Player3.l(this, i);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void j0(boolean z2) {
            Player.g(this, z2);
        }

        @Override // b.i.a.c.d3.TimeBar.a
        public void k(TimeBar timeBar, long j) {
            PlayerControlView playerControlView = PlayerControlView.this;
            TextView textView = playerControlView.w;
            if (textView != null) {
                textView.setText(Util2.u(playerControlView.f2970y, playerControlView.f2971z, j));
            }
        }

        @Override // b.i.a.c.d3.TimeBar.a
        public void l(TimeBar timeBar, long j, boolean z2) {
            Player2 player2;
            PlayerControlView playerControlView = PlayerControlView.this;
            int iC = 0;
            playerControlView.V = false;
            if (z2 || (player2 = playerControlView.Q) == null) {
                return;
            }
            Timeline timelineK = player2.K();
            if (playerControlView.U && !timelineK.q()) {
                int iP = timelineK.p();
                while (true) {
                    long jB = timelineK.n(iC, playerControlView.B).b();
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
                iC = player2.C();
            }
            player2.h(iC, j);
            playerControlView.n();
        }

        @Override // b.i.a.c.d3.TimeBar.a
        public void m(TimeBar timeBar, long j) {
            PlayerControlView playerControlView = PlayerControlView.this;
            playerControlView.V = true;
            TextView textView = playerControlView.w;
            if (textView != null) {
                textView.setText(Util2.u(playerControlView.f2970y, playerControlView.f2971z, j));
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PlayerControlView playerControlView = PlayerControlView.this;
            Player2 player2 = playerControlView.Q;
            if (player2 == null) {
                return;
            }
            if (playerControlView.n == view) {
                player2.O();
                return;
            }
            if (playerControlView.m == view) {
                player2.s();
                return;
            }
            if (playerControlView.q == view) {
                if (player2.y() != 4) {
                    player2.P();
                    return;
                }
                return;
            }
            if (playerControlView.r == view) {
                player2.R();
                return;
            }
            if (playerControlView.o == view) {
                playerControlView.b(player2);
                return;
            }
            if (playerControlView.p == view) {
                Objects.requireNonNull(playerControlView);
                player2.d();
                return;
            }
            if (playerControlView.f2968s != view) {
                if (playerControlView.t == view) {
                    player2.k(!player2.M());
                    return;
                }
                return;
            }
            int I = player2.I();
            int i = PlayerControlView.this.f2959b0;
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
            player2.E(I);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void p(TracksInfo tracksInfo) {
            Player.x(this, tracksInfo);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void r(boolean z2) {
            Player.f(this, z2);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void s(PlaybackException playbackException) {
            Player.o(this, playbackException);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void t(Player2.b bVar) {
            Player.a(this, bVar);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void v(Timeline timeline, int i) {
            Player.w(this, timeline, i);
        }

        @Override // b.i.a.c.Player2.e
        public /* synthetic */ void w(float f) {
            Player.z(this, f);
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void y(int i) {
            Player.m(this, i);
        }

        @Override // b.i.a.c.Player2.e
        public /* synthetic */ void z(DeviceInfo2 deviceInfo2) {
            Player.c(this, deviceInfo2);
        }
    }

    public interface d {
        void a(long j, long j2);
    }

    public interface e {
        void k(int i);
    }

    static {
        ExoPlayerLibraryInfo.a("goog.exo.ui");
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, attributeSet);
    }

    public boolean a(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        Player2 player2 = this.Q;
        if (player2 != null) {
            if (keyCode == 90 || keyCode == 89 || keyCode == 85 || keyCode == 79 || keyCode == 126 || keyCode == 127 || keyCode == 87 || keyCode == 88) {
                if (keyEvent.getAction() == 0) {
                    if (keyCode == 90) {
                        if (player2.y() != 4) {
                            player2.P();
                        }
                    } else if (keyCode == 89) {
                        player2.R();
                    } else if (keyEvent.getRepeatCount() == 0) {
                        if (keyCode == 79 || keyCode == 85) {
                            int iY = player2.y();
                            if (iY == 1 || iY == 4 || !player2.j()) {
                                b(player2);
                            } else {
                                player2.d();
                            }
                        } else if (keyCode == 87) {
                            player2.O();
                        } else if (keyCode == 88) {
                            player2.s();
                        } else if (keyCode == 126) {
                            b(player2);
                        } else if (keyCode == 127) {
                            player2.d();
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void b(Player2 player2) {
        int iY = player2.y();
        if (iY == 1) {
            player2.a();
        } else if (iY == 4) {
            player2.h(player2.C(), -9223372036854775807L);
        }
        player2.e();
    }

    public void c() {
        if (e()) {
            setVisibility(8);
            Iterator<e> it = this.l.iterator();
            while (it.hasNext()) {
                it.next().k(getVisibility());
            }
            removeCallbacks(this.C);
            removeCallbacks(this.D);
            this.f2965h0 = -9223372036854775807L;
        }
    }

    public final void d() {
        removeCallbacks(this.D);
        if (this.W <= 0) {
            this.f2965h0 = -9223372036854775807L;
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        int i = this.W;
        this.f2965h0 = jUptimeMillis + ((long) i);
        if (this.S) {
            postDelayed(this.D, i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.D);
        } else if (motionEvent.getAction() == 1) {
            d();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean e() {
        return getVisibility() == 0;
    }

    public final void f() {
        View view;
        View view2;
        boolean zH = h();
        if (!zH && (view2 = this.o) != null) {
            view2.sendAccessibilityEvent(8);
        } else {
            if (!zH || (view = this.p) == null) {
                return;
            }
            view.sendAccessibilityEvent(8);
        }
    }

    public final void g() {
        View view;
        View view2;
        boolean zH = h();
        if (!zH && (view2 = this.o) != null) {
            view2.requestFocus();
        } else {
            if (!zH || (view = this.p) == null) {
                return;
            }
            view.requestFocus();
        }
    }

    @Nullable
    public Player2 getPlayer() {
        return this.Q;
    }

    public int getRepeatToggleModes() {
        return this.f2959b0;
    }

    public boolean getShowShuffleButton() {
        return this.f2964g0;
    }

    public int getShowTimeoutMs() {
        return this.W;
    }

    public boolean getShowVrButton() {
        View view = this.u;
        return view != null && view.getVisibility() == 0;
    }

    public final boolean h() {
        Player2 player2 = this.Q;
        return (player2 == null || player2.y() == 4 || this.Q.y() == 1 || !this.Q.j()) ? false : true;
    }

    public void i() {
        if (!e()) {
            setVisibility(0);
            Iterator<e> it = this.l.iterator();
            while (it.hasNext()) {
                it.next().k(getVisibility());
            }
            j();
            g();
            f();
        }
        d();
    }

    public final void j() {
        m();
        l();
        o();
        p();
        q();
    }

    public final void k(boolean z2, boolean z3, @Nullable View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z3);
        view.setAlpha(z3 ? this.M : this.N);
        view.setVisibility(z2 ? 0 : 8);
    }

    public final void l() {
        boolean zD;
        boolean z2;
        boolean zD2;
        boolean zD3;
        if (e() && this.S) {
            Player2 player2 = this.Q;
            boolean z3 = false;
            if (player2 != null) {
                boolean zD4 = player2.D(5);
                boolean zD5 = player2.D(7);
                zD2 = player2.D(11);
                zD3 = player2.D(12);
                zD = player2.D(9);
                z2 = zD4;
                z3 = zD5;
            } else {
                zD = false;
                z2 = false;
                zD2 = false;
                zD3 = false;
            }
            k(this.f2962e0, z3, this.m);
            k(this.f2960c0, zD2, this.r);
            k(this.f2961d0, zD3, this.q);
            k(this.f2963f0, zD, this.n);
            TimeBar timeBar = this.f2969x;
            if (timeBar != null) {
                timeBar.setEnabled(z2);
            }
        }
    }

    public final void m() {
        boolean z2;
        boolean z3;
        boolean z4;
        if (e() && this.S) {
            boolean zH = h();
            View view = this.o;
            boolean z5 = true;
            if (view != null) {
                z2 = (zH && view.isFocused()) | false;
                if (Util2.a < 21) {
                    z4 = z2;
                } else {
                    z4 = zH && b.a(this.o);
                }
                z3 = z4 | false;
                this.o.setVisibility(zH ? 8 : 0);
            } else {
                z2 = false;
                z3 = false;
            }
            View view2 = this.p;
            if (view2 != null) {
                z2 |= !zH && view2.isFocused();
                if (Util2.a < 21) {
                    z5 = z2;
                } else if (zH || !b.a(this.p)) {
                    z5 = false;
                }
                z3 |= z5;
                this.p.setVisibility(zH ? 0 : 8);
            }
            if (z2) {
                g();
            }
            if (z3) {
                f();
            }
        }
    }

    public final void n() {
        long jN;
        if (e() && this.S) {
            Player2 player2 = this.Q;
            long jW = 0;
            if (player2 != null) {
                jW = this.m0 + player2.w();
                jN = this.m0 + player2.N();
            } else {
                jN = 0;
            }
            boolean z2 = jW != this.n0;
            boolean z3 = jN != this.o0;
            this.n0 = jW;
            this.o0 = jN;
            TextView textView = this.w;
            if (textView != null && !this.V && z2) {
                textView.setText(Util2.u(this.f2970y, this.f2971z, jW));
            }
            TimeBar timeBar = this.f2969x;
            if (timeBar != null) {
                timeBar.setPosition(jW);
                this.f2969x.setBufferedPosition(jN);
            }
            d dVar = this.R;
            if (dVar != null && (z2 || z3)) {
                dVar.a(jW, jN);
            }
            removeCallbacks(this.C);
            int iY = player2 == null ? 1 : player2.y();
            if (player2 == null || !player2.z()) {
                if (iY == 4 || iY == 1) {
                    return;
                }
                postDelayed(this.C, 1000L);
                return;
            }
            TimeBar timeBar2 = this.f2969x;
            long jMin = Math.min(timeBar2 != null ? timeBar2.getPreferredUpdateDelay() : 1000L, 1000 - (jW % 1000));
            float f = player2.c().k;
            postDelayed(this.C, Util2.i(f > 0.0f ? (long) (jMin / f) : 1000L, this.f2958a0, 1000L));
        }
    }

    public final void o() {
        ImageView imageView;
        if (e() && this.S && (imageView = this.f2968s) != null) {
            if (this.f2959b0 == 0) {
                k(false, false, imageView);
                return;
            }
            Player2 player2 = this.Q;
            if (player2 == null) {
                k(true, false, imageView);
                this.f2968s.setImageDrawable(this.E);
                this.f2968s.setContentDescription(this.H);
                return;
            }
            k(true, true, imageView);
            int I = player2.I();
            if (I == 0) {
                this.f2968s.setImageDrawable(this.E);
                this.f2968s.setContentDescription(this.H);
            } else if (I == 1) {
                this.f2968s.setImageDrawable(this.F);
                this.f2968s.setContentDescription(this.I);
            } else if (I == 2) {
                this.f2968s.setImageDrawable(this.G);
                this.f2968s.setContentDescription(this.J);
            }
            this.f2968s.setVisibility(0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.S = true;
        long j2 = this.f2965h0;
        if (j2 != -9223372036854775807L) {
            long jUptimeMillis = j2 - SystemClock.uptimeMillis();
            if (jUptimeMillis <= 0) {
                c();
            } else {
                postDelayed(this.D, jUptimeMillis);
            }
        } else if (e()) {
            d();
        }
        j();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.S = false;
        removeCallbacks(this.C);
        removeCallbacks(this.D);
    }

    public final void p() {
        ImageView imageView;
        if (e() && this.S && (imageView = this.t) != null) {
            Player2 player2 = this.Q;
            if (!this.f2964g0) {
                k(false, false, imageView);
                return;
            }
            if (player2 == null) {
                k(true, false, imageView);
                this.t.setImageDrawable(this.L);
                this.t.setContentDescription(this.P);
            } else {
                k(true, true, imageView);
                this.t.setImageDrawable(player2.M() ? this.K : this.L);
                this.t.setContentDescription(player2.M() ? this.O : this.P);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003b  */
    /* JADX WARN: Code duplicated, block: B:49:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:53:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:54:0x00c5  */
    public final void q() {
        boolean z2;
        int i;
        Timeline.c cVar;
        long j2;
        long[] jArr;
        int length;
        boolean z3;
        Player2 player2 = this.Q;
        if (player2 == null) {
            return;
        }
        long j3 = -9223372036854775807L;
        boolean z4 = true;
        if (this.T) {
            Timeline timelineK = player2.K();
            Timeline.c cVar2 = this.B;
            if (timelineK.p() <= 100) {
                int iP = timelineK.p();
                int i2 = 0;
                while (true) {
                    if (i2 >= iP) {
                        z3 = true;
                        break;
                    } else {
                        if (timelineK.n(i2, cVar2).A == -9223372036854775807L) {
                            z3 = false;
                            break;
                        }
                        i2++;
                    }
                }
            } else {
                z3 = false;
                break;
            }
            if (z3) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        this.U = z2;
        long j4 = 0;
        this.m0 = 0L;
        Timeline timelineK2 = player2.K();
        if (timelineK2.q()) {
            i = 0;
        } else {
            int iC = player2.C();
            boolean z5 = this.U;
            int i3 = z5 ? 0 : iC;
            int iP2 = z5 ? timelineK2.p() - 1 : iC;
            long j5 = 0;
            i = 0;
            while (i3 <= iP2) {
                if (i3 == iC) {
                    this.m0 = Util2.M(j5);
                }
                timelineK2.n(i3, this.B);
                Timeline.c cVar3 = this.B;
                if (cVar3.A == j3) {
                    AnimatableValueParser.D(this.U ^ z4);
                    break;
                }
                int i4 = cVar3.B;
                while (true) {
                    cVar = this.B;
                    if (i4 <= cVar.C) {
                        timelineK2.f(i4, this.A);
                        AdPlaybackState adPlaybackState = this.A.p;
                        int i5 = adPlaybackState.q;
                        int i6 = adPlaybackState.n;
                        while (i5 < i6) {
                            long jC = this.A.c(i5);
                            if (jC == Long.MIN_VALUE) {
                                long j6 = this.A.m;
                                if (j6 != j3) {
                                    jC = j6;
                                    j2 = jC + this.A.n;
                                    if (j2 >= 0) {
                                        jArr = this.f2966i0;
                                        if (i == jArr.length) {
                                            if (jArr.length == 0) {
                                                length = 1;
                                            } else {
                                                length = jArr.length * 2;
                                            }
                                            this.f2966i0 = Arrays.copyOf(jArr, length);
                                            this.f2967j0 = Arrays.copyOf(this.f2967j0, length);
                                        }
                                        this.f2966i0[i] = Util2.M(j2 + j5);
                                        this.f2967j0[i] = !this.A.p.a(i5).b();
                                        i++;
                                    }
                                }
                            } else {
                                j2 = jC + this.A.n;
                                if (j2 >= 0) {
                                    jArr = this.f2966i0;
                                    if (i == jArr.length) {
                                        if (jArr.length == 0) {
                                            length = 1;
                                        } else {
                                            length = jArr.length * 2;
                                        }
                                        this.f2966i0 = Arrays.copyOf(jArr, length);
                                        this.f2967j0 = Arrays.copyOf(this.f2967j0, length);
                                    }
                                    this.f2966i0[i] = Util2.M(j2 + j5);
                                    this.f2967j0[i] = !this.A.p.a(i5).b();
                                    i++;
                                }
                            }
                            i5++;
                            j3 = -9223372036854775807L;
                        }
                        i4++;
                        j3 = -9223372036854775807L;
                    }
                }
                j5 += cVar.A;
                i3++;
                j3 = -9223372036854775807L;
                z4 = true;
            }
            j4 = j5;
        }
        long jM = Util2.M(j4);
        TextView textView = this.v;
        if (textView != null) {
            textView.setText(Util2.u(this.f2970y, this.f2971z, jM));
        }
        TimeBar timeBar = this.f2969x;
        if (timeBar != null) {
            timeBar.setDuration(jM);
            int length2 = this.k0.length;
            int i7 = i + length2;
            long[] jArr2 = this.f2966i0;
            if (i7 > jArr2.length) {
                this.f2966i0 = Arrays.copyOf(jArr2, i7);
                this.f2967j0 = Arrays.copyOf(this.f2967j0, i7);
            }
            System.arraycopy(this.k0, 0, this.f2966i0, i, length2);
            System.arraycopy(this.l0, 0, this.f2967j0, i, length2);
            this.f2969x.a(this.f2966i0, this.f2967j0, i7);
        }
        n();
    }

    public void setPlayer(@Nullable Player2 player2) {
        boolean z2 = true;
        AnimatableValueParser.D(Looper.myLooper() == Looper.getMainLooper());
        if (player2 != null && player2.L() != Looper.getMainLooper()) {
            z2 = false;
        }
        AnimatableValueParser.j(z2);
        Player2 player3 = this.Q;
        if (player3 == player2) {
            return;
        }
        if (player3 != null) {
            player3.p(this.k);
        }
        this.Q = player2;
        if (player2 != null) {
            player2.x(this.k);
        }
        j();
    }

    public void setProgressUpdateListener(@Nullable d dVar) {
        this.R = dVar;
    }

    public void setRepeatToggleModes(int i) {
        this.f2959b0 = i;
        Player2 player2 = this.Q;
        if (player2 != null) {
            int I = player2.I();
            if (i == 0 && I != 0) {
                this.Q.E(0);
            } else if (i == 1 && I == 2) {
                this.Q.E(1);
            } else if (i == 2 && I == 1) {
                this.Q.E(2);
            }
        }
        o();
    }

    public void setShowFastForwardButton(boolean z2) {
        this.f2961d0 = z2;
        l();
    }

    public void setShowMultiWindowTimeBar(boolean z2) {
        this.T = z2;
        q();
    }

    public void setShowNextButton(boolean z2) {
        this.f2963f0 = z2;
        l();
    }

    public void setShowPreviousButton(boolean z2) {
        this.f2962e0 = z2;
        l();
    }

    public void setShowRewindButton(boolean z2) {
        this.f2960c0 = z2;
        l();
    }

    public void setShowShuffleButton(boolean z2) {
        this.f2964g0 = z2;
        p();
    }

    public void setShowTimeoutMs(int i) {
        this.W = i;
        if (e()) {
            d();
        }
    }

    public void setShowVrButton(boolean z2) {
        View view = this.u;
        if (view != null) {
            view.setVisibility(z2 ? 0 : 8);
        }
    }

    public void setTimeBarMinUpdateInterval(int i) {
        this.f2958a0 = Util2.h(i, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        View view = this.u;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            k(getShowVrButton(), onClickListener != null, this.u);
        }
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i, @Nullable AttributeSet attributeSet2) {
        super(context, attributeSet, i);
        int resourceId = R.e.exo_player_control_view;
        this.W = 5000;
        this.f2959b0 = 0;
        this.f2958a0 = 200;
        this.f2965h0 = -9223372036854775807L;
        this.f2960c0 = true;
        this.f2961d0 = true;
        this.f2962e0 = true;
        this.f2963f0 = true;
        this.f2964g0 = false;
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R.g.PlayerControlView, i, 0);
            try {
                this.W = typedArrayObtainStyledAttributes.getInt(R.g.PlayerControlView_show_timeout, this.W);
                resourceId = typedArrayObtainStyledAttributes.getResourceId(R.g.PlayerControlView_controller_layout_id, resourceId);
                this.f2959b0 = typedArrayObtainStyledAttributes.getInt(R.g.PlayerControlView_repeat_toggle_modes, this.f2959b0);
                this.f2960c0 = typedArrayObtainStyledAttributes.getBoolean(R.g.PlayerControlView_show_rewind_button, this.f2960c0);
                this.f2961d0 = typedArrayObtainStyledAttributes.getBoolean(R.g.PlayerControlView_show_fastforward_button, this.f2961d0);
                this.f2962e0 = typedArrayObtainStyledAttributes.getBoolean(R.g.PlayerControlView_show_previous_button, this.f2962e0);
                this.f2963f0 = typedArrayObtainStyledAttributes.getBoolean(R.g.PlayerControlView_show_next_button, this.f2963f0);
                this.f2964g0 = typedArrayObtainStyledAttributes.getBoolean(R.g.PlayerControlView_show_shuffle_button, this.f2964g0);
                setTimeBarMinUpdateInterval(typedArrayObtainStyledAttributes.getInt(R.g.PlayerControlView_time_bar_min_update_interval, this.f2958a0));
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        }
        this.l = new CopyOnWriteArrayList<>();
        this.A = new Timeline.b();
        this.B = new Timeline.c();
        StringBuilder sb = new StringBuilder();
        this.f2970y = sb;
        this.f2971z = new Formatter(sb, Locale.getDefault());
        this.f2966i0 = new long[0];
        this.f2967j0 = new boolean[0];
        this.k0 = new long[0];
        this.l0 = new boolean[0];
        c cVar = new c(null);
        this.k = cVar;
        this.C = new Runnable() { // from class: b.i.a.c.d3.d
            @Override // java.lang.Runnable
            public final void run() {
                PlayerControlView playerControlView = this.j;
                int i2 = PlayerControlView.j;
                playerControlView.n();
            }
        };
        this.D = new Runnable() { // from class: b.i.a.c.d3.a
            @Override // java.lang.Runnable
            public final void run() {
                this.j.c();
            }
        };
        LayoutInflater.from(context).inflate(resourceId, this);
        setDescendantFocusability(262144);
        int i2 = R.c.exo_progress;
        TimeBar timeBar = (TimeBar) findViewById(i2);
        View viewFindViewById = findViewById(R.c.exo_progress_placeholder);
        if (timeBar != null) {
            this.f2969x = timeBar;
        } else if (viewFindViewById != null) {
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, 0, attributeSet2);
            defaultTimeBar.setId(i2);
            defaultTimeBar.setLayoutParams(viewFindViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById);
            viewGroup.removeView(viewFindViewById);
            viewGroup.addView(defaultTimeBar, iIndexOfChild);
            this.f2969x = defaultTimeBar;
        } else {
            this.f2969x = null;
        }
        this.v = (TextView) findViewById(R.c.exo_duration);
        this.w = (TextView) findViewById(R.c.exo_position);
        TimeBar timeBar2 = this.f2969x;
        if (timeBar2 != null) {
            timeBar2.b(cVar);
        }
        View viewFindViewById2 = findViewById(R.c.exo_play);
        this.o = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(cVar);
        }
        View viewFindViewById3 = findViewById(R.c.exo_pause);
        this.p = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(cVar);
        }
        View viewFindViewById4 = findViewById(R.c.exo_prev);
        this.m = viewFindViewById4;
        if (viewFindViewById4 != null) {
            viewFindViewById4.setOnClickListener(cVar);
        }
        View viewFindViewById5 = findViewById(R.c.exo_next);
        this.n = viewFindViewById5;
        if (viewFindViewById5 != null) {
            viewFindViewById5.setOnClickListener(cVar);
        }
        View viewFindViewById6 = findViewById(R.c.exo_rew);
        this.r = viewFindViewById6;
        if (viewFindViewById6 != null) {
            viewFindViewById6.setOnClickListener(cVar);
        }
        View viewFindViewById7 = findViewById(R.c.exo_ffwd);
        this.q = viewFindViewById7;
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(cVar);
        }
        ImageView imageView = (ImageView) findViewById(R.c.exo_repeat_toggle);
        this.f2968s = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(cVar);
        }
        ImageView imageView2 = (ImageView) findViewById(R.c.exo_shuffle);
        this.t = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(cVar);
        }
        View viewFindViewById8 = findViewById(R.c.exo_vr);
        this.u = viewFindViewById8;
        setShowVrButton(false);
        k(false, false, viewFindViewById8);
        Resources resources = context.getResources();
        this.M = resources.getInteger(R.d.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.N = resources.getInteger(R.d.exo_media_button_opacity_percentage_disabled) / 100.0f;
        this.E = resources.getDrawable(R.b.exo_controls_repeat_off);
        this.F = resources.getDrawable(R.b.exo_controls_repeat_one);
        this.G = resources.getDrawable(R.b.exo_controls_repeat_all);
        this.K = resources.getDrawable(R.b.exo_controls_shuffle_on);
        this.L = resources.getDrawable(R.b.exo_controls_shuffle_off);
        this.H = resources.getString(R.f.exo_controls_repeat_off_description);
        this.I = resources.getString(R.f.exo_controls_repeat_one_description);
        this.J = resources.getString(R.f.exo_controls_repeat_all_description);
        this.O = resources.getString(R.f.exo_controls_shuffle_on_description);
        this.P = resources.getString(R.f.exo_controls_shuffle_off_description);
        this.n0 = -9223372036854775807L;
        this.o0 = -9223372036854775807L;
    }
}
