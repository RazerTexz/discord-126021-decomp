package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackGuildFeedItemUnfeatured.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildFeedItemUnfeatured implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence entityType = null;
    private final Long entityId = null;
    private final transient String analyticsSchemaTypeName = "guild_feed_item_unfeatured";

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
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
        return Intrinsics3.areEqual(this.entityType, trackGuildFeedItemUnfeatured.entityType) && Intrinsics3.areEqual(this.entityId, trackGuildFeedItemUnfeatured.entityId);
    }

    public int hashCode() {
        CharSequence charSequence = this.entityType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.entityId;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackGuildFeedItemUnfeatured(entityType=");
        sbU.append(this.entityType);
        sbU.append(", entityId=");
        return outline.G(sbU, this.entityId, ")");
    }
}
