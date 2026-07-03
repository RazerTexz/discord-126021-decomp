package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackLfgGroup;
import com.discord.analytics.generated.traits.TrackLfgGroupReceiver;
import com.discord.api.science.AnalyticsSchema;

/* JADX INFO: compiled from: TrackLfgGroupReported.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TrackLfgGroupReported implements AnalyticsSchema, TrackBaseReceiver, TrackChannelReceiver, TrackLfgGroupReceiver {
    private final transient String analyticsSchemaTypeName = "lfg_group_reported";
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackLfgGroup trackLfgGroup;

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
