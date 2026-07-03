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
import com.discord.C5419R;
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
import com.discord.utilities.p500io.NetworkUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.string.StringUtilsKt;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.samples.zoomable.ZoomableDraweeView;
import com.google.android.exoplayer2.p505ui.PlayerControlView;
import com.google.android.exoplayer2.p505ui.PlayerView;
import com.google.android.material.appbar.AppBarLayout;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p008a.p040p.C1184i;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p109f.p132g.p139c.C1755c;
import p007b.p109f.p132g.p142e.C1788v;
import p007b.p109f.p187l.p189b.AbstractC2043a;
import p007b.p109f.p187l.p189b.InterfaceC2047e;
import p007b.p225i.p226a.p242c.AbstractC2944u0;
import p007b.p225i.p226a.p242c.C2816k2;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12145m;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action2;

/* JADX INFO: compiled from: WidgetMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMedia extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetMedia.class, "binding", "getBinding()Lcom/discord/databinding/WidgetMediaBinding;", 0)};

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
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(attachment, "attachment");
            MessageAttachmentType messageAttachmentTypeM8068e = attachment.m8068e();
            launch(context, attachment.getFilename(), attachment.getProxyUrl(), messageAttachmentTypeM8068e.ordinal() != 0 ? null : attachment.getProxyUrl(), attachment.getProxyUrl(), attachment.getWidth(), attachment.getHeight(), messageAttachmentTypeM8068e == MessageAttachmentType.VIDEO ? MediaType.VIDEO : null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code duplicated, block: B:9:0x001c  */
        public final void launch(Context context, MessageEmbed embed) {
            String str;
            int iOrdinal;
            String url;
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(embed, "embed");
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
            MediaSource mediaSourceM462P = (progressiveMediaUri == null || mediaType == null) ? null : C1460d.m462P(mediaType, progressiveMediaUri, "javaClass");
            Intent intentPutExtra = new Intent().putExtra(WidgetMedia.INTENT_TITLE, title);
            if (uri == null) {
                uri = previewImageUri;
            }
            Intent intentPutExtra2 = intentPutExtra.putExtra(WidgetMedia.INTENT_URL, uri).putExtra(WidgetMedia.INTENT_IMAGE_URL, previewImageUri).putExtra(WidgetMedia.INTENT_WIDTH, width).putExtra(WidgetMedia.INTENT_HEIGHT, height).putExtra(WidgetMedia.INTENT_MEDIA_SOURCE, mediaSourceM462P);
            C12238m.checkNotNullExpressionValue(intentPutExtra2, "Intent()\n          .putE…EDIA_SOURCE, mediaSource)");
            C0870j.m156d(context, WidgetMedia.class, intentPutExtra2);
        }
    }

    /* JADX INFO: compiled from: WidgetMedia.kt */
    public enum ControlsAnimationAction {
        SHOW,
        HIDE
    }

    /* JADX INFO: renamed from: com.discord.widgets.media.WidgetMedia$onViewBound$3 */
    /* JADX INFO: compiled from: WidgetMedia.kt */
    public static final class C90633 extends AbstractC12240o implements Function2<Integer, Integer, Unit> {
        public C90633() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
            invoke(num.intValue(), num2.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i, int i2) {
            WidgetMedia.this.toolbarHeight = i;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.media.WidgetMedia$onViewBound$4 */
    /* JADX INFO: compiled from: WidgetMedia.kt */
    public static final class C90644 extends AbstractC12240o implements Function2<Integer, Integer, Unit> {
        public C90644() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
            invoke(num.intValue(), num2.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i, int i2) {
            WidgetMedia.this.playerControlsHeight = i;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.media.WidgetMedia$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetMedia.kt */
    public static final class C90651<T1, T2> implements Action2<MenuItem, Context> {
        public final /* synthetic */ Uri $downloadUri;
        public final /* synthetic */ Uri $sourceUri;
        public final /* synthetic */ String $title;
        public final /* synthetic */ String $titleSubtext;

        /* JADX INFO: renamed from: com.discord.widgets.media.WidgetMedia$onViewBoundOrOnResume$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetMedia.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ Context $context;

            /* JADX INFO: renamed from: com.discord.widgets.media.WidgetMedia$onViewBoundOrOnResume$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetMedia.kt */
            public static final class C132871 extends AbstractC12240o implements Function1<String, Unit> {
                public C132871() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    C12238m.checkNotNullParameter(str, "it");
                    if (WidgetMedia.this.isAdded()) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        WidgetMedia widgetMedia = WidgetMedia.this;
                        Context context = anonymousClass1.$context;
                        C12238m.checkNotNullExpressionValue(context, "context");
                        C0876m.m172j(widgetMedia, C1107b.m216h(context, C5419R.string.download_file_complete, new Object[]{str}, null, 4), 0, 4);
                    }
                }
            }

            /* JADX INFO: renamed from: com.discord.widgets.media.WidgetMedia$onViewBoundOrOnResume$1$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetMedia.kt */
            public static final class AnonymousClass2 extends AbstractC12240o implements Function1<Throwable, Unit> {
                public AnonymousClass2() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    C12238m.checkNotNullParameter(th, "it");
                    if (WidgetMedia.this.isAdded()) {
                        WidgetMedia widgetMedia = WidgetMedia.this;
                        C0876m.m172j(widgetMedia, widgetMedia.getString(C5419R.string.download_failed), 0, 4);
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Context context) {
                super(0);
                this.$context = context;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Context context = this.$context;
                Uri uri = C90651.this.$downloadUri;
                C12238m.checkNotNullExpressionValue(uri, "downloadUri");
                C90651 c90651 = C90651.this;
                NetworkUtils.downloadFile(context, uri, c90651.$title, c90651.$titleSubtext, new C132871(), new AnonymousClass2());
            }
        }

        public C90651(Uri uri, Uri uri2, String str, String str2) {
            this.$sourceUri = uri;
            this.$downloadUri = uri2;
            this.$title = str;
            this.$titleSubtext = str2;
        }

        @Override // p658rx.functions.Action2
        public final void call(MenuItem menuItem, Context context) {
            C12238m.checkNotNullExpressionValue(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case C5419R.id.menu_media_browser /* 2131364395 */:
                    C12238m.checkNotNullExpressionValue(context, "context");
                    String string = this.$sourceUri.toString();
                    C12238m.checkNotNullExpressionValue(string, "sourceUri.toString()");
                    UriHandler.handleOrUntrusted$default(context, string, null, 4, null);
                    break;
                case C5419R.id.menu_media_download /* 2131364396 */:
                    WidgetMedia.this.requestMediaDownload(new AnonymousClass1(context));
                    break;
                case C5419R.id.menu_media_share /* 2131364397 */:
                    C12238m.checkNotNullExpressionValue(context, "context");
                    String string2 = this.$sourceUri.toString();
                    C12238m.checkNotNullExpressionValue(string2, "sourceUri.toString()");
                    IntentUtils.performChooserSendIntent$default(context, string2, null, 4, null);
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.media.WidgetMedia$showControls$1 */
    /* JADX INFO: compiled from: WidgetMedia.kt */
    public static final class C90661 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C90661() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            WidgetMedia.this.controlsVisibilitySubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.media.WidgetMedia$showControls$2 */
    /* JADX INFO: compiled from: WidgetMedia.kt */
    public static final class C90672 extends AbstractC12240o implements Function1<Long, Unit> {
        public C90672() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            WidgetMedia.this.hideControls();
        }
    }

    public WidgetMedia() {
        super(C5419R.layout.widget_media);
        this.binding = FragmentViewBindingDelegateKt.viewBinding(this, WidgetMedia$binding$2.INSTANCE, new WidgetMedia$binding$3(this));
        WidgetMedia$viewModel$2 widgetMedia$viewModel$2 = WidgetMedia$viewModel$2.INSTANCE;
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetMediaViewModel.class), new WidgetMedia$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetMedia$viewModel$2));
    }

    private final void configureAndStartControlsAnimation(ValueAnimator animator) {
        animator.setInterpolator(new FastOutSlowInInterpolator());
        animator.setDuration(VERTICAL_CONTROLS_ANIMATION_DURATION_MS);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.discord.widgets.media.WidgetMedia$configureAndStartControlsAnimation$$inlined$apply$lambda$1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                C12238m.checkNotNullExpressionValue(valueAnimator, "animator");
                Object animatedValue = valueAnimator.getAnimatedValue();
                Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                float fFloatValue = ((Float) animatedValue).floatValue();
                AppBarLayout appBarLayout = this.this$0.getBinding().f17229b;
                C12238m.checkNotNullExpressionValue(appBarLayout, "binding.actionBarToolbarLayout");
                appBarLayout.setTranslationY(fFloatValue);
                if (!this.this$0.isVideo() || this.this$0.playerControlsHeight <= 0) {
                    return;
                }
                float f = (-fFloatValue) / (this.this$0.toolbarHeight / this.this$0.playerControlsHeight);
                PlayerControlView playerControlView = this.this$0.getBinding().f17233f;
                C12238m.checkNotNullExpressionValue(playerControlView, "binding.mediaPlayerControlView");
                playerControlView.setTranslationY(f);
            }
        });
        animator.addListener(new AnimatorListenerAdapter() { // from class: com.discord.widgets.media.WidgetMedia$configureAndStartControlsAnimation$$inlined$apply$lambda$2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                C12238m.checkNotNullParameter(animation, "animation");
                this.this$0.controlsAnimationAction = null;
            }
        });
        animator.start();
    }

    private final void configureMediaImage() {
        getBinding().f17231d.setIsLongpressEnabled(false);
        getBinding().f17231d.setTapListener(new GestureDetector.SimpleOnGestureListener() { // from class: com.discord.widgets.media.WidgetMedia.configureMediaImage.1
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
                C12238m.checkNotNullParameter(e, "e");
                ZoomableDraweeView zoomableDraweeView = WidgetMedia.this.getBinding().f17231d;
                C12238m.checkNotNullExpressionValue(zoomableDraweeView, "binding.mediaImage");
                InterfaceC2047e zoomableController = zoomableDraweeView.getZoomableController();
                Objects.requireNonNull(zoomableController, "null cannot be cast to non-null type com.facebook.samples.zoomable.AbstractAnimatedZoomableController");
                AbstractC2043a abstractC2043a = (AbstractC2043a) zoomableController;
                PointF pointF = new PointF(e.getX(), e.getY());
                float[] fArr = abstractC2043a.f4308j;
                fArr[0] = pointF.x;
                fArr[1] = pointF.y;
                abstractC2043a.f4306h.invert(abstractC2043a.f4307i);
                abstractC2043a.f4307i.mapPoints(fArr, 0, fArr, 0, 1);
                for (int i = 0; i < 1; i++) {
                    int i2 = i * 2;
                    int i3 = i2 + 0;
                    float f = fArr[i3];
                    RectF rectF = abstractC2043a.f4303e;
                    fArr[i3] = (f - rectF.left) / rectF.width();
                    int i4 = i2 + 1;
                    float f2 = fArr[i4];
                    RectF rectF2 = abstractC2043a.f4303e;
                    fArr[i4] = (f2 - rectF2.top) / rectF2.height();
                }
                PointF pointF2 = new PointF(fArr[0], fArr[1]);
                int actionMasked = e.getActionMasked();
                if (actionMasked == 0) {
                    this.mDoubleTapViewPoint.set(pointF);
                    this.mDoubleTapImagePoint.set(pointF2);
                    this.mDoubleTapScale = abstractC2043a.m1559e();
                } else if (actionMasked == 1) {
                    if (this.mDoubleTapScroll) {
                        abstractC2043a.m1556p(calcScale(pointF), this.mDoubleTapImagePoint, this.mDoubleTapViewPoint, 7, 0L, null);
                    } else if (abstractC2043a.m1559e() < 3.0f / 2) {
                        abstractC2043a.m1556p(2.0f, pointF2, pointF, 7, this.DURATION_MS, null);
                    } else {
                        abstractC2043a.m1556p(1.0f, pointF2, pointF, 7, this.DURATION_MS, null);
                    }
                    this.mDoubleTapScroll = false;
                } else if (actionMasked == 2) {
                    boolean z2 = this.mDoubleTapScroll || shouldStartDoubleTapScroll(pointF);
                    this.mDoubleTapScroll = z2;
                    if (z2) {
                        abstractC2043a.m1556p(calcScale(pointF), this.mDoubleTapImagePoint, this.mDoubleTapViewPoint, 7, 0L, null);
                    }
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent e) {
                C12238m.checkNotNullParameter(e, "e");
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
        ZoomableDraweeView zoomableDraweeView = getBinding().f17231d;
        C12238m.checkNotNullExpressionValue(zoomableDraweeView, "binding.mediaImage");
        ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.f19495a;
        ScalingUtils$ScaleType scalingUtils$ScaleType2 = C1788v.f3446l;
        C12238m.checkNotNullExpressionValue(scalingUtils$ScaleType2, "ScalingUtils.ScaleType.FIT_CENTER");
        MGImages.setScaleType(zoomableDraweeView, scalingUtils$ScaleType2);
        ZoomableDraweeView zoomableDraweeView2 = getBinding().f17231d;
        C12238m.checkNotNullExpressionValue(zoomableDraweeView2, "binding.mediaImage");
        ZoomableDraweeView zoomableDraweeView3 = getBinding().f17231d;
        C12238m.checkNotNullExpressionValue(zoomableDraweeView3, "binding.mediaImage");
        Context context = zoomableDraweeView3.getContext();
        C12238m.checkNotNullExpressionValue(context, "binding.mediaImage.context");
        Uri uri = this.imageUri;
        if (uri == null) {
            C12238m.throwUninitializedPropertyAccessException("imageUri");
        }
        MGImages.setImage$default(zoomableDraweeView2, C12145m.listOf(getFormattedUrl(context, uri)), 0, 0, false, null, null, new C1755c<ImageInfo>() { // from class: com.discord.widgets.media.WidgetMedia.configureMediaImage.2
            @Override // p007b.p109f.p132g.p139c.C1755c, com.facebook.drawee.controller.ControllerListener
            public void onFailure(String id2, Throwable throwable) {
                super.onFailure(id2, throwable);
                WidgetMedia.this.handleImageProgressComplete();
            }

            @Override // p007b.p109f.p132g.p139c.C1755c, com.facebook.drawee.controller.ControllerListener
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
        if (lastPathSegment == null || !C12103t.endsWith$default(lastPathSegment, ".gif", false, 2, null)) {
            StringBuilder sbM833U = C1643a.m833U("&format=");
            sbM833U.append(StringUtilsKt.getSTATIC_IMAGE_EXTENSION());
            string = sbM833U.toString();
        } else {
            string = "";
        }
        return uri + "?width=" + rectResizeToFitScreen.width() + "&height=" + rectResizeToFitScreen.height() + string;
    }

    private final float getToolbarTranslationY() {
        AppBarLayout appBarLayout = getBinding().f17229b;
        C12238m.checkNotNullExpressionValue(appBarLayout, "binding.actionBarToolbarLayout");
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
        if (C12238m.areEqual(event, AppMediaPlayer.Event.C5584b.f18655a)) {
            showLoadingIndicator();
            return;
        }
        if (C12238m.areEqual(event, AppMediaPlayer.Event.C5583a.f18654a)) {
            ZoomableDraweeView zoomableDraweeView = getBinding().f17231d;
            C12238m.checkNotNullExpressionValue(zoomableDraweeView, "binding.mediaImage");
            zoomableDraweeView.setVisibility(8);
            getViewModel().setShowCoverFrame(false);
            hideLoadingIndicator();
            return;
        }
        if (event instanceof AppMediaPlayer.Event.C5585c) {
            getViewModel().setCurrentPlayerPositionMs(((AppMediaPlayer.Event.C5585c) event).f18656a);
            return;
        }
        if (C12238m.areEqual(event, AppMediaPlayer.Event.C5586d.f18657a)) {
            if (this.playerPausedByFragmentLifecycle) {
                return;
            }
            getViewModel().setPlaying(false);
        } else if (C12238m.areEqual(event, AppMediaPlayer.Event.C5588f.f18659a)) {
            getViewModel().setPlaying(true);
        } else if (C12238m.areEqual(event, AppMediaPlayer.Event.C5587e.f18658a)) {
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
        C12238m.checkNotNullExpressionValue(valueAnimatorOfFloat, "this");
        configureAndStartControlsAnimation(valueAnimatorOfFloat);
        this.controlsAnimator = valueAnimatorOfFloat;
    }

    private final void hideLoadingIndicator() {
        ProgressBar progressBar = getBinding().f17232e;
        C12238m.checkNotNullExpressionValue(progressBar, "binding.mediaLoadingIndicator");
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
        binding.f17231d.setTapListener(null);
        MGImages mGImages = MGImages.INSTANCE;
        ZoomableDraweeView zoomableDraweeView = binding.f17231d;
        C12238m.checkNotNullExpressionValue(zoomableDraweeView, "binding.mediaImage");
        mGImages.cancelImageRequests(zoomableDraweeView);
    }

    private final void showControls() {
        if (isVideo()) {
            getBinding().f17233f.m8901i();
            Subscription subscription = this.controlsVisibilitySubscription;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            Observable<Long> observableM11068d0 = Observable.m11068d0(SHOW_CONTROLS_TIMEOUT_MS, TimeUnit.MILLISECONDS);
            C12238m.checkNotNullExpressionValue(observableM11068d0, "Observable.timer(SHOW_CO…S, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11068d0, this, null, 2, null), (Class<?>) WidgetMedia.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C90661()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C90672());
        } else {
            getBinding().f17233f.m8895c();
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
        C12238m.checkNotNullExpressionValue(valueAnimatorOfFloat, "this");
        configureAndStartControlsAnimation(valueAnimatorOfFloat);
        this.controlsAnimator = valueAnimatorOfFloat;
    }

    private final void showLoadingIndicator() {
        ProgressBar progressBar = getBinding().f17232e;
        C12238m.checkNotNullExpressionValue(progressBar, "binding.mediaLoadingIndicator");
        progressBar.setVisibility(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        AppMediaPlayer appMediaPlayer = this.appMediaPlayer;
        if (appMediaPlayer == null) {
            C12238m.throwUninitializedPropertyAccessException("appMediaPlayer");
        }
        appMediaPlayer.m8440c();
        super.onDestroy();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AppMediaPlayer appMediaPlayer = this.appMediaPlayer;
        if (appMediaPlayer == null) {
            C12238m.throwUninitializedPropertyAccessException("appMediaPlayer");
        }
        if (((AbstractC2944u0) appMediaPlayer.exoPlayer).mo3534z()) {
            this.playerPausedByFragmentLifecycle = true;
            AppMediaPlayer appMediaPlayer2 = this.appMediaPlayer;
            if (appMediaPlayer2 == null) {
                C12238m.throwUninitializedPropertyAccessException("appMediaPlayer");
            }
            ((C2816k2) appMediaPlayer2.exoPlayer).mo2926u(false);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.appMediaPlayer = C1184i.m233a(requireContext());
        ColorCompat.getThemedColor(this, C5419R.attr.primary_900);
        ColorCompat.setStatusBarColor$default((Fragment) this, ColorCompat.getThemedColor(this, C5419R.attr.primary_900), false, 4, (Object) null);
        PlayerView playerView = getBinding().f17234g;
        C12238m.checkNotNullExpressionValue(playerView, "binding.mediaPlayerView");
        View videoSurfaceView = playerView.getVideoSurfaceView();
        if (videoSurfaceView != null) {
            videoSurfaceView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.media.WidgetMedia.onViewBound.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    WidgetMedia.this.onMediaClick();
                }
            });
        }
        getBinding().f17230c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.media.WidgetMedia.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetMedia.this.onMediaClick();
            }
        });
        AppBarLayout appBarLayout = getBinding().f17229b;
        C12238m.checkNotNullExpressionValue(appBarLayout, "binding.actionBarToolbarLayout");
        ViewExtensions.addOnHeightChangedListener(appBarLayout, new C90633());
        PlayerControlView playerControlView = getBinding().f17233f;
        C12238m.checkNotNullExpressionValue(playerControlView, "binding.mediaPlayerControlView");
        ViewExtensions.addOnHeightChangedListener(playerControlView, new C90644());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() throws CloneNotSupportedException {
        Uri uri;
        String str;
        Uri uri2;
        super.onViewBoundOrOnResume();
        ZoomableDraweeView zoomableDraweeView = getBinding().f17231d;
        C12238m.checkNotNullExpressionValue(zoomableDraweeView, "binding.mediaImage");
        zoomableDraweeView.setVisibility(getViewModel().getShowCoverFrame() ? 0 : 8);
        ProgressBar progressBar = getBinding().f17232e;
        C12238m.checkNotNullExpressionValue(progressBar, "binding.mediaLoadingIndicator");
        progressBar.setVisibility(getViewModel().getShowCoverFrame() ? 0 : 8);
        Uri uri3 = Uri.parse(getMostRecentIntent().getStringExtra(INTENT_URL));
        Uri uri4 = Uri.parse(getMostRecentIntent().getStringExtra(INTENT_IMAGE_URL));
        C12238m.checkNotNullExpressionValue(uri4, "Uri.parse(mostRecentInte…gExtra(INTENT_IMAGE_URL))");
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
                C12238m.throwUninitializedPropertyAccessException("imageUri");
            }
        }
        Uri uri5 = uri;
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_TITLE);
        if (stringExtra == null || C12103t.isBlank(stringExtra)) {
            String string2 = uri3.toString();
            C12238m.checkNotNullExpressionValue(string2, "sourceUri.toString()");
            str = string2;
        } else {
            str = stringExtra;
        }
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(C5419R.string.view_embed);
        setActionBarSubtitle(str);
        AppFragment.setActionBarOptionsMenu$default(this, C5419R.menu.menu_media, new C90651(uri3, uri5, stringExtra, str), null, 4, null);
        configureMediaImage();
        showControls();
        this.playerPausedByFragmentLifecycle = false;
        MediaSource mediaSource2 = this.mediaSource;
        if (mediaSource2 != null) {
            boolean z2 = mediaSource2.mediaType == MediaType.GIFV;
            AppMediaPlayer appMediaPlayer = this.appMediaPlayer;
            if (appMediaPlayer == null) {
                C12238m.throwUninitializedPropertyAccessException("appMediaPlayer");
            }
            boolean isPlaying = getViewModel().getIsPlaying();
            long currentPlayerPositionMs = getViewModel().getCurrentPlayerPositionMs();
            PlayerView playerView = getBinding().f17234g;
            C12238m.checkNotNullExpressionValue(playerView, "binding.mediaPlayerView");
            appMediaPlayer.m8439a(mediaSource2, isPlaying, z2, currentPlayerPositionMs, playerView, getBinding().f17233f);
            if (z2) {
                AppMediaPlayer appMediaPlayer2 = this.appMediaPlayer;
                if (appMediaPlayer2 == null) {
                    C12238m.throwUninitializedPropertyAccessException("appMediaPlayer");
                }
                appMediaPlayer2.m8441d(0.0f);
            } else {
                AppMediaPlayer appMediaPlayer3 = this.appMediaPlayer;
                if (appMediaPlayer3 == null) {
                    C12238m.throwUninitializedPropertyAccessException("appMediaPlayer");
                }
                appMediaPlayer3.m8441d(1.0f);
            }
            AppMediaPlayer appMediaPlayer4 = this.appMediaPlayer;
            if (appMediaPlayer4 == null) {
                C12238m.throwUninitializedPropertyAccessException("appMediaPlayer");
            }
            Observable<AppMediaPlayer.Event> observableM11085K = appMediaPlayer4.eventSubject.m11085K();
            C12238m.checkNotNullExpressionValue(observableM11085K, "eventSubject.onBackpressureBuffer()");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11085K, this, null, 2, null), (Class<?>) WidgetMedia.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new WidgetMedia$onViewBoundOrOnResume$$inlined$let$lambda$1(this));
        }
    }
}
