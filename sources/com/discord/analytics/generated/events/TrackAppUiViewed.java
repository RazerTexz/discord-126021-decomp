package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackAppUiViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAppUiViewed implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.loadId, trackAppUiViewed.loadId) && C12238m.areEqual(this.screenName, trackAppUiViewed.screenName) && C12238m.areEqual(this.durationMsSinceAppOpened, trackAppUiViewed.durationMsSinceAppOpened) && C12238m.areEqual(this.durationMsSinceRequiredJsBundleLoaded, trackAppUiViewed.durationMsSinceRequiredJsBundleLoaded) && C12238m.areEqual(this.durationMsSinceRequiredJsBundleParsed, trackAppUiViewed.durationMsSinceRequiredJsBundleParsed) && C12238m.areEqual(this.hasCachedData, trackAppUiViewed.hasCachedData) && C12238m.areEqual(this.manifest, trackAppUiViewed.manifest) && C12238m.areEqual(this.totalCompressedByteSize, trackAppUiViewed.totalCompressedByteSize) && C12238m.areEqual(this.totalUncompressedByteSize, trackAppUiViewed.totalUncompressedByteSize) && C12238m.areEqual(this.totalTransferByteSize, trackAppUiViewed.totalTransferByteSize) && C12238m.areEqual(this.jsCompressedByteSize, trackAppUiViewed.jsCompressedByteSize) && C12238m.areEqual(this.jsUncompressedByteSize, trackAppUiViewed.jsUncompressedByteSize) && C12238m.areEqual(this.jsTransferByteSize, trackAppUiViewed.jsTransferByteSize) && C12238m.areEqual(this.cssCompressedByteSize, trackAppUiViewed.cssCompressedByteSize) && C12238m.areEqual(this.cssUncompressedByteSize, trackAppUiViewed.cssUncompressedByteSize) && C12238m.areEqual(this.cssTransferByteSize, trackAppUiViewed.cssTransferByteSize) && C12238m.areEqual(this.theme, trackAppUiViewed.theme);
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
        StringBuilder sbM833U = C1643a.m833U("TrackAppUiViewed(loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", screenName=");
        sbM833U.append(this.screenName);
        sbM833U.append(", durationMsSinceAppOpened=");
        sbM833U.append(this.durationMsSinceAppOpened);
        sbM833U.append(", durationMsSinceRequiredJsBundleLoaded=");
        sbM833U.append(this.durationMsSinceRequiredJsBundleLoaded);
        sbM833U.append(", durationMsSinceRequiredJsBundleParsed=");
        sbM833U.append(this.durationMsSinceRequiredJsBundleParsed);
        sbM833U.append(", hasCachedData=");
        sbM833U.append(this.hasCachedData);
        sbM833U.append(", manifest=");
        sbM833U.append(this.manifest);
        sbM833U.append(", totalCompressedByteSize=");
        sbM833U.append(this.totalCompressedByteSize);
        sbM833U.append(", totalUncompressedByteSize=");
        sbM833U.append(this.totalUncompressedByteSize);
        sbM833U.append(", totalTransferByteSize=");
        sbM833U.append(this.totalTransferByteSize);
        sbM833U.append(", jsCompressedByteSize=");
        sbM833U.append(this.jsCompressedByteSize);
        sbM833U.append(", jsUncompressedByteSize=");
        sbM833U.append(this.jsUncompressedByteSize);
        sbM833U.append(", jsTransferByteSize=");
        sbM833U.append(this.jsTransferByteSize);
        sbM833U.append(", cssCompressedByteSize=");
        sbM833U.append(this.cssCompressedByteSize);
        sbM833U.append(", cssUncompressedByteSize=");
        sbM833U.append(this.cssUncompressedByteSize);
        sbM833U.append(", cssTransferByteSize=");
        sbM833U.append(this.cssTransferByteSize);
        sbM833U.append(", theme=");
        return C1643a.m817E(sbM833U, this.theme, ")");
    }
}
