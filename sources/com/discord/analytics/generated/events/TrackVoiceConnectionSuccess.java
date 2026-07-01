package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackVoiceConnectionSuccess.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVoiceConnectionSuccess implements AnalyticsSchema, TrackBase2 {
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
        return Intrinsics3.areEqual(this.hostname, trackVoiceConnectionSuccess.hostname) && Intrinsics3.areEqual(this.cloudflareBestRegion, trackVoiceConnectionSuccess.cloudflareBestRegion) && Intrinsics3.areEqual(this.port, trackVoiceConnectionSuccess.port) && Intrinsics3.areEqual(this.protocol, trackVoiceConnectionSuccess.protocol) && Intrinsics3.areEqual(this.sessionId, trackVoiceConnectionSuccess.sessionId) && Intrinsics3.areEqual(this.mediaSessionId, trackVoiceConnectionSuccess.mediaSessionId) && Intrinsics3.areEqual(this.connectTime, trackVoiceConnectionSuccess.connectTime) && Intrinsics3.areEqual(this.rtcConnectionId, trackVoiceConnectionSuccess.rtcConnectionId) && Intrinsics3.areEqual(this.channelId, trackVoiceConnectionSuccess.channelId) && Intrinsics3.areEqual(this.guildId, trackVoiceConnectionSuccess.guildId) && Intrinsics3.areEqual(this.context, trackVoiceConnectionSuccess.context) && Intrinsics3.areEqual(this.connectCount, trackVoiceConnectionSuccess.connectCount) && Intrinsics3.areEqual(this.audioSubsystem, trackVoiceConnectionSuccess.audioSubsystem) && Intrinsics3.areEqual(this.audioLayer, trackVoiceConnectionSuccess.audioLayer) && Intrinsics3.areEqual(this.voiceBackendVersion, trackVoiceConnectionSuccess.voiceBackendVersion) && Intrinsics3.areEqual(this.rtcWorkerBackendVersion, trackVoiceConnectionSuccess.rtcWorkerBackendVersion);
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
        StringBuilder sbU = outline.U("TrackVoiceConnectionSuccess(hostname=");
        sbU.append(this.hostname);
        sbU.append(", cloudflareBestRegion=");
        sbU.append(this.cloudflareBestRegion);
        sbU.append(", port=");
        sbU.append(this.port);
        sbU.append(", protocol=");
        sbU.append(this.protocol);
        sbU.append(", sessionId=");
        sbU.append(this.sessionId);
        sbU.append(", mediaSessionId=");
        sbU.append(this.mediaSessionId);
        sbU.append(", connectTime=");
        sbU.append(this.connectTime);
        sbU.append(", rtcConnectionId=");
        sbU.append(this.rtcConnectionId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", context=");
        sbU.append(this.context);
        sbU.append(", connectCount=");
        sbU.append(this.connectCount);
        sbU.append(", audioSubsystem=");
        sbU.append(this.audioSubsystem);
        sbU.append(", audioLayer=");
        sbU.append(this.audioLayer);
        sbU.append(", voiceBackendVersion=");
        sbU.append(this.voiceBackendVersion);
        sbU.append(", rtcWorkerBackendVersion=");
        return outline.E(sbU, this.rtcWorkerBackendVersion, ")");
    }
}
