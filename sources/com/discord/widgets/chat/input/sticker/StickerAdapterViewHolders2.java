package com.discord.widgets.chat.input.sticker;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import b.i.a.f.e.o.f;
import com.discord.R;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppComponent;
import com.discord.databinding.StickerPickerStickerItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.rlottie.RLottieImageView;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.views.sticker.StickerView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Job;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.StickerViewHolder, reason: use source file name */
/* JADX INFO: compiled from: StickerAdapterViewHolders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerAdapterViewHolders2 extends MGRecyclerViewHolder<WidgetStickerAdapter, MGRecyclerDataPayload> {
    private final AppComponent appComponent;
    private final StickerPickerStickerItemBinding binding;
    private final BehaviorSubject<Boolean> recyclerScrollingWithinThresholdSubject;
    private Subscription scrollingSpeedSubscription;
    private final int type;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.StickerViewHolder$onConfigure$1, reason: invalid class name */
    /* JADX INFO: compiled from: StickerAdapterViewHolders.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ MGRecyclerDataPayload $data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MGRecyclerDataPayload mGRecyclerDataPayload) {
            super(1);
            this.$data = mGRecyclerDataPayload;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            Intrinsics3.checkNotNullExpressionValue(bool, "scrollingWithinThreshold");
            if (bool.booleanValue()) {
                StickerAdapterViewHolders2.this.configureSticker(this.$data);
                Subscription subscription = StickerAdapterViewHolders2.this.scrollingSpeedSubscription;
                if (subscription != null) {
                    subscription.unsubscribe();
                }
                StickerAdapterViewHolders2.this.scrollingSpeedSubscription = null;
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.StickerViewHolder$onConfigure$2, reason: invalid class name */
    /* JADX INFO: compiled from: StickerAdapterViewHolders.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            StickerAdapterViewHolders2.this.scrollingSpeedSubscription = subscription;
        }
    }

    public /* synthetic */ StickerAdapterViewHolders2(int i, WidgetStickerAdapter widgetStickerAdapter, BehaviorSubject behaviorSubject, AppComponent appComponent, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, widgetStickerAdapter, (i2 & 4) != 0 ? null : behaviorSubject, appComponent);
    }

    public static final /* synthetic */ WidgetStickerAdapter access$getAdapter$p(StickerAdapterViewHolders2 stickerAdapterViewHolders2) {
        return (WidgetStickerAdapter) stickerAdapterViewHolders2.adapter;
    }

    private final void configureSticker(final MGRecyclerDataPayload data) {
        Sticker sticker;
        StickerAdapterItems3 stickerAdapterItems3 = (StickerAdapterItems3) (!(data instanceof StickerAdapterItems3) ? null : data);
        if (stickerAdapterItems3 == null || (sticker = stickerAdapterItems3.getSticker()) == null) {
            return;
        }
        this.binding.f2153b.d(sticker, 0);
        StickerView stickerView = this.binding.f2153b;
        Intrinsics3.checkNotNullExpressionValue(stickerView, "binding.stickerPickerSticker");
        stickerView.setAlpha(((StickerAdapterItems3) data).getSendability() == StickerUtils.StickerSendability.SENDABLE ? 1.0f : 0.25f);
        this.binding.f2153b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.sticker.StickerViewHolder.configureSticker.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StickerAdapterViewHolders2.access$getAdapter$p(StickerAdapterViewHolders2.this).getOnStickerItemSelected().invoke(data);
                try {
                    StickerAdapterViewHolders2.this.binding.f2153b.performHapticFeedback(3);
                } catch (Throwable unused) {
                }
            }
        });
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
        return this.binding.f2153b.getCom.discord.utilities.analytics.Traits.Payment.Type.SUBSCRIPTION java.lang.String();
    }

    public final int getType() {
        return this.type;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerAdapterViewHolders2(int i, WidgetStickerAdapter widgetStickerAdapter, BehaviorSubject<Boolean> behaviorSubject, AppComponent appComponent) {
        super(R.layout.sticker_picker_sticker_item, widgetStickerAdapter);
        Intrinsics3.checkNotNullParameter(widgetStickerAdapter, "adapter");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        this.type = i;
        this.recyclerScrollingWithinThresholdSubject = behaviorSubject;
        this.appComponent = appComponent;
        View view = this.itemView;
        StickerView stickerView = (StickerView) view.findViewById(R.id.sticker_picker_sticker);
        if (stickerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.sticker_picker_sticker)));
        }
        StickerPickerStickerItemBinding stickerPickerStickerItemBinding = new StickerPickerStickerItemBinding((FrameLayout) view, stickerView);
        Intrinsics3.checkNotNullExpressionValue(stickerPickerStickerItemBinding, "StickerPickerStickerItemBinding.bind(itemView)");
        this.binding = stickerPickerStickerItemBinding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, MGRecyclerDataPayload data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (this.recyclerScrollingWithinThresholdSubject == null) {
            configureSticker(data);
            return;
        }
        StickerView stickerView = this.binding.f2153b;
        RLottieImageView rLottieImageView = stickerView.binding.c;
        Intrinsics3.checkNotNullExpressionValue(rLottieImageView, "binding.stickerViewLottie");
        rLottieImageView.setVisibility(8);
        SimpleDraweeView simpleDraweeView = stickerView.binding.f191b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.stickerViewImageview");
        simpleDraweeView.setVisibility(8);
        stickerView.binding.f191b.setImageDrawable(null);
        ImageView imageView = stickerView.binding.d;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.stickerViewPlaceholder");
        imageView.setVisibility(0);
        Observable<Boolean> observableR = this.recyclerScrollingWithinThresholdSubject.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "recyclerScrollingWithinT…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableR, this.appComponent, null, 2, null), (Class<?>) StickerAdapterViewHolders2.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass2()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(data));
    }
}
