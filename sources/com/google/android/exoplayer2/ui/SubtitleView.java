package com.google.android.exoplayer2.ui;

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
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.DeviceInfo2;
import b.i.a.c.MediaItem2;
import b.i.a.c.MediaMetadata;
import b.i.a.c.PlaybackParameters;
import b.i.a.c.Player;
import b.i.a.c.Player2;
import b.i.a.c.Player3;
import b.i.a.c.Timeline;
import b.i.a.c.TracksInfo;
import b.i.a.c.a3.TrackGroupArray;
import b.i.a.c.b3.Cue;
import b.i.a.c.b3.q.LanguageFeatureSpan;
import b.i.a.c.c3.TrackSelectionArray;
import b.i.a.c.d3.CanvasSubtitleOutput;
import b.i.a.c.d3.CaptionStyleCompat;
import b.i.a.c.d3.WebViewSubtitleOutput2;
import b.i.a.c.f3.Util2;
import b.i.a.c.g3.VideoSize;
import b.i.b.a.Predicate3;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class SubtitleView extends FrameLayout implements Player2.e {
    public List<Cue> j;
    public CaptionStyleCompat k;
    public int l;
    public float m;
    public float n;
    public boolean o;
    public boolean p;
    public int q;
    public a r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f2976s;

    public interface a {
        void a(List<Cue> list, CaptionStyleCompat captionStyleCompat, float f, int i, float f2);
    }

    public SubtitleView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = Collections.emptyList();
        this.k = CaptionStyleCompat.a;
        this.l = 0;
        this.m = 0.0533f;
        this.n = 0.08f;
        this.o = true;
        this.p = true;
        CanvasSubtitleOutput canvasSubtitleOutput = new CanvasSubtitleOutput(context, null);
        this.r = canvasSubtitleOutput;
        this.f2976s = canvasSubtitleOutput;
        addView(canvasSubtitleOutput);
        this.q = 1;
    }

    private List<Cue> getCuesWithStylingPreferencesApplied() {
        if (this.o && this.p) {
            return this.j;
        }
        ArrayList arrayList = new ArrayList(this.j.size());
        for (int i = 0; i < this.j.size(); i++) {
            Cue.b bVarA = this.j.get(i).a();
            if (!this.o) {
                bVarA.n = false;
                CharSequence charSequence = bVarA.a;
                if (charSequence instanceof Spanned) {
                    if (!(charSequence instanceof Spannable)) {
                        bVarA.a = SpannableString.valueOf(charSequence);
                    }
                    CharSequence charSequence2 = bVarA.a;
                    Objects.requireNonNull(charSequence2);
                    AnimatableValueParser.P1((Spannable) charSequence2, new Predicate3() { // from class: b.i.a.c.d3.g
                        @Override // b.i.b.a.Predicate3
                        public final boolean apply(Object obj) {
                            return !(obj instanceof LanguageFeatureSpan);
                        }
                    });
                }
                AnimatableValueParser.O1(bVarA);
            } else if (!this.p) {
                AnimatableValueParser.O1(bVarA);
            }
            arrayList.add(bVarA.a());
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (Util2.a < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private CaptionStyleCompat getUserCaptionStyle() {
        int i = Util2.a;
        if (i < 19 || isInEditMode()) {
            return CaptionStyleCompat.a;
        }
        CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
        if (captioningManager == null || !captioningManager.isEnabled()) {
            return CaptionStyleCompat.a;
        }
        CaptioningManager.CaptionStyle userStyle = captioningManager.getUserStyle();
        if (i < 21) {
            return new CaptionStyleCompat(userStyle.foregroundColor, userStyle.backgroundColor, 0, userStyle.edgeType, userStyle.edgeColor, userStyle.getTypeface());
        }
        return new CaptionStyleCompat(userStyle.hasForegroundColor() ? userStyle.foregroundColor : -1, userStyle.hasBackgroundColor() ? userStyle.backgroundColor : ViewCompat.MEASURED_STATE_MASK, userStyle.hasWindowColor() ? userStyle.windowColor : 0, userStyle.hasEdgeType() ? userStyle.edgeType : 0, userStyle.hasEdgeColor() ? userStyle.edgeColor : -1, userStyle.getTypeface());
    }

    private <T extends View & a> void setView(T t) {
        removeView(this.f2976s);
        View view = this.f2976s;
        if (view instanceof WebViewSubtitleOutput2) {
            ((WebViewSubtitleOutput2) view).k.destroy();
        }
        this.f2976s = t;
        this.r = t;
        addView(t);
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
    public /* synthetic */ void E(Player2 player2, Player2.d dVar) {
        Player.e(this, player2, dVar);
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
    public void e(List<Cue> list) {
        setCues(list);
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

    public void k() {
        setStyle(getUserCaptionStyle());
    }

    public void l() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public final void m() {
        this.r.a(getCuesWithStylingPreferencesApplied(), this.k, this.m, this.l, this.n);
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

    public void setCues(@Nullable List<Cue> list) {
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

    public void setStyle(CaptionStyleCompat captionStyleCompat) {
        this.k = captionStyleCompat;
        m();
    }

    public void setViewType(int i) {
        if (this.q == i) {
            return;
        }
        if (i == 1) {
            setView(new CanvasSubtitleOutput(getContext(), null));
        } else {
            if (i != 2) {
                throw new IllegalArgumentException();
            }
            setView(new WebViewSubtitleOutput2(getContext()));
        }
        this.q = i;
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
