package com.discord.widgets.chat.list.adapter;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.models.guild.UserGuildMember;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatListAdapterItemGuildScheduledEventInvite$Model {
    public static final WidgetChatListAdapterItemGuildScheduledEventInvite$Model$Companion Companion = new WidgetChatListAdapterItemGuildScheduledEventInvite$Model$Companion(null);
    private final boolean canConnect;
    private final boolean canShare;
    private final Channel channel;
    private final UserGuildMember creator;
    private final Guild guild;
    private final GuildScheduledEvent guildScheduledEvent;
    private final ModelInvite invite;
    private final boolean isInGuild;
    private final boolean isRsvped;
    private final Long selectedVoiceChannelId;

    public WidgetChatListAdapterItemGuildScheduledEventInvite$Model(ModelInvite modelInvite, boolean z2, boolean z3, GuildScheduledEvent guildScheduledEvent, Channel channel, Guild guild, UserGuildMember userGuildMember, Long l, boolean z4, boolean z5) {
        m.checkNotNullParameter(modelInvite, "invite");
        m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        this.invite = modelInvite;
        this.isInGuild = z2;
        this.isRsvped = z3;
        this.guildScheduledEvent = guildScheduledEvent;
        this.channel = channel;
        this.guild = guild;
        this.creator = userGuildMember;
        this.selectedVoiceChannelId = l;
        this.canConnect = z4;
        this.canShare = z5;
    }

    public static /* synthetic */ WidgetChatListAdapterItemGuildScheduledEventInvite$Model copy$default(WidgetChatListAdapterItemGuildScheduledEventInvite$Model widgetChatListAdapterItemGuildScheduledEventInvite$Model, ModelInvite modelInvite, boolean z2, boolean z3, GuildScheduledEvent guildScheduledEvent, Channel channel, Guild guild, UserGuildMember userGuildMember, Long l, boolean z4, boolean z5, int i, Object obj) {
        return widgetChatListAdapterItemGuildScheduledEventInvite$Model.copy((i & 1) != 0 ? widgetChatListAdapterItemGuildScheduledEventInvite$Model.invite : modelInvite, (i & 2) != 0 ? widgetChatListAdapterItemGuildScheduledEventInvite$Model.isInGuild : z2, (i & 4) != 0 ? widgetChatListAdapterItemGuildScheduledEventInvite$Model.isRsvped : z3, (i & 8) != 0 ? widgetChatListAdapterItemGuildScheduledEventInvite$Model.guildScheduledEvent : guildScheduledEvent, (i & 16) != 0 ? widgetChatListAdapterItemGuildScheduledEventInvite$Model.channel : channel, (i & 32) != 0 ? widgetChatListAdapterItemGuildScheduledEventInvite$Model.guild : guild, (i & 64) != 0 ? widgetChatListAdapterItemGuildScheduledEventInvite$Model.creator : userGuildMember, (i & 128) != 0 ? widgetChatListAdapterItemGuildScheduledEventInvite$Model.selectedVoiceChannelId : l, (i & 256) != 0 ? widgetChatListAdapterItemGuildScheduledEventInvite$Model.canConnect : z4, (i & 512) != 0 ? widgetChatListAdapterItemGuildScheduledEventInvite$Model.canShare : z5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelInvite getInvite() {
        return this.invite;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getCanShare() {
        return this.canShare;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsInGuild() {
        return this.isInGuild;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsRsvped() {
        return this.isRsvped;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final UserGuildMember getCreator() {
        return this.creator;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Long getSelectedVoiceChannelId() {
        return this.selectedVoiceChannelId;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getCanConnect() {
        return this.canConnect;
    }

    public final WidgetChatListAdapterItemGuildScheduledEventInvite$Model copy(ModelInvite invite, boolean isInGuild, boolean isRsvped, GuildScheduledEvent guildScheduledEvent, Channel channel, Guild guild, UserGuildMember creator, Long selectedVoiceChannelId, boolean canConnect, boolean canShare) {
        m.checkNotNullParameter(invite, "invite");
        m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        return new WidgetChatListAdapterItemGuildScheduledEventInvite$Model(invite, isInGuild, isRsvped, guildScheduledEvent, channel, guild, creator, selectedVoiceChannelId, canConnect, canShare);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatListAdapterItemGuildScheduledEventInvite$Model)) {
            return false;
        }
        WidgetChatListAdapterItemGuildScheduledEventInvite$Model widgetChatListAdapterItemGuildScheduledEventInvite$Model = (WidgetChatListAdapterItemGuildScheduledEventInvite$Model) other;
        return m.areEqual(this.invite, widgetChatListAdapterItemGuildScheduledEventInvite$Model.invite) && this.isInGuild == widgetChatListAdapterItemGuildScheduledEventInvite$Model.isInGuild && this.isRsvped == widgetChatListAdapterItemGuildScheduledEventInvite$Model.isRsvped && m.areEqual(this.guildScheduledEvent, widgetChatListAdapterItemGuildScheduledEventInvite$Model.guildScheduledEvent) && m.areEqual(this.channel, widgetChatListAdapterItemGuildScheduledEventInvite$Model.channel) && m.areEqual(this.guild, widgetChatListAdapterItemGuildScheduledEventInvite$Model.guild) && m.areEqual(this.creator, widgetChatListAdapterItemGuildScheduledEventInvite$Model.creator) && m.areEqual(this.selectedVoiceChannelId, widgetChatListAdapterItemGuildScheduledEventInvite$Model.selectedVoiceChannelId) && this.canConnect == widgetChatListAdapterItemGuildScheduledEventInvite$Model.canConnect && this.canShare == widgetChatListAdapterItemGuildScheduledEventInvite$Model.canShare;
    }

    public final boolean getCanConnect() {
        return this.canConnect;
    }

    public final boolean getCanShare() {
        return this.canShare;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final UserGuildMember getCreator() {
        return this.creator;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
    }

    public final ModelInvite getInvite() {
        return this.invite;
    }

    public final Long getSelectedVoiceChannelId() {
        return this.selectedVoiceChannelId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        ModelInvite modelInvite = this.invite;
        int iHashCode = (modelInvite != null ? modelInvite.hashCode() : 0) * 31;
        boolean z2 = this.isInGuild;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        boolean z3 = this.isRsvped;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (i + r3) * 31;
        GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
        int iHashCode2 = (i2 + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0)) * 31;
        Channel channel = this.channel;
        int iHashCode3 = (iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31;
        Guild guild = this.guild;
        int iHashCode4 = (iHashCode3 + (guild != null ? guild.hashCode() : 0)) * 31;
        UserGuildMember userGuildMember = this.creator;
        int iHashCode5 = (iHashCode4 + (userGuildMember != null ? userGuildMember.hashCode() : 0)) * 31;
        Long l = this.selectedVoiceChannelId;
        int iHashCode6 = (iHashCode5 + (l != null ? l.hashCode() : 0)) * 31;
        boolean z4 = this.canConnect;
        ?? r1 = z4;
        if (z4) {
            r1 = 1;
        }
        int i3 = (iHashCode6 + r1) * 31;
        boolean z5 = this.canShare;
        return i3 + (z5 ? 1 : z5);
    }

    public final boolean isInGuild() {
        return this.isInGuild;
    }

    public final boolean isRsvped() {
        return this.isRsvped;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(invite=");
        sbU.append(this.invite);
        sbU.append(", isInGuild=");
        sbU.append(this.isInGuild);
        sbU.append(", isRsvped=");
        sbU.append(this.isRsvped);
        sbU.append(", guildScheduledEvent=");
        sbU.append(this.guildScheduledEvent);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", creator=");
        sbU.append(this.creator);
        sbU.append(", selectedVoiceChannelId=");
        sbU.append(this.selectedVoiceChannelId);
        sbU.append(", canConnect=");
        sbU.append(this.canConnect);
        sbU.append(", canShare=");
        return a.O(sbU, this.canShare, ")");
    }
}
