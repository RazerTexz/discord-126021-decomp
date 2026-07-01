package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackMarketingSite;
import com.discord.analytics.generated.traits.TrackMarketingSite2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackViewLanding.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackViewLanding implements AnalyticsSchema, TrackBase2, TrackMarketingSite2 {
    private TrackBase trackBase;
    private TrackMarketingSite trackMarketingSite;
    private final CharSequence game = null;
    private final CharSequence locale = null;
    private final transient String analyticsSchemaTypeName = "view_landing";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackViewLanding)) {
            return false;
        }
        TrackViewLanding trackViewLanding = (TrackViewLanding) other;
        return Intrinsics3.areEqual(this.game, trackViewLanding.game) && Intrinsics3.areEqual(this.locale, trackViewLanding.locale);
    }

    public int hashCode() {
        CharSequence charSequence = this.game;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.locale;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackViewLanding(game=");
        sbU.append(this.game);
        sbU.append(", locale=");
        return outline.E(sbU, this.locale, ")");
    }
}
