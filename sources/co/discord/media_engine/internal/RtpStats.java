package co.discord.media_engine.internal;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: NativeStatistics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RtpStats {
    private final PacketStats fec;
    private final PacketStats retransmitted;
    private final PacketStats transmitted;

    public RtpStats(PacketStats packetStats, PacketStats packetStats2, PacketStats packetStats3) {
        C12238m.checkNotNullParameter(packetStats, "fec");
        C12238m.checkNotNullParameter(packetStats2, "retransmitted");
        C12238m.checkNotNullParameter(packetStats3, "transmitted");
        this.fec = packetStats;
        this.retransmitted = packetStats2;
        this.transmitted = packetStats3;
    }

    public static /* synthetic */ RtpStats copy$default(RtpStats rtpStats, PacketStats packetStats, PacketStats packetStats2, PacketStats packetStats3, int i, Object obj) {
        if ((i & 1) != 0) {
            packetStats = rtpStats.fec;
        }
        if ((i & 2) != 0) {
            packetStats2 = rtpStats.retransmitted;
        }
        if ((i & 4) != 0) {
            packetStats3 = rtpStats.transmitted;
        }
        return rtpStats.copy(packetStats, packetStats2, packetStats3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PacketStats getFec() {
        return this.fec;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PacketStats getRetransmitted() {
        return this.retransmitted;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PacketStats getTransmitted() {
        return this.transmitted;
    }

    public final RtpStats copy(PacketStats fec, PacketStats retransmitted, PacketStats transmitted) {
        C12238m.checkNotNullParameter(fec, "fec");
        C12238m.checkNotNullParameter(retransmitted, "retransmitted");
        C12238m.checkNotNullParameter(transmitted, "transmitted");
        return new RtpStats(fec, retransmitted, transmitted);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RtpStats)) {
            return false;
        }
        RtpStats rtpStats = (RtpStats) other;
        return C12238m.areEqual(this.fec, rtpStats.fec) && C12238m.areEqual(this.retransmitted, rtpStats.retransmitted) && C12238m.areEqual(this.transmitted, rtpStats.transmitted);
    }

    public final PacketStats getFec() {
        return this.fec;
    }

    public final PacketStats getRetransmitted() {
        return this.retransmitted;
    }

    public final PacketStats getTransmitted() {
        return this.transmitted;
    }

    public int hashCode() {
        PacketStats packetStats = this.fec;
        int iHashCode = (packetStats != null ? packetStats.hashCode() : 0) * 31;
        PacketStats packetStats2 = this.retransmitted;
        int iHashCode2 = (iHashCode + (packetStats2 != null ? packetStats2.hashCode() : 0)) * 31;
        PacketStats packetStats3 = this.transmitted;
        return iHashCode2 + (packetStats3 != null ? packetStats3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("RtpStats(fec=");
        sbM833U.append(this.fec);
        sbM833U.append(", retransmitted=");
        sbM833U.append(this.retransmitted);
        sbM833U.append(", transmitted=");
        sbM833U.append(this.transmitted);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
