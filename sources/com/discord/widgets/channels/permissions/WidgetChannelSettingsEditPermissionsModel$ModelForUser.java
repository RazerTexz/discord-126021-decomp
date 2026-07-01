package com.discord.widgets.channels.permissions;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelSettingsEditPermissionsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelSettingsEditPermissionsModel$ModelForUser extends WidgetChannelSettingsEditPermissionsModel {
    private final Channel channel;
    private final GuildMember guildMember;
    private final boolean isMe;
    private final long myPermissionsForChannel;
    private final boolean useNewThreadsPermissions;
    private final User user;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsEditPermissionsModel$ModelForUser(Channel channel, long j, boolean z2, User user, GuildMember guildMember, boolean z3) {
        super(channel, user.getId(), 0, z3, null);
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(user, "user");
        this.channel = channel;
        this.myPermissionsForChannel = j;
        this.isMe = z2;
        this.user = user;
        this.guildMember = guildMember;
        this.useNewThreadsPermissions = z3;
    }

    public static /* synthetic */ WidgetChannelSettingsEditPermissionsModel$ModelForUser copy$default(WidgetChannelSettingsEditPermissionsModel$ModelForUser widgetChannelSettingsEditPermissionsModel$ModelForUser, Channel channel, long j, boolean z2, User user, GuildMember guildMember, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = widgetChannelSettingsEditPermissionsModel$ModelForUser.getChannel();
        }
        if ((i & 2) != 0) {
            j = widgetChannelSettingsEditPermissionsModel$ModelForUser.myPermissionsForChannel;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            z2 = widgetChannelSettingsEditPermissionsModel$ModelForUser.isMe;
        }
        boolean z4 = z2;
        if ((i & 8) != 0) {
            user = widgetChannelSettingsEditPermissionsModel$ModelForUser.user;
        }
        User user2 = user;
        if ((i & 16) != 0) {
            guildMember = widgetChannelSettingsEditPermissionsModel$ModelForUser.guildMember;
        }
        GuildMember guildMember2 = guildMember;
        if ((i & 32) != 0) {
            z3 = widgetChannelSettingsEditPermissionsModel$ModelForUser.getUseNewThreadsPermissions();
        }
        return widgetChannelSettingsEditPermissionsModel$ModelForUser.copy(channel, j2, z4, user2, guildMember2, z3);
    }

    public final Channel component1() {
        return getChannel();
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getMyPermissionsForChannel() {
        return this.myPermissionsForChannel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsMe() {
        return this.isMe;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final boolean component6() {
        return getUseNewThreadsPermissions();
    }

    public final WidgetChannelSettingsEditPermissionsModel$ModelForUser copy(Channel channel, long myPermissionsForChannel, boolean isMe, User user, GuildMember guildMember, boolean useNewThreadsPermissions) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(user, "user");
        return new WidgetChannelSettingsEditPermissionsModel$ModelForUser(channel, myPermissionsForChannel, isMe, user, guildMember, useNewThreadsPermissions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelSettingsEditPermissionsModel$ModelForUser)) {
            return false;
        }
        WidgetChannelSettingsEditPermissionsModel$ModelForUser widgetChannelSettingsEditPermissionsModel$ModelForUser = (WidgetChannelSettingsEditPermissionsModel$ModelForUser) other;
        return m.areEqual(getChannel(), widgetChannelSettingsEditPermissionsModel$ModelForUser.getChannel()) && this.myPermissionsForChannel == widgetChannelSettingsEditPermissionsModel$ModelForUser.myPermissionsForChannel && this.isMe == widgetChannelSettingsEditPermissionsModel$ModelForUser.isMe && m.areEqual(this.user, widgetChannelSettingsEditPermissionsModel$ModelForUser.user) && m.areEqual(this.guildMember, widgetChannelSettingsEditPermissionsModel$ModelForUser.guildMember) && getUseNewThreadsPermissions() == widgetChannelSettingsEditPermissionsModel$ModelForUser.getUseNewThreadsPermissions();
    }

    @Override // com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel
    public Channel getChannel() {
        return this.channel;
    }

    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final long getMyPermissionsForChannel() {
        return this.myPermissionsForChannel;
    }

    @Override // com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel
    public boolean getUseNewThreadsPermissions() {
        return this.useNewThreadsPermissions;
    }

    public final User getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Channel channel = getChannel();
        int iA = (b.a(this.myPermissionsForChannel) + ((channel != null ? channel.hashCode() : 0) * 31)) * 31;
        boolean z2 = this.isMe;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = (iA + r0) * 31;
        User user = this.user;
        int iHashCode = (i + (user != null ? user.hashCode() : 0)) * 31;
        GuildMember guildMember = this.guildMember;
        int iHashCode2 = (iHashCode + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        boolean useNewThreadsPermissions = getUseNewThreadsPermissions();
        return iHashCode2 + (useNewThreadsPermissions ? 1 : useNewThreadsPermissions);
    }

    public final boolean isMe() {
        return this.isMe;
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelForUser(channel=");
        sbU.append(getChannel());
        sbU.append(", myPermissionsForChannel=");
        sbU.append(this.myPermissionsForChannel);
        sbU.append(", isMe=");
        sbU.append(this.isMe);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(", guildMember=");
        sbU.append(this.guildMember);
        sbU.append(", useNewThreadsPermissions=");
        sbU.append(getUseNewThreadsPermissions());
        sbU.append(")");
        return sbU.toString();
    }
}
