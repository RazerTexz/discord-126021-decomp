package com.discord.stores;

import com.discord.models.domain.ModelGift;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifting$acceptGift$1$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreGifting$acceptGift$1$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGifting$acceptGift$1$2$1(StoreGifting$acceptGift$1$2 storeGifting$acceptGift$1$2) {
        super(0);
        this.this$0 = storeGifting$acceptGift$1$2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGifting$acceptGift$1 storeGifting$acceptGift$1 = this.this$0.this$0;
        StoreGifting.access$setGifts(storeGifting$acceptGift$1.this$0, storeGifting$acceptGift$1.$gift.getCode(), new StoreGifting$GiftState$Resolved(ModelGift.copy$default(this.this$0.this$0.$gift, 0L, true, null, null, 0, null, 0, null, null, null, null, 2045, null)));
    }
}
