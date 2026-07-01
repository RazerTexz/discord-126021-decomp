package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackOverlay;
import com.discord.analytics.generated.traits.TrackOverlay2;
import com.discord.api.science.AnalyticsSchema;

/* JADX INFO: compiled from: TrackOverlayHookSucceeded.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TrackOverlayHookSucceeded implements AnalyticsSchema, TrackBase2, TrackOverlay2 {
    private final transient String analyticsSchemaTypeName = "overlay_hook_succeeded";
    private TrackBase trackBase;
    private TrackOverlay trackOverlay;

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
