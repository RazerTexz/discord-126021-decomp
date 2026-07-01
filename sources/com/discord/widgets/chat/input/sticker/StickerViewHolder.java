package com.discord.widgets.chat.input.sticker;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import b.i.a.f.e.o.f;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppComponent;
import com.discord.databinding.StickerPickerStickerItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.rlottie.RLottieImageView;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils$StickerSendability;
import com.discord.views.sticker.StickerView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Job;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StickerAdapterViewHolders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerViewHolder extends MGRecyclerViewHolder<WidgetStickerAdapter, MGRecyclerDataPayload> {
    private final AppComponent appComponent;
    private final StickerPickerStickerItemBinding binding;
    private final BehaviorSubject<Boolean> recyclerScrollingWithinThresholdSubject;
    private Subscription scrollingSpeedSubscription;
    private final int type;

    public /* synthetic */ StickerViewHolder(int i, WidgetStickerAdapter widgetStickerAdapter, BehaviorSubject behaviorSubject, AppComponent appComponent, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, widgetStickerAdapter, (i2 & 4) != 0 ? null : behaviorSubject, appComponent);
    }

    public static final /* synthetic */ void access$configureSticker(StickerViewHolder stickerViewHolder, MGRecyclerDataPayload mGRecyclerDataPayload) {
        stickerViewHolder.configureSticker(mGRecyclerDataPayload);
    }

    public static final /* synthetic */ WidgetStickerAdapter access$getAdapter$p(StickerViewHolder stickerViewHolder) {
        return (WidgetStickerAdapter) stickerViewHolder.adapter;
    }

    public static final /* synthetic */ StickerPickerStickerItemBinding access$getBinding$p(StickerViewHolder stickerViewHolder) {
        return stickerViewHolder.binding;
    }

    public static final /* synthetic */ Subscription access$getScrollingSpeedSubscription$p(StickerViewHolder stickerViewHolder) {
        return stickerViewHolder.scrollingSpeedSubscription;
    }

    public static final /* synthetic */ void access$setScrollingSpeedSubscription$p(StickerViewHolder stickerViewHolder, Subscription subscription) {
        stickerViewHolder.scrollingSpeedSubscription = subscription;
    }

    private final void configureSticker(MGRecyclerDataPayload data) {
        Sticker sticker;
        StickerItem stickerItem = (StickerItem) (!(data instanceof StickerItem) ? null : data);
        if (stickerItem == null || (sticker = stickerItem.getSticker()) == null) {
            return;
        }
        this.binding.f2153b.d(sticker, 0);
        StickerView stickerView = this.binding.f2153b;
        m.checkNotNullExpressionValue(stickerView, "binding.stickerPickerSticker");
        stickerView.setAlpha(((StickerItem) data).getSendability() == StickerUtils$StickerSendability.SENDABLE ? 1.0f : 0.25f);
        this.binding.f2153b.setOnClickListener(new StickerViewHolder$configureSticker$1(this, data));
    }

    public final void cancelLoading() {
        StickerView stickerView = this.binding.f2153b;
        Job job = stickerView.apngLoadingJob;
        if (job != null) {
            f.t(job, null, 1, null);
        }
        stickerView.binding.c.clearAnimation();
        Subscription subscription = this.scrollingSpeedSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.scrollingSpeedSubscription = null;
    }

    public final AppComponent getAppComponent() {
        return this.appComponent;
    }

    public final BehaviorSubject<Boolean> getRecyclerScrollingWithinThresholdSubject() {
        return this.recyclerScrollingWithinThresholdSubject;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.binding.f2153b.getCom.discord.utilities.analytics.Traits$Payment$Type.SUBSCRIPTION java.lang.String();
    }

    public final int getType() {
        return this.type;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerViewHolder(int i, WidgetStickerAdapter widgetStickerAdapter, BehaviorSubject<Boolean> behaviorSubject, AppComponent appComponent) {
        super(R$layout.sticker_picker_sticker_item, widgetStickerAdapter);
        m.checkNotNullParameter(widgetStickerAdapter, "adapter");
        m.checkNotNullParameter(appComponent, "appComponent");
        this.type = i;
        this.recyclerScrollingWithinThresholdSubject = behaviorSubject;
        this.appComponent = appComponent;
        View view = this.itemView;
        StickerView stickerView = (StickerView) view.findViewById(R$id.sticker_picker_sticker);
        if (stickerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R$id.sticker_picker_sticker)));
        }
        StickerPickerStickerItemBinding stickerPickerStickerItemBinding = new StickerPickerStickerItemBinding((FrameLayout) view, stickerView);
        m.checkNotNullExpressionValue(stickerPickerStickerItemBinding, "StickerPickerStickerItemBinding.bind(itemView)");
        this.binding = stickerPickerStickerItemBinding;
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (this.recyclerScrollingWithinThresholdSubject == null) {
            configureSticker(data);
            return;
        }
        StickerView stickerView = this.binding.f2153b;
        RLottieImageView rLottieImageView = stickerView.binding.c;
        m.checkNotNullExpressionValue(rLottieImageView, "binding.stickerViewLottie");
        rLottieImageView.setVisibility(8);
        SimpleDraweeView simpleDraweeView = stickerView.binding.f191b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.stickerViewImageview");
        simpleDraweeView.setVisibility(8);
        stickerView.binding.f191b.setImageDrawable(null);
        ImageView imageView = stickerView.binding.d;
        m.checkNotNullExpressionValue(imageView, "binding.stickerViewPlaceholder");
        imageView.setVisibility(0);
        Observable<Boolean> observableR = this.recyclerScrollingWithinThresholdSubject.r();
        m.checkNotNullExpressionValue(observableR, "recyclerScrollingWithinT…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR, this.appComponent, null, 2, null), StickerViewHolder.class, (Context) null, new StickerViewHolder$onConfigure$2(this), (Function1) null, (Function0) null, (Function0) null, new StickerViewHolder$onConfigure$1(this, data), 58, (Object) null);
    }
}
