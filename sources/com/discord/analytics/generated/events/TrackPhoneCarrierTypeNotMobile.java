package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackPhoneCarrierTypeNotMobile.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPhoneCarrierTypeNotMobile implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence carrierName = null;
    private final CharSequence carrierType = null;
    private final transient String analyticsSchemaTypeName = "phone_carrier_type_not_mobile";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPhoneCarrierTypeNotMobile)) {
            return false;
        }
        TrackPhoneCarrierTypeNotMobile trackPhoneCarrierTypeNotMobile = (TrackPhoneCarrierTypeNotMobile) other;
        return C12238m.areEqual(this.carrierName, trackPhoneCarrierTypeNotMobile.carrierName) && C12238m.areEqual(this.carrierType, trackPhoneCarrierTypeNotMobile.carrierType);
    }

    public int hashCode() {
        CharSequence charSequence = this.carrierName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.carrierType;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackPhoneCarrierTypeNotMobile(carrierName=");
        sbM833U.append(this.carrierName);
        sbM833U.append(", carrierType=");
        return C1643a.m817E(sbM833U, this.carrierType, ")");
    }
}
