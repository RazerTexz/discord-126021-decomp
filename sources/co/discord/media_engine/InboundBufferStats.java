package co.discord.media_engine;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: VoiceQuality.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class InboundBufferStats {
    private final PlayoutMetric audioJitterBuffer;
    private final PlayoutMetric audioJitterDelay;
    private final PlayoutMetric audioJitterTarget;
    private final PlayoutMetric relativePlayoutDelay;
    private final PlayoutMetric relativeReceptionDelay;

    public InboundBufferStats(PlayoutMetric playoutMetric, PlayoutMetric playoutMetric2, PlayoutMetric playoutMetric3, PlayoutMetric playoutMetric4, PlayoutMetric playoutMetric5) {
        this.audioJitterBuffer = playoutMetric;
        this.audioJitterTarget = playoutMetric2;
        this.audioJitterDelay = playoutMetric3;
        this.relativeReceptionDelay = playoutMetric4;
        this.relativePlayoutDelay = playoutMetric5;
    }

    public static /* synthetic */ InboundBufferStats copy$default(InboundBufferStats inboundBufferStats, PlayoutMetric playoutMetric, PlayoutMetric playoutMetric2, PlayoutMetric playoutMetric3, PlayoutMetric playoutMetric4, PlayoutMetric playoutMetric5, int i, Object obj) {
        if ((i & 1) != 0) {
            playoutMetric = inboundBufferStats.audioJitterBuffer;
        }
        if ((i & 2) != 0) {
            playoutMetric2 = inboundBufferStats.audioJitterTarget;
        }
        PlayoutMetric playoutMetric6 = playoutMetric2;
        if ((i & 4) != 0) {
            playoutMetric3 = inboundBufferStats.audioJitterDelay;
        }
        PlayoutMetric playoutMetric7 = playoutMetric3;
        if ((i & 8) != 0) {
            playoutMetric4 = inboundBufferStats.relativeReceptionDelay;
        }
        PlayoutMetric playoutMetric8 = playoutMetric4;
        if ((i & 16) != 0) {
            playoutMetric5 = inboundBufferStats.relativePlayoutDelay;
        }
        return inboundBufferStats.copy(playoutMetric, playoutMetric6, playoutMetric7, playoutMetric8, playoutMetric5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PlayoutMetric getAudioJitterBuffer() {
        return this.audioJitterBuffer;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PlayoutMetric getAudioJitterTarget() {
        return this.audioJitterTarget;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PlayoutMetric getAudioJitterDelay() {
        return this.audioJitterDelay;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final PlayoutMetric getRelativeReceptionDelay() {
        return this.relativeReceptionDelay;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final PlayoutMetric getRelativePlayoutDelay() {
        return this.relativePlayoutDelay;
    }

    public final InboundBufferStats copy(PlayoutMetric audioJitterBuffer, PlayoutMetric audioJitterTarget, PlayoutMetric audioJitterDelay, PlayoutMetric relativeReceptionDelay, PlayoutMetric relativePlayoutDelay) {
        return new InboundBufferStats(audioJitterBuffer, audioJitterTarget, audioJitterDelay, relativeReceptionDelay, relativePlayoutDelay);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboundBufferStats)) {
            return false;
        }
        InboundBufferStats inboundBufferStats = (InboundBufferStats) other;
        return m.areEqual(this.audioJitterBuffer, inboundBufferStats.audioJitterBuffer) && m.areEqual(this.audioJitterTarget, inboundBufferStats.audioJitterTarget) && m.areEqual(this.audioJitterDelay, inboundBufferStats.audioJitterDelay) && m.areEqual(this.relativeReceptionDelay, inboundBufferStats.relativeReceptionDelay) && m.areEqual(this.relativePlayoutDelay, inboundBufferStats.relativePlayoutDelay);
    }

    public final PlayoutMetric getAudioJitterBuffer() {
        return this.audioJitterBuffer;
    }

    public final PlayoutMetric getAudioJitterDelay() {
        return this.audioJitterDelay;
    }

    public final PlayoutMetric getAudioJitterTarget() {
        return this.audioJitterTarget;
    }

    public final PlayoutMetric getRelativePlayoutDelay() {
        return this.relativePlayoutDelay;
    }

    public final PlayoutMetric getRelativeReceptionDelay() {
        return this.relativeReceptionDelay;
    }

    public int hashCode() {
        PlayoutMetric playoutMetric = this.audioJitterBuffer;
        int iHashCode = (playoutMetric != null ? playoutMetric.hashCode() : 0) * 31;
        PlayoutMetric playoutMetric2 = this.audioJitterTarget;
        int iHashCode2 = (iHashCode + (playoutMetric2 != null ? playoutMetric2.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric3 = this.audioJitterDelay;
        int iHashCode3 = (iHashCode2 + (playoutMetric3 != null ? playoutMetric3.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric4 = this.relativeReceptionDelay;
        int iHashCode4 = (iHashCode3 + (playoutMetric4 != null ? playoutMetric4.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric5 = this.relativePlayoutDelay;
        return iHashCode4 + (playoutMetric5 != null ? playoutMetric5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("InboundBufferStats(audioJitterBuffer=");
        sbU.append(this.audioJitterBuffer);
        sbU.append(", audioJitterTarget=");
        sbU.append(this.audioJitterTarget);
        sbU.append(", audioJitterDelay=");
        sbU.append(this.audioJitterDelay);
        sbU.append(", relativeReceptionDelay=");
        sbU.append(this.relativeReceptionDelay);
        sbU.append(", relativePlayoutDelay=");
        sbU.append(this.relativePlayoutDelay);
        sbU.append(")");
        return sbU.toString();
    }
}
