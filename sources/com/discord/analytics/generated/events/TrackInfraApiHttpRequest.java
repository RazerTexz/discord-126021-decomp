package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.statusCode, trackInfraApiHttpRequest.statusCode) && C12238m.areEqual(this.count, trackInfraApiHttpRequest.count);
    }

    public int hashCode() {
        Long l = this.statusCode;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.count;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackInfraApiHttpRequest(statusCode=");
        sbM833U.append(this.statusCode);
        sbM833U.append(", count=");
        return C1643a.m819G(sbM833U, this.count, ")");
    }
}
