package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackGiftCodeMetadata.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGiftCodeMetadata {
    private final CharSequence giftCode = null;
    private final Long giftCodeSkuId = null;
    private final Long giftCodeMaxUses = null;
    private final Long giftCodeMaxAge = null;
    private final Long giftCodeSubscriptionPlanId = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGiftCodeMetadata)) {
            return false;
        }
        TrackGiftCodeMetadata trackGiftCodeMetadata = (TrackGiftCodeMetadata) other;
        return C12238m.areEqual(this.giftCode, trackGiftCodeMetadata.giftCode) && C12238m.areEqual(this.giftCodeSkuId, trackGiftCodeMetadata.giftCodeSkuId) && C12238m.areEqual(this.giftCodeMaxUses, trackGiftCodeMetadata.giftCodeMaxUses) && C12238m.areEqual(this.giftCodeMaxAge, trackGiftCodeMetadata.giftCodeMaxAge) && C12238m.areEqual(this.giftCodeSubscriptionPlanId, trackGiftCodeMetadata.giftCodeSubscriptionPlanId);
    }

    public int hashCode() {
        CharSequence charSequence = this.giftCode;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.giftCodeSkuId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.giftCodeMaxUses;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.giftCodeMaxAge;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.giftCodeSubscriptionPlanId;
        return iHashCode4 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackGiftCodeMetadata(giftCode=");
        sbM833U.append(this.giftCode);
        sbM833U.append(", giftCodeSkuId=");
        sbM833U.append(this.giftCodeSkuId);
        sbM833U.append(", giftCodeMaxUses=");
        sbM833U.append(this.giftCodeMaxUses);
        sbM833U.append(", giftCodeMaxAge=");
        sbM833U.append(this.giftCodeMaxAge);
        sbM833U.append(", giftCodeSubscriptionPlanId=");
        return C1643a.m819G(sbM833U, this.giftCodeSubscriptionPlanId, ")");
    }
}
