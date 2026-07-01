package com.discord.stores;

import b.d.b.a.a;
import com.android.billingclient.api.Purchase;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreGooglePlayPurchases.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreGooglePlayPurchases$State$Loaded extends StoreGooglePlayPurchases$State {
    private final List<Purchase> iapPurchases;
    private final PendingDowngrade pendingDowngrade;
    private final List<Purchase> subscriptionPurchases;

    public /* synthetic */ StoreGooglePlayPurchases$State$Loaded(List list, List list2, PendingDowngrade pendingDowngrade, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? n.emptyList() : list, (i & 2) != 0 ? n.emptyList() : list2, pendingDowngrade);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreGooglePlayPurchases$State$Loaded copy$default(StoreGooglePlayPurchases$State$Loaded storeGooglePlayPurchases$State$Loaded, List list, List list2, PendingDowngrade pendingDowngrade, int i, Object obj) {
        if ((i & 1) != 0) {
            list = storeGooglePlayPurchases$State$Loaded.subscriptionPurchases;
        }
        if ((i & 2) != 0) {
            list2 = storeGooglePlayPurchases$State$Loaded.iapPurchases;
        }
        if ((i & 4) != 0) {
            pendingDowngrade = storeGooglePlayPurchases$State$Loaded.pendingDowngrade;
        }
        return storeGooglePlayPurchases$State$Loaded.copy(list, list2, pendingDowngrade);
    }

    public final List<Purchase> component1() {
        return this.subscriptionPurchases;
    }

    public final List<Purchase> component2() {
        return this.iapPurchases;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PendingDowngrade getPendingDowngrade() {
        return this.pendingDowngrade;
    }

    public final StoreGooglePlayPurchases$State$Loaded copy(List<? extends Purchase> subscriptionPurchases, List<? extends Purchase> iapPurchases, PendingDowngrade pendingDowngrade) {
        m.checkNotNullParameter(subscriptionPurchases, "subscriptionPurchases");
        m.checkNotNullParameter(iapPurchases, "iapPurchases");
        return new StoreGooglePlayPurchases$State$Loaded(subscriptionPurchases, iapPurchases, pendingDowngrade);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreGooglePlayPurchases$State$Loaded)) {
            return false;
        }
        StoreGooglePlayPurchases$State$Loaded storeGooglePlayPurchases$State$Loaded = (StoreGooglePlayPurchases$State$Loaded) other;
        return m.areEqual(this.subscriptionPurchases, storeGooglePlayPurchases$State$Loaded.subscriptionPurchases) && m.areEqual(this.iapPurchases, storeGooglePlayPurchases$State$Loaded.iapPurchases) && m.areEqual(this.pendingDowngrade, storeGooglePlayPurchases$State$Loaded.pendingDowngrade);
    }

    public final List<Purchase> getIapPurchases() {
        return this.iapPurchases;
    }

    public final PendingDowngrade getPendingDowngrade() {
        return this.pendingDowngrade;
    }

    public final List<Purchase> getPurchases() {
        return u.plus((Collection) this.subscriptionPurchases, (Iterable) this.iapPurchases);
    }

    public final List<Purchase> getSubscriptionPurchases() {
        return this.subscriptionPurchases;
    }

    public int hashCode() {
        List<Purchase> list = this.subscriptionPurchases;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<Purchase> list2 = this.iapPurchases;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        PendingDowngrade pendingDowngrade = this.pendingDowngrade;
        return iHashCode2 + (pendingDowngrade != null ? pendingDowngrade.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(subscriptionPurchases=");
        sbU.append(this.subscriptionPurchases);
        sbU.append(", iapPurchases=");
        sbU.append(this.iapPurchases);
        sbU.append(", pendingDowngrade=");
        sbU.append(this.pendingDowngrade);
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StoreGooglePlayPurchases$State$Loaded(List<? extends Purchase> list, List<? extends Purchase> list2, PendingDowngrade pendingDowngrade) {
        super(null);
        m.checkNotNullParameter(list, "subscriptionPurchases");
        m.checkNotNullParameter(list2, "iapPurchases");
        this.subscriptionPurchases = list;
        this.iapPurchases = list2;
        this.pendingDowngrade = pendingDowngrade;
    }
}
