package com.google.android.exoplayer2.ui;

import android.R$color;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import b.c.a.a0.d;
import b.i.a.c.d3.i;
import b.i.a.c.f3.e0;
import b.i.a.c.f3.m;
import b.i.a.c.g3.y;
import b.i.a.c.p2;
import b.i.a.c.p2$a;
import b.i.a.c.y1;
import b.i.b.b.p;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.google.android.exoplayer2.PlaybackException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: classes3.dex */
public class PlayerView extends FrameLayout {
    public static final /* synthetic */ int j = 0;

    @Nullable
    public Drawable A;
    public int B;
    public boolean C;

    @Nullable
    public m<? super PlaybackException> D;

    @Nullable
    public CharSequence E;
    public int F;
    public boolean G;
    public boolean H;
    public boolean I;
    public int J;
    public boolean K;
    public final PlayerView$a k;

    @Nullable
    public final AspectRatioFrameLayout l;

    @Nullable
    public final View m;

    @Nullable
    public final View n;
    public final boolean o;

    @Nullable
    public final ImageView p;

    @Nullable
    public final SubtitleView q;

    @Nullable
    public final View r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public final TextView f2972s;

    @Nullable
    public final PlayerControlView t;

    @Nullable
    public final FrameLayout u;

    @Nullable
    public final FrameLayout v;

    @Nullable
    public y1 w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f2973x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    public PlayerControlView$e f2974y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f2975z;

    public PlayerView(Context context, @Nullable AttributeSet attributeSet) {
        int i;
        int i2;
        boolean z2;
        boolean z3;
        boolean z4;
        int i3;
        int i4;
        int i5;
        boolean z5;
        boolean z6;
        int i6;
        int i7;
        boolean z7;
        boolean z8;
        super(context, attributeSet, 0);
        PlayerView$a playerView$a = new PlayerView$a(this);
        this.k = playerView$a;
        if (isInEditMode()) {
            this.l = null;
            this.m = null;
            this.n = null;
            this.o = false;
            this.p = null;
            this.q = null;
            this.r = null;
            this.f2972s = null;
            this.t = null;
            this.u = null;
            this.v = null;
            ImageView imageView = new ImageView(context);
            if (e0.a >= 23) {
                Resources resources = getResources();
                imageView.setImageDrawable(resources.getDrawable(R$b.exo_edit_mode_logo, null));
                imageView.setBackgroundColor(resources.getColor(R$a.exo_edit_mode_background_color, null));
            } else {
                Resources resources2 = getResources();
                imageView.setImageDrawable(resources2.getDrawable(R$b.exo_edit_mode_logo));
                imageView.setBackgroundColor(resources2.getColor(R$a.exo_edit_mode_background_color));
            }
            addView(imageView);
            return;
        }
        int i8 = R$e.exo_player_view;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$g.PlayerView, 0, 0);
            try {
                int i9 = R$g.PlayerView_shutter_background_color;
                boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i9);
                int color = typedArrayObtainStyledAttributes.getColor(i9, 0);
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$g.PlayerView_player_layout_id, i8);
                boolean z9 = typedArrayObtainStyledAttributes.getBoolean(R$g.PlayerView_use_artwork, true);
                int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R$g.PlayerView_default_artwork, 0);
                boolean z10 = typedArrayObtainStyledAttributes.getBoolean(R$g.PlayerView_use_controller, true);
                int i10 = typedArrayObtainStyledAttributes.getInt(R$g.PlayerView_surface_type, 1);
                int i11 = typedArrayObtainStyledAttributes.getInt(R$g.PlayerView_resize_mode, 0);
                int i12 = typedArrayObtainStyledAttributes.getInt(R$g.PlayerView_show_timeout, 5000);
                boolean z11 = typedArrayObtainStyledAttributes.getBoolean(R$g.PlayerView_hide_on_touch, true);
                boolean z12 = typedArrayObtainStyledAttributes.getBoolean(R$g.PlayerView_auto_show, true);
                int integer = typedArrayObtainStyledAttributes.getInteger(R$g.PlayerView_show_buffering, 0);
                this.C = typedArrayObtainStyledAttributes.getBoolean(R$g.PlayerView_keep_content_on_player_reset, this.C);
                boolean z13 = typedArrayObtainStyledAttributes.getBoolean(R$g.PlayerView_hide_during_ads, true);
                typedArrayObtainStyledAttributes.recycle();
                i3 = i11;
                z2 = z11;
                z3 = z12;
                i7 = i12;
                z7 = z10;
                i = resourceId;
                i6 = resourceId2;
                z6 = z9;
                z5 = zHasValue;
                i5 = color;
                i4 = i10;
                z4 = z13;
                i2 = integer;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            i = i8;
            i2 = 0;
            z2 = true;
            z3 = true;
            z4 = true;
            i3 = 0;
            i4 = 1;
            i5 = 0;
            z5 = false;
            z6 = true;
            i6 = 0;
            i7 = 5000;
            z7 = true;
        }
        LayoutInflater.from(context).inflate(i, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(R$c.exo_content_frame);
        this.l = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setResizeMode(i3);
        }
        View viewFindViewById = findViewById(R$c.exo_shutter);
        this.m = viewFindViewById;
        if (viewFindViewById != null && z5) {
            viewFindViewById.setBackgroundColor(i5);
        }
        if (aspectRatioFrameLayout == null || i4 == 0) {
            this.n = null;
            z8 = false;
        } else {
            ViewGroup$LayoutParams viewGroup$LayoutParams = new ViewGroup$LayoutParams(-1, -1);
            if (i4 != 2) {
                if (i4 == 3) {
                    try {
                        this.n = (View) Class.forName("b.i.a.c.g3.z.k").getConstructor(Context.class).newInstance(context);
                        z8 = true;
                    } catch (Exception e) {
                        throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e);
                    }
                } else if (i4 != 4) {
                    this.n = new SurfaceView(context);
                } else {
                    try {
                        this.n = (View) Class.forName("b.i.a.c.g3.s").getConstructor(Context.class).newInstance(context);
                    } catch (Exception e2) {
                        throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e2);
                    }
                }
                this.n.setLayoutParams(viewGroup$LayoutParams);
                this.n.setOnClickListener(playerView$a);
                this.n.setClickable(false);
                aspectRatioFrameLayout.addView(this.n, 0);
            } else {
                this.n = new TextureView(context);
            }
            z8 = false;
            this.n.setLayoutParams(viewGroup$LayoutParams);
            this.n.setOnClickListener(playerView$a);
            this.n.setClickable(false);
            aspectRatioFrameLayout.addView(this.n, 0);
        }
        this.o = z8;
        this.u = (FrameLayout) findViewById(R$c.exo_ad_overlay);
        this.v = (FrameLayout) findViewById(R$c.exo_overlay);
        ImageView imageView2 = (ImageView) findViewById(R$c.exo_artwork);
        this.p = imageView2;
        this.f2975z = z6 && imageView2 != null;
        if (i6 != 0) {
            this.A = ContextCompat.getDrawable(getContext(), i6);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(R$c.exo_subtitles);
        this.q = subtitleView;
        if (subtitleView != null) {
            subtitleView.k();
            subtitleView.l();
        }
        View viewFindViewById2 = findViewById(R$c.exo_buffering);
        this.r = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(8);
        }
        this.B = i2;
        TextView textView = (TextView) findViewById(R$c.exo_error_message);
        this.f2972s = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        int i13 = R$c.exo_controller;
        PlayerControlView playerControlView = (PlayerControlView) findViewById(i13);
        View viewFindViewById3 = findViewById(R$c.exo_controller_placeholder);
        if (playerControlView != null) {
            this.t = playerControlView;
        } else if (viewFindViewById3 != null) {
            PlayerControlView playerControlView2 = new PlayerControlView(context, null, 0, attributeSet);
            this.t = playerControlView2;
            playerControlView2.setId(i13);
            playerControlView2.setLayoutParams(viewFindViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById3.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById3);
            viewGroup.removeView(viewFindViewById3);
            viewGroup.addView(playerControlView2, iIndexOfChild);
        } else {
            this.t = null;
        }
        PlayerControlView playerControlView3 = this.t;
        this.F = playerControlView3 != null ? i7 : 0;
        this.I = z2;
        this.G = z3;
        this.H = z4;
        this.f2973x = z7 && playerControlView3 != null;
        d();
        m();
        PlayerControlView playerControlView4 = this.t;
        if (playerControlView4 != null) {
            playerControlView4.l.add(playerView$a);
        }
    }

    public static void a(TextureView textureView, int i) {
        Matrix matrix = new Matrix();
        float width = textureView.getWidth();
        float height = textureView.getHeight();
        if (width != 0.0f && height != 0.0f && i != 0) {
            float f = width / 2.0f;
            float f2 = height / 2.0f;
            matrix.postRotate(i, f, f2);
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            matrix.postScale(width / rectF2.width(), height / rectF2.height(), f, f2);
        }
        textureView.setTransform(matrix);
    }

    public final void b() {
        View view = this.m;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public final void c() {
        ImageView imageView = this.p;
        if (imageView != null) {
            imageView.setImageResource(R$color.transparent);
            this.p.setVisibility(4);
        }
    }

    public void d() {
        PlayerControlView playerControlView = this.t;
        if (playerControlView != null) {
            playerControlView.c();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        y1 y1Var = this.w;
        if (y1Var != null && y1Var.f()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        boolean z2 = keyCode == 19 || keyCode == 270 || keyCode == 22 || keyCode == 271 || keyCode == 20 || keyCode == 269 || keyCode == 21 || keyCode == 268 || keyCode == 23;
        if (z2 && p() && !this.t.e()) {
            f(true);
        } else {
            if (!(p() && this.t.a(keyEvent)) && !super.dispatchKeyEvent(keyEvent)) {
                if (!z2 || !p()) {
                    return false;
                }
                f(true);
                return false;
            }
            f(true);
        }
        return true;
    }

    public final boolean e() {
        y1 y1Var = this.w;
        return y1Var != null && y1Var.f() && this.w.j();
    }

    public final void f(boolean z2) {
        if (!(e() && this.H) && p()) {
            boolean z3 = this.t.e() && this.t.getShowTimeoutMs() <= 0;
            boolean zH = h();
            if (z2 || z3 || zH) {
                i(zH);
            }
        }
    }

    @RequiresNonNull({"artworkView"})
    public final boolean g(@Nullable Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                float f = intrinsicWidth / intrinsicHeight;
                AspectRatioFrameLayout aspectRatioFrameLayout = this.l;
                if (aspectRatioFrameLayout != null) {
                    aspectRatioFrameLayout.setAspectRatio(f);
                }
                this.p.setImageDrawable(drawable);
                this.p.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    public List<i> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.v;
        if (frameLayout != null) {
            arrayList.add(new i(frameLayout, 3, "Transparent overlay does not impact viewability"));
        }
        PlayerControlView playerControlView = this.t;
        if (playerControlView != null) {
            arrayList.add(new i(playerControlView, 0));
        }
        return p.n(arrayList);
    }

    public ViewGroup getAdViewGroup() {
        FrameLayout frameLayout = this.u;
        if (frameLayout != null) {
            return frameLayout;
        }
        throw new IllegalStateException("exo_ad_overlay must be present for ad playback");
    }

    public boolean getControllerAutoShow() {
        return this.G;
    }

    public boolean getControllerHideOnTouch() {
        return this.I;
    }

    public int getControllerShowTimeoutMs() {
        return this.F;
    }

    @Nullable
    public Drawable getDefaultArtwork() {
        return this.A;
    }

    @Nullable
    public FrameLayout getOverlayFrameLayout() {
        return this.v;
    }

    @Nullable
    public y1 getPlayer() {
        return this.w;
    }

    public int getResizeMode() {
        d.H(this.l);
        return this.l.getResizeMode();
    }

    @Nullable
    public SubtitleView getSubtitleView() {
        return this.q;
    }

    public boolean getUseArtwork() {
        return this.f2975z;
    }

    public boolean getUseController() {
        return this.f2973x;
    }

    @Nullable
    public View getVideoSurfaceView() {
        return this.n;
    }

    public final boolean h() {
        y1 y1Var = this.w;
        if (y1Var == null) {
            return true;
        }
        int iY = y1Var.y();
        return this.G && (iY == 1 || iY == 4 || !this.w.j());
    }

    public final void i(boolean z2) {
        if (p()) {
            this.t.setShowTimeoutMs(z2 ? 0 : this.F);
            this.t.i();
        }
    }

    public final boolean j() {
        if (!p() || this.w == null) {
            return false;
        }
        if (!this.t.e()) {
            f(true);
        } else if (this.I) {
            this.t.c();
        }
        return true;
    }

    public final void k() {
        y1 y1Var = this.w;
        y yVarO = y1Var != null ? y1Var.o() : y.j;
        int i = yVarO.k;
        int i2 = yVarO.l;
        int i3 = yVarO.m;
        float f = (i2 == 0 || i == 0) ? 0.0f : (i * yVarO.n) / i2;
        View view = this.n;
        if (view instanceof TextureView) {
            if (f > 0.0f && (i3 == 90 || i3 == 270)) {
                f = 1.0f / f;
            }
            if (this.J != 0) {
                view.removeOnLayoutChangeListener(this.k);
            }
            this.J = i3;
            if (i3 != 0) {
                this.n.addOnLayoutChangeListener(this.k);
            }
            a((TextureView) this.n, this.J);
        }
        AspectRatioFrameLayout aspectRatioFrameLayout = this.l;
        float f2 = this.o ? 0.0f : f;
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f2);
        }
    }

    public final void l() {
        int i;
        if (this.r != null) {
            y1 y1Var = this.w;
            boolean z2 = true;
            if (y1Var == null || y1Var.y() != 2 || ((i = this.B) != 2 && (i != 1 || !this.w.j()))) {
                z2 = false;
            }
            this.r.setVisibility(z2 ? 0 : 8);
        }
    }

    public final void m() {
        PlayerControlView playerControlView = this.t;
        if (playerControlView == null || !this.f2973x) {
            setContentDescription(null);
        } else if (playerControlView.getVisibility() == 0) {
            setContentDescription(this.I ? getResources().getString(R$f.exo_controls_hide) : null);
        } else {
            setContentDescription(getResources().getString(R$f.exo_controls_show));
        }
    }

    public final void n() {
        m<? super PlaybackException> mVar;
        TextView textView = this.f2972s;
        if (textView != null) {
            CharSequence charSequence = this.E;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.f2972s.setVisibility(0);
                return;
            }
            y1 y1Var = this.w;
            PlaybackException playbackExceptionT = y1Var != null ? y1Var.t() : null;
            if (playbackExceptionT == null || (mVar = this.D) == null) {
                this.f2972s.setVisibility(8);
            } else {
                this.f2972s.setText((CharSequence) mVar.a(playbackExceptionT).second);
                this.f2972s.setVisibility(0);
            }
        }
    }

    public final void o(boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        y1 y1Var = this.w;
        if (y1Var == null || !y1Var.D(30) || y1Var.H().k.isEmpty()) {
            if (this.C) {
                return;
            }
            c();
            b();
            return;
        }
        if (z2 && !this.C) {
            b();
        }
        p2 p2VarH = y1Var.H();
        boolean zG = false;
        int i = 0;
        while (true) {
            z3 = true;
            if (i >= p2VarH.k.size()) {
                z4 = false;
                break;
            }
            p2$a p2_a = p2VarH.k.get(i);
            boolean[] zArr = p2_a.m;
            int length = zArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z5 = false;
                    break;
                } else {
                    if (zArr[i2]) {
                        z5 = true;
                        break;
                    }
                    i2++;
                }
            }
            if (z5 && p2_a.l == 2) {
                z4 = true;
                break;
            }
            i++;
        }
        if (z4) {
            c();
            return;
        }
        b();
        if (this.f2975z) {
            d.H(this.p);
        } else {
            z3 = false;
        }
        if (z3) {
            byte[] bArr = y1Var.S().v;
            if (bArr != null) {
                zG = g(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
            }
            if (zG || g(this.A)) {
                return;
            }
        }
        c();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!p() || this.w == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.K = true;
            return true;
        }
        if (action != 1 || !this.K) {
            return false;
        }
        this.K = false;
        performClick();
        return true;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!p() || this.w == null) {
            return false;
        }
        f(true);
        return true;
    }

    @EnsuresNonNullIf(expression = {"controller"}, result = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS)
    public final boolean p() {
        if (!this.f2973x) {
            return false;
        }
        d.H(this.t);
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        return j();
    }

    public void setAspectRatioListener(@Nullable AspectRatioFrameLayout$b aspectRatioFrameLayout$b) {
        d.H(this.l);
        this.l.setAspectRatioListener(aspectRatioFrameLayout$b);
    }

    public void setControllerAutoShow(boolean z2) {
        this.G = z2;
    }

    public void setControllerHideDuringAds(boolean z2) {
        this.H = z2;
    }

    public void setControllerHideOnTouch(boolean z2) {
        d.H(this.t);
        this.I = z2;
        m();
    }

    public void setControllerShowTimeoutMs(int i) {
        d.H(this.t);
        this.F = i;
        if (this.t.e()) {
            i(h());
        }
    }

    public void setControllerVisibilityListener(@Nullable PlayerControlView$e playerControlView$e) {
        d.H(this.t);
        PlayerControlView$e playerControlView$e2 = this.f2974y;
        if (playerControlView$e2 == playerControlView$e) {
            return;
        }
        if (playerControlView$e2 != null) {
            this.t.l.remove(playerControlView$e2);
        }
        this.f2974y = playerControlView$e;
        if (playerControlView$e != null) {
            PlayerControlView playerControlView = this.t;
            Objects.requireNonNull(playerControlView);
            playerControlView.l.add(playerControlView$e);
        }
    }

    public void setCustomErrorMessage(@Nullable CharSequence charSequence) {
        d.D(this.f2972s != null);
        this.E = charSequence;
        n();
    }

    public void setDefaultArtwork(@Nullable Drawable drawable) {
        if (this.A != drawable) {
            this.A = drawable;
            o(false);
        }
    }

    public void setErrorMessageProvider(@Nullable m<? super PlaybackException> mVar) {
        if (this.D != mVar) {
            this.D = mVar;
            n();
        }
    }

    public void setKeepContentOnPlayerReset(boolean z2) {
        if (this.C != z2) {
            this.C = z2;
            o(false);
        }
    }

    public void setPlayer(@Nullable y1 y1Var) {
        d.D(Looper.myLooper() == Looper.getMainLooper());
        d.j(y1Var == null || y1Var.L() == Looper.getMainLooper());
        y1 y1Var2 = this.w;
        if (y1Var2 == y1Var) {
            return;
        }
        if (y1Var2 != null) {
            y1Var2.p(this.k);
            if (y1Var2.D(27)) {
                View view = this.n;
                if (view instanceof TextureView) {
                    y1Var2.n((TextureView) view);
                } else if (view instanceof SurfaceView) {
                    y1Var2.F((SurfaceView) view);
                }
            }
        }
        SubtitleView subtitleView = this.q;
        if (subtitleView != null) {
            subtitleView.setCues(null);
        }
        this.w = y1Var;
        if (p()) {
            this.t.setPlayer(y1Var);
        }
        l();
        n();
        o(true);
        if (y1Var == null) {
            d();
            return;
        }
        if (y1Var.D(27)) {
            View view2 = this.n;
            if (view2 instanceof TextureView) {
                y1Var.Q((TextureView) view2);
            } else if (view2 instanceof SurfaceView) {
                y1Var.r((SurfaceView) view2);
            }
            k();
        }
        if (this.q != null && y1Var.D(28)) {
            this.q.setCues(y1Var.A());
        }
        y1Var.x(this.k);
        f(false);
    }

    public void setRepeatToggleModes(int i) {
        d.H(this.t);
        this.t.setRepeatToggleModes(i);
    }

    public void setResizeMode(int i) {
        d.H(this.l);
        this.l.setResizeMode(i);
    }

    public void setShowBuffering(int i) {
        if (this.B != i) {
            this.B = i;
            l();
        }
    }

    public void setShowFastForwardButton(boolean z2) {
        d.H(this.t);
        this.t.setShowFastForwardButton(z2);
    }

    public void setShowMultiWindowTimeBar(boolean z2) {
        d.H(this.t);
        this.t.setShowMultiWindowTimeBar(z2);
    }

    public void setShowNextButton(boolean z2) {
        d.H(this.t);
        this.t.setShowNextButton(z2);
    }

    public void setShowPreviousButton(boolean z2) {
        d.H(this.t);
        this.t.setShowPreviousButton(z2);
    }

    public void setShowRewindButton(boolean z2) {
        d.H(this.t);
        this.t.setShowRewindButton(z2);
    }

    public void setShowShuffleButton(boolean z2) {
        d.H(this.t);
        this.t.setShowShuffleButton(z2);
    }

    public void setShutterBackgroundColor(int i) {
        View view = this.m;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public void setUseArtwork(boolean z2) {
        d.D((z2 && this.p == null) ? false : true);
        if (this.f2975z != z2) {
            this.f2975z = z2;
            o(false);
        }
    }

    public void setUseController(boolean z2) {
        d.D((z2 && this.t == null) ? false : true);
        if (this.f2973x == z2) {
            return;
        }
        this.f2973x = z2;
        if (p()) {
            this.t.setPlayer(this.w);
        } else {
            PlayerControlView playerControlView = this.t;
            if (playerControlView != null) {
                playerControlView.c();
                this.t.setPlayer(null);
            }
        }
        m();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        View view = this.n;
        if (view instanceof SurfaceView) {
            view.setVisibility(i);
        }
    }
}
