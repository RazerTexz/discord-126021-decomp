package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackVerifyEnqueueFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVerifyEnqueueFailed implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence phoneNumber = null;
    private final CharSequence channel = null;
    private final CharSequence reason = null;
    private final transient String analyticsSchemaTypeName = "verify_enqueue_failed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackVerifyEnqueueFailed)) {
            return false;
        }
        TrackVerifyEnqueueFailed trackVerifyEnqueueFailed = (TrackVerifyEnqueueFailed) other;
        return C12238m.areEqual(this.phoneNumber, trackVerifyEnqueueFailed.phoneNumber) && C12238m.areEqual(this.channel, trackVerifyEnqueueFailed.channel) && C12238m.areEqual(this.reason, trackVerifyEnqueueFailed.reason);
    }

    public int hashCode() {
        CharSequence charSequence = this.phoneNumber;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.channel;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.reason;
        return iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackVerifyEnqueueFailed(phoneNumber=");
        sbM833U.append(this.phoneNumber);
        sbM833U.append(", channel=");
        sbM833U.append(this.channel);
        sbM833U.append(", reason=");
        return C1643a.m817E(sbM833U, this.reason, ")");
    }
}
