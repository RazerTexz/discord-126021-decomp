package com.discord.stores;

import b.d.b.a.a;
import com.discord.api.connectedaccounts.ConnectedAccount;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: StoreUserConnections.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreUserConnections$State$ConnectedAccounts extends StoreUserConnections$State {
    private final List<ConnectedAccount> connectedAccounts;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserConnections$State$ConnectedAccounts(List<ConnectedAccount> list) {
        super(list, null);
        m.checkNotNullParameter(list, "connectedAccounts");
        this.connectedAccounts = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreUserConnections$State$ConnectedAccounts copy$default(StoreUserConnections$State$ConnectedAccounts storeUserConnections$State$ConnectedAccounts, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = storeUserConnections$State$ConnectedAccounts.getConnectedAccounts();
        }
        return storeUserConnections$State$ConnectedAccounts.copy(list);
    }

    public final List<ConnectedAccount> component1() {
        return getConnectedAccounts();
    }

    public final StoreUserConnections$State$ConnectedAccounts copy(List<ConnectedAccount> connectedAccounts) {
        m.checkNotNullParameter(connectedAccounts, "connectedAccounts");
        return new StoreUserConnections$State$ConnectedAccounts(connectedAccounts);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreUserConnections$State$ConnectedAccounts) && m.areEqual(getConnectedAccounts(), ((StoreUserConnections$State$ConnectedAccounts) other).getConnectedAccounts());
        }
        return true;
    }

    @Override // com.discord.stores.StoreUserConnections$State
    public List<ConnectedAccount> getConnectedAccounts() {
        return this.connectedAccounts;
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        List<ConnectedAccount> connectedAccounts = getConnectedAccounts();
        if (connectedAccounts != null) {
            return connectedAccounts.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("ConnectedAccounts(connectedAccounts=");
        sbU.append(getConnectedAccounts());
        sbU.append(")");
        return sbU.toString();
    }
}
