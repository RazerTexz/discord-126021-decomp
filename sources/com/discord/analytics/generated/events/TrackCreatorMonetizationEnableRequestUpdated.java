package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackCreatorMonetizationEnableRequest;
import com.discord.analytics.generated.traits.TrackCreatorMonetizationEnableRequestReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;

/* JADX INFO: compiled from: TrackCreatorMonetizationEnableRequestUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TrackCreatorMonetizationEnableRequestUpdated implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackCreatorMonetizationEnableRequestReceiver {
    private final transient String analyticsSchemaTypeName = "creator_monetization_enable_request_updated";
    private TrackBase trackBase;
    private TrackCreatorMonetizationEnableRequest trackCreatorMonetizationEnableRequest;
    private TrackGuild trackGuild;

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    public void c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
