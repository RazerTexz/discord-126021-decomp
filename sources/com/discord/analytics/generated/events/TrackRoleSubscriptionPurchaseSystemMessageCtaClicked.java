package com.discord.analytics.generated.events;

import androidx.core.app.NotificationCompat;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackRoleSubscriptionPurchaseSystemMessageCtaClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackRoleSubscriptionPurchaseSystemMessageCtaClicked implements AnalyticsSchema, TrackBaseReceiver, TrackGuildReceiver, TrackChannelReceiver {
    private final transient String analyticsSchemaTypeName;
    private final Long messageId;
    private final Long sender;
    private final CharSequence stickerId;
    private final Long targetUser;
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;

    public TrackRoleSubscriptionPurchaseSystemMessageCtaClicked() {
        this.messageId = null;
        this.stickerId = null;
        this.targetUser = null;
        this.sender = null;
        this.analyticsSchemaTypeName = "role_subscription_purchase_system_message_cta_clicked";
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
    public void m7514e(TrackChannel trackChannel) {
        this.trackChannel = trackChannel;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackRoleSubscriptionPurchaseSystemMessageCtaClicked)) {
            return false;
        }
        TrackRoleSubscriptionPurchaseSystemMessageCtaClicked trackRoleSubscriptionPurchaseSystemMessageCtaClicked = (TrackRoleSubscriptionPurchaseSystemMessageCtaClicked) other;
        return C12238m.areEqual(this.messageId, trackRoleSubscriptionPurchaseSystemMessageCtaClicked.messageId) && C12238m.areEqual(this.stickerId, trackRoleSubscriptionPurchaseSystemMessageCtaClicked.stickerId) && C12238m.areEqual(this.targetUser, trackRoleSubscriptionPurchaseSystemMessageCtaClicked.targetUser) && C12238m.areEqual(this.sender, trackRoleSubscriptionPurchaseSystemMessageCtaClicked.sender);
    }

    public int hashCode() {
        Long l = this.messageId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.stickerId;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.targetUser;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.sender;
        return iHashCode3 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TrackRoleSubscriptionPurchaseSystemMessageCtaClicked(messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", stickerId=");
        sbM833U.append(this.stickerId);
        sbM833U.append(", targetUser=");
        sbM833U.append(this.targetUser);
        sbM833U.append(", sender=");
        return C1643a.m819G(sbM833U, this.sender, ")");
    }

    public TrackRoleSubscriptionPurchaseSystemMessageCtaClicked(Long l, CharSequence charSequence, Long l2, Long l3) {
        this.messageId = l;
        this.stickerId = charSequence;
        this.targetUser = l2;
        this.sender = l3;
        this.analyticsSchemaTypeName = "role_subscription_purchase_system_message_cta_clicked";
    }
}
