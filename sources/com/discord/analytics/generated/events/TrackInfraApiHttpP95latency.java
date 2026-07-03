package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackInfraApiHttpP95latency.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackInfraApiHttpP95latency implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Float p95Latency = null;
    private final transient String analyticsSchemaTypeName = "infra_api_http_p95latency";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackInfraApiHttpP95latency) && C12238m.areEqual(this.p95Latency, ((TrackInfraApiHttpP95latency) other).p95Latency);
        }
        return true;
    }

    public int hashCode() {
        Float f = this.p95Latency;
        if (f != null) {
            return f.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackInfraApiHttpP95latency(p95Latency=");
        sbM833U.append(this.p95Latency);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
