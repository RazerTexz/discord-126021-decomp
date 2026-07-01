package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import b.d.b.a.a;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierFreeTrial;
import com.discord.api.role.GuildRole;
import com.discord.stores.StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ServerSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData {
    private final GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionFreeTrial;
    private final StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupListingState;
    private final Map<Long, GuildRole> guildRoles;

    public ServerSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData(StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState, Map<Long, GuildRole> map, GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial) {
        this.guildRoleSubscriptionGroupListingState = storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;
        this.guildRoles = map;
        this.guildRoleSubscriptionFreeTrial = guildRoleSubscriptionTierFreeTrial;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ServerSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData copy$default(ServerSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData serverSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData, StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState, Map map, GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial, int i, Object obj) {
        if ((i & 1) != 0) {
            storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState = serverSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData.guildRoleSubscriptionGroupListingState;
        }
        if ((i & 2) != 0) {
            map = serverSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData.guildRoles;
        }
        if ((i & 4) != 0) {
            guildRoleSubscriptionTierFreeTrial = serverSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData.guildRoleSubscriptionFreeTrial;
        }
        return serverSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData.copy(storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState, map, guildRoleSubscriptionTierFreeTrial);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState getGuildRoleSubscriptionGroupListingState() {
        return this.guildRoleSubscriptionGroupListingState;
    }

    public final Map<Long, GuildRole> component2() {
        return this.guildRoles;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final GuildRoleSubscriptionTierFreeTrial getGuildRoleSubscriptionFreeTrial() {
        return this.guildRoleSubscriptionFreeTrial;
    }

    public final ServerSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData copy(StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupListingState, Map<Long, GuildRole> guildRoles, GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionFreeTrial) {
        return new ServerSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData(guildRoleSubscriptionGroupListingState, guildRoles, guildRoleSubscriptionFreeTrial);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServerSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData)) {
            return false;
        }
        ServerSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData serverSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData = (ServerSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData) other;
        return m.areEqual(this.guildRoleSubscriptionGroupListingState, serverSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData.guildRoleSubscriptionGroupListingState) && m.areEqual(this.guildRoles, serverSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData.guildRoles) && m.areEqual(this.guildRoleSubscriptionFreeTrial, serverSettingsGuildRoleSubscriptionEditTierViewModel$GuildRoleSubscriptionStoreData.guildRoleSubscriptionFreeTrial);
    }

    public final GuildRoleSubscriptionTierFreeTrial getGuildRoleSubscriptionFreeTrial() {
        return this.guildRoleSubscriptionFreeTrial;
    }

    public final StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState getGuildRoleSubscriptionGroupListingState() {
        return this.guildRoleSubscriptionGroupListingState;
    }

    public final Map<Long, GuildRole> getGuildRoles() {
        return this.guildRoles;
    }

    public int hashCode() {
        StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState = this.guildRoleSubscriptionGroupListingState;
        int iHashCode = (storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState != null ? storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState.hashCode() : 0) * 31;
        Map<Long, GuildRole> map = this.guildRoles;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial = this.guildRoleSubscriptionFreeTrial;
        return iHashCode2 + (guildRoleSubscriptionTierFreeTrial != null ? guildRoleSubscriptionTierFreeTrial.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildRoleSubscriptionStoreData(guildRoleSubscriptionGroupListingState=");
        sbU.append(this.guildRoleSubscriptionGroupListingState);
        sbU.append(", guildRoles=");
        sbU.append(this.guildRoles);
        sbU.append(", guildRoleSubscriptionFreeTrial=");
        sbU.append(this.guildRoleSubscriptionFreeTrial);
        sbU.append(")");
        return sbU.toString();
    }
}
