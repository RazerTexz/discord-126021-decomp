package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackEntitlementMetadata.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackEntitlementMetadata {
    private final Long entitlementId = null;
    private final Long entitlementCreatorId = null;
    private final Long entitlementSubscriptionPlanId = null;
    private final Long entitlementPaymentId = null;
    private final Long giftCodeBatchId = null;
    private final Long giftStyle = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackEntitlementMetadata)) {
            return false;
        }
        TrackEntitlementMetadata trackEntitlementMetadata = (TrackEntitlementMetadata) other;
        return Intrinsics3.areEqual(this.entitlementId, trackEntitlementMetadata.entitlementId) && Intrinsics3.areEqual(this.entitlementCreatorId, trackEntitlementMetadata.entitlementCreatorId) && Intrinsics3.areEqual(this.entitlementSubscriptionPlanId, trackEntitlementMetadata.entitlementSubscriptionPlanId) && Intrinsics3.areEqual(this.entitlementPaymentId, trackEntitlementMetadata.entitlementPaymentId) && Intrinsics3.areEqual(this.giftCodeBatchId, trackEntitlementMetadata.giftCodeBatchId) && Intrinsics3.areEqual(this.giftStyle, trackEntitlementMetadata.giftStyle);
    }

    public int hashCode() {
        Long l = this.entitlementId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.entitlementCreatorId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.entitlementSubscriptionPlanId;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.entitlementPaymentId;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.giftCodeBatchId;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.giftStyle;
        return iHashCode5 + (l6 != null ? l6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackEntitlementMetadata(entitlementId=");
        sbU.append(this.entitlementId);
        sbU.append(", entitlementCreatorId=");
        sbU.append(this.entitlementCreatorId);
        sbU.append(", entitlementSubscriptionPlanId=");
        sbU.append(this.entitlementSubscriptionPlanId);
        sbU.append(", entitlementPaymentId=");
        sbU.append(this.entitlementPaymentId);
        sbU.append(", giftCodeBatchId=");
        sbU.append(this.giftCodeBatchId);
        sbU.append(", giftStyle=");
        return outline.G(sbU, this.giftStyle, ")");
    }
}
