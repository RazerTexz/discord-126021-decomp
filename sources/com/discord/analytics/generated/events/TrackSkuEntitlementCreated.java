package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackEntitlementMetadata;
import com.discord.analytics.generated.traits.TrackEntitlementMetadataReceiver;
import com.discord.analytics.generated.traits.TrackPaymentMetadata;
import com.discord.analytics.generated.traits.TrackPaymentMetadataReceiver;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackSkuEntitlementCreated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSkuEntitlementCreated implements AnalyticsSchema, TrackBaseReceiver, TrackStoreSkuMetadataReceiver, TrackPaymentMetadataReceiver, TrackEntitlementMetadataReceiver {
    private TrackBase trackBase;
    private TrackEntitlementMetadata trackEntitlementMetadata;
    private TrackPaymentMetadata trackPaymentMetadata;
    private TrackStoreSkuMetadata trackStoreSkuMetadata;
    private final CharSequence entitlementType = null;
    private final Long startTimestamp = null;
    private final Long endTimestamp = null;
    private final CharSequence redemptionCode = null;
    private final transient String analyticsSchemaTypeName = "sku_entitlement_created";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSkuEntitlementCreated)) {
            return false;
        }
        TrackSkuEntitlementCreated trackSkuEntitlementCreated = (TrackSkuEntitlementCreated) other;
        return m.areEqual(this.entitlementType, trackSkuEntitlementCreated.entitlementType) && m.areEqual(this.startTimestamp, trackSkuEntitlementCreated.startTimestamp) && m.areEqual(this.endTimestamp, trackSkuEntitlementCreated.endTimestamp) && m.areEqual(this.redemptionCode, trackSkuEntitlementCreated.redemptionCode);
    }

    public int hashCode() {
        CharSequence charSequence = this.entitlementType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.startTimestamp;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.endTimestamp;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.redemptionCode;
        return iHashCode3 + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackSkuEntitlementCreated(entitlementType=");
        sbU.append(this.entitlementType);
        sbU.append(", startTimestamp=");
        sbU.append(this.startTimestamp);
        sbU.append(", endTimestamp=");
        sbU.append(this.endTimestamp);
        sbU.append(", redemptionCode=");
        return a.E(sbU, this.redemptionCode, ")");
    }
}
