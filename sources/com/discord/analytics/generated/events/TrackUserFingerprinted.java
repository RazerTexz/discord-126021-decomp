package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;

/* JADX INFO: compiled from: TrackUserFingerprinted.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TrackUserFingerprinted implements AnalyticsSchema, TrackBase2 {
    private final transient String analyticsSchemaTypeName = "user_fingerprinted";
    private TrackBase trackBase;

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
