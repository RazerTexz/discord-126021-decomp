package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackPremiumUpgradeStarted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPremiumUpgradeStarted implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence plan = null;
    private final Long priceShown = null;
    private final transient String analyticsSchemaTypeName = "premium_upgrade_started";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPremiumUpgradeStarted)) {
            return false;
        }
        TrackPremiumUpgradeStarted trackPremiumUpgradeStarted = (TrackPremiumUpgradeStarted) other;
        return Intrinsics3.areEqual(this.plan, trackPremiumUpgradeStarted.plan) && Intrinsics3.areEqual(this.priceShown, trackPremiumUpgradeStarted.priceShown);
    }

    public int hashCode() {
        CharSequence charSequence = this.plan;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.priceShown;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackPremiumUpgradeStarted(plan=");
        sbU.append(this.plan);
        sbU.append(", priceShown=");
        return outline.G(sbU, this.priceShown, ")");
    }
}
