package com.discord.stores;

import com.discord.app.AppLog;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifting$generateGiftCode$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Error $error;
    public final /* synthetic */ StoreGifting$generateGiftCode$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGifting$generateGiftCode$2$1(StoreGifting$generateGiftCode$2 storeGifting$generateGiftCode$2, Error error) {
        super(0);
        this.this$0 = storeGifting$generateGiftCode$2;
        this.$error = error;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        int iOrdinal = this.$error.getType().ordinal();
        if (iOrdinal == 3) {
            this.$error.setShowErrorToasts(false);
            StoreGifting$generateGiftCode$2 storeGifting$generateGiftCode$2 = this.this$0;
            StoreGifting.access$setGifts(storeGifting$generateGiftCode$2.this$0, storeGifting$generateGiftCode$2.$comboId, StoreGifting$GiftState$Invalid.INSTANCE);
        } else if (iOrdinal != 11) {
            Logger.e$default(AppLog.g, "Generate Gift Code Error", new Exception(String.valueOf(this.$error.getType())), null, 4, null);
            StoreGifting$generateGiftCode$2 storeGifting$generateGiftCode$3 = this.this$0;
            StoreGifting.access$setGifts(storeGifting$generateGiftCode$3.this$0, storeGifting$generateGiftCode$3.$comboId, StoreGifting$GiftState$LoadFailed.INSTANCE);
        } else {
            StoreGifting$generateGiftCode$2 storeGifting$generateGiftCode$4 = this.this$0;
            StoreGifting.access$setGifts(storeGifting$generateGiftCode$4.this$0, storeGifting$generateGiftCode$4.$comboId, StoreGifting$GiftState$LoadFailed.INSTANCE);
        }
        StoreGifting$generateGiftCode$2 storeGifting$generateGiftCode$5 = this.this$0;
        StoreGifting.access$setGifts(storeGifting$generateGiftCode$5.this$0, storeGifting$generateGiftCode$5.$comboId, StoreGifting$GiftState$LoadFailed.INSTANCE);
    }
}
