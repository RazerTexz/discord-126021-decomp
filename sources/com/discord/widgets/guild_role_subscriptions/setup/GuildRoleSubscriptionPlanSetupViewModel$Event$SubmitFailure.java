package com.discord.widgets.guild_role_subscriptions.setup;

import b.d.b.a.a;
import com.discord.utilities.error.Error;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildRoleSubscriptionPlanSetupViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildRoleSubscriptionPlanSetupViewModel$Event$SubmitFailure extends GuildRoleSubscriptionPlanSetupViewModel$Event {
    private final Error error;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionPlanSetupViewModel$Event$SubmitFailure(Error error) {
        super(null);
        m.checkNotNullParameter(error, "error");
        this.error = error;
    }

    public static /* synthetic */ GuildRoleSubscriptionPlanSetupViewModel$Event$SubmitFailure copy$default(GuildRoleSubscriptionPlanSetupViewModel$Event$SubmitFailure guildRoleSubscriptionPlanSetupViewModel$Event$SubmitFailure, Error error, int i, Object obj) {
        if ((i & 1) != 0) {
            error = guildRoleSubscriptionPlanSetupViewModel$Event$SubmitFailure.error;
        }
        return guildRoleSubscriptionPlanSetupViewModel$Event$SubmitFailure.copy(error);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Error getError() {
        return this.error;
    }

    public final GuildRoleSubscriptionPlanSetupViewModel$Event$SubmitFailure copy(Error error) {
        m.checkNotNullParameter(error, "error");
        return new GuildRoleSubscriptionPlanSetupViewModel$Event$SubmitFailure(error);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildRoleSubscriptionPlanSetupViewModel$Event$SubmitFailure) && m.areEqual(this.error, ((GuildRoleSubscriptionPlanSetupViewModel$Event$SubmitFailure) other).error);
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
