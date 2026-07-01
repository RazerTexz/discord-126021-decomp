package com.discord.stores;

import com.discord.models.domain.ModelGift;
import com.discord.restapi.RestAPIAbortCodes;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import com.discord.utilities.error.Error$Type;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifting$acceptGift$1$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Error $error;
    public final /* synthetic */ StoreGifting$acceptGift$1$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGifting$acceptGift$1$1$1(StoreGifting$acceptGift$1$1 storeGifting$acceptGift$1$1, Error error) {
        super(0);
        this.this$0 = storeGifting$acceptGift$1$1;
        this.$error = error;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$error.getType() != Error$Type.DISCORD_BAD_REQUEST) {
            StoreGifting$acceptGift$1 storeGifting$acceptGift$1 = this.this$0.this$0;
            StoreGifting.access$setGifts(storeGifting$acceptGift$1.this$0, storeGifting$acceptGift$1.$gift.getCode(), new StoreGifting$GiftState$RedeemedFailed(this.this$0.this$0.$gift, true, null));
        }
        this.$error.setShowErrorToasts(false);
        Error$Response response = this.$error.getResponse();
        m.checkNotNullExpressionValue(response, "error.response");
        switch (response.getCode()) {
            case RestAPIAbortCodes.GIFTING_ALREADY_USED_ERROR_CODE /* 50050 */:
                StoreGifting$acceptGift$1 storeGifting$acceptGift$2 = this.this$0.this$0;
                StoreGifting storeGifting = storeGifting$acceptGift$2.this$0;
                String code = storeGifting$acceptGift$2.$gift.getCode();
                ModelGift modelGift = this.this$0.this$0.$gift;
                StoreGifting.access$setGifts(storeGifting, code, new StoreGifting$GiftState$Resolved(ModelGift.copy$default(modelGift, 0L, false, null, null, modelGift.getMaxUses(), null, 0, null, null, null, null, 2031, null)));
                break;
            case RestAPIAbortCodes.GIFTING_ALREADY_OWNED_ERROR_CODE /* 50051 */:
                StoreGifting$acceptGift$1 storeGifting$acceptGift$3 = this.this$0.this$0;
                StoreGifting.access$setGifts(storeGifting$acceptGift$3.this$0, storeGifting$acceptGift$3.$gift.getCode(), new StoreGifting$GiftState$Resolved(ModelGift.copy$default(this.this$0.this$0.$gift, 0L, true, null, null, 0, null, 0, null, null, null, null, 2045, null)));
                break;
            default:
                StoreGifting$acceptGift$1 storeGifting$acceptGift$4 = this.this$0.this$0;
                StoreGifting storeGifting2 = storeGifting$acceptGift$4.this$0;
                String code2 = storeGifting$acceptGift$4.$gift.getCode();
                ModelGift modelGift2 = this.this$0.this$0.$gift;
                Error$Response response2 = this.$error.getResponse();
                m.checkNotNullExpressionValue(response2, "error.response");
                StoreGifting.access$setGifts(storeGifting2, code2, new StoreGifting$GiftState$RedeemedFailed(modelGift2, false, Integer.valueOf(response2.getCode())));
                break;
        }
    }
}
