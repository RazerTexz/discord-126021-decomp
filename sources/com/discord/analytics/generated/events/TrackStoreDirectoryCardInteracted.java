package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.analytics.generated.traits.TrackPaymentMetadata;
import com.discord.analytics.generated.traits.TrackPaymentMetadataReceiver;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackStoreDirectoryCardInteracted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStoreDirectoryCardInteracted implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver, TrackStoreSkuMetadataReceiver, TrackPaymentMetadataReceiver {
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
        return C12238m.areEqual(this.loadId, trackStoreDirectoryCardInteracted.loadId) && C12238m.areEqual(this.audioEnabled, trackStoreDirectoryCardInteracted.audioEnabled) && C12238m.areEqual(this.blogPostOpened, trackStoreDirectoryCardInteracted.blogPostOpened) && C12238m.areEqual(this.isHero, trackStoreDirectoryCardInteracted.isHero) && C12238m.areEqual(this.watchTrailer, trackStoreDirectoryCardInteracted.watchTrailer) && C12238m.areEqual(this.nitroLearnMore, trackStoreDirectoryCardInteracted.nitroLearnMore) && C12238m.areEqual(this.premiumLearnMore, trackStoreDirectoryCardInteracted.premiumLearnMore) && C12238m.areEqual(this.listIndex, trackStoreDirectoryCardInteracted.listIndex) && C12238m.areEqual(this.listSearched, trackStoreDirectoryCardInteracted.listSearched) && C12238m.areEqual(this.listSort, trackStoreDirectoryCardInteracted.listSort) && C12238m.areEqual(this.listFilterDistributionType, trackStoreDirectoryCardInteracted.listFilterDistributionType);
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
        StringBuilder sbM833U = C1643a.m833U("TrackStoreDirectoryCardInteracted(loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", audioEnabled=");
        sbM833U.append(this.audioEnabled);
        sbM833U.append(", blogPostOpened=");
        sbM833U.append(this.blogPostOpened);
        sbM833U.append(", isHero=");
        sbM833U.append(this.isHero);
        sbM833U.append(", watchTrailer=");
        sbM833U.append(this.watchTrailer);
        sbM833U.append(", nitroLearnMore=");
        sbM833U.append(this.nitroLearnMore);
        sbM833U.append(", premiumLearnMore=");
        sbM833U.append(this.premiumLearnMore);
        sbM833U.append(", listIndex=");
        sbM833U.append(this.listIndex);
        sbM833U.append(", listSearched=");
        sbM833U.append(this.listSearched);
        sbM833U.append(", listSort=");
        sbM833U.append(this.listSort);
        sbM833U.append(", listFilterDistributionType=");
        return C1643a.m817E(sbM833U, this.listFilterDistributionType, ")");
    }
}
