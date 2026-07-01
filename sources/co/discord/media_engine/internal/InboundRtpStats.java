package co.discord.media_engine.internal;

import a0.a.a.b;
import b.d.b.a.outline;

/* JADX INFO: compiled from: NativeStatistics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class InboundRtpStats {
    private final long headerBytes;
    private final long jitter;
    private final long packets;
    private final int packetsLost;
    private final long paddingBytes;
    private final long payloadBytes;

    public InboundRtpStats(long j, long j2, int i, long j3, long j4, long j5) {
        this.packets = j;
        this.jitter = j2;
        this.packetsLost = i;
        this.headerBytes = j3;
        this.paddingBytes = j4;
        this.payloadBytes = j5;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getPackets() {
        return this.packets;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getJitter() {
        return this.jitter;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getPacketsLost() {
        return this.packetsLost;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getHeaderBytes() {
        return this.headerBytes;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getPaddingBytes() {
        return this.paddingBytes;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getPayloadBytes() {
        return this.payloadBytes;
    }

    public final InboundRtpStats copy(long packets, long jitter, int packetsLost, long headerBytes, long paddingBytes, long payloadBytes) {
        return new InboundRtpStats(packets, jitter, packetsLost, headerBytes, paddingBytes, payloadBytes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboundRtpStats)) {
            return false;
        }
        InboundRtpStats inboundRtpStats = (InboundRtpStats) other;
        return this.packets == inboundRtpStats.packets && this.jitter == inboundRtpStats.jitter && this.packetsLost == inboundRtpStats.packetsLost && this.headerBytes == inboundRtpStats.headerBytes && this.paddingBytes == inboundRtpStats.paddingBytes && this.payloadBytes == inboundRtpStats.payloadBytes;
    }

    public final long getHeaderBytes() {
        return this.headerBytes;
    }

    public final long getJitter() {
        return this.jitter;
    }

    public final long getPackets() {
        return this.packets;
    }

    public final int getPacketsLost() {
        return this.packetsLost;
    }

    public final long getPaddingBytes() {
        return this.paddingBytes;
    }

    public final long getPayloadBytes() {
        return this.payloadBytes;
    }

    public int hashCode() {
        return b.a(this.payloadBytes) + ((b.a(this.paddingBytes) + ((b.a(this.headerBytes) + ((((b.a(this.jitter) + (b.a(this.packets) * 31)) * 31) + this.packetsLost) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("InboundRtpStats(packets=");
        sbU.append(this.packets);
        sbU.append(", jitter=");
        sbU.append(this.jitter);
        sbU.append(", packetsLost=");
        sbU.append(this.packetsLost);
        sbU.append(", headerBytes=");
        sbU.append(this.headerBytes);
        sbU.append(", paddingBytes=");
        sbU.append(this.paddingBytes);
        sbU.append(", payloadBytes=");
        return outline.C(sbU, this.payloadBytes, ")");
    }
}
