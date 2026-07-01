package com.discord.widgets.chat.list;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.View$OnAttachStateChangeListener;
import android.view.ViewGroup$LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.cardview.widget.CardView;
import b.a.p.i;
import b.c.a.a0.d;
import b.i.a.f.e.o.f;
import com.discord.api.message.attachment.MessageAttachment;
import com.discord.api.message.attachment.MessageAttachmentType;
import com.discord.api.message.embed.EmbedType;
import com.discord.api.message.embed.EmbedVideo;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.app.AppComponent;
import com.discord.databinding.InlineMediaViewBinding;
import com.discord.embed.RenderableEmbedMedia;
import com.discord.player.AppMediaPlayer;
import com.discord.player.AppMediaPlayer$Event;
import com.discord.player.AppMediaPlayer$Event$a;
import com.discord.player.AppMediaPlayer$Event$e;
import com.discord.player.AppMediaPlayer$Event$f;
import com.discord.player.MediaSource;
import com.discord.player.MediaType;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.embed.EmbedResourceUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.views.ViewCoroutineScopeKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.exoplayer2.ui.PlayerView;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: InlineMediaView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InlineMediaView extends CardView implements View$OnAttachStateChangeListener, AppComponent {
    private AppMediaPlayer appMediaPlayer;
    private final InlineMediaViewBinding binding;
    private CompositeSubscription compositeSubscription;
    private String featureTag;
    private final StoreUserSettings storeUserSettings;
    private final Subject<Void, Void> unsubscribeSignal;
    private InlineMediaView$ViewParams viewParams;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InlineMediaView(Context context) {
        super(context);
        m.checkNotNullParameter(context, "context");
        InlineMediaViewBinding inlineMediaViewBindingA = InlineMediaViewBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(inlineMediaViewBindingA, "InlineMediaViewBinding.i…ater.from(context), this)");
        this.binding = inlineMediaViewBindingA;
        this.storeUserSettings = StoreStream.Companion.getUserSettings();
        this.featureTag = "";
        this.compositeSubscription = new CompositeSubscription();
        addOnAttachStateChangeListener(this);
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        m.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectK0;
    }

    public static final /* synthetic */ AppMediaPlayer access$getAppMediaPlayer$p(InlineMediaView inlineMediaView) {
        return inlineMediaView.appMediaPlayer;
    }

    public static final /* synthetic */ InlineMediaViewBinding access$getBinding$p(InlineMediaView inlineMediaView) {
        return inlineMediaView.binding;
    }

    public static final /* synthetic */ CompositeSubscription access$getCompositeSubscription$p(InlineMediaView inlineMediaView) {
        return inlineMediaView.compositeSubscription;
    }

    public static final /* synthetic */ void access$handlePlayerEvent(InlineMediaView inlineMediaView, AppMediaPlayer$Event appMediaPlayer$Event) {
        inlineMediaView.handlePlayerEvent(appMediaPlayer$Event);
    }

    public static final /* synthetic */ void access$setAppMediaPlayer$p(InlineMediaView inlineMediaView, AppMediaPlayer appMediaPlayer) {
        inlineMediaView.appMediaPlayer = appMediaPlayer;
    }

    public static final /* synthetic */ void access$setCompositeSubscription$p(InlineMediaView inlineMediaView, CompositeSubscription compositeSubscription) {
        inlineMediaView.compositeSubscription = compositeSubscription;
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
            InlineMediaView$ViewParams inlineMediaView$ViewParams = this.viewParams;
            targetWidth2 = inlineMediaView$ViewParams != null ? inlineMediaView$ViewParams.getTargetWidth() : null;
        }
        if (targetHeight != null) {
            targetHeight2 = targetHeight;
        } else {
            InlineMediaView$ViewParams inlineMediaView$ViewParams2 = this.viewParams;
            targetHeight2 = inlineMediaView$ViewParams2 != null ? inlineMediaView$ViewParams2.getTargetHeight() : null;
        }
        InlineMediaView$ViewParams inlineMediaView$ViewParams3 = new InlineMediaView$ViewParams(previewImage, progressiveMediaUri, embedType, targetWidth2, targetHeight2, autoPlayGifs);
        if (m.areEqual(inlineMediaView$ViewParams3, this.viewParams)) {
            return;
        }
        this.viewParams = inlineMediaView$ViewParams3;
        updateUI(previewImage, progressiveMediaUri, embedType, targetWidth, targetHeight, featureTag);
    }

    public static /* synthetic */ void diffViewParamsAndUpdateEmbed$default(InlineMediaView inlineMediaView, RenderableEmbedMedia renderableEmbedMedia, String str, EmbedType embedType, Integer num, Integer num2, String str2, boolean z2, int i, Object obj) {
        inlineMediaView.diffViewParamsAndUpdateEmbed(renderableEmbedMedia, str, embedType, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : num2, str2, z2);
    }

    private final void handlePlayerEvent(AppMediaPlayer$Event event) {
        boolean z2 = true;
        if (m.areEqual(event, AppMediaPlayer$Event$a.a)) {
            SimpleDraweeView simpleDraweeView = this.binding.c;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.inlineMediaImagePreview");
            simpleDraweeView.setVisibility(shouldAutoPlay() ^ true ? 0 : 8);
            ProgressBar progressBar = this.binding.d;
            m.checkNotNullExpressionValue(progressBar, "binding.inlineMediaLoadingIndicator");
            progressBar.setVisibility(8);
            return;
        }
        if (!m.areEqual(event, AppMediaPlayer$Event$f.a)) {
            if (m.areEqual(event, AppMediaPlayer$Event$e.a)) {
                resetCurrentEmbed();
                return;
            }
            return;
        }
        InlineMediaView$ViewParams inlineMediaView$ViewParams = this.viewParams;
        EmbedType embedType = inlineMediaView$ViewParams != null ? inlineMediaView$ViewParams.getEmbedType() : null;
        ImageView imageView = this.binding.g;
        m.checkNotNullExpressionValue(imageView, "binding.inlineMediaVolumeToggle");
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
        InlineMediaView$ViewParams inlineMediaView$ViewParams = this.viewParams;
        if (inlineMediaView$ViewParams != null) {
            updateUI(inlineMediaView$ViewParams.getPreviewImage(), inlineMediaView$ViewParams.getProgressiveMediaUri(), inlineMediaView$ViewParams.getEmbedType(), inlineMediaView$ViewParams.getTargetWidth(), inlineMediaView$ViewParams.getTargetHeight(), this.featureTag);
        }
    }

    private final void resetViews() {
        InlineMediaView$ViewParams inlineMediaView$ViewParams = this.viewParams;
        if (inlineMediaView$ViewParams != null) {
            SimpleDraweeView simpleDraweeView = this.binding.c;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.inlineMediaImagePreview");
            simpleDraweeView.setVisibility(0);
            ImageView imageView = this.binding.f2126b;
            m.checkNotNullExpressionValue(imageView, "binding.inlineMediaGifIndicator");
            imageView.setVisibility(shouldAutoPlay() ^ true ? 0 : 8);
            PlayerView playerView = this.binding.f;
            m.checkNotNullExpressionValue(playerView, "binding.inlineMediaPlayerView");
            playerView.setVisibility(8);
            ImageView imageView2 = this.binding.g;
            m.checkNotNullExpressionValue(imageView2, "binding.inlineMediaVolumeToggle");
            imageView2.setVisibility(8);
            ImageView imageView3 = this.binding.e;
            m.checkNotNullExpressionValue(imageView3, "binding.inlineMediaPlayButton");
            imageView3.setVisibility(inlineMediaView$ViewParams.getEmbedType() == EmbedType.VIDEO ? 0 : 8);
            ProgressBar progressBar = this.binding.d;
            m.checkNotNullExpressionValue(progressBar, "binding.inlineMediaLoadingIndicator");
            progressBar.setVisibility(8);
            ImageView imageView4 = this.binding.g;
            m.checkNotNullExpressionValue(imageView4, "binding.inlineMediaVolumeToggle");
            imageView4.setVisibility(8);
        }
    }

    private final boolean shouldAutoPlay() {
        RenderableEmbedMedia previewImage;
        EmbedResourceUtils embedResourceUtils = EmbedResourceUtils.INSTANCE;
        InlineMediaView$ViewParams inlineMediaView$ViewParams = this.viewParams;
        String str = null;
        EmbedType embedType = inlineMediaView$ViewParams != null ? inlineMediaView$ViewParams.getEmbedType() : null;
        InlineMediaView$ViewParams inlineMediaView$ViewParams2 = this.viewParams;
        if (inlineMediaView$ViewParams2 != null && (previewImage = inlineMediaView$ViewParams2.getPreviewImage()) != null) {
            str = previewImage.url;
        }
        if (!embedResourceUtils.isAnimated(embedType, str)) {
            return true;
        }
        InlineMediaView$ViewParams inlineMediaView$ViewParams3 = this.viewParams;
        return inlineMediaView$ViewParams3 != null ? inlineMediaView$ViewParams3.getAutoPlayGifs() : this.storeUserSettings.getIsAutoPlayGifsEnabled();
    }

    private final void updateUI(RenderableEmbedMedia previewImage, String progressiveMediaUri, EmbedType embedType, Integer targetWidth, Integer targetHeight, String featureTag) {
        resetViews();
        this.compositeSubscription.unsubscribe();
        if (targetWidth != null && targetHeight != null) {
            ViewGroup$LayoutParams layoutParams = getLayoutParams();
            if (layoutParams.width != targetWidth.intValue() || layoutParams.height != targetHeight.intValue()) {
                layoutParams.width = targetWidth.intValue();
                layoutParams.height = targetHeight.intValue();
                requestLayout();
            }
            if ((previewImage != null ? previewImage.url : null) != null) {
                SimpleDraweeView simpleDraweeView = this.binding.c;
                m.checkNotNullExpressionValue(simpleDraweeView, "binding.inlineMediaImagePreview");
                MGImages.setImage$default(simpleDraweeView, EmbedResourceUtils.INSTANCE.getPreviewUrls(previewImage.url, targetWidth.intValue(), targetHeight.intValue(), shouldAutoPlay()), 0, 0, false, null, null, null, 252, null);
            }
        }
        if (progressiveMediaUri == null) {
            return;
        }
        AppMediaPlayer appMediaPlayerA = this.appMediaPlayer;
        if (appMediaPlayerA == null) {
            Context context = getContext();
            m.checkNotNullExpressionValue(context, "context");
            appMediaPlayerA = i.a(context);
        }
        this.appMediaPlayer = appMediaPlayerA;
        PlayerView playerView = this.binding.f;
        m.checkNotNullExpressionValue(playerView, "binding.inlineMediaPlayerView");
        playerView.setVisibility(shouldAutoPlay() ? 0 : 8);
        ImageView imageView = this.binding.f2126b;
        m.checkNotNullExpressionValue(imageView, "binding.inlineMediaGifIndicator");
        imageView.setVisibility(shouldAutoPlay() ^ true ? 0 : 8);
        m.checkNotNullParameter(progressiveMediaUri, "progressiveMediaUri");
        m.checkNotNullParameter(featureTag, "featureTag");
        EmbedType embedType2 = EmbedType.GIFV;
        MediaSource mediaSourceP = d.P(embedType == embedType2 ? MediaType.GIFV : MediaType.VIDEO, progressiveMediaUri, featureTag);
        this.compositeSubscription = new CompositeSubscription();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(appMediaPlayerA.volumeSubject, this, null, 2, null), InlineMediaView.class, (Context) null, new InlineMediaView$updateUI$1(this), (Function1) null, (Function0) null, (Function0) null, new InlineMediaView$updateUI$2(this, appMediaPlayerA), 58, (Object) null);
        Observable<AppMediaPlayer$Event> observableK = appMediaPlayerA.eventSubject.K();
        m.checkNotNullExpressionValue(observableK, "eventSubject.onBackpressureBuffer()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableK, this, null, 2, null), InlineMediaView.class, (Context) null, new InlineMediaView$updateUI$3(this), (Function1) null, (Function0) null, (Function0) null, new InlineMediaView$updateUI$4(this), 58, (Object) null);
        if (embedType == embedType2) {
            boolean zShouldAutoPlay = shouldAutoPlay();
            PlayerView playerView2 = this.binding.f;
            m.checkNotNullExpressionValue(playerView2, "binding.inlineMediaPlayerView");
            AppMediaPlayer.b(appMediaPlayerA, mediaSourceP, zShouldAutoPlay, true, 0L, playerView2, null, 40);
            appMediaPlayerA.d(0.0f);
        } else {
            appMediaPlayerA.d(1.0f);
        }
        this.binding.e.setOnClickListener(new InlineMediaView$updateUI$5(this, mediaSourceP));
    }

    public static /* synthetic */ void updateUI$default(InlineMediaView inlineMediaView, RenderableEmbedMedia renderableEmbedMedia, String str, EmbedType embedType, Integer num, Integer num2, String str2, int i, Object obj) {
        inlineMediaView.updateUI(renderableEmbedMedia, str, embedType, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : num2, str2);
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

    @Override // android.view.View$OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        CoroutineScope coroutineScope;
        m.checkNotNullParameter(view, "view");
        resetCurrentEmbed();
        PlayerView playerView = this.binding.f;
        m.checkNotNullExpressionValue(playerView, "binding.inlineMediaPlayerView");
        if (!(playerView.getVideoSurfaceView() instanceof SurfaceView) || (coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(this)) == null) {
            return;
        }
        f.H0(coroutineScope, null, null, new InlineMediaView$onViewAttachedToWindow$1(this, null), 3, null);
    }

    @Override // android.view.View$OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        m.checkNotNullParameter(view, "view");
        clearPlayerAndSubscriptions();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View changedView, int visibility) {
        m.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == 0) {
            resetCurrentEmbed();
        } else {
            clearPlayerAndSubscriptions();
        }
    }

    public final void updateUIWithAttachment(MessageAttachment attachment, Integer targetWidth, Integer targetHeight, boolean autoPlayGifs) {
        EmbedType embedType;
        m.checkNotNullParameter(attachment, "attachment");
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
        m.checkNotNullParameter(embed, "embed");
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
        m.checkNotNullParameter(context, "context");
        InlineMediaViewBinding inlineMediaViewBindingA = InlineMediaViewBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(inlineMediaViewBindingA, "InlineMediaViewBinding.i…ater.from(context), this)");
        this.binding = inlineMediaViewBindingA;
        this.storeUserSettings = StoreStream.Companion.getUserSettings();
        this.featureTag = "";
        this.compositeSubscription = new CompositeSubscription();
        addOnAttachStateChangeListener(this);
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        m.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectK0;
    }

    public /* synthetic */ InlineMediaView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InlineMediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
        InlineMediaViewBinding inlineMediaViewBindingA = InlineMediaViewBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(inlineMediaViewBindingA, "InlineMediaViewBinding.i…ater.from(context), this)");
        this.binding = inlineMediaViewBindingA;
        this.storeUserSettings = StoreStream.Companion.getUserSettings();
        this.featureTag = "";
        this.compositeSubscription = new CompositeSubscription();
        addOnAttachStateChangeListener(this);
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        m.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.unsubscribeSignal = publishSubjectK0;
    }

    public /* synthetic */ InlineMediaView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
