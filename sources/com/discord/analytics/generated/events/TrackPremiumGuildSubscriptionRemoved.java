package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackPremiumGuildSubscriptionRemoved.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPremiumGuildSubscriptionRemoved implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final Long premiumGuildSubscriptionId = null;
    private final Long currentTier = null;
    private final Long previousTier = null;
    private final Long premiumSubscriptionCount = null;
    private final Long tierLost = null;
    private final transient String analyticsSchemaTypeName = "premium_guild_subscription_removed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPremiumGuildSubscriptionRemoved)) {
            return false;
        }
        TrackPremiumGuildSubscriptionRemoved trackPremiumGuildSubscriptionRemoved = (TrackPremiumGuildSubscriptionRemoved) other;
        return m.areEqual(this.guildId, trackPremiumGuildSubscriptionRemoved.guildId) && m.areEqual(this.premiumGuildSubscriptionId, trackPremiumGuildSubscriptionRemoved.premiumGuildSubscriptionId) && m.areEqual(this.currentTier, trackPremiumGuildSubscriptionRemoved.currentTier) && m.areEqual(this.previousTier, trackPremiumGuildSubscriptionRemoved.previousTier) && m.areEqual(this.premiumSubscriptionCount, trackPremiumGuildSubscriptionRemoved.premiumSubscriptionCount) && m.areEqual(this.tierLost, trackPremiumGuildSubscriptionRemoved.tierLost);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.premiumGuildSubscriptionId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.currentTier;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.previousTier;
        int iHashCode4 = (iHashCode3 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.premiumSubscriptionCount;
        int iHashCode5 = (iHashCode4 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.tierLost;
        return iHashCode5 + (l6 != null ? l6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackPremiumGuildSubscriptionRemoved(guildId=");
        sbU.append(this.guildId);
        sbU.append(", premiumGuildSubscriptionId=");
        sbU.append(this.premiumGuildSubscriptionId);
        sbU.append(", currentTier=");
        sbU.append(this.currentTier);
        sbU.append(", previousTier=");
        sbU.append(this.previousTier);
        sbU.append(", premiumSubscriptionCount=");
        sbU.append(this.premiumSubscriptionCount);
        sbU.append(", tierLost=");
        return a.G(sbU, this.tierLost, ")");
    }
}
