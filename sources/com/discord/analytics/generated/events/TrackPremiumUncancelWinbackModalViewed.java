package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackSubscriptionMetadata;
import com.discord.analytics.generated.traits.TrackSubscriptionMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackPremiumUncancelWinbackModalViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPremiumUncancelWinbackModalViewed implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackSubscriptionMetadata2 {
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
        return Intrinsics3.areEqual(this.globalEmojiPosition, trackPremiumUncancelWinbackModalViewed.globalEmojiPosition) && Intrinsics3.areEqual(this.globalEmojiStats, trackPremiumUncancelWinbackModalViewed.globalEmojiStats) && Intrinsics3.areEqual(this.globalEmojiPersonalized, trackPremiumUncancelWinbackModalViewed.globalEmojiPersonalized) && Intrinsics3.areEqual(this.hdStreamingPosition, trackPremiumUncancelWinbackModalViewed.hdStreamingPosition) && Intrinsics3.areEqual(this.hdStreamingStats, trackPremiumUncancelWinbackModalViewed.hdStreamingStats) && Intrinsics3.areEqual(this.hdStreamingPersonalized, trackPremiumUncancelWinbackModalViewed.hdStreamingPersonalized) && Intrinsics3.areEqual(this.largeFileUploadPosition, trackPremiumUncancelWinbackModalViewed.largeFileUploadPosition) && Intrinsics3.areEqual(this.largeFileUploadStats, trackPremiumUncancelWinbackModalViewed.largeFileUploadStats) && Intrinsics3.areEqual(this.largeFileUploadPersonalized, trackPremiumUncancelWinbackModalViewed.largeFileUploadPersonalized);
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
        StringBuilder sbU = outline.U("TrackPremiumUncancelWinbackModalViewed(globalEmojiPosition=");
        sbU.append(this.globalEmojiPosition);
        sbU.append(", globalEmojiStats=");
        sbU.append(this.globalEmojiStats);
        sbU.append(", globalEmojiPersonalized=");
        sbU.append(this.globalEmojiPersonalized);
        sbU.append(", hdStreamingPosition=");
        sbU.append(this.hdStreamingPosition);
        sbU.append(", hdStreamingStats=");
        sbU.append(this.hdStreamingStats);
        sbU.append(", hdStreamingPersonalized=");
        sbU.append(this.hdStreamingPersonalized);
        sbU.append(", largeFileUploadPosition=");
        sbU.append(this.largeFileUploadPosition);
        sbU.append(", largeFileUploadStats=");
        sbU.append(this.largeFileUploadStats);
        sbU.append(", largeFileUploadPersonalized=");
        return outline.D(sbU, this.largeFileUploadPersonalized, ")");
    }
}
