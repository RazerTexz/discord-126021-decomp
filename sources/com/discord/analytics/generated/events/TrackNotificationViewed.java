package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadataReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TrackNotificationViewed.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNotificationViewed implements AnalyticsSchema, TrackBaseReceiver, TrackOverlayClientMetadataReceiver {
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
        return C12238m.areEqual(this.notifType, trackNotificationViewed.notifType) && C12238m.areEqual(this.notifUserId, trackNotificationViewed.notifUserId) && C12238m.areEqual(this.messageId, trackNotificationViewed.messageId) && C12238m.areEqual(this.messageType, trackNotificationViewed.messageType) && C12238m.areEqual(this.guildId, trackNotificationViewed.guildId) && C12238m.areEqual(this.channelId, trackNotificationViewed.channelId) && C12238m.areEqual(this.channelType, trackNotificationViewed.channelType) && C12238m.areEqual(this.relType, trackNotificationViewed.relType) && C12238m.areEqual(this.platformType, trackNotificationViewed.platformType) && C12238m.areEqual(this.activityType, trackNotificationViewed.activityType) && C12238m.areEqual(this.activityName, trackNotificationViewed.activityName);
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
        StringBuilder sbM833U = C1643a.m833U("TrackNotificationViewed(notifType=");
        sbM833U.append(this.notifType);
        sbM833U.append(", notifUserId=");
        sbM833U.append(this.notifUserId);
        sbM833U.append(", messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", messageType=");
        sbM833U.append(this.messageType);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", channelType=");
        sbM833U.append(this.channelType);
        sbM833U.append(", relType=");
        sbM833U.append(this.relType);
        sbM833U.append(", platformType=");
        sbM833U.append(this.platformType);
        sbM833U.append(", activityType=");
        sbM833U.append(this.activityType);
        sbM833U.append(", activityName=");
        return C1643a.m817E(sbM833U, this.activityName, ")");
    }
}
