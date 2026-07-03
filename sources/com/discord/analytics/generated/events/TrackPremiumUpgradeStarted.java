package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackPremiumUpgradeStarted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPremiumUpgradeStarted implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.plan, trackPremiumUpgradeStarted.plan) && C12238m.areEqual(this.priceShown, trackPremiumUpgradeStarted.priceShown);
    }

    public int hashCode() {
        CharSequence charSequence = this.plan;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.priceShown;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackPremiumUpgradeStarted(plan=");
        sbM833U.append(this.plan);
        sbM833U.append(", priceShown=");
        return C1643a.m819G(sbM833U, this.priceShown, ")");
    }
}
