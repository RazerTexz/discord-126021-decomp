package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSubscriptions$observeSubscriptions$1 extends o implements Function0<StoreSubscriptions$SubscriptionsState> {
    public final /* synthetic */ StoreSubscriptions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreSubscriptions$observeSubscriptions$1(StoreSubscriptions storeSubscriptions) {
        super(0);
        this.this$0 = storeSubscriptions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreSubscriptions$SubscriptionsState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreSubscriptions$SubscriptionsState invoke() {
        return this.this$0.getSubscriptionsStateSnapshot();
    }
}
