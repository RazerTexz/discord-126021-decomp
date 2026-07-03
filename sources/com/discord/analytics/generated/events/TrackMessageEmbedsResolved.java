package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackMessageEmbedsResolved.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMessageEmbedsResolved implements AnalyticsSchema, TrackBaseReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private final Long messageId = null;
    private final Long numEmbeds = null;
    private final transient String analyticsSchemaTypeName = "message_embeds_resolved";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackMessageEmbedsResolved)) {
            return false;
        }
        TrackMessageEmbedsResolved trackMessageEmbedsResolved = (TrackMessageEmbedsResolved) other;
        return C12238m.areEqual(this.messageId, trackMessageEmbedsResolved.messageId) && C12238m.areEqual(this.numEmbeds, trackMessageEmbedsResolved.numEmbeds);
    }

    public int hashCode() {
        Long l = this.messageId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.numEmbeds;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackMessageEmbedsResolved(messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", numEmbeds=");
        return C1643a.m819G(sbM833U, this.numEmbeds, ")");
    }
}
