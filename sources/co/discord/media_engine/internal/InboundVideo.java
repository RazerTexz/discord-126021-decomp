package co.discord.media_engine.internal;

import a0.a.a.a;
import a0.a.a.b;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: NativeStatistics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class InboundVideo {
    private final String codecName;
    private final int codecPayloadType;
    private final int currentDelay;
    private final int currentPayloadType;
    private final int decode;
    private final int decodeFrameRate;
    private final String decoderImplementationName;
    private final FrameCounts frameCounts;
    private final long framesDecoded;
    private final int framesDropped;
    private final long framesRendered;
    private final long freezeCount;
    private final int height;
    private final int jitterBuffer;
    private final int maxDecode;
    private final int minPlayoutDelay;
    private final int networkFrameRate;
    private final long pauseCount;
    private final long qpSum;
    private final int renderDelay;
    private final int renderFrameRate;
    private final InboundRtcpStats rtcpStats;
    private final InboundRtpStats rtpStats;
    private final long ssrc;
    private final double sumOfSquaredFramesDurations;
    private final float syncOffset;
    private final float targetDelay;
    private final int totalBitrate;
    private final long totalFramesDuration;
    private final long totalFreezesDuration;
    private final long totalPausesDuration;
    private final int width;

    public InboundVideo(String str, int i, int i2, int i3, int i4, int i5, String str2, FrameCounts frameCounts, long j, long j2, int i6, int i7, int i8, int i9, int i10, int i11, long j3, int i12, int i13, InboundRtcpStats inboundRtcpStats, InboundRtpStats inboundRtpStats, long j4, float f, float f2, int i14, int i15, long j5, long j6, long j7, long j8, long j9, double d) {
        Intrinsics3.checkNotNullParameter(str, "codecName");
        Intrinsics3.checkNotNullParameter(str2, "decoderImplementationName");
        Intrinsics3.checkNotNullParameter(frameCounts, "frameCounts");
        Intrinsics3.checkNotNullParameter(inboundRtcpStats, "rtcpStats");
        Intrinsics3.checkNotNullParameter(inboundRtpStats, "rtpStats");
        this.codecName = str;
        this.codecPayloadType = i;
        this.currentDelay = i2;
        this.currentPayloadType = i3;
        this.decodeFrameRate = i4;
        this.decode = i5;
        this.decoderImplementationName = str2;
        this.frameCounts = frameCounts;
        this.framesDecoded = j;
        this.framesRendered = j2;
        this.framesDropped = i6;
        this.height = i7;
        this.jitterBuffer = i8;
        this.maxDecode = i9;
        this.minPlayoutDelay = i10;
        this.networkFrameRate = i11;
        this.qpSum = j3;
        this.renderDelay = i12;
        this.renderFrameRate = i13;
        this.rtcpStats = inboundRtcpStats;
        this.rtpStats = inboundRtpStats;
        this.ssrc = j4;
        this.syncOffset = f;
        this.targetDelay = f2;
        this.totalBitrate = i14;
        this.width = i15;
        this.freezeCount = j5;
        this.pauseCount = j6;
        this.totalFreezesDuration = j7;
        this.totalPausesDuration = j8;
        this.totalFramesDuration = j9;
        this.sumOfSquaredFramesDurations = d;
    }

    public static /* synthetic */ InboundVideo copy$default(InboundVideo inboundVideo, String str, int i, int i2, int i3, int i4, int i5, String str2, FrameCounts frameCounts, long j, long j2, int i6, int i7, int i8, int i9, int i10, int i11, long j3, int i12, int i13, InboundRtcpStats inboundRtcpStats, InboundRtpStats inboundRtpStats, long j4, float f, float f2, int i14, int i15, long j5, long j6, long j7, long j8, long j9, double d, int i16, Object obj) {
        String str3 = (i16 & 1) != 0 ? inboundVideo.codecName : str;
        int i17 = (i16 & 2) != 0 ? inboundVideo.codecPayloadType : i;
        int i18 = (i16 & 4) != 0 ? inboundVideo.currentDelay : i2;
        int i19 = (i16 & 8) != 0 ? inboundVideo.currentPayloadType : i3;
        int i20 = (i16 & 16) != 0 ? inboundVideo.decodeFrameRate : i4;
        int i21 = (i16 & 32) != 0 ? inboundVideo.decode : i5;
        String str4 = (i16 & 64) != 0 ? inboundVideo.decoderImplementationName : str2;
        FrameCounts frameCounts2 = (i16 & 128) != 0 ? inboundVideo.frameCounts : frameCounts;
        long j10 = (i16 & 256) != 0 ? inboundVideo.framesDecoded : j;
        long j11 = (i16 & 512) != 0 ? inboundVideo.framesRendered : j2;
        int i22 = (i16 & 1024) != 0 ? inboundVideo.framesDropped : i6;
        int i23 = (i16 & 2048) != 0 ? inboundVideo.height : i7;
        int i24 = (i16 & 4096) != 0 ? inboundVideo.jitterBuffer : i8;
        int i25 = (i16 & 8192) != 0 ? inboundVideo.maxDecode : i9;
        int i26 = (i16 & 16384) != 0 ? inboundVideo.minPlayoutDelay : i10;
        int i27 = i22;
        int i28 = (i16 & 32768) != 0 ? inboundVideo.networkFrameRate : i11;
        long j12 = (i16 & 65536) != 0 ? inboundVideo.qpSum : j3;
        int i29 = (i16 & 131072) != 0 ? inboundVideo.renderDelay : i12;
        return inboundVideo.copy(str3, i17, i18, i19, i20, i21, str4, frameCounts2, j10, j11, i27, i23, i24, i25, i26, i28, j12, i29, (262144 & i16) != 0 ? inboundVideo.renderFrameRate : i13, (i16 & 524288) != 0 ? inboundVideo.rtcpStats : inboundRtcpStats, (i16 & 1048576) != 0 ? inboundVideo.rtpStats : inboundRtpStats, (i16 & 2097152) != 0 ? inboundVideo.ssrc : j4, (i16 & 4194304) != 0 ? inboundVideo.syncOffset : f, (8388608 & i16) != 0 ? inboundVideo.targetDelay : f2, (i16 & 16777216) != 0 ? inboundVideo.totalBitrate : i14, (i16 & 33554432) != 0 ? inboundVideo.width : i15, (i16 & 67108864) != 0 ? inboundVideo.freezeCount : j5, (i16 & 134217728) != 0 ? inboundVideo.pauseCount : j6, (i16 & 268435456) != 0 ? inboundVideo.totalFreezesDuration : j7, (i16 & 536870912) != 0 ? inboundVideo.totalPausesDuration : j8, (i16 & BasicMeasure.EXACTLY) != 0 ? inboundVideo.totalFramesDuration : j9, (i16 & Integer.MIN_VALUE) != 0 ? inboundVideo.sumOfSquaredFramesDurations : d);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCodecName() {
        return this.codecName;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final long getFramesRendered() {
        return this.framesRendered;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getFramesDropped() {
        return this.framesDropped;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getJitterBuffer() {
        return this.jitterBuffer;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getMaxDecode() {
        return this.maxDecode;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getMinPlayoutDelay() {
        return this.minPlayoutDelay;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final int getNetworkFrameRate() {
        return this.networkFrameRate;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final long getQpSum() {
        return this.qpSum;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final int getRenderDelay() {
        return this.renderDelay;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final int getRenderFrameRate() {
        return this.renderFrameRate;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getCodecPayloadType() {
        return this.codecPayloadType;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final InboundRtcpStats getRtcpStats() {
        return this.rtcpStats;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final InboundRtpStats getRtpStats() {
        return this.rtpStats;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final long getSsrc() {
        return this.ssrc;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final float getSyncOffset() {
        return this.syncOffset;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final float getTargetDelay() {
        return this.targetDelay;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final int getTotalBitrate() {
        return this.totalBitrate;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final long getFreezeCount() {
        return this.freezeCount;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final long getPauseCount() {
        return this.pauseCount;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final long getTotalFreezesDuration() {
        return this.totalFreezesDuration;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getCurrentDelay() {
        return this.currentDelay;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final long getTotalPausesDuration() {
        return this.totalPausesDuration;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final long getTotalFramesDuration() {
        return this.totalFramesDuration;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final double getSumOfSquaredFramesDurations() {
        return this.sumOfSquaredFramesDurations;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getCurrentPayloadType() {
        return this.currentPayloadType;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getDecodeFrameRate() {
        return this.decodeFrameRate;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getDecode() {
        return this.decode;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getDecoderImplementationName() {
        return this.decoderImplementationName;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final FrameCounts getFrameCounts() {
        return this.frameCounts;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final long getFramesDecoded() {
        return this.framesDecoded;
    }

    public final InboundVideo copy(String codecName, int codecPayloadType, int currentDelay, int currentPayloadType, int decodeFrameRate, int decode, String decoderImplementationName, FrameCounts frameCounts, long framesDecoded, long framesRendered, int framesDropped, int height, int jitterBuffer, int maxDecode, int minPlayoutDelay, int networkFrameRate, long qpSum, int renderDelay, int renderFrameRate, InboundRtcpStats rtcpStats, InboundRtpStats rtpStats, long ssrc, float syncOffset, float targetDelay, int totalBitrate, int width, long freezeCount, long pauseCount, long totalFreezesDuration, long totalPausesDuration, long totalFramesDuration, double sumOfSquaredFramesDurations) {
        Intrinsics3.checkNotNullParameter(codecName, "codecName");
        Intrinsics3.checkNotNullParameter(decoderImplementationName, "decoderImplementationName");
        Intrinsics3.checkNotNullParameter(frameCounts, "frameCounts");
        Intrinsics3.checkNotNullParameter(rtcpStats, "rtcpStats");
        Intrinsics3.checkNotNullParameter(rtpStats, "rtpStats");
        return new InboundVideo(codecName, codecPayloadType, currentDelay, currentPayloadType, decodeFrameRate, decode, decoderImplementationName, frameCounts, framesDecoded, framesRendered, framesDropped, height, jitterBuffer, maxDecode, minPlayoutDelay, networkFrameRate, qpSum, renderDelay, renderFrameRate, rtcpStats, rtpStats, ssrc, syncOffset, targetDelay, totalBitrate, width, freezeCount, pauseCount, totalFreezesDuration, totalPausesDuration, totalFramesDuration, sumOfSquaredFramesDurations);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboundVideo)) {
            return false;
        }
        InboundVideo inboundVideo = (InboundVideo) other;
        return Intrinsics3.areEqual(this.codecName, inboundVideo.codecName) && this.codecPayloadType == inboundVideo.codecPayloadType && this.currentDelay == inboundVideo.currentDelay && this.currentPayloadType == inboundVideo.currentPayloadType && this.decodeFrameRate == inboundVideo.decodeFrameRate && this.decode == inboundVideo.decode && Intrinsics3.areEqual(this.decoderImplementationName, inboundVideo.decoderImplementationName) && Intrinsics3.areEqual(this.frameCounts, inboundVideo.frameCounts) && this.framesDecoded == inboundVideo.framesDecoded && this.framesRendered == inboundVideo.framesRendered && this.framesDropped == inboundVideo.framesDropped && this.height == inboundVideo.height && this.jitterBuffer == inboundVideo.jitterBuffer && this.maxDecode == inboundVideo.maxDecode && this.minPlayoutDelay == inboundVideo.minPlayoutDelay && this.networkFrameRate == inboundVideo.networkFrameRate && this.qpSum == inboundVideo.qpSum && this.renderDelay == inboundVideo.renderDelay && this.renderFrameRate == inboundVideo.renderFrameRate && Intrinsics3.areEqual(this.rtcpStats, inboundVideo.rtcpStats) && Intrinsics3.areEqual(this.rtpStats, inboundVideo.rtpStats) && this.ssrc == inboundVideo.ssrc && Float.compare(this.syncOffset, inboundVideo.syncOffset) == 0 && Float.compare(this.targetDelay, inboundVideo.targetDelay) == 0 && this.totalBitrate == inboundVideo.totalBitrate && this.width == inboundVideo.width && this.freezeCount == inboundVideo.freezeCount && this.pauseCount == inboundVideo.pauseCount && this.totalFreezesDuration == inboundVideo.totalFreezesDuration && this.totalPausesDuration == inboundVideo.totalPausesDuration && this.totalFramesDuration == inboundVideo.totalFramesDuration && Double.compare(this.sumOfSquaredFramesDurations, inboundVideo.sumOfSquaredFramesDurations) == 0;
    }

    public final String getCodecName() {
        return this.codecName;
    }

    public final int getCodecPayloadType() {
        return this.codecPayloadType;
    }

    public final int getCurrentDelay() {
        return this.currentDelay;
    }

    public final int getCurrentPayloadType() {
        return this.currentPayloadType;
    }

    public final int getDecode() {
        return this.decode;
    }

    public final int getDecodeFrameRate() {
        return this.decodeFrameRate;
    }

    public final String getDecoderImplementationName() {
        return this.decoderImplementationName;
    }

    public final FrameCounts getFrameCounts() {
        return this.frameCounts;
    }

    public final long getFramesDecoded() {
        return this.framesDecoded;
    }

    public final int getFramesDropped() {
        return this.framesDropped;
    }

    public final long getFramesRendered() {
        return this.framesRendered;
    }

    public final long getFreezeCount() {
        return this.freezeCount;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getJitterBuffer() {
        return this.jitterBuffer;
    }

    public final int getMaxDecode() {
        return this.maxDecode;
    }

    public final int getMinPlayoutDelay() {
        return this.minPlayoutDelay;
    }

    public final int getNetworkFrameRate() {
        return this.networkFrameRate;
    }

    public final long getPauseCount() {
        return this.pauseCount;
    }

    public final long getQpSum() {
        return this.qpSum;
    }

    public final int getRenderDelay() {
        return this.renderDelay;
    }

    public final int getRenderFrameRate() {
        return this.renderFrameRate;
    }

    public final InboundRtcpStats getRtcpStats() {
        return this.rtcpStats;
    }

    public final InboundRtpStats getRtpStats() {
        return this.rtpStats;
    }

    public final long getSsrc() {
        return this.ssrc;
    }

    public final double getSumOfSquaredFramesDurations() {
        return this.sumOfSquaredFramesDurations;
    }

    public final float getSyncOffset() {
        return this.syncOffset;
    }

    public final float getTargetDelay() {
        return this.targetDelay;
    }

    public final int getTotalBitrate() {
        return this.totalBitrate;
    }

    public final long getTotalFramesDuration() {
        return this.totalFramesDuration;
    }

    public final long getTotalFreezesDuration() {
        return this.totalFreezesDuration;
    }

    public final long getTotalPausesDuration() {
        return this.totalPausesDuration;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        String str = this.codecName;
        int iHashCode = (((((((((((str != null ? str.hashCode() : 0) * 31) + this.codecPayloadType) * 31) + this.currentDelay) * 31) + this.currentPayloadType) * 31) + this.decodeFrameRate) * 31) + this.decode) * 31;
        String str2 = this.decoderImplementationName;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        FrameCounts frameCounts = this.frameCounts;
        int iA = (((((b.a(this.qpSum) + ((((((((((((((b.a(this.framesRendered) + ((b.a(this.framesDecoded) + ((iHashCode2 + (frameCounts != null ? frameCounts.hashCode() : 0)) * 31)) * 31)) * 31) + this.framesDropped) * 31) + this.height) * 31) + this.jitterBuffer) * 31) + this.maxDecode) * 31) + this.minPlayoutDelay) * 31) + this.networkFrameRate) * 31)) * 31) + this.renderDelay) * 31) + this.renderFrameRate) * 31;
        InboundRtcpStats inboundRtcpStats = this.rtcpStats;
        int iHashCode3 = (iA + (inboundRtcpStats != null ? inboundRtcpStats.hashCode() : 0)) * 31;
        InboundRtpStats inboundRtpStats = this.rtpStats;
        return a.a(this.sumOfSquaredFramesDurations) + ((b.a(this.totalFramesDuration) + ((b.a(this.totalPausesDuration) + ((b.a(this.totalFreezesDuration) + ((b.a(this.pauseCount) + ((b.a(this.freezeCount) + ((((((Float.floatToIntBits(this.targetDelay) + ((Float.floatToIntBits(this.syncOffset) + ((b.a(this.ssrc) + ((iHashCode3 + (inboundRtpStats != null ? inboundRtpStats.hashCode() : 0)) * 31)) * 31)) * 31)) * 31) + this.totalBitrate) * 31) + this.width) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("InboundVideo(codecName=");
        sbU.append(this.codecName);
        sbU.append(", codecPayloadType=");
        sbU.append(this.codecPayloadType);
        sbU.append(", currentDelay=");
        sbU.append(this.currentDelay);
        sbU.append(", currentPayloadType=");
        sbU.append(this.currentPayloadType);
        sbU.append(", decodeFrameRate=");
        sbU.append(this.decodeFrameRate);
        sbU.append(", decode=");
        sbU.append(this.decode);
        sbU.append(", decoderImplementationName=");
        sbU.append(this.decoderImplementationName);
        sbU.append(", frameCounts=");
        sbU.append(this.frameCounts);
        sbU.append(", framesDecoded=");
        sbU.append(this.framesDecoded);
        sbU.append(", framesRendered=");
        sbU.append(this.framesRendered);
        sbU.append(", framesDropped=");
        sbU.append(this.framesDropped);
        sbU.append(", height=");
        sbU.append(this.height);
        sbU.append(", jitterBuffer=");
        sbU.append(this.jitterBuffer);
        sbU.append(", maxDecode=");
        sbU.append(this.maxDecode);
        sbU.append(", minPlayoutDelay=");
        sbU.append(this.minPlayoutDelay);
        sbU.append(", networkFrameRate=");
        sbU.append(this.networkFrameRate);
        sbU.append(", qpSum=");
        sbU.append(this.qpSum);
        sbU.append(", renderDelay=");
        sbU.append(this.renderDelay);
        sbU.append(", renderFrameRate=");
        sbU.append(this.renderFrameRate);
        sbU.append(", rtcpStats=");
        sbU.append(this.rtcpStats);
        sbU.append(", rtpStats=");
        sbU.append(this.rtpStats);
        sbU.append(", ssrc=");
        sbU.append(this.ssrc);
        sbU.append(", syncOffset=");
        sbU.append(this.syncOffset);
        sbU.append(", targetDelay=");
        sbU.append(this.targetDelay);
        sbU.append(", totalBitrate=");
        sbU.append(this.totalBitrate);
        sbU.append(", width=");
        sbU.append(this.width);
        sbU.append(", freezeCount=");
        sbU.append(this.freezeCount);
        sbU.append(", pauseCount=");
        sbU.append(this.pauseCount);
        sbU.append(", totalFreezesDuration=");
        sbU.append(this.totalFreezesDuration);
        sbU.append(", totalPausesDuration=");
        sbU.append(this.totalPausesDuration);
        sbU.append(", totalFramesDuration=");
        sbU.append(this.totalFramesDuration);
        sbU.append(", sumOfSquaredFramesDurations=");
        sbU.append(this.sumOfSquaredFramesDurations);
        sbU.append(")");
        return sbU.toString();
    }
}
