package co.discord.media_engine.internal;

import co.discord.media_engine.ReceiverReport;
import java.util.Arrays;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        C12238m.checkNotNullParameter(str, "localAddress");
        this.decryptionFailures = j;
        this.maxPaddingBitrate = i;
        this.pacerDelay = j2;
        this.rtt = i2;
        this.sendBandwidth = i3;
        this.localAddress = str;
        this.receiverReports = receiverReportArr;
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
        C12238m.checkNotNullParameter(localAddress, "localAddress");
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
        return this.decryptionFailures == transport.decryptionFailures && this.maxPaddingBitrate == transport.maxPaddingBitrate && this.pacerDelay == transport.pacerDelay && this.rtt == transport.rtt && this.sendBandwidth == transport.sendBandwidth && C12238m.areEqual(this.localAddress, transport.localAddress) && C12238m.areEqual(this.receiverReports, transport.receiverReports);
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
        int iM3a = (((((C0002b.m3a(this.pacerDelay) + (((C0002b.m3a(this.decryptionFailures) * 31) + this.maxPaddingBitrate) * 31)) * 31) + this.rtt) * 31) + this.sendBandwidth) * 31;
        String str = this.localAddress;
        int iHashCode = (iM3a + (str != null ? str.hashCode() : 0)) * 31;
        ReceiverReport[] receiverReportArr = this.receiverReports;
        return iHashCode + (receiverReportArr != null ? Arrays.hashCode(receiverReportArr) : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("Transport(decryptionFailures=");
        sbM833U.append(this.decryptionFailures);
        sbM833U.append(", maxPaddingBitrate=");
        sbM833U.append(this.maxPaddingBitrate);
        sbM833U.append(", pacerDelay=");
        sbM833U.append(this.pacerDelay);
        sbM833U.append(", rtt=");
        sbM833U.append(this.rtt);
        sbM833U.append(", sendBandwidth=");
        sbM833U.append(this.sendBandwidth);
        sbM833U.append(", localAddress=");
        sbM833U.append(this.localAddress);
        sbM833U.append(", receiverReports=");
        sbM833U.append(Arrays.toString(this.receiverReports));
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
