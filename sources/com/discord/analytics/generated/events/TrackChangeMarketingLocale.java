package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackMarketingSite;
import com.discord.analytics.generated.traits.TrackMarketingSiteReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackChangeMarketingLocale.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackChangeMarketingLocale implements AnalyticsSchema, TrackBaseReceiver, TrackMarketingSiteReceiver {
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
        return C12238m.areEqual(this.from, trackChangeMarketingLocale.from) && C12238m.areEqual(this.to, trackChangeMarketingLocale.to);
    }

    public int hashCode() {
        CharSequence charSequence = this.from;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.to;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackChangeMarketingLocale(from=");
        sbM833U.append(this.from);
        sbM833U.append(", to=");
        return C1643a.m817E(sbM833U, this.to, ")");
    }
}
