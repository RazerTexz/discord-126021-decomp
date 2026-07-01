package com.discord.widgets.user.profile;

import b.d.b.a.a;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;

/* JADX INFO: compiled from: UserProfileConnectionsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class UserProfileConnectionsView$ConnectedAccountItem implements MGRecyclerDataPayload {
    private final ConnectedAccount connectedAccount;
    private final String key;
    private final int type;

    public UserProfileConnectionsView$ConnectedAccountItem(ConnectedAccount connectedAccount) {
        m.checkNotNullParameter(connectedAccount, "connectedAccount");
        this.connectedAccount = connectedAccount;
        this.key = connectedAccount.getId();
    }

    public static /* synthetic */ UserProfileConnectionsView$ConnectedAccountItem copy$default(UserProfileConnectionsView$ConnectedAccountItem userProfileConnectionsView$ConnectedAccountItem, ConnectedAccount connectedAccount, int i, Object obj) {
        if ((i & 1) != 0) {
            connectedAccount = userProfileConnectionsView$ConnectedAccountItem.connectedAccount;
        }
        return userProfileConnectionsView$ConnectedAccountItem.copy(connectedAccount);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ConnectedAccount getConnectedAccount() {
        return this.connectedAccount;
    }

    public final UserProfileConnectionsView$ConnectedAccountItem copy(ConnectedAccount connectedAccount) {
        m.checkNotNullParameter(connectedAccount, "connectedAccount");
        return new UserProfileConnectionsView$ConnectedAccountItem(connectedAccount);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof UserProfileConnectionsView$ConnectedAccountItem) && m.areEqual(this.connectedAccount, ((UserProfileConnectionsView$ConnectedAccountItem) other).connectedAccount);
        }
        return true;
    }

    public final ConnectedAccount getConnectedAccount() {
        return this.connectedAccount;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        ConnectedAccount connectedAccount = this.connectedAccount;
        if (connectedAccount != null) {
            return connectedAccount.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("ConnectedAccountItem(connectedAccount=");
        sbU.append(this.connectedAccount);
        sbU.append(")");
        return sbU.toString();
    }
}
