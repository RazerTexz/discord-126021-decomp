package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackSeoServerLandingPageCtaClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSeoServerLandingPageCtaClicked implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.guildId, trackSeoServerLandingPageCtaClicked.guildId) && C12238m.areEqual(this.guildName, trackSeoServerLandingPageCtaClicked.guildName) && C12238m.areEqual(this.slug, trackSeoServerLandingPageCtaClicked.slug) && C12238m.areEqual(this.cta, trackSeoServerLandingPageCtaClicked.cta);
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
        StringBuilder sbM833U = C1643a.m833U("TrackSeoServerLandingPageCtaClicked(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", guildName=");
        sbM833U.append(this.guildName);
        sbM833U.append(", slug=");
        sbM833U.append(this.slug);
        sbM833U.append(", cta=");
        return C1643a.m817E(sbM833U, this.cta, ")");
    }
}
