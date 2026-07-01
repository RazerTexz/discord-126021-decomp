package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackEmail;
import com.discord.analytics.generated.traits.TrackEmail2;
import com.discord.api.science.AnalyticsSchema;

/* JADX INFO: compiled from: TrackEmailOpened.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TrackEmailOpened implements AnalyticsSchema, TrackBase2, TrackEmail2 {
    private final transient String analyticsSchemaTypeName = "email_opened";
    private TrackBase trackBase;
    private TrackEmail trackEmail;

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
