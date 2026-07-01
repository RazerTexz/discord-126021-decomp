package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: TrackNotificationSettingsClicked.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackNotificationSettingsClicked implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence settingType = null;
    private final Long currentStatus = null;
    private final transient String analyticsSchemaTypeName = "notification_settings_clicked";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackNotificationSettingsClicked)) {
            return false;
        }
        TrackNotificationSettingsClicked trackNotificationSettingsClicked = (TrackNotificationSettingsClicked) other;
        return Intrinsics3.areEqual(this.settingType, trackNotificationSettingsClicked.settingType) && Intrinsics3.areEqual(this.currentStatus, trackNotificationSettingsClicked.currentStatus);
    }

    public int hashCode() {
        CharSequence charSequence = this.settingType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.currentStatus;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackNotificationSettingsClicked(settingType=");
        sbU.append(this.settingType);
        sbU.append(", currentStatus=");
        return outline.G(sbU, this.currentStatus, ")");
    }
}
