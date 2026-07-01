package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: TrackGuildInsightsGuildGridViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildInsightsGuildGridViewed implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final List<Long> guildIds = null;
    private final transient String analyticsSchemaTypeName = "guild_insights_guild_grid_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackGuildInsightsGuildGridViewed) && m.areEqual(this.guildIds, ((TrackGuildInsightsGuildGridViewed) other).guildIds);
        }
        return true;
    }

    public int hashCode() {
        List<Long> list = this.guildIds;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.L(a.U("TrackGuildInsightsGuildGridViewed(guildIds="), this.guildIds, ")");
    }
}
