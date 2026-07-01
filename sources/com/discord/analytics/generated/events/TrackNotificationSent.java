package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackNotificationSent.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNotificationSent implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence notifType = null;
    private final Long notifUserId = null;
    private final Long relType = null;
    private final Boolean hasApnsToken = null;
    private final Boolean hasGcmToken = null;
    private final transient String analyticsSchemaTypeName = "notification_sent";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNotificationSent)) {
            return false;
        }
        TrackNotificationSent trackNotificationSent = (TrackNotificationSent) other;
        return m.areEqual(this.notifType, trackNotificationSent.notifType) && m.areEqual(this.notifUserId, trackNotificationSent.notifUserId) && m.areEqual(this.relType, trackNotificationSent.relType) && m.areEqual(this.hasApnsToken, trackNotificationSent.hasApnsToken) && m.areEqual(this.hasGcmToken, trackNotificationSent.hasGcmToken);
    }

    public int hashCode() {
        CharSequence charSequence = this.notifType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.notifUserId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.relType;
        int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Boolean bool = this.hasApnsToken;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.hasGcmToken;
        return iHashCode4 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackNotificationSent(notifType=");
        sbU.append(this.notifType);
        sbU.append(", notifUserId=");
        sbU.append(this.notifUserId);
        sbU.append(", relType=");
        sbU.append(this.relType);
        sbU.append(", hasApnsToken=");
        sbU.append(this.hasApnsToken);
        sbU.append(", hasGcmToken=");
        return a.D(sbU, this.hasGcmToken, ")");
    }
}
