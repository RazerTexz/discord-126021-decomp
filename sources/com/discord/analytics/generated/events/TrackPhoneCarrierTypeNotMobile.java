package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackPhoneCarrierTypeNotMobile.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPhoneCarrierTypeNotMobile implements AnalyticsSchema, TrackBase2 {
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
        return Intrinsics3.areEqual(this.carrierName, trackPhoneCarrierTypeNotMobile.carrierName) && Intrinsics3.areEqual(this.carrierType, trackPhoneCarrierTypeNotMobile.carrierType);
    }

    public int hashCode() {
        CharSequence charSequence = this.carrierName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.carrierType;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackPhoneCarrierTypeNotMobile(carrierName=");
        sbU.append(this.carrierName);
        sbU.append(", carrierType=");
        return outline.E(sbU, this.carrierType, ")");
    }
}
