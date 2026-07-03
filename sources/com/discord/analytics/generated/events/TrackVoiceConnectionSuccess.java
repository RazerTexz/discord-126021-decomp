package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackVoiceConnectionSuccess.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVoiceConnectionSuccess implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence hostname = null;
    private final CharSequence cloudflareBestRegion = null;
    private final Long port = null;
    private final CharSequence protocol = null;
    private final CharSequence sessionId = null;
    private final CharSequence mediaSessionId = null;
    private final Long connectTime = null;
    private final CharSequence rtcConnectionId = null;
    private final Long channelId = null;
    private final Long guildId = null;
    private final CharSequence context = null;
    private final Long connectCount = null;
    private final CharSequence audioSubsystem = null;
    private final CharSequence audioLayer = null;
    private final CharSequence voiceBackendVersion = null;
    private final CharSequence rtcWorkerBackendVersion = null;
    private final transient String analyticsSchemaTypeName = "voice_connection_success";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVoiceConnectionSuccess)) {
            return false;
        }
        TrackVoiceConnectionSuccess trackVoiceConnectionSuccess = (TrackVoiceConnectionSuccess) other;
        return C12238m.areEqual(this.hostname, trackVoiceConnectionSuccess.hostname) && C12238m.areEqual(this.cloudflareBestRegion, trackVoiceConnectionSuccess.cloudflareBestRegion) && C12238m.areEqual(this.port, trackVoiceConnectionSuccess.port) && C12238m.areEqual(this.protocol, trackVoiceConnectionSuccess.protocol) && C12238m.areEqual(this.sessionId, trackVoiceConnectionSuccess.sessionId) && C12238m.areEqual(this.mediaSessionId, trackVoiceConnectionSuccess.mediaSessionId) && C12238m.areEqual(this.connectTime, trackVoiceConnectionSuccess.connectTime) && C12238m.areEqual(this.rtcConnectionId, trackVoiceConnectionSuccess.rtcConnectionId) && C12238m.areEqual(this.channelId, trackVoiceConnectionSuccess.channelId) && C12238m.areEqual(this.guildId, trackVoiceConnectionSuccess.guildId) && C12238m.areEqual(this.context, trackVoiceConnectionSuccess.context) && C12238m.areEqual(this.connectCount, trackVoiceConnectionSuccess.connectCount) && C12238m.areEqual(this.audioSubsystem, trackVoiceConnectionSuccess.audioSubsystem) && C12238m.areEqual(this.audioLayer, trackVoiceConnectionSuccess.audioLayer) && C12238m.areEqual(this.voiceBackendVersion, trackVoiceConnectionSuccess.voiceBackendVersion) && C12238m.areEqual(this.rtcWorkerBackendVersion, trackVoiceConnectionSuccess.rtcWorkerBackendVersion);
    }

    public int hashCode() {
        CharSequence charSequence = this.hostname;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.cloudflareBestRegion;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.port;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.protocol;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.sessionId;
        int iHashCode5 = (iHashCode4 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.mediaSessionId;
        int iHashCode6 = (iHashCode5 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Long l2 = this.connectTime;
        int iHashCode7 = (iHashCode6 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.rtcConnectionId;
        int iHashCode8 = (iHashCode7 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        Long l3 = this.channelId;
        int iHashCode9 = (iHashCode8 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.guildId;
        int iHashCode10 = (iHashCode9 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.context;
        int iHashCode11 = (iHashCode10 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        Long l5 = this.connectCount;
        int iHashCode12 = (iHashCode11 + (l5 != null ? l5.hashCode() : 0)) * 31;
        CharSequence charSequence8 = this.audioSubsystem;
        int iHashCode13 = (iHashCode12 + (charSequence8 != null ? charSequence8.hashCode() : 0)) * 31;
        CharSequence charSequence9 = this.audioLayer;
        int iHashCode14 = (iHashCode13 + (charSequence9 != null ? charSequence9.hashCode() : 0)) * 31;
        CharSequence charSequence10 = this.voiceBackendVersion;
        int iHashCode15 = (iHashCode14 + (charSequence10 != null ? charSequence10.hashCode() : 0)) * 31;
        CharSequence charSequence11 = this.rtcWorkerBackendVersion;
        return iHashCode15 + (charSequence11 != null ? charSequence11.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackVoiceConnectionSuccess(hostname=");
        sbM833U.append(this.hostname);
        sbM833U.append(", cloudflareBestRegion=");
        sbM833U.append(this.cloudflareBestRegion);
        sbM833U.append(", port=");
        sbM833U.append(this.port);
        sbM833U.append(", protocol=");
        sbM833U.append(this.protocol);
        sbM833U.append(", sessionId=");
        sbM833U.append(this.sessionId);
        sbM833U.append(", mediaSessionId=");
        sbM833U.append(this.mediaSessionId);
        sbM833U.append(", connectTime=");
        sbM833U.append(this.connectTime);
        sbM833U.append(", rtcConnectionId=");
        sbM833U.append(this.rtcConnectionId);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", context=");
        sbM833U.append(this.context);
        sbM833U.append(", connectCount=");
        sbM833U.append(this.connectCount);
        sbM833U.append(", audioSubsystem=");
        sbM833U.append(this.audioSubsystem);
        sbM833U.append(", audioLayer=");
        sbM833U.append(this.audioLayer);
        sbM833U.append(", voiceBackendVersion=");
        sbM833U.append(this.voiceBackendVersion);
        sbM833U.append(", rtcWorkerBackendVersion=");
        return C1643a.m817E(sbM833U, this.rtcWorkerBackendVersion, ")");
    }
}
