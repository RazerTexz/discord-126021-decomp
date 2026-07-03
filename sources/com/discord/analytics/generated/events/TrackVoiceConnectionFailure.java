package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackVoiceConnectionFailure.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVoiceConnectionFailure implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.error, trackVoiceConnectionFailure.error) && C12238m.areEqual(this.hostname, trackVoiceConnectionFailure.hostname) && C12238m.areEqual(this.cloudflareBestRegion, trackVoiceConnectionFailure.cloudflareBestRegion) && C12238m.areEqual(this.port, trackVoiceConnectionFailure.port) && C12238m.areEqual(this.protocol, trackVoiceConnectionFailure.protocol) && C12238m.areEqual(this.sessionId, trackVoiceConnectionFailure.sessionId) && C12238m.areEqual(this.mediaSessionId, trackVoiceConnectionFailure.mediaSessionId) && C12238m.areEqual(this.context, trackVoiceConnectionFailure.context) && C12238m.areEqual(this.rtcConnectionId, trackVoiceConnectionFailure.rtcConnectionId) && C12238m.areEqual(this.channelId, trackVoiceConnectionFailure.channelId) && C12238m.areEqual(this.guildId, trackVoiceConnectionFailure.guildId) && C12238m.areEqual(this.connectCount, trackVoiceConnectionFailure.connectCount) && C12238m.areEqual(this.voiceBackendVersion, trackVoiceConnectionFailure.voiceBackendVersion) && C12238m.areEqual(this.rtcWorkerBackendVersion, trackVoiceConnectionFailure.rtcWorkerBackendVersion);
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
        StringBuilder sbM833U = C1643a.m833U("TrackVoiceConnectionFailure(error=");
        sbM833U.append(this.error);
        sbM833U.append(", hostname=");
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
        sbM833U.append(", context=");
        sbM833U.append(this.context);
        sbM833U.append(", rtcConnectionId=");
        sbM833U.append(this.rtcConnectionId);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", connectCount=");
        sbM833U.append(this.connectCount);
        sbM833U.append(", voiceBackendVersion=");
        sbM833U.append(this.voiceBackendVersion);
        sbM833U.append(", rtcWorkerBackendVersion=");
        return C1643a.m817E(sbM833U, this.rtcWorkerBackendVersion, ")");
    }
}
