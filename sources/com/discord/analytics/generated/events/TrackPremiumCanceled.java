package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackPremiumCanceled.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPremiumCanceled implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.cancellationType, trackPremiumCanceled.cancellationType) && C12238m.areEqual(this.subscriptionLength, trackPremiumCanceled.subscriptionLength) && C12238m.areEqual(this.plan, trackPremiumCanceled.plan);
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
        StringBuilder sbM833U = C1643a.m833U("TrackPremiumCanceled(cancellationType=");
        sbM833U.append(this.cancellationType);
        sbM833U.append(", subscriptionLength=");
        sbM833U.append(this.subscriptionLength);
        sbM833U.append(", plan=");
        return C1643a.m817E(sbM833U, this.plan, ")");
    }
}
