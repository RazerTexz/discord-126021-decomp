package co.discord.media_engine.internal;

import a0.a.a.b;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: NativeStatistics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Substream {
    private final int avgDelay;
    private final FrameCounts frameCounts;
    private final int height;
    private final boolean isFlexFEC;
    private final boolean isRTX;
    private final int maxDelay;
    private final int retransmitBitrate;
    private final RtcpStats rtcpStats;
    private final RtpStats rtpStats;
    private final long ssrc;
    private final int totalBitrate;
    private final int width;

    public Substream(int i, FrameCounts frameCounts, int i2, boolean z2, boolean z3, int i3, int i4, RtcpStats rtcpStats, RtpStats rtpStats, long j, int i5, int i6) {
        Intrinsics3.checkNotNullParameter(frameCounts, "frameCounts");
        Intrinsics3.checkNotNullParameter(rtcpStats, "rtcpStats");
        Intrinsics3.checkNotNullParameter(rtpStats, "rtpStats");
        this.avgDelay = i;
        this.frameCounts = frameCounts;
        this.height = i2;
        this.isFlexFEC = z2;
        this.isRTX = z3;
        this.maxDelay = i3;
        this.retransmitBitrate = i4;
        this.rtcpStats = rtcpStats;
        this.rtpStats = rtpStats;
        this.ssrc = j;
        this.totalBitrate = i5;
        this.width = i6;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getAvgDelay() {
        return this.avgDelay;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final long getSsrc() {
        return this.ssrc;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getTotalBitrate() {
        return this.totalBitrate;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final FrameCounts getFrameCounts() {
        return this.frameCounts;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsFlexFEC() {
        return this.isFlexFEC;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsRTX() {
        return this.isRTX;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getMaxDelay() {
        return this.maxDelay;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getRetransmitBitrate() {
        return this.retransmitBitrate;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final RtcpStats getRtcpStats() {
        return this.rtcpStats;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final RtpStats getRtpStats() {
        return this.rtpStats;
    }

    public final Substream copy(int avgDelay, FrameCounts frameCounts, int height, boolean isFlexFEC, boolean isRTX, int maxDelay, int retransmitBitrate, RtcpStats rtcpStats, RtpStats rtpStats, long ssrc, int totalBitrate, int width) {
        Intrinsics3.checkNotNullParameter(frameCounts, "frameCounts");
        Intrinsics3.checkNotNullParameter(rtcpStats, "rtcpStats");
        Intrinsics3.checkNotNullParameter(rtpStats, "rtpStats");
        return new Substream(avgDelay, frameCounts, height, isFlexFEC, isRTX, maxDelay, retransmitBitrate, rtcpStats, rtpStats, ssrc, totalBitrate, width);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Substream)) {
            return false;
        }
        Substream substream = (Substream) other;
        return this.avgDelay == substream.avgDelay && Intrinsics3.areEqual(this.frameCounts, substream.frameCounts) && this.height == substream.height && this.isFlexFEC == substream.isFlexFEC && this.isRTX == substream.isRTX && this.maxDelay == substream.maxDelay && this.retransmitBitrate == substream.retransmitBitrate && Intrinsics3.areEqual(this.rtcpStats, substream.rtcpStats) && Intrinsics3.areEqual(this.rtpStats, substream.rtpStats) && this.ssrc == substream.ssrc && this.totalBitrate == substream.totalBitrate && this.width == substream.width;
    }

    public final int getAvgDelay() {
        return this.avgDelay;
    }

    public final FrameCounts getFrameCounts() {
        return this.frameCounts;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getMaxDelay() {
        return this.maxDelay;
    }

    public final int getRetransmitBitrate() {
        return this.retransmitBitrate;
    }

    public final RtcpStats getRtcpStats() {
        return this.rtcpStats;
    }

    public final RtpStats getRtpStats() {
        return this.rtpStats;
    }

    public final long getSsrc() {
        return this.ssrc;
    }

    public final int getTotalBitrate() {
        return this.totalBitrate;
    }

    public final int getWidth() {
        return this.width;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int i = this.avgDelay * 31;
        FrameCounts frameCounts = this.frameCounts;
        int iHashCode = (((i + (frameCounts != null ? frameCounts.hashCode() : 0)) * 31) + this.height) * 31;
        boolean z2 = this.isFlexFEC;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i2 = (iHashCode + r1) * 31;
        boolean z3 = this.isRTX;
        int i3 = (((((i2 + (z3 ? 1 : z3)) * 31) + this.maxDelay) * 31) + this.retransmitBitrate) * 31;
        RtcpStats rtcpStats = this.rtcpStats;
        int iHashCode2 = (i3 + (rtcpStats != null ? rtcpStats.hashCode() : 0)) * 31;
        RtpStats rtpStats = this.rtpStats;
        return ((((b.a(this.ssrc) + ((iHashCode2 + (rtpStats != null ? rtpStats.hashCode() : 0)) * 31)) * 31) + this.totalBitrate) * 31) + this.width;
    }

    public final boolean isFlexFEC() {
        return this.isFlexFEC;
    }

    public final boolean isRTX() {
        return this.isRTX;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Substream(avgDelay=");
        sbU.append(this.avgDelay);
        sbU.append(", frameCounts=");
        sbU.append(this.frameCounts);
        sbU.append(", height=");
        sbU.append(this.height);
        sbU.append(", isFlexFEC=");
        sbU.append(this.isFlexFEC);
        sbU.append(", isRTX=");
        sbU.append(this.isRTX);
        sbU.append(", maxDelay=");
        sbU.append(this.maxDelay);
        sbU.append(", retransmitBitrate=");
        sbU.append(this.retransmitBitrate);
        sbU.append(", rtcpStats=");
        sbU.append(this.rtcpStats);
        sbU.append(", rtpStats=");
        sbU.append(this.rtpStats);
        sbU.append(", ssrc=");
        sbU.append(this.ssrc);
        sbU.append(", totalBitrate=");
        sbU.append(this.totalBitrate);
        sbU.append(", width=");
        return outline.B(sbU, this.width, ")");
    }
}
