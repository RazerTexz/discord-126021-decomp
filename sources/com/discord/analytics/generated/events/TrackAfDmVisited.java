package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackAfCard;
import com.discord.analytics.generated.traits.TrackAfCard2;
import com.discord.analytics.generated.traits.TrackAfGame;
import com.discord.analytics.generated.traits.TrackAfGame2;
import com.discord.analytics.generated.traits.TrackAfParty;
import com.discord.analytics.generated.traits.TrackAfParty2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackAfDmVisited.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAfDmVisited implements AnalyticsSchema, TrackBase2, TrackSourceMetadata2, TrackAfCard2, TrackAfGame2, TrackAfParty2, TrackChannel2 {
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
            return (other instanceof TrackAfDmVisited) && Intrinsics3.areEqual(this.recipientId, ((TrackAfDmVisited) other).recipientId);
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
        return outline.G(outline.U("TrackAfDmVisited(recipientId="), this.recipientId, ")");
    }
}
