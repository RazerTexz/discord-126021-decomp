package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.entitlementId, trackEntitlementMetadata.entitlementId) && C12238m.areEqual(this.entitlementCreatorId, trackEntitlementMetadata.entitlementCreatorId) && C12238m.areEqual(this.entitlementSubscriptionPlanId, trackEntitlementMetadata.entitlementSubscriptionPlanId) && C12238m.areEqual(this.entitlementPaymentId, trackEntitlementMetadata.entitlementPaymentId) && C12238m.areEqual(this.giftCodeBatchId, trackEntitlementMetadata.giftCodeBatchId) && C12238m.areEqual(this.giftStyle, trackEntitlementMetadata.giftStyle);
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
        StringBuilder sbM833U = C1643a.m833U("TrackEntitlementMetadata(entitlementId=");
        sbM833U.append(this.entitlementId);
        sbM833U.append(", entitlementCreatorId=");
        sbM833U.append(this.entitlementCreatorId);
        sbM833U.append(", entitlementSubscriptionPlanId=");
        sbM833U.append(this.entitlementSubscriptionPlanId);
        sbM833U.append(", entitlementPaymentId=");
        sbM833U.append(this.entitlementPaymentId);
        sbM833U.append(", giftCodeBatchId=");
        sbM833U.append(this.giftCodeBatchId);
        sbM833U.append(", giftStyle=");
        return C1643a.m819G(sbM833U, this.giftStyle, ")");
    }
}
