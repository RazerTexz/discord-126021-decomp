package com.discord.widgets.servers.role_members;

import b.d.b.a.a;
import com.discord.api.role.GuildRole;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ServerSettingsRoleMembersViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ServerSettingsRoleMembersViewModel$ViewState$Loaded extends ServerSettingsRoleMembersViewModel$ViewState {
    private final boolean isUpdating;
    private final List<ServerSettingsRoleMemberAdapterItem> memberList;
    private final GuildRole role;

    public /* synthetic */ ServerSettingsRoleMembersViewModel$ViewState$Loaded(boolean z2, List list, GuildRole guildRole, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2, list, guildRole);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ServerSettingsRoleMembersViewModel$ViewState$Loaded copy$default(ServerSettingsRoleMembersViewModel$ViewState$Loaded serverSettingsRoleMembersViewModel$ViewState$Loaded, boolean z2, List list, GuildRole guildRole, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = serverSettingsRoleMembersViewModel$ViewState$Loaded.isUpdating;
        }
        if ((i & 2) != 0) {
            list = serverSettingsRoleMembersViewModel$ViewState$Loaded.memberList;
        }
        if ((i & 4) != 0) {
            guildRole = serverSettingsRoleMembersViewModel$ViewState$Loaded.role;
        }
        return serverSettingsRoleMembersViewModel$ViewState$Loaded.copy(z2, list, guildRole);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsUpdating() {
        return this.isUpdating;
    }

    public final List<ServerSettingsRoleMemberAdapterItem> component2() {
        return this.memberList;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final GuildRole getRole() {
        return this.role;
    }

    public final ServerSettingsRoleMembersViewModel$ViewState$Loaded copy(boolean isUpdating, List<ServerSettingsRoleMemberAdapterItem> memberList, GuildRole role) {
        m.checkNotNullParameter(memberList, "memberList");
        m.checkNotNullParameter(role, "role");
        return new ServerSettingsRoleMembersViewModel$ViewState$Loaded(isUpdating, memberList, role);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServerSettingsRoleMembersViewModel$ViewState$Loaded)) {
            return false;
        }
        ServerSettingsRoleMembersViewModel$ViewState$Loaded serverSettingsRoleMembersViewModel$ViewState$Loaded = (ServerSettingsRoleMembersViewModel$ViewState$Loaded) other;
        return this.isUpdating == serverSettingsRoleMembersViewModel$ViewState$Loaded.isUpdating && m.areEqual(this.memberList, serverSettingsRoleMembersViewModel$ViewState$Loaded.memberList) && m.areEqual(this.role, serverSettingsRoleMembersViewModel$ViewState$Loaded.role);
    }

    public final List<ServerSettingsRoleMemberAdapterItem> getMemberList() {
        return this.memberList;
    }

    public final GuildRole getRole() {
        return this.role;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z2 = this.isUpdating;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        List<ServerSettingsRoleMemberAdapterItem> list = this.memberList;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        GuildRole guildRole = this.role;
        return iHashCode + (guildRole != null ? guildRole.hashCode() : 0);
    }

    public final boolean isUpdating() {
        return this.isUpdating;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(isUpdating=");
        sbU.append(this.isUpdating);
        sbU.append(", memberList=");
        sbU.append(this.memberList);
        sbU.append(", role=");
        sbU.append(this.role);
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsRoleMembersViewModel$ViewState$Loaded(boolean z2, List<ServerSettingsRoleMemberAdapterItem> list, GuildRole guildRole) {
        super(null);
        m.checkNotNullParameter(list, "memberList");
        m.checkNotNullParameter(guildRole, "role");
        this.isUpdating = z2;
        this.memberList = list;
        this.role = guildRole;
    }
}
