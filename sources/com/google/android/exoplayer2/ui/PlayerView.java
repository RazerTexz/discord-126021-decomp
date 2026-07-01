package com.google.android.exoplayer2.ui;

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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
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
import b.i.a.c.c3.TrackSelectionArray;
import b.i.a.c.d3.AdOverlayInfo;
import b.i.a.c.f3.ErrorMessageProvider;
import b.i.a.c.f3.Util2;
import b.i.a.c.g3.VideoSize;
import b.i.b.b.ImmutableList2;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.PlayerControlView;
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
    public ErrorMessageProvider<? super PlaybackException> D;

    @Nullable
    public CharSequence E;
    public int F;
    public boolean G;
    public boolean H;
    public boolean I;
    public int J;
    public boolean K;
    public final a k;

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
    public Player2 w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f2973x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    public PlayerControlView.e f2974y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f2975z;

    public final class a implements Player2.e, View.OnLayoutChangeListener, View.OnClickListener, PlayerControlView.e {
        public final Timeline.b j = new Timeline.b();

        @Nullable
        public Object k;

        public a() {
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
        public void W(boolean z2, int i) {
            PlayerView playerView = PlayerView.this;
            int i2 = PlayerView.j;
            playerView.l();
            PlayerView playerView2 = PlayerView.this;
            if (playerView2.e() && playerView2.H) {
                playerView2.d();
            } else {
                playerView2.f(false);
            }
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
        public void c() {
            View view = PlayerView.this.m;
            if (view != null) {
                view.setVisibility(4);
            }
        }

        @Override // b.i.a.c.Player2.e
        public /* synthetic */ void d(boolean z2) {
            Player.u(this, z2);
        }

        @Override // b.i.a.c.Player2.e
        public void e(List<Cue> list) {
            SubtitleView subtitleView = PlayerView.this.q;
            if (subtitleView != null) {
                subtitleView.setCues(list);
            }
        }

        @Override // b.i.a.c.Player2.e
        public void f(VideoSize videoSize) {
            PlayerView playerView = PlayerView.this;
            int i = PlayerView.j;
            playerView.k();
        }

        @Override // b.i.a.c.Player2.c
        public /* synthetic */ void f0(PlaybackException playbackException) {
            Player.p(this, playbackException);
        }

        @Override // b.i.a.c.Player2.c
        public void g(Player2.f fVar, Player2.f fVar2, int i) {
            PlayerView playerView = PlayerView.this;
            int i2 = PlayerView.j;
            if (playerView.e()) {
                PlayerView playerView2 = PlayerView.this;
                if (playerView2.H) {
                    playerView2.d();
                }
            }
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

        @Override // com.google.android.exoplayer2.ui.PlayerControlView.e
        public void k(int i) {
            PlayerView playerView = PlayerView.this;
            int i2 = PlayerView.j;
            playerView.m();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PlayerView playerView = PlayerView.this;
            int i = PlayerView.j;
            playerView.j();
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            PlayerView.a((TextureView) view, PlayerView.this.J);
        }

        @Override // b.i.a.c.Player2.c
        public void p(TracksInfo tracksInfo) {
            Player2 player2 = PlayerView.this.w;
            Objects.requireNonNull(player2);
            Timeline timelineK = player2.K();
            if (timelineK.q()) {
                this.k = null;
            } else if (player2.H().k.isEmpty()) {
                Object obj = this.k;
                if (obj != null) {
                    int iB = timelineK.b(obj);
                    if (iB != -1) {
                        if (player2.C() == timelineK.f(iB, this.j).l) {
                            return;
                        }
                    }
                    this.k = null;
                }
            } else {
                this.k = timelineK.g(player2.m(), this.j, true).k;
            }
            PlayerView.this.o(false);
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
        public void y(int i) {
            PlayerView playerView = PlayerView.this;
            int i2 = PlayerView.j;
            playerView.l();
            PlayerView.this.n();
            PlayerView playerView2 = PlayerView.this;
            if (playerView2.e() && playerView2.H) {
                playerView2.d();
            } else {
                playerView2.f(false);
            }
        }

        @Override // b.i.a.c.Player2.e
        public /* synthetic */ void z(DeviceInfo2 deviceInfo2) {
            Player.c(this, deviceInfo2);
        }
    }

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
        a aVar = new a();
        this.k = aVar;
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
            if (Util2.a >= 23) {
                Resources resources = getResources();
                imageView.setImageDrawable(resources.getDrawable(R.b.exo_edit_mode_logo, null));
                imageView.setBackgroundColor(resources.getColor(R.a.exo_edit_mode_background_color, null));
            } else {
                Resources resources2 = getResources();
                imageView.setImageDrawable(resources2.getDrawable(R.b.exo_edit_mode_logo));
                imageView.setBackgroundColor(resources2.getColor(R.a.exo_edit_mode_background_color));
            }
            addView(imageView);
            return;
        }
        int i8 = R.e.exo_player_view;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.g.PlayerView, 0, 0);
            try {
                int i9 = R.g.PlayerView_shutter_background_color;
                boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i9);
                int color = typedArrayObtainStyledAttributes.getColor(i9, 0);
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.g.PlayerView_player_layout_id, i8);
                boolean z9 = typedArrayObtainStyledAttributes.getBoolean(R.g.PlayerView_use_artwork, true);
                int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R.g.PlayerView_default_artwork, 0);
                boolean z10 = typedArrayObtainStyledAttributes.getBoolean(R.g.PlayerView_use_controller, true);
                int i10 = typedArrayObtainStyledAttributes.getInt(R.g.PlayerView_surface_type, 1);
                int i11 = typedArrayObtainStyledAttributes.getInt(R.g.PlayerView_resize_mode, 0);
                int i12 = typedArrayObtainStyledAttributes.getInt(R.g.PlayerView_show_timeout, 5000);
                boolean z11 = typedArrayObtainStyledAttributes.getBoolean(R.g.PlayerView_hide_on_touch, true);
                boolean z12 = typedArrayObtainStyledAttributes.getBoolean(R.g.PlayerView_auto_show, true);
                int integer = typedArrayObtainStyledAttributes.getInteger(R.g.PlayerView_show_buffering, 0);
                this.C = typedArrayObtainStyledAttributes.getBoolean(R.g.PlayerView_keep_content_on_player_reset, this.C);
                boolean z13 = typedArrayObtainStyledAttributes.getBoolean(R.g.PlayerView_hide_during_ads, true);
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
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(R.c.exo_content_frame);
        this.l = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setResizeMode(i3);
        }
        View viewFindViewById = findViewById(R.c.exo_shutter);
        this.m = viewFindViewById;
        if (viewFindViewById != null && z5) {
            viewFindViewById.setBackgroundColor(i5);
        }
        if (aspectRatioFrameLayout == null || i4 == 0) {
            this.n = null;
            z8 = false;
        } else {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
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
                this.n.setLayoutParams(layoutParams);
                this.n.setOnClickListener(aVar);
                this.n.setClickable(false);
                aspectRatioFrameLayout.addView(this.n, 0);
            } else {
                this.n = new TextureView(context);
            }
            z8 = false;
            this.n.setLayoutParams(layoutParams);
            this.n.setOnClickListener(aVar);
            this.n.setClickable(false);
            aspectRatioFrameLayout.addView(this.n, 0);
        }
        this.o = z8;
        this.u = (FrameLayout) findViewById(R.c.exo_ad_overlay);
        this.v = (FrameLayout) findViewById(R.c.exo_overlay);
        ImageView imageView2 = (ImageView) findViewById(R.c.exo_artwork);
        this.p = imageView2;
        this.f2975z = z6 && imageView2 != null;
        if (i6 != 0) {
            this.A = ContextCompat.getDrawable(getContext(), i6);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(R.c.exo_subtitles);
        this.q = subtitleView;
        if (subtitleView != null) {
            subtitleView.k();
            subtitleView.l();
        }
        View viewFindViewById2 = findViewById(R.c.exo_buffering);
        this.r = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(8);
        }
        this.B = i2;
        TextView textView = (TextView) findViewById(R.c.exo_error_message);
        this.f2972s = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        int i13 = R.c.exo_controller;
        PlayerControlView playerControlView = (PlayerControlView) findViewById(i13);
        View viewFindViewById3 = findViewById(R.c.exo_controller_placeholder);
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
            playerControlView4.l.add(aVar);
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
            imageView.setImageResource(android.R.color.transparent);
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
        Player2 player2 = this.w;
        if (player2 != null && player2.f()) {
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
        Player2 player2 = this.w;
        return player2 != null && player2.f() && this.w.j();
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

    public List<AdOverlayInfo> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.v;
        if (frameLayout != null) {
            arrayList.add(new AdOverlayInfo(frameLayout, 3, "Transparent overlay does not impact viewability"));
        }
        PlayerControlView playerControlView = this.t;
        if (playerControlView != null) {
            arrayList.add(new AdOverlayInfo(playerControlView, 0));
        }
        return ImmutableList2.n(arrayList);
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
    public Player2 getPlayer() {
        return this.w;
    }

    public int getResizeMode() {
        AnimatableValueParser.H(this.l);
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
        Player2 player2 = this.w;
        if (player2 == null) {
            return true;
        }
        int iY = player2.y();
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
        Player2 player2 = this.w;
        VideoSize videoSizeO = player2 != null ? player2.o() : VideoSize.j;
        int i = videoSizeO.k;
        int i2 = videoSizeO.l;
        int i3 = videoSizeO.m;
        float f = (i2 == 0 || i == 0) ? 0.0f : (i * videoSizeO.n) / i2;
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
            Player2 player2 = this.w;
            boolean z2 = true;
            if (player2 == null || player2.y() != 2 || ((i = this.B) != 2 && (i != 1 || !this.w.j()))) {
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
            setContentDescription(this.I ? getResources().getString(R.f.exo_controls_hide) : null);
        } else {
            setContentDescription(getResources().getString(R.f.exo_controls_show));
        }
    }

    public final void n() {
        ErrorMessageProvider<? super PlaybackException> errorMessageProvider;
        TextView textView = this.f2972s;
        if (textView != null) {
            CharSequence charSequence = this.E;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.f2972s.setVisibility(0);
                return;
            }
            Player2 player2 = this.w;
            PlaybackException playbackExceptionT = player2 != null ? player2.t() : null;
            if (playbackExceptionT == null || (errorMessageProvider = this.D) == null) {
                this.f2972s.setVisibility(8);
            } else {
                this.f2972s.setText((CharSequence) errorMessageProvider.a(playbackExceptionT).second);
                this.f2972s.setVisibility(0);
            }
        }
    }

    public final void o(boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        Player2 player2 = this.w;
        if (player2 == null || !player2.D(30) || player2.H().k.isEmpty()) {
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
        TracksInfo tracksInfoH = player2.H();
        boolean zG = false;
        int i = 0;
        while (true) {
            z3 = true;
            if (i >= tracksInfoH.k.size()) {
                z4 = false;
                break;
            }
            TracksInfo.a aVar = tracksInfoH.k.get(i);
            boolean[] zArr = aVar.m;
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
            if (z5 && aVar.l == 2) {
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
            AnimatableValueParser.H(this.p);
        } else {
            z3 = false;
        }
        if (z3) {
            byte[] bArr = player2.S().v;
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
        AnimatableValueParser.H(this.t);
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        return j();
    }

    public void setAspectRatioListener(@Nullable AspectRatioFrameLayout.b bVar) {
        AnimatableValueParser.H(this.l);
        this.l.setAspectRatioListener(bVar);
    }

    public void setControllerAutoShow(boolean z2) {
        this.G = z2;
    }

    public void setControllerHideDuringAds(boolean z2) {
        this.H = z2;
    }

    public void setControllerHideOnTouch(boolean z2) {
        AnimatableValueParser.H(this.t);
        this.I = z2;
        m();
    }

    public void setControllerShowTimeoutMs(int i) {
        AnimatableValueParser.H(this.t);
        this.F = i;
        if (this.t.e()) {
            i(h());
        }
    }

    public void setControllerVisibilityListener(@Nullable PlayerControlView.e eVar) {
        AnimatableValueParser.H(this.t);
        PlayerControlView.e eVar2 = this.f2974y;
        if (eVar2 == eVar) {
            return;
        }
        if (eVar2 != null) {
            this.t.l.remove(eVar2);
        }
        this.f2974y = eVar;
        if (eVar != null) {
            PlayerControlView playerControlView = this.t;
            Objects.requireNonNull(playerControlView);
            playerControlView.l.add(eVar);
        }
    }

    public void setCustomErrorMessage(@Nullable CharSequence charSequence) {
        AnimatableValueParser.D(this.f2972s != null);
        this.E = charSequence;
        n();
    }

    public void setDefaultArtwork(@Nullable Drawable drawable) {
        if (this.A != drawable) {
            this.A = drawable;
            o(false);
        }
    }

    public void setErrorMessageProvider(@Nullable ErrorMessageProvider<? super PlaybackException> errorMessageProvider) {
        if (this.D != errorMessageProvider) {
            this.D = errorMessageProvider;
            n();
        }
    }

    public void setKeepContentOnPlayerReset(boolean z2) {
        if (this.C != z2) {
            this.C = z2;
            o(false);
        }
    }

    public void setPlayer(@Nullable Player2 player2) {
        AnimatableValueParser.D(Looper.myLooper() == Looper.getMainLooper());
        AnimatableValueParser.j(player2 == null || player2.L() == Looper.getMainLooper());
        Player2 player3 = this.w;
        if (player3 == player2) {
            return;
        }
        if (player3 != null) {
            player3.p(this.k);
            if (player3.D(27)) {
                View view = this.n;
                if (view instanceof TextureView) {
                    player3.n((TextureView) view);
                } else if (view instanceof SurfaceView) {
                    player3.F((SurfaceView) view);
                }
            }
        }
        SubtitleView subtitleView = this.q;
        if (subtitleView != null) {
            subtitleView.setCues(null);
        }
        this.w = player2;
        if (p()) {
            this.t.setPlayer(player2);
        }
        l();
        n();
        o(true);
        if (player2 == null) {
            d();
            return;
        }
        if (player2.D(27)) {
            View view2 = this.n;
            if (view2 instanceof TextureView) {
                player2.Q((TextureView) view2);
            } else if (view2 instanceof SurfaceView) {
                player2.r((SurfaceView) view2);
            }
            k();
        }
        if (this.q != null && player2.D(28)) {
            this.q.setCues(player2.A());
        }
        player2.x(this.k);
        f(false);
    }

    public void setRepeatToggleModes(int i) {
        AnimatableValueParser.H(this.t);
        this.t.setRepeatToggleModes(i);
    }

    public void setResizeMode(int i) {
        AnimatableValueParser.H(this.l);
        this.l.setResizeMode(i);
    }

    public void setShowBuffering(int i) {
        if (this.B != i) {
            this.B = i;
            l();
        }
    }

    public void setShowFastForwardButton(boolean z2) {
        AnimatableValueParser.H(this.t);
        this.t.setShowFastForwardButton(z2);
    }

    public void setShowMultiWindowTimeBar(boolean z2) {
        AnimatableValueParser.H(this.t);
        this.t.setShowMultiWindowTimeBar(z2);
    }

    public void setShowNextButton(boolean z2) {
        AnimatableValueParser.H(this.t);
        this.t.setShowNextButton(z2);
    }

    public void setShowPreviousButton(boolean z2) {
        AnimatableValueParser.H(this.t);
        this.t.setShowPreviousButton(z2);
    }

    public void setShowRewindButton(boolean z2) {
        AnimatableValueParser.H(this.t);
        this.t.setShowRewindButton(z2);
    }

    public void setShowShuffleButton(boolean z2) {
        AnimatableValueParser.H(this.t);
        this.t.setShowShuffleButton(z2);
    }

    public void setShutterBackgroundColor(int i) {
        View view = this.m;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public void setUseArtwork(boolean z2) {
        AnimatableValueParser.D((z2 && this.p == null) ? false : true);
        if (this.f2975z != z2) {
            this.f2975z = z2;
            o(false);
        }
    }

    public void setUseController(boolean z2) {
        AnimatableValueParser.D((z2 && this.t == null) ? false : true);
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
