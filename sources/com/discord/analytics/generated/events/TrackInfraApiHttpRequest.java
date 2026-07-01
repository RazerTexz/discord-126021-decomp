package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackInfraApiHttpRequest.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackInfraApiHttpRequest implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long statusCode = null;
    private final Long count = null;
    private final transient String analyticsSchemaTypeName = "infra_api_http_request";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackInfraApiHttpRequest)) {
            return false;
        }
        TrackInfraApiHttpRequest trackInfraApiHttpRequest = (TrackInfraApiHttpRequest) other;
        return m.areEqual(this.statusCode, trackInfraApiHttpRequest.statusCode) && m.areEqual(this.count, trackInfraApiHttpRequest.count);
    }

    public int hashCode() {
        Long l = this.statusCode;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.count;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackInfraApiHttpRequest(statusCode=");
        sbU.append(this.statusCode);
        sbU.append(", count=");
        return a.G(sbU, this.count, ")");
    }
}
