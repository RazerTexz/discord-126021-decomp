package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.houseId, trackHypesquadSubscriptionUpdated.houseId) && C12238m.areEqual(this.subscribed, trackHypesquadSubscriptionUpdated.subscribed);
    }

    public int hashCode() {
        Long l = this.houseId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Boolean bool = this.subscribed;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackHypesquadSubscriptionUpdated(houseId=");
        sbM833U.append(this.houseId);
        sbM833U.append(", subscribed=");
        return C1643a.m816D(sbM833U, this.subscribed, ")");
    }
}
