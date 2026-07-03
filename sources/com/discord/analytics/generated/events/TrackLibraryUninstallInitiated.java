package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;

/* JADX INFO: compiled from: TrackLibraryUninstallInitiated.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TrackLibraryUninstallInitiated implements AnalyticsSchema, TrackBaseReceiver, TrackStoreSkuMetadataReceiver {
    private final transient String analyticsSchemaTypeName = "library_uninstall_initiated";
    private TrackBase trackBase;
    private TrackStoreSkuMetadata trackStoreSkuMetadata;

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
