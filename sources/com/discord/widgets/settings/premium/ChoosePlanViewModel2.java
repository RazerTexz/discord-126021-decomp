package com.discord.widgets.settings.premium;

import com.discord.stores.StoreGooglePlayPurchases;
import com.discord.stores.StoreGooglePlaySkuDetails;
import com.discord.stores.StoreSubscriptions;
import com.discord.widgets.settings.premium.ChoosePlanViewModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function4;

/* JADX INFO: renamed from: com.discord.widgets.settings.premium.ChoosePlanViewModel$Companion$observeStores$1, reason: use source file name */
/* JADX INFO: compiled from: ChoosePlanViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ChoosePlanViewModel2 extends FunctionReferenceImpl implements Function4<StoreGooglePlaySkuDetails.State, StoreGooglePlayPurchases.State, StoreGooglePlayPurchases.QueryState, StoreSubscriptions.SubscriptionsState, ChoosePlanViewModel.StoreState> {
    public static final ChoosePlanViewModel2 INSTANCE = new ChoosePlanViewModel2();

    public ChoosePlanViewModel2() {
        super(4, ChoosePlanViewModel.StoreState.class, "<init>", "<init>(Lcom/discord/stores/StoreGooglePlaySkuDetails$State;Lcom/discord/stores/StoreGooglePlayPurchases$State;Lcom/discord/stores/StoreGooglePlayPurchases$QueryState;Lcom/discord/stores/StoreSubscriptions$SubscriptionsState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public final ChoosePlanViewModel.StoreState invoke(StoreGooglePlaySkuDetails.State state, StoreGooglePlayPurchases.State state2, StoreGooglePlayPurchases.QueryState queryState, StoreSubscriptions.SubscriptionsState subscriptionsState) {
        Intrinsics3.checkNotNullParameter(state, "p1");
        Intrinsics3.checkNotNullParameter(state2, "p2");
        Intrinsics3.checkNotNullParameter(queryState, "p3");
        Intrinsics3.checkNotNullParameter(subscriptionsState, "p4");
        return new ChoosePlanViewModel.StoreState(state, state2, queryState, subscriptionsState);
    }
}
