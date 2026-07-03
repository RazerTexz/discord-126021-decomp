package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
    /* JADX INFO: renamed from: c */
    public void mo7508c(TrackGuild trackGuild) {
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
        return C12238m.areEqual(this.channel, trackStartSpeaking.channel) && C12238m.areEqual(this.mode, trackStartSpeaking.mode) && C12238m.areEqual(this.priority, trackStartSpeaking.priority) && C12238m.areEqual(this.server, trackStartSpeaking.server) && C12238m.areEqual(this.gamePlatform, trackStartSpeaking.gamePlatform) && C12238m.areEqual(this.gameName, trackStartSpeaking.gameName) && C12238m.areEqual(this.gameExeName, trackStartSpeaking.gameExeName) && C12238m.areEqual(this.gameId, trackStartSpeaking.gameId) && C12238m.areEqual(this.mediaSessionId, trackStartSpeaking.mediaSessionId) && C12238m.areEqual(this.rtcConnectionId, trackStartSpeaking.rtcConnectionId) && C12238m.areEqual(this.packetsSent, trackStartSpeaking.packetsSent) && C12238m.areEqual(this.packetsSentLost, trackStartSpeaking.packetsSentLost) && C12238m.areEqual(this.packetsReceived, trackStartSpeaking.packetsReceived) && C12238m.areEqual(this.packetsReceivedLost, trackStartSpeaking.packetsReceivedLost) && C12238m.areEqual(this.voiceStateCount, trackStartSpeaking.voiceStateCount);
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
        StringBuilder sbM833U = C1643a.m833U("TrackStartSpeaking(channel=");
        sbM833U.append(this.channel);
        sbM833U.append(", mode=");
        sbM833U.append(this.mode);
        sbM833U.append(", priority=");
        sbM833U.append(this.priority);
        sbM833U.append(", server=");
        sbM833U.append(this.server);
        sbM833U.append(", gamePlatform=");
        sbM833U.append(this.gamePlatform);
        sbM833U.append(", gameName=");
        sbM833U.append(this.gameName);
        sbM833U.append(", gameExeName=");
        sbM833U.append(this.gameExeName);
        sbM833U.append(", gameId=");
        sbM833U.append(this.gameId);
        sbM833U.append(", mediaSessionId=");
        sbM833U.append(this.mediaSessionId);
        sbM833U.append(", rtcConnectionId=");
        sbM833U.append(this.rtcConnectionId);
        sbM833U.append(", packetsSent=");
        sbM833U.append(this.packetsSent);
        sbM833U.append(", packetsSentLost=");
        sbM833U.append(this.packetsSentLost);
        sbM833U.append(", packetsReceived=");
        sbM833U.append(this.packetsReceived);
        sbM833U.append(", packetsReceivedLost=");
        sbM833U.append(this.packetsReceivedLost);
        sbM833U.append(", voiceStateCount=");
        return C1643a.m819G(sbM833U, this.voiceStateCount, ")");
    }
}
