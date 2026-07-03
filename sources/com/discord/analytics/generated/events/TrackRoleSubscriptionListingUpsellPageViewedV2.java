package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        if (!(other instanceof TrackRoleSubscriptionListingUpsellPageViewedV2)) {
            return false;
        }
        TrackRoleSubscriptionListingUpsellPageViewedV2 trackRoleSubscriptionListingUpsellPageViewedV2 = (TrackRoleSubscriptionListingUpsellPageViewedV2) other;
        return C12238m.areEqual(this.roleSubscriptionGroupListingId, trackRoleSubscriptionListingUpsellPageViewedV2.roleSubscriptionGroupListingId) && C12238m.areEqual(this.roleSubscriptionListingIds, trackRoleSubscriptionListingUpsellPageViewedV2.roleSubscriptionListingIds) && C12238m.areEqual(this.isPremiumMember, trackRoleSubscriptionListingUpsellPageViewedV2.isPremiumMember);
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
        StringBuilder sbM833U = C1643a.m833U("TrackRoleSubscriptionListingUpsellPageViewedV2(roleSubscriptionGroupListingId=");
        sbM833U.append(this.roleSubscriptionGroupListingId);
        sbM833U.append(", roleSubscriptionListingIds=");
        sbM833U.append(this.roleSubscriptionListingIds);
        sbM833U.append(", isPremiumMember=");
        return C1643a.m816D(sbM833U, this.isPremiumMember, ")");
    }
}
