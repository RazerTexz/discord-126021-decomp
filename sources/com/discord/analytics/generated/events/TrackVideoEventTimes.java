package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackVideoEventTimes.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVideoEventTimes implements AnalyticsSchema, TrackBase2 {
    private final transient String analyticsSchemaTypeName;
    private final Long connectionStreamFirstFrame;
    private final Long connectionVideoFirstFrame;
    private final CharSequence eventTimeName;
    private final Long gatewayConnection;
    private final Long gatewayHello;
    private final Long mediaEngineConnection;
    private final Long streamConnection;
    private final Long streamFirstFrame;
    private final Long streamRequested;
    private TrackBase trackBase;
    private final Long videoFirstFrame;
    private final Long voiceConnection;

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVideoEventTimes)) {
            return false;
        }
        TrackVideoEventTimes trackVideoEventTimes = (TrackVideoEventTimes) other;
        return Intrinsics3.areEqual(this.gatewayConnection, trackVideoEventTimes.gatewayConnection) && Intrinsics3.areEqual(this.gatewayHello, trackVideoEventTimes.gatewayHello) && Intrinsics3.areEqual(this.voiceConnection, trackVideoEventTimes.voiceConnection) && Intrinsics3.areEqual(this.streamRequested, trackVideoEventTimes.streamRequested) && Intrinsics3.areEqual(this.streamConnection, trackVideoEventTimes.streamConnection) && Intrinsics3.areEqual(this.streamFirstFrame, trackVideoEventTimes.streamFirstFrame) && Intrinsics3.areEqual(this.videoFirstFrame, trackVideoEventTimes.videoFirstFrame) && Intrinsics3.areEqual(this.mediaEngineConnection, trackVideoEventTimes.mediaEngineConnection) && Intrinsics3.areEqual(this.connectionVideoFirstFrame, trackVideoEventTimes.connectionVideoFirstFrame) && Intrinsics3.areEqual(this.connectionStreamFirstFrame, trackVideoEventTimes.connectionStreamFirstFrame) && Intrinsics3.areEqual(this.eventTimeName, trackVideoEventTimes.eventTimeName);
    }

    public int hashCode() {
        Long l = this.gatewayConnection;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.gatewayHello;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.voiceConnection;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.streamRequested;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.streamConnection;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.streamFirstFrame;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.videoFirstFrame;
        int iHashCode7 = (iHashCode6 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.mediaEngineConnection;
        int iHashCode8 = (iHashCode7 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.connectionVideoFirstFrame;
        int iHashCode9 = (iHashCode8 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.connectionStreamFirstFrame;
        int iHashCode10 = (iHashCode9 + (l10 != null ? l10.hashCode() : 0)) * 31;
        CharSequence charSequence = this.eventTimeName;
        return iHashCode10 + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackVideoEventTimes(gatewayConnection=");
        sbU.append(this.gatewayConnection);
        sbU.append(", gatewayHello=");
        sbU.append(this.gatewayHello);
        sbU.append(", voiceConnection=");
        sbU.append(this.voiceConnection);
        sbU.append(", streamRequested=");
        sbU.append(this.streamRequested);
        sbU.append(", streamConnection=");
        sbU.append(this.streamConnection);
        sbU.append(", streamFirstFrame=");
        sbU.append(this.streamFirstFrame);
        sbU.append(", videoFirstFrame=");
        sbU.append(this.videoFirstFrame);
        sbU.append(", mediaEngineConnection=");
        sbU.append(this.mediaEngineConnection);
        sbU.append(", connectionVideoFirstFrame=");
        sbU.append(this.connectionVideoFirstFrame);
        sbU.append(", connectionStreamFirstFrame=");
        sbU.append(this.connectionStreamFirstFrame);
        sbU.append(", eventTimeName=");
        return outline.E(sbU, this.eventTimeName, ")");
    }
}
