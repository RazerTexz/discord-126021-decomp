package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackPaymentException.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPaymentException implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence errorMessage = null;
    private final Long requestStatus = null;
    private final transient String analyticsSchemaTypeName = "payment_exception";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPaymentException)) {
            return false;
        }
        TrackPaymentException trackPaymentException = (TrackPaymentException) other;
        return m.areEqual(this.errorMessage, trackPaymentException.errorMessage) && m.areEqual(this.requestStatus, trackPaymentException.requestStatus);
    }

    public int hashCode() {
        CharSequence charSequence = this.errorMessage;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.requestStatus;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackPaymentException(errorMessage=");
        sbU.append(this.errorMessage);
        sbU.append(", requestStatus=");
        return a.G(sbU, this.requestStatus, ")");
    }
}
