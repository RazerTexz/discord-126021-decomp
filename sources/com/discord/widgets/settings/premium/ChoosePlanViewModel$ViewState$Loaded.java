package com.discord.widgets.settings.premium;

import b.d.b.a.a;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.discord.models.domain.ModelSubscription;
import com.discord.stores.StoreGooglePlayPurchases$QueryState;
import d0.z.d.m;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ChoosePlanViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChoosePlanViewModel$ViewState$Loaded extends ChoosePlanViewModel$ViewState {
    private final boolean isEmpty;
    private final List<WidgetChoosePlanAdapter$Item> items;
    private final List<Purchase> purchases;
    private final StoreGooglePlayPurchases$QueryState purchasesQueryState;
    private final Map<String, SkuDetails> skuDetails;
    private final List<ModelSubscription> subscriptions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChoosePlanViewModel$ViewState$Loaded(StoreGooglePlayPurchases$QueryState storeGooglePlayPurchases$QueryState, List<? extends WidgetChoosePlanAdapter$Item> list, Map<String, ? extends SkuDetails> map, List<? extends Purchase> list2, List<ModelSubscription> list3, boolean z2) {
        super(null);
        m.checkNotNullParameter(storeGooglePlayPurchases$QueryState, "purchasesQueryState");
        m.checkNotNullParameter(list, "items");
        m.checkNotNullParameter(map, "skuDetails");
        m.checkNotNullParameter(list2, "purchases");
        m.checkNotNullParameter(list3, "subscriptions");
        this.purchasesQueryState = storeGooglePlayPurchases$QueryState;
        this.items = list;
        this.skuDetails = map;
        this.purchases = list2;
        this.subscriptions = list3;
        this.isEmpty = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChoosePlanViewModel$ViewState$Loaded copy$default(ChoosePlanViewModel$ViewState$Loaded choosePlanViewModel$ViewState$Loaded, StoreGooglePlayPurchases$QueryState storeGooglePlayPurchases$QueryState, List list, Map map, List list2, List list3, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            storeGooglePlayPurchases$QueryState = choosePlanViewModel$ViewState$Loaded.purchasesQueryState;
        }
        if ((i & 2) != 0) {
            list = choosePlanViewModel$ViewState$Loaded.items;
        }
        List list4 = list;
        if ((i & 4) != 0) {
            map = choosePlanViewModel$ViewState$Loaded.skuDetails;
        }
        Map map2 = map;
        if ((i & 8) != 0) {
            list2 = choosePlanViewModel$ViewState$Loaded.purchases;
        }
        List list5 = list2;
        if ((i & 16) != 0) {
            list3 = choosePlanViewModel$ViewState$Loaded.subscriptions;
        }
        List list6 = list3;
        if ((i & 32) != 0) {
            z2 = choosePlanViewModel$ViewState$Loaded.isEmpty;
        }
        return choosePlanViewModel$ViewState$Loaded.copy(storeGooglePlayPurchases$QueryState, list4, map2, list5, list6, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreGooglePlayPurchases$QueryState getPurchasesQueryState() {
        return this.purchasesQueryState;
    }

    public final List<WidgetChoosePlanAdapter$Item> component2() {
        return this.items;
    }

    public final Map<String, SkuDetails> component3() {
        return this.skuDetails;
    }

    public final List<Purchase> component4() {
        return this.purchases;
    }

    public final List<ModelSubscription> component5() {
        return this.subscriptions;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsEmpty() {
        return this.isEmpty;
    }

    public final ChoosePlanViewModel$ViewState$Loaded copy(StoreGooglePlayPurchases$QueryState purchasesQueryState, List<? extends WidgetChoosePlanAdapter$Item> items, Map<String, ? extends SkuDetails> skuDetails, List<? extends Purchase> purchases, List<ModelSubscription> subscriptions, boolean isEmpty) {
        m.checkNotNullParameter(purchasesQueryState, "purchasesQueryState");
        m.checkNotNullParameter(items, "items");
        m.checkNotNullParameter(skuDetails, "skuDetails");
        m.checkNotNullParameter(purchases, "purchases");
        m.checkNotNullParameter(subscriptions, "subscriptions");
        return new ChoosePlanViewModel$ViewState$Loaded(purchasesQueryState, items, skuDetails, purchases, subscriptions, isEmpty);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChoosePlanViewModel$ViewState$Loaded)) {
            return false;
        }
        ChoosePlanViewModel$ViewState$Loaded choosePlanViewModel$ViewState$Loaded = (ChoosePlanViewModel$ViewState$Loaded) other;
        return m.areEqual(this.purchasesQueryState, choosePlanViewModel$ViewState$Loaded.purchasesQueryState) && m.areEqual(this.items, choosePlanViewModel$ViewState$Loaded.items) && m.areEqual(this.skuDetails, choosePlanViewModel$ViewState$Loaded.skuDetails) && m.areEqual(this.purchases, choosePlanViewModel$ViewState$Loaded.purchases) && m.areEqual(this.subscriptions, choosePlanViewModel$ViewState$Loaded.subscriptions) && this.isEmpty == choosePlanViewModel$ViewState$Loaded.isEmpty;
    }

    public final List<WidgetChoosePlanAdapter$Item> getItems() {
        return this.items;
    }

    public final List<Purchase> getPurchases() {
        return this.purchases;
    }

    public final StoreGooglePlayPurchases$QueryState getPurchasesQueryState() {
        return this.purchasesQueryState;
    }

    public final Map<String, SkuDetails> getSkuDetails() {
        return this.skuDetails;
    }

    public final List<ModelSubscription> getSubscriptions() {
        return this.subscriptions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        StoreGooglePlayPurchases$QueryState storeGooglePlayPurchases$QueryState = this.purchasesQueryState;
        int iHashCode = (storeGooglePlayPurchases$QueryState != null ? storeGooglePlayPurchases$QueryState.hashCode() : 0) * 31;
        List<WidgetChoosePlanAdapter$Item> list = this.items;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        Map<String, SkuDetails> map = this.skuDetails;
        int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
        List<Purchase> list2 = this.purchases;
        int iHashCode4 = (iHashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<ModelSubscription> list3 = this.subscriptions;
        int iHashCode5 = (iHashCode4 + (list3 != null ? list3.hashCode() : 0)) * 31;
        boolean z2 = this.isEmpty;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode5 + r1;
    }

    public final boolean isEmpty() {
        return this.isEmpty;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(purchasesQueryState=");
        sbU.append(this.purchasesQueryState);
        sbU.append(", items=");
        sbU.append(this.items);
        sbU.append(", skuDetails=");
        sbU.append(this.skuDetails);
        sbU.append(", purchases=");
        sbU.append(this.purchases);
        sbU.append(", subscriptions=");
        sbU.append(this.subscriptions);
        sbU.append(", isEmpty=");
        return a.O(sbU, this.isEmpty, ")");
    }
}
