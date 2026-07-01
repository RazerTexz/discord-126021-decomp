package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackEntitlementMetadata;
import com.discord.analytics.generated.traits.TrackEntitlementMetadata2;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackSkuEntitlementUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSkuEntitlementUpdated implements AnalyticsSchema, TrackBase2, TrackStoreSkuMetadata2, TrackEntitlementMetadata2 {
    private TrackBase trackBase;
    private TrackEntitlementMetadata trackEntitlementMetadata;
    private TrackStoreSkuMetadata trackStoreSkuMetadata;
    private final CharSequence entitlementType = null;
    private final CharSequence redemptionCode = null;
    private final transient String analyticsSchemaTypeName = "sku_entitlement_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSkuEntitlementUpdated)) {
            return false;
        }
        TrackSkuEntitlementUpdated trackSkuEntitlementUpdated = (TrackSkuEntitlementUpdated) other;
        return Intrinsics3.areEqual(this.entitlementType, trackSkuEntitlementUpdated.entitlementType) && Intrinsics3.areEqual(this.redemptionCode, trackSkuEntitlementUpdated.redemptionCode);
    }

    public int hashCode() {
        CharSequence charSequence = this.entitlementType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.redemptionCode;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackSkuEntitlementUpdated(entitlementType=");
        sbU.append(this.entitlementType);
        sbU.append(", redemptionCode=");
        return outline.E(sbU, this.redemptionCode, ")");
    }
}
