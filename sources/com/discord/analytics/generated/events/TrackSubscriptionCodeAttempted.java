package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackSubscriptionCodeAttempted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSubscriptionCodeAttempted implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence code = null;
    private final Boolean isEligible = null;
    private final transient String analyticsSchemaTypeName = "subscription_code_attempted";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSubscriptionCodeAttempted)) {
            return false;
        }
        TrackSubscriptionCodeAttempted trackSubscriptionCodeAttempted = (TrackSubscriptionCodeAttempted) other;
        return m.areEqual(this.code, trackSubscriptionCodeAttempted.code) && m.areEqual(this.isEligible, trackSubscriptionCodeAttempted.isEligible);
    }

    public int hashCode() {
        CharSequence charSequence = this.code;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Boolean bool = this.isEligible;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackSubscriptionCodeAttempted(code=");
        sbU.append(this.code);
        sbU.append(", isEligible=");
        return a.D(sbU, this.isEligible, ")");
    }
}
