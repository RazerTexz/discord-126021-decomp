package co.discord.media_engine.internal;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;
import java.util.Arrays;

/* JADX INFO: compiled from: NativeStatistics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class OutboundVideo {
    private final int avgEncodeTime;
    private final boolean bwLimitedResolution;
    private final String codecName;
    private final int codecPayloadType;
    private final boolean cpuLimitedResolution;
    private final int encodeFrameRate;
    private final int encodeUsage;
    private final String encoderImplementationName;
    private final long framesEncoded;
    private final int inputFrameRate;
    private final int mediaBitrate;
    private final int numberOfCPUAdaptChanges;
    private final int numberOfQualityAdaptChanges;
    private final long qpSum;
    private final Substream[] substreams;
    private final boolean suspended;
    private final int targetMediaBitrate;

    public OutboundVideo(String str, int i, int i2, boolean z2, boolean z3, int i3, int i4, String str2, long j, int i5, int i6, int i7, int i8, long j2, Substream[] substreamArr, boolean z4, int i9) {
        m.checkNotNullParameter(str, "codecName");
        m.checkNotNullParameter(str2, "encoderImplementationName");
        m.checkNotNullParameter(substreamArr, "substreams");
        this.codecName = str;
        this.codecPayloadType = i;
        this.avgEncodeTime = i2;
        this.bwLimitedResolution = z2;
        this.cpuLimitedResolution = z3;
        this.encodeFrameRate = i3;
        this.encodeUsage = i4;
        this.encoderImplementationName = str2;
        this.framesEncoded = j;
        this.inputFrameRate = i5;
        this.mediaBitrate = i6;
        this.numberOfCPUAdaptChanges = i7;
        this.numberOfQualityAdaptChanges = i8;
        this.qpSum = j2;
        this.substreams = substreamArr;
        this.suspended = z4;
        this.targetMediaBitrate = i9;
    }

    public static /* synthetic */ OutboundVideo copy$default(OutboundVideo outboundVideo, String str, int i, int i2, boolean z2, boolean z3, int i3, int i4, String str2, long j, int i5, int i6, int i7, int i8, long j2, Substream[] substreamArr, boolean z4, int i9, int i10, Object obj) {
        return outboundVideo.copy((i10 & 1) != 0 ? outboundVideo.codecName : str, (i10 & 2) != 0 ? outboundVideo.codecPayloadType : i, (i10 & 4) != 0 ? outboundVideo.avgEncodeTime : i2, (i10 & 8) != 0 ? outboundVideo.bwLimitedResolution : z2, (i10 & 16) != 0 ? outboundVideo.cpuLimitedResolution : z3, (i10 & 32) != 0 ? outboundVideo.encodeFrameRate : i3, (i10 & 64) != 0 ? outboundVideo.encodeUsage : i4, (i10 & 128) != 0 ? outboundVideo.encoderImplementationName : str2, (i10 & 256) != 0 ? outboundVideo.framesEncoded : j, (i10 & 512) != 0 ? outboundVideo.inputFrameRate : i5, (i10 & 1024) != 0 ? outboundVideo.mediaBitrate : i6, (i10 & 2048) != 0 ? outboundVideo.numberOfCPUAdaptChanges : i7, (i10 & 4096) != 0 ? outboundVideo.numberOfQualityAdaptChanges : i8, (i10 & 8192) != 0 ? outboundVideo.qpSum : j2, (i10 & 16384) != 0 ? outboundVideo.substreams : substreamArr, (32768 & i10) != 0 ? outboundVideo.suspended : z4, (i10 & 65536) != 0 ? outboundVideo.targetMediaBitrate : i9);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCodecName() {
        return this.codecName;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getInputFrameRate() {
        return this.inputFrameRate;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getMediaBitrate() {
        return this.mediaBitrate;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getNumberOfCPUAdaptChanges() {
        return this.numberOfCPUAdaptChanges;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getNumberOfQualityAdaptChanges() {
        return this.numberOfQualityAdaptChanges;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final long getQpSum() {
        return this.qpSum;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Substream[] getSubstreams() {
        return this.substreams;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final boolean getSuspended() {
        return this.suspended;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final int getTargetMediaBitrate() {
        return this.targetMediaBitrate;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getCodecPayloadType() {
        return this.codecPayloadType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getAvgEncodeTime() {
        return this.avgEncodeTime;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getBwLimitedResolution() {
        return this.bwLimitedResolution;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getCpuLimitedResolution() {
        return this.cpuLimitedResolution;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getEncodeFrameRate() {
        return this.encodeFrameRate;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getEncodeUsage() {
        return this.encodeUsage;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getEncoderImplementationName() {
        return this.encoderImplementationName;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final long getFramesEncoded() {
        return this.framesEncoded;
    }

    public final OutboundVideo copy(String codecName, int codecPayloadType, int avgEncodeTime, boolean bwLimitedResolution, boolean cpuLimitedResolution, int encodeFrameRate, int encodeUsage, String encoderImplementationName, long framesEncoded, int inputFrameRate, int mediaBitrate, int numberOfCPUAdaptChanges, int numberOfQualityAdaptChanges, long qpSum, Substream[] substreams, boolean suspended, int targetMediaBitrate) {
        m.checkNotNullParameter(codecName, "codecName");
        m.checkNotNullParameter(encoderImplementationName, "encoderImplementationName");
        m.checkNotNullParameter(substreams, "substreams");
        return new OutboundVideo(codecName, codecPayloadType, avgEncodeTime, bwLimitedResolution, cpuLimitedResolution, encodeFrameRate, encodeUsage, encoderImplementationName, framesEncoded, inputFrameRate, mediaBitrate, numberOfCPUAdaptChanges, numberOfQualityAdaptChanges, qpSum, substreams, suspended, targetMediaBitrate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OutboundVideo)) {
            return false;
        }
        OutboundVideo outboundVideo = (OutboundVideo) other;
        return m.areEqual(this.codecName, outboundVideo.codecName) && this.codecPayloadType == outboundVideo.codecPayloadType && this.avgEncodeTime == outboundVideo.avgEncodeTime && this.bwLimitedResolution == outboundVideo.bwLimitedResolution && this.cpuLimitedResolution == outboundVideo.cpuLimitedResolution && this.encodeFrameRate == outboundVideo.encodeFrameRate && this.encodeUsage == outboundVideo.encodeUsage && m.areEqual(this.encoderImplementationName, outboundVideo.encoderImplementationName) && this.framesEncoded == outboundVideo.framesEncoded && this.inputFrameRate == outboundVideo.inputFrameRate && this.mediaBitrate == outboundVideo.mediaBitrate && this.numberOfCPUAdaptChanges == outboundVideo.numberOfCPUAdaptChanges && this.numberOfQualityAdaptChanges == outboundVideo.numberOfQualityAdaptChanges && this.qpSum == outboundVideo.qpSum && m.areEqual(this.substreams, outboundVideo.substreams) && this.suspended == outboundVideo.suspended && this.targetMediaBitrate == outboundVideo.targetMediaBitrate;
    }

    public final int getAvgEncodeTime() {
        return this.avgEncodeTime;
    }

    public final boolean getBwLimitedResolution() {
        return this.bwLimitedResolution;
    }

    public final String getCodecName() {
        return this.codecName;
    }

    public final int getCodecPayloadType() {
        return this.codecPayloadType;
    }

    public final boolean getCpuLimitedResolution() {
        return this.cpuLimitedResolution;
    }

    public final int getEncodeFrameRate() {
        return this.encodeFrameRate;
    }

    public final int getEncodeUsage() {
        return this.encodeUsage;
    }

    public final String getEncoderImplementationName() {
        return this.encoderImplementationName;
    }

    public final long getFramesEncoded() {
        return this.framesEncoded;
    }

    public final int getInputFrameRate() {
        return this.inputFrameRate;
    }

    public final int getMediaBitrate() {
        return this.mediaBitrate;
    }

    public final int getNumberOfCPUAdaptChanges() {
        return this.numberOfCPUAdaptChanges;
    }

    public final int getNumberOfQualityAdaptChanges() {
        return this.numberOfQualityAdaptChanges;
    }

    public final long getQpSum() {
        return this.qpSum;
    }

    public final Substream[] getSubstreams() {
        return this.substreams;
    }

    public final boolean getSuspended() {
        return this.suspended;
    }

    public final int getTargetMediaBitrate() {
        return this.targetMediaBitrate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v27, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String str = this.codecName;
        int iHashCode = (((((str != null ? str.hashCode() : 0) * 31) + this.codecPayloadType) * 31) + this.avgEncodeTime) * 31;
        boolean z2 = this.bwLimitedResolution;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        boolean z3 = this.cpuLimitedResolution;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (((((i + r3) * 31) + this.encodeFrameRate) * 31) + this.encodeUsage) * 31;
        String str2 = this.encoderImplementationName;
        int iA = (b.a(this.qpSum) + ((((((((((b.a(this.framesEncoded) + ((i2 + (str2 != null ? str2.hashCode() : 0)) * 31)) * 31) + this.inputFrameRate) * 31) + this.mediaBitrate) * 31) + this.numberOfCPUAdaptChanges) * 31) + this.numberOfQualityAdaptChanges) * 31)) * 31;
        Substream[] substreamArr = this.substreams;
        int iHashCode2 = (iA + (substreamArr != null ? Arrays.hashCode(substreamArr) : 0)) * 31;
        boolean z4 = this.suspended;
        return ((iHashCode2 + (z4 ? 1 : z4)) * 31) + this.targetMediaBitrate;
    }

    public String toString() {
        StringBuilder sbU = a.U("OutboundVideo(codecName=");
        sbU.append(this.codecName);
        sbU.append(", codecPayloadType=");
        sbU.append(this.codecPayloadType);
        sbU.append(", avgEncodeTime=");
        sbU.append(this.avgEncodeTime);
        sbU.append(", bwLimitedResolution=");
        sbU.append(this.bwLimitedResolution);
        sbU.append(", cpuLimitedResolution=");
        sbU.append(this.cpuLimitedResolution);
        sbU.append(", encodeFrameRate=");
        sbU.append(this.encodeFrameRate);
        sbU.append(", encodeUsage=");
        sbU.append(this.encodeUsage);
        sbU.append(", encoderImplementationName=");
        sbU.append(this.encoderImplementationName);
        sbU.append(", framesEncoded=");
        sbU.append(this.framesEncoded);
        sbU.append(", inputFrameRate=");
        sbU.append(this.inputFrameRate);
        sbU.append(", mediaBitrate=");
        sbU.append(this.mediaBitrate);
        sbU.append(", numberOfCPUAdaptChanges=");
        sbU.append(this.numberOfCPUAdaptChanges);
        sbU.append(", numberOfQualityAdaptChanges=");
        sbU.append(this.numberOfQualityAdaptChanges);
        sbU.append(", qpSum=");
        sbU.append(this.qpSum);
        sbU.append(", substreams=");
        sbU.append(Arrays.toString(this.substreams));
        sbU.append(", suspended=");
        sbU.append(this.suspended);
        sbU.append(", targetMediaBitrate=");
        return a.B(sbU, this.targetMediaBitrate, ")");
    }
}
