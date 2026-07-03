package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
    /* JADX INFO: renamed from: c */
    public void mo7508c(TrackGuild trackGuild) {
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
        return C12238m.areEqual(this.tag, trackDiscoverySetupPopularTagClicked.tag) && C12238m.areEqual(this.primaryCategoryId, trackDiscoverySetupPopularTagClicked.primaryCategoryId);
    }

    public int hashCode() {
        CharSequence charSequence = this.tag;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.primaryCategoryId;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackDiscoverySetupPopularTagClicked(tag=");
        sbM833U.append(this.tag);
        sbM833U.append(", primaryCategoryId=");
        return C1643a.m819G(sbM833U, this.primaryCategoryId, ")");
    }
}
