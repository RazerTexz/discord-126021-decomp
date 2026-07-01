package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackUserTrialOfferCreated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUserTrialOfferCreated implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Long trialOfferId = null;
    private final Long trialId = null;
    private final Long expiresAt = null;
    private final transient String analyticsSchemaTypeName = "user_trial_offer_created";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUserTrialOfferCreated)) {
            return false;
        }
        TrackUserTrialOfferCreated trackUserTrialOfferCreated = (TrackUserTrialOfferCreated) other;
        return m.areEqual(this.trialOfferId, trackUserTrialOfferCreated.trialOfferId) && m.areEqual(this.trialId, trackUserTrialOfferCreated.trialId) && m.areEqual(this.expiresAt, trackUserTrialOfferCreated.expiresAt);
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
        StringBuilder sbU = a.U("TrackUserTrialOfferCreated(trialOfferId=");
        sbU.append(this.trialOfferId);
        sbU.append(", trialId=");
        sbU.append(this.trialId);
        sbU.append(", expiresAt=");
        return a.G(sbU, this.expiresAt, ")");
    }
}
