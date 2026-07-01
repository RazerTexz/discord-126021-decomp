package com.discord.stores;

import b.d.b.a.a;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded extends StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState {
    private final GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing;

    public StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
        super(null);
        this.guildRoleSubscriptionGroupListing = guildRoleSubscriptionGroupListing;
    }

    public static /* synthetic */ StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded copy$default(StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded, GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, int i, Object obj) {
        if ((i & 1) != 0) {
            guildRoleSubscriptionGroupListing = storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded.guildRoleSubscriptionGroupListing;
        }
        return storeGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded.copy(guildRoleSubscriptionGroupListing);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuildRoleSubscriptionGroupListing getGuildRoleSubscriptionGroupListing() {
        return this.guildRoleSubscriptionGroupListing;
    }

    public final StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded copy(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
        return new StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded(guildRoleSubscriptionGroupListing);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded) && m.areEqual(this.guildRoleSubscriptionGroupListing, ((StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded) other).guildRoleSubscriptionGroupListing);
        }
        return true;
    }

    public final GuildRoleSubscriptionGroupListing getGuildRoleSubscriptionGroupListing() {
        return this.guildRoleSubscriptionGroupListing;
    }

    public int hashCode() {
        GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = this.guildRoleSubscriptionGroupListing;
        if (guildRoleSubscriptionGroupListing != null) {
            return guildRoleSubscriptionGroupListing.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(guildRoleSubscriptionGroupListing=");
        sbU.append(this.guildRoleSubscriptionGroupListing);
        sbU.append(")");
        return sbU.toString();
    }
}
