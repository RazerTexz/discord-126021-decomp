package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata;
import com.discord.analytics.generated.traits.TrackOverlayClientMetadata2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackNotificationClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNotificationClicked implements AnalyticsSchema, TrackBase2, TrackOverlayClientMetadata2 {
    private TrackBase trackBase;
    private TrackOverlayClientMetadata trackOverlayClientMetadata;
    private final Boolean notifInApp = null;
    private final CharSequence notifType = null;
    private final Long notifUserId = null;
    private final Long messageId = null;
    private final Long messageType = null;
    private final Boolean hasMessage = null;
    private final Long guildId = null;
    private final Long channelId = null;
    private final Long channelType = null;
    private final Long relType = null;
    private final CharSequence platformType = null;
    private final Long activityType = null;
    private final CharSequence activityName = null;
    private final CharSequence actionType = null;
    private final Long pushDataSize = null;
    private final Long messageDataSize = null;
    private final transient String analyticsSchemaTypeName = "notification_clicked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNotificationClicked)) {
            return false;
        }
        TrackNotificationClicked trackNotificationClicked = (TrackNotificationClicked) other;
        return Intrinsics3.areEqual(this.notifInApp, trackNotificationClicked.notifInApp) && Intrinsics3.areEqual(this.notifType, trackNotificationClicked.notifType) && Intrinsics3.areEqual(this.notifUserId, trackNotificationClicked.notifUserId) && Intrinsics3.areEqual(this.messageId, trackNotificationClicked.messageId) && Intrinsics3.areEqual(this.messageType, trackNotificationClicked.messageType) && Intrinsics3.areEqual(this.hasMessage, trackNotificationClicked.hasMessage) && Intrinsics3.areEqual(this.guildId, trackNotificationClicked.guildId) && Intrinsics3.areEqual(this.channelId, trackNotificationClicked.channelId) && Intrinsics3.areEqual(this.channelType, trackNotificationClicked.channelType) && Intrinsics3.areEqual(this.relType, trackNotificationClicked.relType) && Intrinsics3.areEqual(this.platformType, trackNotificationClicked.platformType) && Intrinsics3.areEqual(this.activityType, trackNotificationClicked.activityType) && Intrinsics3.areEqual(this.activityName, trackNotificationClicked.activityName) && Intrinsics3.areEqual(this.actionType, trackNotificationClicked.actionType) && Intrinsics3.areEqual(this.pushDataSize, trackNotificationClicked.pushDataSize) && Intrinsics3.areEqual(this.messageDataSize, trackNotificationClicked.messageDataSize);
    }

    public int hashCode() {
        Boolean bool = this.notifInApp;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        CharSequence charSequence = this.notifType;
        int iHashCode2 = (iHashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Long l = this.notifUserId;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.messageId;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.messageType;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Boolean bool2 = this.hasMessage;
        int iHashCode6 = (iHashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Long l4 = this.guildId;
        int iHashCode7 = (iHashCode6 + (l4 != null ? l4.hashCode() : 0)) * 31;
        Long l5 = this.channelId;
        int iHashCode8 = (iHashCode7 + (l5 != null ? l5.hashCode() : 0)) * 31;
        Long l6 = this.channelType;
        int iHashCode9 = (iHashCode8 + (l6 != null ? l6.hashCode() : 0)) * 31;
        Long l7 = this.relType;
        int iHashCode10 = (iHashCode9 + (l7 != null ? l7.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.platformType;
        int iHashCode11 = (iHashCode10 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l8 = this.activityType;
        int iHashCode12 = (iHashCode11 + (l8 != null ? l8.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.activityName;
        int iHashCode13 = (iHashCode12 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.actionType;
        int iHashCode14 = (iHashCode13 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l9 = this.pushDataSize;
        int iHashCode15 = (iHashCode14 + (l9 != null ? l9.hashCode() : 0)) * 31;
        Long l10 = this.messageDataSize;
        return iHashCode15 + (l10 != null ? l10.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackNotificationClicked(notifInApp=");
        sbU.append(this.notifInApp);
        sbU.append(", notifType=");
        sbU.append(this.notifType);
        sbU.append(", notifUserId=");
        sbU.append(this.notifUserId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", messageType=");
        sbU.append(this.messageType);
        sbU.append(", hasMessage=");
        sbU.append(this.hasMessage);
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
        sbU.append(this.activityName);
        sbU.append(", actionType=");
        sbU.append(this.actionType);
        sbU.append(", pushDataSize=");
        sbU.append(this.pushDataSize);
        sbU.append(", messageDataSize=");
        return outline.G(sbU, this.messageDataSize, ")");
    }
}
