package com.discord.widgets.servers.guild_role_subscription;

import b.d.b.a.a;
import com.discord.stores.StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;
import d0.z.d.m;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ServerSettingsGuildRoleSubscriptionViewModel$StoreState {
    private final Boolean fullServerGatingOverwrite;
    private final StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState;

    public ServerSettingsGuildRoleSubscriptionViewModel$StoreState(StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState, Boolean bool) {
        this.guildRoleSubscriptionGroupState = storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;
        this.fullServerGatingOverwrite = bool;
    }

    public static /* synthetic */ ServerSettingsGuildRoleSubscriptionViewModel$StoreState copy$default(ServerSettingsGuildRoleSubscriptionViewModel$StoreState serverSettingsGuildRoleSubscriptionViewModel$StoreState, StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState = serverSettingsGuildRoleSubscriptionViewModel$StoreState.guildRoleSubscriptionGroupState;
        }
        if ((i & 2) != 0) {
            bool = serverSettingsGuildRoleSubscriptionViewModel$StoreState.fullServerGatingOverwrite;
        }
        return serverSettingsGuildRoleSubscriptionViewModel$StoreState.copy(storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState, bool);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState getGuildRoleSubscriptionGroupState() {
        return this.guildRoleSubscriptionGroupState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getFullServerGatingOverwrite() {
        return this.fullServerGatingOverwrite;
    }

    public final ServerSettingsGuildRoleSubscriptionViewModel$StoreState copy(StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState, Boolean fullServerGatingOverwrite) {
        return new ServerSettingsGuildRoleSubscriptionViewModel$StoreState(guildRoleSubscriptionGroupState, fullServerGatingOverwrite);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServerSettingsGuildRoleSubscriptionViewModel$StoreState)) {
            return false;
        }
        ServerSettingsGuildRoleSubscriptionViewModel$StoreState serverSettingsGuildRoleSubscriptionViewModel$StoreState = (ServerSettingsGuildRoleSubscriptionViewModel$StoreState) other;
        return m.areEqual(this.guildRoleSubscriptionGroupState, serverSettingsGuildRoleSubscriptionViewModel$StoreState.guildRoleSubscriptionGroupState) && m.areEqual(this.fullServerGatingOverwrite, serverSettingsGuildRoleSubscriptionViewModel$StoreState.fullServerGatingOverwrite);
    }

    public final Boolean getFullServerGatingOverwrite() {
        return this.fullServerGatingOverwrite;
    }

    public final StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState getGuildRoleSubscriptionGroupState() {
        return this.guildRoleSubscriptionGroupState;
    }

    public int hashCode() {
        StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState = this.guildRoleSubscriptionGroupState;
        int iHashCode = (storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState != null ? storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState.hashCode() : 0) * 31;
        Boolean bool = this.fullServerGatingOverwrite;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(guildRoleSubscriptionGroupState=");
        sbU.append(this.guildRoleSubscriptionGroupState);
        sbU.append(", fullServerGatingOverwrite=");
        return a.D(sbU, this.fullServerGatingOverwrite, ")");
    }
}
