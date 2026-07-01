package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackUserPhoneVerificationRequestFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUserPhoneVerificationRequestFailed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence reason = null;
    private final transient String analyticsSchemaTypeName = "user_phone_verification_request_failed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackUserPhoneVerificationRequestFailed) && Intrinsics3.areEqual(this.reason, ((TrackUserPhoneVerificationRequestFailed) other).reason);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.reason;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.E(outline.U("TrackUserPhoneVerificationRequestFailed(reason="), this.reason, ")");
    }
}
