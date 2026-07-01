package com.discord.analytics.generated.events.activity_internal;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadataReceiver;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackActivityInternalPurchaseStepCompleted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackActivityInternalPurchaseStepCompleted implements AnalyticsSchema, TrackBaseReceiver, TrackActivityInternalMetadataReceiver {
    private TrackActivityInternalMetadata trackActivityInternalMetadata;
    private TrackBase trackBase;
    private final CharSequence step = null;
    private final CharSequence nextStep = null;
    private final CharSequence purchaseType = null;
    private final CharSequence purchaseName = null;
    private final Long skuId = null;
    private final Long activityDurationMs = null;
    private final Boolean success = null;
    private final transient String analyticsSchemaTypeName = "activity_internal_purchase_step_completed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackActivityInternalPurchaseStepCompleted)) {
            return false;
        }
        TrackActivityInternalPurchaseStepCompleted trackActivityInternalPurchaseStepCompleted = (TrackActivityInternalPurchaseStepCompleted) other;
        return m.areEqual(this.step, trackActivityInternalPurchaseStepCompleted.step) && m.areEqual(this.nextStep, trackActivityInternalPurchaseStepCompleted.nextStep) && m.areEqual(this.purchaseType, trackActivityInternalPurchaseStepCompleted.purchaseType) && m.areEqual(this.purchaseName, trackActivityInternalPurchaseStepCompleted.purchaseName) && m.areEqual(this.skuId, trackActivityInternalPurchaseStepCompleted.skuId) && m.areEqual(this.activityDurationMs, trackActivityInternalPurchaseStepCompleted.activityDurationMs) && m.areEqual(this.success, trackActivityInternalPurchaseStepCompleted.success);
    }

    public int hashCode() {
        CharSequence charSequence = this.step;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.nextStep;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.purchaseType;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.purchaseName;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l = this.skuId;
        int iHashCode5 = (iHashCode4 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.activityDurationMs;
        int iHashCode6 = (iHashCode5 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Boolean bool = this.success;
        return iHashCode6 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackActivityInternalPurchaseStepCompleted(step=");
        sbU.append(this.step);
        sbU.append(", nextStep=");
        sbU.append(this.nextStep);
        sbU.append(", purchaseType=");
        sbU.append(this.purchaseType);
        sbU.append(", purchaseName=");
        sbU.append(this.purchaseName);
        sbU.append(", skuId=");
        sbU.append(this.skuId);
        sbU.append(", activityDurationMs=");
        sbU.append(this.activityDurationMs);
        sbU.append(", success=");
        return a.D(sbU, this.success, ")");
    }
}
