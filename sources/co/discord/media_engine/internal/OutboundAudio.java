package co.discord.media_engine.internal;

import p001a0.p002a.p003a.C0001a;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: NativeStatistics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class OutboundAudio {
    private final int audioLevel;
    private final long bytesSent;
    private final String codecName;
    private final int codecPayloadType;
    private final int delayMedian;
    private final int delayStd;
    private final double echoReturnLoss;
    private final double echoReturnLossEnchancement;
    private final float fractionLost;
    private final long framesCaptured;
    private final long framesRendered;
    private final int jitter;
    private final Boolean noiseCancellerIsEnabled;
    private final Long noiseCancellerProcessTime;
    private final int packetsLost;
    private final long packetsSent;
    private final double residualEchoLikelihood;
    private final double residualEchoLikelihoodRecentMax;
    private final long rtt;
    private final long speaking;
    private final long ssrc;
    private final boolean typingNoiseDetected;
    private final Boolean voiceActivityDetectorIsEnabled;
    private final Long voiceActivityDetectorProcessTime;

    public OutboundAudio(int i, long j, String str, int i2, int i3, int i4, double d, double d2, float f, int i5, int i6, long j2, double d3, double d4, long j3, long j4, long j5, boolean z2, long j6, long j7, Boolean bool, Long l, Boolean bool2, Long l2) {
        C12238m.checkNotNullParameter(str, "codecName");
        this.audioLevel = i;
        this.bytesSent = j;
        this.codecName = str;
        this.codecPayloadType = i2;
        this.delayMedian = i3;
        this.delayStd = i4;
        this.echoReturnLoss = d;
        this.echoReturnLossEnchancement = d2;
        this.fractionLost = f;
        this.jitter = i5;
        this.packetsLost = i6;
        this.packetsSent = j2;
        this.residualEchoLikelihood = d3;
        this.residualEchoLikelihoodRecentMax = d4;
        this.rtt = j3;
        this.speaking = j4;
        this.ssrc = j5;
        this.typingNoiseDetected = z2;
        this.framesCaptured = j6;
        this.framesRendered = j7;
        this.noiseCancellerIsEnabled = bool;
        this.noiseCancellerProcessTime = l;
        this.voiceActivityDetectorIsEnabled = bool2;
        this.voiceActivityDetectorProcessTime = l2;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getAudioLevel() {
        return this.audioLevel;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getJitter() {
        return this.jitter;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getPacketsLost() {
        return this.packetsLost;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final long getPacketsSent() {
        return this.packetsSent;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final double getResidualEchoLikelihood() {
        return this.residualEchoLikelihood;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final double getResidualEchoLikelihoodRecentMax() {
        return this.residualEchoLikelihoodRecentMax;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final long getRtt() {
        return this.rtt;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final long getSpeaking() {
        return this.speaking;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final long getSsrc() {
        return this.ssrc;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final boolean getTypingNoiseDetected() {
        return this.typingNoiseDetected;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final long getFramesCaptured() {
        return this.framesCaptured;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getBytesSent() {
        return this.bytesSent;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final long getFramesRendered() {
        return this.framesRendered;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final Boolean getNoiseCancellerIsEnabled() {
        return this.noiseCancellerIsEnabled;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final Long getNoiseCancellerProcessTime() {
        return this.noiseCancellerProcessTime;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final Boolean getVoiceActivityDetectorIsEnabled() {
        return this.voiceActivityDetectorIsEnabled;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final Long getVoiceActivityDetectorProcessTime() {
        return this.voiceActivityDetectorProcessTime;
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
    public final int getDelayMedian() {
        return this.delayMedian;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getDelayStd() {
        return this.delayStd;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final double getEchoReturnLoss() {
        return this.echoReturnLoss;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final double getEchoReturnLossEnchancement() {
        return this.echoReturnLossEnchancement;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final float getFractionLost() {
        return this.fractionLost;
    }

    public final OutboundAudio copy(int audioLevel, long bytesSent, String codecName, int codecPayloadType, int delayMedian, int delayStd, double echoReturnLoss, double echoReturnLossEnchancement, float fractionLost, int jitter, int packetsLost, long packetsSent, double residualEchoLikelihood, double residualEchoLikelihoodRecentMax, long rtt, long speaking, long ssrc, boolean typingNoiseDetected, long framesCaptured, long framesRendered, Boolean noiseCancellerIsEnabled, Long noiseCancellerProcessTime, Boolean voiceActivityDetectorIsEnabled, Long voiceActivityDetectorProcessTime) {
        C12238m.checkNotNullParameter(codecName, "codecName");
        return new OutboundAudio(audioLevel, bytesSent, codecName, codecPayloadType, delayMedian, delayStd, echoReturnLoss, echoReturnLossEnchancement, fractionLost, jitter, packetsLost, packetsSent, residualEchoLikelihood, residualEchoLikelihoodRecentMax, rtt, speaking, ssrc, typingNoiseDetected, framesCaptured, framesRendered, noiseCancellerIsEnabled, noiseCancellerProcessTime, voiceActivityDetectorIsEnabled, voiceActivityDetectorProcessTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OutboundAudio)) {
            return false;
        }
        OutboundAudio outboundAudio = (OutboundAudio) other;
        return this.audioLevel == outboundAudio.audioLevel && this.bytesSent == outboundAudio.bytesSent && C12238m.areEqual(this.codecName, outboundAudio.codecName) && this.codecPayloadType == outboundAudio.codecPayloadType && this.delayMedian == outboundAudio.delayMedian && this.delayStd == outboundAudio.delayStd && Double.compare(this.echoReturnLoss, outboundAudio.echoReturnLoss) == 0 && Double.compare(this.echoReturnLossEnchancement, outboundAudio.echoReturnLossEnchancement) == 0 && Float.compare(this.fractionLost, outboundAudio.fractionLost) == 0 && this.jitter == outboundAudio.jitter && this.packetsLost == outboundAudio.packetsLost && this.packetsSent == outboundAudio.packetsSent && Double.compare(this.residualEchoLikelihood, outboundAudio.residualEchoLikelihood) == 0 && Double.compare(this.residualEchoLikelihoodRecentMax, outboundAudio.residualEchoLikelihoodRecentMax) == 0 && this.rtt == outboundAudio.rtt && this.speaking == outboundAudio.speaking && this.ssrc == outboundAudio.ssrc && this.typingNoiseDetected == outboundAudio.typingNoiseDetected && this.framesCaptured == outboundAudio.framesCaptured && this.framesRendered == outboundAudio.framesRendered && C12238m.areEqual(this.noiseCancellerIsEnabled, outboundAudio.noiseCancellerIsEnabled) && C12238m.areEqual(this.noiseCancellerProcessTime, outboundAudio.noiseCancellerProcessTime) && C12238m.areEqual(this.voiceActivityDetectorIsEnabled, outboundAudio.voiceActivityDetectorIsEnabled) && C12238m.areEqual(this.voiceActivityDetectorProcessTime, outboundAudio.voiceActivityDetectorProcessTime);
    }

    public final int getAudioLevel() {
        return this.audioLevel;
    }

    public final long getBytesSent() {
        return this.bytesSent;
    }

    public final String getCodecName() {
        return this.codecName;
    }

    public final int getCodecPayloadType() {
        return this.codecPayloadType;
    }

    public final int getDelayMedian() {
        return this.delayMedian;
    }

    public final int getDelayStd() {
        return this.delayStd;
    }

    public final double getEchoReturnLoss() {
        return this.echoReturnLoss;
    }

    public final double getEchoReturnLossEnchancement() {
        return this.echoReturnLossEnchancement;
    }

    public final float getFractionLost() {
        return this.fractionLost;
    }

    public final long getFramesCaptured() {
        return this.framesCaptured;
    }

    public final long getFramesRendered() {
        return this.framesRendered;
    }

    public final int getJitter() {
        return this.jitter;
    }

    public final Boolean getNoiseCancellerIsEnabled() {
        return this.noiseCancellerIsEnabled;
    }

    public final Long getNoiseCancellerProcessTime() {
        return this.noiseCancellerProcessTime;
    }

    public final int getPacketsLost() {
        return this.packetsLost;
    }

    public final long getPacketsSent() {
        return this.packetsSent;
    }

    public final double getResidualEchoLikelihood() {
        return this.residualEchoLikelihood;
    }

    public final double getResidualEchoLikelihoodRecentMax() {
        return this.residualEchoLikelihoodRecentMax;
    }

    public final long getRtt() {
        return this.rtt;
    }

    public final long getSpeaking() {
        return this.speaking;
    }

    public final long getSsrc() {
        return this.ssrc;
    }

    public final boolean getTypingNoiseDetected() {
        return this.typingNoiseDetected;
    }

    public final Boolean getVoiceActivityDetectorIsEnabled() {
        return this.voiceActivityDetectorIsEnabled;
    }

    public final Long getVoiceActivityDetectorProcessTime() {
        return this.voiceActivityDetectorProcessTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v28, types: [int] */
    /* JADX WARN: Type inference failed for: r1v27, types: [int] */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v45 */
    public int hashCode() {
        int iM3a = (C0002b.m3a(this.bytesSent) + (this.audioLevel * 31)) * 31;
        String str = this.codecName;
        int iM3a2 = (C0002b.m3a(this.ssrc) + ((C0002b.m3a(this.speaking) + ((C0002b.m3a(this.rtt) + ((C0001a.m2a(this.residualEchoLikelihoodRecentMax) + ((C0001a.m2a(this.residualEchoLikelihood) + ((C0002b.m3a(this.packetsSent) + ((((((Float.floatToIntBits(this.fractionLost) + ((C0001a.m2a(this.echoReturnLossEnchancement) + ((C0001a.m2a(this.echoReturnLoss) + ((((((((iM3a + (str != null ? str.hashCode() : 0)) * 31) + this.codecPayloadType) * 31) + this.delayMedian) * 31) + this.delayStd) * 31)) * 31)) * 31)) * 31) + this.jitter) * 31) + this.packetsLost) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z2 = this.typingNoiseDetected;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int iM3a3 = (C0002b.m3a(this.framesRendered) + ((C0002b.m3a(this.framesCaptured) + ((iM3a2 + r1) * 31)) * 31)) * 31;
        Boolean bool = this.noiseCancellerIsEnabled;
        int iHashCode = (iM3a3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l = this.noiseCancellerProcessTime;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool2 = this.voiceActivityDetectorIsEnabled;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l2 = this.voiceActivityDetectorProcessTime;
        return iHashCode3 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("OutboundAudio(audioLevel=");
        sbM833U.append(this.audioLevel);
        sbM833U.append(", bytesSent=");
        sbM833U.append(this.bytesSent);
        sbM833U.append(", codecName=");
        sbM833U.append(this.codecName);
        sbM833U.append(", codecPayloadType=");
        sbM833U.append(this.codecPayloadType);
        sbM833U.append(", delayMedian=");
        sbM833U.append(this.delayMedian);
        sbM833U.append(", delayStd=");
        sbM833U.append(this.delayStd);
        sbM833U.append(", echoReturnLoss=");
        sbM833U.append(this.echoReturnLoss);
        sbM833U.append(", echoReturnLossEnchancement=");
        sbM833U.append(this.echoReturnLossEnchancement);
        sbM833U.append(", fractionLost=");
        sbM833U.append(this.fractionLost);
        sbM833U.append(", jitter=");
        sbM833U.append(this.jitter);
        sbM833U.append(", packetsLost=");
        sbM833U.append(this.packetsLost);
        sbM833U.append(", packetsSent=");
        sbM833U.append(this.packetsSent);
        sbM833U.append(", residualEchoLikelihood=");
        sbM833U.append(this.residualEchoLikelihood);
        sbM833U.append(", residualEchoLikelihoodRecentMax=");
        sbM833U.append(this.residualEchoLikelihoodRecentMax);
        sbM833U.append(", rtt=");
        sbM833U.append(this.rtt);
        sbM833U.append(", speaking=");
        sbM833U.append(this.speaking);
        sbM833U.append(", ssrc=");
        sbM833U.append(this.ssrc);
        sbM833U.append(", typingNoiseDetected=");
        sbM833U.append(this.typingNoiseDetected);
        sbM833U.append(", framesCaptured=");
        sbM833U.append(this.framesCaptured);
        sbM833U.append(", framesRendered=");
        sbM833U.append(this.framesRendered);
        sbM833U.append(", noiseCancellerIsEnabled=");
        sbM833U.append(this.noiseCancellerIsEnabled);
        sbM833U.append(", noiseCancellerProcessTime=");
        sbM833U.append(this.noiseCancellerProcessTime);
        sbM833U.append(", voiceActivityDetectorIsEnabled=");
        sbM833U.append(this.voiceActivityDetectorIsEnabled);
        sbM833U.append(", voiceActivityDetectorProcessTime=");
        return C1643a.m819G(sbM833U, this.voiceActivityDetectorProcessTime, ")");
    }
}
