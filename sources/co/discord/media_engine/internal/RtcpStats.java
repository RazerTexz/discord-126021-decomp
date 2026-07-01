package co.discord.media_engine.internal;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: NativeStatistics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RtcpStats {
    private final long firPackets;
    private final int fractionLost;
    private final long nackPackets;
    private final long nackRequests;
    private final int packetsLost;
    private final long pliPackets;
    private final long uniqueNackRequests;

    public RtcpStats(int i, int i2, long j, long j2, long j3, long j4, long j5) {
        this.fractionLost = i;
        this.packetsLost = i2;
        this.firPackets = j;
        this.nackPackets = j2;
        this.nackRequests = j3;
        this.pliPackets = j4;
        this.uniqueNackRequests = j5;
    }

    public static /* synthetic */ RtcpStats copy$default(RtcpStats rtcpStats, int i, int i2, long j, long j2, long j3, long j4, long j5, int i3, Object obj) {
        return rtcpStats.copy((i3 & 1) != 0 ? rtcpStats.fractionLost : i, (i3 & 2) != 0 ? rtcpStats.packetsLost : i2, (i3 & 4) != 0 ? rtcpStats.firPackets : j, (i3 & 8) != 0 ? rtcpStats.nackPackets : j2, (i3 & 16) != 0 ? rtcpStats.nackRequests : j3, (i3 & 32) != 0 ? rtcpStats.pliPackets : j4, (i3 & 64) != 0 ? rtcpStats.uniqueNackRequests : j5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getFractionLost() {
        return this.fractionLost;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getPacketsLost() {
        return this.packetsLost;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getFirPackets() {
        return this.firPackets;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getNackPackets() {
        return this.nackPackets;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getNackRequests() {
        return this.nackRequests;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getPliPackets() {
        return this.pliPackets;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getUniqueNackRequests() {
        return this.uniqueNackRequests;
    }

    public final RtcpStats copy(int fractionLost, int packetsLost, long firPackets, long nackPackets, long nackRequests, long pliPackets, long uniqueNackRequests) {
        return new RtcpStats(fractionLost, packetsLost, firPackets, nackPackets, nackRequests, pliPackets, uniqueNackRequests);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RtcpStats)) {
            return false;
        }
        RtcpStats rtcpStats = (RtcpStats) other;
        return this.fractionLost == rtcpStats.fractionLost && this.packetsLost == rtcpStats.packetsLost && this.firPackets == rtcpStats.firPackets && this.nackPackets == rtcpStats.nackPackets && this.nackRequests == rtcpStats.nackRequests && this.pliPackets == rtcpStats.pliPackets && this.uniqueNackRequests == rtcpStats.uniqueNackRequests;
    }

    public final long getFirPackets() {
        return this.firPackets;
    }

    public final int getFractionLost() {
        return this.fractionLost;
    }

    public final long getNackPackets() {
        return this.nackPackets;
    }

    public final long getNackRequests() {
        return this.nackRequests;
    }

    public final int getPacketsLost() {
        return this.packetsLost;
    }

    public final long getPliPackets() {
        return this.pliPackets;
    }

    public final long getUniqueNackRequests() {
        return this.uniqueNackRequests;
    }

    public int hashCode() {
        return b.a(this.uniqueNackRequests) + ((b.a(this.pliPackets) + ((b.a(this.nackRequests) + ((b.a(this.nackPackets) + ((b.a(this.firPackets) + (((this.fractionLost * 31) + this.packetsLost) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("RtcpStats(fractionLost=");
        sbU.append(this.fractionLost);
        sbU.append(", packetsLost=");
        sbU.append(this.packetsLost);
        sbU.append(", firPackets=");
        sbU.append(this.firPackets);
        sbU.append(", nackPackets=");
        sbU.append(this.nackPackets);
        sbU.append(", nackRequests=");
        sbU.append(this.nackRequests);
        sbU.append(", pliPackets=");
        sbU.append(this.pliPackets);
        sbU.append(", uniqueNackRequests=");
        return a.C(sbU, this.uniqueNackRequests, ")");
    }
}
