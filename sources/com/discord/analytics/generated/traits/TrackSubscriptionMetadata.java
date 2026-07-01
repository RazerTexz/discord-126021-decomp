package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

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
        return Intrinsics3.areEqual(this.subscriptionPlanGatewayPlanId, trackSubscriptionMetadata.subscriptionPlanGatewayPlanId) && Intrinsics3.areEqual(this.subscriptionType, trackSubscriptionMetadata.subscriptionType) && Intrinsics3.areEqual(this.subscriptionPlanId, trackSubscriptionMetadata.subscriptionPlanId) && Intrinsics3.areEqual(this.code, trackSubscriptionMetadata.code);
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
        StringBuilder sbU = outline.U("TrackSubscriptionMetadata(subscriptionPlanGatewayPlanId=");
        sbU.append(this.subscriptionPlanGatewayPlanId);
        sbU.append(", subscriptionType=");
        sbU.append(this.subscriptionType);
        sbU.append(", subscriptionPlanId=");
        sbU.append(this.subscriptionPlanId);
        sbU.append(", code=");
        return outline.E(sbU, this.code, ")");
    }
}
