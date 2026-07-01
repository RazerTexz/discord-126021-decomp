package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: TrackRoleSubscriptionListingUpsellPageViewedV2.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackRoleSubscriptionListingUpsellPageViewedV2 implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final Long roleSubscriptionGroupListingId = null;
    private final List<Long> roleSubscriptionListingIds = null;
    private final Boolean isPremiumMember = null;
    private final transient String analyticsSchemaTypeName = "role_subscription_listing_upsell_page_viewed_v2";

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
        if (!(other instanceof TrackRoleSubscriptionListingUpsellPageViewedV2)) {
            return false;
        }
        TrackRoleSubscriptionListingUpsellPageViewedV2 trackRoleSubscriptionListingUpsellPageViewedV2 = (TrackRoleSubscriptionListingUpsellPageViewedV2) other;
        return m.areEqual(this.roleSubscriptionGroupListingId, trackRoleSubscriptionListingUpsellPageViewedV2.roleSubscriptionGroupListingId) && m.areEqual(this.roleSubscriptionListingIds, trackRoleSubscriptionListingUpsellPageViewedV2.roleSubscriptionListingIds) && m.areEqual(this.isPremiumMember, trackRoleSubscriptionListingUpsellPageViewedV2.isPremiumMember);
    }

    public int hashCode() {
        Long l = this.roleSubscriptionGroupListingId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        List<Long> list = this.roleSubscriptionListingIds;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        Boolean bool = this.isPremiumMember;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackRoleSubscriptionListingUpsellPageViewedV2(roleSubscriptionGroupListingId=");
        sbU.append(this.roleSubscriptionGroupListingId);
        sbU.append(", roleSubscriptionListingIds=");
        sbU.append(this.roleSubscriptionListingIds);
        sbU.append(", isPremiumMember=");
        return a.D(sbU, this.isPremiumMember, ")");
    }
}
