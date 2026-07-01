package com.discord.stores;

import com.discord.models.domain.ModelGift;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifting$generateGiftCode$3$1 extends o implements Function0<Unit> {
    public final /* synthetic */ ModelGift $newGift;
    public final /* synthetic */ StoreGifting$generateGiftCode$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGifting$generateGiftCode$3$1(StoreGifting$generateGiftCode$3 storeGifting$generateGiftCode$3, ModelGift modelGift) {
        super(0);
        this.this$0 = storeGifting$generateGiftCode$3;
        this.$newGift = modelGift;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGifting$generateGiftCode$3 storeGifting$generateGiftCode$3 = this.this$0;
        StoreGifting.access$removeGiftCode(storeGifting$generateGiftCode$3.this$0, storeGifting$generateGiftCode$3.$comboId);
        StoreGifting.access$setGifts(this.this$0.this$0, this.$newGift.getCode(), new StoreGifting$GiftState$Resolved(this.$newGift));
    }
}
