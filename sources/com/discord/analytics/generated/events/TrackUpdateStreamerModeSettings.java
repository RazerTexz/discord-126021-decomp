package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* JADX INFO: compiled from: TrackUpdateStreamerModeSettings.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackUpdateStreamerModeSettings implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final Boolean automatic = null;
    private final Boolean disableNotifications = null;
    private final Boolean disableSounds = null;
    private final Boolean enabled = null;
    private final Boolean hideInstantInvites = null;
    private final Boolean hidePersonalInfo = null;
    private final transient String analyticsSchemaTypeName = "update_streamer_mode_settings";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUpdateStreamerModeSettings)) {
            return false;
        }
        TrackUpdateStreamerModeSettings trackUpdateStreamerModeSettings = (TrackUpdateStreamerModeSettings) other;
        return m.areEqual(this.automatic, trackUpdateStreamerModeSettings.automatic) && m.areEqual(this.disableNotifications, trackUpdateStreamerModeSettings.disableNotifications) && m.areEqual(this.disableSounds, trackUpdateStreamerModeSettings.disableSounds) && m.areEqual(this.enabled, trackUpdateStreamerModeSettings.enabled) && m.areEqual(this.hideInstantInvites, trackUpdateStreamerModeSettings.hideInstantInvites) && m.areEqual(this.hidePersonalInfo, trackUpdateStreamerModeSettings.hidePersonalInfo);
    }

    public int hashCode() {
        Boolean bool = this.automatic;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.disableNotifications;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.disableSounds;
        int iHashCode3 = (iHashCode2 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.enabled;
        int iHashCode4 = (iHashCode3 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Boolean bool5 = this.hideInstantInvites;
        int iHashCode5 = (iHashCode4 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.hidePersonalInfo;
        return iHashCode5 + (bool6 != null ? bool6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("TrackUpdateStreamerModeSettings(automatic=");
        sbU.append(this.automatic);
        sbU.append(", disableNotifications=");
        sbU.append(this.disableNotifications);
        sbU.append(", disableSounds=");
        sbU.append(this.disableSounds);
        sbU.append(", enabled=");
        sbU.append(this.enabled);
        sbU.append(", hideInstantInvites=");
        sbU.append(this.hideInstantInvites);
        sbU.append(", hidePersonalInfo=");
        return a.D(sbU, this.hidePersonalInfo, ")");
    }
}
