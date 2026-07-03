package com.discord.analytics.generated.events.activity_internal;

import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadataReceiver;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackActivityInternalWatchTogetherSearched.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivityInternalWatchTogetherSearched implements AnalyticsSchema, TrackBaseReceiver, TrackActivityInternalMetadataReceiver {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final Boolean isHost = null;
    private final CharSequence searchType = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_watch_together_searched";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalWatchTogetherSearched)) {
            return false;
        }
        TrackActivityInternalWatchTogetherSearched trackActivityInternalWatchTogetherSearched = (TrackActivityInternalWatchTogetherSearched) other;
        return C12238m.areEqual(this.isHost, trackActivityInternalWatchTogetherSearched.isHost) && C12238m.areEqual(this.searchType, trackActivityInternalWatchTogetherSearched.searchType);
    }

    public int hashCode() {
        Boolean bool = this.isHost;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.searchType;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackActivityInternalWatchTogetherSearched(isHost=");
        sbM833U.append(this.isHost);
        sbM833U.append(", searchType=");
        return C1643a.m817E(sbM833U, this.searchType, ")");
    }
}
