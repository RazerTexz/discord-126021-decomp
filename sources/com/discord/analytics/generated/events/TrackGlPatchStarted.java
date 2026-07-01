package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackDispatchBase;
import com.discord.analytics.generated.traits.TrackDispatchBaseReceiver;
import com.discord.analytics.generated.traits.TrackDispatchPatch;
import com.discord.analytics.generated.traits.TrackDispatchPatchReceiver;
import com.discord.api.science.AnalyticsSchema;

/* JADX INFO: compiled from: TrackGlPatchStarted.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TrackGlPatchStarted implements AnalyticsSchema, TrackBaseReceiver, TrackDispatchBaseReceiver, TrackDispatchPatchReceiver {
    private final transient String analyticsSchemaTypeName = "gl_patch_started";
    private TrackBase trackBase;
    private TrackDispatchBase trackDispatchBase;
    private TrackDispatchPatch trackDispatchPatch;

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
