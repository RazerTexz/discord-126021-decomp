package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: TrackRoleSubscriptionListingUpsellPageViewedV3.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackRoleSubscriptionListingUpsellPageViewedV3 implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private final transient String analyticsSchemaTypeName;
    private final Boolean isPremiumMember;
    private final Long roleSubscriptionGroupListingId;
    private final List<Long> roleSubscriptionListingIds;
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;

    public TrackRoleSubscriptionListingUpsellPageViewedV3() {
        this.roleSubscriptionGroupListingId = null;
        this.roleSubscriptionListingIds = null;
        this.isPremiumMember = null;
        this.analyticsSchemaTypeName = "role_subscription_listing_upsell_page_viewed_v3";
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* JADX INFO: renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    public void c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public void e(TrackBase trackBase) {
        this.trackBase = trackBase;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackRoleSubscriptionListingUpsellPageViewedV3)) {
            return false;
        }
        TrackRoleSubscriptionListingUpsellPageViewedV3 trackRoleSubscriptionListingUpsellPageViewedV3 = (TrackRoleSubscriptionListingUpsellPageViewedV3) other;
        return Intrinsics3.areEqual(this.roleSubscriptionGroupListingId, trackRoleSubscriptionListingUpsellPageViewedV3.roleSubscriptionGroupListingId) && Intrinsics3.areEqual(this.roleSubscriptionListingIds, trackRoleSubscriptionListingUpsellPageViewedV3.roleSubscriptionListingIds) && Intrinsics3.areEqual(this.isPremiumMember, trackRoleSubscriptionListingUpsellPageViewedV3.isPremiumMember);
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
        StringBuilder sbU = outline.U("TrackRoleSubscriptionListingUpsellPageViewedV3(roleSubscriptionGroupListingId=");
        sbU.append(this.roleSubscriptionGroupListingId);
        sbU.append(", roleSubscriptionListingIds=");
        sbU.append(this.roleSubscriptionListingIds);
        sbU.append(", isPremiumMember=");
        return outline.D(sbU, this.isPremiumMember, ")");
    }

    public TrackRoleSubscriptionListingUpsellPageViewedV3(Long l, List<Long> list, Boolean bool) {
        this.roleSubscriptionGroupListingId = l;
        this.roleSubscriptionListingIds = list;
        this.isPremiumMember = bool;
        this.analyticsSchemaTypeName = "role_subscription_listing_upsell_page_viewed_v3";
    }
}
