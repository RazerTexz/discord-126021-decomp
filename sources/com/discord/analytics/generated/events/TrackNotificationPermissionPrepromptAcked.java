package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackNotificationPermissionPrepromptAcked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNotificationPermissionPrepromptAcked implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence actionType = null;
    private final CharSequence actionLocation = null;
    private final Boolean permissionGranted = null;
    private final transient String analyticsSchemaTypeName = "notification_permission_preprompt_acked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNotificationPermissionPrepromptAcked)) {
            return false;
        }
        TrackNotificationPermissionPrepromptAcked trackNotificationPermissionPrepromptAcked = (TrackNotificationPermissionPrepromptAcked) other;
        return Intrinsics3.areEqual(this.actionType, trackNotificationPermissionPrepromptAcked.actionType) && Intrinsics3.areEqual(this.actionLocation, trackNotificationPermissionPrepromptAcked.actionLocation) && Intrinsics3.areEqual(this.permissionGranted, trackNotificationPermissionPrepromptAcked.permissionGranted);
    }

    public int hashCode() {
        CharSequence charSequence = this.actionType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.actionLocation;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Boolean bool = this.permissionGranted;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackNotificationPermissionPrepromptAcked(actionType=");
        sbU.append(this.actionType);
        sbU.append(", actionLocation=");
        sbU.append(this.actionLocation);
        sbU.append(", permissionGranted=");
        return outline.D(sbU, this.permissionGranted, ")");
    }
}
