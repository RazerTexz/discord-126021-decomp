package co.discord.media_engine;

import a0.a.a.b;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: Statistics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class OutboundRtpAudio {
    private final boolean audioDetected;
    private final float audioLevel;
    private final long bytesSent;
    private final StatsCodec codec;
    private final float fractionLost;
    private final long framesCaptured;
    private final long framesRendered;
    private final boolean noiseCancellerIsEnabled;
    private final long noiseCancellerProcessTime;
    private final int packetsLost;
    private final long packetsSent;
    private final long ssrc;
    private final String type;
    private final boolean voiceActivityDetectorIsEnabled;
    private final long voiceActivityDetectorProcessTime;

    public OutboundRtpAudio(String str, long j, StatsCodec statsCodec, long j2, long j3, int i, float f, float f2, boolean z2, long j4, long j5, boolean z3, long j6, boolean z4, long j7) {
        Intrinsics3.checkNotNullParameter(str, "type");
        Intrinsics3.checkNotNullParameter(statsCodec, "codec");
        this.type = str;
        this.ssrc = j;
        this.codec = statsCodec;
        this.bytesSent = j2;
        this.packetsSent = j3;
        this.packetsLost = i;
        this.fractionLost = f;
        this.audioLevel = f2;
        this.audioDetected = z2;
        this.framesCaptured = j4;
        this.framesRendered = j5;
        this.noiseCancellerIsEnabled = z3;
        this.noiseCancellerProcessTime = j6;
        this.voiceActivityDetectorIsEnabled = z4;
        this.voiceActivityDetectorProcessTime = j7;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final long getFramesCaptured() {
        return this.framesCaptured;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final long getFramesRendered() {
        return this.framesRendered;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getNoiseCancellerIsEnabled() {
        return this.noiseCancellerIsEnabled;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final long getNoiseCancellerProcessTime() {
        return this.noiseCancellerProcessTime;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getVoiceActivityDetectorIsEnabled() {
        return this.voiceActivityDetectorIsEnabled;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final long getVoiceActivityDetectorProcessTime() {
        return this.voiceActivityDetectorProcessTime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getSsrc() {
        return this.ssrc;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final StatsCodec getCodec() {
        return this.codec;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getBytesSent() {
        return this.bytesSent;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getPacketsSent() {
        return this.packetsSent;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getPacketsLost() {
        return this.packetsLost;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final float getFractionLost() {
        return this.fractionLost;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final float getAudioLevel() {
        return this.audioLevel;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getAudioDetected() {
        return this.audioDetected;
    }

    public final OutboundRtpAudio copy(String type, long ssrc, StatsCodec codec, long bytesSent, long packetsSent, int packetsLost, float fractionLost, float audioLevel, boolean audioDetected, long framesCaptured, long framesRendered, boolean noiseCancellerIsEnabled, long noiseCancellerProcessTime, boolean voiceActivityDetectorIsEnabled, long voiceActivityDetectorProcessTime) {
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(codec, "codec");
        return new OutboundRtpAudio(type, ssrc, codec, bytesSent, packetsSent, packetsLost, fractionLost, audioLevel, audioDetected, framesCaptured, framesRendered, noiseCancellerIsEnabled, noiseCancellerProcessTime, voiceActivityDetectorIsEnabled, voiceActivityDetectorProcessTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OutboundRtpAudio)) {
            return false;
        }
        OutboundRtpAudio outboundRtpAudio = (OutboundRtpAudio) other;
        return Intrinsics3.areEqual(this.type, outboundRtpAudio.type) && this.ssrc == outboundRtpAudio.ssrc && Intrinsics3.areEqual(this.codec, outboundRtpAudio.codec) && this.bytesSent == outboundRtpAudio.bytesSent && this.packetsSent == outboundRtpAudio.packetsSent && this.packetsLost == outboundRtpAudio.packetsLost && Float.compare(this.fractionLost, outboundRtpAudio.fractionLost) == 0 && Float.compare(this.audioLevel, outboundRtpAudio.audioLevel) == 0 && this.audioDetected == outboundRtpAudio.audioDetected && this.framesCaptured == outboundRtpAudio.framesCaptured && this.framesRendered == outboundRtpAudio.framesRendered && this.noiseCancellerIsEnabled == outboundRtpAudio.noiseCancellerIsEnabled && this.noiseCancellerProcessTime == outboundRtpAudio.noiseCancellerProcessTime && this.voiceActivityDetectorIsEnabled == outboundRtpAudio.voiceActivityDetectorIsEnabled && this.voiceActivityDetectorProcessTime == outboundRtpAudio.voiceActivityDetectorProcessTime;
    }

    public final boolean getAudioDetected() {
        return this.audioDetected;
    }

    public final float getAudioLevel() {
        return this.audioLevel;
    }

    public final long getBytesSent() {
        return this.bytesSent;
    }

    public final StatsCodec getCodec() {
        return this.codec;
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

    public final boolean getNoiseCancellerIsEnabled() {
        return this.noiseCancellerIsEnabled;
    }

    public final long getNoiseCancellerProcessTime() {
        return this.noiseCancellerProcessTime;
    }

    public final int getPacketsLost() {
        return this.packetsLost;
    }

    public final long getPacketsSent() {
        return this.packetsSent;
    }

    public final long getSsrc() {
        return this.ssrc;
    }

    public final String getType() {
        return this.type;
    }

    public final boolean getVoiceActivityDetectorIsEnabled() {
        return this.voiceActivityDetectorIsEnabled;
    }

    public final long getVoiceActivityDetectorProcessTime() {
        return this.voiceActivityDetectorProcessTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r0v24, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    public int hashCode() {
        String str = this.type;
        int iA = (b.a(this.ssrc) + ((str != null ? str.hashCode() : 0) * 31)) * 31;
        StatsCodec statsCodec = this.codec;
        int iFloatToIntBits = (Float.floatToIntBits(this.audioLevel) + ((Float.floatToIntBits(this.fractionLost) + ((((b.a(this.packetsSent) + ((b.a(this.bytesSent) + ((iA + (statsCodec != null ? statsCodec.hashCode() : 0)) * 31)) * 31)) * 31) + this.packetsLost) * 31)) * 31)) * 31;
        boolean z2 = this.audioDetected;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int iA2 = (b.a(this.framesRendered) + ((b.a(this.framesCaptured) + ((iFloatToIntBits + r0) * 31)) * 31)) * 31;
        boolean z3 = this.noiseCancellerIsEnabled;
        ?? r1 = z3;
        if (z3) {
            r1 = 1;
        }
        int iA3 = (b.a(this.noiseCancellerProcessTime) + ((iA2 + r1) * 31)) * 31;
        boolean z4 = this.voiceActivityDetectorIsEnabled;
        return b.a(this.voiceActivityDetectorProcessTime) + ((iA3 + (z4 ? 1 : z4)) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("OutboundRtpAudio(type=");
        sbU.append(this.type);
        sbU.append(", ssrc=");
        sbU.append(this.ssrc);
        sbU.append(", codec=");
        sbU.append(this.codec);
        sbU.append(", bytesSent=");
        sbU.append(this.bytesSent);
        sbU.append(", packetsSent=");
        sbU.append(this.packetsSent);
        sbU.append(", packetsLost=");
        sbU.append(this.packetsLost);
        sbU.append(", fractionLost=");
        sbU.append(this.fractionLost);
        sbU.append(", audioLevel=");
        sbU.append(this.audioLevel);
        sbU.append(", audioDetected=");
        sbU.append(this.audioDetected);
        sbU.append(", framesCaptured=");
        sbU.append(this.framesCaptured);
        sbU.append(", framesRendered=");
        sbU.append(this.framesRendered);
        sbU.append(", noiseCancellerIsEnabled=");
        sbU.append(this.noiseCancellerIsEnabled);
        sbU.append(", noiseCancellerProcessTime=");
        sbU.append(this.noiseCancellerProcessTime);
        sbU.append(", voiceActivityDetectorIsEnabled=");
        sbU.append(this.voiceActivityDetectorIsEnabled);
        sbU.append(", voiceActivityDetectorProcessTime=");
        return outline.C(sbU, this.voiceActivityDetectorProcessTime, ")");
    }
}
