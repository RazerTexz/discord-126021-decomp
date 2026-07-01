package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackNotificationViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNotificationViewed implements AnalyticsSchema, TrackBase2, TrackOverlayClientMetadata2 {
    private TrackBase trackBase;
    private TrackOverlayClientMetadata trackOverlayClientMetadata;
    private final CharSequence notifType = null;
    private final Long notifUserId = null;
    private final Long messageId = null;
    private final Long messageType = null;
    private final Long guildId = null;
    private final Long channelId = null;
    private final Long channelType = null;
    private final Long relType = null;
    private final CharSequence platformType = null;
    private final Long activityType = null;
    private final CharSequence activityName = null;
    private final transient String analyticsSchemaTypeName = "notification_viewed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNotificationViewed)) {
            return false;
        }
        TrackNotificationViewed trackNotificationViewed = (TrackNotificationViewed) other;
        return Intrinsics3.areEqual(this.notifType, trackNotificationViewed.notifType) && Intrinsics3.areEqual(this.notifUserId, trackNotificationViewed.notifUserId) && Intrinsics3.areEqual(this.messageId, trackNotificationViewed.messageId) && Intrinsics3.areEqual(this.messageType, trackNotificationViewed.messageType) && Intrinsics3.areEqual(this.guildId, trackNotificationViewed.guildId) && Intrinsics3.areEqual(this.channelId, trackNotificationViewed.channelId) && Intrinsics3.areEqual(this.channelType, trackNotificationViewed.channelType) && Intrinsics3.areEqual(this.relType, trackNotificationViewed.relType) && Intrinsics3.areEqual(this.platformType, trackNotificationViewed.platformType) && Intrinsics3.areEqual(this.activityType, trackNotificationViewed.activityType) && Intrinsics3.areEqual(this.activityName, trackNotificationViewed.activityName);
    }

    public int hashCode() {
        CharSequence charSequence = this.notifType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.notifUserId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.messageId;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.messageType;
        int iHashCode4 = (iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.guildId;
        int iHashCode5 = (iHashCode4 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.channelId;
        int iHashCode6 = (iHashCode5 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.channelType;
        int iHashCode7 = (iHashCode6 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.relType;
        int iHashCode8 = (iHashCode7 + (l7 != null ? l7.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.platformType;
        int iHashCode9 = (iHashCode8 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l8 = this.activityType;
        int iHashCode10 = (iHashCode9 + (l8 != null ? l8.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.activityName;
        return iHashCode10 + (charSequence3 != null ? charSequence3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackNotificationViewed(notifType=");
        sbU.append(this.notifType);
        sbU.append(", notifUserId=");
        sbU.append(this.notifUserId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", messageType=");
        sbU.append(this.messageType);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", relType=");
        sbU.append(this.relType);
        sbU.append(", platformType=");
        sbU.append(this.platformType);
        sbU.append(", activityType=");
        sbU.append(this.activityType);
        sbU.append(", activityName=");
        return outline.E(sbU, this.activityName, ")");
    }
}
