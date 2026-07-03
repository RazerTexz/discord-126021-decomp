package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackDataRequestInitiated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackDataRequestInitiated implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long harvestId = null;
    private final transient String analyticsSchemaTypeName = "data_request_initiated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackDataRequestInitiated) && C12238m.areEqual(this.harvestId, ((TrackDataRequestInitiated) other).harvestId);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.harvestId;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return C1643a.m819G(C1643a.m833U("TrackDataRequestInitiated(harvestId="), this.harvestId, ")");
    }
}
