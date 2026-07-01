package com.discord.widgets.settings.premium;

import com.discord.stores.StoreGooglePlayPurchases$QueryState;
import com.discord.stores.StoreGooglePlayPurchases$State;
import com.discord.stores.StoreGooglePlaySkuDetails$State;
import com.discord.stores.StoreSubscriptions$SubscriptionsState;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: ChoosePlanViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ChoosePlanViewModel$Companion$observeStores$1 extends k implements Function4<StoreGooglePlaySkuDetails$State, StoreGooglePlayPurchases$State, StoreGooglePlayPurchases$QueryState, StoreSubscriptions$SubscriptionsState, ChoosePlanViewModel$StoreState> {
    public static final ChoosePlanViewModel$Companion$observeStores$1 INSTANCE = new ChoosePlanViewModel$Companion$observeStores$1();

    public ChoosePlanViewModel$Companion$observeStores$1() {
        super(4, ChoosePlanViewModel$StoreState.class, "<init>", "<init>(Lcom/discord/stores/StoreGooglePlaySkuDetails$State;Lcom/discord/stores/StoreGooglePlayPurchases$State;Lcom/discord/stores/StoreGooglePlayPurchases$QueryState;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ ChoosePlanViewModel$StoreState invoke(StoreGooglePlaySkuDetails$State storeGooglePlaySkuDetails$State, StoreGooglePlayPurchases$State storeGooglePlayPurchases$State, StoreGooglePlayPurchases$QueryState storeGooglePlayPurchases$QueryState, StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState) {
        return invoke2(storeGooglePlaySkuDetails$State, storeGooglePlayPurchases$State, storeGooglePlayPurchases$QueryState, storeSubscriptions$SubscriptionsState);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ChoosePlanViewModel$StoreState invoke2(StoreGooglePlaySkuDetails$State storeGooglePlaySkuDetails$State, StoreGooglePlayPurchases$State storeGooglePlayPurchases$State, StoreGooglePlayPurchases$QueryState storeGooglePlayPurchases$QueryState, StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState) {
        m.checkNotNullParameter(storeGooglePlaySkuDetails$State, "p1");
        m.checkNotNullParameter(storeGooglePlayPurchases$State, "p2");
        m.checkNotNullParameter(storeGooglePlayPurchases$QueryState, "p3");
        m.checkNotNullParameter(storeSubscriptions$SubscriptionsState, "p4");
        return new ChoosePlanViewModel$StoreState(storeGooglePlaySkuDetails$State, storeGooglePlayPurchases$State, storeGooglePlayPurchases$QueryState, storeSubscriptions$SubscriptionsState);
    }
}
