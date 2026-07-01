package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

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
        return m.areEqual(this.applicationId, trackNetworkingPeerMetrics.applicationId) && m.areEqual(this.peerId, trackNetworkingPeerMetrics.peerId) && m.areEqual(this.intervalNs, trackNetworkingPeerMetrics.intervalNs) && m.areEqual(this.pingsSent, trackNetworkingPeerMetrics.pingsSent) && m.areEqual(this.pingsReceived, trackNetworkingPeerMetrics.pingsReceived) && m.areEqual(this.pongsSent, trackNetworkingPeerMetrics.pongsSent) && m.areEqual(this.pongsReceived, trackNetworkingPeerMetrics.pongsReceived) && m.areEqual(this.pingRttAvg, trackNetworkingPeerMetrics.pingRttAvg) && m.areEqual(this.pingRttMax, trackNetworkingPeerMetrics.pingRttMax) && m.areEqual(this.pingRttP95, trackNetworkingPeerMetrics.pingRttP95) && m.areEqual(this.pingRttStddev, trackNetworkingPeerMetrics.pingRttStddev);
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
        StringBuilder sbU = a.U("TrackNetworkingPeerMetrics(applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", peerId=");
        sbU.append(this.peerId);
        sbU.append(", intervalNs=");
        sbU.append(this.intervalNs);
        sbU.append(", pingsSent=");
        sbU.append(this.pingsSent);
        sbU.append(", pingsReceived=");
        sbU.append(this.pingsReceived);
        sbU.append(", pongsSent=");
        sbU.append(this.pongsSent);
        sbU.append(", pongsReceived=");
        sbU.append(this.pongsReceived);
        sbU.append(", pingRttAvg=");
        sbU.append(this.pingRttAvg);
        sbU.append(", pingRttMax=");
        sbU.append(this.pingRttMax);
        sbU.append(", pingRttP95=");
        sbU.append(this.pingRttP95);
        sbU.append(", pingRttStddev=");
        return a.G(sbU, this.pingRttStddev, ")");
    }
}
