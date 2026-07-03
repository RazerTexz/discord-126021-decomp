package com.discord.api.connectedaccounts;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ConnectedIntegrationGuild.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ConnectedIntegrationGuild {
    private final String icon;
    private final long id;
    private final String name;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConnectedIntegrationGuild)) {
            return false;
        }
        ConnectedIntegrationGuild connectedIntegrationGuild = (ConnectedIntegrationGuild) other;
        return this.id == connectedIntegrationGuild.id && C12238m.areEqual(this.icon, connectedIntegrationGuild.icon) && C12238m.areEqual(this.name, connectedIntegrationGuild.name);
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.icon;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.name;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ConnectedIntegrationGuild(id=");
        sbM833U.append(this.id);
        sbM833U.append(", icon=");
        sbM833U.append(this.icon);
        sbM833U.append(", name=");
        return C1643a.m822J(sbM833U, this.name, ")");
    }
}
