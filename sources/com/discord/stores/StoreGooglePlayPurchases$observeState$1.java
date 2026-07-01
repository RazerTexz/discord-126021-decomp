package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGooglePlayPurchases$observeState$1 extends o implements Function0<StoreGooglePlayPurchases$State> {
    public final /* synthetic */ StoreGooglePlayPurchases this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGooglePlayPurchases$observeState$1(StoreGooglePlayPurchases storeGooglePlayPurchases) {
        super(0);
        this.this$0 = storeGooglePlayPurchases;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreGooglePlayPurchases$State invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreGooglePlayPurchases$State invoke() {
        return this.this$0.getStoreStateSnapshot();
    }
}
