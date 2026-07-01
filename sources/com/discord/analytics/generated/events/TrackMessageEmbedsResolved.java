package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackMessageEmbedsResolved.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackMessageEmbedsResolved implements AnalyticsSchema, TrackBase2, TrackChannel2 {
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
        return Intrinsics3.areEqual(this.messageId, trackMessageEmbedsResolved.messageId) && Intrinsics3.areEqual(this.numEmbeds, trackMessageEmbedsResolved.numEmbeds);
    }

    public int hashCode() {
        Long l = this.messageId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.numEmbeds;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackMessageEmbedsResolved(messageId=");
        sbU.append(this.messageId);
        sbU.append(", numEmbeds=");
        return outline.G(sbU, this.numEmbeds, ")");
    }
}
