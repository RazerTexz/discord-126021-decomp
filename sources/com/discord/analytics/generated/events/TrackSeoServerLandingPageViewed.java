package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackSeoServerLandingPageViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSeoServerLandingPageViewed implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final CharSequence guildName = null;
    private final CharSequence slug = null;
    private final transient String analyticsSchemaTypeName = "seo_server_landing_page_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSeoServerLandingPageViewed)) {
            return false;
        }
        TrackSeoServerLandingPageViewed trackSeoServerLandingPageViewed = (TrackSeoServerLandingPageViewed) other;
        return m.areEqual(this.guildId, trackSeoServerLandingPageViewed.guildId) && m.areEqual(this.guildName, trackSeoServerLandingPageViewed.guildName) && m.areEqual(this.slug, trackSeoServerLandingPageViewed.slug);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.guildName;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.slug;
        return iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackSeoServerLandingPageViewed(guildId=");
        sbU.append(this.guildId);
        sbU.append(", guildName=");
        sbU.append(this.guildName);
        sbU.append(", slug=");
        return a.E(sbU, this.slug, ")");
    }
}
