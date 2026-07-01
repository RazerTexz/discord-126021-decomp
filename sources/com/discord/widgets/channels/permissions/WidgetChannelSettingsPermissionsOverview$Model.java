package com.discord.widgets.channels.permissions;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.utilities.permissions.PermissionUtils;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelSettingsPermissionsOverview$Model {
    public static final WidgetChannelSettingsPermissionsOverview$Model$Companion Companion = new WidgetChannelSettingsPermissionsOverview$Model$Companion(null);
    private final boolean canManage;
    private final Channel channel;
    private final Guild guild;
    private final Map<Long, GuildRole> guildRoles;
    private final MeUser me;
    private final long myPermissions;

    public WidgetChannelSettingsPermissionsOverview$Model(MeUser meUser, Guild guild, Channel channel, long j, Map<Long, GuildRole> map) {
        m.checkNotNullParameter(meUser, "me");
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(map, "guildRoles");
        this.me = meUser;
        this.guild = guild;
        this.channel = channel;
        this.myPermissions = j;
        this.guildRoles = map;
        this.canManage = guild.getOwnerId() == meUser.getId() || PermissionUtils.canAndIsElevated(Permission.MANAGE_ROLES, Long.valueOf(j), meUser.getMfaEnabled(), guild.getMfaLevel()) || PermissionUtils.canAndIsElevated(8L, Long.valueOf(j), meUser.getMfaEnabled(), guild.getMfaLevel());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChannelSettingsPermissionsOverview$Model copy$default(WidgetChannelSettingsPermissionsOverview$Model widgetChannelSettingsPermissionsOverview$Model, MeUser meUser, Guild guild, Channel channel, long j, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            meUser = widgetChannelSettingsPermissionsOverview$Model.me;
        }
        if ((i & 2) != 0) {
            guild = widgetChannelSettingsPermissionsOverview$Model.guild;
        }
        Guild guild2 = guild;
        if ((i & 4) != 0) {
            channel = widgetChannelSettingsPermissionsOverview$Model.channel;
        }
        Channel channel2 = channel;
        if ((i & 8) != 0) {
            j = widgetChannelSettingsPermissionsOverview$Model.myPermissions;
        }
        long j2 = j;
        if ((i & 16) != 0) {
            map = widgetChannelSettingsPermissionsOverview$Model.guildRoles;
        }
        return widgetChannelSettingsPermissionsOverview$Model.copy(meUser, guild2, channel2, j2, map);
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

    public final WidgetChannelSettingsPermissionsOverview$Model copy(MeUser me2, Guild guild, Channel channel, long myPermissions, Map<Long, GuildRole> guildRoles) {
        m.checkNotNullParameter(me2, "me");
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(guildRoles, "guildRoles");
        return new WidgetChannelSettingsPermissionsOverview$Model(me2, guild, channel, myPermissions, guildRoles);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelSettingsPermissionsOverview$Model)) {
            return false;
        }
        WidgetChannelSettingsPermissionsOverview$Model widgetChannelSettingsPermissionsOverview$Model = (WidgetChannelSettingsPermissionsOverview$Model) other;
        return m.areEqual(this.me, widgetChannelSettingsPermissionsOverview$Model.me) && m.areEqual(this.guild, widgetChannelSettingsPermissionsOverview$Model.guild) && m.areEqual(this.channel, widgetChannelSettingsPermissionsOverview$Model.channel) && this.myPermissions == widgetChannelSettingsPermissionsOverview$Model.myPermissions && m.areEqual(this.guildRoles, widgetChannelSettingsPermissionsOverview$Model.guildRoles);
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

    public final long getMyPermissions() {
        return this.myPermissions;
    }

    public int hashCode() {
        MeUser meUser = this.me;
        int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
        Guild guild = this.guild;
        int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
        Channel channel = this.channel;
        int iA = (b.a(this.myPermissions) + ((iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31)) * 31;
        Map<Long, GuildRole> map = this.guildRoles;
        return iA + (map != null ? map.hashCode() : 0);
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
        return a.M(sbU, this.guildRoles, ")");
    }
}
