package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;

/* JADX INFO: compiled from: TrackSpotifyAutoPaused.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TrackSpotifyAutoPaused implements AnalyticsSchema, TrackBase2 {
    private final transient String analyticsSchemaTypeName = "spotify_auto_paused";
    private TrackBase trackBase;

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
