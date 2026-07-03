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
import com.discord.C5419R;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.p501rx.RxCoroutineUtilsKt;
import com.discord.utilities.views.ViewCoroutineScopeKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.exoplayer2.p505ui.PlayerView;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import p007b.p008a.p027k.C1107b;
import p007b.p008a.p040p.C1184i;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12113l;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;
import p658rx.subjects.PublishSubject;
import p658rx.subjects.Subject;
import p658rx.subscriptions.CompositeSubscription;
import p659s.p660a.p664d2.InterfaceC13082d;
import p659s.p660a.p664d2.InterfaceC13083e;

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
            return C12238m.areEqual(this.previewImage, viewParams.previewImage) && C12238m.areEqual(this.progressiveMediaUri, viewParams.progressiveMediaUri) && C12238m.areEqual(this.embedType, viewParams.embedType) && C12238m.areEqual(this.targetWidth, viewParams.targetWidth) && C12238m.areEqual(this.targetHeight, viewParams.targetHeight) && this.autoPlayGifs == viewParams.autoPlayGifs;
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
            StringBuilder sbM833U = C1643a.m833U("ViewParams(previewImage=");
            sbM833U.append(this.previewImage);
            sbM833U.append(", progressiveMediaUri=");
            sbM833U.append(this.progressiveMediaUri);
            sbM833U.append(", embedType=");
            sbM833U.append(this.embedType);
            sbM833U.append(", targetWidth=");
            sbM833U.append(this.targetWidth);
            sbM833U.append(", targetHeight=");
            sbM833U.append(this.targetHeight);
            sbM833U.append(", autoPlayGifs=");
            return C1643a.m827O(sbM833U, this.autoPlayGifs, ")");
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

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.InlineMediaView$onViewAttachedToWindow$1 */
    /* JADX INFO: compiled from: InlineMediaView.kt */
    @InterfaceC12188e(m10084c = "com.discord.widgets.chat.list.InlineMediaView$onViewAttachedToWindow$1", m10085f = "InlineMediaView.kt", m10086l = {89, 416}, m10087m = "invokeSuspend")
    public static final class C79331 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public C79331(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            return InlineMediaView.this.new C79331(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C79331) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    C12113l.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C12113l.throwOnFailure(obj);
                }
                return Unit.f27425a;
            }
            C12113l.throwOnFailure(obj);
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable observableM11112r = Observable.m11076j(companion.getNavigation().observeLeftPanelState(), companion.getNavigation().observeRightPanelState(), new Func2<PanelState, PanelState, Boolean>() { // from class: com.discord.widgets.chat.list.InlineMediaView.onViewAttachedToWindow.1.1
                @Override // p658rx.functions.Func2
                public final Boolean call(PanelState panelState, PanelState panelState2) {
                    PanelState.C5580c c5580c = PanelState.C5580c.f18642a;
                    return Boolean.valueOf(C12238m.areEqual(panelState, c5580c) || C12238m.areEqual(panelState2, c5580c));
                }
            }).m11112r();
            C12238m.checkNotNullExpressionValue(observableM11112r, "Observable.combineLatest…  .distinctUntilChanged()");
            this.label = 1;
            obj = RxCoroutineUtilsKt.toFlow(observableM11112r, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            InterfaceC13083e<Boolean> interfaceC13083e = new InterfaceC13083e<Boolean>() { // from class: com.discord.widgets.chat.list.InlineMediaView$onViewAttachedToWindow$1$invokeSuspend$$inlined$collect$1
                @Override // p659s.p660a.p664d2.InterfaceC13083e
                public Object emit(Boolean bool, Continuation continuation) {
                    Boolean bool2 = bool;
                    View view = InlineMediaView.this.binding.f15173h;
                    C12238m.checkNotNullExpressionValue(view, "binding.opacityShim");
                    C12238m.checkNotNullExpressionValue(bool2, "isAnyPanelOpen");
                    view.setVisibility(bool2.booleanValue() ? 0 : 8);
                    return Unit.f27425a;
                }
            };
            this.label = 2;
            if (((InterfaceC13082d) obj).mo11246a(interfaceC13083e, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.InlineMediaView$updateUI$1 */
    /* JADX INFO: compiled from: InlineMediaView.kt */
    public static final class C79351 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C79351() {
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
            InlineMediaView.this.compositeSubscription.m11136a(subscription);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.InlineMediaView$updateUI$2 */
    /* JADX INFO: compiled from: InlineMediaView.kt */
    public static final class C79362 extends AbstractC12240o implements Function1<Float, Unit> {
        public final /* synthetic */ AppMediaPlayer $player;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C79362(AppMediaPlayer appMediaPlayer) {
            super(1);
            this.$player = appMediaPlayer;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Float f) {
            invoke(f.floatValue());
            return Unit.f27425a;
        }

        public final void invoke(float f) {
            final boolean z2 = f > ((float) 0);
            InlineMediaView.this.binding.f15172g.setImageDrawable(ContextCompat.getDrawable(InlineMediaView.this.getContext(), z2 ? C5419R.drawable.ic_volume_up_white_24dp : C5419R.drawable.ic_volume_off_24dp));
            InlineMediaView.this.binding.f15172g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.InlineMediaView.updateUI.2.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C79362.this.$player.m8441d(z2 ? 0.0f : 1.0f);
                }
            });
            int i = z2 ? C5419R.string.video_playback_mute_accessibility_label : C5419R.string.video_playback_unmute_accessibility_label;
            ImageView imageView = InlineMediaView.this.binding.f15172g;
            C12238m.checkNotNullExpressionValue(imageView, "binding.inlineMediaVolumeToggle");
            imageView.setContentDescription(C1107b.m212d(InlineMediaView.this, i, new Object[0], (4 & 4) != 0 ? C1107b.c.f1492j : null));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.InlineMediaView$updateUI$3 */
    /* JADX INFO: compiled from: InlineMediaView.kt */
    public static final class C79373 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C79373() {
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
            InlineMediaView.this.compositeSubscription.m11136a(subscription);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.InlineMediaView$updateUI$4 */
    /* JADX INFO: compiled from: InlineMediaView.kt */
    public static final class C79384 extends AbstractC12240o implements Function1<AppMediaPlayer.Event, Unit> {
        public C79384() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AppMediaPlayer.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AppMediaPlayer.Event event) {
            C12238m.checkNotNullParameter(event, "event");
            InlineMediaView.this.handlePlayerEvent(event);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InlineMediaView(Context context) {
        super(context);
        C12238m.checkNotNullParameter(context, "context");
        InlineMediaViewBinding inlineMediaViewBindingM8388a = InlineMediaViewBinding.m8388a(LayoutInflater.from(getContext()), this);
        C12238m.checkNotNullExpressionValue(inlineMediaViewBindingM8388a, "InlineMediaViewBinding.i…ater.from(context), this)");
        this.binding = inlineMediaViewBindingM8388a;
        this.storeUserSettings = StoreStream.INSTANCE.getUserSettings();
        this.featureTag = "";
        this.compositeSubscription = new CompositeSubscription();
        addOnAttachStateChangeListener(this);
        PublishSubject publishSubjectM11133k0 = PublishSubject.m11133k0();
        C12238m.checkNotNullExpressionValue(publishSubjectM11133k0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectM11133k0;
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
        if (C12238m.areEqual(viewParams3, this.viewParams)) {
            return;
        }
        this.viewParams = viewParams3;
        updateUI(previewImage, progressiveMediaUri, embedType, targetWidth, targetHeight, featureTag);
    }

    private final void handlePlayerEvent(AppMediaPlayer.Event event) {
        boolean z2 = true;
        if (C12238m.areEqual(event, AppMediaPlayer.Event.C5583a.f18654a)) {
            SimpleDraweeView simpleDraweeView = this.binding.f15168c;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.inlineMediaImagePreview");
            simpleDraweeView.setVisibility(shouldAutoPlay() ^ true ? 0 : 8);
            ProgressBar progressBar = this.binding.f15169d;
            C12238m.checkNotNullExpressionValue(progressBar, "binding.inlineMediaLoadingIndicator");
            progressBar.setVisibility(8);
            return;
        }
        if (!C12238m.areEqual(event, AppMediaPlayer.Event.C5588f.f18659a)) {
            if (C12238m.areEqual(event, AppMediaPlayer.Event.C5587e.f18658a)) {
                resetCurrentEmbed();
                return;
            }
            return;
        }
        ViewParams viewParams = this.viewParams;
        EmbedType embedType = viewParams != null ? viewParams.getEmbedType() : null;
        ImageView imageView = this.binding.f15172g;
        C12238m.checkNotNullExpressionValue(imageView, "binding.inlineMediaVolumeToggle");
        if (embedType != EmbedType.VIDEO && embedType != null) {
            z2 = false;
        }
        imageView.setVisibility(z2 ? 0 : 8);
    }

    private final void releasePlayer() {
        AppMediaPlayer appMediaPlayer = this.appMediaPlayer;
        if (appMediaPlayer != null) {
            appMediaPlayer.m8440c();
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
            SimpleDraweeView simpleDraweeView = this.binding.f15168c;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.inlineMediaImagePreview");
            simpleDraweeView.setVisibility(0);
            ImageView imageView = this.binding.f15167b;
            C12238m.checkNotNullExpressionValue(imageView, "binding.inlineMediaGifIndicator");
            imageView.setVisibility(shouldAutoPlay() ^ true ? 0 : 8);
            PlayerView playerView = this.binding.f15171f;
            C12238m.checkNotNullExpressionValue(playerView, "binding.inlineMediaPlayerView");
            playerView.setVisibility(8);
            ImageView imageView2 = this.binding.f15172g;
            C12238m.checkNotNullExpressionValue(imageView2, "binding.inlineMediaVolumeToggle");
            imageView2.setVisibility(8);
            ImageView imageView3 = this.binding.f15170e;
            C12238m.checkNotNullExpressionValue(imageView3, "binding.inlineMediaPlayButton");
            imageView3.setVisibility(viewParams.getEmbedType() == EmbedType.VIDEO ? 0 : 8);
            ProgressBar progressBar = this.binding.f15169d;
            C12238m.checkNotNullExpressionValue(progressBar, "binding.inlineMediaLoadingIndicator");
            progressBar.setVisibility(8);
            ImageView imageView4 = this.binding.f15172g;
            C12238m.checkNotNullExpressionValue(imageView4, "binding.inlineMediaVolumeToggle");
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
                SimpleDraweeView simpleDraweeView = this.binding.f15168c;
                C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.inlineMediaImagePreview");
                MGImages.setImage$default(simpleDraweeView, EmbedResourceUtils.INSTANCE.getPreviewUrls(previewImage.url, targetWidth.intValue(), targetHeight.intValue(), shouldAutoPlay()), 0, 0, false, null, null, null, 252, null);
            }
        }
        if (progressiveMediaUri == null) {
            return;
        }
        AppMediaPlayer appMediaPlayerM233a = this.appMediaPlayer;
        if (appMediaPlayerM233a == null) {
            Context context = getContext();
            C12238m.checkNotNullExpressionValue(context, "context");
            appMediaPlayerM233a = C1184i.m233a(context);
        }
        this.appMediaPlayer = appMediaPlayerM233a;
        PlayerView playerView = this.binding.f15171f;
        C12238m.checkNotNullExpressionValue(playerView, "binding.inlineMediaPlayerView");
        playerView.setVisibility(shouldAutoPlay() ? 0 : 8);
        ImageView imageView = this.binding.f15167b;
        C12238m.checkNotNullExpressionValue(imageView, "binding.inlineMediaGifIndicator");
        imageView.setVisibility(shouldAutoPlay() ^ true ? 0 : 8);
        C12238m.checkNotNullParameter(progressiveMediaUri, "progressiveMediaUri");
        C12238m.checkNotNullParameter(featureTag, "featureTag");
        EmbedType embedType2 = EmbedType.GIFV;
        final MediaSource mediaSourceM462P = C1460d.m462P(embedType == embedType2 ? MediaType.GIFV : MediaType.VIDEO, progressiveMediaUri, featureTag);
        this.compositeSubscription = new CompositeSubscription();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(appMediaPlayerM233a.volumeSubject, this, null, 2, null), (Class<?>) InlineMediaView.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C79351()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C79362(appMediaPlayerM233a));
        Observable<AppMediaPlayer.Event> observableM11085K = appMediaPlayerM233a.eventSubject.m11085K();
        C12238m.checkNotNullExpressionValue(observableM11085K, "eventSubject.onBackpressureBuffer()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11085K, this, null, 2, null), (Class<?>) InlineMediaView.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C79373()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C79384());
        if (embedType == embedType2) {
            boolean zShouldAutoPlay = shouldAutoPlay();
            PlayerView playerView2 = this.binding.f15171f;
            C12238m.checkNotNullExpressionValue(playerView2, "binding.inlineMediaPlayerView");
            AppMediaPlayer.m8438b(appMediaPlayerM233a, mediaSourceM462P, zShouldAutoPlay, true, 0L, playerView2, null, 40);
            appMediaPlayerM233a.m8441d(0.0f);
        } else {
            appMediaPlayerM233a.m8441d(1.0f);
        }
        this.binding.f15170e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.InlineMediaView.updateUI.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayerView playerView3 = InlineMediaView.this.binding.f15171f;
                C12238m.checkNotNullExpressionValue(playerView3, "binding.inlineMediaPlayerView");
                playerView3.setVisibility(0);
                AppMediaPlayer appMediaPlayer = InlineMediaView.this.appMediaPlayer;
                if (appMediaPlayer != null) {
                    MediaSource mediaSource = mediaSourceM462P;
                    PlayerView playerView4 = InlineMediaView.this.binding.f15171f;
                    C12238m.checkNotNullExpressionValue(playerView4, "binding.inlineMediaPlayerView");
                    AppMediaPlayer.m8438b(appMediaPlayer, mediaSource, true, false, 0L, playerView4, null, 40);
                }
                ImageView imageView2 = InlineMediaView.this.binding.f15170e;
                C12238m.checkNotNullExpressionValue(imageView2, "binding.inlineMediaPlayButton");
                imageView2.setVisibility(8);
                ProgressBar progressBar = InlineMediaView.this.binding.f15169d;
                C12238m.checkNotNullExpressionValue(progressBar, "binding.inlineMediaLoadingIndicator");
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
        C12238m.checkNotNullParameter(view, "view");
        resetCurrentEmbed();
        PlayerView playerView = this.binding.f15171f;
        C12238m.checkNotNullExpressionValue(playerView, "binding.inlineMediaPlayerView");
        if (!(playerView.getVideoSurfaceView() instanceof SurfaceView) || (coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(this)) == null) {
            return;
        }
        C3404f.m4211H0(coroutineScope, null, null, new C79331(null), 3, null);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        C12238m.checkNotNullParameter(view, "view");
        clearPlayerAndSubscriptions();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View changedView, int visibility) {
        C12238m.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == 0) {
            resetCurrentEmbed();
        } else {
            clearPlayerAndSubscriptions();
        }
    }

    public final void updateUIWithAttachment(MessageAttachment attachment, Integer targetWidth, Integer targetHeight, boolean autoPlayGifs) {
        EmbedType embedType;
        C12238m.checkNotNullParameter(attachment, "attachment");
        MessageAttachmentType messageAttachmentTypeM8068e = attachment.m8068e();
        if ((messageAttachmentTypeM8068e == MessageAttachmentType.IMAGE || messageAttachmentTypeM8068e == MessageAttachmentType.VIDEO) && this.storeUserSettings.getIsAttachmentMediaInline()) {
            RenderableEmbedMedia renderableEmbedMediaCreateRenderableEmbedMediaFromAttachment = EmbedResourceUtils.INSTANCE.createRenderableEmbedMediaFromAttachment(attachment);
            this.featureTag = InlineMediaView.class.getSimpleName() + ": attachment";
            String proxyUrl = attachment.m8068e() == MessageAttachmentType.VIDEO ? attachment.getProxyUrl() : null;
            int iOrdinal = messageAttachmentTypeM8068e.ordinal();
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
        C12238m.checkNotNullParameter(embed, "embed");
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
        C12238m.checkNotNullParameter(context, "context");
        InlineMediaViewBinding inlineMediaViewBindingM8388a = InlineMediaViewBinding.m8388a(LayoutInflater.from(getContext()), this);
        C12238m.checkNotNullExpressionValue(inlineMediaViewBindingM8388a, "InlineMediaViewBinding.i…ater.from(context), this)");
        this.binding = inlineMediaViewBindingM8388a;
        this.storeUserSettings = StoreStream.INSTANCE.getUserSettings();
        this.featureTag = "";
        this.compositeSubscription = new CompositeSubscription();
        addOnAttachStateChangeListener(this);
        PublishSubject publishSubjectM11133k0 = PublishSubject.m11133k0();
        C12238m.checkNotNullExpressionValue(publishSubjectM11133k0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectM11133k0;
    }

    public /* synthetic */ InlineMediaView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InlineMediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C12238m.checkNotNullParameter(context, "context");
        InlineMediaViewBinding inlineMediaViewBindingM8388a = InlineMediaViewBinding.m8388a(LayoutInflater.from(getContext()), this);
        C12238m.checkNotNullExpressionValue(inlineMediaViewBindingM8388a, "InlineMediaViewBinding.i…ater.from(context), this)");
        this.binding = inlineMediaViewBindingM8388a;
        this.storeUserSettings = StoreStream.INSTANCE.getUserSettings();
        this.featureTag = "";
        this.compositeSubscription = new CompositeSubscription();
        addOnAttachStateChangeListener(this);
        PublishSubject publishSubjectM11133k0 = PublishSubject.m11133k0();
        C12238m.checkNotNullExpressionValue(publishSubjectM11133k0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectM11133k0;
    }

    public /* synthetic */ InlineMediaView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
