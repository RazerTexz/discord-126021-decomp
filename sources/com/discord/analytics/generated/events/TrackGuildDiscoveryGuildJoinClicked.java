package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackGuildDiscoveryGuildJoinClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildDiscoveryGuildJoinClicked implements AnalyticsSchema, TrackBase2, TrackLocationMetadata2 {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private final Long guildId = null;
    private final CharSequence loadId = null;
    private final transient String analyticsSchemaTypeName = "guild_discovery_guild_join_clicked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildDiscoveryGuildJoinClicked)) {
            return false;
        }
        TrackGuildDiscoveryGuildJoinClicked trackGuildDiscoveryGuildJoinClicked = (TrackGuildDiscoveryGuildJoinClicked) other;
        return Intrinsics3.areEqual(this.guildId, trackGuildDiscoveryGuildJoinClicked.guildId) && Intrinsics3.areEqual(this.loadId, trackGuildDiscoveryGuildJoinClicked.loadId);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.loadId;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGuildDiscoveryGuildJoinClicked(guildId=");
        sbU.append(this.guildId);
        sbU.append(", loadId=");
        return outline.E(sbU, this.loadId, ")");
    }
}
