package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackPremiumPurchaseCompleted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPremiumPurchaseCompleted implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Boolean success = null;
    private final CharSequence errorCode = null;
    private final CharSequence plan = null;
    private final CharSequence paymentGateway = null;
    private final transient String analyticsSchemaTypeName = "premium_purchase_completed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPremiumPurchaseCompleted)) {
            return false;
        }
        TrackPremiumPurchaseCompleted trackPremiumPurchaseCompleted = (TrackPremiumPurchaseCompleted) other;
        return C12238m.areEqual(this.success, trackPremiumPurchaseCompleted.success) && C12238m.areEqual(this.errorCode, trackPremiumPurchaseCompleted.errorCode) && C12238m.areEqual(this.plan, trackPremiumPurchaseCompleted.plan) && C12238m.areEqual(this.paymentGateway, trackPremiumPurchaseCompleted.paymentGateway);
    }

    public int hashCode() {
        Boolean bool = this.success;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.errorCode;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.plan;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.paymentGateway;
        return iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackPremiumPurchaseCompleted(success=");
        sbM833U.append(this.success);
        sbM833U.append(", errorCode=");
        sbM833U.append(this.errorCode);
        sbM833U.append(", plan=");
        sbM833U.append(this.plan);
        sbM833U.append(", paymentGateway=");
        return C1643a.m817E(sbM833U, this.paymentGateway, ")");
    }
}
