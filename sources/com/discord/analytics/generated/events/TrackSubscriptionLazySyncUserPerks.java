package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackSubscriptionLazySyncUserPerks.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSubscriptionLazySyncUserPerks implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long subscriptionId = null;
    private final Long subscriptionPlanId = null;
    private final Long paymentGateway = null;
    private final CharSequence paymentGatewayPlanId = null;
    private final Long currentPeriodStart = null;
    private final Long currentPeriodEnd = null;
    private final Boolean premiumTypeMismatch = null;
    private final Boolean premiumUntilMismatch = null;
    private final Long originalPremiumType = null;
    private final Long originalPremiumUntil = null;
    private final Long newPremiumType = null;
    private final Long newPremiumUntil = null;
    private final transient String analyticsSchemaTypeName = "subscription_lazy_sync_user_perks";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSubscriptionLazySyncUserPerks)) {
            return false;
        }
        TrackSubscriptionLazySyncUserPerks trackSubscriptionLazySyncUserPerks = (TrackSubscriptionLazySyncUserPerks) other;
        return Intrinsics3.areEqual(this.subscriptionId, trackSubscriptionLazySyncUserPerks.subscriptionId) && Intrinsics3.areEqual(this.subscriptionPlanId, trackSubscriptionLazySyncUserPerks.subscriptionPlanId) && Intrinsics3.areEqual(this.paymentGateway, trackSubscriptionLazySyncUserPerks.paymentGateway) && Intrinsics3.areEqual(this.paymentGatewayPlanId, trackSubscriptionLazySyncUserPerks.paymentGatewayPlanId) && Intrinsics3.areEqual(this.currentPeriodStart, trackSubscriptionLazySyncUserPerks.currentPeriodStart) && Intrinsics3.areEqual(this.currentPeriodEnd, trackSubscriptionLazySyncUserPerks.currentPeriodEnd) && Intrinsics3.areEqual(this.premiumTypeMismatch, trackSubscriptionLazySyncUserPerks.premiumTypeMismatch) && Intrinsics3.areEqual(this.premiumUntilMismatch, trackSubscriptionLazySyncUserPerks.premiumUntilMismatch) && Intrinsics3.areEqual(this.originalPremiumType, trackSubscriptionLazySyncUserPerks.originalPremiumType) && Intrinsics3.areEqual(this.originalPremiumUntil, trackSubscriptionLazySyncUserPerks.originalPremiumUntil) && Intrinsics3.areEqual(this.newPremiumType, trackSubscriptionLazySyncUserPerks.newPremiumType) && Intrinsics3.areEqual(this.newPremiumUntil, trackSubscriptionLazySyncUserPerks.newPremiumUntil);
    }

    public int hashCode() {
        Long l = this.subscriptionId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.subscriptionPlanId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.paymentGateway;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence = this.paymentGatewayPlanId;
        int iHashCode4 = (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l4 = this.currentPeriodStart;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.currentPeriodEnd;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Boolean bool = this.premiumTypeMismatch;
        int iHashCode7 = (iHashCode6 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.premiumUntilMismatch;
        int iHashCode8 = (iHashCode7 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l6 = this.originalPremiumType;
        int iHashCode9 = (iHashCode8 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.originalPremiumUntil;
        int iHashCode10 = (iHashCode9 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.newPremiumType;
        int iHashCode11 = (iHashCode10 + (l8 != null ? l8.hashCode() : 0)) * 31;
        Long l9 = this.newPremiumUntil;
        return iHashCode11 + (l9 != null ? l9.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSubscriptionLazySyncUserPerks(subscriptionId=");
        sbU.append(this.subscriptionId);
        sbU.append(", subscriptionPlanId=");
        sbU.append(this.subscriptionPlanId);
        sbU.append(", paymentGateway=");
        sbU.append(this.paymentGateway);
        sbU.append(", paymentGatewayPlanId=");
        sbU.append(this.paymentGatewayPlanId);
        sbU.append(", currentPeriodStart=");
        sbU.append(this.currentPeriodStart);
        sbU.append(", currentPeriodEnd=");
        sbU.append(this.currentPeriodEnd);
        sbU.append(", premiumTypeMismatch=");
        sbU.append(this.premiumTypeMismatch);
        sbU.append(", premiumUntilMismatch=");
        sbU.append(this.premiumUntilMismatch);
        sbU.append(", originalPremiumType=");
        sbU.append(this.originalPremiumType);
        sbU.append(", originalPremiumUntil=");
        sbU.append(this.originalPremiumUntil);
        sbU.append(", newPremiumType=");
        sbU.append(this.newPremiumType);
        sbU.append(", newPremiumUntil=");
        return outline.G(sbU, this.newPremiumUntil, ")");
    }
}
