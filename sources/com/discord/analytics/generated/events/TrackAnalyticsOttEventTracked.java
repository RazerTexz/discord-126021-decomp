package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackAnalyticsOttEventTracked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackAnalyticsOttEventTracked implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence kpi = null;
    private final CharSequence fpc = null;
    private final CharSequence pip = null;
    private final transient String analyticsSchemaTypeName = "analytics_ott_event_tracked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAnalyticsOttEventTracked)) {
            return false;
        }
        TrackAnalyticsOttEventTracked trackAnalyticsOttEventTracked = (TrackAnalyticsOttEventTracked) other;
        return C12238m.areEqual(this.kpi, trackAnalyticsOttEventTracked.kpi) && C12238m.areEqual(this.fpc, trackAnalyticsOttEventTracked.fpc) && C12238m.areEqual(this.pip, trackAnalyticsOttEventTracked.pip);
    }

    public int hashCode() {
        CharSequence charSequence = this.kpi;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.fpc;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.pip;
        return iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackAnalyticsOttEventTracked(kpi=");
        sbM833U.append(this.kpi);
        sbM833U.append(", fpc=");
        sbM833U.append(this.fpc);
        sbM833U.append(", pip=");
        return C1643a.m817E(sbM833U, this.pip, ")");
    }
}
