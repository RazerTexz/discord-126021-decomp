package com.discord.widgets.settings.premium;

import com.discord.stores.StoreGooglePlayPurchases;
import com.discord.stores.StoreGooglePlaySkuDetails;
import com.discord.stores.StoreSubscriptions;
import kotlin.jvm.functions.Function4;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ChoosePlanViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ChoosePlanViewModel$Companion$observeStores$1 extends C12236k implements Function4<StoreGooglePlaySkuDetails.State, StoreGooglePlayPurchases.State, StoreGooglePlayPurchases.QueryState, StoreSubscriptions.SubscriptionsState, ChoosePlanViewModel.StoreState> {
    public static final ChoosePlanViewModel$Companion$observeStores$1 INSTANCE = new ChoosePlanViewModel$Companion$observeStores$1();

    public ChoosePlanViewModel$Companion$observeStores$1() {
        super(4, ChoosePlanViewModel.StoreState.class, "<init>", "<init>(Lcom/discord/stores/StoreGooglePlaySkuDetails$State;Lcom/discord/stores/StoreGooglePlayPurchases$State;Lcom/discord/stores/StoreGooglePlayPurchases$QueryState;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public final ChoosePlanViewModel.StoreState invoke(StoreGooglePlaySkuDetails.State state, StoreGooglePlayPurchases.State state2, StoreGooglePlayPurchases.QueryState queryState, StoreSubscriptions.SubscriptionsState subscriptionsState) {
        C12238m.checkNotNullParameter(state, "p1");
        C12238m.checkNotNullParameter(state2, "p2");
        C12238m.checkNotNullParameter(queryState, "p3");
        C12238m.checkNotNullParameter(subscriptionsState, "p4");
        return new ChoosePlanViewModel.StoreState(state, state2, queryState, subscriptionsState);
    }
}
