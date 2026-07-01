package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import b.d.b.a.a;
import com.discord.utilities.error.Error;
import d0.z.d.m;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionEditTierViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$DeleteFailure extends ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event {
    private final Error error;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$DeleteFailure(Error error) {
        super(null);
        m.checkNotNullParameter(error, "error");
        this.error = error;
    }

    public static /* synthetic */ ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$DeleteFailure copy$default(ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$DeleteFailure serverSettingsGuildRoleSubscriptionEditTierViewModel$Event$DeleteFailure, Error error, int i, Object obj) {
        if ((i & 1) != 0) {
            error = serverSettingsGuildRoleSubscriptionEditTierViewModel$Event$DeleteFailure.error;
        }
        return serverSettingsGuildRoleSubscriptionEditTierViewModel$Event$DeleteFailure.copy(error);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Error getError() {
        return this.error;
    }

    public final ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$DeleteFailure copy(Error error) {
        m.checkNotNullParameter(error, "error");
        return new ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$DeleteFailure(error);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$DeleteFailure) && m.areEqual(this.error, ((ServerSettingsGuildRoleSubscriptionEditTierViewModel$Event$DeleteFailure) other).error);
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
        StringBuilder sbU = a.U("DeleteFailure(error=");
        sbU.append(this.error);
        sbU.append(")");
        return sbU.toString();
    }
}
