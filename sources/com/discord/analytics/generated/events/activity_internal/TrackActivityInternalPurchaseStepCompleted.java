package com.discord.analytics.generated.events.activity_internal;

import com.discord.analytics.generated.traits.TrackActivityInternalMetadata;
import com.discord.analytics.generated.traits.TrackActivityInternalMetadataReceiver;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.step, trackActivityInternalPurchaseStepCompleted.step) && C12238m.areEqual(this.nextStep, trackActivityInternalPurchaseStepCompleted.nextStep) && C12238m.areEqual(this.purchaseType, trackActivityInternalPurchaseStepCompleted.purchaseType) && C12238m.areEqual(this.purchaseName, trackActivityInternalPurchaseStepCompleted.purchaseName) && C12238m.areEqual(this.skuId, trackActivityInternalPurchaseStepCompleted.skuId) && C12238m.areEqual(this.activityDurationMs, trackActivityInternalPurchaseStepCompleted.activityDurationMs) && C12238m.areEqual(this.success, trackActivityInternalPurchaseStepCompleted.success);
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
        StringBuilder sbM833U = C1643a.m833U("TrackActivityInternalPurchaseStepCompleted(step=");
        sbM833U.append(this.step);
        sbM833U.append(", nextStep=");
        sbM833U.append(this.nextStep);
        sbM833U.append(", purchaseType=");
        sbM833U.append(this.purchaseType);
        sbM833U.append(", purchaseName=");
        sbM833U.append(this.purchaseName);
        sbM833U.append(", skuId=");
        sbM833U.append(this.skuId);
        sbM833U.append(", activityDurationMs=");
        sbM833U.append(this.activityDurationMs);
        sbM833U.append(", success=");
        return C1643a.m816D(sbM833U, this.success, ")");
    }
}
