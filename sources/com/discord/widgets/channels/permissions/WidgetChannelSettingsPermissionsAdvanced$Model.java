package com.discord.widgets.channels.permissions;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite$Type;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.channels.SimpleMembersAdapter$MemberItem;
import com.discord.widgets.channels.SimpleRolesAdapter$RoleItem;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelSettingsPermissionsAdvanced$Model {
    public static final WidgetChannelSettingsPermissionsAdvanced$Model$Companion Companion = new WidgetChannelSettingsPermissionsAdvanced$Model$Companion(null);
    private final boolean canAddRole;
    private final boolean canManage;
    private final Channel channel;
    private final Guild guild;
    private final Map<Long, GuildRole> guildRoles;
    private final MeUser me;
    private final List<SimpleMembersAdapter$MemberItem> memberItems;
    private final long myPermissions;
    private final List<SimpleRolesAdapter$RoleItem> roleItems;

    public WidgetChannelSettingsPermissionsAdvanced$Model(MeUser meUser, Guild guild, Channel channel, long j, Map<Long, GuildRole> map, List<SimpleMembersAdapter$MemberItem> list) {
        m.checkNotNullParameter(meUser, "me");
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(map, "guildRoles");
        m.checkNotNullParameter(list, "memberItems");
        this.me = meUser;
        this.guild = guild;
        this.channel = channel;
        this.myPermissions = j;
        this.guildRoles = map;
        this.memberItems = list;
        this.canManage = guild.getOwnerId() == meUser.getId() || PermissionUtils.canAndIsElevated(Permission.MANAGE_ROLES, Long.valueOf(j), meUser.getMfaEnabled(), guild.getMfaLevel()) || PermissionUtils.canAndIsElevated(8L, Long.valueOf(j), meUser.getMfaEnabled(), guild.getMfaLevel());
        List<SimpleRolesAdapter$RoleItem> listBuildRoleItems = buildRoleItems();
        this.roleItems = listBuildRoleItems;
        this.canAddRole = map.size() > listBuildRoleItems.size();
    }

    private final List<SimpleRolesAdapter$RoleItem> buildRoleItems() {
        ArrayList arrayList = new ArrayList();
        Iterator it = WidgetChannelSettingsPermissionsAdvanced$Model$Companion.access$getOverwriteIds(Companion, this.channel, PermissionOverwrite$Type.ROLE).iterator();
        while (it.hasNext()) {
            GuildRole guildRole = this.guildRoles.get(Long.valueOf(((Number) it.next()).longValue()));
            if (guildRole != null) {
                arrayList.add(new SimpleRolesAdapter$RoleItem(guildRole));
            }
        }
        return u.sorted(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChannelSettingsPermissionsAdvanced$Model copy$default(WidgetChannelSettingsPermissionsAdvanced$Model widgetChannelSettingsPermissionsAdvanced$Model, MeUser meUser, Guild guild, Channel channel, long j, Map map, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            meUser = widgetChannelSettingsPermissionsAdvanced$Model.me;
        }
        if ((i & 2) != 0) {
            guild = widgetChannelSettingsPermissionsAdvanced$Model.guild;
        }
        Guild guild2 = guild;
        if ((i & 4) != 0) {
            channel = widgetChannelSettingsPermissionsAdvanced$Model.channel;
        }
        Channel channel2 = channel;
        if ((i & 8) != 0) {
            j = widgetChannelSettingsPermissionsAdvanced$Model.myPermissions;
        }
        long j2 = j;
        if ((i & 16) != 0) {
            map = widgetChannelSettingsPermissionsAdvanced$Model.guildRoles;
        }
        Map map2 = map;
        if ((i & 32) != 0) {
            list = widgetChannelSettingsPermissionsAdvanced$Model.memberItems;
        }
        return widgetChannelSettingsPermissionsAdvanced$Model.copy(meUser, guild2, channel2, j2, map2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MeUser getMe() {
        return this.me;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getMyPermissions() {
        return this.myPermissions;
    }

    public final Map<Long, GuildRole> component5() {
        return this.guildRoles;
    }

    public final List<SimpleMembersAdapter$MemberItem> component6() {
        return this.memberItems;
    }

    public final WidgetChannelSettingsPermissionsAdvanced$Model copy(MeUser me2, Guild guild, Channel channel, long myPermissions, Map<Long, GuildRole> guildRoles, List<SimpleMembersAdapter$MemberItem> memberItems) {
        m.checkNotNullParameter(me2, "me");
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(guildRoles, "guildRoles");
        m.checkNotNullParameter(memberItems, "memberItems");
        return new WidgetChannelSettingsPermissionsAdvanced$Model(me2, guild, channel, myPermissions, guildRoles, memberItems);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelSettingsPermissionsAdvanced$Model)) {
            return false;
        }
        WidgetChannelSettingsPermissionsAdvanced$Model widgetChannelSettingsPermissionsAdvanced$Model = (WidgetChannelSettingsPermissionsAdvanced$Model) other;
        return m.areEqual(this.me, widgetChannelSettingsPermissionsAdvanced$Model.me) && m.areEqual(this.guild, widgetChannelSettingsPermissionsAdvanced$Model.guild) && m.areEqual(this.channel, widgetChannelSettingsPermissionsAdvanced$Model.channel) && this.myPermissions == widgetChannelSettingsPermissionsAdvanced$Model.myPermissions && m.areEqual(this.guildRoles, widgetChannelSettingsPermissionsAdvanced$Model.guildRoles) && m.areEqual(this.memberItems, widgetChannelSettingsPermissionsAdvanced$Model.memberItems);
    }

    public final boolean getCanAddRole() {
        return this.canAddRole;
    }

    public final boolean getCanManage() {
        return this.canManage;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final Map<Long, GuildRole> getGuildRoles() {
        return this.guildRoles;
    }

    public final MeUser getMe() {
        return this.me;
    }

    public final List<SimpleMembersAdapter$MemberItem> getMemberItems() {
        return this.memberItems;
    }

    public final long getMyPermissions() {
        return this.myPermissions;
    }

    public final List<SimpleRolesAdapter$RoleItem> getRoleItems() {
        return this.roleItems;
    }

    public int hashCode() {
        MeUser meUser = this.me;
        int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
        Guild guild = this.guild;
        int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
        Channel channel = this.channel;
        int iA = (b.a(this.myPermissions) + ((iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31)) * 31;
        Map<Long, GuildRole> map = this.guildRoles;
        int iHashCode3 = (iA + (map != null ? map.hashCode() : 0)) * 31;
        List<SimpleMembersAdapter$MemberItem> list = this.memberItems;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(me=");
        sbU.append(this.me);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", myPermissions=");
        sbU.append(this.myPermissions);
        sbU.append(", guildRoles=");
        sbU.append(this.guildRoles);
        sbU.append(", memberItems=");
        return a.L(sbU, this.memberItems, ")");
    }
}
