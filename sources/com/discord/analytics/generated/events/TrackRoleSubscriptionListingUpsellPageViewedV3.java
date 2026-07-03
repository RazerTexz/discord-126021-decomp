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

/* JADX INFO: compiled from: TrackRoleSubscriptionListingUpsellPageViewedV3.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackRoleSubscriptionListingUpsellPageViewedV3 implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
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

    /* JADX INFO: renamed from: e */
    public void m7511e(TrackBase trackBase) {
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
        return C12238m.areEqual(this.roleSubscriptionGroupListingId, trackRoleSubscriptionListingUpsellPageViewedV3.roleSubscriptionGroupListingId) && C12238m.areEqual(this.roleSubscriptionListingIds, trackRoleSubscriptionListingUpsellPageViewedV3.roleSubscriptionListingIds) && C12238m.areEqual(this.isPremiumMember, trackRoleSubscriptionListingUpsellPageViewedV3.isPremiumMember);
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
        StringBuilder sbM833U = C1643a.m833U("TrackRoleSubscriptionListingUpsellPageViewedV3(roleSubscriptionGroupListingId=");
        sbM833U.append(this.roleSubscriptionGroupListingId);
        sbM833U.append(", roleSubscriptionListingIds=");
        sbM833U.append(this.roleSubscriptionListingIds);
        sbM833U.append(", isPremiumMember=");
        return C1643a.m816D(sbM833U, this.isPremiumMember, ")");
    }

    public TrackRoleSubscriptionListingUpsellPageViewedV3(Long l, List<Long> list, Boolean bool) {
        this.roleSubscriptionGroupListingId = l;
        this.roleSubscriptionListingIds = list;
        this.isPremiumMember = bool;
        this.analyticsSchemaTypeName = "role_subscription_listing_upsell_page_viewed_v3";
    }
}
