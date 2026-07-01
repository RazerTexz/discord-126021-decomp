package com.discord.stores;

import com.discord.models.domain.ModelGift;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifting$fetchGift$1 extends o implements Function1<ModelGift, Unit> {
    public final /* synthetic */ String $giftCode;
    public final /* synthetic */ StoreGifting this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGifting$fetchGift$1(StoreGifting storeGifting, String str) {
        super(1);
        this.this$0 = storeGifting;
        this.$giftCode = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelGift modelGift) {
        invoke2(modelGift);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelGift modelGift) {
        m.checkNotNullParameter(modelGift, "gift");
        this.this$0.getDispatcher().schedule(new StoreGifting$fetchGift$1$1(this, modelGift));
    }
}
