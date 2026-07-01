package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackSmsEnqueueFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSmsEnqueueFailed implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence phoneNumber = null;
    private final CharSequence reason = null;
    private final CharSequence phoneCountry = null;
    private final CharSequence carrierName = null;
    private final CharSequence carrierType = null;
    private final CharSequence source = null;
    private final transient String analyticsSchemaTypeName = "sms_enqueue_failed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSmsEnqueueFailed)) {
            return false;
        }
        TrackSmsEnqueueFailed trackSmsEnqueueFailed = (TrackSmsEnqueueFailed) other;
        return Intrinsics3.areEqual(this.phoneNumber, trackSmsEnqueueFailed.phoneNumber) && Intrinsics3.areEqual(this.reason, trackSmsEnqueueFailed.reason) && Intrinsics3.areEqual(this.phoneCountry, trackSmsEnqueueFailed.phoneCountry) && Intrinsics3.areEqual(this.carrierName, trackSmsEnqueueFailed.carrierName) && Intrinsics3.areEqual(this.carrierType, trackSmsEnqueueFailed.carrierType) && Intrinsics3.areEqual(this.source, trackSmsEnqueueFailed.source);
    }

    public int hashCode() {
        CharSequence charSequence = this.phoneNumber;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.reason;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.phoneCountry;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.carrierName;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.carrierType;
        int iHashCode5 = (iHashCode4 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.source;
        return iHashCode5 + (charSequence6 != null ? charSequence6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSmsEnqueueFailed(phoneNumber=");
        sbU.append(this.phoneNumber);
        sbU.append(", reason=");
        sbU.append(this.reason);
        sbU.append(", phoneCountry=");
        sbU.append(this.phoneCountry);
        sbU.append(", carrierName=");
        sbU.append(this.carrierName);
        sbU.append(", carrierType=");
        sbU.append(this.carrierType);
        sbU.append(", source=");
        return outline.E(sbU, this.source, ")");
    }
}
