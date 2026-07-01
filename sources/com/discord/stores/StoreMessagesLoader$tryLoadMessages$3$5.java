package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: StoreMessagesLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessagesLoader$tryLoadMessages$3$5 extends o implements Function1<Subscription, Unit> {
    public final /* synthetic */ StoreMessagesLoader$tryLoadMessages$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessagesLoader$tryLoadMessages$3$5(StoreMessagesLoader$tryLoadMessages$3 storeMessagesLoader$tryLoadMessages$3) {
        super(1);
        this.this$0 = storeMessagesLoader$tryLoadMessages$3;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
        invoke2(subscription);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Subscription subscription) {
        m.checkNotNullParameter(subscription, "it");
        StoreMessagesLoader.access$setLoadingMessagesSubscription$p(this.this$0.this$0, subscription);
    }
}
