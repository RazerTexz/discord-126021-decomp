package com.discord.widgets.servers.role_members;

import b.d.b.a.a;
import com.discord.api.role.GuildRole;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import d0.z.d.m;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ServerSettingsRoleMembersViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ServerSettingsRoleMembersViewModel$StoreState {
    private final List<GuildMember> guildMembers;
    private final GuildRole role;
    private final Map<Long, User> users;

    /* JADX WARN: Multi-variable type inference failed */
    public ServerSettingsRoleMembersViewModel$StoreState(List<GuildMember> list, Map<Long, ? extends User> map, GuildRole guildRole) {
        m.checkNotNullParameter(list, "guildMembers");
        m.checkNotNullParameter(map, "users");
        this.guildMembers = list;
        this.users = map;
        this.role = guildRole;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ServerSettingsRoleMembersViewModel$StoreState copy$default(ServerSettingsRoleMembersViewModel$StoreState serverSettingsRoleMembersViewModel$StoreState, List list, Map map, GuildRole guildRole, int i, Object obj) {
        if ((i & 1) != 0) {
            list = serverSettingsRoleMembersViewModel$StoreState.guildMembers;
        }
        if ((i & 2) != 0) {
            map = serverSettingsRoleMembersViewModel$StoreState.users;
        }
        if ((i & 4) != 0) {
            guildRole = serverSettingsRoleMembersViewModel$StoreState.role;
        }
        return serverSettingsRoleMembersViewModel$StoreState.copy(list, map, guildRole);
    }

    public final List<GuildMember> component1() {
        return this.guildMembers;
    }

    public final Map<Long, User> component2() {
        return this.users;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final GuildRole getRole() {
        return this.role;
    }

    public final ServerSettingsRoleMembersViewModel$StoreState copy(List<GuildMember> guildMembers, Map<Long, ? extends User> users, GuildRole role) {
        m.checkNotNullParameter(guildMembers, "guildMembers");
        m.checkNotNullParameter(users, "users");
        return new ServerSettingsRoleMembersViewModel$StoreState(guildMembers, users, role);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServerSettingsRoleMembersViewModel$StoreState)) {
            return false;
        }
        ServerSettingsRoleMembersViewModel$StoreState serverSettingsRoleMembersViewModel$StoreState = (ServerSettingsRoleMembersViewModel$StoreState) other;
        return m.areEqual(this.guildMembers, serverSettingsRoleMembersViewModel$StoreState.guildMembers) && m.areEqual(this.users, serverSettingsRoleMembersViewModel$StoreState.users) && m.areEqual(this.role, serverSettingsRoleMembersViewModel$StoreState.role);
    }

    public final List<GuildMember> getGuildMembers() {
        return this.guildMembers;
    }

    public final GuildRole getRole() {
        return this.role;
    }

    public final Map<Long, User> getUsers() {
        return this.users;
    }

    public int hashCode() {
        List<GuildMember> list = this.guildMembers;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        Map<Long, User> map = this.users;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        GuildRole guildRole = this.role;
        return iHashCode2 + (guildRole != null ? guildRole.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(guildMembers=");
        sbU.append(this.guildMembers);
        sbU.append(", users=");
        sbU.append(this.users);
        sbU.append(", role=");
        sbU.append(this.role);
        sbU.append(")");
        return sbU.toString();
    }
}
