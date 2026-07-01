package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackAfCard;
import com.discord.analytics.generated.traits.TrackAfCardReceiver;
import com.discord.analytics.generated.traits.TrackAfGame;
import com.discord.analytics.generated.traits.TrackAfGameReceiver;
import com.discord.analytics.generated.traits.TrackAfParty;
import com.discord.analytics.generated.traits.TrackAfPartyReceiver;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackAfDmVisited.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAfDmVisited implements AnalyticsSchema, TrackBaseReceiver, TrackSourceMetadataReceiver, TrackAfCardReceiver, TrackAfGameReceiver, TrackAfPartyReceiver, TrackChannelReceiver {
    private TrackAfCard trackAfCard;
    private TrackAfGame trackAfGame;
    private TrackAfParty trackAfParty;
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackSourceMetadata trackSourceMetadata;
    private final Long recipientId = null;
    private final transient String analyticsSchemaTypeName = "af_dm_visited";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackAfDmVisited) && m.areEqual(this.recipientId, ((TrackAfDmVisited) other).recipientId);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.recipientId;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.G(a.U("TrackAfDmVisited(recipientId="), this.recipientId, ")");
    }
}
