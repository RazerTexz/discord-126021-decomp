package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackSubscriptionCodeUsed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSubscriptionCodeUsed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence couponCode = null;
    private final CharSequence source = null;
    private final Long subscriptionType = null;
    private final Long currentPeriodEnd = null;
    private final transient String analyticsSchemaTypeName = "subscription_code_used";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSubscriptionCodeUsed)) {
            return false;
        }
        TrackSubscriptionCodeUsed trackSubscriptionCodeUsed = (TrackSubscriptionCodeUsed) other;
        return Intrinsics3.areEqual(this.couponCode, trackSubscriptionCodeUsed.couponCode) && Intrinsics3.areEqual(this.source, trackSubscriptionCodeUsed.source) && Intrinsics3.areEqual(this.subscriptionType, trackSubscriptionCodeUsed.subscriptionType) && Intrinsics3.areEqual(this.currentPeriodEnd, trackSubscriptionCodeUsed.currentPeriodEnd);
    }

    public int hashCode() {
        CharSequence charSequence = this.couponCode;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.source;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.subscriptionType;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.currentPeriodEnd;
        return iHashCode3 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSubscriptionCodeUsed(couponCode=");
        sbU.append(this.couponCode);
        sbU.append(", source=");
        sbU.append(this.source);
        sbU.append(", subscriptionType=");
        sbU.append(this.subscriptionType);
        sbU.append(", currentPeriodEnd=");
        return outline.G(sbU, this.currentPeriodEnd, ")");
    }
}
