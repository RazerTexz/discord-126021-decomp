package com.discord.widgets.guild_role_subscriptions.tier.create;

import b.d.b.a.a;
import com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierAdapterItem;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: GuildRoleSubscriptionReviewViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildRoleSubscriptionReviewViewModel$ViewState {
    private final List<GuildRoleSubscriptionTierAdapterItem> items;

    /* JADX WARN: Multi-variable type inference failed */
    public GuildRoleSubscriptionReviewViewModel$ViewState(List<? extends GuildRoleSubscriptionTierAdapterItem> list) {
        m.checkNotNullParameter(list, "items");
        this.items = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildRoleSubscriptionReviewViewModel$ViewState copy$default(GuildRoleSubscriptionReviewViewModel$ViewState guildRoleSubscriptionReviewViewModel$ViewState, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = guildRoleSubscriptionReviewViewModel$ViewState.items;
        }
        return guildRoleSubscriptionReviewViewModel$ViewState.copy(list);
    }

    public final List<GuildRoleSubscriptionTierAdapterItem> component1() {
        return this.items;
    }

    public final GuildRoleSubscriptionReviewViewModel$ViewState copy(List<? extends GuildRoleSubscriptionTierAdapterItem> items) {
        m.checkNotNullParameter(items, "items");
        return new GuildRoleSubscriptionReviewViewModel$ViewState(items);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildRoleSubscriptionReviewViewModel$ViewState) && m.areEqual(this.items, ((GuildRoleSubscriptionReviewViewModel$ViewState) other).items);
        }
        return true;
    }

    public final List<GuildRoleSubscriptionTierAdapterItem> getItems() {
        return this.items;
    }

    public int hashCode() {
        List<GuildRoleSubscriptionTierAdapterItem> list = this.items;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.L(a.U("ViewState(items="), this.items, ")");
    }
}
