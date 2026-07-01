package com.discord.analytics.generated.events.activity_internal;

import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;

/* JADX INFO: compiled from: TrackActivityInternalVideoImpression.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TrackActivityInternalVideoImpression implements AnalyticsSchema, TrackBase2, TrackActivityInternalMetadata2 {
    private final transient String analyticsSchemaTypeName = "activity_internal_video_impression";
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
