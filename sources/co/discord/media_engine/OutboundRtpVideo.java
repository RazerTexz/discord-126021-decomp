package co.discord.media_engine;

import com.discord.models.domain.ModelAuditLogEntry;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Statistics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class OutboundRtpVideo {
    private final int averageEncodeTime;
    private final boolean bandwidthLimitedResolution;
    private final int bitrate;
    private final int bitrateTarget;
    private final long bytesSent;
    private final StatsCodec codec;
    private final boolean cpuLimitedResolution;
    private final int encodeUsage;
    private final String encoderImplementationName;
    private final long firCount;
    private final float fractionLost;
    private final int frameRateEncode;
    private final int frameRateInput;
    private final long framesEncoded;
    private final long framesSent;
    private final long nackCount;
    private final int packetsLost;
    private final long packetsSent;
    private final long pliCount;
    private final long qpSum;
    private final Resolution resolution;
    private final long ssrc;
    private final String type;

    public OutboundRtpVideo(String str, long j, StatsCodec statsCodec, long j2, long j3, int i, float f, int i2, int i3, int i4, String str2, int i5, Resolution resolution, long j4, long j5, int i6, int i7, long j6, long j7, long j8, long j9, boolean z2, boolean z3) {
        C12238m.checkNotNullParameter(str, "type");
        C12238m.checkNotNullParameter(statsCodec, "codec");
        C12238m.checkNotNullParameter(str2, "encoderImplementationName");
        C12238m.checkNotNullParameter(resolution, "resolution");
        this.type = str;
        this.ssrc = j;
        this.codec = statsCodec;
        this.bytesSent = j2;
        this.packetsSent = j3;
        this.packetsLost = i;
        this.fractionLost = f;
        this.bitrate = i2;
        this.bitrateTarget = i3;
        this.encodeUsage = i4;
        this.encoderImplementationName = str2;
        this.averageEncodeTime = i5;
        this.resolution = resolution;
        this.framesSent = j4;
        this.framesEncoded = j5;
        this.frameRateInput = i6;
        this.frameRateEncode = i7;
        this.firCount = j6;
        this.nackCount = j7;
        this.pliCount = j8;
        this.qpSum = j9;
        this.bandwidthLimitedResolution = z2;
        this.cpuLimitedResolution = z3;
    }

    public static /* synthetic */ OutboundRtpVideo copy$default(OutboundRtpVideo outboundRtpVideo, String str, long j, StatsCodec statsCodec, long j2, long j3, int i, float f, int i2, int i3, int i4, String str2, int i5, Resolution resolution, long j4, long j5, int i6, int i7, long j6, long j7, long j8, long j9, boolean z2, boolean z3, int i8, Object obj) {
        String str3 = (i8 & 1) != 0 ? outboundRtpVideo.type : str;
        long j10 = (i8 & 2) != 0 ? outboundRtpVideo.ssrc : j;
        StatsCodec statsCodec2 = (i8 & 4) != 0 ? outboundRtpVideo.codec : statsCodec;
        long j11 = (i8 & 8) != 0 ? outboundRtpVideo.bytesSent : j2;
        long j12 = (i8 & 16) != 0 ? outboundRtpVideo.packetsSent : j3;
        int i9 = (i8 & 32) != 0 ? outboundRtpVideo.packetsLost : i;
        float f2 = (i8 & 64) != 0 ? outboundRtpVideo.fractionLost : f;
        int i10 = (i8 & 128) != 0 ? outboundRtpVideo.bitrate : i2;
        int i11 = (i8 & 256) != 0 ? outboundRtpVideo.bitrateTarget : i3;
        int i12 = (i8 & 512) != 0 ? outboundRtpVideo.encodeUsage : i4;
        return outboundRtpVideo.copy(str3, j10, statsCodec2, j11, j12, i9, f2, i10, i11, i12, (i8 & 1024) != 0 ? outboundRtpVideo.encoderImplementationName : str2, (i8 & 2048) != 0 ? outboundRtpVideo.averageEncodeTime : i5, (i8 & 4096) != 0 ? outboundRtpVideo.resolution : resolution, (i8 & 8192) != 0 ? outboundRtpVideo.framesSent : j4, (i8 & 16384) != 0 ? outboundRtpVideo.framesEncoded : j5, (i8 & 32768) != 0 ? outboundRtpVideo.frameRateInput : i6, (65536 & i8) != 0 ? outboundRtpVideo.frameRateEncode : i7, (i8 & 131072) != 0 ? outboundRtpVideo.firCount : j6, (i8 & 262144) != 0 ? outboundRtpVideo.nackCount : j7, (i8 & 524288) != 0 ? outboundRtpVideo.pliCount : j8, (i8 & 1048576) != 0 ? outboundRtpVideo.qpSum : j9, (i8 & 2097152) != 0 ? outboundRtpVideo.bandwidthLimitedResolution : z2, (i8 & 4194304) != 0 ? outboundRtpVideo.cpuLimitedResolution : z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getEncodeUsage() {
        return this.encodeUsage;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getEncoderImplementationName() {
        return this.encoderImplementationName;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getAverageEncodeTime() {
        return this.averageEncodeTime;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Resolution getResolution() {
        return this.resolution;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final long getFramesSent() {
        return this.framesSent;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final long getFramesEncoded() {
        return this.framesEncoded;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final int getFrameRateInput() {
        return this.frameRateInput;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final int getFrameRateEncode() {
        return this.frameRateEncode;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final long getFirCount() {
        return this.firCount;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final long getNackCount() {
        return this.nackCount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getSsrc() {
        return this.ssrc;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final long getPliCount() {
        return this.pliCount;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final long getQpSum() {
        return this.qpSum;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final boolean getBandwidthLimitedResolution() {
        return this.bandwidthLimitedResolution;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final boolean getCpuLimitedResolution() {
        return this.cpuLimitedResolution;
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
    public final int getBitrate() {
        return this.bitrate;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getBitrateTarget() {
        return this.bitrateTarget;
    }

    public final OutboundRtpVideo copy(String type, long ssrc, StatsCodec codec, long bytesSent, long packetsSent, int packetsLost, float fractionLost, int bitrate, int bitrateTarget, int encodeUsage, String encoderImplementationName, int averageEncodeTime, Resolution resolution, long framesSent, long framesEncoded, int frameRateInput, int frameRateEncode, long firCount, long nackCount, long pliCount, long qpSum, boolean bandwidthLimitedResolution, boolean cpuLimitedResolution) {
        C12238m.checkNotNullParameter(type, "type");
        C12238m.checkNotNullParameter(codec, "codec");
        C12238m.checkNotNullParameter(encoderImplementationName, "encoderImplementationName");
        C12238m.checkNotNullParameter(resolution, "resolution");
        return new OutboundRtpVideo(type, ssrc, codec, bytesSent, packetsSent, packetsLost, fractionLost, bitrate, bitrateTarget, encodeUsage, encoderImplementationName, averageEncodeTime, resolution, framesSent, framesEncoded, frameRateInput, frameRateEncode, firCount, nackCount, pliCount, qpSum, bandwidthLimitedResolution, cpuLimitedResolution);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OutboundRtpVideo)) {
            return false;
        }
        OutboundRtpVideo outboundRtpVideo = (OutboundRtpVideo) other;
        return C12238m.areEqual(this.type, outboundRtpVideo.type) && this.ssrc == outboundRtpVideo.ssrc && C12238m.areEqual(this.codec, outboundRtpVideo.codec) && this.bytesSent == outboundRtpVideo.bytesSent && this.packetsSent == outboundRtpVideo.packetsSent && this.packetsLost == outboundRtpVideo.packetsLost && Float.compare(this.fractionLost, outboundRtpVideo.fractionLost) == 0 && this.bitrate == outboundRtpVideo.bitrate && this.bitrateTarget == outboundRtpVideo.bitrateTarget && this.encodeUsage == outboundRtpVideo.encodeUsage && C12238m.areEqual(this.encoderImplementationName, outboundRtpVideo.encoderImplementationName) && this.averageEncodeTime == outboundRtpVideo.averageEncodeTime && C12238m.areEqual(this.resolution, outboundRtpVideo.resolution) && this.framesSent == outboundRtpVideo.framesSent && this.framesEncoded == outboundRtpVideo.framesEncoded && this.frameRateInput == outboundRtpVideo.frameRateInput && this.frameRateEncode == outboundRtpVideo.frameRateEncode && this.firCount == outboundRtpVideo.firCount && this.nackCount == outboundRtpVideo.nackCount && this.pliCount == outboundRtpVideo.pliCount && this.qpSum == outboundRtpVideo.qpSum && this.bandwidthLimitedResolution == outboundRtpVideo.bandwidthLimitedResolution && this.cpuLimitedResolution == outboundRtpVideo.cpuLimitedResolution;
    }

    public final int getAverageEncodeTime() {
        return this.averageEncodeTime;
    }

    public final boolean getBandwidthLimitedResolution() {
        return this.bandwidthLimitedResolution;
    }

    public final int getBitrate() {
        return this.bitrate;
    }

    public final int getBitrateTarget() {
        return this.bitrateTarget;
    }

    public final long getBytesSent() {
        return this.bytesSent;
    }

    public final StatsCodec getCodec() {
        return this.codec;
    }

    public final boolean getCpuLimitedResolution() {
        return this.cpuLimitedResolution;
    }

    public final int getEncodeUsage() {
        return this.encodeUsage;
    }

    public final String getEncoderImplementationName() {
        return this.encoderImplementationName;
    }

    public final long getFirCount() {
        return this.firCount;
    }

    public final float getFractionLost() {
        return this.fractionLost;
    }

    public final int getFrameRateEncode() {
        return this.frameRateEncode;
    }

    public final int getFrameRateInput() {
        return this.frameRateInput;
    }

    public final long getFramesEncoded() {
        return this.framesEncoded;
    }

    public final long getFramesSent() {
        return this.framesSent;
    }

    public final long getNackCount() {
        return this.nackCount;
    }

    public final int getPacketsLost() {
        return this.packetsLost;
    }

    public final long getPacketsSent() {
        return this.packetsSent;
    }

    public final long getPliCount() {
        return this.pliCount;
    }

    public final long getQpSum() {
        return this.qpSum;
    }

    public final Resolution getResolution() {
        return this.resolution;
    }

    public final long getSsrc() {
        return this.ssrc;
    }

    public final String getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v40, types: [int] */
    /* JADX WARN: Type inference failed for: r0v42, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24, types: [int] */
    /* JADX WARN: Type inference failed for: r2v25 */
    public int hashCode() {
        String str = this.type;
        int iM3a = (C0002b.m3a(this.ssrc) + ((str != null ? str.hashCode() : 0) * 31)) * 31;
        StatsCodec statsCodec = this.codec;
        int iFloatToIntBits = (((((((Float.floatToIntBits(this.fractionLost) + ((((C0002b.m3a(this.packetsSent) + ((C0002b.m3a(this.bytesSent) + ((iM3a + (statsCodec != null ? statsCodec.hashCode() : 0)) * 31)) * 31)) * 31) + this.packetsLost) * 31)) * 31) + this.bitrate) * 31) + this.bitrateTarget) * 31) + this.encodeUsage) * 31;
        String str2 = this.encoderImplementationName;
        int iHashCode = (((iFloatToIntBits + (str2 != null ? str2.hashCode() : 0)) * 31) + this.averageEncodeTime) * 31;
        Resolution resolution = this.resolution;
        int iM3a2 = (C0002b.m3a(this.qpSum) + ((C0002b.m3a(this.pliCount) + ((C0002b.m3a(this.nackCount) + ((C0002b.m3a(this.firCount) + ((((((C0002b.m3a(this.framesEncoded) + ((C0002b.m3a(this.framesSent) + ((iHashCode + (resolution != null ? resolution.hashCode() : 0)) * 31)) * 31)) * 31) + this.frameRateInput) * 31) + this.frameRateEncode) * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z2 = this.bandwidthLimitedResolution;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iM3a2 + r1) * 31;
        boolean z3 = this.cpuLimitedResolution;
        return i + (z3 ? 1 : z3);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("OutboundRtpVideo(type=");
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
        sbM833U.append(", bitrate=");
        sbM833U.append(this.bitrate);
        sbM833U.append(", bitrateTarget=");
        sbM833U.append(this.bitrateTarget);
        sbM833U.append(", encodeUsage=");
        sbM833U.append(this.encodeUsage);
        sbM833U.append(", encoderImplementationName=");
        sbM833U.append(this.encoderImplementationName);
        sbM833U.append(", averageEncodeTime=");
        sbM833U.append(this.averageEncodeTime);
        sbM833U.append(", resolution=");
        sbM833U.append(this.resolution);
        sbM833U.append(", framesSent=");
        sbM833U.append(this.framesSent);
        sbM833U.append(", framesEncoded=");
        sbM833U.append(this.framesEncoded);
        sbM833U.append(", frameRateInput=");
        sbM833U.append(this.frameRateInput);
        sbM833U.append(", frameRateEncode=");
        sbM833U.append(this.frameRateEncode);
        sbM833U.append(", firCount=");
        sbM833U.append(this.firCount);
        sbM833U.append(", nackCount=");
        sbM833U.append(this.nackCount);
        sbM833U.append(", pliCount=");
        sbM833U.append(this.pliCount);
        sbM833U.append(", qpSum=");
        sbM833U.append(this.qpSum);
        sbM833U.append(", bandwidthLimitedResolution=");
        sbM833U.append(this.bandwidthLimitedResolution);
        sbM833U.append(", cpuLimitedResolution=");
        return C1643a.m827O(sbM833U, this.cpuLimitedResolution, ")");
    }
}
