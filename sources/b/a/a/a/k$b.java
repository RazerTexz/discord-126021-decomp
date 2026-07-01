package b.a.a.a;

import com.discord.stores.StoreSubscriptions$SubscriptionsState;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildBoostUncancelViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k$b {
    public final StoreSubscriptions$SubscriptionsState a;

    public k$b(StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState) {
        m.checkNotNullParameter(storeSubscriptions$SubscriptionsState, "subscriptionState");
        this.a = storeSubscriptions$SubscriptionsState;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof k$b) && m.areEqual(this.a, ((k$b) obj).a);
        }
        return true;
    }

    public int hashCode() {
        StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState = this.a;
        if (storeSubscriptions$SubscriptionsState != null) {
            return storeSubscriptions$SubscriptionsState.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("StoreState(subscriptionState=");
        sbU.append(this.a);
        sbU.append(")");
        return sbU.toString();
    }
}
