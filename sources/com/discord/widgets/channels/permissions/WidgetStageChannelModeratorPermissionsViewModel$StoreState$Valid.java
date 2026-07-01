package com.discord.widgets.channels.permissions;

import b.d.b.a.a;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import d0.z.d.m;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetStageChannelModeratorPermissionsViewModel$StoreState$Valid extends WidgetStageChannelModeratorPermissionsViewModel$StoreState {
    private final boolean canEditModerators;
    private final List<PermissionOverwrite> channelPermissionOverwrites;
    private final Guild guild;
    private final Map<Long, GuildMember> guildMembers;
    private final User guildOwnerUser;
    private final Map<Long, GuildRole> guildRoles;
    private final Map<Long, User> usersWithOverwrites;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetStageChannelModeratorPermissionsViewModel$StoreState$Valid(Guild guild, List<PermissionOverwrite> list, Map<Long, GuildRole> map, Map<Long, ? extends User> map2, Map<Long, GuildMember> map3, User user, boolean z2) {
        super(null);
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(list, "channelPermissionOverwrites");
        m.checkNotNullParameter(map, "guildRoles");
        m.checkNotNullParameter(map2, "usersWithOverwrites");
        m.checkNotNullParameter(map3, "guildMembers");
        this.guild = guild;
        this.channelPermissionOverwrites = list;
        this.guildRoles = map;
        this.usersWithOverwrites = map2;
        this.guildMembers = map3;
        this.guildOwnerUser = user;
        this.canEditModerators = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetStageChannelModeratorPermissionsViewModel$StoreState$Valid copy$default(WidgetStageChannelModeratorPermissionsViewModel$StoreState$Valid widgetStageChannelModeratorPermissionsViewModel$StoreState$Valid, Guild guild, List list, Map map, Map map2, Map map3, User user, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = widgetStageChannelModeratorPermissionsViewModel$StoreState$Valid.guild;
        }
        if ((i & 2) != 0) {
            list = widgetStageChannelModeratorPermissionsViewModel$StoreState$Valid.channelPermissionOverwrites;
        }
        List list2 = list;
        if ((i & 4) != 0) {
            map = widgetStageChannelModeratorPermissionsViewModel$StoreState$Valid.guildRoles;
        }
        Map map4 = map;
        if ((i & 8) != 0) {
            map2 = widgetStageChannelModeratorPermissionsViewModel$StoreState$Valid.usersWithOverwrites;
        }
        Map map5 = map2;
        if ((i & 16) != 0) {
            map3 = widgetStageChannelModeratorPermissionsViewModel$StoreState$Valid.guildMembers;
        }
        Map map6 = map3;
        if ((i & 32) != 0) {
            user = widgetStageChannelModeratorPermissionsViewModel$StoreState$Valid.guildOwnerUser;
        }
        User user2 = user;
        if ((i & 64) != 0) {
            z2 = widgetStageChannelModeratorPermissionsViewModel$StoreState$Valid.canEditModerators;
        }
        return widgetStageChannelModeratorPermissionsViewModel$StoreState$Valid.copy(guild, list2, map4, map5, map6, user2, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final List<PermissionOverwrite> component2() {
        return this.channelPermissionOverwrites;
    }

    public final Map<Long, GuildRole> component3() {
        return this.guildRoles;
    }

    public final Map<Long, User> component4() {
        return this.usersWithOverwrites;
    }

    public final Map<Long, GuildMember> component5() {
        return this.guildMembers;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final User getGuildOwnerUser() {
        return this.guildOwnerUser;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getCanEditModerators() {
        return this.canEditModerators;
    }

    public final WidgetStageChannelModeratorPermissionsViewModel$StoreState$Valid copy(Guild guild, List<PermissionOverwrite> channelPermissionOverwrites, Map<Long, GuildRole> guildRoles, Map<Long, ? extends User> usersWithOverwrites, Map<Long, GuildMember> guildMembers, User guildOwnerUser, boolean canEditModerators) {
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(channelPermissionOverwrites, "channelPermissionOverwrites");
        m.checkNotNullParameter(guildRoles, "guildRoles");
        m.checkNotNullParameter(usersWithOverwrites, "usersWithOverwrites");
        m.checkNotNullParameter(guildMembers, "guildMembers");
        return new WidgetStageChannelModeratorPermissionsViewModel$StoreState$Valid(guild, channelPermissionOverwrites, guildRoles, usersWithOverwrites, guildMembers, guildOwnerUser, canEditModerators);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetStageChannelModeratorPermissionsViewModel$StoreState$Valid)) {
            return false;
        }
        WidgetStageChannelModeratorPermissionsViewModel$StoreState$Valid widgetStageChannelModeratorPermissionsViewModel$StoreState$Valid = (WidgetStageChannelModeratorPermissionsViewModel$StoreState$Valid) other;
        return m.areEqual(this.guild, widgetStageChannelModeratorPermissionsViewModel$StoreState$Valid.guild) && m.areEqual(this.channelPermissionOverwrites, widgetStageChannelModeratorPermissionsViewModel$StoreState$Valid.channelPermissionOverwrites) && m.areEqual(this.guildRoles, widgetStageChannelModeratorPermissionsViewModel$StoreState$Valid.guildRoles) && m.areEqual(this.usersWithOverwrites, widgetStageChannelModeratorPermissionsViewModel$StoreState$Valid.usersWithOverwrites) && m.areEqual(this.guildMembers, widgetStageChannelModeratorPermissionsViewModel$StoreState$Valid.guildMembers) && m.areEqual(this.guildOwnerUser, widgetStageChannelModeratorPermissionsViewModel$StoreState$Valid.guildOwnerUser) && this.canEditModerators == widgetStageChannelModeratorPermissionsViewModel$StoreState$Valid.canEditModerators;
    }

    public final boolean getCanEditModerators() {
        return this.canEditModerators;
    }

    public final List<PermissionOverwrite> getChannelPermissionOverwrites() {
        return this.channelPermissionOverwrites;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final Map<Long, GuildMember> getGuildMembers() {
        return this.guildMembers;
    }

    public final User getGuildOwnerUser() {
        return this.guildOwnerUser;
    }

    public final Map<Long, GuildRole> getGuildRoles() {
        return this.guildRoles;
    }

    public final Map<Long, User> getUsersWithOverwrites() {
        return this.usersWithOverwrites;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        List<PermissionOverwrite> list = this.channelPermissionOverwrites;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        Map<Long, GuildRole> map = this.guildRoles;
        int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, User> map2 = this.usersWithOverwrites;
        int iHashCode4 = (iHashCode3 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, GuildMember> map3 = this.guildMembers;
        int iHashCode5 = (iHashCode4 + (map3 != null ? map3.hashCode() : 0)) * 31;
        User user = this.guildOwnerUser;
        int iHashCode6 = (iHashCode5 + (user != null ? user.hashCode() : 0)) * 31;
        boolean z2 = this.canEditModerators;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode6 + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("Valid(guild=");
        sbU.append(this.guild);
        sbU.append(", channelPermissionOverwrites=");
        sbU.append(this.channelPermissionOverwrites);
        sbU.append(", guildRoles=");
        sbU.append(this.guildRoles);
        sbU.append(", usersWithOverwrites=");
        sbU.append(this.usersWithOverwrites);
        sbU.append(", guildMembers=");
        sbU.append(this.guildMembers);
        sbU.append(", guildOwnerUser=");
        sbU.append(this.guildOwnerUser);
        sbU.append(", canEditModerators=");
        return a.O(sbU, this.canEditModerators, ")");
    }
}
