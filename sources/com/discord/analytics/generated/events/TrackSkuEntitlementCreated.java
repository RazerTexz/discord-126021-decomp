package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackEntitlementMetadata;
import com.discord.analytics.generated.traits.TrackEntitlementMetadata2;
import com.discord.analytics.generated.traits.TrackPaymentMetadata;
import com.discord.analytics.generated.traits.TrackPaymentMetadata2;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackSkuEntitlementCreated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSkuEntitlementCreated implements AnalyticsSchema, TrackBase2, TrackStoreSkuMetadata2, TrackPaymentMetadata2, TrackEntitlementMetadata2 {
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
        return Intrinsics3.areEqual(this.entitlementType, trackSkuEntitlementCreated.entitlementType) && Intrinsics3.areEqual(this.startTimestamp, trackSkuEntitlementCreated.startTimestamp) && Intrinsics3.areEqual(this.endTimestamp, trackSkuEntitlementCreated.endTimestamp) && Intrinsics3.areEqual(this.redemptionCode, trackSkuEntitlementCreated.redemptionCode);
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
        StringBuilder sbU = outline.U("TrackSkuEntitlementCreated(entitlementType=");
        sbU.append(this.entitlementType);
        sbU.append(", startTimestamp=");
        sbU.append(this.startTimestamp);
        sbU.append(", endTimestamp=");
        sbU.append(this.endTimestamp);
        sbU.append(", redemptionCode=");
        return outline.E(sbU, this.redemptionCode, ")");
    }
}
