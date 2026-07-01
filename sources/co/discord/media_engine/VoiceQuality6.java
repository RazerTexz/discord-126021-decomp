package co.discord.media_engine;

import a0.a.a.b;
import b.d.b.a.outline;

/* JADX INFO: renamed from: co.discord.media_engine.OutboundAudio, reason: use source file name */
/* JADX INFO: compiled from: VoiceQuality.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class VoiceQuality6 {
    private final int packetsLost;
    private final long packetsSent;

    public VoiceQuality6(long j, int i) {
        this.packetsSent = j;
        this.packetsLost = i;
    }

    public static /* synthetic */ VoiceQuality6 copy$default(VoiceQuality6 voiceQuality6, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = voiceQuality6.packetsSent;
        }
        if ((i2 & 2) != 0) {
            i = voiceQuality6.packetsLost;
        }
        return voiceQuality6.copy(j, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getPacketsSent() {
        return this.packetsSent;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getPacketsLost() {
        return this.packetsLost;
    }

    public final VoiceQuality6 copy(long packetsSent, int packetsLost) {
        return new VoiceQuality6(packetsSent, packetsLost);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceQuality6)) {
            return false;
        }
        VoiceQuality6 voiceQuality6 = (VoiceQuality6) other;
        return this.packetsSent == voiceQuality6.packetsSent && this.packetsLost == voiceQuality6.packetsLost;
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
        StringBuilder sbU = outline.U("OutboundAudio(packetsSent=");
        sbU.append(this.packetsSent);
        sbU.append(", packetsLost=");
        return outline.B(sbU, this.packetsLost, ")");
    }
}
