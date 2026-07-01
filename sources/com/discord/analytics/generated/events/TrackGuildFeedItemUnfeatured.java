package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackGuildFeedItemUnfeatured.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildFeedItemUnfeatured implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence entityType = null;
    private final Long entityId = null;
    private final transient String analyticsSchemaTypeName = "guild_feed_item_unfeatured";

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

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGuildFeedItemUnfeatured)) {
            return false;
        }
        TrackGuildFeedItemUnfeatured trackGuildFeedItemUnfeatured = (TrackGuildFeedItemUnfeatured) other;
        return m.areEqual(this.entityType, trackGuildFeedItemUnfeatured.entityType) && m.areEqual(this.entityId, trackGuildFeedItemUnfeatured.entityId);
    }

    public int hashCode() {
        CharSequence charSequence = this.entityType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.entityId;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackGuildFeedItemUnfeatured(entityType=");
        sbU.append(this.entityType);
        sbU.append(", entityId=");
        return a.G(sbU, this.entityId, ")");
    }
}
