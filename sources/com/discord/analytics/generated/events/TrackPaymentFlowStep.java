package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackLocationMetadata;
import com.discord.analytics.generated.traits.TrackLocationMetadataReceiver;
import com.discord.analytics.generated.traits.TrackPaymentMetadata;
import com.discord.analytics.generated.traits.TrackPaymentMetadataReceiver;
import com.discord.analytics.generated.traits.TrackSourceMetadata;
import com.discord.analytics.generated.traits.TrackSourceMetadataReceiver;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadata;
import com.discord.analytics.generated.traits.TrackStoreSkuMetadataReceiver;
import com.discord.analytics.generated.traits.TrackSubscriptionMetadata;
import com.discord.analytics.generated.traits.TrackSubscriptionMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackPaymentFlowStep.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPaymentFlowStep implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver, TrackStoreSkuMetadataReceiver, TrackSubscriptionMetadataReceiver, TrackPaymentMetadataReceiver, TrackSourceMetadataReceiver {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackPaymentMetadata trackPaymentMetadata;
    private TrackSourceMetadata trackSourceMetadata;
    private TrackStoreSkuMetadata trackStoreSkuMetadata;
    private TrackSubscriptionMetadata trackSubscriptionMetadata;
    private final CharSequence toStep = null;
    private final CharSequence fromStep = null;
    private final CharSequence loadId = null;
    private final Long stepDurationMs = null;
    private final Long flowDurationMs = null;
    private final Boolean eligibleForTrial = null;
    private final Long guildId = null;
    private final transient String analyticsSchemaTypeName = "payment_flow_step";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPaymentFlowStep)) {
            return false;
        }
        TrackPaymentFlowStep trackPaymentFlowStep = (TrackPaymentFlowStep) other;
        return C12238m.areEqual(this.toStep, trackPaymentFlowStep.toStep) && C12238m.areEqual(this.fromStep, trackPaymentFlowStep.fromStep) && C12238m.areEqual(this.loadId, trackPaymentFlowStep.loadId) && C12238m.areEqual(this.stepDurationMs, trackPaymentFlowStep.stepDurationMs) && C12238m.areEqual(this.flowDurationMs, trackPaymentFlowStep.flowDurationMs) && C12238m.areEqual(this.eligibleForTrial, trackPaymentFlowStep.eligibleForTrial) && C12238m.areEqual(this.guildId, trackPaymentFlowStep.guildId);
    }

    public int hashCode() {
        CharSequence charSequence = this.toStep;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.fromStep;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.loadId;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l = this.stepDurationMs;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.flowDurationMs;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Boolean bool = this.eligibleForTrial;
        int iHashCode6 = (iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        return iHashCode6 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackPaymentFlowStep(toStep=");
        sbM833U.append(this.toStep);
        sbM833U.append(", fromStep=");
        sbM833U.append(this.fromStep);
        sbM833U.append(", loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", stepDurationMs=");
        sbM833U.append(this.stepDurationMs);
        sbM833U.append(", flowDurationMs=");
        sbM833U.append(this.flowDurationMs);
        sbM833U.append(", eligibleForTrial=");
        sbM833U.append(this.eligibleForTrial);
        sbM833U.append(", guildId=");
        return C1643a.m819G(sbM833U, this.guildId, ")");
    }
}
