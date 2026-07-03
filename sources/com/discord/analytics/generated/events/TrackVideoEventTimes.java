package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackVideoEventTimes.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVideoEventTimes implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.gatewayConnection, trackVideoEventTimes.gatewayConnection) && C12238m.areEqual(this.gatewayHello, trackVideoEventTimes.gatewayHello) && C12238m.areEqual(this.voiceConnection, trackVideoEventTimes.voiceConnection) && C12238m.areEqual(this.streamRequested, trackVideoEventTimes.streamRequested) && C12238m.areEqual(this.streamConnection, trackVideoEventTimes.streamConnection) && C12238m.areEqual(this.streamFirstFrame, trackVideoEventTimes.streamFirstFrame) && C12238m.areEqual(this.videoFirstFrame, trackVideoEventTimes.videoFirstFrame) && C12238m.areEqual(this.mediaEngineConnection, trackVideoEventTimes.mediaEngineConnection) && C12238m.areEqual(this.connectionVideoFirstFrame, trackVideoEventTimes.connectionVideoFirstFrame) && C12238m.areEqual(this.connectionStreamFirstFrame, trackVideoEventTimes.connectionStreamFirstFrame) && C12238m.areEqual(this.eventTimeName, trackVideoEventTimes.eventTimeName);
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
        StringBuilder sbM833U = C1643a.m833U("TrackVideoEventTimes(gatewayConnection=");
        sbM833U.append(this.gatewayConnection);
        sbM833U.append(", gatewayHello=");
        sbM833U.append(this.gatewayHello);
        sbM833U.append(", voiceConnection=");
        sbM833U.append(this.voiceConnection);
        sbM833U.append(", streamRequested=");
        sbM833U.append(this.streamRequested);
        sbM833U.append(", streamConnection=");
        sbM833U.append(this.streamConnection);
        sbM833U.append(", streamFirstFrame=");
        sbM833U.append(this.streamFirstFrame);
        sbM833U.append(", videoFirstFrame=");
        sbM833U.append(this.videoFirstFrame);
        sbM833U.append(", mediaEngineConnection=");
        sbM833U.append(this.mediaEngineConnection);
        sbM833U.append(", connectionVideoFirstFrame=");
        sbM833U.append(this.connectionVideoFirstFrame);
        sbM833U.append(", connectionStreamFirstFrame=");
        sbM833U.append(this.connectionStreamFirstFrame);
        sbM833U.append(", eventTimeName=");
        return C1643a.m817E(sbM833U, this.eventTimeName, ")");
    }
}
