package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackLocalSettingsUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackLocalSettingsUpdated implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Boolean notificationsEnabled = null;
    private final Boolean notificationsInAppEnabled = null;
    private final Boolean colorblindEnabled = null;
    private final Float saturationLevel = null;
    private final Boolean gameDetectionEnabled = null;
    private final Boolean nativePhoneIntegrationEnabled = null;
    private final Boolean autoStreaming = null;
    private final transient String analyticsSchemaTypeName = "local_settings_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackLocalSettingsUpdated)) {
            return false;
        }
        TrackLocalSettingsUpdated trackLocalSettingsUpdated = (TrackLocalSettingsUpdated) other;
        return m.areEqual(this.notificationsEnabled, trackLocalSettingsUpdated.notificationsEnabled) && m.areEqual(this.notificationsInAppEnabled, trackLocalSettingsUpdated.notificationsInAppEnabled) && m.areEqual(this.colorblindEnabled, trackLocalSettingsUpdated.colorblindEnabled) && m.areEqual(this.saturationLevel, trackLocalSettingsUpdated.saturationLevel) && m.areEqual(this.gameDetectionEnabled, trackLocalSettingsUpdated.gameDetectionEnabled) && m.areEqual(this.nativePhoneIntegrationEnabled, trackLocalSettingsUpdated.nativePhoneIntegrationEnabled) && m.areEqual(this.autoStreaming, trackLocalSettingsUpdated.autoStreaming);
    }

    public int hashCode() {
        Boolean bool = this.notificationsEnabled;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.notificationsInAppEnabled;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.colorblindEnabled;
        int iHashCode3 = (iHashCode2 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Float f = this.saturationLevel;
        int iHashCode4 = (iHashCode3 + (f != null ? f.hashCode() : 0)) * 31;
        Boolean bool4 = this.gameDetectionEnabled;
        int iHashCode5 = (iHashCode4 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Boolean bool5 = this.nativePhoneIntegrationEnabled;
        int iHashCode6 = (iHashCode5 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.autoStreaming;
        return iHashCode6 + (bool6 != null ? bool6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackLocalSettingsUpdated(notificationsEnabled=");
        sbU.append(this.notificationsEnabled);
        sbU.append(", notificationsInAppEnabled=");
        sbU.append(this.notificationsInAppEnabled);
        sbU.append(", colorblindEnabled=");
        sbU.append(this.colorblindEnabled);
        sbU.append(", saturationLevel=");
        sbU.append(this.saturationLevel);
        sbU.append(", gameDetectionEnabled=");
        sbU.append(this.gameDetectionEnabled);
        sbU.append(", nativePhoneIntegrationEnabled=");
        sbU.append(this.nativePhoneIntegrationEnabled);
        sbU.append(", autoStreaming=");
        return a.D(sbU, this.autoStreaming, ")");
    }
}
