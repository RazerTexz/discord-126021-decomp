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

/* JADX INFO: compiled from: TrackPaymentFlowCompleted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackPaymentFlowCompleted implements AnalyticsSchema, TrackBaseReceiver, TrackLocationMetadataReceiver, TrackStoreSkuMetadataReceiver, TrackSubscriptionMetadataReceiver, TrackPaymentMetadataReceiver, TrackSourceMetadataReceiver {
    private TrackBase trackBase;
    private TrackLocationMetadata trackLocationMetadata;
    private TrackPaymentMetadata trackPaymentMetadata;
    private TrackSourceMetadata trackSourceMetadata;
    private TrackStoreSkuMetadata trackStoreSkuMetadata;
    private TrackSubscriptionMetadata trackSubscriptionMetadata;
    private final CharSequence loadId = null;
    private final Long durationMs = null;
    private final Long trialPeriodLengthDays = null;
    private final Boolean eligibleForTrial = null;
    private final Long guildId = null;
    private final transient String analyticsSchemaTypeName = "payment_flow_completed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackPaymentFlowCompleted)) {
            return false;
        }
        TrackPaymentFlowCompleted trackPaymentFlowCompleted = (TrackPaymentFlowCompleted) other;
        return C12238m.areEqual(this.loadId, trackPaymentFlowCompleted.loadId) && C12238m.areEqual(this.durationMs, trackPaymentFlowCompleted.durationMs) && C12238m.areEqual(this.trialPeriodLengthDays, trackPaymentFlowCompleted.trialPeriodLengthDays) && C12238m.areEqual(this.eligibleForTrial, trackPaymentFlowCompleted.eligibleForTrial) && C12238m.areEqual(this.guildId, trackPaymentFlowCompleted.guildId);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.durationMs;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.trialPeriodLengthDays;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Boolean bool = this.eligibleForTrial;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l3 = this.guildId;
        return iHashCode4 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackPaymentFlowCompleted(loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", durationMs=");
        sbM833U.append(this.durationMs);
        sbM833U.append(", trialPeriodLengthDays=");
        sbM833U.append(this.trialPeriodLengthDays);
        sbM833U.append(", eligibleForTrial=");
        sbM833U.append(this.eligibleForTrial);
        sbM833U.append(", guildId=");
        return C1643a.m819G(sbM833U, this.guildId, ")");
    }
}
