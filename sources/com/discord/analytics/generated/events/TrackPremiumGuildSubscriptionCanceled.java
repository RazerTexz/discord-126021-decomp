package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackPremiumGuildSubscriptionCanceled.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPremiumGuildSubscriptionCanceled implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final Long premiumGuildSubscriptionId = null;
    private final CharSequence subscriptionCanceledReason = null;
    private final Long slotId = null;
    private final transient String analyticsSchemaTypeName = "premium_guild_subscription_canceled";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPremiumGuildSubscriptionCanceled)) {
            return false;
        }
        TrackPremiumGuildSubscriptionCanceled trackPremiumGuildSubscriptionCanceled = (TrackPremiumGuildSubscriptionCanceled) other;
        return m.areEqual(this.guildId, trackPremiumGuildSubscriptionCanceled.guildId) && m.areEqual(this.premiumGuildSubscriptionId, trackPremiumGuildSubscriptionCanceled.premiumGuildSubscriptionId) && m.areEqual(this.subscriptionCanceledReason, trackPremiumGuildSubscriptionCanceled.subscriptionCanceledReason) && m.areEqual(this.slotId, trackPremiumGuildSubscriptionCanceled.slotId);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.premiumGuildSubscriptionId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.subscriptionCanceledReason;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l3 = this.slotId;
        return iHashCode3 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackPremiumGuildSubscriptionCanceled(guildId=");
        sbU.append(this.guildId);
        sbU.append(", premiumGuildSubscriptionId=");
        sbU.append(this.premiumGuildSubscriptionId);
        sbU.append(", subscriptionCanceledReason=");
        sbU.append(this.subscriptionCanceledReason);
        sbU.append(", slotId=");
        return a.G(sbU, this.slotId, ")");
    }
}
