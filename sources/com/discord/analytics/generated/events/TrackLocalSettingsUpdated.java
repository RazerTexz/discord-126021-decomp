package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
        return C12238m.areEqual(this.notificationsEnabled, trackLocalSettingsUpdated.notificationsEnabled) && C12238m.areEqual(this.notificationsInAppEnabled, trackLocalSettingsUpdated.notificationsInAppEnabled) && C12238m.areEqual(this.colorblindEnabled, trackLocalSettingsUpdated.colorblindEnabled) && C12238m.areEqual(this.saturationLevel, trackLocalSettingsUpdated.saturationLevel) && C12238m.areEqual(this.gameDetectionEnabled, trackLocalSettingsUpdated.gameDetectionEnabled) && C12238m.areEqual(this.nativePhoneIntegrationEnabled, trackLocalSettingsUpdated.nativePhoneIntegrationEnabled) && C12238m.areEqual(this.autoStreaming, trackLocalSettingsUpdated.autoStreaming);
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
        StringBuilder sbM833U = C1643a.m833U("TrackLocalSettingsUpdated(notificationsEnabled=");
        sbM833U.append(this.notificationsEnabled);
        sbM833U.append(", notificationsInAppEnabled=");
        sbM833U.append(this.notificationsInAppEnabled);
        sbM833U.append(", colorblindEnabled=");
        sbM833U.append(this.colorblindEnabled);
        sbM833U.append(", saturationLevel=");
        sbM833U.append(this.saturationLevel);
        sbM833U.append(", gameDetectionEnabled=");
        sbM833U.append(this.gameDetectionEnabled);
        sbM833U.append(", nativePhoneIntegrationEnabled=");
        sbM833U.append(this.nativePhoneIntegrationEnabled);
        sbM833U.append(", autoStreaming=");
        return C1643a.m816D(sbM833U, this.autoStreaming, ")");
    }
}
