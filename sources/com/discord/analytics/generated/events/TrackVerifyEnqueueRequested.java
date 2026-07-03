package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackVerifyEnqueueRequested.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVerifyEnqueueRequested implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence phoneNumber = null;
    private final CharSequence channel = null;
    private final transient String analyticsSchemaTypeName = "verify_enqueue_requested";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVerifyEnqueueRequested)) {
            return false;
        }
        TrackVerifyEnqueueRequested trackVerifyEnqueueRequested = (TrackVerifyEnqueueRequested) other;
        return C12238m.areEqual(this.phoneNumber, trackVerifyEnqueueRequested.phoneNumber) && C12238m.areEqual(this.channel, trackVerifyEnqueueRequested.channel);
    }

    public int hashCode() {
        CharSequence charSequence = this.phoneNumber;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.channel;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackVerifyEnqueueRequested(phoneNumber=");
        sbM833U.append(this.phoneNumber);
        sbM833U.append(", channel=");
        return C1643a.m817E(sbM833U, this.channel, ")");
    }
}
