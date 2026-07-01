package com.discord.api.connectedaccounts;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: ConnectedAccountIntegration.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ConnectedAccountIntegration {
    private final ConnectedIntegrationAccount account;
    private final ConnectedIntegrationGuild guild;
    private final String id;
    private final String type;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final ConnectedIntegrationAccount getAccount() {
        return this.account;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final ConnectedIntegrationGuild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConnectedAccountIntegration)) {
            return false;
        }
        ConnectedAccountIntegration connectedAccountIntegration = (ConnectedAccountIntegration) other;
        return m.areEqual(this.id, connectedAccountIntegration.id) && m.areEqual(this.type, connectedAccountIntegration.type) && m.areEqual(this.account, connectedAccountIntegration.account) && m.areEqual(this.guild, connectedAccountIntegration.guild);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.type;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        ConnectedIntegrationAccount connectedIntegrationAccount = this.account;
        int iHashCode3 = (iHashCode2 + (connectedIntegrationAccount != null ? connectedIntegrationAccount.hashCode() : 0)) * 31;
        ConnectedIntegrationGuild connectedIntegrationGuild = this.guild;
        return iHashCode3 + (connectedIntegrationGuild != null ? connectedIntegrationGuild.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ConnectedAccountIntegration(id=");
        sbU.append(this.id);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", account=");
        sbU.append(this.account);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(")");
        return sbU.toString();
    }
}
