package com.discord.widgets.guild_role_subscriptions.tier.create;

import b.d.b.a.a;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildRoleSubscriptionTierViewModel$ViewState {
    private final GuildRoleSubscriptionTier guildRoleSubscriptionTier;
    private final Boolean isFullServerGating;

    public GuildRoleSubscriptionTierViewModel$ViewState() {
        this(null, null, 3, null);
    }

    public GuildRoleSubscriptionTierViewModel$ViewState(GuildRoleSubscriptionTier guildRoleSubscriptionTier, Boolean bool) {
        m.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
        this.guildRoleSubscriptionTier = guildRoleSubscriptionTier;
        this.isFullServerGating = bool;
    }

    public static /* synthetic */ GuildRoleSubscriptionTierViewModel$ViewState copy$default(GuildRoleSubscriptionTierViewModel$ViewState guildRoleSubscriptionTierViewModel$ViewState, GuildRoleSubscriptionTier guildRoleSubscriptionTier, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            guildRoleSubscriptionTier = guildRoleSubscriptionTierViewModel$ViewState.guildRoleSubscriptionTier;
        }
        if ((i & 2) != 0) {
            bool = guildRoleSubscriptionTierViewModel$ViewState.isFullServerGating;
        }
        return guildRoleSubscriptionTierViewModel$ViewState.copy(guildRoleSubscriptionTier, bool);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuildRoleSubscriptionTier getGuildRoleSubscriptionTier() {
        return this.guildRoleSubscriptionTier;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getIsFullServerGating() {
        return this.isFullServerGating;
    }

    public final GuildRoleSubscriptionTierViewModel$ViewState copy(GuildRoleSubscriptionTier guildRoleSubscriptionTier, Boolean isFullServerGating) {
        m.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
        return new GuildRoleSubscriptionTierViewModel$ViewState(guildRoleSubscriptionTier, isFullServerGating);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleSubscriptionTierViewModel$ViewState)) {
            return false;
        }
        GuildRoleSubscriptionTierViewModel$ViewState guildRoleSubscriptionTierViewModel$ViewState = (GuildRoleSubscriptionTierViewModel$ViewState) other;
        return m.areEqual(this.guildRoleSubscriptionTier, guildRoleSubscriptionTierViewModel$ViewState.guildRoleSubscriptionTier) && m.areEqual(this.isFullServerGating, guildRoleSubscriptionTierViewModel$ViewState.isFullServerGating);
    }

    public final GuildRoleSubscriptionTier getGuildRoleSubscriptionTier() {
        return this.guildRoleSubscriptionTier;
    }

    public int hashCode() {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = this.guildRoleSubscriptionTier;
        int iHashCode = (guildRoleSubscriptionTier != null ? guildRoleSubscriptionTier.hashCode() : 0) * 31;
        Boolean bool = this.isFullServerGating;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public final Boolean isFullServerGating() {
        return this.isFullServerGating;
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(guildRoleSubscriptionTier=");
        sbU.append(this.guildRoleSubscriptionTier);
        sbU.append(", isFullServerGating=");
        return a.D(sbU, this.isFullServerGating, ")");
    }

    public /* synthetic */ GuildRoleSubscriptionTierViewModel$ViewState(GuildRoleSubscriptionTier guildRoleSubscriptionTier, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new GuildRoleSubscriptionTier(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null) : guildRoleSubscriptionTier, (i & 2) != 0 ? null : bool);
    }
}
