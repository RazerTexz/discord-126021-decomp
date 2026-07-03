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
        return C12238m.areEqual(this.entitlementType, trackSkuEntitlementDeleted.entitlementType) && C12238m.areEqual(this.deletionType, trackSkuEntitlementDeleted.deletionType);
    }

    public int hashCode() {
        CharSequence charSequence = this.entitlementType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.deletionType;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackSkuEntitlementDeleted(entitlementType=");
        sbM833U.append(this.entitlementType);
        sbM833U.append(", deletionType=");
        return C1643a.m817E(sbM833U, this.deletionType, ")");
    }
}
