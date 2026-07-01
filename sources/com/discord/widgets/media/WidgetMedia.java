package com.discord.widgets.media;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Parcelable;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.a.p.AppMediaPlayerFactory;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.f.g.c.BaseControllerListener;
import b.f.g.e.v;
import b.f.l.b.AbstractAnimatedZoomableController;
import b.f.l.b.ZoomableController;
import b.i.a.c.BasePlayer;
import b.i.a.c.SimpleExoPlayer;
import com.discord.R;
import com.discord.api.message.attachment.MessageAttachment;
import com.discord.api.message.attachment.MessageAttachmentType;
import com.discord.api.message.embed.EmbedType;
import com.discord.api.message.embed.EmbedVideo;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetMediaBinding;
import com.discord.embed.RenderableEmbedMedia;
import com.discord.player.AppMediaPlayer;
import com.discord.player.MediaSource;
import com.discord.player.MediaType;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.display.DisplayUtils;
import com.discord.utilities.embed.EmbedResourceUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.io.NetworkUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.string.StringUtils2;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.samples.zoomable.ZoomableDraweeView;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.material.appbar.AppBarLayout;
import d0.g0.StringsJVM;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMedia extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetMedia.class, "binding", "getBinding()Lcom/discord/databinding/WidgetMediaBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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
    private ControlsAnimationAction controlsAnimationAction;
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

    /* JADX INFO: compiled from: WidgetMedia.kt */
    public static final class Companion {

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                MessageAttachmentType.values();
                int[] iArr = new int[3];
                $EnumSwitchMapping$0 = iArr;
                iArr[MessageAttachmentType.VIDEO.ordinal()] = 1;
                EmbedType.values();
                int[] iArr2 = new int[11];
                $EnumSwitchMapping$1 = iArr2;
                iArr2[EmbedType.VIDEO.ordinal()] = 1;
                iArr2[EmbedType.GIFV.ordinal()] = 2;
            }
        }

        private Companion() {
        }

        public final void launch(Context context, MessageAttachment attachment) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(attachment, "attachment");
            MessageAttachmentType messageAttachmentTypeE = attachment.e();
            launch(context, attachment.getFilename(), attachment.getProxyUrl(), messageAttachmentTypeE.ordinal() != 0 ? null : attachment.getProxyUrl(), attachment.getProxyUrl(), attachment.getWidth(), attachment.getHeight(), messageAttachmentTypeE == MessageAttachmentType.VIDEO ? MediaType.VIDEO : null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code duplicated, block: B:9:0x001c  */
        public final void launch(Context context, MessageEmbed embed) {
            String str;
            int iOrdinal;
            String url;
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(embed, "embed");
            EmbedType type = embed.getType();
            if (type != null && ((iOrdinal = type.ordinal()) == 2 || iOrdinal == 7)) {
                EmbedVideo video = embed.getVideo();
                if (video == null || (url = video.getProxyUrl()) == null) {
                    EmbedVideo video2 = embed.getVideo();
                    if (video2 != null) {
                        url = video2.getUrl();
                    } else {
                        str = null;
                    }
                }
                str = url;
            } else {
                str = null;
            }
            RenderableEmbedMedia previewImage = EmbedResourceUtils.INSTANCE.getPreviewImage(embed);
            launch(context, embed.getTitle(), embed.getUrl(), str, previewImage != null ? previewImage.url : null, previewImage != null ? previewImage.width : null, previewImage != null ? previewImage.height : null, embed.getType() == EmbedType.GIFV ? MediaType.GIFV : MediaType.VIDEO);
        }

        private final void launch(Context context, String title, String uri, String progressiveMediaUri, String previewImageUri, Integer width, Integer height, MediaType mediaType) {
            MediaSource mediaSourceP = (progressiveMediaUri == null || mediaType == null) ? null : AnimatableValueParser.P(mediaType, progressiveMediaUri, "javaClass");
            Intent intentPutExtra = new Intent().putExtra(WidgetMedia.INTENT_TITLE, title);
            if (uri == null) {
                uri = previewImageUri;
            }
            Intent intentPutExtra2 = intentPutExtra.putExtra(WidgetMedia.INTENT_URL, uri).putExtra(WidgetMedia.INTENT_IMAGE_URL, previewImageUri).putExtra(WidgetMedia.INTENT_WIDTH, width).putExtra(WidgetMedia.INTENT_HEIGHT, height).putExtra(WidgetMedia.INTENT_MEDIA_SOURCE, mediaSourceP);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra2, "Intent()\n          .putE…EDIA_SOURCE, mediaSource)");
            AppScreen2.d(context, WidgetMedia.class, intentPutExtra2);
        }
    }

    /* JADX INFO: compiled from: WidgetMedia.kt */
    public enum ControlsAnimationAction {
        SHOW,
        HIDE
    }

    /* JADX INFO: renamed from: com.discord.widgets.media.WidgetMedia$onViewBound$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetMedia.kt */
    public static final class AnonymousClass3 extends Lambda implements Function2<Integer, Integer, Unit> {
        public AnonymousClass3() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
            invoke(num.intValue(), num2.intValue());
            return Unit.a;
        }

        public final void invoke(int i, int i2) {
            WidgetMedia.this.toolbarHeight = i;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.media.WidgetMedia$onViewBound$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetMedia.kt */
    public static final class AnonymousClass4 extends Lambda implements Function2<Integer, Integer, Unit> {
        public AnonymousClass4() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
            invoke(num.intValue(), num2.intValue());
            return Unit.a;
        }

        public final void invoke(int i, int i2) {
            WidgetMedia.this.playerControlsHeight = i;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.media.WidgetMedia$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetMedia.kt */
    public static final class AnonymousClass1<T1, T2> implements Action2<MenuItem, Context> {
        public final /* synthetic */ Uri $downloadUri;
        public final /* synthetic */ Uri $sourceUri;
        public final /* synthetic */ String $title;
        public final /* synthetic */ String $titleSubtext;

        /* JADX INFO: renamed from: com.discord.widgets.media.WidgetMedia$onViewBoundOrOnResume$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: WidgetMedia.kt */
        public static final class C03001 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Context $context;

            /* JADX INFO: renamed from: com.discord.widgets.media.WidgetMedia$onViewBoundOrOnResume$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetMedia.kt */
            public static final class C03011 extends Lambda implements Function1<String, Unit> {
                public C03011() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    Intrinsics3.checkNotNullParameter(str, "it");
                    if (WidgetMedia.this.isAdded()) {
                        C03001 c03001 = C03001.this;
                        WidgetMedia widgetMedia = WidgetMedia.this;
                        Context context = c03001.$context;
                        Intrinsics3.checkNotNullExpressionValue(context, "context");
                        AppToast.j(widgetMedia, FormatUtils.b(context, R.string.download_file_complete, new Object[]{str}, (4 & 4) != 0 ? FormatUtils.b.j : null), 0, 4);
                    }
                }
            }

            /* JADX INFO: renamed from: com.discord.widgets.media.WidgetMedia$onViewBoundOrOnResume$1$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetMedia.kt */
            public static final class AnonymousClass2 extends Lambda implements Function1<Throwable, Unit> {
                public AnonymousClass2() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    Intrinsics3.checkNotNullParameter(th, "it");
                    if (WidgetMedia.this.isAdded()) {
                        WidgetMedia widgetMedia = WidgetMedia.this;
                        AppToast.j(widgetMedia, widgetMedia.getString(R.string.download_failed), 0, 4);
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C03001(Context context) {
                super(0);
                this.$context = context;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Context context = this.$context;
                Uri uri = AnonymousClass1.this.$downloadUri;
                Intrinsics3.checkNotNullExpressionValue(uri, "downloadUri");
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                NetworkUtils.downloadFile(context, uri, anonymousClass1.$title, anonymousClass1.$titleSubtext, new C03011(), new AnonymousClass2());
            }
        }

        public AnonymousClass1(Uri uri, Uri uri2, String str, String str2) {
            this.$sourceUri = uri;
            this.$downloadUri = uri2;
            this.$title = str;
            this.$titleSubtext = str2;
        }

        @Override // rx.functions.Action2
        public final void call(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case R.id.menu_media_browser /* 2131364395 */:
                    Intrinsics3.checkNotNullExpressionValue(context, "context");
                    String string = this.$sourceUri.toString();
                    Intrinsics3.checkNotNullExpressionValue(string, "sourceUri.toString()");
                    UriHandler.handleOrUntrusted$default(context, string, null, 4, null);
                    break;
                case R.id.menu_media_download /* 2131364396 */:
                    WidgetMedia.this.requestMediaDownload(new C03001(context));
                    break;
                case R.id.menu_media_share /* 2131364397 */:
                    Intrinsics3.checkNotNullExpressionValue(context, "context");
                    String string2 = this.$sourceUri.toString();
                    Intrinsics3.checkNotNullExpressionValue(string2, "sourceUri.toString()");
                    IntentUtils.performChooserSendIntent$default(context, string2, null, 4, null);
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.media.WidgetMedia$showControls$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetMedia.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            WidgetMedia.this.controlsVisibilitySubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.media.WidgetMedia$showControls$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetMedia.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            WidgetMedia.this.hideControls();
        }
    }

    public WidgetMedia() {
        super(R.layout.widget_media);
        this.binding = FragmentViewBindingDelegate3.viewBinding(this, WidgetMedia2.INSTANCE, new WidgetMedia3(this));
        WidgetMedia7 widgetMedia7 = WidgetMedia7.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetMediaViewModel.class), new WidgetMedia$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetMedia7));
    }

    private final void configureAndStartControlsAnimation(ValueAnimator animator) {
        animator.setInterpolator(new FastOutSlowInInterpolator());
        animator.setDuration(VERTICAL_CONTROLS_ANIMATION_DURATION_MS);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.discord.widgets.media.WidgetMedia$configureAndStartControlsAnimation$$inlined$apply$lambda$1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Intrinsics3.checkNotNullExpressionValue(valueAnimator, "animator");
                Object animatedValue = valueAnimator.getAnimatedValue();
                Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                float fFloatValue = ((Float) animatedValue).floatValue();
                AppBarLayout appBarLayout = this.this$0.getBinding().f2486b;
                Intrinsics3.checkNotNullExpressionValue(appBarLayout, "binding.actionBarToolbarLayout");
                appBarLayout.setTranslationY(fFloatValue);
                if (!this.this$0.isVideo() || this.this$0.playerControlsHeight <= 0) {
                    return;
                }
                float f = (-fFloatValue) / (this.this$0.toolbarHeight / this.this$0.playerControlsHeight);
                PlayerControlView playerControlView = this.this$0.getBinding().f;
                Intrinsics3.checkNotNullExpressionValue(playerControlView, "binding.mediaPlayerControlView");
                playerControlView.setTranslationY(f);
            }
        });
        animator.addListener(new AnimatorListenerAdapter() { // from class: com.discord.widgets.media.WidgetMedia$configureAndStartControlsAnimation$$inlined$apply$lambda$2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics3.checkNotNullParameter(animation, "animation");
                this.this$0.controlsAnimationAction = null;
            }
        });
        animator.start();
    }

    private final void configureMediaImage() {
        getBinding().d.setIsLongpressEnabled(false);
        getBinding().d.setTapListener(new GestureDetector.SimpleOnGestureListener() { // from class: com.discord.widgets.media.WidgetMedia.configureMediaImage.1
            private boolean mDoubleTapScroll;
            private final long DURATION_MS = 300;
            private final long DOUBLE_TAP_SCROLL_THRESHOLD = 20;
            private final PointF mDoubleTapViewPoint = new PointF();
            private final PointF mDoubleTapImagePoint = new PointF();
            private float mDoubleTapScale = 1.0f;

            private final float calcScale(PointF currentViewPoint) {
                float f = currentViewPoint.y - this.mDoubleTapViewPoint.y;
                float fAbs = (Math.abs(f) * 0.001f) + 1;
                return f < ((float) 0) ? this.mDoubleTapScale / fAbs : this.mDoubleTapScale * fAbs;
            }

            private final boolean shouldStartDoubleTapScroll(PointF viewPoint) {
                float f = viewPoint.x;
                PointF pointF = this.mDoubleTapViewPoint;
                return ((float) Math.hypot((double) (f - pointF.x), (double) (viewPoint.y - pointF.y))) > ((float) this.DOUBLE_TAP_SCROLL_THRESHOLD);
            }

            public final PointF getMDoubleTapImagePoint() {
                return this.mDoubleTapImagePoint;
            }

            public final float getMDoubleTapScale() {
                return this.mDoubleTapScale;
            }

            public final boolean getMDoubleTapScroll() {
                return this.mDoubleTapScroll;
            }

            public final PointF getMDoubleTapViewPoint() {
                return this.mDoubleTapViewPoint;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTapEvent(MotionEvent e) {
                Intrinsics3.checkNotNullParameter(e, "e");
                ZoomableDraweeView zoomableDraweeView = WidgetMedia.this.getBinding().d;
                Intrinsics3.checkNotNullExpressionValue(zoomableDraweeView, "binding.mediaImage");
                ZoomableController zoomableController = zoomableDraweeView.getZoomableController();
                Objects.requireNonNull(zoomableController, "null cannot be cast to non-null type com.facebook.samples.zoomable.AbstractAnimatedZoomableController");
                AbstractAnimatedZoomableController abstractAnimatedZoomableController = (AbstractAnimatedZoomableController) zoomableController;
                PointF pointF = new PointF(e.getX(), e.getY());
                float[] fArr = abstractAnimatedZoomableController.j;
                fArr[0] = pointF.x;
                fArr[1] = pointF.y;
                abstractAnimatedZoomableController.h.invert(abstractAnimatedZoomableController.i);
                abstractAnimatedZoomableController.i.mapPoints(fArr, 0, fArr, 0, 1);
                for (int i = 0; i < 1; i++) {
                    int i2 = i * 2;
                    int i3 = i2 + 0;
                    float f = fArr[i3];
                    RectF rectF = abstractAnimatedZoomableController.e;
                    fArr[i3] = (f - rectF.left) / rectF.width();
                    int i4 = i2 + 1;
                    float f2 = fArr[i4];
                    RectF rectF2 = abstractAnimatedZoomableController.e;
                    fArr[i4] = (f2 - rectF2.top) / rectF2.height();
                }
                PointF pointF2 = new PointF(fArr[0], fArr[1]);
                int actionMasked = e.getActionMasked();
                if (actionMasked == 0) {
                    this.mDoubleTapViewPoint.set(pointF);
                    this.mDoubleTapImagePoint.set(pointF2);
                    this.mDoubleTapScale = abstractAnimatedZoomableController.e();
                } else if (actionMasked == 1) {
                    if (this.mDoubleTapScroll) {
                        abstractAnimatedZoomableController.p(calcScale(pointF), this.mDoubleTapImagePoint, this.mDoubleTapViewPoint, 7, 0L, null);
                    } else if (abstractAnimatedZoomableController.e() < 3.0f / 2) {
                        abstractAnimatedZoomableController.p(2.0f, pointF2, pointF, 7, this.DURATION_MS, null);
                    } else {
                        abstractAnimatedZoomableController.p(1.0f, pointF2, pointF, 7, this.DURATION_MS, null);
                    }
                    this.mDoubleTapScroll = false;
                } else if (actionMasked == 2) {
                    boolean z2 = this.mDoubleTapScroll || shouldStartDoubleTapScroll(pointF);
                    this.mDoubleTapScroll = z2;
                    if (z2) {
                        abstractAnimatedZoomableController.p(calcScale(pointF), this.mDoubleTapImagePoint, this.mDoubleTapViewPoint, 7, 0L, null);
                    }
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent e) {
                Intrinsics3.checkNotNullParameter(e, "e");
                WidgetMedia.this.onMediaClick();
                return true;
            }

            public final void setMDoubleTapScale(float f) {
                this.mDoubleTapScale = f;
            }

            public final void setMDoubleTapScroll(boolean z2) {
                this.mDoubleTapScroll = z2;
            }
        });
        ZoomableDraweeView zoomableDraweeView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(zoomableDraweeView, "binding.mediaImage");
        ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.a;
        ScalingUtils$ScaleType scalingUtils$ScaleType2 = v.l;
        Intrinsics3.checkNotNullExpressionValue(scalingUtils$ScaleType2, "ScalingUtils.ScaleType.FIT_CENTER");
        MGImages.setScaleType(zoomableDraweeView, scalingUtils$ScaleType2);
        ZoomableDraweeView zoomableDraweeView2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(zoomableDraweeView2, "binding.mediaImage");
        ZoomableDraweeView zoomableDraweeView3 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(zoomableDraweeView3, "binding.mediaImage");
        Context context = zoomableDraweeView3.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "binding.mediaImage.context");
        Uri uri = this.imageUri;
        if (uri == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("imageUri");
        }
        MGImages.setImage$default(zoomableDraweeView2, CollectionsJVM.listOf(getFormattedUrl(context, uri)), 0, 0, false, null, null, new BaseControllerListener<ImageInfo>() { // from class: com.discord.widgets.media.WidgetMedia.configureMediaImage.2
            @Override // b.f.g.c.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
            public void onFailure(String id2, Throwable throwable) {
                super.onFailure(id2, throwable);
                WidgetMedia.this.handleImageProgressComplete();
            }

            @Override // b.f.g.c.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
            public void onFinalImageSet(String id2, ImageInfo imageInfo, Animatable animatable) {
                super.onFinalImageSet(id2, imageInfo, animatable);
                WidgetMedia.this.handleImageProgressComplete();
            }
        }, 124, null);
    }

    private final WidgetMediaBinding getBinding() {
        return (WidgetMediaBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getFormattedUrl(Context context, Uri uri) {
        String string;
        Rect rectResizeToFitScreen = DisplayUtils.resizeToFitScreen(context, new Rect(0, 0, getMostRecentIntent().getIntExtra(INTENT_WIDTH, 0), getMostRecentIntent().getIntExtra(INTENT_HEIGHT, 0)));
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null || !StringsJVM.endsWith$default(lastPathSegment, ".gif", false, 2, null)) {
            StringBuilder sbU = outline.U("&format=");
            sbU.append(StringUtils2.getSTATIC_IMAGE_EXTENSION());
            string = sbU.toString();
        } else {
            string = "";
        }
        return uri + "?width=" + rectResizeToFitScreen.width() + "&height=" + rectResizeToFitScreen.height() + string;
    }

    private final float getToolbarTranslationY() {
        AppBarLayout appBarLayout = getBinding().f2486b;
        Intrinsics3.checkNotNullExpressionValue(appBarLayout, "binding.actionBarToolbarLayout");
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

    private final void handlePlayerEvent(AppMediaPlayer.Event event) {
        if (Intrinsics3.areEqual(event, AppMediaPlayer.Event.b.a)) {
            showLoadingIndicator();
            return;
        }
        if (Intrinsics3.areEqual(event, AppMediaPlayer.Event.a.a)) {
            ZoomableDraweeView zoomableDraweeView = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(zoomableDraweeView, "binding.mediaImage");
            zoomableDraweeView.setVisibility(8);
            getViewModel().setShowCoverFrame(false);
            hideLoadingIndicator();
            return;
        }
        if (event instanceof AppMediaPlayer.Event.c) {
            getViewModel().setCurrentPlayerPositionMs(((AppMediaPlayer.Event.c) event).a);
            return;
        }
        if (Intrinsics3.areEqual(event, AppMediaPlayer.Event.d.a)) {
            if (this.playerPausedByFragmentLifecycle) {
                return;
            }
            getViewModel().setPlaying(false);
        } else if (Intrinsics3.areEqual(event, AppMediaPlayer.Event.f.a)) {
            getViewModel().setPlaying(true);
        } else if (Intrinsics3.areEqual(event, AppMediaPlayer.Event.e.a)) {
            hideLoadingIndicator();
        }
    }

    private final void hideControls() {
        ControlsAnimationAction controlsAnimationAction = this.controlsAnimationAction;
        ControlsAnimationAction controlsAnimationAction2 = ControlsAnimationAction.HIDE;
        if (controlsAnimationAction == controlsAnimationAction2) {
            return;
        }
        this.controlsAnimationAction = controlsAnimationAction2;
        ValueAnimator valueAnimator = this.controlsAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(getToolbarTranslationY(), -this.toolbarHeight);
        Intrinsics3.checkNotNullExpressionValue(valueAnimatorOfFloat, "this");
        configureAndStartControlsAnimation(valueAnimatorOfFloat);
        this.controlsAnimator = valueAnimatorOfFloat;
    }

    private final void hideLoadingIndicator() {
        ProgressBar progressBar = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.mediaLoadingIndicator");
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
        Intrinsics3.checkNotNullExpressionValue(zoomableDraweeView, "binding.mediaImage");
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
            Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable.timer(SHOW_CO…S, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), (Class<?>) WidgetMedia.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass1()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
        } else {
            getBinding().f.c();
        }
        ControlsAnimationAction controlsAnimationAction = this.controlsAnimationAction;
        ControlsAnimationAction controlsAnimationAction2 = ControlsAnimationAction.SHOW;
        if (controlsAnimationAction == controlsAnimationAction2) {
            return;
        }
        this.controlsAnimationAction = controlsAnimationAction2;
        ValueAnimator valueAnimator = this.controlsAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(getToolbarTranslationY(), 0.0f);
        Intrinsics3.checkNotNullExpressionValue(valueAnimatorOfFloat, "this");
        configureAndStartControlsAnimation(valueAnimatorOfFloat);
        this.controlsAnimator = valueAnimatorOfFloat;
    }

    private final void showLoadingIndicator() {
        ProgressBar progressBar = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.mediaLoadingIndicator");
        progressBar.setVisibility(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        AppMediaPlayer appMediaPlayer = this.appMediaPlayer;
        if (appMediaPlayer == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("appMediaPlayer");
        }
        appMediaPlayer.c();
        super.onDestroy();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AppMediaPlayer appMediaPlayer = this.appMediaPlayer;
        if (appMediaPlayer == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("appMediaPlayer");
        }
        if (((BasePlayer) appMediaPlayer.exoPlayer).z()) {
            this.playerPausedByFragmentLifecycle = true;
            AppMediaPlayer appMediaPlayer2 = this.appMediaPlayer;
            if (appMediaPlayer2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("appMediaPlayer");
            }
            ((SimpleExoPlayer) appMediaPlayer2.exoPlayer).u(false);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.appMediaPlayer = AppMediaPlayerFactory.a(requireContext());
        ColorCompat.getThemedColor(this, R.attr.primary_900);
        ColorCompat.setStatusBarColor$default((Fragment) this, ColorCompat.getThemedColor(this, R.attr.primary_900), false, 4, (Object) null);
        PlayerView playerView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(playerView, "binding.mediaPlayerView");
        View videoSurfaceView = playerView.getVideoSurfaceView();
        if (videoSurfaceView != null) {
            videoSurfaceView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.media.WidgetMedia.onViewBound.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    WidgetMedia.this.onMediaClick();
                }
            });
        }
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.media.WidgetMedia.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetMedia.this.onMediaClick();
            }
        });
        AppBarLayout appBarLayout = getBinding().f2486b;
        Intrinsics3.checkNotNullExpressionValue(appBarLayout, "binding.actionBarToolbarLayout");
        ViewExtensions.addOnHeightChangedListener(appBarLayout, new AnonymousClass3());
        PlayerControlView playerControlView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(playerControlView, "binding.mediaPlayerControlView");
        ViewExtensions.addOnHeightChangedListener(playerControlView, new AnonymousClass4());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        Uri uri;
        String str;
        Uri uri2;
        super.onViewBoundOrOnResume();
        ZoomableDraweeView zoomableDraweeView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(zoomableDraweeView, "binding.mediaImage");
        zoomableDraweeView.setVisibility(getViewModel().getShowCoverFrame() ? 0 : 8);
        ProgressBar progressBar = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.mediaLoadingIndicator");
        progressBar.setVisibility(getViewModel().getShowCoverFrame() ? 0 : 8);
        Uri uri3 = Uri.parse(getMostRecentIntent().getStringExtra(INTENT_URL));
        Uri uri4 = Uri.parse(getMostRecentIntent().getStringExtra(INTENT_IMAGE_URL));
        Intrinsics3.checkNotNullExpressionValue(uri4, "Uri.parse(mostRecentInte…gExtra(INTENT_IMAGE_URL))");
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
                Intrinsics3.throwUninitializedPropertyAccessException("imageUri");
            }
        }
        Uri uri5 = uri;
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_TITLE);
        if (stringExtra == null || StringsJVM.isBlank(stringExtra)) {
            String string2 = uri3.toString();
            Intrinsics3.checkNotNullExpressionValue(string2, "sourceUri.toString()");
            str = string2;
        } else {
            str = stringExtra;
        }
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.view_embed);
        setActionBarSubtitle(str);
        AppFragment.setActionBarOptionsMenu$default(this, R.menu.menu_media, new AnonymousClass1(uri3, uri5, stringExtra, str), null, 4, null);
        configureMediaImage();
        showControls();
        this.playerPausedByFragmentLifecycle = false;
        MediaSource mediaSource2 = this.mediaSource;
        if (mediaSource2 != null) {
            boolean z2 = mediaSource2.mediaType == MediaType.GIFV;
            AppMediaPlayer appMediaPlayer = this.appMediaPlayer;
            if (appMediaPlayer == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("appMediaPlayer");
            }
            boolean isPlaying = getViewModel().getIsPlaying();
            long currentPlayerPositionMs = getViewModel().getCurrentPlayerPositionMs();
            PlayerView playerView = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(playerView, "binding.mediaPlayerView");
            appMediaPlayer.a(mediaSource2, isPlaying, z2, currentPlayerPositionMs, playerView, getBinding().f);
            if (z2) {
                AppMediaPlayer appMediaPlayer2 = this.appMediaPlayer;
                if (appMediaPlayer2 == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("appMediaPlayer");
                }
                appMediaPlayer2.d(0.0f);
            } else {
                AppMediaPlayer appMediaPlayer3 = this.appMediaPlayer;
                if (appMediaPlayer3 == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("appMediaPlayer");
                }
                appMediaPlayer3.d(1.0f);
            }
            AppMediaPlayer appMediaPlayer4 = this.appMediaPlayer;
            if (appMediaPlayer4 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("appMediaPlayer");
            }
            Observable<AppMediaPlayer.Event> observableK = appMediaPlayer4.eventSubject.K();
            Intrinsics3.checkNotNullExpressionValue(observableK, "eventSubject.onBackpressureBuffer()");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableK, this, null, 2, null), (Class<?>) WidgetMedia.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new WidgetMedia6(this));
        }
    }
}
