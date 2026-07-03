package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.desktop, trackGameNotificationSettingsUpdated.desktop) && C12238m.areEqual(this.mobile, trackGameNotificationSettingsUpdated.mobile) && C12238m.areEqual(this.peakHours, trackGameNotificationSettingsUpdated.peakHours) && C12238m.areEqual(this.autoFollow, trackGameNotificationSettingsUpdated.autoFollow);
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
        StringBuilder sbM833U = C1643a.m833U("TrackGameNotificationSettingsUpdated(desktop=");
        sbM833U.append(this.desktop);
        sbM833U.append(", mobile=");
        sbM833U.append(this.mobile);
        sbM833U.append(", peakHours=");
        sbM833U.append(this.peakHours);
        sbM833U.append(", autoFollow=");
        return C1643a.m816D(sbM833U, this.autoFollow, ")");
    }
}
