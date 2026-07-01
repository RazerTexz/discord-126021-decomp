package com.discord.stores;

import b.d.b.a.a;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.domain.ModelSubscription$Type;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: StoreSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreSubscriptions$SubscriptionsState$Loaded extends StoreSubscriptions$SubscriptionsState {
    private final List<ModelSubscription> subscriptions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreSubscriptions$SubscriptionsState$Loaded(List<ModelSubscription> list) {
        super(null);
        m.checkNotNullParameter(list, "subscriptions");
        this.subscriptions = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreSubscriptions$SubscriptionsState$Loaded copy$default(StoreSubscriptions$SubscriptionsState$Loaded storeSubscriptions$SubscriptionsState$Loaded, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = storeSubscriptions$SubscriptionsState$Loaded.subscriptions;
        }
        return storeSubscriptions$SubscriptionsState$Loaded.copy(list);
    }

    public final List<ModelSubscription> component1() {
        return this.subscriptions;
    }

    public final StoreSubscriptions$SubscriptionsState$Loaded copy(List<ModelSubscription> subscriptions) {
        m.checkNotNullParameter(subscriptions, "subscriptions");
        return new StoreSubscriptions$SubscriptionsState$Loaded(subscriptions);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreSubscriptions$SubscriptionsState$Loaded) && m.areEqual(this.subscriptions, ((StoreSubscriptions$SubscriptionsState$Loaded) other).subscriptions);
        }
        return true;
    }

    public final ModelSubscription getPremiumSubscription() {
        Object next;
        Iterator<T> it = this.subscriptions.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (((ModelSubscription) next).getType() == ModelSubscription$Type.PREMIUM) {
                return (ModelSubscription) next;
            }
        }
        next = null;
        return (ModelSubscription) next;
    }

    public final List<ModelSubscription> getSubscriptions() {
        return this.subscriptions;
    }

    public int hashCode() {
        List<ModelSubscription> list = this.subscriptions;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.L(a.U("Loaded(subscriptions="), this.subscriptions, ")");
    }
}
