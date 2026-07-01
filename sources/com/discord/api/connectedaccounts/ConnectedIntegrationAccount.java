package com.discord.api.connectedaccounts;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: ConnectedIntegrationAccount.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ConnectedIntegrationAccount {
    private final String id;
    private final String name;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConnectedIntegrationAccount)) {
            return false;
        }
        ConnectedIntegrationAccount connectedIntegrationAccount = (ConnectedIntegrationAccount) other;
        return m.areEqual(this.id, connectedIntegrationAccount.id) && m.areEqual(this.name, connectedIntegrationAccount.name);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ConnectedIntegrationAccount(id=");
        sbU.append(this.id);
        sbU.append(", name=");
        return a.J(sbU, this.name, ")");
    }
}
