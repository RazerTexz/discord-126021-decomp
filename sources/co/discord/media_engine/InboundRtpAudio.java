package co.discord.media_engine;

import a0.a.a.b;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: Statistics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class InboundRtpAudio {
    private final boolean audioDetected;
    private final PlayoutMetric audioJitterBuffer;
    private final PlayoutMetric audioJitterDelay;
    private final PlayoutMetric audioJitterTarget;
    private final float audioLevel;
    private final PlayoutMetric audioPlayoutUnderruns;
    private final long bytesReceived;
    private final StatsCodec codec;
    private final int decodingCNG;
    private final int decodingMutedOutput;
    private final int decodingNormal;
    private final int decodingPLC;
    private final int decodingPLCCNG;
    private final long delayEstimate;
    private final long jitter;
    private final long jitterBuffer;
    private final long jitterBufferPreferred;
    private final Long opAccelerate;
    private final Long opCNG;
    private final Long opExpand;
    private final Long opMerge;
    private final Long opNormal;
    private final Long opPreemptiveExpand;
    private final Long opSilence;
    private final long packetsLost;
    private final long packetsReceived;
    private final PlayoutMetric relativePlayoutDelay;
    private final PlayoutMetric relativeReceptionDelay;
    private final long ssrc;
    private final String type;

    public InboundRtpAudio(String str, long j, StatsCodec statsCodec, long j2, long j3, long j4, float f, boolean z2, long j5, long j6, long j7, long j8, int i, int i2, int i3, int i4, int i5, Long l, Long l2, Long l3, Long l4, Long l5, Long l6, Long l7, PlayoutMetric playoutMetric, PlayoutMetric playoutMetric2, PlayoutMetric playoutMetric3, PlayoutMetric playoutMetric4, PlayoutMetric playoutMetric5, PlayoutMetric playoutMetric6) {
        Intrinsics3.checkNotNullParameter(str, "type");
        Intrinsics3.checkNotNullParameter(statsCodec, "codec");
        this.type = str;
        this.ssrc = j;
        this.codec = statsCodec;
        this.bytesReceived = j2;
        this.packetsReceived = j3;
        this.packetsLost = j4;
        this.audioLevel = f;
        this.audioDetected = z2;
        this.jitter = j5;
        this.jitterBuffer = j6;
        this.jitterBufferPreferred = j7;
        this.delayEstimate = j8;
        this.decodingCNG = i;
        this.decodingMutedOutput = i2;
        this.decodingNormal = i3;
        this.decodingPLC = i4;
        this.decodingPLCCNG = i5;
        this.opSilence = l;
        this.opNormal = l2;
        this.opMerge = l3;
        this.opExpand = l4;
        this.opAccelerate = l5;
        this.opPreemptiveExpand = l6;
        this.opCNG = l7;
        this.audioJitterBuffer = playoutMetric;
        this.audioJitterDelay = playoutMetric2;
        this.audioJitterTarget = playoutMetric3;
        this.audioPlayoutUnderruns = playoutMetric4;
        this.relativeReceptionDelay = playoutMetric5;
        this.relativePlayoutDelay = playoutMetric6;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final long getJitterBuffer() {
        return this.jitterBuffer;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final long getJitterBufferPreferred() {
        return this.jitterBufferPreferred;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final long getDelayEstimate() {
        return this.delayEstimate;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getDecodingCNG() {
        return this.decodingCNG;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getDecodingMutedOutput() {
        return this.decodingMutedOutput;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getDecodingNormal() {
        return this.decodingNormal;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final int getDecodingPLC() {
        return this.decodingPLC;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final int getDecodingPLCCNG() {
        return this.decodingPLCCNG;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final Long getOpSilence() {
        return this.opSilence;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final Long getOpNormal() {
        return this.opNormal;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getSsrc() {
        return this.ssrc;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final Long getOpMerge() {
        return this.opMerge;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final Long getOpExpand() {
        return this.opExpand;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final Long getOpAccelerate() {
        return this.opAccelerate;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final Long getOpPreemptiveExpand() {
        return this.opPreemptiveExpand;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final Long getOpCNG() {
        return this.opCNG;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final PlayoutMetric getAudioJitterBuffer() {
        return this.audioJitterBuffer;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final PlayoutMetric getAudioJitterDelay() {
        return this.audioJitterDelay;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final PlayoutMetric getAudioJitterTarget() {
        return this.audioJitterTarget;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final PlayoutMetric getAudioPlayoutUnderruns() {
        return this.audioPlayoutUnderruns;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final PlayoutMetric getRelativeReceptionDelay() {
        return this.relativeReceptionDelay;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final StatsCodec getCodec() {
        return this.codec;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final PlayoutMetric getRelativePlayoutDelay() {
        return this.relativePlayoutDelay;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getBytesReceived() {
        return this.bytesReceived;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getPacketsReceived() {
        return this.packetsReceived;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getPacketsLost() {
        return this.packetsLost;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final float getAudioLevel() {
        return this.audioLevel;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getAudioDetected() {
        return this.audioDetected;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final long getJitter() {
        return this.jitter;
    }

    public final InboundRtpAudio copy(String type, long ssrc, StatsCodec codec, long bytesReceived, long packetsReceived, long packetsLost, float audioLevel, boolean audioDetected, long jitter, long jitterBuffer, long jitterBufferPreferred, long delayEstimate, int decodingCNG, int decodingMutedOutput, int decodingNormal, int decodingPLC, int decodingPLCCNG, Long opSilence, Long opNormal, Long opMerge, Long opExpand, Long opAccelerate, Long opPreemptiveExpand, Long opCNG, PlayoutMetric audioJitterBuffer, PlayoutMetric audioJitterDelay, PlayoutMetric audioJitterTarget, PlayoutMetric audioPlayoutUnderruns, PlayoutMetric relativeReceptionDelay, PlayoutMetric relativePlayoutDelay) {
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(codec, "codec");
        return new InboundRtpAudio(type, ssrc, codec, bytesReceived, packetsReceived, packetsLost, audioLevel, audioDetected, jitter, jitterBuffer, jitterBufferPreferred, delayEstimate, decodingCNG, decodingMutedOutput, decodingNormal, decodingPLC, decodingPLCCNG, opSilence, opNormal, opMerge, opExpand, opAccelerate, opPreemptiveExpand, opCNG, audioJitterBuffer, audioJitterDelay, audioJitterTarget, audioPlayoutUnderruns, relativeReceptionDelay, relativePlayoutDelay);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboundRtpAudio)) {
            return false;
        }
        InboundRtpAudio inboundRtpAudio = (InboundRtpAudio) other;
        return Intrinsics3.areEqual(this.type, inboundRtpAudio.type) && this.ssrc == inboundRtpAudio.ssrc && Intrinsics3.areEqual(this.codec, inboundRtpAudio.codec) && this.bytesReceived == inboundRtpAudio.bytesReceived && this.packetsReceived == inboundRtpAudio.packetsReceived && this.packetsLost == inboundRtpAudio.packetsLost && Float.compare(this.audioLevel, inboundRtpAudio.audioLevel) == 0 && this.audioDetected == inboundRtpAudio.audioDetected && this.jitter == inboundRtpAudio.jitter && this.jitterBuffer == inboundRtpAudio.jitterBuffer && this.jitterBufferPreferred == inboundRtpAudio.jitterBufferPreferred && this.delayEstimate == inboundRtpAudio.delayEstimate && this.decodingCNG == inboundRtpAudio.decodingCNG && this.decodingMutedOutput == inboundRtpAudio.decodingMutedOutput && this.decodingNormal == inboundRtpAudio.decodingNormal && this.decodingPLC == inboundRtpAudio.decodingPLC && this.decodingPLCCNG == inboundRtpAudio.decodingPLCCNG && Intrinsics3.areEqual(this.opSilence, inboundRtpAudio.opSilence) && Intrinsics3.areEqual(this.opNormal, inboundRtpAudio.opNormal) && Intrinsics3.areEqual(this.opMerge, inboundRtpAudio.opMerge) && Intrinsics3.areEqual(this.opExpand, inboundRtpAudio.opExpand) && Intrinsics3.areEqual(this.opAccelerate, inboundRtpAudio.opAccelerate) && Intrinsics3.areEqual(this.opPreemptiveExpand, inboundRtpAudio.opPreemptiveExpand) && Intrinsics3.areEqual(this.opCNG, inboundRtpAudio.opCNG) && Intrinsics3.areEqual(this.audioJitterBuffer, inboundRtpAudio.audioJitterBuffer) && Intrinsics3.areEqual(this.audioJitterDelay, inboundRtpAudio.audioJitterDelay) && Intrinsics3.areEqual(this.audioJitterTarget, inboundRtpAudio.audioJitterTarget) && Intrinsics3.areEqual(this.audioPlayoutUnderruns, inboundRtpAudio.audioPlayoutUnderruns) && Intrinsics3.areEqual(this.relativeReceptionDelay, inboundRtpAudio.relativeReceptionDelay) && Intrinsics3.areEqual(this.relativePlayoutDelay, inboundRtpAudio.relativePlayoutDelay);
    }

    public final boolean getAudioDetected() {
        return this.audioDetected;
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

    public final float getAudioLevel() {
        return this.audioLevel;
    }

    public final PlayoutMetric getAudioPlayoutUnderruns() {
        return this.audioPlayoutUnderruns;
    }

    public final long getBytesReceived() {
        return this.bytesReceived;
    }

    public final StatsCodec getCodec() {
        return this.codec;
    }

    public final int getDecodingCNG() {
        return this.decodingCNG;
    }

    public final int getDecodingMutedOutput() {
        return this.decodingMutedOutput;
    }

    public final int getDecodingNormal() {
        return this.decodingNormal;
    }

    public final int getDecodingPLC() {
        return this.decodingPLC;
    }

    public final int getDecodingPLCCNG() {
        return this.decodingPLCCNG;
    }

    public final long getDelayEstimate() {
        return this.delayEstimate;
    }

    public final long getJitter() {
        return this.jitter;
    }

    public final long getJitterBuffer() {
        return this.jitterBuffer;
    }

    public final long getJitterBufferPreferred() {
        return this.jitterBufferPreferred;
    }

    public final Long getOpAccelerate() {
        return this.opAccelerate;
    }

    public final Long getOpCNG() {
        return this.opCNG;
    }

    public final Long getOpExpand() {
        return this.opExpand;
    }

    public final Long getOpMerge() {
        return this.opMerge;
    }

    public final Long getOpNormal() {
        return this.opNormal;
    }

    public final Long getOpPreemptiveExpand() {
        return this.opPreemptiveExpand;
    }

    public final Long getOpSilence() {
        return this.opSilence;
    }

    public final long getPacketsLost() {
        return this.packetsLost;
    }

    public final long getPacketsReceived() {
        return this.packetsReceived;
    }

    public final PlayoutMetric getRelativePlayoutDelay() {
        return this.relativePlayoutDelay;
    }

    public final PlayoutMetric getRelativeReceptionDelay() {
        return this.relativeReceptionDelay;
    }

    public final long getSsrc() {
        return this.ssrc;
    }

    public final String getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v75 */
    /* JADX WARN: Type inference failed for: r0v78 */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    public int hashCode() {
        String str = this.type;
        int iA = (b.a(this.ssrc) + ((str != null ? str.hashCode() : 0) * 31)) * 31;
        StatsCodec statsCodec = this.codec;
        int iFloatToIntBits = (Float.floatToIntBits(this.audioLevel) + ((b.a(this.packetsLost) + ((b.a(this.packetsReceived) + ((b.a(this.bytesReceived) + ((iA + (statsCodec != null ? statsCodec.hashCode() : 0)) * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z2 = this.audioDetected;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int iA2 = (((((((((((b.a(this.delayEstimate) + ((b.a(this.jitterBufferPreferred) + ((b.a(this.jitterBuffer) + ((b.a(this.jitter) + ((iFloatToIntBits + r0) * 31)) * 31)) * 31)) * 31)) * 31) + this.decodingCNG) * 31) + this.decodingMutedOutput) * 31) + this.decodingNormal) * 31) + this.decodingPLC) * 31) + this.decodingPLCCNG) * 31;
        Long l = this.opSilence;
        int iHashCode = (iA2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.opNormal;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.opMerge;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.opExpand;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.opAccelerate;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.opPreemptiveExpand;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.opCNG;
        int iHashCode7 = (iHashCode6 + (l7 != null ? l7.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric = this.audioJitterBuffer;
        int iHashCode8 = (iHashCode7 + (playoutMetric != null ? playoutMetric.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric2 = this.audioJitterDelay;
        int iHashCode9 = (iHashCode8 + (playoutMetric2 != null ? playoutMetric2.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric3 = this.audioJitterTarget;
        int iHashCode10 = (iHashCode9 + (playoutMetric3 != null ? playoutMetric3.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric4 = this.audioPlayoutUnderruns;
        int iHashCode11 = (iHashCode10 + (playoutMetric4 != null ? playoutMetric4.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric5 = this.relativeReceptionDelay;
        int iHashCode12 = (iHashCode11 + (playoutMetric5 != null ? playoutMetric5.hashCode() : 0)) * 31;
        PlayoutMetric playoutMetric6 = this.relativePlayoutDelay;
        return iHashCode12 + (playoutMetric6 != null ? playoutMetric6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("InboundRtpAudio(type=");
        sbU.append(this.type);
        sbU.append(", ssrc=");
        sbU.append(this.ssrc);
        sbU.append(", codec=");
        sbU.append(this.codec);
        sbU.append(", bytesReceived=");
        sbU.append(this.bytesReceived);
        sbU.append(", packetsReceived=");
        sbU.append(this.packetsReceived);
        sbU.append(", packetsLost=");
        sbU.append(this.packetsLost);
        sbU.append(", audioLevel=");
        sbU.append(this.audioLevel);
        sbU.append(", audioDetected=");
        sbU.append(this.audioDetected);
        sbU.append(", jitter=");
        sbU.append(this.jitter);
        sbU.append(", jitterBuffer=");
        sbU.append(this.jitterBuffer);
        sbU.append(", jitterBufferPreferred=");
        sbU.append(this.jitterBufferPreferred);
        sbU.append(", delayEstimate=");
        sbU.append(this.delayEstimate);
        sbU.append(", decodingCNG=");
        sbU.append(this.decodingCNG);
        sbU.append(", decodingMutedOutput=");
        sbU.append(this.decodingMutedOutput);
        sbU.append(", decodingNormal=");
        sbU.append(this.decodingNormal);
        sbU.append(", decodingPLC=");
        sbU.append(this.decodingPLC);
        sbU.append(", decodingPLCCNG=");
        sbU.append(this.decodingPLCCNG);
        sbU.append(", opSilence=");
        sbU.append(this.opSilence);
        sbU.append(", opNormal=");
        sbU.append(this.opNormal);
        sbU.append(", opMerge=");
        sbU.append(this.opMerge);
        sbU.append(", opExpand=");
        sbU.append(this.opExpand);
        sbU.append(", opAccelerate=");
        sbU.append(this.opAccelerate);
        sbU.append(", opPreemptiveExpand=");
        sbU.append(this.opPreemptiveExpand);
        sbU.append(", opCNG=");
        sbU.append(this.opCNG);
        sbU.append(", audioJitterBuffer=");
        sbU.append(this.audioJitterBuffer);
        sbU.append(", audioJitterDelay=");
        sbU.append(this.audioJitterDelay);
        sbU.append(", audioJitterTarget=");
        sbU.append(this.audioJitterTarget);
        sbU.append(", audioPlayoutUnderruns=");
        sbU.append(this.audioPlayoutUnderruns);
        sbU.append(", relativeReceptionDelay=");
        sbU.append(this.relativeReceptionDelay);
        sbU.append(", relativePlayoutDelay=");
        sbU.append(this.relativePlayoutDelay);
        sbU.append(")");
        return sbU.toString();
    }
}
