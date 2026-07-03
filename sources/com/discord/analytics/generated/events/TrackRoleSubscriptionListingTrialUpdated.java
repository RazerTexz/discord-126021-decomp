package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
    /* JADX INFO: renamed from: c */
    public void mo7508c(TrackGuild trackGuild) {
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
        return C12238m.areEqual(this.roleSubscriptionListingId, trackRoleSubscriptionListingTrialUpdated.roleSubscriptionListingId) && C12238m.areEqual(this.trialInterval, trackRoleSubscriptionListingTrialUpdated.trialInterval) && C12238m.areEqual(this.trialIntervalCount, trackRoleSubscriptionListingTrialUpdated.trialIntervalCount) && C12238m.areEqual(this.activeTrialUserLimit, trackRoleSubscriptionListingTrialUpdated.activeTrialUserLimit);
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
        StringBuilder sbM833U = C1643a.m833U("TrackRoleSubscriptionListingTrialUpdated(roleSubscriptionListingId=");
        sbM833U.append(this.roleSubscriptionListingId);
        sbM833U.append(", trialInterval=");
        sbM833U.append(this.trialInterval);
        sbM833U.append(", trialIntervalCount=");
        sbM833U.append(this.trialIntervalCount);
        sbM833U.append(", activeTrialUserLimit=");
        return C1643a.m819G(sbM833U, this.activeTrialUserLimit, ")");
    }
}
