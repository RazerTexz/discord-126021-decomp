package com.discord.widgets.channels.memberlist.adapter;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChannelMembersListAdapter$Item$RoleHeader extends ChannelMembersListAdapter$Item {
    private final Long guildId;
    private final int memberCount;
    private final long roleId;
    private final String roleName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListAdapter$Item$RoleHeader(long j, String str, int i, Long l) {
        super(ChannelMembersListAdapter$ViewType.ROLE_HEADER, Long.valueOf(j), null);
        m.checkNotNullParameter(str, "roleName");
        this.roleId = j;
        this.roleName = str;
        this.memberCount = i;
        this.guildId = l;
    }

    public static /* synthetic */ ChannelMembersListAdapter$Item$RoleHeader copy$default(ChannelMembersListAdapter$Item$RoleHeader channelMembersListAdapter$Item$RoleHeader, long j, String str, int i, Long l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = channelMembersListAdapter$Item$RoleHeader.roleId;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            str = channelMembersListAdapter$Item$RoleHeader.roleName;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            i = channelMembersListAdapter$Item$RoleHeader.memberCount;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            l = channelMembersListAdapter$Item$RoleHeader.guildId;
        }
        return channelMembersListAdapter$Item$RoleHeader.copy(j2, str2, i3, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getRoleId() {
        return this.roleId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRoleName() {
        return this.roleName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getMemberCount() {
        return this.memberCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    public final ChannelMembersListAdapter$Item$RoleHeader copy(long roleId, String roleName, int memberCount, Long guildId) {
        m.checkNotNullParameter(roleName, "roleName");
        return new ChannelMembersListAdapter$Item$RoleHeader(roleId, roleName, memberCount, guildId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelMembersListAdapter$Item$RoleHeader)) {
            return false;
        }
        ChannelMembersListAdapter$Item$RoleHeader channelMembersListAdapter$Item$RoleHeader = (ChannelMembersListAdapter$Item$RoleHeader) other;
        return this.roleId == channelMembersListAdapter$Item$RoleHeader.roleId && m.areEqual(this.roleName, channelMembersListAdapter$Item$RoleHeader.roleName) && this.memberCount == channelMembersListAdapter$Item$RoleHeader.memberCount && m.areEqual(this.guildId, channelMembersListAdapter$Item$RoleHeader.guildId);
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final int getMemberCount() {
        return this.memberCount;
    }

    public final long getRoleId() {
        return this.roleId;
    }

    public final String getRoleName() {
        return this.roleName;
    }

    public int hashCode() {
        int iA = b.a(this.roleId) * 31;
        String str = this.roleName;
        int iHashCode = (((iA + (str != null ? str.hashCode() : 0)) * 31) + this.memberCount) * 31;
        Long l = this.guildId;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("RoleHeader(roleId=");
        sbU.append(this.roleId);
        sbU.append(", roleName=");
        sbU.append(this.roleName);
        sbU.append(", memberCount=");
        sbU.append(this.memberCount);
        sbU.append(", guildId=");
        return a.G(sbU, this.guildId, ")");
    }
}
