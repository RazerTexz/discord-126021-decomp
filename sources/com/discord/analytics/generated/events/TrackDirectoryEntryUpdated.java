package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackDirectoryEntry;
import com.discord.analytics.generated.traits.TrackDirectoryEntryReceiver;
import com.discord.api.science.AnalyticsSchema;

/* JADX INFO: compiled from: TrackDirectoryEntryUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TrackDirectoryEntryUpdated implements AnalyticsSchema, TrackBaseReceiver, TrackDirectoryEntryReceiver {
    private final transient String analyticsSchemaTypeName = "directory_entry_updated";
    private TrackBase trackBase;
    private TrackDirectoryEntry trackDirectoryEntry;

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
