package co.discord.media_engine;

import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        C12238m.checkNotNullParameter(str, "type");
        C12238m.checkNotNullParameter(statsCodec, "codec");
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
        C12238m.checkNotNullParameter(type, "type");
        C12238m.checkNotNullParameter(codec, "codec");
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
        return C12238m.areEqual(this.type, outboundRtpAudio.type) && this.ssrc == outboundRtpAudio.ssrc && C12238m.areEqual(this.codec, outboundRtpAudio.codec) && this.bytesSent == outboundRtpAudio.bytesSent && this.packetsSent == outboundRtpAudio.packetsSent && this.packetsLost == outboundRtpAudio.packetsLost && Float.compare(this.fractionLost, outboundRtpAudio.fractionLost) == 0 && Float.compare(this.audioLevel, outboundRtpAudio.audioLevel) == 0 && this.audioDetected == outboundRtpAudio.audioDetected && this.framesCaptured == outboundRtpAudio.framesCaptured && this.framesRendered == outboundRtpAudio.framesRendered && this.noiseCancellerIsEnabled == outboundRtpAudio.noiseCancellerIsEnabled && this.noiseCancellerProcessTime == outboundRtpAudio.noiseCancellerProcessTime && this.voiceActivityDetectorIsEnabled == outboundRtpAudio.voiceActivityDetectorIsEnabled && this.voiceActivityDetectorProcessTime == outboundRtpAudio.voiceActivityDetectorProcessTime;
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
        int iM3a = (C0002b.m3a(this.ssrc) + ((str != null ? str.hashCode() : 0) * 31)) * 31;
        StatsCodec statsCodec = this.codec;
        int iFloatToIntBits = (Float.floatToIntBits(this.audioLevel) + ((Float.floatToIntBits(this.fractionLost) + ((((C0002b.m3a(this.packetsSent) + ((C0002b.m3a(this.bytesSent) + ((iM3a + (statsCodec != null ? statsCodec.hashCode() : 0)) * 31)) * 31)) * 31) + this.packetsLost) * 31)) * 31)) * 31;
        boolean z2 = this.audioDetected;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int iM3a2 = (C0002b.m3a(this.framesRendered) + ((C0002b.m3a(this.framesCaptured) + ((iFloatToIntBits + r0) * 31)) * 31)) * 31;
        boolean z3 = this.noiseCancellerIsEnabled;
        ?? r1 = z3;
        if (z3) {
            r1 = 1;
        }
        int iM3a3 = (C0002b.m3a(this.noiseCancellerProcessTime) + ((iM3a2 + r1) * 31)) * 31;
        boolean z4 = this.voiceActivityDetectorIsEnabled;
        return C0002b.m3a(this.voiceActivityDetectorProcessTime) + ((iM3a3 + (z4 ? 1 : z4)) * 31);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("OutboundRtpAudio(type=");
        sbM833U.append(this.type);
        sbM833U.append(", ssrc=");
        sbM833U.append(this.ssrc);
        sbM833U.append(", codec=");
        sbM833U.append(this.codec);
        sbM833U.append(", bytesSent=");
        sbM833U.append(this.bytesSent);
        sbM833U.append(", packetsSent=");
        sbM833U.append(this.packetsSent);
        sbM833U.append(", packetsLost=");
        sbM833U.append(this.packetsLost);
        sbM833U.append(", fractionLost=");
        sbM833U.append(this.fractionLost);
        sbM833U.append(", audioLevel=");
        sbM833U.append(this.audioLevel);
        sbM833U.append(", audioDetected=");
        sbM833U.append(this.audioDetected);
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
        return C1643a.m815C(sbM833U, this.voiceActivityDetectorProcessTime, ")");
    }
}
