package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import b.d.b.a.a;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import d0.z.d.m;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$StoredStateUpdate extends ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event {
    private final GuildRoleSubscriptionTier guildRoleSubscriptionTier;
    private final boolean isFullServerGating;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$StoredStateUpdate(GuildRoleSubscriptionTier guildRoleSubscriptionTier, boolean z2) {
        super(null);
        m.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
        this.guildRoleSubscriptionTier = guildRoleSubscriptionTier;
        this.isFullServerGating = z2;
    }

    public static /* synthetic */ ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$StoredStateUpdate copy$default(ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$StoredStateUpdate serverSettingsGuildRoleSubscriptionEditTierViewModel$Event$StoredStateUpdate, GuildRoleSubscriptionTier guildRoleSubscriptionTier, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            guildRoleSubscriptionTier = serverSettingsGuildRoleSubscriptionEditTierViewModel$Event$StoredStateUpdate.guildRoleSubscriptionTier;
        }
        if ((i & 2) != 0) {
            z2 = serverSettingsGuildRoleSubscriptionEditTierViewModel$Event$StoredStateUpdate.isFullServerGating;
        }
        return serverSettingsGuildRoleSubscriptionEditTierViewModel$Event$StoredStateUpdate.copy(guildRoleSubscriptionTier, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuildRoleSubscriptionTier getGuildRoleSubscriptionTier() {
        return this.guildRoleSubscriptionTier;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsFullServerGating() {
        return this.isFullServerGating;
    }

    public final ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$StoredStateUpdate copy(GuildRoleSubscriptionTier guildRoleSubscriptionTier, boolean isFullServerGating) {
        m.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
        return new ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$StoredStateUpdate(guildRoleSubscriptionTier, isFullServerGating);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$StoredStateUpdate)) {
            return false;
        }
        ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$StoredStateUpdate serverSettingsGuildRoleSubscriptionEditTierViewModel$Event$StoredStateUpdate = (ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$StoredStateUpdate) other;
        return m.areEqual(this.guildRoleSubscriptionTier, serverSettingsGuildRoleSubscriptionEditTierViewModel$Event$StoredStateUpdate.guildRoleSubscriptionTier) && this.isFullServerGating == serverSettingsGuildRoleSubscriptionEditTierViewModel$Event$StoredStateUpdate.isFullServerGating;
    }

    public final GuildRoleSubscriptionTier getGuildRoleSubscriptionTier() {
        return this.guildRoleSubscriptionTier;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = this.guildRoleSubscriptionTier;
        int iHashCode = (guildRoleSubscriptionTier != null ? guildRoleSubscriptionTier.hashCode() : 0) * 31;
        boolean z2 = this.isFullServerGating;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final boolean isFullServerGating() {
        return this.isFullServerGating;
    }

    public String toString() {
        StringBuilder sbU = a.U("StoredStateUpdate(guildRoleSubscriptionTier=");
        sbU.append(this.guildRoleSubscriptionTier);
        sbU.append(", isFullServerGating=");
        return a.O(sbU, this.isFullServerGating, ")");
    }
}
