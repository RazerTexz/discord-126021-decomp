package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.source, trackPremiumGuildSubscriptionCtaClicked.source) && C12238m.areEqual(this.guildId, trackPremiumGuildSubscriptionCtaClicked.guildId);
    }

    public int hashCode() {
        CharSequence charSequence = this.source;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.guildId;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackPremiumGuildSubscriptionCtaClicked(source=");
        sbM833U.append(this.source);
        sbM833U.append(", guildId=");
        return C1643a.m819G(sbM833U, this.guildId, ")");
    }
}
