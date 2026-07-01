package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGooglePlayPurchases$downgradePurchase$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreGooglePlayPurchases this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGooglePlayPurchases$downgradePurchase$1(StoreGooglePlayPurchases storeGooglePlayPurchases) {
        super(0);
        this.this$0 = storeGooglePlayPurchases;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGooglePlayPurchases$State storeGooglePlayPurchases$StateAccess$getStoreState$p = StoreGooglePlayPurchases.access$getStoreState$p(this.this$0);
        if (storeGooglePlayPurchases$StateAccess$getStoreState$p instanceof StoreGooglePlayPurchases$State$Loaded) {
            StoreGooglePlayPurchases$State$Loaded storeGooglePlayPurchases$State$Loaded = (StoreGooglePlayPurchases$State$Loaded) storeGooglePlayPurchases$StateAccess$getStoreState$p;
            if (storeGooglePlayPurchases$State$Loaded.getPendingDowngrade() != null) {
                StoreGooglePlayPurchases.access$setQueryState$p(this.this$0, StoreGooglePlayPurchases$QueryState$InProgress.INSTANCE);
                this.this$0.markChanged();
                StoreGooglePlayPurchases.access$doDowngrade(this.this$0, storeGooglePlayPurchases$State$Loaded.getPendingDowngrade());
            }
        }
    }
}
