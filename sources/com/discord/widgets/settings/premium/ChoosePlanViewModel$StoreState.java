package com.discord.widgets.settings.premium;

import b.d.b.a.a;
import com.discord.stores.StoreGooglePlayPurchases$QueryState;
import com.discord.stores.StoreGooglePlayPurchases$State;
import com.discord.stores.StoreGooglePlaySkuDetails$State;
import com.discord.stores.StoreSubscriptions$SubscriptionsState;
import d0.z.d.m;

/* JADX INFO: compiled from: ChoosePlanViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChoosePlanViewModel$StoreState {
    private final StoreGooglePlayPurchases$QueryState purchasesQueryState;
    private final StoreGooglePlayPurchases$State purchasesState;
    private final StoreGooglePlaySkuDetails$State skuDetailsState;
    private final StoreSubscriptions$SubscriptionsState subscriptionsState;

    public ChoosePlanViewModel$StoreState(StoreGooglePlaySkuDetails$State storeGooglePlaySkuDetails$State, StoreGooglePlayPurchases$State storeGooglePlayPurchases$State, StoreGooglePlayPurchases$QueryState storeGooglePlayPurchases$QueryState, StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState) {
        m.checkNotNullParameter(storeGooglePlaySkuDetails$State, "skuDetailsState");
        m.checkNotNullParameter(storeGooglePlayPurchases$State, "purchasesState");
        m.checkNotNullParameter(storeGooglePlayPurchases$QueryState, "purchasesQueryState");
        m.checkNotNullParameter(storeSubscriptions$SubscriptionsState, "subscriptionsState");
        this.skuDetailsState = storeGooglePlaySkuDetails$State;
        this.purchasesState = storeGooglePlayPurchases$State;
        this.purchasesQueryState = storeGooglePlayPurchases$QueryState;
        this.subscriptionsState = storeSubscriptions$SubscriptionsState;
    }

    public static /* synthetic */ ChoosePlanViewModel$StoreState copy$default(ChoosePlanViewModel$StoreState choosePlanViewModel$StoreState, StoreGooglePlaySkuDetails$State storeGooglePlaySkuDetails$State, StoreGooglePlayPurchases$State storeGooglePlayPurchases$State, StoreGooglePlayPurchases$QueryState storeGooglePlayPurchases$QueryState, StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState, int i, Object obj) {
        if ((i & 1) != 0) {
            storeGooglePlaySkuDetails$State = choosePlanViewModel$StoreState.skuDetailsState;
        }
        if ((i & 2) != 0) {
            storeGooglePlayPurchases$State = choosePlanViewModel$StoreState.purchasesState;
        }
        if ((i & 4) != 0) {
            storeGooglePlayPurchases$QueryState = choosePlanViewModel$StoreState.purchasesQueryState;
        }
        if ((i & 8) != 0) {
            storeSubscriptions$SubscriptionsState = choosePlanViewModel$StoreState.subscriptionsState;
        }
        return choosePlanViewModel$StoreState.copy(storeGooglePlaySkuDetails$State, storeGooglePlayPurchases$State, storeGooglePlayPurchases$QueryState, storeSubscriptions$SubscriptionsState);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreGooglePlaySkuDetails$State getSkuDetailsState() {
        return this.skuDetailsState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StoreGooglePlayPurchases$State getPurchasesState() {
        return this.purchasesState;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final StoreGooglePlayPurchases$QueryState getPurchasesQueryState() {
        return this.purchasesQueryState;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final StoreSubscriptions$SubscriptionsState getSubscriptionsState() {
        return this.subscriptionsState;
    }

    public final ChoosePlanViewModel$StoreState copy(StoreGooglePlaySkuDetails$State skuDetailsState, StoreGooglePlayPurchases$State purchasesState, StoreGooglePlayPurchases$QueryState purchasesQueryState, StoreSubscriptions$SubscriptionsState subscriptionsState) {
        m.checkNotNullParameter(skuDetailsState, "skuDetailsState");
        m.checkNotNullParameter(purchasesState, "purchasesState");
        m.checkNotNullParameter(purchasesQueryState, "purchasesQueryState");
        m.checkNotNullParameter(subscriptionsState, "subscriptionsState");
        return new ChoosePlanViewModel$StoreState(skuDetailsState, purchasesState, purchasesQueryState, subscriptionsState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChoosePlanViewModel$StoreState)) {
            return false;
        }
        ChoosePlanViewModel$StoreState choosePlanViewModel$StoreState = (ChoosePlanViewModel$StoreState) other;
        return m.areEqual(this.skuDetailsState, choosePlanViewModel$StoreState.skuDetailsState) && m.areEqual(this.purchasesState, choosePlanViewModel$StoreState.purchasesState) && m.areEqual(this.purchasesQueryState, choosePlanViewModel$StoreState.purchasesQueryState) && m.areEqual(this.subscriptionsState, choosePlanViewModel$StoreState.subscriptionsState);
    }

    public final StoreGooglePlayPurchases$QueryState getPurchasesQueryState() {
        return this.purchasesQueryState;
    }

    public final StoreGooglePlayPurchases$State getPurchasesState() {
        return this.purchasesState;
    }

    public final StoreGooglePlaySkuDetails$State getSkuDetailsState() {
        return this.skuDetailsState;
    }

    public final StoreSubscriptions$SubscriptionsState getSubscriptionsState() {
        return this.subscriptionsState;
    }

    public int hashCode() {
        StoreGooglePlaySkuDetails$State storeGooglePlaySkuDetails$State = this.skuDetailsState;
        int iHashCode = (storeGooglePlaySkuDetails$State != null ? storeGooglePlaySkuDetails$State.hashCode() : 0) * 31;
        StoreGooglePlayPurchases$State storeGooglePlayPurchases$State = this.purchasesState;
        int iHashCode2 = (iHashCode + (storeGooglePlayPurchases$State != null ? storeGooglePlayPurchases$State.hashCode() : 0)) * 31;
        StoreGooglePlayPurchases$QueryState storeGooglePlayPurchases$QueryState = this.purchasesQueryState;
        int iHashCode3 = (iHashCode2 + (storeGooglePlayPurchases$QueryState != null ? storeGooglePlayPurchases$QueryState.hashCode() : 0)) * 31;
        StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState = this.subscriptionsState;
        return iHashCode3 + (storeSubscriptions$SubscriptionsState != null ? storeSubscriptions$SubscriptionsState.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(skuDetailsState=");
        sbU.append(this.skuDetailsState);
        sbU.append(", purchasesState=");
        sbU.append(this.purchasesState);
        sbU.append(", purchasesQueryState=");
        sbU.append(this.purchasesQueryState);
        sbU.append(", subscriptionsState=");
        sbU.append(this.subscriptionsState);
        sbU.append(")");
        return sbU.toString();
    }
}
