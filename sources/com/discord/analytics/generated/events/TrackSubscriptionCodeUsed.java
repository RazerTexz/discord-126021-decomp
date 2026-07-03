package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackSubscriptionCodeUsed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSubscriptionCodeUsed implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.couponCode, trackSubscriptionCodeUsed.couponCode) && C12238m.areEqual(this.source, trackSubscriptionCodeUsed.source) && C12238m.areEqual(this.subscriptionType, trackSubscriptionCodeUsed.subscriptionType) && C12238m.areEqual(this.currentPeriodEnd, trackSubscriptionCodeUsed.currentPeriodEnd);
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
        StringBuilder sbM833U = C1643a.m833U("TrackSubscriptionCodeUsed(couponCode=");
        sbM833U.append(this.couponCode);
        sbM833U.append(", source=");
        sbM833U.append(this.source);
        sbM833U.append(", subscriptionType=");
        sbM833U.append(this.subscriptionType);
        sbM833U.append(", currentPeriodEnd=");
        return C1643a.m819G(sbM833U, this.currentPeriodEnd, ")");
    }
}
