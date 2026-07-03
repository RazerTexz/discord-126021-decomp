package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackUserTrialOfferAcknowledged.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUserTrialOfferAcknowledged implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long trialOfferId = null;
    private final Long trialId = null;
    private final Long expiresAt = null;
    private final transient String analyticsSchemaTypeName = "user_trial_offer_acknowledged";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUserTrialOfferAcknowledged)) {
            return false;
        }
        TrackUserTrialOfferAcknowledged trackUserTrialOfferAcknowledged = (TrackUserTrialOfferAcknowledged) other;
        return C12238m.areEqual(this.trialOfferId, trackUserTrialOfferAcknowledged.trialOfferId) && C12238m.areEqual(this.trialId, trackUserTrialOfferAcknowledged.trialId) && C12238m.areEqual(this.expiresAt, trackUserTrialOfferAcknowledged.expiresAt);
    }

    public int hashCode() {
        Long l = this.trialOfferId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.trialId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.expiresAt;
        return iHashCode2 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackUserTrialOfferAcknowledged(trialOfferId=");
        sbM833U.append(this.trialOfferId);
        sbM833U.append(", trialId=");
        sbM833U.append(this.trialId);
        sbM833U.append(", expiresAt=");
        return C1643a.m819G(sbM833U, this.expiresAt, ")");
    }
}
