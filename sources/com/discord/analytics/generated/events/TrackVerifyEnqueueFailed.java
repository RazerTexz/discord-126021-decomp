package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackVerifyEnqueueFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackVerifyEnqueueFailed implements AnalyticsSchema, TrackBase2 {
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
        return Intrinsics3.areEqual(this.phoneNumber, trackVerifyEnqueueFailed.phoneNumber) && Intrinsics3.areEqual(this.channel, trackVerifyEnqueueFailed.channel) && Intrinsics3.areEqual(this.reason, trackVerifyEnqueueFailed.reason);
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
        StringBuilder sbU = outline.U("TrackVerifyEnqueueFailed(phoneNumber=");
        sbU.append(this.phoneNumber);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", reason=");
        return outline.E(sbU, this.reason, ")");
    }
}
