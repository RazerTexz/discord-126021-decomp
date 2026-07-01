package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackPaymentSourceRemoved.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPaymentSourceRemoved implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long paymentSourceId = null;
    private final transient String analyticsSchemaTypeName = "payment_source_removed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackPaymentSourceRemoved) && Intrinsics3.areEqual(this.paymentSourceId, ((TrackPaymentSourceRemoved) other).paymentSourceId);
        }
        return true;
    }

    public int hashCode() {
        Long l = this.paymentSourceId;
        if (l != null) {
            return l.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.G(outline.U("TrackPaymentSourceRemoved(paymentSourceId="), this.paymentSourceId, ")");
    }
}
