package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackWebhookDeleted.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackWebhookDeleted implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long webhookId = null;
    private final CharSequence webhookName = null;
    private final Long type = null;
    private final Long channelId = null;
    private final Long channelType = null;
    private final Long guildId = null;
    private final Long webhookSourceChannelId = null;
    private final Long webhookSourceGuildId = null;
    private final Long webhookSourceChannelType = null;
    private final transient String analyticsSchemaTypeName = "webhook_deleted";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackWebhookDeleted)) {
            return false;
        }
        TrackWebhookDeleted trackWebhookDeleted = (TrackWebhookDeleted) other;
        return Intrinsics3.areEqual(this.webhookId, trackWebhookDeleted.webhookId) && Intrinsics3.areEqual(this.webhookName, trackWebhookDeleted.webhookName) && Intrinsics3.areEqual(this.type, trackWebhookDeleted.type) && Intrinsics3.areEqual(this.channelId, trackWebhookDeleted.channelId) && Intrinsics3.areEqual(this.channelType, trackWebhookDeleted.channelType) && Intrinsics3.areEqual(this.guildId, trackWebhookDeleted.guildId) && Intrinsics3.areEqual(this.webhookSourceChannelId, trackWebhookDeleted.webhookSourceChannelId) && Intrinsics3.areEqual(this.webhookSourceGuildId, trackWebhookDeleted.webhookSourceGuildId) && Intrinsics3.areEqual(this.webhookSourceChannelType, trackWebhookDeleted.webhookSourceChannelType);
    }

    public int hashCode() {
        Long l = this.webhookId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.webhookName;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l2 = this.type;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.channelId;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.channelType;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.guildId;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.webhookSourceChannelId;
        int iHashCode7 = (iHashCode6 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.webhookSourceGuildId;
        int iHashCode8 = (iHashCode7 + (l7 != null ? l7.hashCode() : 0)) * 31;
        Long l8 = this.webhookSourceChannelType;
        return iHashCode8 + (l8 != null ? l8.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackWebhookDeleted(webhookId=");
        sbU.append(this.webhookId);
        sbU.append(", webhookName=");
        sbU.append(this.webhookName);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", webhookSourceChannelId=");
        sbU.append(this.webhookSourceChannelId);
        sbU.append(", webhookSourceGuildId=");
        sbU.append(this.webhookSourceGuildId);
        sbU.append(", webhookSourceChannelType=");
        return outline.G(sbU, this.webhookSourceChannelType, ")");
    }
}
