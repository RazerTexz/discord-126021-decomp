package com.discord.widgets.chat.input.sticker;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.discord.C5419R;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppComponent;
import com.discord.databinding.StickerPickerStickerItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.rlottie.RLottieImageView;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.views.sticker.StickerView;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Job;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StickerAdapterViewHolders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerViewHolder extends MGRecyclerViewHolder<WidgetStickerAdapter, MGRecyclerDataPayload> {
    private final AppComponent appComponent;
    private final StickerPickerStickerItemBinding binding;
    private final BehaviorSubject<Boolean> recyclerScrollingWithinThresholdSubject;
    private Subscription scrollingSpeedSubscription;
    private final int type;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.StickerViewHolder$onConfigure$1 */
    /* JADX INFO: compiled from: StickerAdapterViewHolders.kt */
    public static final class C78981 extends AbstractC12240o implements Function1<Boolean, Unit> {
        public final /* synthetic */ MGRecyclerDataPayload $data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C78981(MGRecyclerDataPayload mGRecyclerDataPayload) {
            super(1);
            this.$data = mGRecyclerDataPayload;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            C12238m.checkNotNullExpressionValue(bool, "scrollingWithinThreshold");
            if (bool.booleanValue()) {
                StickerViewHolder.this.configureSticker(this.$data);
                Subscription subscription = StickerViewHolder.this.scrollingSpeedSubscription;
                if (subscription != null) {
                    subscription.unsubscribe();
                }
                StickerViewHolder.this.scrollingSpeedSubscription = null;
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.StickerViewHolder$onConfigure$2 */
    /* JADX INFO: compiled from: StickerAdapterViewHolders.kt */
    public static final class C78992 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C78992() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, "it");
            StickerViewHolder.this.scrollingSpeedSubscription = subscription;
        }
    }

    public /* synthetic */ StickerViewHolder(int i, WidgetStickerAdapter widgetStickerAdapter, BehaviorSubject behaviorSubject, AppComponent appComponent, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, widgetStickerAdapter, (i2 & 4) != 0 ? null : behaviorSubject, appComponent);
    }

    public static final /* synthetic */ WidgetStickerAdapter access$getAdapter$p(StickerViewHolder stickerViewHolder) {
        return (WidgetStickerAdapter) stickerViewHolder.adapter;
    }

    private final void configureSticker(final MGRecyclerDataPayload data) {
        Sticker sticker;
        StickerItem stickerItem = (StickerItem) (!(data instanceof StickerItem) ? null : data);
        if (stickerItem == null || (sticker = stickerItem.getSticker()) == null) {
            return;
        }
        this.binding.f15276b.m8616d(sticker, 0);
        StickerView stickerView = this.binding.f15276b;
        C12238m.checkNotNullExpressionValue(stickerView, "binding.stickerPickerSticker");
        stickerView.setAlpha(((StickerItem) data).getSendability() == StickerUtils.StickerSendability.SENDABLE ? 1.0f : 0.25f);
        this.binding.f15276b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.sticker.StickerViewHolder.configureSticker.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StickerViewHolder.access$getAdapter$p(StickerViewHolder.this).getOnStickerItemSelected().invoke(data);
                try {
                    StickerViewHolder.this.binding.f15276b.performHapticFeedback(3);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public final void cancelLoading() {
        StickerView stickerView = this.binding.f15276b;
        Job job = stickerView.apngLoadingJob;
        if (job != null) {
            C3404f.m4343t(job, null, 1, null);
        }
        stickerView.binding.f1178c.clearAnimation();
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
        return this.binding.f15276b.getCom.discord.utilities.analytics.Traits.Payment.Type.SUBSCRIPTION java.lang.String();
    }

    public final int getType() {
        return this.type;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerViewHolder(int i, WidgetStickerAdapter widgetStickerAdapter, BehaviorSubject<Boolean> behaviorSubject, AppComponent appComponent) {
        super(C5419R.layout.sticker_picker_sticker_item, widgetStickerAdapter);
        C12238m.checkNotNullParameter(widgetStickerAdapter, "adapter");
        C12238m.checkNotNullParameter(appComponent, "appComponent");
        this.type = i;
        this.recyclerScrollingWithinThresholdSubject = behaviorSubject;
        this.appComponent = appComponent;
        View view = this.itemView;
        StickerView stickerView = (StickerView) view.findViewById(C5419R.id.sticker_picker_sticker);
        if (stickerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.sticker_picker_sticker)));
        }
        StickerPickerStickerItemBinding stickerPickerStickerItemBinding = new StickerPickerStickerItemBinding((FrameLayout) view, stickerView);
        C12238m.checkNotNullExpressionValue(stickerPickerStickerItemBinding, "StickerPickerStickerItemBinding.bind(itemView)");
        this.binding = stickerPickerStickerItemBinding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, MGRecyclerDataPayload data) {
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (this.recyclerScrollingWithinThresholdSubject == null) {
            configureSticker(data);
            return;
        }
        StickerView stickerView = this.binding.f15276b;
        RLottieImageView rLottieImageView = stickerView.binding.f1178c;
        C12238m.checkNotNullExpressionValue(rLottieImageView, "binding.stickerViewLottie");
        rLottieImageView.setVisibility(8);
        SimpleDraweeView simpleDraweeView = stickerView.binding.f1177b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.stickerViewImageview");
        simpleDraweeView.setVisibility(8);
        stickerView.binding.f1177b.setImageDrawable(null);
        ImageView imageView = stickerView.binding.f1179d;
        C12238m.checkNotNullExpressionValue(imageView, "binding.stickerViewPlaceholder");
        imageView.setVisibility(0);
        Observable<Boolean> observableM11112r = this.recyclerScrollingWithinThresholdSubject.m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "recyclerScrollingWithinT…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11112r, this.appComponent, null, 2, null), (Class<?>) StickerViewHolder.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C78992()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C78981(data));
    }
}
