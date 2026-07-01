package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.analytics.generated.traits.TrackMarketingSite;
import com.discord.analytics.generated.traits.TrackMarketingSiteReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

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
        return m.areEqual(this.pageName, trackMktgVideoPlayed.pageName) && m.areEqual(this.videoUrl, trackMktgVideoPlayed.videoUrl);
    }

    public int hashCode() {
        CharSequence charSequence = this.pageName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.videoUrl;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackMktgVideoPlayed(pageName=");
        sbU.append(this.pageName);
        sbU.append(", videoUrl=");
        return a.E(sbU, this.videoUrl, ")");
    }
}
