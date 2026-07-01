package co.discord.media_engine;

import a0.a.a.a;
import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: Statistics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class InboundRtpVideo {
    private final int averageDecodeTime;
    private final int bitrate;
    private final long bytesReceived;
    private final StatsCodec codec;
    private final String decoderImplementationName;
    private final long firCount;
    private final int frameRateDecode;
    private final int frameRateNetwork;
    private final int frameRateRender;
    private final int framesDecoded;
    private final int framesDropped;
    private final int framesReceived;
    private final long freezeCount;
    private final long nackCount;
    private final int packetsLost;
    private final int packetsReceived;
    private final long pauseCount;
    private final long pliCount;
    private final long qpSum;
    private final Resolution resolution;
    private final long ssrc;
    private final double sumOfSquaredFramesDurations;
    private final long totalFramesDuration;
    private final long totalFreezesDuration;
    private final long totalPausesDuration;
    private final String type;

    public InboundRtpVideo(String str, long j, StatsCodec statsCodec, long j2, int i, int i2, int i3, int i4, Resolution resolution, String str2, int i5, int i6, int i7, int i8, int i9, int i10, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, double d) {
        Intrinsics3.checkNotNullParameter(str, "type");
        Intrinsics3.checkNotNullParameter(resolution, "resolution");
        Intrinsics3.checkNotNullParameter(str2, "decoderImplementationName");
        this.type = str;
        this.ssrc = j;
        this.codec = statsCodec;
        this.bytesReceived = j2;
        this.packetsReceived = i;
        this.packetsLost = i2;
        this.bitrate = i3;
        this.averageDecodeTime = i4;
        this.resolution = resolution;
        this.decoderImplementationName = str2;
        this.framesDecoded = i5;
        this.framesDropped = i6;
        this.framesReceived = i7;
        this.frameRateDecode = i8;
        this.frameRateNetwork = i9;
        this.frameRateRender = i10;
        this.firCount = j3;
        this.nackCount = j4;
        this.pliCount = j5;
        this.qpSum = j6;
        this.freezeCount = j7;
        this.pauseCount = j8;
        this.totalFreezesDuration = j9;
        this.totalPausesDuration = j10;
        this.totalFramesDuration = j11;
        this.sumOfSquaredFramesDurations = d;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getDecoderImplementationName() {
        return this.decoderImplementationName;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getFramesDecoded() {
        return this.framesDecoded;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getFramesDropped() {
        return this.framesDropped;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getFramesReceived() {
        return this.framesReceived;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getFrameRateDecode() {
        return this.frameRateDecode;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getFrameRateNetwork() {
        return this.frameRateNetwork;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final int getFrameRateRender() {
        return this.frameRateRender;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final long getFirCount() {
        return this.firCount;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final long getNackCount() {
        return this.nackCount;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final long getPliCount() {
        return this.pliCount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getSsrc() {
        return this.ssrc;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final long getQpSum() {
        return this.qpSum;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final long getFreezeCount() {
        return this.freezeCount;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final long getPauseCount() {
        return this.pauseCount;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final long getTotalFreezesDuration() {
        return this.totalFreezesDuration;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final long getTotalPausesDuration() {
        return this.totalPausesDuration;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final long getTotalFramesDuration() {
        return this.totalFramesDuration;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final double getSumOfSquaredFramesDurations() {
        return this.sumOfSquaredFramesDurations;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final StatsCodec getCodec() {
        return this.codec;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getBytesReceived() {
        return this.bytesReceived;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getPacketsReceived() {
        return this.packetsReceived;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getPacketsLost() {
        return this.packetsLost;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getBitrate() {
        return this.bitrate;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getAverageDecodeTime() {
        return this.averageDecodeTime;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Resolution getResolution() {
        return this.resolution;
    }

    public final InboundRtpVideo copy(String type, long ssrc, StatsCodec codec, long bytesReceived, int packetsReceived, int packetsLost, int bitrate, int averageDecodeTime, Resolution resolution, String decoderImplementationName, int framesDecoded, int framesDropped, int framesReceived, int frameRateDecode, int frameRateNetwork, int frameRateRender, long firCount, long nackCount, long pliCount, long qpSum, long freezeCount, long pauseCount, long totalFreezesDuration, long totalPausesDuration, long totalFramesDuration, double sumOfSquaredFramesDurations) {
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(resolution, "resolution");
        Intrinsics3.checkNotNullParameter(decoderImplementationName, "decoderImplementationName");
        return new InboundRtpVideo(type, ssrc, codec, bytesReceived, packetsReceived, packetsLost, bitrate, averageDecodeTime, resolution, decoderImplementationName, framesDecoded, framesDropped, framesReceived, frameRateDecode, frameRateNetwork, frameRateRender, firCount, nackCount, pliCount, qpSum, freezeCount, pauseCount, totalFreezesDuration, totalPausesDuration, totalFramesDuration, sumOfSquaredFramesDurations);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InboundRtpVideo)) {
            return false;
        }
        InboundRtpVideo inboundRtpVideo = (InboundRtpVideo) other;
        return Intrinsics3.areEqual(this.type, inboundRtpVideo.type) && this.ssrc == inboundRtpVideo.ssrc && Intrinsics3.areEqual(this.codec, inboundRtpVideo.codec) && this.bytesReceived == inboundRtpVideo.bytesReceived && this.packetsReceived == inboundRtpVideo.packetsReceived && this.packetsLost == inboundRtpVideo.packetsLost && this.bitrate == inboundRtpVideo.bitrate && this.averageDecodeTime == inboundRtpVideo.averageDecodeTime && Intrinsics3.areEqual(this.resolution, inboundRtpVideo.resolution) && Intrinsics3.areEqual(this.decoderImplementationName, inboundRtpVideo.decoderImplementationName) && this.framesDecoded == inboundRtpVideo.framesDecoded && this.framesDropped == inboundRtpVideo.framesDropped && this.framesReceived == inboundRtpVideo.framesReceived && this.frameRateDecode == inboundRtpVideo.frameRateDecode && this.frameRateNetwork == inboundRtpVideo.frameRateNetwork && this.frameRateRender == inboundRtpVideo.frameRateRender && this.firCount == inboundRtpVideo.firCount && this.nackCount == inboundRtpVideo.nackCount && this.pliCount == inboundRtpVideo.pliCount && this.qpSum == inboundRtpVideo.qpSum && this.freezeCount == inboundRtpVideo.freezeCount && this.pauseCount == inboundRtpVideo.pauseCount && this.totalFreezesDuration == inboundRtpVideo.totalFreezesDuration && this.totalPausesDuration == inboundRtpVideo.totalPausesDuration && this.totalFramesDuration == inboundRtpVideo.totalFramesDuration && Double.compare(this.sumOfSquaredFramesDurations, inboundRtpVideo.sumOfSquaredFramesDurations) == 0;
    }

    public final int getAverageDecodeTime() {
        return this.averageDecodeTime;
    }

    public final int getBitrate() {
        return this.bitrate;
    }

    public final long getBytesReceived() {
        return this.bytesReceived;
    }

    public final StatsCodec getCodec() {
        return this.codec;
    }

    public final String getDecoderImplementationName() {
        return this.decoderImplementationName;
    }

    public final long getFirCount() {
        return this.firCount;
    }

    public final int getFrameRateDecode() {
        return this.frameRateDecode;
    }

    public final int getFrameRateNetwork() {
        return this.frameRateNetwork;
    }

    public final int getFrameRateRender() {
        return this.frameRateRender;
    }

    public final int getFramesDecoded() {
        return this.framesDecoded;
    }

    public final int getFramesDropped() {
        return this.framesDropped;
    }

    public final int getFramesReceived() {
        return this.framesReceived;
    }

    public final long getFreezeCount() {
        return this.freezeCount;
    }

    public final long getNackCount() {
        return this.nackCount;
    }

    public final int getPacketsLost() {
        return this.packetsLost;
    }

    public final int getPacketsReceived() {
        return this.packetsReceived;
    }

    public final long getPauseCount() {
        return this.pauseCount;
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

    public final double getSumOfSquaredFramesDurations() {
        return this.sumOfSquaredFramesDurations;
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

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        int iA = (b.a(this.ssrc) + ((str != null ? str.hashCode() : 0) * 31)) * 31;
        StatsCodec statsCodec = this.codec;
        int iA2 = (((((((((b.a(this.bytesReceived) + ((iA + (statsCodec != null ? statsCodec.hashCode() : 0)) * 31)) * 31) + this.packetsReceived) * 31) + this.packetsLost) * 31) + this.bitrate) * 31) + this.averageDecodeTime) * 31;
        Resolution resolution = this.resolution;
        int iHashCode = (iA2 + (resolution != null ? resolution.hashCode() : 0)) * 31;
        String str2 = this.decoderImplementationName;
        return a.a(this.sumOfSquaredFramesDurations) + ((b.a(this.totalFramesDuration) + ((b.a(this.totalPausesDuration) + ((b.a(this.totalFreezesDuration) + ((b.a(this.pauseCount) + ((b.a(this.freezeCount) + ((b.a(this.qpSum) + ((b.a(this.pliCount) + ((b.a(this.nackCount) + ((b.a(this.firCount) + ((((((((((((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.framesDecoded) * 31) + this.framesDropped) * 31) + this.framesReceived) * 31) + this.frameRateDecode) * 31) + this.frameRateNetwork) * 31) + this.frameRateRender) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("InboundRtpVideo(type=");
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
        sbU.append(", bitrate=");
        sbU.append(this.bitrate);
        sbU.append(", averageDecodeTime=");
        sbU.append(this.averageDecodeTime);
        sbU.append(", resolution=");
        sbU.append(this.resolution);
        sbU.append(", decoderImplementationName=");
        sbU.append(this.decoderImplementationName);
        sbU.append(", framesDecoded=");
        sbU.append(this.framesDecoded);
        sbU.append(", framesDropped=");
        sbU.append(this.framesDropped);
        sbU.append(", framesReceived=");
        sbU.append(this.framesReceived);
        sbU.append(", frameRateDecode=");
        sbU.append(this.frameRateDecode);
        sbU.append(", frameRateNetwork=");
        sbU.append(this.frameRateNetwork);
        sbU.append(", frameRateRender=");
        sbU.append(this.frameRateRender);
        sbU.append(", firCount=");
        sbU.append(this.firCount);
        sbU.append(", nackCount=");
        sbU.append(this.nackCount);
        sbU.append(", pliCount=");
        sbU.append(this.pliCount);
        sbU.append(", qpSum=");
        sbU.append(this.qpSum);
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
