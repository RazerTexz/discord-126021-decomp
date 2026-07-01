package com.discord.analytics.generated.events;

import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannelReceiver;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

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
    public void c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public void e(TrackChannel trackChannel) {
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
        return m.areEqual(this.messageId, trackRoleSubscriptionPurchaseSystemMessageCtaClicked.messageId) && m.areEqual(this.stickerId, trackRoleSubscriptionPurchaseSystemMessageCtaClicked.stickerId) && m.areEqual(this.targetUser, trackRoleSubscriptionPurchaseSystemMessageCtaClicked.targetUser) && m.areEqual(this.sender, trackRoleSubscriptionPurchaseSystemMessageCtaClicked.sender);
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
        StringBuilder sbU = a.U("TrackRoleSubscriptionPurchaseSystemMessageCtaClicked(messageId=");
        sbU.append(this.messageId);
        sbU.append(", stickerId=");
        sbU.append(this.stickerId);
        sbU.append(", targetUser=");
        sbU.append(this.targetUser);
        sbU.append(", sender=");
        return a.G(sbU, this.sender, ")");
    }

    public TrackRoleSubscriptionPurchaseSystemMessageCtaClicked(Long l, CharSequence charSequence, Long l2, Long l3) {
        this.messageId = l;
        this.stickerId = charSequence;
        this.targetUser = l2;
        this.sender = l3;
        this.analyticsSchemaTypeName = "role_subscription_purchase_system_message_cta_clicked";
    }
}
