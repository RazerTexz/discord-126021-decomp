package com.discord.widgets.guild_role_subscriptions.tier.create;

import b.d.b.a.a;

/* JADX INFO: compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class CreateGuildRoleSubscriptionTierViewModel$Event$ServerGatingUpdate extends CreateGuildRoleSubscriptionTierViewModel$Event {
    private final boolean isFullServerGating;

    public CreateGuildRoleSubscriptionTierViewModel$Event$ServerGatingUpdate(boolean z2) {
        super(null);
        this.isFullServerGating = z2;
    }

    public static /* synthetic */ CreateGuildRoleSubscriptionTierViewModel$Event$ServerGatingUpdate copy$default(CreateGuildRoleSubscriptionTierViewModel$Event$ServerGatingUpdate createGuildRoleSubscriptionTierViewModel$Event$ServerGatingUpdate, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = createGuildRoleSubscriptionTierViewModel$Event$ServerGatingUpdate.isFullServerGating;
        }
        return createGuildRoleSubscriptionTierViewModel$Event$ServerGatingUpdate.copy(z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsFullServerGating() {
        return this.isFullServerGating;
    }

    public final CreateGuildRoleSubscriptionTierViewModel$Event$ServerGatingUpdate copy(boolean isFullServerGating) {
        return new CreateGuildRoleSubscriptionTierViewModel$Event$ServerGatingUpdate(isFullServerGating);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof CreateGuildRoleSubscriptionTierViewModel$Event$ServerGatingUpdate) && this.isFullServerGating == ((CreateGuildRoleSubscriptionTierViewModel$Event$ServerGatingUpdate) other).isFullServerGating;
        }
        return true;
    }

    public int hashCode() {
        boolean z2 = this.isFullServerGating;
        if (z2) {
            return 1;
        }
        return z2 ? 1 : 0;
    }

    public final boolean isFullServerGating() {
        return this.isFullServerGating;
    }

    public String toString() {
        return a.O(a.U("ServerGatingUpdate(isFullServerGating="), this.isFullServerGating, ")");
    }
}
