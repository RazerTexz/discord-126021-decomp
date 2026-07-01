package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;

/* JADX INFO: compiled from: TrackFriendAddNearbyConnected.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TrackFriendAddNearbyConnected implements AnalyticsSchema, TrackBase2 {
    private final transient String analyticsSchemaTypeName = "friend_add_nearby_connected";
    private TrackBase trackBase;

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
