package com.discord.widgets.servers.role_members;

import b.d.b.a.a;
import com.discord.utilities.error.Error;
import d0.z.d.m;

/* JADX INFO: compiled from: ServerSettingsRoleMembersViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ServerSettingsRoleMembersViewModel$Event$RemoveMemberFailure extends ServerSettingsRoleMembersViewModel$Event {
    private final Error error;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsRoleMembersViewModel$Event$RemoveMemberFailure(Error error) {
        super(null);
        m.checkNotNullParameter(error, "error");
        this.error = error;
    }

    public static /* synthetic */ ServerSettingsRoleMembersViewModel$Event$RemoveMemberFailure copy$default(ServerSettingsRoleMembersViewModel$Event$RemoveMemberFailure serverSettingsRoleMembersViewModel$Event$RemoveMemberFailure, Error error, int i, Object obj) {
        if ((i & 1) != 0) {
            error = serverSettingsRoleMembersViewModel$Event$RemoveMemberFailure.error;
        }
        return serverSettingsRoleMembersViewModel$Event$RemoveMemberFailure.copy(error);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Error getError() {
        return this.error;
    }

    public final ServerSettingsRoleMembersViewModel$Event$RemoveMemberFailure copy(Error error) {
        m.checkNotNullParameter(error, "error");
        return new ServerSettingsRoleMembersViewModel$Event$RemoveMemberFailure(error);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ServerSettingsRoleMembersViewModel$Event$RemoveMemberFailure) && m.areEqual(this.error, ((ServerSettingsRoleMembersViewModel$Event$RemoveMemberFailure) other).error);
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
        StringBuilder sbU = a.U("RemoveMemberFailure(error=");
        sbU.append(this.error);
        sbU.append(")");
        return sbU.toString();
    }
}
