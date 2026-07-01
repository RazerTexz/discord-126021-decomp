package com.discord.analytics.generated.events.activity_internal;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadataReceiver;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackActivityInternalWatchTogetherVideoAdded.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivityInternalWatchTogetherVideoAdded implements AnalyticsSchema, TrackBaseReceiver, TrackActivityInternalMetadataReceiver {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final Boolean isHost = null;
    private final CharSequence via = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_watch_together_video_added";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalWatchTogetherVideoAdded)) {
            return false;
        }
        TrackActivityInternalWatchTogetherVideoAdded trackActivityInternalWatchTogetherVideoAdded = (TrackActivityInternalWatchTogetherVideoAdded) other;
        return m.areEqual(this.isHost, trackActivityInternalWatchTogetherVideoAdded.isHost) && m.areEqual(this.via, trackActivityInternalWatchTogetherVideoAdded.via);
    }

    public int hashCode() {
        Boolean bool = this.isHost;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.via;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackActivityInternalWatchTogetherVideoAdded(isHost=");
        sbU.append(this.isHost);
        sbU.append(", via=");
        return a.E(sbU, this.via, ")");
    }
}
