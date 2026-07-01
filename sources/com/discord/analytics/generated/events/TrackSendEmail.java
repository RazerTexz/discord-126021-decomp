package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackSendEmail.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSendEmail implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence emailType = null;
    private final CharSequence trackingPixelUuid = null;
    private final transient String analyticsSchemaTypeName = "send_email";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSendEmail)) {
            return false;
        }
        TrackSendEmail trackSendEmail = (TrackSendEmail) other;
        return Intrinsics3.areEqual(this.emailType, trackSendEmail.emailType) && Intrinsics3.areEqual(this.trackingPixelUuid, trackSendEmail.trackingPixelUuid);
    }

    public int hashCode() {
        CharSequence charSequence = this.emailType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.trackingPixelUuid;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSendEmail(emailType=");
        sbU.append(this.emailType);
        sbU.append(", trackingPixelUuid=");
        return outline.E(sbU, this.trackingPixelUuid, ")");
    }
}
