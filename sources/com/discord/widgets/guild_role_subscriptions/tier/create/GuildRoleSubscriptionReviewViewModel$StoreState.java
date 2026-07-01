package com.discord.widgets.guild_role_subscriptions.tier.create;

import b.d.b.a.a;

/* JADX INFO: compiled from: GuildRoleSubscriptionReviewViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildRoleSubscriptionReviewViewModel$StoreState {
    private final int guildChannelCount;

    public GuildRoleSubscriptionReviewViewModel$StoreState(int i) {
        this.guildChannelCount = i;
    }

    public static /* synthetic */ GuildRoleSubscriptionReviewViewModel$StoreState copy$default(GuildRoleSubscriptionReviewViewModel$StoreState guildRoleSubscriptionReviewViewModel$StoreState, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = guildRoleSubscriptionReviewViewModel$StoreState.guildChannelCount;
        }
        return guildRoleSubscriptionReviewViewModel$StoreState.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getGuildChannelCount() {
        return this.guildChannelCount;
    }

    public final GuildRoleSubscriptionReviewViewModel$StoreState copy(int guildChannelCount) {
        return new GuildRoleSubscriptionReviewViewModel$StoreState(guildChannelCount);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildRoleSubscriptionReviewViewModel$StoreState) && this.guildChannelCount == ((GuildRoleSubscriptionReviewViewModel$StoreState) other).guildChannelCount;
        }
        return true;
    }

    public final int getGuildChannelCount() {
        return this.guildChannelCount;
    }

    public int hashCode() {
        return this.guildChannelCount;
    }

    public String toString() {
        return a.B(a.U("StoreState(guildChannelCount="), this.guildChannelCount, ")");
    }
}
