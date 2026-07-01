package com.discord.widgets.servers.guild_role_subscription;

import b.d.b.a.a;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ServerSettingsGuildRoleSubscriptionViewModel$Event$StoreStateUpdate extends ServerSettingsGuildRoleSubscriptionViewModel$Event {
    private final Boolean fullServerGatingOverwrite;
    private final GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing;

    public /* synthetic */ ServerSettingsGuildRoleSubscriptionViewModel$Event$StoreStateUpdate(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(guildRoleSubscriptionGroupListing, (i & 2) != 0 ? null : bool);
    }

    public static /* synthetic */ ServerSettingsGuildRoleSubscriptionViewModel$Event$StoreStateUpdate copy$default(ServerSettingsGuildRoleSubscriptionViewModel$Event$StoreStateUpdate serverSettingsGuildRoleSubscriptionViewModel$Event$StoreStateUpdate, GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            guildRoleSubscriptionGroupListing = serverSettingsGuildRoleSubscriptionViewModel$Event$StoreStateUpdate.guildRoleSubscriptionGroupListing;
        }
        if ((i & 2) != 0) {
            bool = serverSettingsGuildRoleSubscriptionViewModel$Event$StoreStateUpdate.fullServerGatingOverwrite;
        }
        return serverSettingsGuildRoleSubscriptionViewModel$Event$StoreStateUpdate.copy(guildRoleSubscriptionGroupListing, bool);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuildRoleSubscriptionGroupListing getGuildRoleSubscriptionGroupListing() {
        return this.guildRoleSubscriptionGroupListing;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getFullServerGatingOverwrite() {
        return this.fullServerGatingOverwrite;
    }

    public final ServerSettingsGuildRoleSubscriptionViewModel$Event$StoreStateUpdate copy(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, Boolean fullServerGatingOverwrite) {
        m.checkNotNullParameter(guildRoleSubscriptionGroupListing, "guildRoleSubscriptionGroupListing");
        return new ServerSettingsGuildRoleSubscriptionViewModel$Event$StoreStateUpdate(guildRoleSubscriptionGroupListing, fullServerGatingOverwrite);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServerSettingsGuildRoleSubscriptionViewModel$Event$StoreStateUpdate)) {
            return false;
        }
        ServerSettingsGuildRoleSubscriptionViewModel$Event$StoreStateUpdate serverSettingsGuildRoleSubscriptionViewModel$Event$StoreStateUpdate = (ServerSettingsGuildRoleSubscriptionViewModel$Event$StoreStateUpdate) other;
        return m.areEqual(this.guildRoleSubscriptionGroupListing, serverSettingsGuildRoleSubscriptionViewModel$Event$StoreStateUpdate.guildRoleSubscriptionGroupListing) && m.areEqual(this.fullServerGatingOverwrite, serverSettingsGuildRoleSubscriptionViewModel$Event$StoreStateUpdate.fullServerGatingOverwrite);
    }

    public final Boolean getFullServerGatingOverwrite() {
        return this.fullServerGatingOverwrite;
    }

    public final GuildRoleSubscriptionGroupListing getGuildRoleSubscriptionGroupListing() {
        return this.guildRoleSubscriptionGroupListing;
    }

    public int hashCode() {
        GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = this.guildRoleSubscriptionGroupListing;
        int iHashCode = (guildRoleSubscriptionGroupListing != null ? guildRoleSubscriptionGroupListing.hashCode() : 0) * 31;
        Boolean bool = this.fullServerGatingOverwrite;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreStateUpdate(guildRoleSubscriptionGroupListing=");
        sbU.append(this.guildRoleSubscriptionGroupListing);
        sbU.append(", fullServerGatingOverwrite=");
        return a.D(sbU, this.fullServerGatingOverwrite, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsGuildRoleSubscriptionViewModel$Event$StoreStateUpdate(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, Boolean bool) {
        super(null);
        m.checkNotNullParameter(guildRoleSubscriptionGroupListing, "guildRoleSubscriptionGroupListing");
        this.guildRoleSubscriptionGroupListing = guildRoleSubscriptionGroupListing;
        this.fullServerGatingOverwrite = bool;
    }
}
