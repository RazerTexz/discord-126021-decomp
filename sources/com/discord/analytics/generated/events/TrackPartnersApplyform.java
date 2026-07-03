package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackMarketingSite;
import com.discord.analytics.generated.traits.TrackMarketingSiteReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackPartnersApplyform.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPartnersApplyform implements AnalyticsSchema, TrackBaseReceiver, TrackMarketingSiteReceiver {
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
        return C12238m.areEqual(this.linkclicked, trackPartnersApplyform.linkclicked) && C12238m.areEqual(this.googleanalytics, trackPartnersApplyform.googleanalytics);
    }

    public int hashCode() {
        CharSequence charSequence = this.linkclicked;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.googleanalytics;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackPartnersApplyform(linkclicked=");
        sbM833U.append(this.linkclicked);
        sbM833U.append(", googleanalytics=");
        return C1643a.m816D(sbM833U, this.googleanalytics, ")");
    }
}
