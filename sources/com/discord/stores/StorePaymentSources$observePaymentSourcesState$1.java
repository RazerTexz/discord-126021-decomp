package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StorePaymentSources.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StorePaymentSources$observePaymentSourcesState$1 extends o implements Function0<StorePaymentSources$PaymentSourcesState> {
    public final /* synthetic */ StorePaymentSources this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorePaymentSources$observePaymentSourcesState$1(StorePaymentSources storePaymentSources) {
        super(0);
        this.this$0 = storePaymentSources;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StorePaymentSources$PaymentSourcesState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StorePaymentSources$PaymentSourcesState invoke() {
        return this.this$0.getPaymentSourcesStateSnapshot();
    }
}
