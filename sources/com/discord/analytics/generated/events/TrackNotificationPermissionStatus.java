package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackNotificationPermissionStatus.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNotificationPermissionStatus implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Boolean osEnabled = null;
    private final Boolean foregroundAppEnabled = null;
    private final Boolean backgroundAppEnabled = null;
    private final transient String analyticsSchemaTypeName = "notification_permission_status";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNotificationPermissionStatus)) {
            return false;
        }
        TrackNotificationPermissionStatus trackNotificationPermissionStatus = (TrackNotificationPermissionStatus) other;
        return m.areEqual(this.osEnabled, trackNotificationPermissionStatus.osEnabled) && m.areEqual(this.foregroundAppEnabled, trackNotificationPermissionStatus.foregroundAppEnabled) && m.areEqual(this.backgroundAppEnabled, trackNotificationPermissionStatus.backgroundAppEnabled);
    }

    public int hashCode() {
        Boolean bool = this.osEnabled;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.foregroundAppEnabled;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.backgroundAppEnabled;
        return iHashCode2 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackNotificationPermissionStatus(osEnabled=");
        sbU.append(this.osEnabled);
        sbU.append(", foregroundAppEnabled=");
        sbU.append(this.foregroundAppEnabled);
        sbU.append(", backgroundAppEnabled=");
        return a.D(sbU, this.backgroundAppEnabled, ")");
    }
}
