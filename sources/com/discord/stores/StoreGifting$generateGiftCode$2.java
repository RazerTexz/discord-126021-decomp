package com.discord.stores;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifting$generateGiftCode$2 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ String $comboId;
    public final /* synthetic */ Function1 $onError;
    public final /* synthetic */ StoreGifting this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGifting$generateGiftCode$2(StoreGifting storeGifting, String str, Function1 function1) {
        super(1);
        this.this$0 = storeGifting;
        this.$comboId = str;
        this.$onError = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "error");
        this.this$0.getDispatcher().schedule(new StoreGifting$generateGiftCode$2$1(this, error));
        Function1 function1 = this.$onError;
        if (function1 != null) {
        }
    }
}
