package com.discord.widgets.servers.role_members;

import b.d.b.a.outline;
import com.discord.models.member.GuildMember;
import com.discord.utilities.recycler.DiffKeyProvider;
import com.discord.widgets.channels.permissions.PermissionOwner;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: ServerSettingsRoleMemberAdapterItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ServerSettingsRoleMemberAdapterItem implements DiffKeyProvider {
    private final GuildMember guildMember;
    private final String key;
    private final PermissionOwner.Member permissionOwner;

    public ServerSettingsRoleMemberAdapterItem(GuildMember guildMember, PermissionOwner.Member member) {
        Intrinsics3.checkNotNullParameter(guildMember, "guildMember");
        Intrinsics3.checkNotNullParameter(member, "permissionOwner");
        this.guildMember = guildMember;
        this.permissionOwner = member;
        this.key = String.valueOf(member.getUser().getId());
    }

    public static /* synthetic */ ServerSettingsRoleMemberAdapterItem copy$default(ServerSettingsRoleMemberAdapterItem serverSettingsRoleMemberAdapterItem, GuildMember guildMember, PermissionOwner.Member member, int i, Object obj) {
        if ((i & 1) != 0) {
            guildMember = serverSettingsRoleMemberAdapterItem.guildMember;
        }
        if ((i & 2) != 0) {
            member = serverSettingsRoleMemberAdapterItem.permissionOwner;
        }
        return serverSettingsRoleMemberAdapterItem.copy(guildMember, member);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PermissionOwner.Member getPermissionOwner() {
        return this.permissionOwner;
    }

    public final ServerSettingsRoleMemberAdapterItem copy(GuildMember guildMember, PermissionOwner.Member permissionOwner) {
        Intrinsics3.checkNotNullParameter(guildMember, "guildMember");
        Intrinsics3.checkNotNullParameter(permissionOwner, "permissionOwner");
        return new ServerSettingsRoleMemberAdapterItem(guildMember, permissionOwner);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServerSettingsRoleMemberAdapterItem)) {
            return false;
        }
        ServerSettingsRoleMemberAdapterItem serverSettingsRoleMemberAdapterItem = (ServerSettingsRoleMemberAdapterItem) other;
        return Intrinsics3.areEqual(this.guildMember, serverSettingsRoleMemberAdapterItem.guildMember) && Intrinsics3.areEqual(this.permissionOwner, serverSettingsRoleMemberAdapterItem.permissionOwner);
    }

    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    @Override // com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final PermissionOwner.Member getPermissionOwner() {
        return this.permissionOwner;
    }

    public int hashCode() {
        GuildMember guildMember = this.guildMember;
        int iHashCode = (guildMember != null ? guildMember.hashCode() : 0) * 31;
        PermissionOwner.Member member = this.permissionOwner;
        return iHashCode + (member != null ? member.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ServerSettingsRoleMemberAdapterItem(guildMember=");
        sbU.append(this.guildMember);
        sbU.append(", permissionOwner=");
        sbU.append(this.permissionOwner);
        sbU.append(")");
        return sbU.toString();
    }
}
