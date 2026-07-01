package com.discord.widgets.guild_role_subscriptions.entrypoint;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionEntryPointViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildRoleSubscriptionEntryPointViewModel$StoreState {
    private final Guild guild;
    private final Long guildRoleSubscriptionGroupListingId;
    private final Boolean hasUserActiveSubscription;
    private final boolean isAccessible;
    private final boolean isConnected;

    public WidgetGuildRoleSubscriptionEntryPointViewModel$StoreState(boolean z2, boolean z3, Guild guild, Boolean bool, Long l) {
        this.isConnected = z2;
        this.isAccessible = z3;
        this.guild = guild;
        this.hasUserActiveSubscription = bool;
        this.guildRoleSubscriptionGroupListingId = l;
    }

    public static /* synthetic */ WidgetGuildRoleSubscriptionEntryPointViewModel$StoreState copy$default(WidgetGuildRoleSubscriptionEntryPointViewModel$StoreState widgetGuildRoleSubscriptionEntryPointViewModel$StoreState, boolean z2, boolean z3, Guild guild, Boolean bool, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = widgetGuildRoleSubscriptionEntryPointViewModel$StoreState.isConnected;
        }
        if ((i & 2) != 0) {
            z3 = widgetGuildRoleSubscriptionEntryPointViewModel$StoreState.isAccessible;
        }
        boolean z4 = z3;
        if ((i & 4) != 0) {
            guild = widgetGuildRoleSubscriptionEntryPointViewModel$StoreState.guild;
        }
        Guild guild2 = guild;
        if ((i & 8) != 0) {
            bool = widgetGuildRoleSubscriptionEntryPointViewModel$StoreState.hasUserActiveSubscription;
        }
        Boolean bool2 = bool;
        if ((i & 16) != 0) {
            l = widgetGuildRoleSubscriptionEntryPointViewModel$StoreState.guildRoleSubscriptionGroupListingId;
        }
        return widgetGuildRoleSubscriptionEntryPointViewModel$StoreState.copy(z2, z4, guild2, bool2, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsConnected() {
        return this.isConnected;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsAccessible() {
        return this.isAccessible;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getHasUserActiveSubscription() {
        return this.hasUserActiveSubscription;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Long getGuildRoleSubscriptionGroupListingId() {
        return this.guildRoleSubscriptionGroupListingId;
    }

    public final WidgetGuildRoleSubscriptionEntryPointViewModel$StoreState copy(boolean isConnected, boolean isAccessible, Guild guild, Boolean hasUserActiveSubscription, Long guildRoleSubscriptionGroupListingId) {
        return new WidgetGuildRoleSubscriptionEntryPointViewModel$StoreState(isConnected, isAccessible, guild, hasUserActiveSubscription, guildRoleSubscriptionGroupListingId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildRoleSubscriptionEntryPointViewModel$StoreState)) {
            return false;
        }
        WidgetGuildRoleSubscriptionEntryPointViewModel$StoreState widgetGuildRoleSubscriptionEntryPointViewModel$StoreState = (WidgetGuildRoleSubscriptionEntryPointViewModel$StoreState) other;
        return this.isConnected == widgetGuildRoleSubscriptionEntryPointViewModel$StoreState.isConnected && this.isAccessible == widgetGuildRoleSubscriptionEntryPointViewModel$StoreState.isAccessible && m.areEqual(this.guild, widgetGuildRoleSubscriptionEntryPointViewModel$StoreState.guild) && m.areEqual(this.hasUserActiveSubscription, widgetGuildRoleSubscriptionEntryPointViewModel$StoreState.hasUserActiveSubscription) && m.areEqual(this.guildRoleSubscriptionGroupListingId, widgetGuildRoleSubscriptionEntryPointViewModel$StoreState.guildRoleSubscriptionGroupListingId);
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final Long getGuildRoleSubscriptionGroupListingId() {
        return this.guildRoleSubscriptionGroupListingId;
    }

    public final Boolean getHasUserActiveSubscription() {
        return this.hasUserActiveSubscription;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    public int hashCode() {
        boolean z2 = this.isConnected;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.isAccessible;
        int i2 = (i + (z3 ? 1 : z3)) * 31;
        Guild guild = this.guild;
        int iHashCode = (i2 + (guild != null ? guild.hashCode() : 0)) * 31;
        Boolean bool = this.hasUserActiveSubscription;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l = this.guildRoleSubscriptionGroupListingId;
        return iHashCode2 + (l != null ? l.hashCode() : 0);
    }

    public final boolean isAccessible() {
        return this.isAccessible;
    }

    public final boolean isConnected() {
        return this.isConnected;
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(isConnected=");
        sbU.append(this.isConnected);
        sbU.append(", isAccessible=");
        sbU.append(this.isAccessible);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", hasUserActiveSubscription=");
        sbU.append(this.hasUserActiveSubscription);
        sbU.append(", guildRoleSubscriptionGroupListingId=");
        return a.G(sbU, this.guildRoleSubscriptionGroupListingId, ")");
    }
}
