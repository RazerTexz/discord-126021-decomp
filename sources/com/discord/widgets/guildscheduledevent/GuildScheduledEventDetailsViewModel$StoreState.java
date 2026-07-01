package com.discord.widgets.guildscheduledevent;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.guild.Guild;
import com.discord.models.guild.UserGuildMember;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildScheduledEventDetailsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventDetailsViewModel$StoreState {
    private final boolean canConnect;
    private final boolean canShare;
    private final boolean canStartEvent;
    private final Channel channel;
    private final UserGuildMember creator;
    private final Guild guild;
    private final GuildScheduledEvent guildScheduledEvent;
    private final boolean isDeveloperMode;
    private final boolean isInGuild;
    private final boolean isRsvpUsersError;
    private final boolean isRsvpUsersFetching;
    private final boolean isRsvped;
    private final List<GuildScheduledEventRsvpUserListItem$RsvpUser> rsvpUsers;
    private final Long selectedVoiceChannelId;

    public GuildScheduledEventDetailsViewModel$StoreState() {
        this(null, null, null, null, false, false, false, false, false, null, false, null, false, false, 16383, null);
    }

    public GuildScheduledEventDetailsViewModel$StoreState(GuildScheduledEvent guildScheduledEvent, Channel channel, Guild guild, UserGuildMember userGuildMember, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Long l, boolean z7, List<GuildScheduledEventRsvpUserListItem$RsvpUser> list, boolean z8, boolean z9) {
        m.checkNotNullParameter(list, "rsvpUsers");
        this.guildScheduledEvent = guildScheduledEvent;
        this.channel = channel;
        this.guild = guild;
        this.creator = userGuildMember;
        this.isInGuild = z2;
        this.isRsvped = z3;
        this.canShare = z4;
        this.canStartEvent = z5;
        this.isDeveloperMode = z6;
        this.selectedVoiceChannelId = l;
        this.canConnect = z7;
        this.rsvpUsers = list;
        this.isRsvpUsersFetching = z8;
        this.isRsvpUsersError = z9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildScheduledEventDetailsViewModel$StoreState copy$default(GuildScheduledEventDetailsViewModel$StoreState guildScheduledEventDetailsViewModel$StoreState, GuildScheduledEvent guildScheduledEvent, Channel channel, Guild guild, UserGuildMember userGuildMember, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Long l, boolean z7, List list, boolean z8, boolean z9, int i, Object obj) {
        return guildScheduledEventDetailsViewModel$StoreState.copy((i & 1) != 0 ? guildScheduledEventDetailsViewModel$StoreState.guildScheduledEvent : guildScheduledEvent, (i & 2) != 0 ? guildScheduledEventDetailsViewModel$StoreState.channel : channel, (i & 4) != 0 ? guildScheduledEventDetailsViewModel$StoreState.guild : guild, (i & 8) != 0 ? guildScheduledEventDetailsViewModel$StoreState.creator : userGuildMember, (i & 16) != 0 ? guildScheduledEventDetailsViewModel$StoreState.isInGuild : z2, (i & 32) != 0 ? guildScheduledEventDetailsViewModel$StoreState.isRsvped : z3, (i & 64) != 0 ? guildScheduledEventDetailsViewModel$StoreState.canShare : z4, (i & 128) != 0 ? guildScheduledEventDetailsViewModel$StoreState.canStartEvent : z5, (i & 256) != 0 ? guildScheduledEventDetailsViewModel$StoreState.isDeveloperMode : z6, (i & 512) != 0 ? guildScheduledEventDetailsViewModel$StoreState.selectedVoiceChannelId : l, (i & 1024) != 0 ? guildScheduledEventDetailsViewModel$StoreState.canConnect : z7, (i & 2048) != 0 ? guildScheduledEventDetailsViewModel$StoreState.rsvpUsers : list, (i & 4096) != 0 ? guildScheduledEventDetailsViewModel$StoreState.isRsvpUsersFetching : z8, (i & 8192) != 0 ? guildScheduledEventDetailsViewModel$StoreState.isRsvpUsersError : z9);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Long getSelectedVoiceChannelId() {
        return this.selectedVoiceChannelId;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getCanConnect() {
        return this.canConnect;
    }

    public final List<GuildScheduledEventRsvpUserListItem$RsvpUser> component12() {
        return this.rsvpUsers;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getIsRsvpUsersFetching() {
        return this.isRsvpUsersFetching;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getIsRsvpUsersError() {
        return this.isRsvpUsersError;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final UserGuildMember getCreator() {
        return this.creator;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsInGuild() {
        return this.isInGuild;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsRsvped() {
        return this.isRsvped;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getCanShare() {
        return this.canShare;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getCanStartEvent() {
        return this.canStartEvent;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsDeveloperMode() {
        return this.isDeveloperMode;
    }

    public final GuildScheduledEventDetailsViewModel$StoreState copy(GuildScheduledEvent guildScheduledEvent, Channel channel, Guild guild, UserGuildMember creator, boolean isInGuild, boolean isRsvped, boolean canShare, boolean canStartEvent, boolean isDeveloperMode, Long selectedVoiceChannelId, boolean canConnect, List<GuildScheduledEventRsvpUserListItem$RsvpUser> rsvpUsers, boolean isRsvpUsersFetching, boolean isRsvpUsersError) {
        m.checkNotNullParameter(rsvpUsers, "rsvpUsers");
        return new GuildScheduledEventDetailsViewModel$StoreState(guildScheduledEvent, channel, guild, creator, isInGuild, isRsvped, canShare, canStartEvent, isDeveloperMode, selectedVoiceChannelId, canConnect, rsvpUsers, isRsvpUsersFetching, isRsvpUsersError);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventDetailsViewModel$StoreState)) {
            return false;
        }
        GuildScheduledEventDetailsViewModel$StoreState guildScheduledEventDetailsViewModel$StoreState = (GuildScheduledEventDetailsViewModel$StoreState) other;
        return m.areEqual(this.guildScheduledEvent, guildScheduledEventDetailsViewModel$StoreState.guildScheduledEvent) && m.areEqual(this.channel, guildScheduledEventDetailsViewModel$StoreState.channel) && m.areEqual(this.guild, guildScheduledEventDetailsViewModel$StoreState.guild) && m.areEqual(this.creator, guildScheduledEventDetailsViewModel$StoreState.creator) && this.isInGuild == guildScheduledEventDetailsViewModel$StoreState.isInGuild && this.isRsvped == guildScheduledEventDetailsViewModel$StoreState.isRsvped && this.canShare == guildScheduledEventDetailsViewModel$StoreState.canShare && this.canStartEvent == guildScheduledEventDetailsViewModel$StoreState.canStartEvent && this.isDeveloperMode == guildScheduledEventDetailsViewModel$StoreState.isDeveloperMode && m.areEqual(this.selectedVoiceChannelId, guildScheduledEventDetailsViewModel$StoreState.selectedVoiceChannelId) && this.canConnect == guildScheduledEventDetailsViewModel$StoreState.canConnect && m.areEqual(this.rsvpUsers, guildScheduledEventDetailsViewModel$StoreState.rsvpUsers) && this.isRsvpUsersFetching == guildScheduledEventDetailsViewModel$StoreState.isRsvpUsersFetching && this.isRsvpUsersError == guildScheduledEventDetailsViewModel$StoreState.isRsvpUsersError;
    }

    public final boolean getCanConnect() {
        return this.canConnect;
    }

    public final boolean getCanShare() {
        return this.canShare;
    }

    public final boolean getCanStartEvent() {
        return this.canStartEvent;
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

    public final List<GuildScheduledEventRsvpUserListItem$RsvpUser> getRsvpUsers() {
        return this.rsvpUsers;
    }

    public final Long getSelectedVoiceChannelId() {
        return this.selectedVoiceChannelId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26, types: [int] */
    /* JADX WARN: Type inference failed for: r0v28, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18, types: [int] */
    /* JADX WARN: Type inference failed for: r2v23, types: [int] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
        int iHashCode = (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0) * 31;
        Channel channel = this.channel;
        int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
        Guild guild = this.guild;
        int iHashCode3 = (iHashCode2 + (guild != null ? guild.hashCode() : 0)) * 31;
        UserGuildMember userGuildMember = this.creator;
        int iHashCode4 = (iHashCode3 + (userGuildMember != null ? userGuildMember.hashCode() : 0)) * 31;
        boolean z2 = this.isInGuild;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode4 + r2) * 31;
        boolean z3 = this.isRsvped;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (i + r3) * 31;
        boolean z4 = this.canShare;
        ?? r4 = z4;
        if (z4) {
            r4 = 1;
        }
        int i3 = (i2 + r4) * 31;
        boolean z5 = this.canStartEvent;
        ?? r5 = z5;
        if (z5) {
            r5 = 1;
        }
        int i4 = (i3 + r5) * 31;
        boolean z6 = this.isDeveloperMode;
        ?? r6 = z6;
        if (z6) {
            r6 = 1;
        }
        int i5 = (i4 + r6) * 31;
        Long l = this.selectedVoiceChannelId;
        int iHashCode5 = (i5 + (l != null ? l.hashCode() : 0)) * 31;
        boolean z7 = this.canConnect;
        ?? r7 = z7;
        if (z7) {
            r7 = 1;
        }
        int i6 = (iHashCode5 + r7) * 31;
        List<GuildScheduledEventRsvpUserListItem$RsvpUser> list = this.rsvpUsers;
        int iHashCode6 = (i6 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z8 = this.isRsvpUsersFetching;
        ?? r1 = z8;
        if (z8) {
            r1 = 1;
        }
        int i7 = (iHashCode6 + r1) * 31;
        boolean z9 = this.isRsvpUsersError;
        return i7 + (z9 ? 1 : z9);
    }

    public final boolean isDeveloperMode() {
        return this.isDeveloperMode;
    }

    public final boolean isInGuild() {
        return this.isInGuild;
    }

    public final boolean isRsvpUsersError() {
        return this.isRsvpUsersError;
    }

    public final boolean isRsvpUsersFetching() {
        return this.isRsvpUsersFetching;
    }

    public final boolean isRsvped() {
        return this.isRsvped;
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(guildScheduledEvent=");
        sbU.append(this.guildScheduledEvent);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", creator=");
        sbU.append(this.creator);
        sbU.append(", isInGuild=");
        sbU.append(this.isInGuild);
        sbU.append(", isRsvped=");
        sbU.append(this.isRsvped);
        sbU.append(", canShare=");
        sbU.append(this.canShare);
        sbU.append(", canStartEvent=");
        sbU.append(this.canStartEvent);
        sbU.append(", isDeveloperMode=");
        sbU.append(this.isDeveloperMode);
        sbU.append(", selectedVoiceChannelId=");
        sbU.append(this.selectedVoiceChannelId);
        sbU.append(", canConnect=");
        sbU.append(this.canConnect);
        sbU.append(", rsvpUsers=");
        sbU.append(this.rsvpUsers);
        sbU.append(", isRsvpUsersFetching=");
        sbU.append(this.isRsvpUsersFetching);
        sbU.append(", isRsvpUsersError=");
        return a.O(sbU, this.isRsvpUsersError, ")");
    }

    public /* synthetic */ GuildScheduledEventDetailsViewModel$StoreState(GuildScheduledEvent guildScheduledEvent, Channel channel, Guild guild, UserGuildMember userGuildMember, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Long l, boolean z7, List list, boolean z8, boolean z9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : guildScheduledEvent, (i & 2) != 0 ? null : channel, (i & 4) != 0 ? null : guild, (i & 8) != 0 ? null : userGuildMember, (i & 16) != 0 ? true : z2, (i & 32) != 0 ? false : z3, (i & 64) != 0 ? false : z4, (i & 128) != 0 ? false : z5, (i & 256) != 0 ? false : z6, (i & 512) == 0 ? l : null, (i & 1024) != 0 ? false : z7, (i & 2048) != 0 ? n.emptyList() : list, (i & 4096) != 0 ? false : z8, (i & 8192) == 0 ? z9 : false);
    }
}
