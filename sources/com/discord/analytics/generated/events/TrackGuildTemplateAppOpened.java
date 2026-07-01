package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuildTemplate;
import com.discord.analytics.generated.traits.TrackGuildTemplate2;
import com.discord.api.science.AnalyticsSchema;

/* JADX INFO: compiled from: TrackGuildTemplateAppOpened.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TrackGuildTemplateAppOpened implements AnalyticsSchema, TrackBase2, TrackGuildTemplate2 {
    private final transient String analyticsSchemaTypeName = "guild_template_app_opened";
    private TrackBase trackBase;
    private TrackGuildTemplate trackGuildTemplate;

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
