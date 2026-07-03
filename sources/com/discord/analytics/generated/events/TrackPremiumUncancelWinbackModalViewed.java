package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.analytics.generated.traits.TrackSubscriptionMetadata;
import com.discord.analytics.generated.traits.TrackSubscriptionMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackPremiumUncancelWinbackModalViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPremiumUncancelWinbackModalViewed implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver, TrackSubscriptionMetadataReceiver {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackSubscriptionMetadata trackSubscriptionMetadata;
    private final Long globalEmojiPosition = null;
    private final Long globalEmojiStats = null;
    private final Boolean globalEmojiPersonalized = null;
    private final Long hdStreamingPosition = null;
    private final Long hdStreamingStats = null;
    private final Boolean hdStreamingPersonalized = null;
    private final Long largeFileUploadPosition = null;
    private final Long largeFileUploadStats = null;
    private final Boolean largeFileUploadPersonalized = null;
    private final transient String analyticsSchemaTypeName = "premium_uncancel_winback_modal_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPremiumUncancelWinbackModalViewed)) {
            return false;
        }
        TrackPremiumUncancelWinbackModalViewed trackPremiumUncancelWinbackModalViewed = (TrackPremiumUncancelWinbackModalViewed) other;
        return C12238m.areEqual(this.globalEmojiPosition, trackPremiumUncancelWinbackModalViewed.globalEmojiPosition) && C12238m.areEqual(this.globalEmojiStats, trackPremiumUncancelWinbackModalViewed.globalEmojiStats) && C12238m.areEqual(this.globalEmojiPersonalized, trackPremiumUncancelWinbackModalViewed.globalEmojiPersonalized) && C12238m.areEqual(this.hdStreamingPosition, trackPremiumUncancelWinbackModalViewed.hdStreamingPosition) && C12238m.areEqual(this.hdStreamingStats, trackPremiumUncancelWinbackModalViewed.hdStreamingStats) && C12238m.areEqual(this.hdStreamingPersonalized, trackPremiumUncancelWinbackModalViewed.hdStreamingPersonalized) && C12238m.areEqual(this.largeFileUploadPosition, trackPremiumUncancelWinbackModalViewed.largeFileUploadPosition) && C12238m.areEqual(this.largeFileUploadStats, trackPremiumUncancelWinbackModalViewed.largeFileUploadStats) && C12238m.areEqual(this.largeFileUploadPersonalized, trackPremiumUncancelWinbackModalViewed.largeFileUploadPersonalized);
    }

    public int hashCode() {
        Long l = this.globalEmojiPosition;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.globalEmojiStats;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Boolean bool = this.globalEmojiPersonalized;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l3 = this.hdStreamingPosition;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.hdStreamingStats;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Boolean bool2 = this.hdStreamingPersonalized;
        int iHashCode6 = (iHashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l5 = this.largeFileUploadPosition;
        int iHashCode7 = (iHashCode6 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.largeFileUploadStats;
        int iHashCode8 = (iHashCode7 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Boolean bool3 = this.largeFileUploadPersonalized;
        return iHashCode8 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackPremiumUncancelWinbackModalViewed(globalEmojiPosition=");
        sbM833U.append(this.globalEmojiPosition);
        sbM833U.append(", globalEmojiStats=");
        sbM833U.append(this.globalEmojiStats);
        sbM833U.append(", globalEmojiPersonalized=");
        sbM833U.append(this.globalEmojiPersonalized);
        sbM833U.append(", hdStreamingPosition=");
        sbM833U.append(this.hdStreamingPosition);
        sbM833U.append(", hdStreamingStats=");
        sbM833U.append(this.hdStreamingStats);
        sbM833U.append(", hdStreamingPersonalized=");
        sbM833U.append(this.hdStreamingPersonalized);
        sbM833U.append(", largeFileUploadPosition=");
        sbM833U.append(this.largeFileUploadPosition);
        sbM833U.append(", largeFileUploadStats=");
        sbM833U.append(this.largeFileUploadStats);
        sbM833U.append(", largeFileUploadPersonalized=");
        return C1643a.m816D(sbM833U, this.largeFileUploadPersonalized, ")");
    }
}
