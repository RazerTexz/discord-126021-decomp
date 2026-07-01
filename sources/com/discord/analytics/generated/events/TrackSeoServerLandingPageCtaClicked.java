package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackSeoServerLandingPageCtaClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSeoServerLandingPageCtaClicked implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long guildId = null;
    private final CharSequence guildName = null;
    private final CharSequence slug = null;
    private final CharSequence cta = null;
    private final transient String analyticsSchemaTypeName = "seo_server_landing_page_cta_clicked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSeoServerLandingPageCtaClicked)) {
            return false;
        }
        TrackSeoServerLandingPageCtaClicked trackSeoServerLandingPageCtaClicked = (TrackSeoServerLandingPageCtaClicked) other;
        return Intrinsics3.areEqual(this.guildId, trackSeoServerLandingPageCtaClicked.guildId) && Intrinsics3.areEqual(this.guildName, trackSeoServerLandingPageCtaClicked.guildName) && Intrinsics3.areEqual(this.slug, trackSeoServerLandingPageCtaClicked.slug) && Intrinsics3.areEqual(this.cta, trackSeoServerLandingPageCtaClicked.cta);
    }

    public int hashCode() {
        Long l = this.guildId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.guildName;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.slug;
        int iHashCode3 = (iHashCode2 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.cta;
        return iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSeoServerLandingPageCtaClicked(guildId=");
        sbU.append(this.guildId);
        sbU.append(", guildName=");
        sbU.append(this.guildName);
        sbU.append(", slug=");
        sbU.append(this.slug);
        sbU.append(", cta=");
        return outline.E(sbU, this.cta, ")");
    }
}
