package com.discord.stores;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: StoreSearchData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreSearchData$init$1 extends k implements Function1<Subscription, Unit> {
    public StoreSearchData$init$1(StoreSearchData storeSearchData) {
        super(1, storeSearchData, StoreSearchData.class, "handleSubscription", "handleSubscription(Lrx/Subscription;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
        invoke2(subscription);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Subscription subscription) {
        StoreSearchData.access$handleSubscription((StoreSearchData) this.receiver, subscription);
    }
}
