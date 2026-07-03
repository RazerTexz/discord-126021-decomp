package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackSubscriptionLazySyncUserPerks.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSubscriptionLazySyncUserPerks implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.subscriptionId, trackSubscriptionLazySyncUserPerks.subscriptionId) && C12238m.areEqual(this.subscriptionPlanId, trackSubscriptionLazySyncUserPerks.subscriptionPlanId) && C12238m.areEqual(this.paymentGateway, trackSubscriptionLazySyncUserPerks.paymentGateway) && C12238m.areEqual(this.paymentGatewayPlanId, trackSubscriptionLazySyncUserPerks.paymentGatewayPlanId) && C12238m.areEqual(this.currentPeriodStart, trackSubscriptionLazySyncUserPerks.currentPeriodStart) && C12238m.areEqual(this.currentPeriodEnd, trackSubscriptionLazySyncUserPerks.currentPeriodEnd) && C12238m.areEqual(this.premiumTypeMismatch, trackSubscriptionLazySyncUserPerks.premiumTypeMismatch) && C12238m.areEqual(this.premiumUntilMismatch, trackSubscriptionLazySyncUserPerks.premiumUntilMismatch) && C12238m.areEqual(this.originalPremiumType, trackSubscriptionLazySyncUserPerks.originalPremiumType) && C12238m.areEqual(this.originalPremiumUntil, trackSubscriptionLazySyncUserPerks.originalPremiumUntil) && C12238m.areEqual(this.newPremiumType, trackSubscriptionLazySyncUserPerks.newPremiumType) && C12238m.areEqual(this.newPremiumUntil, trackSubscriptionLazySyncUserPerks.newPremiumUntil);
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
        StringBuilder sbM833U = C1643a.m833U("TrackSubscriptionLazySyncUserPerks(subscriptionId=");
        sbM833U.append(this.subscriptionId);
        sbM833U.append(", subscriptionPlanId=");
        sbM833U.append(this.subscriptionPlanId);
        sbM833U.append(", paymentGateway=");
        sbM833U.append(this.paymentGateway);
        sbM833U.append(", paymentGatewayPlanId=");
        sbM833U.append(this.paymentGatewayPlanId);
        sbM833U.append(", currentPeriodStart=");
        sbM833U.append(this.currentPeriodStart);
        sbM833U.append(", currentPeriodEnd=");
        sbM833U.append(this.currentPeriodEnd);
        sbM833U.append(", premiumTypeMismatch=");
        sbM833U.append(this.premiumTypeMismatch);
        sbM833U.append(", premiumUntilMismatch=");
        sbM833U.append(this.premiumUntilMismatch);
        sbM833U.append(", originalPremiumType=");
        sbM833U.append(this.originalPremiumType);
        sbM833U.append(", originalPremiumUntil=");
        sbM833U.append(this.originalPremiumUntil);
        sbM833U.append(", newPremiumType=");
        sbM833U.append(this.newPremiumType);
        sbM833U.append(", newPremiumUntil=");
        return C1643a.m819G(sbM833U, this.newPremiumUntil, ")");
    }
}
