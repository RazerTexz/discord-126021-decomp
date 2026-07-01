package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGooglePlayPurchases$observeQueryState$1 extends o implements Function0<StoreGooglePlayPurchases$QueryState> {
    public final /* synthetic */ StoreGooglePlayPurchases this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGooglePlayPurchases$observeQueryState$1(StoreGooglePlayPurchases storeGooglePlayPurchases) {
        super(0);
        this.this$0 = storeGooglePlayPurchases;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreGooglePlayPurchases$QueryState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreGooglePlayPurchases$QueryState invoke() {
        return this.this$0.getQueryStateSnapshot();
    }
}
