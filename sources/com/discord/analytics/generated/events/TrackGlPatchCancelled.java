package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackDispatchBase;
import com.discord.analytics.generated.traits.TrackDispatchBase2;
import com.discord.analytics.generated.traits.TrackDispatchPatch;
import com.discord.analytics.generated.traits.TrackDispatchPatch2;
import com.discord.analytics.generated.traits.TrackDispatchStats;
import com.discord.analytics.generated.traits.TrackDispatchStats2;
import com.discord.api.science.AnalyticsSchema;

/* JADX INFO: compiled from: TrackGlPatchCancelled.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TrackGlPatchCancelled implements AnalyticsSchema, TrackBase2, TrackDispatchBase2, TrackDispatchPatch2, TrackDispatchStats2 {
    private final transient String analyticsSchemaTypeName = "gl_patch_cancelled";
    private TrackBase trackBase;
    private TrackDispatchBase trackDispatchBase;
    private TrackDispatchPatch trackDispatchPatch;
    private TrackDispatchStats trackDispatchStats;

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
