package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.analytics.generated.traits.TrackMarketingSite;
import com.discord.analytics.generated.traits.TrackMarketingSiteReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackMktgVideoPlayed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMktgVideoPlayed implements AnalyticsSchema, TrackBaseReceiver, TrackMarketingSiteReceiver, TrackLocationMetadataReceiver {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackMarketingSite trackMarketingSite;
    private final CharSequence pageName = null;
    private final CharSequence videoUrl = null;
    private final transient String analyticsSchemaTypeName = "mktg_video_played";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackMktgVideoPlayed)) {
            return false;
        }
        TrackMktgVideoPlayed trackMktgVideoPlayed = (TrackMktgVideoPlayed) other;
        return C12238m.areEqual(this.pageName, trackMktgVideoPlayed.pageName) && C12238m.areEqual(this.videoUrl, trackMktgVideoPlayed.videoUrl);
    }

    public int hashCode() {
        CharSequence charSequence = this.pageName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.videoUrl;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackMktgVideoPlayed(pageName=");
        sbM833U.append(this.pageName);
        sbM833U.append(", videoUrl=");
        return C1643a.m817E(sbM833U, this.videoUrl, ")");
    }
}
