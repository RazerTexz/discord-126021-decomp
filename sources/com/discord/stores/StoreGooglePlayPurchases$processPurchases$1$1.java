package com.discord.stores;

import com.discord.utilities.billing.BillingUtils;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGooglePlayPurchases$processPurchases$1$1 extends o implements Function1<StoreGooglePlayPurchases$QueryState, Unit> {
    public final /* synthetic */ StoreGooglePlayPurchases$processPurchases$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGooglePlayPurchases$processPurchases$1$1(StoreGooglePlayPurchases$processPurchases$1 storeGooglePlayPurchases$processPurchases$1) {
        super(1);
        this.this$0 = storeGooglePlayPurchases$processPurchases$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreGooglePlayPurchases$QueryState storeGooglePlayPurchases$QueryState) {
        invoke2(storeGooglePlayPurchases$QueryState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreGooglePlayPurchases$QueryState storeGooglePlayPurchases$QueryState) {
        if (storeGooglePlayPurchases$QueryState instanceof StoreGooglePlayPurchases$QueryState$NotInProgress) {
            BillingUtils.INSTANCE.verifyPurchases(this.this$0.$purchases);
        }
    }
}
