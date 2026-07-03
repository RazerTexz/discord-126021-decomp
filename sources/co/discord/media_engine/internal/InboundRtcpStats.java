package co.discord.media_engine.internal;

import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: compiled from: NativeStatistics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class InboundRtcpStats {
    private final long firPackets;
    private final long nackPackets;
    private final long nackRequests;
    private final long pliPackets;
    private final long uniqueNackRequests;

    public InboundRtcpStats(long j, long j2, long j3, long j4, long j5) {
        this.firPackets = j;
        this.nackPackets = j2;
        this.nackRequests = j3;
        this.pliPackets = j4;
        this.uniqueNackRequests = j5;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getFirPackets() {
        return this.firPackets;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getNackPackets() {
        return this.nackPackets;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getNackRequests() {
        return this.nackRequests;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getPliPackets() {
        return this.pliPackets;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getUniqueNackRequests() {
        return this.uniqueNackRequests;
    }

    public final InboundRtcpStats copy(long firPackets, long nackPackets, long nackRequests, long pliPackets, long uniqueNackRequests) {
        return new InboundRtcpStats(firPackets, nackPackets, nackRequests, pliPackets, uniqueNackRequests);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboundRtcpStats)) {
            return false;
        }
        InboundRtcpStats inboundRtcpStats = (InboundRtcpStats) other;
        return this.firPackets == inboundRtcpStats.firPackets && this.nackPackets == inboundRtcpStats.nackPackets && this.nackRequests == inboundRtcpStats.nackRequests && this.pliPackets == inboundRtcpStats.pliPackets && this.uniqueNackRequests == inboundRtcpStats.uniqueNackRequests;
    }

    public final long getFirPackets() {
        return this.firPackets;
    }

    public final long getNackPackets() {
        return this.nackPackets;
    }

    public final long getNackRequests() {
        return this.nackRequests;
    }

    public final long getPliPackets() {
        return this.pliPackets;
    }

    public final long getUniqueNackRequests() {
        return this.uniqueNackRequests;
    }

    public int hashCode() {
        return C0002b.m3a(this.uniqueNackRequests) + ((C0002b.m3a(this.pliPackets) + ((C0002b.m3a(this.nackRequests) + ((C0002b.m3a(this.nackPackets) + (C0002b.m3a(this.firPackets) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("InboundRtcpStats(firPackets=");
        sbM833U.append(this.firPackets);
        sbM833U.append(", nackPackets=");
        sbM833U.append(this.nackPackets);
        sbM833U.append(", nackRequests=");
        sbM833U.append(this.nackRequests);
        sbM833U.append(", pliPackets=");
        sbM833U.append(this.pliPackets);
        sbM833U.append(", uniqueNackRequests=");
        return C1643a.m815C(sbM833U, this.uniqueNackRequests, ")");
    }
}
