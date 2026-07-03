package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackGuildDiscoveryViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildDiscoveryViewed implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final CharSequence loadId = null;
    private final Long numGuilds = null;
    private final Long numGuildsRecommended = null;
    private final Long numGuildsPopular = null;
    private final List<Long> recommendedGuildIds = null;
    private final Long categoryId = null;
    private final CharSequence recommendationsSource = null;
    private final transient String analyticsSchemaTypeName = "guild_discovery_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildDiscoveryViewed)) {
            return false;
        }
        TrackGuildDiscoveryViewed trackGuildDiscoveryViewed = (TrackGuildDiscoveryViewed) other;
        return C12238m.areEqual(this.loadId, trackGuildDiscoveryViewed.loadId) && C12238m.areEqual(this.numGuilds, trackGuildDiscoveryViewed.numGuilds) && C12238m.areEqual(this.numGuildsRecommended, trackGuildDiscoveryViewed.numGuildsRecommended) && C12238m.areEqual(this.numGuildsPopular, trackGuildDiscoveryViewed.numGuildsPopular) && C12238m.areEqual(this.recommendedGuildIds, trackGuildDiscoveryViewed.recommendedGuildIds) && C12238m.areEqual(this.categoryId, trackGuildDiscoveryViewed.categoryId) && C12238m.areEqual(this.recommendationsSource, trackGuildDiscoveryViewed.recommendationsSource);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.numGuilds;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.numGuildsRecommended;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.numGuildsPopular;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        List<Long> list = this.recommendedGuildIds;
        int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        Long l4 = this.categoryId;
        int iHashCode6 = (iHashCode5 + (l4 != null ? l4.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.recommendationsSource;
        return iHashCode6 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackGuildDiscoveryViewed(loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", numGuilds=");
        sbM833U.append(this.numGuilds);
        sbM833U.append(", numGuildsRecommended=");
        sbM833U.append(this.numGuildsRecommended);
        sbM833U.append(", numGuildsPopular=");
        sbM833U.append(this.numGuildsPopular);
        sbM833U.append(", recommendedGuildIds=");
        sbM833U.append(this.recommendedGuildIds);
        sbM833U.append(", categoryId=");
        sbM833U.append(this.categoryId);
        sbM833U.append(", recommendationsSource=");
        return C1643a.m817E(sbM833U, this.recommendationsSource, ")");
    }
}
