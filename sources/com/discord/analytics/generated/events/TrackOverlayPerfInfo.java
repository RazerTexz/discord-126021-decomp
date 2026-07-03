package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.width, trackOverlayPerfInfo.width) && C12238m.areEqual(this.height, trackOverlayPerfInfo.height) && C12238m.areEqual(this.apiName, trackOverlayPerfInfo.apiName) && C12238m.areEqual(this.fullscreen, trackOverlayPerfInfo.fullscreen) && C12238m.areEqual(this.frameBufferSource, trackOverlayPerfInfo.frameBufferSource) && C12238m.areEqual(this.durationUs, trackOverlayPerfInfo.durationUs) && C12238m.areEqual(this.frameCount, trackOverlayPerfInfo.frameCount) && C12238m.areEqual(this.framesReceived, trackOverlayPerfInfo.framesReceived) && C12238m.areEqual(this.framesCaptured, trackOverlayPerfInfo.framesCaptured) && C12238m.areEqual(this.lockFailures, trackOverlayPerfInfo.lockFailures) && C12238m.areEqual(this.frameTimeMinUs, trackOverlayPerfInfo.frameTimeMinUs) && C12238m.areEqual(this.frameTimeMaxUs, trackOverlayPerfInfo.frameTimeMaxUs) && C12238m.areEqual(this.frameTimeAvgUs, trackOverlayPerfInfo.frameTimeAvgUs) && C12238m.areEqual(this.drawTimeMinUs, trackOverlayPerfInfo.drawTimeMinUs) && C12238m.areEqual(this.drawTimeMaxUs, trackOverlayPerfInfo.drawTimeMaxUs) && C12238m.areEqual(this.drawTimeAvgUs, trackOverlayPerfInfo.drawTimeAvgUs) && C12238m.areEqual(this.captureTimeMinUs, trackOverlayPerfInfo.captureTimeMinUs) && C12238m.areEqual(this.captureTimeMaxUs, trackOverlayPerfInfo.captureTimeMaxUs) && C12238m.areEqual(this.captureTimeAvgUs, trackOverlayPerfInfo.captureTimeAvgUs);
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
        StringBuilder sbM833U = C1643a.m833U("TrackOverlayPerfInfo(width=");
        sbM833U.append(this.width);
        sbM833U.append(", height=");
        sbM833U.append(this.height);
        sbM833U.append(", apiName=");
        sbM833U.append(this.apiName);
        sbM833U.append(", fullscreen=");
        sbM833U.append(this.fullscreen);
        sbM833U.append(", frameBufferSource=");
        sbM833U.append(this.frameBufferSource);
        sbM833U.append(", durationUs=");
        sbM833U.append(this.durationUs);
        sbM833U.append(", frameCount=");
        sbM833U.append(this.frameCount);
        sbM833U.append(", framesReceived=");
        sbM833U.append(this.framesReceived);
        sbM833U.append(", framesCaptured=");
        sbM833U.append(this.framesCaptured);
        sbM833U.append(", lockFailures=");
        sbM833U.append(this.lockFailures);
        sbM833U.append(", frameTimeMinUs=");
        sbM833U.append(this.frameTimeMinUs);
        sbM833U.append(", frameTimeMaxUs=");
        sbM833U.append(this.frameTimeMaxUs);
        sbM833U.append(", frameTimeAvgUs=");
        sbM833U.append(this.frameTimeAvgUs);
        sbM833U.append(", drawTimeMinUs=");
        sbM833U.append(this.drawTimeMinUs);
        sbM833U.append(", drawTimeMaxUs=");
        sbM833U.append(this.drawTimeMaxUs);
        sbM833U.append(", drawTimeAvgUs=");
        sbM833U.append(this.drawTimeAvgUs);
        sbM833U.append(", captureTimeMinUs=");
        sbM833U.append(this.captureTimeMinUs);
        sbM833U.append(", captureTimeMaxUs=");
        sbM833U.append(this.captureTimeMaxUs);
        sbM833U.append(", captureTimeAvgUs=");
        return C1643a.m819G(sbM833U, this.captureTimeAvgUs, ")");
    }
}
