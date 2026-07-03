package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;

/* JADX INFO: compiled from: TrackAfViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TrackAfViewed implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver {
    private final transient String analyticsSchemaTypeName = "af_viewed";
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
