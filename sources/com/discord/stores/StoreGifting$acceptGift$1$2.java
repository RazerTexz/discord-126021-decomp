package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifting$acceptGift$1$2 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ StoreGifting$acceptGift$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGifting$acceptGift$1$2(StoreGifting$acceptGift$1 storeGifting$acceptGift$1) {
        super(1);
        this.this$0 = storeGifting$acceptGift$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r2) {
        this.this$0.this$0.getDispatcher().schedule(new StoreGifting$acceptGift$1$2$1(this));
        StoreStream.Companion.getLibrary().fetchApplications();
    }
}
