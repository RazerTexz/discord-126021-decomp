package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: TrackGuildDiscoveryViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildDiscoveryViewed implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2 {
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
        return Intrinsics3.areEqual(this.loadId, trackGuildDiscoveryViewed.loadId) && Intrinsics3.areEqual(this.numGuilds, trackGuildDiscoveryViewed.numGuilds) && Intrinsics3.areEqual(this.numGuildsRecommended, trackGuildDiscoveryViewed.numGuildsRecommended) && Intrinsics3.areEqual(this.numGuildsPopular, trackGuildDiscoveryViewed.numGuildsPopular) && Intrinsics3.areEqual(this.recommendedGuildIds, trackGuildDiscoveryViewed.recommendedGuildIds) && Intrinsics3.areEqual(this.categoryId, trackGuildDiscoveryViewed.categoryId) && Intrinsics3.areEqual(this.recommendationsSource, trackGuildDiscoveryViewed.recommendationsSource);
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
        StringBuilder sbU = outline.U("TrackGuildDiscoveryViewed(loadId=");
        sbU.append(this.loadId);
        sbU.append(", numGuilds=");
        sbU.append(this.numGuilds);
        sbU.append(", numGuildsRecommended=");
        sbU.append(this.numGuildsRecommended);
        sbU.append(", numGuildsPopular=");
        sbU.append(this.numGuildsPopular);
        sbU.append(", recommendedGuildIds=");
        sbU.append(this.recommendedGuildIds);
        sbU.append(", categoryId=");
        sbU.append(this.categoryId);
        sbU.append(", recommendationsSource=");
        return outline.E(sbU, this.recommendationsSource, ")");
    }
}
