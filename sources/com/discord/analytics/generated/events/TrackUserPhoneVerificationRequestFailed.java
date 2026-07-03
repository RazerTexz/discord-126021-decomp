package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackUserPhoneVerificationRequestFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUserPhoneVerificationRequestFailed implements AnalyticsSchema, TrackBaseReceiver {
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
            return (other instanceof TrackUserPhoneVerificationRequestFailed) && C12238m.areEqual(this.reason, ((TrackUserPhoneVerificationRequestFailed) other).reason);
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
        return C1643a.m817E(C1643a.m833U("TrackUserPhoneVerificationRequestFailed(reason="), this.reason, ")");
    }
}
