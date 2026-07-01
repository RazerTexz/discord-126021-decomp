package com.discord.widgets.media;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Parcelable;
import android.view.View;
import android.widget.ProgressBar;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import b.a.d.g0;
import b.a.d.i0;
import b.a.p.i;
import b.d.b.a.a;
import b.f.g.e.v;
import b.i.a.c.k2;
import b.i.a.c.u0;
import com.discord.R$layout;
import com.discord.R$menu;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetMediaBinding;
import com.discord.player.AppMediaPlayer;
import com.discord.player.AppMediaPlayer$Event;
import com.discord.player.AppMediaPlayer$Event$a;
import com.discord.player.AppMediaPlayer$Event$b;
import com.discord.player.AppMediaPlayer$Event$c;
import com.discord.player.AppMediaPlayer$Event$d;
import com.discord.player.AppMediaPlayer$Event$e;
import com.discord.player.AppMediaPlayer$Event$f;
import com.discord.player.MediaSource;
import com.discord.player.MediaType;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.display.DisplayUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.string.StringUtilsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.samples.zoomable.ZoomableDraweeView;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.material.appbar.AppBarLayout;
import d0.g0.t;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMedia extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetMedia.class, "binding", "getBinding()Lcom/discord/databinding/WidgetMediaBinding;", 0)};
    public static final WidgetMedia$Companion Companion = new WidgetMedia$Companion(null);
    private static final String INTENT_HEIGHT = "INTENT_MEDIA_HEIGHT";
    private static final String INTENT_IMAGE_URL = "INTENT_IMAGE_URL";
    private static final String INTENT_MEDIA_SOURCE = "INTENT_MEDIA_SOURCE";
    private static final String INTENT_TITLE = "INTENT_TITLE";
    private static final String INTENT_URL = "INTENT_MEDIA_URL";
    private static final String INTENT_WIDTH = "INTENT_MEDIA_WIDTH";
    private static final long SHOW_CONTROLS_TIMEOUT_MS = 3000;
    private static final long VERTICAL_CONTROLS_ANIMATION_DURATION_MS = 200;
    private AppMediaPlayer appMediaPlayer;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private WidgetMedia$ControlsAnimationAction controlsAnimationAction;
    private ValueAnimator controlsAnimator;
    private Subscription controlsVisibilitySubscription;
    private Uri imageUri;
    private MediaSource mediaSource;
    private int playerControlsHeight;
    private boolean playerPausedByFragmentLifecycle;
    private int toolbarHeight;
    private String videoUrl;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetMedia() {
        super(R$layout.widget_media);
        this.binding = FragmentViewBindingDelegateKt.viewBinding(this, WidgetMedia$binding$2.INSTANCE, new WidgetMedia$binding$3(this));
        WidgetMedia$viewModel$2 widgetMedia$viewModel$2 = WidgetMedia$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetMediaViewModel.class), new WidgetMedia$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetMedia$viewModel$2));
    }

    public static final /* synthetic */ WidgetMediaBinding access$getBinding$p(WidgetMedia widgetMedia) {
        return widgetMedia.getBinding();
    }

    public static final /* synthetic */ WidgetMedia$ControlsAnimationAction access$getControlsAnimationAction$p(WidgetMedia widgetMedia) {
        return widgetMedia.controlsAnimationAction;
    }

    public static final /* synthetic */ Subscription access$getControlsVisibilitySubscription$p(WidgetMedia widgetMedia) {
        return widgetMedia.controlsVisibilitySubscription;
    }

    public static final /* synthetic */ int access$getPlayerControlsHeight$p(WidgetMedia widgetMedia) {
        return widgetMedia.playerControlsHeight;
    }

    public static final /* synthetic */ int access$getToolbarHeight$p(WidgetMedia widgetMedia) {
        return widgetMedia.toolbarHeight;
    }

    public static final /* synthetic */ void access$handleImageProgressComplete(WidgetMedia widgetMedia) {
        widgetMedia.handleImageProgressComplete();
    }

    public static final /* synthetic */ void access$handlePlayerEvent(WidgetMedia widgetMedia, AppMediaPlayer$Event appMediaPlayer$Event) {
        widgetMedia.handlePlayerEvent(appMediaPlayer$Event);
    }

    public static final /* synthetic */ void access$hideControls(WidgetMedia widgetMedia) {
        widgetMedia.hideControls();
    }

    public static final /* synthetic */ boolean access$isVideo(WidgetMedia widgetMedia) {
        return widgetMedia.isVideo();
    }

    public static final /* synthetic */ void access$onMediaClick(WidgetMedia widgetMedia) {
        widgetMedia.onMediaClick();
    }

    public static final /* synthetic */ void access$onViewBindingDestroy(WidgetMedia widgetMedia, WidgetMediaBinding widgetMediaBinding) {
        widgetMedia.onViewBindingDestroy(widgetMediaBinding);
    }

    public static final /* synthetic */ void access$setControlsAnimationAction$p(WidgetMedia widgetMedia, WidgetMedia$ControlsAnimationAction widgetMedia$ControlsAnimationAction) {
        widgetMedia.controlsAnimationAction = widgetMedia$ControlsAnimationAction;
    }

    public static final /* synthetic */ void access$setControlsVisibilitySubscription$p(WidgetMedia widgetMedia, Subscription subscription) {
        widgetMedia.controlsVisibilitySubscription = subscription;
    }

    public static final /* synthetic */ void access$setPlayerControlsHeight$p(WidgetMedia widgetMedia, int i) {
        widgetMedia.playerControlsHeight = i;
    }

    public static final /* synthetic */ void access$setToolbarHeight$p(WidgetMedia widgetMedia, int i) {
        widgetMedia.toolbarHeight = i;
    }

    private final void configureAndStartControlsAnimation(ValueAnimator animator) {
        animator.setInterpolator(new FastOutSlowInInterpolator());
        animator.setDuration(VERTICAL_CONTROLS_ANIMATION_DURATION_MS);
        animator.addUpdateListener(new WidgetMedia$configureAndStartControlsAnimation$$inlined$apply$lambda$1(this));
        animator.addListener(new WidgetMedia$configureAndStartControlsAnimation$$inlined$apply$lambda$2(this));
        animator.start();
    }

    private final void configureMediaImage() {
        getBinding().d.setIsLongpressEnabled(false);
        getBinding().d.setTapListener(new WidgetMedia$configureMediaImage$1(this));
        ZoomableDraweeView zoomableDraweeView = getBinding().d;
        m.checkNotNullExpressionValue(zoomableDraweeView, "binding.mediaImage");
        ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.a;
        ScalingUtils$ScaleType scalingUtils$ScaleType2 = v.l;
        m.checkNotNullExpressionValue(scalingUtils$ScaleType2, "ScalingUtils.ScaleType.FIT_CENTER");
        MGImages.setScaleType(zoomableDraweeView, scalingUtils$ScaleType2);
        ZoomableDraweeView zoomableDraweeView2 = getBinding().d;
        m.checkNotNullExpressionValue(zoomableDraweeView2, "binding.mediaImage");
        ZoomableDraweeView zoomableDraweeView3 = getBinding().d;
        m.checkNotNullExpressionValue(zoomableDraweeView3, "binding.mediaImage");
        Context context = zoomableDraweeView3.getContext();
        m.checkNotNullExpressionValue(context, "binding.mediaImage.context");
        Uri uri = this.imageUri;
        if (uri == null) {
            m.throwUninitializedPropertyAccessException("imageUri");
        }
        MGImages.setImage$default(zoomableDraweeView2, d0.t.m.listOf(getFormattedUrl(context, uri)), 0, 0, false, null, null, new WidgetMedia$configureMediaImage$2(this), 124, null);
    }

    private final WidgetMediaBinding getBinding() {
        return (WidgetMediaBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getFormattedUrl(Context context, Uri uri) {
        String string;
        Rect rectResizeToFitScreen = DisplayUtils.resizeToFitScreen(context, new Rect(0, 0, getMostRecentIntent().getIntExtra(INTENT_WIDTH, 0), getMostRecentIntent().getIntExtra(INTENT_HEIGHT, 0)));
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null || !t.endsWith$default(lastPathSegment, ".gif", false, 2, null)) {
            StringBuilder sbU = a.U("&format=");
            sbU.append(StringUtilsKt.getSTATIC_IMAGE_EXTENSION());
            string = sbU.toString();
        } else {
            string = "";
        }
        return uri + "?width=" + rectResizeToFitScreen.width() + "&height=" + rectResizeToFitScreen.height() + string;
    }

    private final float getToolbarTranslationY() {
        AppBarLayout appBarLayout = getBinding().f2486b;
        m.checkNotNullExpressionValue(appBarLayout, "binding.actionBarToolbarLayout");
        return appBarLayout.getTranslationY();
    }

    private final WidgetMediaViewModel getViewModel() {
        return (WidgetMediaViewModel) this.viewModel.getValue();
    }

    private final void handleImageProgressComplete() {
        if (this.videoUrl == null) {
            hideLoadingIndicator();
        }
    }

    private final void handlePlayerEvent(AppMediaPlayer$Event event) {
        if (m.areEqual(event, AppMediaPlayer$Event$b.a)) {
            showLoadingIndicator();
            return;
        }
        if (m.areEqual(event, AppMediaPlayer$Event$a.a)) {
            ZoomableDraweeView zoomableDraweeView = getBinding().d;
            m.checkNotNullExpressionValue(zoomableDraweeView, "binding.mediaImage");
            zoomableDraweeView.setVisibility(8);
            getViewModel().setShowCoverFrame(false);
            hideLoadingIndicator();
            return;
        }
        if (event instanceof AppMediaPlayer$Event$c) {
            getViewModel().setCurrentPlayerPositionMs(((AppMediaPlayer$Event$c) event).a);
            return;
        }
        if (m.areEqual(event, AppMediaPlayer$Event$d.a)) {
            if (this.playerPausedByFragmentLifecycle) {
                return;
            }
            getViewModel().setPlaying(false);
        } else if (m.areEqual(event, AppMediaPlayer$Event$f.a)) {
            getViewModel().setPlaying(true);
        } else if (m.areEqual(event, AppMediaPlayer$Event$e.a)) {
            hideLoadingIndicator();
        }
    }

    private final void hideControls() {
        WidgetMedia$ControlsAnimationAction widgetMedia$ControlsAnimationAction = this.controlsAnimationAction;
        WidgetMedia$ControlsAnimationAction widgetMedia$ControlsAnimationAction2 = WidgetMedia$ControlsAnimationAction.HIDE;
        if (widgetMedia$ControlsAnimationAction == widgetMedia$ControlsAnimationAction2) {
            return;
        }
        this.controlsAnimationAction = widgetMedia$ControlsAnimationAction2;
        ValueAnimator valueAnimator = this.controlsAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(getToolbarTranslationY(), -this.toolbarHeight);
        m.checkNotNullExpressionValue(valueAnimatorOfFloat, "this");
        configureAndStartControlsAnimation(valueAnimatorOfFloat);
        this.controlsAnimator = valueAnimatorOfFloat;
    }

    private final void hideLoadingIndicator() {
        ProgressBar progressBar = getBinding().e;
        m.checkNotNullExpressionValue(progressBar, "binding.mediaLoadingIndicator");
        progressBar.setVisibility(8);
    }

    private final boolean isVideo() {
        MediaSource mediaSource = this.mediaSource;
        return (mediaSource != null ? mediaSource.mediaType : null) == MediaType.VIDEO;
    }

    private final void onMediaClick() {
        if (getToolbarTranslationY() < 0.0f) {
            showControls();
        } else {
            hideControls();
        }
    }

    private final void onViewBindingDestroy(WidgetMediaBinding binding) {
        ValueAnimator valueAnimator = this.controlsAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        binding.d.setTapListener(null);
        MGImages mGImages = MGImages.INSTANCE;
        ZoomableDraweeView zoomableDraweeView = binding.d;
        m.checkNotNullExpressionValue(zoomableDraweeView, "binding.mediaImage");
        mGImages.cancelImageRequests(zoomableDraweeView);
    }

    private final void showControls() {
        if (isVideo()) {
            getBinding().f.i();
            Subscription subscription = this.controlsVisibilitySubscription;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            Observable<Long> observableD0 = Observable.d0(SHOW_CONTROLS_TIMEOUT_MS, TimeUnit.MILLISECONDS);
            m.checkNotNullExpressionValue(observableD0, "Observable.timer(SHOW_CO…S, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), WidgetMedia.class, (Context) null, new WidgetMedia$showControls$1(this), (Function1) null, (Function0) null, (Function0) null, new WidgetMedia$showControls$2(this), 58, (Object) null);
        } else {
            getBinding().f.c();
        }
        WidgetMedia$ControlsAnimationAction widgetMedia$ControlsAnimationAction = this.controlsAnimationAction;
        WidgetMedia$ControlsAnimationAction widgetMedia$ControlsAnimationAction2 = WidgetMedia$ControlsAnimationAction.SHOW;
        if (widgetMedia$ControlsAnimationAction == widgetMedia$ControlsAnimationAction2) {
            return;
        }
        this.controlsAnimationAction = widgetMedia$ControlsAnimationAction2;
        ValueAnimator valueAnimator = this.controlsAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(getToolbarTranslationY(), 0.0f);
        m.checkNotNullExpressionValue(valueAnimatorOfFloat, "this");
        configureAndStartControlsAnimation(valueAnimatorOfFloat);
        this.controlsAnimator = valueAnimatorOfFloat;
    }

    private final void showLoadingIndicator() {
        ProgressBar progressBar = getBinding().e;
        m.checkNotNullExpressionValue(progressBar, "binding.mediaLoadingIndicator");
        progressBar.setVisibility(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        AppMediaPlayer appMediaPlayer = this.appMediaPlayer;
        if (appMediaPlayer == null) {
            m.throwUninitializedPropertyAccessException("appMediaPlayer");
        }
        appMediaPlayer.c();
        super.onDestroy();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AppMediaPlayer appMediaPlayer = this.appMediaPlayer;
        if (appMediaPlayer == null) {
            m.throwUninitializedPropertyAccessException("appMediaPlayer");
        }
        if (((u0) appMediaPlayer.exoPlayer).z()) {
            this.playerPausedByFragmentLifecycle = true;
            AppMediaPlayer appMediaPlayer2 = this.appMediaPlayer;
            if (appMediaPlayer2 == null) {
                m.throwUninitializedPropertyAccessException("appMediaPlayer");
            }
            ((k2) appMediaPlayer2.exoPlayer).u(false);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.appMediaPlayer = i.a(requireContext());
        ColorCompat.getThemedColor(this, 2130970006);
        ColorCompat.setStatusBarColor$default((Fragment) this, ColorCompat.getThemedColor(this, 2130970006), false, 4, (Object) null);
        PlayerView playerView = getBinding().g;
        m.checkNotNullExpressionValue(playerView, "binding.mediaPlayerView");
        View videoSurfaceView = playerView.getVideoSurfaceView();
        if (videoSurfaceView != null) {
            videoSurfaceView.setOnClickListener(new WidgetMedia$onViewBound$1(this));
        }
        getBinding().c.setOnClickListener(new WidgetMedia$onViewBound$2(this));
        AppBarLayout appBarLayout = getBinding().f2486b;
        m.checkNotNullExpressionValue(appBarLayout, "binding.actionBarToolbarLayout");
        ViewExtensions.addOnHeightChangedListener(appBarLayout, new WidgetMedia$onViewBound$3(this));
        PlayerControlView playerControlView = getBinding().f;
        m.checkNotNullExpressionValue(playerControlView, "binding.mediaPlayerControlView");
        ViewExtensions.addOnHeightChangedListener(playerControlView, new WidgetMedia$onViewBound$4(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        Uri uri;
        String str;
        Uri uri2;
        super.onViewBoundOrOnResume();
        ZoomableDraweeView zoomableDraweeView = getBinding().d;
        m.checkNotNullExpressionValue(zoomableDraweeView, "binding.mediaImage");
        zoomableDraweeView.setVisibility(getViewModel().getShowCoverFrame() ? 0 : 8);
        ProgressBar progressBar = getBinding().e;
        m.checkNotNullExpressionValue(progressBar, "binding.mediaLoadingIndicator");
        progressBar.setVisibility(getViewModel().getShowCoverFrame() ? 0 : 8);
        Uri uri3 = Uri.parse(getMostRecentIntent().getStringExtra(INTENT_URL));
        Uri uri4 = Uri.parse(getMostRecentIntent().getStringExtra(INTENT_IMAGE_URL));
        m.checkNotNullExpressionValue(uri4, "Uri.parse(mostRecentInte…gExtra(INTENT_IMAGE_URL))");
        this.imageUri = uri4;
        Parcelable parcelableExtra = getMostRecentIntent().getParcelableExtra(INTENT_MEDIA_SOURCE);
        if (!(parcelableExtra instanceof MediaSource)) {
            parcelableExtra = null;
        }
        MediaSource mediaSource = (MediaSource) parcelableExtra;
        this.mediaSource = mediaSource;
        String string = (mediaSource == null || (uri2 = mediaSource.progressiveMediaUri) == null) ? null : uri2.toString();
        this.videoUrl = string;
        if (string != null) {
            uri = Uri.parse(string);
        } else {
            uri = this.imageUri;
            if (uri == null) {
                m.throwUninitializedPropertyAccessException("imageUri");
            }
        }
        Uri uri5 = uri;
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_TITLE);
        if (stringExtra == null || t.isBlank(stringExtra)) {
            String string2 = uri3.toString();
            m.checkNotNullExpressionValue(string2, "sourceUri.toString()");
            str = string2;
        } else {
            str = stringExtra;
        }
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(2131897134);
        setActionBarSubtitle(str);
        AppFragment.setActionBarOptionsMenu$default(this, R$menu.menu_media, new WidgetMedia$onViewBoundOrOnResume$1(this, uri3, uri5, stringExtra, str), null, 4, null);
        configureMediaImage();
        showControls();
        this.playerPausedByFragmentLifecycle = false;
        MediaSource mediaSource2 = this.mediaSource;
        if (mediaSource2 != null) {
            boolean z2 = mediaSource2.mediaType == MediaType.GIFV;
            AppMediaPlayer appMediaPlayer = this.appMediaPlayer;
            if (appMediaPlayer == null) {
                m.throwUninitializedPropertyAccessException("appMediaPlayer");
            }
            boolean isPlaying = getViewModel().getIsPlaying();
            long currentPlayerPositionMs = getViewModel().getCurrentPlayerPositionMs();
            PlayerView playerView = getBinding().g;
            m.checkNotNullExpressionValue(playerView, "binding.mediaPlayerView");
            appMediaPlayer.a(mediaSource2, isPlaying, z2, currentPlayerPositionMs, playerView, getBinding().f);
            if (z2) {
                AppMediaPlayer appMediaPlayer2 = this.appMediaPlayer;
                if (appMediaPlayer2 == null) {
                    m.throwUninitializedPropertyAccessException("appMediaPlayer");
                }
                appMediaPlayer2.d(0.0f);
            } else {
                AppMediaPlayer appMediaPlayer3 = this.appMediaPlayer;
                if (appMediaPlayer3 == null) {
                    m.throwUninitializedPropertyAccessException("appMediaPlayer");
                }
                appMediaPlayer3.d(1.0f);
            }
            AppMediaPlayer appMediaPlayer4 = this.appMediaPlayer;
            if (appMediaPlayer4 == null) {
                m.throwUninitializedPropertyAccessException("appMediaPlayer");
            }
            Observable<AppMediaPlayer$Event> observableK = appMediaPlayer4.eventSubject.K();
            m.checkNotNullExpressionValue(observableK, "eventSubject.onBackpressureBuffer()");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableK, this, null, 2, null), WidgetMedia.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetMedia$onViewBoundOrOnResume$$inlined$let$lambda$1(this), 62, (Object) null);
        }
    }
}
