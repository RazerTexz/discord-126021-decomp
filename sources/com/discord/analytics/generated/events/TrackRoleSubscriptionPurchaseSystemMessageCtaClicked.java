package com.discord.analytics.generated.events;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackRoleSubscriptionPurchaseSystemMessageCtaClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackRoleSubscriptionPurchaseSystemMessageCtaClicked implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
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
        return Intrinsics3.areEqual(this.messageId, trackRoleSubscriptionPurchaseSystemMessageCtaClicked.messageId) && Intrinsics3.areEqual(this.stickerId, trackRoleSubscriptionPurchaseSystemMessageCtaClicked.stickerId) && Intrinsics3.areEqual(this.targetUser, trackRoleSubscriptionPurchaseSystemMessageCtaClicked.targetUser) && Intrinsics3.areEqual(this.sender, trackRoleSubscriptionPurchaseSystemMessageCtaClicked.sender);
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
        StringBuilder sbU = outline.U("TrackRoleSubscriptionPurchaseSystemMessageCtaClicked(messageId=");
        sbU.append(this.messageId);
        sbU.append(", stickerId=");
        sbU.append(this.stickerId);
        sbU.append(", targetUser=");
        sbU.append(this.targetUser);
        sbU.append(", sender=");
        return outline.G(sbU, this.sender, ")");
    }

    public TrackRoleSubscriptionPurchaseSystemMessageCtaClicked(Long l, CharSequence charSequence, Long l2, Long l3) {
        this.messageId = l;
        this.stickerId = charSequence;
        this.targetUser = l2;
        this.sender = l3;
        this.analyticsSchemaTypeName = "role_subscription_purchase_system_message_cta_clicked";
    }
}
