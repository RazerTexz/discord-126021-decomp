package com.discord.widgets.channels.list.items;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.UserGuildMember;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventLocationInfo;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: ChannelListItemActiveEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChannelListItemActiveEventData {
    private final int audienceSize;
    private final boolean connected;
    private final Long eventId;
    private final boolean isSpeaker;
    private final GuildScheduledEventLocationInfo locationInfo;
    private final List<UserGuildMember> speakers;
    private final String topic;

    public ChannelListItemActiveEventData(String str, GuildScheduledEventLocationInfo guildScheduledEventLocationInfo, int i, List<UserGuildMember> list, boolean z2, boolean z3, Long l) {
        m.checkNotNullParameter(guildScheduledEventLocationInfo, "locationInfo");
        m.checkNotNullParameter(list, "speakers");
        this.topic = str;
        this.locationInfo = guildScheduledEventLocationInfo;
        this.audienceSize = i;
        this.speakers = list;
        this.connected = z2;
        this.isSpeaker = z3;
        this.eventId = l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChannelListItemActiveEventData copy$default(ChannelListItemActiveEventData channelListItemActiveEventData, String str, GuildScheduledEventLocationInfo guildScheduledEventLocationInfo, int i, List list, boolean z2, boolean z3, Long l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = channelListItemActiveEventData.topic;
        }
        if ((i2 & 2) != 0) {
            guildScheduledEventLocationInfo = channelListItemActiveEventData.locationInfo;
        }
        GuildScheduledEventLocationInfo guildScheduledEventLocationInfo2 = guildScheduledEventLocationInfo;
        if ((i2 & 4) != 0) {
            i = channelListItemActiveEventData.audienceSize;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            list = channelListItemActiveEventData.speakers;
        }
        List list2 = list;
        if ((i2 & 16) != 0) {
            z2 = channelListItemActiveEventData.connected;
        }
        boolean z4 = z2;
        if ((i2 & 32) != 0) {
            z3 = channelListItemActiveEventData.isSpeaker;
        }
        boolean z5 = z3;
        if ((i2 & 64) != 0) {
            l = channelListItemActiveEventData.eventId;
        }
        return channelListItemActiveEventData.copy(str, guildScheduledEventLocationInfo2, i3, list2, z4, z5, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTopic() {
        return this.topic;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final GuildScheduledEventLocationInfo getLocationInfo() {
        return this.locationInfo;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getAudienceSize() {
        return this.audienceSize;
    }

    public final List<UserGuildMember> component4() {
        return this.speakers;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getConnected() {
        return this.connected;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsSpeaker() {
        return this.isSpeaker;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Long getEventId() {
        return this.eventId;
    }

    public final ChannelListItemActiveEventData copy(String topic, GuildScheduledEventLocationInfo locationInfo, int audienceSize, List<UserGuildMember> speakers, boolean connected, boolean isSpeaker, Long eventId) {
        m.checkNotNullParameter(locationInfo, "locationInfo");
        m.checkNotNullParameter(speakers, "speakers");
        return new ChannelListItemActiveEventData(topic, locationInfo, audienceSize, speakers, connected, isSpeaker, eventId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelListItemActiveEventData)) {
            return false;
        }
        ChannelListItemActiveEventData channelListItemActiveEventData = (ChannelListItemActiveEventData) other;
        return m.areEqual(this.topic, channelListItemActiveEventData.topic) && m.areEqual(this.locationInfo, channelListItemActiveEventData.locationInfo) && this.audienceSize == channelListItemActiveEventData.audienceSize && m.areEqual(this.speakers, channelListItemActiveEventData.speakers) && this.connected == channelListItemActiveEventData.connected && this.isSpeaker == channelListItemActiveEventData.isSpeaker && m.areEqual(this.eventId, channelListItemActiveEventData.eventId);
    }

    public final int getAudienceSize() {
        return this.audienceSize;
    }

    public final boolean getConnected() {
        return this.connected;
    }

    public final Long getEventId() {
        return this.eventId;
    }

    public final GuildScheduledEventLocationInfo getLocationInfo() {
        return this.locationInfo;
    }

    public final List<UserGuildMember> getSpeakers() {
        return this.speakers;
    }

    public final String getTopic() {
        return this.topic;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String str = this.topic;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        GuildScheduledEventLocationInfo guildScheduledEventLocationInfo = this.locationInfo;
        int iHashCode2 = (((iHashCode + (guildScheduledEventLocationInfo != null ? guildScheduledEventLocationInfo.hashCode() : 0)) * 31) + this.audienceSize) * 31;
        List<UserGuildMember> list = this.speakers;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.connected;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode3 + r2) * 31;
        boolean z3 = this.isSpeaker;
        int i2 = (i + (z3 ? 1 : z3)) * 31;
        Long l = this.eventId;
        return i2 + (l != null ? l.hashCode() : 0);
    }

    public final boolean isSpeaker() {
        return this.isSpeaker;
    }

    public String toString() {
        StringBuilder sbU = a.U("ChannelListItemActiveEventData(topic=");
        sbU.append(this.topic);
        sbU.append(", locationInfo=");
        sbU.append(this.locationInfo);
        sbU.append(", audienceSize=");
        sbU.append(this.audienceSize);
        sbU.append(", speakers=");
        sbU.append(this.speakers);
        sbU.append(", connected=");
        sbU.append(this.connected);
        sbU.append(", isSpeaker=");
        sbU.append(this.isSpeaker);
        sbU.append(", eventId=");
        return a.G(sbU, this.eventId, ")");
    }
}
