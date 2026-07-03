package com.discord.api.connectedaccounts;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.id, connectedAccountIntegration.id) && C12238m.areEqual(this.type, connectedAccountIntegration.type) && C12238m.areEqual(this.account, connectedAccountIntegration.account) && C12238m.areEqual(this.guild, connectedAccountIntegration.guild);
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
        StringBuilder sbM833U = C1643a.m833U("ConnectedAccountIntegration(id=");
        sbM833U.append(this.id);
        sbM833U.append(", type=");
        sbM833U.append(this.type);
        sbM833U.append(", account=");
        sbM833U.append(this.account);
        sbM833U.append(", guild=");
        sbM833U.append(this.guild);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
