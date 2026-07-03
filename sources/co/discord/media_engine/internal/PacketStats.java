package co.discord.media_engine.internal;

import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;

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
        return C0002b.m3a(this.payloadBytes) + ((C0002b.m3a(this.paddingBytes) + ((C0002b.m3a(this.packets) + (C0002b.m3a(this.headerBytes) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("PacketStats(headerBytes=");
        sbM833U.append(this.headerBytes);
        sbM833U.append(", packets=");
        sbM833U.append(this.packets);
        sbM833U.append(", paddingBytes=");
        sbM833U.append(this.paddingBytes);
        sbM833U.append(", payloadBytes=");
        return C1643a.m815C(sbM833U, this.payloadBytes, ")");
    }
}
