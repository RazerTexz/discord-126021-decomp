package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackEntitlementMetadata;
import com.discord.analytics.generated.traits.TrackEntitlementMetadataReceiver;
import com.discord.analytics.generated.traits.TrackPaymentMetadata;
import com.discord.analytics.generated.traits.TrackPaymentMetadataReceiver;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.entitlementType, trackSkuEntitlementCreated.entitlementType) && C12238m.areEqual(this.startTimestamp, trackSkuEntitlementCreated.startTimestamp) && C12238m.areEqual(this.endTimestamp, trackSkuEntitlementCreated.endTimestamp) && C12238m.areEqual(this.redemptionCode, trackSkuEntitlementCreated.redemptionCode);
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
        StringBuilder sbM833U = C1643a.m833U("TrackSkuEntitlementCreated(entitlementType=");
        sbM833U.append(this.entitlementType);
        sbM833U.append(", startTimestamp=");
        sbM833U.append(this.startTimestamp);
        sbM833U.append(", endTimestamp=");
        sbM833U.append(this.endTimestamp);
        sbM833U.append(", redemptionCode=");
        return C1643a.m817E(sbM833U, this.redemptionCode, ")");
    }
}
