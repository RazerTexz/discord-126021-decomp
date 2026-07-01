package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackDiscoverySetupPopularTagClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDiscoverySetupPopularTagClicked implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final CharSequence tag = null;
    private final Long primaryCategoryId = null;
    private final transient String analyticsSchemaTypeName = "discovery_setup_popular_tag_clicked";

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    public void c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDiscoverySetupPopularTagClicked)) {
            return false;
        }
        TrackDiscoverySetupPopularTagClicked trackDiscoverySetupPopularTagClicked = (TrackDiscoverySetupPopularTagClicked) other;
        return m.areEqual(this.tag, trackDiscoverySetupPopularTagClicked.tag) && m.areEqual(this.primaryCategoryId, trackDiscoverySetupPopularTagClicked.primaryCategoryId);
    }

    public int hashCode() {
        CharSequence charSequence = this.tag;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.primaryCategoryId;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackDiscoverySetupPopularTagClicked(tag=");
        sbU.append(this.tag);
        sbU.append(", primaryCategoryId=");
        return a.G(sbU, this.primaryCategoryId, ")");
    }
}
