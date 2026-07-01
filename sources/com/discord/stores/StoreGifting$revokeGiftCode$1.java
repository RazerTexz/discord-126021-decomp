package com.discord.stores;

import com.discord.models.domain.ModelGift;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifting$revokeGiftCode$1 extends o implements Function0<Unit> {
    public final /* synthetic */ ModelGift $gift;
    public final /* synthetic */ StoreGifting this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGifting$revokeGiftCode$1(StoreGifting storeGifting, ModelGift modelGift) {
        super(0);
        this.this$0 = storeGifting;
        this.$gift = modelGift;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGifting.access$setGifts(this.this$0, this.$gift.getCode(), new StoreGifting$GiftState$Revoking(this.$gift));
    }
}
