package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.view.accessibility.CaptioningManager$CaptionStyle;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import b.c.a.a0.d;
import b.i.a.c.a2;
import b.i.a.c.a3.o0;
import b.i.a.c.b3.b;
import b.i.a.c.b3.b$b;
import b.i.a.c.c1;
import b.i.a.c.c3.n;
import b.i.a.c.d3.g;
import b.i.a.c.d3.j;
import b.i.a.c.d3.k;
import b.i.a.c.d3.r;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class SubtitleView extends FrameLayout implements y1$e {
    public List<b> j;
    public k k;
    public int l;
    public float m;
    public float n;
    public boolean o;
    public boolean p;
    public int q;
    public SubtitleView$a r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f2976s;

    public SubtitleView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = Collections.emptyList();
        this.k = k.a;
        this.l = 0;
        this.m = 0.0533f;
        this.n = 0.08f;
        this.o = true;
        this.p = true;
        j jVar = new j(context, null);
        this.r = jVar;
        this.f2976s = jVar;
        addView(jVar);
        this.q = 1;
    }

    private List<b> getCuesWithStylingPreferencesApplied() {
        if (this.o && this.p) {
            return this.j;
        }
        ArrayList arrayList = new ArrayList(this.j.size());
        for (int i = 0; i < this.j.size(); i++) {
            b$b b_bA = this.j.get(i).a();
            if (!this.o) {
                b_bA.n = false;
                CharSequence charSequence = b_bA.a;
                if (charSequence instanceof Spanned) {
                    if (!(charSequence instanceof Spannable)) {
                        b_bA.a = SpannableString.valueOf(charSequence);
                    }
                    CharSequence charSequence2 = b_bA.a;
                    Objects.requireNonNull(charSequence2);
                    d.P1((Spannable) charSequence2, g.a);
                }
                d.O1(b_bA);
            } else if (!this.p) {
                d.O1(b_bA);
            }
            arrayList.add(b_bA.a());
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (e0.a < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private k getUserCaptionStyle() {
        int i = e0.a;
        if (i < 19 || isInEditMode()) {
            return k.a;
        }
        CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
        if (captioningManager == null || !captioningManager.isEnabled()) {
            return k.a;
        }
        CaptioningManager$CaptionStyle userStyle = captioningManager.getUserStyle();
        if (i < 21) {
            return new k(userStyle.foregroundColor, userStyle.backgroundColor, 0, userStyle.edgeType, userStyle.edgeColor, userStyle.getTypeface());
        }
        return new k(userStyle.hasForegroundColor() ? userStyle.foregroundColor : -1, userStyle.hasBackgroundColor() ? userStyle.backgroundColor : ViewCompat.MEASURED_STATE_MASK, userStyle.hasWindowColor() ? userStyle.windowColor : 0, userStyle.hasEdgeType() ? userStyle.edgeType : 0, userStyle.hasEdgeColor() ? userStyle.edgeColor : -1, userStyle.getTypeface());
    }

    private <T extends View & SubtitleView$a> void setView(T t) {
        removeView(this.f2976s);
        View view = this.f2976s;
        if (view instanceof r) {
            ((r) view).k.destroy();
        }
        this.f2976s = t;
        this.r = t;
        addView(t);
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
    public void e(List<b> list) {
        setCues(list);
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

    public void k() {
        setStyle(getUserCaptionStyle());
    }

    public void l() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public final void m() {
        this.r.a(getCuesWithStylingPreferencesApplied(), this.k, this.m, this.l, this.n);
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

    public void setApplyEmbeddedFontSizes(boolean z2) {
        this.p = z2;
        m();
    }

    public void setApplyEmbeddedStyles(boolean z2) {
        this.o = z2;
        m();
    }

    public void setBottomPaddingFraction(float f) {
        this.n = f;
        m();
    }

    public void setCues(@Nullable List<b> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.j = list;
        m();
    }

    public void setFractionalTextSize(float f) {
        this.l = 0;
        this.m = f;
        m();
    }

    public void setStyle(k kVar) {
        this.k = kVar;
        m();
    }

    public void setViewType(int i) {
        if (this.q == i) {
            return;
        }
        if (i == 1) {
            setView(new j(getContext(), null));
        } else {
            if (i != 2) {
                throw new IllegalArgumentException();
            }
            setView(new r(getContext()));
        }
        this.q = i;
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
