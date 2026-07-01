package com.discord.rtcconnection.socket.io;

import androidx.core.app.FrameMetricsAggregator;
import b.d.b.a.a;
import b.i.d.p.b;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Payloads.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Payloads$Stream {
    private final Boolean active;

    @b("max_bitrate")
    private final Integer maxBitrate;

    @b("max_framerate")
    private final Integer maxFrameRate;

    @b("max_resolution")
    private final Payloads$Stream$MaxResolution maxResolution;
    private final Integer quality;
    private final String rid;

    @b("rtx_ssrc")
    private final Integer rtxSsrc;
    private final Integer ssrc;
    private final String type;

    public Payloads$Stream() {
        this(null, null, null, null, null, null, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public Payloads$Stream(String str, String str2, Integer num, Integer num2, Integer num3, Integer num4, Payloads$Stream$MaxResolution payloads$Stream$MaxResolution, Boolean bool, Integer num5) {
        this.type = str;
        this.rid = str2;
        this.maxFrameRate = num;
        this.quality = num2;
        this.ssrc = num3;
        this.rtxSsrc = num4;
        this.maxResolution = payloads$Stream$MaxResolution;
        this.active = bool;
        this.maxBitrate = num5;
    }

    public static /* synthetic */ Payloads$Stream copy$default(Payloads$Stream payloads$Stream, String str, String str2, Integer num, Integer num2, Integer num3, Integer num4, Payloads$Stream$MaxResolution payloads$Stream$MaxResolution, Boolean bool, Integer num5, int i, Object obj) {
        return payloads$Stream.copy((i & 1) != 0 ? payloads$Stream.type : str, (i & 2) != 0 ? payloads$Stream.rid : str2, (i & 4) != 0 ? payloads$Stream.maxFrameRate : num, (i & 8) != 0 ? payloads$Stream.quality : num2, (i & 16) != 0 ? payloads$Stream.ssrc : num3, (i & 32) != 0 ? payloads$Stream.rtxSsrc : num4, (i & 64) != 0 ? payloads$Stream.maxResolution : payloads$Stream$MaxResolution, (i & 128) != 0 ? payloads$Stream.active : bool, (i & 256) != 0 ? payloads$Stream.maxBitrate : num5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRid() {
        return this.rid;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getMaxFrameRate() {
        return this.maxFrameRate;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getQuality() {
        return this.quality;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getSsrc() {
        return this.ssrc;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getRtxSsrc() {
        return this.rtxSsrc;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Payloads$Stream$MaxResolution getMaxResolution() {
        return this.maxResolution;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Boolean getActive() {
        return this.active;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getMaxBitrate() {
        return this.maxBitrate;
    }

    public final Payloads$Stream copy(String type, String rid, Integer maxFrameRate, Integer quality, Integer ssrc, Integer rtxSsrc, Payloads$Stream$MaxResolution maxResolution, Boolean active, Integer maxBitrate) {
        return new Payloads$Stream(type, rid, maxFrameRate, quality, ssrc, rtxSsrc, maxResolution, active, maxBitrate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Payloads$Stream)) {
            return false;
        }
        Payloads$Stream payloads$Stream = (Payloads$Stream) other;
        return m.areEqual(this.type, payloads$Stream.type) && m.areEqual(this.rid, payloads$Stream.rid) && m.areEqual(this.maxFrameRate, payloads$Stream.maxFrameRate) && m.areEqual(this.quality, payloads$Stream.quality) && m.areEqual(this.ssrc, payloads$Stream.ssrc) && m.areEqual(this.rtxSsrc, payloads$Stream.rtxSsrc) && m.areEqual(this.maxResolution, payloads$Stream.maxResolution) && m.areEqual(this.active, payloads$Stream.active) && m.areEqual(this.maxBitrate, payloads$Stream.maxBitrate);
    }

    public final Boolean getActive() {
        return this.active;
    }

    public final Integer getMaxBitrate() {
        return this.maxBitrate;
    }

    public final Integer getMaxFrameRate() {
        return this.maxFrameRate;
    }

    public final Payloads$Stream$MaxResolution getMaxResolution() {
        return this.maxResolution;
    }

    public final Integer getQuality() {
        return this.quality;
    }

    public final String getRid() {
        return this.rid;
    }

    public final Integer getRtxSsrc() {
        return this.rtxSsrc;
    }

    public final Integer getSsrc() {
        return this.ssrc;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.rid;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.maxFrameRate;
        int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.quality;
        int iHashCode4 = (iHashCode3 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.ssrc;
        int iHashCode5 = (iHashCode4 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.rtxSsrc;
        int iHashCode6 = (iHashCode5 + (num4 != null ? num4.hashCode() : 0)) * 31;
        Payloads$Stream$MaxResolution payloads$Stream$MaxResolution = this.maxResolution;
        int iHashCode7 = (iHashCode6 + (payloads$Stream$MaxResolution != null ? payloads$Stream$MaxResolution.hashCode() : 0)) * 31;
        Boolean bool = this.active;
        int iHashCode8 = (iHashCode7 + (bool != null ? bool.hashCode() : 0)) * 31;
        Integer num5 = this.maxBitrate;
        return iHashCode8 + (num5 != null ? num5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Stream(type=");
        sbU.append(this.type);
        sbU.append(", rid=");
        sbU.append(this.rid);
        sbU.append(", maxFrameRate=");
        sbU.append(this.maxFrameRate);
        sbU.append(", quality=");
        sbU.append(this.quality);
        sbU.append(", ssrc=");
        sbU.append(this.ssrc);
        sbU.append(", rtxSsrc=");
        sbU.append(this.rtxSsrc);
        sbU.append(", maxResolution=");
        sbU.append(this.maxResolution);
        sbU.append(", active=");
        sbU.append(this.active);
        sbU.append(", maxBitrate=");
        return a.F(sbU, this.maxBitrate, ")");
    }

    public /* synthetic */ Payloads$Stream(String str, String str2, Integer num, Integer num2, Integer num3, Integer num4, Payloads$Stream$MaxResolution payloads$Stream$MaxResolution, Boolean bool, Integer num5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : num3, (i & 32) != 0 ? null : num4, (i & 64) != 0 ? null : payloads$Stream$MaxResolution, (i & 128) != 0 ? null : bool, (i & 256) == 0 ? num5 : null);
    }
}
