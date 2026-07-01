package b.a.a.a;

import com.discord.stores.StoreGuildBoost$State;
import com.discord.stores.StoreSubscriptions$SubscriptionsState;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildBoostCancelViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f$b {
    public final StoreGuildBoost$State a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StoreSubscriptions$SubscriptionsState f41b;

    public f$b(StoreGuildBoost$State storeGuildBoost$State, StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState) {
        m.checkNotNullParameter(storeGuildBoost$State, "guildBoostState");
        m.checkNotNullParameter(storeSubscriptions$SubscriptionsState, "subscriptionState");
        this.a = storeGuildBoost$State;
        this.f41b = storeSubscriptions$SubscriptionsState;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f$b)) {
            return false;
        }
        f$b f_b = (f$b) obj;
        return m.areEqual(this.a, f_b.a) && m.areEqual(this.f41b, f_b.f41b);
    }

    public int hashCode() {
        StoreGuildBoost$State storeGuildBoost$State = this.a;
        int iHashCode = (storeGuildBoost$State != null ? storeGuildBoost$State.hashCode() : 0) * 31;
        StoreSubscriptions$SubscriptionsState storeSubscriptions$SubscriptionsState = this.f41b;
        return iHashCode + (storeSubscriptions$SubscriptionsState != null ? storeSubscriptions$SubscriptionsState.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("StoreState(guildBoostState=");
        sbU.append(this.a);
        sbU.append(", subscriptionState=");
        sbU.append(this.f41b);
        sbU.append(")");
        return sbU.toString();
    }
}
