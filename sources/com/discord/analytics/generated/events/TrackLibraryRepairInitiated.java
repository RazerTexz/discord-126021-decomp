package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata2;
import com.discord.api.science.AnalyticsSchema;

/* JADX INFO: compiled from: TrackLibraryRepairInitiated.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TrackLibraryRepairInitiated implements AnalyticsSchema, TrackBase2, TrackStoreSkuMetadata2 {
    private final transient String analyticsSchemaTypeName = "library_repair_initiated";
    private TrackBase trackBase;
    private TrackStoreSkuMetadata trackStoreSkuMetadata;

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
