package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackEntitlementMetadata;
import com.discord.analytics.generated.traits.TrackEntitlementMetadataReceiver;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackSkuEntitlementUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSkuEntitlementUpdated implements AnalyticsSchema, TrackBaseReceiver, TrackStoreSkuMetadataReceiver, TrackEntitlementMetadataReceiver {
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
        return C12238m.areEqual(this.entitlementType, trackSkuEntitlementUpdated.entitlementType) && C12238m.areEqual(this.redemptionCode, trackSkuEntitlementUpdated.redemptionCode);
    }

    public int hashCode() {
        CharSequence charSequence = this.entitlementType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.redemptionCode;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackSkuEntitlementUpdated(entitlementType=");
        sbM833U.append(this.entitlementType);
        sbM833U.append(", redemptionCode=");
        return C1643a.m817E(sbM833U, this.redemptionCode, ")");
    }
}
