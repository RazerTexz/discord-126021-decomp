package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackUserPremiumGuildSubscriptionSlotRemoved.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUserPremiumGuildSubscriptionSlotRemoved implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long slotId = null;
    private final Long subscriptionId = null;
    private final CharSequence removalType = null;
    private final transient String analyticsSchemaTypeName = "user_premium_guild_subscription_slot_removed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUserPremiumGuildSubscriptionSlotRemoved)) {
            return false;
        }
        TrackUserPremiumGuildSubscriptionSlotRemoved trackUserPremiumGuildSubscriptionSlotRemoved = (TrackUserPremiumGuildSubscriptionSlotRemoved) other;
        return Intrinsics3.areEqual(this.slotId, trackUserPremiumGuildSubscriptionSlotRemoved.slotId) && Intrinsics3.areEqual(this.subscriptionId, trackUserPremiumGuildSubscriptionSlotRemoved.subscriptionId) && Intrinsics3.areEqual(this.removalType, trackUserPremiumGuildSubscriptionSlotRemoved.removalType);
    }

    public int hashCode() {
        Long l = this.slotId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.subscriptionId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.removalType;
        return iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackUserPremiumGuildSubscriptionSlotRemoved(slotId=");
        sbU.append(this.slotId);
        sbU.append(", subscriptionId=");
        sbU.append(this.subscriptionId);
        sbU.append(", removalType=");
        return outline.E(sbU, this.removalType, ")");
    }
}
