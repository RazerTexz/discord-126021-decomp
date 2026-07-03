package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackUserPhoneUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUserPhoneUpdated implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.phoneNumberChanged, trackUserPhoneUpdated.phoneNumberChanged) && C12238m.areEqual(this.smsBackupEnabled, trackUserPhoneUpdated.smsBackupEnabled) && C12238m.areEqual(this.didRequireVerifiedPhone, trackUserPhoneUpdated.didRequireVerifiedPhone);
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
        StringBuilder sbM833U = C1643a.m833U("TrackUserPhoneUpdated(phoneNumberChanged=");
        sbM833U.append(this.phoneNumberChanged);
        sbM833U.append(", smsBackupEnabled=");
        sbM833U.append(this.smsBackupEnabled);
        sbM833U.append(", didRequireVerifiedPhone=");
        return C1643a.m816D(sbM833U, this.didRequireVerifiedPhone, ")");
    }
}
