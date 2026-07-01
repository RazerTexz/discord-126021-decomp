package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackPremiumCanceled.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPremiumCanceled implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence cancellationType = null;
    private final Long subscriptionLength = null;
    private final CharSequence plan = null;
    private final transient String analyticsSchemaTypeName = "premium_canceled";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPremiumCanceled)) {
            return false;
        }
        TrackPremiumCanceled trackPremiumCanceled = (TrackPremiumCanceled) other;
        return Intrinsics3.areEqual(this.cancellationType, trackPremiumCanceled.cancellationType) && Intrinsics3.areEqual(this.subscriptionLength, trackPremiumCanceled.subscriptionLength) && Intrinsics3.areEqual(this.plan, trackPremiumCanceled.plan);
    }

    public int hashCode() {
        CharSequence charSequence = this.cancellationType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.subscriptionLength;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.plan;
        return iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackPremiumCanceled(cancellationType=");
        sbU.append(this.cancellationType);
        sbU.append(", subscriptionLength=");
        sbU.append(this.subscriptionLength);
        sbU.append(", plan=");
        return outline.E(sbU, this.plan, ")");
    }
}
