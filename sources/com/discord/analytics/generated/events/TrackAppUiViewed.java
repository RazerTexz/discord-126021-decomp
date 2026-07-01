package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackAppUiViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAppUiViewed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence loadId = null;
    private final CharSequence screenName = null;
    private final Long durationMsSinceAppOpened = null;
    private final Long durationMsSinceRequiredJsBundleLoaded = null;
    private final Long durationMsSinceRequiredJsBundleParsed = null;
    private final Boolean hasCachedData = null;
    private final CharSequence manifest = null;
    private final Long totalCompressedByteSize = null;
    private final Long totalUncompressedByteSize = null;
    private final Long totalTransferByteSize = null;
    private final Long jsCompressedByteSize = null;
    private final Long jsUncompressedByteSize = null;
    private final Long jsTransferByteSize = null;
    private final Long cssCompressedByteSize = null;
    private final Long cssUncompressedByteSize = null;
    private final Long cssTransferByteSize = null;
    private final CharSequence theme = null;
    private final transient String analyticsSchemaTypeName = "app_ui_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAppUiViewed)) {
            return false;
        }
        TrackAppUiViewed trackAppUiViewed = (TrackAppUiViewed) other;
        return Intrinsics3.areEqual(this.loadId, trackAppUiViewed.loadId) && Intrinsics3.areEqual(this.screenName, trackAppUiViewed.screenName) && Intrinsics3.areEqual(this.durationMsSinceAppOpened, trackAppUiViewed.durationMsSinceAppOpened) && Intrinsics3.areEqual(this.durationMsSinceRequiredJsBundleLoaded, trackAppUiViewed.durationMsSinceRequiredJsBundleLoaded) && Intrinsics3.areEqual(this.durationMsSinceRequiredJsBundleParsed, trackAppUiViewed.durationMsSinceRequiredJsBundleParsed) && Intrinsics3.areEqual(this.hasCachedData, trackAppUiViewed.hasCachedData) && Intrinsics3.areEqual(this.manifest, trackAppUiViewed.manifest) && Intrinsics3.areEqual(this.totalCompressedByteSize, trackAppUiViewed.totalCompressedByteSize) && Intrinsics3.areEqual(this.totalUncompressedByteSize, trackAppUiViewed.totalUncompressedByteSize) && Intrinsics3.areEqual(this.totalTransferByteSize, trackAppUiViewed.totalTransferByteSize) && Intrinsics3.areEqual(this.jsCompressedByteSize, trackAppUiViewed.jsCompressedByteSize) && Intrinsics3.areEqual(this.jsUncompressedByteSize, trackAppUiViewed.jsUncompressedByteSize) && Intrinsics3.areEqual(this.jsTransferByteSize, trackAppUiViewed.jsTransferByteSize) && Intrinsics3.areEqual(this.cssCompressedByteSize, trackAppUiViewed.cssCompressedByteSize) && Intrinsics3.areEqual(this.cssUncompressedByteSize, trackAppUiViewed.cssUncompressedByteSize) && Intrinsics3.areEqual(this.cssTransferByteSize, trackAppUiViewed.cssTransferByteSize) && Intrinsics3.areEqual(this.theme, trackAppUiViewed.theme);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.screenName;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.durationMsSinceAppOpened;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.durationMsSinceRequiredJsBundleLoaded;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.durationMsSinceRequiredJsBundleParsed;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Boolean bool = this.hasCachedData;
        int iHashCode6 = (iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.manifest;
        int iHashCode7 = (iHashCode6 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l4 = this.totalCompressedByteSize;
        int iHashCode8 = (iHashCode7 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.totalUncompressedByteSize;
        int iHashCode9 = (iHashCode8 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.totalTransferByteSize;
        int iHashCode10 = (iHashCode9 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.jsCompressedByteSize;
        int iHashCode11 = (iHashCode10 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.jsUncompressedByteSize;
        int iHashCode12 = (iHashCode11 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.jsTransferByteSize;
        int iHashCode13 = (iHashCode12 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.cssCompressedByteSize;
        int iHashCode14 = (iHashCode13 + (l10 != null ? l10.hashCode() : 0)) * 31;
        Long l11 = this.cssUncompressedByteSize;
        int iHashCode15 = (iHashCode14 + (l11 != null ? l11.hashCode() : 0)) * 31;
        Long l12 = this.cssTransferByteSize;
        int iHashCode16 = (iHashCode15 + (l12 != null ? l12.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.theme;
        return iHashCode16 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackAppUiViewed(loadId=");
        sbU.append(this.loadId);
        sbU.append(", screenName=");
        sbU.append(this.screenName);
        sbU.append(", durationMsSinceAppOpened=");
        sbU.append(this.durationMsSinceAppOpened);
        sbU.append(", durationMsSinceRequiredJsBundleLoaded=");
        sbU.append(this.durationMsSinceRequiredJsBundleLoaded);
        sbU.append(", durationMsSinceRequiredJsBundleParsed=");
        sbU.append(this.durationMsSinceRequiredJsBundleParsed);
        sbU.append(", hasCachedData=");
        sbU.append(this.hasCachedData);
        sbU.append(", manifest=");
        sbU.append(this.manifest);
        sbU.append(", totalCompressedByteSize=");
        sbU.append(this.totalCompressedByteSize);
        sbU.append(", totalUncompressedByteSize=");
        sbU.append(this.totalUncompressedByteSize);
        sbU.append(", totalTransferByteSize=");
        sbU.append(this.totalTransferByteSize);
        sbU.append(", jsCompressedByteSize=");
        sbU.append(this.jsCompressedByteSize);
        sbU.append(", jsUncompressedByteSize=");
        sbU.append(this.jsUncompressedByteSize);
        sbU.append(", jsTransferByteSize=");
        sbU.append(this.jsTransferByteSize);
        sbU.append(", cssCompressedByteSize=");
        sbU.append(this.cssCompressedByteSize);
        sbU.append(", cssUncompressedByteSize=");
        sbU.append(this.cssUncompressedByteSize);
        sbU.append(", cssTransferByteSize=");
        sbU.append(this.cssTransferByteSize);
        sbU.append(", theme=");
        return outline.E(sbU, this.theme, ")");
    }
}
