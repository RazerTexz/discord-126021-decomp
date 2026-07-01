package co.discord.media_engine;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: StreamParameters.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class StreamParameters {
    private final boolean active;
    private final int maxBitrate;
    private final int maxPixelCount;
    private final int quality;
    private final String rid;
    private final int rtxSsrc;
    private final int ssrc;
    private final StreamParameters2 type;

    public StreamParameters(StreamParameters2 streamParameters2, String str, int i, int i2, boolean z2, int i3, int i4, int i5) {
        Intrinsics3.checkNotNullParameter(streamParameters2, "type");
        Intrinsics3.checkNotNullParameter(str, "rid");
        this.type = streamParameters2;
        this.rid = str;
        this.ssrc = i;
        this.rtxSsrc = i2;
        this.active = z2;
        this.maxBitrate = i3;
        this.quality = i4;
        this.maxPixelCount = i5;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StreamParameters2 getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRid() {
        return this.rid;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getSsrc() {
        return this.ssrc;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getRtxSsrc() {
        return this.rtxSsrc;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getActive() {
        return this.active;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getMaxBitrate() {
        return this.maxBitrate;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getQuality() {
        return this.quality;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getMaxPixelCount() {
        return this.maxPixelCount;
    }

    public final StreamParameters copy(StreamParameters2 type, String rid, int ssrc, int rtxSsrc, boolean active, int maxBitrate, int quality, int maxPixelCount) {
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(rid, "rid");
        return new StreamParameters(type, rid, ssrc, rtxSsrc, active, maxBitrate, quality, maxPixelCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StreamParameters)) {
            return false;
        }
        StreamParameters streamParameters = (StreamParameters) other;
        return Intrinsics3.areEqual(this.type, streamParameters.type) && Intrinsics3.areEqual(this.rid, streamParameters.rid) && this.ssrc == streamParameters.ssrc && this.rtxSsrc == streamParameters.rtxSsrc && this.active == streamParameters.active && this.maxBitrate == streamParameters.maxBitrate && this.quality == streamParameters.quality && this.maxPixelCount == streamParameters.maxPixelCount;
    }

    public final boolean getActive() {
        return this.active;
    }

    public final int getMaxBitrate() {
        return this.maxBitrate;
    }

    public final int getMaxPixelCount() {
        return this.maxPixelCount;
    }

    public final int getQuality() {
        return this.quality;
    }

    public final String getRid() {
        return this.rid;
    }

    public final int getRtxSsrc() {
        return this.rtxSsrc;
    }

    public final int getSsrc() {
        return this.ssrc;
    }

    public final StreamParameters2 getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        StreamParameters2 streamParameters2 = this.type;
        int iHashCode = (streamParameters2 != null ? streamParameters2.hashCode() : 0) * 31;
        String str = this.rid;
        int iHashCode2 = (((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.ssrc) * 31) + this.rtxSsrc) * 31;
        boolean z2 = this.active;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return ((((((iHashCode2 + r1) * 31) + this.maxBitrate) * 31) + this.quality) * 31) + this.maxPixelCount;
    }

    public String toString() {
        StringBuilder sbU = outline.U("StreamParameters(type=");
        sbU.append(this.type);
        sbU.append(", rid=");
        sbU.append(this.rid);
        sbU.append(", ssrc=");
        sbU.append(this.ssrc);
        sbU.append(", rtxSsrc=");
        sbU.append(this.rtxSsrc);
        sbU.append(", active=");
        sbU.append(this.active);
        sbU.append(", maxBitrate=");
        sbU.append(this.maxBitrate);
        sbU.append(", quality=");
        sbU.append(this.quality);
        sbU.append(", maxPixelCount=");
        return outline.B(sbU, this.maxPixelCount, ")");
    }
}
