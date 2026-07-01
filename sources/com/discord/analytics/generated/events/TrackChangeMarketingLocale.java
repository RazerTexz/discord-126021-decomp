package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackMarketingSite;
import com.discord.analytics.generated.traits.TrackMarketingSite2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackChangeMarketingLocale.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackChangeMarketingLocale implements AnalyticsSchema, TrackBase2, TrackMarketingSite2 {
    private TrackBase trackBase;
    private TrackMarketingSite trackMarketingSite;
    private final CharSequence from = null;
    private final CharSequence to = null;
    private final transient String analyticsSchemaTypeName = "change_marketing_locale";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackChangeMarketingLocale)) {
            return false;
        }
        TrackChangeMarketingLocale trackChangeMarketingLocale = (TrackChangeMarketingLocale) other;
        return Intrinsics3.areEqual(this.from, trackChangeMarketingLocale.from) && Intrinsics3.areEqual(this.to, trackChangeMarketingLocale.to);
    }

    public int hashCode() {
        CharSequence charSequence = this.from;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.to;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackChangeMarketingLocale(from=");
        sbU.append(this.from);
        sbU.append(", to=");
        return outline.E(sbU, this.to, ")");
    }
}
