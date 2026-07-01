package co.discord.media_engine;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: VoiceQuality.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class OutboundAudio {
    private final int packetsLost;
    private final long packetsSent;

    public OutboundAudio(long j, int i) {
        this.packetsSent = j;
        this.packetsLost = i;
    }

    public static /* synthetic */ OutboundAudio copy$default(OutboundAudio outboundAudio, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = outboundAudio.packetsSent;
        }
        if ((i2 & 2) != 0) {
            i = outboundAudio.packetsLost;
        }
        return outboundAudio.copy(j, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getPacketsSent() {
        return this.packetsSent;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getPacketsLost() {
        return this.packetsLost;
    }

    public final OutboundAudio copy(long packetsSent, int packetsLost) {
        return new OutboundAudio(packetsSent, packetsLost);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OutboundAudio)) {
            return false;
        }
        OutboundAudio outboundAudio = (OutboundAudio) other;
        return this.packetsSent == outboundAudio.packetsSent && this.packetsLost == outboundAudio.packetsLost;
    }

    public final int getPacketsLost() {
        return this.packetsLost;
    }

    public final long getPacketsSent() {
        return this.packetsSent;
    }

    public int hashCode() {
        return (b.a(this.packetsSent) * 31) + this.packetsLost;
    }

    public String toString() {
        StringBuilder sbU = a.U("OutboundAudio(packetsSent=");
        sbU.append(this.packetsSent);
        sbU.append(", packetsLost=");
        return a.B(sbU, this.packetsLost, ")");
    }
}
