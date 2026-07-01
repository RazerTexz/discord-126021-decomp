package com.discord.analytics.generated.traits;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

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
        return Intrinsics3.areEqual(this.giftCode, trackGiftCodeMetadata.giftCode) && Intrinsics3.areEqual(this.giftCodeSkuId, trackGiftCodeMetadata.giftCodeSkuId) && Intrinsics3.areEqual(this.giftCodeMaxUses, trackGiftCodeMetadata.giftCodeMaxUses) && Intrinsics3.areEqual(this.giftCodeMaxAge, trackGiftCodeMetadata.giftCodeMaxAge) && Intrinsics3.areEqual(this.giftCodeSubscriptionPlanId, trackGiftCodeMetadata.giftCodeSubscriptionPlanId);
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
        StringBuilder sbU = outline.U("TrackGiftCodeMetadata(giftCode=");
        sbU.append(this.giftCode);
        sbU.append(", giftCodeSkuId=");
        sbU.append(this.giftCodeSkuId);
        sbU.append(", giftCodeMaxUses=");
        sbU.append(this.giftCodeMaxUses);
        sbU.append(", giftCodeMaxAge=");
        sbU.append(this.giftCodeMaxAge);
        sbU.append(", giftCodeSubscriptionPlanId=");
        return outline.G(sbU, this.giftCodeSubscriptionPlanId, ")");
    }
}
