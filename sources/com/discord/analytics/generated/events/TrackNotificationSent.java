package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.notifType, trackNotificationSent.notifType) && C12238m.areEqual(this.notifUserId, trackNotificationSent.notifUserId) && C12238m.areEqual(this.relType, trackNotificationSent.relType) && C12238m.areEqual(this.hasApnsToken, trackNotificationSent.hasApnsToken) && C12238m.areEqual(this.hasGcmToken, trackNotificationSent.hasGcmToken);
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
        StringBuilder sbM833U = C1643a.m833U("TrackNotificationSent(notifType=");
        sbM833U.append(this.notifType);
        sbM833U.append(", notifUserId=");
        sbM833U.append(this.notifUserId);
        sbM833U.append(", relType=");
        sbM833U.append(this.relType);
        sbM833U.append(", hasApnsToken=");
        sbM833U.append(this.hasApnsToken);
        sbM833U.append(", hasGcmToken=");
        return C1643a.m816D(sbM833U, this.hasGcmToken, ")");
    }
}
