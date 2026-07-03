package co.discord.media_engine;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
    private final MediaType type;

    public StreamParameters(MediaType mediaType, String str, int i, int i2, boolean z2, int i3, int i4, int i5) {
        C12238m.checkNotNullParameter(mediaType, "type");
        C12238m.checkNotNullParameter(str, "rid");
        this.type = mediaType;
        this.rid = str;
        this.ssrc = i;
        this.rtxSsrc = i2;
        this.active = z2;
        this.maxBitrate = i3;
        this.quality = i4;
        this.maxPixelCount = i5;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MediaType getType() {
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

    public final StreamParameters copy(MediaType type, String rid, int ssrc, int rtxSsrc, boolean active, int maxBitrate, int quality, int maxPixelCount) {
        C12238m.checkNotNullParameter(type, "type");
        C12238m.checkNotNullParameter(rid, "rid");
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
        return C12238m.areEqual(this.type, streamParameters.type) && C12238m.areEqual(this.rid, streamParameters.rid) && this.ssrc == streamParameters.ssrc && this.rtxSsrc == streamParameters.rtxSsrc && this.active == streamParameters.active && this.maxBitrate == streamParameters.maxBitrate && this.quality == streamParameters.quality && this.maxPixelCount == streamParameters.maxPixelCount;
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

    public final MediaType getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        MediaType mediaType = this.type;
        int iHashCode = (mediaType != null ? mediaType.hashCode() : 0) * 31;
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
        StringBuilder sbM833U = C1643a.m833U("StreamParameters(type=");
        sbM833U.append(this.type);
        sbM833U.append(", rid=");
        sbM833U.append(this.rid);
        sbM833U.append(", ssrc=");
        sbM833U.append(this.ssrc);
        sbM833U.append(", rtxSsrc=");
        sbM833U.append(this.rtxSsrc);
        sbM833U.append(", active=");
        sbM833U.append(this.active);
        sbM833U.append(", maxBitrate=");
        sbM833U.append(this.maxBitrate);
        sbM833U.append(", quality=");
        sbM833U.append(this.quality);
        sbM833U.append(", maxPixelCount=");
        return C1643a.m814B(sbM833U, this.maxPixelCount, ")");
    }
}
