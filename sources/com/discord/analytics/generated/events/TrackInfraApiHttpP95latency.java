package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackInfraApiHttpP95latency.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackInfraApiHttpP95latency implements AnalyticsSchema, TrackBase2 {
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
            return (other instanceof TrackInfraApiHttpP95latency) && Intrinsics3.areEqual(this.p95Latency, ((TrackInfraApiHttpP95latency) other).p95Latency);
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
        StringBuilder sbU = outline.U("TrackInfraApiHttpP95latency(p95Latency=");
        sbU.append(this.p95Latency);
        sbU.append(")");
        return sbU.toString();
    }
}
