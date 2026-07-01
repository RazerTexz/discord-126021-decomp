package com.discord.analytics.generated.traits;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackSubscriptionMetadata.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSubscriptionMetadata {
    private final CharSequence subscriptionPlanGatewayPlanId = null;
    private final Long subscriptionType = null;
    private final Long subscriptionPlanId = null;
    private final CharSequence code = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSubscriptionMetadata)) {
            return false;
        }
        TrackSubscriptionMetadata trackSubscriptionMetadata = (TrackSubscriptionMetadata) other;
        return m.areEqual(this.subscriptionPlanGatewayPlanId, trackSubscriptionMetadata.subscriptionPlanGatewayPlanId) && m.areEqual(this.subscriptionType, trackSubscriptionMetadata.subscriptionType) && m.areEqual(this.subscriptionPlanId, trackSubscriptionMetadata.subscriptionPlanId) && m.areEqual(this.code, trackSubscriptionMetadata.code);
    }

    public int hashCode() {
        CharSequence charSequence = this.subscriptionPlanGatewayPlanId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.subscriptionType;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.subscriptionPlanId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.code;
        return iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackSubscriptionMetadata(subscriptionPlanGatewayPlanId=");
        sbU.append(this.subscriptionPlanGatewayPlanId);
        sbU.append(", subscriptionType=");
        sbU.append(this.subscriptionType);
        sbU.append(", subscriptionPlanId=");
        sbU.append(this.subscriptionPlanId);
        sbU.append(", code=");
        return a.E(sbU, this.code, ")");
    }
}
