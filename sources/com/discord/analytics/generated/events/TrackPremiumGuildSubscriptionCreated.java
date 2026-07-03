package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackPremiumGuildSubscriptionCreated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPremiumGuildSubscriptionCreated implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final Long premiumGuildSubscriptionId = null;
    private final Long currentTier = null;
    private final Long previousTier = null;
    private final Long premiumSubscriptionCount = null;
    private final Long slotId = null;
    private final Long tierReached = null;
    private final transient String analyticsSchemaTypeName = "premium_guild_subscription_created";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPremiumGuildSubscriptionCreated)) {
            return false;
        }
        TrackPremiumGuildSubscriptionCreated trackPremiumGuildSubscriptionCreated = (TrackPremiumGuildSubscriptionCreated) other;
        return C12238m.areEqual(this.guildId, trackPremiumGuildSubscriptionCreated.guildId) && C12238m.areEqual(this.premiumGuildSubscriptionId, trackPremiumGuildSubscriptionCreated.premiumGuildSubscriptionId) && C12238m.areEqual(this.currentTier, trackPremiumGuildSubscriptionCreated.currentTier) && C12238m.areEqual(this.previousTier, trackPremiumGuildSubscriptionCreated.previousTier) && C12238m.areEqual(this.premiumSubscriptionCount, trackPremiumGuildSubscriptionCreated.premiumSubscriptionCount) && C12238m.areEqual(this.slotId, trackPremiumGuildSubscriptionCreated.slotId) && C12238m.areEqual(this.tierReached, trackPremiumGuildSubscriptionCreated.tierReached);
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
        Long l6 = this.slotId;
        int iHashCode6 = (iHashCode5 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.tierReached;
        return iHashCode6 + (l7 != null ? l7.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackPremiumGuildSubscriptionCreated(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", premiumGuildSubscriptionId=");
        sbM833U.append(this.premiumGuildSubscriptionId);
        sbM833U.append(", currentTier=");
        sbM833U.append(this.currentTier);
        sbM833U.append(", previousTier=");
        sbM833U.append(this.previousTier);
        sbM833U.append(", premiumSubscriptionCount=");
        sbM833U.append(this.premiumSubscriptionCount);
        sbM833U.append(", slotId=");
        sbM833U.append(this.slotId);
        sbM833U.append(", tierReached=");
        return C1643a.m819G(sbM833U, this.tierReached, ")");
    }
}
