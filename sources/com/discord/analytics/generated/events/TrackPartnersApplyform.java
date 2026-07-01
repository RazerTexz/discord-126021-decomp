package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackMarketingSite;
import com.discord.analytics.generated.traits.TrackMarketingSite2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackPartnersApplyform.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPartnersApplyform implements AnalyticsSchema, TrackBase2, TrackMarketingSite2 {
    private TrackBase trackBase;
    private TrackMarketingSite trackMarketingSite;
    private final CharSequence linkclicked = null;
    private final Boolean googleanalytics = null;
    private final transient String analyticsSchemaTypeName = "partners_applyform";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPartnersApplyform)) {
            return false;
        }
        TrackPartnersApplyform trackPartnersApplyform = (TrackPartnersApplyform) other;
        return Intrinsics3.areEqual(this.linkclicked, trackPartnersApplyform.linkclicked) && Intrinsics3.areEqual(this.googleanalytics, trackPartnersApplyform.googleanalytics);
    }

    public int hashCode() {
        CharSequence charSequence = this.linkclicked;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.googleanalytics;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackPartnersApplyform(linkclicked=");
        sbU.append(this.linkclicked);
        sbU.append(", googleanalytics=");
        return outline.D(sbU, this.googleanalytics, ")");
    }
}
