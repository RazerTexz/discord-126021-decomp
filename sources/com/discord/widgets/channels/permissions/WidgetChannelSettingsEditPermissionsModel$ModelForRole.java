package com.discord.widgets.channels.permissions;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelSettingsEditPermissionsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelSettingsEditPermissionsModel$ModelForRole extends WidgetChannelSettingsEditPermissionsModel {
    private final Channel channel;
    private final GuildRole guildRole;
    private final boolean isEveryoneRole;
    private final boolean meHasRole;
    private final long myPermissionsForChannel;
    private final long myPermissionsWithRoleDenied;
    private final long myPermissionsWithRoleNeutral;
    private final long targetId;
    private final boolean useNewThreadsPermissions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsEditPermissionsModel$ModelForRole(Channel channel, long j, GuildRole guildRole, long j2, long j3, long j4, boolean z2, boolean z3, boolean z4) {
        super(channel, j2, 1, z4, null);
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(guildRole, "guildRole");
        this.channel = channel;
        this.myPermissionsForChannel = j;
        this.guildRole = guildRole;
        this.targetId = j2;
        this.myPermissionsWithRoleNeutral = j3;
        this.myPermissionsWithRoleDenied = j4;
        this.meHasRole = z2;
        this.isEveryoneRole = z3;
        this.useNewThreadsPermissions = z4;
    }

    public static /* synthetic */ WidgetChannelSettingsEditPermissionsModel$ModelForRole copy$default(WidgetChannelSettingsEditPermissionsModel$ModelForRole widgetChannelSettingsEditPermissionsModel$ModelForRole, Channel channel, long j, GuildRole guildRole, long j2, long j3, long j4, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        return widgetChannelSettingsEditPermissionsModel$ModelForRole.copy((i & 1) != 0 ? widgetChannelSettingsEditPermissionsModel$ModelForRole.getChannel() : channel, (i & 2) != 0 ? widgetChannelSettingsEditPermissionsModel$ModelForRole.myPermissionsForChannel : j, (i & 4) != 0 ? widgetChannelSettingsEditPermissionsModel$ModelForRole.guildRole : guildRole, (i & 8) != 0 ? widgetChannelSettingsEditPermissionsModel$ModelForRole.getTargetId() : j2, (i & 16) != 0 ? widgetChannelSettingsEditPermissionsModel$ModelForRole.myPermissionsWithRoleNeutral : j3, (i & 32) != 0 ? widgetChannelSettingsEditPermissionsModel$ModelForRole.myPermissionsWithRoleDenied : j4, (i & 64) != 0 ? widgetChannelSettingsEditPermissionsModel$ModelForRole.meHasRole : z2, (i & 128) != 0 ? widgetChannelSettingsEditPermissionsModel$ModelForRole.isEveryoneRole : z3, (i & 256) != 0 ? widgetChannelSettingsEditPermissionsModel$ModelForRole.getUseNewThreadsPermissions() : z4);
    }

    public final boolean canDenyRolePermission(long permission) {
        return (this.myPermissionsWithRoleDenied & permission) == (permission & this.myPermissionsForChannel);
    }

    public final boolean canNeutralizeRolePermission(long permission) {
        return (this.myPermissionsWithRoleNeutral & permission) == (permission & this.myPermissionsForChannel);
    }

    public final Channel component1() {
        return getChannel();
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getMyPermissionsForChannel() {
        return this.myPermissionsForChannel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final GuildRole getGuildRole() {
        return this.guildRole;
    }

    public final long component4() {
        return getTargetId();
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getMyPermissionsWithRoleNeutral() {
        return this.myPermissionsWithRoleNeutral;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getMyPermissionsWithRoleDenied() {
        return this.myPermissionsWithRoleDenied;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getMeHasRole() {
        return this.meHasRole;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsEveryoneRole() {
        return this.isEveryoneRole;
    }

    public final boolean component9() {
        return getUseNewThreadsPermissions();
    }

    public final WidgetChannelSettingsEditPermissionsModel$ModelForRole copy(Channel channel, long myPermissionsForChannel, GuildRole guildRole, long targetId, long myPermissionsWithRoleNeutral, long myPermissionsWithRoleDenied, boolean meHasRole, boolean isEveryoneRole, boolean useNewThreadsPermissions) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(guildRole, "guildRole");
        return new WidgetChannelSettingsEditPermissionsModel$ModelForRole(channel, myPermissionsForChannel, guildRole, targetId, myPermissionsWithRoleNeutral, myPermissionsWithRoleDenied, meHasRole, isEveryoneRole, useNewThreadsPermissions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelSettingsEditPermissionsModel$ModelForRole)) {
            return false;
        }
        WidgetChannelSettingsEditPermissionsModel$ModelForRole widgetChannelSettingsEditPermissionsModel$ModelForRole = (WidgetChannelSettingsEditPermissionsModel$ModelForRole) other;
        return m.areEqual(getChannel(), widgetChannelSettingsEditPermissionsModel$ModelForRole.getChannel()) && this.myPermissionsForChannel == widgetChannelSettingsEditPermissionsModel$ModelForRole.myPermissionsForChannel && m.areEqual(this.guildRole, widgetChannelSettingsEditPermissionsModel$ModelForRole.guildRole) && getTargetId() == widgetChannelSettingsEditPermissionsModel$ModelForRole.getTargetId() && this.myPermissionsWithRoleNeutral == widgetChannelSettingsEditPermissionsModel$ModelForRole.myPermissionsWithRoleNeutral && this.myPermissionsWithRoleDenied == widgetChannelSettingsEditPermissionsModel$ModelForRole.myPermissionsWithRoleDenied && this.meHasRole == widgetChannelSettingsEditPermissionsModel$ModelForRole.meHasRole && this.isEveryoneRole == widgetChannelSettingsEditPermissionsModel$ModelForRole.isEveryoneRole && getUseNewThreadsPermissions() == widgetChannelSettingsEditPermissionsModel$ModelForRole.getUseNewThreadsPermissions();
    }

    @Override // com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel
    public Channel getChannel() {
        return this.channel;
    }

    public final GuildRole getGuildRole() {
        return this.guildRole;
    }

    public final boolean getMeHasRole() {
        return this.meHasRole;
    }

    public final long getMyPermissionsForChannel() {
        return this.myPermissionsForChannel;
    }

    public final long getMyPermissionsWithRoleDenied() {
        return this.myPermissionsWithRoleDenied;
    }

    public final long getMyPermissionsWithRoleNeutral() {
        return this.myPermissionsWithRoleNeutral;
    }

    @Override // com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel
    public long getTargetId() {
        return this.targetId;
    }

    @Override // com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel
    public boolean getUseNewThreadsPermissions() {
        return this.useNewThreadsPermissions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        Channel channel = getChannel();
        int iA = (b.a(this.myPermissionsForChannel) + ((channel != null ? channel.hashCode() : 0) * 31)) * 31;
        GuildRole guildRole = this.guildRole;
        int iA2 = (b.a(this.myPermissionsWithRoleDenied) + ((b.a(this.myPermissionsWithRoleNeutral) + ((b.a(getTargetId()) + ((iA + (guildRole != null ? guildRole.hashCode() : 0)) * 31)) * 31)) * 31)) * 31;
        boolean z2 = this.meHasRole;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iA2 + r1) * 31;
        boolean z3 = this.isEveryoneRole;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean useNewThreadsPermissions = getUseNewThreadsPermissions();
        return i2 + (useNewThreadsPermissions ? 1 : useNewThreadsPermissions);
    }

    public final boolean isEveryoneRole() {
        return this.isEveryoneRole;
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelForRole(channel=");
        sbU.append(getChannel());
        sbU.append(", myPermissionsForChannel=");
        sbU.append(this.myPermissionsForChannel);
        sbU.append(", guildRole=");
        sbU.append(this.guildRole);
        sbU.append(", targetId=");
        sbU.append(getTargetId());
        sbU.append(", myPermissionsWithRoleNeutral=");
        sbU.append(this.myPermissionsWithRoleNeutral);
        sbU.append(", myPermissionsWithRoleDenied=");
        sbU.append(this.myPermissionsWithRoleDenied);
        sbU.append(", meHasRole=");
        sbU.append(this.meHasRole);
        sbU.append(", isEveryoneRole=");
        sbU.append(this.isEveryoneRole);
        sbU.append(", useNewThreadsPermissions=");
        sbU.append(getUseNewThreadsPermissions());
        sbU.append(")");
        return sbU.toString();
    }
}
