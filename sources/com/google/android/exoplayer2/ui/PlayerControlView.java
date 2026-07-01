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
import android.view.View$OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import b.c.a.a0.d;
import b.i.a.c.a3.p0.c;
import b.i.a.c.d3.a;
import b.i.a.c.d3.o;
import b.i.a.c.f3.e0;
import b.i.a.c.i1;
import b.i.a.c.o2;
import b.i.a.c.o2$b;
import b.i.a.c.o2$c;
import b.i.a.c.y1;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class PlayerControlView extends FrameLayout {
    public static final /* synthetic */ int j = 0;
    public final o2$b A;
    public final o2$c B;
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
    public y1 Q;

    @Nullable
    public PlayerControlView$d R;
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
    public final PlayerControlView$c k;
    public long[] k0;
    public final CopyOnWriteArrayList<PlayerControlView$e> l;
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
    public final o f2969x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final StringBuilder f2970y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Formatter f2971z;

    static {
        i1.a("goog.exo.ui");
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, attributeSet);
    }

    public boolean a(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        y1 y1Var = this.Q;
        if (y1Var != null) {
            if (keyCode == 90 || keyCode == 89 || keyCode == 85 || keyCode == 79 || keyCode == 126 || keyCode == 127 || keyCode == 87 || keyCode == 88) {
                if (keyEvent.getAction() == 0) {
                    if (keyCode == 90) {
                        if (y1Var.y() != 4) {
                            y1Var.P();
                        }
                    } else if (keyCode == 89) {
                        y1Var.R();
                    } else if (keyEvent.getRepeatCount() == 0) {
                        if (keyCode == 79 || keyCode == 85) {
                            int iY = y1Var.y();
                            if (iY == 1 || iY == 4 || !y1Var.j()) {
                                b(y1Var);
                            } else {
                                y1Var.d();
                            }
                        } else if (keyCode == 87) {
                            y1Var.O();
                        } else if (keyCode == 88) {
                            y1Var.s();
                        } else if (keyCode == 126) {
                            b(y1Var);
                        } else if (keyCode == 127) {
                            y1Var.d();
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void b(y1 y1Var) {
        int iY = y1Var.y();
        if (iY == 1) {
            y1Var.a();
        } else if (iY == 4) {
            y1Var.h(y1Var.C(), -9223372036854775807L);
        }
        y1Var.e();
    }

    public void c() {
        if (e()) {
            setVisibility(8);
            Iterator<PlayerControlView$e> it = this.l.iterator();
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
    public y1 getPlayer() {
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
        y1 y1Var = this.Q;
        return (y1Var == null || y1Var.y() == 4 || this.Q.y() == 1 || !this.Q.j()) ? false : true;
    }

    public void i() {
        if (!e()) {
            setVisibility(0);
            Iterator<PlayerControlView$e> it = this.l.iterator();
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
            y1 y1Var = this.Q;
            boolean z3 = false;
            if (y1Var != null) {
                boolean zD4 = y1Var.D(5);
                boolean zD5 = y1Var.D(7);
                zD2 = y1Var.D(11);
                zD3 = y1Var.D(12);
                zD = y1Var.D(9);
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
            o oVar = this.f2969x;
            if (oVar != null) {
                oVar.setEnabled(z2);
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
                if (e0.a < 21) {
                    z4 = z2;
                } else {
                    z4 = zH && PlayerControlView$b.a(this.o);
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
                if (e0.a < 21) {
                    z5 = z2;
                } else if (zH || !PlayerControlView$b.a(this.p)) {
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
            y1 y1Var = this.Q;
            long jW = 0;
            if (y1Var != null) {
                jW = this.m0 + y1Var.w();
                jN = this.m0 + y1Var.N();
            } else {
                jN = 0;
            }
            boolean z2 = jW != this.n0;
            boolean z3 = jN != this.o0;
            this.n0 = jW;
            this.o0 = jN;
            TextView textView = this.w;
            if (textView != null && !this.V && z2) {
                textView.setText(e0.u(this.f2970y, this.f2971z, jW));
            }
            o oVar = this.f2969x;
            if (oVar != null) {
                oVar.setPosition(jW);
                this.f2969x.setBufferedPosition(jN);
            }
            PlayerControlView$d playerControlView$d = this.R;
            if (playerControlView$d != null && (z2 || z3)) {
                playerControlView$d.a(jW, jN);
            }
            removeCallbacks(this.C);
            int iY = y1Var == null ? 1 : y1Var.y();
            if (y1Var == null || !y1Var.z()) {
                if (iY == 4 || iY == 1) {
                    return;
                }
                postDelayed(this.C, 1000L);
                return;
            }
            o oVar2 = this.f2969x;
            long jMin = Math.min(oVar2 != null ? oVar2.getPreferredUpdateDelay() : 1000L, 1000 - (jW % 1000));
            float f = y1Var.c().k;
            postDelayed(this.C, e0.i(f > 0.0f ? (long) (jMin / f) : 1000L, this.f2958a0, 1000L));
        }
    }

    public final void o() {
        ImageView imageView;
        if (e() && this.S && (imageView = this.f2968s) != null) {
            if (this.f2959b0 == 0) {
                k(false, false, imageView);
                return;
            }
            y1 y1Var = this.Q;
            if (y1Var == null) {
                k(true, false, imageView);
                this.f2968s.setImageDrawable(this.E);
                this.f2968s.setContentDescription(this.H);
                return;
            }
            k(true, true, imageView);
            int I = y1Var.I();
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
            y1 y1Var = this.Q;
            if (!this.f2964g0) {
                k(false, false, imageView);
                return;
            }
            if (y1Var == null) {
                k(true, false, imageView);
                this.t.setImageDrawable(this.L);
                this.t.setContentDescription(this.P);
            } else {
                k(true, true, imageView);
                this.t.setImageDrawable(y1Var.M() ? this.K : this.L);
                this.t.setContentDescription(y1Var.M() ? this.O : this.P);
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
        o2$c o2_c;
        long j2;
        long[] jArr;
        int length;
        boolean z3;
        y1 y1Var = this.Q;
        if (y1Var == null) {
            return;
        }
        long j3 = -9223372036854775807L;
        boolean z4 = true;
        if (this.T) {
            o2 o2VarK = y1Var.K();
            o2$c o2_c2 = this.B;
            if (o2VarK.p() <= 100) {
                int iP = o2VarK.p();
                int i2 = 0;
                while (true) {
                    if (i2 >= iP) {
                        z3 = true;
                        break;
                    } else {
                        if (o2VarK.n(i2, o2_c2).A == -9223372036854775807L) {
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
        o2 o2VarK2 = y1Var.K();
        if (o2VarK2.q()) {
            i = 0;
        } else {
            int iC = y1Var.C();
            boolean z5 = this.U;
            int i3 = z5 ? 0 : iC;
            int iP2 = z5 ? o2VarK2.p() - 1 : iC;
            long j5 = 0;
            i = 0;
            while (i3 <= iP2) {
                if (i3 == iC) {
                    this.m0 = e0.M(j5);
                }
                o2VarK2.n(i3, this.B);
                o2$c o2_c3 = this.B;
                if (o2_c3.A == j3) {
                    d.D(this.U ^ z4);
                    break;
                }
                int i4 = o2_c3.B;
                while (true) {
                    o2_c = this.B;
                    if (i4 <= o2_c.C) {
                        o2VarK2.f(i4, this.A);
                        c cVar = this.A.p;
                        int i5 = cVar.q;
                        int i6 = cVar.n;
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
                                        this.f2966i0[i] = e0.M(j2 + j5);
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
                                    this.f2966i0[i] = e0.M(j2 + j5);
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
                j5 += o2_c.A;
                i3++;
                j3 = -9223372036854775807L;
                z4 = true;
            }
            j4 = j5;
        }
        long jM = e0.M(j4);
        TextView textView = this.v;
        if (textView != null) {
            textView.setText(e0.u(this.f2970y, this.f2971z, jM));
        }
        o oVar = this.f2969x;
        if (oVar != null) {
            oVar.setDuration(jM);
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

    public void setPlayer(@Nullable y1 y1Var) {
        boolean z2 = true;
        d.D(Looper.myLooper() == Looper.getMainLooper());
        if (y1Var != null && y1Var.L() != Looper.getMainLooper()) {
            z2 = false;
        }
        d.j(z2);
        y1 y1Var2 = this.Q;
        if (y1Var2 == y1Var) {
            return;
        }
        if (y1Var2 != null) {
            y1Var2.p(this.k);
        }
        this.Q = y1Var;
        if (y1Var != null) {
            y1Var.x(this.k);
        }
        j();
    }

    public void setProgressUpdateListener(@Nullable PlayerControlView$d playerControlView$d) {
        this.R = playerControlView$d;
    }

    public void setRepeatToggleModes(int i) {
        this.f2959b0 = i;
        y1 y1Var = this.Q;
        if (y1Var != null) {
            int I = y1Var.I();
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
        this.f2958a0 = e0.h(i, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View$OnClickListener view$OnClickListener) {
        View view = this.u;
        if (view != null) {
            view.setOnClickListener(view$OnClickListener);
            k(getShowVrButton(), view$OnClickListener != null, this.u);
        }
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i, @Nullable AttributeSet attributeSet2) {
        super(context, attributeSet, i);
        int resourceId = R$e.exo_player_control_view;
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
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R$g.PlayerControlView, i, 0);
            try {
                this.W = typedArrayObtainStyledAttributes.getInt(R$g.PlayerControlView_show_timeout, this.W);
                resourceId = typedArrayObtainStyledAttributes.getResourceId(R$g.PlayerControlView_controller_layout_id, resourceId);
                this.f2959b0 = typedArrayObtainStyledAttributes.getInt(R$g.PlayerControlView_repeat_toggle_modes, this.f2959b0);
                this.f2960c0 = typedArrayObtainStyledAttributes.getBoolean(R$g.PlayerControlView_show_rewind_button, this.f2960c0);
                this.f2961d0 = typedArrayObtainStyledAttributes.getBoolean(R$g.PlayerControlView_show_fastforward_button, this.f2961d0);
                this.f2962e0 = typedArrayObtainStyledAttributes.getBoolean(R$g.PlayerControlView_show_previous_button, this.f2962e0);
                this.f2963f0 = typedArrayObtainStyledAttributes.getBoolean(R$g.PlayerControlView_show_next_button, this.f2963f0);
                this.f2964g0 = typedArrayObtainStyledAttributes.getBoolean(R$g.PlayerControlView_show_shuffle_button, this.f2964g0);
                setTimeBarMinUpdateInterval(typedArrayObtainStyledAttributes.getInt(R$g.PlayerControlView_time_bar_min_update_interval, this.f2958a0));
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        }
        this.l = new CopyOnWriteArrayList<>();
        this.A = new o2$b();
        this.B = new o2$c();
        StringBuilder sb = new StringBuilder();
        this.f2970y = sb;
        this.f2971z = new Formatter(sb, Locale.getDefault());
        this.f2966i0 = new long[0];
        this.f2967j0 = new boolean[0];
        this.k0 = new long[0];
        this.l0 = new boolean[0];
        PlayerControlView$c playerControlView$c = new PlayerControlView$c(this, null);
        this.k = playerControlView$c;
        this.C = new b.i.a.c.d3.d(this);
        this.D = new a(this);
        LayoutInflater.from(context).inflate(resourceId, this);
        setDescendantFocusability(262144);
        int i2 = R$c.exo_progress;
        o oVar = (o) findViewById(i2);
        View viewFindViewById = findViewById(R$c.exo_progress_placeholder);
        if (oVar != null) {
            this.f2969x = oVar;
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
        this.v = (TextView) findViewById(R$c.exo_duration);
        this.w = (TextView) findViewById(R$c.exo_position);
        o oVar2 = this.f2969x;
        if (oVar2 != null) {
            oVar2.b(playerControlView$c);
        }
        View viewFindViewById2 = findViewById(R$c.exo_play);
        this.o = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(playerControlView$c);
        }
        View viewFindViewById3 = findViewById(R$c.exo_pause);
        this.p = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(playerControlView$c);
        }
        View viewFindViewById4 = findViewById(R$c.exo_prev);
        this.m = viewFindViewById4;
        if (viewFindViewById4 != null) {
            viewFindViewById4.setOnClickListener(playerControlView$c);
        }
        View viewFindViewById5 = findViewById(R$c.exo_next);
        this.n = viewFindViewById5;
        if (viewFindViewById5 != null) {
            viewFindViewById5.setOnClickListener(playerControlView$c);
        }
        View viewFindViewById6 = findViewById(R$c.exo_rew);
        this.r = viewFindViewById6;
        if (viewFindViewById6 != null) {
            viewFindViewById6.setOnClickListener(playerControlView$c);
        }
        View viewFindViewById7 = findViewById(R$c.exo_ffwd);
        this.q = viewFindViewById7;
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(playerControlView$c);
        }
        ImageView imageView = (ImageView) findViewById(R$c.exo_repeat_toggle);
        this.f2968s = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(playerControlView$c);
        }
        ImageView imageView2 = (ImageView) findViewById(R$c.exo_shuffle);
        this.t = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(playerControlView$c);
        }
        View viewFindViewById8 = findViewById(R$c.exo_vr);
        this.u = viewFindViewById8;
        setShowVrButton(false);
        k(false, false, viewFindViewById8);
        Resources resources = context.getResources();
        this.M = resources.getInteger(R$d.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.N = resources.getInteger(R$d.exo_media_button_opacity_percentage_disabled) / 100.0f;
        this.E = resources.getDrawable(R$b.exo_controls_repeat_off);
        this.F = resources.getDrawable(R$b.exo_controls_repeat_one);
        this.G = resources.getDrawable(R$b.exo_controls_repeat_all);
        this.K = resources.getDrawable(R$b.exo_controls_shuffle_on);
        this.L = resources.getDrawable(R$b.exo_controls_shuffle_off);
        this.H = resources.getString(R$f.exo_controls_repeat_off_description);
        this.I = resources.getString(R$f.exo_controls_repeat_one_description);
        this.J = resources.getString(R$f.exo_controls_repeat_all_description);
        this.O = resources.getString(R$f.exo_controls_shuffle_on_description);
        this.P = resources.getString(R$f.exo_controls_shuffle_off_description);
        this.n0 = -9223372036854775807L;
        this.o0 = -9223372036854775807L;
    }
}
