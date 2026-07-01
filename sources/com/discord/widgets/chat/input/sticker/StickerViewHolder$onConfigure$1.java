package com.discord.widgets.chat.input.sticker;

import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: StickerAdapterViewHolders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerViewHolder$onConfigure$1 extends o implements Function1<Boolean, Unit> {
    public final /* synthetic */ MGRecyclerDataPayload $data;
    public final /* synthetic */ StickerViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerViewHolder$onConfigure$1(StickerViewHolder stickerViewHolder, MGRecyclerDataPayload mGRecyclerDataPayload) {
        super(1);
        this.this$0 = stickerViewHolder;
        this.$data = mGRecyclerDataPayload;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke2(bool);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean bool) {
        m.checkNotNullExpressionValue(bool, "scrollingWithinThreshold");
        if (bool.booleanValue()) {
            StickerViewHolder.access$configureSticker(this.this$0, this.$data);
            Subscription subscriptionAccess$getScrollingSpeedSubscription$p = StickerViewHolder.access$getScrollingSpeedSubscription$p(this.this$0);
            if (subscriptionAccess$getScrollingSpeedSubscription$p != null) {
                subscriptionAccess$getScrollingSpeedSubscription$p.unsubscribe();
            }
            StickerViewHolder.access$setScrollingSpeedSubscription$p(this.this$0, null);
        }
    }
}
