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

/* JADX INFO: compiled from: TrackRoleSubscriptionPurchaseSystemMessageClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackRoleSubscriptionPurchaseSystemMessageClicked implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private final transient String analyticsSchemaTypeName;
    private final Long messageId;
    private final Long roleSubscriptionListingId;
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;

    public TrackRoleSubscriptionPurchaseSystemMessageClicked() {
        this.messageId = null;
        this.roleSubscriptionListingId = null;
        this.analyticsSchemaTypeName = "role_subscription_purchase_system_message_clicked";
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
        if (!(other instanceof TrackRoleSubscriptionPurchaseSystemMessageClicked)) {
            return false;
        }
        TrackRoleSubscriptionPurchaseSystemMessageClicked trackRoleSubscriptionPurchaseSystemMessageClicked = (TrackRoleSubscriptionPurchaseSystemMessageClicked) other;
        return Intrinsics3.areEqual(this.messageId, trackRoleSubscriptionPurchaseSystemMessageClicked.messageId) && Intrinsics3.areEqual(this.roleSubscriptionListingId, trackRoleSubscriptionPurchaseSystemMessageClicked.roleSubscriptionListingId);
    }

    public void f(TrackChannel trackChannel) {
        this.trackChannel = trackChannel;
    }

    public int hashCode() {
        Long l = this.messageId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.roleSubscriptionListingId;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackRoleSubscriptionPurchaseSystemMessageClicked(messageId=");
        sbU.append(this.messageId);
        sbU.append(", roleSubscriptionListingId=");
        return outline.G(sbU, this.roleSubscriptionListingId, ")");
    }

    public TrackRoleSubscriptionPurchaseSystemMessageClicked(Long l, Long l2) {
        this.messageId = l;
        this.roleSubscriptionListingId = l2;
        this.analyticsSchemaTypeName = "role_subscription_purchase_system_message_clicked";
    }
}
