package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.analytics.generated.traits.TrackPaymentMetadata;
import com.discord.analytics.generated.traits.TrackPaymentMetadata2;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackStoreDirectoryCardInteracted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStoreDirectoryCardInteracted implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2, TrackStoreSkuMetadata2, TrackPaymentMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackPaymentMetadata trackPaymentMetadata;
    private TrackStoreSkuMetadata trackStoreSkuMetadata;
    private final CharSequence loadId = null;
    private final Boolean audioEnabled = null;
    private final Boolean blogPostOpened = null;
    private final Boolean isHero = null;
    private final Boolean watchTrailer = null;
    private final Boolean nitroLearnMore = null;
    private final Boolean premiumLearnMore = null;
    private final Long listIndex = null;
    private final Boolean listSearched = null;
    private final CharSequence listSort = null;
    private final CharSequence listFilterDistributionType = null;
    private final transient String analyticsSchemaTypeName = "store_directory_card_interacted";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStoreDirectoryCardInteracted)) {
            return false;
        }
        TrackStoreDirectoryCardInteracted trackStoreDirectoryCardInteracted = (TrackStoreDirectoryCardInteracted) other;
        return Intrinsics3.areEqual(this.loadId, trackStoreDirectoryCardInteracted.loadId) && Intrinsics3.areEqual(this.audioEnabled, trackStoreDirectoryCardInteracted.audioEnabled) && Intrinsics3.areEqual(this.blogPostOpened, trackStoreDirectoryCardInteracted.blogPostOpened) && Intrinsics3.areEqual(this.isHero, trackStoreDirectoryCardInteracted.isHero) && Intrinsics3.areEqual(this.watchTrailer, trackStoreDirectoryCardInteracted.watchTrailer) && Intrinsics3.areEqual(this.nitroLearnMore, trackStoreDirectoryCardInteracted.nitroLearnMore) && Intrinsics3.areEqual(this.premiumLearnMore, trackStoreDirectoryCardInteracted.premiumLearnMore) && Intrinsics3.areEqual(this.listIndex, trackStoreDirectoryCardInteracted.listIndex) && Intrinsics3.areEqual(this.listSearched, trackStoreDirectoryCardInteracted.listSearched) && Intrinsics3.areEqual(this.listSort, trackStoreDirectoryCardInteracted.listSort) && Intrinsics3.areEqual(this.listFilterDistributionType, trackStoreDirectoryCardInteracted.listFilterDistributionType);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.audioEnabled;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.blogPostOpened;
        int iHashCode3 = (iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.isHero;
        int iHashCode4 = (iHashCode3 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.watchTrailer;
        int iHashCode5 = (iHashCode4 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Boolean bool5 = this.nitroLearnMore;
        int iHashCode6 = (iHashCode5 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.premiumLearnMore;
        int iHashCode7 = (iHashCode6 + (bool6 != null ? bool6.hashCode() : 0)) * 31;
        Long l = this.listIndex;
        int iHashCode8 = (iHashCode7 + (l != null ? l.hashCode() : 0)) * 31;
        Boolean bool7 = this.listSearched;
        int iHashCode9 = (iHashCode8 + (bool7 != null ? bool7.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.listSort;
        int iHashCode10 = (iHashCode9 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.listFilterDistributionType;
        return iHashCode10 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackStoreDirectoryCardInteracted(loadId=");
        sbU.append(this.loadId);
        sbU.append(", audioEnabled=");
        sbU.append(this.audioEnabled);
        sbU.append(", blogPostOpened=");
        sbU.append(this.blogPostOpened);
        sbU.append(", isHero=");
        sbU.append(this.isHero);
        sbU.append(", watchTrailer=");
        sbU.append(this.watchTrailer);
        sbU.append(", nitroLearnMore=");
        sbU.append(this.nitroLearnMore);
        sbU.append(", premiumLearnMore=");
        sbU.append(this.premiumLearnMore);
        sbU.append(", listIndex=");
        sbU.append(this.listIndex);
        sbU.append(", listSearched=");
        sbU.append(this.listSearched);
        sbU.append(", listSort=");
        sbU.append(this.listSort);
        sbU.append(", listFilterDistributionType=");
        return outline.E(sbU, this.listFilterDistributionType, ")");
    }
}
