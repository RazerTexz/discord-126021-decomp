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

/* JADX INFO: compiled from: TrackGuildFeedItemFeatured.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGuildFeedItemFeatured implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence entityType = null;
    private final Long entityId = null;
    private final Long featureUntil = null;
    private final Long numMessageUrls = null;
    private final Long referenceMessageId = null;
    private final transient String analyticsSchemaTypeName = "guild_feed_item_featured";

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
        if (!(other instanceof TrackGuildFeedItemFeatured)) {
            return false;
        }
        TrackGuildFeedItemFeatured trackGuildFeedItemFeatured = (TrackGuildFeedItemFeatured) other;
        return m.areEqual(this.entityType, trackGuildFeedItemFeatured.entityType) && m.areEqual(this.entityId, trackGuildFeedItemFeatured.entityId) && m.areEqual(this.featureUntil, trackGuildFeedItemFeatured.featureUntil) && m.areEqual(this.numMessageUrls, trackGuildFeedItemFeatured.numMessageUrls) && m.areEqual(this.referenceMessageId, trackGuildFeedItemFeatured.referenceMessageId);
    }

    public int hashCode() {
        CharSequence charSequence = this.entityType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.entityId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.featureUntil;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.numMessageUrls;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.referenceMessageId;
        return iHashCode4 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackGuildFeedItemFeatured(entityType=");
        sbU.append(this.entityType);
        sbU.append(", entityId=");
        sbU.append(this.entityId);
        sbU.append(", featureUntil=");
        sbU.append(this.featureUntil);
        sbU.append(", numMessageUrls=");
        sbU.append(this.numMessageUrls);
        sbU.append(", referenceMessageId=");
        return a.G(sbU, this.referenceMessageId, ")");
    }
}
