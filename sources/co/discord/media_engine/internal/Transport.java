package co.discord.media_engine.internal;

import a0.a.a.b;
import b.d.b.a.a;
import co.discord.media_engine.ReceiverReport;
import d0.z.d.m;
import java.util.Arrays;

/* JADX INFO: compiled from: NativeStatistics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Transport {
    private final long decryptionFailures;
    private final String localAddress;
    private final int maxPaddingBitrate;
    private final long pacerDelay;
    private final ReceiverReport[] receiverReports;
    private final int rtt;
    private final int sendBandwidth;

    public Transport(long j, int i, long j2, int i2, int i3, String str, ReceiverReport[] receiverReportArr) {
        m.checkNotNullParameter(str, "localAddress");
        this.decryptionFailures = j;
        this.maxPaddingBitrate = i;
        this.pacerDelay = j2;
        this.rtt = i2;
        this.sendBandwidth = i3;
        this.localAddress = str;
        this.receiverReports = receiverReportArr;
    }

    public static /* synthetic */ Transport copy$default(Transport transport, long j, int i, long j2, int i2, int i3, String str, ReceiverReport[] receiverReportArr, int i4, Object obj) {
        return transport.copy((i4 & 1) != 0 ? transport.decryptionFailures : j, (i4 & 2) != 0 ? transport.maxPaddingBitrate : i, (i4 & 4) != 0 ? transport.pacerDelay : j2, (i4 & 8) != 0 ? transport.rtt : i2, (i4 & 16) != 0 ? transport.sendBandwidth : i3, (i4 & 32) != 0 ? transport.localAddress : str, (i4 & 64) != 0 ? transport.receiverReports : receiverReportArr);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getDecryptionFailures() {
        return this.decryptionFailures;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMaxPaddingBitrate() {
        return this.maxPaddingBitrate;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getPacerDelay() {
        return this.pacerDelay;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getRtt() {
        return this.rtt;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getSendBandwidth() {
        return this.sendBandwidth;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getLocalAddress() {
        return this.localAddress;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final ReceiverReport[] getReceiverReports() {
        return this.receiverReports;
    }

    public final Transport copy(long decryptionFailures, int maxPaddingBitrate, long pacerDelay, int rtt, int sendBandwidth, String localAddress, ReceiverReport[] receiverReports) {
        m.checkNotNullParameter(localAddress, "localAddress");
        return new Transport(decryptionFailures, maxPaddingBitrate, pacerDelay, rtt, sendBandwidth, localAddress, receiverReports);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Transport)) {
            return false;
        }
        Transport transport = (Transport) other;
        return this.decryptionFailures == transport.decryptionFailures && this.maxPaddingBitrate == transport.maxPaddingBitrate && this.pacerDelay == transport.pacerDelay && this.rtt == transport.rtt && this.sendBandwidth == transport.sendBandwidth && m.areEqual(this.localAddress, transport.localAddress) && m.areEqual(this.receiverReports, transport.receiverReports);
    }

    public final long getDecryptionFailures() {
        return this.decryptionFailures;
    }

    public final String getLocalAddress() {
        return this.localAddress;
    }

    public final int getMaxPaddingBitrate() {
        return this.maxPaddingBitrate;
    }

    public final long getPacerDelay() {
        return this.pacerDelay;
    }

    public final ReceiverReport[] getReceiverReports() {
        return this.receiverReports;
    }

    public final int getRtt() {
        return this.rtt;
    }

    public final int getSendBandwidth() {
        return this.sendBandwidth;
    }

    public int hashCode() {
        int iA = (((((b.a(this.pacerDelay) + (((b.a(this.decryptionFailures) * 31) + this.maxPaddingBitrate) * 31)) * 31) + this.rtt) * 31) + this.sendBandwidth) * 31;
        String str = this.localAddress;
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        ReceiverReport[] receiverReportArr = this.receiverReports;
        return iHashCode + (receiverReportArr != null ? Arrays.hashCode(receiverReportArr) : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Transport(decryptionFailures=");
        sbU.append(this.decryptionFailures);
        sbU.append(", maxPaddingBitrate=");
        sbU.append(this.maxPaddingBitrate);
        sbU.append(", pacerDelay=");
        sbU.append(this.pacerDelay);
        sbU.append(", rtt=");
        sbU.append(this.rtt);
        sbU.append(", sendBandwidth=");
        sbU.append(this.sendBandwidth);
        sbU.append(", localAddress=");
        sbU.append(this.localAddress);
        sbU.append(", receiverReports=");
        sbU.append(Arrays.toString(this.receiverReports));
        sbU.append(")");
        return sbU.toString();
    }
}
