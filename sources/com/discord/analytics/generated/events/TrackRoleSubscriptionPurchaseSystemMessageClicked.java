package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackRoleSubscriptionPurchaseSystemMessageClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackRoleSubscriptionPurchaseSystemMessageClicked implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
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
    public void m7512e(TrackBase trackBase) {
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
        return C12238m.areEqual(this.messageId, trackRoleSubscriptionPurchaseSystemMessageClicked.messageId) && C12238m.areEqual(this.roleSubscriptionListingId, trackRoleSubscriptionPurchaseSystemMessageClicked.roleSubscriptionListingId);
    }

    /* JADX INFO: renamed from: f */
    public void m7513f(TrackChannel trackChannel) {
        this.trackChannel = trackChannel;
    }

    public int hashCode() {
        Long l = this.messageId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.roleSubscriptionListingId;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackRoleSubscriptionPurchaseSystemMessageClicked(messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", roleSubscriptionListingId=");
        return C1643a.m819G(sbM833U, this.roleSubscriptionListingId, ")");
    }

    public TrackRoleSubscriptionPurchaseSystemMessageClicked(Long l, Long l2) {
        this.messageId = l;
        this.roleSubscriptionListingId = l2;
        this.analyticsSchemaTypeName = "role_subscription_purchase_system_message_clicked";
    }
}
