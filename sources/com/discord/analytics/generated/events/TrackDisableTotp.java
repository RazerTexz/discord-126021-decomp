package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;

/* JADX INFO: compiled from: TrackDisableTotp.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TrackDisableTotp implements AnalyticsSchema, TrackBaseReceiver {
    private final transient String analyticsSchemaTypeName = "disable_totp";
    private TrackBase trackBase;

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
