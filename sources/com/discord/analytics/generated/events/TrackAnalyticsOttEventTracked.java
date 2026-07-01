package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

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
        return m.areEqual(this.kpi, trackAnalyticsOttEventTracked.kpi) && m.areEqual(this.fpc, trackAnalyticsOttEventTracked.fpc) && m.areEqual(this.pip, trackAnalyticsOttEventTracked.pip);
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
        StringBuilder sbU = a.U("TrackAnalyticsOttEventTracked(kpi=");
        sbU.append(this.kpi);
        sbU.append(", fpc=");
        sbU.append(this.fpc);
        sbU.append(", pip=");
        return a.E(sbU, this.pip, ")");
    }
}
