package co.discord.media_engine;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;
import java.util.Arrays;

/* JADX INFO: compiled from: Statistics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Transport {
    private final int availableOutgoingBitrate;
    private final long bytesReceived;
    private final long bytesSent;
    private final Integer decryptionFailures;
    private final String localAddress;
    private final int ping;
    private final ReceiverReport[] receiverReports;

    public Transport(int i, long j, long j2, int i2, Integer num, String str, ReceiverReport[] receiverReportArr) {
        this.availableOutgoingBitrate = i;
        this.bytesReceived = j;
        this.bytesSent = j2;
        this.ping = i2;
        this.decryptionFailures = num;
        this.localAddress = str;
        this.receiverReports = receiverReportArr;
    }

    public static /* synthetic */ Transport copy$default(Transport transport, int i, long j, long j2, int i2, Integer num, String str, ReceiverReport[] receiverReportArr, int i3, Object obj) {
        return transport.copy((i3 & 1) != 0 ? transport.availableOutgoingBitrate : i, (i3 & 2) != 0 ? transport.bytesReceived : j, (i3 & 4) != 0 ? transport.bytesSent : j2, (i3 & 8) != 0 ? transport.ping : i2, (i3 & 16) != 0 ? transport.decryptionFailures : num, (i3 & 32) != 0 ? transport.localAddress : str, (i3 & 64) != 0 ? transport.receiverReports : receiverReportArr);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getAvailableOutgoingBitrate() {
        return this.availableOutgoingBitrate;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getBytesReceived() {
        return this.bytesReceived;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getBytesSent() {
        return this.bytesSent;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getPing() {
        return this.ping;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getDecryptionFailures() {
        return this.decryptionFailures;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getLocalAddress() {
        return this.localAddress;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final ReceiverReport[] getReceiverReports() {
        return this.receiverReports;
    }

    public final Transport copy(int availableOutgoingBitrate, long bytesReceived, long bytesSent, int ping, Integer decryptionFailures, String localAddress, ReceiverReport[] receiverReports) {
        return new Transport(availableOutgoingBitrate, bytesReceived, bytesSent, ping, decryptionFailures, localAddress, receiverReports);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Transport)) {
            return false;
        }
        Transport transport = (Transport) other;
        return this.availableOutgoingBitrate == transport.availableOutgoingBitrate && this.bytesReceived == transport.bytesReceived && this.bytesSent == transport.bytesSent && this.ping == transport.ping && m.areEqual(this.decryptionFailures, transport.decryptionFailures) && m.areEqual(this.localAddress, transport.localAddress) && m.areEqual(this.receiverReports, transport.receiverReports);
    }

    public final int getAvailableOutgoingBitrate() {
        return this.availableOutgoingBitrate;
    }

    public final long getBytesReceived() {
        return this.bytesReceived;
    }

    public final long getBytesSent() {
        return this.bytesSent;
    }

    public final Integer getDecryptionFailures() {
        return this.decryptionFailures;
    }

    public final String getLocalAddress() {
        return this.localAddress;
    }

    public final int getPing() {
        return this.ping;
    }

    public final ReceiverReport[] getReceiverReports() {
        return this.receiverReports;
    }

    public int hashCode() {
        int iA = (((b.a(this.bytesSent) + ((b.a(this.bytesReceived) + (this.availableOutgoingBitrate * 31)) * 31)) * 31) + this.ping) * 31;
        Integer num = this.decryptionFailures;
        int iHashCode = (iA + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.localAddress;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        ReceiverReport[] receiverReportArr = this.receiverReports;
        return iHashCode2 + (receiverReportArr != null ? Arrays.hashCode(receiverReportArr) : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Transport(availableOutgoingBitrate=");
        sbU.append(this.availableOutgoingBitrate);
        sbU.append(", bytesReceived=");
        sbU.append(this.bytesReceived);
        sbU.append(", bytesSent=");
        sbU.append(this.bytesSent);
        sbU.append(", ping=");
        sbU.append(this.ping);
        sbU.append(", decryptionFailures=");
        sbU.append(this.decryptionFailures);
        sbU.append(", localAddress=");
        sbU.append(this.localAddress);
        sbU.append(", receiverReports=");
        sbU.append(Arrays.toString(this.receiverReports));
        sbU.append(")");
        return sbU.toString();
    }
}
