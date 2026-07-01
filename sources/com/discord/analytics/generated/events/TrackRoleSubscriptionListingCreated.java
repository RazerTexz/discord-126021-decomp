package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: TrackRoleSubscriptionListingCreated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackRoleSubscriptionListingCreated implements AnalyticsSchema, TrackBase2, TrackGuild2 {
    private TrackBase trackBase;
    private TrackGuild trackGuild;
    private final Long roleSubscriptionListingId = null;
    private final CharSequence name = null;
    private final Long roleSubscriptionGroupListingId = null;
    private final Boolean published = null;
    private final List<Long> channelBenefitIds = null;
    private final Long roleId = null;
    private final List<CharSequence> intangibleBenefitNames = null;
    private final Long priceTier = null;
    private final transient String analyticsSchemaTypeName = "role_subscription_listing_created";

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

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackRoleSubscriptionListingCreated)) {
            return false;
        }
        TrackRoleSubscriptionListingCreated trackRoleSubscriptionListingCreated = (TrackRoleSubscriptionListingCreated) other;
        return Intrinsics3.areEqual(this.roleSubscriptionListingId, trackRoleSubscriptionListingCreated.roleSubscriptionListingId) && Intrinsics3.areEqual(this.name, trackRoleSubscriptionListingCreated.name) && Intrinsics3.areEqual(this.roleSubscriptionGroupListingId, trackRoleSubscriptionListingCreated.roleSubscriptionGroupListingId) && Intrinsics3.areEqual(this.published, trackRoleSubscriptionListingCreated.published) && Intrinsics3.areEqual(this.channelBenefitIds, trackRoleSubscriptionListingCreated.channelBenefitIds) && Intrinsics3.areEqual(this.roleId, trackRoleSubscriptionListingCreated.roleId) && Intrinsics3.areEqual(this.intangibleBenefitNames, trackRoleSubscriptionListingCreated.intangibleBenefitNames) && Intrinsics3.areEqual(this.priceTier, trackRoleSubscriptionListingCreated.priceTier);
    }

    public int hashCode() {
        Long l = this.roleSubscriptionListingId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.name;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.roleSubscriptionGroupListingId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Boolean bool = this.published;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        List<Long> list = this.channelBenefitIds;
        int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        Long l3 = this.roleId;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        List<CharSequence> list2 = this.intangibleBenefitNames;
        int iHashCode7 = (iHashCode6 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Long l4 = this.priceTier;
        return iHashCode7 + (l4 != null ? l4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackRoleSubscriptionListingCreated(roleSubscriptionListingId=");
        sbU.append(this.roleSubscriptionListingId);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", roleSubscriptionGroupListingId=");
        sbU.append(this.roleSubscriptionGroupListingId);
        sbU.append(", published=");
        sbU.append(this.published);
        sbU.append(", channelBenefitIds=");
        sbU.append(this.channelBenefitIds);
        sbU.append(", roleId=");
        sbU.append(this.roleId);
        sbU.append(", intangibleBenefitNames=");
        sbU.append(this.intangibleBenefitNames);
        sbU.append(", priceTier=");
        return outline.G(sbU, this.priceTier, ")");
    }
}
