package co.discord.media_engine;

import java.util.Arrays;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return this.availableOutgoingBitrate == transport.availableOutgoingBitrate && this.bytesReceived == transport.bytesReceived && this.bytesSent == transport.bytesSent && this.ping == transport.ping && C12238m.areEqual(this.decryptionFailures, transport.decryptionFailures) && C12238m.areEqual(this.localAddress, transport.localAddress) && C12238m.areEqual(this.receiverReports, transport.receiverReports);
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
        int iM3a = (((C0002b.m3a(this.bytesSent) + ((C0002b.m3a(this.bytesReceived) + (this.availableOutgoingBitrate * 31)) * 31)) * 31) + this.ping) * 31;
        Integer num = this.decryptionFailures;
        int iHashCode = (iM3a + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.localAddress;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        ReceiverReport[] receiverReportArr = this.receiverReports;
        return iHashCode2 + (receiverReportArr != null ? Arrays.hashCode(receiverReportArr) : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("Transport(availableOutgoingBitrate=");
        sbM833U.append(this.availableOutgoingBitrate);
        sbM833U.append(", bytesReceived=");
        sbM833U.append(this.bytesReceived);
        sbM833U.append(", bytesSent=");
        sbM833U.append(this.bytesSent);
        sbM833U.append(", ping=");
        sbM833U.append(this.ping);
        sbM833U.append(", decryptionFailures=");
        sbM833U.append(this.decryptionFailures);
        sbM833U.append(", localAddress=");
        sbM833U.append(this.localAddress);
        sbM833U.append(", receiverReports=");
        sbM833U.append(Arrays.toString(this.receiverReports));
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
