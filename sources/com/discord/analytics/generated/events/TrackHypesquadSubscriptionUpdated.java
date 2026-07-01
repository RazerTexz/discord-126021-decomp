package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackHypesquadSubscriptionUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackHypesquadSubscriptionUpdated implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long houseId = null;
    private final Boolean subscribed = null;
    private final transient String analyticsSchemaTypeName = "hypesquad_subscription_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackHypesquadSubscriptionUpdated)) {
            return false;
        }
        TrackHypesquadSubscriptionUpdated trackHypesquadSubscriptionUpdated = (TrackHypesquadSubscriptionUpdated) other;
        return m.areEqual(this.houseId, trackHypesquadSubscriptionUpdated.houseId) && m.areEqual(this.subscribed, trackHypesquadSubscriptionUpdated.subscribed);
    }

    public int hashCode() {
        Long l = this.houseId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Boolean bool = this.subscribed;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackHypesquadSubscriptionUpdated(houseId=");
        sbU.append(this.houseId);
        sbU.append(", subscribed=");
        return a.D(sbU, this.subscribed, ")");
    }
}
