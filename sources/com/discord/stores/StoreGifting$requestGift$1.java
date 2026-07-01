package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifting$requestGift$1 extends o implements Function0<Unit> {
    public final /* synthetic */ String $giftCode;
    public final /* synthetic */ StoreGifting this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGifting$requestGift$1(StoreGifting storeGifting, String str) {
        super(0);
        this.this$0 = storeGifting;
        this.$giftCode = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGifting.access$fetchGift(this.this$0, this.$giftCode);
    }
}
