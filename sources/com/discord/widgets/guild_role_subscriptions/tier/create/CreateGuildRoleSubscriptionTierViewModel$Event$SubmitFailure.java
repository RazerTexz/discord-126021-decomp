package com.discord.widgets.guild_role_subscriptions.tier.create;

import b.d.b.a.a;
import com.discord.utilities.error.Error;
import d0.z.d.m;

/* JADX INFO: compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class CreateGuildRoleSubscriptionTierViewModel$Event$SubmitFailure extends CreateGuildRoleSubscriptionTierViewModel$Event {
    private final Error error;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateGuildRoleSubscriptionTierViewModel$Event$SubmitFailure(Error error) {
        super(null);
        m.checkNotNullParameter(error, "error");
        this.error = error;
    }

    public static /* synthetic */ CreateGuildRoleSubscriptionTierViewModel$Event$SubmitFailure copy$default(CreateGuildRoleSubscriptionTierViewModel$Event$SubmitFailure createGuildRoleSubscriptionTierViewModel$Event$SubmitFailure, Error error, int i, Object obj) {
        if ((i & 1) != 0) {
            error = createGuildRoleSubscriptionTierViewModel$Event$SubmitFailure.error;
        }
        return createGuildRoleSubscriptionTierViewModel$Event$SubmitFailure.copy(error);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Error getError() {
        return this.error;
    }

    public final CreateGuildRoleSubscriptionTierViewModel$Event$SubmitFailure copy(Error error) {
        m.checkNotNullParameter(error, "error");
        return new CreateGuildRoleSubscriptionTierViewModel$Event$SubmitFailure(error);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof CreateGuildRoleSubscriptionTierViewModel$Event$SubmitFailure) && m.areEqual(this.error, ((CreateGuildRoleSubscriptionTierViewModel$Event$SubmitFailure) other).error);
        }
        return true;
    }

    public final Error getError() {
        return this.error;
    }

    public int hashCode() {
        Error error = this.error;
        if (error != null) {
            return error.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("SubmitFailure(error=");
        sbU.append(this.error);
        sbU.append(")");
        return sbU.toString();
    }
}
