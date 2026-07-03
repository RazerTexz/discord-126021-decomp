package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackUserPremiumGuildSubscriptionSlotRemoved.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUserPremiumGuildSubscriptionSlotRemoved implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.slotId, trackUserPremiumGuildSubscriptionSlotRemoved.slotId) && C12238m.areEqual(this.subscriptionId, trackUserPremiumGuildSubscriptionSlotRemoved.subscriptionId) && C12238m.areEqual(this.removalType, trackUserPremiumGuildSubscriptionSlotRemoved.removalType);
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
        StringBuilder sbM833U = C1643a.m833U("TrackUserPremiumGuildSubscriptionSlotRemoved(slotId=");
        sbM833U.append(this.slotId);
        sbM833U.append(", subscriptionId=");
        sbM833U.append(this.subscriptionId);
        sbM833U.append(", removalType=");
        return C1643a.m817E(sbM833U, this.removalType, ")");
    }
}
