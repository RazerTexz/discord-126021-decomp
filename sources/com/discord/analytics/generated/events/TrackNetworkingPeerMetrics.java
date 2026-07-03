package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackNetworkingPeerMetrics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNetworkingPeerMetrics implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long applicationId = null;
    private final Long peerId = null;
    private final Long intervalNs = null;
    private final Long pingsSent = null;
    private final Long pingsReceived = null;
    private final Long pongsSent = null;
    private final Long pongsReceived = null;
    private final Long pingRttAvg = null;
    private final Long pingRttMax = null;
    private final Long pingRttP95 = null;
    private final Long pingRttStddev = null;
    private final transient String analyticsSchemaTypeName = "networking_peer_metrics";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNetworkingPeerMetrics)) {
            return false;
        }
        TrackNetworkingPeerMetrics trackNetworkingPeerMetrics = (TrackNetworkingPeerMetrics) other;
        return C12238m.areEqual(this.applicationId, trackNetworkingPeerMetrics.applicationId) && C12238m.areEqual(this.peerId, trackNetworkingPeerMetrics.peerId) && C12238m.areEqual(this.intervalNs, trackNetworkingPeerMetrics.intervalNs) && C12238m.areEqual(this.pingsSent, trackNetworkingPeerMetrics.pingsSent) && C12238m.areEqual(this.pingsReceived, trackNetworkingPeerMetrics.pingsReceived) && C12238m.areEqual(this.pongsSent, trackNetworkingPeerMetrics.pongsSent) && C12238m.areEqual(this.pongsReceived, trackNetworkingPeerMetrics.pongsReceived) && C12238m.areEqual(this.pingRttAvg, trackNetworkingPeerMetrics.pingRttAvg) && C12238m.areEqual(this.pingRttMax, trackNetworkingPeerMetrics.pingRttMax) && C12238m.areEqual(this.pingRttP95, trackNetworkingPeerMetrics.pingRttP95) && C12238m.areEqual(this.pingRttStddev, trackNetworkingPeerMetrics.pingRttStddev);
    }

    public int hashCode() {
        Long l = this.applicationId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.peerId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.intervalNs;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.pingsSent;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.pingsReceived;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.pongsSent;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.pongsReceived;
        int iHashCode7 = (iHashCode6 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.pingRttAvg;
        int iHashCode8 = (iHashCode7 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.pingRttMax;
        int iHashCode9 = (iHashCode8 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.pingRttP95;
        int iHashCode10 = (iHashCode9 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.pingRttStddev;
        return iHashCode10 + (l11 != null ? l11.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackNetworkingPeerMetrics(applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", peerId=");
        sbM833U.append(this.peerId);
        sbM833U.append(", intervalNs=");
        sbM833U.append(this.intervalNs);
        sbM833U.append(", pingsSent=");
        sbM833U.append(this.pingsSent);
        sbM833U.append(", pingsReceived=");
        sbM833U.append(this.pingsReceived);
        sbM833U.append(", pongsSent=");
        sbM833U.append(this.pongsSent);
        sbM833U.append(", pongsReceived=");
        sbM833U.append(this.pongsReceived);
        sbM833U.append(", pingRttAvg=");
        sbM833U.append(this.pingRttAvg);
        sbM833U.append(", pingRttMax=");
        sbM833U.append(this.pingRttMax);
        sbM833U.append(", pingRttP95=");
        sbM833U.append(this.pingRttP95);
        sbM833U.append(", pingRttStddev=");
        return C1643a.m819G(sbM833U, this.pingRttStddev, ")");
    }
}
