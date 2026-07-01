package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackEntitlementMetadata;
import com.discord.analytics.generated.traits.TrackEntitlementMetadataReceiver;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackSkuEntitlementDeleted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSkuEntitlementDeleted implements AnalyticsSchema, TrackBaseReceiver, TrackStoreSkuMetadataReceiver, TrackEntitlementMetadataReceiver {
    private TrackBase trackBase;
    private TrackEntitlementMetadata trackEntitlementMetadata;
    private TrackStoreSkuMetadata trackStoreSkuMetadata;
    private final CharSequence entitlementType = null;
    private final CharSequence deletionType = null;
    private final transient String analyticsSchemaTypeName = "sku_entitlement_deleted";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSkuEntitlementDeleted)) {
            return false;
        }
        TrackSkuEntitlementDeleted trackSkuEntitlementDeleted = (TrackSkuEntitlementDeleted) other;
        return m.areEqual(this.entitlementType, trackSkuEntitlementDeleted.entitlementType) && m.areEqual(this.deletionType, trackSkuEntitlementDeleted.deletionType);
    }

    public int hashCode() {
        CharSequence charSequence = this.entitlementType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.deletionType;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackSkuEntitlementDeleted(entitlementType=");
        sbU.append(this.entitlementType);
        sbU.append(", deletionType=");
        return a.E(sbU, this.deletionType, ")");
    }
}
