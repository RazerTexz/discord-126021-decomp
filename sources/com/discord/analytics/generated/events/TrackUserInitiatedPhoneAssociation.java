package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackUserInitiatedPhoneAssociation.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUserInitiatedPhoneAssociation implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence phoneNumber = null;
    private final CharSequence carrierType = null;
    private final CharSequence carrierName = null;
    private final Long codeType = null;
    private final CharSequence phoneCountry = null;
    private final transient String analyticsSchemaTypeName = "user_initiated_phone_association";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUserInitiatedPhoneAssociation)) {
            return false;
        }
        TrackUserInitiatedPhoneAssociation trackUserInitiatedPhoneAssociation = (TrackUserInitiatedPhoneAssociation) other;
        return Intrinsics3.areEqual(this.phoneNumber, trackUserInitiatedPhoneAssociation.phoneNumber) && Intrinsics3.areEqual(this.carrierType, trackUserInitiatedPhoneAssociation.carrierType) && Intrinsics3.areEqual(this.carrierName, trackUserInitiatedPhoneAssociation.carrierName) && Intrinsics3.areEqual(this.codeType, trackUserInitiatedPhoneAssociation.codeType) && Intrinsics3.areEqual(this.phoneCountry, trackUserInitiatedPhoneAssociation.phoneCountry);
    }

    public int hashCode() {
        CharSequence charSequence = this.phoneNumber;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.carrierType;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.carrierName;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l = this.codeType;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.phoneCountry;
        return iHashCode4 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackUserInitiatedPhoneAssociation(phoneNumber=");
        sbU.append(this.phoneNumber);
        sbU.append(", carrierType=");
        sbU.append(this.carrierType);
        sbU.append(", carrierName=");
        sbU.append(this.carrierName);
        sbU.append(", codeType=");
        sbU.append(this.codeType);
        sbU.append(", phoneCountry=");
        return outline.E(sbU, this.phoneCountry, ")");
    }
}
