package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;

/* JADX INFO: compiled from: TrackInviteViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TrackInviteViewed implements AnalyticsSchema, TrackBase2 {
    private final transient String analyticsSchemaTypeName = "invite_viewed";
    private TrackBase trackBase;

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
