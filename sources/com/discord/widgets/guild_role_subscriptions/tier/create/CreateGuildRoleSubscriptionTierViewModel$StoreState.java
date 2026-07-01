package com.discord.widgets.guild_role_subscriptions.tier.create;

import b.d.b.a.a;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class CreateGuildRoleSubscriptionTierViewModel$StoreState {
    private final Boolean fullServerGatingOverwrite;
    private final GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing;

    public CreateGuildRoleSubscriptionTierViewModel$StoreState() {
        this(null, null, 3, null);
    }

    public CreateGuildRoleSubscriptionTierViewModel$StoreState(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, Boolean bool) {
        this.guildRoleSubscriptionGroupListing = guildRoleSubscriptionGroupListing;
        this.fullServerGatingOverwrite = bool;
    }

    public static /* synthetic */ CreateGuildRoleSubscriptionTierViewModel$StoreState copy$default(CreateGuildRoleSubscriptionTierViewModel$StoreState createGuildRoleSubscriptionTierViewModel$StoreState, GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            guildRoleSubscriptionGroupListing = createGuildRoleSubscriptionTierViewModel$StoreState.guildRoleSubscriptionGroupListing;
        }
        if ((i & 2) != 0) {
            bool = createGuildRoleSubscriptionTierViewModel$StoreState.fullServerGatingOverwrite;
        }
        return createGuildRoleSubscriptionTierViewModel$StoreState.copy(guildRoleSubscriptionGroupListing, bool);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuildRoleSubscriptionGroupListing getGuildRoleSubscriptionGroupListing() {
        return this.guildRoleSubscriptionGroupListing;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getFullServerGatingOverwrite() {
        return this.fullServerGatingOverwrite;
    }

    public final CreateGuildRoleSubscriptionTierViewModel$StoreState copy(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, Boolean fullServerGatingOverwrite) {
        return new CreateGuildRoleSubscriptionTierViewModel$StoreState(guildRoleSubscriptionGroupListing, fullServerGatingOverwrite);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateGuildRoleSubscriptionTierViewModel$StoreState)) {
            return false;
        }
        CreateGuildRoleSubscriptionTierViewModel$StoreState createGuildRoleSubscriptionTierViewModel$StoreState = (CreateGuildRoleSubscriptionTierViewModel$StoreState) other;
        return m.areEqual(this.guildRoleSubscriptionGroupListing, createGuildRoleSubscriptionTierViewModel$StoreState.guildRoleSubscriptionGroupListing) && m.areEqual(this.fullServerGatingOverwrite, createGuildRoleSubscriptionTierViewModel$StoreState.fullServerGatingOverwrite);
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
        StringBuilder sbU = a.U("StoreState(guildRoleSubscriptionGroupListing=");
        sbU.append(this.guildRoleSubscriptionGroupListing);
        sbU.append(", fullServerGatingOverwrite=");
        return a.D(sbU, this.fullServerGatingOverwrite, ")");
    }

    public /* synthetic */ CreateGuildRoleSubscriptionTierViewModel$StoreState(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : guildRoleSubscriptionGroupListing, (i & 2) != 0 ? null : bool);
    }
}
