package co.discord.media_engine.internal;

import a0.a.a.b;
import b.d.b.a.outline;

/* JADX INFO: compiled from: NativeStatistics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class PacketStats {
    private final long headerBytes;
    private final long packets;
    private final long paddingBytes;
    private final long payloadBytes;

    public PacketStats(long j, long j2, long j3, long j4) {
        this.headerBytes = j;
        this.packets = j2;
        this.paddingBytes = j3;
        this.payloadBytes = j4;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getHeaderBytes() {
        return this.headerBytes;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getPackets() {
        return this.packets;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getPaddingBytes() {
        return this.paddingBytes;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getPayloadBytes() {
        return this.payloadBytes;
    }

    public final PacketStats copy(long headerBytes, long packets, long paddingBytes, long payloadBytes) {
        return new PacketStats(headerBytes, packets, paddingBytes, payloadBytes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PacketStats)) {
            return false;
        }
        PacketStats packetStats = (PacketStats) other;
        return this.headerBytes == packetStats.headerBytes && this.packets == packetStats.packets && this.paddingBytes == packetStats.paddingBytes && this.payloadBytes == packetStats.payloadBytes;
    }

    public final long getHeaderBytes() {
        return this.headerBytes;
    }

    public final long getPackets() {
        return this.packets;
    }

    public final long getPaddingBytes() {
        return this.paddingBytes;
    }

    public final long getPayloadBytes() {
        return this.payloadBytes;
    }

    public int hashCode() {
        return b.a(this.payloadBytes) + ((b.a(this.paddingBytes) + ((b.a(this.packets) + (b.a(this.headerBytes) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("PacketStats(headerBytes=");
        sbU.append(this.headerBytes);
        sbU.append(", packets=");
        sbU.append(this.packets);
        sbU.append(", paddingBytes=");
        sbU.append(this.paddingBytes);
        sbU.append(", payloadBytes=");
        return outline.C(sbU, this.payloadBytes, ")");
    }
}
