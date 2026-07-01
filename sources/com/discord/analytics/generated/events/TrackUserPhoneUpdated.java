package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackUserPhoneUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUserPhoneUpdated implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Boolean phoneNumberChanged = null;
    private final Boolean smsBackupEnabled = null;
    private final Boolean didRequireVerifiedPhone = null;
    private final transient String analyticsSchemaTypeName = "user_phone_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUserPhoneUpdated)) {
            return false;
        }
        TrackUserPhoneUpdated trackUserPhoneUpdated = (TrackUserPhoneUpdated) other;
        return Intrinsics3.areEqual(this.phoneNumberChanged, trackUserPhoneUpdated.phoneNumberChanged) && Intrinsics3.areEqual(this.smsBackupEnabled, trackUserPhoneUpdated.smsBackupEnabled) && Intrinsics3.areEqual(this.didRequireVerifiedPhone, trackUserPhoneUpdated.didRequireVerifiedPhone);
    }

    public int hashCode() {
        Boolean bool = this.phoneNumberChanged;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.smsBackupEnabled;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.didRequireVerifiedPhone;
        return iHashCode2 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackUserPhoneUpdated(phoneNumberChanged=");
        sbU.append(this.phoneNumberChanged);
        sbU.append(", smsBackupEnabled=");
        sbU.append(this.smsBackupEnabled);
        sbU.append(", didRequireVerifiedPhone=");
        return outline.D(sbU, this.didRequireVerifiedPhone, ")");
    }
}
