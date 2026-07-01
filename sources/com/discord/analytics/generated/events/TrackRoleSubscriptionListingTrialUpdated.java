package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackRoleSubscriptionListingTrialUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackRoleSubscriptionListingTrialUpdated implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final Long roleSubscriptionListingId = null;
    private final Long trialInterval = null;
    private final Long trialIntervalCount = null;
    private final Long activeTrialUserLimit = null;
    private final transient String analyticsSchemaTypeName = "role_subscription_listing_trial_updated";

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuildReceiver
    public void c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackRoleSubscriptionListingTrialUpdated)) {
            return false;
        }
        TrackRoleSubscriptionListingTrialUpdated trackRoleSubscriptionListingTrialUpdated = (TrackRoleSubscriptionListingTrialUpdated) other;
        return m.areEqual(this.roleSubscriptionListingId, trackRoleSubscriptionListingTrialUpdated.roleSubscriptionListingId) && m.areEqual(this.trialInterval, trackRoleSubscriptionListingTrialUpdated.trialInterval) && m.areEqual(this.trialIntervalCount, trackRoleSubscriptionListingTrialUpdated.trialIntervalCount) && m.areEqual(this.activeTrialUserLimit, trackRoleSubscriptionListingTrialUpdated.activeTrialUserLimit);
    }

    public int hashCode() {
        Long l = this.roleSubscriptionListingId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.trialInterval;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.trialIntervalCount;
        int iHashCode3 = (iHashCode2 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.activeTrialUserLimit;
        return iHashCode3 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackRoleSubscriptionListingTrialUpdated(roleSubscriptionListingId=");
        sbU.append(this.roleSubscriptionListingId);
        sbU.append(", trialInterval=");
        sbU.append(this.trialInterval);
        sbU.append(", trialIntervalCount=");
        sbU.append(this.trialIntervalCount);
        sbU.append(", activeTrialUserLimit=");
        return a.G(sbU, this.activeTrialUserLimit, ")");
    }
}
