package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackPremiumMarketingPageViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPremiumMarketingPageViewed implements AnalyticsSchema, TrackBaseReceiver, TrackSourceMetadataReceiver {
    private TrackBase trackBase;
    private TrackSourceMetadata trackSourceMetadata;
    private final CharSequence loadId = null;
    private final transient String analyticsSchemaTypeName = "premium_marketing_page_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackPremiumMarketingPageViewed) && m.areEqual(this.loadId, ((TrackPremiumMarketingPageViewed) other).loadId);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.E(a.U("TrackPremiumMarketingPageViewed(loadId="), this.loadId, ")");
    }
}
