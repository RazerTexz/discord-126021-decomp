package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;

/* JADX INFO: compiled from: TrackRegisterWillView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TrackRegisterWillView implements AnalyticsSchema, TrackBase2 {
    private final transient String analyticsSchemaTypeName = "register_will_view";
    private TrackBase trackBase;

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
