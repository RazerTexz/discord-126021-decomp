package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackDirectoryEntry;
import com.discord.analytics.generated.traits.TrackDirectoryEntry2;
import com.discord.api.science.AnalyticsSchema;

/* JADX INFO: compiled from: TrackDirectoryEntryDeleted.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TrackDirectoryEntryDeleted implements AnalyticsSchema, TrackBase2, TrackDirectoryEntry2 {
    private final transient String analyticsSchemaTypeName = "directory_entry_deleted";
    private TrackBase trackBase;
    private TrackDirectoryEntry trackDirectoryEntry;

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
