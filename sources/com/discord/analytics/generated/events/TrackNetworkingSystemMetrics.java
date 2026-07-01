package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackNetworkingSystemMetrics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNetworkingSystemMetrics implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long applicationId = null;
    private final Long peerId = null;
    private final Long intervalNs = null;
    private final Long messagesSent = null;
    private final Long messagesDropped = null;
    private final Long messagesReceived = null;
    private final Long dataReceivedBytesAvg = null;
    private final Long dataReceivedBytesMax = null;
    private final Long dataReceivedBytesP95 = null;
    private final Long dataSentBytesAvg = null;
    private final Long dataSentBytesMax = null;
    private final Long dataSentBytesP95 = null;
    private final Long dataSentPerPollAvg = null;
    private final Long dataSentPerPollMax = null;
    private final Long dataSentPerPollP95 = null;
    private final Long dataReceivedPerPollAvg = null;
    private final Long dataReceivedPerPollMax = null;
    private final Long dataReceivedPerPollP95 = null;
    private final Long pingsSent = null;
    private final Long pongsReceived = null;
    private final Long dataSent = null;
    private final Long dataReceived = null;
    private final Long routeChanges = null;
    private final Long pingRttAvg = null;
    private final Long pingRttMax = null;
    private final Long pingRttP95 = null;
    private final Long pingRttStddev = null;
    private final Long pollCalls = null;
    private final Long flushCalls = null;
    private final Long peerCount = null;
    private final transient String analyticsSchemaTypeName = "networking_system_metrics";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNetworkingSystemMetrics)) {
            return false;
        }
        TrackNetworkingSystemMetrics trackNetworkingSystemMetrics = (TrackNetworkingSystemMetrics) other;
        return m.areEqual(this.applicationId, trackNetworkingSystemMetrics.applicationId) && m.areEqual(this.peerId, trackNetworkingSystemMetrics.peerId) && m.areEqual(this.intervalNs, trackNetworkingSystemMetrics.intervalNs) && m.areEqual(this.messagesSent, trackNetworkingSystemMetrics.messagesSent) && m.areEqual(this.messagesDropped, trackNetworkingSystemMetrics.messagesDropped) && m.areEqual(this.messagesReceived, trackNetworkingSystemMetrics.messagesReceived) && m.areEqual(this.dataReceivedBytesAvg, trackNetworkingSystemMetrics.dataReceivedBytesAvg) && m.areEqual(this.dataReceivedBytesMax, trackNetworkingSystemMetrics.dataReceivedBytesMax) && m.areEqual(this.dataReceivedBytesP95, trackNetworkingSystemMetrics.dataReceivedBytesP95) && m.areEqual(this.dataSentBytesAvg, trackNetworkingSystemMetrics.dataSentBytesAvg) && m.areEqual(this.dataSentBytesMax, trackNetworkingSystemMetrics.dataSentBytesMax) && m.areEqual(this.dataSentBytesP95, trackNetworkingSystemMetrics.dataSentBytesP95) && m.areEqual(this.dataSentPerPollAvg, trackNetworkingSystemMetrics.dataSentPerPollAvg) && m.areEqual(this.dataSentPerPollMax, trackNetworkingSystemMetrics.dataSentPerPollMax) && m.areEqual(this.dataSentPerPollP95, trackNetworkingSystemMetrics.dataSentPerPollP95) && m.areEqual(this.dataReceivedPerPollAvg, trackNetworkingSystemMetrics.dataReceivedPerPollAvg) && m.areEqual(this.dataReceivedPerPollMax, trackNetworkingSystemMetrics.dataReceivedPerPollMax) && m.areEqual(this.dataReceivedPerPollP95, trackNetworkingSystemMetrics.dataReceivedPerPollP95) && m.areEqual(this.pingsSent, trackNetworkingSystemMetrics.pingsSent) && m.areEqual(this.pongsReceived, trackNetworkingSystemMetrics.pongsReceived) && m.areEqual(this.dataSent, trackNetworkingSystemMetrics.dataSent) && m.areEqual(this.dataReceived, trackNetworkingSystemMetrics.dataReceived) && m.areEqual(this.routeChanges, trackNetworkingSystemMetrics.routeChanges) && m.areEqual(this.pingRttAvg, trackNetworkingSystemMetrics.pingRttAvg) && m.areEqual(this.pingRttMax, trackNetworkingSystemMetrics.pingRttMax) && m.areEqual(this.pingRttP95, trackNetworkingSystemMetrics.pingRttP95) && m.areEqual(this.pingRttStddev, trackNetworkingSystemMetrics.pingRttStddev) && m.areEqual(this.pollCalls, trackNetworkingSystemMetrics.pollCalls) && m.areEqual(this.flushCalls, trackNetworkingSystemMetrics.flushCalls) && m.areEqual(this.peerCount, trackNetworkingSystemMetrics.peerCount);
    }

    public int hashCode() {
        Long l = this.applicationId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.peerId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.intervalNs;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.messagesSent;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.messagesDropped;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.messagesReceived;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.dataReceivedBytesAvg;
        int iHashCode7 = (iHashCode6 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.dataReceivedBytesMax;
        int iHashCode8 = (iHashCode7 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.dataReceivedBytesP95;
        int iHashCode9 = (iHashCode8 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.dataSentBytesAvg;
        int iHashCode10 = (iHashCode9 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.dataSentBytesMax;
        int iHashCode11 = (iHashCode10 + (l11 != null ? l11.hashCode() : 0)) * 31;
        Long l12 = this.dataSentBytesP95;
        int iHashCode12 = (iHashCode11 + (l12 != null ? l12.hashCode() : 0)) * 31;
        Long l13 = this.dataSentPerPollAvg;
        int iHashCode13 = (iHashCode12 + (l13 != null ? l13.hashCode() : 0)) * 31;
        Long l14 = this.dataSentPerPollMax;
        int iHashCode14 = (iHashCode13 + (l14 != null ? l14.hashCode() : 0)) * 31;
        Long l15 = this.dataSentPerPollP95;
        int iHashCode15 = (iHashCode14 + (l15 != null ? l15.hashCode() : 0)) * 31;
        Long l16 = this.dataReceivedPerPollAvg;
        int iHashCode16 = (iHashCode15 + (l16 != null ? l16.hashCode() : 0)) * 31;
        Long l17 = this.dataReceivedPerPollMax;
        int iHashCode17 = (iHashCode16 + (l17 != null ? l17.hashCode() : 0)) * 31;
        Long l18 = this.dataReceivedPerPollP95;
        int iHashCode18 = (iHashCode17 + (l18 != null ? l18.hashCode() : 0)) * 31;
        Long l19 = this.pingsSent;
        int iHashCode19 = (iHashCode18 + (l19 != null ? l19.hashCode() : 0)) * 31;
        Long l20 = this.pongsReceived;
        int iHashCode20 = (iHashCode19 + (l20 != null ? l20.hashCode() : 0)) * 31;
        Long l21 = this.dataSent;
        int iHashCode21 = (iHashCode20 + (l21 != null ? l21.hashCode() : 0)) * 31;
        Long l22 = this.dataReceived;
        int iHashCode22 = (iHashCode21 + (l22 != null ? l22.hashCode() : 0)) * 31;
        Long l23 = this.routeChanges;
        int iHashCode23 = (iHashCode22 + (l23 != null ? l23.hashCode() : 0)) * 31;
        Long l24 = this.pingRttAvg;
        int iHashCode24 = (iHashCode23 + (l24 != null ? l24.hashCode() : 0)) * 31;
        Long l25 = this.pingRttMax;
        int iHashCode25 = (iHashCode24 + (l25 != null ? l25.hashCode() : 0)) * 31;
        Long l26 = this.pingRttP95;
        int iHashCode26 = (iHashCode25 + (l26 != null ? l26.hashCode() : 0)) * 31;
        Long l27 = this.pingRttStddev;
        int iHashCode27 = (iHashCode26 + (l27 != null ? l27.hashCode() : 0)) * 31;
        Long l28 = this.pollCalls;
        int iHashCode28 = (iHashCode27 + (l28 != null ? l28.hashCode() : 0)) * 31;
        Long l29 = this.flushCalls;
        int iHashCode29 = (iHashCode28 + (l29 != null ? l29.hashCode() : 0)) * 31;
        Long l30 = this.peerCount;
        return iHashCode29 + (l30 != null ? l30.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackNetworkingSystemMetrics(applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", peerId=");
        sbU.append(this.peerId);
        sbU.append(", intervalNs=");
        sbU.append(this.intervalNs);
        sbU.append(", messagesSent=");
        sbU.append(this.messagesSent);
        sbU.append(", messagesDropped=");
        sbU.append(this.messagesDropped);
        sbU.append(", messagesReceived=");
        sbU.append(this.messagesReceived);
        sbU.append(", dataReceivedBytesAvg=");
        sbU.append(this.dataReceivedBytesAvg);
        sbU.append(", dataReceivedBytesMax=");
        sbU.append(this.dataReceivedBytesMax);
        sbU.append(", dataReceivedBytesP95=");
        sbU.append(this.dataReceivedBytesP95);
        sbU.append(", dataSentBytesAvg=");
        sbU.append(this.dataSentBytesAvg);
        sbU.append(", dataSentBytesMax=");
        sbU.append(this.dataSentBytesMax);
        sbU.append(", dataSentBytesP95=");
        sbU.append(this.dataSentBytesP95);
        sbU.append(", dataSentPerPollAvg=");
        sbU.append(this.dataSentPerPollAvg);
        sbU.append(", dataSentPerPollMax=");
        sbU.append(this.dataSentPerPollMax);
        sbU.append(", dataSentPerPollP95=");
        sbU.append(this.dataSentPerPollP95);
        sbU.append(", dataReceivedPerPollAvg=");
        sbU.append(this.dataReceivedPerPollAvg);
        sbU.append(", dataReceivedPerPollMax=");
        sbU.append(this.dataReceivedPerPollMax);
        sbU.append(", dataReceivedPerPollP95=");
        sbU.append(this.dataReceivedPerPollP95);
        sbU.append(", pingsSent=");
        sbU.append(this.pingsSent);
        sbU.append(", pongsReceived=");
        sbU.append(this.pongsReceived);
        sbU.append(", dataSent=");
        sbU.append(this.dataSent);
        sbU.append(", dataReceived=");
        sbU.append(this.dataReceived);
        sbU.append(", routeChanges=");
        sbU.append(this.routeChanges);
        sbU.append(", pingRttAvg=");
        sbU.append(this.pingRttAvg);
        sbU.append(", pingRttMax=");
        sbU.append(this.pingRttMax);
        sbU.append(", pingRttP95=");
        sbU.append(this.pingRttP95);
        sbU.append(", pingRttStddev=");
        sbU.append(this.pingRttStddev);
        sbU.append(", pollCalls=");
        sbU.append(this.pollCalls);
        sbU.append(", flushCalls=");
        sbU.append(this.flushCalls);
        sbU.append(", peerCount=");
        return a.G(sbU, this.peerCount, ")");
    }
}
