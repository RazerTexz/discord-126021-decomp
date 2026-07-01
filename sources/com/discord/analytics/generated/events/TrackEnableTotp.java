package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;

/* JADX INFO: compiled from: TrackEnableTotp.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TrackEnableTotp implements AnalyticsSchema, TrackBaseReceiver {
    private final transient String analyticsSchemaTypeName = "enable_totp";
    private TrackBase trackBase;

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
