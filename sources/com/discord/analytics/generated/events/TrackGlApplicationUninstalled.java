package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackDispatchBase;
import com.discord.analytics.generated.traits.TrackDispatchBase2;
import com.discord.api.science.AnalyticsSchema;

/* JADX INFO: compiled from: TrackGlApplicationUninstalled.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TrackGlApplicationUninstalled implements AnalyticsSchema, TrackBase2, TrackDispatchBase2 {
    private final transient String analyticsSchemaTypeName = "gl_application_uninstalled";
    private TrackBase trackBase;
    private TrackDispatchBase trackDispatchBase;

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
