package com.discord.widgets.chat.list;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import b.a.k.FormatUtils;
import b.a.p.AppMediaPlayerFactory;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import com.discord.R;
import com.discord.api.message.attachment.MessageAttachment;
import com.discord.api.message.attachment.MessageAttachmentType;
import com.discord.api.message.embed.EmbedType;
import com.discord.api.message.embed.EmbedVideo;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.app.AppComponent;
import com.discord.databinding.InlineMediaViewBinding;
import com.discord.embed.RenderableEmbedMedia;
import com.discord.panels.PanelState;
import com.discord.player.AppMediaPlayer;
import com.discord.player.MediaSource;
import com.discord.player.MediaType;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.embed.EmbedResourceUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.RxCoroutineUtils;
import com.discord.utilities.views.ViewCoroutineScope;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.exoplayer2.ui.PlayerView;
import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;
import rx.subscriptions.CompositeSubscription;
import s.a.d2.Flow3;
import s.a.d2.FlowCollector;

/* JADX INFO: compiled from: InlineMediaView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InlineMediaView extends CardView implements View.OnAttachStateChangeListener, AppComponent {
    private AppMediaPlayer appMediaPlayer;
    private final InlineMediaViewBinding binding;
    private CompositeSubscription compositeSubscription;
    private String featureTag;
    private final StoreUserSettings storeUserSettings;
    private final Subject<Void, Void> unsubscribeSignal;
    private ViewParams viewParams;

    /* JADX INFO: compiled from: InlineMediaView.kt */
    public static final /* data */ class ViewParams {
        private final boolean autoPlayGifs;
        private final EmbedType embedType;
        private final RenderableEmbedMedia previewImage;
        private final String progressiveMediaUri;
        private final Integer targetHeight;
        private final Integer targetWidth;

        public ViewParams(RenderableEmbedMedia renderableEmbedMedia, String str, EmbedType embedType, Integer num, Integer num2, boolean z2) {
            this.previewImage = renderableEmbedMedia;
            this.progressiveMediaUri = str;
            this.embedType = embedType;
            this.targetWidth = num;
            this.targetHeight = num2;
            this.autoPlayGifs = z2;
        }

        public static /* synthetic */ ViewParams copy$default(ViewParams viewParams, RenderableEmbedMedia renderableEmbedMedia, String str, EmbedType embedType, Integer num, Integer num2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                renderableEmbedMedia = viewParams.previewImage;
            }
            if ((i & 2) != 0) {
                str = viewParams.progressiveMediaUri;
            }
            String str2 = str;
            if ((i & 4) != 0) {
                embedType = viewParams.embedType;
            }
            EmbedType embedType2 = embedType;
            if ((i & 8) != 0) {
                num = viewParams.targetWidth;
            }
            Integer num3 = num;
            if ((i & 16) != 0) {
                num2 = viewParams.targetHeight;
            }
            Integer num4 = num2;
            if ((i & 32) != 0) {
                z2 = viewParams.autoPlayGifs;
            }
            return viewParams.copy(renderableEmbedMedia, str2, embedType2, num3, num4, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final RenderableEmbedMedia getPreviewImage() {
            return this.previewImage;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getProgressiveMediaUri() {
            return this.progressiveMediaUri;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final EmbedType getEmbedType() {
            return this.embedType;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getTargetWidth() {
            return this.targetWidth;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getTargetHeight() {
            return this.targetHeight;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getAutoPlayGifs() {
            return this.autoPlayGifs;
        }

        public final ViewParams copy(RenderableEmbedMedia previewImage, String progressiveMediaUri, EmbedType embedType, Integer targetWidth, Integer targetHeight, boolean autoPlayGifs) {
            return new ViewParams(previewImage, progressiveMediaUri, embedType, targetWidth, targetHeight, autoPlayGifs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewParams)) {
                return false;
            }
            ViewParams viewParams = (ViewParams) other;
            return Intrinsics3.areEqual(this.previewImage, viewParams.previewImage) && Intrinsics3.areEqual(this.progressiveMediaUri, viewParams.progressiveMediaUri) && Intrinsics3.areEqual(this.embedType, viewParams.embedType) && Intrinsics3.areEqual(this.targetWidth, viewParams.targetWidth) && Intrinsics3.areEqual(this.targetHeight, viewParams.targetHeight) && this.autoPlayGifs == viewParams.autoPlayGifs;
        }

        public final boolean getAutoPlayGifs() {
            return this.autoPlayGifs;
        }

        public final EmbedType getEmbedType() {
            return this.embedType;
        }

        public final RenderableEmbedMedia getPreviewImage() {
            return this.previewImage;
        }

        public final String getProgressiveMediaUri() {
            return this.progressiveMediaUri;
        }

        public final Integer getTargetHeight() {
            return this.targetHeight;
        }

        public final Integer getTargetWidth() {
            return this.targetWidth;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            RenderableEmbedMedia renderableEmbedMedia = this.previewImage;
            int iHashCode = (renderableEmbedMedia != null ? renderableEmbedMedia.hashCode() : 0) * 31;
            String str = this.progressiveMediaUri;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            EmbedType embedType = this.embedType;
            int iHashCode3 = (iHashCode2 + (embedType != null ? embedType.hashCode() : 0)) * 31;
            Integer num = this.targetWidth;
            int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 31;
            Integer num2 = this.targetHeight;
            int iHashCode5 = (iHashCode4 + (num2 != null ? num2.hashCode() : 0)) * 31;
            boolean z2 = this.autoPlayGifs;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode5 + r1;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewParams(previewImage=");
            sbU.append(this.previewImage);
            sbU.append(", progressiveMediaUri=");
            sbU.append(this.progressiveMediaUri);
            sbU.append(", embedType=");
            sbU.append(this.embedType);
            sbU.append(", targetWidth=");
            sbU.append(this.targetWidth);
            sbU.append(", targetHeight=");
            sbU.append(this.targetHeight);
            sbU.append(", autoPlayGifs=");
            return outline.O(sbU, this.autoPlayGifs, ")");
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            MessageAttachmentType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[MessageAttachmentType.VIDEO.ordinal()] = 1;
            iArr[MessageAttachmentType.IMAGE.ordinal()] = 2;
            iArr[MessageAttachmentType.FILE.ordinal()] = 3;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.InlineMediaView$onViewAttachedToWindow$1, reason: invalid class name */
    /* JADX INFO: compiled from: InlineMediaView.kt */
    @DebugMetadata(c = "com.discord.widgets.chat.list.InlineMediaView$onViewAttachedToWindow$1", f = "InlineMediaView.kt", l = {89, 416}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return InlineMediaView.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    Result3.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Result3.throwOnFailure(obj);
                }
                return Unit.a;
            }
            Result3.throwOnFailure(obj);
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable observableR = Observable.j(companion.getNavigation().observeLeftPanelState(), companion.getNavigation().observeRightPanelState(), new Func2<PanelState, PanelState, Boolean>() { // from class: com.discord.widgets.chat.list.InlineMediaView.onViewAttachedToWindow.1.1
                @Override // rx.functions.Func2
                public final Boolean call(PanelState panelState, PanelState panelState2) {
                    PanelState.c cVar = PanelState.c.a;
                    return Boolean.valueOf(Intrinsics3.areEqual(panelState, cVar) || Intrinsics3.areEqual(panelState2, cVar));
                }
            }).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
            this.label = 1;
            obj = RxCoroutineUtils.toFlow(observableR, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            FlowCollector<Boolean> flowCollector = new FlowCollector<Boolean>() { // from class: com.discord.widgets.chat.list.InlineMediaView$onViewAttachedToWindow$1$invokeSuspend$$inlined$collect$1
                @Override // s.a.d2.FlowCollector
                public Object emit(Boolean bool, Continuation continuation) {
                    Boolean bool2 = bool;
                    View view = InlineMediaView.this.binding.h;
                    Intrinsics3.checkNotNullExpressionValue(view, "binding.opacityShim");
                    Intrinsics3.checkNotNullExpressionValue(bool2, "isAnyPanelOpen");
                    view.setVisibility(bool2.booleanValue() ? 0 : 8);
                    return Unit.a;
                }
            };
            this.label = 2;
            if (((Flow3) obj).a(flowCollector, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.InlineMediaView$updateUI$1, reason: invalid class name */
    /* JADX INFO: compiled from: InlineMediaView.kt */
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
            InlineMediaView.this.compositeSubscription.a(subscription);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.InlineMediaView$updateUI$2, reason: invalid class name */
    /* JADX INFO: compiled from: InlineMediaView.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Float, Unit> {
        public final /* synthetic */ AppMediaPlayer $player;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(AppMediaPlayer appMediaPlayer) {
            super(1);
            this.$player = appMediaPlayer;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Float f) {
            invoke(f.floatValue());
            return Unit.a;
        }

        public final void invoke(float f) {
            final boolean z2 = f > ((float) 0);
            InlineMediaView.this.binding.g.setImageDrawable(ContextCompat.getDrawable(InlineMediaView.this.getContext(), z2 ? R.drawable.ic_volume_up_white_24dp : R.drawable.ic_volume_off_24dp));
            InlineMediaView.this.binding.g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.InlineMediaView.updateUI.2.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AnonymousClass2.this.$player.d(z2 ? 0.0f : 1.0f);
                }
            });
            int i = z2 ? R.string.video_playback_mute_accessibility_label : R.string.video_playback_unmute_accessibility_label;
            ImageView imageView = InlineMediaView.this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.inlineMediaVolumeToggle");
            imageView.setContentDescription(FormatUtils.d(InlineMediaView.this, i, new Object[0], (4 & 4) != 0 ? FormatUtils.c.j : null));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.InlineMediaView$updateUI$3, reason: invalid class name */
    /* JADX INFO: compiled from: InlineMediaView.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass3() {
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
            InlineMediaView.this.compositeSubscription.a(subscription);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.InlineMediaView$updateUI$4, reason: invalid class name */
    /* JADX INFO: compiled from: InlineMediaView.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<AppMediaPlayer.Event, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AppMediaPlayer.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AppMediaPlayer.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            InlineMediaView.this.handlePlayerEvent(event);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InlineMediaView(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        InlineMediaViewBinding inlineMediaViewBindingA = InlineMediaViewBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(inlineMediaViewBindingA, "InlineMediaViewBinding.i…ater.from(context), this)");
        this.binding = inlineMediaViewBindingA;
        this.storeUserSettings = StoreStream.INSTANCE.getUserSettings();
        this.featureTag = "";
        this.compositeSubscription = new CompositeSubscription();
        addOnAttachStateChangeListener(this);
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectK0;
    }

    private final void clearPlayerAndSubscriptions() {
        releasePlayer();
        getUnsubscribeSignal().onNext(null);
    }

    private final void diffViewParamsAndUpdateEmbed(RenderableEmbedMedia previewImage, String progressiveMediaUri, EmbedType embedType, Integer targetWidth, Integer targetHeight, String featureTag, boolean autoPlayGifs) {
        Integer targetWidth2;
        Integer targetHeight2;
        if (targetWidth != null) {
            targetWidth2 = targetWidth;
        } else {
            ViewParams viewParams = this.viewParams;
            targetWidth2 = viewParams != null ? viewParams.getTargetWidth() : null;
        }
        if (targetHeight != null) {
            targetHeight2 = targetHeight;
        } else {
            ViewParams viewParams2 = this.viewParams;
            targetHeight2 = viewParams2 != null ? viewParams2.getTargetHeight() : null;
        }
        ViewParams viewParams3 = new ViewParams(previewImage, progressiveMediaUri, embedType, targetWidth2, targetHeight2, autoPlayGifs);
        if (Intrinsics3.areEqual(viewParams3, this.viewParams)) {
            return;
        }
        this.viewParams = viewParams3;
        updateUI(previewImage, progressiveMediaUri, embedType, targetWidth, targetHeight, featureTag);
    }

    private final void handlePlayerEvent(AppMediaPlayer.Event event) {
        boolean z2 = true;
        if (Intrinsics3.areEqual(event, AppMediaPlayer.Event.a.a)) {
            SimpleDraweeView simpleDraweeView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.inlineMediaImagePreview");
            simpleDraweeView.setVisibility(shouldAutoPlay() ^ true ? 0 : 8);
            ProgressBar progressBar = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.inlineMediaLoadingIndicator");
            progressBar.setVisibility(8);
            return;
        }
        if (!Intrinsics3.areEqual(event, AppMediaPlayer.Event.f.a)) {
            if (Intrinsics3.areEqual(event, AppMediaPlayer.Event.e.a)) {
                resetCurrentEmbed();
                return;
            }
            return;
        }
        ViewParams viewParams = this.viewParams;
        EmbedType embedType = viewParams != null ? viewParams.getEmbedType() : null;
        ImageView imageView = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.inlineMediaVolumeToggle");
        if (embedType != EmbedType.VIDEO && embedType != null) {
            z2 = false;
        }
        imageView.setVisibility(z2 ? 0 : 8);
    }

    private final void releasePlayer() {
        AppMediaPlayer appMediaPlayer = this.appMediaPlayer;
        if (appMediaPlayer != null) {
            appMediaPlayer.c();
        }
        this.appMediaPlayer = null;
    }

    private final void resetCurrentEmbed() {
        ViewParams viewParams = this.viewParams;
        if (viewParams != null) {
            updateUI(viewParams.getPreviewImage(), viewParams.getProgressiveMediaUri(), viewParams.getEmbedType(), viewParams.getTargetWidth(), viewParams.getTargetHeight(), this.featureTag);
        }
    }

    private final void resetViews() {
        ViewParams viewParams = this.viewParams;
        if (viewParams != null) {
            SimpleDraweeView simpleDraweeView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.inlineMediaImagePreview");
            simpleDraweeView.setVisibility(0);
            ImageView imageView = this.binding.f2126b;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.inlineMediaGifIndicator");
            imageView.setVisibility(shouldAutoPlay() ^ true ? 0 : 8);
            PlayerView playerView = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(playerView, "binding.inlineMediaPlayerView");
            playerView.setVisibility(8);
            ImageView imageView2 = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.inlineMediaVolumeToggle");
            imageView2.setVisibility(8);
            ImageView imageView3 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.inlineMediaPlayButton");
            imageView3.setVisibility(viewParams.getEmbedType() == EmbedType.VIDEO ? 0 : 8);
            ProgressBar progressBar = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.inlineMediaLoadingIndicator");
            progressBar.setVisibility(8);
            ImageView imageView4 = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.inlineMediaVolumeToggle");
            imageView4.setVisibility(8);
        }
    }

    private final boolean shouldAutoPlay() {
        RenderableEmbedMedia previewImage;
        EmbedResourceUtils embedResourceUtils = EmbedResourceUtils.INSTANCE;
        ViewParams viewParams = this.viewParams;
        String str = null;
        EmbedType embedType = viewParams != null ? viewParams.getEmbedType() : null;
        ViewParams viewParams2 = this.viewParams;
        if (viewParams2 != null && (previewImage = viewParams2.getPreviewImage()) != null) {
            str = previewImage.url;
        }
        if (!embedResourceUtils.isAnimated(embedType, str)) {
            return true;
        }
        ViewParams viewParams3 = this.viewParams;
        return viewParams3 != null ? viewParams3.getAutoPlayGifs() : this.storeUserSettings.getIsAutoPlayGifsEnabled();
    }

    private final void updateUI(RenderableEmbedMedia previewImage, String progressiveMediaUri, EmbedType embedType, Integer targetWidth, Integer targetHeight, String featureTag) {
        resetViews();
        this.compositeSubscription.unsubscribe();
        if (targetWidth != null && targetHeight != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams.width != targetWidth.intValue() || layoutParams.height != targetHeight.intValue()) {
                layoutParams.width = targetWidth.intValue();
                layoutParams.height = targetHeight.intValue();
                requestLayout();
            }
            if ((previewImage != null ? previewImage.url : null) != null) {
                SimpleDraweeView simpleDraweeView = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.inlineMediaImagePreview");
                MGImages.setImage$default(simpleDraweeView, EmbedResourceUtils.INSTANCE.getPreviewUrls(previewImage.url, targetWidth.intValue(), targetHeight.intValue(), shouldAutoPlay()), 0, 0, false, null, null, null, 252, null);
            }
        }
        if (progressiveMediaUri == null) {
            return;
        }
        AppMediaPlayer appMediaPlayerA = this.appMediaPlayer;
        if (appMediaPlayerA == null) {
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            appMediaPlayerA = AppMediaPlayerFactory.a(context);
        }
        this.appMediaPlayer = appMediaPlayerA;
        PlayerView playerView = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(playerView, "binding.inlineMediaPlayerView");
        playerView.setVisibility(shouldAutoPlay() ? 0 : 8);
        ImageView imageView = this.binding.f2126b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.inlineMediaGifIndicator");
        imageView.setVisibility(shouldAutoPlay() ^ true ? 0 : 8);
        Intrinsics3.checkNotNullParameter(progressiveMediaUri, "progressiveMediaUri");
        Intrinsics3.checkNotNullParameter(featureTag, "featureTag");
        EmbedType embedType2 = EmbedType.GIFV;
        final MediaSource mediaSourceP = AnimatableValueParser.P(embedType == embedType2 ? MediaType.GIFV : MediaType.VIDEO, progressiveMediaUri, featureTag);
        this.compositeSubscription = new CompositeSubscription();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(appMediaPlayerA.volumeSubject, this, null, 2, null), (Class<?>) InlineMediaView.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass1()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(appMediaPlayerA));
        Observable<AppMediaPlayer.Event> observableK = appMediaPlayerA.eventSubject.K();
        Intrinsics3.checkNotNullExpressionValue(observableK, "eventSubject.onBackpressureBuffer()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableK, this, null, 2, null), (Class<?>) InlineMediaView.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass3()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass4());
        if (embedType == embedType2) {
            boolean zShouldAutoPlay = shouldAutoPlay();
            PlayerView playerView2 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(playerView2, "binding.inlineMediaPlayerView");
            AppMediaPlayer.b(appMediaPlayerA, mediaSourceP, zShouldAutoPlay, true, 0L, playerView2, null, 40);
            appMediaPlayerA.d(0.0f);
        } else {
            appMediaPlayerA.d(1.0f);
        }
        this.binding.e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.InlineMediaView.updateUI.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayerView playerView3 = InlineMediaView.this.binding.f;
                Intrinsics3.checkNotNullExpressionValue(playerView3, "binding.inlineMediaPlayerView");
                playerView3.setVisibility(0);
                AppMediaPlayer appMediaPlayer = InlineMediaView.this.appMediaPlayer;
                if (appMediaPlayer != null) {
                    MediaSource mediaSource = mediaSourceP;
                    PlayerView playerView4 = InlineMediaView.this.binding.f;
                    Intrinsics3.checkNotNullExpressionValue(playerView4, "binding.inlineMediaPlayerView");
                    AppMediaPlayer.b(appMediaPlayer, mediaSource, true, false, 0L, playerView4, null, 40);
                }
                ImageView imageView2 = InlineMediaView.this.binding.e;
                Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.inlineMediaPlayButton");
                imageView2.setVisibility(8);
                ProgressBar progressBar = InlineMediaView.this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.inlineMediaLoadingIndicator");
                progressBar.setVisibility(0);
            }
        });
    }

    public static /* synthetic */ void updateUIWithAttachment$default(InlineMediaView inlineMediaView, MessageAttachment messageAttachment, Integer num, Integer num2, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        inlineMediaView.updateUIWithAttachment(messageAttachment, num, num2, z2);
    }

    public static /* synthetic */ void updateUIWithEmbed$default(InlineMediaView inlineMediaView, MessageEmbed messageEmbed, Integer num, Integer num2, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        inlineMediaView.updateUIWithEmbed(messageEmbed, num, num2, z2);
    }

    @Override // com.discord.app.AppComponent
    public Subject<Void, Void> getUnsubscribeSignal() {
        return this.unsubscribeSignal;
    }

    public final void onPause() {
        clearPlayerAndSubscriptions();
    }

    public final void onResume() {
        resetCurrentEmbed();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        CoroutineScope coroutineScope;
        Intrinsics3.checkNotNullParameter(view, "view");
        resetCurrentEmbed();
        PlayerView playerView = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(playerView, "binding.inlineMediaPlayerView");
        if (!(playerView.getVideoSurfaceView() instanceof SurfaceView) || (coroutineScope = ViewCoroutineScope.getCoroutineScope(this)) == null) {
            return;
        }
        f.H0(coroutineScope, null, null, new AnonymousClass1(null), 3, null);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        clearPlayerAndSubscriptions();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View changedView, int visibility) {
        Intrinsics3.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == 0) {
            resetCurrentEmbed();
        } else {
            clearPlayerAndSubscriptions();
        }
    }

    public final void updateUIWithAttachment(MessageAttachment attachment, Integer targetWidth, Integer targetHeight, boolean autoPlayGifs) {
        EmbedType embedType;
        Intrinsics3.checkNotNullParameter(attachment, "attachment");
        MessageAttachmentType messageAttachmentTypeE = attachment.e();
        if ((messageAttachmentTypeE == MessageAttachmentType.IMAGE || messageAttachmentTypeE == MessageAttachmentType.VIDEO) && this.storeUserSettings.getIsAttachmentMediaInline()) {
            RenderableEmbedMedia renderableEmbedMediaCreateRenderableEmbedMediaFromAttachment = EmbedResourceUtils.INSTANCE.createRenderableEmbedMediaFromAttachment(attachment);
            this.featureTag = InlineMediaView.class.getSimpleName() + ": attachment";
            String proxyUrl = attachment.e() == MessageAttachmentType.VIDEO ? attachment.getProxyUrl() : null;
            int iOrdinal = messageAttachmentTypeE.ordinal();
            if (iOrdinal == 0) {
                embedType = EmbedType.VIDEO;
            } else if (iOrdinal == 1) {
                embedType = EmbedType.IMAGE;
            } else {
                if (iOrdinal != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                embedType = EmbedType.FILE;
            }
            diffViewParamsAndUpdateEmbed(renderableEmbedMediaCreateRenderableEmbedMediaFromAttachment, proxyUrl, embedType, targetWidth, targetHeight, this.featureTag, autoPlayGifs);
        }
    }

    public final void updateUIWithEmbed(MessageEmbed embed, Integer targetWidth, Integer targetHeight, boolean autoPlayGifs) {
        String url;
        Intrinsics3.checkNotNullParameter(embed, "embed");
        EmbedResourceUtils embedResourceUtils = EmbedResourceUtils.INSTANCE;
        if ((embedResourceUtils.getPreviewImage(embed) != null) && this.storeUserSettings.getIsEmbedMediaInlined() && this.storeUserSettings.getIsRenderEmbedsEnabled()) {
            this.featureTag = InlineMediaView.class.getSimpleName() + ": embed";
            EmbedVideo video = embed.getVideo();
            if (video == null || (url = video.getProxyUrl()) == null) {
                EmbedVideo video2 = embed.getVideo();
                url = video2 != null ? video2.getUrl() : null;
            }
            diffViewParamsAndUpdateEmbed(embedResourceUtils.getPreviewImage(embed), url, embed.getType(), targetWidth, targetHeight, this.featureTag, autoPlayGifs);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InlineMediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        InlineMediaViewBinding inlineMediaViewBindingA = InlineMediaViewBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(inlineMediaViewBindingA, "InlineMediaViewBinding.i…ater.from(context), this)");
        this.binding = inlineMediaViewBindingA;
        this.storeUserSettings = StoreStream.INSTANCE.getUserSettings();
        this.featureTag = "";
        this.compositeSubscription = new CompositeSubscription();
        addOnAttachStateChangeListener(this);
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectK0;
    }

    public /* synthetic */ InlineMediaView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InlineMediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        InlineMediaViewBinding inlineMediaViewBindingA = InlineMediaViewBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(inlineMediaViewBindingA, "InlineMediaViewBinding.i…ater.from(context), this)");
        this.binding = inlineMediaViewBindingA;
        this.storeUserSettings = StoreStream.INSTANCE.getUserSettings();
        this.featureTag = "";
        this.compositeSubscription = new CompositeSubscription();
        addOnAttachStateChangeListener(this);
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectK0;
    }

    public /* synthetic */ InlineMediaView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
