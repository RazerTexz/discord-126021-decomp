package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackGameNotificationSettingsUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackGameNotificationSettingsUpdated implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Boolean desktop = null;
    private final Boolean mobile = null;
    private final Boolean peakHours = null;
    private final Boolean autoFollow = null;
    private final transient String analyticsSchemaTypeName = "game_notification_settings_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackGameNotificationSettingsUpdated)) {
            return false;
        }
        TrackGameNotificationSettingsUpdated trackGameNotificationSettingsUpdated = (TrackGameNotificationSettingsUpdated) other;
        return m.areEqual(this.desktop, trackGameNotificationSettingsUpdated.desktop) && m.areEqual(this.mobile, trackGameNotificationSettingsUpdated.mobile) && m.areEqual(this.peakHours, trackGameNotificationSettingsUpdated.peakHours) && m.areEqual(this.autoFollow, trackGameNotificationSettingsUpdated.autoFollow);
    }

    public int hashCode() {
        Boolean bool = this.desktop;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.mobile;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.peakHours;
        int iHashCode3 = (iHashCode2 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.autoFollow;
        return iHashCode3 + (bool4 != null ? bool4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackGameNotificationSettingsUpdated(desktop=");
        sbU.append(this.desktop);
        sbU.append(", mobile=");
        sbU.append(this.mobile);
        sbU.append(", peakHours=");
        sbU.append(this.peakHours);
        sbU.append(", autoFollow=");
        return a.D(sbU, this.autoFollow, ")");
    }
}
