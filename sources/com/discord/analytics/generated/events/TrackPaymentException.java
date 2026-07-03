package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.errorMessage, trackPaymentException.errorMessage) && C12238m.areEqual(this.requestStatus, trackPaymentException.requestStatus);
    }

    public int hashCode() {
        CharSequence charSequence = this.errorMessage;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.requestStatus;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackPaymentException(errorMessage=");
        sbM833U.append(this.errorMessage);
        sbM833U.append(", requestStatus=");
        return C1643a.m819G(sbM833U, this.requestStatus, ")");
    }
}
