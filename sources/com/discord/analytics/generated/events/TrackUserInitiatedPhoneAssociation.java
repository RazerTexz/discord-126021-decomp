package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackUserInitiatedPhoneAssociation.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUserInitiatedPhoneAssociation implements AnalyticsSchema, TrackBaseReceiver {
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
        return C12238m.areEqual(this.phoneNumber, trackUserInitiatedPhoneAssociation.phoneNumber) && C12238m.areEqual(this.carrierType, trackUserInitiatedPhoneAssociation.carrierType) && C12238m.areEqual(this.carrierName, trackUserInitiatedPhoneAssociation.carrierName) && C12238m.areEqual(this.codeType, trackUserInitiatedPhoneAssociation.codeType) && C12238m.areEqual(this.phoneCountry, trackUserInitiatedPhoneAssociation.phoneCountry);
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
        StringBuilder sbM833U = C1643a.m833U("TrackUserInitiatedPhoneAssociation(phoneNumber=");
        sbM833U.append(this.phoneNumber);
        sbM833U.append(", carrierType=");
        sbM833U.append(this.carrierType);
        sbM833U.append(", carrierName=");
        sbM833U.append(this.carrierName);
        sbM833U.append(", codeType=");
        sbM833U.append(this.codeType);
        sbM833U.append(", phoneCountry=");
        return C1643a.m817E(sbM833U, this.phoneCountry, ")");
    }
}
