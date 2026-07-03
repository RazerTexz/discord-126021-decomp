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

/* JADX INFO: compiled from: TrackStoreDirectoryHeroViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackStoreDirectoryHeroViewed implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver, TrackStoreSkuMetadataReceiver, TrackPaymentMetadataReceiver {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackPaymentMetadata trackPaymentMetadata;
    private TrackStoreSkuMetadata trackStoreSkuMetadata;
    private final CharSequence loadId = null;
    private final Long cardIndex = null;
    private final CharSequence cardType = null;
    private final transient String analyticsSchemaTypeName = "store_directory_hero_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackStoreDirectoryHeroViewed)) {
            return false;
        }
        TrackStoreDirectoryHeroViewed trackStoreDirectoryHeroViewed = (TrackStoreDirectoryHeroViewed) other;
        return C12238m.areEqual(this.loadId, trackStoreDirectoryHeroViewed.loadId) && C12238m.areEqual(this.cardIndex, trackStoreDirectoryHeroViewed.cardIndex) && C12238m.areEqual(this.cardType, trackStoreDirectoryHeroViewed.cardType);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.cardIndex;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.cardType;
        return iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackStoreDirectoryHeroViewed(loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", cardIndex=");
        sbM833U.append(this.cardIndex);
        sbM833U.append(", cardType=");
        return C1643a.m817E(sbM833U, this.cardType, ")");
    }
}
