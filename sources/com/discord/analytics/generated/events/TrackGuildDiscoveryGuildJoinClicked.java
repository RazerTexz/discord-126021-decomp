package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackGuildDiscoveryGuildJoinClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildDiscoveryGuildJoinClicked implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver {
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
        return C12238m.areEqual(this.guildId, trackGuildDiscoveryGuildJoinClicked.guildId) && C12238m.areEqual(this.loadId, trackGuildDiscoveryGuildJoinClicked.loadId);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.loadId;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackGuildDiscoveryGuildJoinClicked(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", loadId=");
        return C1643a.m817E(sbM833U, this.loadId, ")");
    }
}
