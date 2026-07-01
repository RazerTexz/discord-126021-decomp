package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackOverlayPerfInfo.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackOverlayPerfInfo implements AnalyticsSchema, TrackBaseReceiver, TrackOverlayClientMetadataReceiver {
    private TrackBase trackBase;
    private TrackOverlayClientMetadata trackOverlayClientMetadata;
    private final Long width = null;
    private final Long height = null;
    private final CharSequence apiName = null;
    private final Boolean fullscreen = null;
    private final CharSequence frameBufferSource = null;
    private final Long durationUs = null;
    private final Long frameCount = null;
    private final Long framesReceived = null;
    private final Long framesCaptured = null;
    private final Long lockFailures = null;
    private final Long frameTimeMinUs = null;
    private final Long frameTimeMaxUs = null;
    private final Long frameTimeAvgUs = null;
    private final Long drawTimeMinUs = null;
    private final Long drawTimeMaxUs = null;
    private final Long drawTimeAvgUs = null;
    private final Long captureTimeMinUs = null;
    private final Long captureTimeMaxUs = null;
    private final Long captureTimeAvgUs = null;
    private final transient String analyticsSchemaTypeName = "overlay_perf_info";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackOverlayPerfInfo)) {
            return false;
        }
        TrackOverlayPerfInfo trackOverlayPerfInfo = (TrackOverlayPerfInfo) other;
        return m.areEqual(this.width, trackOverlayPerfInfo.width) && m.areEqual(this.height, trackOverlayPerfInfo.height) && m.areEqual(this.apiName, trackOverlayPerfInfo.apiName) && m.areEqual(this.fullscreen, trackOverlayPerfInfo.fullscreen) && m.areEqual(this.frameBufferSource, trackOverlayPerfInfo.frameBufferSource) && m.areEqual(this.durationUs, trackOverlayPerfInfo.durationUs) && m.areEqual(this.frameCount, trackOverlayPerfInfo.frameCount) && m.areEqual(this.framesReceived, trackOverlayPerfInfo.framesReceived) && m.areEqual(this.framesCaptured, trackOverlayPerfInfo.framesCaptured) && m.areEqual(this.lockFailures, trackOverlayPerfInfo.lockFailures) && m.areEqual(this.frameTimeMinUs, trackOverlayPerfInfo.frameTimeMinUs) && m.areEqual(this.frameTimeMaxUs, trackOverlayPerfInfo.frameTimeMaxUs) && m.areEqual(this.frameTimeAvgUs, trackOverlayPerfInfo.frameTimeAvgUs) && m.areEqual(this.drawTimeMinUs, trackOverlayPerfInfo.drawTimeMinUs) && m.areEqual(this.drawTimeMaxUs, trackOverlayPerfInfo.drawTimeMaxUs) && m.areEqual(this.drawTimeAvgUs, trackOverlayPerfInfo.drawTimeAvgUs) && m.areEqual(this.captureTimeMinUs, trackOverlayPerfInfo.captureTimeMinUs) && m.areEqual(this.captureTimeMaxUs, trackOverlayPerfInfo.captureTimeMaxUs) && m.areEqual(this.captureTimeAvgUs, trackOverlayPerfInfo.captureTimeAvgUs);
    }

    public int hashCode() {
        Long l = this.width;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.height;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.apiName;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.fullscreen;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.frameBufferSource;
        int iHashCode5 = (iHashCode4 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l3 = this.durationUs;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.frameCount;
        int iHashCode7 = (iHashCode6 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.framesReceived;
        int iHashCode8 = (iHashCode7 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.framesCaptured;
        int iHashCode9 = (iHashCode8 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.lockFailures;
        int iHashCode10 = (iHashCode9 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.frameTimeMinUs;
        int iHashCode11 = (iHashCode10 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.frameTimeMaxUs;
        int iHashCode12 = (iHashCode11 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.frameTimeAvgUs;
        int iHashCode13 = (iHashCode12 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.drawTimeMinUs;
        int iHashCode14 = (iHashCode13 + (l11 != null ? l11.hashCode() : 0)) * 31;
        Long l12 = this.drawTimeMaxUs;
        int iHashCode15 = (iHashCode14 + (l12 != null ? l12.hashCode() : 0)) * 31;
        Long l13 = this.drawTimeAvgUs;
        int iHashCode16 = (iHashCode15 + (l13 != null ? l13.hashCode() : 0)) * 31;
        Long l14 = this.captureTimeMinUs;
        int iHashCode17 = (iHashCode16 + (l14 != null ? l14.hashCode() : 0)) * 31;
        Long l15 = this.captureTimeMaxUs;
        int iHashCode18 = (iHashCode17 + (l15 != null ? l15.hashCode() : 0)) * 31;
        Long l16 = this.captureTimeAvgUs;
        return iHashCode18 + (l16 != null ? l16.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackOverlayPerfInfo(width=");
        sbU.append(this.width);
        sbU.append(", height=");
        sbU.append(this.height);
        sbU.append(", apiName=");
        sbU.append(this.apiName);
        sbU.append(", fullscreen=");
        sbU.append(this.fullscreen);
        sbU.append(", frameBufferSource=");
        sbU.append(this.frameBufferSource);
        sbU.append(", durationUs=");
        sbU.append(this.durationUs);
        sbU.append(", frameCount=");
        sbU.append(this.frameCount);
        sbU.append(", framesReceived=");
        sbU.append(this.framesReceived);
        sbU.append(", framesCaptured=");
        sbU.append(this.framesCaptured);
        sbU.append(", lockFailures=");
        sbU.append(this.lockFailures);
        sbU.append(", frameTimeMinUs=");
        sbU.append(this.frameTimeMinUs);
        sbU.append(", frameTimeMaxUs=");
        sbU.append(this.frameTimeMaxUs);
        sbU.append(", frameTimeAvgUs=");
        sbU.append(this.frameTimeAvgUs);
        sbU.append(", drawTimeMinUs=");
        sbU.append(this.drawTimeMinUs);
        sbU.append(", drawTimeMaxUs=");
        sbU.append(this.drawTimeMaxUs);
        sbU.append(", drawTimeAvgUs=");
        sbU.append(this.drawTimeAvgUs);
        sbU.append(", captureTimeMinUs=");
        sbU.append(this.captureTimeMinUs);
        sbU.append(", captureTimeMaxUs=");
        sbU.append(this.captureTimeMaxUs);
        sbU.append(", captureTimeAvgUs=");
        return a.G(sbU, this.captureTimeAvgUs, ")");
    }
}
