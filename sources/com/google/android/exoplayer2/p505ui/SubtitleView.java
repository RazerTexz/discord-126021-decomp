package com.google.android.exoplayer2.p505ui;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.AbstractC2832o2;
import p007b.p225i.p226a.p242c.C2528a2;
import p007b.p225i.p226a.p242c.C2633c1;
import p007b.p225i.p226a.p242c.C2831o1;
import p007b.p225i.p226a.p242c.C2835p1;
import p007b.p225i.p226a.p242c.C2836p2;
import p007b.p225i.p226a.p242c.C2998x1;
import p007b.p225i.p226a.p242c.C3154z1;
import p007b.p225i.p226a.p242c.InterfaceC3128y1;
import p007b.p225i.p226a.p242c.p243a3.C2558o0;
import p007b.p225i.p226a.p242c.p245b3.C2578b;
import p007b.p225i.p226a.p242c.p245b3.p249q.InterfaceC2602b;
import p007b.p225i.p226a.p242c.p255c3.C2648n;
import p007b.p225i.p226a.p242c.p256d3.C2666j;
import p007b.p225i.p226a.p242c.p256d3.C2667k;
import p007b.p225i.p226a.p242c.p256d3.C2674r;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p260g3.C2788y;
import p007b.p225i.p355b.p356a.InterfaceC4488h;

/* JADX INFO: loaded from: classes3.dex */
public final class SubtitleView extends FrameLayout implements InterfaceC3128y1.e {

    /* JADX INFO: renamed from: j */
    public List<C2578b> f20190j;

    /* JADX INFO: renamed from: k */
    public C2667k f20191k;

    /* JADX INFO: renamed from: l */
    public int f20192l;

    /* JADX INFO: renamed from: m */
    public float f20193m;

    /* JADX INFO: renamed from: n */
    public float f20194n;

    /* JADX INFO: renamed from: o */
    public boolean f20195o;

    /* JADX INFO: renamed from: p */
    public boolean f20196p;

    /* JADX INFO: renamed from: q */
    public int f20197q;

    /* JADX INFO: renamed from: r */
    public InterfaceC10760a f20198r;

    /* JADX INFO: renamed from: s */
    public View f20199s;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.ui.SubtitleView$a */
    public interface InterfaceC10760a {
        /* JADX INFO: renamed from: a */
        void mo2758a(List<C2578b> list, C2667k c2667k, float f, int i, float f2);
    }

    public SubtitleView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20190j = Collections.emptyList();
        this.f20191k = C2667k.f6349a;
        this.f20192l = 0;
        this.f20193m = 0.0533f;
        this.f20194n = 0.08f;
        this.f20195o = true;
        this.f20196p = true;
        C2666j c2666j = new C2666j(context, null);
        this.f20198r = c2666j;
        this.f20199s = c2666j;
        addView(c2666j);
        this.f20197q = 1;
    }

    private List<C2578b> getCuesWithStylingPreferencesApplied() {
        if (this.f20195o && this.f20196p) {
            return this.f20190j;
        }
        ArrayList arrayList = new ArrayList(this.f20190j.size());
        for (int i = 0; i < this.f20190j.size(); i++) {
            C2578b.b bVarM2605a = this.f20190j.get(i).m2605a();
            if (!this.f20195o) {
                bVarM2605a.f5786n = false;
                CharSequence charSequence = bVarM2605a.f5773a;
                if (charSequence instanceof Spanned) {
                    if (!(charSequence instanceof Spannable)) {
                        bVarM2605a.f5773a = SpannableString.valueOf(charSequence);
                    }
                    CharSequence charSequence2 = bVarM2605a.f5773a;
                    Objects.requireNonNull(charSequence2);
                    C1460d.m464P1((Spannable) charSequence2, new InterfaceC4488h() { // from class: b.i.a.c.d3.g
                        @Override // p007b.p225i.p355b.p356a.InterfaceC4488h
                        public final boolean apply(Object obj) {
                            return !(obj instanceof InterfaceC2602b);
                        }
                    });
                }
                C1460d.m461O1(bVarM2605a);
            } else if (!this.f20196p) {
                C1460d.m461O1(bVarM2605a);
            }
            arrayList.add(bVarM2605a.m2606a());
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (C2738e0.f6708a < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private C2667k getUserCaptionStyle() {
        int i = C2738e0.f6708a;
        if (i < 19 || isInEditMode()) {
            return C2667k.f6349a;
        }
        CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
        if (captioningManager == null || !captioningManager.isEnabled()) {
            return C2667k.f6349a;
        }
        CaptioningManager.CaptionStyle userStyle = captioningManager.getUserStyle();
        if (i < 21) {
            return new C2667k(userStyle.foregroundColor, userStyle.backgroundColor, 0, userStyle.edgeType, userStyle.edgeColor, userStyle.getTypeface());
        }
        return new C2667k(userStyle.hasForegroundColor() ? userStyle.foregroundColor : -1, userStyle.hasBackgroundColor() ? userStyle.backgroundColor : ViewCompat.MEASURED_STATE_MASK, userStyle.hasWindowColor() ? userStyle.windowColor : 0, userStyle.hasEdgeType() ? userStyle.edgeType : 0, userStyle.hasEdgeColor() ? userStyle.edgeColor : -1, userStyle.getTypeface());
    }

    private <T extends View & InterfaceC10760a> void setView(T t) {
        removeView(this.f20199s);
        View view = this.f20199s;
        if (view instanceof C2674r) {
            ((C2674r) view).f6403k.destroy();
        }
        this.f20199s = t;
        this.f20198r = t;
        addView(t);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: A */
    public /* synthetic */ void mo235A(C2835p1 c2835p1) {
        C2528a2.m2427i(this, c2835p1);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: D */
    public /* synthetic */ void mo236D(boolean z2) {
        C2528a2.m2438t(this, z2);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: E */
    public /* synthetic */ void mo237E(InterfaceC3128y1 interfaceC3128y1, InterfaceC3128y1.d dVar) {
        C2528a2.m2423e(this, interfaceC3128y1, dVar);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.e
    /* JADX INFO: renamed from: G */
    public /* synthetic */ void mo238G(int i, boolean z2) {
        C2528a2.m2422d(this, i, z2);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: H */
    public /* synthetic */ void mo239H(boolean z2, int i) {
        C3154z1.m3883k(this, z2, i);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: L */
    public /* synthetic */ void mo240L(int i) {
        C2528a2.m2437s(this, i);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: M */
    public /* synthetic */ void mo241M(C2831o1 c2831o1, int i) {
        C2528a2.m2426h(this, c2831o1, i);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: W */
    public /* synthetic */ void mo242W(boolean z2, int i) {
        C2528a2.m2429k(this, z2, i);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: Y */
    public /* synthetic */ void mo243Y(C2558o0 c2558o0, C2648n c2648n) {
        C3154z1.m3890r(this, c2558o0, c2648n);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: a */
    public /* synthetic */ void mo244a() {
        C3154z1.m3887o(this);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.e
    /* JADX INFO: renamed from: a0 */
    public /* synthetic */ void mo245a0(int i, int i2) {
        C2528a2.m2440v(this, i, i2);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.e
    /* JADX INFO: renamed from: b */
    public /* synthetic */ void mo246b(Metadata metadata) {
        C2528a2.m2428j(this, metadata);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: b0 */
    public /* synthetic */ void mo247b0(C2998x1 c2998x1) {
        C2528a2.m2430l(this, c2998x1);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.e
    /* JADX INFO: renamed from: c */
    public /* synthetic */ void mo248c() {
        C2528a2.m2436r(this);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.e
    /* JADX INFO: renamed from: d */
    public /* synthetic */ void mo249d(boolean z2) {
        C2528a2.m2439u(this, z2);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.e
    /* JADX INFO: renamed from: e */
    public void mo250e(List<C2578b> list) {
        setCues(list);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.e
    /* JADX INFO: renamed from: f */
    public /* synthetic */ void mo251f(C2788y c2788y) {
        C2528a2.m2443y(this, c2788y);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: f0 */
    public /* synthetic */ void mo252f0(PlaybackException playbackException) {
        C2528a2.m2434p(this, playbackException);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: g */
    public /* synthetic */ void mo253g(InterfaceC3128y1.f fVar, InterfaceC3128y1.f fVar2, int i) {
        C2528a2.m2435q(this, fVar, fVar2, i);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: h */
    public /* synthetic */ void mo254h(int i) {
        C2528a2.m2432n(this, i);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: i */
    public /* synthetic */ void mo255i(boolean z2) {
        C3154z1.m3876d(this, z2);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: j */
    public /* synthetic */ void mo256j(int i) {
        C3154z1.m3884l(this, i);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: j0 */
    public /* synthetic */ void mo257j0(boolean z2) {
        C2528a2.m2425g(this, z2);
    }

    /* JADX INFO: renamed from: k */
    public void m8929k() {
        setStyle(getUserCaptionStyle());
    }

    /* JADX INFO: renamed from: l */
    public void m8930l() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    /* JADX INFO: renamed from: m */
    public final void m8931m() {
        this.f20198r.mo2758a(getCuesWithStylingPreferencesApplied(), this.f20191k, this.f20193m, this.f20192l, this.f20194n);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: p */
    public /* synthetic */ void mo258p(C2836p2 c2836p2) {
        C2528a2.m2442x(this, c2836p2);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: r */
    public /* synthetic */ void mo259r(boolean z2) {
        C2528a2.m2424f(this, z2);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: s */
    public /* synthetic */ void mo260s(PlaybackException playbackException) {
        C2528a2.m2433o(this, playbackException);
    }

    public void setApplyEmbeddedFontSizes(boolean z2) {
        this.f20196p = z2;
        m8931m();
    }

    public void setApplyEmbeddedStyles(boolean z2) {
        this.f20195o = z2;
        m8931m();
    }

    public void setBottomPaddingFraction(float f) {
        this.f20194n = f;
        m8931m();
    }

    public void setCues(@Nullable List<C2578b> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.f20190j = list;
        m8931m();
    }

    public void setFractionalTextSize(float f) {
        this.f20192l = 0;
        this.f20193m = f;
        m8931m();
    }

    public void setStyle(C2667k c2667k) {
        this.f20191k = c2667k;
        m8931m();
    }

    public void setViewType(int i) {
        if (this.f20197q == i) {
            return;
        }
        if (i == 1) {
            setView(new C2666j(getContext(), null));
        } else {
            if (i != 2) {
                throw new IllegalArgumentException();
            }
            setView(new C2674r(getContext()));
        }
        this.f20197q = i;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: t */
    public /* synthetic */ void mo261t(InterfaceC3128y1.b bVar) {
        C2528a2.m2419a(this, bVar);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: v */
    public /* synthetic */ void mo262v(AbstractC2832o2 abstractC2832o2, int i) {
        C2528a2.m2441w(this, abstractC2832o2, i);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.e
    /* JADX INFO: renamed from: w */
    public /* synthetic */ void mo263w(float f) {
        C2528a2.m2444z(this, f);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: y */
    public /* synthetic */ void mo264y(int i) {
        C2528a2.m2431m(this, i);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.e
    /* JADX INFO: renamed from: z */
    public /* synthetic */ void mo265z(C2633c1 c2633c1) {
        C2528a2.m2421c(this, c2633c1);
    }
}
