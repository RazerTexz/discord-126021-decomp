package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackStartSpeaking.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStartSpeaking implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final Long channel = null;
    private final CharSequence mode = null;
    private final Boolean priority = null;
    private final Long server = null;
    private final CharSequence gamePlatform = null;
    private final CharSequence gameName = null;
    private final CharSequence gameExeName = null;
    private final Long gameId = null;
    private final CharSequence mediaSessionId = null;
    private final CharSequence rtcConnectionId = null;
    private final Long packetsSent = null;
    private final Long packetsSentLost = null;
    private final Long packetsReceived = null;
    private final Long packetsReceivedLost = null;
    private final Long voiceStateCount = null;
    private final transient String analyticsSchemaTypeName = "start_speaking";

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    public void c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStartSpeaking)) {
            return false;
        }
        TrackStartSpeaking trackStartSpeaking = (TrackStartSpeaking) other;
        return m.areEqual(this.channel, trackStartSpeaking.channel) && m.areEqual(this.mode, trackStartSpeaking.mode) && m.areEqual(this.priority, trackStartSpeaking.priority) && m.areEqual(this.server, trackStartSpeaking.server) && m.areEqual(this.gamePlatform, trackStartSpeaking.gamePlatform) && m.areEqual(this.gameName, trackStartSpeaking.gameName) && m.areEqual(this.gameExeName, trackStartSpeaking.gameExeName) && m.areEqual(this.gameId, trackStartSpeaking.gameId) && m.areEqual(this.mediaSessionId, trackStartSpeaking.mediaSessionId) && m.areEqual(this.rtcConnectionId, trackStartSpeaking.rtcConnectionId) && m.areEqual(this.packetsSent, trackStartSpeaking.packetsSent) && m.areEqual(this.packetsSentLost, trackStartSpeaking.packetsSentLost) && m.areEqual(this.packetsReceived, trackStartSpeaking.packetsReceived) && m.areEqual(this.packetsReceivedLost, trackStartSpeaking.packetsReceivedLost) && m.areEqual(this.voiceStateCount, trackStartSpeaking.voiceStateCount);
    }

    public int hashCode() {
        Long l = this.channel;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.mode;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.priority;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l2 = this.server;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.gamePlatform;
        int iHashCode5 = (iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.gameName;
        int iHashCode6 = (iHashCode5 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.gameExeName;
        int iHashCode7 = (iHashCode6 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l3 = this.gameId;
        int iHashCode8 = (iHashCode7 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.mediaSessionId;
        int iHashCode9 = (iHashCode8 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.rtcConnectionId;
        int iHashCode10 = (iHashCode9 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        Long l4 = this.packetsSent;
        int iHashCode11 = (iHashCode10 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.packetsSentLost;
        int iHashCode12 = (iHashCode11 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.packetsReceived;
        int iHashCode13 = (iHashCode12 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.packetsReceivedLost;
        int iHashCode14 = (iHashCode13 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.voiceStateCount;
        return iHashCode14 + (l8 != null ? l8.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackStartSpeaking(channel=");
        sbU.append(this.channel);
        sbU.append(", mode=");
        sbU.append(this.mode);
        sbU.append(", priority=");
        sbU.append(this.priority);
        sbU.append(", server=");
        sbU.append(this.server);
        sbU.append(", gamePlatform=");
        sbU.append(this.gamePlatform);
        sbU.append(", gameName=");
        sbU.append(this.gameName);
        sbU.append(", gameExeName=");
        sbU.append(this.gameExeName);
        sbU.append(", gameId=");
        sbU.append(this.gameId);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", rtcConnectionId=");
        sbU.append(this.rtcConnectionId);
        sbU.append(", packetsSent=");
        sbU.append(this.packetsSent);
        sbU.append(", packetsSentLost=");
        sbU.append(this.packetsSentLost);
        sbU.append(", packetsReceived=");
        sbU.append(this.packetsReceived);
        sbU.append(", packetsReceivedLost=");
        sbU.append(this.packetsReceivedLost);
        sbU.append(", voiceStateCount=");
        return a.G(sbU, this.voiceStateCount, ")");
    }
}
