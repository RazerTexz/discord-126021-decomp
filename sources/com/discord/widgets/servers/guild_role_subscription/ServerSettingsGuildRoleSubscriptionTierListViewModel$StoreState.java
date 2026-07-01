package com.discord.widgets.servers.guild_role_subscription;

import b.d.b.a.a;
import com.discord.stores.StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;
import d0.z.d.m;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ServerSettingsGuildRoleSubscriptionTierListViewModel$StoreState {
    private final StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState;

    public ServerSettingsGuildRoleSubscriptionTierListViewModel$StoreState(StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState) {
        this.guildRoleSubscriptionGroupState = storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;
    }

    public static /* synthetic */ ServerSettingsGuildRoleSubscriptionTierListViewModel$StoreState copy$default(ServerSettingsGuildRoleSubscriptionTierListViewModel$StoreState serverSettingsGuildRoleSubscriptionTierListViewModel$StoreState, StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState, int i, Object obj) {
        if ((i & 1) != 0) {
            storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState = serverSettingsGuildRoleSubscriptionTierListViewModel$StoreState.guildRoleSubscriptionGroupState;
        }
        return serverSettingsGuildRoleSubscriptionTierListViewModel$StoreState.copy(storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState getGuildRoleSubscriptionGroupState() {
        return this.guildRoleSubscriptionGroupState;
    }

    public final ServerSettingsGuildRoleSubscriptionTierListViewModel$StoreState copy(StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState) {
        return new ServerSettingsGuildRoleSubscriptionTierListViewModel$StoreState(guildRoleSubscriptionGroupState);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ServerSettingsGuildRoleSubscriptionTierListViewModel$StoreState) && m.areEqual(this.guildRoleSubscriptionGroupState, ((ServerSettingsGuildRoleSubscriptionTierListViewModel$StoreState) other).guildRoleSubscriptionGroupState);
        }
        return true;
    }

    public final StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState getGuildRoleSubscriptionGroupState() {
        return this.guildRoleSubscriptionGroupState;
    }

    public int hashCode() {
        StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState = this.guildRoleSubscriptionGroupState;
        if (storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState != null) {
            return storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(guildRoleSubscriptionGroupState=");
        sbU.append(this.guildRoleSubscriptionGroupState);
        sbU.append(")");
        return sbU.toString();
    }
}
