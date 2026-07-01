package com.discord.api.connectedaccounts;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

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
        return this.id == connectedIntegrationGuild.id && Intrinsics3.areEqual(this.icon, connectedIntegrationGuild.icon) && Intrinsics3.areEqual(this.name, connectedIntegrationGuild.name);
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
        StringBuilder sbU = outline.U("ConnectedIntegrationGuild(id=");
        sbU.append(this.id);
        sbU.append(", icon=");
        sbU.append(this.icon);
        sbU.append(", name=");
        return outline.J(sbU, this.name, ")");
    }
}
