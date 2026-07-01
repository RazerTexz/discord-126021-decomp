package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackPremiumGuildSubscriptionCtaClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPremiumGuildSubscriptionCtaClicked implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence source = null;
    private final Long guildId = null;
    private final transient String analyticsSchemaTypeName = "premium_guild_subscription_cta_clicked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPremiumGuildSubscriptionCtaClicked)) {
            return false;
        }
        TrackPremiumGuildSubscriptionCtaClicked trackPremiumGuildSubscriptionCtaClicked = (TrackPremiumGuildSubscriptionCtaClicked) other;
        return m.areEqual(this.source, trackPremiumGuildSubscriptionCtaClicked.source) && m.areEqual(this.guildId, trackPremiumGuildSubscriptionCtaClicked.guildId);
    }

    public int hashCode() {
        CharSequence charSequence = this.source;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.guildId;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackPremiumGuildSubscriptionCtaClicked(source=");
        sbU.append(this.source);
        sbU.append(", guildId=");
        return a.G(sbU, this.guildId, ")");
    }
}
