package com.discord.widgets.channels.settings;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetTextChannelSettings$Model {
    public static final WidgetTextChannelSettings$Model$Companion Companion = new WidgetTextChannelSettings$Model$Companion(null);
    private final boolean canManageChannel;
    private final boolean canManagePermissions;
    private final Channel channel;
    private final Guild guild;
    private final boolean isCommunityGuild;
    private final boolean isPinsEnabled;
    private final boolean isPublicGuildRulesChannel;
    private final boolean isPublicGuildUpdatesChannel;

    public WidgetTextChannelSettings$Model(Guild guild, Channel channel, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(channel, "channel");
        this.guild = guild;
        this.channel = channel;
        this.canManageChannel = z2;
        this.canManagePermissions = z3;
        this.isPinsEnabled = z4;
        this.isPublicGuildRulesChannel = z5;
        this.isPublicGuildUpdatesChannel = z6;
        this.isCommunityGuild = z7;
    }

    public static /* synthetic */ WidgetTextChannelSettings$Model copy$default(WidgetTextChannelSettings$Model widgetTextChannelSettings$Model, Guild guild, Channel channel, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, Object obj) {
        return widgetTextChannelSettings$Model.copy((i & 1) != 0 ? widgetTextChannelSettings$Model.guild : guild, (i & 2) != 0 ? widgetTextChannelSettings$Model.channel : channel, (i & 4) != 0 ? widgetTextChannelSettings$Model.canManageChannel : z2, (i & 8) != 0 ? widgetTextChannelSettings$Model.canManagePermissions : z3, (i & 16) != 0 ? widgetTextChannelSettings$Model.isPinsEnabled : z4, (i & 32) != 0 ? widgetTextChannelSettings$Model.isPublicGuildRulesChannel : z5, (i & 64) != 0 ? widgetTextChannelSettings$Model.isPublicGuildUpdatesChannel : z6, (i & 128) != 0 ? widgetTextChannelSettings$Model.isCommunityGuild : z7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getCanManageChannel() {
        return this.canManageChannel;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getCanManagePermissions() {
        return this.canManagePermissions;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsPinsEnabled() {
        return this.isPinsEnabled;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsPublicGuildRulesChannel() {
        return this.isPublicGuildRulesChannel;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsPublicGuildUpdatesChannel() {
        return this.isPublicGuildUpdatesChannel;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsCommunityGuild() {
        return this.isCommunityGuild;
    }

    public final WidgetTextChannelSettings$Model copy(Guild guild, Channel channel, boolean canManageChannel, boolean canManagePermissions, boolean isPinsEnabled, boolean isPublicGuildRulesChannel, boolean isPublicGuildUpdatesChannel, boolean isCommunityGuild) {
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(channel, "channel");
        return new WidgetTextChannelSettings$Model(guild, channel, canManageChannel, canManagePermissions, isPinsEnabled, isPublicGuildRulesChannel, isPublicGuildUpdatesChannel, isCommunityGuild);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetTextChannelSettings$Model)) {
            return false;
        }
        WidgetTextChannelSettings$Model widgetTextChannelSettings$Model = (WidgetTextChannelSettings$Model) other;
        return m.areEqual(this.guild, widgetTextChannelSettings$Model.guild) && m.areEqual(this.channel, widgetTextChannelSettings$Model.channel) && this.canManageChannel == widgetTextChannelSettings$Model.canManageChannel && this.canManagePermissions == widgetTextChannelSettings$Model.canManagePermissions && this.isPinsEnabled == widgetTextChannelSettings$Model.isPinsEnabled && this.isPublicGuildRulesChannel == widgetTextChannelSettings$Model.isPublicGuildRulesChannel && this.isPublicGuildUpdatesChannel == widgetTextChannelSettings$Model.isPublicGuildUpdatesChannel && this.isCommunityGuild == widgetTextChannelSettings$Model.isCommunityGuild;
    }

    public final boolean getCanManageChannel() {
        return this.canManageChannel;
    }

    public final boolean getCanManagePermissions() {
        return this.canManagePermissions;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        Channel channel = this.channel;
        int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
        boolean z2 = this.canManageChannel;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode2 + r1) * 31;
        boolean z3 = this.canManagePermissions;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.isPinsEnabled;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        boolean z5 = this.isPublicGuildRulesChannel;
        ?? r4 = z5;
        if (z5) {
            r4 = 1;
        }
        int i4 = (i3 + r4) * 31;
        boolean z6 = this.isPublicGuildUpdatesChannel;
        ?? r5 = z6;
        if (z6) {
            r5 = 1;
        }
        int i5 = (i4 + r5) * 31;
        boolean z7 = this.isCommunityGuild;
        return i5 + (z7 ? 1 : z7);
    }

    public final boolean isCommunityGuild() {
        return this.isCommunityGuild;
    }

    public final boolean isPinsEnabled() {
        return this.isPinsEnabled;
    }

    public final boolean isPublicGuildRulesChannel() {
        return this.isPublicGuildRulesChannel;
    }

    public final boolean isPublicGuildUpdatesChannel() {
        return this.isPublicGuildUpdatesChannel;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(guild=");
        sbU.append(this.guild);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", canManageChannel=");
        sbU.append(this.canManageChannel);
        sbU.append(", canManagePermissions=");
        sbU.append(this.canManagePermissions);
        sbU.append(", isPinsEnabled=");
        sbU.append(this.isPinsEnabled);
        sbU.append(", isPublicGuildRulesChannel=");
        sbU.append(this.isPublicGuildRulesChannel);
        sbU.append(", isPublicGuildUpdatesChannel=");
        sbU.append(this.isPublicGuildUpdatesChannel);
        sbU.append(", isCommunityGuild=");
        return a.O(sbU, this.isCommunityGuild, ")");
    }
}
