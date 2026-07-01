package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackVoiceConnectionFailure.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVoiceConnectionFailure implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence error = null;
    private final CharSequence hostname = null;
    private final CharSequence cloudflareBestRegion = null;
    private final Long port = null;
    private final CharSequence protocol = null;
    private final CharSequence sessionId = null;
    private final CharSequence mediaSessionId = null;
    private final CharSequence context = null;
    private final CharSequence rtcConnectionId = null;
    private final Long channelId = null;
    private final Long guildId = null;
    private final Long connectCount = null;
    private final CharSequence voiceBackendVersion = null;
    private final CharSequence rtcWorkerBackendVersion = null;
    private final transient String analyticsSchemaTypeName = "voice_connection_failure";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVoiceConnectionFailure)) {
            return false;
        }
        TrackVoiceConnectionFailure trackVoiceConnectionFailure = (TrackVoiceConnectionFailure) other;
        return Intrinsics3.areEqual(this.error, trackVoiceConnectionFailure.error) && Intrinsics3.areEqual(this.hostname, trackVoiceConnectionFailure.hostname) && Intrinsics3.areEqual(this.cloudflareBestRegion, trackVoiceConnectionFailure.cloudflareBestRegion) && Intrinsics3.areEqual(this.port, trackVoiceConnectionFailure.port) && Intrinsics3.areEqual(this.protocol, trackVoiceConnectionFailure.protocol) && Intrinsics3.areEqual(this.sessionId, trackVoiceConnectionFailure.sessionId) && Intrinsics3.areEqual(this.mediaSessionId, trackVoiceConnectionFailure.mediaSessionId) && Intrinsics3.areEqual(this.context, trackVoiceConnectionFailure.context) && Intrinsics3.areEqual(this.rtcConnectionId, trackVoiceConnectionFailure.rtcConnectionId) && Intrinsics3.areEqual(this.channelId, trackVoiceConnectionFailure.channelId) && Intrinsics3.areEqual(this.guildId, trackVoiceConnectionFailure.guildId) && Intrinsics3.areEqual(this.connectCount, trackVoiceConnectionFailure.connectCount) && Intrinsics3.areEqual(this.voiceBackendVersion, trackVoiceConnectionFailure.voiceBackendVersion) && Intrinsics3.areEqual(this.rtcWorkerBackendVersion, trackVoiceConnectionFailure.rtcWorkerBackendVersion);
    }

    public int hashCode() {
        CharSequence charSequence = this.error;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.hostname;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.cloudflareBestRegion;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l = this.port;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.protocol;
        int iHashCode5 = (iHashCode4 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.sessionId;
        int iHashCode6 = (iHashCode5 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.mediaSessionId;
        int iHashCode7 = (iHashCode6 + (charSequence6 != null ? charSequence6.hashCode() : 0)) * 31;
        CharSequence charSequence7 = this.context;
        int iHashCode8 = (iHashCode7 + (charSequence7 != null ? charSequence7.hashCode() : 0)) * 31;
        CharSequence charSequence8 = this.rtcConnectionId;
        int iHashCode9 = (iHashCode8 + (charSequence8 != null ? charSequence8.hashCode() : 0)) * 31;
        Long l2 = this.channelId;
        int iHashCode10 = (iHashCode9 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        int iHashCode11 = (iHashCode10 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.connectCount;
        int iHashCode12 = (iHashCode11 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence9 = this.voiceBackendVersion;
        int iHashCode13 = (iHashCode12 + (charSequence9 != null ? charSequence9.hashCode() : 0)) * 31;
        CharSequence charSequence10 = this.rtcWorkerBackendVersion;
        return iHashCode13 + (charSequence10 != null ? charSequence10.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackVoiceConnectionFailure(error=");
        sbU.append(this.error);
        sbU.append(", hostname=");
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
        sbU.append(", context=");
        sbU.append(this.context);
        sbU.append(", rtcConnectionId=");
        sbU.append(this.rtcConnectionId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", connectCount=");
        sbU.append(this.connectCount);
        sbU.append(", voiceBackendVersion=");
        sbU.append(this.voiceBackendVersion);
        sbU.append(", rtcWorkerBackendVersion=");
        return outline.E(sbU, this.rtcWorkerBackendVersion, ")");
    }
}
