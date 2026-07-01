package co.discord.media_engine.internal;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: NativeStatistics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class InboundAudio {
    private final int audioLevel;
    private final long bytesReceived;
    private final String codecName;
    private final int codecPayloadType;
    private final int decodingCNG;
    private final int decodingMutedOutput;
    private final int decodingNormal;
    private final int decodingPLC;
    private final int decodingPLCCNG;
    private final long delayEstimate;
    private final long jitter;
    private final long jitterBuffer;
    private final long jitterBufferPreferred;
    private final long opAccelerate;
    private final long opCNG;
    private final long opExpand;
    private final long opMerge;
    private final long opNormal;
    private final long opPreemptiveExpand;
    private final long opSilence;
    private final long packetsLost;
    private final long packetsReceived;
    private final long speaking;
    private final long ssrc;

    public InboundAudio(int i, long j, String str, int i2, long j2, int i3, int i4, int i5, int i6, int i7, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16) {
        m.checkNotNullParameter(str, "codecName");
        this.audioLevel = i;
        this.bytesReceived = j;
        this.codecName = str;
        this.codecPayloadType = i2;
        this.delayEstimate = j2;
        this.decodingCNG = i3;
        this.decodingMutedOutput = i4;
        this.decodingNormal = i5;
        this.decodingPLC = i6;
        this.decodingPLCCNG = i7;
        this.jitter = j3;
        this.jitterBuffer = j4;
        this.jitterBufferPreferred = j5;
        this.packetsLost = j6;
        this.packetsReceived = j7;
        this.opSilence = j8;
        this.opNormal = j9;
        this.opMerge = j10;
        this.opExpand = j11;
        this.opAccelerate = j12;
        this.opPreemptiveExpand = j13;
        this.opCNG = j14;
        this.speaking = j15;
        this.ssrc = j16;
    }

    public static /* synthetic */ InboundAudio copy$default(InboundAudio inboundAudio, int i, long j, String str, int i2, long j2, int i3, int i4, int i5, int i6, int i7, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, int i8, Object obj) {
        return inboundAudio.copy((i8 & 1) != 0 ? inboundAudio.audioLevel : i, (i8 & 2) != 0 ? inboundAudio.bytesReceived : j, (i8 & 4) != 0 ? inboundAudio.codecName : str, (i8 & 8) != 0 ? inboundAudio.codecPayloadType : i2, (i8 & 16) != 0 ? inboundAudio.delayEstimate : j2, (i8 & 32) != 0 ? inboundAudio.decodingCNG : i3, (i8 & 64) != 0 ? inboundAudio.decodingMutedOutput : i4, (i8 & 128) != 0 ? inboundAudio.decodingNormal : i5, (i8 & 256) != 0 ? inboundAudio.decodingPLC : i6, (i8 & 512) != 0 ? inboundAudio.decodingPLCCNG : i7, (i8 & 1024) != 0 ? inboundAudio.jitter : j3, (i8 & 2048) != 0 ? inboundAudio.jitterBuffer : j4, (i8 & 4096) != 0 ? inboundAudio.jitterBufferPreferred : j5, (i8 & 8192) != 0 ? inboundAudio.packetsLost : j6, (i8 & 16384) != 0 ? inboundAudio.packetsReceived : j7, (i8 & 32768) != 0 ? inboundAudio.opSilence : j8, (i8 & 65536) != 0 ? inboundAudio.opNormal : j9, (i8 & 131072) != 0 ? inboundAudio.opMerge : j10, (i8 & 262144) != 0 ? inboundAudio.opExpand : j11, (i8 & 524288) != 0 ? inboundAudio.opAccelerate : j12, (i8 & 1048576) != 0 ? inboundAudio.opPreemptiveExpand : j13, (i8 & 2097152) != 0 ? inboundAudio.opCNG : j14, (i8 & 4194304) != 0 ? inboundAudio.speaking : j15, (i8 & 8388608) != 0 ? inboundAudio.ssrc : j16);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getAudioLevel() {
        return this.audioLevel;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getDecodingPLCCNG() {
        return this.decodingPLCCNG;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final long getJitter() {
        return this.jitter;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final long getJitterBuffer() {
        return this.jitterBuffer;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final long getJitterBufferPreferred() {
        return this.jitterBufferPreferred;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final long getPacketsLost() {
        return this.packetsLost;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final long getPacketsReceived() {
        return this.packetsReceived;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final long getOpSilence() {
        return this.opSilence;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final long getOpNormal() {
        return this.opNormal;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final long getOpMerge() {
        return this.opMerge;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final long getOpExpand() {
        return this.opExpand;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getBytesReceived() {
        return this.bytesReceived;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final long getOpAccelerate() {
        return this.opAccelerate;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final long getOpPreemptiveExpand() {
        return this.opPreemptiveExpand;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final long getOpCNG() {
        return this.opCNG;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final long getSpeaking() {
        return this.speaking;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final long getSsrc() {
        return this.ssrc;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCodecName() {
        return this.codecName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getCodecPayloadType() {
        return this.codecPayloadType;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getDelayEstimate() {
        return this.delayEstimate;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getDecodingCNG() {
        return this.decodingCNG;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getDecodingMutedOutput() {
        return this.decodingMutedOutput;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getDecodingNormal() {
        return this.decodingNormal;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getDecodingPLC() {
        return this.decodingPLC;
    }

    public final InboundAudio copy(int audioLevel, long bytesReceived, String codecName, int codecPayloadType, long delayEstimate, int decodingCNG, int decodingMutedOutput, int decodingNormal, int decodingPLC, int decodingPLCCNG, long jitter, long jitterBuffer, long jitterBufferPreferred, long packetsLost, long packetsReceived, long opSilence, long opNormal, long opMerge, long opExpand, long opAccelerate, long opPreemptiveExpand, long opCNG, long speaking, long ssrc) {
        m.checkNotNullParameter(codecName, "codecName");
        return new InboundAudio(audioLevel, bytesReceived, codecName, codecPayloadType, delayEstimate, decodingCNG, decodingMutedOutput, decodingNormal, decodingPLC, decodingPLCCNG, jitter, jitterBuffer, jitterBufferPreferred, packetsLost, packetsReceived, opSilence, opNormal, opMerge, opExpand, opAccelerate, opPreemptiveExpand, opCNG, speaking, ssrc);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboundAudio)) {
            return false;
        }
        InboundAudio inboundAudio = (InboundAudio) other;
        return this.audioLevel == inboundAudio.audioLevel && this.bytesReceived == inboundAudio.bytesReceived && m.areEqual(this.codecName, inboundAudio.codecName) && this.codecPayloadType == inboundAudio.codecPayloadType && this.delayEstimate == inboundAudio.delayEstimate && this.decodingCNG == inboundAudio.decodingCNG && this.decodingMutedOutput == inboundAudio.decodingMutedOutput && this.decodingNormal == inboundAudio.decodingNormal && this.decodingPLC == inboundAudio.decodingPLC && this.decodingPLCCNG == inboundAudio.decodingPLCCNG && this.jitter == inboundAudio.jitter && this.jitterBuffer == inboundAudio.jitterBuffer && this.jitterBufferPreferred == inboundAudio.jitterBufferPreferred && this.packetsLost == inboundAudio.packetsLost && this.packetsReceived == inboundAudio.packetsReceived && this.opSilence == inboundAudio.opSilence && this.opNormal == inboundAudio.opNormal && this.opMerge == inboundAudio.opMerge && this.opExpand == inboundAudio.opExpand && this.opAccelerate == inboundAudio.opAccelerate && this.opPreemptiveExpand == inboundAudio.opPreemptiveExpand && this.opCNG == inboundAudio.opCNG && this.speaking == inboundAudio.speaking && this.ssrc == inboundAudio.ssrc;
    }

    public final int getAudioLevel() {
        return this.audioLevel;
    }

    public final long getBytesReceived() {
        return this.bytesReceived;
    }

    public final String getCodecName() {
        return this.codecName;
    }

    public final int getCodecPayloadType() {
        return this.codecPayloadType;
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

    public final long getOpAccelerate() {
        return this.opAccelerate;
    }

    public final long getOpCNG() {
        return this.opCNG;
    }

    public final long getOpExpand() {
        return this.opExpand;
    }

    public final long getOpMerge() {
        return this.opMerge;
    }

    public final long getOpNormal() {
        return this.opNormal;
    }

    public final long getOpPreemptiveExpand() {
        return this.opPreemptiveExpand;
    }

    public final long getOpSilence() {
        return this.opSilence;
    }

    public final long getPacketsLost() {
        return this.packetsLost;
    }

    public final long getPacketsReceived() {
        return this.packetsReceived;
    }

    public final long getSpeaking() {
        return this.speaking;
    }

    public final long getSsrc() {
        return this.ssrc;
    }

    public int hashCode() {
        int iA = (b.a(this.bytesReceived) + (this.audioLevel * 31)) * 31;
        String str = this.codecName;
        return b.a(this.ssrc) + ((b.a(this.speaking) + ((b.a(this.opCNG) + ((b.a(this.opPreemptiveExpand) + ((b.a(this.opAccelerate) + ((b.a(this.opExpand) + ((b.a(this.opMerge) + ((b.a(this.opNormal) + ((b.a(this.opSilence) + ((b.a(this.packetsReceived) + ((b.a(this.packetsLost) + ((b.a(this.jitterBufferPreferred) + ((b.a(this.jitterBuffer) + ((b.a(this.jitter) + ((((((((((((b.a(this.delayEstimate) + ((((iA + (str != null ? str.hashCode() : 0)) * 31) + this.codecPayloadType) * 31)) * 31) + this.decodingCNG) * 31) + this.decodingMutedOutput) * 31) + this.decodingNormal) * 31) + this.decodingPLC) * 31) + this.decodingPLCCNG) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("InboundAudio(audioLevel=");
        sbU.append(this.audioLevel);
        sbU.append(", bytesReceived=");
        sbU.append(this.bytesReceived);
        sbU.append(", codecName=");
        sbU.append(this.codecName);
        sbU.append(", codecPayloadType=");
        sbU.append(this.codecPayloadType);
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
        sbU.append(", jitter=");
        sbU.append(this.jitter);
        sbU.append(", jitterBuffer=");
        sbU.append(this.jitterBuffer);
        sbU.append(", jitterBufferPreferred=");
        sbU.append(this.jitterBufferPreferred);
        sbU.append(", packetsLost=");
        sbU.append(this.packetsLost);
        sbU.append(", packetsReceived=");
        sbU.append(this.packetsReceived);
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
        sbU.append(", speaking=");
        sbU.append(this.speaking);
        sbU.append(", ssrc=");
        return a.C(sbU, this.ssrc, ")");
    }
}
