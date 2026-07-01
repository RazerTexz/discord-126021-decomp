package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackNotificationDeviceTokenUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNotificationDeviceTokenUpdate implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence provider = null;
    private final CharSequence token = null;
    private final CharSequence type = null;
    private final CharSequence pushToken = null;
    private final transient String analyticsSchemaTypeName = "notification_device_token_update";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNotificationDeviceTokenUpdate)) {
            return false;
        }
        TrackNotificationDeviceTokenUpdate trackNotificationDeviceTokenUpdate = (TrackNotificationDeviceTokenUpdate) other;
        return m.areEqual(this.provider, trackNotificationDeviceTokenUpdate.provider) && m.areEqual(this.token, trackNotificationDeviceTokenUpdate.token) && m.areEqual(this.type, trackNotificationDeviceTokenUpdate.type) && m.areEqual(this.pushToken, trackNotificationDeviceTokenUpdate.pushToken);
    }

    public int hashCode() {
        CharSequence charSequence = this.provider;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.token;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.type;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.pushToken;
        return iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackNotificationDeviceTokenUpdate(provider=");
        sbU.append(this.provider);
        sbU.append(", token=");
        sbU.append(this.token);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", pushToken=");
        return a.E(sbU, this.pushToken, ")");
    }
}
