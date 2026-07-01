package com.discord.widgets.guildscheduledevent;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.guild.Guild;
import com.discord.models.guild.UserGuildMember;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: GuildScheduledEventDetailsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventDetailsViewModel$ViewState$Initialized extends GuildScheduledEventDetailsViewModel$ViewState {
    private final boolean canConnect;
    private final boolean canShare;
    private final boolean canStartEvent;
    private final Channel channel;
    private final UserGuildMember creator;
    private final Guild guild;
    private final GuildScheduledEvent guildScheduledEvent;
    private final boolean isConnected;
    private final boolean isDeveloperMode;
    private final boolean isInGuild;
    private final boolean isRsvped;
    private final GuildScheduledEventLocationInfo locationInfo;
    private final List<GuildScheduledEventRsvpUserListItem$RsvpUser> rsvpUsers;
    private final EventDetailsRsvpUsersFetchState rsvpUsersFetchState;
    private final EventDetailsSection section;
    private final int segmentedControlIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDetailsViewModel$ViewState$Initialized(GuildScheduledEvent guildScheduledEvent, GuildScheduledEventLocationInfo guildScheduledEventLocationInfo, Guild guild, Channel channel, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, List<GuildScheduledEventRsvpUserListItem$RsvpUser> list, EventDetailsSection eventDetailsSection, EventDetailsRsvpUsersFetchState eventDetailsRsvpUsersFetchState, int i, UserGuildMember userGuildMember) {
        super(null);
        m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(list, "rsvpUsers");
        m.checkNotNullParameter(eventDetailsSection, "section");
        m.checkNotNullParameter(eventDetailsRsvpUsersFetchState, "rsvpUsersFetchState");
        this.guildScheduledEvent = guildScheduledEvent;
        this.locationInfo = guildScheduledEventLocationInfo;
        this.guild = guild;
        this.channel = channel;
        this.isInGuild = z2;
        this.isRsvped = z3;
        this.canShare = z4;
        this.isConnected = z5;
        this.canStartEvent = z6;
        this.isDeveloperMode = z7;
        this.canConnect = z8;
        this.rsvpUsers = list;
        this.section = eventDetailsSection;
        this.rsvpUsersFetchState = eventDetailsRsvpUsersFetchState;
        this.segmentedControlIndex = i;
        this.creator = userGuildMember;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildScheduledEventDetailsViewModel$ViewState$Initialized copy$default(GuildScheduledEventDetailsViewModel$ViewState$Initialized guildScheduledEventDetailsViewModel$ViewState$Initialized, GuildScheduledEvent guildScheduledEvent, GuildScheduledEventLocationInfo guildScheduledEventLocationInfo, Guild guild, Channel channel, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, List list, EventDetailsSection eventDetailsSection, EventDetailsRsvpUsersFetchState eventDetailsRsvpUsersFetchState, int i, UserGuildMember userGuildMember, int i2, Object obj) {
        return guildScheduledEventDetailsViewModel$ViewState$Initialized.copy((i2 & 1) != 0 ? guildScheduledEventDetailsViewModel$ViewState$Initialized.guildScheduledEvent : guildScheduledEvent, (i2 & 2) != 0 ? guildScheduledEventDetailsViewModel$ViewState$Initialized.locationInfo : guildScheduledEventLocationInfo, (i2 & 4) != 0 ? guildScheduledEventDetailsViewModel$ViewState$Initialized.guild : guild, (i2 & 8) != 0 ? guildScheduledEventDetailsViewModel$ViewState$Initialized.channel : channel, (i2 & 16) != 0 ? guildScheduledEventDetailsViewModel$ViewState$Initialized.isInGuild : z2, (i2 & 32) != 0 ? guildScheduledEventDetailsViewModel$ViewState$Initialized.isRsvped : z3, (i2 & 64) != 0 ? guildScheduledEventDetailsViewModel$ViewState$Initialized.canShare : z4, (i2 & 128) != 0 ? guildScheduledEventDetailsViewModel$ViewState$Initialized.isConnected : z5, (i2 & 256) != 0 ? guildScheduledEventDetailsViewModel$ViewState$Initialized.canStartEvent : z6, (i2 & 512) != 0 ? guildScheduledEventDetailsViewModel$ViewState$Initialized.isDeveloperMode : z7, (i2 & 1024) != 0 ? guildScheduledEventDetailsViewModel$ViewState$Initialized.canConnect : z8, (i2 & 2048) != 0 ? guildScheduledEventDetailsViewModel$ViewState$Initialized.rsvpUsers : list, (i2 & 4096) != 0 ? guildScheduledEventDetailsViewModel$ViewState$Initialized.section : eventDetailsSection, (i2 & 8192) != 0 ? guildScheduledEventDetailsViewModel$ViewState$Initialized.rsvpUsersFetchState : eventDetailsRsvpUsersFetchState, (i2 & 16384) != 0 ? guildScheduledEventDetailsViewModel$ViewState$Initialized.segmentedControlIndex : i, (i2 & 32768) != 0 ? guildScheduledEventDetailsViewModel$ViewState$Initialized.creator : userGuildMember);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsDeveloperMode() {
        return this.isDeveloperMode;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getCanConnect() {
        return this.canConnect;
    }

    public final List<GuildScheduledEventRsvpUserListItem$RsvpUser> component12() {
        return this.rsvpUsers;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final EventDetailsSection getSection() {
        return this.section;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final EventDetailsRsvpUsersFetchState getRsvpUsersFetchState() {
        return this.rsvpUsersFetchState;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getSegmentedControlIndex() {
        return this.segmentedControlIndex;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final UserGuildMember getCreator() {
        return this.creator;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final GuildScheduledEventLocationInfo getLocationInfo() {
        return this.locationInfo;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
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
    public final boolean getIsConnected() {
        return this.isConnected;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getCanStartEvent() {
        return this.canStartEvent;
    }

    public final GuildScheduledEventDetailsViewModel$ViewState$Initialized copy(GuildScheduledEvent guildScheduledEvent, GuildScheduledEventLocationInfo locationInfo, Guild guild, Channel channel, boolean isInGuild, boolean isRsvped, boolean canShare, boolean isConnected, boolean canStartEvent, boolean isDeveloperMode, boolean canConnect, List<GuildScheduledEventRsvpUserListItem$RsvpUser> rsvpUsers, EventDetailsSection section, EventDetailsRsvpUsersFetchState rsvpUsersFetchState, int segmentedControlIndex, UserGuildMember creator) {
        m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(rsvpUsers, "rsvpUsers");
        m.checkNotNullParameter(section, "section");
        m.checkNotNullParameter(rsvpUsersFetchState, "rsvpUsersFetchState");
        return new GuildScheduledEventDetailsViewModel$ViewState$Initialized(guildScheduledEvent, locationInfo, guild, channel, isInGuild, isRsvped, canShare, isConnected, canStartEvent, isDeveloperMode, canConnect, rsvpUsers, section, rsvpUsersFetchState, segmentedControlIndex, creator);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventDetailsViewModel$ViewState$Initialized)) {
            return false;
        }
        GuildScheduledEventDetailsViewModel$ViewState$Initialized guildScheduledEventDetailsViewModel$ViewState$Initialized = (GuildScheduledEventDetailsViewModel$ViewState$Initialized) other;
        return m.areEqual(this.guildScheduledEvent, guildScheduledEventDetailsViewModel$ViewState$Initialized.guildScheduledEvent) && m.areEqual(this.locationInfo, guildScheduledEventDetailsViewModel$ViewState$Initialized.locationInfo) && m.areEqual(this.guild, guildScheduledEventDetailsViewModel$ViewState$Initialized.guild) && m.areEqual(this.channel, guildScheduledEventDetailsViewModel$ViewState$Initialized.channel) && this.isInGuild == guildScheduledEventDetailsViewModel$ViewState$Initialized.isInGuild && this.isRsvped == guildScheduledEventDetailsViewModel$ViewState$Initialized.isRsvped && this.canShare == guildScheduledEventDetailsViewModel$ViewState$Initialized.canShare && this.isConnected == guildScheduledEventDetailsViewModel$ViewState$Initialized.isConnected && this.canStartEvent == guildScheduledEventDetailsViewModel$ViewState$Initialized.canStartEvent && this.isDeveloperMode == guildScheduledEventDetailsViewModel$ViewState$Initialized.isDeveloperMode && this.canConnect == guildScheduledEventDetailsViewModel$ViewState$Initialized.canConnect && m.areEqual(this.rsvpUsers, guildScheduledEventDetailsViewModel$ViewState$Initialized.rsvpUsers) && m.areEqual(this.section, guildScheduledEventDetailsViewModel$ViewState$Initialized.section) && m.areEqual(this.rsvpUsersFetchState, guildScheduledEventDetailsViewModel$ViewState$Initialized.rsvpUsersFetchState) && this.segmentedControlIndex == guildScheduledEventDetailsViewModel$ViewState$Initialized.segmentedControlIndex && m.areEqual(this.creator, guildScheduledEventDetailsViewModel$ViewState$Initialized.creator);
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

    public final GuildScheduledEventLocationInfo getLocationInfo() {
        return this.locationInfo;
    }

    public final List<GuildScheduledEventRsvpUserListItem$RsvpUser> getRsvpUsers() {
        return this.rsvpUsers;
    }

    public final EventDetailsRsvpUsersFetchState getRsvpUsersFetchState() {
        return this.rsvpUsersFetchState;
    }

    public final EventDetailsSection getSection() {
        return this.section;
    }

    public final int getSegmentedControlIndex() {
        return this.segmentedControlIndex;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20, types: [int] */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
        int iHashCode = (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0) * 31;
        GuildScheduledEventLocationInfo guildScheduledEventLocationInfo = this.locationInfo;
        int iHashCode2 = (iHashCode + (guildScheduledEventLocationInfo != null ? guildScheduledEventLocationInfo.hashCode() : 0)) * 31;
        Guild guild = this.guild;
        int iHashCode3 = (iHashCode2 + (guild != null ? guild.hashCode() : 0)) * 31;
        Channel channel = this.channel;
        int iHashCode4 = (iHashCode3 + (channel != null ? channel.hashCode() : 0)) * 31;
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
        boolean z5 = this.isConnected;
        ?? r5 = z5;
        if (z5) {
            r5 = 1;
        }
        int i4 = (i3 + r5) * 31;
        boolean z6 = this.canStartEvent;
        ?? r6 = z6;
        if (z6) {
            r6 = 1;
        }
        int i5 = (i4 + r6) * 31;
        boolean z7 = this.isDeveloperMode;
        ?? r7 = z7;
        if (z7) {
            r7 = 1;
        }
        int i6 = (i5 + r7) * 31;
        boolean z8 = this.canConnect;
        int i7 = (i6 + (z8 ? 1 : z8)) * 31;
        List<GuildScheduledEventRsvpUserListItem$RsvpUser> list = this.rsvpUsers;
        int iHashCode5 = (i7 + (list != null ? list.hashCode() : 0)) * 31;
        EventDetailsSection eventDetailsSection = this.section;
        int iHashCode6 = (iHashCode5 + (eventDetailsSection != null ? eventDetailsSection.hashCode() : 0)) * 31;
        EventDetailsRsvpUsersFetchState eventDetailsRsvpUsersFetchState = this.rsvpUsersFetchState;
        int iHashCode7 = (((iHashCode6 + (eventDetailsRsvpUsersFetchState != null ? eventDetailsRsvpUsersFetchState.hashCode() : 0)) * 31) + this.segmentedControlIndex) * 31;
        UserGuildMember userGuildMember = this.creator;
        return iHashCode7 + (userGuildMember != null ? userGuildMember.hashCode() : 0);
    }

    public final boolean isConnected() {
        return this.isConnected;
    }

    public final boolean isDeveloperMode() {
        return this.isDeveloperMode;
    }

    public final boolean isInGuild() {
        return this.isInGuild;
    }

    public final boolean isRsvped() {
        return this.isRsvped;
    }

    public String toString() {
        StringBuilder sbU = a.U("Initialized(guildScheduledEvent=");
        sbU.append(this.guildScheduledEvent);
        sbU.append(", locationInfo=");
        sbU.append(this.locationInfo);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", isInGuild=");
        sbU.append(this.isInGuild);
        sbU.append(", isRsvped=");
        sbU.append(this.isRsvped);
        sbU.append(", canShare=");
        sbU.append(this.canShare);
        sbU.append(", isConnected=");
        sbU.append(this.isConnected);
        sbU.append(", canStartEvent=");
        sbU.append(this.canStartEvent);
        sbU.append(", isDeveloperMode=");
        sbU.append(this.isDeveloperMode);
        sbU.append(", canConnect=");
        sbU.append(this.canConnect);
        sbU.append(", rsvpUsers=");
        sbU.append(this.rsvpUsers);
        sbU.append(", section=");
        sbU.append(this.section);
        sbU.append(", rsvpUsersFetchState=");
        sbU.append(this.rsvpUsersFetchState);
        sbU.append(", segmentedControlIndex=");
        sbU.append(this.segmentedControlIndex);
        sbU.append(", creator=");
        sbU.append(this.creator);
        sbU.append(")");
        return sbU.toString();
    }
}
